import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class agec
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  public agec(QzonePhotoView paramQzonePhotoView) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) < 1000L) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Long = l;
      } while ((paramView == null) || (!(paramView.getTag() instanceof DataTag)));
      paramView = (DataTag)paramView.getTag();
    } while (paramView == null);
    int i = paramView.a;
    paramView = QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView).a.a;
    switch (i)
    {
    default: 
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a, "CliOper", "", "", "card_mall", "0X80066C4", 0, 0, "2", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCard.QzonePhotoView", 2, "View.OnClickListener click type is photo wall view");
    }
    QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView, QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agec
 * JD-Core Version:    0.7.0.1
 */