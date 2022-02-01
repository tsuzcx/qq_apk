package com.tencent.mm.plugin.scanner.util;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public class ScanCameraLightDetector
{
  public static final ScanCameraLightDetector xlv;
  private String gXv;
  private ao handler;
  private float qxb = -1.0F;
  private final int xlw = 2;
  private int xlx;
  private long xly = -1L;
  private HandlerThread xlz;
  
  static
  {
    AppMethodBeat.i(91077);
    xlv = new ScanCameraLightDetector();
    AppMethodBeat.o(91077);
  }
  
  private static native int calcLumNative(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private void dBo()
  {
    AppMethodBeat.i(91074);
    ac.i("MicroMsg.ScanCameraLightDetector", "alvinluo initDetectThread");
    stop();
    this.xlz = d.gA("ScanCameraLightDetector_detectThread", 5);
    this.xlz.start();
    this.handler = new ao(this.xlz.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(91071);
        if (paramAnonymousMessage.what == 233)
        {
          paramAnonymousMessage = (ScanCameraLightDetector.a)paramAnonymousMessage.obj;
          if (paramAnonymousMessage != null)
          {
            long l = bs.Gn();
            boolean bool = ScanCameraLightDetector.B(paramAnonymousMessage.uLZ, paramAnonymousMessage.width, paramAnonymousMessage.height);
            ac.i("MicroMsg.ScanCameraLightDetector", "isYuvDark: %s, currentLight: %s, used %sms", new Object[] { Boolean.valueOf(bool), Float.valueOf(ScanCameraLightDetector.a(ScanCameraLightDetector.this)), Long.valueOf(bs.aO(l)) });
            if (bool)
            {
              ac.i("MicroMsg.ScanCameraLightDetector", "is dark now");
              ScanCameraLightDetector.b(ScanCameraLightDetector.this);
              if ((ScanCameraLightDetector.c(ScanCameraLightDetector.this).equals("continuous-video")) && (ScanCameraLightDetector.d(ScanCameraLightDetector.this) < 2))
              {
                AppMethodBeat.o(91071);
                return;
              }
              ScanCameraLightDetector.e(ScanCameraLightDetector.this);
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(91069);
                  ry localry = new ry();
                  localry.duU.duV = true;
                  a.GpY.l(localry);
                  AppMethodBeat.o(91069);
                }
              });
              AppMethodBeat.o(91071);
              return;
            }
            ac.i("MicroMsg.ScanCameraLightDetector", "not dark");
            ScanCameraLightDetector.e(ScanCameraLightDetector.this);
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(91070);
                ry localry = new ry();
                localry.duU.duV = false;
                a.GpY.l(localry);
                AppMethodBeat.o(91070);
              }
            });
          }
        }
        AppMethodBeat.o(91071);
      }
    };
    AppMethodBeat.o(91074);
  }
  
  public final void A(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91075);
    if (((this.xly < 0L) || (bs.aO(this.xly) >= 1000L)) && (this.handler != null) && (this.xlz != null) && (this.xlz.isAlive()))
    {
      a locala = new a((byte)0);
      locala.uLZ = paramArrayOfByte;
      locala.width = paramInt1;
      locala.height = paramInt2;
      paramArrayOfByte = Message.obtain();
      paramArrayOfByte.what = 233;
      paramArrayOfByte.obj = locala;
      this.handler.sendMessage(paramArrayOfByte);
      this.xly = bs.Gn();
    }
    AppMethodBeat.o(91075);
  }
  
  public final void start(String paramString)
  {
    AppMethodBeat.i(91072);
    try
    {
      this.gXv = paramString;
      dBo();
      AppMethodBeat.o(91072);
      return;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.ScanCameraLightDetector", paramString, "start error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(91072);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(91073);
    try
    {
      this.xly = -1L;
      if (this.xlz != null) {
        this.xlz.quit();
      }
      AppMethodBeat.o(91073);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.ScanCameraLightDetector", localException, "stop error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(91073);
    }
  }
  
  final class a
  {
    int height;
    byte[] uLZ;
    int width;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector
 * JD-Core Version:    0.7.0.1
 */