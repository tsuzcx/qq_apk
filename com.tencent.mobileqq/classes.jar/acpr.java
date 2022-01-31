import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopTagViewActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class acpr
  extends Handler
{
  public acpr(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.jdField_c_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          case 1: 
            this.a.c();
            return;
          case 6: 
            if (QLog.isColorLevel()) {
              QLog.i("Q.chatopttroop", 2, "MSG_UPDATE_TROOP_MEMBER_CARD");
            }
            break;
          }
        } while (this.a.jdField_a_of_type_ArrayOfAndroidViewView == null);
        paramMessage = (FormSimpleItem)this.a.jdField_a_of_type_ArrayOfAndroidViewView[6];
      } while (paramMessage == null);
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, "handle MSG_UPDATE_TROOP_MEMBER_CARD message and update nick");
        }
        localObject1 = new bamb(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick, 16).a();
        paramMessage.setRightText((CharSequence)localObject1);
        bdrv.a(this.a.app, paramMessage.a(), (Spannable)localObject1);
        return;
      }
      paramMessage.setRightText(this.a.getString(2131698006));
      bdrv.a(this.a.app, paramMessage.a(), new SpannableString(""));
      return;
      localObject2 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[4];
    } while (localObject2 == null);
    Object localObject1 = null;
    if (paramMessage.obj != null) {
      localObject1 = (String)paramMessage.obj;
    }
    ChatSettingForTroop.a(this.a, (View)localObject2, (String)localObject1);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "MSG_UPDATE_INFO");
    }
    if (this.a.jdField_c_of_type_AndroidWidgetTextView != null) {
      this.a.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131702139) + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + alud.a(2131702145));
    }
    this.a.b(true);
    this.a.e();
    this.a.a(this.a.e);
    ChatSettingForTroop.j(this.a);
    return;
    Object localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags;
    localObject1 = new Intent(this.a, TroopTagViewActivity.class);
    ((Intent)localObject1).putExtra("troopuin", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    ((Intent)localObject1).putExtra("isAdmin", false);
    paramMessage = "";
    int i;
    if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText))
    {
      paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText;
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        ((Intent)localObject1).putExtra("subclass", paramMessage);
      }
      Object localObject3;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        paramMessage = new StringBuffer();
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            paramMessage.append((String)localObject3 + "\n");
            continue;
            if ((this.a.jdField_a_of_type_Bcwd == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_Bcwd.a))) {
              break label1404;
            }
            if (alud.a(2131702132).equals(this.a.jdField_a_of_type_Bcwd.a))
            {
              i = 0;
              break;
            }
            paramMessage = this.a.jdField_a_of_type_Bcwd.a;
            i = 1;
            break;
          }
        }
        paramMessage.deleteCharAt(paramMessage.length() - 1);
        ((Intent)localObject1).putExtra("tags", paramMessage.toString());
      }
      ((Intent)localObject1).putExtra("act_type", 1);
      ((Intent)localObject1).putExtra("uin", this.a.app.getCurrentAccountUin());
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        this.a.startActivityForResult((Intent)localObject1, 11);
        return;
      }
      this.a.startActivity((Intent)localObject1);
      return;
      View localView1 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[8];
      View localView2 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[9];
      Switch localSwitch;
      if ((localView2 != null) && (localView1 != null) && ((localView1 instanceof FormSwitchItem)))
      {
        localObject2 = (FormSimpleItem)localView2.findViewById(2131368590);
        localSwitch = ((FormSwitchItem)localView1).a();
        localObject3 = (TextView)localView2.findViewById(2131368311);
        ((TextView)localObject3).setBackgroundResource(2130839256);
        localObject1 = "";
        paramMessage = "";
        Boolean localBoolean = (Boolean)this.a.jdField_a_of_type_Bdmq.c.get(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if ((localBoolean != null) && (localBoolean.booleanValue())) {
          break label1204;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) {
          break;
        }
        i = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopmask;
        if (i != 1) {
          break label1045;
        }
        localView1.setBackgroundResource(2130839261);
        localView1.getBackground().setAlpha(255);
        if (localSwitch.isChecked())
        {
          localSwitch.setTag(Boolean.TRUE);
          localSwitch.setChecked(false);
        }
        localView2.setVisibility(8);
        paramMessage = "";
        localObject1 = "";
        this.a.b.setVisibility(8);
        if (ChatSettingForTroop.a(this.a) != null) {
          ChatSettingForTroop.d(this.a);
        }
      }
      for (;;)
      {
        ((FormSimpleItem)localObject2).setRightText(new bamp((CharSequence)localObject1, 3));
        ((TextView)localObject3).setText(paramMessage);
        ((TextView)localObject3).setTextColor(this.a.getResources().getColor(2131166977));
        auam.a().c(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        return;
        label1045:
        localView1.setBackgroundResource(2130839264);
        localView1.getBackground().setAlpha(255);
        if (!localSwitch.isChecked())
        {
          localSwitch.setTag(Boolean.TRUE);
          localSwitch.setChecked(true);
        }
        localView2.setVisibility(0);
        switch (i)
        {
        default: 
          paramMessage = "";
          localObject1 = "";
          break;
        case 2: 
          localObject1 = this.a.getString(2131698079);
          paramMessage = this.a.getString(2131698081);
          break;
        case 3: 
          localObject1 = this.a.getString(2131693310);
          paramMessage = this.a.getString(2131698077);
          break;
        case 4: 
          localObject1 = this.a.getString(2131698083);
          paramMessage = this.a.getString(2131698085);
          break;
          label1204:
          localView2.setVisibility(0);
          localView1.setBackgroundResource(2130839264);
          localView1.getBackground().setAlpha(255);
          this.a.b.setVisibility(0);
        }
      }
      paramMessage = this.a.jdField_a_of_type_ArrayOfAndroidViewView[27];
      if (paramMessage != null)
      {
        localObject1 = (TextView)paramMessage.findViewById(2131377938);
        if (localObject1 != null)
        {
          ((TextView)localObject1).setTextColor(Color.parseColor("#00b6f9"));
          if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
            ((TextView)localObject1).setAlpha(0.5F);
          }
        }
        paramMessage = (ProgressBar)paramMessage.findViewById(2131372291);
        if (paramMessage != null) {
          paramMessage.setVisibility(8);
        }
      }
      QQToast.a(this.a, 2, this.a.getString(2131690872), 0).a();
      return;
      i = paramMessage.arg1;
      paramMessage = this.a.jdField_a_of_type_ArrayOfAndroidViewView[30];
      if (!(paramMessage instanceof FormSimpleItem)) {
        break;
      }
      localObject1 = (FormSimpleItem)paramMessage;
      if (i == 0) {}
      for (paramMessage = null;; paramMessage = this.a.getResources().getDrawable(2130849801))
      {
        ((FormSimpleItem)localObject1).setRightIcon(paramMessage);
        return;
      }
      label1404:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpr
 * JD-Core Version:    0.7.0.1
 */