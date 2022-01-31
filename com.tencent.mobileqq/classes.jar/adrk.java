import android.os.Handler;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.MagicfaceActionListener;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.qphone.base.util.QLog;

public class adrk
  implements MagicfaceActionManager.MagicfaceActionListener
{
  public adrk(MagicfaceViewController paramMagicfaceViewController, long paramLong, int paramInt) {}
  
  public void a(ActionGlobalData paramActionGlobalData)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "【magicface】 cost =" + (l1 - l2) + "ms");
    }
    boolean bool;
    if (this.jdField_a_of_type_Int == 0)
    {
      bool = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c(bool);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_AndroidOsHandler.post(new adrl(this, paramActionGlobalData));
      return;
      bool = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c(bool);
    }
  }
  
  public void b(ActionGlobalData paramActionGlobalData)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.jdField_a_of_type_AndroidOsHandler.post(new adrm(this, paramActionGlobalData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adrk
 * JD-Core Version:    0.7.0.1
 */