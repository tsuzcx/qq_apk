import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;

public class abqw
  implements CompoundButton.OnCheckedChangeListener
{
  public abqw(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (!bbfj.g(this.a))
    {
      bcql.a(BaseApplication.getContext(), 1, 2131694674, 0).b(this.a.getTitleBarHeight());
      paramCompoundButton = this.a.j;
      if (!paramBoolean) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramCompoundButton.setChecked(paramBoolean);
        return;
      }
    }
    ((ajti)this.a.app.a(2)).g(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abqw
 * JD-Core Version:    0.7.0.1
 */