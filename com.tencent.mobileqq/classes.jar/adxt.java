import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class adxt
  implements bikc
{
  private final WeakReference<adxp> a;
  
  adxt(adxp paramadxp)
  {
    this.a = new WeakReference(paramadxp);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      if (QLog.isColorLevel()) {
        QLog.i("AutoLoginHelper", 2, "CheckRegisterLiangHao.RequestCallBack not called in main thread !!!");
      }
    }
    adxp localadxp;
    do
    {
      return;
      localadxp = (adxp)this.a.get();
    } while (localadxp == null);
    localadxp.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxt
 * JD-Core Version:    0.7.0.1
 */