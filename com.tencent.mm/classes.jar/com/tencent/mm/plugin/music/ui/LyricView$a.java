package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

final class LyricView$a
  extends GestureDetector.SimpleOnGestureListener
{
  private LyricView$a(LyricView paramLyricView) {}
  
  public final boolean onContextClick(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219872);
    b localb = new b();
    localb.bm(paramMotionEvent);
    a.b("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    boolean bool = super.onContextClick(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(219872);
    return bool;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219871);
    b localb = new b();
    localb.bm(paramMotionEvent);
    a.b("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    boolean bool = super.onDoubleTap(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(219871);
    return bool;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(63181);
    b localb = new b();
    localb.bm(paramMotionEvent);
    a.b("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    paramMotionEvent = LyricView.a(this.Anc, paramMotionEvent.getX(), paramMotionEvent.getY());
    if (!Util.isNullOrNil(paramMotionEvent))
    {
      ClipboardHelper.setText(MMApplicationContext.getContext(), "MicroMsg.Music", paramMotionEvent);
      Toast.makeText(this.Anc.getContext(), this.Anc.getContext().getString(2131763328, new Object[] { paramMotionEvent }), 0).show();
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(63181);
      return;
      Log.i("MicroMsg.Music.LyricView", "onLongPress not found sentence");
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(219870);
    b localb = new b();
    localb.bm(paramMotionEvent);
    a.b("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    a.a(false, this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(219870);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.LyricView.a
 * JD-Core Version:    0.7.0.1
 */