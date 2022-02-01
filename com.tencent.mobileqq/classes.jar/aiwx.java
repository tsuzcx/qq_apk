import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CSettingFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class aiwx
  implements adap
{
  public aiwx(ChatHistoryC2CSettingFragment paramChatHistoryC2CSettingFragment) {}
  
  public void a(Activity paramActivity)
  {
    QQToast.a(paramActivity, 2, 2131691367, 0).b(this.a.getActivity().getTitleBarHeight());
    paramActivity.setResult(-1);
    paramActivity.finish();
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 0) {
      bcef.b(paramQQAppInterface, "dc00898", "", "", "0X800A17D", "0X800A17D", 2, 0, "", "", "", "");
    }
    while (paramInt != 1) {
      return;
    }
    bcef.b(paramQQAppInterface, "dc00898", "", "", "0X800A17F", "0X800A17F", 2, 0, "", "", "", "");
  }
  
  public void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 0) {
      bcef.b(paramQQAppInterface, "dc00898", "", "", "0X800A17E", "0X800A17E", 2, 0, "", "", "", "");
    }
    while (paramInt != 1) {
      return;
    }
    bcef.b(paramQQAppInterface, "dc00898", "", "", "0X800A180", "0X800A180", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwx
 * JD-Core Version:    0.7.0.1
 */