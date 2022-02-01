import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class aipf
  extends bhhe
{
  aipf(aipe paramaipe, String paramString1, String paramString2) {}
  
  public void onCancel(bhhf parambhhf)
  {
    aipe.a(this.jdField_a_of_type_Aipe).remove(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(bhhf parambhhf)
  {
    aipe.a(this.jdField_a_of_type_Aipe).remove(this.jdField_a_of_type_JavaLangString);
    if (parambhhf.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "download finished " + this.b);
      }
      if ((this.b != null) && (aipe.a(this.jdField_a_of_type_Aipe) != null) && (this.b.equals(aipe.a(this.jdField_a_of_type_Aipe).starVideo))) {
        aipe.b(this.jdField_a_of_type_Aipe);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      aipe.a(this.jdField_a_of_type_Aipe);
      return;
    }
    QLog.d("BlessManager", 2, "downloadFile failed: " + parambhhf.b + " code=" + parambhhf.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipf
 * JD-Core Version:    0.7.0.1
 */