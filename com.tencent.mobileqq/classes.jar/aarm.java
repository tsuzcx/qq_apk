import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;

public class aarm
  implements CompoundButton.OnCheckedChangeListener
{
  public aarm(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.c();
      ArkIDESettingFragment.a("");
      ArkAppCenter.b("ArkApp.DebugOnlineActivity", String.format("IDEDebug is open", new Object[0]));
      return;
    }
    this.a.d();
    ArkIDESettingFragment.a("close");
    ArkAppCenter.b("ArkApp.DebugOnlineActivity", String.format("IDEDebug is close", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aarm
 * JD-Core Version:    0.7.0.1
 */