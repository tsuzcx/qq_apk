import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ajid
  extends anuw
{
  ajid(ajic paramajic) {}
  
  protected void onGetSelfAddFriendSetting(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "onGetSelfAddFriendSetting() addFriendSetting is:" + paramInt);
    }
    ajic.a(this.a, ajic.a(this.a, paramInt));
    if ((ajic.a(this.a)) && (ajic.a(this.a) != null)) {
      this.a.b(ajic.a(this.a).c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajid
 * JD-Core Version:    0.7.0.1
 */