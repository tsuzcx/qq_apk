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
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.text.QQText;
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

public class adsd
  extends Handler
{
  public adsd(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void handleMessage(Message paramMessage)
  {
    int j = 0;
    if ((this.a.jdField_c_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    int i;
    label507:
    do
    {
      Object localObject2;
      Object localObject3;
      Switch localSwitch;
      do
      {
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
                this.a.d();
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
            localObject1 = new begq(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick, 16).a();
            paramMessage.setRightText((CharSequence)localObject1);
            bhmb.a(paramMessage.a(), (Spannable)localObject1, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNickId);
            return;
          }
          paramMessage.setRightText(this.a.getString(2131697320));
          bhmb.a(paramMessage.a(), new SpannableString(""), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNickId);
          return;
          localObject2 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[4];
        } while (localObject2 == null);
        localObject1 = null;
        if (paramMessage.obj != null) {
          localObject1 = (String)paramMessage.obj;
        }
        ChatSettingForTroop.a(this.a, (View)localObject2, (String)localObject1);
        return;
        if (QLog.isColorLevel())
        {
          if (this.a.e != null)
          {
            i = this.a.e.size();
            QLog.d("Q.chatopttroop", 2, "MSG_UPDATE_INFO memberListForCard.size = " + i);
          }
        }
        else
        {
          if (this.a.jdField_c_of_type_AndroidWidgetTextView != null) {
            this.a.jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131701252) + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + anvx.a(2131701258));
          }
          this.a.b(true);
          this.a.f();
          this.a.a(this.a.e);
          ChatSettingForTroop.j(this.a);
          paramMessage = this.a;
          if (this.a.d) {
            break label507;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          ChatSettingForTroop.a(paramMessage, bool, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop);
          return;
          i = -1;
          break;
        }
        localObject3 = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags;
        localObject2 = new Intent(this.a, TroopTagViewActivity.class);
        ((Intent)localObject2).putExtra("troopuin", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        ((Intent)localObject2).putExtra("isAdmin", false);
        localObject1 = "";
        if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText))
        {
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText;
          i = 1;
        }
        for (;;)
        {
          if (i != 0) {
            ((Intent)localObject2).putExtra("subclass", paramMessage);
          }
          if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
            break label796;
          }
          paramMessage = new StringBuffer();
          localObject1 = ((List)localObject3).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)((Iterator)localObject1).next();
            paramMessage.append((String)localObject3 + "\n");
          }
          paramMessage = (Message)localObject1;
          i = j;
          if (this.a.jdField_a_of_type_Bgss != null)
          {
            paramMessage = (Message)localObject1;
            i = j;
            if (!TextUtils.isEmpty(this.a.jdField_a_of_type_Bgss.a))
            {
              paramMessage = (Message)localObject1;
              i = j;
              if (!anvx.a(2131701245).equals(this.a.jdField_a_of_type_Bgss.a))
              {
                paramMessage = this.a.jdField_a_of_type_Bgss.a;
                i = 1;
              }
            }
          }
        }
        paramMessage.deleteCharAt(paramMessage.length() - 1);
        ((Intent)localObject2).putExtra("tags", paramMessage.toString());
        ((Intent)localObject2).putExtra("act_type", 1);
        ((Intent)localObject2).putExtra("uin", this.a.app.getCurrentAccountUin());
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
        {
          this.a.startActivityForResult((Intent)localObject2, 11);
          return;
        }
        this.a.startActivity((Intent)localObject2);
        return;
        localObject2 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[8];
        localObject3 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[9];
        if ((localObject3 == null) || (localObject2 == null) || (!(localObject2 instanceof FormSwitchItem))) {
          break;
        }
        localObject1 = (FormSimpleItem)((View)localObject3).findViewById(2131369195);
        localSwitch = ((FormSwitchItem)localObject2).a();
        ((TextView)((View)localObject3).findViewById(2131368875)).setVisibility(8);
        paramMessage = "";
        Boolean localBoolean = (Boolean)this.a.jdField_a_of_type_Bhhi.c.get(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if ((localBoolean != null) && (localBoolean.booleanValue())) {
          break label1281;
        }
      } while (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null);
      i = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopmask;
      if (i == 1)
      {
        ((View)localObject2).setBackgroundResource(2130839503);
        ((View)localObject2).getBackground().setAlpha(255);
        if (localSwitch.isChecked())
        {
          localSwitch.setTag(Boolean.TRUE);
          localSwitch.setChecked(false);
        }
        ((View)localObject3).setVisibility(8);
        paramMessage = "";
        this.a.b.setVisibility(8);
        if (ChatSettingForTroop.a(this.a) != null) {
          ChatSettingForTroop.d(this.a);
        }
      }
      for (;;)
      {
        ((FormSimpleItem)localObject1).setRightText(new QQText(paramMessage, 3));
        awtz.a().c(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        return;
        ((View)localObject2).setBackgroundResource(2130839506);
        ((View)localObject2).getBackground().setAlpha(255);
        if (!localSwitch.isChecked())
        {
          localSwitch.setTag(Boolean.TRUE);
          localSwitch.setChecked(true);
        }
        ((View)localObject3).setVisibility(0);
        switch (i)
        {
        default: 
          paramMessage = "";
          break;
        case 2: 
          paramMessage = this.a.getString(2131697393);
          this.a.getString(2131697395);
          break;
        case 3: 
          paramMessage = this.a.getString(2131692970);
          this.a.getString(2131697391);
          break;
        case 4: 
          paramMessage = this.a.getString(2131697397);
          this.a.getString(2131697399);
          break;
          ((View)localObject3).setVisibility(0);
          ((View)localObject2).setBackgroundResource(2130839506);
          ((View)localObject2).getBackground().setAlpha(255);
          this.a.b.setVisibility(0);
        }
      }
      paramMessage = this.a.jdField_a_of_type_ArrayOfAndroidViewView[27];
      if (paramMessage != null)
      {
        localObject1 = (TextView)paramMessage.findViewById(2131379001);
        if (localObject1 != null)
        {
          ((TextView)localObject1).setTextColor(Color.parseColor("#00b6f9"));
          if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
            ((TextView)localObject1).setAlpha(0.5F);
          }
        }
        paramMessage = (ProgressBar)paramMessage.findViewById(2131373175);
        if (paramMessage != null) {
          paramMessage.setVisibility(8);
        }
      }
      QQToast.a(this.a, 2, this.a.getString(2131690835), 0).a();
      return;
      i = paramMessage.arg1;
      paramMessage = this.a.jdField_a_of_type_ArrayOfAndroidViewView[30];
    } while (!(paramMessage instanceof FormSimpleItem));
    label796:
    Object localObject1 = (FormSimpleItem)paramMessage;
    label1281:
    if (i == 0) {}
    for (paramMessage = null;; paramMessage = this.a.getResources().getDrawable(2130850427))
    {
      ((FormSimpleItem)localObject1).setRightIcon(paramMessage);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsd
 * JD-Core Version:    0.7.0.1
 */