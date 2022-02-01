package com.tencent.mm.plugin.scanner.util;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public class ScanCameraLightDetector
{
  public static final ScanCameraLightDetector yzx;
  private ap handler;
  private String hpB;
  private float rgR = -1.0F;
  private long yzA = -1L;
  private HandlerThread yzB;
  private final int yzy = 2;
  private int yzz;
  
  static
  {
    AppMethodBeat.i(91077);
    yzx = new ScanCameraLightDetector();
    AppMethodBeat.o(91077);
  }
  
  private static native int calcLumNative(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private void dMM()
  {
    AppMethodBeat.i(91074);
    ad.i("MicroMsg.ScanCameraLightDetector", "alvinluo initDetectThread");
    stop();
    this.yzB = d.gY("ScanCameraLightDetector_detectThread", 5);
    this.yzB.start();
    this.handler = new ap(this.yzB.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(91071);
        if (paramAnonymousMessage.what == 233)
        {
          paramAnonymousMessage = (ScanCameraLightDetector.a)paramAnonymousMessage.obj;
          if (paramAnonymousMessage != null)
          {
            long l = bt.HI();
            boolean bool = ScanCameraLightDetector.D(paramAnonymousMessage.vPf, paramAnonymousMessage.width, paramAnonymousMessage.height);
            ad.i("MicroMsg.ScanCameraLightDetector", "isYuvDark: %s, currentLight: %s, used %sms", new Object[] { Boolean.valueOf(bool), Float.valueOf(ScanCameraLightDetector.a(ScanCameraLightDetector.this)), Long.valueOf(bt.aO(l)) });
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
                  sk localsk = new sk();
                  localsk.dGV.dGW = true;
                  a.IbL.l(localsk);
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
                sk localsk = new sk();
                localsk.dGV.dGW = false;
                a.IbL.l(localsk);
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
  
  public final void C(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91075);
    if (((this.yzA < 0L) || (bt.aO(this.yzA) >= 1000L)) && (this.handler != null) && (this.yzB != null) && (this.yzB.isAlive()))
    {
      a locala = new a((byte)0);
      locala.vPf = paramArrayOfByte;
      locala.width = paramInt1;
      locala.height = paramInt2;
      paramArrayOfByte = Message.obtain();
      paramArrayOfByte.what = 233;
      paramArrayOfByte.obj = locala;
      this.handler.sendMessage(paramArrayOfByte);
      this.yzA = bt.HI();
    }
    AppMethodBeat.o(91075);
  }
  
  public final void start(String paramString)
  {
    AppMethodBeat.i(91072);
    try
    {
      this.hpB = paramString;
      dMM();
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
      this.yzA = -1L;
      if (this.yzB != null) {
        this.yzB.quit();
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
    byte[] vPf;
    int width;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector
 * JD-Core Version:    0.7.0.1
 */