import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class aayr
  implements View.OnClickListener
{
  public aayr(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (ActionSheet)ActionSheetHelper.a(BaseActivity.sTopActivity, null);
    paramView.a(BaseActivity.sTopActivity.getString(2131438839));
    paramView.a(2131438841, 3);
    paramView.c(2131438842);
    paramView.setOnDismissListener(new aays(this, paramView));
    paramView.a(new aayt(this, paramView));
    if (!paramView.isShowing()) {
      paramView.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayr
 * JD-Core Version:    0.7.0.1
 */