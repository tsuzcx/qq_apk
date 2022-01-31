package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.test.suitebuilder.annotation.Suppress;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.sdk.platformtools.y;

public class MMTextView
  extends TextView
{
  private long djE = -1L;
  private boolean vFX = false;
  private GestureDetector vFY = null;
  private MMTextView.b wki = null;
  private boolean wkj = false;
  private boolean wkk = false;
  private boolean wkl = false;
  private MMTextView.a wkm = null;
  
  public MMTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MMTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.vFY = new GestureDetector(getContext(), new MMTextView.1(this));
  }
  
  public void cancelLongPress()
  {
    y.d("MicroMsg.MMTextView", "cancelLongPress , should ignore Action Up Event next time");
    this.vFX = true;
    super.cancelLongPress();
  }
  
  public int getBaseline()
  {
    try
    {
      int i = super.getBaseline();
      return i;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.MMTextView", localThrowable, "", new Object[0]);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      return;
    }
    catch (Throwable paramCanvas)
    {
      y.printErrStackTrace("MicroMsg.MMTextView", paramCanvas, "", new Object[0]);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.MMTextView", localThrowable, "", new Object[0]);
    }
  }
  
  public boolean onPreDraw()
  {
    try
    {
      boolean bool = super.onPreDraw();
      return bool;
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    int j = paramMotionEvent.getAction();
    if ((j == 1) && (this.vFX)) {}
    for (int i = 1; i != 0; i = 0)
    {
      y.d("MicroMsg.MMTextView", "ignore Action Up Event this time");
      return bool2;
    }
    if (j == 0) {
      this.vFX = false;
    }
    if ((this.wki != null) && (this.vFY != null)) {}
    for (boolean bool1 = this.vFY.onTouchEvent(paramMotionEvent);; bool1 = false)
    {
      bool2 = bool1;
      if (bool1) {
        break;
      }
      return super.onTouchEvent(paramMotionEvent);
    }
  }
  
  public boolean performLongClick()
  {
    y.d("MicroMsg.MMTextView", "performLongClick , should ignore Action Up Event next time");
    this.vFX = true;
    return super.performLongClick();
  }
  
  public void setIsFromChatting(boolean paramBoolean)
  {
    if (!this.wkj) {
      this.wkj = paramBoolean;
    }
  }
  
  public void setMMTextViewCallBack(MMTextView.a parama)
  {
    if ((!this.wkl) && (parama != null))
    {
      this.wkm = parama;
      this.wkl = true;
    }
  }
  
  public void setMsgId(long paramLong)
  {
    this.djE = paramLong;
  }
  
  public void setOnDoubleClickLitsener(MMTextView.b paramb)
  {
    this.wki = paramb;
  }
  
  @Suppress
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(paramCharSequence, paramBufferType);
    if ((this.wkm != null) && (this.wkj) && ((paramCharSequence instanceof Spannable)) && (((Spannable)paramCharSequence).getSpans(0, paramCharSequence.length(), Object.class) != null)) {
      this.wkm.a(paramCharSequence, this.djE);
    }
    this.wkk = false;
  }
  
  public void setTextInternal(CharSequence paramCharSequence)
  {
    this.wkk = true;
    setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMTextView
 * JD-Core Version:    0.7.0.1
 */