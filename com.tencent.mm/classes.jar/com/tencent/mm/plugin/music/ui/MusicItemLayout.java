package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

public class MusicItemLayout
  extends LinearLayout
{
  private GestureDetector hRv;
  
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
    this.hRv = new GestureDetector(getContext(), new a((byte)0));
    AppMethodBeat.o(63207);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(63208);
    b.a locala = (b.a)getTag();
    if (!locala.cVQ())
    {
      if ((locala.tYY.getX() > paramMotionEvent.getX()) || (paramMotionEvent.getX() > locala.tYY.getX() + locala.tYY.getMeasuredWidth()) || (locala.tYY.getY() > paramMotionEvent.getY())) {
        break label125;
      }
      float f1 = paramMotionEvent.getY();
      float f2 = locala.tYY.getY();
      if (f1 > locala.tYY.getMeasuredHeight() + f2) {
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
    this.hRv.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(63209);
    return true;
  }
  
  final class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a() {}
    
    public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(63203);
      if (Math.abs(paramFloat2) > Math.abs(paramFloat1))
      {
        paramMotionEvent1 = (b.a)MusicItemLayout.this.getTag();
        if (paramFloat2 <= 0.0F) {
          break label47;
        }
        paramMotionEvent1.cVS();
      }
      for (;;)
      {
        AppMethodBeat.o(63203);
        return false;
        label47:
        paramMotionEvent1.cVR();
      }
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(63204);
      b.a locala = (b.a)MusicItemLayout.this.getTag();
      if (locala.cVQ()) {
        if ((paramMotionEvent.getY() <= locala.tYX.getMeasuredHeight()) && (paramMotionEvent.getY() > 100.0F)) {
          locala.cVT();
        }
      }
      for (;;)
      {
        AppMethodBeat.o(63204);
        return false;
        if ((paramMotionEvent.getY() >= locala.tZa.getY() - 100.0F) && (paramMotionEvent.getY() < locala.tZa.getMeasuredHeight() + locala.tZa.getY())) {
          locala.cVT();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicItemLayout
 * JD-Core Version:    0.7.0.1
 */