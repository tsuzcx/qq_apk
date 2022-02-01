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
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.q;
import android.support.v4.view.v;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.CustomViewPager;
import java.util.ArrayList;

public class TitlePageIndicator
  extends View
  implements b
{
  private ViewPager.OnPageChangeListener Qlc;
  private int Qld;
  private float Qle;
  private int Qlf;
  private final Paint Qlg;
  private boolean Qlh;
  private int Qli;
  private int Qlj;
  private int Qlk;
  private int Qll;
  private float Qlm;
  private float Qln;
  private float Qlo;
  private a Qlp;
  private a Qlq;
  private int mActivePointerId;
  private final Rect mBounds;
  private float mLastMotionX;
  private int mScrollState;
  private int mTouchSlop;
  private CustomViewPager mViewPager;
  private boolean okz;
  
  public TitlePageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205321);
    this.Qld = -1;
    this.Qlg = new Paint();
    this.mBounds = new Rect();
    this.mLastMotionX = -1.0F;
    this.mActivePointerId = -1;
    init();
    AppMethodBeat.o(205321);
  }
  
  public TitlePageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205322);
    this.Qld = -1;
    this.Qlg = new Paint();
    this.mBounds = new Rect();
    this.mLastMotionX = -1.0F;
    this.mActivePointerId = -1;
    init();
    AppMethodBeat.o(205322);
  }
  
  private Rect a(int paramInt, Paint paramPaint)
  {
    AppMethodBeat.i(205335);
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    CharSequence localCharSequence = aoj(paramInt);
    paramPaint.getTextBounds(localCharSequence.toString(), 0, localCharSequence.length(), localRect2);
    localRect1.left = 0;
    localRect1.top = ((getHeight() - localRect2.height()) / 2);
    localRect1.right = (localRect1.left + localRect2.width());
    paramInt = localRect1.top;
    localRect1.bottom = (localRect2.height() + paramInt);
    AppMethodBeat.o(205335);
    return localRect1;
  }
  
  private CharSequence aoj(int paramInt)
  {
    AppMethodBeat.i(205343);
    CharSequence localCharSequence = this.mViewPager.getAdapter().getPageTitle(paramInt);
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    AppMethodBeat.o(205343);
    return localObject;
  }
  
  private int getCount()
  {
    AppMethodBeat.i(205344);
    int i = this.mViewPager.getAdapter().getCount();
    AppMethodBeat.o(205344);
    return i + 1;
  }
  
  private void init()
  {
    AppMethodBeat.i(205323);
    if (isInEditMode())
    {
      AppMethodBeat.o(205323);
      return;
    }
    this.Qln = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
    this.Qlm = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
    this.Qlo = com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
    this.Qli = com.tencent.mm.cb.a.n(getContext(), 2131099651);
    this.Qlj = com.tencent.mm.cb.a.n(getContext(), 2131101424);
    this.Qlk = com.tencent.mm.cb.a.fromDPToPix(getContext(), 17);
    this.Qll = com.tencent.mm.cb.a.fromDPToPix(getContext(), 22);
    this.Qlp = new a(this.Qli, this.Qlj);
    this.Qlq = new a(this.Qlj, this.Qli);
    this.Qlh = true;
    this.Qlg.setAntiAlias(true);
    this.Qlg.setTextAlign(Paint.Align.LEFT);
    this.mTouchSlop = v.a(ViewConfiguration.get(getContext()));
    AppMethodBeat.o(205323);
  }
  
  public float getClipPadding()
  {
    return this.Qlo;
  }
  
  public int getSelectedColor()
  {
    return this.Qlj;
  }
  
  public int getTextColor()
  {
    return this.Qli;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(205327);
    float f = this.Qlg.getTextSize();
    AppMethodBeat.o(205327);
    return f;
  }
  
  public float getTitlePadding()
  {
    return this.Qlm;
  }
  
  public float getTopPadding()
  {
    return this.Qln;
  }
  
  public Typeface getTypeface()
  {
    AppMethodBeat.i(205332);
    Typeface localTypeface = this.Qlg.getTypeface();
    AppMethodBeat.o(205332);
    return localTypeface;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(205333);
    super.onDraw(paramCanvas);
    if (this.mViewPager == null)
    {
      AppMethodBeat.o(205333);
      return;
    }
    int m = getCount();
    if (m == 0)
    {
      AppMethodBeat.o(205333);
      return;
    }
    if ((this.Qld == -1) && (this.mViewPager != null)) {
      this.Qld = this.mViewPager.getCurrentItem();
    }
    int n = getLeft();
    int i1 = n + getWidth();
    int i = this.Qld;
    float f1;
    Object localObject;
    ArrayList localArrayList;
    int k;
    int i2;
    int i3;
    label145:
    int i4;
    int i5;
    if (this.Qle <= 0.5D)
    {
      f1 = this.Qle;
      localObject = this.Qlg;
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
      i4 = this.Qll;
      i5 = this.Qlk;
      ((Paint)localObject).setTextSize(this.Qll - (i4 - i5) * f1);
    }
    label335:
    float f2;
    for (Rect localRect = a(j, (Paint)localObject);; localRect = a(j, (Paint)localObject))
    {
      i4 = localRect.right - localRect.left;
      i5 = localRect.bottom;
      i5 = localRect.top;
      localRect.left = ((int)(i3 - i4 / 2.0F) - (int)(this.Qlf - this.Qle * (i4 + getClipPadding())) / 2 + (int)((j - this.Qld) * (i2 - i4 - getClipPadding())) / 2);
      localRect.right = (i4 + localRect.left);
      localArrayList.add(localRect);
      j += 1;
      break label145;
      f1 = 1.0F - this.Qle;
      i += 1;
      break;
      i4 = this.Qll;
      i5 = this.Qlk;
      f2 = this.Qlk;
      ((Paint)localObject).setTextSize((i4 - i5) * f1 + f2);
    }
    label381:
    int j = localArrayList.size();
    if (this.Qld >= j)
    {
      setCurrentItem(j - 1);
      AppMethodBeat.o(205333);
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
        localObject = aoj(j);
        if (k == 0) {
          break label600;
        }
        k = this.Qll;
        i2 = this.Qlk;
        f2 = this.Qll;
        f3 = k - i2;
        this.Qlg.setTextSize(f2 - f3 * f1);
        this.Qlg.setColor(this.Qlq.getColor((int)(100.0F * f1)));
      }
      for (;;)
      {
        paramCanvas.drawText((CharSequence)localObject, 0, ((CharSequence)localObject).length(), localRect.left, localRect.bottom, this.Qlg);
        j += 1;
        break;
        label594:
        k = 0;
        break label483;
        label600:
        k = this.Qll;
        i2 = this.Qlk;
        f2 = this.Qlk;
        f3 = k - i2;
        this.Qlg.setTextSize(f3 * f1 + f2);
        this.Qlg.setColor(this.Qlp.getColor((int)(100.0F * f1)));
      }
    }
    AppMethodBeat.o(205333);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(205338);
    this.mScrollState = paramInt;
    if (this.Qlc != null) {
      this.Qlc.onPageScrollStateChanged(paramInt);
    }
    AppMethodBeat.o(205338);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(205339);
    Log.i("MicroMsg.TitlePageIndicator", "onPageScrolled %s, %s, %s", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(paramFloat), Integer.valueOf(paramInt2) });
    this.Qld = paramInt1;
    this.Qle = paramFloat;
    this.Qlf = paramInt2;
    invalidate();
    if (this.Qlc != null) {
      this.Qlc.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
    AppMethodBeat.o(205339);
  }
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(205340);
    if (this.mScrollState == 0)
    {
      this.Qld = paramInt;
      invalidate();
    }
    if (this.Qlc != null) {
      this.Qlc.onPageSelected(paramInt);
    }
    AppMethodBeat.o(205340);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(205341);
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.Qld = paramParcelable.zXP;
    requestLayout();
    AppMethodBeat.o(205341);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(205342);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.zXP = this.Qld;
    AppMethodBeat.o(205342);
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    AppMethodBeat.i(205334);
    if (super.onTouchEvent(paramMotionEvent))
    {
      AppMethodBeat.o(205334);
      return true;
    }
    if ((this.mViewPager == null) || (getCount() == 0))
    {
      AppMethodBeat.o(205334);
      return false;
    }
    int j = paramMotionEvent.getAction() & 0xFF;
    switch (j)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(205334);
      return true;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.mLastMotionX = paramMotionEvent.getX();
      continue;
      float f1 = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.mActivePointerId));
      float f2 = f1 - this.mLastMotionX;
      if ((!this.okz) && (Math.abs(f2) > this.mTouchSlop)) {
        this.okz = true;
      }
      if (this.okz)
      {
        this.mLastMotionX = f1;
        if ((this.mViewPager.isFakeDragging()) || (this.mViewPager.beginFakeDrag()))
        {
          this.mViewPager.fakeDragBy(f2);
          continue;
          if (!this.okz)
          {
            i = getCount();
            int k = getWidth();
            f1 = k / 2.0F;
            f2 = k / 6.0F;
            float f3 = paramMotionEvent.getX();
            if (f3 < f1 - f2)
            {
              if (this.Qld > 0)
              {
                if (j != 3) {
                  this.mViewPager.setCurrentItem(this.Qld - 1);
                }
                AppMethodBeat.o(205334);
                return true;
              }
            }
            else if ((f3 > f2 + f1) && (this.Qld < i - 1))
            {
              if (j != 3) {
                this.mViewPager.setCurrentItem(this.Qld + 1);
              }
              AppMethodBeat.o(205334);
              return true;
            }
          }
          this.okz = false;
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
    AppMethodBeat.i(205337);
    if (this.mViewPager == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("ViewPager has not been bound.");
      AppMethodBeat.o(205337);
      throw localIllegalStateException;
    }
    this.mViewPager.setCurrentItem(paramInt);
    this.Qld = paramInt;
    invalidate();
    AppMethodBeat.o(205337);
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.Qlc = paramOnPageChangeListener;
  }
  
  public void setSelectedBold(boolean paramBoolean)
  {
    AppMethodBeat.i(205325);
    this.Qlh = paramBoolean;
    invalidate();
    AppMethodBeat.o(205325);
  }
  
  public void setSelectedColor(int paramInt)
  {
    AppMethodBeat.i(205324);
    this.Qlj = paramInt;
    invalidate();
    AppMethodBeat.o(205324);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(205326);
    this.Qlg.setColor(paramInt);
    this.Qli = paramInt;
    invalidate();
    AppMethodBeat.o(205326);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(205328);
    this.Qlg.setTextSize(paramFloat);
    invalidate();
    AppMethodBeat.o(205328);
  }
  
  public void setTitlePadding(float paramFloat)
  {
    AppMethodBeat.i(205329);
    this.Qlm = paramFloat;
    invalidate();
    AppMethodBeat.o(205329);
  }
  
  public void setTopPadding(float paramFloat)
  {
    AppMethodBeat.i(205330);
    this.Qln = paramFloat;
    invalidate();
    AppMethodBeat.o(205330);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(205331);
    this.Qlg.setTypeface(paramTypeface);
    invalidate();
    AppMethodBeat.o(205331);
  }
  
  public void setViewPager(CustomViewPager paramCustomViewPager)
  {
    AppMethodBeat.i(205336);
    if (this.mViewPager == paramCustomViewPager)
    {
      AppMethodBeat.o(205336);
      return;
    }
    if (this.mViewPager != null) {
      this.mViewPager.setOnPageChangeListener(null);
    }
    if (paramCustomViewPager.getAdapter() == null)
    {
      paramCustomViewPager = new IllegalStateException("ViewPager does not have adapter instance.");
      AppMethodBeat.o(205336);
      throw paramCustomViewPager;
    }
    this.mViewPager = paramCustomViewPager;
    this.mViewPager.setOnPageChangeListener(this);
    invalidate();
    AppMethodBeat.o(205336);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    int zXP;
    
    static
    {
      AppMethodBeat.i(205320);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(205320);
    }
    
    private SavedState(Parcel paramParcel)
    {
      super();
      AppMethodBeat.i(205318);
      this.zXP = paramParcel.readInt();
      AppMethodBeat.o(205318);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(205319);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.zXP);
      AppMethodBeat.o(205319);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.indicator.TitlePageIndicator
 * JD-Core Version:    0.7.0.1
 */