package com.tencent.mm.plugin.mmsight.segment;

import android.view.Surface;
import com.tencent.mm.plugin.mmsight.segment.a.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class VideoSegmentUI$d
  implements Runnable
{
  private VideoSegmentUI$d(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        bool1 = VideoSegmentUI.o(this.mnw).await(5L, TimeUnit.SECONDS);
        if ((!bool1) || (VideoSegmentUI.t(this.mnw)) || (this.mnw.isFinishing()) || (VideoSegmentUI.u(this.mnw) == null) || (!VideoSegmentUI.u(this.mnw).isValid()))
        {
          boolean bool3 = VideoSegmentUI.t(this.mnw);
          boolean bool4 = this.mnw.isFinishing();
          if (VideoSegmentUI.u(this.mnw) != null) {
            break label311;
          }
          bool2 = true;
          y.w("MicroMsg.VideoSegmentUI", "Waiting Prepared error result[%b] needFinish[%b] isFinishing[%b] mSurface is null[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool2) });
          this.mnw.finish();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        y.e("MicroMsg.VideoSegmentUI", "count down latch error %s", new Object[] { localInterruptedException });
        boolean bool1 = false;
        continue;
        if (VideoSegmentUI.d(this.mnw) != null)
        {
          VideoSegmentUI.d(this.mnw).a(null);
          VideoSegmentUI.d(this.mnw).a(null);
          VideoSegmentUI.d(this.mnw).release();
          VideoSegmentUI.v(this.mnw);
        }
      }
      catch (Exception localException)
      {
        try
        {
          VideoSegmentUI.a(this.mnw, VideoSegmentUI.u(this.mnw));
          VideoSegmentUI.d(this.mnw).setSurface(VideoSegmentUI.u(this.mnw));
          ai.d(new VideoSegmentUI.d.1(this));
          return;
        }
        catch (IOException localIOException)
        {
          y.printErrStackTrace("MicroMsg.VideoSegmentUI", localIOException, "init segmentPlayer second time %s", new Object[] { localIOException.getMessage() });
          this.mnw.finish();
          return;
        }
        localException = localException;
        y.printErrStackTrace("MicroMsg.VideoSegmentUI", localException, "Finished when init", new Object[0]);
        this.mnw.finish();
        return;
      }
      label311:
      boolean bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.d
 * JD-Core Version:    0.7.0.1
 */