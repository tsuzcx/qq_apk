import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;

public class algn
  implements View.OnClickListener
{
  public algn(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onClick(View paramView)
  {
    paramView = (begr)behe.a(BaseActivity.sTopActivity, null);
    paramView.a(BaseActivity.sTopActivity.getString(2131624666));
    paramView.a(2131624665, 3);
    paramView.c(2131624664);
    paramView.setOnDismissListener(new algo(this, paramView));
    paramView.a(new algp(this, paramView));
    if (!paramView.isShowing()) {
      paramView.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     algn
 * JD-Core Version:    0.7.0.1
 */