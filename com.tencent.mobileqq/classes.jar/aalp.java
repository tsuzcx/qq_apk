import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aalp
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 3000L;
  private aalk jdField_a_of_type_Aalk;
  private aall jdField_a_of_type_Aall;
  private aalm jdField_a_of_type_Aalm;
  private aaln jdField_a_of_type_Aaln;
  private aalp jdField_a_of_type_Aalp;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private View jdField_a_of_type_AndroidViewView;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private List<aalf> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private aalp jdField_b_of_type_Aalp;
  
  public static aalf a(View... paramVarArgs)
  {
    return new aalp().b(paramVarArgs);
  }
  
  public aalp a()
  {
    if (this.jdField_a_of_type_Aalp != null)
    {
      this.jdField_a_of_type_Aalp.a();
      return this;
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = a();
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnPreDrawListener(new aals(this));
      return this;
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    return this;
  }
  
  public aalp a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public aalp a(aalm paramaalm)
  {
    this.jdField_a_of_type_Aalm = paramaalm;
    return this;
  }
  
  public aalp a(aaln paramaaln)
  {
    this.jdField_a_of_type_Aaln = paramaaln;
    return this;
  }
  
  public aalp a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
    return this;
  }
  
  protected AnimatorSet a()
  {
    this.jdField_a_of_type_Boolean = false;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aalf)((Iterator)localObject1).next();
      List localList = ((aalf)localObject2).a();
      if (((aalf)localObject2).a() != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          ((Animator)localIterator.next()).setInterpolator(((aalf)localObject2).a());
        }
      }
      localArrayList.addAll(localList);
    }
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aalf)((Iterator)localObject1).next();
      if (((aalf)localObject2).a()) {
        this.jdField_a_of_type_AndroidViewView = ((aalf)localObject2).a();
      }
    }
    localObject1 = localArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Animator)((Iterator)localObject1).next();
      if ((localObject2 instanceof ValueAnimator))
      {
        localObject2 = (ValueAnimator)localObject2;
        ((ValueAnimator)localObject2).setRepeatCount(this.jdField_a_of_type_Int);
        ((ValueAnimator)localObject2).setRepeatMode(this.jdField_b_of_type_Int);
        if (!this.jdField_a_of_type_Boolean)
        {
          ((ValueAnimator)localObject2).addListener(new aalq(this));
          this.jdField_a_of_type_Boolean = true;
        }
      }
    }
    localObject1 = new AnimatorSet();
    ((AnimatorSet)localObject1).playTogether(localArrayList);
    ((AnimatorSet)localObject1).setDuration(this.jdField_a_of_type_Long);
    ((AnimatorSet)localObject1).setStartDelay(this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_AndroidViewAnimationInterpolator != null) {
      ((AnimatorSet)localObject1).setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
    }
    ((AnimatorSet)localObject1).addListener(new aalr(this));
    return localObject1;
  }
  
  public aalf b(View... paramVarArgs)
  {
    paramVarArgs = new aalf(this, paramVarArgs);
    this.jdField_a_of_type_JavaUtilList.add(paramVarArgs);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalp
 * JD-Core Version:    0.7.0.1
 */