package com.tencent.mm.plugin.qqmail.d;

import android.util.Base64;
import com.qq.taf.jce.HexUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.xweb.util.a;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class p
  extends n
  implements k
{
  private f callback;
  public String dqk;
  private b gRX;
  public String xrM;
  public String xrN;
  
  public p(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(217948);
    b.a locala = new b.a();
    locala.funcId = getType();
    this.xrM = paramString1;
    this.dqk = paramString2;
    this.xrN = paramString3;
    d locald = new d();
    locald.xrc = paramInt;
    if (!bu.isNullOrNil(paramString4)) {
      locald.xrg = encrypt(paramString4, paramString3);
    }
    locald.xre = paramString1;
    locald.xrf = paramString2;
    locala.hQF = locald;
    locala.hQG = new e();
    locala.uri = "/cgi-bin/micromsg-bin/commitbindxmail";
    this.gRX = locala.aDS();
    AppMethodBeat.o(217948);
  }
  
  private static String encrypt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217949);
    try
    {
      paramString2 = a.bcP(paramString2);
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString2, "AES");
      Object localObject = Cipher.getInstance("AES/CBC/PKCS5Padding");
      ((Cipher)localObject).init(1, localSecretKeySpec, new IvParameterSpec(paramString2));
      paramString1 = aj.ej(paramString1).getBytes("UTF-8");
      localObject = ((Cipher)localObject).doFinal(paramString1);
      ae.d("MicroMsg.NetSceneBindXmail", "key %s, pwd %s, encrypt %s", new Object[] { HexUtil.bytes2HexStr(paramString2), HexUtil.bytes2HexStr(paramString1), HexUtil.bytes2HexStr((byte[])localObject) });
      paramString1 = Base64.encodeToString((byte[])localObject, 2);
      AppMethodBeat.o(217949);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ae.printErrStackTrace("MicroMsg.NetSceneBindXmail", paramString1, "bind xmail encrypt second pwd error", new Object[0]);
      AppMethodBeat.o(217949);
    }
    return "";
  }
  
  public final int dFz()
  {
    return ((e)this.gRX.hQE.hQJ).xrh;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(217950);
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(217950);
    return i;
  }
  
  public final int getType()
  {
    return 586;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(217951);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(217951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.p
 * JD-Core Version:    0.7.0.1
 */