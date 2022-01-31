import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity.GetClassChoiceCallBack.1;
import com.tencent.qphone.base.util.QLog;

public class abwd
  implements azrl
{
  public abwd(TroopClassChoiceActivity paramTroopClassChoiceActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.a = azrj.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getContext(), TroopClassChoiceActivity.a(this.a));
      this.a.runOnUiThread(new TroopClassChoiceActivity.GetClassChoiceCallBack.1(this));
      return;
    }
    QLog.e("IphoneTitleBarActivity", 1, "getClassChoiceFromServer failed!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abwd
 * JD-Core Version:    0.7.0.1
 */