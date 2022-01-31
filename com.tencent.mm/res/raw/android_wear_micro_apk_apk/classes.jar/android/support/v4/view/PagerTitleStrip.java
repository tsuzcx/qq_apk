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
  private static final int[] kA = { 16843660 };
  private static final int[] kz = { 16842804, 16842901, 16842904, 16842927 };
  private int kB;
  int kC;
  ViewPager kn;
  TextView ko;
  TextView kp;
  TextView kq;
  private int kr = -1;
  float ks = -1.0F;
  private int kt;
  private int ku;
  private boolean kv;
  private boolean kw;
  private final p kx = new p(this);
  private WeakReference<o> ky;
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TextView localTextView = new TextView(paramContext);
    this.ko = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.kp = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.kq = localTextView;
    addView(localTextView);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, kz);
    int i = paramAttributeSet.getResourceId(0, 0);
    if (i != 0)
    {
      v.a(this.ko, i);
      v.a(this.kp, i);
      v.a(this.kq, i);
    }
    int j = paramAttributeSet.getDimensionPixelSize(1, 0);
    if (j != 0)
    {
      float f = j;
      this.ko.setTextSize(0, f);
      this.kp.setTextSize(0, f);
      this.kq.setTextSize(0, f);
    }
    if (paramAttributeSet.hasValue(2))
    {
      j = paramAttributeSet.getColor(2, 0);
      this.ko.setTextColor(j);
      this.kp.setTextColor(j);
      this.kq.setTextColor(j);
    }
    this.ku = paramAttributeSet.getInteger(3, 80);
    paramAttributeSet.recycle();
    this.kC = this.kp.getTextColors().getDefaultColor();
    this.kB = 153;
    j = this.kB << 24 | this.kC & 0xFFFFFF;
    this.ko.setTextColor(j);
    this.kq.setTextColor(j);
    this.ko.setEllipsize(TextUtils.TruncateAt.END);
    this.kp.setEllipsize(TextUtils.TruncateAt.END);
    this.kq.setEllipsize(TextUtils.TruncateAt.END);
    if (i != 0)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(i, kA);
      bool = paramAttributeSet.getBoolean(0, false);
      paramAttributeSet.recycle();
    }
    if (bool)
    {
      a(this.ko);
      a(this.kp);
      a(this.kq);
    }
    for (;;)
    {
      this.kt = ((int)(paramContext.getResources().getDisplayMetrics().density * 16.0F));
      return;
      this.ko.setSingleLine();
      this.kp.setSingleLine();
      this.kq.setSingleLine();
    }
  }
  
  private void a(o paramo1, o paramo2)
  {
    if (paramo1 != null)
    {
      paramo1.unregisterDataSetObserver(this.kx);
      this.ky = null;
    }
    if (paramo2 != null)
    {
      paramo2.registerDataSetObserver(this.kx);
      this.ky = new WeakReference(paramo2);
    }
    if (this.kn != null)
    {
      this.kr = -1;
      this.ks = -1.0F;
      a(this.kn.lc, paramo2);
      requestLayout();
    }
  }
  
  private static void a(TextView paramTextView)
  {
    paramTextView.setTransformationMethod(new q(paramTextView.getContext()));
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
    if (paramInt != this.kr)
    {
      a(paramInt, this.kn.lb);
      this.kw = true;
      m = this.ko.getMeasuredWidth();
      i4 = this.kp.getMeasuredWidth();
      k = this.kq.getMeasuredWidth();
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
      i7 = this.ko.getBaseline();
      i6 = this.kp.getBaseline();
      i5 = this.kq.getBaseline();
      i8 = Math.max(Math.max(i7, i6), i5);
      i7 = i8 - i7;
      i6 = i8 - i6;
      i5 = i8 - i5;
      i8 = this.ko.getMeasuredHeight();
      int i9 = this.kp.getMeasuredHeight();
      int i10 = this.kq.getMeasuredHeight();
      i8 = Math.max(Math.max(i8 + i7, i9 + i6), i10 + i5);
      switch (this.ku & 0x70)
      {
      default: 
        j = paramInt + i7;
        i = paramInt + i6;
        paramInt += i5;
      }
    }
    for (;;)
    {
      this.kp.layout(i3, i, i4, this.kp.getMeasuredHeight() + i);
      i = Math.min(i2, i3 - this.kt - m);
      this.ko.layout(i, j, m + i, this.ko.getMeasuredHeight() + j);
      i = Math.max(n - i1 - k, this.kt + i4);
      this.kq.layout(i, paramInt, i + k, this.kq.getMeasuredHeight() + paramInt);
      this.ks = paramFloat;
      this.kw = false;
      return;
      if ((paramBoolean) || (paramFloat != this.ks)) {
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
    this.kv = true;
    this.ko.setText(null);
    this.kp.setText(null);
    this.kq.setText(null);
    int i = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), -2147483648);
    int j = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), -2147483648);
    this.ko.measure(i, j);
    this.kp.measure(i, j);
    this.kq.measure(i, j);
    this.kr = paramInt;
    if (!this.kw) {
      a(paramInt, this.ks, false);
    }
    this.kv = false;
  }
  
  public final int br()
  {
    return this.kt;
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
    o localo = ((ViewPager)localObject).lb;
    ((ViewPager)localObject).a(this.kx);
    ((ViewPager)localObject).a(this.kx);
    this.kn = ((ViewPager)localObject);
    if (this.ky != null) {}
    for (localObject = (o)this.ky.get();; localObject = null)
    {
      a((o)localObject, localo);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.kn != null)
    {
      a(this.kn.lb, null);
      this.kn.a(null);
      this.kn.b(this.kx);
      this.kn = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    if (this.kn != null)
    {
      if (this.ks >= 0.0F) {
        f = this.ks;
      }
      a(this.kr, f, true);
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
    this.ko.measure(paramInt1, k);
    this.kp.measure(paramInt1, k);
    this.kq.measure(paramInt1, k);
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (paramInt1 = View.MeasureSpec.getSize(paramInt2);; paramInt1 = Math.max(getMinHeight(), j + paramInt1))
    {
      setMeasuredDimension(i, View.resolveSizeAndState(paramInt1, paramInt2, this.kp.getMeasuredState() << 16));
      return;
      paramInt1 = this.kp.getMeasuredHeight();
    }
  }
  
  public void requestLayout()
  {
    if (!this.kv) {
      super.requestLayout();
    }
  }
  
  public void x(int paramInt)
  {
    this.kt = paramInt;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.PagerTitleStrip
 * JD-Core Version:    0.7.0.1
 */