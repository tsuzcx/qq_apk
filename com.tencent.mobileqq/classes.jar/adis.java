import android.os.Build.VERSION;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adis
  implements CompoundButton.OnCheckedChangeListener
{
  public adis(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject;
    if (!NetworkUtil.isNetSupport(this.a))
    {
      AssistantSettingActivity.a(this.a, 2131694305, 1);
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
      balv.a(this.a.app, true);
      banp.a().a(true);
      bdla.b(null, "dc00898", "", "", "0X800B44F", "0X800B44F", 1, 0, "", "", "", "");
      bakl.a("HelloQQWake", "qVoiceAssistantCkb change isChecked:" + paramBoolean);
      if ((Build.VERSION.SDK_INT < 23) || (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") == 0))
      {
        i = 1;
        label147:
        bool = FloatingScreenPermission.checkPermission(BaseApplicationImpl.getContext());
        localObject = new adit(this);
        if ((i == 0) || (!bool)) {
          break label203;
        }
        banp.a().a(this.a, "AssistantSettingActivity", (banv)localObject);
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
        this.a.requestPermissions(new adiu(this, (banv)localObject), 1, new String[] { "android.permission.RECORD_AUDIO" });
      }
      if (!bool)
      {
        FloatingScreenPermission.requestPermission(this.a);
        continue;
        balv.a(this.a.app, false);
        banp.a().a(false);
        banp.a().b("AssistantSettingActivity");
        bdla.b(null, "dc00898", "", "", "0X800B44F", "0X800B44F", 2, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adis
 * JD-Core Version:    0.7.0.1
 */