package com.tencent.mm.pluginsdk.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.g.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.y;
import java.util.Map;

public final class c
  extends p
  implements m
{
  private final a XUc;
  private h callback;
  private com.tencent.mm.am.c rr;
  
  public c(k.b paramb, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(244537);
    Object localObject = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject).otE = new zy();
    ((com.tencent.mm.am.c.a)localObject).otF = new zz();
    ((com.tencent.mm.am.c.a)localObject).uri = "/cgi-bin/micromsg-bin/checkbigfileupload";
    ((com.tencent.mm.am.c.a)localObject).funcId = 727;
    ((com.tencent.mm.am.c.a)localObject).otG = 0;
    ((com.tencent.mm.am.c.a)localObject).respCmdId = 0;
    this.rr = ((com.tencent.mm.am.c.a)localObject).bEF();
    localObject = (zy)c.b.b(this.rr.otB);
    if ((paramb != null) && (!Util.isNullOrNil(paramb.aesKey)) && (!Util.isNullOrNil(paramb.filemd5)))
    {
      ((zy)localObject).ZaN = paramb.aesKey;
      ((zy)localObject).Ida = paramb.filemd5;
      ((zy)localObject).IcZ = paramb.title;
      ((zy)localObject).YKs = paramb.nRe;
    }
    for (((zy)localObject).YKr = paramb.nRd;; ((zy)localObject).YKr = ((int)y.bEl(paramString1)))
    {
      ((zy)localObject).YIE = a.lwb;
      ((zy)localObject).IMg = paramString2;
      ((zy)localObject).IMh = z.bAM();
      this.XUc = parama;
      Log.i("MicroMsg.NetSceneCheckBigFileUpload", "summerbig NetSceneCheckBigFileUpload content[%s], aesKey[%s] md5[%s] FileName[%s] FileSize[%d] FileExt[%s] talker[%s], fromUserName[%s], stack[%s]", new Object[] { paramb, ((zy)localObject).ZaN, ((zy)localObject).Ida, ((zy)localObject).IcZ, Long.valueOf(((zy)localObject).YKr), ((zy)localObject).YKs, ((zy)localObject).IMg, ((zy)localObject).IMh, Util.getStack() });
      AppMethodBeat.o(244537);
      return;
      k.bHX();
      ((zy)localObject).ZaN = d.bHI();
      k.bHX();
      ((zy)localObject).Ida = d.Ns(paramString1);
      ((zy)localObject).IcZ = y.bEq(paramString1);
      ((zy)localObject).YKs = y.alV(paramString1);
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(244542);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(244542);
    return i;
  }
  
  public final int getType()
  {
    return 727;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(244548);
    Log.d("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd [%d, %d, %s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneCheckBigFileUpload", "summerbig onGYNetEnd errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (this.XUc != null)
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
        this.XUc.a(params, "", "", "", "", "", 0L);
        AppMethodBeat.o(244548);
        return;
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    paramArrayOfByte = (zy)c.b.b(((com.tencent.mm.am.c)params).otB);
    params = (zz)c.c.b(((com.tencent.mm.am.c)params).otC);
    Log.d("MicroMsg.NetSceneCheckBigFileUpload", "summersafecdn onGYNetEnd Signature[%s], fuin[%d], faeskey[%s], fSignature[%s]", new Object[] { params.pSi, Integer.valueOf(params.Zis), params.Zit, params.Ziu });
    if (this.XUc != null)
    {
      paramString = "";
      if (params.getBaseResponse().Idd != 0)
      {
        paramString = XmlParser.parseXml(params.getBaseResponse().akjO.toString(), "e", null);
        if (paramString != null) {
          break label390;
        }
      }
    }
    label390:
    for (paramString = MMApplicationContext.getContext().getString(c.h.check_big_file_error_parse_resp);; paramString = (String)paramString.get(".e.Content"))
    {
      this.XUc.a(paramString, paramArrayOfByte.Ida, paramArrayOfByte.ZaN, params.pSi, params.Zit, params.Ziu, paramArrayOfByte.YKr);
      AppMethodBeat.o(244548);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.c
 * JD-Core Version:    0.7.0.1
 */