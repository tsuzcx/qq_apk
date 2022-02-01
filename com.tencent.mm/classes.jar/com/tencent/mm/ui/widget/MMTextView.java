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
import com.tencent.mm.sdk.platformtools.Log;

public class MMTextView
  extends TextView
{
  private boolean PPd;
  private GestureDetector PPe;
  private b QDL;
  private boolean QDM;
  private boolean QDN;
  private boolean QDO;
  private a QDP;
  private long gof;
  
  public MMTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143405);
    this.PPd = false;
    this.QDL = null;
    this.PPe = null;
    this.QDM = false;
    this.QDN = false;
    this.QDO = false;
    this.gof = -1L;
    this.QDP = null;
    init();
    AppMethodBeat.o(143405);
  }
  
  public MMTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143406);
    this.PPd = false;
    this.QDL = null;
    this.PPe = null;
    this.QDM = false;
    this.QDN = false;
    this.QDO = false;
    this.gof = -1L;
    this.QDP = null;
    init();
    AppMethodBeat.o(143406);
  }
  
  private void init()
  {
    AppMethodBeat.i(143407);
    this.PPe = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()new Handler
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(205409);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205409);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143404);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        if (MMTextView.a(MMTextView.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143404);
          return false;
        }
        boolean bool = MMTextView.a(MMTextView.this).gB(MMTextView.this);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(143404);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(205408);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(205408);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(205407);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205407);
        return bool;
      }
    }, new Handler(Looper.getMainLooper()));
    AppMethodBeat.o(143407);
  }
  
  public void cancelLongPress()
  {
    AppMethodBeat.i(143411);
    Log.d("MicroMsg.MMTextView", "cancelLongPress , should ignore Action Up Event next time");
    this.PPd = true;
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
      Log.printErrStackTrace("MicroMsg.MMTextView", localThrowable, "", new Object[0]);
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
      Log.printErrStackTrace("MicroMsg.MMTextView", paramCanvas, "", new Object[0]);
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
      Log.printErrStackTrace("MicroMsg.MMTextView", localThrowable, "", new Object[0]);
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
    if ((j == 1) && (this.PPd)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.d("MicroMsg.MMTextView", "ignore Action Up Event this time");
      AppMethodBeat.o(143408);
      return true;
    }
    if (j == 0) {
      this.PPd = false;
    }
    GestureDetector localGestureDetector;
    com.tencent.mm.hellhoundlib.b.a locala;
    if ((this.QDL != null) && (this.PPe != null))
    {
      localGestureDetector = this.PPe;
      locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.axQ(), "com/tencent/mm/ui/widget/MMTextView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    for (boolean bool1 = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/ui/widget/MMTextView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");; bool1 = false)
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
    Log.d("MicroMsg.MMTextView", "performLongClick , should ignore Action Up Event next time");
    this.PPd = true;
    boolean bool = super.performLongClick();
    AppMethodBeat.o(143412);
    return bool;
  }
  
  public void setIsFromChatting(boolean paramBoolean)
  {
    if (!this.QDM) {
      this.QDM = paramBoolean;
    }
  }
  
  public void setMMTextViewCallBack(a parama)
  {
    if ((!this.QDO) && (parama != null))
    {
      this.QDP = parama;
      this.QDO = true;
    }
  }
  
  public void setMsgId(long paramLong)
  {
    this.gof = paramLong;
  }
  
  public void setOnDoubleClickLitsener(b paramb)
  {
    this.QDL = paramb;
  }
  
  @Suppress
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(143410);
    super.setText(paramCharSequence, paramBufferType);
    if ((this.QDP != null) && (this.QDM) && ((paramCharSequence instanceof Spannable)) && (((Spannable)paramCharSequence).getSpans(0, paramCharSequence.length(), Object.class) != null)) {
      this.QDP.a(paramCharSequence, this.gof);
    }
    this.QDN = false;
    AppMethodBeat.o(143410);
  }
  
  public void setTextInternal(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143409);
    this.QDN = true;
    setText(paramCharSequence);
    AppMethodBeat.o(143409);
  }
  
  public static abstract interface a
  {
    public abstract void a(CharSequence paramCharSequence, long paramLong);
  }
  
  public static abstract interface b
  {
    public abstract boolean gB(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMTextView
 * JD-Core Version:    0.7.0.1
 */