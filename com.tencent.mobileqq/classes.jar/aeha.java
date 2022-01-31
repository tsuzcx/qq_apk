import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout.CaptureButtonListenerInterceptor;
import com.tencent.mobileqq.widget.QQToast;

public class aeha
  implements CameraCaptureButtonLayout.CaptureButtonListenerInterceptor
{
  public aeha(SmallVideoCameraCaptureFragment paramSmallVideoCameraCaptureFragment) {}
  
  public boolean a()
  {
    if (!SmallVideoCameraCaptureFragment.a(this.a)) {
      QQToast.a(this.a.getActivity(), 1, SmallVideoCameraCaptureFragment.a(this.a), 0).a();
    }
    return SmallVideoCameraCaptureFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeha
 * JD-Core Version:    0.7.0.1
 */