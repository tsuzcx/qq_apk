import android.widget.TextView;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader.StatusListener;

public class abfp
  extends JSDebuggerSoLoader.StatusListener
{
  public abfp(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void a(int paramInt)
  {
    if (ArkIDESettingFragment.a(this.a) != null)
    {
      TextView localTextView = ArkIDESettingFragment.a(this.a);
      ArkAppCenter.a().postToMainThread(new abfq(this, paramInt, localTextView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abfp
 * JD-Core Version:    0.7.0.1
 */