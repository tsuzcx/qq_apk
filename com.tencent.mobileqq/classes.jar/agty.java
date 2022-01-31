import android.app.Activity;
import android.content.Context;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.richmedia.capture.fragment.CameraCaptureFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class agty
  implements Runnable
{
  public agty(CameraCaptureFragment paramCameraCaptureFragment, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCameraCaptureFragment.getActivity();
    if (localObject == null) {}
    do
    {
      for (;;)
      {
        return;
        QLog.e("CameraCaptureFragment", 2, "onCameraStarted error = " + this.jdField_a_of_type_JavaLangString);
        String str = ((Activity)localObject).getString(2131428347);
        localObject = DialogUtil.a((Context)localObject, 230).setMessage(str).setPositiveButton(((Activity)localObject).getString(2131428346), new agtz(this, (Activity)localObject));
        try
        {
          ((QQCustomDialog)localObject).setCancelable(false);
          if (!CameraCaptureFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCameraCaptureFragment))
          {
            ((QQCustomDialog)localObject).show();
            CameraCaptureFragment.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentCameraCaptureFragment, true);
            return;
          }
        }
        catch (WindowManager.BadTokenException localBadTokenException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("CameraCaptureFragment", 2, "", localBadTokenException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agty
 * JD-Core Version:    0.7.0.1
 */