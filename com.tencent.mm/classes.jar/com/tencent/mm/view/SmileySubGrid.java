package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.view.a.a;
import com.tencent.mm.view.popview.AbstractPopView;
import com.tencent.mm.view.popview.c;

public class SmileySubGrid
  extends SmileyGrid
{
  int FVW;
  int HXP;
  boolean HXQ;
  private AbstractPopView HXR;
  private c HXS;
  private int HXT;
  private a HXU;
  private b HXV;
  private View HXW;
  private boolean HXX;
  private av HXY;
  private volatile int HXZ;
  private volatile boolean HYa;
  public boolean HYb;
  private final Object HYc;
  Rect ajU;
  int ajZ;
  private int akM;
  int avs;
  private ap mHandler;
  private int mTouchSlop;
  float oEd;
  float oEe;
  private WindowManager oEl;
  private boolean oIL;
  
  public SmileySubGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105228);
    this.FVW = 6;
    this.HXP = -1;
    this.ajU = new Rect();
    this.mHandler = new ap();
    this.HXX = false;
    this.HXY = null;
    this.HXZ = -1;
    this.HYa = false;
    this.HYb = true;
    this.HYc = new Object();
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.oEl = ((WindowManager)paramContext.getSystemService("window"));
    this.akM = getLongTouchTime();
    this.HXT = ViewConfiguration.getPressedStateDuration();
    AppMethodBeat.o(105228);
  }
  
  private void R(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105235);
    this.ajU.set(paramInt1 - getPaddingLeft(), paramInt2 - getPaddingTop(), getPaddingRight() + paramInt3, getPaddingBottom() + paramInt4);
    AppMethodBeat.o(105235);
  }
  
  private void aQ(final View paramView, int paramInt)
  {
    AppMethodBeat.i(105230);
    if (paramInt != this.HXZ)
    {
      ad.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks begin show:%d", new Object[] { Integer.valueOf(paramInt) });
      Object localObject = getAdapter().getItem(paramInt);
      if (this.HXR == null)
      {
        this.HXR = c.b(getContext(), localObject);
        this.oEl.addView(this.HXR, this.HXR.getWindowLayoutParams());
        this.HXR.setVisibility(4);
      }
      eh(localObject);
      this.oEl.updateViewLayout(this.HXR, this.HXR.getWindowLayoutParams());
      this.HXR.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(183931);
          if (SmileySubGrid.a(SmileySubGrid.this) != null)
          {
            SmileySubGrid.a(SmileySubGrid.this).setVisibility(0);
            SmileySubGrid.a(SmileySubGrid.this).gD(paramView);
            SmileySubGrid.b(SmileySubGrid.this).updateViewLayout(SmileySubGrid.a(SmileySubGrid.this), SmileySubGrid.a(SmileySubGrid.this).getWindowLayoutParams());
          }
          AppMethodBeat.o(183931);
        }
      });
    }
    for (;;)
    {
      this.HXZ = paramInt;
      AppMethodBeat.o(105230);
      return;
      ad.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks already show:%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  private void eh(Object paramObject)
  {
    AppMethodBeat.i(105238);
    synchronized (this.HYc)
    {
      if (this.HXR != null)
      {
        c.a(this.HXR, paramObject);
        AppMethodBeat.o(105238);
        return;
      }
      ad.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "mPopImageView is null.");
    }
  }
  
  private void fiJ()
  {
    AppMethodBeat.i(105233);
    if (this.HXS != null) {
      this.mHandler.removeCallbacks(this.HXS);
    }
    if (this.HXR != null)
    {
      this.oEl.removeView(this.HXR);
      this.HXR = null;
      this.oIL = false;
      this.HYa = false;
    }
    this.HXZ = -1;
    AppMethodBeat.o(105233);
  }
  
  private void gC(View paramView)
  {
    AppMethodBeat.i(105234);
    Rect localRect = this.ajU;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    R(localRect.left, localRect.top, localRect.right, localRect.bottom);
    boolean bool = this.HXQ;
    if (paramView.isEnabled() != bool) {
      if (bool) {
        break label86;
      }
    }
    label86:
    for (bool = true;; bool = false)
    {
      this.HXQ = bool;
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
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105240);
    super.onDetachedFromWindow();
    fiJ();
    AppMethodBeat.o(105240);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    b localb = null;
    AppMethodBeat.i(105229);
    if (!this.HYb)
    {
      fiJ();
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
      this.oEd = i;
      this.oEe = j;
      i = pointToPosition(i, j);
      if ((i >= 0) && (getAdapter().isEnabled(i))) {
        this.avs = 0;
      }
      paramMotionEvent = localb;
      if (i >= 0)
      {
        this.HXP = i;
        paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
      }
      if (paramMotionEvent != null)
      {
        paramMotionEvent.setPressed(true);
        paramMotionEvent.setSelected(true);
        gC(paramMotionEvent);
      }
      if (this.HXU == null) {
        this.HXU = new a((byte)0);
      }
      this.HXU.fdb();
      this.ajZ = i;
      if ((i >= 0) && ((getAdapter() instanceof a)))
      {
        getAdapter();
        this.mHandler.postDelayed(this.HXU, this.akM);
      }
      if ((i >= 0) && ((getAdapter() instanceof a)))
      {
        getAdapter();
        continue;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if (this.FVW == 5)
        {
          i = pointToPosition(i, j);
          this.ajZ = i;
          if ((i >= 0) && ((getAdapter() instanceof a)))
          {
            getAdapter();
            if (this.HXP != i)
            {
              this.HXP = i;
              paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
              layoutChildren();
              if (paramMotionEvent != null)
              {
                paramMotionEvent.setPressed(true);
                paramMotionEvent.setSelected(true);
                gC(paramMotionEvent);
                aQ(paramMotionEvent, this.HXP);
              }
            }
          }
          for (;;)
          {
            this.mHandler.removeCallbacks(this.HXU);
            break;
            fiJ();
            if (this.HXP >= 0)
            {
              paramMotionEvent = getChildAt(this.HXP - getFirstVisiblePosition());
              if (paramMotionEvent != null)
              {
                paramMotionEvent.setPressed(false);
                paramMotionEvent.setSelected(false);
                gC(paramMotionEvent);
              }
            }
          }
        }
        if (Math.abs(this.oEd - i) > this.mTouchSlop)
        {
          this.avs = -1;
          this.mHandler.removeCallbacks(this.HXU);
        }
        fiJ();
        continue;
        j = this.ajZ;
        paramMotionEvent = getChildAt(j - getFirstVisiblePosition());
        if ((i == 1) && (this.avs != -1))
        {
          if (this.HXV == null) {
            this.HXV = new b((byte)0);
          }
          localb = this.HXV;
          localb.CQ = paramMotionEvent;
          localb.HjD = j;
          localb.fdb();
          this.mHandler.post(localb);
        }
        if (this.HXY != null)
        {
          this.HXY.stopTimer();
          this.HXY = null;
        }
        this.mHandler.removeCallbacks(this.HXU);
        setScrollEnable(true);
        fiJ();
        if (this.HXP >= 0)
        {
          paramMotionEvent = getChildAt(this.HXP - getFirstVisiblePosition());
          if (paramMotionEvent != null)
          {
            paramMotionEvent.setPressed(false);
            paramMotionEvent.setSelected(false);
            gC(paramMotionEvent);
          }
        }
        this.FVW = 6;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(105239);
    super.release();
    fiJ();
    AppMethodBeat.o(105239);
  }
  
  public void setFromDetail(boolean paramBoolean)
  {
    this.HXX = paramBoolean;
  }
  
  public void setIsShowPopWin(boolean paramBoolean)
  {
    this.HYb = paramBoolean;
  }
  
  protected void setScrollEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(105236);
    ad.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "cpan t setScrollEnable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.HXW != null)
    {
      if ((this.HXW instanceof MMFlipper))
      {
        ((MMFlipper)this.HXW).setScrollEnable(paramBoolean);
        AppMethodBeat.o(105236);
        return;
      }
      if ((this.HXW instanceof CustomViewPager)) {
        ((CustomViewPager)this.HXW).setCanSlide(paramBoolean);
      }
    }
    AppMethodBeat.o(105236);
  }
  
  public void setViewParent(View paramView)
  {
    this.HXW = paramView;
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
      ad.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "LongPress run");
      int i = SmileySubGrid.this.ajZ;
      Object localObject = SmileySubGrid.this;
      localObject = ((SmileySubGrid)localObject).getChildAt(i - ((SmileySubGrid)localObject).getFirstVisiblePosition());
      if (localObject != null)
      {
        int j = SmileySubGrid.this.ajZ;
        long l = SmileySubGrid.this.getAdapter().getItemId(SmileySubGrid.this.ajZ);
        if (fdc())
        {
          ad.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "CheckForLongPress performLongPress position:[%d] id:[%d]", new Object[] { Integer.valueOf(j), Long.valueOf(l) });
          SmileySubGrid.a(SmileySubGrid.this, (View)localObject, i);
          SmileySubGrid.this.avs = -1;
          SmileySubGrid.this.FVW = 5;
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
    View CQ;
    int HjD;
    
    private b()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(105224);
      ad.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "Click run");
      ListAdapter localListAdapter = SmileySubGrid.this.getAdapter();
      int i = this.HjD;
      if ((localListAdapter != null) && (SmileySubGrid.this.getCount() > 0) && (i != -1) && (i < localListAdapter.getCount()) && (fdc()))
      {
        ad.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "PerformClick performItemClick position:[%d] id:[%d] ", new Object[] { Integer.valueOf(i), Long.valueOf(localListAdapter.getItemId(i)) });
        SmileySubGrid.this.performItemClick(this.CQ, i, localListAdapter.getItemId(i));
      }
      AppMethodBeat.o(105224);
    }
  }
  
  final class c
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(105225);
      if (!SmileySubGrid.e(this.HYd))
      {
        SmileySubGrid.b(this.HYd).addView(SmileySubGrid.a(this.HYd), SmileySubGrid.a(this.HYd).getWindowLayoutParams());
        SmileySubGrid.f(this.HYd);
      }
      AppMethodBeat.o(105225);
    }
  }
  
  class d
  {
    private int FZO;
    
    private d() {}
    
    public final void fdb()
    {
      AppMethodBeat.i(105226);
      this.FZO = SmileySubGrid.c(SmileySubGrid.this);
      AppMethodBeat.o(105226);
    }
    
    public final boolean fdc()
    {
      AppMethodBeat.i(105227);
      if ((SmileySubGrid.this.hasWindowFocus()) && (SmileySubGrid.d(SmileySubGrid.this) == this.FZO))
      {
        AppMethodBeat.o(105227);
        return true;
      }
      AppMethodBeat.o(105227);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.SmileySubGrid
 * JD-Core Version:    0.7.0.1
 */