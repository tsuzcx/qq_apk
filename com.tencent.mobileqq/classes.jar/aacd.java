import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aacd
  implements bavt
{
  private final WeakReference<aabz> a;
  
  aacd(aabz paramaabz)
  {
    this.a = new WeakReference(paramaabz);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      if (QLog.isColorLevel()) {
        QLog.i("AutoLoginHelper", 2, "CheckRegisterLiangHao.RequestCallBack not called in main thread !!!");
      }
    }
    aabz localaabz;
    do
    {
      return;
      localaabz = (aabz)this.a.get();
    } while (localaabz == null);
    localaabz.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aacd
 * JD-Core Version:    0.7.0.1
 */