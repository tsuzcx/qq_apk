package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class VideoSegmentUI$7
  implements Runnable
{
  VideoSegmentUI$7(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void run()
  {
    bool = true;
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        VideoSegmentUI.d(this.mnw).stop();
        int i = VideoSegmentUI.e(this.mnw);
        long l1 = bk.UZ();
        VideoSegmentUI.i(this.mnw).b(VideoSegmentUI.f(this.mnw), VideoSegmentUI.g(this.mnw), VideoSegmentUI.h(this.mnw));
        localObject1 = VideoSegmentUI.i(this.mnw);
        long l2 = (VideoSegmentUI.j(this.mnw).bjK() * i);
        float f = VideoSegmentUI.j(this.mnw).bjL();
        i = ((f)localObject1).E(l2, (i * f));
        if (i < 0)
        {
          y.i("MicroMsg.VideoSegmentUI", "clip failed! %s", new Object[] { Integer.valueOf(i) });
          ai.d(new VideoSegmentUI.7.1(this));
          return;
        }
        Bitmap localBitmap = d.ng(VideoSegmentUI.g(this.mnw));
        if (localBitmap == null) {
          continue;
        }
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        localObject1 = localBitmap;
        if (d.a(localBitmap.getWidth(), localBitmap.getHeight(), VideoSegmentUI.h(this.mnw).ejZ, localPInt1, localPInt2)) {
          localObject1 = Bitmap.createScaledBitmap(localBitmap, localPInt1.value, localPInt2.value, true);
        }
        y.i("MicroMsg.VideoSegmentUI", "getBitmap size = [%d, %d]", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
        com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject1, 80, Bitmap.CompressFormat.JPEG, VideoSegmentUI.l(this.mnw), true);
        y.i("MicroMsg.VideoSegmentUI", "create video thumb. use %dms", new Object[] { Long.valueOf(bk.cp(l1)) });
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        Object localObject1 = localException.getMessage();
        y.printErrStackTrace("MicroMsg.VideoSegmentUI", localException, "UnexpectedException when clip : [%s]", new Object[] { localException.getMessage() });
        bool = false;
        continue;
      }
      ai.d(new VideoSegmentUI.7.2(this, bool, (String)localObject1));
      return;
      y.e("MicroMsg.VideoSegmentUI", "getVideoThumb failed!");
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.7
 * JD-Core Version:    0.7.0.1
 */