import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class alnb
  implements View.OnTouchListener
{
  public alnb(LoginView paramLoginView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "mScrollRootView.setOnTouch action=" + paramMotionEvent.getAction() + " im:" + LoginView.a(this.a));
    }
    if ((paramMotionEvent.getAction() == 1) && (LoginView.a(this.a) != null)) {
      LoginView.a(this.a).hideSoftInputFromWindow(this.a.a.getWindow().getDecorView().getWindowToken(), 0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnb
 * JD-Core Version:    0.7.0.1
 */