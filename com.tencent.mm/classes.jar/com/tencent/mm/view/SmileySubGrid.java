package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.view.a.a;
import com.tencent.mm.view.popview.AbstractPopView;
import com.tencent.mm.view.popview.c;

public class SmileySubGrid
  extends GridView
{
  private volatile int ZFN;
  int adPm;
  int agKb;
  boolean agKc;
  private AbstractPopView agKd;
  private SmileySubGrid.c agKe;
  private int agKf;
  private a agKg;
  private b agKh;
  private View agKi;
  private boolean agKj;
  private MTimerHandler agKk;
  private volatile boolean agKl;
  public boolean agKm;
  private final Object agKn;
  private MMHandler mHandler;
  private int mTouchSlop;
  private WindowManager mWindowManager;
  Rect te;
  int tj;
  private int tz;
  int wS;
  float xUu;
  float xUv;
  private boolean xZm;
  
  public SmileySubGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105228);
    this.adPm = 6;
    this.agKb = -1;
    this.te = new Rect();
    this.mHandler = new MMHandler();
    this.agKj = false;
    this.agKk = null;
    this.ZFN = -1;
    this.agKl = false;
    this.agKm = true;
    this.agKn = new Object();
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.tz = getLongTouchTime();
    this.agKf = ViewConfiguration.getPressedStateDuration();
    AppMethodBeat.o(105228);
  }
  
  private void ah(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105235);
    this.te.set(paramInt1 - getPaddingLeft(), paramInt2 - getPaddingTop(), getPaddingRight() + paramInt3, getPaddingBottom() + paramInt4);
    AppMethodBeat.o(105235);
  }
  
  private void bE(final View paramView, int paramInt)
  {
    AppMethodBeat.i(105230);
    if (paramInt != this.ZFN)
    {
      Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks begin show:%d", new Object[] { Integer.valueOf(paramInt) });
      Object localObject = getAdapter().getItem(paramInt);
      if (this.agKd == null)
      {
        this.agKd = c.c(getContext(), localObject);
        this.mWindowManager.addView(this.agKd, this.agKd.getWindowLayoutParams());
        this.agKd.setVisibility(4);
      }
      gV(localObject);
      this.mWindowManager.updateViewLayout(this.agKd, this.agKd.getWindowLayoutParams());
      this.agKd.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(183931);
          if (SmileySubGrid.c(SmileySubGrid.this) != null)
          {
            SmileySubGrid.c(SmileySubGrid.this).setVisibility(0);
            SmileySubGrid.c(SmileySubGrid.this).mB(paramView);
            SmileySubGrid.d(SmileySubGrid.this).updateViewLayout(SmileySubGrid.c(SmileySubGrid.this), SmileySubGrid.c(SmileySubGrid.this).getWindowLayoutParams());
          }
          AppMethodBeat.o(183931);
        }
      });
    }
    for (;;)
    {
      this.ZFN = paramInt;
      AppMethodBeat.o(105230);
      return;
      Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks already show:%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  private void gV(Object paramObject)
  {
    AppMethodBeat.i(105238);
    synchronized (this.agKn)
    {
      if (this.agKd != null)
      {
        c.a(this.agKd, paramObject);
        AppMethodBeat.o(105238);
        return;
      }
      Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "mPopImageView is null.");
    }
  }
  
  private void mz(View paramView)
  {
    AppMethodBeat.i(105234);
    Rect localRect = this.te;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    ah(localRect.left, localRect.top, localRect.right, localRect.bottom);
    boolean bool = this.agKc;
    if (paramView.isEnabled() != bool) {
      if (bool) {
        break label84;
      }
    }
    label84:
    for (bool = true;; bool = false)
    {
      this.agKc = bool;
      refreshDrawableState();
      AppMethodBeat.o(105234);
      return;
    }
  }
  
  protected int getLongTouchTime()
  {
    AppMethodBeat.i(105237);
    int i = ViewConfiguration.getLongPressTimeout();
    AppMethodBeat.o(105237);
    return i;
  }
  
  public final void jMM()
  {
    AppMethodBeat.i(105233);
    if (this.agKe != null) {
      this.mHandler.removeCallbacks(this.agKe);
    }
    if (this.agKd != null)
    {
      this.mWindowManager.removeView(this.agKd);
      this.agKd = null;
      this.xZm = false;
      this.agKl = false;
    }
    this.ZFN = -1;
    AppMethodBeat.o(105233);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105240);
    super.onDetachedFromWindow();
    jMM();
    AppMethodBeat.o(105240);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    b localb = null;
    AppMethodBeat.i(105229);
    if (!this.agKm)
    {
      jMM();
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(105229);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(105229);
      return true;
      i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      this.xUu = i;
      this.xUv = j;
      i = pointToPosition(i, j);
      if ((i >= 0) && (getAdapter().isEnabled(i))) {
        this.wS = 0;
      }
      paramMotionEvent = localb;
      if (i >= 0)
      {
        this.agKb = i;
        paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
      }
      if (paramMotionEvent != null)
      {
        paramMotionEvent.setPressed(true);
        paramMotionEvent.setSelected(true);
        mz(paramMotionEvent);
      }
      if (this.agKg == null) {
        this.agKg = new a((byte)0);
      }
      this.agKg.jBA();
      this.tj = i;
      if ((i >= 0) && ((getAdapter() instanceof a)) && (((a)getAdapter()).dBU())) {
        this.mHandler.postDelayed(this.agKg, this.tz);
      }
      if ((i >= 0) && ((getAdapter() instanceof a)) && (((a)getAdapter()).dBV()))
      {
        if (this.agKk != null) {
          this.agKk.stopTimer();
        }
        this.agKk = new MTimerHandler(new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(234706);
            View localView = SmileySubGrid.this.getChildAt(SmileySubGrid.this.tj - SmileySubGrid.this.getFirstVisiblePosition());
            if ((localView != null) && (((a)SmileySubGrid.this.getAdapter()).dBV()))
            {
              if (SmileySubGrid.a(SmileySubGrid.this) == null) {
                SmileySubGrid.a(SmileySubGrid.this, new SmileySubGrid.b(SmileySubGrid.this, (byte)0));
              }
              SmileySubGrid.b localb = SmileySubGrid.a(SmileySubGrid.this);
              localb.bCC = localView;
              localb.afvP = SmileySubGrid.this.tj;
              localb.jBA();
              SmileySubGrid.b(SmileySubGrid.this).post(localb);
              AppMethodBeat.o(234706);
              return true;
            }
            AppMethodBeat.o(234706);
            return false;
          }
        }, true);
        this.agKk.startTimer(ViewConfiguration.getKeyRepeatTimeout(), ViewConfiguration.getKeyRepeatDelay());
        continue;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if (this.adPm == 5)
        {
          i = pointToPosition(i, j);
          this.tj = i;
          if ((i >= 0) && ((getAdapter() instanceof a)) && (((a)getAdapter()).dBU())) {
            if (this.agKb != i)
            {
              this.agKb = i;
              paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
              layoutChildren();
              if (paramMotionEvent != null)
              {
                paramMotionEvent.setPressed(true);
                paramMotionEvent.setSelected(true);
                mz(paramMotionEvent);
                bE(paramMotionEvent, this.agKb);
              }
            }
          }
          for (;;)
          {
            this.mHandler.removeCallbacks(this.agKg);
            break;
            jMM();
            if (this.agKb >= 0)
            {
              paramMotionEvent = getChildAt(this.agKb - getFirstVisiblePosition());
              if (paramMotionEvent != null)
              {
                paramMotionEvent.setPressed(false);
                paramMotionEvent.setSelected(false);
                mz(paramMotionEvent);
              }
            }
          }
        }
        if (Math.abs(this.xUu - i) > this.mTouchSlop)
        {
          this.wS = -1;
          this.mHandler.removeCallbacks(this.agKg);
        }
        jMM();
        continue;
        j = this.tj;
        paramMotionEvent = getChildAt(j - getFirstVisiblePosition());
        if ((i == 1) && (this.wS != -1))
        {
          if (this.agKh == null) {
            this.agKh = new b((byte)0);
          }
          localb = this.agKh;
          localb.bCC = paramMotionEvent;
          localb.afvP = j;
          localb.jBA();
          this.mHandler.post(localb);
        }
        if (this.agKk != null)
        {
          this.agKk.stopTimer();
          this.agKk = null;
        }
        this.mHandler.removeCallbacks(this.agKg);
        setScrollEnable(true);
        jMM();
        if (this.agKb >= 0)
        {
          paramMotionEvent = getChildAt(this.agKb - getFirstVisiblePosition());
          if (paramMotionEvent != null)
          {
            paramMotionEvent.setPressed(false);
            paramMotionEvent.setSelected(false);
            mz(paramMotionEvent);
          }
        }
        this.adPm = 6;
      }
    }
  }
  
  public void setFromDetail(boolean paramBoolean)
  {
    this.agKj = paramBoolean;
  }
  
  public void setIsShowPopWin(boolean paramBoolean)
  {
    this.agKm = paramBoolean;
  }
  
  protected void setScrollEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(105236);
    Log.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "cpan t setScrollEnable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.agKi != null)
    {
      if ((this.agKi instanceof MMFlipper))
      {
        ((MMFlipper)this.agKi).setScrollEnable(paramBoolean);
        AppMethodBeat.o(105236);
        return;
      }
      if ((this.agKi instanceof CustomViewPager)) {
        ((CustomViewPager)this.agKi).setCanSlide(paramBoolean);
      }
    }
    AppMethodBeat.o(105236);
  }
  
  public void setViewParent(View paramView)
  {
    this.agKi = paramView;
  }
  
  final class a
    extends SmileySubGrid.d
    implements Runnable
  {
    private a()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(105223);
      Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "LongPress run");
      int i = SmileySubGrid.this.tj;
      Object localObject = SmileySubGrid.this;
      localObject = ((SmileySubGrid)localObject).getChildAt(i - ((SmileySubGrid)localObject).getFirstVisiblePosition());
      if (localObject != null)
      {
        int j = SmileySubGrid.this.tj;
        long l = SmileySubGrid.this.getAdapter().getItemId(SmileySubGrid.this.tj);
        if (jBB())
        {
          Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "CheckForLongPress performLongPress position:[%d] id:[%d]", new Object[] { Integer.valueOf(j), Long.valueOf(l) });
          SmileySubGrid.a(SmileySubGrid.this, (View)localObject, i);
          SmileySubGrid.this.wS = -1;
          SmileySubGrid.this.adPm = 5;
          SmileySubGrid.this.setScrollEnable(false);
        }
      }
      AppMethodBeat.o(105223);
    }
  }
  
  final class b
    extends SmileySubGrid.d
    implements Runnable
  {
    int afvP;
    View bCC;
    
    private b()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(105224);
      Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "Click run");
      ListAdapter localListAdapter = SmileySubGrid.this.getAdapter();
      int i = this.afvP;
      if ((localListAdapter != null) && (SmileySubGrid.this.getCount() > 0) && (i != -1) && (i < localListAdapter.getCount()) && (jBB()))
      {
        Log.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "PerformClick performItemClick position:[%d] id:[%d] ", new Object[] { Integer.valueOf(i), Long.valueOf(localListAdapter.getItemId(i)) });
        SmileySubGrid.this.performItemClick(this.bCC, i, localListAdapter.getItemId(i));
      }
      AppMethodBeat.o(105224);
    }
  }
  
  class d
  {
    private int adTB;
    
    private d() {}
    
    public final void jBA()
    {
      AppMethodBeat.i(105226);
      this.adTB = SmileySubGrid.e(SmileySubGrid.this);
      AppMethodBeat.o(105226);
    }
    
    public final boolean jBB()
    {
      AppMethodBeat.i(105227);
      if ((SmileySubGrid.this.hasWindowFocus()) && (SmileySubGrid.f(SmileySubGrid.this) == this.adTB))
      {
        AppMethodBeat.o(105227);
        return true;
      }
      AppMethodBeat.o(105227);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.SmileySubGrid
 * JD-Core Version:    0.7.0.1
 */