import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ahxg
  implements apou
{
  ahxg(ahww paramahww, int paramInt) {}
  
  public void a(float paramFloat, List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "upLoadEmotions progress=" + paramFloat + ", addEmotionsResults=" + paramList + ", isTimeOut=" + ahww.b(this.jdField_a_of_type_Ahww));
    }
    if (!ahww.b(this.jdField_a_of_type_Ahww))
    {
      ahww.b(this.jdField_a_of_type_Ahww, paramList);
      ahww.a(this.jdField_a_of_type_Ahww, this.jdField_a_of_type_Int, paramFloat);
    }
  }
  
  public void a(List<Integer> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDKEmotionSettingManager", 2, "onUploadFinish , addEmotionsResults=" + paramList + ", isTimeOut=" + ahww.b(this.jdField_a_of_type_Ahww));
    }
    if (!ahww.b(this.jdField_a_of_type_Ahww))
    {
      ahww.a(this.jdField_a_of_type_Ahww).removeMessages(11);
      ahww.a(this.jdField_a_of_type_Ahww, this.jdField_a_of_type_Int, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxg
 * JD-Core Version:    0.7.0.1
 */