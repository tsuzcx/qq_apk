import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class aiui
  implements QQPermissionCallback
{
  aiui(aitt paramaitt) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion denied sd grant");
    bfur.a(aitt.a(this.a), new aiuj(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion user grant");
    aitt.a(this.a, aitt.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiui
 * JD-Core Version:    0.7.0.1
 */