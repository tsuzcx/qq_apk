import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;

public class alux
  implements CompoundButton.OnCheckedChangeListener
{
  public alux(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.b();
      this.a.a("");
      ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("IDEDebug is open", new Object[0]));
      return;
    }
    this.a.c();
    this.a.a("close");
    ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("IDEDebug is close", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alux
 * JD-Core Version:    0.7.0.1
 */