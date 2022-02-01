import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class adlf
  implements biav
{
  private final WeakReference<adlb> a;
  
  adlf(adlb paramadlb)
  {
    this.a = new WeakReference(paramadlb);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      if (QLog.isColorLevel()) {
        QLog.i("AutoLoginHelper", 2, "CheckRegisterLiangHao.RequestCallBack not called in main thread !!!");
      }
    }
    adlb localadlb;
    do
    {
      return;
      localadlb = (adlb)this.a.get();
    } while (localadlb == null);
    localadlb.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adlf
 * JD-Core Version:    0.7.0.1
 */