package com.tencent.mm.plugin.secinforeport;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.normsg.Normsg.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.btu;
import com.tencent.mm.protocal.protobuf.btv;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.Deflater;

 enum c
  implements com.tencent.mm.plugin.secinforeport.a.c
{
  static
  {
    AppMethodBeat.i(57501);
    qEg = new c("INSTANCE");
    qEh = new c[] { qEg };
    AppMethodBeat.o(57501);
  }
  
  private c() {}
  
  private static byte[] S(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(144026);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new IllegalArgumentException("dataIn is null.");
      AppMethodBeat.o(144026);
      throw paramArrayOfByte;
    }
    Deflater localDeflater = new Deflater();
    localDeflater.setLevel(9);
    localDeflater.setInput(paramArrayOfByte, 0, paramInt);
    paramArrayOfByte = new ByteArrayOutputStream(paramInt);
    localDeflater.finish();
    byte[] arrayOfByte = new byte[4096];
    while (!localDeflater.finished()) {
      paramArrayOfByte.write(arrayOfByte, 0, localDeflater.deflate(arrayOfByte));
    }
    localDeflater.end();
    try
    {
      paramArrayOfByte.close();
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      AppMethodBeat.o(144026);
      return paramArrayOfByte;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SecInfoReporterImpl", localIOException, "exception when compressing dump maps", new Object[0]);
      }
    }
  }
  
  public final void CU(int paramInt)
  {
    AppMethodBeat.i(57498);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("<st><Manufacturer>").append(Build.MANUFACTURER).append("</Manufacturer><Model>").append(Build.MODEL).append("</Model><VersionRelease>").append(Build.VERSION.RELEASE).append("</VersionRelease><VersionIncremental>").append(Build.VERSION.INCREMENTAL).append("</VersionIncremental><Display>").append(Build.DISPLAY).append("</Display>");
    StringBuilder localStringBuilder2;
    if (paramInt == -2147483646)
    {
      localStringBuilder2 = localStringBuilder1.append("<FingerPrint>").append(Build.FINGERPRINT).append("</FingerPrint><NDM>");
      localObject = com.tencent.mm.plugin.normsg.a.b.pgQ.jU(false).getBytes();
      localObject = Base64.encode(S((byte[])localObject, localObject.length), 2);
      ab.d("MicroMsg.SecInfoReporterImpl", "Base64 length = " + localObject.length + "\n content = " + Arrays.toString((byte[])localObject));
      if (localObject != null) {
        break label277;
      }
    }
    label277:
    for (Object localObject = "";; localObject = new String((byte[])localObject))
    {
      if (((String)localObject).length() > 5120)
      {
        h.qsU.idkeyStat(633L, 4L, 1L, false);
        ab.d("MicroMsg.SecInfoReporterImpl", "compressed and base64 result is still too large with length " + ((String)localObject).length());
      }
      localStringBuilder2.append((String)localObject).append("</NDM>");
      localStringBuilder1.append("</st>");
      ab.d("MicroMsg.SecInfoReporterImpl", "report msg:\n" + localStringBuilder1.toString());
      p(paramInt, localStringBuilder1.toString().getBytes(Charset.forName("UTF-8")));
      AppMethodBeat.o(57498);
      return;
    }
  }
  
  public final boolean ac(int paramInt, long paramLong)
  {
    AppMethodBeat.i(57496);
    boolean bool = c.a.ac(paramInt, paramLong);
    AppMethodBeat.o(57496);
    return bool;
  }
  
  public final void fq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57497);
    byte[] arrayOfByte = Normsg.b.AL(paramInt2);
    if (arrayOfByte != null) {
      p(paramInt1, arrayOfByte);
    }
    AppMethodBeat.o(57497);
  }
  
  public final void p(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(57500);
    if (paramArrayOfByte == null)
    {
      ab.e("MicroMsg.SecInfoReporterImpl", "data is null.");
      AppMethodBeat.o(57500);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).uri = com.tencent.mm.plugin.normsg.a.b.pgQ.Wd("");
    ((b.a)localObject).funcId = 771;
    ((b.a)localObject).fsX = new btu();
    ((b.a)localObject).fsY = new btv();
    localObject = ((b.a)localObject).ado();
    btu localbtu = (btu)((com.tencent.mm.ai.b)localObject).fsV.fta;
    localbtu.xHl = paramInt;
    localbtu.xHk = new com.tencent.mm.bv.b(paramArrayOfByte);
    e.qrI.idkeyStat(416L, 0L, 1L, false);
    w.a((com.tencent.mm.ai.b)localObject, new c.1(this, paramInt), false);
    AppMethodBeat.o(57500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.c
 * JD-Core Version:    0.7.0.1
 */