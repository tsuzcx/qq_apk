import android.app.Activity;
import android.content.Context;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.ocr.SearchQuestionCameraFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class aggh
  implements Runnable
{
  public aggh(SearchQuestionCameraFragment paramSearchQuestionCameraFragment, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqOcrSearchQuestionCameraFragment.getActivity();
    if (localObject == null) {}
    do
    {
      return;
      QLog.e("SearchQuestionFragment", 2, "onCameraStarted error = " + this.jdField_a_of_type_JavaLangString);
      String str = ((Activity)localObject).getString(2131428347);
      localObject = DialogUtil.a((Context)localObject, 230).setMessage(str).setPositiveButton(((Activity)localObject).getString(2131428346), new aggi(this, (Activity)localObject));
      try
      {
        ((QQCustomDialog)localObject).setCancelable(false);
        ((QQCustomDialog)localObject).show();
        return;
      }
      catch (WindowManager.BadTokenException localBadTokenException) {}
    } while (!QLog.isColorLevel());
    QLog.i("SearchQuestionFragment", 2, "", localBadTokenException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aggh
 * JD-Core Version:    0.7.0.1
 */