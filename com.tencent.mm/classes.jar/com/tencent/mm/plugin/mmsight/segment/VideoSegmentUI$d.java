package com.tencent.mm.plugin.mmsight.segment;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class VideoSegmentUI$d
  implements Runnable
{
  private VideoSegmentUI$d(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(55052);
    for (;;)
    {
      try
      {
        bool1 = VideoSegmentUI.o(this.oME).await(5L, TimeUnit.SECONDS);
        if ((!bool1) || (VideoSegmentUI.t(this.oME)) || (this.oME.isFinishing()) || (VideoSegmentUI.u(this.oME) == null) || (!VideoSegmentUI.u(this.oME).isValid()))
        {
          boolean bool3 = VideoSegmentUI.t(this.oME);
          boolean bool4 = this.oME.isFinishing();
          if (VideoSegmentUI.u(this.oME) != null) {
            break label336;
          }
          bool2 = true;
          ab.w("MicroMsg.VideoSegmentUI", "Waiting Prepared error result[%b] needFinish[%b] isFinishing[%b] mSurface is null[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool2) });
          this.oME.finish();
          AppMethodBeat.o(55052);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        ab.e("MicroMsg.VideoSegmentUI", "count down latch error %s", new Object[] { localInterruptedException });
        boolean bool1 = false;
        continue;
        if (VideoSegmentUI.d(this.oME) != null)
        {
          VideoSegmentUI.d(this.oME).a(null);
          VideoSegmentUI.d(this.oME).a(null);
          VideoSegmentUI.d(this.oME).release();
          VideoSegmentUI.v(this.oME);
        }
        try
        {
          VideoSegmentUI.a(this.oME, VideoSegmentUI.u(this.oME));
          VideoSegmentUI.d(this.oME).setSurface(VideoSegmentUI.u(this.oME));
          al.d(new VideoSegmentUI.d.1(this));
          AppMethodBeat.o(55052);
          return;
        }
        catch (IOException localIOException)
        {
          ab.printErrStackTrace("MicroMsg.VideoSegmentUI", localIOException, "init segmentPlayer second time %s", new Object[] { localIOException.getMessage() });
          this.oME.finish();
          AppMethodBeat.o(55052);
          return;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.VideoSegmentUI", localException, "Finished when init", new Object[0]);
        this.oME.finish();
        AppMethodBeat.o(55052);
        return;
      }
      label336:
      boolean bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.d
 * JD-Core Version:    0.7.0.1
 */