import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class akkb
  extends ajto
{
  akkb(akka paramakka) {}
  
  protected void onGetSelfAddFriendSetting(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "onGetSelfAddFriendSetting() addFriendSetting is:" + paramInt);
    }
    akka.a(this.a, akka.a(this.a, paramInt));
    if ((akka.a(this.a)) && (akka.a(this.a) != null)) {
      this.a.b(akka.a(this.a).c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akkb
 * JD-Core Version:    0.7.0.1
 */