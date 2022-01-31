import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class aksi
  extends bbwt
{
  aksi(String paramString) {}
  
  public void onCancel(bbwu parambbwu)
  {
    akse.jdField_a_of_type_Bbwu = null;
    QLog.d(akse.jdField_a_of_type_JavaLangString, 1, "downloadZipFile cancel");
  }
  
  public void onDone(bbwu parambbwu)
  {
    akse.jdField_a_of_type_Bbwu = null;
    if (parambbwu.a() == 3)
    {
      QLog.d(akse.jdField_a_of_type_JavaLangString, 1, "download finished " + akse.f);
      parambbwu = new File(this.jdField_a_of_type_JavaLangString);
      if ((parambbwu.exists()) && (akse.a(parambbwu))) {
        QLog.d(akse.jdField_a_of_type_JavaLangString, 1, "downloadZipFile suc and zip succ");
      }
      return;
    }
    QLog.d(akse.jdField_a_of_type_JavaLangString, 1, new Object[] { "downloadZipFile failed: ", parambbwu.b, " code=", Integer.valueOf(parambbwu.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aksi
 * JD-Core Version:    0.7.0.1
 */