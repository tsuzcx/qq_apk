import com.tencent.mobileqq.activity.SettingUncommUsedContactsActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class acbx
  extends ajxl
{
  public acbx(SettingUncommUsedContactsActivity paramSettingUncommUsedContactsActivity) {}
  
  protected void onGetBothDongtaiPermissions(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      SettingUncommUsedContactsActivity.a(this.a, this.a.a.a(), paramBoolean2);
      SettingUncommUsedContactsActivity.a(this.a, this.a.b.a(), paramBoolean3);
    }
  }
  
  protected void onSetNotAllowedSeeMyDongtai(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.a.a(2131719375, 1);
      SettingUncommUsedContactsActivity.a(this.a, this.a.a.a(), paramBoolean2);
    }
  }
  
  protected void onSetShieldHisDongtai(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      this.a.a(2131719375, 1);
      SettingUncommUsedContactsActivity.a(this.a, this.a.b.a(), paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acbx
 * JD-Core Version:    0.7.0.1
 */