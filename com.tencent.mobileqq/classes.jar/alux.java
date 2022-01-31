import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;

public class alux
  implements View.OnClickListener
{
  public alux(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (bfpc)bfpp.a(BaseActivity.sTopActivity, null);
    paramView.a(BaseActivity.sTopActivity.getString(2131690217));
    paramView.a(2131690216, 3);
    paramView.c(2131690218);
    paramView.setOnDismissListener(new aluy(this, paramView));
    paramView.a(new aluz(this, paramView));
    if (!paramView.isShowing()) {
      paramView.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alux
 * JD-Core Version:    0.7.0.1
 */