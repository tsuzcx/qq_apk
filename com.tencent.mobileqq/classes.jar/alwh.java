import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class alwh
  implements aufw
{
  alwh(alwd paramalwd) {}
  
  public void a(int paramInt)
  {
    boolean bool1 = alwd.b(this.a);
    alwd.a(this.a, false);
    boolean bool2 = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager", 2, "onBindStateChanged last:" + bool1 + "  now:" + bool2);
    }
    if (bool1 != bool2) {
      ((FriendListHandler)alwd.a(this.a).a(1)).notifyUI(92, true, null);
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b(int paramInt) {}
  
  public void c(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alwh
 * JD-Core Version:    0.7.0.1
 */