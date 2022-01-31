import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class abfj
  implements View.OnClickListener
{
  public abfj(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (ActionSheet)ActionSheetHelper.a(BaseActivity.sTopActivity, null);
    paramView.a(BaseActivity.sTopActivity.getString(2131438862));
    paramView.a(2131438864, 3);
    paramView.c(2131438866);
    paramView.setOnDismissListener(new abfk(this, paramView));
    paramView.a(new abfl(this, paramView));
    if (!paramView.isShowing()) {
      paramView.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abfj
 * JD-Core Version:    0.7.0.1
 */