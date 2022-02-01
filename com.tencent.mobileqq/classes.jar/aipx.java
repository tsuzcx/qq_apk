import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class aipx
  extends bhyn
{
  aipx(aipw paramaipw, String paramString1, String paramString2) {}
  
  public void onCancel(bhyo parambhyo)
  {
    aipw.a(this.jdField_a_of_type_Aipw).remove(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(bhyo parambhyo)
  {
    aipw.a(this.jdField_a_of_type_Aipw).remove(this.jdField_a_of_type_JavaLangString);
    if (parambhyo.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "download finished " + this.b);
      }
      if ((this.b != null) && (aipw.a(this.jdField_a_of_type_Aipw) != null) && (this.b.equals(aipw.a(this.jdField_a_of_type_Aipw).starVideo))) {
        aipw.b(this.jdField_a_of_type_Aipw);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      aipw.a(this.jdField_a_of_type_Aipw);
      return;
    }
    QLog.d("BlessManager", 2, "downloadFile failed: " + parambhyo.b + " code=" + parambhyo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipx
 * JD-Core Version:    0.7.0.1
 */