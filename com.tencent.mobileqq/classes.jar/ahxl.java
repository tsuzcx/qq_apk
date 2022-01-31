import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class ahxl
  implements QQPermissionCallback
{
  ahxl(ahww paramahww) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion denied sd grant");
    bdgm.a(ahww.a(this.a), new ahxm(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion user grant");
    ahww.a(this.a, ahww.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxl
 * JD-Core Version:    0.7.0.1
 */