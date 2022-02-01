import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class ahuy
  extends bgod
{
  ahuy(ahux paramahux, String paramString1, String paramString2) {}
  
  public void onCancel(bgoe parambgoe)
  {
    ahux.a(this.jdField_a_of_type_Ahux).remove(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(bgoe parambgoe)
  {
    ahux.a(this.jdField_a_of_type_Ahux).remove(this.jdField_a_of_type_JavaLangString);
    if (parambgoe.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "download finished " + this.b);
      }
      if ((this.b != null) && (ahux.a(this.jdField_a_of_type_Ahux) != null) && (this.b.equals(ahux.a(this.jdField_a_of_type_Ahux).starVideo))) {
        ahux.b(this.jdField_a_of_type_Ahux);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      ahux.a(this.jdField_a_of_type_Ahux);
      return;
    }
    QLog.d("BlessManager", 2, "downloadFile failed: " + parambgoe.b + " code=" + parambgoe.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahuy
 * JD-Core Version:    0.7.0.1
 */