import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.activity.BusinessCardListActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class abus
  extends BusinessCardObserver
{
  public abus(BusinessCardListActivity paramBusinessCardListActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_observer", 2, "onGetCardList " + paramBoolean);
    }
    if (paramBoolean)
    {
      ArrayList localArrayList = this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a();
      this.a.a(localArrayList, 0L, false);
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt != 3))
    {
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a();
      if ((paramInt == 1) && (this.a.jdField_a_of_type_Int == 0)) {
        this.a.a(paramString, 0L, false);
      }
    }
    else
    {
      return;
    }
    this.a.a(paramString, 500L, false);
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a();
      this.a.a(paramString, 500L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abus
 * JD-Core Version:    0.7.0.1
 */