import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.fragment.CameraCaptureFragment;
import com.tencent.mobileqq.widget.QQToast;

public class ague
  implements Runnable
{
  public ague(CameraCaptureFragment paramCameraCaptureFragment, int paramInt) {}
  
  public void run()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
    case 101: 
    case 104: 
      FragmentActivity localFragmentActivity;
      do
      {
        return;
        QQToast.a(BaseApplicationImpl.getApplication(), "录制出现异常，请重试", 1).a();
        localFragmentActivity = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCameraCaptureFragment.getActivity();
      } while ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()));
      localFragmentActivity.finish();
      return;
    case 102: 
      QQToast.a(BaseApplicationImpl.getContext(), "拍摄时间过短，请重新拍摄。", 0).a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCameraCaptureFragment.K_();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), "拍照出现异常，请重试", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ague
 * JD-Core Version:    0.7.0.1
 */