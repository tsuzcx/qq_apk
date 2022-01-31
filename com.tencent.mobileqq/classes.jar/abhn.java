import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class abhn
  extends axms
{
  public abhn(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s onReqGetSimpleUISwitch suc=%b [%b,%d]", new Object[] { "SimpleUILog", Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) }));
    }
    if ((!paramBoolean1) || (!this.a.app.getCurrentAccountUin().equals(paramString))) {}
    while ((GeneralSettingActivity.a(this.a, this.a.a)) || (!this.a.a())) {
      return;
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s onSwitchSimpleUICallback suc=%b bSwitchElsePref=%b hasChange=%b statusCode=%d", new Object[] { "SimpleUILog", Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) }));
    }
    Object localObject;
    label177:
    String str;
    if (paramBoolean3)
    {
      paramBoolean2 = this.a.a.a().isChecked();
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          this.a.a(this.a.getString(2131719396, new Object[] { ajyc.a(2131705243) }), 2);
        }
        GeneralSettingActivity.a(this.a, false, this.a.a);
        this.a.a(axmt.b(), axmt.c());
        if (paramBoolean1) {
          bhoo.a();
        }
        return;
      }
      this.a.a(this.a.a.a(), axmt.b());
      if (paramBoolean2)
      {
        localObject = ajyc.a(2131705241);
        str = this.a.getString(2131719395, new Object[] { localObject });
        if (1 != paramInt) {
          break label259;
        }
        localObject = ajyc.a(2131705238) + (String)localObject + ajyc.a(2131705239);
      }
    }
    for (;;)
    {
      this.a.a((String)localObject, 1);
      break;
      localObject = ajyc.a(2131705242);
      break label177;
      label259:
      if (6 == paramInt)
      {
        localObject = str + ajyc.a(2131705237);
        continue;
        if (paramBoolean1) {
          break;
        }
        this.a.a(2131719393, 1);
        break;
      }
      localObject = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abhn
 * JD-Core Version:    0.7.0.1
 */