import android.view.View;
import com.tencent.mobileqq.profile.ProfileCardWebviewPlugin;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class agpm
  implements ActionSheet.OnButtonClickListener
{
  public agpm(ProfileCardWebviewPlugin paramProfileCardWebviewPlugin) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ProfileCardWebviewPlugin.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agpm
 * JD-Core Version:    0.7.0.1
 */