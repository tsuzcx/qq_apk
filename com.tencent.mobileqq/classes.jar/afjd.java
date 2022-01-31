import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class afjd
  implements ancn
{
  afjd(afiu paramafiu, int paramInt) {}
  
  public void a(float paramFloat, List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "upLoadEmotions progress=" + paramFloat + ", addEmotionsResults=" + paramList + ", isTimeOut=" + afiu.b(this.jdField_a_of_type_Afiu));
    }
    if (!afiu.b(this.jdField_a_of_type_Afiu))
    {
      afiu.b(this.jdField_a_of_type_Afiu, paramList);
      afiu.a(this.jdField_a_of_type_Afiu, this.jdField_a_of_type_Int, paramFloat);
    }
  }
  
  public void a(List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "onUploadFinish , addEmotionsResults=" + paramList + ", isTimeOut=" + afiu.b(this.jdField_a_of_type_Afiu));
    }
    if (!afiu.b(this.jdField_a_of_type_Afiu))
    {
      afiu.a(this.jdField_a_of_type_Afiu).removeMessages(11);
      afiu.a(this.jdField_a_of_type_Afiu, this.jdField_a_of_type_Int, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afjd
 * JD-Core Version:    0.7.0.1
 */