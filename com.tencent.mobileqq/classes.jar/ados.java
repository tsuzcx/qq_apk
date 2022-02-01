import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ados
  implements bhjn
{
  private final WeakReference<adoo> a;
  
  ados(adoo paramadoo)
  {
    this.a = new WeakReference(paramadoo);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      if (QLog.isColorLevel()) {
        QLog.i("AutoLoginHelper", 2, "CheckRegisterLiangHao.RequestCallBack not called in main thread !!!");
      }
    }
    adoo localadoo;
    do
    {
      return;
      localadoo = (adoo)this.a.get();
    } while (localadoo == null);
    localadoo.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ados
 * JD-Core Version:    0.7.0.1
 */