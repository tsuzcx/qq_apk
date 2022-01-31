import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class aevj
  implements Runnable
{
  public aevj(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel, String paramString) {}
  
  public void run()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.a.app, "CliOper", "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0, 0, "", "", "", "");
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.nearby_people_card.", 4, "reportClickEvent " + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevj
 * JD-Core Version:    0.7.0.1
 */