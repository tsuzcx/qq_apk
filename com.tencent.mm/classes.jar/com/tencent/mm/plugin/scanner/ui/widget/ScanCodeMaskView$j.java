package com.tencent.mm.plugin.scanner.ui.widget;

import android.graphics.Bitmap;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.qbar.ScanDecodeFrameData;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class ScanCodeMaskView$j
  implements Runnable
{
  ScanCodeMaskView$j(ScanCodeMaskView paramScanCodeMaskView, ScanDecodeFrameData paramScanDecodeFrameData) {}
  
  public final void run()
  {
    AppMethodBeat.i(170053);
    long l = System.currentTimeMillis();
    ScanCodeMaskView.a(this.CRD, ScanCodeMaskView.a(this.CRD, this.CRN));
    Log.i("MicroMsg.ScanCodeMaskView", "alvinluo getFrameBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    MMHandlerThread.postToMainThread((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(170052);
        if ((!ScanCodeMaskView.o(this.CRO.CRD)) && (ScanCodeMaskView.n(this.CRO.CRD) != null))
        {
          Object localObject = ScanCodeMaskView.n(this.CRO.CRD);
          if (localObject == null) {
            p.hyc();
          }
          if (!((Bitmap)localObject).isRecycled())
          {
            ScanCodeMaskView.p(this.CRO.CRD).setImageBitmap(ScanCodeMaskView.n(this.CRO.CRD));
            ScanCodeMaskView.p(this.CRO.CRD).setVisibility(0);
            ScanCodeMaskView.p(this.CRO.CRD).setAlpha(0.0F);
            localObject = ScanCodeMaskView.p(this.CRO.CRD).animate();
            if (localObject != null) {
              ((ViewPropertyAnimator)localObject).cancel();
            }
            localObject = ScanCodeMaskView.p(this.CRO.CRD).animate();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView.j
 * JD-Core Version:    0.7.0.1
 */