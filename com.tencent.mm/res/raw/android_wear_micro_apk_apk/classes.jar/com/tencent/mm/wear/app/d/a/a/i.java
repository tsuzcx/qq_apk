package com.tencent.mm.wear.app.d.a.a;

import android.media.AudioTrack;
import android.os.Process;
import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.wear.a.c.d;

final class i
  implements Runnable
{
  private i(h paramh) {}
  
  public final void run()
  {
    Process.setThreadPriority(-16);
    int i = AudioTrack.getMinBufferSize(h.a(this.adF), 2, 2) * 2;
    ??? = new byte[i];
    short s = (short)(h.a(this.adF) * 20 / 1000);
    d.e("MicroMsg.SilkPlayer", "frameLen: %d, playBufferSize: %d", new Object[] { Short.valueOf(s), Integer.valueOf(i) });
    for (;;)
    {
      if (h.b(this.adF) == f.ads) {
        synchronized (h.mI())
        {
          if (h.mJ() != h.c(this.adF))
          {
            d.c("MicroMsg.SilkPlayer", "[%d] diff id, useDeocder: %d", new Object[] { Integer.valueOf(h.c(this.adF)), Integer.valueOf(h.mJ()) });
            h.a(this.adF, h.d(this.adF));
          }
          i = MediaRecorder.SilkDoDec((byte[])???, s);
          d.c("MicroMsg.SilkPlayer", "SilkDoDec ret %d", new Object[] { Integer.valueOf(i) });
          if (i <= 0) {
            h.a(this.adF, f.adt);
          }
        }
      }
      try
      {
        Thread.sleep(1000L);
        synchronized (h.mI())
        {
          label194:
          if (h.mJ() == h.c(this.adF))
          {
            MediaRecorder.SilkDecUnInit();
            d.c("MicroMsg.SilkPlayer", "[%d] SilkDecUnInit", new Object[] { Integer.valueOf(h.c(this.adF)) });
            h.mK();
          }
          h.f(this.adF);
          this.adF.g(h.g(this.adF));
          return;
          arrayOfByte = finally;
          throw arrayOfByte;
          try
          {
            h.e(this.adF).write(arrayOfByte, 0, s * 2);
          }
          catch (Exception localException) {}
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label194;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.a.i
 * JD-Core Version:    0.7.0.1
 */