import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ambr
  extends allb
{
  ambr(ambq paramambq) {}
  
  protected void onGetSelfAddFriendSetting(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "onGetSelfAddFriendSetting() addFriendSetting is:" + paramInt);
    }
    ambq.a(this.a, ambq.a(this.a, paramInt));
    if ((ambq.a(this.a)) && (ambq.a(this.a) != null)) {
      this.a.b(ambq.a(this.a).c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambr
 * JD-Core Version:    0.7.0.1
 */