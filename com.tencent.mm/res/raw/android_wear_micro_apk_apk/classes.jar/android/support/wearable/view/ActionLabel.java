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
  private TextPaint Bb;
  private float Bc;
  private float Bd;
  private Layout Be;
  private ColorStateList Bf;
  private int Bg;
  private CharSequence Bh;
  private float Bi = 1.0F;
  private float Bj = 0.0F;
  private float Bk;
  private float Bl;
  private float Bm;
  private float Bn;
  private int Bo = 2147483647;
  private int Bp;
  private int ho = 8388659;
  
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
    this.Bm = (f2 / f1);
    this.Bk = (10.0F * f2);
    this.Bl = (f2 * 60.0F);
    this.Bb = new TextPaint(1);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, k.yB, paramInt, 0);
    this.Bh = paramContext.getText(k.yG);
    this.Bk = paramContext.getDimension(k.yL, this.Bk);
    this.Bl = paramContext.getDimension(k.yM, this.Bl);
    this.Bf = paramContext.getColorStateList(k.yE);
    this.Bo = paramContext.getInt(k.yH, 2);
    if (this.Bf != null) {
      eV();
    }
    this.Bb.setTextSize(this.Bl);
    a(paramContext.getString(k.yK), paramContext.getInt(k.yC, -1), paramContext.getInt(k.yD, -1));
    this.ho = paramContext.getInt(k.yF, this.ho);
    this.Bd = paramContext.getDimensionPixelSize(k.yI, (int)this.Bd);
    this.Bc = paramContext.getFloat(k.yJ, this.Bc);
    paramContext.recycle();
    if (this.Bh == null) {
      this.Bh = "";
    }
  }
  
  private void eV()
  {
    int i = this.Bf.getColorForState(getDrawableState(), 0);
    if (i != this.Bg)
    {
      this.Bg = i;
      invalidate();
    }
  }
  
  private void setTypeface(Typeface paramTypeface)
  {
    if (this.Bb.getTypeface() != paramTypeface)
    {
      this.Bb.setTypeface(paramTypeface);
      if (this.Be != null)
      {
        requestLayout();
        invalidate();
      }
    }
  }
  
  private void setTypeface(Typeface paramTypeface, int paramInt)
  {
    boolean bool = false;
    if (paramInt > 0)
    {
      int i;
      if (paramTypeface == null)
      {
        paramTypeface = Typeface.defaultFromStyle(paramInt);
        setTypeface(paramTypeface);
        if (paramTypeface == null) {
          break label87;
        }
        i = paramTypeface.getStyle();
        label31:
        paramInt = (i ^ 0xFFFFFFFF) & paramInt;
        paramTypeface = this.Bb;
        if ((paramInt & 0x1) != 0) {
          bool = true;
        }
        paramTypeface.setFakeBoldText(bool);
        paramTypeface = this.Bb;
        if ((paramInt & 0x2) == 0) {
          break label93;
        }
      }
      label87:
      label93:
      for (float f = -0.25F;; f = 0.0F)
      {
        paramTypeface.setTextSkewX(f);
        return;
        paramTypeface = Typeface.create(paramTypeface, paramInt);
        break;
        i = 0;
        break label31;
      }
    }
    this.Bb.setFakeBoldText(false);
    this.Bb.setTextSkewX(0.0F);
    setTypeface(paramTypeface);
  }
  
  final void a(String paramString, int paramInt1, int paramInt2)
  {
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
    }
    for (;;)
    {
      setTypeface(paramString, paramInt2);
      return;
      paramString = Typeface.SANS_SERIF;
      continue;
      paramString = Typeface.SERIF;
      continue;
      paramString = Typeface.MONOSPACE;
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.Bf != null) && (this.Bf.isStateful())) {
      eV();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f;
    int j;
    int i;
    int k;
    if (this.Be != null)
    {
      paramCanvas.save();
      this.Bb.setColor(this.Bg);
      this.Bb.drawableState = getDrawableState();
      f = getPaddingLeft();
      j = getPaddingTop();
      i = getHeight() - (getPaddingTop() + getPaddingBottom());
      k = this.Be.getLineTop(this.Bp);
      switch (this.ho & 0x70)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      paramCanvas.translate(f, i + j);
      paramCanvas.clipRect(0, 0, getWidth() - getPaddingRight(), this.Be.getLineTop(this.Bp));
      this.Be.draw(paramCanvas);
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
      this.Bb.setTextSize(this.Bl);
      i = (int)Math.ceil(Layout.getDesiredWidth(this.Bh, this.Bb));
      this.Bb.setTextSize(this.Bn);
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
        if (this.Be != null)
        {
          if (this.Be.getWidth() == m) {
            break label378;
          }
          paramInt2 = 1;
          if (this.Be.getHeight() == paramInt1) {
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
          this.Be = localObject;
          if (this.Be != null) {
            break label713;
          }
          setMeasuredDimension(0, 0);
          return;
          switch (this.ho & 0x800007)
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
            this.Bn = this.Bl;
            this.Bb.setTextSize(this.Bl);
            StaticLayout localStaticLayout = new StaticLayout(this.Bh, this.Bb, i3, localAlignment, this.Bi, this.Bj, true);
            if (localStaticLayout.getLineCount() > this.Bo)
            {
              paramInt2 = 1;
              if (localStaticLayout.getLineTop(localStaticLayout.getLineCount()) <= i2) {
                break label667;
              }
              j = 1;
              label496:
              if (this.Bb.getTextSize() <= this.Bk) {
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
              this.Bn -= 1.0F;
              this.Bb.setTextSize(this.Bn);
              localStaticLayout = new StaticLayout(this.Bh, this.Bb, i3, localAlignment, this.Bi, this.Bj, true);
              if (localStaticLayout.getLineTop(localStaticLayout.getLineCount()) <= i2) {
                break label678;
              }
              paramInt2 = 1;
              label615:
              if (localStaticLayout.getLineCount() <= this.Bo) {
                break label683;
              }
              i = 1;
              label629:
              if (this.Bb.getTextSize() <= this.Bk) {
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
            this.Bp = Math.min(this.Bo, localObject.getLineCount());
          }
        }
        label713:
        if (i1 != 1073741824) {
          paramInt1 = this.Be.getLineTop(this.Be.getLineCount());
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
    this.Be = null;
    requestLayout();
    invalidate();
  }
  
  public final void setGravity(int paramInt)
  {
    if (this.ho != paramInt)
    {
      this.ho = paramInt;
      invalidate();
    }
  }
  
  public final void setLineSpacing(float paramFloat1, float paramFloat2)
  {
    if ((this.Bj != paramFloat1) || (this.Bi != paramFloat2))
    {
      this.Bj = paramFloat1;
      this.Bi = paramFloat2;
      if (this.Be != null)
      {
        this.Be = null;
        requestLayout();
        invalidate();
      }
    }
  }
  
  public final void setMaxLines(int paramInt)
  {
    if (this.Bo != paramInt)
    {
      this.Bo = paramInt;
      this.Be = null;
      requestLayout();
      invalidate();
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      throw new RuntimeException("Can not set ActionLabel text to null");
    }
    if (!Objects.equals(this.Bh, paramCharSequence))
    {
      this.Be = null;
      this.Bh = paramCharSequence;
      requestLayout();
      invalidate();
    }
  }
  
  public final void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList == null) {
      throw new NullPointerException();
    }
    this.Bf = paramColorStateList;
    eV();
  }
  
  public final void t(float paramFloat)
  {
    paramFloat = TypedValue.applyDimension(0, paramFloat, getContext().getResources().getDisplayMetrics());
    if (paramFloat != this.Bk)
    {
      this.Be = null;
      this.Bk = paramFloat;
      requestLayout();
      invalidate();
    }
  }
  
  public final void u(float paramFloat)
  {
    paramFloat = TypedValue.applyDimension(0, paramFloat, getContext().getResources().getDisplayMetrics());
    if (paramFloat != this.Bl)
    {
      this.Be = null;
      this.Bl = paramFloat;
      requestLayout();
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.ActionLabel
 * JD-Core Version:    0.7.0.1
 */