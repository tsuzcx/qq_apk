import android.app.Activity;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ajzk
  extends nkq
{
  ajzk(ajyt paramajyt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction checkOpenidDiff errorCode =" + paramInt);
    if ((ajyt.a(this.a).isFinishing()) || (this.a.a))
    {
      QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction activity finishing or timeout");
      return;
    }
    this.a.c();
    if (ajyt.a(this.a) != null) {
      ajyt.a(this.a).removeCallbacks(ajyt.b(this.a));
    }
    if (paramInt == 16)
    {
      this.a.d();
      return;
    }
    ajyt.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzk
 * JD-Core Version:    0.7.0.1
 */