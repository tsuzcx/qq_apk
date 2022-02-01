package com.tencent.mm.plugin.scanner.util;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

public class ScanCameraLightDetector
{
  public static final ScanCameraLightDetector yPx;
  private aq handler;
  private String hsp;
  private float roV = -1.0F;
  private long yPA = -1L;
  private HandlerThread yPB;
  private final int yPy = 2;
  private int yPz;
  
  static
  {
    AppMethodBeat.i(91077);
    yPx = new ScanCameraLightDetector();
    AppMethodBeat.o(91077);
  }
  
  private static native int calcLumNative(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private void dQf()
  {
    AppMethodBeat.i(91074);
    ae.i("MicroMsg.ScanCameraLightDetector", "alvinluo initDetectThread");
    stop();
    this.yPB = d.hh("ScanCameraLightDetector_detectThread", 5);
    this.yPB.start();
    this.handler = new aq(this.yPB.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(91071);
        if (paramAnonymousMessage.what == 233)
        {
          paramAnonymousMessage = (ScanCameraLightDetector.a)paramAnonymousMessage.obj;
          if (paramAnonymousMessage != null)
          {
            long l = bu.HQ();
            boolean bool = ScanCameraLightDetector.E(paramAnonymousMessage.wbi, paramAnonymousMessage.width, paramAnonymousMessage.height);
            ae.i("MicroMsg.ScanCameraLightDetector", "isYuvDark: %s, currentLight: %s, used %sms", new Object[] { Boolean.valueOf(bool), Float.valueOf(ScanCameraLightDetector.a(ScanCameraLightDetector.this)), Long.valueOf(bu.aO(l)) });
            if (bool)
            {
              ae.i("MicroMsg.ScanCameraLightDetector", "is dark now");
              ScanCameraLightDetector.b(ScanCameraLightDetector.this);
              if ((ScanCameraLightDetector.c(ScanCameraLightDetector.this).equals("continuous-video")) && (ScanCameraLightDetector.d(ScanCameraLightDetector.this) < 2))
              {
                AppMethodBeat.o(91071);
                return;
              }
              ScanCameraLightDetector.e(ScanCameraLightDetector.this);
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(91069);
                  sl localsl = new sl();
                  localsl.dIb.dIc = true;
                  a.IvT.l(localsl);
                  AppMethodBeat.o(91069);
                }
              });
              AppMethodBeat.o(91071);
              return;
            }
            ae.i("MicroMsg.ScanCameraLightDetector", "not dark");
            ScanCameraLightDetector.e(ScanCameraLightDetector.this);
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(91070);
                sl localsl = new sl();
                localsl.dIb.dIc = false;
                a.IvT.l(localsl);
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
  
  public final void D(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91075);
    if (((this.yPA < 0L) || (bu.aO(this.yPA) >= 1000L)) && (this.handler != null) && (this.yPB != null) && (this.yPB.isAlive()))
    {
      a locala = new a((byte)0);
      locala.wbi = paramArrayOfByte;
      locala.width = paramInt1;
      locala.height = paramInt2;
      paramArrayOfByte = Message.obtain();
      paramArrayOfByte.what = 233;
      paramArrayOfByte.obj = locala;
      this.handler.sendMessage(paramArrayOfByte);
      this.yPA = bu.HQ();
    }
    AppMethodBeat.o(91075);
  }
  
  public final void start(String paramString)
  {
    AppMethodBeat.i(91072);
    try
    {
      this.hsp = paramString;
      dQf();
      AppMethodBeat.o(91072);
      return;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.ScanCameraLightDetector", paramString, "start error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(91072);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(91073);
    try
    {
      this.yPA = -1L;
      if (this.yPB != null) {
        this.yPB.quit();
      }
      AppMethodBeat.o(91073);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.ScanCameraLightDetector", localException, "stop error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(91073);
    }
  }
  
  final class a
  {
    int height;
    byte[] wbi;
    int width;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector
 * JD-Core Version:    0.7.0.1
 */