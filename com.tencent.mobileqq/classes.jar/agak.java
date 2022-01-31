import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41.1;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41.2;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41.3;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41.4;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41.5;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41.6;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMember;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.UserInfo;

public class agak
  extends akim
{
  public agak(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin))) {
      return;
    }
    this.a.a(paramString2);
    this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(9));
  }
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (!this.a.jdField_c_of_type_JavaLangString.equals(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.history.BaseFragment", 2, "onUpdateTroopGetMemberList,!mTroopUin.equals(troopUin)==>mTroopUin:" + this.a.jdField_c_of_type_JavaLangString + "|troopUin:" + paramString);
      }
    }
    do
    {
      do
      {
        return;
        paramInt2 = ChatHistoryTroopMemberFragment.d(this.a);
        if (paramInt2 == paramInt1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.history.BaseFragment", 2, "onUpdateTroopGetMemberList,realReqType != reqType, realReqType:" + paramInt2 + "|reqType:" + paramInt1);
      return;
      if (this.a.jdField_a_of_type_Long == paramLong) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.history.BaseFragment", 2, "onUpdateTroopGetMemberList,mMemberListReqStartTime != reqTimestamp, mMemberListReqStartTime:" + this.a.jdField_a_of_type_Long + "|reqTimestamp:" + paramLong);
    return;
    paramLong = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = localStringBuilder1.append("Thread id:").append(Thread.currentThread().getId()).append(",threadName:").append(Thread.currentThread().getName()).append("|onUpdateTroopGetMemberList:").append(paramBoolean).append("|troopMemberInfoList size:");
      if (paramList == null)
      {
        paramString = "";
        label254:
        localStringBuilder2.append(paramString).append("|time:").append((paramLong - this.a.jdField_a_of_type_Long) / 1000L).append("s");
        QLog.d("Q.history.BaseFragment", 2, localStringBuilder1.toString());
      }
    }
    else
    {
      if (!paramBoolean) {
        break label560;
      }
    }
    for (;;)
    {
      try
      {
        this.a.getActivity().getSharedPreferences("last_update_time" + this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).edit().putLong("key_last_update_time" + this.a.jdField_c_of_type_JavaLangString, System.currentTimeMillis()).commit();
        this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
        if ((this.a.jdField_d_of_type_Int == 13) || (this.a.jdField_d_of_type_Int == 21)) {
          break label512;
        }
        this.a.a(this.a.jdField_c_of_type_JavaLangString, paramList);
        this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, Boolean.valueOf(paramBoolean)));
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.history.BaseFragment", 2, "onUpdateTroopGetMemberList:" + paramString.toString());
      return;
      paramString = Integer.valueOf(paramList.size());
      break label254;
      label512:
      paramString = this.a.a(this.a.jdField_c_of_type_JavaLangString, this.a.jdField_e_of_type_JavaUtilList);
      this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(2, paramString));
    }
    label560:
    if ((this.a.jdField_d_of_type_Int != 13) && (this.a.jdField_d_of_type_Int != 21)) {
      this.a.a(this.a.jdField_c_of_type_JavaLangString, null);
    }
    for (;;)
    {
      this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(5, Boolean.valueOf(paramBoolean)));
      return;
      paramString = this.a.a(this.a.jdField_c_of_type_JavaLangString, this.a.jdField_e_of_type_JavaUtilList);
      this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(2, paramString));
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "onDeleteTroopMember, isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    }
    if (paramBoolean)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        this.a.jdField_o_of_type_Boolean = true;
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          this.a.a(str);
        }
        if (this.a.jdField_d_of_type_Int == 15) {
          ChatHistoryTroopMemberFragment.a(this.a, paramArrayList);
        }
        this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(6));
      }
      return;
    }
    if (paramInt == 2)
    {
      this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(15));
      return;
    }
    this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(7));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!bbbd.a(String.valueOf(paramLong1), this.a.jdField_c_of_type_JavaLangString)) {}
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(150);
        localStringBuilder.append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
        QLog.i("Q.history.BaseFragment", 2, localStringBuilder.toString());
      }
      if ((paramInt1 == 1) && (paramBoolean)) {
        ThreadManager.post(new ChatHistoryTroopMemberFragment.41.3(this, paramList), 5, null, true);
      }
    } while ((paramInt1 != 2) || (!paramBoolean));
    ThreadManager.post(new ChatHistoryTroopMemberFragment.41.4(this, paramList), 8, null, true);
  }
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString, List<String> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.jdField_c_of_type_JavaLangString)) && (this.a.m == 1) && (paramList != null)) {
      ThreadManager.getUIHandler().post(new ChatHistoryTroopMemberFragment.41.5(this, paramList));
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3)
  {
    this.a.getActivity().runOnUiThread(new ChatHistoryTroopMemberFragment.41.1(this, paramBoolean1, paramString1, paramBoolean2, paramString2, paramString3, paramBoolean3));
  }
  
  protected void a(boolean paramBoolean, List<cmd0x406.GroupFeeMember> paramList)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment.troop.troop_fee", 2, "onGetTroopFeeMemberList : isSuccess=" + paramBoolean);
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      cmd0x406.GroupFeeMember localGroupFeeMember = (cmd0x406.GroupFeeMember)localIterator.next();
      agau localagau = new agau();
      localagau.a = (localGroupFeeMember.uint64_uin.get() + "");
      localagau.b = localGroupFeeMember.string_nick_name.get();
      if (this.a.jdField_a_of_type_Agbh != null) {
        this.a.jdField_a_of_type_Agbh.a(localagau);
      }
      localArrayList.add(localagau);
    }
    this.a.jdField_c_of_type_Int = paramList.size();
    this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(1, new Object[] { localArrayList }));
  }
  
  protected void b(String paramString1, String paramString2, String paramString3)
  {
    if (!this.a.jdField_c_of_type_JavaLangString.equals(paramString1)) {
      return;
    }
    ThreadManager.post(new ChatHistoryTroopMemberFragment.41.2(this, paramString2), 8, null, true);
  }
  
  protected void b(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.b(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "onOIDB0X899_1_Ret, isSuccess:" + paramBoolean + " returnUin:" + paramLong1 + " mTroopUin:" + this.a.jdField_c_of_type_JavaLangString + " time:" + (System.currentTimeMillis() - this.a.jdField_b_of_type_Long) / 1000L + "s");
    }
    if ((!paramBoolean) || (!this.a.jdField_c_of_type_JavaLangString.equals(Long.toString(paramLong1)))) {}
    do
    {
      return;
      this.a.getActivity().getSharedPreferences("last_update_time" + this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).edit().putLong("key_troop_info_last_update" + this.a.jdField_c_of_type_JavaLangString, System.currentTimeMillis()).commit();
    } while (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null);
    paramString = this.a;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isHomeworkTroop()))
    {
      paramBoolean = true;
      paramString.jdField_e_of_type_Boolean = paramBoolean;
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin != null) {
        this.a.f = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin;
      }
      this.a.g = bamn.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, paramList, false);
      paramList = this.a;
      if ((!this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopowneruin)) && ((this.a.g == null) || (!this.a.g.contains(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))) {
        break label458;
      }
      paramBoolean = true;
      label380:
      paramList.jdField_d_of_type_Boolean = paramBoolean;
      if ((this.a.f == null) || (!this.a.f.equals(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        break label463;
      }
    }
    for (this.a.jdField_o_of_type_JavaLangString = "0";; this.a.jdField_o_of_type_JavaLangString = "1") {
      label458:
      label463:
      do
      {
        this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(9));
        return;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label380;
      } while ((this.a.g == null) || (!this.a.g.contains(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())));
    }
  }
  
  protected void c(boolean paramBoolean, String paramString, List<oidb_0xa2a.UserInfo> paramList)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.jdField_c_of_type_JavaLangString)) && (this.a.m == 8) && (paramList != null)) {
      ThreadManager.getUIHandler().post(new ChatHistoryTroopMemberFragment.41.6(this, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agak
 * JD-Core Version:    0.7.0.1
 */