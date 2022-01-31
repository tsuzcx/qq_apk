import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class akzm
  implements QQPermissionCallback
{
  akzm(akzl paramakzl) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbcv.a(akzl.a(this.a), paramArrayOfString, paramArrayOfInt);
    QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION deny");
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION allow restart it");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akzm
 * JD-Core Version:    0.7.0.1
 */