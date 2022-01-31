import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class aarq
  implements View.OnClickListener
{
  public aarq(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (ActionSheet)ActionSheetHelper.a(BaseActivity.sTopActivity, null);
    paramView.a(BaseActivity.sTopActivity.getString(2131438821));
    paramView.a(2131438823, 3);
    paramView.c(2131438824);
    paramView.setOnDismissListener(new aarr(this, paramView));
    paramView.a(new aars(this, paramView));
    if (!paramView.isShowing()) {
      paramView.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aarq
 * JD-Core Version:    0.7.0.1
 */