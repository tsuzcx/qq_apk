import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aafq
  implements aafj
{
  aafq(aafn paramaafn, long paramLong) {}
  
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
      this.jdField_a_of_type_Aafn.jdField_a_of_type_Aafl.e = paramString1;
      this.jdField_a_of_type_Aafn.jdField_a_of_type_Aafm.a.b(this.jdField_a_of_type_Aafn.jdField_a_of_type_Aafm);
      this.jdField_a_of_type_Aafn.jdField_a_of_type_Aafm.b();
      return;
    }
    this.jdField_a_of_type_Aafn.jdField_a_of_type_Aafm.d = paramString2;
    this.jdField_a_of_type_Aafn.jdField_a_of_type_Aafm.a.a(this.jdField_a_of_type_Aafn.jdField_a_of_type_Aafm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafq
 * JD-Core Version:    0.7.0.1
 */