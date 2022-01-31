import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aalw
  implements bbyn
{
  private final WeakReference<aals> a;
  
  aalw(aals paramaals)
  {
    this.a = new WeakReference(paramaals);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      if (QLog.isColorLevel()) {
        QLog.i("AutoLoginHelper", 2, "CheckRegisterLiangHao.RequestCallBack not called in main thread !!!");
      }
    }
    aals localaals;
    do
    {
      return;
      localaals = (aals)this.a.get();
    } while (localaals == null);
    localaals.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aalw
 * JD-Core Version:    0.7.0.1
 */