package com.tencent.mm.pluginsdk.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.aq.f;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.protocal.protobuf.yb;
import com.tencent.mm.protocal.protobuf.yc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.u;
import java.util.Map;

public final class c
  extends q
  implements m
{
  private final a QYe;
  private i callback;
  private d rr;
  
  public c(k.b paramb, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(232165);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new yb();
    ((d.a)localObject).lBV = new yc();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
    ((d.a)localObject).funcId = 727;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (yb)d.b.b(this.rr.lBR);
    if ((paramb != null) && (!Util.isNullOrNil(paramb.aesKey)) && (!Util.isNullOrNil(paramb.filemd5)))
    {
      ((yb)localObject).ScV = paramb.aesKey;
      ((yb)localObject).CqS = paramb.filemd5;
      ((yb)localObject).CqQ = paramb.title;
      ((yb)localObject).RNe = paramb.llY;
    }
    for (((yb)localObject).RNd = paramb.llX;; ((yb)localObject).RNd = ((int)u.bBQ(paramString1)))
    {
      ((yb)localObject).RLs = com.tencent.mm.i.a.iTW;
      ((yb)localObject).CRQ = paramString2;
      ((yb)localObject).CRR = z.bcZ();
      this.QYe = parama;
      Log.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", new Object[] { paramb, ((yb)localObject).ScV, ((yb)localObject).CqS, ((yb)localObject).CqQ, Long.valueOf(((yb)localObject).RNd), ((yb)localObject).RNe, ((yb)localObject).CRQ, ((yb)localObject).CRR, Util.getStack() });
      AppMethodBeat.o(232165);
      return;
      f.bkh();
      ((yb)localObject).ScV = com.tencent.mm.aq.a.bjV();
      f.bkh();
      ((yb)localObject).CqS = com.tencent.mm.aq.a.Vs(paramString1);
      ((yb)localObject).CqQ = u.bBW(paramString1);
      ((yb)localObject).RNe = u.asq(paramString1);
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(232170);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(232170);
    return i;
  }
  
  public final int getType()
  {
    return 727;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(232171);
    Log.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.QYe != null)
      {
        params = MMApplicationContext.getContext().getString(c.h.check_big_file_error_svr);
        if (!Util.isNullOrNil(paramString))
        {
          paramString = XmlParser.parseXml(paramString, "e", null);
          if (paramString != null) {
            break label173;
          }
        }
      }
      label173:
      for (params = MMApplicationContext.getContext().getString(c.h.check_big_file_error_parse_resp);; params = (String)paramString.get(".e.Content"))
      {
        this.QYe.a(params, "", "", "", "", "", 0L);
        AppMethodBeat.o(232171);
        return;
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    paramArrayOfByte = (yb)d.b.b(((d)params).lBR);
    params = (yc)d.c.b(((d)params).lBS);
    Log.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", new Object[] { params.mVB, Integer.valueOf(params.Ski), params.Skj, params.Skk });
    if (this.QYe != null)
    {
      paramString = "";
      if (params.getBaseResponse().CqV != 0)
      {
        paramString = XmlParser.parseXml(params.getBaseResponse().Tef.toString(), "e", null);
        if (paramString != null) {
          break label390;
        }
      }
    }
    label390:
    for (paramString = MMApplicationContext.getContext().getString(c.h.check_big_file_error_parse_resp);; paramString = (String)paramString.get(".e.Content"))
    {
      this.QYe.a(paramString, paramArrayOfByte.CqS, paramArrayOfByte.ScV, params.mVB, params.Skj, params.Skk, paramArrayOfByte.RNd);
      AppMethodBeat.o(232171);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.c
 * JD-Core Version:    0.7.0.1
 */