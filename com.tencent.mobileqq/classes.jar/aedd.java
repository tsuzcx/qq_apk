import android.os.Looper;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aedd
  implements bgql
{
  private final WeakReference<RegisterQQNumberActivity> a;
  
  public aedd(RegisterQQNumberActivity paramRegisterQQNumberActivity)
  {
    this.a = new WeakReference(paramRegisterQQNumberActivity);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
      if (QLog.isColorLevel()) {
        QLog.i("RegisterQQNumberActivity", 2, "CheckRegisterLiangHao.RequestCallBack not called in main thread !!!");
      }
    }
    RegisterQQNumberActivity localRegisterQQNumberActivity;
    do
    {
      return;
      localRegisterQQNumberActivity = (RegisterQQNumberActivity)this.a.get();
    } while (localRegisterQQNumberActivity == null);
    localRegisterQQNumberActivity.a(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedd
 * JD-Core Version:    0.7.0.1
 */