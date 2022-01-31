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

public class aeko
{
  aekg jdField_a_of_type_Aekg;
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
  
  public aeko(aekj paramaekj, Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_b_of_type_ArrayOfInt = new int[2];
    this.jdField_c_of_type_ArrayOfInt = new int[2];
    paramViewGroup.getLocationInWindow(this.jdField_b_of_type_ArrayOfInt);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(17170445);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new aekp(this, paramaekj));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = paramaekj.a;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramContext);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(637534208);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView = new RoundRectImageView(paramContext);
    if (PhotoListPanel.f() == 1) {
      this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setCornerRadiusAndMode(12, 1);
    }
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new aekq(this, paramaekj);
    this.jdField_a_of_type_JavaLangRunnable = new PhotoListPanel.SwipeUpAndDragListener.GestureHandler.3(this, paramaekj);
    this.jdField_b_of_type_JavaLangRunnable = new PhotoListPanel.SwipeUpAndDragListener.GestureHandler.4(this, paramaekj);
  }
  
  boolean a()
  {
    return (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidViewViewGroup.indexOfChild(this.jdField_a_of_type_AndroidWidgetRelativeLayout) != -1);
  }
  
  public boolean a(aekg paramaekg, int paramInt)
  {
    this.jdField_a_of_type_Aekg = paramaekg;
    this.jdField_b_of_type_Int = paramInt;
    paramaekg.itemView.getLocationInWindow(this.jdField_c_of_type_ArrayOfInt);
    paramaekg = this.jdField_a_of_type_Aekg.a.getDrawable();
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setImageDrawable(paramaekg);
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
      this.jdField_a_of_type_Aekg.itemView.clearAnimation();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeko
 * JD-Core Version:    0.7.0.1
 */