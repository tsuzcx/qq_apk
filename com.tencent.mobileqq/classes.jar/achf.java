import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class achf
  implements becl
{
  private final WeakReference<achb> a;
  
  achf(achb paramachb)
  {
    this.a = new WeakReference(paramachb);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      if (QLog.isColorLevel()) {
        QLog.i("AutoLoginHelper", 2, "CheckRegisterLiangHao.RequestCallBack not called in main thread !!!");
      }
    }
    achb localachb;
    do
    {
      return;
      localachb = (achb)this.a.get();
    } while (localachb == null);
    localachb.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     achf
 * JD-Core Version:    0.7.0.1
 */