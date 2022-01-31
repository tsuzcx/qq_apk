import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mobileqq.richmedia.capture.fragment.ArithmeticCameraCaptureFragment;

public class agtv
  implements View.OnKeyListener
{
  private agtv(ArithmeticCameraCaptureFragment paramArithmeticCameraCaptureFragment) {}
  
  public void a()
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (localFragmentActivity != null)
    {
      this.a.getActivity().finish();
      localFragmentActivity.overridePendingTransition(2131034165, 2131034328);
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
      switch (paramKeyEvent.getAction())
      {
      case 0: 
      default: 
        break;
      case 1: 
        bool1 = bool2;
      }
    } while (paramKeyEvent.isCanceled());
    a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agtv
 * JD-Core Version:    0.7.0.1
 */