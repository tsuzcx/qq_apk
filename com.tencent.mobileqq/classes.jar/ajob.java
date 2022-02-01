import android.app.Activity;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ajob
  extends niv
{
  ajob(ajnk paramajnk) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction checkOpenidDiff errorCode =" + paramInt);
    if ((ajnk.a(this.a).isFinishing()) || (this.a.a))
    {
      QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction activity finishing or timeout");
      return;
    }
    this.a.c();
    if (ajnk.a(this.a) != null) {
      ajnk.a(this.a).removeCallbacks(ajnk.b(this.a));
    }
    if (paramInt == 16)
    {
      this.a.d();
      return;
    }
    ajnk.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajob
 * JD-Core Version:    0.7.0.1
 */