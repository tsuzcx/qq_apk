package com.tencent.mm.plugin.qqmail.d;

import android.util.Base64;
import com.qq.taf.jce.HexUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
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

public final class p
  extends q
  implements m
{
  public String BrO;
  public String BrP;
  private i callback;
  public String dHx;
  private com.tencent.mm.ak.d hJu;
  
  public p(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(198602);
    d.a locala = new d.a();
    locala.funcId = getType();
    this.BrO = paramString1;
    this.dHx = paramString2;
    this.BrP = paramString3;
    d locald = new d();
    locald.Brf = paramInt;
    if (!Util.isNullOrNil(paramString4)) {
      locald.Brj = encrypt(paramString4, paramString3);
    }
    locald.Brh = paramString1;
    locald.Bri = paramString2;
    locala.iLN = locald;
    locala.iLO = new e();
    locala.uri = "/cgi-bin/micromsg-bin/commitbindxmail";
    this.hJu = locala.aXF();
    AppMethodBeat.o(198602);
  }
  
  private static String encrypt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198603);
    try
    {
      paramString2 = a.bsA(paramString2);
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString2, "AES");
      Object localObject = Cipher.getInstance("AES/CBC/PKCS5Padding");
      ((Cipher)localObject).init(1, localSecretKeySpec, new IvParameterSpec(paramString2));
      paramString1 = MD5Util.getMD5String(paramString1).getBytes("UTF-8");
      localObject = ((Cipher)localObject).doFinal(paramString1);
      Log.d("MicroMsg.NetSceneBindXmail", "key %s, pwd %s, encrypt %s", new Object[] { HexUtil.bytes2HexStr(paramString2), HexUtil.bytes2HexStr(paramString1), HexUtil.bytes2HexStr((byte[])localObject) });
      paramString1 = Base64.encodeToString((byte[])localObject, 2);
      AppMethodBeat.o(198603);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.NetSceneBindXmail", paramString1, "bind xmail encrypt second pwd error", new Object[0]);
      AppMethodBeat.o(198603);
    }
    return "";
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(198604);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(198604);
    return i;
  }
  
  public final int eGo()
  {
    return ((e)this.hJu.iLL.iLR).Brk;
  }
  
  public final int getType()
  {
    return 586;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198605);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(198605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.p
 * JD-Core Version:    0.7.0.1
 */