package com.tencent.mm.plugin.scanner.ui.widget;

import android.graphics.Bitmap;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.qbar.ScanDecodeFrameData;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
final class ScanCodeMaskView$j
  implements Runnable
{
  ScanCodeMaskView$j(ScanCodeMaskView paramScanCodeMaskView, ScanDecodeFrameData paramScanDecodeFrameData) {}
  
  public final void run()
  {
    AppMethodBeat.i(170053);
    long l = System.currentTimeMillis();
    ScanCodeMaskView.a(this.yxL, ScanCodeMaskView.a(this.yxL, this.yxW));
    ad.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    aq.f((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(170052);
        if ((!ScanCodeMaskView.o(this.yxX.yxL)) && (ScanCodeMaskView.n(this.yxX.yxL) != null))
        {
          Object localObject = ScanCodeMaskView.n(this.yxX.yxL);
          if (localObject == null) {
            p.gfZ();
          }
          if (!((Bitmap)localObject).isRecycled())
          {
            ScanCodeMaskView.p(this.yxX.yxL).setImageBitmap(ScanCodeMaskView.n(this.yxX.yxL));
            ScanCodeMaskView.p(this.yxX.yxL).setVisibility(0);
            ScanCodeMaskView.p(this.yxX.yxL).setAlpha(0.0F);
            localObject = ScanCodeMaskView.p(this.yxX.yxL).animate();
            if (localObject != null) {
              ((ViewPropertyAnimator)localObject).cancel();
            }
            localObject = ScanCodeMaskView.p(this.yxX.yxL).animate();
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).alpha(1.0F);
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
                if (localObject != null)
                {
                  ((ViewPropertyAnimator)localObject).start();
                  AppMethodBeat.o(170052);
                  return;
                }
              }
            }
          }
        }
        AppMethodBeat.o(170052);
      }
    });
    AppMethodBeat.o(170053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView.j
 * JD-Core Version:    0.7.0.1
 */