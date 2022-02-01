import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aicm
  extends CardObserver
{
  aicm(aicl paramaicl) {}
  
  public void onGetSelfAddFriendSetting(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "onGetSelfAddFriendSetting() addFriendSetting is:" + paramInt);
    }
    aicl.a(this.a, aicl.a(this.a, paramInt));
    if ((aicl.a(this.a)) && (aicl.a(this.a) != null)) {
      this.a.b(aicl.a(this.a).getCurrentUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicm
 * JD-Core Version:    0.7.0.1
 */