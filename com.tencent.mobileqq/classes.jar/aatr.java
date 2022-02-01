import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aatr
  implements aatl
{
  aatr(aatq paramaatq, long paramLong) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "combineWording end! isSuccess:" + paramBoolean + " path = " + paramString1);
      QLog.d(".troop.trace_video_combine", 2, "combineWordingTime:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    File localFile = new File(paramString1);
    if ((paramBoolean) && (localFile.exists()))
    {
      this.jdField_a_of_type_Aatq.a.jdField_a_of_type_Aatn.e = paramString1;
      this.jdField_a_of_type_Aatq.a.jdField_a_of_type_Aato.a.b(this.jdField_a_of_type_Aatq.a.jdField_a_of_type_Aato);
      this.jdField_a_of_type_Aatq.a.jdField_a_of_type_Aato.b();
      return;
    }
    this.jdField_a_of_type_Aatq.a.jdField_a_of_type_Aato.d = paramString2;
    this.jdField_a_of_type_Aatq.a.jdField_a_of_type_Aato.a.a(this.jdField_a_of_type_Aatq.a.jdField_a_of_type_Aato);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aatr
 * JD-Core Version:    0.7.0.1
 */