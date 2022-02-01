import android.widget.TextView;
import com.tencent.mobileqq.activity.DevlockQuickLoginActivity.DevlockClosePCVerifyProxy.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class aduh
  implements baqi
{
  private WeakReference<BaseActivity> a;
  private WeakReference<TextView> b;
  
  public aduh(WeakReference<BaseActivity> paramWeakReference, WeakReference<TextView> paramWeakReference1)
  {
    if ((paramWeakReference == null) || (paramWeakReference1 == null)) {
      return;
    }
    this.a = paramWeakReference;
    this.b = paramWeakReference1;
  }
  
  private boolean a()
  {
    if ((this.a == null) || (this.b == null) || (this.a.get() == null) || (this.b.get() == null))
    {
      QLog.e("DevlockQuickLoginActivity", 1, "sanityCheckPCVerifyWrong(): params empty");
      return true;
    }
    return false;
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new DevlockQuickLoginActivity.DevlockClosePCVerifyProxy.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aduh
 * JD-Core Version:    0.7.0.1
 */