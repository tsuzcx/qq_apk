import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

public class adxr
  extends nmf
{
  public adxr(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if ((this.a.isFinishing()) || (this.a.m)) {}
    do
    {
      do
      {
        return;
        this.a.p();
        if (this.a.b != null) {
          this.a.b.removeCallbacksAndMessages(null);
        }
        if ((!paramBoolean) || (paramOpenID == null) || (paramOpenID.openID == null)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "openIdObserver success");
        }
      } while (paramOpenID.openID.equals(this.a.e));
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "-->onGetOpenId--openid doesn't equal current openid");
      }
      this.a.s();
      return;
    } while (!QLog.isColorLevel());
    QLog.d("Q.chatopttroop", 2, "openIdObserver fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxr
 * JD-Core Version:    0.7.0.1
 */