import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class ajnz
  implements QQPermissionCallback
{
  ajnz(ajnk paramajnk) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion denied sd grant");
    bglp.a(ajnk.a(this.a), new ajoa(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion user grant");
    ajnk.a(this.a, ajnk.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnz
 * JD-Core Version:    0.7.0.1
 */