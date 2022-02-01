import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class alee
  extends amsu
{
  public alee(QQSpecialCareSettingActivity paramQQSpecialCareSettingActivity) {}
  
  protected void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "onSetSpecialCareSwith_global isSuccess: " + paramBoolean);
    }
    Object localObject;
    boolean bool;
    if (!paramBoolean)
    {
      localObject = this.a;
      FormSwitchItem localFormSwitchItem = QQSpecialCareSettingActivity.a(this.a);
      if (!QQSpecialCareSettingActivity.a(this.a).a())
      {
        bool = true;
        ((QQSpecialCareSettingActivity)localObject).a(localFormSwitchItem, bool);
      }
    }
    else
    {
      this.a.a.sendEmptyMessage(8194);
      localObject = this.a.a.obtainMessage(8195);
      if (paramBoolean) {
        i = 2;
      }
      ((Message)localObject).arg1 = i;
      if (!paramBoolean) {
        break label194;
      }
      if (!Boolean.valueOf(((boolean[])(boolean[])paramArrayOfObject[2])[0]).booleanValue()) {
        break label188;
      }
      i = 2131698593;
    }
    for (;;)
    {
      ((Message)localObject).arg2 = i;
      this.a.a.sendMessage((Message)localObject);
      QQSpecialCareSettingActivity.b(this.a);
      bcqk.c(this.a.app);
      return;
      bool = false;
      break;
      label188:
      i = 2131698592;
      continue;
      label194:
      if (((boolean[])(boolean[])paramArrayOfObject[2])[0] != 0) {
        i = 2131698596;
      } else {
        i = 2131698588;
      }
    }
  }
  
  protected void onSetSpecialCareSwitch_qzone(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "onSetSpecialCareSwith_qzone isSuccess: " + paramBoolean);
    }
    FormSwitchItem localFormSwitchItem;
    if (!paramBoolean)
    {
      paramArrayOfObject = this.a;
      localFormSwitchItem = QQSpecialCareSettingActivity.b(this.a);
      if (QQSpecialCareSettingActivity.b(this.a).a()) {
        break label77;
      }
    }
    label77:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramArrayOfObject.a(localFormSwitchItem, paramBoolean);
      QQSpecialCareSettingActivity.b(this.a);
      return;
    }
  }
  
  protected void onSetSpecialCareSwitch_specialRing(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "onSetSpecialCareSwith_specialRing isSuccess: " + paramBoolean);
    }
    QQSpecialCareSettingActivity.b(this.a);
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "onUpdateDelFriend isSuccess: " + paramBoolean + ", uin: " + paramObject);
    }
    QQSpecialCareSettingActivity.b(this.a);
  }
  
  protected void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List<SpecialCareInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "onUpdateSpecialCareList isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2);
    }
    QQSpecialCareSettingActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alee
 * JD-Core Version:    0.7.0.1
 */