import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class adml
  extends asyt
{
  public adml(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    if (!paramBoolean1)
    {
      this.a.a(2131719884, 1);
      return;
    }
    PermisionPrivacyActivity.a(this.a, this.a.c.a(), paramBoolean2);
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean2) {
      i = 2;
    }
    azqs.b(localQQAppInterface, "dc00898", "", "", "0X8009D11", "0X8009D11", 0, 0, String.valueOf(i), "", "", "");
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PermisionPrivacyActivity.a(this.a, this.a.c.a(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adml
 * JD-Core Version:    0.7.0.1
 */