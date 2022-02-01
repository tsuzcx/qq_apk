import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public class aazg
{
  private final aazq jdField_a_of_type_Aazq;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private final List<Animator> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private boolean b;
  
  public aazg(aazq paramaazq, View... paramVarArgs)
  {
    this.jdField_a_of_type_Aazq = paramaazq;
    this.jdField_a_of_type_ArrayOfAndroidViewView = paramVarArgs;
  }
  
  protected float a(float paramFloat)
  {
    return this.jdField_a_of_type_ArrayOfAndroidViewView[0].getContext().getResources().getDisplayMetrics().density * paramFloat;
  }
  
  public aazg a(long paramLong)
  {
    this.jdField_a_of_type_Aazq.a(paramLong);
    return this;
  }
  
  public aazg a(aazn paramaazn)
  {
    this.jdField_a_of_type_Aazq.a(paramaazn);
    return this;
  }
  
  public aazg a(aazp paramaazp, float... paramVarArgs)
  {
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(a(paramVarArgs));
      if (paramaazp != null) {
        localValueAnimator.addUpdateListener(new aazh(this, paramaazp, localView));
      }
      a(localValueAnimator);
      i += 1;
    }
    return this;
  }
  
  protected aazg a(Animator paramAnimator)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramAnimator);
    return this;
  }
  
  public aazg a(String paramString, float... paramVarArgs)
  {
    View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
    int j = arrayOfView.length;
    int i = 0;
    while (i < j)
    {
      View localView = arrayOfView[i];
      this.jdField_a_of_type_JavaUtilList.add(ObjectAnimator.ofFloat(localView, paramString, a(paramVarArgs)));
      i += 1;
    }
    return this;
  }
  
  public aazg a(float... paramVarArgs)
  {
    return a("translationY", paramVarArgs);
  }
  
  public aazg a(View... paramVarArgs)
  {
    return this.jdField_a_of_type_Aazq.b(paramVarArgs);
  }
  
  public aazq a()
  {
    return this.jdField_a_of_type_Aazq.a(new AccelerateInterpolator());
  }
  
  public aazq a(float paramFloat)
  {
    return this.jdField_a_of_type_Aazq.a(new DecelerateInterpolator(paramFloat));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ArrayOfAndroidViewView[0];
  }
  
  public Interpolator a()
  {
    return this.jdField_a_of_type_AndroidViewAnimationInterpolator;
  }
  
  protected List<Animator> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected float[] a(float... paramVarArgs)
  {
    if (!this.b) {
      return paramVarArgs;
    }
    float[] arrayOfFloat = new float[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfFloat[i] = a(paramVarArgs[i]);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public aazg b(float... paramVarArgs)
  {
    return a("alpha", paramVarArgs);
  }
  
  public aazq b()
  {
    this.jdField_a_of_type_Aazq.a();
    return this.jdField_a_of_type_Aazq;
  }
  
  public aazg c(float... paramVarArgs)
  {
    return a(new aazi(this), paramVarArgs);
  }
  
  public aazg d(float... paramVarArgs)
  {
    return a(new aazj(this), paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aazg
 * JD-Core Version:    0.7.0.1
 */