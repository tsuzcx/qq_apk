import android.text.TextUtils;
import com.tencent.mobileqq.leba.LebaFeedsVideoPlayController;
import com.tencent.mobileqq.leba.LebaFeedsVideoPlayController.VideoPlayParam;
import com.tencent.mobileqq.leba.LebaFeedsVideoPlayer;
import com.tencent.qphone.base.util.QLog;

public class aehd
  implements Runnable
{
  public aehd(LebaFeedsVideoPlayController paramLebaFeedsVideoPlayController, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayController", 2, "playVideo in subThread, param=" + LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController) + ", startPos=" + this.jdField_a_of_type_Long);
    }
    if (LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController) != null)
    {
      if (!TextUtils.isEmpty(LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController).jdField_b_of_type_JavaLangString)) {
        LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController).a(LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController).jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long, LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController).jdField_c_of_type_Long, LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController).jdField_b_of_type_Long);
      }
    }
    else {
      return;
    }
    LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController).b(LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController).jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Long, LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController).jdField_c_of_type_Long, LebaFeedsVideoPlayController.a(this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController).jdField_b_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehd
 * JD-Core Version:    0.7.0.1
 */