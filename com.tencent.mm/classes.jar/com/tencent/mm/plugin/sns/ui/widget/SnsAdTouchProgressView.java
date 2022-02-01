package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public class SnsAdTouchProgressView
  extends FrameLayout
{
  protected Handler PRJ;
  protected boolean RWQ;
  protected boolean RWR;
  protected boolean RWS;
  protected int RWT;
  protected int RWU;
  protected a Rna;
  protected Context mContext;
  protected boolean mIsCanceled;
  protected GestureDetector mQj;
  
  public SnsAdTouchProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(179405);
    this.RWQ = false;
    this.mIsCanceled = false;
    this.RWR = false;
    this.RWS = false;
    this.RWT = 500;
    this.RWU = this.RWT;
    init(paramContext);
    AppMethodBeat.o(179405);
  }
  
  public SnsAdTouchProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(179406);
    this.RWQ = false;
    this.mIsCanceled = false;
    this.RWR = false;
    this.RWS = false;
    this.RWT = 500;
    this.RWU = this.RWT;
    init(paramContext);
    AppMethodBeat.o(179406);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(179407);
    this.mContext = paramContext;
    this.PRJ = new Handler(Looper.getMainLooper());
    this.RWT = ViewConfiguration.getLongPressTimeout();
    Log.i("SnsAdTouchProgressView", "init, longPressTimeout=" + this.RWT);
    if (this.RWT < 500) {
      this.RWT = 500;
    }
    this.RWU = this.RWT;
    this.mQj = new GestureDetector(paramContext, new GestureDetector.OnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(179402);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        Log.i("SnsAdTouchProgressView", "onLongPress");
        SnsAdTouchProgressView.this.getParent().requestDisallowInterceptTouchEvent(true);
        SnsAdTouchProgressView.this.RWR = true;
        if (SnsAdTouchProgressView.this.Rna != null) {
          SnsAdTouchProgressView.this.Rna.onStart();
        }
        int j = SnsAdTouchProgressView.this.RWU - SnsAdTouchProgressView.this.RWT;
        int i = j;
        if (j < 0) {
          i = 0;
        }
        SnsAdTouchProgressView.this.PRJ.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(309300);
            if (SnsAdTouchProgressView.this.Rna != null)
            {
              SnsAdTouchProgressView.this.RWQ = true;
              SnsAdTouchProgressView.this.Rna.onFinish();
            }
            AppMethodBeat.o(309300);
          }
        }, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(179402);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return true;
      }
      
      public final void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(179401);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        if (SnsAdTouchProgressView.this.Rna != null) {
          SnsAdTouchProgressView.this.Rna.onClick(SnsAdTouchProgressView.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView$1", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(179401);
        return true;
      }
    });
    AppMethodBeat.o(179407);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(179409);
    Log.i("SnsAdTouchProgressView", "clear");
    this.mIsCanceled = true;
    this.PRJ.removeCallbacksAndMessages(null);
    AppMethodBeat.o(179409);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(309232);
    if (this.RWS) {
      paramCanvas.drawColor(Color.parseColor("#35FF0000"));
    }
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(309232);
  }
  
  public int getLongPressTime()
  {
    return this.RWT;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(179410);
    int i = paramMotionEvent.getAction();
    GestureDetector localGestureDetector = this.mQj;
    paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, paramMotionEvent.aYi(), "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)paramMotionEvent.sb(0)), "com/tencent/mm/plugin/sns/ui/widget/SnsAdTouchProgressView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if (i == 0)
    {
      this.RWQ = false;
      this.mIsCanceled = false;
    }
    for (;;)
    {
      AppMethodBeat.o(179410);
      return bool;
      if ((i == 1) || (i == 3))
      {
        Log.i("SnsAdTouchProgressView", "onTouchEvent cancel， action=" + i + ", IsLongClicked=" + this.RWR + ", isSuccFinish=" + this.RWQ);
        getParent().requestDisallowInterceptTouchEvent(false);
        this.PRJ.removeCallbacksAndMessages(null);
        if ((!this.RWQ) && (this.RWR) && (this.Rna != null)) {
          this.Rna.onCancel();
        }
        this.RWR = false;
        clear();
      }
    }
  }
  
  public void setActionListener(a parama)
  {
    this.Rna = parama;
  }
  
  public void setPressDuration(int paramInt)
  {
    AppMethodBeat.i(309236);
    Log.i("SnsAdTouchProgressView", "setPressDuration:".concat(String.valueOf(paramInt)));
    int i = paramInt;
    if (paramInt < this.RWT) {
      i = this.RWT;
    }
    this.RWU = i;
    AppMethodBeat.o(309236);
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
    
    public abstract void onClick(View paramView);
    
    public abstract void onFinish();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView
 * JD-Core Version:    0.7.0.1
 */