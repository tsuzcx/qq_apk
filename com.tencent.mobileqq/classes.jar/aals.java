import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aals
  implements bbzb
{
  private final WeakReference<aalo> a;
  
  aals(aalo paramaalo)
  {
    this.a = new WeakReference(paramaalo);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      if (QLog.isColorLevel()) {
        QLog.i("AutoLoginHelper", 2, "CheckRegisterLiangHao.RequestCallBack not called in main thread !!!");
      }
    }
    aalo localaalo;
    do
    {
      return;
      localaalo = (aalo)this.a.get();
    } while (localaalo == null);
    localaalo.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aals
 * JD-Core Version:    0.7.0.1
 */