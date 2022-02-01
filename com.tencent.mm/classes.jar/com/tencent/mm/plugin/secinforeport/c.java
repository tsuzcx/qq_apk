package com.tencent.mm.plugin.secinforeport;

import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.ra;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aa;
import com.tencent.mm.protocal.protobuf.cuk;
import com.tencent.mm.protocal.protobuf.cul;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.protocal.protobuf.zb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
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
    yRJ = new c("INSTANCE");
    yRK = new c[] { yRJ };
    AppMethodBeat.o(89181);
  }
  
  private c() {}
  
  private static byte[] Y(byte[] paramArrayOfByte, int paramInt)
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
        ae.printErrStackTrace("MicroMsg.SecInfoReporterImpl", localIOException, "exception when compressing dump maps", new Object[0]);
      }
    }
  }
  
  public final void PE(int paramInt)
  {
    AppMethodBeat.i(210884);
    byte[] arrayOfByte = c.p.aa(0);
    if (arrayOfByte != null) {}
    try
    {
      eby localeby = new eby();
      localeby.Ihs = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
      ae.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d ctx=%d in finder", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(paramInt) }));
      r(paramInt, localeby.toByteArray());
      label75:
      ae.i("MicroMsg.SecInfoReporterImpl", "[+] report finder through cgi, type: sec");
      AppMethodBeat.o(210884);
      return;
      ae.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
      AppMethodBeat.o(210884);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label75;
    }
  }
  
  public final void PF(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(89178);
    new StringBuilder();
    Object localObject1 = new aa();
    ((aa)localObject1).nJo = Build.MANUFACTURER;
    ((aa)localObject1).nIO = Build.MODEL;
    ((aa)localObject1).FIV = Build.VERSION.RELEASE;
    ((aa)localObject1).FIW = Build.VERSION.INCREMENTAL;
    ((aa)localObject1).FIX = Build.DISPLAY;
    Object localObject2;
    if (paramInt == -2147483646)
    {
      ((aa)localObject1).FIY = Build.FINGERPRINT;
      localObject2 = com.tencent.mm.plugin.normsg.a.b.wJt.pq(false);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = ((String)localObject2).split(",");
        if (localObject2 != null)
        {
          int j = localObject2.length;
          while (i < j)
          {
            Object localObject3 = localObject2[i];
            ((aa)localObject1).FIZ.add(localObject3);
            i += 1;
          }
        }
      }
    }
    try
    {
      localObject2 = ((aa)localObject1).toByteArray();
      localObject1 = new zb();
      ((zb)localObject1).Gra = new com.tencent.mm.bw.b("".getBytes());
      ((zb)localObject1).type = 1;
      localObject2 = Y((byte[])localObject2, localObject2.length);
      if (localObject2 == null)
      {
        ((zb)localObject1).Grb = new com.tencent.mm.bw.b("compress data failed".getBytes());
        ((zb)localObject1).dataType = 1;
        ((zb)localObject1).timestamp = (System.currentTimeMillis() / 1000L);
      }
      for (((zb)localObject1).status = 1;; ((zb)localObject1).status = 0)
      {
        localObject2 = new eby();
        ((eby)localObject2).Ihu = new SKBuiltinBuffer_t().setBuffer(((zb)localObject1).toByteArray());
        localObject1 = ((eby)localObject2).toByteArray();
        ae.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] report di info msg: len = %d \n", new Object[] { Integer.valueOf(localObject1.length) }));
        r(paramInt, (byte[])localObject1);
        AppMethodBeat.o(89178);
        return;
        if (localObject2.length > 5120)
        {
          g.yxI.idkeyStat(633L, 4L, 1L, false);
          ae.d("MicroMsg.SecInfoReporterImpl", "compressed and base64 result is still too large with length " + localObject2.length);
        }
        ((zb)localObject1).Grb = new com.tencent.mm.bw.b((byte[])localObject2);
        ((zb)localObject1).dataType = 4;
        ((zb)localObject1).timestamp = (System.currentTimeMillis() / 1000L);
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
    AppMethodBeat.i(210885);
    qz localqz = new qz();
    localqz.dGE.dGF = paramInt;
    a.IvT.l(localqz);
    AppMethodBeat.o(210885);
  }
  
  public final void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(89176);
    a.IvT.l(new ra());
    AppMethodBeat.o(89176);
  }
  
  public final boolean ay(int paramInt, long paramLong)
  {
    AppMethodBeat.i(89173);
    boolean bool = c.a.ay(paramInt, paramLong);
    ae.i("MicroMsg.SecInfoReporterImpl", "[+] isTimeToReport called, res: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(89173);
    return bool;
  }
  
  public final boolean az(int paramInt, long paramLong)
  {
    AppMethodBeat.i(89174);
    ay localay = ay.aRW(new StringBuilder("atadtsurt_").reverse().toString());
    long l1 = localay.getLong(String.format("%s", new Object[] { Integer.valueOf(paramInt) }), 0L);
    long l2 = System.currentTimeMillis();
    boolean bool;
    if ((l1 == 0L) || (l2 < l1))
    {
      localay.putLong(String.format("%s", new Object[] { Integer.valueOf(paramInt) }), l2).apply();
      if (l1 == 0L) {
        bool = true;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.SecInfoReporterImpl", "[+] isTimeToReport2 called, res: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(89174);
      return bool;
      bool = false;
      continue;
      if (l2 - l1 > paramLong)
      {
        localay.putLong(String.format("%s", new Object[] { Integer.valueOf(paramInt) }), l2).apply();
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final void dQs()
  {
    AppMethodBeat.i(89175);
    byte[] arrayOfByte = c.p.aa(8);
    if (arrayOfByte != null) {}
    try
    {
      eby localeby = new eby();
      localeby.Ihs = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
      ae.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d in yap", new Object[] { Integer.valueOf(arrayOfByte.length) }));
      r(540999683, localeby.toByteArray());
      label73:
      ae.i("MicroMsg.SecInfoReporterImpl", "[+] report yap through cgi, type: sec");
      AppMethodBeat.o(89175);
      return;
      ae.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
      AppMethodBeat.o(89175);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label73;
    }
  }
  
  public final void hw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89177);
    byte[] arrayOfByte1 = c.p.aa(paramInt2);
    byte[] arrayOfByte2 = com.tencent.mm.plugin.normsg.a.b.wJt.dyf();
    if (arrayOfByte1 != null) {
      for (;;)
      {
        try
        {
          eby localeby = new eby();
          if (arrayOfByte2 == null) {
            continue;
          }
          zb localzb = new zb();
          localzb.Gra = new com.tencent.mm.bw.b("".getBytes());
          localzb.type = 1;
          localzb.Grb = new com.tencent.mm.bw.b(arrayOfByte2);
          localzb.dataType = 2;
          localzb.timestamp = (System.currentTimeMillis() / 1000L);
          localzb.status = 0;
          arrayOfByte2 = localzb.toByteArray();
          ae.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] tur ccd data len = %d", new Object[] { Integer.valueOf(arrayOfByte2.length) }));
          localeby.Ihv = new SKBuiltinBuffer_t().setBuffer(arrayOfByte2);
          localeby.Ihs = new SKBuiltinBuffer_t().setBuffer(arrayOfByte1);
          ae.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d", new Object[] { Integer.valueOf(arrayOfByte1.length) }));
          r(paramInt1, localeby.toByteArray());
        }
        catch (Throwable localThrowable)
        {
          continue;
        }
        ae.i("MicroMsg.SecInfoReporterImpl", "[+] report through cgi, type: sec, ctx: %s", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(89177);
        return;
        ae.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] tur ccd data is null ", new Object[0]));
      }
    }
    ae.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
    AppMethodBeat.o(89177);
  }
  
  public final void r(final int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89180);
    if (paramArrayOfByte == null)
    {
      ae.e("MicroMsg.SecInfoReporterImpl", "data is null.");
      AppMethodBeat.o(89180);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).uri = com.tencent.mm.plugin.normsg.a.b.wJt.auA("");
    ((b.a)localObject).funcId = 771;
    ((b.a)localObject).hQF = new cuk();
    ((b.a)localObject).hQG = new cul();
    localObject = ((b.a)localObject).aDS();
    cuk localcuk = (cuk)((com.tencent.mm.ak.b)localObject).hQD.hQJ;
    localcuk.dGF = paramInt;
    localcuk.HFn = new com.tencent.mm.bw.b("".getBytes());
    localcuk.FSj = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    e.ywz.idkeyStat(416L, 0L, 1L, false);
    x.a((com.tencent.mm.ak.b)localObject, new x.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb, n paramAnonymousn)
      {
        AppMethodBeat.i(89166);
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          ae.i("MicroMsg.SecInfoReporterImpl", "cgireport succ, ctx: %d, stack: %s", new Object[] { Integer.valueOf(paramInt), bu.fpN().toString() });
          e.ywz.idkeyStat(416L, 1L, 1L, false);
        }
        for (;;)
        {
          AppMethodBeat.o(89166);
          return 0;
          ae.w("MicroMsg.SecInfoReporterImpl", "cgireport failed, ctx: %d, err: %d:%d %s, stack: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, bu.fpN().toString() });
          e.ywz.idkeyStat(416L, 2L, 1L, false);
        }
      }
    }, false);
    AppMethodBeat.o(89180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.c
 * JD-Core Version:    0.7.0.1
 */