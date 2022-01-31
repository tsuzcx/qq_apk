import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class aeqe
  extends batl
{
  aeqe(aeqd paramaeqd, String paramString1, String paramString2) {}
  
  public void onCancel(batm parambatm)
  {
    aeqd.a(this.jdField_a_of_type_Aeqd).remove(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(batm parambatm)
  {
    aeqd.a(this.jdField_a_of_type_Aeqd).remove(this.jdField_a_of_type_JavaLangString);
    if (parambatm.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "download finished " + this.b);
      }
      if ((this.b != null) && (aeqd.a(this.jdField_a_of_type_Aeqd) != null) && (this.b.equals(aeqd.a(this.jdField_a_of_type_Aeqd).starVideo))) {
        aeqd.b(this.jdField_a_of_type_Aeqd);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      aeqd.a(this.jdField_a_of_type_Aeqd);
      return;
    }
    QLog.d("BlessManager", 2, "downloadFile failed: " + parambatm.b + " code=" + parambatm.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aeqe
 * JD-Core Version:    0.7.0.1
 */