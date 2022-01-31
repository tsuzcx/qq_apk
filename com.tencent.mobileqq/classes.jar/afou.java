import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ocr.SearchQuestionCameraFragment;
import com.tencent.qphone.base.util.QLog;

public class afou
  implements DialogInterface.OnDismissListener
{
  public afou(SearchQuestionCameraFragment paramSearchQuestionCameraFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    SearchQuestionCameraFragment.a(this.a, -1);
    if (QLog.isColorLevel()) {
      QLog.d("SearchQuestionFragment", 2, "mProgressDialog dismiss");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afou
 * JD-Core Version:    0.7.0.1
 */