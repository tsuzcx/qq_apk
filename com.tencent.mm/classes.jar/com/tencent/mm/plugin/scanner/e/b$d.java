package com.tencent.mm.plugin.scanner.e;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$attachImageView$1", "Landroid/view/GestureDetector$OnDoubleTapListener;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "onSingleTapConfirmed", "plugin-scan_release"})
public final class b$d
  implements GestureDetector.OnDoubleTapListener
{
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(240484);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramMotionEvent);
    a.b("com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$attachImageView$1", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    boolean bool = this.CIF.onDoubleTap(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/scanner/ocr/ImageGalleryImageOCRHelper$attachImageView$1", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(240484);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.b.d
 * JD-Core Version:    0.7.0.1
 */