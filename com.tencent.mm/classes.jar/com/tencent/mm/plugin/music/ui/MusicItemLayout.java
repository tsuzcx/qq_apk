package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MusicItemLayout
  extends LinearLayout
{
  private GestureDetector jEK;
  
  public MusicItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView();
  }
  
  public MusicItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void initView()
  {
    this.jEK = new GestureDetector(getContext(), new MusicItemLayout.a(this, (byte)0));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    b.a locala = (b.a)getTag();
    if (!locala.bnR())
    {
      if ((locala.mBF.getX() > paramMotionEvent.getX()) || (paramMotionEvent.getX() > locala.mBF.getX() + locala.mBF.getMeasuredWidth()) || (locala.mBF.getY() > paramMotionEvent.getY())) {
        break label115;
      }
      float f1 = paramMotionEvent.getY();
      float f2 = locala.mBF.getY();
      if (f1 > locala.mBF.getMeasuredHeight() + f2) {
        break label115;
      }
    }
    label115:
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jEK.onTouchEvent(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicItemLayout
 * JD-Core Version:    0.7.0.1
 */