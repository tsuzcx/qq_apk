package com.tencent.mm.plugin.mmsight.segment;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class h$a
  implements Runnable
{
  volatile int eUK;
  boolean fZn;
  int fdk;
  Object fdy;
  
  private h$a(h paramh)
  {
    AppMethodBeat.i(3654);
    this.fdy = new Object();
    AppMethodBeat.o(3654);
  }
  
  public final void run()
  {
    AppMethodBeat.i(3655);
    if (this.fdk == -1)
    {
      this.fdk = Process.myTid();
      Process.setThreadPriority(Process.myTid(), -2);
      ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.fdk) });
    }
    this.eUK = 0;
    for (;;)
    {
      int i;
      synchronized (this.fdy)
      {
        if (this.fZn) {
          break label195;
        }
        l = bo.yB();
        ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
        i = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.eUK), false);
        ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(this.eUK), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
        int j = this.eUK;
        if (i != j) {}
      }
      try
      {
        Thread.sleep(20L);
        this.eUK = i;
        continue;
        localObject2 = finally;
        AppMethodBeat.o(3655);
        throw localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.MediaCodecFFMpegTranscoder", "thread sleep error");
        }
      }
    }
    label195:
    long l = bo.yB();
    this.eUK = MP4MuxerJNI.triggerEncodeForSegment(this.eUK, true);
    ab.i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bo.av(l)), Integer.valueOf(this.eUK), Long.valueOf(Thread.currentThread().getId()) });
    AppMethodBeat.o(3655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.h.a
 * JD-Core Version:    0.7.0.1
 */