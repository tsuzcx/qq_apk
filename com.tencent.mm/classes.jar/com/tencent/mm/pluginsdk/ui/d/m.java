package com.tencent.mm.pluginsdk.ui.d;

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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

public final class m
  implements View.OnTouchListener
{
  private static boolean DEBUG;
  private static int Fy;
  private static int wcF;
  private boolean jfJ;
  String mSessionId;
  private Context uiContext;
  private View view;
  private n wcC;
  private boolean wcD;
  private View wcE;
  private ak wcG;
  private b wcH;
  private m.a wcI;
  
  static
  {
    AppMethodBeat.i(79877);
    DEBUG = false;
    Fy = ViewConfiguration.getTapTimeout();
    int i = ViewConfiguration.getLongPressTimeout();
    wcF = i;
    if (i > Fy * 2) {
      wcF -= Fy;
    }
    ab.d("MicroMsg.PressSpanTouchListener", "long press timeout:%d", new Object[] { Integer.valueOf(wcF) });
    AppMethodBeat.o(79877);
  }
  
  public m()
  {
    AppMethodBeat.i(79870);
    this.wcC = null;
    this.wcD = false;
    this.wcE = null;
    this.jfJ = false;
    this.uiContext = null;
    this.wcG = new ak(Looper.getMainLooper());
    this.wcH = new b((byte)0);
    this.wcI = new m.a(this);
    AppMethodBeat.o(79870);
  }
  
  public m(Context paramContext)
  {
    AppMethodBeat.i(79871);
    this.wcC = null;
    this.wcD = false;
    this.wcE = null;
    this.jfJ = false;
    this.uiContext = null;
    this.wcG = new ak(Looper.getMainLooper());
    this.wcH = new b((byte)0);
    this.wcI = new m.a(this);
    this.uiContext = paramContext;
    AppMethodBeat.o(79871);
  }
  
  private void Ms(int paramInt)
  {
    AppMethodBeat.i(79875);
    if (this.view != null) {
      this.wcG.postDelayed(this.wcI, wcF - paramInt);
    }
    AppMethodBeat.o(79875);
  }
  
  private void Q(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79873);
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      aEa();
    }
    AppMethodBeat.o(79873);
  }
  
  public final void aEa()
  {
    AppMethodBeat.i(79874);
    if (this.wcC != null)
    {
      this.wcC.setIsPressed(false);
      this.wcC.setContext(null);
      this.wcE.invalidate();
      this.wcE = null;
      this.wcC = null;
    }
    AppMethodBeat.o(79874);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(79872);
    if ((!(paramView instanceof TextView)) && (!(paramView instanceof StaticTextView)))
    {
      AppMethodBeat.o(79872);
      return false;
    }
    if (paramMotionEvent.getAction() == 0) {
      paramView.setTag(2131820681, new int[] { (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY() });
    }
    this.view = paramView;
    Layout localLayout;
    CharSequence localCharSequence;
    MotionEvent localMotionEvent;
    Object localObject;
    int i;
    int j;
    int k;
    if ((paramView instanceof TextView))
    {
      localLayout = ((TextView)paramView).getLayout();
      localCharSequence = ((TextView)paramView).getText();
      if (DEBUG) {
        ab.d("MicroMsg.PressSpanTouchListener", "ontouch action: %d, isLongPress:%b " + localLayout + " " + (localCharSequence instanceof Spanned) + " " + bo.dtY().toString(), new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(this.jfJ) });
      }
      localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (((localCharSequence instanceof Spanned)) && (localLayout != null))
      {
        localObject = (Spanned)localCharSequence;
        i = localMotionEvent.getAction();
        paramView.invalidate();
        if ((paramView == null) || (localObject == null) || (!e.a(paramView, (Spanned)localObject)))
        {
          if ((i != 1) && (i != 0) && (i != 2) && (i != 3)) {
            break label836;
          }
          j = (int)localMotionEvent.getX();
          i = (int)localMotionEvent.getY();
          if (!(paramView instanceof StaticTextView)) {
            break label456;
          }
          if (j >= ((StaticTextView)paramView).getHorizontalDrawOffset())
          {
            k = localLayout.getWidth();
            if (j <= ((StaticTextView)paramView).getHorizontalDrawOffset() + k) {
              break label415;
            }
          }
          Q(localMotionEvent);
        }
      }
    }
    label415:
    label1338:
    for (;;)
    {
      localMotionEvent.recycle();
      if (DEBUG) {
        ab.d("MicroMsg.PressSpanTouchListener", "ontouch action2: %d, isLongPress:%b " + localLayout + " " + (localCharSequence instanceof Spanned) + " processResult: false " + bo.dtY().toString(), new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(this.jfJ) });
      }
      AppMethodBeat.o(79872);
      return false;
      localLayout = ((StaticTextView)paramView).getTvLayout();
      localCharSequence = ((StaticTextView)paramView).getText();
      break;
      if (i >= ((StaticTextView)paramView).getVerticalDrawOffset())
      {
        k = localLayout.getHeight();
        if (i <= ((StaticTextView)paramView).getVerticalDrawOffset() + k) {}
      }
      else
      {
        Q(localMotionEvent);
        continue;
        label456:
        if ((paramView instanceof TextView))
        {
          if (j >= ((TextView)paramView).getTotalPaddingLeft())
          {
            k = localLayout.getWidth();
            if (j <= ((TextView)paramView).getTotalPaddingLeft() + k) {}
          }
          else
          {
            Q(localMotionEvent);
            continue;
          }
          if (i >= ((TextView)paramView).getTotalPaddingTop())
          {
            k = localLayout.getHeight();
            if (i <= ((TextView)paramView).getTotalPaddingTop() + k) {}
          }
          else
          {
            Q(localMotionEvent);
            continue;
          }
        }
      }
      if ((paramView instanceof TextView))
      {
        j -= ((TextView)paramView).getTotalPaddingLeft();
        i -= ((TextView)paramView).getTotalPaddingTop();
        label576:
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
        localObject = (n[])((Spanned)localObject).getSpans(i, i, n.class);
        i = localObject.length - 1;
        if (DEBUG) {
          ab.d("MicroMsg.PressSpanTouchListener", "processPress action: %d, isLongPress:%b " + localObject.length + " " + this.wcC + " " + bo.dtY().toString(), new Object[] { Integer.valueOf(localMotionEvent.getAction()), Boolean.valueOf(this.jfJ) });
        }
        if (localObject.length == 0) {
          break label1290;
        }
        if (j != 1) {
          break label1029;
        }
        this.wcG.removeCallbacks(this.wcH);
        this.wcG.removeCallbacks(this.wcI);
        if (!this.jfJ) {
          break label922;
        }
        aEa();
        this.jfJ = false;
        paramView.setClickable(this.wcD);
        if (DEBUG) {
          ab.i("MicroMsg.PressSpanTouchListener", "processPress action1 " + localMotionEvent.getAction());
        }
      }
      for (;;)
      {
        label836:
        if (!DEBUG) {
          break label1338;
        }
        ab.i("MicroMsg.PressSpanTouchListener", "processTouch action2 " + localMotionEvent.getAction());
        break;
        if ((paramView instanceof StaticTextView))
        {
          j -= ((StaticTextView)paramView).getHorizontalDrawOffset();
          i -= ((StaticTextView)paramView).getVerticalDrawOffset();
          break label576;
        }
        j -= paramView.getPaddingLeft();
        i -= paramView.getPaddingTop();
        break label576;
        this.jfJ = false;
        if (this.wcC != null)
        {
          this.wcC.setSessionId(this.mSessionId);
          if (this.uiContext != null) {
            this.wcC.setContext(this.uiContext);
          }
          this.wcC.onClick(paramView);
        }
        for (;;)
        {
          paramView.setClickable(this.wcD);
          aEa();
          if (!DEBUG) {
            break;
          }
          ab.i("MicroMsg.PressSpanTouchListener", "processPress action2 " + localMotionEvent.getAction());
          break;
          ab.e("MicroMsg.PressSpanTouchListener", "ACTION_UP error, lastClickSpan is null");
        }
        if ((j == 0) || (j == 2))
        {
          if ((j == 0) && (wcF > 0)) {
            Ms(0);
          }
          if (j == 0) {
            this.wcD = paramView.isClickable();
          }
          aEa();
          this.wcC = localObject[i];
          this.wcE = paramView;
          localObject[i].setContext(null);
          localObject[i].setIsPressed(true);
          localObject[i].setEnable(true);
          paramView.invalidate();
          if (this.jfJ)
          {
            localObject[i].setIsPressed(false);
            localObject[i].setEnable(false);
            paramView.setClickable(this.wcD);
            if (DEBUG) {
              ab.i("MicroMsg.PressSpanTouchListener", "processPress action3 " + localMotionEvent.getAction());
            }
          }
          else if (DEBUG)
          {
            ab.i("MicroMsg.PressSpanTouchListener", "processPress action4 " + localMotionEvent.getAction());
          }
        }
        else if (j == 3)
        {
          this.wcG.removeCallbacks(this.wcH);
          this.wcG.removeCallbacks(this.wcI);
          paramView.setClickable(this.wcD);
          aEa();
          if (DEBUG)
          {
            ab.i("MicroMsg.PressSpanTouchListener", "processPress action5 " + localMotionEvent.getAction());
            continue;
            aEa();
          }
        }
        else
        {
          if (j == 1) {
            this.jfJ = false;
          }
          if (DEBUG) {
            ab.i("MicroMsg.PressSpanTouchListener", "processPress action6 " + localMotionEvent.getAction());
          }
        }
      }
    }
  }
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(79869);
      m.a(m.this, m.Fy);
      AppMethodBeat.o(79869);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.m
 * JD-Core Version:    0.7.0.1
 */