import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aatp
  implements aatl
{
  aatp(aato paramaato, aatn paramaatn) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "combineVideos end! isSuccess:" + paramBoolean + " path = " + paramString1);
    }
    File localFile = new File(paramString1);
    if ((paramBoolean) && (localFile.exists()))
    {
      if (this.jdField_a_of_type_Aatn.a)
      {
        this.jdField_a_of_type_Aato.jdField_a_of_type_Aauc.b(this.jdField_a_of_type_Aato);
        return;
      }
      if (this.jdField_a_of_type_Aato.jdField_a_of_type_JavaLangString != null)
      {
        l = System.currentTimeMillis();
        this.jdField_a_of_type_Aato.jdField_a_of_type_Aatd.a(paramString1, this.jdField_a_of_type_Aato.jdField_a_of_type_JavaLangString, new aatq(this, l));
        return;
      }
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Aato.a(localFile, this.jdField_a_of_type_Aato.b, new aats(this, l));
      return;
    }
    this.jdField_a_of_type_Aato.d = paramString2;
    this.jdField_a_of_type_Aato.jdField_a_of_type_Aauc.a(this.jdField_a_of_type_Aato);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aatp
 * JD-Core Version:    0.7.0.1
 */