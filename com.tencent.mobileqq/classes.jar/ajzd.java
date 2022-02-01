import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ajzd
  implements ashj
{
  ajzd(ajyt paramajyt, int paramInt) {}
  
  public void a(float paramFloat, List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "upLoadEmotions progress=" + paramFloat + ", addEmotionsResults=" + paramList + ", isTimeOut=" + ajyt.b(this.jdField_a_of_type_Ajyt));
    }
    if (!ajyt.b(this.jdField_a_of_type_Ajyt))
    {
      ajyt.b(this.jdField_a_of_type_Ajyt, paramList);
      ajyt.a(this.jdField_a_of_type_Ajyt, this.jdField_a_of_type_Int, paramFloat);
    }
  }
  
  public void a(List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "onUploadFinish , addEmotionsResults=" + paramList + ", isTimeOut=" + ajyt.b(this.jdField_a_of_type_Ajyt));
    }
    if (!ajyt.b(this.jdField_a_of_type_Ajyt))
    {
      ajyt.a(this.jdField_a_of_type_Ajyt).removeMessages(11);
      ajyt.a(this.jdField_a_of_type_Ajyt, this.jdField_a_of_type_Int, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzd
 * JD-Core Version:    0.7.0.1
 */