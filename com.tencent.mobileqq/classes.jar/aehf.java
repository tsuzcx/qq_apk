import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;

public class aehf
  implements View.OnKeyListener
{
  private aehf(SmallVideoCameraCaptureFragment paramSmallVideoCameraCaptureFragment) {}
  
  public void a()
  {
    SLog.d("story.publish.CaptureFragment", "onBackPressed");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aehf
 * JD-Core Version:    0.7.0.1
 */