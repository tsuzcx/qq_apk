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
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

public final class o
  implements View.OnTouchListener
{
  private static boolean DEBUG;
  private static int Lug;
  private static int MN;
  private p RsB;
  private boolean RsC;
  private View RsD;
  private MMHandler RsE;
  private o.b RsF;
  private a RsG;
  private a mAdTagClickCallback;
  public int mAdTagClickScene;
  String mSessionId;
  private int position;
  private boolean rqI;
  private Context uiContext;
  private View view;
  
  static
  {
    AppMethodBeat.i(152338);
    DEBUG = false;
    MN = ViewConfiguration.getTapTimeout();
    int i = ViewConfiguration.getLongPressTimeout();
    Lug = i;
    if (i > MN * 2) {
      Lug -= MN;
    }
    Log.d("MicroMsg.PressSpanTouchListener", "long press timeout:%d", new Object[] { Integer.valueOf(Lug) });
    AppMethodBeat.o(152338);
  }
  
  public o()
  {
    AppMethodBeat.i(152331);
    this.RsB = null;
    this.RsC = false;
    this.RsD = null;
    this.rqI = false;
    this.uiContext = null;
    this.RsE = new MMHandler(Looper.getMainLooper());
    this.RsF = new o.b(this, (byte)0);
    this.RsG = new a();
    AppMethodBeat.o(152331);
  }
  
  public o(Context paramContext)
  {
    AppMethodBeat.i(152332);
    this.RsB = null;
    this.RsC = false;
    this.RsD = null;
    this.rqI = false;
    this.uiContext = null;
    this.RsE = new MMHandler(Looper.getMainLooper());
    this.RsF = new o.b(this, (byte)0);
    this.RsG = new a();
    this.uiContext = paramContext;
    AppMethodBeat.o(152332);
  }
  
  private void ao(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152334);
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      resetStatus();
    }
    AppMethodBeat.o(152334);
  }
  
  private void aqR(int paramInt)
  {
    AppMethodBeat.i(152336);
    if (this.view != null) {
      this.RsE.postDelayed(this.RsG, Lug - paramInt);
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
    Layout localLayout;
    CharSequence localCharSequence;
    MotionEvent localMotionEvent;
    Object localObject;
    int k;
    label309:
    boolean bool;
    if ((paramView instanceof TextView))
    {
      localLayout = ((TextView)paramView).getLayout();
      localCharSequence = ((TextView)paramView).getText();
      if (DEBUG) {
        Log.d("MicroMsg.PressSpanTouchListener", "ontouch action: %d, isLongPress:%b " + localLayout + " " + (localCharSequence instanceof Spanned) + " " + Util.getStack().toString(), new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(this.rqI) });
      }
      localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if ((!(localCharSequence instanceof Spanned)) || (localLayout == null)) {
        break label1446;
      }
      localObject = (Spanned)localCharSequence;
      i = localMotionEvent.getAction();
      paramView.invalidate();
      if ((paramView == null) || (localObject == null) || (!g.a(paramView, (Spanned)localObject)))
      {
        if ((i != 1) && (i != 0) && (i != 2) && (i != 3)) {
          break label1411;
        }
        j = (int)localMotionEvent.getX();
        i = (int)localMotionEvent.getY();
        if (!(paramView instanceof StaticTextView)) {
          break label476;
        }
        if (j >= ((StaticTextView)paramView).getHorizontalDrawOffset())
        {
          k = localLayout.getWidth();
          if (j <= ((StaticTextView)paramView).getHorizontalDrawOffset() + k) {
            break label435;
          }
        }
        ao(localMotionEvent);
      }
      bool = false;
    }
    for (;;)
    {
      localMotionEvent.recycle();
      if (DEBUG) {
        Log.d("MicroMsg.PressSpanTouchListener", "ontouch action2: %d, isLongPress:%b " + localLayout + " " + (localCharSequence instanceof Spanned) + " processResult: " + bool + " " + Util.getStack().toString(), new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(this.rqI) });
      }
      AppMethodBeat.o(152333);
      return bool;
      localLayout = ((StaticTextView)paramView).getTvLayout();
      localCharSequence = ((StaticTextView)paramView).getText();
      break;
      label435:
      if (i >= ((StaticTextView)paramView).getVerticalDrawOffset())
      {
        k = localLayout.getHeight();
        if (i <= ((StaticTextView)paramView).getVerticalDrawOffset() + k) {}
      }
      else
      {
        ao(localMotionEvent);
        break label309;
        label476:
        if ((paramView instanceof TextView))
        {
          if (j >= ((TextView)paramView).getTotalPaddingLeft())
          {
            k = localLayout.getWidth();
            if (j <= ((TextView)paramView).getTotalPaddingLeft() + k) {}
          }
          else
          {
            ao(localMotionEvent);
            break label309;
          }
          if (i >= ((TextView)paramView).getTotalPaddingTop())
          {
            k = localLayout.getHeight();
            if (i <= ((TextView)paramView).getTotalPaddingTop() + k) {}
          }
          else
          {
            ao(localMotionEvent);
            break label309;
          }
        }
      }
      if ((paramView instanceof TextView))
      {
        j -= ((TextView)paramView).getTotalPaddingLeft();
        i -= ((TextView)paramView).getTotalPaddingTop();
        label596:
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
        localObject = (p[])((Spanned)localObject).getSpans(i, i, p.class);
        i = localObject.length - 1;
        if (DEBUG) {
          Log.d("MicroMsg.PressSpanTouchListener", "processPress action: %d, isLongPress:%b " + localObject.length + " " + this.RsB + " " + Util.getStack().toString(), new Object[] { Integer.valueOf(localMotionEvent.getAction()), Boolean.valueOf(this.rqI) });
        }
        if (localObject.length == 0) {
          break label1359;
        }
        if (j != 1) {
          break label1087;
        }
        this.RsE.removeCallbacks(this.RsF);
        this.RsE.removeCallbacks(this.RsG);
        if (!this.rqI) {
          break label952;
        }
        resetStatus();
        this.rqI = false;
        paramView.setClickable(this.RsC);
        if (DEBUG) {
          Log.i("MicroMsg.PressSpanTouchListener", "processPress action1 " + localMotionEvent.getAction());
        }
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label1411;
        }
        if (DEBUG) {
          Log.i("MicroMsg.PressSpanTouchListener", "processTouch action1 " + localMotionEvent.getAction());
        }
        bool = true;
        break;
        if ((paramView instanceof StaticTextView))
        {
          j -= ((StaticTextView)paramView).getHorizontalDrawOffset();
          i -= ((StaticTextView)paramView).getVerticalDrawOffset();
          break label596;
        }
        j -= paramView.getPaddingLeft();
        i -= paramView.getPaddingTop();
        break label596;
        label952:
        this.rqI = false;
        if (this.RsB != null)
        {
          this.RsB.setSessionId(this.mSessionId);
          this.RsB.setAdTagClickCallback(this.mAdTagClickCallback, this.position);
          this.RsB.setAdTagClickScene(this.mAdTagClickScene);
          if (this.uiContext != null) {
            this.RsB.setContext(this.uiContext);
          }
          this.RsB.onClick(paramView);
        }
        for (;;)
        {
          paramView.setClickable(this.RsC);
          resetStatus();
          if (DEBUG) {
            Log.i("MicroMsg.PressSpanTouchListener", "processPress action2 " + localMotionEvent.getAction());
          }
          i = 0;
          break;
          Log.e("MicroMsg.PressSpanTouchListener", "ACTION_UP error, lastClickSpan is null");
        }
        label1087:
        if ((j == 0) || (j == 2))
        {
          if ((j == 0) && (Lug > 0)) {
            aqR(0);
          }
          if (j == 0)
          {
            this.rqI = false;
            this.RsC = paramView.isClickable();
          }
          resetStatus();
          this.RsB = localObject[i];
          this.RsD = paramView;
          localObject[i].setContext(null);
          localObject[i].setIsPressed(true);
          localObject[i].setEnable(true);
          paramView.invalidate();
          if (this.rqI)
          {
            localObject[i].setIsPressed(false);
            localObject[i].setEnable(false);
            paramView.setClickable(this.RsC);
            if (DEBUG) {
              Log.i("MicroMsg.PressSpanTouchListener", "processPress action3 " + localMotionEvent.getAction());
            }
            i = 0;
          }
          else
          {
            if (DEBUG) {
              Log.i("MicroMsg.PressSpanTouchListener", "processPress action4 " + localMotionEvent.getAction());
            }
            i = 1;
          }
        }
        else if (j == 3)
        {
          this.RsE.removeCallbacks(this.RsF);
          this.RsE.removeCallbacks(this.RsG);
          paramView.setClickable(this.RsC);
          resetStatus();
          if (DEBUG) {
            Log.i("MicroMsg.PressSpanTouchListener", "processPress action5 " + localMotionEvent.getAction());
          }
          i = 0;
          continue;
          label1359:
          resetStatus();
        }
        else
        {
          if (j == 1) {
            this.rqI = false;
          }
          if (DEBUG) {
            Log.i("MicroMsg.PressSpanTouchListener", "processPress action6 " + localMotionEvent.getAction());
          }
          i = 0;
        }
      }
      label1411:
      if (!DEBUG) {
        break label309;
      }
      Log.i("MicroMsg.PressSpanTouchListener", "processTouch action2 " + localMotionEvent.getAction());
      break label309;
      label1446:
      bool = false;
    }
  }
  
  public final void resetStatus()
  {
    AppMethodBeat.i(152335);
    if (this.RsB != null)
    {
      this.RsB.setIsPressed(false);
      this.RsB.setContext(null);
      this.RsD.invalidate();
      this.RsD = null;
      this.RsB = null;
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
      if ((o.a(o.this) != null) && (o.a(o.this).isPressed()))
      {
        Log.d("MicroMsg.PressSpanTouchListener", "long pressed timeout");
        o.b(o.this);
        o.this.resetStatus();
      }
      AppMethodBeat.o(152329);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.o
 * JD-Core Version:    0.7.0.1
 */