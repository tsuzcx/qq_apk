import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class afba
  extends bbwf
{
  afba(afaz paramafaz, String paramString1, String paramString2) {}
  
  public void onCancel(bbwg parambbwg)
  {
    afaz.a(this.jdField_a_of_type_Afaz).remove(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(bbwg parambbwg)
  {
    afaz.a(this.jdField_a_of_type_Afaz).remove(this.jdField_a_of_type_JavaLangString);
    if (parambbwg.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "download finished " + this.b);
      }
      if ((this.b != null) && (afaz.a(this.jdField_a_of_type_Afaz) != null) && (this.b.equals(afaz.a(this.jdField_a_of_type_Afaz).starVideo))) {
        afaz.b(this.jdField_a_of_type_Afaz);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      afaz.a(this.jdField_a_of_type_Afaz);
      return;
    }
    QLog.d("BlessManager", 2, "downloadFile failed: " + parambbwg.b + " code=" + parambbwg.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afba
 * JD-Core Version:    0.7.0.1
 */