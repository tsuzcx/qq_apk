package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

public class MusicItemLayout
  extends LinearLayout
{
  private GestureDetector nwZ;
  
  public MusicItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63205);
    initView();
    AppMethodBeat.o(63205);
  }
  
  public MusicItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63206);
    initView();
    AppMethodBeat.o(63206);
  }
  
  private void initView()
  {
    AppMethodBeat.i(63207);
    this.nwZ = new GestureDetector(getContext(), new a((byte)0));
    AppMethodBeat.o(63207);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(63208);
    b.a locala = (b.a)getTag();
    if (!locala.goO())
    {
      if ((locala.LPz.getX() > paramMotionEvent.getX()) || (paramMotionEvent.getX() > locala.LPz.getX() + locala.LPz.getMeasuredWidth()) || (locala.LPz.getY() > paramMotionEvent.getY())) {
        break label125;
      }
      float f1 = paramMotionEvent.getY();
      float f2 = locala.LPz.getY();
      if (f1 > locala.LPz.getMeasuredHeight() + f2) {
        break label125;
      }
    }
    label125:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(63208);
      return false;
    }
    AppMethodBeat.o(63208);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(63209);
    GestureDetector localGestureDetector = this.nwZ;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aYi(), "com/tencent/mm/plugin/music/ui/MusicItemLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/plugin/music/ui/MusicItemLayout", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(63209);
    return true;
  }
  
  final class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(270934);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/MusicItemLayout$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/MusicItemLayout$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(270934);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(270930);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/MusicItemLayout$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/music/ui/MusicItemLayout$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(270930);
      return bool;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(270923);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/MusicItemLayout$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/MusicItemLayout$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(270923);
    }
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(63203);
      if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
      {
        paramMotionEvent1 = (b.a)MusicItemLayout.this.getTag();
        if (paramFloat2 <= 0.0F) {
          break label47;
        }
        paramMotionEvent1.goQ();
      }
      for (;;)
      {
        AppMethodBeat.o(63203);
        return false;
        label47:
        paramMotionEvent1.goP();
      }
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(63204);
      Object localObject = new b();
      ((b)localObject).cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/MusicItemLayout$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, ((b)localObject).aYj());
      localObject = (b.a)MusicItemLayout.this.getTag();
      if (((b.a)localObject).goO()) {
        if ((paramMotionEvent.getY() <= ((b.a)localObject).LPy.getMeasuredHeight()) && (paramMotionEvent.getY() > 100.0F)) {
          ((b.a)localObject).goR();
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/music/ui/MusicItemLayout$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(63204);
        return false;
        if ((paramMotionEvent.getY() >= ((b.a)localObject).LPB.getY() - 100.0F) && (paramMotionEvent.getY() < ((b.a)localObject).LPB.getMeasuredHeight() + ((b.a)localObject).LPB.getY())) {
          ((b.a)localObject).goR();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicItemLayout
 * JD-Core Version:    0.7.0.1
 */