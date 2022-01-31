import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aavv
  implements baxq
{
  private WeakReference<aqeb> a;
  
  public aavv(aqeb paramaqeb)
  {
    this.a = new WeakReference(paramaqeb);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      aqeb localaqeb = (aqeb)this.a.get();
      if (localaqeb != null) {
        localaqeb.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "check friend's profile and preload web-process!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aavv
 * JD-Core Version:    0.7.0.1
 */