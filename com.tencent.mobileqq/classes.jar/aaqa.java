import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

public final class aaqa
  implements View.OnClickListener
{
  public aaqa(boolean paramBoolean, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.QQBrowserDelegationActivity");
    paramView.putExtra("param_force_internal_browser", this.jdField_a_of_type_Boolean);
    paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
    paramView.putExtra("injectrecommend", false);
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {
      localBaseActivity.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqa
 * JD-Core Version:    0.7.0.1
 */