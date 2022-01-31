import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class agyd
  extends bdvu
{
  agyd(agyc paramagyc, String paramString1, String paramString2) {}
  
  public void onCancel(bdvv parambdvv)
  {
    agyc.a(this.jdField_a_of_type_Agyc).remove(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(bdvv parambdvv)
  {
    agyc.a(this.jdField_a_of_type_Agyc).remove(this.jdField_a_of_type_JavaLangString);
    if (parambdvv.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "download finished " + this.b);
      }
      if ((this.b != null) && (agyc.a(this.jdField_a_of_type_Agyc) != null) && (this.b.equals(agyc.a(this.jdField_a_of_type_Agyc).starVideo))) {
        agyc.b(this.jdField_a_of_type_Agyc);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      agyc.a(this.jdField_a_of_type_Agyc);
      return;
    }
    QLog.d("BlessManager", 2, "downloadFile failed: " + parambdvv.b + " code=" + parambdvv.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyd
 * JD-Core Version:    0.7.0.1
 */