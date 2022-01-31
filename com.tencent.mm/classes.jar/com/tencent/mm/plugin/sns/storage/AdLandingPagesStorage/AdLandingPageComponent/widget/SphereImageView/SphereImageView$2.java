package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SphereImageView$2
  implements GestureDetector.OnGestureListener
{
  SphereImageView$2(SphereImageView paramSphereImageView) {}
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(145405);
    if (this.rBr.rBm != null)
    {
      this.rBr.rBm.onLongClick(this.rBr);
      ab.i("SphereImageView.SphereView", "onLongPress, hash=" + hashCode());
    }
    AppMethodBeat.o(145405);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(145404);
    if (this.rBr.rBl != null)
    {
      this.rBr.rBl.onClick(this.rBr);
      ab.i("SphereImageView.SphereView", "onClick, hash=" + hashCode());
    }
    AppMethodBeat.o(145404);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView.2
 * JD-Core Version:    0.7.0.1
 */