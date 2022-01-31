import com.tencent.mobileqq.activity.bless.BlessResultActivity;
import com.tencent.qphone.base.util.QLog;

public class afbf
  implements aznu
{
  public afbf(BlessResultActivity paramBlessResultActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadSuccess!");
    }
    this.a.jdField_a_of_type_Boolean = true;
    this.a.g = this.a.b(this.a.d);
    if (this.a.jdField_a_of_type_Bfmt.hasMessages(1003)) {
      this.a.jdField_a_of_type_Bfmt.removeMessages(1003);
    }
    this.a.jdField_a_of_type_Bfmt.sendEmptyMessage(1001);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadFail!");
    }
    if (this.a.jdField_a_of_type_Bfmt.hasMessages(1003)) {
      this.a.jdField_a_of_type_Bfmt.removeMessages(1003);
    }
    this.a.jdField_a_of_type_Bfmt.sendEmptyMessage(1003);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadStart!");
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadStop!");
    }
  }
  
  public void c(long paramLong)
  {
    long l = bbdj.a(this.a.jdField_a_of_type_Afbg.a);
    int i = (int)(100L * paramLong / l);
    if (QLog.isColorLevel()) {
      QLog.d("BlessResultActivity", 2, "OnUploadVideoListener onUploadProcess! rawLen = " + l + ",offset = " + paramLong + ",process = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afbf
 * JD-Core Version:    0.7.0.1
 */