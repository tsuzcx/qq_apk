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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kiss.widget.textview.StaticTextView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;

public final class n
  implements View.OnTouchListener
{
  private static int ADv;
  private static boolean DEBUG;
  private static int Pk;
  private o FhQ;
  private boolean FhR;
  private View FhS;
  private ap FhT;
  private b FhU;
  private a FhV;
  String mSessionId;
  private boolean mYz;
  private Context uiContext;
  private View view;
  
  static
  {
    AppMethodBeat.i(152338);
    DEBUG = false;
    Pk = ViewConfiguration.getTapTimeout();
    int i = ViewConfiguration.getLongPressTimeout();
    ADv = i;
    if (i > Pk * 2) {
      ADv -= Pk;
    }
    ad.d("MicroMsg.PressSpanTouchListener", "long press timeout:%d", new Object[] { Integer.valueOf(ADv) });
    AppMethodBeat.o(152338);
  }
  
  public n()
  {
    AppMethodBeat.i(152331);
    this.FhQ = null;
    this.FhR = false;
    this.FhS = null;
    this.mYz = false;
    this.uiContext = null;
    this.FhT = new ap(Looper.getMainLooper());
    this.FhU = new b((byte)0);
    this.FhV = new a();
    AppMethodBeat.o(152331);
  }
  
  public n(Context paramContext)
  {
    AppMethodBeat.i(152332);
    this.FhQ = null;
    this.FhR = false;
    this.FhS = null;
    this.mYz = false;
    this.uiContext = null;
    this.FhT = new ap(Looper.getMainLooper());
    this.FhU = new b((byte)0);
    this.FhV = new a();
    this.uiContext = paramContext;
    AppMethodBeat.o(152332);
  }
  
  private void Zr(int paramInt)
  {
    AppMethodBeat.i(152336);
    if (this.view != null) {
      this.FhT.postDelayed(this.FhV, ADv - paramInt);
    }
    AppMethodBeat.o(152336);
  }
  
  private void aa(MotionEvent paramMotionEvent)
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
    Object localObject1 = new b();
    ((b)localObject1).bd(paramView);
    ((b)localObject1).bd(paramMotionEvent);
    a.b("com/tencent/mm/pluginsdk/ui/span/PressSpanTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((b)localObject1).ahq());
    if ((!(paramView instanceof TextView)) && (!(paramView instanceof StaticTextView)))
    {
      a.a(false, this, "com/tencent/mm/pluginsdk/ui/span/PressSpanTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(152333);
      return false;
    }
    if (paramMotionEvent.getAction() == 0) {
      paramView.setTag(2131306044, new int[] { (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY() });
    }
    this.view = paramView;
    Layout localLayout;
    MotionEvent localMotionEvent;
    Object localObject2;
    int i;
    int j;
    int k;
    label353:
    boolean bool;
    if ((paramView instanceof TextView))
    {
      localLayout = ((TextView)paramView).getLayout();
      localObject1 = ((TextView)paramView).getText();
      if (DEBUG) {
        ad.d("MicroMsg.PressSpanTouchListener", "ontouch action: %d, isLongPress:%b " + localLayout + " " + (localObject1 instanceof Spanned) + " " + bt.flS().toString(), new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(this.mYz) });
      }
      localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if ((!(localObject1 instanceof Spanned)) || (localLayout == null)) {
        break label1480;
      }
      localObject2 = (Spanned)localObject1;
      i = localMotionEvent.getAction();
      paramView.invalidate();
      if ((paramView == null) || (localObject2 == null) || (!f.a(paramView, (Spanned)localObject2)))
      {
        if ((i != 1) && (i != 0) && (i != 2) && (i != 3)) {
          break label1445;
        }
        j = (int)localMotionEvent.getX();
        i = (int)localMotionEvent.getY();
        if (!(paramView instanceof StaticTextView)) {
          break label536;
        }
        if (j >= ((StaticTextView)paramView).getHorizontalDrawOffset())
        {
          k = localLayout.getWidth();
          if (j <= ((StaticTextView)paramView).getHorizontalDrawOffset() + k) {
            break label495;
          }
        }
        aa(localMotionEvent);
      }
      bool = false;
    }
    for (;;)
    {
      localMotionEvent.recycle();
      if (DEBUG) {
        ad.d("MicroMsg.PressSpanTouchListener", "ontouch action2: %d, isLongPress:%b " + localLayout + " " + (localObject1 instanceof Spanned) + " processResult: " + bool + " " + bt.flS().toString(), new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(this.mYz) });
      }
      a.a(bool, this, "com/tencent/mm/pluginsdk/ui/span/PressSpanTouchListener", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(152333);
      return bool;
      localLayout = ((StaticTextView)paramView).getTvLayout();
      localObject1 = ((StaticTextView)paramView).getText();
      break;
      label495:
      if (i >= ((StaticTextView)paramView).getVerticalDrawOffset())
      {
        k = localLayout.getHeight();
        if (i <= ((StaticTextView)paramView).getVerticalDrawOffset() + k) {}
      }
      else
      {
        aa(localMotionEvent);
        break label353;
        if ((paramView instanceof TextView))
        {
          if (j >= ((TextView)paramView).getTotalPaddingLeft())
          {
            k = localLayout.getWidth();
            if (j <= ((TextView)paramView).getTotalPaddingLeft() + k) {}
          }
          else
          {
            aa(localMotionEvent);
            break label353;
          }
          if (i >= ((TextView)paramView).getTotalPaddingTop())
          {
            k = localLayout.getHeight();
            if (i <= ((TextView)paramView).getTotalPaddingTop() + k) {}
          }
          else
          {
            aa(localMotionEvent);
            break label353;
          }
        }
      }
      label536:
      if ((paramView instanceof TextView))
      {
        j -= ((TextView)paramView).getTotalPaddingLeft();
        i -= ((TextView)paramView).getTotalPaddingTop();
        k = paramView.getScrollX();
        j = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(i + paramView.getScrollY()), j + k);
        i = j;
        if ((paramView instanceof TextView))
        {
          i = j;
          if (j < ((Spanned)localObject2).length()) {
            i = j + 1;
          }
        }
        j = localMotionEvent.getAction();
        localObject2 = (o[])((Spanned)localObject2).getSpans(i, i, o.class);
        i = localObject2.length - 1;
        if (DEBUG) {
          ad.d("MicroMsg.PressSpanTouchListener", "processPress action: %d, isLongPress:%b " + localObject2.length + " " + this.FhQ + " " + bt.flS().toString(), new Object[] { Integer.valueOf(localMotionEvent.getAction()), Boolean.valueOf(this.mYz) });
        }
        if (localObject2.length == 0) {
          break label1393;
        }
        if (j != 1) {
          break label1121;
        }
        this.FhT.removeCallbacks(this.FhU);
        this.FhT.removeCallbacks(this.FhV);
        if (!this.mYz) {
          break label1012;
        }
        resetStatus();
        this.mYz = false;
        paramView.setClickable(this.FhR);
        if (DEBUG) {
          ad.i("MicroMsg.PressSpanTouchListener", "processPress action1 " + localMotionEvent.getAction());
        }
        i = 0;
      }
      for (;;)
      {
        label656:
        if (i == 0) {
          break label1445;
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
          break label656;
        }
        j -= paramView.getPaddingLeft();
        i -= paramView.getPaddingTop();
        break label656;
        label1012:
        this.mYz = false;
        if (this.FhQ != null)
        {
          this.FhQ.setSessionId(this.mSessionId);
          if (this.uiContext != null) {
            this.FhQ.setContext(this.uiContext);
          }
          this.FhQ.onClick(paramView);
        }
        for (;;)
        {
          paramView.setClickable(this.FhR);
          resetStatus();
          if (DEBUG) {
            ad.i("MicroMsg.PressSpanTouchListener", "processPress action2 " + localMotionEvent.getAction());
          }
          i = 0;
          break;
          ad.e("MicroMsg.PressSpanTouchListener", "ACTION_UP error, lastClickSpan is null");
        }
        label1121:
        if ((j == 0) || (j == 2))
        {
          if ((j == 0) && (ADv > 0)) {
            Zr(0);
          }
          if (j == 0)
          {
            this.mYz = false;
            this.FhR = paramView.isClickable();
          }
          resetStatus();
          this.FhQ = localObject2[i];
          this.FhS = paramView;
          localObject2[i].setContext(null);
          localObject2[i].setIsPressed(true);
          localObject2[i].setEnable(true);
          paramView.invalidate();
          if (this.mYz)
          {
            localObject2[i].setIsPressed(false);
            localObject2[i].setEnable(false);
            paramView.setClickable(this.FhR);
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
          this.FhT.removeCallbacks(this.FhU);
          this.FhT.removeCallbacks(this.FhV);
          paramView.setClickable(this.FhR);
          resetStatus();
          if (DEBUG) {
            ad.i("MicroMsg.PressSpanTouchListener", "processPress action5 " + localMotionEvent.getAction());
          }
          i = 0;
          continue;
          label1393:
          resetStatus();
        }
        else
        {
          if (j == 1) {
            this.mYz = false;
          }
          if (DEBUG) {
            ad.i("MicroMsg.PressSpanTouchListener", "processPress action6 " + localMotionEvent.getAction());
          }
          i = 0;
        }
      }
      label1445:
      if (!DEBUG) {
        break label353;
      }
      ad.i("MicroMsg.PressSpanTouchListener", "processTouch action2 " + localMotionEvent.getAction());
      break label353;
      label1480:
      bool = false;
    }
  }
  
  public final void resetStatus()
  {
    AppMethodBeat.i(152335);
    if (this.FhQ != null)
    {
      this.FhQ.setIsPressed(false);
      this.FhQ.setContext(null);
      this.FhS.invalidate();
      this.FhS = null;
      this.FhQ = null;
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
      n.a(n.this, n.Pk);
      AppMethodBeat.o(152330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.n
 * JD-Core Version:    0.7.0.1
 */