import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class agsv
  implements axbz
{
  boolean jdField_a_of_type_Boolean = false;
  
  agsv(agsu paramagsu, axbz paramaxbz) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SpecifyRedPacketAnimMsg", 2, "showAnim onFrameEnd");
    }
    if ((this.jdField_a_of_type_Boolean) || (agsu.a(this.jdField_a_of_type_Agsu))) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      if (agsu.a(this.jdField_a_of_type_Agsu) != null) {
        ThreadManager.getUIHandler().removeCallbacks(agsu.a(this.jdField_a_of_type_Agsu));
      }
    } while (this.jdField_a_of_type_Axbz == null);
    this.jdField_a_of_type_Axbz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agsv
 * JD-Core Version:    0.7.0.1
 */