package com.tencent.mm.plugin.music.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

final class MusicItemLayout$a
  extends GestureDetector.SimpleOnGestureListener
{
  private MusicItemLayout$a(MusicItemLayout paramMusicItemLayout) {}
  
  public final boolean onContextClick(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219879);
    b localb = new b();
    localb.bm(paramMotionEvent);
    a.b("com/tencent/mm/plugin/music/ui/MusicItemLayout$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    boolean bool = super.onContextClick(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/music/ui/MusicItemLayout$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(219879);
    return bool;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219878);
    b localb = new b();
    localb.bm(paramMotionEvent);
    a.b("com/tencent/mm/plugin/music/ui/MusicItemLayout$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    boolean bool = super.onDoubleTap(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/music/ui/MusicItemLayout$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(219878);
    return bool;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219877);
    b localb = new b();
    localb.bm(paramMotionEvent);
    a.b("com/tencent/mm/plugin/music/ui/MusicItemLayout$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    super.onLongPress(paramMotionEvent);
    a.a(this, "com/tencent/mm/plugin/music/ui/MusicItemLayout$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(219877);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(63203);
    if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
    {
      paramMotionEvent1 = (b.a)this.Ang.getTag();
      if (paramFloat2 <= 0.0F) {
        break label47;
      }
      paramMotionEvent1.evj();
    }
    for (;;)
    {
      AppMethodBeat.o(63203);
      return false;
      label47:
      paramMotionEvent1.evi();
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(63204);
    Object localObject = new b();
    ((b)localObject).bm(paramMotionEvent);
    a.b("com/tencent/mm/plugin/music/ui/MusicItemLayout$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, ((b)localObject).axR());
    localObject = (b.a)this.Ang.getTag();
    if (((b.a)localObject).evh()) {
      if ((paramMotionEvent.getY() <= ((b.a)localObject).Ans.getMeasuredHeight()) && (paramMotionEvent.getY() > 100.0F)) {
        ((b.a)localObject).evk();
      }
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/plugin/music/ui/MusicItemLayout$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(63204);
      return false;
      if ((paramMotionEvent.getY() >= ((b.a)localObject).Anv.getY() - 100.0F) && (paramMotionEvent.getY() < ((b.a)localObject).Anv.getMeasuredHeight() + ((b.a)localObject).Anv.getY())) {
        ((b.a)localObject).evk();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicItemLayout.a
 * JD-Core Version:    0.7.0.1
 */