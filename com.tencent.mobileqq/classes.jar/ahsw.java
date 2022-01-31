import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class ahsw
  implements QQPermissionCallback
{
  ahsw(ahsh paramahsh) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion denied sd grant");
    bdcd.a(ahsh.a(this.a), new ahsx(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion user grant");
    ahsh.a(this.a, ahsh.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsw
 * JD-Core Version:    0.7.0.1
 */