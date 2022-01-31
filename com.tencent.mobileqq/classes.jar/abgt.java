import android.app.Application;
import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity.15.1;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity.15.2;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import mqq.app.MobileQQ;

public class abgt
  implements CompoundButton.OnCheckedChangeListener
{
  public abgt(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject;
    if (((paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton == PermisionPrivacyActivity.b(this.a)) || (paramCompoundButton == PermisionPrivacyActivity.a(this.a)) || (paramCompoundButton == this.a.b.a()) || (paramCompoundButton == this.a.c.a()) || (paramCompoundButton == this.a.e.a())) && (!badq.d(this.a.getActivity())))
    {
      this.a.a(2131629006, 1);
      localObject = this.a;
      if (!paramBoolean)
      {
        paramBoolean = true;
        PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject, paramCompoundButton, paramBoolean);
      }
    }
    label426:
    label624:
    do
    {
      return;
      paramBoolean = false;
      break;
      int i;
      if (paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        if (AppSetting.c) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(this.a.getResources().getString(2131628945));
        }
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          awqx.b(this.a.app, "CliOper", "", "", "Setting_tab", "Nearby_likeme", 0, i, String.valueOf(i), "", "", "");
          this.a.app.e(true, paramBoolean);
          return;
        }
      }
      if (paramCompoundButton == this.a.e.a())
      {
        ((ajfi)this.a.app.a(2)).o(paramBoolean);
        if (paramBoolean)
        {
          awqx.b(this.a.app, "dc00898", "", "", "0X8009E81", "0X8009E81", 0, 0, "", "", "", "");
          return;
        }
        awqx.b(this.a.app, "dc00898", "", "", "0X8009E80", "0X8009E80", 0, 0, "", "", "", "");
        return;
      }
      if (paramCompoundButton == this.a.i.a())
      {
        boolean bool;
        if (!badq.d(this.a.app.getApplication().getApplicationContext()))
        {
          bbmy.a(this.a.getApplicationContext(), 2131653546, 1).a();
          localObject = this.a;
          if (!paramBoolean)
          {
            bool = true;
            PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject, paramCompoundButton, bool);
          }
        }
        else
        {
          paramCompoundButton = (ajfi)this.a.app.a(2);
          if (paramBoolean) {
            break label426;
          }
        }
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramCompoundButton.k(paramBoolean);
          return;
          bool = false;
          break;
        }
      }
      if (paramCompoundButton == this.a.jdField_a_of_type_AndroidWidgetCompoundButton)
      {
        if (!badq.d(this.a.app.getApplication().getApplicationContext()))
        {
          bbmy.a(this.a.getApplicationContext(), 2131628948, 1).a();
          this.a.jdField_a_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(null);
          paramCompoundButton = this.a.jdField_a_of_type_AndroidWidgetCompoundButton;
          if (this.a.app.e() == 1) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            paramCompoundButton.setChecked(paramBoolean);
            this.a.jdField_a_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.a.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
            return;
          }
        }
        if (paramBoolean)
        {
          i = 1;
          awqx.b(this.a.app, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, String.valueOf(i), "", "", "");
          this.a.a(this.a.getApplication().getResources().getString(2131653478));
          if (!paramBoolean) {
            break label624;
          }
        }
        for (i = 1;; i = 0)
        {
          this.a.app.g(i);
          return;
          i = 0;
          break;
        }
      }
      if (paramCompoundButton == PermisionPrivacyActivity.b(this.a))
      {
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          awqx.b(this.a.app, "CliOper", "", "", "Setting_tab", "Visible_same", 0, i, String.valueOf(i), "", "", "");
          this.a.app.b(paramBoolean, false);
          this.a.a(paramBoolean);
          return;
        }
      }
      if (paramCompoundButton == PermisionPrivacyActivity.a(this.a))
      {
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          awqx.b(this.a.app, "CliOper", "", "", "Setting_tab", "Same_likeme", 0, i, String.valueOf(i), "", "", "");
          this.a.app.e(false, paramBoolean);
          return;
        }
      }
      if (paramCompoundButton == this.a.h.a())
      {
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          awqx.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_signature_qzone", 0, i, String.valueOf(i), "", "", "");
          if ((!badq.d(this.a.getActivity())) || (PermisionPrivacyActivity.a(this.a) == null)) {
            break;
          }
          if (AppSetting.c) {
            this.a.h.setContentDescription(ajjy.a(2131642132));
          }
          PermisionPrivacyActivity.a(this.a).a(paramBoolean);
          return;
        }
        paramCompoundButton = this.a;
        if (PermisionPrivacyActivity.a(this.a) != null)
        {
          i = 2131629006;
          PermisionPrivacyActivity.a(paramCompoundButton, i);
          paramCompoundButton = this.a;
          localObject = this.a.h.a();
          if (paramBoolean) {
            break label945;
          }
        }
        for (paramBoolean = true;; paramBoolean = false)
        {
          PermisionPrivacyActivity.a(paramCompoundButton, (CompoundButton)localObject, paramBoolean);
          return;
          i = 2131653546;
          break;
        }
      }
      if (paramCompoundButton == this.a.g.a())
      {
        if (AppSetting.c) {
          this.a.g.setContentDescription("可通过系统通讯录发起QQ聊天");
        }
        paramCompoundButton = new PermisionPrivacyActivity.15.1(this, (amoa)this.a.app.getManager(41), paramBoolean);
        localObject = new PermisionPrivacyActivity.15.2(this);
        if (paramBoolean)
        {
          if ((amnv.a()) && (befo.k()))
          {
            PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.app.getManager(11);
            amnx localamnx = new amnx();
            localamnx.jdField_a_of_type_JavaLangRunnable = paramCompoundButton;
            localamnx.b = ((Runnable)localObject);
            localamnx.jdField_a_of_type_Int = 7;
            localPhoneContactManagerImp.a().a(this.a, localamnx, this.a, new String[] { "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS" });
            return;
          }
          paramCompoundButton.run();
          return;
        }
        paramCompoundButton.run();
        return;
      }
      if (paramCompoundButton == this.a.b.a())
      {
        if (AppSetting.c) {
          this.a.b.setContentDescription(ajjy.a(2131642134));
        }
        PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean);
        this.a.app.c(paramBoolean, true);
        if (paramBoolean)
        {
          awqx.b(this.a.app, "CliOper", "", "", "0X8009C08", "0X8009C08", 0, 0, "", "", "", "");
          return;
        }
        awqx.b(this.a.app, "CliOper", "", "", "0X8009C09", "0X8009C09", 0, 0, "", "", "", "");
        return;
      }
      if (paramCompoundButton == this.a.c.a())
      {
        if (AppSetting.c) {
          this.a.c.setContentDescription(ajjy.a(2131642125));
        }
        PermisionPrivacyActivity.a(this.a, this.a.c.a(), paramBoolean);
        this.a.app.d(paramBoolean, true);
        return;
      }
      if (paramCompoundButton == this.a.d.a())
      {
        paramCompoundButton = this.a.app;
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          awqx.b(paramCompoundButton, "CliOper", "", "", "0X800487E", "0X800487E", 0, 0, String.valueOf(i), "", "", "");
          if (!badq.d(this.a.getActivity())) {
            break;
          }
          if (AppSetting.c) {
            this.a.d.setContentDescription(ajjy.a(2131642135));
          }
          ((ajfi)this.a.app.a(2)).i(paramBoolean);
          return;
        }
        paramCompoundButton = this.a;
        if (PermisionPrivacyActivity.a(this.a) != null)
        {
          i = 2131629006;
          PermisionPrivacyActivity.a(paramCompoundButton, i);
          paramCompoundButton = this.a;
          localObject = this.a.d.a();
          if (paramBoolean) {
            break label1512;
          }
        }
        for (paramBoolean = true;; paramBoolean = false)
        {
          PermisionPrivacyActivity.a(paramCompoundButton, (CompoundButton)localObject, paramBoolean);
          return;
          i = 2131653546;
          break;
        }
      }
      if (paramCompoundButton == this.a.f.a())
      {
        if ((paramCompoundButton.getTag() != null) && (((Boolean)paramCompoundButton.getTag()).booleanValue()))
        {
          paramCompoundButton.setTag(Boolean.FALSE);
          return;
        }
        this.a.jdField_a_of_type_Ajtg.a(paramBoolean);
        paramCompoundButton = this.a.jdField_a_of_type_AndroidWidgetTextView;
        if (paramBoolean)
        {
          i = 2131627556;
          paramCompoundButton.setText(i);
          localObject = this.a.app;
          if (!paramBoolean) {
            break label1643;
          }
        }
        for (paramCompoundButton = "open_autopass";; paramCompoundButton = "close_autopass")
        {
          awqx.b((QQAppInterface)localObject, "dc00899", "Grp_invite_friend", "", "auto_pass", paramCompoundButton, 0, 0, "", "", "", "");
          return;
          i = 2131627557;
          break;
        }
      }
    } while (paramCompoundButton != this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormMultiLineSwitchItem.a());
    label945:
    label1512:
    label1643:
    ((FriendListHandler)this.a.app.a(1)).a(this.a.app, paramBoolean, new abgu(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abgt
 * JD-Core Version:    0.7.0.1
 */