import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.QLog;

public class affx
  extends aocj
{
  public affx(QQLSActivity paramQQLSActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "PC has read onPushReadedNotify finish" + Thread.currentThread().getId());
    }
    QQLSActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     affx
 * JD-Core Version:    0.7.0.1
 */