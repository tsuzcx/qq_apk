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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.view.a.g;
import com.tencent.mm.view.popview.AbstractPopView;
import com.tencent.mm.view.popview.a;

public class SmileySubGrid
  extends SmileyGrid
{
  private AbstractPopView ARA;
  private SmileySubGrid.c ARB;
  private int ARC;
  private SmileySubGrid.a ARD;
  private SmileySubGrid.b ARE;
  private View ARF;
  private boolean ARG;
  private volatile int ARH;
  private volatile boolean ARI;
  public boolean ARJ;
  private final Object ARK;
  int ARy;
  boolean ARz;
  Rect acN;
  int acS;
  private int adF;
  int anS;
  float lnM;
  float lnN;
  private WindowManager lnU;
  private boolean lss;
  private ak mHandler;
  private int mTouchSlop;
  int zis;
  
  public SmileySubGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(62960);
    this.zis = 6;
    this.ARy = -1;
    this.acN = new Rect();
    this.mHandler = new ak();
    this.ARG = false;
    this.ARH = -1;
    this.ARI = false;
    this.ARJ = true;
    this.ARK = new Object();
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.lnU = ((WindowManager)paramContext.getSystemService("window"));
    this.adF = getLongTouchTime();
    this.ARC = ViewConfiguration.getPressedStateDuration();
    AppMethodBeat.o(62960);
  }
  
  private void N(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(62967);
    this.acN.set(paramInt1 - getPaddingLeft(), paramInt2 - getPaddingTop(), getPaddingRight() + paramInt3, getPaddingBottom() + paramInt4);
    AppMethodBeat.o(62967);
  }
  
  private boolean RH(int paramInt)
  {
    AppMethodBeat.i(62963);
    if ((paramInt == this.ARH) && (this.ARA.isShown()))
    {
      AppMethodBeat.o(62963);
      return true;
    }
    AppMethodBeat.o(62963);
    return false;
  }
  
  private void aD(View paramView, int paramInt)
  {
    AppMethodBeat.i(62962);
    if (!RH(paramInt))
    {
      ab.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks begin show:%d", new Object[] { Integer.valueOf(paramInt) });
      Object localObject = getAdapter().getItem(paramInt);
      if (this.ARA == null) {
        this.ARA = a.b(getContext(), localObject);
      }
      cQ(localObject);
      fB(paramView);
    }
    for (;;)
    {
      this.ARH = paramInt;
      AppMethodBeat.o(62962);
      return;
      ab.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks already show:%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  private void cQ(Object paramObject)
  {
    AppMethodBeat.i(62970);
    synchronized (this.ARK)
    {
      if (this.ARA != null)
      {
        a.a(this.ARA, paramObject);
        AppMethodBeat.o(62970);
        return;
      }
      ab.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "mPopImageView is null.");
    }
  }
  
  private void dQQ()
  {
    AppMethodBeat.i(62965);
    if (this.ARB != null) {
      this.mHandler.removeCallbacks(this.ARB);
    }
    if (this.lss)
    {
      this.lnU.removeView(this.ARA);
      this.lss = false;
      this.ARI = false;
    }
    AppMethodBeat.o(62965);
  }
  
  private void fB(View paramView)
  {
    AppMethodBeat.i(62964);
    if (this.ARB == null) {
      this.ARB = new SmileySubGrid.c(this, (byte)0);
    }
    ab.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "updatePopView %s", new Object[] { Boolean.valueOf(this.lss) });
    this.ARA.fD(paramView);
    if (!this.lss)
    {
      this.ARI = true;
      this.mHandler.postDelayed(this.ARB, this.ARC);
      AppMethodBeat.o(62964);
      return;
    }
    this.lnU.updateViewLayout(this.ARA, this.ARA.getWindowLayoutParams());
    AppMethodBeat.o(62964);
  }
  
  private void fC(View paramView)
  {
    AppMethodBeat.i(62966);
    Rect localRect = this.acN;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    N(localRect.left, localRect.top, localRect.right, localRect.bottom);
    boolean bool = this.ARz;
    if (paramView.isEnabled() != bool) {
      if (bool) {
        break label86;
      }
    }
    label86:
    for (bool = true;; bool = false)
    {
      this.ARz = bool;
      refreshDrawableState();
      AppMethodBeat.o(62966);
      return;
    }
  }
  
  protected int getLongTouchTime()
  {
    AppMethodBeat.i(62969);
    int i = ViewConfiguration.getLongPressTimeout();
    AppMethodBeat.o(62969);
    return i;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(62972);
    super.onDetachedFromWindow();
    dQQ();
    AppMethodBeat.o(62972);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(62961);
    if (!this.ARJ)
    {
      dQQ();
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(62961);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    SmileySubGrid.b localb = null;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62961);
      return true;
      i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      this.lnM = i;
      this.lnN = j;
      i = pointToPosition(i, j);
      if ((i >= 0) && (getAdapter().isEnabled(i))) {
        this.anS = 0;
      }
      paramMotionEvent = localb;
      if (i >= 0)
      {
        this.ARy = i;
        paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
      }
      if (paramMotionEvent != null)
      {
        paramMotionEvent.setPressed(true);
        paramMotionEvent.setSelected(true);
        fC(paramMotionEvent);
      }
      if (this.ARD == null) {
        this.ARD = new SmileySubGrid.a(this, (byte)0);
      }
      this.ARD.dNn();
      this.acS = i;
      if ((i >= 0) && ((getAdapter() instanceof g)) && (((g)getAdapter()).uu(i)))
      {
        this.mHandler.postDelayed(this.ARD, this.adF);
        continue;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if (this.zis == 5)
        {
          i = pointToPosition(i, j);
          this.acS = i;
          if ((i >= 0) && ((getAdapter() instanceof g)) && (((g)getAdapter()).uu(i))) {
            if (this.ARy != i)
            {
              this.ARy = i;
              paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
              layoutChildren();
              if (paramMotionEvent != null)
              {
                paramMotionEvent.setPressed(true);
                paramMotionEvent.setSelected(true);
                fC(paramMotionEvent);
                aD(paramMotionEvent, this.ARy);
              }
            }
          }
          for (;;)
          {
            this.mHandler.removeCallbacks(this.ARD);
            break;
            dQQ();
            if (this.ARy >= 0)
            {
              paramMotionEvent = getChildAt(this.ARy - getFirstVisiblePosition());
              if (paramMotionEvent != null)
              {
                paramMotionEvent.setPressed(false);
                paramMotionEvent.setSelected(false);
                fC(paramMotionEvent);
              }
            }
          }
        }
        if (Math.abs(this.lnM - i) > this.mTouchSlop)
        {
          this.anS = -1;
          this.mHandler.removeCallbacks(this.ARD);
        }
        dQQ();
        continue;
        j = this.acS;
        paramMotionEvent = getChildAt(j - getFirstVisiblePosition());
        if ((i == 1) && (this.anS != -1))
        {
          if (this.ARE == null) {
            this.ARE = new SmileySubGrid.b(this, (byte)0);
          }
          localb = this.ARE;
          localb.ws = paramMotionEvent;
          localb.Aph = j;
          localb.dNn();
          this.mHandler.post(localb);
        }
        this.mHandler.removeCallbacks(this.ARD);
        setScrollEnable(true);
        dQQ();
        if (this.ARy >= 0)
        {
          paramMotionEvent = getChildAt(this.ARy - getFirstVisiblePosition());
          if (paramMotionEvent != null)
          {
            paramMotionEvent.setPressed(false);
            paramMotionEvent.setSelected(false);
            fC(paramMotionEvent);
          }
        }
        this.zis = 6;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(62971);
    super.release();
    dQQ();
    if (this.ARA != null) {
      this.ARA = null;
    }
    AppMethodBeat.o(62971);
  }
  
  public void setFromDetail(boolean paramBoolean)
  {
    this.ARG = paramBoolean;
  }
  
  public void setIsShowPopWin(boolean paramBoolean)
  {
    this.ARJ = paramBoolean;
  }
  
  protected void setScrollEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(62968);
    ab.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "cpan t setScrollEnable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.ARF != null)
    {
      if ((this.ARF instanceof MMFlipper))
      {
        ((MMFlipper)this.ARF).setScrollEnable(paramBoolean);
        AppMethodBeat.o(62968);
        return;
      }
      if ((this.ARF instanceof CustomViewPager)) {
        ((CustomViewPager)this.ARF).setCanSlide(paramBoolean);
      }
    }
    AppMethodBeat.o(62968);
  }
  
  public void setViewParent(View paramView)
  {
    this.ARF = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.SmileySubGrid
 * JD-Core Version:    0.7.0.1
 */