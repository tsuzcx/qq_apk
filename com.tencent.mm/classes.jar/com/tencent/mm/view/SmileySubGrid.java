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
  private volatile int GlH;
  int JjA;
  int LrL;
  boolean LrM;
  private AbstractPopView LrN;
  private c LrO;
  private int LrP;
  private a LrQ;
  private b LrR;
  private View LrS;
  private boolean LrT;
  private av LrU;
  private volatile boolean LrV;
  public boolean LrW;
  private final Object LrX;
  Rect amF;
  int amK;
  private int anx;
  int aye;
  private WindowManager gKC;
  private ap mHandler;
  private int mTouchSlop;
  float pLf;
  float pLg;
  private boolean pPL;
  
  public SmileySubGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105228);
    this.JjA = 6;
    this.LrL = -1;
    this.amF = new Rect();
    this.mHandler = new ap();
    this.LrT = false;
    this.LrU = null;
    this.GlH = -1;
    this.LrV = false;
    this.LrW = true;
    this.LrX = new Object();
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.gKC = ((WindowManager)paramContext.getSystemService("window"));
    this.anx = getLongTouchTime();
    this.LrP = ViewConfiguration.getPressedStateDuration();
    AppMethodBeat.o(105228);
  }
  
  private void T(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105235);
    this.amF.set(paramInt1 - getPaddingLeft(), paramInt2 - getPaddingTop(), getPaddingRight() + paramInt3, getPaddingBottom() + paramInt4);
    AppMethodBeat.o(105235);
  }
  
  private void aU(final View paramView, int paramInt)
  {
    AppMethodBeat.i(105230);
    if (paramInt != this.GlH)
    {
      ad.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks begin show:%d", new Object[] { Integer.valueOf(paramInt) });
      Object localObject = getAdapter().getItem(paramInt);
      if (this.LrN == null)
      {
        this.LrN = c.b(getContext(), localObject);
        this.gKC.addView(this.LrN, this.LrN.getWindowLayoutParams());
        this.LrN.setVisibility(4);
      }
      el(localObject);
      this.gKC.updateViewLayout(this.LrN, this.LrN.getWindowLayoutParams());
      this.LrN.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(183931);
          if (SmileySubGrid.a(SmileySubGrid.this) != null)
          {
            SmileySubGrid.a(SmileySubGrid.this).setVisibility(0);
            SmileySubGrid.a(SmileySubGrid.this).hl(paramView);
            SmileySubGrid.b(SmileySubGrid.this).updateViewLayout(SmileySubGrid.a(SmileySubGrid.this), SmileySubGrid.a(SmileySubGrid.this).getWindowLayoutParams());
          }
          AppMethodBeat.o(183931);
        }
      });
    }
    for (;;)
    {
      this.GlH = paramInt;
      AppMethodBeat.o(105230);
      return;
      ad.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks already show:%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  private void el(Object paramObject)
  {
    AppMethodBeat.i(105238);
    synchronized (this.LrX)
    {
      if (this.LrN != null)
      {
        c.a(this.LrN, paramObject);
        AppMethodBeat.o(105238);
        return;
      }
      ad.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "mPopImageView is null.");
    }
  }
  
  private void fQg()
  {
    AppMethodBeat.i(105233);
    if (this.LrO != null) {
      this.mHandler.removeCallbacks(this.LrO);
    }
    if (this.LrN != null)
    {
      this.gKC.removeView(this.LrN);
      this.LrN = null;
      this.pPL = false;
      this.LrV = false;
    }
    this.GlH = -1;
    AppMethodBeat.o(105233);
  }
  
  private void hj(View paramView)
  {
    AppMethodBeat.i(105234);
    Rect localRect = this.amF;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    T(localRect.left, localRect.top, localRect.right, localRect.bottom);
    boolean bool = this.LrM;
    if (paramView.isEnabled() != bool) {
      if (bool) {
        break label86;
      }
    }
    label86:
    for (bool = true;; bool = false)
    {
      this.LrM = bool;
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
    fQg();
    AppMethodBeat.o(105240);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    b localb = null;
    AppMethodBeat.i(105229);
    if (!this.LrW)
    {
      fQg();
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
      this.pLf = i;
      this.pLg = j;
      i = pointToPosition(i, j);
      if ((i >= 0) && (getAdapter().isEnabled(i))) {
        this.aye = 0;
      }
      paramMotionEvent = localb;
      if (i >= 0)
      {
        this.LrL = i;
        paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
      }
      if (paramMotionEvent != null)
      {
        paramMotionEvent.setPressed(true);
        paramMotionEvent.setSelected(true);
        hj(paramMotionEvent);
      }
      if (this.LrQ == null) {
        this.LrQ = new a((byte)0);
      }
      this.LrQ.fJK();
      this.amK = i;
      if ((i >= 0) && ((getAdapter() instanceof a)))
      {
        getAdapter();
        this.mHandler.postDelayed(this.LrQ, this.anx);
      }
      if ((i >= 0) && ((getAdapter() instanceof a)))
      {
        getAdapter();
        continue;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if (this.JjA == 5)
        {
          i = pointToPosition(i, j);
          this.amK = i;
          if ((i >= 0) && ((getAdapter() instanceof a)))
          {
            getAdapter();
            if (this.LrL != i)
            {
              this.LrL = i;
              paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
              layoutChildren();
              if (paramMotionEvent != null)
              {
                paramMotionEvent.setPressed(true);
                paramMotionEvent.setSelected(true);
                hj(paramMotionEvent);
                aU(paramMotionEvent, this.LrL);
              }
            }
          }
          for (;;)
          {
            this.mHandler.removeCallbacks(this.LrQ);
            break;
            fQg();
            if (this.LrL >= 0)
            {
              paramMotionEvent = getChildAt(this.LrL - getFirstVisiblePosition());
              if (paramMotionEvent != null)
              {
                paramMotionEvent.setPressed(false);
                paramMotionEvent.setSelected(false);
                hj(paramMotionEvent);
              }
            }
          }
        }
        if (Math.abs(this.pLf - i) > this.mTouchSlop)
        {
          this.aye = -1;
          this.mHandler.removeCallbacks(this.LrQ);
        }
        fQg();
        continue;
        j = this.amK;
        paramMotionEvent = getChildAt(j - getFirstVisiblePosition());
        if ((i == 1) && (this.aye != -1))
        {
          if (this.LrR == null) {
            this.LrR = new b((byte)0);
          }
          localb = this.LrR;
          localb.FF = paramMotionEvent;
          localb.KBd = j;
          localb.fJK();
          this.mHandler.post(localb);
        }
        if (this.LrU != null)
        {
          this.LrU.stopTimer();
          this.LrU = null;
        }
        this.mHandler.removeCallbacks(this.LrQ);
        setScrollEnable(true);
        fQg();
        if (this.LrL >= 0)
        {
          paramMotionEvent = getChildAt(this.LrL - getFirstVisiblePosition());
          if (paramMotionEvent != null)
          {
            paramMotionEvent.setPressed(false);
            paramMotionEvent.setSelected(false);
            hj(paramMotionEvent);
          }
        }
        this.JjA = 6;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(105239);
    super.release();
    fQg();
    AppMethodBeat.o(105239);
  }
  
  public void setFromDetail(boolean paramBoolean)
  {
    this.LrT = paramBoolean;
  }
  
  public void setIsShowPopWin(boolean paramBoolean)
  {
    this.LrW = paramBoolean;
  }
  
  protected void setScrollEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(105236);
    ad.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "cpan t setScrollEnable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.LrS != null)
    {
      if ((this.LrS instanceof MMFlipper))
      {
        ((MMFlipper)this.LrS).setScrollEnable(paramBoolean);
        AppMethodBeat.o(105236);
        return;
      }
      if ((this.LrS instanceof CustomViewPager)) {
        ((CustomViewPager)this.LrS).setCanSlide(paramBoolean);
      }
    }
    AppMethodBeat.o(105236);
  }
  
  public void setViewParent(View paramView)
  {
    this.LrS = paramView;
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
      int i = SmileySubGrid.this.amK;
      Object localObject = SmileySubGrid.this;
      localObject = ((SmileySubGrid)localObject).getChildAt(i - ((SmileySubGrid)localObject).getFirstVisiblePosition());
      if (localObject != null)
      {
        int j = SmileySubGrid.this.amK;
        long l = SmileySubGrid.this.getAdapter().getItemId(SmileySubGrid.this.amK);
        if (fJL())
        {
          ad.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "CheckForLongPress performLongPress position:[%d] id:[%d]", new Object[] { Integer.valueOf(j), Long.valueOf(l) });
          SmileySubGrid.a(SmileySubGrid.this, (View)localObject, i);
          SmileySubGrid.this.aye = -1;
          SmileySubGrid.this.JjA = 5;
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
    View FF;
    int KBd;
    
    private b()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(105224);
      ad.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "Click run");
      ListAdapter localListAdapter = SmileySubGrid.this.getAdapter();
      int i = this.KBd;
      if ((localListAdapter != null) && (SmileySubGrid.this.getCount() > 0) && (i != -1) && (i < localListAdapter.getCount()) && (fJL()))
      {
        ad.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "PerformClick performItemClick position:[%d] id:[%d] ", new Object[] { Integer.valueOf(i), Long.valueOf(localListAdapter.getItemId(i)) });
        SmileySubGrid.this.performItemClick(this.FF, i, localListAdapter.getItemId(i));
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
      if (!SmileySubGrid.e(this.LrY))
      {
        SmileySubGrid.b(this.LrY).addView(SmileySubGrid.a(this.LrY), SmileySubGrid.a(this.LrY).getWindowLayoutParams());
        SmileySubGrid.f(this.LrY);
      }
      AppMethodBeat.o(105225);
    }
  }
  
  class d
  {
    private int Jnt;
    
    private d() {}
    
    public final void fJK()
    {
      AppMethodBeat.i(105226);
      this.Jnt = SmileySubGrid.c(SmileySubGrid.this);
      AppMethodBeat.o(105226);
    }
    
    public final boolean fJL()
    {
      AppMethodBeat.i(105227);
      if ((SmileySubGrid.this.hasWindowFocus()) && (SmileySubGrid.d(SmileySubGrid.this) == this.Jnt))
      {
        AppMethodBeat.o(105227);
        return true;
      }
      AppMethodBeat.o(105227);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.SmileySubGrid
 * JD-Core Version:    0.7.0.1
 */