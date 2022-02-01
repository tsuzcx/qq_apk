package com.tencent.mm.pluginsdk.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
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
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.protocal.protobuf.wm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.vfs.o;
import java.util.Map;

public final class c
  extends n
  implements k
{
  private final a FgK;
  private com.tencent.mm.ak.f callback;
  private b rr;
  
  public c(k.b paramb, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(218837);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new wl();
    ((b.a)localObject).hQG = new wm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
    ((b.a)localObject).funcId = 727;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (wl)this.rr.hQD.hQJ;
    if ((paramb != null) && (!bu.isNullOrNil(paramb.gmb)) && (!bu.isNullOrNil(paramb.filemd5)))
    {
      ((wl)localObject).Ghg = paramb.gmb;
      ((wl)localObject).Goe = paramb.filemd5;
      ((wl)localObject).Gof = paramb.title;
      ((wl)localObject).FSy = paramb.hCD;
    }
    for (((wl)localObject).FSx = paramb.hCC;; ((wl)localObject).FSx = ((int)o.aZR(paramString1)))
    {
      ((wl)localObject).FQT = com.tencent.mm.i.a.fKC;
      ((wl)localObject).uvF = paramString2;
      ((wl)localObject).uvG = v.aAC();
      this.FgK = parama;
      ae.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", new Object[] { paramb, ((wl)localObject).Ghg, ((wl)localObject).Goe, ((wl)localObject).Gof, Long.valueOf(((wl)localObject).FSx), ((wl)localObject).FSy, ((wl)localObject).uvF, ((wl)localObject).uvG, bu.fpN() });
      AppMethodBeat.o(218837);
      return;
      com.tencent.mm.an.f.aHa();
      ((wl)localObject).Ghg = com.tencent.mm.an.a.aGP();
      com.tencent.mm.an.f.aHa();
      ((wl)localObject).Goe = com.tencent.mm.an.a.Fl(paramString1);
      ((wl)localObject).Gof = o.aZW(paramString1);
      ((wl)localObject).FSy = o.aaw(paramString1);
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(218838);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(218838);
    return i;
  }
  
  public final int getType()
  {
    return 727;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218839);
    ae.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.FgK != null)
      {
        paramq = ak.getContext().getString(2131766914);
        if (!bu.isNullOrNil(paramString))
        {
          paramString = bx.M(paramString, "e");
          if (paramString != null) {
            break label171;
          }
        }
      }
      label171:
      for (paramq = ak.getContext().getString(2131766913);; paramq = (String)paramString.get(".e.Content"))
      {
        this.FgK.a(paramq, "", "", "", "", "", 0L);
        AppMethodBeat.o(218839);
        return;
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    paramArrayOfByte = (wl)((b)paramq).hQD.hQJ;
    paramq = (wm)((b)paramq).hQE.hQJ;
    ae.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", new Object[] { paramq.jfY, Integer.valueOf(paramq.Gog), paramq.Goh, paramq.Goi });
    if (this.FgK != null)
    {
      paramString = "";
      if (paramq.getBaseResponse().Ret != 0)
      {
        paramString = bx.M(paramq.getBaseResponse().ErrMsg.toString(), "e");
        if (paramString != null) {
          break label387;
        }
      }
    }
    label387:
    for (paramString = ak.getContext().getString(2131766913);; paramString = (String)paramString.get(".e.Content"))
    {
      this.FgK.a(paramString, paramArrayOfByte.Goe, paramArrayOfByte.Ghg, paramq.jfY, paramq.Goh, paramq.Goi, paramArrayOfByte.FSx);
      AppMethodBeat.o(218839);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.c
 * JD-Core Version:    0.7.0.1
 */