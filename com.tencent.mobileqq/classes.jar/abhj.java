import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class abhj
  extends axmu
{
  public abhj(GeneralSettingActivity paramGeneralSettingActivity) {}
  
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
          this.a.a(this.a.getString(2131719407, new Object[] { ajya.a(2131705254) }), 2);
        }
        GeneralSettingActivity.a(this.a, false, this.a.a);
        this.a.a(axmv.b(), axmv.c());
        if (paramBoolean1) {
          bhpf.a();
        }
        return;
      }
      this.a.a(this.a.a.a(), axmv.b());
      if (paramBoolean2)
      {
        localObject = ajya.a(2131705252);
        str = this.a.getString(2131719406, new Object[] { localObject });
        if (1 != paramInt) {
          break label259;
        }
        localObject = ajya.a(2131705249) + (String)localObject + ajya.a(2131705250);
      }
    }
    for (;;)
    {
      this.a.a((String)localObject, 1);
      break;
      localObject = ajya.a(2131705253);
      break label177;
      label259:
      if (6 == paramInt)
      {
        localObject = str + ajya.a(2131705248);
        continue;
        if (paramBoolean1) {
          break;
        }
        this.a.a(2131719404, 1);
        break;
      }
      localObject = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abhj
 * JD-Core Version:    0.7.0.1
 */