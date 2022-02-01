import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;

public class addp
  extends ansi
{
  public addp(AboutActivity paramAboutActivity) {}
  
  protected void onUpgradeConfig(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    AboutActivity.a(this.a, paramUpgradeDetailWrapper);
    paramUpgradeDetailWrapper = this.a.app.getAboutConfig();
    AboutActivity.a(this.a, paramUpgradeDetailWrapper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addp
 * JD-Core Version:    0.7.0.1
 */