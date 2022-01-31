import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.fragment.CameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ahmv
  implements Runnable
{
  public ahmv(CameraCaptureFragment paramCameraCaptureFragment, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult) {}
  
  public void run()
  {
    QLog.d("CameraCaptureFragment", 2, "onVideoCaptured. videoFrameCount = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount + " ; minFrameCount = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCameraCaptureFragment.b);
    QQToast.a(BaseApplicationImpl.getContext(), "拍摄时间过短，请重新拍摄。", 0).a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCameraCaptureFragment.z_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahmv
 * JD-Core Version:    0.7.0.1
 */