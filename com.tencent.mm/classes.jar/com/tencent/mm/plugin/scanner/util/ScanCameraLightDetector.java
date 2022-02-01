package com.tencent.mm.plugin.scanner.util;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public class ScanCameraLightDetector
{
  public static final ScanCameraLightDetector wap;
  private String gwY;
  private ap handler;
  private float pOt = -1.0F;
  private final int waq = 2;
  private int war;
  private long was = -1L;
  private HandlerThread wat;
  
  static
  {
    AppMethodBeat.i(91077);
    wap = new ScanCameraLightDetector();
    AppMethodBeat.o(91077);
  }
  
  private static native int calcLumNative(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private void dng()
  {
    AppMethodBeat.i(91074);
    ad.i("MicroMsg.ScanCameraLightDetector", "alvinluo initDetectThread");
    stop();
    this.wat = d.gw("ScanCameraLightDetector_detectThread", 5);
    this.wat.start();
    this.handler = new ap(this.wat.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(91071);
        if (paramAnonymousMessage.what == 233)
        {
          paramAnonymousMessage = (ScanCameraLightDetector.a)paramAnonymousMessage.obj;
          if (paramAnonymousMessage != null)
          {
            long l = bt.GC();
            boolean bool = ScanCameraLightDetector.C(paramAnonymousMessage.tDE, paramAnonymousMessage.width, paramAnonymousMessage.height);
            ad.i("MicroMsg.ScanCameraLightDetector", "isYuvDark: %s, currentLight: %s, used %sms", new Object[] { Boolean.valueOf(bool), Float.valueOf(ScanCameraLightDetector.a(ScanCameraLightDetector.this)), Long.valueOf(bt.aS(l)) });
            if (bool)
            {
              ad.i("MicroMsg.ScanCameraLightDetector", "is dark now");
              ScanCameraLightDetector.b(ScanCameraLightDetector.this);
              if ((ScanCameraLightDetector.c(ScanCameraLightDetector.this).equals("continuous-video")) && (ScanCameraLightDetector.d(ScanCameraLightDetector.this) < 2))
              {
                AppMethodBeat.o(91071);
                return;
              }
              ScanCameraLightDetector.e(ScanCameraLightDetector.this);
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(91069);
                  rp localrp = new rp();
                  localrp.dxh.dxi = true;
                  a.ESL.l(localrp);
                  AppMethodBeat.o(91069);
                }
              });
              AppMethodBeat.o(91071);
              return;
            }
            ad.i("MicroMsg.ScanCameraLightDetector", "not dark");
            ScanCameraLightDetector.e(ScanCameraLightDetector.this);
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(91070);
                rp localrp = new rp();
                localrp.dxh.dxi = false;
                a.ESL.l(localrp);
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
  
  public final void B(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91075);
    if (((this.was < 0L) || (bt.aS(this.was) >= 1000L)) && (this.handler != null) && (this.wat != null) && (this.wat.isAlive()))
    {
      a locala = new a((byte)0);
      locala.tDE = paramArrayOfByte;
      locala.width = paramInt1;
      locala.height = paramInt2;
      paramArrayOfByte = Message.obtain();
      paramArrayOfByte.what = 233;
      paramArrayOfByte.obj = locala;
      this.handler.sendMessage(paramArrayOfByte);
      this.was = bt.GC();
    }
    AppMethodBeat.o(91075);
  }
  
  public final void start(String paramString)
  {
    AppMethodBeat.i(91072);
    try
    {
      this.gwY = paramString;
      dng();
      AppMethodBeat.o(91072);
      return;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.ScanCameraLightDetector", paramString, "start error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(91072);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(91073);
    try
    {
      this.was = -1L;
      if (this.wat != null) {
        this.wat.quit();
      }
      AppMethodBeat.o(91073);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.ScanCameraLightDetector", localException, "stop error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(91073);
    }
  }
  
  final class a
  {
    int height;
    byte[] tDE;
    int width;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector
 * JD-Core Version:    0.7.0.1
 */