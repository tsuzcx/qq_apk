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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;

public final class o
  implements View.OnTouchListener
{
  private static boolean DEBUG;
  private static int FfB;
  private static int Pw;
  private p Kru;
  private boolean Krv;
  private View Krw;
  private MMHandler Krx;
  private b Kry;
  private a Krz;
  private a mAdTagClickCallback;
  public int mAdTagClickScene;
  String mSessionId;
  private boolean ooU;
  private int position;
  private Context uiContext;
  private View view;
  
  static
  {
    AppMethodBeat.i(152338);
    DEBUG = false;
    Pw = ViewConfiguration.getTapTimeout();
    int i = ViewConfiguration.getLongPressTimeout();
    FfB = i;
    if (i > Pw * 2) {
      FfB -= Pw;
    }
    Log.d("MicroMsg.PressSpanTouchListener", "long press timeout:%d", new Object[] { Integer.valueOf(FfB) });
    AppMethodBeat.o(152338);
  }
  
  public o()
  {
    AppMethodBeat.i(152331);
    this.Kru = null;
    this.Krv = false;
    this.Krw = null;
    this.ooU = false;
    this.uiContext = null;
    this.Krx = new MMHandler(Looper.getMainLooper());
    this.Kry = new b((byte)0);
    this.Krz = new a();
    AppMethodBeat.o(152331);
  }
  
  public o(Context paramContext)
  {
    AppMethodBeat.i(152332);
    this.Kru = null;
    this.Krv = false;
    this.Krw = null;
    this.ooU = false;
    this.uiContext = null;
    this.Krx = new MMHandler(Looper.getMainLooper());
    this.Kry = new b((byte)0);
    this.Krz = new a();
    this.uiContext = paramContext;
    AppMethodBeat.o(152332);
  }
  
  private void af(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152334);
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      resetStatus();
    }
    AppMethodBeat.o(152334);
  }
  
  private void aiL(int paramInt)
  {
    AppMethodBeat.i(152336);
    if (this.view != null) {
      this.Krx.postDelayed(this.Krz, FfB - paramInt);
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
    if (paramMotionEvent.getAction() == 0) {
      paramView.setTag(2131309367, new int[] { (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY() });
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
        Log.d("MicroMsg.PressSpanTouchListener", "ontouch action: %d, isLongPress:%b " + localLayout + " " + (localCharSequence instanceof Spanned) + " " + Util.getStack().toString(), new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(this.ooU) });
      }
      localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if ((!(localCharSequence instanceof Spanned)) || (localLayout == null)) {
        break label1439;
      }
      localObject = (Spanned)localCharSequence;
      i = localMotionEvent.getAction();
      paramView.invalidate();
      if ((paramView == null) || (localObject == null) || (!g.a(paramView, (Spanned)localObject)))
      {
        if ((i != 1) && (i != 0) && (i != 2) && (i != 3)) {
          break label1404;
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
        af(localMotionEvent);
      }
      bool = false;
    }
    for (;;)
    {
      localMotionEvent.recycle();
      if (DEBUG) {
        Log.d("MicroMsg.PressSpanTouchListener", "ontouch action2: %d, isLongPress:%b " + localLayout + " " + (localCharSequence instanceof Spanned) + " processResult: " + bool + " " + Util.getStack().toString(), new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(this.ooU) });
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
        af(localMotionEvent);
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
            af(localMotionEvent);
            break label302;
          }
          if (i >= ((TextView)paramView).getTotalPaddingTop())
          {
            k = localLayout.getHeight();
            if (i <= ((TextView)paramView).getTotalPaddingTop() + k) {}
          }
          else
          {
            af(localMotionEvent);
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
        localObject = (p[])((Spanned)localObject).getSpans(i, i, p.class);
        i = localObject.length - 1;
        if (DEBUG) {
          Log.d("MicroMsg.PressSpanTouchListener", "processPress action: %d, isLongPress:%b " + localObject.length + " " + this.Kru + " " + Util.getStack().toString(), new Object[] { Integer.valueOf(localMotionEvent.getAction()), Boolean.valueOf(this.ooU) });
        }
        if (localObject.length == 0) {
          break label1352;
        }
        if (j != 1) {
          break label1080;
        }
        this.Krx.removeCallbacks(this.Kry);
        this.Krx.removeCallbacks(this.Krz);
        if (!this.ooU) {
          break label945;
        }
        resetStatus();
        this.ooU = false;
        paramView.setClickable(this.Krv);
        if (DEBUG) {
          Log.i("MicroMsg.PressSpanTouchListener", "processPress action1 " + localMotionEvent.getAction());
        }
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label1404;
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
          break label589;
        }
        j -= paramView.getPaddingLeft();
        i -= paramView.getPaddingTop();
        break label589;
        label945:
        this.ooU = false;
        if (this.Kru != null)
        {
          this.Kru.setSessionId(this.mSessionId);
          this.Kru.setAdTagClickCallback(this.mAdTagClickCallback, this.position);
          this.Kru.setAdTagClickScene(this.mAdTagClickScene);
          if (this.uiContext != null) {
            this.Kru.setContext(this.uiContext);
          }
          this.Kru.onClick(paramView);
        }
        for (;;)
        {
          paramView.setClickable(this.Krv);
          resetStatus();
          if (DEBUG) {
            Log.i("MicroMsg.PressSpanTouchListener", "processPress action2 " + localMotionEvent.getAction());
          }
          i = 0;
          break;
          Log.e("MicroMsg.PressSpanTouchListener", "ACTION_UP error, lastClickSpan is null");
        }
        label1080:
        if ((j == 0) || (j == 2))
        {
          if ((j == 0) && (FfB > 0)) {
            aiL(0);
          }
          if (j == 0)
          {
            this.ooU = false;
            this.Krv = paramView.isClickable();
          }
          resetStatus();
          this.Kru = localObject[i];
          this.Krw = paramView;
          localObject[i].setContext(null);
          localObject[i].setIsPressed(true);
          localObject[i].setEnable(true);
          paramView.invalidate();
          if (this.ooU)
          {
            localObject[i].setIsPressed(false);
            localObject[i].setEnable(false);
            paramView.setClickable(this.Krv);
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
          this.Krx.removeCallbacks(this.Kry);
          this.Krx.removeCallbacks(this.Krz);
          paramView.setClickable(this.Krv);
          resetStatus();
          if (DEBUG) {
            Log.i("MicroMsg.PressSpanTouchListener", "processPress action5 " + localMotionEvent.getAction());
          }
          i = 0;
          continue;
          label1352:
          resetStatus();
        }
        else
        {
          if (j == 1) {
            this.ooU = false;
          }
          if (DEBUG) {
            Log.i("MicroMsg.PressSpanTouchListener", "processPress action6 " + localMotionEvent.getAction());
          }
          i = 0;
        }
      }
      label1404:
      if (!DEBUG) {
        break label302;
      }
      Log.i("MicroMsg.PressSpanTouchListener", "processTouch action2 " + localMotionEvent.getAction());
      break label302;
      label1439:
      bool = false;
    }
  }
  
  public final void resetStatus()
  {
    AppMethodBeat.i(152335);
    if (this.Kru != null)
    {
      this.Kru.setIsPressed(false);
      this.Kru.setContext(null);
      this.Krw.invalidate();
      this.Krw = null;
      this.Kru = null;
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
  
  final class b
    implements Runnable
  {
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(152330);
      o.a(o.this, o.Pw);
      AppMethodBeat.o(152330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.o
 * JD-Core Version:    0.7.0.1
 */