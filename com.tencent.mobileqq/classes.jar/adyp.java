import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.QLog;

public class adyp
  extends amwl
{
  public adyp(QQLSActivity paramQQLSActivity) {}
  
  protected void onPushReadedNotify(boolean paramBoolean, Object paramObject)
  {
    super.onPushReadedNotify(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "PC has read onPushReadedNotify finish" + Thread.currentThread().getId());
    }
    QQLSActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyp
 * JD-Core Version:    0.7.0.1
 */