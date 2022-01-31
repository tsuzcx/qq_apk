import android.graphics.Point;
import com.tencent.mobileqq.arcard.ARCardCameraRecordActivity;
import com.tencent.mobileqq.arcard.ARCardCameraRecordActivity.VideoRecordResult;
import com.tencent.mobileqq.arcard.ARCardUtils;
import com.tencent.mobileqq.arcard.ARVideoPreviewActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class aaei
  implements Runnable
{
  public aaei(ARCardCameraRecordActivity paramARCardCameraRecordActivity, ARCardCameraRecordActivity.VideoRecordResult paramVideoRecordResult) {}
  
  public void run()
  {
    ARCardCameraRecordActivity.a(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity, this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity$VideoRecordResult);
    Point localPoint = ARCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity$VideoRecordResult.b);
    ARCardCameraRecordActivity.a(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity).b = this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity$VideoRecordResult.b;
    ARCardCameraRecordActivity.a(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity, 2);
    ARVideoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity, 1, this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity$VideoRecordResult.b, localPoint.x, localPoint.y, ARCardCameraRecordActivity.a(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity), ARCardCameraRecordActivity.b(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity), ARCardCameraRecordActivity.c(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity), ARCardCameraRecordActivity.d(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity), ARCardCameraRecordActivity.e(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity), ARCardCameraRecordActivity.f(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity), ARCardCameraRecordActivity.g(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity));
    try
    {
      i = Integer.parseInt(ARCardCameraRecordActivity.g(this.jdField_a_of_type_ComTencentMobileqqArcardARCardCameraRecordActivity));
      ReportController.b(null, "dc00898", "", "", "0X8008F20", "0X8008F20", i, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aaei
 * JD-Core Version:    0.7.0.1
 */