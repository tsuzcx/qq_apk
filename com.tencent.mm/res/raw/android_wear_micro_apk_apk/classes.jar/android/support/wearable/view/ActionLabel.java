package android.support.wearable.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.support.wearable.k;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.Objects;

@TargetApi(21)
public class ActionLabel
  extends View
{
  private int ku = 8388659;
  private int zA;
  private TextPaint zm;
  private float zn;
  private float zo;
  private Layout zp;
  private ColorStateList zq;
  private int zr;
  private CharSequence zs;
  private float zt = 1.0F;
  private float zu = 0.0F;
  private float zv;
  private float zw;
  private float zx;
  private float zy;
  private int zz = 2147483647;
  
  public ActionLabel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionLabel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionLabel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ActionLabel(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    float f1 = localDisplayMetrics.density;
    float f2 = localDisplayMetrics.scaledDensity;
    this.zx = (f2 / f1);
    this.zv = (10.0F * f2);
    this.zw = (f2 * 60.0F);
    this.zm = new TextPaint(1);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, k.wM, paramInt, 0);
    this.zs = paramContext.getText(k.wR);
    this.zv = paramContext.getDimension(k.wW, this.zv);
    this.zw = paramContext.getDimension(k.wX, this.zw);
    this.zq = paramContext.getColorStateList(k.wP);
    this.zz = paramContext.getInt(k.wS, 2);
    if (this.zq != null) {
      eF();
    }
    this.zm.setTextSize(this.zw);
    a(paramContext.getString(k.wV), paramContext.getInt(k.wN, -1), paramContext.getInt(k.wO, -1));
    this.ku = paramContext.getInt(k.wQ, this.ku);
    this.zo = paramContext.getDimensionPixelSize(k.wT, (int)this.zo);
    this.zn = paramContext.getFloat(k.wU, this.zn);
    paramContext.recycle();
    if (this.zs == null) {
      this.zs = "";
    }
  }
  
  private void eF()
  {
    int i = this.zq.getColorForState(getDrawableState(), 0);
    if (i != this.zr)
    {
      this.zr = i;
      invalidate();
    }
  }
  
  private void setTypeface(Typeface paramTypeface)
  {
    if (this.zm.getTypeface() != paramTypeface)
    {
      this.zm.setTypeface(paramTypeface);
      if (this.zp != null)
      {
        requestLayout();
        invalidate();
      }
    }
  }
  
  final void a(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    String str = null;
    if (paramString != null)
    {
      paramString = Typeface.create(paramString, paramInt2);
      str = paramString;
      if (paramString != null)
      {
        setTypeface(paramString);
        return;
      }
    }
    switch (paramInt1)
    {
    default: 
      paramString = str;
      if (paramInt2 <= 0) {
        break label175;
      }
      if (paramString == null)
      {
        paramString = Typeface.defaultFromStyle(paramInt2);
        label72:
        setTypeface(paramString);
        if (paramString == null) {
          break label164;
        }
        paramInt1 = paramString.getStyle();
        label86:
        paramInt1 = (paramInt1 ^ 0xFFFFFFFF) & paramInt2;
        paramString = this.zm;
        if ((paramInt1 & 0x1) != 0) {
          bool = true;
        }
        paramString.setFakeBoldText(bool);
        paramString = this.zm;
        if ((paramInt1 & 0x2) == 0) {
          break label169;
        }
      }
      break;
    }
    label164:
    label169:
    for (float f = -0.25F;; f = 0.0F)
    {
      paramString.setTextSkewX(f);
      return;
      paramString = Typeface.SANS_SERIF;
      break;
      paramString = Typeface.SERIF;
      break;
      paramString = Typeface.MONOSPACE;
      break;
      paramString = Typeface.create(paramString, paramInt2);
      break label72;
      paramInt1 = 0;
      break label86;
    }
    label175:
    this.zm.setFakeBoldText(false);
    this.zm.setTextSkewX(0.0F);
    setTypeface(paramString);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.zq != null) && (this.zq.isStateful())) {
      eF();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f;
    int j;
    int i;
    int k;
    if (this.zp != null)
    {
      paramCanvas.save();
      this.zm.setColor(this.zr);
      this.zm.drawableState = getDrawableState();
      f = getPaddingLeft();
      j = getPaddingTop();
      i = getHeight() - (getPaddingTop() + getPaddingBottom());
      k = this.zp.getLineTop(this.zA);
      switch (this.ku & 0x70)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      paramCanvas.translate(f, i + j);
      paramCanvas.clipRect(0, 0, getWidth() - getPaddingRight(), this.zp.getLineTop(this.zA));
      this.zp.draw(paramCanvas);
      paramCanvas.restore();
      return;
      i = 0;
      continue;
      i = (i - k) / 2;
      continue;
      i -= k;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = -1;
    paramInt1 = -1;
    if (m == 1073741824) {
      paramInt2 = j;
    }
    if (i1 == 1073741824) {
      paramInt1 = k;
    }
    int i = paramInt2;
    if (paramInt2 == -1)
    {
      this.zm.setTextSize(this.zw);
      i = (int)Math.ceil(Layout.getDesiredWidth(this.zs, this.zm));
      this.zm.setTextSize(this.zy);
    }
    if (m == -2147483648) {}
    for (m = Math.min(i, j);; m = i)
    {
      Layout.Alignment localAlignment;
      switch (getTextAlignment())
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        if (paramInt1 == -1) {
          if (i1 == -2147483648) {
            paramInt1 = k;
          }
        }
        break;
      }
      for (;;)
      {
        label169:
        label190:
        label203:
        Object localObject;
        if (this.zp != null)
        {
          if (this.zp.getWidth() == m) {
            break label378;
          }
          paramInt2 = 1;
          if (this.zp.getHeight() == paramInt1) {
            break label383;
          }
          i = 1;
          if ((paramInt2 == 0) && (i == 0)) {}
        }
        else
        {
          if ((paramInt1 > 0) && (m > 0)) {
            break label388;
          }
          localObject = null;
        }
        for (;;)
        {
          this.zp = localObject;
          if (this.zp != null) {
            break label713;
          }
          setMeasuredDimension(0, 0);
          return;
          switch (this.ku & 0x800007)
          {
          default: 
            localAlignment = Layout.Alignment.ALIGN_NORMAL;
            break;
          case 8388611: 
            localAlignment = Layout.Alignment.ALIGN_NORMAL;
            break;
          case 8388613: 
            localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
            break;
          case 3: 
            localAlignment = Layout.Alignment.ALIGN_NORMAL;
            break;
          case 5: 
            localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
            break;
          case 1: 
            localAlignment = Layout.Alignment.ALIGN_CENTER;
            break;
            localAlignment = Layout.Alignment.ALIGN_NORMAL;
            break;
            localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
            break;
            localAlignment = Layout.Alignment.ALIGN_CENTER;
            break;
            paramInt1 = 2147483647;
            break label169;
            label378:
            paramInt2 = 0;
            break label190;
            label383:
            i = 0;
            break label203;
            label388:
            int i2 = paramInt1 - (getPaddingTop() + getPaddingBottom());
            int i3 = m - (getPaddingLeft() + getPaddingRight());
            this.zy = this.zw;
            this.zm.setTextSize(this.zw);
            StaticLayout localStaticLayout = new StaticLayout(this.zs, this.zm, i3, localAlignment, this.zt, this.zu, true);
            if (localStaticLayout.getLineCount() > this.zz)
            {
              paramInt2 = 1;
              if (localStaticLayout.getLineTop(localStaticLayout.getLineCount()) <= i2) {
                break label667;
              }
              j = 1;
              label496:
              if (this.zm.getTextSize() <= this.zv) {
                break label673;
              }
              i = 1;
              label513:
              if (paramInt2 == 0)
              {
                localObject = localStaticLayout;
                if (j == 0) {
                  break label694;
                }
              }
              label526:
              if (paramInt2 == 0)
              {
                localObject = localStaticLayout;
                if (j == 0) {
                  break label694;
                }
              }
              localObject = localStaticLayout;
              if (i == 0) {
                break label694;
              }
              this.zy -= 1.0F;
              this.zm.setTextSize(this.zy);
              localStaticLayout = new StaticLayout(this.zs, this.zm, i3, localAlignment, this.zt, this.zu, true);
              if (localStaticLayout.getLineTop(localStaticLayout.getLineCount()) <= i2) {
                break label678;
              }
              paramInt2 = 1;
              label615:
              if (localStaticLayout.getLineCount() <= this.zz) {
                break label683;
              }
              i = 1;
              label629:
              if (this.zm.getTextSize() <= this.zv) {
                break label688;
              }
            }
            label667:
            label673:
            label678:
            label683:
            label688:
            for (j = 1;; j = 0)
            {
              int n = i;
              i = j;
              j = paramInt2;
              paramInt2 = n;
              break label526;
              paramInt2 = 0;
              break;
              j = 0;
              break label496;
              i = 0;
              break label513;
              paramInt2 = 0;
              break label615;
              i = 0;
              break label629;
            }
            label694:
            this.zA = Math.min(this.zz, localObject.getLineCount());
          }
        }
        label713:
        if (i1 != 1073741824) {
          paramInt1 = this.zp.getLineTop(this.zp.getLineCount());
        }
        for (;;)
        {
          paramInt2 = paramInt1;
          if (i1 == -2147483648) {
            paramInt2 = Math.min(paramInt1, k);
          }
          setMeasuredDimension(m, paramInt2);
          return;
        }
      }
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    super.onRtlPropertiesChanged(paramInt);
    this.zp = null;
    requestLayout();
    invalidate();
  }
  
  public final void s(float paramFloat)
  {
    paramFloat = TypedValue.applyDimension(0, paramFloat, getContext().getResources().getDisplayMetrics());
    if (paramFloat != this.zv)
    {
      this.zp = null;
      this.zv = paramFloat;
      requestLayout();
      invalidate();
    }
  }
  
  public final void setGravity(int paramInt)
  {
    if (this.ku != paramInt)
    {
      this.ku = paramInt;
      invalidate();
    }
  }
  
  public final void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    if ((this.zu != paramFloat1) || (this.zt != paramFloat2))
    {
      this.zu = paramFloat1;
      this.zt = paramFloat2;
      if (this.zp != null)
      {
        this.zp = null;
        requestLayout();
        invalidate();
      }
    }
  }
  
  public final void setMaxLines(int paramInt)
  {
    if (this.zz != paramInt)
    {
      this.zz = paramInt;
      this.zp = null;
      requestLayout();
      invalidate();
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      throw new RuntimeException("Can not set ActionLabel text to null");
    }
    if (!Objects.equals(this.zs, paramCharSequence))
    {
      this.zp = null;
      this.zs = paramCharSequence;
      requestLayout();
      invalidate();
    }
  }
  
  public final void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList == null) {
      throw new NullPointerException();
    }
    this.zq = paramColorStateList;
    eF();
  }
  
  public final void t(float paramFloat)
  {
    paramFloat = TypedValue.applyDimension(0, paramFloat, getContext().getResources().getDisplayMetrics());
    if (paramFloat != this.zw)
    {
      this.zp = null;
      this.zw = paramFloat;
      requestLayout();
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.ActionLabel
 * JD-Core Version:    0.7.0.1
 */