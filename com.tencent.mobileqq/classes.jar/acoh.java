import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.widget.ListView;

public class acoh
  extends acnv
{
  static final int jdField_b_of_type_Int = (int)(60.0F * BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density + 0.5F);
  float jdField_a_of_type_Float = 0.04166667F;
  long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private View jdField_b_of_type_AndroidViewView;
  
  public acoh(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  private boolean a(long paramLong)
  {
    int m = this.jdField_a_of_type_AndroidViewView.getLeft();
    int n = this.jdField_a_of_type_AndroidViewView.getWidth() / 2;
    int i = this.jdField_a_of_type_AndroidViewView.getTop();
    int j = this.jdField_a_of_type_AndroidViewView.getHeight() / 2;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth() / 2;
    int k = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getHeight() / 2;
    m = i1 - (m + n);
    i = k - (i + j);
    if ((m != 0) || (i != 0))
    {
      this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(m);
      this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(i);
      this.jdField_b_of_type_AndroidViewView.offsetLeftAndRight(m);
      this.jdField_b_of_type_AndroidViewView.offsetTopAndBottom(i);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
    }
    return true;
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.offsetChildrenTopAndBottom(paramInt);
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(this.jdField_a_of_type_Long);
  }
  
  @TargetApi(11)
  protected boolean a(Object... paramVarArgs)
  {
    boolean bool2 = false;
    int i = ((Integer)paramVarArgs[0]).intValue();
    this.jdField_a_of_type_Long = ((Long)paramVarArgs[1]).longValue();
    boolean bool1 = bool2;
    int i1;
    int j;
    int k;
    if (i > 0)
    {
      i1 = Integer.toString(i).length();
      if (i <= 99) {
        break label781;
      }
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = new Drawable[4];
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3] = this.jdField_a_of_type_ComTencentWidgetListView.getResources().getDrawable(2130837678);
      i = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3].getIntrinsicWidth();
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2] = this.jdField_a_of_type_ComTencentWidgetListView.getResources().getDrawable(2130838281);
      j = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2].getIntrinsicWidth();
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1] = this.jdField_a_of_type_ComTencentWidgetListView.getResources().getDrawable(2130838281);
      k = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1].getIntrinsicWidth() + (i + 0 + j);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0] = this.jdField_a_of_type_ComTencentWidgetListView.getResources().getDrawable(2130838282);
      i = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0].getIntrinsicWidth() + k;
      this.jdField_a_of_type_AndroidViewView = new acom(this, this.jdField_a_of_type_ComTencentWidgetListView.getContext());
      this.jdField_b_of_type_AndroidViewView = new acom(this, this.jdField_a_of_type_ComTencentWidgetListView.getContext());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_a_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_b_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
      this.jdField_a_of_type_AndroidViewView.layout(0, 0, i, jdField_b_of_type_Int);
      this.jdField_b_of_type_AndroidViewView.layout(0, 0, i, jdField_b_of_type_Int);
      bool1 = bool2;
      if (a(this.jdField_a_of_type_Long))
      {
        if (!befo.e()) {
          break label867;
        }
        this.jdField_a_of_type_AndroidViewView.setLayerType(2, null);
        this.jdField_a_of_type_AndroidViewView.setPivotX(i / 2);
        this.jdField_a_of_type_AndroidViewView.setPivotY(jdField_b_of_type_Int / 2);
        this.jdField_b_of_type_AndroidViewView.setLayerType(2, null);
        this.jdField_b_of_type_AndroidViewView.setPivotX(i / 2);
        this.jdField_b_of_type_AndroidViewView.setPivotY(jdField_b_of_type_Int / 2);
        Object localObject1 = Keyframe.ofFloat(0.0F, 0.0F);
        Object localObject2 = Keyframe.ofFloat(11.0F * this.jdField_a_of_type_Float, 1.0F);
        Object localObject3 = Keyframe.ofFloat(20.0F * this.jdField_a_of_type_Float, 1.0F);
        Keyframe localKeyframe = Keyframe.ofFloat(1.0F, 0.0F);
        paramVarArgs = new Keyframe[4];
        paramVarArgs[0] = Keyframe.ofFloat(0.0F, 1.0F);
        paramVarArgs[1] = Keyframe.ofFloat(6.0F * this.jdField_a_of_type_Float, 1.5F);
        paramVarArgs[2] = Keyframe.ofFloat(11.0F * this.jdField_a_of_type_Float, 1.0F);
        paramVarArgs[3] = Keyframe.ofFloat(1.0F, 1.0F);
        localObject3 = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { localObject1, localObject2, localObject3, localKeyframe });
        localObject1 = PropertyValuesHolder.ofKeyframe("scaleX", paramVarArgs);
        localObject2 = PropertyValuesHolder.ofKeyframe("scaleY", paramVarArgs);
        paramVarArgs = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidViewView, new PropertyValuesHolder[] { localObject3 }).setDuration(1000L);
        localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidViewView, new PropertyValuesHolder[] { localObject1 }).setDuration(1000L);
        localObject2 = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidViewView, new PropertyValuesHolder[] { localObject2 }).setDuration(1000L);
        localObject3 = new AnimatorSet();
        ((AnimatorSet)localObject3).addListener(new acoi(this));
        ((AnimatorSet)localObject3).play(paramVarArgs).with((Animator)localObject1).with((Animator)localObject2);
        ((AnimatorSet)localObject3).start();
        this.jdField_a_of_type_AndroidViewView.setTag(localObject3);
        this.jdField_b_of_type_AndroidViewView.setAlpha(0.0F);
        paramVarArgs = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { 0.5F, 0.0F }).setDuration(333L);
        localObject1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "scaleX", new float[] { 1.5F, 2.0F }).setDuration(333L);
        localObject2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "scaleY", new float[] { 1.5F, 2.0F }).setDuration(333L);
        localObject3 = new AnimatorSet();
        ((AnimatorSet)localObject3).play(paramVarArgs).with((Animator)localObject1).with((Animator)localObject2);
        ((AnimatorSet)localObject3).setStartDelay((this.jdField_a_of_type_Float * 5.0F * 1000.0F));
        ((AnimatorSet)localObject3).start();
        this.jdField_b_of_type_AndroidViewView.setTag(localObject3);
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label781:
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = new Drawable[i1 + 1];
      int m = 0;
      j = 0;
      int n;
      do
      {
        this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[(i1 - m)] = this.jdField_a_of_type_ComTencentWidgetListView.getResources().getDrawable(i % 10 + 2130838272);
        k = j + this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[(i1 - m)].getIntrinsicWidth();
        m += 1;
        n = i / 10;
        j = k;
        i = n;
      } while (n > 0);
      break;
      label867:
      paramVarArgs = new acoj(this);
      paramVarArgs.setDuration(1000L);
      paramVarArgs.setFillAfter(true);
      this.jdField_a_of_type_AndroidViewView.setAnimation(paramVarArgs);
      paramVarArgs.setAnimationListener(new acok(this));
      paramVarArgs = new acol(this);
      paramVarArgs.setDuration(1000L);
      paramVarArgs.setFillAfter(true);
      this.jdField_b_of_type_AndroidViewView.setAnimation(paramVarArgs);
    }
  }
  
  @TargetApi(11)
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_b_of_type_AndroidViewView);
    if (befo.e())
    {
      Animator localAnimator1 = (Animator)this.jdField_a_of_type_AndroidViewView.getTag();
      Animator localAnimator2 = (Animator)this.jdField_b_of_type_AndroidViewView.getTag();
      if (localAnimator1 != null) {
        localAnimator1.cancel();
      }
      if (localAnimator2 != null) {
        localAnimator2.cancel();
      }
    }
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acoh
 * JD-Core Version:    0.7.0.1
 */