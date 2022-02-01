import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acsn
  implements View.OnClickListener
{
  public acsn(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(View paramView)
  {
    if ((Build.VERSION.SDK_INT < 23) || (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") == 0)) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = FloatingScreenPermission.checkPermission(BaseApplicationImpl.getContext());
      if (i == 0) {
        this.a.requestPermissions(new acso(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
      }
      if (!bool) {
        FloatingScreenPermission.requestPermission(this.a);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsn
 * JD-Core Version:    0.7.0.1
 */