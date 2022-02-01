package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.os.Looper;
import android.text.Layout;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.StaticTextView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;

public final class n
  implements View.OnTouchListener
{
  private static int Ckv;
  private static boolean DEBUG;
  private static int Mw;
  private o Cks;
  private boolean Ckt;
  private View Cku;
  private ap Ckw;
  private b Ckx;
  private a Cky;
  private boolean lVP;
  String mSessionId;
  private Context uiContext;
  private View view;
  
  static
  {
    AppMethodBeat.i(152338);
    DEBUG = false;
    Mw = ViewConfiguration.getTapTimeout();
    int i = ViewConfiguration.getLongPressTimeout();
    Ckv = i;
    if (i > Mw * 2) {
      Ckv -= Mw;
    }
    ad.d("MicroMsg.PressSpanTouchListener", "long press timeout:%d", new Object[] { Integer.valueOf(Ckv) });
    AppMethodBeat.o(152338);
  }
  
  public n()
  {
    AppMethodBeat.i(152331);
    this.Cks = null;
    this.Ckt = false;
    this.Cku = null;
    this.lVP = false;
    this.uiContext = null;
    this.Ckw = new ap(Looper.getMainLooper());
    this.Ckx = new b((byte)0);
    this.Cky = new a();
    AppMethodBeat.o(152331);
  }
  
  public n(Context paramContext)
  {
    AppMethodBeat.i(152332);
    this.Cks = null;
    this.Ckt = false;
    this.Cku = null;
    this.lVP = false;
    this.uiContext = null;
    this.Ckw = new ap(Looper.getMainLooper());
    this.Ckx = new b((byte)0);
    this.Cky = new a();
    this.uiContext = paramContext;
    AppMethodBeat.o(152332);
  }
  
  private void Vm(int paramInt)
  {
    AppMethodBeat.i(152336);
    if (this.view != null) {
      this.Ckw.postDelayed(this.Cky, Ckv - paramInt);
    }
    AppMethodBeat.o(152336);
  }
  
  private void Y(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152334);
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      resetStatus();
    }
    AppMethodBeat.o(152334);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152333);
    if ((!(paramView instanceof TextView)) && (!(paramView instanceof StaticTextView)))
    {
      AppMethodBeat.o(152333);
      return false;
    }
    if (paramMotionEvent.getAction() == 0) {
      paramView.setTag(2131306044, new int[] { (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY() });
    }
    this.view = paramView;
    Layout localLayout;
    CharSequence localCharSequence;
    MotionEvent localMotionEvent;
    Object localObject;
    int i;
    int j;
    int k;
    label302:
    boolean bool;
    if ((paramView instanceof TextView))
    {
      localLayout = ((TextView)paramView).getLayout();
      localCharSequence = ((TextView)paramView).getText();
      if (DEBUG) {
        ad.d("MicroMsg.PressSpanTouchListener", "ontouch action: %d, isLongPress:%b " + localLayout + " " + (localCharSequence instanceof Spanned) + " " + bt.eGN().toString(), new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(this.lVP) });
      }
      localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if ((!(localCharSequence instanceof Spanned)) || (localLayout == null)) {
        break label1413;
      }
      localObject = (Spanned)localCharSequence;
      i = localMotionEvent.getAction();
      paramView.invalidate();
      if ((paramView == null) || (localObject == null) || (!f.a(paramView, (Spanned)localObject)))
      {
        if ((i != 1) && (i != 0) && (i != 2) && (i != 3)) {
          break label1378;
        }
        j = (int)localMotionEvent.getX();
        i = (int)localMotionEvent.getY();
        if (!(paramView instanceof StaticTextView)) {
          break label469;
        }
        if (j >= ((StaticTextView)paramView).getHorizontalDrawOffset())
        {
          k = localLayout.getWidth();
          if (j <= ((StaticTextView)paramView).getHorizontalDrawOffset() + k) {
            break label428;
          }
        }
        Y(localMotionEvent);
      }
      bool = false;
    }
    for (;;)
    {
      localMotionEvent.recycle();
      if (DEBUG) {
        ad.d("MicroMsg.PressSpanTouchListener", "ontouch action2: %d, isLongPress:%b " + localLayout + " " + (localCharSequence instanceof Spanned) + " processResult: " + bool + " " + bt.eGN().toString(), new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(this.lVP) });
      }
      AppMethodBeat.o(152333);
      return bool;
      localLayout = ((StaticTextView)paramView).getTvLayout();
      localCharSequence = ((StaticTextView)paramView).getText();
      break;
      label428:
      if (i >= ((StaticTextView)paramView).getVerticalDrawOffset())
      {
        k = localLayout.getHeight();
        if (i <= ((StaticTextView)paramView).getVerticalDrawOffset() + k) {}
      }
      else
      {
        Y(localMotionEvent);
        break label302;
        label469:
        if ((paramView instanceof TextView))
        {
          if (j >= ((TextView)paramView).getTotalPaddingLeft())
          {
            k = localLayout.getWidth();
            if (j <= ((TextView)paramView).getTotalPaddingLeft() + k) {}
          }
          else
          {
            Y(localMotionEvent);
            break label302;
          }
          if (i >= ((TextView)paramView).getTotalPaddingTop())
          {
            k = localLayout.getHeight();
            if (i <= ((TextView)paramView).getTotalPaddingTop() + k) {}
          }
          else
          {
            Y(localMotionEvent);
            break label302;
          }
        }
      }
      if ((paramView instanceof TextView))
      {
        j -= ((TextView)paramView).getTotalPaddingLeft();
        i -= ((TextView)paramView).getTotalPaddingTop();
        label589:
        k = paramView.getScrollX();
        j = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(i + paramView.getScrollY()), j + k);
        i = j;
        if ((paramView instanceof TextView))
        {
          i = j;
          if (j < ((Spanned)localObject).length()) {
            i = j + 1;
          }
        }
        j = localMotionEvent.getAction();
        localObject = (o[])((Spanned)localObject).getSpans(i, i, o.class);
        i = localObject.length - 1;
        if (DEBUG) {
          ad.d("MicroMsg.PressSpanTouchListener", "processPress action: %d, isLongPress:%b " + localObject.length + " " + this.Cks + " " + bt.eGN().toString(), new Object[] { Integer.valueOf(localMotionEvent.getAction()), Boolean.valueOf(this.lVP) });
        }
        if (localObject.length == 0) {
          break label1326;
        }
        if (j != 1) {
          break label1054;
        }
        this.Ckw.removeCallbacks(this.Ckx);
        this.Ckw.removeCallbacks(this.Cky);
        if (!this.lVP) {
          break label945;
        }
        resetStatus();
        this.lVP = false;
        paramView.setClickable(this.Ckt);
        if (DEBUG) {
          ad.i("MicroMsg.PressSpanTouchListener", "processPress action1 " + localMotionEvent.getAction());
        }
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label1378;
        }
        if (DEBUG) {
          ad.i("MicroMsg.PressSpanTouchListener", "processTouch action1 " + localMotionEvent.getAction());
        }
        bool = true;
        break;
        if ((paramView instanceof StaticTextView))
        {
          j -= ((StaticTextView)paramView).getHorizontalDrawOffset();
          i -= ((StaticTextView)paramView).getVerticalDrawOffset();
          break label589;
        }
        j -= paramView.getPaddingLeft();
        i -= paramView.getPaddingTop();
        break label589;
        label945:
        this.lVP = false;
        if (this.Cks != null)
        {
          this.Cks.setSessionId(this.mSessionId);
          if (this.uiContext != null) {
            this.Cks.setContext(this.uiContext);
          }
          this.Cks.onClick(paramView);
        }
        for (;;)
        {
          paramView.setClickable(this.Ckt);
          resetStatus();
          if (DEBUG) {
            ad.i("MicroMsg.PressSpanTouchListener", "processPress action2 " + localMotionEvent.getAction());
          }
          i = 0;
          break;
          ad.e("MicroMsg.PressSpanTouchListener", "ACTION_UP error, lastClickSpan is null");
        }
        label1054:
        if ((j == 0) || (j == 2))
        {
          if ((j == 0) && (Ckv > 0)) {
            Vm(0);
          }
          if (j == 0)
          {
            this.lVP = false;
            this.Ckt = paramView.isClickable();
          }
          resetStatus();
          this.Cks = localObject[i];
          this.Cku = paramView;
          localObject[i].setContext(null);
          localObject[i].setIsPressed(true);
          localObject[i].setEnable(true);
          paramView.invalidate();
          if (this.lVP)
          {
            localObject[i].setIsPressed(false);
            localObject[i].setEnable(false);
            paramView.setClickable(this.Ckt);
            if (DEBUG) {
              ad.i("MicroMsg.PressSpanTouchListener", "processPress action3 " + localMotionEvent.getAction());
            }
            i = 0;
          }
          else
          {
            if (DEBUG) {
              ad.i("MicroMsg.PressSpanTouchListener", "processPress action4 " + localMotionEvent.getAction());
            }
            i = 1;
          }
        }
        else if (j == 3)
        {
          this.Ckw.removeCallbacks(this.Ckx);
          this.Ckw.removeCallbacks(this.Cky);
          paramView.setClickable(this.Ckt);
          resetStatus();
          if (DEBUG) {
            ad.i("MicroMsg.PressSpanTouchListener", "processPress action5 " + localMotionEvent.getAction());
          }
          i = 0;
          continue;
          label1326:
          resetStatus();
        }
        else
        {
          if (j == 1) {
            this.lVP = false;
          }
          if (DEBUG) {
            ad.i("MicroMsg.PressSpanTouchListener", "processPress action6 " + localMotionEvent.getAction());
          }
          i = 0;
        }
      }
      label1378:
      if (!DEBUG) {
        break label302;
      }
      ad.i("MicroMsg.PressSpanTouchListener", "processTouch action2 " + localMotionEvent.getAction());
      break label302;
      label1413:
      bool = false;
    }
  }
  
  public final void resetStatus()
  {
    AppMethodBeat.i(152335);
    if (this.Cks != null)
    {
      this.Cks.setIsPressed(false);
      this.Cks.setContext(null);
      this.Cku.invalidate();
      this.Cku = null;
      this.Cks = null;
    }
    AppMethodBeat.o(152335);
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(152329);
      if ((n.a(n.this) != null) && (n.a(n.this).isPressed()))
      {
        ad.d("MicroMsg.PressSpanTouchListener", "long pressed timeout");
        n.b(n.this);
        n.this.resetStatus();
      }
      AppMethodBeat.o(152329);
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(152330);
      n.a(n.this, n.Mw);
      AppMethodBeat.o(152330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.n
 * JD-Core Version:    0.7.0.1
 */