import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;

public class aaym
  implements CompoundButton.OnCheckedChangeListener
{
  public aaym(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AboutActivity.a(5);
      if (!ArkIDESettingFragment.b().equals("close")) {
        this.a.c();
      }
      ArkAppCenter.b("ArkApp.DebugOnlineActivity", String.format("ArkDebug switch is opened and IDE debug is also open ,state=%s", new Object[] { AboutActivity.b() }));
      return;
    }
    AboutActivity.a(0);
    this.a.d();
    ArkAppCenter.b("ArkApp.DebugOnlineActivity", String.format("ArkDebug switch is closed and IDE debug is also closed,state=%s", new Object[] { AboutActivity.b() }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaym
 * JD-Core Version:    0.7.0.1
 */