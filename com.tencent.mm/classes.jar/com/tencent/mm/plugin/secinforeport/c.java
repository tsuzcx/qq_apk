package com.tencent.mm.plugin.secinforeport;

import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.x;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.normsg.c.p;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aa;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.protocal.protobuf.cjh;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.protocal.protobuf.wo;
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
    wcx = new c("INSTANCE");
    wcy = new c[] { wcx };
    AppMethodBeat.o(89181);
  }
  
  private c() {}
  
  private static byte[] W(byte[] paramArrayOfByte, int paramInt)
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
  
  public final void Lv(int paramInt)
  {
    AppMethodBeat.i(186719);
    byte[] arrayOfByte = c.p.aa(0);
    if (arrayOfByte != null) {}
    try
    {
      dow localdow = new dow();
      localdow.EFc = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
      ad.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d ctx=%d in finder", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(paramInt) }));
      r(paramInt, localdow.toByteArray());
      label75:
      ad.i("MicroMsg.SecInfoReporterImpl", "[+] report finder through cgi, type: sec");
      AppMethodBeat.o(186719);
      return;
      ad.e("MicroMsg.SecInfoReporterImpl", "[-] data is null.");
      AppMethodBeat.o(186719);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label75;
    }
  }
  
  public final void Lw(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(89178);
    new StringBuilder();
    Object localObject1 = new aa();
    ((aa)localObject1).mBv = Build.MANUFACTURER;
    ((aa)localObject1).mAV = Build.MODEL;
    ((aa)localObject1).Ctb = Build.VERSION.RELEASE;
    ((aa)localObject1).Ctc = Build.VERSION.INCREMENTAL;
    ((aa)localObject1).Ctd = Build.DISPLAY;
    Object localObject2;
    if (paramInt == -2147483646)
    {
      ((aa)localObject1).Cte = Build.FINGERPRINT;
      localObject2 = com.tencent.mm.plugin.normsg.a.b.ufs.nP(false);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = ((String)localObject2).split(",");
        if (localObject2 != null)
        {
          int j = localObject2.length;
          while (i < j)
          {
            Object localObject3 = localObject2[i];
            ((aa)localObject1).Ctf.add(localObject3);
            i += 1;
          }
        }
      }
    }
    try
    {
      localObject2 = ((aa)localObject1).toByteArray();
      localObject1 = new wo();
      ((wo)localObject1).CYH = new com.tencent.mm.bx.b("".getBytes());
      ((wo)localObject1).type = 1;
      localObject2 = W((byte[])localObject2, localObject2.length);
      if (localObject2 == null)
      {
        ((wo)localObject1).CYI = new com.tencent.mm.bx.b("compress data failed".getBytes());
        ((wo)localObject1).dataType = 1;
        ((wo)localObject1).timestamp = (System.currentTimeMillis() / 1000L);
      }
      for (((wo)localObject1).status = 1;; ((wo)localObject1).status = 0)
      {
        localObject2 = new dow();
        ((dow)localObject2).EFe = new SKBuiltinBuffer_t().setBuffer(((wo)localObject1).toByteArray());
        localObject1 = ((dow)localObject2).toByteArray();
        ad.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] report di info msg: len = %d \n", new Object[] { Integer.valueOf(localObject1.length) }));
        r(paramInt, (byte[])localObject1);
        AppMethodBeat.o(89178);
        return;
        if (localObject2.length > 5120)
        {
          h.vKh.idkeyStat(633L, 4L, 1L, false);
          ad.d("MicroMsg.SecInfoReporterImpl", "compressed and base64 result is still too large with length " + localObject2.length);
        }
        ((wo)localObject1).CYI = new com.tencent.mm.bx.b((byte[])localObject2);
        ((wo)localObject1).dataType = 4;
        ((wo)localObject1).timestamp = (System.currentTimeMillis() / 1000L);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(89178);
    }
  }
  
  public final boolean as(int paramInt, long paramLong)
  {
    AppMethodBeat.i(89173);
    boolean bool = c.a.as(paramInt, paramLong);
    ad.i("MicroMsg.SecInfoReporterImpl", "[+] isTimeToReport called, res: %s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(89173);
    return bool;
  }
  
  public final void asyncReportFinderSecurityInfoThroughCgi(int paramInt)
  {
    AppMethodBeat.i(186720);
    qe localqe = new qe();
    localqe.dvL.dvM = paramInt;
    a.ESL.l(localqe);
    AppMethodBeat.o(186720);
  }
  
  public final void asyncReportPaySecurityInfoThroughCgi()
  {
    AppMethodBeat.i(89176);
    a.ESL.l(new qf());
    AppMethodBeat.o(89176);
  }
  
  public final boolean at(int paramInt, long paramLong)
  {
    AppMethodBeat.i(89174);
    ax localax = ax.aFC(new StringBuilder("atadtsurt_").reverse().toString());
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
  
  public final void dnu()
  {
    AppMethodBeat.i(89175);
    byte[] arrayOfByte = c.p.aa(8);
    if (arrayOfByte != null) {}
    try
    {
      dow localdow = new dow();
      localdow.EFc = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
      ad.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d in yap", new Object[] { Integer.valueOf(arrayOfByte.length) }));
      r(540999683, localdow.toByteArray());
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
  
  public final void gU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89177);
    byte[] arrayOfByte1 = c.p.aa(paramInt2);
    byte[] arrayOfByte2 = com.tencent.mm.plugin.normsg.a.b.ufs.cWV();
    if (arrayOfByte1 != null) {
      for (;;)
      {
        try
        {
          dow localdow = new dow();
          if (arrayOfByte2 == null) {
            continue;
          }
          wo localwo = new wo();
          localwo.CYH = new com.tencent.mm.bx.b("".getBytes());
          localwo.type = 1;
          localwo.CYI = new com.tencent.mm.bx.b(arrayOfByte2);
          localwo.dataType = 2;
          localwo.timestamp = (System.currentTimeMillis() / 1000L);
          localwo.status = 0;
          arrayOfByte2 = localwo.toByteArray();
          ad.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] tur ccd data len = %d", new Object[] { Integer.valueOf(arrayOfByte2.length) }));
          localdow.EFf = new SKBuiltinBuffer_t().setBuffer(arrayOfByte2);
          localdow.EFc = new SKBuiltinBuffer_t().setBuffer(arrayOfByte1);
          ad.d("MicroMsg.SecInfoReporterImpl", String.format("[debug] ccd data len = %d", new Object[] { Integer.valueOf(arrayOfByte1.length) }));
          r(paramInt1, localdow.toByteArray());
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
    ((b.a)localObject).uri = com.tencent.mm.plugin.normsg.a.b.ufs.ajp("");
    ((b.a)localObject).funcId = 771;
    ((b.a)localObject).gUU = new cjg();
    ((b.a)localObject).gUV = new cjh();
    localObject = ((b.a)localObject).atI();
    cjg localcjg = (cjg)((com.tencent.mm.al.b)localObject).gUS.gUX;
    localcjg.dvM = paramInt;
    localcjg.EeA = new com.tencent.mm.bx.b("".getBytes());
    localcjg.CBU = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    e.vIY.idkeyStat(416L, 0L, 1L, false);
    x.a((com.tencent.mm.al.b)localObject, new c.1(this, paramInt), false);
    AppMethodBeat.o(89180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.secinforeport.c
 * JD-Core Version:    0.7.0.1
 */