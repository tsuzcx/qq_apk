import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aiwu
  extends aniz
{
  aiwu(aiwt paramaiwt) {}
  
  protected void onGetSelfAddFriendSetting(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "onGetSelfAddFriendSetting() addFriendSetting is:" + paramInt);
    }
    aiwt.a(this.a, aiwt.a(this.a, paramInt));
    if ((aiwt.a(this.a)) && (aiwt.a(this.a) != null)) {
      this.a.b(aiwt.a(this.a).c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwu
 * JD-Core Version:    0.7.0.1
 */