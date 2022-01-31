import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ahfk
  implements aycb
{
  boolean jdField_a_of_type_Boolean = false;
  
  ahfk(ahfj paramahfj, aycb paramaycb) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SpecifyRedPacketAnimMsg", 2, "showAnim onFrameEnd");
    }
    if ((this.jdField_a_of_type_Boolean) || (ahfj.a(this.jdField_a_of_type_Ahfj))) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      if (ahfj.a(this.jdField_a_of_type_Ahfj) != null) {
        ThreadManager.getUIHandler().removeCallbacks(ahfj.a(this.jdField_a_of_type_Ahfj));
      }
    } while (this.jdField_a_of_type_Aycb == null);
    this.jdField_a_of_type_Aycb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahfk
 * JD-Core Version:    0.7.0.1
 */