import com.tencent.mobileqq.activity.bless.BlessTask;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class ahcs
  extends bead
{
  ahcs(ahcr paramahcr, String paramString1, String paramString2) {}
  
  public void onCancel(beae parambeae)
  {
    ahcr.a(this.jdField_a_of_type_Ahcr).remove(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDone(beae parambeae)
  {
    ahcr.a(this.jdField_a_of_type_Ahcr).remove(this.jdField_a_of_type_JavaLangString);
    if (parambeae.a() == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessManager", 2, "download finished " + this.b);
      }
      if ((this.b != null) && (ahcr.a(this.jdField_a_of_type_Ahcr) != null) && (this.b.equals(ahcr.a(this.jdField_a_of_type_Ahcr).starVideo))) {
        ahcr.b(this.jdField_a_of_type_Ahcr);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      ahcr.a(this.jdField_a_of_type_Ahcr);
      return;
    }
    QLog.d("BlessManager", 2, "downloadFile failed: " + parambeae.b + " code=" + parambeae.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcs
 * JD-Core Version:    0.7.0.1
 */