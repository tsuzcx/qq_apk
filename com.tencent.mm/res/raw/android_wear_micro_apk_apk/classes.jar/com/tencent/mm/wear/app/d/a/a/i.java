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
    int i = AudioTrack.getMinBufferSize(h.a(this.ahh), 2, 2) * 2;
    ??? = new byte[i];
    short s = (short)(h.a(this.ahh) * 20 / 1000);
    d.d("MicroMsg.SilkPlayer", "frameLen: %d, playBufferSize: %d", new Object[] { Short.valueOf(s), Integer.valueOf(i) });
    for (;;)
    {
      if (h.b(this.ahh) == f.agU) {
        synchronized (h.nu())
        {
          if (h.nv() != h.c(this.ahh))
          {
            d.c("MicroMsg.SilkPlayer", "[%d] diff id, useDeocder: %d", new Object[] { Integer.valueOf(h.c(this.ahh)), Integer.valueOf(h.nv()) });
            h.a(this.ahh, h.d(this.ahh));
          }
          i = MediaRecorder.SilkDoDec((byte[])???, s, MediaRecorder.Xa);
          d.c("MicroMsg.SilkPlayer", "SilkDoDec ret %d", new Object[] { Integer.valueOf(i) });
          if (i <= 0) {
            h.a(this.ahh, f.agV);
          }
        }
      }
      try
      {
        Thread.sleep(1000L);
        synchronized (h.nu())
        {
          label197:
          if (h.nv() == h.c(this.ahh))
          {
            MediaRecorder.SilkDecUnInit(MediaRecorder.Xa);
            d.c("MicroMsg.SilkPlayer", "[%d] SilkDecUnInit", new Object[] { Integer.valueOf(h.c(this.ahh)) });
            h.nw();
          }
          h.f(this.ahh);
          this.ahh.h(h.g(this.ahh));
          return;
          arrayOfByte = finally;
          throw arrayOfByte;
          try
          {
            h.e(this.ahh).write(arrayOfByte, 0, s * 2);
          }
          catch (Exception localException) {}
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        break label197;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.a.i
 * JD-Core Version:    0.7.0.1
 */