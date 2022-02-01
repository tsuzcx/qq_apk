package com.tencent.mm.pluginsdk.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.protocal.protobuf.je;
import com.tencent.mm.protocal.protobuf.wi;
import com.tencent.mm.protocal.protobuf.wj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.vfs.i;
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
  private final a EOj;
  private com.tencent.mm.al.f callback;
  private b rr;
  
  public a(List<b> paramList, a parama)
  {
    AppMethodBeat.i(195378);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new jd();
    ((b.a)localObject).hNN = new je();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchcheckbigfileupload";
    ((b.a)localObject).funcId = 3939;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (jd)this.rr.hNK.hNQ;
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      wi localwi = new wi();
      String str1 = localb.filePath;
      String str2 = localb.toUser;
      if ((!bt.isNullOrNil(localb.gjI)) && (!bt.isNullOrNil(localb.nUg)))
      {
        localwi.FOH = localb.gjI;
        localwi.FVF = localb.nUg;
        localwi.FVG = localb.fileName;
        localwi.FAa = localb.fVf;
      }
      for (localwi.FzZ = localb.fileSize;; localwi.FzZ = ((int)i.aYo(str1)))
      {
        localwi.Fyv = com.tencent.mm.i.a.fIy;
        localwi.uki = str2;
        localwi.ukj = u.aAm();
        ad.i("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig NetSceneBatchCheckBigFileUpload, aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", new Object[] { localwi.FOH, localwi.FVF, localwi.FVG, Long.valueOf(localwi.FzZ), localwi.FAa, localwi.uki, localwi.ukj, bt.flS() });
        ((jd)localObject).nDj.add(localwi);
        break;
        com.tencent.mm.ao.f.aGJ();
        localwi.FOH = com.tencent.mm.ao.a.aGz();
        com.tencent.mm.ao.f.aGJ();
        localwi.FVF = com.tencent.mm.ao.a.EJ(str1);
        localwi.FVG = i.aYt(str1);
        localwi.FAa = i.ZF(str1);
      }
    }
    ((jd)localObject).nDi = ((jd)localObject).nDj.size();
    this.EOj = parama;
    AppMethodBeat.o(195378);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(195379);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(195379);
    return i;
  }
  
  public final int getType()
  {
    return 3939;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(195380);
    ad.d("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig onGYNetEnd errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.EOj != null)
      {
        paramq = paramString;
        if (bt.isNullOrNil(paramString)) {
          paramq = aj.getContext().getString(2131766914);
        }
        paramString = this.EOj;
        if (paramInt3 == 0) {
          break label145;
        }
      }
      for (;;)
      {
        paramString.bE(paramInt3, paramq);
        AppMethodBeat.o(195380);
        return;
        label145:
        paramInt3 = -1001;
      }
    }
    paramArrayOfByte = (jd)((b)paramq).hNK.hNQ;
    paramq = (je)((b)paramq).hNL.hNQ;
    paramInt1 = paramq.getBaseResponse().Ret;
    if (paramInt1 != 0)
    {
      paramString = paramq.getBaseResponse().ErrMsg.toString();
      ad.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig outer resp.getBaseResponse().Ret: " + paramInt1 + ", errMsg:" + paramString);
      this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
      if (this.EOj != null) {
        this.EOj.bE(paramInt1, paramString);
      }
      AppMethodBeat.o(195380);
      return;
    }
    if ((paramArrayOfByte.nDi != paramq.nDi) || (paramArrayOfByte.nDj.size() != paramq.nDj.size()) || (paramq.nDi != paramq.nDj.size()))
    {
      ad.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig  req.count: " + paramArrayOfByte.nDi + " not equals resp.Count:" + paramq.nDi + ", resp.List.size() = " + paramq.nDj.size());
      this.callback.onSceneEnd(paramInt2, -1000, "req-count mismatch resp-count", this);
      if (this.EOj != null) {
        this.EOj.bE(-1000, aj.getContext().getString(2131766912));
      }
      AppMethodBeat.o(195380);
      return;
    }
    Object localObject = paramq.nDj.iterator();
    while (((Iterator)localObject).hasNext())
    {
      wj localwj = (wj)((Iterator)localObject).next();
      paramInt1 = localwj.getBaseResponse().Ret;
      String str = localwj.getBaseResponse().ErrMsg.toString();
      if (paramInt1 != 0)
      {
        ad.e("MicroMsg.NetSceneBatchCheckBigFileUpload", "summerbig inner resp.getBaseResponse().Ret: " + localwj + ", errMsg:" + str);
        paramString = bw.M(str, "e");
        if (paramString == null) {}
        for (paramString = aj.getContext().getString(2131766913);; paramString = (String)paramString.get(".e.Content"))
        {
          this.callback.onSceneEnd(paramInt2, paramInt1, paramString, this);
          if (this.EOj != null) {
            this.EOj.bE(paramInt1, paramString);
          }
          AppMethodBeat.o(195380);
          return;
        }
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if (this.EOj != null)
    {
      paramString = Collections.synchronizedList(new ArrayList());
      paramInt1 = 0;
      while (paramInt1 < paramq.nDi)
      {
        localObject = new c();
        ((c)localObject).nUg = ((wi)paramArrayOfByte.nDj.get(paramInt1)).FVF;
        ((c)localObject).totalLen = ((wi)paramArrayOfByte.nDj.get(paramInt1)).FzZ;
        ((c)localObject).gjI = ((wi)paramArrayOfByte.nDj.get(paramInt1)).FOH;
        ((c)localObject).signature = ((wj)paramq.nDj.get(paramInt1)).jdf;
        ((c)localObject).EOk = ((wj)paramq.nDj.get(paramInt1)).FVI;
        ((c)localObject).EOl = ((wj)paramq.nDj.get(paramInt1)).FVJ;
        ad.d("MicroMsg.NetSceneBatchCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", new Object[] { ((c)localObject).signature, Integer.valueOf(((wj)paramq.nDj.get(paramInt1)).FVH), ((c)localObject).EOk, ((c)localObject).EOl });
        paramString.add(localObject);
        paramInt1 += 1;
      }
      this.EOj.bE(0, "");
    }
    AppMethodBeat.o(195380);
  }
  
  public static abstract interface a
  {
    public abstract void bE(int paramInt, String paramString);
  }
  
  public static final class b
  {
    public String fVf;
    public String fileName;
    public String filePath;
    public long fileSize;
    public String gjI;
    public String nUg;
    public String toUser;
  }
  
  public final class c
  {
    public String EOk;
    public String EOl;
    public String gjI;
    public String nUg;
    public String signature;
    public long totalLen;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a
 * JD-Core Version:    0.7.0.1
 */