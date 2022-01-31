import KQQ.BatchResponse;
import KQQ.RespBatchProcess;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ChatSettingForTroop.32.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.RspBody;

public class aaks
  extends ajuc
{
  public aaks(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(String paramString1, String paramString2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
      this.a.e();
    }
  }
  
  protected void a(oidb_0xaf4.RspBody paramRspBody, int paramInt)
  {
    if (paramRspBody.group_id.has())
    {
      str = String.valueOf(paramRspBody.group_id.get());
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, str))) {
        if (QLog.isColorLevel()) {
          QLog.e("Q.chatopttroop", 2, "onGetNewTroopAppList troopUin not match. rsp uin=" + str + ", current uin=" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        String str;
        do
        {
          return;
        } while (paramInt != 1);
        if (QLog.isColorLevel()) {
          QLog.d("raymondguo", 2, "game feed service type 1 refresh");
        }
        this.a.a(paramRspBody);
        paramRspBody = this.a.jdField_a_of_type_ArrayOfAndroidViewView[29];
        if ((paramRspBody != null) && (paramRspBody.isShown())) {
          azzx.a("Grp_game", "Grp_data", "rank_exp", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        }
        paramRspBody = this.a.jdField_a_of_type_ArrayOfAndroidViewView[30];
      } while ((paramRspBody == null) || (!paramRspBody.isShown()));
      azzx.a("Grp_game", "Grp_data", "feeds_exp", 0, 0, new String[] { this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      return;
    }
    QLog.e("Q.chatopttroop", 2, "onGetNewTroopAppList group_id lost. current uin=" + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!azzz.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(paramLong)));
        if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))))
        {
          this.a.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt));
          if (paramTroopInfo != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
          }
          if (this.a.jdField_a_of_type_Bbmv == null) {
            this.a.jdField_a_of_type_Bbmv = new bbmv(this.a);
          }
          if (paramBoolean)
          {
            this.a.jdField_a_of_type_Bbmv.a(1, this.a.getString(2131627935), 1000);
            return;
          }
          this.a.jdField_a_of_type_Bbmv.a(2, this.a.getString(2131627934), 1000);
          ChatSettingForTroop.b(this.a, paramInt);
          return;
        }
      } while ((!paramBoolean) || (paramTroopInfo == null));
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    } while ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() != 0));
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(paramTroopInfo, this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    this.a.p();
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        return;
      } while (paramLong != Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
      if (!paramBoolean) {
        break label194;
      }
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        this.a.a(2131654590, 0);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      if (this.a.isResume()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("qqBaseActivity", 2, "ChatSettingForTroop onOIDB0X88D_1_Ret return----------------");
    return;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3))
    {
      ChatSettingForTroop.c(this.a, 2);
      return;
    }
    ChatSettingForTroop.a(this.a, null);
    return;
    label194:
    this.a.a(2131653422, 1);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.a(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if ((!TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(paramLong1))) || (paramInt1 != 5)) {}
    do
    {
      return;
      if (paramBoolean)
      {
        ChatSettingForTroop.a(this.a, paramList);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.chatopttroop", 2, "onOIDB0X899_0_Ret, result = " + paramInt2 + "strErrorMsg = " + paramString);
  }
  
  protected void a(boolean paramBoolean, long paramLong, RespBatchProcess paramRespBatchProcess)
  {
    int i = 0;
    if ((this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.a.jdField_a_of_type_AndroidWidgetTextView != null)) {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onBatchGetTroopInfoResp, isSucc=").append(paramBoolean).append(", mTroopInfoData IsNull=");
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)
      {
        paramBoolean = true;
        localObject = ((StringBuilder)localObject).append(paramBoolean).append(", resp IsNull=");
        if (paramRespBatchProcess != null) {
          break label171;
        }
        paramBoolean = true;
        label101:
        QLog.d("Q.chatopttroop", 2, paramBoolean);
      }
    }
    else
    {
      if ((paramRespBatchProcess != null) && (paramRespBatchProcess.batch_response_list != null) && (paramRespBatchProcess.batch_response_list.size() != 0) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)) {
        break label176;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "onBatchGetTroopInfoResp, return");
      }
    }
    label171:
    label176:
    label248:
    int j;
    do
    {
      do
      {
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label101;
        if (String.valueOf(paramLong).equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
          break label248;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.chatopttroop", 2, "onBatchGetTroopInfoResp  fiter resp, curTroopUin = " + this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + ",respUin = " + paramLong);
      return;
      j = paramRespBatchProcess.batch_response_list.size();
      if (i < j)
      {
        localObject = (BatchResponse)paramRespBatchProcess.batch_response_list.get(i);
        if ((localObject == null) || (((BatchResponse)localObject).result != 0)) {}
        for (;;)
        {
          i += 1;
          break;
          if (((BatchResponse)localObject).type == 1) {
            this.a.a((BatchResponse)localObject);
          }
        }
      }
    } while (j <= 0);
    azlj.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
    this.a.b(true);
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.e != null)) {
      this.a.a(this.a.e);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!azzz.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "onGetTroopInfoResult|uin = " + paramString);
      }
      paramString = ((TroopManager)this.a.app.getManager(52)).b(paramString);
    } while (paramString == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramString;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(paramString, this.a.getResources(), this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!paramBoolean)
    {
      bbmy.a(this.a, this.a.getString(2131630787), 0).b(this.a.getTitleBarHeight());
      ChatSettingForTroop.k(this.a);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (TextUtils.equals(paramString1, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin)))
    {
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getLatestMemo();
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("get last memo [%s, %s]", new Object[] { paramString1, str }));
      }
      if (!TextUtils.isEmpty(str))
      {
        paramString1 = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage();
        paramString1.what = 20;
        paramString1.obj = str;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
      }
      ChatSettingForTroop.a(this.a, str);
    }
  }
  
  protected void a(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    boolean bool;
    do
    {
      return;
      if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
      for (bool = false;; bool = a(paramArrayList))
      {
        if (this.a.jdField_a_of_type_Bbmv == null) {
          this.a.jdField_a_of_type_Bbmv = new bbmv(this.a);
        }
        if ((paramBoolean) || (TextUtils.isEmpty(paramString))) {
          break;
        }
        this.a.jdField_a_of_type_Bbmv.a(2, paramString, 1000);
        return;
      }
      if ((!paramBoolean) && ((this.a.b & 0x1) == 1))
      {
        paramArrayList = this.a;
        paramArrayList.b &= 0xFFFFFFFE;
        this.a.jdField_a_of_type_Bbmv.b(2, 2131628646, 1000);
        return;
      }
    } while ((!bool) || ((this.a.b & 0x1) != 1));
    paramArrayList = this.a;
    paramArrayList.b &= 0xFFFFFFFE;
    this.a.jdField_a_of_type_Bbmv.b(1, 2131628647, 1000);
  }
  
  protected void a(boolean paramBoolean1, ArrayList<TroopMemberCardInfo> paramArrayList, boolean paramBoolean2)
  {
    ThreadManager.post(new ChatSettingForTroop.32.1(this), 8, null, true);
  }
  
  protected boolean a(ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    int i = 0;
    Object localObject = null;
    if ((localObject == null) && (i < paramArrayList.size()))
    {
      TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i);
      if (localTroopMemberCardInfo == null) {
        localObject = localTroopMemberCardInfo;
      }
      for (;;)
      {
        i += 1;
        break;
        if (azzz.a(localTroopMemberCardInfo.troopuin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
        {
          localObject = localTroopMemberCardInfo;
          if (azzz.a(localTroopMemberCardInfo.memberuin, this.a.app.getCurrentAccountUin())) {}
        }
        else
        {
          localObject = null;
        }
      }
    }
    paramArrayList = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard;
    if ((localObject != null) && (!azzz.a(paramArrayList, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard)))
    {
      paramArrayList = localObject.name;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopColorNick = localObject.colorNick;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCard = localObject.name;
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    }
    return localObject != null;
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nNewFileMsgNum = babl.a(this.a.app.getCurrentAccountUin(), "troop_file_new", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nUnreadFileMsgnum = 0;
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
    }
  }
  
  protected void b(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      if ((paramBoolean2) && (this.a.app != null)) {
        ((azrx)this.a.app.getManager(234)).a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
    }
    for (;;)
    {
      ChatSettingForTroop.l(this.a);
      return;
      bbmy.a(BaseApplication.getContext(), 2131630710, 0).b(this.a.getTitleBarHeight());
    }
  }
  
  protected void b(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0));
      localObject = null;
      int i = 0;
      if ((localObject == null) && (i < paramArrayList.size()))
      {
        TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
        if (localTroopInfo == null) {
          localObject = localTroopInfo;
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = localTroopInfo;
          if (!azzz.a(localTroopInfo.troopuin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
            localObject = null;
          }
        }
      }
    } while (localObject == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localObject;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopChatSetting(localObject, this.a.getResources(), this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    try
    {
      long l1 = Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      long l2 = Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopCode);
      azkm.a(this.a.app, 0, l2, l1, 0L, "", 0, "OidbSvc.0x852_48", (short)23, false, false);
      return;
    }
    catch (Exception paramArrayList) {}
  }
  
  protected void c(boolean paramBoolean, String paramString) {}
  
  protected void c(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      this.a.i = paramInt;
    }
  }
  
  protected void c(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while ((!paramBoolean) || (paramArrayList == null)) {
      return;
    }
    a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaks
 * JD-Core Version:    0.7.0.1
 */