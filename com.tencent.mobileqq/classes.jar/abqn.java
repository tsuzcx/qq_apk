import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class abqn
  extends ajxj
{
  public abqn(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void onGetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean2);
    }
  }
  
  protected void onSetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      this.a.a(2131719386, 1);
    }
    PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abqn
 * JD-Core Version:    0.7.0.1
 */