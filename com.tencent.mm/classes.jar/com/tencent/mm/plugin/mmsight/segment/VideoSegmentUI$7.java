package com.tencent.mm.plugin.mmsight.segment;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class VideoSegmentUI$7
  implements Runnable
{
  VideoSegmentUI$7(VideoSegmentUI paramVideoSegmentUI) {}
  
  public final void run()
  {
    bool = true;
    AppMethodBeat.i(55038);
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        VideoSegmentUI.d(this.oME).stop();
        int i = VideoSegmentUI.e(this.oME);
        long l1 = bo.yB();
        VideoSegmentUI.i(this.oME).b(VideoSegmentUI.f(this.oME), VideoSegmentUI.g(this.oME), VideoSegmentUI.h(this.oME));
        localObject1 = VideoSegmentUI.i(this.oME);
        long l2 = (VideoSegmentUI.j(this.oME).bRy() * i);
        float f = VideoSegmentUI.j(this.oME).bRz();
        i = ((f)localObject1).Q(l2, (i * f));
        if (i < 0)
        {
          ab.i("MicroMsg.VideoSegmentUI", "clip failed! %s", new Object[] { Integer.valueOf(i) });
          al.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(55036);
              if (VideoSegmentUI.k(VideoSegmentUI.7.this.oME) != null) {
                VideoSegmentUI.k(VideoSegmentUI.7.this.oME).dismiss();
              }
              if (VideoSegmentUI.j(VideoSegmentUI.7.this.oME) != null) {
                VideoSegmentUI.j(VideoSegmentUI.7.this.oME).jo(false);
              }
              Toast.makeText(VideoSegmentUI.7.this.oME, 2131301571, 1).show();
              AppMethodBeat.o(55036);
            }
          });
          AppMethodBeat.o(55038);
          return;
        }
        Bitmap localBitmap = com.tencent.mm.plugin.mmsight.d.ut(VideoSegmentUI.g(this.oME));
        if (localBitmap == null) {
          continue;
        }
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        localObject1 = localBitmap;
        if (com.tencent.mm.plugin.mmsight.d.a(localBitmap.getWidth(), localBitmap.getHeight(), VideoSegmentUI.h(this.oME).fAg, localPInt1, localPInt2)) {
          localObject1 = Bitmap.createScaledBitmap(localBitmap, localPInt1.value, localPInt2.value, true);
        }
        ab.i("MicroMsg.VideoSegmentUI", "getBitmap size = [%d, %d]", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
        com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject1, 80, Bitmap.CompressFormat.JPEG, VideoSegmentUI.l(this.oME), true);
        ab.i("MicroMsg.VideoSegmentUI", "create video thumb. use %dms", new Object[] { Long.valueOf(bo.av(l1)) });
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        Object localObject1 = localException.getMessage();
        ab.printErrStackTrace("MicroMsg.VideoSegmentUI", localException, "UnexpectedException when clip : [%s]", new Object[] { localException.getMessage() });
        bool = false;
        continue;
      }
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55037);
          if (VideoSegmentUI.k(VideoSegmentUI.7.this.oME) != null) {
            VideoSegmentUI.k(VideoSegmentUI.7.this.oME).dismiss();
          }
          if (VideoSegmentUI.j(VideoSegmentUI.7.this.oME) != null) {
            VideoSegmentUI.j(VideoSegmentUI.7.this.oME).jo(false);
          }
          VideoSegmentUI.a(VideoSegmentUI.7.this.oME, bool, this.oMI);
          AppMethodBeat.o(55037);
        }
      });
      AppMethodBeat.o(55038);
      return;
      ab.e("MicroMsg.VideoSegmentUI", "getVideoThumb failed!");
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.7
 * JD-Core Version:    0.7.0.1
 */