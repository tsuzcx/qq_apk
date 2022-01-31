import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class abfn
  implements bcay
{
  private WeakReference<aqyf> a;
  
  public abfn(aqyf paramaqyf)
  {
    this.a = new WeakReference(paramaqyf);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      aqyf localaqyf = (aqyf)this.a.get();
      if (localaqyf != null) {
        localaqyf.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "check friend's profile and preload web-process!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abfn
 * JD-Core Version:    0.7.0.1
 */