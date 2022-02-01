import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.GestureHandler.3;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.GestureHandler.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RoundRectImageView;
import mqq.os.MqqHandler;

public class aifj
{
  aifb jdField_a_of_type_Aifb;
  Context jdField_a_of_type_AndroidContentContext;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  RoundRectImageView jdField_a_of_type_ComTencentWidgetRoundRectImageView;
  Runnable jdField_a_of_type_JavaLangRunnable;
  int jdField_b_of_type_Int;
  AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public Runnable b;
  int[] jdField_b_of_type_ArrayOfInt;
  RelativeLayout.LayoutParams jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  public RelativeLayout c;
  int[] jdField_c_of_type_ArrayOfInt;
  RelativeLayout.LayoutParams d;
  
  public aifj(aife paramaife, Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_b_of_type_ArrayOfInt = new int[2];
    this.jdField_c_of_type_ArrayOfInt = new int[2];
    paramViewGroup.getLocationInWindow(this.jdField_b_of_type_ArrayOfInt);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(17170445);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new aifk(this, paramaife));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = paramaife.a;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramContext);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(637534208);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView = new RoundRectImageView(paramContext);
    if (PhotoListPanel.f() == 1) {
      this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setCornerRadiusAndMode(12, 1);
    }
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new aifl(this, paramaife);
    this.jdField_a_of_type_JavaLangRunnable = new PhotoListPanel.SwipeUpAndDragListener.GestureHandler.3(this, paramaife);
    this.jdField_b_of_type_JavaLangRunnable = new PhotoListPanel.SwipeUpAndDragListener.GestureHandler.4(this, paramaife);
  }
  
  boolean a()
  {
    return (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidViewViewGroup.indexOfChild(this.jdField_a_of_type_AndroidWidgetRelativeLayout) != -1);
  }
  
  public boolean a(aifb paramaifb, int paramInt)
  {
    this.jdField_a_of_type_Aifb = paramaifb;
    this.jdField_b_of_type_Int = paramInt;
    paramaifb.itemView.getLocationInWindow(this.jdField_c_of_type_ArrayOfInt);
    paramaifb = this.jdField_a_of_type_Aifb.a.getDrawable();
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setImageDrawable(paramaifb);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return true;
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  void b()
  {
    QLog.d("PhotoListPanel", 1, new Object[] { "clear", "handler = " + this });
    try
    {
      this.jdField_a_of_type_Aifb.itemView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
      {
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 50L);
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        localNullPointerException.printStackTrace();
      }
      ThreadManager.getUIHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 100L);
    }
  }
  
  boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifj
 * JD-Core Version:    0.7.0.1
 */