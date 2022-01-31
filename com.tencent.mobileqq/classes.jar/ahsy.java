import android.app.Activity;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ahsy
  extends nac
{
  ahsy(ahsh paramahsh) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction checkOpenidDiff errorCode =" + paramInt);
    if ((ahsh.a(this.a).isFinishing()) || (this.a.a))
    {
      QLog.i("SDKEmotionSettingManager", 1, " checkJumpAction activity finishing or timeout");
      return;
    }
    this.a.c();
    if (ahsh.a(this.a) != null) {
      ahsh.a(this.a).removeCallbacks(ahsh.b(this.a));
    }
    if (paramInt == 16)
    {
      this.a.d();
      return;
    }
    ahsh.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsy
 * JD-Core Version:    0.7.0.1
 */