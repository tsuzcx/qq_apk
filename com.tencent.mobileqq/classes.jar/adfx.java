import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.hotpic.HotPicSendData;
import com.tencent.mobileqq.persistence.EntityManager;

public class adfx
  implements Runnable
{
  public adfx(HotPicManager paramHotPicManager, HotPicSendData paramHotPicSendData1, HotPicSendData paramHotPicSendData2) {}
  
  public void run()
  {
    HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager).b(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicSendData);
    if (this.b != null) {
      HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager).b(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adfx
 * JD-Core Version:    0.7.0.1
 */