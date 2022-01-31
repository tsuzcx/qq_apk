import android.widget.EditText;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;

public class ajgw
  implements Runnable
{
  public ajgw(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void run()
  {
    EditText localEditText = PublishHomeWorkFragment.a(this.a, PublishHomeWorkFragment.a(this.a));
    if (QLog.isColorLevel()) {
      QLog.d("PublishHomeWorkFragment", 2, "弹起键盘");
    }
    if (localEditText != null) {
      InputMethodUtil.a(localEditText);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgw
 * JD-Core Version:    0.7.0.1
 */