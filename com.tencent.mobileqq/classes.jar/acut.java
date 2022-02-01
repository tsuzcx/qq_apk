import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class acut
  implements bgql
{
  private final WeakReference<acup> a;
  
  acut(acup paramacup)
  {
    this.a = new WeakReference(paramacup);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      if (QLog.isColorLevel()) {
        QLog.i("AutoLoginHelper", 2, "CheckRegisterLiangHao.RequestCallBack not called in main thread !!!");
      }
    }
    acup localacup;
    do
    {
      return;
      localacup = (acup)this.a.get();
    } while (localacup == null);
    localacup.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acut
 * JD-Core Version:    0.7.0.1
 */