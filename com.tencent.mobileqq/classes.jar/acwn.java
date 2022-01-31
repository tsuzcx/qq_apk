import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class acwn
  implements bdzz
{
  private WeakReference<asot> a;
  
  public acwn(asot paramasot)
  {
    this.a = new WeakReference(paramasot);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      asot localasot = (asot)this.a.get();
      if (localasot != null) {
        localasot.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "check friend's profile and preload web-process!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acwn
 * JD-Core Version:    0.7.0.1
 */