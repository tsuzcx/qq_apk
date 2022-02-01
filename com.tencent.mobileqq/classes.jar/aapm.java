import com.tencent.qphone.base.util.QLog;
import java.io.File;

class aapm
  implements aapi
{
  aapm(aapl paramaapl, aapk paramaapk) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "combineVideos end! isSuccess:" + paramBoolean + " path = " + paramString1);
    }
    File localFile = new File(paramString1);
    if ((paramBoolean) && (localFile.exists()))
    {
      if (this.jdField_a_of_type_Aapk.a)
      {
        this.jdField_a_of_type_Aapl.jdField_a_of_type_Aapz.b(this.jdField_a_of_type_Aapl);
        return;
      }
      if (this.jdField_a_of_type_Aapl.jdField_a_of_type_JavaLangString != null)
      {
        l = System.currentTimeMillis();
        this.jdField_a_of_type_Aapl.jdField_a_of_type_Aapa.a(paramString1, this.jdField_a_of_type_Aapl.jdField_a_of_type_JavaLangString, new aapn(this, l));
        return;
      }
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Aapl.a(localFile, this.jdField_a_of_type_Aapl.b, new aapp(this, l));
      return;
    }
    this.jdField_a_of_type_Aapl.d = paramString2;
    this.jdField_a_of_type_Aapl.jdField_a_of_type_Aapz.a(this.jdField_a_of_type_Aapl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapm
 * JD-Core Version:    0.7.0.1
 */