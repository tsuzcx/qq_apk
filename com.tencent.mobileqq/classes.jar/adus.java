import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.AssistantSettingActivity.1.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.HeightAdaptableListView;
import java.util.Locale;
import java.util.Map;

public class adus
  extends anuw
{
  public adus(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  protected void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.a.isFinishing())) {
      AssistantSettingActivity.a(this.a, this.a.f.a(), paramBoolean2);
    }
  }
  
  protected void onGetCommonSwitchFromDetailInfo(boolean paramBoolean, short[] paramArrayOfShort, Map<Short, Short> paramMap)
  {
    if ((paramBoolean) && (AssistantSettingActivity.a(this.a) != null) && (this.a.jdField_a_of_type_Advs != null) && (this.a.jdField_a_of_type_Advs.a(paramArrayOfShort)))
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.i("AssistantSettingActivity", 0, "onGetCommonSwitchFromDetailInfo");
      }
      AssistantSettingActivity.a(this.a).a();
    }
  }
  
  protected void onGetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.i("AssistantSettingActivity", 2, "onGetConnectionsSwitch:" + paramBoolean + " " + paramInt1 + " " + paramInt2);
    }
    AssistantSettingActivity localAssistantSettingActivity;
    if (paramBoolean)
    {
      localAssistantSettingActivity = this.a;
      if (this.a.jdField_a_of_type_Ajwm.c()) {
        break label81;
      }
    }
    label81:
    for (paramBoolean = true;; paramBoolean = false)
    {
      AssistantSettingActivity.b(localAssistantSettingActivity, paramBoolean);
      return;
    }
  }
  
  protected void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.isFinishing()) {
      AssistantSettingActivity.a(this.a, this.a.f.a(), paramBoolean2);
    }
  }
  
  protected void onSetCommonSwitchFromDetailInfo(boolean paramBoolean, short paramShort1, short paramShort2)
  {
    boolean bool2 = true;
    if (this.a.jdField_a_of_type_Advs == null) {}
    for (ajwh localajwh = null; localajwh == null; localajwh = this.a.jdField_a_of_type_Advs.a(paramShort1)) {
      return;
    }
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.i("AssistantSettingActivity", 0, String.format(Locale.getDefault(), "onSetCommonSwitchFromDetailInfo [%s, %s, %s]", new Object[] { Boolean.valueOf(paramBoolean), Short.valueOf(paramShort1), Short.valueOf(paramShort2) }));
    }
    boolean bool1;
    if (paramShort2 == 1)
    {
      bool1 = true;
      label91:
      if ((paramBoolean) || (bool1 != localajwh.e)) {
        break label148;
      }
      if (localajwh.e) {
        break label150;
      }
    }
    label148:
    label150:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localajwh.e = paramBoolean;
      this.a.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.post(new AssistantSettingActivity.1.1(this, bool1));
      return;
      bool1 = false;
      break label91;
      break;
    }
  }
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.i("AssistantSettingActivity", 2, "onSetConnectionsSwitch:" + paramBoolean + " " + paramInt1 + " " + paramInt2);
    }
    AssistantSettingActivity localAssistantSettingActivity;
    if (!paramBoolean)
    {
      AssistantSettingActivity.a(this.a, 2131717966, 1);
      localAssistantSettingActivity = this.a;
      if (this.a.jdField_a_of_type_Ajwm.c()) {
        break label95;
      }
    }
    label95:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      AssistantSettingActivity.b(localAssistantSettingActivity, paramBoolean);
      return;
    }
  }
  
  protected void onSetEmotionRecSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.a.isFinishing()) || (this.a.app == null)) {
      return;
    }
    if (!paramBoolean1)
    {
      AssistantSettingActivity.a(this.a, 2131717966, 1);
      AssistantSettingActivity.a(this.a, aiti.a(this.a.app).b(), AssistantSettingActivity.a(this.a));
      return;
    }
    AssistantSettingActivity.a(this.a, paramBoolean2, AssistantSettingActivity.a(this.a));
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean2) {}
    for (String str = "1";; str = "2")
    {
      bdll.b(localQQAppInterface, "dc00898", "", "", "0X800A223", "0X800A223", 0, 0, str, "", "", "");
      return;
    }
  }
  
  protected void onSetPttAutoToTxtSwitch(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      QQToast.a(BaseApplication.getContext(), 1, anzj.a(2131699694), 0).b(this.a.getTitleBarHeight());
      paramBoolean = ((Boolean)paramObject).booleanValue();
      AssistantSettingActivity.a(this.a, true);
      this.a.e.setChecked(paramBoolean);
      AssistantSettingActivity.a(this.a, paramBoolean);
      AssistantSettingActivity.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adus
 * JD-Core Version:    0.7.0.1
 */