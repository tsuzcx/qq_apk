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
import com.tencent.mm.kiss.widget.textview.StaticTextView;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class m
  implements View.OnTouchListener
{
  private static boolean DEBUG = false;
  private static int EP = ViewConfiguration.getTapTimeout();
  private static int sjY;
  String fKV;
  private boolean hqZ = false;
  private n sjV = null;
  private boolean sjW = false;
  private View sjX = null;
  private Context sjZ = null;
  private ah ska = new ah(Looper.getMainLooper());
  private b skb = new b((byte)0);
  private a skc = new a();
  private View view;
  
  static
  {
    int i = ViewConfiguration.getLongPressTimeout();
    sjY = i;
    if (i > EP * 2) {
      sjY -= EP;
    }
    y.d("MicroMsg.PressSpanTouchListener", "long press timeout:%d", new Object[] { Integer.valueOf(sjY) });
  }
  
  public m() {}
  
  public m(Context paramContext)
  {
    this.sjZ = paramContext;
  }
  
  private void Eu(int paramInt)
  {
    if (this.view != null) {
      this.ska.postDelayed(this.skc, sjY - paramInt);
    }
  }
  
  private void G(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      bcB();
    }
  }
  
  public final void bcB()
  {
    if (this.sjV != null)
    {
      this.sjV.mmZ = false;
      this.sjV.setContext(null);
      this.sjX.invalidate();
      this.sjX = null;
      this.sjV = null;
    }
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!(paramView instanceof TextView)) && (!(paramView instanceof StaticTextView))) {
      return false;
    }
    int i;
    int j;
    if (paramMotionEvent.getAction() == 0)
    {
      i = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      paramView.setTag(a.e.touch_loc, new int[] { i, j });
    }
    this.view = paramView;
    Layout localLayout;
    CharSequence localCharSequence;
    MotionEvent localMotionEvent;
    Object localObject;
    int k;
    if ((paramView instanceof TextView))
    {
      localLayout = ((TextView)paramView).getLayout();
      localCharSequence = ((TextView)paramView).getText();
      if (DEBUG) {
        y.d("MicroMsg.PressSpanTouchListener", "ontouch action: %d, isLongPress:%b " + localLayout + " " + (localCharSequence instanceof Spanned) + " " + bk.csb().toString(), new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(this.hqZ) });
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
            break label827;
          }
          j = (int)localMotionEvent.getX();
          i = (int)localMotionEvent.getY();
          if (!(paramView instanceof StaticTextView)) {
            break label447;
          }
          if (j >= ((StaticTextView)paramView).getHorizontalDrawOffset())
          {
            k = localLayout.getWidth();
            if (j <= ((StaticTextView)paramView).getHorizontalDrawOffset() + k) {
              break label406;
            }
          }
          G(localMotionEvent);
        }
      }
    }
    label406:
    label1329:
    for (;;)
    {
      localMotionEvent.recycle();
      if (DEBUG) {
        y.d("MicroMsg.PressSpanTouchListener", "ontouch action2: %d, isLongPress:%b " + localLayout + " " + (localCharSequence instanceof Spanned) + " processResult: false " + bk.csb().toString(), new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(this.hqZ) });
      }
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
        G(localMotionEvent);
        continue;
        label447:
        if ((paramView instanceof TextView))
        {
          if (j >= ((TextView)paramView).getTotalPaddingLeft())
          {
            k = localLayout.getWidth();
            if (j <= ((TextView)paramView).getTotalPaddingLeft() + k) {}
          }
          else
          {
            G(localMotionEvent);
            continue;
          }
          if (i >= ((TextView)paramView).getTotalPaddingTop())
          {
            k = localLayout.getHeight();
            if (i <= ((TextView)paramView).getTotalPaddingTop() + k) {}
          }
          else
          {
            G(localMotionEvent);
            continue;
          }
        }
      }
      if ((paramView instanceof TextView))
      {
        j -= ((TextView)paramView).getTotalPaddingLeft();
        i -= ((TextView)paramView).getTotalPaddingTop();
        label567:
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
          y.d("MicroMsg.PressSpanTouchListener", "processPress action: %d, isLongPress:%b " + localObject.length + " " + this.sjV + " " + bk.csb().toString(), new Object[] { Integer.valueOf(localMotionEvent.getAction()), Boolean.valueOf(this.hqZ) });
        }
        if (localObject.length == 0) {
          break label1281;
        }
        if (j != 1) {
          break label1020;
        }
        this.ska.removeCallbacks(this.skb);
        this.ska.removeCallbacks(this.skc);
        if (!this.hqZ) {
          break label913;
        }
        bcB();
        this.hqZ = false;
        paramView.setClickable(this.sjW);
        if (DEBUG) {
          y.i("MicroMsg.PressSpanTouchListener", "processPress action1 " + localMotionEvent.getAction());
        }
      }
      for (;;)
      {
        label827:
        if (!DEBUG) {
          break label1329;
        }
        y.i("MicroMsg.PressSpanTouchListener", "processTouch action2 " + localMotionEvent.getAction());
        break;
        if ((paramView instanceof StaticTextView))
        {
          j -= ((StaticTextView)paramView).getHorizontalDrawOffset();
          i -= ((StaticTextView)paramView).getVerticalDrawOffset();
          break label567;
        }
        j -= paramView.getPaddingLeft();
        i -= paramView.getPaddingTop();
        break label567;
        this.hqZ = false;
        if (this.sjV != null)
        {
          this.sjV.setSessionId(this.fKV);
          if (this.sjZ != null) {
            this.sjV.setContext(this.sjZ);
          }
          this.sjV.onClick(paramView);
        }
        for (;;)
        {
          paramView.setClickable(this.sjW);
          bcB();
          if (!DEBUG) {
            break;
          }
          y.i("MicroMsg.PressSpanTouchListener", "processPress action2 " + localMotionEvent.getAction());
          break;
          y.e("MicroMsg.PressSpanTouchListener", "ACTION_UP error, lastClickSpan is null");
        }
        label1020:
        if ((j == 0) || (j == 2))
        {
          if ((j == 0) && (sjY > 0)) {
            Eu(0);
          }
          if (j == 0) {
            this.sjW = paramView.isClickable();
          }
          bcB();
          this.sjV = localObject[i];
          this.sjX = paramView;
          localObject[i].setContext(null);
          localObject[i].mmZ = true;
          localObject[i].mEnable = true;
          paramView.invalidate();
          if (this.hqZ)
          {
            localObject[i].mmZ = false;
            localObject[i].mEnable = false;
            paramView.setClickable(this.sjW);
            if (DEBUG) {
              y.i("MicroMsg.PressSpanTouchListener", "processPress action3 " + localMotionEvent.getAction());
            }
          }
          else if (DEBUG)
          {
            y.i("MicroMsg.PressSpanTouchListener", "processPress action4 " + localMotionEvent.getAction());
          }
        }
        else if (j == 3)
        {
          this.ska.removeCallbacks(this.skb);
          this.ska.removeCallbacks(this.skc);
          paramView.setClickable(this.sjW);
          bcB();
          if (DEBUG)
          {
            y.i("MicroMsg.PressSpanTouchListener", "processPress action5 " + localMotionEvent.getAction());
            continue;
            bcB();
          }
        }
        else
        {
          if (j == 1) {
            this.hqZ = false;
          }
          if (DEBUG) {
            y.i("MicroMsg.PressSpanTouchListener", "processPress action6 " + localMotionEvent.getAction());
          }
        }
      }
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      if ((m.a(m.this) != null) && (m.a(m.this).isPressed()))
      {
        y.d("MicroMsg.PressSpanTouchListener", "long pressed timeout");
        m.b(m.this);
        m.this.bcB();
      }
    }
  }
  
  private final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      m.a(m.this, m.EP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.m
 * JD-Core Version:    0.7.0.1
 */