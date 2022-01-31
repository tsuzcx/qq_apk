import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;

public class aluy
  implements View.OnClickListener
{
  public aluy(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (bfol)bfoy.a(BaseActivity.sTopActivity, null);
    paramView.a(BaseActivity.sTopActivity.getString(2131690217));
    paramView.a(2131690216, 3);
    paramView.c(2131690218);
    paramView.setOnDismissListener(new aluz(this, paramView));
    paramView.a(new alva(this, paramView));
    if (!paramView.isShowing()) {
      paramView.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aluy
 * JD-Core Version:    0.7.0.1
 */