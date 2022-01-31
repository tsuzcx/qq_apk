import android.view.View;
import com.tencent.mobileqq.troop.browser.TroopWebviewPlugin;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class aimq
  implements ActionSheet.OnButtonClickListener
{
  public aimq(TroopWebviewPlugin paramTroopWebviewPlugin) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    TroopWebviewPlugin.a(this.a);
    if (paramInt == 0) {
      TroopWebviewPlugin.a(this.a, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aimq
 * JD-Core Version:    0.7.0.1
 */