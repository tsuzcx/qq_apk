import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;

public class abgl
  implements Runnable
{
  public abgl(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard != null) {
      BusinessCardEditActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.cardName, this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.company, this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard.mobilesNum);
    }
    while (this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo == null) {
      return;
    }
    BusinessCardEditActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.a, null, this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataCardOCRInfo.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abgl
 * JD-Core Version:    0.7.0.1
 */