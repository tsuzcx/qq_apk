import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.nearby.now.send.SmallVideoSendFragment;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public class aehl
  implements Runnable
{
  public aehl(SmallVideoSendFragment paramSmallVideoSendFragment) {}
  
  public void run()
  {
    if ((this.a.getActivity() == null) || (this.a.getActivity().isFinishing())) {
      if (QLog.isColorLevel()) {
        QLog.w("PublishActivity", 2, "Activity has been destroy.");
      }
    }
    while (this.a.a == null) {
      return;
    }
    this.a.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aehl
 * JD-Core Version:    0.7.0.1
 */