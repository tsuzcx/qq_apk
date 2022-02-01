import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ajps
  implements asfr
{
  ajps(ajpi paramajpi, int paramInt) {}
  
  public void a(float paramFloat, List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "upLoadEmotions progress=" + paramFloat + ", addEmotionsResults=" + paramList + ", isTimeOut=" + ajpi.b(this.jdField_a_of_type_Ajpi));
    }
    if (!ajpi.b(this.jdField_a_of_type_Ajpi))
    {
      ajpi.b(this.jdField_a_of_type_Ajpi, paramList);
      ajpi.a(this.jdField_a_of_type_Ajpi, this.jdField_a_of_type_Int, paramFloat);
    }
  }
  
  public void a(List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "onUploadFinish , addEmotionsResults=" + paramList + ", isTimeOut=" + ajpi.b(this.jdField_a_of_type_Ajpi));
    }
    if (!ajpi.b(this.jdField_a_of_type_Ajpi))
    {
      ajpi.a(this.jdField_a_of_type_Ajpi).removeMessages(11);
      ajpi.a(this.jdField_a_of_type_Ajpi, this.jdField_a_of_type_Int, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajps
 * JD-Core Version:    0.7.0.1
 */