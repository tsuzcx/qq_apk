package com.tencent.mm.plugin.scanner.util;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ti;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public class ScanCameraLightDetector
{
  public static final ScanCameraLightDetector CTx;
  private long CTA = -1L;
  private HandlerThread CTB;
  private final int CTy = 2;
  private int CTz;
  private MMHandler handler;
  private String imR;
  private float sQv = -1.0F;
  
  static
  {
    AppMethodBeat.i(91077);
    CTx = new ScanCameraLightDetector();
    AppMethodBeat.o(91077);
  }
  
  private static native int calcLumNative(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private void eRS()
  {
    AppMethodBeat.i(91074);
    Log.i("MicroMsg.ScanCameraLightDetector", "alvinluo initDetectThread");
    stop();
    this.CTB = d.hB("ScanCameraLightDetector_detectThread", 5);
    this.CTB.start();
    this.handler = new MMHandler(this.CTB.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(91071);
        if (paramAnonymousMessage.what == 233)
        {
          paramAnonymousMessage = (ScanCameraLightDetector.a)paramAnonymousMessage.obj;
          if (paramAnonymousMessage != null)
          {
            long l = Util.currentTicks();
            boolean bool = ScanCameraLightDetector.O(paramAnonymousMessage.zvl, paramAnonymousMessage.width, paramAnonymousMessage.height);
            Log.i("MicroMsg.ScanCameraLightDetector", "isYuvDark: %s, currentLight: %s, used %sms", new Object[] { Boolean.valueOf(bool), Float.valueOf(ScanCameraLightDetector.a(ScanCameraLightDetector.this)), Long.valueOf(Util.ticksToNow(l)) });
            if (bool)
            {
              Log.i("MicroMsg.ScanCameraLightDetector", "is dark now");
              ScanCameraLightDetector.b(ScanCameraLightDetector.this);
              if ((ScanCameraLightDetector.c(ScanCameraLightDetector.this).equals("continuous-video")) && (ScanCameraLightDetector.d(ScanCameraLightDetector.this) < 2))
              {
                AppMethodBeat.o(91071);
                return;
              }
              ScanCameraLightDetector.e(ScanCameraLightDetector.this);
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(91069);
                  ti localti = new ti();
                  localti.dZN.dZO = true;
                  EventCenter.instance.publish(localti);
                  AppMethodBeat.o(91069);
                }
              });
              AppMethodBeat.o(91071);
              return;
            }
            Log.i("MicroMsg.ScanCameraLightDetector", "not dark");
            ScanCameraLightDetector.e(ScanCameraLightDetector.this);
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(91070);
                ti localti = new ti();
                localti.dZN.dZO = false;
                EventCenter.instance.publish(localti);
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
  
  public final void N(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91075);
    if (((this.CTA < 0L) || (Util.ticksToNow(this.CTA) >= 1000L)) && (this.handler != null) && (this.CTB != null) && (this.CTB.isAlive()))
    {
      a locala = new a((byte)0);
      locala.zvl = paramArrayOfByte;
      locala.width = paramInt1;
      locala.height = paramInt2;
      paramArrayOfByte = Message.obtain();
      paramArrayOfByte.what = 233;
      paramArrayOfByte.obj = locala;
      this.handler.sendMessage(paramArrayOfByte);
      this.CTA = Util.currentTicks();
    }
    AppMethodBeat.o(91075);
  }
  
  public final void start(String paramString)
  {
    AppMethodBeat.i(91072);
    try
    {
      this.imR = paramString;
      eRS();
      AppMethodBeat.o(91072);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.ScanCameraLightDetector", paramString, "start error: %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(91072);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(91073);
    try
    {
      this.CTA = -1L;
      if (this.CTB != null) {
        this.CTB.quit();
      }
      AppMethodBeat.o(91073);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanCameraLightDetector", localException, "stop error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(91073);
    }
  }
  
  final class a
  {
    int height;
    int width;
    byte[] zvl;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector
 * JD-Core Version:    0.7.0.1
 */