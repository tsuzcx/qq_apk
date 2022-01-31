import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class aksj
  extends bbwf
{
  aksj(String paramString) {}
  
  public void onCancel(bbwg parambbwg)
  {
    aksf.jdField_a_of_type_Bbwg = null;
    QLog.d(aksf.jdField_a_of_type_JavaLangString, 1, "downloadZipFile cancel");
  }
  
  public void onDone(bbwg parambbwg)
  {
    aksf.jdField_a_of_type_Bbwg = null;
    if (parambbwg.a() == 3)
    {
      QLog.d(aksf.jdField_a_of_type_JavaLangString, 1, "download finished " + aksf.f);
      parambbwg = new File(this.jdField_a_of_type_JavaLangString);
      if ((parambbwg.exists()) && (aksf.a(parambbwg))) {
        QLog.d(aksf.jdField_a_of_type_JavaLangString, 1, "downloadZipFile suc and zip succ");
      }
      return;
    }
    QLog.d(aksf.jdField_a_of_type_JavaLangString, 1, new Object[] { "downloadZipFile failed: ", parambbwg.b, " code=", Integer.valueOf(parambbwg.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aksj
 * JD-Core Version:    0.7.0.1
 */