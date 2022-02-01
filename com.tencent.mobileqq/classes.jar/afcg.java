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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import mqq.app.MobileQQ;

public class afcg
  implements CompoundButton.OnCheckedChangeListener
{
  public afcg(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool;
    if (((paramCompoundButton == this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (paramCompoundButton == PermisionPrivacyActivity.b(this.a)) || (paramCompoundButton == PermisionPrivacyActivity.a(this.a)) || (paramCompoundButton == this.a.b.a()) || (paramCompoundButton == this.a.c.a()) || (paramCompoundButton == this.a.e.a())) && (!bhnv.d(this.a.getActivity())))
    {
      this.a.a(2131694005, 1);
      localObject1 = this.a;
      if (!paramBoolean)
      {
        bool = true;
        PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, paramCompoundButton, bool);
      }
    }
    int i;
    label402:
    label449:
    label578:
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
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(this.a.getResources().getString(2131693962));
        }
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          bdll.b(this.a.app, "CliOper", "", "", "Setting_tab", "Nearby_likeme", 0, i, String.valueOf(i), "", "", "");
          this.a.app.e(true, paramBoolean);
          break;
        }
      }
      if (paramCompoundButton == this.a.e.a())
      {
        ((anum)this.a.app.a(2)).o(paramBoolean);
        if (paramBoolean) {
          bdll.b(this.a.app, "dc00898", "", "", "0X8009E81", "0X8009E81", 0, 0, "", "", "", "");
        } else {
          bdll.b(this.a.app, "dc00898", "", "", "0X8009E80", "0X8009E80", 0, 0, "", "", "", "");
        }
      }
      else
      {
        if (paramCompoundButton == this.a.i.a())
        {
          if (!bhnv.d(this.a.app.getApplication().getApplicationContext()))
          {
            QQToast.a(this.a.getApplicationContext(), 2131717966, 1).a();
            localObject1 = this.a;
            if (!paramBoolean)
            {
              bool = true;
              PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, paramCompoundButton, bool);
            }
          }
          else
          {
            localObject1 = (anum)this.a.app.a(2);
            if (paramBoolean) {
              break label449;
            }
          }
          for (bool = true;; bool = false)
          {
            ((anum)localObject1).k(bool);
            break;
            bool = false;
            break label402;
          }
        }
        if (paramCompoundButton == this.a.jdField_a_of_type_AndroidWidgetCompoundButton)
        {
          if (!bhnv.d(this.a.app.getApplication().getApplicationContext()))
          {
            QQToast.a(this.a.getApplicationContext(), 2131693965, 1).a();
            this.a.jdField_a_of_type_AndroidWidgetCompoundButton.setOnCheckedChangeListener(null);
            localObject1 = this.a.jdField_a_of_type_AndroidWidgetCompoundButton;
            if (this.a.app.e() == 1) {}
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
            bdll.b(this.a.app, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, String.valueOf(i), "", "", "");
            this.a.a(this.a.getApplication().getResources().getString(2131717920));
            if (!paramBoolean) {
              break label657;
            }
          }
          label657:
          for (i = 1;; i = 0)
          {
            this.a.app.g(i);
            break;
            i = 0;
            break label578;
          }
        }
        if (paramCompoundButton == PermisionPrivacyActivity.b(this.a))
        {
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            bdll.b(this.a.app, "CliOper", "", "", "Setting_tab", "Visible_same", 0, i, String.valueOf(i), "", "", "");
            this.a.app.b(paramBoolean, false);
            this.a.a(paramBoolean);
            break;
          }
        }
        if (paramCompoundButton == PermisionPrivacyActivity.a(this.a))
        {
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            bdll.b(this.a.app, "CliOper", "", "", "Setting_tab", "Same_likeme", 0, i, String.valueOf(i), "", "", "");
            this.a.app.e(false, paramBoolean);
            break;
          }
        }
        if (paramCompoundButton == this.a.h.a())
        {
          if (paramBoolean) {}
          for (i = 1;; i = 0)
          {
            bdll.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_signature_qzone", 0, i, String.valueOf(i), "", "", "");
            if ((!bhnv.d(this.a.getActivity())) || (PermisionPrivacyActivity.a(this.a) == null)) {
              break label924;
            }
            if (AppSetting.c) {
              this.a.h.setContentDescription(anzj.a(2131706798));
            }
            PermisionPrivacyActivity.a(this.a).a(paramBoolean);
            break;
          }
          label924:
          localObject1 = this.a;
          if (PermisionPrivacyActivity.a(this.a) != null)
          {
            i = 2131694005;
            label943:
            PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, i);
            localObject1 = this.a;
            localObject2 = this.a.h.a();
            if (paramBoolean) {
              break label992;
            }
          }
          label992:
          for (bool = true;; bool = false)
          {
            PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, (CompoundButton)localObject2, bool);
            break;
            i = 2131717966;
            break label943;
          }
        }
        if (paramCompoundButton == this.a.g.a())
        {
          if (AppSetting.c) {
            this.a.g.setContentDescription("可通过系统通讯录发起QQ聊天");
          }
          localObject1 = new PermisionPrivacyActivity.16.1(this, (ContactSyncManager)this.a.app.getManager(41), paramBoolean);
          localObject2 = new PermisionPrivacyActivity.16.2(this);
          if (paramBoolean)
          {
            if ((ajnj.a()) && (VersionUtils.isM()))
            {
              PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.app.getManager(11);
              ajnl localajnl = new ajnl();
              localajnl.jdField_a_of_type_JavaLangRunnable = ((Runnable)localObject1);
              localajnl.b = ((Runnable)localObject2);
              localajnl.jdField_a_of_type_Int = 7;
              localPhoneContactManagerImp.a().a(this.a, localajnl, this.a, new String[] { "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS" });
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
            this.a.b.setContentDescription(anzj.a(2131706800));
          }
          PermisionPrivacyActivity.a(this.a, this.a.b.a(), paramBoolean);
          this.a.app.c(paramBoolean, true);
          if (paramBoolean) {
            bdll.b(this.a.app, "CliOper", "", "", "0X8009C08", "0X8009C08", 0, 0, "", "", "", "");
          } else {
            bdll.b(this.a.app, "CliOper", "", "", "0X8009C09", "0X8009C09", 0, 0, "", "", "", "");
          }
        }
        else if (paramCompoundButton == this.a.c.a())
        {
          if (AppSetting.c) {
            this.a.c.setContentDescription(anzj.a(2131706791));
          }
          PermisionPrivacyActivity.a(this.a, this.a.c.a(), paramBoolean);
          this.a.app.d(paramBoolean, true);
        }
        else
        {
          if (paramCompoundButton == this.a.d.a())
          {
            localObject1 = this.a.app;
            if (paramBoolean) {}
            for (i = 1;; i = 0)
            {
              bdll.b((QQAppInterface)localObject1, "CliOper", "", "", "0X800487E", "0X800487E", 0, 0, String.valueOf(i), "", "", "");
              if (!bhnv.d(this.a.getActivity())) {
                break label1520;
              }
              if (AppSetting.c) {
                this.a.d.setContentDescription(anzj.a(2131706801));
              }
              ((anum)this.a.app.a(2)).i(paramBoolean);
              break;
            }
            label1520:
            localObject1 = this.a;
            if (PermisionPrivacyActivity.a(this.a) != null)
            {
              i = 2131694005;
              label1539:
              PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, i);
              localObject1 = this.a;
              localObject2 = this.a.d.a();
              if (paramBoolean) {
                break label1588;
              }
            }
            label1588:
            for (bool = true;; bool = false)
            {
              PermisionPrivacyActivity.a((PermisionPrivacyActivity)localObject1, (CompoundButton)localObject2, bool);
              break;
              i = 2131717966;
              break label1539;
            }
          }
          if (paramCompoundButton == this.a.f.a())
          {
            if ((paramCompoundButton.getTag() == null) || (!((Boolean)paramCompoundButton.getTag()).booleanValue())) {
              break label1638;
            }
            paramCompoundButton.setTag(Boolean.FALSE);
          }
        }
      }
    }
    label1638:
    this.a.jdField_a_of_type_Aoip.a(paramBoolean);
    Object localObject1 = this.a.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean)
    {
      i = 2131692803;
      label1666:
      ((TextView)localObject1).setText(i);
      localObject2 = this.a.app;
      if (!paramBoolean) {
        break label1728;
      }
    }
    label1728:
    for (localObject1 = "open_autopass";; localObject1 = "close_autopass")
    {
      bdll.b((QQAppInterface)localObject2, "dc00899", "Grp_invite_friend", "", "auto_pass", (String)localObject1, 0, 0, "", "", "", "");
      break;
      i = 2131692804;
      break label1666;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcg
 * JD-Core Version:    0.7.0.1
 */