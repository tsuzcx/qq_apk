package com.tencent.mm.plugin.scanner.f;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$attachImageView$1", "Landroid/view/GestureDetector$OnDoubleTapListener;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onSingleTapConfirmed", "plugin-scan_release"})
public final class b$b
  implements GestureDetector.OnDoubleTapListener
{
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(218474);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramMotionEvent);
    a.c("com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$attachImageView$1", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    boolean bool = this.INw.onDoubleTap(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$attachImageView$1", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(218474);
    return bool;
  }
  
  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.b.b
 * JD-Core Version:    0.7.0.1
 */