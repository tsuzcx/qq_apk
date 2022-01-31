import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.confess.FrdConfessInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class abrr
  implements Runnable
{
  public abrr(ConfessManager paramConfessManager) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.a.jdField_a_of_type_ComTencentMobileqqConfessConfessConfig == null)) {
      ConfessManager.a(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ConfessManager", 2, String.format(Locale.getDefault(), "init config : %s", new Object[] { this.a.jdField_a_of_type_ComTencentMobileqqConfessConfessConfig }));
    }
    if (!this.a.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo.a) {
      this.a.jdField_a_of_type_ComTencentMobileqqConfessFrdConfessInfo.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abrr
 * JD-Core Version:    0.7.0.1
 */