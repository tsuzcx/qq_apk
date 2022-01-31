import android.os.Handler;
import android.widget.ImageView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.leba.LebaFeedsVideoPlayController;
import com.tencent.mobileqq.leba.LebaFeedsVideoPlayer;

public class adyw
  implements Runnable
{
  public adyw(LebaFeedsVideoPlayController paramLebaFeedsVideoPlayController, int paramInt) {}
  
  public void run()
  {
    if (LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController) != null) {
      LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController).setVisibility(8);
    }
    if ((LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController) != null) && (LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController) != null)) {
      LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController, LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController).c());
    }
    if ((LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController) != null) && (this.jdField_a_of_type_Int != 3))
    {
      LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController).setVisibility(0);
      LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController).removeMessages(11);
      LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController).sendEmptyMessageDelayed(11, 3000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyw
 * JD-Core Version:    0.7.0.1
 */