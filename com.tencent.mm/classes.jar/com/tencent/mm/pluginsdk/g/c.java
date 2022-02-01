package com.tencent.mm.pluginsdk.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
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
import com.tencent.mm.protocal.protobuf.wi;
import com.tencent.mm.protocal.protobuf.wj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.vfs.i;
import java.util.Map;

public final class c
  extends n
  implements k
{
  private final a EOo;
  private com.tencent.mm.al.f callback;
  private b rr;
  
  public c(k.b paramb, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(195384);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new wi();
    ((b.a)localObject).hNN = new wj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
    ((b.a)localObject).funcId = 727;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (wi)this.rr.hNK.hNQ;
    if ((paramb != null) && (!bt.isNullOrNil(paramb.gjI)) && (!bt.isNullOrNil(paramb.filemd5)))
    {
      ((wi)localObject).FOH = paramb.gjI;
      ((wi)localObject).FVF = paramb.filemd5;
      ((wi)localObject).FVG = paramb.title;
      ((wi)localObject).FAa = paramb.hzP;
    }
    for (((wi)localObject).FzZ = paramb.hzO;; ((wi)localObject).FzZ = ((int)i.aYo(paramString1)))
    {
      ((wi)localObject).Fyv = com.tencent.mm.i.a.fIy;
      ((wi)localObject).uki = paramString2;
      ((wi)localObject).ukj = u.aAm();
      this.EOo = parama;
      ad.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", new Object[] { paramb, ((wi)localObject).FOH, ((wi)localObject).FVF, ((wi)localObject).FVG, Long.valueOf(((wi)localObject).FzZ), ((wi)localObject).FAa, ((wi)localObject).uki, ((wi)localObject).ukj, bt.flS() });
      AppMethodBeat.o(195384);
      return;
      com.tencent.mm.ao.f.aGJ();
      ((wi)localObject).FOH = com.tencent.mm.ao.a.aGz();
      com.tencent.mm.ao.f.aGJ();
      ((wi)localObject).FVF = com.tencent.mm.ao.a.EJ(paramString1);
      ((wi)localObject).FVG = i.aYt(paramString1);
      ((wi)localObject).FAa = i.ZF(paramString1);
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(195385);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(195385);
    return i;
  }
  
  public final int getType()
  {
    return 727;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(195386);
    ad.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.EOo != null)
      {
        paramq = aj.getContext().getString(2131766914);
        if (!bt.isNullOrNil(paramString))
        {
          paramString = bw.M(paramString, "e");
          if (paramString != null) {
            break label171;
          }
        }
      }
      label171:
      for (paramq = aj.getContext().getString(2131766913);; paramq = (String)paramString.get(".e.Content"))
      {
        this.EOo.a(paramq, "", "", "", "", "", 0L);
        AppMethodBeat.o(195386);
        return;
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    paramArrayOfByte = (wi)((b)paramq).hNK.hNQ;
    paramq = (wj)((b)paramq).hNL.hNQ;
    ad.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", new Object[] { paramq.jdf, Integer.valueOf(paramq.FVH), paramq.FVI, paramq.FVJ });
    if (this.EOo != null)
    {
      paramString = "";
      if (paramq.getBaseResponse().Ret != 0)
      {
        paramString = bw.M(paramq.getBaseResponse().ErrMsg.toString(), "e");
        if (paramString != null) {
          break label387;
        }
      }
    }
    label387:
    for (paramString = aj.getContext().getString(2131766913);; paramString = (String)paramString.get(".e.Content"))
    {
      this.EOo.a(paramString, paramArrayOfByte.FVF, paramArrayOfByte.FOH, paramq.jdf, paramq.FVI, paramq.FVJ, paramArrayOfByte.FzZ);
      AppMethodBeat.o(195386);
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