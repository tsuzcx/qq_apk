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
import androidx.core.g.aa;
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
  private ViewPager.OnPageChangeListener afwe;
  private int afwf;
  private float afwg;
  private int afwh;
  private final Paint afwi;
  private boolean afwj;
  private int afwk;
  private int afwl;
  private int afwm;
  private int afwn;
  private float afwo;
  private float afwp;
  private float afwq;
  private a afwr;
  private a afws;
  private int mActivePointerId;
  private final Rect mBounds;
  private float mLastMotionX;
  private int mScrollState;
  private int mTouchSlop;
  private CustomViewPager mViewPager;
  private boolean uwK;
  
  public TitlePageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(249702);
    this.afwf = -1;
    this.afwi = new Paint();
    this.mBounds = new Rect();
    this.mLastMotionX = -1.0F;
    this.mActivePointerId = -1;
    init();
    AppMethodBeat.o(249702);
  }
  
  public TitlePageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(249707);
    this.afwf = -1;
    this.afwi = new Paint();
    this.mBounds = new Rect();
    this.mLastMotionX = -1.0F;
    this.mActivePointerId = -1;
    init();
    AppMethodBeat.o(249707);
  }
  
  private Rect a(int paramInt, Paint paramPaint)
  {
    AppMethodBeat.i(249718);
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    CharSequence localCharSequence = aDX(paramInt);
    paramPaint.getTextBounds(localCharSequence.toString(), 0, localCharSequence.length(), localRect2);
    localRect1.left = 0;
    localRect1.top = ((getHeight() - localRect2.height()) / 2);
    localRect1.right = (localRect1.left + localRect2.width());
    paramInt = localRect1.top;
    localRect1.bottom = (localRect2.height() + paramInt);
    AppMethodBeat.o(249718);
    return localRect1;
  }
  
  private CharSequence aDX(int paramInt)
  {
    AppMethodBeat.i(249722);
    CharSequence localCharSequence = this.mViewPager.getAdapter().getPageTitle(paramInt);
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    AppMethodBeat.o(249722);
    return localObject;
  }
  
  private int getCount()
  {
    AppMethodBeat.i(249725);
    int i = this.mViewPager.getAdapter().getCount();
    AppMethodBeat.o(249725);
    return i + 1;
  }
  
  private void init()
  {
    AppMethodBeat.i(249712);
    if (isInEditMode())
    {
      AppMethodBeat.o(249712);
      return;
    }
    this.afwp = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
    this.afwo = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
    this.afwq = com.tencent.mm.cd.a.fromDPToPix(getContext(), 16);
    this.afwk = com.tencent.mm.cd.a.w(getContext(), a.d.BG_3);
    this.afwl = com.tencent.mm.cd.a.w(getContext(), a.d.white);
    this.afwm = com.tencent.mm.cd.a.fromDPToPix(getContext(), 17);
    this.afwn = com.tencent.mm.cd.a.fromDPToPix(getContext(), 22);
    this.afwr = new a(this.afwk, this.afwl);
    this.afws = new a(this.afwl, this.afwk);
    this.afwj = true;
    this.afwi.setAntiAlias(true);
    this.afwi.setTextAlign(Paint.Align.LEFT);
    this.mTouchSlop = aa.a(ViewConfiguration.get(getContext()));
    AppMethodBeat.o(249712);
  }
  
  public float getClipPadding()
  {
    return this.afwq;
  }
  
  public int getSelectedColor()
  {
    return this.afwl;
  }
  
  public int getTextColor()
  {
    return this.afwk;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(249743);
    float f = this.afwi.getTextSize();
    AppMethodBeat.o(249743);
    return f;
  }
  
  public float getTitlePadding()
  {
    return this.afwo;
  }
  
  public float getTopPadding()
  {
    return this.afwp;
  }
  
  public Typeface getTypeface()
  {
    AppMethodBeat.i(249760);
    Typeface localTypeface = this.afwi.getTypeface();
    AppMethodBeat.o(249760);
    return localTypeface;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(249765);
    super.onDraw(paramCanvas);
    if (this.mViewPager == null)
    {
      AppMethodBeat.o(249765);
      return;
    }
    int m = getCount();
    if (m == 0)
    {
      AppMethodBeat.o(249765);
      return;
    }
    if ((this.afwf == -1) && (this.mViewPager != null)) {
      this.afwf = this.mViewPager.getCurrentItem();
    }
    int n = getLeft();
    int i1 = n + getWidth();
    int i = this.afwf;
    float f1;
    Object localObject;
    ArrayList localArrayList;
    int k;
    int i2;
    int i3;
    label145:
    int i4;
    int i5;
    if (this.afwg <= 0.5D)
    {
      f1 = this.afwg;
      localObject = this.afwi;
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
      i4 = this.afwn;
      i5 = this.afwm;
      ((Paint)localObject).setTextSize(this.afwn - (i4 - i5) * f1);
    }
    label335:
    float f2;
    for (Rect localRect = a(j, (Paint)localObject);; localRect = a(j, (Paint)localObject))
    {
      i4 = localRect.right - localRect.left;
      i5 = localRect.bottom;
      i5 = localRect.top;
      localRect.left = ((int)(i3 - i4 / 2.0F) - (int)(this.afwh - this.afwg * (i4 + getClipPadding())) / 2 + (int)((j - this.afwf) * (i2 - i4 - getClipPadding())) / 2);
      localRect.right = (i4 + localRect.left);
      localArrayList.add(localRect);
      j += 1;
      break label145;
      f1 = 1.0F - this.afwg;
      i += 1;
      break;
      i4 = this.afwn;
      i5 = this.afwm;
      f2 = this.afwm;
      ((Paint)localObject).setTextSize((i4 - i5) * f1 + f2);
    }
    label381:
    int j = localArrayList.size();
    if (this.afwf >= j)
    {
      setCurrentItem(j - 1);
      AppMethodBeat.o(249765);
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
        localObject = aDX(j);
        if (k == 0) {
          break label600;
        }
        k = this.afwn;
        i2 = this.afwm;
        f2 = this.afwn;
        f3 = k - i2;
        this.afwi.setTextSize(f2 - f3 * f1);
        this.afwi.setColor(this.afws.getColor((int)(100.0F * f1)));
      }
      for (;;)
      {
        paramCanvas.drawText((CharSequence)localObject, 0, ((CharSequence)localObject).length(), localRect.left, localRect.bottom, this.afwi);
        j += 1;
        break;
        label594:
        k = 0;
        break label483;
        label600:
        k = this.afwn;
        i2 = this.afwm;
        f2 = this.afwm;
        f3 = k - i2;
        this.afwi.setTextSize(f3 * f1 + f2);
        this.afwi.setColor(this.afwr.getColor((int)(100.0F * f1)));
      }
    }
    AppMethodBeat.o(249765);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(249780);
    this.mScrollState = paramInt;
    if (this.afwe != null) {
      this.afwe.onPageScrollStateChanged(paramInt);
    }
    AppMethodBeat.o(249780);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(249784);
    Log.i("MicroMsg.TitlePageIndicator", "onPageScrolled %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2) });
    this.afwf = paramInt1;
    this.afwg = paramFloat;
    this.afwh = paramInt2;
    invalidate();
    if (this.afwe != null) {
      this.afwe.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    AppMethodBeat.o(249784);
  }
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(249785);
    if (this.mScrollState == 0)
    {
      this.afwf = paramInt;
      invalidate();
    }
    if (this.afwe != null) {
      this.afwe.onPageSelected(paramInt);
    }
    AppMethodBeat.o(249785);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(249787);
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.afwf = paramParcelable.Lzr;
    requestLayout();
    AppMethodBeat.o(249787);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(249788);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.Lzr = this.afwf;
    AppMethodBeat.o(249788);
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    AppMethodBeat.i(249770);
    if (super.onTouchEvent(paramMotionEvent))
    {
      AppMethodBeat.o(249770);
      return true;
    }
    if ((this.mViewPager == null) || (getCount() == 0))
    {
      AppMethodBeat.o(249770);
      return false;
    }
    int j = paramMotionEvent.getAction() & 0xFF;
    switch (j)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(249770);
      return true;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.mLastMotionX = paramMotionEvent.getX();
      continue;
      float f1 = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId));
      float f2 = f1 - this.mLastMotionX;
      if ((!this.uwK) && (Math.abs(f2) > this.mTouchSlop)) {
        this.uwK = true;
      }
      if (this.uwK)
      {
        this.mLastMotionX = f1;
        if ((this.mViewPager.isFakeDragging()) || (this.mViewPager.beginFakeDrag()))
        {
          this.mViewPager.fakeDragBy(f2);
          continue;
          if (!this.uwK)
          {
            i = getCount();
            int k = getWidth();
            f1 = k / 2.0F;
            f2 = k / 6.0F;
            float f3 = paramMotionEvent.getX();
            if (f3 < f1 - f2)
            {
              if (this.afwf > 0)
              {
                if (j != 3) {
                  this.mViewPager.setCurrentItem(this.afwf - 1);
                }
                AppMethodBeat.o(249770);
                return true;
              }
            }
            else if ((f3 > f2 + f1) && (this.afwf < i - 1))
            {
              if (j != 3) {
                this.mViewPager.setCurrentItem(this.afwf + 1);
              }
              AppMethodBeat.o(249770);
              return true;
            }
          }
          this.uwK = false;
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
    AppMethodBeat.i(249778);
    if (this.mViewPager == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("ViewPager has not been bound.");
      AppMethodBeat.o(249778);
      throw localIllegalStateException;
    }
    this.mViewPager.setCurrentItem(paramInt);
    this.afwf = paramInt;
    invalidate();
    AppMethodBeat.o(249778);
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.afwe = paramOnPageChangeListener;
  }
  
  public void setSelectedBold(boolean paramBoolean)
  {
    AppMethodBeat.i(249734);
    this.afwj = paramBoolean;
    invalidate();
    AppMethodBeat.o(249734);
  }
  
  public void setSelectedColor(int paramInt)
  {
    AppMethodBeat.i(249731);
    this.afwl = paramInt;
    invalidate();
    AppMethodBeat.o(249731);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(249738);
    this.afwi.setColor(paramInt);
    this.afwk = paramInt;
    invalidate();
    AppMethodBeat.o(249738);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(249745);
    this.afwi.setTextSize(paramFloat);
    invalidate();
    AppMethodBeat.o(249745);
  }
  
  public void setTitlePadding(float paramFloat)
  {
    AppMethodBeat.i(249751);
    this.afwo = paramFloat;
    invalidate();
    AppMethodBeat.o(249751);
  }
  
  public void setTopPadding(float paramFloat)
  {
    AppMethodBeat.i(249755);
    this.afwp = paramFloat;
    invalidate();
    AppMethodBeat.o(249755);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(249757);
    this.afwi.setTypeface(paramTypeface);
    invalidate();
    AppMethodBeat.o(249757);
  }
  
  public void setViewPager(CustomViewPager paramCustomViewPager)
  {
    AppMethodBeat.i(249774);
    if (this.mViewPager == paramCustomViewPager)
    {
      AppMethodBeat.o(249774);
      return;
    }
    if (this.mViewPager != null) {
      this.mViewPager.setOnPageChangeListener(null);
    }
    if (paramCustomViewPager.getAdapter() == null)
    {
      paramCustomViewPager = new IllegalStateException("ViewPager does not have adapter instance.");
      AppMethodBeat.o(249774);
      throw paramCustomViewPager;
    }
    this.mViewPager = paramCustomViewPager;
    this.mViewPager.setOnPageChangeListener(this);
    invalidate();
    AppMethodBeat.o(249774);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    int Lzr;
    
    static
    {
      AppMethodBeat.i(249716);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(249716);
    }
    
    private SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(249708);
      this.Lzr = paramParcel.readInt();
      AppMethodBeat.o(249708);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(249721);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.Lzr);
      AppMethodBeat.o(249721);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.indicator.TitlePageIndicator
 * JD-Core Version:    0.7.0.1
 */