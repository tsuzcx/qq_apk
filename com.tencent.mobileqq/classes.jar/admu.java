import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.qphone.base.util.QLog;

public class admu
  extends asim
{
  public admu(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onBandIntimateRelationship");
    }
    PermisionPrivacyActivity.a(this.a);
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramString, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "onDisbandIntimateRelationship");
    }
    PermisionPrivacyActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     admu
 * JD-Core Version:    0.7.0.1
 */