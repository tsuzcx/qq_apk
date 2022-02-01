import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class alhl
  implements bdyi
{
  boolean jdField_a_of_type_Boolean = false;
  
  alhl(alhk paramalhk, bdyi parambdyi) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SpecifyRedPacketAnimMsg", 2, "showAnim onFrameEnd");
    }
    if ((this.jdField_a_of_type_Boolean) || (alhk.a(this.jdField_a_of_type_Alhk))) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      if (alhk.a(this.jdField_a_of_type_Alhk) != null) {
        ThreadManager.getUIHandler().removeCallbacks(alhk.a(this.jdField_a_of_type_Alhk));
      }
    } while (this.jdField_a_of_type_Bdyi == null);
    this.jdField_a_of_type_Bdyi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhl
 * JD-Core Version:    0.7.0.1
 */