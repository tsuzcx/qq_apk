package com.tencent.mm.pluginsdk.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.protocal.protobuf.je;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.protocal.protobuf.wm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
  extends n
  implements k
{
  private final a FgF;
  private com.tencent.mm.ak.f callback;
  private b rr;
  
  public a(List<b> paramList, a parama)
  {
    AppMethodBeat.i(218831);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new jd();
    ((b.a)localObject).hQG = new je();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchcheckbigfileupload";
    ((b.a)localObject).funcId = 3939;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (jd)this.rr.hQD.hQJ;
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      wl localwl = new wl();
      String str1 = localb.filePath;
      String str2 = localb.toUser;
      if ((!bu.isNullOrNil(localb.gmb)) && (!bu.isNullOrNil(localb.nZM)))
      {
        localwl.Ghg = localb.gmb;
        localwl.Goe = localb.nZM;
        localwl.Gof = localb.fileName;
        localwl.FSy = localb.fXl;
      }
      for (localwl.FSx = localb.fileSize;; localwl.FSx = ((int)o.aZR(str1)))
      {
        localwl.FQT = com.tencent.mm.i.a.fKC;
        localwl.uvF = str2;
        localwl.uvG = v.aAC();
        ae.i("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig NetSceneBatchCheckBigFileUpload, aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", new Object[] { localwl.Ghg, localwl.Goe, localwl.Gof, Long.valueOf(localwl.FSx), localwl.FSy, localwl.uvF, localwl.uvG, bu.fpN() });
        ((jd)localObject).nIE.add(localwl);
        break;
        com.tencent.mm.an.f.aHa();
        localwl.Ghg = com.tencent.mm.an.a.aGP();
        com.tencent.mm.an.f.aHa();
        localwl.Goe = com.tencent.mm.an.a.Fl(str1);
        localwl.Gof = o.aZW(str1);
        localwl.FSy = o.aaw(str1);
      }
    }
    ((jd)localObject).nID = ((jd)localObject).nIE.size();
    this.FgF = parama;
    AppMethodBeat.o(218831);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(218832);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(218832);
    return i;
  }
  
  public final int getType()
  {
    return 3939;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218833);
    ae.d("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig onGYNetEnd errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.FgF != null)
      {
        paramq = paramString;
        if (bu.isNullOrNil(paramString)) {
          paramq = ak.getContext().getString(2131766914);
        }
        paramString = this.FgF;
        if (paramInt3 == 0) {
          break label145;
        }
      }
      for (;;)
      {
        paramString.bE(paramInt3, paramq);
        AppMethodBeat.o(218833);
        return;
        label145:
        paramInt3 = -1001;
      }
    }
    paramArrayOfByte = (jd)((b)paramq).hQD.hQJ;
    paramq = (je)((b)paramq).hQE.hQJ;
    paramInt1 = paramq.getBaseResponse().Ret;
    if (paramInt1 != 0)
    {
      paramString = paramq.getBaseResponse().ErrMsg.toString();
      ae.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig outer resp.getBaseResponse().Ret: " + paramInt1 + ", errMsg:" + paramString);
      this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
      if (this.FgF != null) {
        this.FgF.bE(paramInt1, paramString);
      }
      AppMethodBeat.o(218833);
      return;
    }
    if ((paramArrayOfByte.nID != paramq.nID) || (paramArrayOfByte.nIE.size() != paramq.nIE.size()) || (paramq.nID != paramq.nIE.size()))
    {
      ae.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig  req.count: " + paramArrayOfByte.nID + " not equals resp.Count:" + paramq.nID + ", resp.List.size() = " + paramq.nIE.size());
      this.callback.onSceneEnd(paramInt2, -1000, "req-count mismatch resp-count", this);
      if (this.FgF != null) {
        this.FgF.bE(-1000, ak.getContext().getString(2131766912));
      }
      AppMethodBeat.o(218833);
      return;
    }
    Object localObject = paramq.nIE.iterator();
    while (((Iterator)localObject).hasNext())
    {
      wm localwm = (wm)((Iterator)localObject).next();
      paramInt1 = localwm.getBaseResponse().Ret;
      String str = localwm.getBaseResponse().ErrMsg.toString();
      if (paramInt1 != 0)
      {
        ae.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig inner resp.getBaseResponse().Ret: " + localwm + ", errMsg:" + str);
        paramString = bx.M(str, "e");
        if (paramString == null) {}
        for (paramString = ak.getContext().getString(2131766913);; paramString = (String)paramString.get(".e.Content"))
        {
          this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
          if (this.FgF != null) {
            this.FgF.bE(paramInt1, paramString);
          }
          AppMethodBeat.o(218833);
          return;
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.FgF != null)
    {
      paramString = Collections.synchronizedList(new ArrayList());
      paramInt1 = 0;
      while (paramInt1 < paramq.nID)
      {
        localObject = new c();
        ((c)localObject).nZM = ((wl)paramArrayOfByte.nIE.get(paramInt1)).Goe;
        ((c)localObject).totalLen = ((wl)paramArrayOfByte.nIE.get(paramInt1)).FSx;
        ((c)localObject).gmb = ((wl)paramArrayOfByte.nIE.get(paramInt1)).Ghg;
        ((c)localObject).signature = ((wm)paramq.nIE.get(paramInt1)).jfY;
        ((c)localObject).FgG = ((wm)paramq.nIE.get(paramInt1)).Goh;
        ((c)localObject).FgH = ((wm)paramq.nIE.get(paramInt1)).Goi;
        ae.d("MicroMsg.NetSceneBatchCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", new Object[] { ((c)localObject).signature, Integer.valueOf(((wm)paramq.nIE.get(paramInt1)).Gog), ((c)localObject).FgG, ((c)localObject).FgH });
        paramString.add(localObject);
        paramInt1 += 1;
      }
      this.FgF.bE(0, "");
    }
    AppMethodBeat.o(218833);
  }
  
  public static abstract interface a
  {
    public abstract void bE(int paramInt, String paramString);
  }
  
  public static final class b
  {
    public String fXl;
    public String fileName;
    public String filePath;
    public long fileSize;
    public String gmb;
    public String nZM;
    public String toUser;
  }
  
  public final class c
  {
    public String FgG;
    public String FgH;
    public String gmb;
    public String nZM;
    public String signature;
    public long totalLen;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a
 * JD-Core Version:    0.7.0.1
 */