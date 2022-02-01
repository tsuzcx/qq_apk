import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aixl
  extends CardObserver
{
  aixl(aixk paramaixk) {}
  
  public void onGetSelfAddFriendSetting(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "onGetSelfAddFriendSetting() addFriendSetting is:" + paramInt);
    }
    aixk.a(this.a, aixk.a(this.a, paramInt));
    if ((aixk.a(this.a)) && (aixk.a(this.a) != null)) {
      this.a.b(aixk.a(this.a).getCurrentUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixl
 * JD-Core Version:    0.7.0.1
 */