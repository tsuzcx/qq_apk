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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.view.a.a;
import com.tencent.mm.view.popview.AbstractPopView;
import com.tencent.mm.view.popview.c;

public class SmileySubGrid
  extends SmileyGrid
{
  private volatile int GEJ;
  int JEo;
  private int LOA;
  private a LOB;
  private b LOC;
  private View LOD;
  private boolean LOE;
  private aw LOF;
  private volatile boolean LOH;
  public boolean LOI;
  private final Object LOJ;
  int LOw;
  boolean LOx;
  private AbstractPopView LOy;
  private c LOz;
  Rect amF;
  int amK;
  private int anx;
  int aye;
  private WindowManager gNl;
  private aq mHandler;
  private int mTouchSlop;
  float pRK;
  float pRL;
  private boolean pWq;
  
  public SmileySubGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(105228);
    this.JEo = 6;
    this.LOw = -1;
    this.amF = new Rect();
    this.mHandler = new aq();
    this.LOE = false;
    this.LOF = null;
    this.GEJ = -1;
    this.LOH = false;
    this.LOI = true;
    this.LOJ = new Object();
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.gNl = ((WindowManager)paramContext.getSystemService("window"));
    this.anx = getLongTouchTime();
    this.LOA = ViewConfiguration.getPressedStateDuration();
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
    if (paramInt != this.GEJ)
    {
      ae.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks begin show:%d", new Object[] { Integer.valueOf(paramInt) });
      Object localObject = getAdapter().getItem(paramInt);
      if (this.LOy == null)
      {
        this.LOy = c.b(getContext(), localObject);
        this.gNl.addView(this.LOy, this.LOy.getWindowLayoutParams());
        this.LOy.setVisibility(4);
      }
      eo(localObject);
      this.gNl.updateViewLayout(this.LOy, this.LOy.getWindowLayoutParams());
      this.LOy.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(183931);
          if (SmileySubGrid.a(SmileySubGrid.this) != null)
          {
            SmileySubGrid.a(SmileySubGrid.this).setVisibility(0);
            SmileySubGrid.a(SmileySubGrid.this).hq(paramView);
            SmileySubGrid.b(SmileySubGrid.this).updateViewLayout(SmileySubGrid.a(SmileySubGrid.this), SmileySubGrid.a(SmileySubGrid.this).getWindowLayoutParams());
          }
          AppMethodBeat.o(183931);
        }
      });
    }
    for (;;)
    {
      this.GEJ = paramInt;
      AppMethodBeat.o(105230);
      return;
      ae.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks already show:%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  private void eo(Object paramObject)
  {
    AppMethodBeat.i(105238);
    synchronized (this.LOJ)
    {
      if (this.LOy != null)
      {
        c.a(this.LOy, paramObject);
        AppMethodBeat.o(105238);
        return;
      }
      ae.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "mPopImageView is null.");
    }
  }
  
  private void fUC()
  {
    AppMethodBeat.i(105233);
    if (this.LOz != null) {
      this.mHandler.removeCallbacks(this.LOz);
    }
    if (this.LOy != null)
    {
      this.gNl.removeView(this.LOy);
      this.LOy = null;
      this.pWq = false;
      this.LOH = false;
    }
    this.GEJ = -1;
    AppMethodBeat.o(105233);
  }
  
  private void ho(View paramView)
  {
    AppMethodBeat.i(105234);
    Rect localRect = this.amF;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    T(localRect.left, localRect.top, localRect.right, localRect.bottom);
    boolean bool = this.LOx;
    if (paramView.isEnabled() != bool) {
      if (bool) {
        break label86;
      }
    }
    label86:
    for (bool = true;; bool = false)
    {
      this.LOx = bool;
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
    fUC();
    AppMethodBeat.o(105240);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    b localb = null;
    AppMethodBeat.i(105229);
    if (!this.LOI)
    {
      fUC();
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
      this.pRK = i;
      this.pRL = j;
      i = pointToPosition(i, j);
      if ((i >= 0) && (getAdapter().isEnabled(i))) {
        this.aye = 0;
      }
      paramMotionEvent = localb;
      if (i >= 0)
      {
        this.LOw = i;
        paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
      }
      if (paramMotionEvent != null)
      {
        paramMotionEvent.setPressed(true);
        paramMotionEvent.setSelected(true);
        ho(paramMotionEvent);
      }
      if (this.LOB == null) {
        this.LOB = new a((byte)0);
      }
      this.LOB.fOb();
      this.amK = i;
      if ((i >= 0) && ((getAdapter() instanceof a)))
      {
        getAdapter();
        this.mHandler.postDelayed(this.LOB, this.anx);
      }
      if ((i >= 0) && ((getAdapter() instanceof a)))
      {
        getAdapter();
        continue;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if (this.JEo == 5)
        {
          i = pointToPosition(i, j);
          this.amK = i;
          if ((i >= 0) && ((getAdapter() instanceof a)))
          {
            getAdapter();
            if (this.LOw != i)
            {
              this.LOw = i;
              paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
              layoutChildren();
              if (paramMotionEvent != null)
              {
                paramMotionEvent.setPressed(true);
                paramMotionEvent.setSelected(true);
                ho(paramMotionEvent);
                aU(paramMotionEvent, this.LOw);
              }
            }
          }
          for (;;)
          {
            this.mHandler.removeCallbacks(this.LOB);
            break;
            fUC();
            if (this.LOw >= 0)
            {
              paramMotionEvent = getChildAt(this.LOw - getFirstVisiblePosition());
              if (paramMotionEvent != null)
              {
                paramMotionEvent.setPressed(false);
                paramMotionEvent.setSelected(false);
                ho(paramMotionEvent);
              }
            }
          }
        }
        if (Math.abs(this.pRK - i) > this.mTouchSlop)
        {
          this.aye = -1;
          this.mHandler.removeCallbacks(this.LOB);
        }
        fUC();
        continue;
        j = this.amK;
        paramMotionEvent = getChildAt(j - getFirstVisiblePosition());
        if ((i == 1) && (this.aye != -1))
        {
          if (this.LOC == null) {
            this.LOC = new b((byte)0);
          }
          localb = this.LOC;
          localb.FF = paramMotionEvent;
          localb.KXx = j;
          localb.fOb();
          this.mHandler.post(localb);
        }
        if (this.LOF != null)
        {
          this.LOF.stopTimer();
          this.LOF = null;
        }
        this.mHandler.removeCallbacks(this.LOB);
        setScrollEnable(true);
        fUC();
        if (this.LOw >= 0)
        {
          paramMotionEvent = getChildAt(this.LOw - getFirstVisiblePosition());
          if (paramMotionEvent != null)
          {
            paramMotionEvent.setPressed(false);
            paramMotionEvent.setSelected(false);
            ho(paramMotionEvent);
          }
        }
        this.JEo = 6;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(105239);
    super.release();
    fUC();
    AppMethodBeat.o(105239);
  }
  
  public void setFromDetail(boolean paramBoolean)
  {
    this.LOE = paramBoolean;
  }
  
  public void setIsShowPopWin(boolean paramBoolean)
  {
    this.LOI = paramBoolean;
  }
  
  protected void setScrollEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(105236);
    ae.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "cpan t setScrollEnable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.LOD != null)
    {
      if ((this.LOD instanceof MMFlipper))
      {
        ((MMFlipper)this.LOD).setScrollEnable(paramBoolean);
        AppMethodBeat.o(105236);
        return;
      }
      if ((this.LOD instanceof CustomViewPager)) {
        ((CustomViewPager)this.LOD).setCanSlide(paramBoolean);
      }
    }
    AppMethodBeat.o(105236);
  }
  
  public void setViewParent(View paramView)
  {
    this.LOD = paramView;
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
      ae.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "LongPress run");
      int i = SmileySubGrid.this.amK;
      Object localObject = SmileySubGrid.this;
      localObject = ((SmileySubGrid)localObject).getChildAt(i - ((SmileySubGrid)localObject).getFirstVisiblePosition());
      if (localObject != null)
      {
        int j = SmileySubGrid.this.amK;
        long l = SmileySubGrid.this.getAdapter().getItemId(SmileySubGrid.this.amK);
        if (fOc())
        {
          ae.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "CheckForLongPress performLongPress position:[%d] id:[%d]", new Object[] { Integer.valueOf(j), Long.valueOf(l) });
          SmileySubGrid.a(SmileySubGrid.this, (View)localObject, i);
          SmileySubGrid.this.aye = -1;
          SmileySubGrid.this.JEo = 5;
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
    int KXx;
    
    private b()
    {
      super((byte)0);
    }
    
    public final void run()
    {
      AppMethodBeat.i(105224);
      ae.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "Click run");
      ListAdapter localListAdapter = SmileySubGrid.this.getAdapter();
      int i = this.KXx;
      if ((localListAdapter != null) && (SmileySubGrid.this.getCount() > 0) && (i != -1) && (i < localListAdapter.getCount()) && (fOc()))
      {
        ae.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "PerformClick performItemClick position:[%d] id:[%d] ", new Object[] { Integer.valueOf(i), Long.valueOf(localListAdapter.getItemId(i)) });
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
      if (!SmileySubGrid.e(this.LOK))
      {
        SmileySubGrid.b(this.LOK).addView(SmileySubGrid.a(this.LOK), SmileySubGrid.a(this.LOK).getWindowLayoutParams());
        SmileySubGrid.f(this.LOK);
      }
      AppMethodBeat.o(105225);
    }
  }
  
  class d
  {
    private int JIi;
    
    private d() {}
    
    public final void fOb()
    {
      AppMethodBeat.i(105226);
      this.JIi = SmileySubGrid.c(SmileySubGrid.this);
      AppMethodBeat.o(105226);
    }
    
    public final boolean fOc()
    {
      AppMethodBeat.i(105227);
      if ((SmileySubGrid.this.hasWindowFocus()) && (SmileySubGrid.d(SmileySubGrid.this) == this.JIi))
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