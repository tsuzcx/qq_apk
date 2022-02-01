import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aafn
  implements aafj
{
  aafn(aafm paramaafm, aafl paramaafl) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "combineVideos end! isSuccess:" + paramBoolean + " path = " + paramString1);
    }
    File localFile = new File(paramString1);
    if ((paramBoolean) && (localFile.exists()))
    {
      if (this.jdField_a_of_type_Aafl.a)
      {
        this.jdField_a_of_type_Aafm.jdField_a_of_type_Aaga.b(this.jdField_a_of_type_Aafm);
        return;
      }
      if (this.jdField_a_of_type_Aafm.jdField_a_of_type_JavaLangString != null)
      {
        l = System.currentTimeMillis();
        this.jdField_a_of_type_Aafm.jdField_a_of_type_Aafb.a(paramString1, this.jdField_a_of_type_Aafm.jdField_a_of_type_JavaLangString, new aafo(this, l));
        return;
      }
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Aafm.a(localFile, this.jdField_a_of_type_Aafm.b, new aafq(this, l));
      return;
    }
    this.jdField_a_of_type_Aafm.d = paramString2;
    this.jdField_a_of_type_Aafm.jdField_a_of_type_Aaga.a(this.jdField_a_of_type_Aafm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafn
 * JD-Core Version:    0.7.0.1
 */