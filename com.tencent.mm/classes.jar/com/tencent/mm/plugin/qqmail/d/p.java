package com.tencent.mm.plugin.qqmail.d;

import android.util.Base64;
import com.qq.taf.jce.HexUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.xweb.util.a;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class p
  extends n
  implements k
{
  private f callback;
  public String dpf;
  private b gPp;
  public String xbV;
  public String xbW;
  
  public p(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(215202);
    b.a locala = new b.a();
    locala.funcId = getType();
    this.xbV = paramString1;
    this.dpf = paramString2;
    this.xbW = paramString3;
    d locald = new d();
    locald.xbl = paramInt;
    if (!bt.isNullOrNil(paramString4)) {
      locald.xbp = encrypt(paramString4, paramString3);
    }
    locald.xbn = paramString1;
    locald.xbo = paramString2;
    locala.hNM = locald;
    locala.hNN = new e();
    locala.uri = "/cgi-bin/micromsg-bin/commitbindxmail";
    this.gPp = locala.aDC();
    AppMethodBeat.o(215202);
  }
  
  private static String encrypt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215203);
    try
    {
      paramString2 = a.bbm(paramString2);
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString2, "AES");
      Object localObject = Cipher.getInstance("AES/CBC/PKCS5Padding");
      ((Cipher)localObject).init(1, localSecretKeySpec, new IvParameterSpec(paramString2));
      paramString1 = ai.ee(paramString1).getBytes("UTF-8");
      localObject = ((Cipher)localObject).doFinal(paramString1);
      ad.d("MicroMsg.NetSceneBindXmail", "key %s, pwd %s, encrypt %s", new Object[] { HexUtil.bytes2HexStr(paramString2), HexUtil.bytes2HexStr(paramString1), HexUtil.bytes2HexStr((byte[])localObject) });
      paramString1 = Base64.encodeToString((byte[])localObject, 2);
      AppMethodBeat.o(215203);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ad.printErrStackTrace("MicroMsg.NetSceneBindXmail", paramString1, "bind xmail encrypt second pwd error", new Object[0]);
      AppMethodBeat.o(215203);
    }
    return "";
  }
  
  public final int dCi()
  {
    return ((e)this.gPp.hNL.hNQ).xbq;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(215204);
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(215204);
    return i;
  }
  
  public final int getType()
  {
    return 586;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(215205);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(215205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.p
 * JD-Core Version:    0.7.0.1
 */