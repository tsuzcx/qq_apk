import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class adoh
  implements QQPermissionCallback
{
  adoh(adog paramadog) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("QQSettingRedesign", 1, "User requestPermissions denied...");
    bdcd.a(this.a.a.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("QQSettingRedesign", 1, "User requestPermissions grant...");
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adoh
 * JD-Core Version:    0.7.0.1
 */