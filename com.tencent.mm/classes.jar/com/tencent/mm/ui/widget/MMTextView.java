package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.test.suitebuilder.annotation.Suppress;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class MMTextView
  extends TextView
{
  private boolean GPx;
  private GestureDetector GPy;
  private a HAA;
  private b HAw;
  private boolean HAx;
  private boolean HAy;
  private boolean HAz;
  private long fll;
  
  public MMTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143405);
    this.GPx = false;
    this.HAw = null;
    this.GPy = null;
    this.HAx = false;
    this.HAy = false;
    this.HAz = false;
    this.fll = -1L;
    this.HAA = null;
    init();
    AppMethodBeat.o(143405);
  }
  
  public MMTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143406);
    this.GPx = false;
    this.HAw = null;
    this.GPy = null;
    this.HAx = false;
    this.HAy = false;
    this.HAz = false;
    this.fll = -1L;
    this.HAA = null;
    init();
    AppMethodBeat.o(143406);
  }
  
  private void init()
  {
    AppMethodBeat.i(143407);
    this.GPy = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()new Handler
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143404);
        if (MMTextView.a(MMTextView.this) == null)
        {
          AppMethodBeat.o(143404);
          return false;
        }
        boolean bool = MMTextView.a(MMTextView.this).fI(MMTextView.this);
        AppMethodBeat.o(143404);
        return bool;
      }
    }, new Handler(Looper.getMainLooper()));
    AppMethodBeat.o(143407);
  }
  
  public void cancelLongPress()
  {
    AppMethodBeat.i(143411);
    ad.d("MicroMsg.MMTextView", "cancelLongPress , should ignore Action Up Event next time");
    this.GPx = true;
    super.cancelLongPress();
    AppMethodBeat.o(143411);
  }
  
  public int getBaseline()
  {
    AppMethodBeat.i(143416);
    try
    {
      int i = super.getBaseline();
      AppMethodBeat.o(143416);
      return i;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.MMTextView", localThrowable, "", new Object[0]);
      AppMethodBeat.o(143416);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143414);
    try
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(143414);
      return;
    }
    catch (Throwable paramCanvas)
    {
      ad.printErrStackTrace("MicroMsg.MMTextView", paramCanvas, "", new Object[0]);
      AppMethodBeat.o(143414);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143413);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(143413);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.MMTextView", localThrowable, "", new Object[0]);
      AppMethodBeat.o(143413);
    }
  }
  
  public boolean onPreDraw()
  {
    AppMethodBeat.i(143415);
    try
    {
      boolean bool = super.onPreDraw();
      AppMethodBeat.o(143415);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(143415);
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143408);
    int j = paramMotionEvent.getAction();
    if ((j == 1) && (this.GPx)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.d("MicroMsg.MMTextView", "ignore Action Up Event this time");
      AppMethodBeat.o(143408);
      return true;
    }
    if (j == 0) {
      this.GPx = false;
    }
    if ((this.HAw != null) && (this.GPy != null)) {}
    for (boolean bool1 = this.GPy.onTouchEvent(paramMotionEvent);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = super.onTouchEvent(paramMotionEvent);
      }
      AppMethodBeat.o(143408);
      return bool2;
    }
  }
  
  public boolean performLongClick()
  {
    AppMethodBeat.i(143412);
    ad.d("MicroMsg.MMTextView", "performLongClick , should ignore Action Up Event next time");
    this.GPx = true;
    boolean bool = super.performLongClick();
    AppMethodBeat.o(143412);
    return bool;
  }
  
  public void setIsFromChatting(boolean paramBoolean)
  {
    if (!this.HAx) {
      this.HAx = paramBoolean;
    }
  }
  
  public void setMMTextViewCallBack(a parama)
  {
    if ((!this.HAz) && (parama != null))
    {
      this.HAA = parama;
      this.HAz = true;
    }
  }
  
  public void setMsgId(long paramLong)
  {
    this.fll = paramLong;
  }
  
  public void setOnDoubleClickLitsener(b paramb)
  {
    this.HAw = paramb;
  }
  
  @Suppress
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(143410);
    super.setText(paramCharSequence, paramBufferType);
    if ((this.HAA != null) && (this.HAx) && ((paramCharSequence instanceof Spannable)) && (((Spannable)paramCharSequence).getSpans(0, paramCharSequence.length(), Object.class) != null)) {
      this.HAA.a(paramCharSequence, this.fll);
    }
    this.HAy = false;
    AppMethodBeat.o(143410);
  }
  
  public void setTextInternal(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143409);
    this.HAy = true;
    setText(paramCharSequence);
    AppMethodBeat.o(143409);
  }
  
  public static abstract interface a
  {
    public abstract void a(CharSequence paramCharSequence, long paramLong);
  }
  
  public static abstract interface b
  {
    public abstract boolean fI(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMTextView
 * JD-Core Version:    0.7.0.1
 */