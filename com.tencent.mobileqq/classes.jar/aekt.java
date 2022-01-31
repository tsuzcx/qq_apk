import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.qphone.base.util.QLog;

public class aekt
  extends TroopObserver
{
  public aekt(LoginWelcomeManager paramLoginWelcomeManager) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (paramBoolean)
    {
      paramString = LoginWelcomeManager.a(this.a).getBundle("request");
      paramString.putString("uin", String.valueOf(paramLong));
      paramString.putShort("option", paramTroopInfo.cGroupOption);
      paramString.putString("name", paramTroopInfo.troopname);
      if ((paramTroopInfo.cGroupOption != 4) && (paramTroopInfo.cGroupOption != 5)) {
        break label114;
      }
      paramString.putString("answer", paramTroopInfo.joinTroopAnswer);
      paramString.putString("question", paramTroopInfo.joinTroopQuestion);
    }
    for (;;)
    {
      this.a.b();
      LoginWelcomeManager.a(this.a).removeObserver(this);
      return;
      label114:
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "onOIDB0X88D_1_Ret err");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekt
 * JD-Core Version:    0.7.0.1
 */