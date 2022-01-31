import com.tencent.mobileqq.dating.CarrierHelper;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.Iterator;
import java.util.LinkedList;

public class acem
  implements Runnable
{
  public acem(CarrierHelper paramCarrierHelper, LinkedList paramLinkedList) {}
  
  public void run()
  {
    if ((CarrierHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper)) || (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (5 == localInteger.intValue()) {
        ReportController.b(CarrierHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper), "CliOper", "", "", "0X80052A4", "0X80052A4", CarrierHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper), 0, "", "", "", "");
      } else if ((CarrierHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper) == 2) || (CarrierHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper) == 1)) {
        ReportController.b(CarrierHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper), "CliOper", "", "", "0X80050D0", "0X80050D0", CarrierHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper), 0, String.valueOf(localInteger), "", "", "");
      }
    }
    CarrierHelper.a(this.jdField_a_of_type_ComTencentMobileqqDatingCarrierHelper, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acem
 * JD-Core Version:    0.7.0.1
 */