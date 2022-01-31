import android.os.Handler;
import android.os.Message;
import cooperation.qzone.QZoneLiveVideoDownLoadActivtyV2;

class ambv
  implements Runnable
{
  ambv(ambu paramambu, float paramFloat) {}
  
  public void run()
  {
    if ((int)(this.jdField_a_of_type_Float * 100.0F) > 0)
    {
      this.jdField_a_of_type_Ambu.a.a.removeMessages(1009);
      this.jdField_a_of_type_Ambu.a.a.obtainMessage(1004, 100, 0).sendToTarget();
      this.jdField_a_of_type_Ambu.a.a(false, true);
    }
    while (!this.jdField_a_of_type_Ambu.a.e) {
      return;
    }
    this.jdField_a_of_type_Ambu.a.a.removeMessages(1009);
    this.jdField_a_of_type_Ambu.a.a(true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambv
 * JD-Core Version:    0.7.0.1
 */