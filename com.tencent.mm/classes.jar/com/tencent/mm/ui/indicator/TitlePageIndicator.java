package com.tencent.mm.ui.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import androidx.core.g.x;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.CustomViewPager;
import java.util.ArrayList;

public class TitlePageIndicator
  extends View
  implements b
{
  private float XIA;
  private int XIB;
  private final Paint XIC;
  private boolean XID;
  private int XIE;
  private int XIF;
  private int XIG;
  private int XIH;
  private float XII;
  private float XIJ;
  private float XIK;
  private a XIL;
  private a XIM;
  private ViewPager.OnPageChangeListener XIy;
  private int XIz;
  private int mActivePointerId;
  private final Rect mBounds;
  private float mLastMotionX;
  private int mScrollState;
  private int mTouchSlop;
  private CustomViewPager mViewPager;
  private boolean rmR;
  
  public TitlePageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(198332);
    this.XIz = -1;
    this.XIC = new Paint();
    this.mBounds = new Rect();
    this.mLastMotionX = -1.0F;
    this.mActivePointerId = -1;
    init();
    AppMethodBeat.o(198332);
  }
  
  public TitlePageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(198337);
    this.XIz = -1;
    this.XIC = new Paint();
    this.mBounds = new Rect();
    this.mLastMotionX = -1.0F;
    this.mActivePointerId = -1;
    init();
    AppMethodBeat.o(198337);
  }
  
  private Rect a(int paramInt, Paint paramPaint)
  {
    AppMethodBeat.i(198385);
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    CharSequence localCharSequence = axn(paramInt);
    paramPaint.getTextBounds(localCharSequence.toString(), 0, localCharSequence.length(), localRect2);
    localRect1.left = 0;
    localRect1.top = ((getHeight() - localRect2.height()) / 2);
    localRect1.right = (localRect1.left + localRect2.width());
    paramInt = localRect1.top;
    localRect1.bottom = (localRect2.height() + paramInt);
    AppMethodBeat.o(198385);
    return localRect1;
  }
  
  private CharSequence axn(int paramInt)
  {
    AppMethodBeat.i(198405);
    CharSequence localCharSequence = this.mViewPager.getAdapter().getPageTitle(paramInt);
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    AppMethodBeat.o(198405);
    return localObject;
  }
  
  private int getCount()
  {
    AppMethodBeat.i(198406);
    int i = this.mViewPager.getAdapter().getCount();
    AppMethodBeat.o(198406);
    return i + 1;
  }
  
  private void init()
  {
    AppMethodBeat.i(198346);
    if (isInEditMode())
    {
      AppMethodBeat.o(198346);
      return;
    }
    this.XIJ = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
    this.XII = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
    this.XIK = com.tencent.mm.ci.a.fromDPToPix(getContext(), 16);
    this.XIE = com.tencent.mm.ci.a.w(getContext(), a.d.BG_3);
    this.XIF = com.tencent.mm.ci.a.w(getContext(), a.d.white);
    this.XIG = com.tencent.mm.ci.a.fromDPToPix(getContext(), 17);
    this.XIH = com.tencent.mm.ci.a.fromDPToPix(getContext(), 22);
    this.XIL = new a(this.XIE, this.XIF);
    this.XIM = new a(this.XIF, this.XIE);
    this.XID = true;
    this.XIC.setAntiAlias(true);
    this.XIC.setTextAlign(Paint.Align.LEFT);
    this.mTouchSlop = x.a(ViewConfiguration.get(getContext()));
    AppMethodBeat.o(198346);
  }
  
  public float getClipPadding()
  {
    return this.XIK;
  }
  
  public int getSelectedColor()
  {
    return this.XIF;
  }
  
  public int getTextColor()
  {
    return this.XIE;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(198352);
    float f = this.XIC.getTextSize();
    AppMethodBeat.o(198352);
    return f;
  }
  
  public float getTitlePadding()
  {
    return this.XII;
  }
  
  public float getTopPadding()
  {
    return this.XIJ;
  }
  
  public Typeface getTypeface()
  {
    AppMethodBeat.i(198361);
    Typeface localTypeface = this.XIC.getTypeface();
    AppMethodBeat.o(198361);
    return localTypeface;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(198368);
    super.onDraw(paramCanvas);
    if (this.mViewPager == null)
    {
      AppMethodBeat.o(198368);
      return;
    }
    int m = getCount();
    if (m == 0)
    {
      AppMethodBeat.o(198368);
      return;
    }
    if ((this.XIz == -1) && (this.mViewPager != null)) {
      this.XIz = this.mViewPager.getCurrentItem();
    }
    int n = getLeft();
    int i1 = n + getWidth();
    int i = this.XIz;
    float f1;
    Object localObject;
    ArrayList localArrayList;
    int k;
    int i2;
    int i3;
    label145:
    int i4;
    int i5;
    if (this.XIA <= 0.5D)
    {
      f1 = this.XIA;
      localObject = this.XIC;
      localArrayList = new ArrayList();
      k = getCount();
      i2 = getWidth();
      getHeight();
      i3 = i2 / 2;
      j = 0;
      if (j >= k) {
        break label381;
      }
      if (i != j) {
        break label335;
      }
      i4 = this.XIH;
      i5 = this.XIG;
      ((Paint)localObject).setTextSize(this.XIH - (i4 - i5) * f1);
    }
    label335:
    float f2;
    for (Rect localRect = a(j, (Paint)localObject);; localRect = a(j, (Paint)localObject))
    {
      i4 = localRect.right - localRect.left;
      i5 = localRect.bottom;
      i5 = localRect.top;
      localRect.left = ((int)(i3 - i4 / 2.0F) - (int)(this.XIB - this.XIA * (i4 + getClipPadding())) / 2 + (int)((j - this.XIz) * (i2 - i4 - getClipPadding())) / 2);
      localRect.right = (i4 + localRect.left);
      localArrayList.add(localRect);
      j += 1;
      break label145;
      f1 = 1.0F - this.XIA;
      i += 1;
      break;
      i4 = this.XIH;
      i5 = this.XIG;
      f2 = this.XIG;
      ((Paint)localObject).setTextSize((i4 - i5) * f1 + f2);
    }
    label381:
    int j = localArrayList.size();
    if (this.XIz >= j)
    {
      setCurrentItem(j - 1);
      AppMethodBeat.o(198368);
      return;
    }
    j = 0;
    if (j < m)
    {
      localRect = (Rect)localArrayList.get(j);
      label483:
      float f3;
      if (((localRect.left > n) && (localRect.left < i1)) || ((localRect.right > n) && (localRect.right < i1)))
      {
        if (j != i) {
          break label594;
        }
        k = 1;
        localObject = axn(j);
        if (k == 0) {
          break label600;
        }
        k = this.XIH;
        i2 = this.XIG;
        f2 = this.XIH;
        f3 = k - i2;
        this.XIC.setTextSize(f2 - f3 * f1);
        this.XIC.setColor(this.XIM.getColor((int)(100.0F * f1)));
      }
      for (;;)
      {
        paramCanvas.drawText((CharSequence)localObject, 0, ((CharSequence)localObject).length(), localRect.left, localRect.bottom, this.XIC);
        j += 1;
        break;
        label594:
        k = 0;
        break label483;
        label600:
        k = this.XIH;
        i2 = this.XIG;
        f2 = this.XIG;
        f3 = k - i2;
        this.XIC.setTextSize(f3 * f1 + f2);
        this.XIC.setColor(this.XIL.getColor((int)(100.0F * f1)));
      }
    }
    AppMethodBeat.o(198368);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(198394);
    this.mScrollState = paramInt;
    if (this.XIy != null) {
      this.XIy.onPageScrollStateChanged(paramInt);
    }
    AppMethodBeat.o(198394);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(198397);
    Log.i("MicroMsg.TitlePageIndicator", "onPageScrolled %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2) });
    this.XIz = paramInt1;
    this.XIA = paramFloat;
    this.XIB = paramInt2;
    invalidate();
    if (this.XIy != null) {
      this.XIy.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    AppMethodBeat.o(198397);
  }
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(198400);
    if (this.mScrollState == 0)
    {
      this.XIz = paramInt;
      invalidate();
    }
    if (this.XIy != null) {
      this.XIy.onPageSelected(paramInt);
    }
    AppMethodBeat.o(198400);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(198402);
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.XIz = paramParcelable.FDB;
    requestLayout();
    AppMethodBeat.o(198402);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(198403);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.FDB = this.XIz;
    AppMethodBeat.o(198403);
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    AppMethodBeat.i(198380);
    if (super.onTouchEvent(paramMotionEvent))
    {
      AppMethodBeat.o(198380);
      return true;
    }
    if ((this.mViewPager == null) || (getCount() == 0))
    {
      AppMethodBeat.o(198380);
      return false;
    }
    int j = paramMotionEvent.getAction() & 0xFF;
    switch (j)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(198380);
      return true;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.mLastMotionX = paramMotionEvent.getX();
      continue;
      float f1 = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId));
      float f2 = f1 - this.mLastMotionX;
      if ((!this.rmR) && (Math.abs(f2) > this.mTouchSlop)) {
        this.rmR = true;
      }
      if (this.rmR)
      {
        this.mLastMotionX = f1;
        if ((this.mViewPager.isFakeDragging()) || (this.mViewPager.beginFakeDrag()))
        {
          this.mViewPager.fakeDragBy(f2);
          continue;
          if (!this.rmR)
          {
            i = getCount();
            int k = getWidth();
            f1 = k / 2.0F;
            f2 = k / 6.0F;
            float f3 = paramMotionEvent.getX();
            if (f3 < f1 - f2)
            {
              if (this.XIz > 0)
              {
                if (j != 3) {
                  this.mViewPager.setCurrentItem(this.XIz - 1);
                }
                AppMethodBeat.o(198380);
                return true;
              }
            }
            else if ((f3 > f2 + f1) && (this.XIz < i - 1))
            {
              if (j != 3) {
                this.mViewPager.setCurrentItem(this.XIz + 1);
              }
              AppMethodBeat.o(198380);
              return true;
            }
          }
          this.rmR = false;
          this.mActivePointerId = -1;
          if (this.mViewPager.isFakeDragging())
          {
            this.mViewPager.endFakeDrag();
            continue;
            i = paramMotionEvent.getActionIndex();
            this.mLastMotionX = paramMotionEvent.getX(i);
            this.mActivePointerId = paramMotionEvent.getPointerId(i);
            continue;
            j = paramMotionEvent.getActionIndex();
            if (paramMotionEvent.getPointerId(j) == this.mActivePointerId)
            {
              if (j == 0) {
                i = 1;
              }
              this.mActivePointerId = paramMotionEvent.getPointerId(i);
            }
            this.mLastMotionX = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId));
          }
        }
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    AppMethodBeat.i(198393);
    if (this.mViewPager == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("ViewPager has not been bound.");
      AppMethodBeat.o(198393);
      throw localIllegalStateException;
    }
    this.mViewPager.setCurrentItem(paramInt);
    this.XIz = paramInt;
    invalidate();
    AppMethodBeat.o(198393);
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.XIy = paramOnPageChangeListener;
  }
  
  public void setSelectedBold(boolean paramBoolean)
  {
    AppMethodBeat.i(198348);
    this.XID = paramBoolean;
    invalidate();
    AppMethodBeat.o(198348);
  }
  
  public void setSelectedColor(int paramInt)
  {
    AppMethodBeat.i(198347);
    this.XIF = paramInt;
    invalidate();
    AppMethodBeat.o(198347);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(198351);
    this.XIC.setColor(paramInt);
    this.XIE = paramInt;
    invalidate();
    AppMethodBeat.o(198351);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(198355);
    this.XIC.setTextSize(paramFloat);
    invalidate();
    AppMethodBeat.o(198355);
  }
  
  public void setTitlePadding(float paramFloat)
  {
    AppMethodBeat.i(198357);
    this.XII = paramFloat;
    invalidate();
    AppMethodBeat.o(198357);
  }
  
  public void setTopPadding(float paramFloat)
  {
    AppMethodBeat.i(198359);
    this.XIJ = paramFloat;
    invalidate();
    AppMethodBeat.o(198359);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(198360);
    this.XIC.setTypeface(paramTypeface);
    invalidate();
    AppMethodBeat.o(198360);
  }
  
  public void setViewPager(CustomViewPager paramCustomViewPager)
  {
    AppMethodBeat.i(198388);
    if (this.mViewPager == paramCustomViewPager)
    {
      AppMethodBeat.o(198388);
      return;
    }
    if (this.mViewPager != null) {
      this.mViewPager.setOnPageChangeListener(null);
    }
    if (paramCustomViewPager.getAdapter() == null)
    {
      paramCustomViewPager = new IllegalStateException("ViewPager does not have adapter instance.");
      AppMethodBeat.o(198388);
      throw paramCustomViewPager;
    }
    this.mViewPager = paramCustomViewPager;
    this.mViewPager.setOnPageChangeListener(this);
    invalidate();
    AppMethodBeat.o(198388);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    int FDB;
    
    static
    {
      AppMethodBeat.i(195822);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(195822);
    }
    
    private SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(195813);
      this.FDB = paramParcel.readInt();
      AppMethodBeat.o(195813);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(195818);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.FDB);
      AppMethodBeat.o(195818);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.indicator.TitlePageIndicator
 * JD-Core Version:    0.7.0.1
 */