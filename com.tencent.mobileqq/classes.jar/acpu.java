import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ChatSettingForTroop.33.1;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.ExtraInfo;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.RspBody;

public class acpu
  extends ameq
{
  public acpu(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (QLog.isColorLevel())
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
        bool = true;
      }
      QLog.d("Q.chatopttroop", 2, new Object[] { "onTroopManagerFailed. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", hasTroopInfoData=", Boolean.valueOf(bool) });
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      return;
      if ((1 == paramInt1) && ((this.a.isResume()) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)))
      {
        this.a.p();
        bcpx.a(this.a, paramInt2);
        this.a.b = null;
        return;
      }
    } while ((!this.a.isResume()) || ((paramInt1 != 2) && (paramInt1 != 9)));
    if (this.a.jdField_a_of_type_Beub == null) {
      this.a.jdField_a_of_type_Beub = new beub(this.a);
    }
    this.a.jdField_a_of_type_Beub.b(2, 2131692289, 1500);
    this.a.finish();
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (TextUtils.isEmpty(paramString))
      {
        localObject = "";
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
          break label107;
        }
        bool = true;
        label30:
        QLog.d("Q.chatopttroop", 2, new Object[] { "onTroopManagerSuccess. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", troopUin=", localObject, ", hasTroopInfoData=", Boolean.valueOf(bool) });
      }
    }
    else {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
        break label113;
      }
    }
    label107:
    label113:
    do
    {
      for (;;)
      {
        return;
        localObject = paramString;
        break;
        bool = false;
        break label30;
        if ((1 == paramInt1) && ((this.a.isResume()) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)))
        {
          this.a.p();
          if (this.a.jdField_a_of_type_Beub == null) {
            this.a.jdField_a_of_type_Beub = new beub(this.a);
          }
          switch (paramInt2)
          {
          case -1: 
          default: 
            this.a.jdField_a_of_type_Beub.b(2, 2131693805, 1500);
          }
          for (;;)
          {
            this.a.b = null;
            return;
            ((amdu)this.a.app.a(20)).b(Long.parseLong(paramString), Long.parseLong(this.a.app.getAccount()));
            continue;
            this.a.jdField_a_of_type_Beub.b(2, 2131693806, 1500);
            this.a.finish();
            ChatSettingForTroop.a(this.a, true);
            localObject = (TroopManager)this.a.app.getManager(52);
            if (localObject != null)
            {
              ((TroopManager)localObject).e(((TroopManager)localObject).b(paramString));
              continue;
              this.a.jdField_a_of_type_Beub.b(2, 2131721057, 1500);
            }
          }
        }
        if (this.a.isResume())
        {
          if (paramInt1 != 3) {
            break label536;
          }
          if (paramInt2 == 0)
          {
            paramString = (TroopManager)this.a.app.getManager(52);
            if (paramString == null) {}
            for (paramString = null;; paramString = paramString.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
            {
              if ((paramString == null) || (paramString.wMemberNum == this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum)) {
                break label534;
              }
              this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopAdmMemberNum(paramString.Administrator, paramString.wMemberNum, this.a.app.getCurrentAccountUin(), this.a.getResources());
              if (this.a.c == null) {
                break;
              }
              this.a.c.setText(alud.a(2131702138) + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + alud.a(2131702140));
              return;
            }
          }
        }
      }
    } while (((paramInt1 != 2) && (paramInt1 != 9)) || (paramInt2 != 0));
    label534:
    label536:
    paramString = new Intent();
    paramString.putExtra("isNeedFinish", true);
    this.a.setResult(-1, paramString);
    this.a.finish();
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, String.format("onGetAddTroopWebInfo url=%s", new Object[] { paramString }));
    }
    if (!this.a.isResume()) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      QQToast.a(this.a, 2, 2131719238, 1).b(this.a.getTitleBarHeight());
    }
    for (;;)
    {
      this.a.finish();
      return;
      paramString = paramString + "?_wv=1031&troopUin=" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&isVerify=" + 0;
      Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("hide_left_button", true);
      localIntent.putExtra("show_right_close_button", true);
      localIntent.putExtra("finish_animation_up_down", true);
      this.a.startActivity(localIntent);
      this.a.overridePendingTransition(2130771997, 2130771990);
    }
  }
  
  protected void a(oidb_0xaf4.RspBody paramRspBody, int paramInt)
  {
    if (paramRspBody.group_id.has())
    {
      localObject = String.valueOf(paramRspBody.group_id.get());
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (CharSequence)localObject))) {
        if (QLog.isColorLevel()) {
          QLog.e("Q.chatopttroop", 2, "onGetNewTroopAppList troopUin not match. rsp uin=" + (String)localObject + ", current uin=" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      do
      {
        do
        {
          return;
        } while (paramInt != 3);
        if (QLog.isColorLevel()) {
          QLog.d("raymondguo", 2, "game feed service type 3 refresh");
        }
        localObject = this.a.jdField_a_of_type_ArrayOfAndroidViewView[28];
      } while (localObject == null);
      if (paramRspBody.extra_info.tab_infos.size() > 0)
      {
        ((View)localObject).setVisibility(0);
        this.a.b(paramRspBody.extra_info.tab_infos.get());
        return;
      }
      ((View)localObject).setVisibility(8);
      return;
    }
    QLog.e("Q.chatopttroop", 2, "onGetNewTroopAppList service 3 group_id lost. current uin=" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<bcpf> paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("RobotMemberFormItem onGetAddedRobots suc:").append(paramBoolean).append(" retCode:").append(paramInt).append(" troopuin:").append(paramLong).append(" infos:");
      if (paramArrayList != null) {
        break label95;
      }
    }
    label95:
    for (String str = "null";; str = paramArrayList.toString())
    {
      QLog.d("Q.chatopttroop", 2, str);
      this.a.runOnUiThread(new ChatSettingForTroop.33.1(this, paramArrayList));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpu
 * JD-Core Version:    0.7.0.1
 */