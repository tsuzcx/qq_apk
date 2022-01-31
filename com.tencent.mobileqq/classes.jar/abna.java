import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class abna
  implements QQPermissionCallback
{
  abna(abmz paramabmz) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("QQSettingRedesign", 1, "User requestPermissions denied...");
    babr.a(this.a.a.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("QQSettingRedesign", 1, "User requestPermissions grant...");
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abna
 * JD-Core Version:    0.7.0.1
 */