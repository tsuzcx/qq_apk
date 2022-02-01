package com.tencent.mm.plugin.music.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class LyricView$a
  extends GestureDetector.SimpleOnGestureListener
{
  private LyricView$a(LyricView paramLyricView) {}
  
  public final boolean onContextClick(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192489);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    boolean bool = super.onContextClick(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(192489);
    return bool;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192488);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    boolean bool = super.onDoubleTap(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(192488);
    return bool;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(63181);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
    paramMotionEvent = LyricView.a(this.wmW, paramMotionEvent.getX(), paramMotionEvent.getY());
    if (!bt.isNullOrNil(paramMotionEvent))
    {
      f.dtg().setPrimaryClip(ClipData.newPlainText("MicroMsg.Music", paramMotionEvent));
      Toast.makeText(this.wmW.getContext(), this.wmW.getContext().getString(2131761463, new Object[] { paramMotionEvent }), 0).show();
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(63181);
      return;
      ad.i("MicroMsg.Music.LyricView", "onLongPress not found sentence");
    }
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(192487);
    b localb = new b();
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    boolean bool = super.onSingleTapUp(paramMotionEvent);
    a.a(bool, this, "com/tencent/mm/plugin/music/ui/LyricView$LongClickGestureDetector", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(192487);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.LyricView.a
 * JD-Core Version:    0.7.0.1
 */