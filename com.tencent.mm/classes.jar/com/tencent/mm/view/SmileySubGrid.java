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
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.view.a.a;
import com.tencent.mm.view.popview.AbstractPopView;
import com.tencent.mm.view.popview.c;

public class SmileySubGrid
  extends GridView
{
  private volatile int LBD;
  int OPg;
  int RmU;
  boolean RmV;
  private AbstractPopView RmW;
  private c RmX;
  private int RmY;
  private a RmZ;
  private b Rna;
  private View Rnb;
  private boolean Rnc;
  private MTimerHandler Rnd;
  private volatile boolean Rne;
  public boolean Rnf;
  private final Object Rng;
  Rect amS;
  int amX;
  private int anJ;
  int ayc;
  private MMHandler mHandler;
  private int mTouchSlop;
  private WindowManager mWindowManager;
  float riK;
  float riL;
  private boolean rnp;
  
  public SmileySubGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105228);
    this.OPg = 6;
    this.RmU = -1;
    this.amS = new Rect();
    this.mHandler = new MMHandler();
    this.Rnc = false;
    this.Rnd = null;
    this.LBD = -1;
    this.Rne = false;
    this.Rnf = true;
    this.Rng = new Object();
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.anJ = getLongTouchTime();
    this.RmY = ViewConfiguration.getPressedStateDuration();
    AppMethodBeat.o(105228);
  }
  
  private void S(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(105235);
    this.amS.set(paramInt1 - getPaddingLeft(), paramInt2 - getPaddingTop(), getPaddingRight() + paramInt3, getPaddingBottom() + paramInt4);
    AppMethodBeat.o(105235);
  }
  
  private void aY(final View paramView, int paramInt)
  {
    AppMethodBeat.i(105230);
    if (paramInt != this.LBD)
    {
      Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks begin show:%d", new Object[] { Integer.valueOf(paramInt) });
      Object localObject = getAdapter().getItem(paramInt);
      if (this.RmW == null)
      {
        this.RmW = c.b(getContext(), localObject);
        this.mWindowManager.addView(this.RmW, this.RmW.getWindowLayoutParams());
        this.RmW.setVisibility(4);
      }
      es(localObject);
      this.mWindowManager.updateViewLayout(this.RmW, this.RmW.getWindowLayoutParams());
      this.RmW.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(183931);
          if (SmileySubGrid.a(SmileySubGrid.this) != null)
          {
            SmileySubGrid.a(SmileySubGrid.this).setVisibility(0);
            SmileySubGrid.a(SmileySubGrid.this).hI(paramView);
            SmileySubGrid.b(SmileySubGrid.this).updateViewLayout(SmileySubGrid.a(SmileySubGrid.this), SmileySubGrid.a(SmileySubGrid.this).getWindowLayoutParams());
          }
          AppMethodBeat.o(183931);
        }
      });
    }
    for (;;)
    {
      this.LBD = paramInt;
      AppMethodBeat.o(105230);
      return;
      Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks already show:%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  private void es(Object paramObject)
  {
    AppMethodBeat.i(105238);
    synchronized (this.Rng)
    {
      if (this.RmW != null)
      {
        c.a(this.RmW, paramObject);
        AppMethodBeat.o(105238);
        return;
      }
      Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "mPopImageView is null.");
    }
  }
  
  private void hG(View paramView)
  {
    AppMethodBeat.i(105234);
    Rect localRect = this.amS;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    S(localRect.left, localRect.top, localRect.right, localRect.bottom);
    boolean bool = this.RmV;
    if (paramView.isEnabled() != bool) {
      if (bool) {
        break label84;
      }
    }
    label84:
    for (bool = true;; bool = false)
    {
      this.RmV = bool;
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
  
  public final void hfZ()
  {
    AppMethodBeat.i(105233);
    if (this.RmX != null) {
      this.mHandler.removeCallbacks(this.RmX);
    }
    if (this.RmW != null)
    {
      this.mWindowManager.removeView(this.RmW);
      this.RmW = null;
      this.rnp = false;
      this.Rne = false;
    }
    this.LBD = -1;
    AppMethodBeat.o(105233);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(105240);
    super.onDetachedFromWindow();
    hfZ();
    AppMethodBeat.o(105240);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    b localb = null;
    AppMethodBeat.i(105229);
    if (!this.Rnf)
    {
      hfZ();
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
      this.riK = i;
      this.riL = j;
      i = pointToPosition(i, j);
      if ((i >= 0) && (getAdapter().isEnabled(i))) {
        this.ayc = 0;
      }
      paramMotionEvent = localb;
      if (i >= 0)
      {
        this.RmU = i;
        paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
      }
      if (paramMotionEvent != null)
      {
        paramMotionEvent.setPressed(true);
        paramMotionEvent.setSelected(true);
        hG(paramMotionEvent);
      }
      if (this.RmZ == null) {
        this.RmZ = new a((byte)0);
      }
      this.RmZ.gWv();
      this.amX = i;
      if ((i >= 0) && ((getAdapter() instanceof a)))
      {
        getAdapter();
        this.mHandler.postDelayed(this.RmZ, this.anJ);
      }
      if ((i >= 0) && ((getAdapter() instanceof a)))
      {
        getAdapter();
        continue;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if (this.OPg == 5)
        {
          i = pointToPosition(i, j);
          this.amX = i;
          if ((i >= 0) && ((getAdapter() instanceof a)))
          {
            getAdapter();
            if (this.RmU != i)
            {
              this.RmU = i;
              paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
              layoutChildren();
              if (paramMotionEvent != null)
              {
                paramMotionEvent.setPressed(true);
                paramMotionEvent.setSelected(true);
                hG(paramMotionEvent);
                aY(paramMotionEvent, this.RmU);
              }
            }
          }
          for (;;)
          {
            this.mHandler.removeCallbacks(this.RmZ);
            break;
            hfZ();
            if (this.RmU >= 0)
            {
              paramMotionEvent = getChildAt(this.RmU - getFirstVisiblePosition());
              if (paramMotionEvent != null)
              {
                paramMotionEvent.setPressed(false);
                paramMotionEvent.setSelected(false);
                hG(paramMotionEvent);
              }
            }
          }
        }
        if (Math.abs(this.riK - i) > this.mTouchSlop)
        {
          this.ayc = -1;
          this.mHandler.removeCallbacks(this.RmZ);
        }
        hfZ();
        continue;
        j = this.amX;
        paramMotionEvent = getChildAt(j - getFirstVisiblePosition());
        if ((i == 1) && (this.ayc != -1))
        {
          if (this.Rna == null) {
            this.Rna = new b((byte)0);
          }
          localb = this.Rna;
          localb.FP = paramMotionEvent;
          localb.QkN = j;
          localb.gWv();
          this.mHandler.post(localb);
        }
        if (this.Rnd != null)
        {
          this.Rnd.stopTimer();
          this.Rnd = null;
        }
        this.mHandler.removeCallbacks(this.RmZ);
        setScrollEnable(true);
        hfZ();
        if (this.RmU >= 0)
        {
          paramMotionEvent = getChildAt(this.RmU - getFirstVisiblePosition());
          if (paramMotionEvent != null)
          {
            paramMotionEvent.setPressed(false);
            paramMotionEvent.setSelected(false);
            hG(paramMotionEvent);
          }
        }
        this.OPg = 6;
      }
    }
  }
  
  public void setFromDetail(boolean paramBoolean)
  {
    this.Rnc = paramBoolean;
  }
  
  public void setIsShowPopWin(boolean paramBoolean)
  {
    this.Rnf = paramBoolean;
  }
  
  protected void setScrollEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(105236);
    Log.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "cpan t setScrollEnable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.Rnb != null)
    {
      if ((this.Rnb instanceof MMFlipper))
      {
        ((MMFlipper)this.Rnb).setScrollEnable(paramBoolean);
        AppMethodBeat.o(105236);
        return;
      }
      if ((this.Rnb instanceof CustomViewPager)) {
        ((CustomViewPager)this.Rnb).setCanSlide(paramBoolean);
      }
    }
    AppMethodBeat.o(105236);
  }
  
  public void setViewParent(View paramView)
  {
    this.Rnb = paramView;
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
      int i = SmileySubGrid.this.amX;
      Object localObject = SmileySubGrid.this;
      localObject = ((SmileySubGrid)localObject).getChildAt(i - ((SmileySubGrid)localObject).getFirstVisiblePosition());
      if (localObject != null)
      {
        int j = SmileySubGrid.this.amX;
        long l = SmileySubGrid.this.getAdapter().getItemId(SmileySubGrid.this.amX);
        if (gWw())
        {
          Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "CheckForLongPress performLongPress position:[%d] id:[%d]", new Object[] { Integer.valueOf(j), Long.valueOf(l) });
          SmileySubGrid.a(SmileySubGrid.this, (View)localObject, i);
          SmileySubGrid.this.ayc = -1;
          SmileySubGrid.this.OPg = 5;
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
    View FP;
    int QkN;
    
    private b()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(105224);
      Log.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "Click run");
      ListAdapter localListAdapter = SmileySubGrid.this.getAdapter();
      int i = this.QkN;
      if ((localListAdapter != null) && (SmileySubGrid.this.getCount() > 0) && (i != -1) && (i < localListAdapter.getCount()) && (gWw()))
      {
        Log.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "PerformClick performItemClick position:[%d] id:[%d] ", new Object[] { Integer.valueOf(i), Long.valueOf(localListAdapter.getItemId(i)) });
        SmileySubGrid.this.performItemClick(this.FP, i, localListAdapter.getItemId(i));
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
      if (!SmileySubGrid.e(this.Rnh))
      {
        SmileySubGrid.b(this.Rnh).addView(SmileySubGrid.a(this.Rnh), SmileySubGrid.a(this.Rnh).getWindowLayoutParams());
        SmileySubGrid.f(this.Rnh);
      }
      AppMethodBeat.o(105225);
    }
  }
  
  class d
  {
    private int OTb;
    
    private d() {}
    
    public final void gWv()
    {
      AppMethodBeat.i(105226);
      this.OTb = SmileySubGrid.c(SmileySubGrid.this);
      AppMethodBeat.o(105226);
    }
    
    public final boolean gWw()
    {
      AppMethodBeat.i(105227);
      if ((SmileySubGrid.this.hasWindowFocus()) && (SmileySubGrid.d(SmileySubGrid.this) == this.OTb))
      {
        AppMethodBeat.o(105227);
        return true;
      }
      AppMethodBeat.o(105227);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.SmileySubGrid
 * JD-Core Version:    0.7.0.1
 */