import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.trooponline.TroopOnlineMemberBar;
import com.tencent.mobileqq.trooponline.TroopOnlineMemberNewGuideDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.util.BitmapUtil;

public class ajin
  implements Animator.AnimatorListener
{
  public ajin(TroopOnlineMemberBar paramTroopOnlineMemberBar) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    Bitmap localBitmap;
    if ((!SharedPreUtils.t(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (TroopOnlineMemberBar.a(this.a) == 0))
    {
      SharedPreUtils.G(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localBitmap = BitmapUtil.a((View)this.a.b.findViewById(2131363974).getParent());
      paramAnimator = null;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getChildCount() <= 1) {
        break label123;
      }
      paramAnimator = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getChildAt(1);
    }
    for (;;)
    {
      new TroopOnlineMemberNewGuideDialog(this.a.jdField_a_of_type_AndroidContentContext, localBitmap, paramAnimator).show();
      return;
      label123:
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getChildCount() > 0) {
        paramAnimator = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getChildAt(0);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajin
 * JD-Core Version:    0.7.0.1
 */