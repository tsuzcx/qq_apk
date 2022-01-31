import android.widget.EditText;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;

public class ajhu
  implements Runnable
{
  public ajhu(SubmitHomeWorkFragment paramSubmitHomeWorkFragment) {}
  
  public void run()
  {
    EditText localEditText = SubmitHomeWorkFragment.a(this.a, SubmitHomeWorkFragment.a(this.a));
    if (QLog.isColorLevel()) {
      QLog.d("SubmitHomeWorkFragment", 2, "弹起键盘");
    }
    if (localEditText != null) {
      InputMethodUtil.a(localEditText);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhu
 * JD-Core Version:    0.7.0.1
 */