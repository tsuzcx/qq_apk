package android.support.wearable.view;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.wearable.j;
import android.support.wearable.k;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowInsets;

@TargetApi(21)
public class ActionPage
  extends ViewGroup
{
  public static int Bq = 1;
  public static int Br = 0;
  private int BA;
  private boolean BB;
  private final ActionLabel Bs;
  private CircularButton Bt;
  private int Bu;
  private float Bv;
  private final Point Bw = new Point();
  private int Bx;
  private int By;
  private boolean Bz;
  
  public ActionPage(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionPage(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionPage(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, j.yA);
  }
  
  public ActionPage(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.Bt = new CircularButton(paramContext);
    this.Bs = new ActionLabel(paramContext);
    this.Bs.setGravity(17);
    this.Bs.setMaxLines(2);
    float f1 = 1.0F;
    float f2 = 0.0F;
    Object localObject = null;
    int j = 1;
    int i = 0;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, k.yN, paramInt1, paramInt2);
    paramInt1 = 0;
    paramAttributeSet = (AttributeSet)localObject;
    paramInt2 = j;
    if (paramInt1 < localTypedArray.getIndexCount())
    {
      int m = localTypedArray.getIndex(paramInt1);
      float f4;
      float f3;
      int k;
      if (m == k.yV)
      {
        this.Bt.setColor(localTypedArray.getColorStateList(m));
        f4 = f1;
        f3 = f2;
        localObject = paramAttributeSet;
        k = paramInt2;
        j = i;
      }
      for (;;)
      {
        paramInt1 += 1;
        i = j;
        paramInt2 = k;
        paramAttributeSet = (AttributeSet)localObject;
        f2 = f3;
        f1 = f4;
        break;
        if (m == k.yS)
        {
          this.Bt.setImageDrawable(localTypedArray.getDrawable(m));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.zc)
        {
          this.Bt.bj(localTypedArray.getInt(m, 0));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.zd)
        {
          this.Bt.bl(localTypedArray.getColor(m, -1));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.ze)
        {
          this.Bt.v(localTypedArray.getDimension(m, 0.0F));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.yT)
        {
          this.Bs.setText(localTypedArray.getText(m));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.za)
        {
          this.Bs.t(localTypedArray.getDimension(m, 10.0F));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.zb)
        {
          this.Bs.u(localTypedArray.getDimension(m, 60.0F));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.yQ)
        {
          this.Bs.setTextColor(localTypedArray.getColorStateList(m));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.yU)
        {
          this.Bs.setMaxLines(localTypedArray.getInt(m, 2));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.yY)
        {
          localObject = localTypedArray.getString(m);
          j = i;
          k = paramInt2;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.yO)
        {
          k = localTypedArray.getInt(m, paramInt2);
          j = i;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.yP)
        {
          j = localTypedArray.getInt(m, i);
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.yR)
        {
          this.Bs.setGravity(localTypedArray.getInt(m, 17));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.yW)
        {
          f3 = localTypedArray.getDimension(m, f2);
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f4 = f1;
        }
        else if (m == k.yX)
        {
          f4 = localTypedArray.getDimension(m, f1);
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
        }
        else
        {
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
          if (m == k.yZ)
          {
            this.Bt.setStateListAnimator(AnimatorInflater.loadStateListAnimator(paramContext, localTypedArray.getResourceId(m, 0)));
            j = i;
            k = paramInt2;
            localObject = paramAttributeSet;
            f3 = f2;
            f4 = f1;
          }
        }
      }
    }
    localTypedArray.recycle();
    this.Bs.setLineSpacing(f2, f1);
    this.Bs.a(paramAttributeSet, paramInt2, i);
    addView(this.Bs);
    addView(this.Bt);
  }
  
  public final void bj(int paramInt)
  {
    this.Bt.bj(paramInt);
  }
  
  public final ActionLabel eW()
  {
    return this.Bs;
  }
  
  public final void eX()
  {
    this.Bt.setColor(0);
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    this.BB = true;
    if (this.Bz != paramWindowInsets.isRound())
    {
      this.Bz = paramWindowInsets.isRound();
      requestLayout();
    }
    int i = paramWindowInsets.getSystemWindowInsetBottom();
    if (this.BA != i)
    {
      this.BA = i;
      requestLayout();
    }
    if (this.Bz) {
      this.BA = ((int)Math.max(this.BA, 0.09375F * getMeasuredHeight()));
    }
    return paramWindowInsets;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!this.BB) {
      requestApplyInsets();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.Bt.layout((int)(this.Bw.x - this.Bv), (int)(this.Bw.y - this.Bv), (int)(this.Bw.x + this.Bv), (int)(this.Bw.y + this.Bv));
    paramInt1 = (int)((paramInt3 - paramInt1 - this.Bx) / 2.0F);
    this.Bs.layout(paramInt1, this.Bt.getBottom(), this.Bx + paramInt1, this.Bt.getBottom() + this.By);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredHeight();
    paramInt2 = getMeasuredWidth();
    if ((this.Bt.fi() == 1) && (this.Bt.fh() != null))
    {
      this.Bt.measure(0, 0);
      this.Bu = Math.min(this.Bt.getMeasuredWidth(), this.Bt.getMeasuredHeight());
      this.Bv = (this.Bu / 2.0F);
      if (!this.Bz) {
        break label231;
      }
      this.Bw.set(paramInt2 / 2, paramInt1 / 2);
      this.Bx = ((int)(paramInt2 * 0.625F));
      this.BA = ((int)(paramInt1 * 0.09375F));
    }
    for (;;)
    {
      this.By = ((int)(paramInt1 - (this.Bw.y + this.Bv) - this.BA));
      this.Bs.measure(View.MeasureSpec.makeMeasureSpec(this.Bx, 1073741824), View.MeasureSpec.makeMeasureSpec(this.By, 1073741824));
      return;
      this.Bu = ((int)(Math.min(paramInt2, paramInt1) * 0.45F));
      this.Bv = (this.Bu / 2.0F);
      this.Bt.measure(View.MeasureSpec.makeMeasureSpec(this.Bu, 1073741824), View.MeasureSpec.makeMeasureSpec(this.Bu, 1073741824));
      break;
      label231:
      this.Bw.set(paramInt2 / 2, (int)(paramInt1 * 0.43F));
      this.Bx = ((int)(paramInt2 * 0.892F));
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (this.Bt != null) {
      this.Bt.setEnabled(paramBoolean);
    }
  }
  
  public final void setImageDrawable(Drawable paramDrawable)
  {
    this.Bt.setImageDrawable(paramDrawable);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.Bt != null) {
      this.Bt.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setStateListAnimator(StateListAnimator paramStateListAnimator)
  {
    if (this.Bt != null) {
      this.Bt.setStateListAnimator(paramStateListAnimator);
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.Bs.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.ActionPage
 * JD-Core Version:    0.7.0.1
 */