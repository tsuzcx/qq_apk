package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.ListAdapter;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.u.a.a;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.view.a.e;
import com.tencent.mm.view.popview.AbstractPopView;
import com.tencent.mm.view.popview.EmojiPopView;
import com.tencent.mm.view.popview.SmileyPopView;

public class SmileySubGrid
  extends SmileyGrid
{
  private int acV;
  Rect acb = new Rect();
  int acg;
  int alA;
  private int jb = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  float jeW;
  float jeX;
  private WindowManager jfe;
  private boolean jjA;
  private ah mHandler = new ah();
  int uTR = 6;
  private int wwA;
  private SmileySubGrid.a wwB;
  private SmileySubGrid.b wwC;
  private View wwD;
  private boolean wwE = false;
  private volatile int wwF = -1;
  private volatile boolean wwG = false;
  public boolean wwH = true;
  private final Object wwI = new Object();
  int www = -1;
  boolean wwx;
  private AbstractPopView wwy;
  private SmileySubGrid.c wwz;
  
  public SmileySubGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jfe = ((WindowManager)paramContext.getSystemService("window"));
    this.acV = getLongTouchTime();
    this.wwA = ViewConfiguration.getPressedStateDuration();
  }
  
  private void aa(View paramView, int paramInt)
  {
    int i;
    Object localObject2;
    if ((paramInt == this.wwF) && (this.wwy.isShown()))
    {
      i = 1;
      if (i != 0) {
        break label304;
      }
      y.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks begin show:%d", new Object[] { Integer.valueOf(paramInt) });
      localObject2 = getAdapter().getItem(paramInt);
      if (this.wwy == null)
      {
        ??? = getContext();
        if (!(localObject2 instanceof a)) {
          break label227;
        }
        ??? = new SmileyPopView((Context)???);
        label86:
        this.wwy = ((AbstractPopView)???);
      }
    }
    for (;;)
    {
      synchronized (this.wwI)
      {
        if (this.wwy != null)
        {
          AbstractPopView localAbstractPopView = this.wwy;
          if ((localAbstractPopView instanceof EmojiPopView))
          {
            ((EmojiPopView)localAbstractPopView).setEmojiInfo((EmojiInfo)localObject2);
            if (this.wwz == null) {
              this.wwz = new SmileySubGrid.c(this, (byte)0);
            }
            y.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "updatePopView %s", new Object[] { Boolean.valueOf(this.jjA) });
            this.wwy.ep(paramView);
            if (this.jjA) {
              break label281;
            }
            this.wwG = true;
            this.mHandler.postDelayed(this.wwz, this.wwA);
            this.wwF = paramInt;
            return;
            i = 0;
            break;
            label227:
            ??? = new EmojiPopView((Context)???);
            break label86;
          }
          if (!(localAbstractPopView instanceof SmileyPopView)) {
            continue;
          }
          ((SmileyPopView)localAbstractPopView).setSmileyItem((a)localObject2);
        }
      }
      y.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "mPopImageView is null.");
      continue;
      label281:
      this.jfe.updateViewLayout(this.wwy, this.wwy.getWindowLayoutParams());
      continue;
      label304:
      y.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks already show:%d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  private void cLy()
  {
    if (this.wwz != null) {
      this.mHandler.removeCallbacks(this.wwz);
    }
    if (this.jjA)
    {
      this.jfe.removeView(this.wwy);
      this.jjA = false;
      this.wwG = false;
    }
  }
  
  private void eo(View paramView)
  {
    Rect localRect = this.acb;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    int i = localRect.left;
    int j = localRect.top;
    int k = localRect.right;
    int m = localRect.bottom;
    this.acb.set(i - getPaddingLeft(), j - getPaddingTop(), k + getPaddingRight(), m + getPaddingBottom());
    boolean bool = this.wwx;
    if (paramView.isEnabled() != bool) {
      if (bool) {
        break label120;
      }
    }
    label120:
    for (bool = true;; bool = false)
    {
      this.wwx = bool;
      refreshDrawableState();
      return;
    }
  }
  
  public int getLongTouchTime()
  {
    return ViewConfiguration.getLongPressTimeout();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    cLy();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.wwH)
    {
      cLy();
      return super.onTouchEvent(paramMotionEvent);
    }
    int i = paramMotionEvent.getAction();
    SmileySubGrid.b localb = null;
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      this.jeW = i;
      this.jeX = j;
      i = pointToPosition(i, j);
      if ((i >= 0) && (getAdapter().isEnabled(i))) {
        this.alA = 0;
      }
      paramMotionEvent = localb;
      if (i >= 0)
      {
        this.www = i;
        paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
      }
      if (paramMotionEvent != null)
      {
        paramMotionEvent.setPressed(true);
        paramMotionEvent.setSelected(true);
        eo(paramMotionEvent);
      }
      if (this.wwB == null) {
        this.wwB = new SmileySubGrid.a(this, (byte)0);
      }
      this.wwB.cID();
      this.acg = i;
      if ((i >= 0) && ((getAdapter() instanceof e)) && (((e)getAdapter()).pY(i)))
      {
        this.mHandler.postDelayed(this.wwB, this.acV);
        continue;
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if (this.uTR == 5)
        {
          i = pointToPosition(i, j);
          this.acg = i;
          if ((i >= 0) && ((getAdapter() instanceof e)) && (((e)getAdapter()).pY(i))) {
            if (this.www != i)
            {
              this.www = i;
              paramMotionEvent = getChildAt(i - getFirstVisiblePosition());
              layoutChildren();
              if (paramMotionEvent != null)
              {
                paramMotionEvent.setPressed(true);
                paramMotionEvent.setSelected(true);
                eo(paramMotionEvent);
                aa(paramMotionEvent, this.www);
              }
            }
          }
          for (;;)
          {
            this.mHandler.removeCallbacks(this.wwB);
            break;
            cLy();
            if (this.www >= 0)
            {
              paramMotionEvent = getChildAt(this.www - getFirstVisiblePosition());
              if (paramMotionEvent != null)
              {
                paramMotionEvent.setPressed(false);
                paramMotionEvent.setSelected(false);
                eo(paramMotionEvent);
              }
            }
          }
        }
        if (Math.abs(this.jeW - i) > this.jb)
        {
          this.alA = -1;
          this.mHandler.removeCallbacks(this.wwB);
        }
        cLy();
        continue;
        j = this.acg;
        paramMotionEvent = getChildAt(j - getFirstVisiblePosition());
        if ((i == 1) && (this.alA != -1))
        {
          if (this.wwC == null) {
            this.wwC = new SmileySubGrid.b(this, (byte)0);
          }
          localb = this.wwC;
          localb.wd = paramMotionEvent;
          localb.vWZ = j;
          localb.cID();
          this.mHandler.post(localb);
        }
        this.mHandler.removeCallbacks(this.wwB);
        setScrollEnable(true);
        cLy();
        if (this.www >= 0)
        {
          paramMotionEvent = getChildAt(this.www - getFirstVisiblePosition());
          if (paramMotionEvent != null)
          {
            paramMotionEvent.setPressed(false);
            paramMotionEvent.setSelected(false);
            eo(paramMotionEvent);
          }
        }
        this.uTR = 6;
      }
    }
  }
  
  public final void release()
  {
    super.release();
    cLy();
    if (this.wwy != null) {
      this.wwy = null;
    }
  }
  
  public void setFromDetail(boolean paramBoolean)
  {
    this.wwE = paramBoolean;
  }
  
  public void setIsShowPopWin(boolean paramBoolean)
  {
    this.wwH = paramBoolean;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    y.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "cpan t setScrollEnable:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (this.wwD != null)
    {
      if (!(this.wwD instanceof MMFlipper)) {
        break label48;
      }
      ((MMFlipper)this.wwD).setScrollEnable(paramBoolean);
    }
    label48:
    while (!(this.wwD instanceof CustomViewPager)) {
      return;
    }
    ((CustomViewPager)this.wwD).setCanSlide(paramBoolean);
  }
  
  public void setViewParent(View paramView)
  {
    this.wwD = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.view.SmileySubGrid
 * JD-Core Version:    0.7.0.1
 */