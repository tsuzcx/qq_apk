import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class akdx
  extends batl
{
  akdx(String paramString) {}
  
  public void onCancel(batm parambatm)
  {
    akdt.jdField_a_of_type_Batm = null;
    QLog.d(akdt.jdField_a_of_type_JavaLangString, 1, "downloadZipFile cancel");
  }
  
  public void onDone(batm parambatm)
  {
    akdt.jdField_a_of_type_Batm = null;
    if (parambatm.a() == 3)
    {
      QLog.d(akdt.jdField_a_of_type_JavaLangString, 1, "download finished " + akdt.f);
      parambatm = new File(this.jdField_a_of_type_JavaLangString);
      if ((parambatm.exists()) && (akdt.a(parambatm))) {
        QLog.d(akdt.jdField_a_of_type_JavaLangString, 1, "downloadZipFile suc and zip succ");
      }
      return;
    }
    QLog.d(akdt.jdField_a_of_type_JavaLangString, 1, new Object[] { "downloadZipFile failed: ", parambatm.b, " code=", Integer.valueOf(parambatm.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akdx
 * JD-Core Version:    0.7.0.1
 */