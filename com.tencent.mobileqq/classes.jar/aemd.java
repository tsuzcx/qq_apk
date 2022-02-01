import android.app.Application;
import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity.16.1;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity.16.2;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import mqq.app.MobileQQ;

public class aemd
  implements CompoundButton.OnCheckedChangeListener
{
  public aemd(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool;
    if (((paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton == PermisionPrivacyActivity.b(this.a)) || (paramCompoundButton == PermisionPrivacyActivity.a(this.a)) || (paramCompoundButton == this.a.b.a()) || (paramCompoundButton == this.a.c.a()) || (paramCompoundButton == this.a.e.a())) && (!NetworkUtil.isNetSupport(this.a.getActivity())))
    {
      this.a.a(2131694302, 1);
      localObject1 = this.a;
      if (!paramBoolean)
      {
        bool = true;
        PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, paramCompoundButton, bool);
      }
    }
    int i;
    label404:
    label453:
    label582:
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      if (paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
      {
        if (AppSetting.c) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(this.a.getResources().getString(2131694252));
        }
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          bdla.b(this.a.app, "CliOper", "", "", "Setting_tab", "Nearby_likeme", 0, i, String.valueOf(i), "", "", "");
          this.a.app.setZanAllowed(true, paramBoolean);
          break;
        }
      }
      if (paramCompoundButton == this.a.e.a())
      {
        ((anri)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).o(paramBoolean);
        if (paramBoolean) {
          bdla.b(this.a.app, "dc00898", "", "", "0X8009E81", "0X8009E81", 0, 0, "", "", "", "");
        } else {
          bdla.b(this.a.app, "dc00898", "", "", "0X8009E80", "0X8009E80", 0, 0, "", "", "", "");
        }
      }
      else
      {
        if (paramCompoundButton == this.a.i.a())
        {
          if (!NetworkUtil.isNetSupport(this.a.app.getApplication().getApplicationContext()))
          {
            QQToast.a(this.a.getApplicationContext(), 2131718593, 1).a();
            localObject1 = this.a;
            if (!paramBoolean)
            {
              bool = true;
              PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, paramCompoundButton, bool);
            }
          }
          else
          {
            localObject1 = (anri)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
            if (paramBoolean) {
              break label453;
            }
          }
          for (bool = true;; bool = false)
          {
            ((anri)localObject1).k(bool);
            break;
            bool = false;
            break label404;
          }
        }
        if (paramCompoundButton == this.a.jdField_a_of_type_AndroidWidgetCompoundButton)
        {
          if (!NetworkUtil.isNetSupport(this.a.app.getApplication().getApplicationContext()))
          {
            QQToast.a(this.a.getApplicationContext(), 2131694255, 1).a();
            this.a.jdField_a_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(null);
            localObject1 = this.a.jdField_a_of_type_AndroidWidgetCompoundButton;
            if (this.a.app.getC2CRoamingSetting() == 1) {}
            for (bool = true;; bool = false)
            {
              ((CompoundButton)localObject1).setChecked(bool);
              this.a.jdField_a_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(this.a.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
              break;
            }
          }
          if (paramBoolean)
          {
            i = 1;
            bdla.b(this.a.app, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, String.valueOf(i), "", "", "");
            this.a.a(this.a.getApplication().getResources().getString(2131718545));
            if (!paramBoolean) {
              break label661;
            }
          }
          label661:
          for (i = 1;; i = 0)
          {
            this.a.app.setC2CRoamingSetting(i);
            break;
            i = 0;
            break label582;
          }
        }
        if (paramCompoundButton == PermisionPrivacyActivity.b(this.a))
        {
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            bdla.b(this.a.app, "CliOper", "", "", "Setting_tab", "Visible_same", 0, i, String.valueOf(i), "", "", "");
            this.a.app.setVisibilityForStatus(paramBoolean, false);
            this.a.a(paramBoolean);
            break;
          }
        }
        if (paramCompoundButton == PermisionPrivacyActivity.a(this.a))
        {
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            bdla.b(this.a.app, "CliOper", "", "", "Setting_tab", "Same_likeme", 0, i, String.valueOf(i), "", "", "");
            this.a.app.setZanAllowed(false, paramBoolean);
            break;
          }
        }
        if (paramCompoundButton == this.a.h.a())
        {
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            bdla.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_signature_qzone", 0, i, String.valueOf(i), "", "", "");
            if ((!NetworkUtil.isNetSupport(this.a.getActivity())) || (PermisionPrivacyActivity.a(this.a) == null)) {
              break label928;
            }
            if (AppSetting.c) {
              this.a.h.setContentDescription(anvx.a(2131707377));
            }
            PermisionPrivacyActivity.a(this.a).a(paramBoolean);
            break;
          }
          label928:
          localObject1 = this.a;
          if (PermisionPrivacyActivity.a(this.a) != null)
          {
            i = 2131694302;
            label947:
            PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, i);
            localObject1 = this.a;
            localObject2 = this.a.h.a();
            if (paramBoolean) {
              break label996;
            }
          }
          label996:
          for (bool = true;; bool = false)
          {
            PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, (CompoundButton)localObject2, bool);
            break;
            i = 2131718593;
            break label947;
          }
        }
        if (paramCompoundButton == this.a.g.a())
        {
          if (AppSetting.c) {
            this.a.g.setContentDescription("可通过系统通讯录发起QQ聊天");
          }
          localObject1 = new PermisionPrivacyActivity.16.1(this, (ContactSyncManager)this.a.app.getManager(QQManagerFactory.MGR_SYNC_CONTACT), paramBoolean);
          localObject2 = new PermisionPrivacyActivity.16.2(this);
          if (paramBoolean)
          {
            if ((ajcr.a()) && (VersionUtils.isM()))
            {
              PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.app.getManager(QQManagerFactory.CONTACT_MANAGER);
              ajct localajct = new ajct();
              localajct.jdField_a_of_type_JavaLangRunnable = ((Runnable)localObject1);
              localajct.b = ((Runnable)localObject2);
              localajct.jdField_a_of_type_Int = 7;
              localPhoneContactManagerImp.a().a(this.a, localajct, this.a, new String[] { "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS" });
            }
            else
            {
              ((Runnable)localObject1).run();
            }
          }
          else {
            ((Runnable)localObject1).run();
          }
        }
        else if (paramCompoundButton == this.a.b.a())
        {
          if (AppSetting.c) {
            this.a.b.setContentDescription(anvx.a(2131707379));
          }
          PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean);
          this.a.app.setVisibilityForNetWorkStatus(paramBoolean, true);
          if (paramBoolean) {
            bdla.b(this.a.app, "CliOper", "", "", "0X8009C08", "0X8009C08", 0, 0, "", "", "", "");
          } else {
            bdla.b(this.a.app, "CliOper", "", "", "0X8009C09", "0X8009C09", 0, 0, "", "", "", "");
          }
        }
        else if (paramCompoundButton == this.a.c.a())
        {
          if (AppSetting.c) {
            this.a.c.setContentDescription(anvx.a(2131707370));
          }
          PermisionPrivacyActivity.a(this.a, this.a.c.a(), paramBoolean);
          this.a.app.setVisibilityForInputStatus(paramBoolean, true);
        }
        else
        {
          if (paramCompoundButton == this.a.d.a())
          {
            localObject1 = this.a.app;
            if (paramBoolean) {}
            for (i = 1;; i = 0)
            {
              bdla.b((QQAppInterface)localObject1, "CliOper", "", "", "0X800487E", "0X800487E", 0, 0, String.valueOf(i), "", "", "");
              if (!NetworkUtil.isNetSupport(this.a.getActivity())) {
                break label1528;
              }
              if (AppSetting.c) {
                this.a.d.setContentDescription(anvx.a(2131707380));
              }
              ((anri)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).i(paramBoolean);
              break;
            }
            label1528:
            localObject1 = this.a;
            if (PermisionPrivacyActivity.a(this.a) != null)
            {
              i = 2131694302;
              label1547:
              PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, i);
              localObject1 = this.a;
              localObject2 = this.a.d.a();
              if (paramBoolean) {
                break label1596;
              }
            }
            label1596:
            for (bool = true;; bool = false)
            {
              PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, (CompoundButton)localObject2, bool);
              break;
              i = 2131718593;
              break label1547;
            }
          }
          if (paramCompoundButton == this.a.f.a())
          {
            if ((paramCompoundButton.getTag() == null) || (!((Boolean)paramCompoundButton.getTag()).booleanValue())) {
              break label1646;
            }
            paramCompoundButton.setTag(Boolean.FALSE);
          }
        }
      }
    }
    label1646:
    this.a.jdField_a_of_type_Aoep.a(paramBoolean);
    Object localObject1 = this.a.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean)
    {
      i = 2131692960;
      label1674:
      ((TextView)localObject1).setText(i);
      localObject2 = this.a.app;
      if (!paramBoolean) {
        break label1736;
      }
    }
    label1736:
    for (localObject1 = "open_autopass";; localObject1 = "close_autopass")
    {
      bdla.b((QQAppInterface)localObject2, "dc00899", "Grp_invite_friend", "", "auto_pass", (String)localObject1, 0, 0, "", "", "", "");
      break;
      i = 2131692961;
      break label1674;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemd
 * JD-Core Version:    0.7.0.1
 */