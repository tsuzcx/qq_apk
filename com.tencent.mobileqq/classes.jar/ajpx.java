import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class ajpx
  implements QQPermissionCallback
{
  ajpx(ajpi paramajpi) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion denied sd grant");
    bhdj.a(ajpi.a(this.a), new ajpy(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion user grant");
    ajpi.a(this.a, ajpi.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpx
 * JD-Core Version:    0.7.0.1
 */