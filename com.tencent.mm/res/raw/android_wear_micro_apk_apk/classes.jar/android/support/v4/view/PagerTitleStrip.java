package android.support.v4.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.v;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import java.lang.ref.WeakReference;

@ah
public class PagerTitleStrip
  extends ViewGroup
{
  private static final int[] mv = { 16842804, 16842901, 16842904, 16842927 };
  private static final int[] mw = { 16843660 };
  private int ho;
  ViewPager mk;
  TextView ml;
  TextView mm;
  TextView mn;
  private int mo = -1;
  float mp = -1.0F;
  private int mq;
  private boolean mr;
  private boolean ms;
  private final p mt = new p(this);
  private WeakReference<o> mu;
  private int mx;
  int my;
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TextView localTextView = new TextView(paramContext);
    this.ml = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.mm = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.mn = localTextView;
    addView(localTextView);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, mv);
    int i = paramAttributeSet.getResourceId(0, 0);
    if (i != 0)
    {
      v.a(this.ml, i);
      v.a(this.mm, i);
      v.a(this.mn, i);
    }
    int j = paramAttributeSet.getDimensionPixelSize(1, 0);
    if (j != 0)
    {
      float f = j;
      this.ml.setTextSize(0, f);
      this.mm.setTextSize(0, f);
      this.mn.setTextSize(0, f);
    }
    if (paramAttributeSet.hasValue(2))
    {
      j = paramAttributeSet.getColor(2, 0);
      this.ml.setTextColor(j);
      this.mm.setTextColor(j);
      this.mn.setTextColor(j);
    }
    this.ho = paramAttributeSet.getInteger(3, 80);
    paramAttributeSet.recycle();
    this.my = this.mm.getTextColors().getDefaultColor();
    this.mx = 153;
    j = this.mx << 24 | this.my & 0xFFFFFF;
    this.ml.setTextColor(j);
    this.mn.setTextColor(j);
    this.ml.setEllipsize(TextUtils.TruncateAt.END);
    this.mm.setEllipsize(TextUtils.TruncateAt.END);
    this.mn.setEllipsize(TextUtils.TruncateAt.END);
    if (i != 0)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(i, mw);
      bool = paramAttributeSet.getBoolean(0, false);
      paramAttributeSet.recycle();
    }
    if (bool)
    {
      a(this.ml);
      a(this.mm);
      a(this.mn);
    }
    for (;;)
    {
      this.mq = ((int)(paramContext.getResources().getDisplayMetrics().density * 16.0F));
      return;
      this.ml.setSingleLine();
      this.mm.setSingleLine();
      this.mn.setSingleLine();
    }
  }
  
  private void a(o paramo1, o paramo2)
  {
    if (paramo1 != null)
    {
      paramo1.unregisterDataSetObserver(this.mt);
      this.mu = null;
    }
    if (paramo2 != null)
    {
      paramo2.registerDataSetObserver(this.mt);
      this.mu = new WeakReference(paramo2);
    }
    if (this.mk != null)
    {
      this.mo = -1;
      this.mp = -1.0F;
      a(this.mk.mY, paramo2);
      requestLayout();
    }
  }
  
  private static void a(TextView paramTextView)
  {
    paramTextView.setTransformationMethod(new q(paramTextView.getContext()));
  }
  
  public void I(int paramInt)
  {
    this.mq = paramInt;
    requestLayout();
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    int m;
    int i4;
    int k;
    int i3;
    int n;
    int i;
    int i2;
    int i1;
    int j;
    int i5;
    int i7;
    int i6;
    int i8;
    if (paramInt != this.mo)
    {
      a(paramInt, this.mk.mX);
      this.ms = true;
      m = this.ml.getMeasuredWidth();
      i4 = this.mm.getMeasuredWidth();
      k = this.mn.getMeasuredWidth();
      i3 = i4 / 2;
      n = getWidth();
      i = getHeight();
      i2 = getPaddingLeft();
      i1 = getPaddingRight();
      paramInt = getPaddingTop();
      j = getPaddingBottom();
      i5 = i1 + i3;
      float f2 = 0.5F + paramFloat;
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = f2 - 1.0F;
      }
      i3 = n - i5 - (int)(f1 * (n - (i2 + i3) - i5)) - i3;
      i4 = i3 + i4;
      i7 = this.ml.getBaseline();
      i6 = this.mm.getBaseline();
      i5 = this.mn.getBaseline();
      i8 = Math.max(Math.max(i7, i6), i5);
      i7 = i8 - i7;
      i6 = i8 - i6;
      i5 = i8 - i5;
      i8 = this.ml.getMeasuredHeight();
      int i9 = this.mm.getMeasuredHeight();
      int i10 = this.mn.getMeasuredHeight();
      i8 = Math.max(Math.max(i8 + i7, i9 + i6), i10 + i5);
      switch (this.ho & 0x70)
      {
      default: 
        j = paramInt + i7;
        i = paramInt + i6;
        paramInt += i5;
      }
    }
    for (;;)
    {
      this.mm.layout(i3, i, i4, this.mm.getMeasuredHeight() + i);
      i = Math.min(i2, i3 - this.mq - m);
      this.ml.layout(i, j, m + i, this.ml.getMeasuredHeight() + j);
      i = Math.max(n - i1 - k, this.mq + i4);
      this.mn.layout(i, paramInt, i + k, this.mn.getMeasuredHeight() + paramInt);
      this.mp = paramFloat;
      this.ms = false;
      return;
      if ((paramBoolean) || (paramFloat != this.mp)) {
        break;
      }
      return;
      paramInt = (i - paramInt - j - i8) / 2;
      j = paramInt + i7;
      i = paramInt + i6;
      paramInt += i5;
      continue;
      paramInt = i - j - i8;
      j = paramInt + i7;
      i = paramInt + i6;
      paramInt += i5;
    }
  }
  
  final void a(int paramInt, o paramo)
  {
    this.mr = true;
    this.ml.setText(null);
    this.mm.setText(null);
    this.mn.setText(null);
    int i = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), -2147483648);
    int j = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), -2147483648);
    this.ml.measure(i, j);
    this.mm.measure(i, j);
    this.mn.measure(i, j);
    this.mo = paramInt;
    if (!this.ms) {
      a(paramInt, this.mp, false);
    }
    this.mr = false;
  }
  
  public final int bI()
  {
    return this.mq;
  }
  
  int getMinHeight()
  {
    int i = 0;
    Drawable localDrawable = getBackground();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicHeight();
    }
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getParent();
    if (!(localObject instanceof ViewPager)) {
      throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }
    localObject = (ViewPager)localObject;
    o localo = ((ViewPager)localObject).mX;
    ((ViewPager)localObject).a(this.mt);
    ((ViewPager)localObject).a(this.mt);
    this.mk = ((ViewPager)localObject);
    if (this.mu != null) {}
    for (localObject = (o)this.mu.get();; localObject = null)
    {
      a((o)localObject, localo);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mk != null)
    {
      a(this.mk.mX, null);
      this.mk.a(null);
      this.mk.b(this.mt);
      this.mk = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    if (this.mk != null)
    {
      if (this.mp >= 0.0F) {
        f = this.mp;
      }
      a(this.mo, f, true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      throw new IllegalStateException("Must measure with an exact width");
    }
    int j = getPaddingTop() + getPaddingBottom();
    int k = getChildMeasureSpec(paramInt2, j, -2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = getChildMeasureSpec(paramInt1, (int)(i * 0.2F), -2);
    this.ml.measure(paramInt1, k);
    this.mm.measure(paramInt1, k);
    this.mn.measure(paramInt1, k);
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (paramInt1 = View.MeasureSpec.getSize(paramInt2);; paramInt1 = Math.max(getMinHeight(), j + paramInt1))
    {
      setMeasuredDimension(i, View.resolveSizeAndState(paramInt1, paramInt2, this.mm.getMeasuredState() << 16));
      return;
      paramInt1 = this.mm.getMeasuredHeight();
    }
  }
  
  public void requestLayout()
  {
    if (!this.mr) {
      super.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStrip
 * JD-Core Version:    0.7.0.1
 */