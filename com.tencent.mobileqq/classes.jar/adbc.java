import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class adbc
  implements beei
{
  private WeakReference<astc> a;
  
  public adbc(astc paramastc)
  {
    this.a = new WeakReference(paramastc);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      astc localastc = (astc)this.a.get();
      if (localastc != null) {
        localastc.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "check friend's profile and preload web-process!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbc
 * JD-Core Version:    0.7.0.1
 */