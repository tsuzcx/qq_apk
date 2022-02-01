import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class aiud
  implements arbh
{
  aiud(aitt paramaitt, int paramInt) {}
  
  public void a(float paramFloat, List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "upLoadEmotions progress=" + paramFloat + ", addEmotionsResults=" + paramList + ", isTimeOut=" + aitt.b(this.jdField_a_of_type_Aitt));
    }
    if (!aitt.b(this.jdField_a_of_type_Aitt))
    {
      aitt.b(this.jdField_a_of_type_Aitt, paramList);
      aitt.a(this.jdField_a_of_type_Aitt, this.jdField_a_of_type_Int, paramFloat);
    }
  }
  
  public void a(List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "onUploadFinish , addEmotionsResults=" + paramList + ", isTimeOut=" + aitt.b(this.jdField_a_of_type_Aitt));
    }
    if (!aitt.b(this.jdField_a_of_type_Aitt))
    {
      aitt.a(this.jdField_a_of_type_Aitt).removeMessages(11);
      aitt.a(this.jdField_a_of_type_Aitt, this.jdField_a_of_type_Int, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiud
 * JD-Core Version:    0.7.0.1
 */