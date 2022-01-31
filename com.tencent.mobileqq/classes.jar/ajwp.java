import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.trooponline.TroopOnlineMemberBar;

public class ajwp
  implements ValueAnimator.AnimatorUpdateListener
{
  public ajwp(TroopOnlineMemberBar paramTroopOnlineMemberBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    ((RelativeLayout.LayoutParams)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getLayoutParams()).topMargin = paramValueAnimator.intValue();
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.requestLayout();
    if ((paramValueAnimator.intValue() >= this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448)) && (AppSetting.b) && (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getChildCount() > 0))
    {
      paramValueAnimator = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getChildAt(0);
      if (paramValueAnimator != null) {
        paramValueAnimator.requestFocusFromTouch();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwp
 * JD-Core Version:    0.7.0.1
 */