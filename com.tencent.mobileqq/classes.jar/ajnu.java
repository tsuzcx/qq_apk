import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ajnu
  implements arrv
{
  ajnu(ajnk paramajnk, int paramInt) {}
  
  public void a(float paramFloat, List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "upLoadEmotions progress=" + paramFloat + ", addEmotionsResults=" + paramList + ", isTimeOut=" + ajnk.b(this.jdField_a_of_type_Ajnk));
    }
    if (!ajnk.b(this.jdField_a_of_type_Ajnk))
    {
      ajnk.b(this.jdField_a_of_type_Ajnk, paramList);
      ajnk.a(this.jdField_a_of_type_Ajnk, this.jdField_a_of_type_Int, paramFloat);
    }
  }
  
  public void a(List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "onUploadFinish , addEmotionsResults=" + paramList + ", isTimeOut=" + ajnk.b(this.jdField_a_of_type_Ajnk));
    }
    if (!ajnk.b(this.jdField_a_of_type_Ajnk))
    {
      ajnk.a(this.jdField_a_of_type_Ajnk).removeMessages(11);
      ajnk.a(this.jdField_a_of_type_Ajnk, this.jdField_a_of_type_Int, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnu
 * JD-Core Version:    0.7.0.1
 */