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
import com.tencent.mm.kiss.widget.textview.PLSysTextView;
import com.tencent.mm.kiss.widget.textview.StaticTextView;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

public final class s
  implements View.OnTouchListener
{
  private static boolean DEBUG;
  private static int RXH;
  private static int bsP;
  private t YoV;
  private boolean YoW;
  private View YoX;
  private MMHandler YoY;
  private b YoZ;
  private a Ypa;
  private a mAdTagClickCallback;
  public int mAdTagClickScene;
  String mSessionId;
  private int position;
  private boolean uAR;
  private Context uiContext;
  private View view;
  
  static
  {
    AppMethodBeat.i(152338);
    DEBUG = false;
    bsP = ViewConfiguration.getTapTimeout();
    int i = ViewConfiguration.getLongPressTimeout();
    RXH = i;
    if (i > bsP * 2) {
      RXH -= bsP;
    }
    Log.d("MicroMsg.PressSpanTouchListener", "long press timeout:%d", new Object[] { Integer.valueOf(RXH) });
    AppMethodBeat.o(152338);
  }
  
  public s()
  {
    AppMethodBeat.i(152331);
    this.YoV = null;
    this.YoW = false;
    this.YoX = null;
    this.uAR = false;
    this.uiContext = null;
    this.YoY = new MMHandler(Looper.getMainLooper());
    this.YoZ = new b((byte)0);
    this.Ypa = new a();
    AppMethodBeat.o(152331);
  }
  
  public s(Context paramContext)
  {
    AppMethodBeat.i(152332);
    this.YoV = null;
    this.YoW = false;
    this.YoX = null;
    this.uAR = false;
    this.uiContext = null;
    this.YoY = new MMHandler(Looper.getMainLooper());
    this.YoZ = new b((byte)0);
    this.Ypa = new a();
    this.uiContext = paramContext;
    AppMethodBeat.o(152332);
  }
  
  private void ar(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152334);
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      resetStatus();
    }
    AppMethodBeat.o(152334);
  }
  
  private void awX(int paramInt)
  {
    AppMethodBeat.i(152336);
    if (this.view != null) {
      this.YoY.postDelayed(this.Ypa, RXH - paramInt);
    }
    AppMethodBeat.o(152336);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152333);
    if ((!(paramView instanceof TextView)) && (!(paramView instanceof StaticTextView)))
    {
      AppMethodBeat.o(152333);
      return false;
    }
    int i;
    int j;
    if (paramMotionEvent.getAction() == 0)
    {
      i = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      paramView.setTag(c.e.touch_loc, new int[] { i, j });
    }
    this.view = paramView;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    label110:
    Object localObject4;
    int k;
    label324:
    boolean bool;
    if ((paramView instanceof TextView)) {
      if ((paramView instanceof PLSysTextView))
      {
        localObject1 = ((PLSysTextView)paramView).getTvLayout();
        localObject3 = ((TextView)paramView).getText();
        localObject2 = localObject1;
        localObject1 = localObject3;
        if (DEBUG) {
          Log.d("MicroMsg.PressSpanTouchListener", "ontouch action: %d, isLongPress:%b " + localObject2 + " " + (localObject1 instanceof Spanned) + " " + Util.getStack().toString(), new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(this.uAR) });
        }
        localObject3 = MotionEvent.obtain(paramMotionEvent);
        if ((!(localObject1 instanceof Spanned)) || (localObject2 == null)) {
          break label1474;
        }
        localObject4 = (Spanned)localObject1;
        i = ((MotionEvent)localObject3).getAction();
        paramView.invalidate();
        if ((paramView == null) || (localObject4 == null) || (!g.a(paramView, (Spanned)localObject4)))
        {
          if ((i != 1) && (i != 0) && (i != 2) && (i != 3)) {
            break label1439;
          }
          j = (int)((MotionEvent)localObject3).getX();
          i = (int)((MotionEvent)localObject3).getY();
          if (!(paramView instanceof StaticTextView)) {
            break label504;
          }
          if (j >= ((StaticTextView)paramView).getHorizontalDrawOffset())
          {
            k = ((Layout)localObject2).getWidth();
            if (j <= ((StaticTextView)paramView).getHorizontalDrawOffset() + k) {
              break label463;
            }
          }
          ar((MotionEvent)localObject3);
        }
        bool = false;
      }
    }
    for (;;)
    {
      ((MotionEvent)localObject3).recycle();
      if (DEBUG) {
        Log.d("MicroMsg.PressSpanTouchListener", "ontouch action2: %d, isLongPress:%b " + localObject2 + " " + (localObject1 instanceof Spanned) + " processResult: " + bool + " " + Util.getStack().toString(), new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(this.uAR) });
      }
      AppMethodBeat.o(152333);
      return bool;
      localObject1 = ((TextView)paramView).getLayout();
      break;
      localObject2 = ((StaticTextView)paramView).getTvLayout();
      localObject1 = ((StaticTextView)paramView).getText();
      break label110;
      label463:
      if (i >= ((StaticTextView)paramView).getVerticalDrawOffset())
      {
        k = ((Layout)localObject2).getHeight();
        if (i <= ((StaticTextView)paramView).getVerticalDrawOffset() + k) {}
      }
      else
      {
        ar((MotionEvent)localObject3);
        break label324;
        label504:
        if ((paramView instanceof TextView))
        {
          if (j >= ((TextView)paramView).getTotalPaddingLeft())
          {
            k = ((Layout)localObject2).getWidth();
            if (j <= ((TextView)paramView).getTotalPaddingLeft() + k) {}
          }
          else
          {
            ar((MotionEvent)localObject3);
            break label324;
          }
          if (i >= ((TextView)paramView).getTotalPaddingTop())
          {
            k = ((Layout)localObject2).getHeight();
            if (i <= ((TextView)paramView).getTotalPaddingTop() + k) {}
          }
          else
          {
            ar((MotionEvent)localObject3);
            break label324;
          }
        }
      }
      if ((paramView instanceof TextView))
      {
        j -= ((TextView)paramView).getTotalPaddingLeft();
        i -= ((TextView)paramView).getTotalPaddingTop();
        label624:
        k = paramView.getScrollX();
        j = ((Layout)localObject2).getOffsetForHorizontal(((Layout)localObject2).getLineForVertical(i + paramView.getScrollY()), j + k);
        i = j;
        if ((paramView instanceof TextView))
        {
          i = j;
          if (j < ((Spanned)localObject4).length()) {
            i = j + 1;
          }
        }
        j = ((MotionEvent)localObject3).getAction();
        localObject4 = (t[])((Spanned)localObject4).getSpans(i, i, t.class);
        i = localObject4.length - 1;
        if (DEBUG) {
          Log.d("MicroMsg.PressSpanTouchListener", "processPress action: %d, isLongPress:%b " + localObject4.length + " " + this.YoV + " " + Util.getStack().toString(), new Object[] { Integer.valueOf(((MotionEvent)localObject3).getAction()), Boolean.valueOf(this.uAR) });
        }
        if (localObject4.length == 0) {
          break label1387;
        }
        if (j != 1) {
          break label1115;
        }
        this.YoY.removeCallbacks(this.YoZ);
        this.YoY.removeCallbacks(this.Ypa);
        if (!this.uAR) {
          break label980;
        }
        resetStatus();
        this.uAR = false;
        paramView.setClickable(this.YoW);
        if (DEBUG) {
          Log.i("MicroMsg.PressSpanTouchListener", "processPress action1 " + ((MotionEvent)localObject3).getAction());
        }
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label1439;
        }
        if (DEBUG) {
          Log.i("MicroMsg.PressSpanTouchListener", "processTouch action1 " + ((MotionEvent)localObject3).getAction());
        }
        bool = true;
        break;
        if ((paramView instanceof StaticTextView))
        {
          j -= ((StaticTextView)paramView).getHorizontalDrawOffset();
          i -= ((StaticTextView)paramView).getVerticalDrawOffset();
          break label624;
        }
        j -= paramView.getPaddingLeft();
        i -= paramView.getPaddingTop();
        break label624;
        label980:
        this.uAR = false;
        if (this.YoV != null)
        {
          this.YoV.setSessionId(this.mSessionId);
          this.YoV.setAdTagClickCallback(this.mAdTagClickCallback, this.position);
          this.YoV.setAdTagClickScene(this.mAdTagClickScene);
          if (this.uiContext != null) {
            this.YoV.setContext(this.uiContext);
          }
          this.YoV.onClick(paramView);
        }
        for (;;)
        {
          paramView.setClickable(this.YoW);
          resetStatus();
          if (DEBUG) {
            Log.i("MicroMsg.PressSpanTouchListener", "processPress action2 " + ((MotionEvent)localObject3).getAction());
          }
          i = 0;
          break;
          Log.e("MicroMsg.PressSpanTouchListener", "ACTION_UP error, lastClickSpan is null");
        }
        label1115:
        if ((j == 0) || (j == 2))
        {
          if ((j == 0) && (RXH > 0)) {
            awX(0);
          }
          if (j == 0)
          {
            this.uAR = false;
            this.YoW = paramView.isClickable();
          }
          resetStatus();
          this.YoV = localObject4[i];
          this.YoX = paramView;
          localObject4[i].setContext(null);
          localObject4[i].setIsPressed(true);
          localObject4[i].setEnable(true);
          paramView.invalidate();
          if (this.uAR)
          {
            localObject4[i].setIsPressed(false);
            localObject4[i].setEnable(false);
            paramView.setClickable(this.YoW);
            if (DEBUG) {
              Log.i("MicroMsg.PressSpanTouchListener", "processPress action3 " + ((MotionEvent)localObject3).getAction());
            }
            i = 0;
          }
          else
          {
            if (DEBUG) {
              Log.i("MicroMsg.PressSpanTouchListener", "processPress action4 " + ((MotionEvent)localObject3).getAction());
            }
            i = 1;
          }
        }
        else if (j == 3)
        {
          this.YoY.removeCallbacks(this.YoZ);
          this.YoY.removeCallbacks(this.Ypa);
          paramView.setClickable(this.YoW);
          resetStatus();
          if (DEBUG) {
            Log.i("MicroMsg.PressSpanTouchListener", "processPress action5 " + ((MotionEvent)localObject3).getAction());
          }
          i = 0;
          continue;
          label1387:
          resetStatus();
        }
        else
        {
          if (j == 1) {
            this.uAR = false;
          }
          if (DEBUG) {
            Log.i("MicroMsg.PressSpanTouchListener", "processPress action6 " + ((MotionEvent)localObject3).getAction());
          }
          i = 0;
        }
      }
      label1439:
      if (!DEBUG) {
        break label324;
      }
      Log.i("MicroMsg.PressSpanTouchListener", "processTouch action2 " + ((MotionEvent)localObject3).getAction());
      break label324;
      label1474:
      bool = false;
    }
  }
  
  public final void resetStatus()
  {
    AppMethodBeat.i(152335);
    if (this.YoV != null)
    {
      this.YoV.setIsPressed(false);
      this.YoV.setContext(null);
      this.YoX.invalidate();
      this.YoX = null;
      this.YoV = null;
    }
    AppMethodBeat.o(152335);
  }
  
  public final void setAdTagClickCallback(a parama, int paramInt)
  {
    this.mAdTagClickCallback = parama;
    this.position = paramInt;
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(152329);
      if ((s.a(s.this) != null) && (s.a(s.this).isPressed()))
      {
        Log.d("MicroMsg.PressSpanTouchListener", "long pressed timeout");
        s.b(s.this);
        s.this.resetStatus();
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
      s.a(s.this, s.bsP);
      AppMethodBeat.o(152330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.s
 * JD-Core Version:    0.7.0.1
 */