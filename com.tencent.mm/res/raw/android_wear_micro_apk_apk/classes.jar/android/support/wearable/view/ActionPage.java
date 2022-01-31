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
  public static int zB = 1;
  public static int zC = 0;
  private final ActionLabel zD;
  private CircularButton zE;
  private int zF;
  private float zG;
  private final Point zH = new Point();
  private int zI;
  private int zJ;
  private boolean zK;
  private int zL;
  private boolean zM;
  
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
    this(paramContext, paramAttributeSet, paramInt, j.wL);
  }
  
  public ActionPage(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.zE = new CircularButton(paramContext);
    this.zD = new ActionLabel(paramContext);
    this.zD.setGravity(17);
    this.zD.setMaxLines(2);
    float f1 = 1.0F;
    float f2 = 0.0F;
    Object localObject = null;
    int j = 1;
    int i = 0;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, k.wY, paramInt1, paramInt2);
    paramInt1 = 0;
    paramAttributeSet = (AttributeSet)localObject;
    paramInt2 = j;
    if (paramInt1 < localTypedArray.getIndexCount())
    {
      int m = localTypedArray.getIndex(paramInt1);
      float f4;
      float f3;
      int k;
      if (m == k.xg)
      {
        this.zE.setColor(localTypedArray.getColorStateList(m));
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
        if (m == k.xd)
        {
          this.zE.setImageDrawable(localTypedArray.getDrawable(m));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.xn)
        {
          this.zE.aP(localTypedArray.getInt(m, 0));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.xo)
        {
          this.zE.aR(localTypedArray.getColor(m, -1));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.xp)
        {
          this.zE.u(localTypedArray.getDimension(m, 0.0F));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.xe)
        {
          this.zD.setText(localTypedArray.getText(m));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.xl)
        {
          this.zD.s(localTypedArray.getDimension(m, 10.0F));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.xm)
        {
          this.zD.t(localTypedArray.getDimension(m, 60.0F));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.xb)
        {
          this.zD.setTextColor(localTypedArray.getColorStateList(m));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.xf)
        {
          this.zD.setMaxLines(localTypedArray.getInt(m, 2));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.xj)
        {
          localObject = localTypedArray.getString(m);
          j = i;
          k = paramInt2;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.wZ)
        {
          k = localTypedArray.getInt(m, paramInt2);
          j = i;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.xa)
        {
          j = localTypedArray.getInt(m, i);
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.xc)
        {
          this.zD.setGravity(localTypedArray.getInt(m, 17));
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f3 = f2;
          f4 = f1;
        }
        else if (m == k.xh)
        {
          f3 = localTypedArray.getDimension(m, f2);
          j = i;
          k = paramInt2;
          localObject = paramAttributeSet;
          f4 = f1;
        }
        else if (m == k.xi)
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
          if (m == k.xk)
          {
            this.zE.setStateListAnimator(AnimatorInflater.loadStateListAnimator(paramContext, localTypedArray.getResourceId(m, 0)));
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
    this.zD.setLineSpacing(f2, f1);
    this.zD.a(paramAttributeSet, paramInt2, i);
    addView(this.zD);
    addView(this.zE);
  }
  
  public final void aP(int paramInt)
  {
    this.zE.aP(paramInt);
  }
  
  public final ActionLabel eG()
  {
    return this.zD;
  }
  
  public final void eH()
  {
    this.zE.setColor(0);
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    this.zM = true;
    if (this.zK != paramWindowInsets.isRound())
    {
      this.zK = paramWindowInsets.isRound();
      requestLayout();
    }
    int i = paramWindowInsets.getSystemWindowInsetBottom();
    if (this.zL != i)
    {
      this.zL = i;
      requestLayout();
    }
    if (this.zK) {
      this.zL = ((int)Math.max(this.zL, 0.09375F * getMeasuredHeight()));
    }
    return paramWindowInsets;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!this.zM) {
      requestApplyInsets();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.zE.layout((int)(this.zH.x - this.zG), (int)(this.zH.y - this.zG), (int)(this.zH.x + this.zG), (int)(this.zH.y + this.zG));
    paramInt1 = (int)((paramInt3 - paramInt1 - this.zI) / 2.0F);
    this.zD.layout(paramInt1, this.zE.getBottom(), this.zI + paramInt1, this.zE.getBottom() + this.zJ);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredHeight();
    paramInt2 = getMeasuredWidth();
    if ((this.zE.eS() == 1) && (this.zE.eR() != null))
    {
      this.zE.measure(0, 0);
      this.zF = Math.min(this.zE.getMeasuredWidth(), this.zE.getMeasuredHeight());
      this.zG = (this.zF / 2.0F);
      if (!this.zK) {
        break label231;
      }
      this.zH.set(paramInt2 / 2, paramInt1 / 2);
      this.zI = ((int)(paramInt2 * 0.625F));
      this.zL = ((int)(paramInt1 * 0.09375F));
    }
    for (;;)
    {
      this.zJ = ((int)(paramInt1 - (this.zH.y + this.zG) - this.zL));
      this.zD.measure(View.MeasureSpec.makeMeasureSpec(this.zI, 1073741824), View.MeasureSpec.makeMeasureSpec(this.zJ, 1073741824));
      return;
      this.zF = ((int)(Math.min(paramInt2, paramInt1) * 0.45F));
      this.zG = (this.zF / 2.0F);
      this.zE.measure(View.MeasureSpec.makeMeasureSpec(this.zF, 1073741824), View.MeasureSpec.makeMeasureSpec(this.zF, 1073741824));
      break;
      label231:
      this.zH.set(paramInt2 / 2, (int)(paramInt1 * 0.43F));
      this.zI = ((int)(paramInt2 * 0.892F));
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (this.zE != null) {
      this.zE.setEnabled(paramBoolean);
    }
  }
  
  public final void setImageDrawable(Drawable paramDrawable)
  {
    this.zE.setImageDrawable(paramDrawable);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.zE != null) {
      this.zE.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setStateListAnimator(StateListAnimator paramStateListAnimator)
  {
    if (this.zE != null) {
      this.zE.setStateListAnimator(paramStateListAnimator);
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.zD.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.ActionPage
 * JD-Core Version:    0.7.0.1
 */