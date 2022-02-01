package com.tencent.mm.pluginsdk.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class c
  extends q
  implements m
{
  private final a JXC;
  private i callback;
  private d rr;
  
  public c(k.b paramb, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(223773);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new xv();
    ((d.a)localObject).iLO = new xw();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
    ((d.a)localObject).funcId = 727;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (xv)this.rr.iLK.iLR;
    if ((paramb != null) && (!Util.isNullOrNil(paramb.aesKey)) && (!Util.isNullOrNil(paramb.filemd5)))
    {
      ((xv)localObject).LbJ = paramb.aesKey;
      ((xv)localObject).xuB = paramb.filemd5;
      ((xv)localObject).xuz = paramb.title;
      ((xv)localObject).KMh = paramb.iwJ;
    }
    for (((xv)localObject).KMg = paramb.iwI;; ((xv)localObject).KMg = ((int)com.tencent.mm.vfs.s.boW(paramString1)))
    {
      ((xv)localObject).KKA = com.tencent.mm.i.a.gpO;
      ((xv)localObject).xNG = paramString2;
      ((xv)localObject).xNH = z.aTY();
      this.JXC = parama;
      Log.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", new Object[] { paramb, ((xv)localObject).LbJ, ((xv)localObject).xuB, ((xv)localObject).xuz, Long.valueOf(((xv)localObject).KMg), ((xv)localObject).KMh, ((xv)localObject).xNG, ((xv)localObject).xNH, Util.getStack() });
      AppMethodBeat.o(223773);
      return;
      f.baR();
      ((xv)localObject).LbJ = com.tencent.mm.an.a.baG();
      f.baR();
      ((xv)localObject).xuB = com.tencent.mm.an.a.NV(paramString1);
      ((xv)localObject).xuz = com.tencent.mm.vfs.s.bpb(paramString1);
      ((xv)localObject).KMh = com.tencent.mm.vfs.s.akC(paramString1);
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(223774);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(223774);
    return i;
  }
  
  public final int getType()
  {
    return 727;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(223775);
    Log.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.JXC != null)
      {
        params = MMApplicationContext.getContext().getString(2131757553);
        if (!Util.isNullOrNil(paramString))
        {
          paramString = XmlParser.parseXml(paramString, "e", null);
          if (paramString != null) {
            break label172;
          }
        }
      }
      label172:
      for (params = MMApplicationContext.getContext().getString(2131757552);; params = (String)paramString.get(".e.Content"))
      {
        this.JXC.a(params, "", "", "", "", "", 0L);
        AppMethodBeat.o(223775);
        return;
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    paramArrayOfByte = (xv)((d)params).iLK.iLR;
    params = (xw)((d)params).iLL.iLR;
    Log.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", new Object[] { params.keb, Integer.valueOf(params.LiR), params.LiS, params.LiT });
    if (this.JXC != null)
    {
      paramString = "";
      if (params.getBaseResponse().Ret != 0)
      {
        paramString = XmlParser.parseXml(params.getBaseResponse().ErrMsg.toString(), "e", null);
        if (paramString != null) {
          break label389;
        }
      }
    }
    label389:
    for (paramString = MMApplicationContext.getContext().getString(2131757552);; paramString = (String)paramString.get(".e.Content"))
    {
      this.JXC.a(paramString, paramArrayOfByte.xuB, paramArrayOfByte.LbJ, params.keb, params.LiS, params.LiT, paramArrayOfByte.KMg);
      AppMethodBeat.o(223775);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.c
 * JD-Core Version:    0.7.0.1
 */