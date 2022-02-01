package com.tencent.mm.plugin.secinforeport;

import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.x;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aa;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.protocal.protobuf.wz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
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
    xnI = new c("INSTANCE");
    xnJ = new c[] { xnI };
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
        ac.printErrStackTrace("MicroMsg.SecInfoReporterImpl", localIOException, "exception when compressing dump maps", new Object[0]);
      }
    }
  }
  
  public final void Nv(int paramInt)
  {
    AppMethodBeat.i(207471);
    byte[] arrayOfByte = c.p.aa(0);
    if (arrayOfByte != null) {}
    try
    {
      dun localdun = new dun();
      localdun.Gco = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
      ac.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d ctx=%d in finder", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(paramInt) }));
      r(paramInt, localdun.toByteArray());
      label75:
      ac.i("MicroMsg.SecInfoReporterImpl", "[+] report finder through cgi, type: sec");
      AppMethodBeat.o(207471);
      return;
      ac.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
      AppMethodBeat.o(207471);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label75;
    }
  }
  
  public final void Nw(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(89178);
    new StringBuilder();
    Object localObject1 = new aa();
    ((aa)localObject1).ndw = Build.MANUFACTURER;
    ((aa)localObject1).ncW = Build.MODEL;
    ((aa)localObject1).DLs = Build.VERSION.RELEASE;
    ((aa)localObject1).DLt = Build.VERSION.INCREMENTAL;
    ((aa)localObject1).DLu = Build.DISPLAY;
    Object localObject2;
    if (paramInt == -2147483646)
    {
      ((aa)localObject1).DLv = Build.FINGERPRINT;
      localObject2 = com.tencent.mm.plugin.normsg.a.b.vor.oJ(false);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = ((String)localObject2).split(",");
        if (localObject2 != null)
        {
          int j = localObject2.length;
          while (i < j)
          {
            Object localObject3 = localObject2[i];
            ((aa)localObject1).DLw.add(localObject3);
            i += 1;
          }
        }
      }
    }
    try
    {
      localObject2 = ((aa)localObject1).toByteArray();
      localObject1 = new wz();
      ((wz)localObject1).Err = new com.tencent.mm.bw.b("".getBytes());
      ((wz)localObject1).type = 1;
      localObject2 = U((byte[])localObject2, localObject2.length);
      if (localObject2 == null)
      {
        ((wz)localObject1).Ers = new com.tencent.mm.bw.b("compress data failed".getBytes());
        ((wz)localObject1).dataType = 1;
        ((wz)localObject1).timestamp = (System.currentTimeMillis() / 1000L);
      }
      for (((wz)localObject1).status = 1;; ((wz)localObject1).status = 0)
      {
        localObject2 = new dun();
        ((dun)localObject2).Gcq = new SKBuiltinBuffer_t().setBuffer(((wz)localObject1).toByteArray());
        localObject1 = ((dun)localObject2).toByteArray();
        ac.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] report di info msg: len = %d \n", new Object[] { Integer.valueOf(localObject1.length) }));
        r(paramInt, (byte[])localObject1);
        AppMethodBeat.o(89178);
        return;
        if (localObject2.length > 5120)
        {
          h.wUl.idkeyStat(633L, 4L, 1L, false);
          ac.d("MicroMsg.SecInfoReporterImpl", "compressed and base64 result is still too large with length " + localObject2.length);
        }
        ((wz)localObject1).Ers = new com.tencent.mm.bw.b((byte[])localObject2);
        ((wz)localObject1).dataType = 4;
        ((wz)localObject1).timestamp = (System.currentTimeMillis() / 1000L);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(89178);
    }
  }
  
  public final boolean ar(int paramInt, long paramLong)
  {
    AppMethodBeat.i(89173);
    boolean bool = c.a.ar(paramInt, paramLong);
    ac.i("MicroMsg.SecInfoReporterImpl", "[+] isTimeToReport called, res: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(89173);
    return bool;
  }
  
  public final boolean as(int paramInt, long paramLong)
  {
    AppMethodBeat.i(89174);
    aw localaw = aw.aKT(new StringBuilder("atadtsurt_").reverse().toString());
    long l1 = localaw.getLong(String.format("%s", new Object[] { Integer.valueOf(paramInt) }), 0L);
    long l2 = System.currentTimeMillis();
    boolean bool;
    if ((l1 == 0L) || (l2 < l1))
    {
      localaw.putLong(String.format("%s", new Object[] { Integer.valueOf(paramInt) }), l2).apply();
      if (l1 == 0L) {
        bool = true;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.SecInfoReporterImpl", "[+] isTimeToReport2 called, res: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(89174);
      return bool;
      bool = false;
      continue;
      if (l2 - l1 > paramLong)
      {
        localaw.putLong(String.format("%s", new Object[] { Integer.valueOf(paramInt) }), l2).apply();
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public final void asyncReportFinderSecurityInfoThroughCgi(int paramInt)
  {
    AppMethodBeat.i(207472);
    qn localqn = new qn();
    localqn.dty.dtz = paramInt;
    a.GpY.l(localqn);
    AppMethodBeat.o(207472);
  }
  
  public final void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(89176);
    a.GpY.l(new qo());
    AppMethodBeat.o(89176);
  }
  
  public final void dBC()
  {
    AppMethodBeat.i(89175);
    byte[] arrayOfByte = c.p.aa(8);
    if (arrayOfByte != null) {}
    try
    {
      dun localdun = new dun();
      localdun.Gco = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
      ac.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d in yap", new Object[] { Integer.valueOf(arrayOfByte.length) }));
      r(540999683, localdun.toByteArray());
      label73:
      ac.i("MicroMsg.SecInfoReporterImpl", "[+] report yap through cgi, type: sec");
      AppMethodBeat.o(89175);
      return;
      ac.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
      AppMethodBeat.o(89175);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label73;
    }
  }
  
  public final void hd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89177);
    byte[] arrayOfByte1 = c.p.aa(paramInt2);
    byte[] arrayOfByte2 = com.tencent.mm.plugin.normsg.a.b.vor.dkD();
    if (arrayOfByte1 != null) {
      for (;;)
      {
        try
        {
          dun localdun = new dun();
          if (arrayOfByte2 == null) {
            continue;
          }
          wz localwz = new wz();
          localwz.Err = new com.tencent.mm.bw.b("".getBytes());
          localwz.type = 1;
          localwz.Ers = new com.tencent.mm.bw.b(arrayOfByte2);
          localwz.dataType = 2;
          localwz.timestamp = (System.currentTimeMillis() / 1000L);
          localwz.status = 0;
          arrayOfByte2 = localwz.toByteArray();
          ac.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] tur ccd data len = %d", new Object[] { Integer.valueOf(arrayOfByte2.length) }));
          localdun.Gcr = new SKBuiltinBuffer_t().setBuffer(arrayOfByte2);
          localdun.Gco = new SKBuiltinBuffer_t().setBuffer(arrayOfByte1);
          ac.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d", new Object[] { Integer.valueOf(arrayOfByte1.length) }));
          r(paramInt1, localdun.toByteArray());
        }
        catch (Throwable localThrowable)
        {
          continue;
        }
        ac.i("MicroMsg.SecInfoReporterImpl", "[+] report through cgi, type: sec, ctx: %s", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(89177);
        return;
        ac.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] tur ccd data is null ", new Object[0]));
      }
    }
    ac.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
    AppMethodBeat.o(89177);
  }
  
  public final void r(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89180);
    if (paramArrayOfByte == null)
    {
      ac.e("MicroMsg.SecInfoReporterImpl", "data is null.");
      AppMethodBeat.o(89180);
      return;
    }
    Object localObject = new b.a();
    ((b.a)localObject).uri = com.tencent.mm.plugin.normsg.a.b.vor.aon("");
    ((b.a)localObject).funcId = 771;
    ((b.a)localObject).hvt = new con();
    ((b.a)localObject).hvu = new coo();
    localObject = ((b.a)localObject).aAz();
    con localcon = (con)((com.tencent.mm.ak.b)localObject).hvr.hvw;
    localcon.dtz = paramInt;
    localcon.FBA = new com.tencent.mm.bw.b("".getBytes());
    localcon.DUr = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    e.wTc.idkeyStat(416L, 0L, 1L, false);
    x.a((com.tencent.mm.ak.b)localObject, new c.1(this, paramInt), false);
    AppMethodBeat.o(89180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.c
 * JD-Core Version:    0.7.0.1
 */