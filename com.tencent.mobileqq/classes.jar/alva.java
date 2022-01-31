import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;

public class alva
  implements View.OnClickListener
{
  public alva(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (bfpc)bfpp.a(BaseActivity.sTopActivity, null);
    paramView.a(BaseActivity.sTopActivity.getString(2131690220));
    paramView.a(2131690219, 3);
    paramView.c(2131690218);
    paramView.setOnDismissListener(new alvb(this, paramView));
    paramView.a(new alvc(this, paramView));
    if (!paramView.isShowing()) {
      paramView.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alva
 * JD-Core Version:    0.7.0.1
 */