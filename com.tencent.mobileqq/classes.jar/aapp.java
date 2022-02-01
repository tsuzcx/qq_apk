import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aapp
  implements aapi
{
  aapp(aapm paramaapm, long paramLong) {}
  
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
      this.jdField_a_of_type_Aapm.jdField_a_of_type_Aapk.e = paramString1;
      this.jdField_a_of_type_Aapm.jdField_a_of_type_Aapl.a.b(this.jdField_a_of_type_Aapm.jdField_a_of_type_Aapl);
      this.jdField_a_of_type_Aapm.jdField_a_of_type_Aapl.b();
      return;
    }
    this.jdField_a_of_type_Aapm.jdField_a_of_type_Aapl.d = paramString2;
    this.jdField_a_of_type_Aapm.jdField_a_of_type_Aapl.a.a(this.jdField_a_of_type_Aapm.jdField_a_of_type_Aapl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapp
 * JD-Core Version:    0.7.0.1
 */