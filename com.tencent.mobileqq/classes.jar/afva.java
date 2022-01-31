import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class afva
  implements ansy
{
  afva(afur paramafur, int paramInt) {}
  
  public void a(float paramFloat, List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "upLoadEmotions progress=" + paramFloat + ", addEmotionsResults=" + paramList + ", isTimeOut=" + afur.b(this.jdField_a_of_type_Afur));
    }
    if (!afur.b(this.jdField_a_of_type_Afur))
    {
      afur.b(this.jdField_a_of_type_Afur, paramList);
      afur.a(this.jdField_a_of_type_Afur, this.jdField_a_of_type_Int, paramFloat);
    }
  }
  
  public void a(List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "onUploadFinish , addEmotionsResults=" + paramList + ", isTimeOut=" + afur.b(this.jdField_a_of_type_Afur));
    }
    if (!afur.b(this.jdField_a_of_type_Afur))
    {
      afur.a(this.jdField_a_of_type_Afur).removeMessages(11);
      afur.a(this.jdField_a_of_type_Afur, this.jdField_a_of_type_Int, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afva
 * JD-Core Version:    0.7.0.1
 */