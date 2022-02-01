package com.tencent.mm.plugin.scanner.ui.widget;

import android.graphics.Bitmap;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.qbar.ScanDecodeFrameData;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class ScanCodeMaskView$j
  implements Runnable
{
  ScanCodeMaskView$j(ScanCodeMaskView paramScanCodeMaskView, ScanDecodeFrameData paramScanDecodeFrameData) {}
  
  public final void run()
  {
    AppMethodBeat.i(170053);
    long l = System.currentTimeMillis();
    ScanCodeMaskView.a(this.xjJ, ScanCodeMaskView.a(this.xjJ, this.xjU));
    ac.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    ap.f((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(170052);
        if ((!ScanCodeMaskView.o(this.xjV.xjJ)) && (ScanCodeMaskView.n(this.xjV.xjJ) != null))
        {
          Object localObject = ScanCodeMaskView.n(this.xjV.xjJ);
          if (localObject == null) {
            k.fOy();
          }
          if (!((Bitmap)localObject).isRecycled())
          {
            ScanCodeMaskView.p(this.xjV.xjJ).setImageBitmap(ScanCodeMaskView.n(this.xjV.xjJ));
            ScanCodeMaskView.p(this.xjV.xjJ).setVisibility(0);
            ScanCodeMaskView.p(this.xjV.xjJ).setAlpha(0.0F);
            localObject = ScanCodeMaskView.p(this.xjV.xjJ).animate();
            if (localObject != null) {
              ((ViewPropertyAnimator)localObject).cancel();
            }
            localObject = ScanCodeMaskView.p(this.xjV.xjJ).animate();
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