import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ChatSettingForTroop.38.1;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.ExtraInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody;

public class adsg
  extends aofu
{
  public adsg(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void onGetAddTroopWebInfo(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, String.format("onGetAddTroopWebInfo url=%s", new Object[] { paramString }));
    }
    if (!this.a.isResume()) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      QQToast.a(this.a, 2, 2131718060, 1).b(this.a.getTitleBarHeight());
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
  
  protected void onGetAddedRobots(boolean paramBoolean, int paramInt, long paramLong, ArrayList<bglr> paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("RobotMemberFormItem onGetAddedRobots suc:").append(paramBoolean).append(" retCode:").append(paramInt).append(" troopuin:").append(paramLong).append(" infos:");
      if (paramArrayList != null) {
        break label90;
      }
    }
    label90:
    for (String str = "null";; str = paramArrayList.toString())
    {
      QLog.d("Q.chatopttroop", 2, str);
      this.a.runOnUiThread(new ChatSettingForTroop.38.1(this, paramArrayList));
      return;
    }
  }
  
  protected void onGetNewTroopAppList(oidb_0xe83.RspBody paramRspBody, int paramInt)
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
  
  protected void onGetToopLuckyCharacterStatus(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) || (TextUtils.isEmpty(paramString1)) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) || (this.a.jdField_a_of_type_ArrayOfAndroidViewView == null)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!paramBoolean);
        paramString1 = this.a.jdField_a_of_type_ArrayOfAndroidViewView[49];
      } while (paramString1 == null);
      paramString1 = (TextView)paramString1.findViewById(2131376668);
    } while ((paramString2 == null) || (paramString1 == null));
    paramString1.setText(paramString2);
  }
  
  protected void onTroopManagerFailed(int paramInt1, int paramInt2)
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
        this.a.q();
        TroopUtils.handleJoinTroopFailed(this.a, paramInt2);
        this.a.b = null;
        return;
      }
    } while ((!this.a.isResume()) || ((paramInt1 != 2) && (paramInt1 != 9)));
    if (this.a.jdField_a_of_type_Biso == null) {
      this.a.jdField_a_of_type_Biso = new biso(this.a);
    }
    this.a.jdField_a_of_type_Biso.b(2, 2131692035, 1500);
    this.a.finish();
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      if (TextUtils.isEmpty(paramString))
      {
        localObject = "";
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
          break label110;
        }
        bool = true;
        label31:
        QLog.d("Q.chatopttroop", 2, new Object[] { "onTroopManagerSuccess. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", troopUin=", localObject, ", hasTroopInfoData=", Boolean.valueOf(bool) });
      }
    }
    else {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
        break label116;
      }
    }
    label110:
    label116:
    do
    {
      for (;;)
      {
        return;
        localObject = paramString;
        break;
        bool = false;
        break label31;
        if ((1 == paramInt1) && ((this.a.isResume()) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)))
        {
          this.a.q();
          if (this.a.jdField_a_of_type_Biso == null) {
            this.a.jdField_a_of_type_Biso = new biso(this.a);
          }
          switch (paramInt2)
          {
          case -1: 
          default: 
            this.a.jdField_a_of_type_Biso.b(2, 2131693399, 1500);
          }
          for (;;)
          {
            this.a.b = null;
            return;
            ((aoep)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(Long.parseLong(paramString), Long.parseLong(this.a.app.getAccount()));
            continue;
            this.a.jdField_a_of_type_Biso.b(2, 2131693400, 1500);
            this.a.finish();
            ChatSettingForTroop.a(this.a, true);
            localObject = (TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
            if (localObject != null)
            {
              ((TroopManager)localObject).e(((TroopManager)localObject).b(paramString));
              continue;
              this.a.jdField_a_of_type_Biso.b(2, 2131719621, 1500);
            }
          }
        }
        if (this.a.isResume())
        {
          if (paramInt1 != 3) {
            break label548;
          }
          if (paramInt2 == 0)
          {
            paramString = (TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
            if (paramString == null) {}
            for (paramString = null;; paramString = paramString.b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
            {
              if ((paramString == null) || (paramString.wMemberNum == this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum)) {
                break label546;
              }
              this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopAdmMemberNum(paramString.Administrator, paramString.wMemberNum, this.a.app.getCurrentAccountUin(), this.a.getResources());
              if (this.a.c == null) {
                break;
              }
              this.a.c.setText(anvx.a(2131701251) + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + anvx.a(2131701253));
              return;
            }
          }
        }
      }
    } while (((paramInt1 != 2) && (paramInt1 != 9)) || (paramInt2 != 0));
    label546:
    label548:
    paramString = new Intent();
    paramString.putExtra("isNeedFinish", true);
    this.a.setResult(-1, paramString);
    this.a.finish();
  }
  
  protected void onTroopMemberActiveRankingDesc(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    if ((!paramBoolean1) || (TextUtils.isEmpty(paramString1)) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.a.jdField_a_of_type_ArrayOfAndroidViewView == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "onTroopMemberActiveRankingDesc failed: isSucc = " + paramBoolean1 + ",troopUin = " + paramString1);
      }
    }
    do
    {
      View localView;
      do
      {
        return;
        localView = this.a.jdField_a_of_type_ArrayOfAndroidViewView[42];
      } while ((localView == null) || (localView.getVisibility() != 0));
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "isShowRedPoint = " + paramBoolean2 + ",wording = " + paramString2 + ",troopUin = " + paramString1);
      }
      paramString1 = (TextView)localView.findViewById(2131376668);
    } while (paramString1 == null);
    if ((paramBoolean2) && (paramString2 != null)) {
      paramString1.setText(paramString2);
    }
    for (;;)
    {
      TroopUtils.updateRedPoint(paramBoolean2, paramString1);
      return;
      paramString1.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsg
 * JD-Core Version:    0.7.0.1
 */