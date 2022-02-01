package com.tencent.mm.plugin.qqmail.model;

import android.util.Base64;
import com.qq.taf.jce.HexUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.util.a;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class o
  extends p
  implements m
{
  public String NjV;
  public String NjW;
  private h callback;
  public String hFb;
  private com.tencent.mm.am.c nao;
  
  public o(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(267064);
    c.a locala = new c.a();
    locala.funcId = getType();
    this.NjV = paramString1;
    this.hFb = paramString2;
    this.NjW = paramString3;
    c localc = new c();
    localc.Njm = paramInt;
    if (!Util.isNullOrNil(paramString4)) {
      localc.Njq = encrypt(paramString4, paramString3);
    }
    localc.Njo = paramString1;
    localc.Njp = paramString2;
    locala.otE = localc;
    locala.otF = new d();
    locala.uri = "/cgi-bin/micromsg-bin/commitbindxmail";
    this.nao = locala.bEF();
    AppMethodBeat.o(267064);
  }
  
  private static String encrypt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(267068);
    try
    {
      paramString2 = a.bHW(paramString2);
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString2, "AES");
      Object localObject = Cipher.getInstance("AES/CBC/PKCS5Padding");
      ((Cipher)localObject).init(1, localSecretKeySpec, new IvParameterSpec(paramString2));
      paramString1 = MD5Util.getMD5String(paramString1).getBytes("UTF-8");
      localObject = ((Cipher)localObject).doFinal(paramString1);
      Log.d("MicroMsg.NetSceneBindXmail", "key %s, pwd %s, encrypt %s", new Object[] { HexUtil.bytes2HexStr(paramString2), HexUtil.bytes2HexStr(paramString1), HexUtil.bytes2HexStr((byte[])localObject) });
      paramString1 = Base64.encodeToString((byte[])localObject, 2);
      AppMethodBeat.o(267068);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneBindXmail", paramString1, "bind xmail encrypt second pwd error", new Object[0]);
      AppMethodBeat.o(267068);
    }
    return "";
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(267073);
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(267073);
    return i;
  }
  
  public final int gDX()
  {
    AppMethodBeat.i(267075);
    int i = ((d)c.c.b(this.nao.otC)).Njr;
    AppMethodBeat.o(267075);
    return i;
  }
  
  public final int getType()
  {
    return 586;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(267078);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(267078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.o
 * JD-Core Version:    0.7.0.1
 */