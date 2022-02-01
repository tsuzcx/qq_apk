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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.view.a.a;
import com.tencent.mm.view.popview.AbstractPopView;
import com.tencent.mm.view.popview.c;

public class SmileySubGrid
  extends SmileyGrid
{
  private volatile int EDS;
  int HvK;
  int JyE;
  boolean JyF;
  private AbstractPopView JyG;
  private c JyH;
  private int JyI;
  private a JyJ;
  private b JyK;
  private View JyL;
  private boolean JyM;
  private au JyN;
  private volatile boolean JyO;
  public boolean JyP;
  private final Object JyQ;
  Rect akO;
  int akT;
  private int alG;
  int awn;
  private WindowManager gqS;
  private ao mHandler;
  private int mTouchSlop;
  float phD;
  float phE;
  private boolean pml;
  
  public SmileySubGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105228);
    this.HvK = 6;
    this.JyE = -1;
    this.akO = new Rect();
    this.mHandler = new ao();
    this.JyM = false;
    this.JyN = null;
    this.EDS = -1;
    this.JyO = false;
    this.JyP = true;
    this.JyQ = new Object();
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.gqS = ((WindowManager)paramContext.getSystemService("window"));
    this.alG = getLongTouchTime();
    this.JyI = ViewConfiguration.getPressedStateDuration();
    AppMethodBeat.o(105228);
  }
  
  private void T(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105235);
    this.akO.set(paramInt1 - getPaddingLeft(), paramInt2 - getPaddingTop(), getPaddingRight() + paramInt3, getPaddingBottom() + paramInt4);
    AppMethodBeat.o(105235);
  }
  
  private void aS(final View paramView, int paramInt)
  {
    AppMethodBeat.i(105230);
    if (paramInt != this.EDS)
    {
      ac.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks begin show:%d", new Object[] { Integer.valueOf(paramInt) });
      Object localObject = getAdapter().getItem(paramInt);
      if (this.JyG == null)
      {
        this.JyG = c.b(getContext(), localObject);
        this.gqS.addView(this.JyG, this.JyG.getWindowLayoutParams());
        this.JyG.setVisibility(4);
      }
      ei(localObject);
      this.gqS.updateViewLayout(this.JyG, this.JyG.getWindowLayoutParams());
      this.JyG.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(183931);
          if (SmileySubGrid.a(SmileySubGrid.this) != null)
          {
            SmileySubGrid.a(SmileySubGrid.this).setVisibility(0);
            SmileySubGrid.a(SmileySubGrid.this).gU(paramView);
            SmileySubGrid.b(SmileySubGrid.this).updateViewLayout(SmileySubGrid.a(SmileySubGrid.this), SmileySubGrid.a(SmileySubGrid.this).getWindowLayoutParams());
          }
          AppMethodBeat.o(183931);
        }
      });
    }
    for (;;)
    {
      this.EDS = paramInt;
      AppMethodBeat.o(105230);
      return;
      ac.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks already show:%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  private void ei(Object paramObject)
  {
    AppMethodBeat.i(105238);
    synchronized (this.JyQ)
    {
      if (this.JyG != null)
      {
        c.a(this.JyG, paramObject);
        AppMethodBeat.o(105238);
        return;
      }
      ac.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "mPopImageView is null.");
    }
  }
  
  private void fyX()
  {
    AppMethodBeat.i(105233);
    if (this.JyH != null) {
      this.mHandler.removeCallbacks(this.JyH);
    }
    if (this.JyG != null)
    {
      this.gqS.removeView(this.JyG);
      this.JyG = null;
      this.pml = false;
      this.JyO = false;
    }
    this.EDS = -1;
    AppMethodBeat.o(105233);
  }
  
  private void gS(View paramView)
  {
    AppMethodBeat.i(105234);
    Rect localRect = this.akO;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    T(localRect.left, localRect.top, localRect.right, localRect.bottom);
    boolean bool = this.JyF;
    if (paramView.isEnabled() != bool) {
      if (bool) {
        break label86;
      }
    }
    label86:
    for (bool = true;; bool = false)
    {
      this.JyF = bool;
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
    fyX();
    AppMethodBeat.o(105240);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    b localb = null;
    AppMethodBeat.i(105229);
    if (!this.JyP)
    {
      fyX();
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
      this.phD = i;
      this.phE = j;
      i = pointToPosition(i, j);
      if ((i >= 0) && (getAdapter().isEnabled(i))) {
        this.awn = 0;
      }
      paramMotionEvent = localb;
      if (i >= 0)
      {
        this.JyE = i;
        paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
      }
      if (paramMotionEvent != null)
      {
        paramMotionEvent.setPressed(true);
        paramMotionEvent.setSelected(true);
        gS(paramMotionEvent);
      }
      if (this.JyJ == null) {
        this.JyJ = new a((byte)0);
      }
      this.JyJ.fsW();
      this.akT = i;
      if ((i >= 0) && ((getAdapter() instanceof a)))
      {
        getAdapter();
        this.mHandler.postDelayed(this.JyJ, this.alG);
      }
      if ((i >= 0) && ((getAdapter() instanceof a)))
      {
        getAdapter();
        continue;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if (this.HvK == 5)
        {
          i = pointToPosition(i, j);
          this.akT = i;
          if ((i >= 0) && ((getAdapter() instanceof a)))
          {
            getAdapter();
            if (this.JyE != i)
            {
              this.JyE = i;
              paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
              layoutChildren();
              if (paramMotionEvent != null)
              {
                paramMotionEvent.setPressed(true);
                paramMotionEvent.setSelected(true);
                gS(paramMotionEvent);
                aS(paramMotionEvent, this.JyE);
              }
            }
          }
          for (;;)
          {
            this.mHandler.removeCallbacks(this.JyJ);
            break;
            fyX();
            if (this.JyE >= 0)
            {
              paramMotionEvent = getChildAt(this.JyE - getFirstVisiblePosition());
              if (paramMotionEvent != null)
              {
                paramMotionEvent.setPressed(false);
                paramMotionEvent.setSelected(false);
                gS(paramMotionEvent);
              }
            }
          }
        }
        if (Math.abs(this.phD - i) > this.mTouchSlop)
        {
          this.awn = -1;
          this.mHandler.removeCallbacks(this.JyJ);
        }
        fyX();
        continue;
        j = this.akT;
        paramMotionEvent = getChildAt(j - getFirstVisiblePosition());
        if ((i == 1) && (this.awn != -1))
        {
          if (this.JyK == null) {
            this.JyK = new b((byte)0);
          }
          localb = this.JyK;
          localb.DO = paramMotionEvent;
          localb.IJW = j;
          localb.fsW();
          this.mHandler.post(localb);
        }
        if (this.JyN != null)
        {
          this.JyN.stopTimer();
          this.JyN = null;
        }
        this.mHandler.removeCallbacks(this.JyJ);
        setScrollEnable(true);
        fyX();
        if (this.JyE >= 0)
        {
          paramMotionEvent = getChildAt(this.JyE - getFirstVisiblePosition());
          if (paramMotionEvent != null)
          {
            paramMotionEvent.setPressed(false);
            paramMotionEvent.setSelected(false);
            gS(paramMotionEvent);
          }
        }
        this.HvK = 6;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(105239);
    super.release();
    fyX();
    AppMethodBeat.o(105239);
  }
  
  public void setFromDetail(boolean paramBoolean)
  {
    this.JyM = paramBoolean;
  }
  
  public void setIsShowPopWin(boolean paramBoolean)
  {
    this.JyP = paramBoolean;
  }
  
  protected void setScrollEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(105236);
    ac.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "cpan t setScrollEnable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.JyL != null)
    {
      if ((this.JyL instanceof MMFlipper))
      {
        ((MMFlipper)this.JyL).setScrollEnable(paramBoolean);
        AppMethodBeat.o(105236);
        return;
      }
      if ((this.JyL instanceof CustomViewPager)) {
        ((CustomViewPager)this.JyL).setCanSlide(paramBoolean);
      }
    }
    AppMethodBeat.o(105236);
  }
  
  public void setViewParent(View paramView)
  {
    this.JyL = paramView;
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
      ac.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "LongPress run");
      int i = SmileySubGrid.this.akT;
      Object localObject = SmileySubGrid.this;
      localObject = ((SmileySubGrid)localObject).getChildAt(i - ((SmileySubGrid)localObject).getFirstVisiblePosition());
      if (localObject != null)
      {
        int j = SmileySubGrid.this.akT;
        long l = SmileySubGrid.this.getAdapter().getItemId(SmileySubGrid.this.akT);
        if (fsX())
        {
          ac.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "CheckForLongPress performLongPress position:[%d] id:[%d]", new Object[] { Integer.valueOf(j), Long.valueOf(l) });
          SmileySubGrid.a(SmileySubGrid.this, (View)localObject, i);
          SmileySubGrid.this.awn = -1;
          SmileySubGrid.this.HvK = 5;
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
    View DO;
    int IJW;
    
    private b()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(105224);
      ac.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "Click run");
      ListAdapter localListAdapter = SmileySubGrid.this.getAdapter();
      int i = this.IJW;
      if ((localListAdapter != null) && (SmileySubGrid.this.getCount() > 0) && (i != -1) && (i < localListAdapter.getCount()) && (fsX()))
      {
        ac.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "PerformClick performItemClick position:[%d] id:[%d] ", new Object[] { Integer.valueOf(i), Long.valueOf(localListAdapter.getItemId(i)) });
        SmileySubGrid.this.performItemClick(this.DO, i, localListAdapter.getItemId(i));
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
      if (!SmileySubGrid.e(this.JyR))
      {
        SmileySubGrid.b(this.JyR).addView(SmileySubGrid.a(this.JyR), SmileySubGrid.a(this.JyR).getWindowLayoutParams());
        SmileySubGrid.f(this.JyR);
      }
      AppMethodBeat.o(105225);
    }
  }
  
  class d
  {
    private int HzC;
    
    private d() {}
    
    public final void fsW()
    {
      AppMethodBeat.i(105226);
      this.HzC = SmileySubGrid.c(SmileySubGrid.this);
      AppMethodBeat.o(105226);
    }
    
    public final boolean fsX()
    {
      AppMethodBeat.i(105227);
      if ((SmileySubGrid.this.hasWindowFocus()) && (SmileySubGrid.d(SmileySubGrid.this) == this.HzC))
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