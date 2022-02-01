import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aats
  implements aatl
{
  aats(aatp paramaatp, long paramLong) {}
  
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
      this.jdField_a_of_type_Aatp.jdField_a_of_type_Aatn.e = paramString1;
      this.jdField_a_of_type_Aatp.jdField_a_of_type_Aato.a.b(this.jdField_a_of_type_Aatp.jdField_a_of_type_Aato);
      this.jdField_a_of_type_Aatp.jdField_a_of_type_Aato.b();
      return;
    }
    this.jdField_a_of_type_Aatp.jdField_a_of_type_Aato.d = paramString2;
    this.jdField_a_of_type_Aatp.jdField_a_of_type_Aato.a.a(this.jdField_a_of_type_Aatp.jdField_a_of_type_Aato);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aats
 * JD-Core Version:    0.7.0.1
 */