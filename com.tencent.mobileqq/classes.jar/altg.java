import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public final class altg
  implements awdn
{
  private WeakReference<FrameHelperActivity> a;
  
  public altg(FrameHelperActivity paramFrameHelperActivity)
  {
    this.a = new WeakReference(paramFrameHelperActivity);
  }
  
  public void a()
  {
    FrameHelperActivity localFrameHelperActivity = (FrameHelperActivity)this.a.get();
    if (localFrameHelperActivity == null) {}
    FragmentActivity localFragmentActivity;
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        localFragmentActivity = localFrameHelperActivity.getActivity();
      } while ((localFragmentActivity == null) || (localFragmentActivity.getAppInterface() == null));
      localQQAppInterface = localFragmentActivity.app;
    } while ((!awia.a().a(localQQAppInterface, localFragmentActivity)) || ((FrameHelperActivity.a(localFrameHelperActivity) != null) && (FrameHelperActivity.a(localFrameHelperActivity).isShowing())));
    FrameHelperActivity.a(localFrameHelperActivity, localQQAppInterface, localFragmentActivity);
    azqs.b(localQQAppInterface, "dc00898", "", "", "0X800A00D", "0X800A00D", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     altg
 * JD-Core Version:    0.7.0.1
 */