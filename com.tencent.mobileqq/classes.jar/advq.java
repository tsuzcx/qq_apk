import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class advq
  implements CompoundButton.OnCheckedChangeListener
{
  public advq(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    if (!paramCompoundButton.isPressed())
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = "open_storyset";
      label27:
      yup.a("dynamic_more", (String)localObject, 0, 0, new String[0]);
      localObject = new Integer[5];
      localObject[0] = Integer.valueOf(1);
      if (!paramBoolean) {
        break label125;
      }
    }
    label125:
    for (int i = 1;; i = 0)
    {
      localObject[3] = Integer.valueOf(i);
      this.a.app.a().a((Integer[])localObject);
      localObject = (wja)this.a.app.a(98);
      i = j;
      if (paramBoolean) {
        i = 2;
      }
      ((wja)localObject).a(i);
      break;
      localObject = "close_storyset";
      break label27;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advq
 * JD-Core Version:    0.7.0.1
 */