import android.os.Build.VERSION;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acsi
  implements CompoundButton.OnCheckedChangeListener
{
  public acsi(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject;
    if (!NetworkUtil.isNetSupport(this.a))
    {
      AssistantSettingActivity.a(this.a, 2131694108, 1);
      localObject = this.a;
      if (!paramBoolean) {}
      for (;;)
      {
        AssistantSettingActivity.b((AssistantSettingActivity)localObject, bool, this);
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        bool = false;
      }
    }
    int i;
    if (paramBoolean)
    {
      azge.a(this.a.app, true);
      azhh.a().a(true);
      bcef.b(null, "dc00898", "", "", "0X800B44F", "0X800B44F", 1, 0, "", "", "", "");
      azeu.a("HelloQQWake", "qVoiceAssistantCkb change isChecked:" + paramBoolean);
      if ((Build.VERSION.SDK_INT < 23) || (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") == 0))
      {
        i = 1;
        label147:
        bool = FloatingScreenPermission.checkPermission(BaseApplicationImpl.getContext());
        localObject = new acsj(this);
        if ((i == 0) || (!bool)) {
          break label203;
        }
        azhh.a().a(this.a, "AssistantSettingActivity", (azhn)localObject);
      }
    }
    for (;;)
    {
      AssistantSettingActivity.a(this.a);
      break;
      i = 0;
      break label147;
      label203:
      if (i == 0) {
        this.a.requestPermissions(new acsk(this, (azhn)localObject), 1, new String[] { "android.permission.RECORD_AUDIO" });
      }
      if (!bool)
      {
        FloatingScreenPermission.requestPermission(this.a);
        continue;
        azge.a(this.a.app, false);
        azhh.a().a(false);
        azhh.a().b("AssistantSettingActivity");
        bcef.b(null, "dc00898", "", "", "0X800B44F", "0X800B44F", 2, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsi
 * JD-Core Version:    0.7.0.1
 */