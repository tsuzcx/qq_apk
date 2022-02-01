import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class ajao
  extends biht
{
  ajao(ajan paramajan, String paramString1, String paramString2) {}
  
  public void onCancel(bihu parambihu)
  {
    ajan.a(this.jdField_a_of_type_Ajan).remove(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(bihu parambihu)
  {
    ajan.a(this.jdField_a_of_type_Ajan).remove(this.jdField_a_of_type_JavaLangString);
    if (parambihu.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "download finished " + this.b);
      }
      if ((this.b != null) && (ajan.a(this.jdField_a_of_type_Ajan) != null) && (this.b.equals(ajan.a(this.jdField_a_of_type_Ajan).starVideo))) {
        ajan.b(this.jdField_a_of_type_Ajan);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      ajan.a(this.jdField_a_of_type_Ajan);
      return;
    }
    QLog.d("BlessManager", 2, "downloadFile failed: " + parambihu.b + " code=" + parambihu.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajao
 * JD-Core Version:    0.7.0.1
 */