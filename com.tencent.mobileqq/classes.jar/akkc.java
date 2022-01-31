import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class akkc
  extends ajtq
{
  akkc(akkb paramakkb) {}
  
  protected void onGetSelfAddFriendSetting(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "onGetSelfAddFriendSetting() addFriendSetting is:" + paramInt);
    }
    akkb.a(this.a, akkb.a(this.a, paramInt));
    if ((akkb.a(this.a)) && (akkb.a(this.a) != null)) {
      this.a.b(akkb.a(this.a).c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akkc
 * JD-Core Version:    0.7.0.1
 */