import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class akvw
  implements bdfn
{
  boolean jdField_a_of_type_Boolean = false;
  
  akvw(akvv paramakvv, bdfn parambdfn) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SpecifyRedPacketAnimMsg", 2, "showAnim onFrameEnd");
    }
    if ((this.jdField_a_of_type_Boolean) || (akvv.a(this.jdField_a_of_type_Akvv))) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      if (akvv.a(this.jdField_a_of_type_Akvv) != null) {
        ThreadManager.getUIHandler().removeCallbacks(akvv.a(this.jdField_a_of_type_Akvv));
      }
    } while (this.jdField_a_of_type_Bdfn == null);
    this.jdField_a_of_type_Bdfn.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akvw
 * JD-Core Version:    0.7.0.1
 */