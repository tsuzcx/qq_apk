import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class accq
  implements bdyc
{
  private final WeakReference<accm> a;
  
  accq(accm paramaccm)
  {
    this.a = new WeakReference(paramaccm);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      if (QLog.isColorLevel()) {
        QLog.i("AutoLoginHelper", 2, "CheckRegisterLiangHao.RequestCallBack not called in main thread !!!");
      }
    }
    accm localaccm;
    do
    {
      return;
      localaccm = (accm)this.a.get();
    } while (localaccm == null);
    localaccm.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     accq
 * JD-Core Version:    0.7.0.1
 */