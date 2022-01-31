package com.tencent.mm.plugin.mmsight.segment;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class h$a
  implements Runnable
{
  volatile int eJK;
  int eJL;
  boolean eJM;
  Object eJN = new Object();
  
  private h$a(h paramh) {}
  
  public final void run()
  {
    if (this.eJL == -1)
    {
      this.eJL = Process.myTid();
      Process.setThreadPriority(Process.myTid(), -2);
      y.i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", new Object[] { Integer.valueOf(this.eJL) });
    }
    this.eJK = 0;
    for (;;)
    {
      int i;
      synchronized (this.eJN)
      {
        if (this.eJM) {
          break label183;
        }
        l = bk.UZ();
        y.i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
        i = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.eJK), false);
        y.i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(bk.cp(l)), Integer.valueOf(this.eJK), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
        int j = this.eJK;
        if (i != j) {}
      }
      try
      {
        Thread.sleep(20L);
        this.eJK = i;
        continue;
        localObject2 = finally;
        throw localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.MediaCodecFFMpegTranscoder", "thread sleep error");
        }
      }
    }
    label183:
    long l = bk.UZ();
    this.eJK = MP4MuxerJNI.triggerEncodeForSegment(this.eJK, true);
    y.i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[] { Long.valueOf(bk.cp(l)), Integer.valueOf(this.eJK), Long.valueOf(Thread.currentThread().getId()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.h.a
 * JD-Core Version:    0.7.0.1
 */