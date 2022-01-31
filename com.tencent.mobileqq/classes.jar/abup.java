import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class abup
  implements Runnable
{
  abup(abul paramabul, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MessageForNearbyMarketGrayTips", 4, "0X80052C4");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052C4", "0X80052C4", 0, 0, abul.a(this.jdField_a_of_type_Abul).frienduin, "", "", "");
    QQAppInterface localQQAppInterface;
    if ((abul.a(this.jdField_a_of_type_Abul).AioType == 1) || (abul.a(this.jdField_a_of_type_Abul).AioType == 3))
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (abul.a(this.jdField_a_of_type_Abul).AioType != 0) {
        break label122;
      }
    }
    label122:
    for (String str = "0";; str = "1")
    {
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "tmp_grey", "clk_blue", 0, 0, str, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abup
 * JD-Core Version:    0.7.0.1
 */