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
import com.tencent.mm.sdk.platformtools.ad;

public class MMTextView
  extends TextView
{
  private b KSe;
  private boolean KSf;
  private boolean KSg;
  private boolean KSh;
  private a KSi;
  private boolean KfZ;
  private GestureDetector Kga;
  private long fGN;
  
  public MMTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143405);
    this.KfZ = false;
    this.KSe = null;
    this.Kga = null;
    this.KSf = false;
    this.KSg = false;
    this.KSh = false;
    this.fGN = -1L;
    this.KSi = null;
    init();
    AppMethodBeat.o(143405);
  }
  
  public MMTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(143406);
    this.KfZ = false;
    this.KSe = null;
    this.Kga = null;
    this.KSf = false;
    this.KSg = false;
    this.KSh = false;
    this.fGN = -1L;
    this.KSi = null;
    init();
    AppMethodBeat.o(143406);
  }
  
  private void init()
  {
    AppMethodBeat.i(143407);
    this.Kga = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener()new Handler
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186512);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186512);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(143404);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (MMTextView.a(MMTextView.this) == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(143404);
          return false;
        }
        boolean bool = MMTextView.a(MMTextView.this).gk(MMTextView.this);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(143404);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186511);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(186511);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186510);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/MMTextView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186510);
        return bool;
      }
    }, new Handler(Looper.getMainLooper()));
    AppMethodBeat.o(143407);
  }
  
  public void cancelLongPress()
  {
    AppMethodBeat.i(143411);
    ad.d("MicroMsg.MMTextView", "cancelLongPress , should ignore Action Up Event next time");
    this.KfZ = true;
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
    if ((j == 1) && (this.KfZ)) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.d("MicroMsg.MMTextView", "ignore Action Up Event this time");
      AppMethodBeat.o(143408);
      return true;
    }
    if (j == 0) {
      this.KfZ = false;
    }
    GestureDetector localGestureDetector;
    com.tencent.mm.hellhoundlib.b.a locala;
    if ((this.KSe != null) && (this.Kga != null))
    {
      localGestureDetector = this.Kga;
      locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahp(), "com/tencent/mm/ui/widget/MMTextView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    for (boolean bool1 = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/ui/widget/MMTextView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");; bool1 = false)
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
    this.KfZ = true;
    boolean bool = super.performLongClick();
    AppMethodBeat.o(143412);
    return bool;
  }
  
  public void setIsFromChatting(boolean paramBoolean)
  {
    if (!this.KSf) {
      this.KSf = paramBoolean;
    }
  }
  
  public void setMMTextViewCallBack(a parama)
  {
    if ((!this.KSh) && (parama != null))
    {
      this.KSi = parama;
      this.KSh = true;
    }
  }
  
  public void setMsgId(long paramLong)
  {
    this.fGN = paramLong;
  }
  
  public void setOnDoubleClickLitsener(b paramb)
  {
    this.KSe = paramb;
  }
  
  @Suppress
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(143410);
    super.setText(paramCharSequence, paramBufferType);
    if ((this.KSi != null) && (this.KSf) && ((paramCharSequence instanceof Spannable)) && (((Spannable)paramCharSequence).getSpans(0, paramCharSequence.length(), Object.class) != null)) {
      this.KSi.a(paramCharSequence, this.fGN);
    }
    this.KSg = false;
    AppMethodBeat.o(143410);
  }
  
  public void setTextInternal(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143409);
    this.KSg = true;
    setText(paramCharSequence);
    AppMethodBeat.o(143409);
  }
  
  public static abstract interface a
  {
    public abstract void a(CharSequence paramCharSequence, long paramLong);
  }
  
  public static abstract interface b
  {
    public abstract boolean gk(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMTextView
 * JD-Core Version:    0.7.0.1
 */