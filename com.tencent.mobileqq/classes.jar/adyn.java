import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.data.LebaFeedInfo;
import com.tencent.mobileqq.leba.LebaFeedsAdapter;
import com.tencent.mobileqq.leba.LebaFeedsVideoPlayController;
import com.tencent.mobileqq.leba.view.LebaFPSXListView;

public class adyn
  implements Animator.AnimatorListener
{
  public adyn(LebaFeedsAdapter paramLebaFeedsAdapter, LebaFeedInfo paramLebaFeedInfo) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    LebaFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter, null);
    LebaFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter).a(false);
    LebaFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter, this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo.feedID);
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter.notifyDataSetChanged();
    LebaFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter, false);
    LebaFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsAdapter).requestLayout();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyn
 * JD-Core Version:    0.7.0.1
 */