import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ajvs
  extends ajfo
{
  ajvs(ajvr paramajvr) {}
  
  protected void onGetSelfAddFriendSetting(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.manager", 2, "onGetSelfAddFriendSetting() addFriendSetting is:" + paramInt);
    }
    ajvr.a(this.a, ajvr.a(this.a, paramInt));
    if ((ajvr.a(this.a)) && (ajvr.a(this.a) != null)) {
      this.a.b(ajvr.a(this.a).c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajvs
 * JD-Core Version:    0.7.0.1
 */