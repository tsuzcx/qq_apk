package com.tencent.mm.plugin.pwdgroup.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.ah;

public class MMCallBackScrollView
  extends ScrollView
{
  private ah mHandler = new MMCallBackScrollView.1(this);
  private int mState = 0;
  private int nbB;
  private MMCallBackScrollView.a nbC;
  
  public MMCallBackScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMCallBackScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void wh(int paramInt)
  {
    if ((this.nbC != null) && (this.mState != paramInt))
    {
      this.mState = paramInt;
      this.nbC.bR(paramInt);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    this.nbB = getScrollY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 1: 
      do
      {
        return bool;
      } while (this.mHandler == null);
      this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(), 5L);
      return bool;
    }
    wh(1);
    return bool;
  }
  
  public void setMMOnScrollListener(MMCallBackScrollView.a parama)
  {
    this.nbC = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView
 * JD-Core Version:    0.7.0.1
 */