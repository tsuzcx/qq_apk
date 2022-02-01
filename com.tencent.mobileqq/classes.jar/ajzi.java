import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class ajzi
  implements QQPermissionCallback
{
  ajzi(ajyt paramajyt) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion denied sd grant");
    bhlq.a(ajyt.a(this.a), new ajzj(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("SDKEmotionSettingManager", 1, "setEmotion user grant");
    ajyt.a(this.a, ajyt.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzi
 * JD-Core Version:    0.7.0.1
 */