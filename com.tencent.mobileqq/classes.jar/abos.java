import com.tencent.mobileqq.armap.test.ARWebTestActivity;
import com.tencent.qphone.base.util.QLog;

public class abos
  implements Runnable
{
  public abos(ARWebTestActivity paramARWebTestActivity, String paramString) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ARWebTestActivity", 4, "call from onPageFinished delay");
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapTestARWebTestActivity.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abos
 * JD-Core Version:    0.7.0.1
 */