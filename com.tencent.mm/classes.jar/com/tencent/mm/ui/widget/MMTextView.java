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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class MMTextView
  extends TextView
{
  private MMTextView.b ADQ;
  private boolean ADR;
  private boolean ADS;
  private boolean ADT;
  private MMTextView.a ADU;
  private long eaY;
  private boolean zXr;
  private GestureDetector zXs;
  
  public MMTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107922);
    this.zXr = false;
    this.ADQ = null;
    this.zXs = null;
    this.ADR = false;
    this.ADS = false;
    this.ADT = false;
    this.eaY = -1L;
    this.ADU = null;
    init();
    AppMethodBeat.o(107922);
  }
  
  public MMTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(107923);
    this.zXr = false;
    this.ADQ = null;
    this.zXs = null;
    this.ADR = false;
    this.ADS = false;
    this.ADT = false;
    this.eaY = -1L;
    this.ADU = null;
    init();
    AppMethodBeat.o(107923);
  }
  
  private void init()
  {
    AppMethodBeat.i(107924);
    this.zXs = new GestureDetector(getContext(), new MMTextView.1(this));
    AppMethodBeat.o(107924);
  }
  
  public void cancelLongPress()
  {
    AppMethodBeat.i(107928);
    ab.d("MicroMsg.MMTextView", "cancelLongPress , should ignore Action Up Event next time");
    this.zXr = true;
    super.cancelLongPress();
    AppMethodBeat.o(107928);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(107933);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(107933);
      return i;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.MMTextView", localThrowable, "", new Object[0]);
      AppMethodBeat.o(107933);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(107931);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(107931);
      return;
    }
    catch (Throwable paramCanvas)
    {
      ab.printErrStackTrace("MicroMsg.MMTextView", paramCanvas, "", new Object[0]);
      AppMethodBeat.o(107931);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107930);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(107930);
      return;
    }
    catch (Throwable localThrowable)
    {
      ab.printErrStackTrace("MicroMsg.MMTextView", localThrowable, "", new Object[0]);
      AppMethodBeat.o(107930);
    }
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(107932);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(107932);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(107932);
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107925);
    int j = paramMotionEvent.getAction();
    if ((j == 1) && (this.zXr)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ab.d("MicroMsg.MMTextView", "ignore Action Up Event this time");
      AppMethodBeat.o(107925);
      return true;
    }
    if (j == 0) {
      this.zXr = false;
    }
    if ((this.ADQ != null) && (this.zXs != null)) {}
    for (boolean bool1 = this.zXs.onTouchEvent(paramMotionEvent);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = super.onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(107925);
      return bool2;
    }
  }
  
  public boolean performLongClick()
  {
    AppMethodBeat.i(107929);
    ab.d("MicroMsg.MMTextView", "performLongClick , should ignore Action Up Event next time");
    this.zXr = true;
    boolean bool = super.performLongClick();
    AppMethodBeat.o(107929);
    return bool;
  }
  
  public void setIsFromChatting(boolean paramBoolean)
  {
    if (!this.ADR) {
      this.ADR = paramBoolean;
    }
  }
  
  public void setMMTextViewCallBack(MMTextView.a parama)
  {
    if ((!this.ADT) && (parama != null))
    {
      this.ADU = parama;
      this.ADT = true;
    }
  }
  
  public void setMsgId(long paramLong)
  {
    this.eaY = paramLong;
  }
  
  public void setOnDoubleClickLitsener(MMTextView.b paramb)
  {
    this.ADQ = paramb;
  }
  
  @Suppress
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(107927);
    super.setText(paramCharSequence, paramBufferType);
    if ((this.ADU != null) && (this.ADR) && ((paramCharSequence instanceof Spannable)) && (((Spannable)paramCharSequence).getSpans(0, paramCharSequence.length(), Object.class) != null)) {
      this.ADU.a(paramCharSequence, this.eaY);
    }
    this.ADS = false;
    AppMethodBeat.o(107927);
  }
  
  public void setTextInternal(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(107926);
    this.ADS = true;
    setText(paramCharSequence);
    AppMethodBeat.o(107926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMTextView
 * JD-Core Version:    0.7.0.1
 */