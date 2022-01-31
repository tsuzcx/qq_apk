import android.app.Activity;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ahxn
  extends nac
{
  ahxn(ahww paramahww) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction checkOpenidDiff errorCode =" + paramInt);
    if ((ahww.a(this.a).isFinishing()) || (this.a.a))
    {
      QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction activity finishing or timeout");
      return;
    }
    this.a.c();
    if (ahww.a(this.a) != null) {
      ahww.a(this.a).removeCallbacks(ahww.b(this.a));
    }
    if (paramInt == 16)
    {
      this.a.d();
      return;
    }
    ahww.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxn
 * JD-Core Version:    0.7.0.1
 */