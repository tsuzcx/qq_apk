import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class afay
  extends bbwt
{
  afay(afax paramafax, String paramString1, String paramString2) {}
  
  public void onCancel(bbwu parambbwu)
  {
    afax.a(this.jdField_a_of_type_Afax).remove(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(bbwu parambbwu)
  {
    afax.a(this.jdField_a_of_type_Afax).remove(this.jdField_a_of_type_JavaLangString);
    if (parambbwu.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "download finished " + this.b);
      }
      if ((this.b != null) && (afax.a(this.jdField_a_of_type_Afax) != null) && (this.b.equals(afax.a(this.jdField_a_of_type_Afax).starVideo))) {
        afax.b(this.jdField_a_of_type_Afax);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      afax.a(this.jdField_a_of_type_Afax);
      return;
    }
    QLog.d("BlessManager", 2, "downloadFile failed: " + parambbwu.b + " code=" + parambbwu.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afay
 * JD-Core Version:    0.7.0.1
 */