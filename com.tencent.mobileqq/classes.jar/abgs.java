import android.widget.CompoundButton;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class abgs
  extends ajfo
{
  public abgs(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      PermisionPrivacyActivity.a(this.a, this.a.d.a(), paramBoolean2);
    }
  }
  
  protected void onGetAllowStrangerInviteToGroupSwitch(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((this.a.isFinishing()) || (this.a.app == null)) {
      return;
    }
    if (!paramBoolean1)
    {
      this.a.a(2131653546, 1);
      Card localCard = ((ajjj)this.a.app.getManager(51)).c(this.a.app.getCurrentAccountUin());
      PermisionPrivacyActivity.a(this.a, this.a.e.a(), localCard.strangerInviteMeGroupOpen);
      return;
    }
    PermisionPrivacyActivity.a(this.a, this.a.e.a(), paramBoolean2);
  }
  
  protected void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.a.isFinishing()))
    {
      if (paramBoolean2) {
        break label106;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ajjy.a(2131633656));
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        Card localCard = ((ajjj)this.a.app.getManager(51)).c(this.a.app.getCurrentAccountUin());
        QLog.d("interactive", 2, "PermisionPrivacyActivity onGetCalReactiveDays isAllow= " + paramBoolean2 + "card.allowCalInteractive=" + localCard.allowCalInteractive);
      }
      return;
      label106:
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ajjy.a(2131633657));
    }
  }
  
  protected void onGetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.app.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    PermisionPrivacyActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), paramBoolean2);
    PermisionPrivacyActivity.a(this.a, PermisionPrivacyActivity.a(this.a), paramBoolean3);
  }
  
  protected void onGetPrettyOwnerFlag(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        paramBoolean = ((Boolean)paramObject).booleanValue();
        PermisionPrivacyActivity.a(this.a, paramBoolean);
        this.a.j.setChecked(paramBoolean);
        QLog.e("vip_pretty.Q.security", 1, "onGetPrettyOwnerFlag " + paramBoolean);
        return;
      }
      catch (Exception paramObject)
      {
        QLog.e("vip_pretty.Q.security", 1, "onGetPrettyOwnerFlag ex:" + paramObject);
        return;
      }
      paramBoolean = false;
    }
  }
  
  protected void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetAllowSeeLoginDays(boolean paramBoolean)
  {
    Card localCard = ((ajjj)this.a.app.getManager(51)).c(this.a.app.getCurrentAccountUin());
    PermisionPrivacyActivity.a(this.a, this.a.d.a(), localCard.allowPeopleSee);
  }
  
  protected void onSetCalReactiveDays(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if ((paramBoolean) && (!this.a.isFinishing()))
    {
      Card localCard = ((ajjj)this.a.app.getManager(51)).c(this.a.app.getCurrentAccountUin());
      if (localCard.allowCalInteractive) {
        break label108;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ajjy.a(2131633656));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("PermisionPrivacyActivity onSetCalReactiveDays isAllow= ");
        if (localCard.allowCalInteractive) {
          break label126;
        }
      }
    }
    label108:
    label126:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("interactive", 2, paramBoolean);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(ajjy.a(2131633657));
      break;
    }
  }
  
  protected void onSetCardSwitch(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.a.app.getCurrentAccountUin().equals(paramString)) {
      return;
    }
    if (!paramBoolean1) {
      this.a.a(2131653546, 1);
    }
    if (paramBoolean2)
    {
      PermisionPrivacyActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a(), paramBoolean3);
      return;
    }
    PermisionPrivacyActivity.a(this.a, PermisionPrivacyActivity.a(this.a), paramBoolean3);
  }
  
  protected void onSetMedal(boolean paramBoolean)
  {
    int i = 1;
    boolean bool = false;
    if (!paramBoolean)
    {
      bbmy.a(this.a.app.getApp(), 1, this.a.getString(2131653546), 3000).b(this.a.getTitleBarHeight());
      localObject1 = this.a;
      localObject2 = this.a.i.a();
      paramBoolean = bool;
      if (!this.a.i.a().isChecked()) {
        paramBoolean = true;
      }
      PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, (CompoundButton)localObject2, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.security", 2, "PermisionPrivacyActivity onSetMedal failed");
      }
      return;
    }
    Object localObject1 = ((ajjj)this.a.app.getManager(51)).c(this.a.app.getCurrentAccountUin());
    if (!this.a.isFinishing())
    {
      localObject2 = this.a;
      Switch localSwitch = this.a.i.a();
      if (((Card)localObject1).medalSwitchDisable) {
        break label260;
      }
      paramBoolean = true;
      PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject2, localSwitch, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.security", 2, "PermisionPrivacyActivity onSetMedal medalSwitchDisable= " + ((Card)localObject1).medalSwitchDisable);
      }
    }
    Object localObject2 = this.a.app;
    if (((Card)localObject1).medalSwitchDisable) {}
    for (;;)
    {
      awqx.b((QQAppInterface)localObject2, "dc00898", "", "", "0X80073A0", "0X80073A0", i, 0, "", "", "", "");
      return;
      label260:
      paramBoolean = false;
      break;
      i = 0;
    }
  }
  
  protected void onSetPrettyOwnerFlag(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      return;
    }
    if (paramObject != null) {}
    for (;;)
    {
      try
      {
        paramBoolean = ((Boolean)paramObject).booleanValue();
        PermisionPrivacyActivity.a(this.a, paramBoolean);
        QLog.e("vip_pretty.Q.security", 1, "onSetPrettyOwnerFlag " + paramBoolean);
        return;
      }
      catch (Exception paramObject)
      {
        QLog.e("vip_pretty.Q.security", 1, "onSetPrettyOwnerFlag ex:" + paramObject);
        return;
      }
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abgs
 * JD-Core Version:    0.7.0.1
 */