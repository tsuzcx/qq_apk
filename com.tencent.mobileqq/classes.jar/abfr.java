import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class abfr
  implements bcak
{
  private WeakReference<aqyd> a;
  
  public abfr(aqyd paramaqyd)
  {
    this.a = new WeakReference(paramaqyd);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      aqyd localaqyd = (aqyd)this.a.get();
      if (localaqyd != null) {
        localaqyd.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "check friend's profile and preload web-process!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abfr
 * JD-Core Version:    0.7.0.1
 */