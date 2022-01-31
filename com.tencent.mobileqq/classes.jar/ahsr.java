import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ahsr
  implements apkl
{
  ahsr(ahsh paramahsh, int paramInt) {}
  
  public void a(float paramFloat, List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "upLoadEmotions progress=" + paramFloat + ", addEmotionsResults=" + paramList + ", isTimeOut=" + ahsh.b(this.jdField_a_of_type_Ahsh));
    }
    if (!ahsh.b(this.jdField_a_of_type_Ahsh))
    {
      ahsh.b(this.jdField_a_of_type_Ahsh, paramList);
      ahsh.a(this.jdField_a_of_type_Ahsh, this.jdField_a_of_type_Int, paramFloat);
    }
  }
  
  public void a(List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "onUploadFinish , addEmotionsResults=" + paramList + ", isTimeOut=" + ahsh.b(this.jdField_a_of_type_Ahsh));
    }
    if (!ahsh.b(this.jdField_a_of_type_Ahsh))
    {
      ahsh.a(this.jdField_a_of_type_Ahsh).removeMessages(11);
      ahsh.a(this.jdField_a_of_type_Ahsh, this.jdField_a_of_type_Int, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsr
 * JD-Core Version:    0.7.0.1
 */