package android.support.wearable.view;

import android.animation.ArgbEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.support.wearable.b;
import android.support.wearable.k;
import android.util.AttributeSet;
import android.util.Property;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ProgressBar;

@TargetApi(20)
public class ProgressSpinner
  extends ProgressBar
{
  private static final Property<ProgressSpinner, Float> Dx = new Property(Float.class, "showingness") {};
  private int DA;
  private ArgbEvaluator Dy = new ArgbEvaluator();
  private float Dz;
  private Interpolator mInterpolator;
  private int[] nI = null;
  
  public ProgressSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public ProgressSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    if (!isInEditMode()) {
      this.mInterpolator = AnimationUtils.loadInterpolator(paramContext, 17563661);
    }
    setIndeterminateDrawable(new t(this));
    if (getVisibility() == 0) {
      this.Dz = 1.0F;
    }
    int[] arrayOfInt = this.nI;
    if (paramAttributeSet != null) {
      arrayOfInt = b(paramContext, paramAttributeSet, paramInt);
    }
    paramAttributeSet = arrayOfInt;
    if (arrayOfInt == null)
    {
      if (!isInEditMode()) {
        break label106;
      }
      paramAttributeSet = new int[1];
      paramAttributeSet[0] = paramContext.getResources().getColor(17170456);
    }
    for (;;)
    {
      if ((paramAttributeSet != null) && (paramAttributeSet.length > 0)) {
        this.nI = paramAttributeSet;
      }
      return;
      label106:
      paramContext = getResources().obtainTypedArray(b.wc);
      paramAttributeSet = new int[paramContext.length()];
      paramInt = 0;
      while (paramInt < paramContext.length())
      {
        paramAttributeSet[paramInt] = paramContext.getColor(paramInt, 0);
        paramInt += 1;
      }
      paramContext.recycle();
    }
  }
  
  private int[] b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, k.yd, paramInt, 0);
    paramContext = localObject2;
    if (localTypedArray.hasValue(k.ye)) {}
    try
    {
      paramInt = localTypedArray.getResourceId(k.ye, 0);
      paramAttributeSet = getResources().getIntArray(paramInt);
      if (paramAttributeSet != null)
      {
        paramContext = paramAttributeSet;
        if (paramAttributeSet.length > 0) {}
      }
      else
      {
        paramInt = localTypedArray.getColor(k.ye, getResources().getColor(17170445));
        paramContext = new int[1];
        paramContext[0] = Integer.valueOf(paramInt).intValue();
      }
      localTypedArray.recycle();
      return paramContext;
    }
    catch (Resources.NotFoundException paramContext)
    {
      for (;;)
      {
        paramAttributeSet = localObject1;
      }
    }
  }
  
  private static float c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 != paramFloat2) {
      return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
    }
    return 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.ProgressSpinner
 * JD-Core Version:    0.7.0.1
 */