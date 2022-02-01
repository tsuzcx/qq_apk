package com.tencent.mm.plugin.secinforeport;

import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.x;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aa;
import com.tencent.mm.protocal.protobuf.ctq;
import com.tencent.mm.protocal.protobuf.ctr;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.yy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.zip.Deflater;

 enum c
  implements com.tencent.mm.plugin.secinforeport.a.c
{
  static
  {
    AppMethodBeat.i(89181);
    yBJ = new c("INSTANCE");
    yBK = new c[] { yBJ };
    AppMethodBeat.o(89181);
  }
  
  private c() {}
  
  private static byte[] U(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(89179);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new IllegalArgumentException("dataIn is null.");
      AppMethodBeat.o(89179);
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
      AppMethodBeat.o(89179);
      return paramArrayOfByte;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.SecInfoReporterImpl", localIOException, "exception when compressing dump maps", new Object[0]);
      }
    }
  }
  
  public final void OX(int paramInt)
  {
    AppMethodBeat.i(197166);
    byte[] arrayOfByte = c.p.aa(0);
    if (arrayOfByte != null) {}
    try
    {
      eah localeah = new eah();
      localeah.HNl = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
      ad.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d ctx=%d in finder", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(paramInt) }));
      r(paramInt, localeah.toByteArray());
      label75:
      ad.i("MicroMsg.SecInfoReporterImpl", "[+] report finder through cgi, type: sec");
      AppMethodBeat.o(197166);
      return;
      ad.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
      AppMethodBeat.o(197166);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label75;
    }
  }
  
  public final void OY(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(89178);
    new StringBuilder();
    Object localObject1 = new aa();
    ((aa)localObject1).nDT = Build.MANUFACTURER;
    ((aa)localObject1).nDt = Build.MODEL;
    ((aa)localObject1).Fqx = Build.VERSION.RELEASE;
    ((aa)localObject1).Fqy = Build.VERSION.INCREMENTAL;
    ((aa)localObject1).Fqz = Build.DISPLAY;
    Object localObject2;
    if (paramInt == -2147483646)
    {
      ((aa)localObject1).FqA = Build.FINGERPRINT;
      localObject2 = com.tencent.mm.plugin.normsg.a.b.wtJ.pi(false);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = ((String)localObject2).split(",");
        if (localObject2 != null)
        {
          int j = localObject2.length;
          while (i < j)
          {
            Object localObject3 = localObject2[i];
            ((aa)localObject1).FqB.add(localObject3);
            i += 1;
          }
        }
      }
    }
    try
    {
      localObject2 = ((aa)localObject1).toByteArray();
      localObject1 = new yy();
      ((yy)localObject1).FYB = new com.tencent.mm.bx.b("".getBytes());
      ((yy)localObject1).type = 1;
      localObject2 = U((byte[])localObject2, localObject2.length);
      if (localObject2 == null)
      {
        ((yy)localObject1).FYC = new com.tencent.mm.bx.b("compress data failed".getBytes());
        ((yy)localObject1).dataType = 1;
        ((yy)localObject1).timestamp = (System.currentTimeMillis() / 1000L);
      }
      for (((yy)localObject1).status = 1;; ((yy)localObject1).status = 0)
      {
        localObject2 = new eah();
        ((eah)localObject2).HNn = new SKBuiltinBuffer_t().setBuffer(((yy)localObject1).toByteArray());
        localObject1 = ((eah)localObject2).toByteArray();
        ad.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] report di info msg: len = %d \n", new Object[] { Integer.valueOf(localObject1.length) }));
        r(paramInt, (byte[])localObject1);
        AppMethodBeat.o(89178);
        return;
        if (localObject2.length > 5120)
        {
          g.yhR.idkeyStat(633L, 4L, 1L, false);
          ad.d("MicroMsg.SecInfoReporterImpl", "compressed and base64 result is still too large with length " + localObject2.length);
        }
        ((yy)localObject1).FYC = new com.tencent.mm.bx.b((byte[])localObject2);
        ((yy)localObject1).dataType = 4;
        ((yy)localObject1).timestamp = (System.currentTimeMillis() / 1000L);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(89178);
    }
  }
  
  public final void asyncReportFinderSecurityInfoThroughCgi(int paramInt)
  {
    AppMethodBeat.i(197167);
    qy localqy = new qy();
    localqy.dFz.dFA = paramInt;
    a.IbL.l(localqy);
    AppMethodBeat.o(197167);
  }
  
  public final void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(89176);
    a.IbL.l(new qz());
    AppMethodBeat.o(89176);
  }
  
  public final boolean ay(int paramInt, long paramLong)
  {
    AppMethodBeat.i(89173);
    boolean bool = c.a.ay(paramInt, paramLong);
    ad.i("MicroMsg.SecInfoReporterImpl", "[+] isTimeToReport called, res: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(89173);
    return bool;
  }
  
  public final boolean az(int paramInt, long paramLong)
  {
    AppMethodBeat.i(89174);
    ax localax = ax.aQz(new StringBuilder("atadtsurt_").reverse().toString());
    long l1 = localax.getLong(String.format("%s", new Object[] { Integer.valueOf(paramInt) }), 0L);
    long l2 = System.currentTimeMillis();
    boolean bool;
    if ((l1 == 0L) || (l2 < l1))
    {
      localax.putLong(String.format("%s", new Object[] { Integer.valueOf(paramInt) }), l2).apply();
      if (l1 == 0L) {
        bool = true;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.SecInfoReporterImpl", "[+] isTimeToReport2 called, res: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(89174);
      return bool;
      bool = false;
      continue;
      if (l2 - l1 > paramLong)
      {
        localax.putLong(String.format("%s", new Object[] { Integer.valueOf(paramInt) }), l2).apply();
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final void dMZ()
  {
    AppMethodBeat.i(89175);
    byte[] arrayOfByte = c.p.aa(8);
    if (arrayOfByte != null) {}
    try
    {
      eah localeah = new eah();
      localeah.HNl = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
      ad.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d in yap", new Object[] { Integer.valueOf(arrayOfByte.length) }));
      r(540999683, localeah.toByteArray());
      label73:
      ad.i("MicroMsg.SecInfoReporterImpl", "[+] report yap through cgi, type: sec");
      AppMethodBeat.o(89175);
      return;
      ad.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
      AppMethodBeat.o(89175);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label73;
    }
  }
  
  public final void hu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89177);
    byte[] arrayOfByte1 = c.p.aa(paramInt2);
    byte[] arrayOfByte2 = com.tencent.mm.plugin.normsg.a.b.wtJ.duP();
    if (arrayOfByte1 != null) {
      for (;;)
      {
        try
        {
          eah localeah = new eah();
          if (arrayOfByte2 == null) {
            continue;
          }
          yy localyy = new yy();
          localyy.FYB = new com.tencent.mm.bx.b("".getBytes());
          localyy.type = 1;
          localyy.FYC = new com.tencent.mm.bx.b(arrayOfByte2);
          localyy.dataType = 2;
          localyy.timestamp = (System.currentTimeMillis() / 1000L);
          localyy.status = 0;
          arrayOfByte2 = localyy.toByteArray();
          ad.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] tur ccd data len = %d", new Object[] { Integer.valueOf(arrayOfByte2.length) }));
          localeah.HNo = new SKBuiltinBuffer_t().setBuffer(arrayOfByte2);
          localeah.HNl = new SKBuiltinBuffer_t().setBuffer(arrayOfByte1);
          ad.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d", new Object[] { Integer.valueOf(arrayOfByte1.length) }));
          r(paramInt1, localeah.toByteArray());
        }
        catch (Throwable localThrowable)
        {
          continue;
        }
        ad.i("MicroMsg.SecInfoReporterImpl", "[+] report through cgi, type: sec, ctx: %s", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(89177);
        return;
        ad.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] tur ccd data is null ", new Object[0]));
      }
    }
    ad.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
    AppMethodBeat.o(89177);
  }
  
  public final void r(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89180);
    if (paramArrayOfByte == null)
    {
      ad.e("MicroMsg.SecInfoReporterImpl", "data is null.");
      AppMethodBeat.o(89180);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).uri = com.tencent.mm.plugin.normsg.a.b.wtJ.atn("");
    ((b.a)localObject).funcId = 771;
    ((b.a)localObject).hNM = new ctq();
    ((b.a)localObject).hNN = new ctr();
    localObject = ((b.a)localObject).aDC();
    ctq localctq = (ctq)((com.tencent.mm.al.b)localObject).hNK.hNQ;
    localctq.dFA = paramInt;
    localctq.HlN = new com.tencent.mm.bx.b("".getBytes());
    localctq.FzL = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    e.ygI.idkeyStat(416L, 0L, 1L, false);
    x.a((com.tencent.mm.al.b)localObject, new c.1(this, paramInt), false);
    AppMethodBeat.o(89180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.c
 * JD-Core Version:    0.7.0.1
 */