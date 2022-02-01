import android.app.Activity;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ajpz
  extends ntf
{
  ajpz(ajpi paramajpi) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction checkOpenidDiff errorCode =" + paramInt);
    if ((ajpi.a(this.a).isFinishing()) || (this.a.a))
    {
      QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction activity finishing or timeout");
      return;
    }
    this.a.c();
    if (ajpi.a(this.a) != null) {
      ajpi.a(this.a).removeCallbacks(ajpi.b(this.a));
    }
    if (paramInt == 16)
    {
      this.a.d();
      return;
    }
    ajpi.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajpz
 * JD-Core Version:    0.7.0.1
 */