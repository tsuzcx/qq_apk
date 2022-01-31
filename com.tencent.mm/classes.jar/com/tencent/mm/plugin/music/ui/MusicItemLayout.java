package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MusicItemLayout
  extends LinearLayout
{
  private GestureDetector lOj;
  
  public MusicItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105067);
    initView();
    AppMethodBeat.o(105067);
  }
  
  public MusicItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(105068);
    initView();
    AppMethodBeat.o(105068);
  }
  
  private void initView()
  {
    AppMethodBeat.i(105069);
    this.lOj = new GestureDetector(getContext(), new MusicItemLayout.a(this, (byte)0));
    AppMethodBeat.o(105069);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105070);
    b.a locala = (b.a)getTag();
    if (!locala.bWo())
    {
      if ((locala.pbK.getX() > paramMotionEvent.getX()) || (paramMotionEvent.getX() > locala.pbK.getX() + locala.pbK.getMeasuredWidth()) || (locala.pbK.getY() > paramMotionEvent.getY())) {
        break label125;
      }
      float f1 = paramMotionEvent.getY();
      float f2 = locala.pbK.getY();
      if (f1 > locala.pbK.getMeasuredHeight() + f2) {
        break label125;
      }
    }
    label125:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(105070);
      return false;
    }
    AppMethodBeat.o(105070);
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(105071);
    this.lOj.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(105071);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicItemLayout
 * JD-Core Version:    0.7.0.1
 */