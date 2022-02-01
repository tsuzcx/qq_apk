package com.tencent.mm.plugin.scanner.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.am;
import com.tencent.mm.sdk.platformtools.Log;

final class ScanUIRectView$7
  extends GestureDetector.SimpleOnGestureListener
{
  ScanUIRectView$7(ScanUIRectView paramScanUIRectView) {}
  
  public final boolean onContextClick(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(314552);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$16", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    boolean bool = super.onContextClick(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$16", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(314552);
    return bool;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(314539);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$16", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    Log.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramMotionEvent.getActionIndex()), Float.valueOf(paramMotionEvent.getX(paramMotionEvent.getActionIndex())), Float.valueOf(paramMotionEvent.getY(paramMotionEvent.getActionIndex())) });
    ((com.tencent.scanlib.a.a)ScanUIRectView.G(this.Pcg)).aHd(5);
    am.J(ScanUIRectView.H(this.Pcg), 3, ScanUIRectView.r(this.Pcg));
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$16", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(314539);
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(314545);
    Log.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Boolean.valueOf(ScanUIRectView.I(this.Pcg)), Boolean.valueOf(ScanUIRectView.J(this.Pcg)), Boolean.valueOf(ScanUIRectView.K(this.Pcg)) });
    if ((!ScanUIRectView.K(this.Pcg)) && (ScanUIRectView.J(this.Pcg)) && (Math.abs(paramFloat1) > Math.abs(paramFloat2)))
    {
      if ((paramFloat1 >= -1200.0F) || (!ScanUIRectView.I(this.Pcg))) {
        break label168;
      }
      if (ScanUIRectView.L(this.Pcg) != null) {
        ScanUIRectView.L(this.Pcg).gTx();
      }
      ScanUIRectView.b(this.Pcg, false);
    }
    for (;;)
    {
      boolean bool = super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      AppMethodBeat.o(314545);
      return bool;
      label168:
      if ((paramFloat1 > 1200.0F) && (ScanUIRectView.I(this.Pcg)))
      {
        if (ScanUIRectView.L(this.Pcg) != null) {
          ScanUIRectView.L(this.Pcg).gTy();
        }
        ScanUIRectView.b(this.Pcg, false);
      }
    }
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(314550);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$16", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    super.onLongPress(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$16", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(314550);
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(314547);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$16", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    boolean bool = super.onSingleTapUp(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$16", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(314547);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanUIRectView.7
 * JD-Core Version:    0.7.0.1
 */