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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

public class MMTextView
  extends TextView
{
  private boolean KCs;
  private GestureDetector KCt;
  private b LoC;
  private boolean LoD;
  private boolean LoE;
  private boolean LoF;
  private a LoG;
  private long fIR;
  
  public MMTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143405);
    this.KCs = false;
    this.LoC = null;
    this.KCt = null;
    this.LoD = false;
    this.LoE = false;
    this.LoF = false;
    this.fIR = -1L;
    this.LoG = null;
    init();
    AppMethodBeat.o(143405);
  }
  
  public MMTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143406);
    this.KCs = false;
    this.LoC = null;
    this.KCt = null;
    this.LoD = false;
    this.LoE = false;
    this.LoF = false;
    this.fIR = -1L;
    this.LoG = null;
    init();
    AppMethodBeat.o(143406);
  }
  
  private void init()
  {
    AppMethodBeat.i(143407);
    this.KCt = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()new Handler
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(193770);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(193770);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143404);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        if (MMTextView.a(MMTextView.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143404);
          return false;
        }
        boolean bool = MMTextView.a(MMTextView.this).gj(MMTextView.this);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(143404);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(193769);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(193769);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(193768);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(193768);
        return bool;
      }
    }, new Handler(Looper.getMainLooper()));
    AppMethodBeat.o(143407);
  }
  
  public void cancelLongPress()
  {
    AppMethodBeat.i(143411);
    ae.d("MicroMsg.MMTextView", "cancelLongPress , should ignore Action Up Event next time");
    this.KCs = true;
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
      ae.printErrStackTrace("MicroMsg.MMTextView", localThrowable, "", new Object[0]);
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
      ae.printErrStackTrace("MicroMsg.MMTextView", paramCanvas, "", new Object[0]);
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
      ae.printErrStackTrace("MicroMsg.MMTextView", localThrowable, "", new Object[0]);
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
    if ((j == 1) && (this.KCs)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ae.d("MicroMsg.MMTextView", "ignore Action Up Event this time");
      AppMethodBeat.o(143408);
      return true;
    }
    if (j == 0) {
      this.KCs = false;
    }
    GestureDetector localGestureDetector;
    com.tencent.mm.hellhoundlib.b.a locala;
    if ((this.LoC != null) && (this.KCt != null))
    {
      localGestureDetector = this.KCt;
      locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahE(), "com/tencent/mm/ui/widget/MMTextView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    for (boolean bool1 = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/ui/widget/MMTextView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");; bool1 = false)
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
    ae.d("MicroMsg.MMTextView", "performLongClick , should ignore Action Up Event next time");
    this.KCs = true;
    boolean bool = super.performLongClick();
    AppMethodBeat.o(143412);
    return bool;
  }
  
  public void setIsFromChatting(boolean paramBoolean)
  {
    if (!this.LoD) {
      this.LoD = paramBoolean;
    }
  }
  
  public void setMMTextViewCallBack(a parama)
  {
    if ((!this.LoF) && (parama != null))
    {
      this.LoG = parama;
      this.LoF = true;
    }
  }
  
  public void setMsgId(long paramLong)
  {
    this.fIR = paramLong;
  }
  
  public void setOnDoubleClickLitsener(b paramb)
  {
    this.LoC = paramb;
  }
  
  @Suppress
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(143410);
    super.setText(paramCharSequence, paramBufferType);
    if ((this.LoG != null) && (this.LoD) && ((paramCharSequence instanceof Spannable)) && (((Spannable)paramCharSequence).getSpans(0, paramCharSequence.length(), Object.class) != null)) {
      this.LoG.a(paramCharSequence, this.fIR);
    }
    this.LoE = false;
    AppMethodBeat.o(143410);
  }
  
  public void setTextInternal(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143409);
    this.LoE = true;
    setText(paramCharSequence);
    AppMethodBeat.o(143409);
  }
  
  public static abstract interface a
  {
    public abstract void a(CharSequence paramCharSequence, long paramLong);
  }
  
  public static abstract interface b
  {
    public abstract boolean gj(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMTextView
 * JD-Core Version:    0.7.0.1
 */