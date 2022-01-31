import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class afuy
  implements antd
{
  afuy(afup paramafup, int paramInt) {}
  
  public void a(float paramFloat, List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "upLoadEmotions progress=" + paramFloat + ", addEmotionsResults=" + paramList + ", isTimeOut=" + afup.b(this.jdField_a_of_type_Afup));
    }
    if (!afup.b(this.jdField_a_of_type_Afup))
    {
      afup.b(this.jdField_a_of_type_Afup, paramList);
      afup.a(this.jdField_a_of_type_Afup, this.jdField_a_of_type_Int, paramFloat);
    }
  }
  
  public void a(List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "onUploadFinish , addEmotionsResults=" + paramList + ", isTimeOut=" + afup.b(this.jdField_a_of_type_Afup));
    }
    if (!afup.b(this.jdField_a_of_type_Afup))
    {
      afup.a(this.jdField_a_of_type_Afup).removeMessages(11);
      afup.a(this.jdField_a_of_type_Afup, this.jdField_a_of_type_Int, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afuy
 * JD-Core Version:    0.7.0.1
 */