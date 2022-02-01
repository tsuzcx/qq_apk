import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.C2CPlusPanelAppConfigHelper;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.Iterator;
import java.util.List;

public class ahwe
  extends ahwd
{
  private void a(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    b(paramBaseChatPie, paramQQAppInterface);
    c(paramBaseChatPie, paramQQAppInterface);
    c(paramBaseChatPie);
    d(paramBaseChatPie, paramQQAppInterface);
  }
  
  private void a(BaseChatPie paramBaseChatPie, List<PlusPanelAppInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        PlusPanelAppInfo localPlusPanelAppInfo = (PlusPanelAppInfo)paramList.next();
        if (localPlusPanelAppInfo.getAppID() == 215)
        {
          if ((amme.a(paramBaseChatPie.mActivity, Boolean.valueOf(false))) && (amme.a(paramBaseChatPie.getApp(), "aio", null) > 0)) {
            a(localPlusPanelAppInfo);
          }
        }
        else {
          a(localPlusPanelAppInfo);
        }
      }
    }
  }
  
  private void b(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    c(paramBaseChatPie.sessionInfo.curType);
    a(paramBaseChatPie.sessionInfo.curType, 201);
    a(paramBaseChatPie.sessionInfo.curType, 202);
    a(paramBaseChatPie.sessionInfo.curType, 203);
    if (avmh.a(paramQQAppInterface).b()) {
      a(paramBaseChatPie.sessionInfo.curType, 204);
    }
    a(paramBaseChatPie.sessionInfo.curType, 219);
    if ((ahqp.a(paramQQAppInterface).a()) && (bdfk.b())) {
      a(paramBaseChatPie.sessionInfo.curType, 209);
    }
    a(paramBaseChatPie.sessionInfo.curType, 205);
    a(paramBaseChatPie.sessionInfo.curType, 206);
    a(paramBaseChatPie.sessionInfo.curType, 207);
    if ((ahqp.a(paramQQAppInterface).a()) && (!bdfk.b())) {
      a(paramBaseChatPie.sessionInfo.curType, 209);
    }
    a(paramBaseChatPie.sessionInfo.curType, 208);
  }
  
  private void c(BaseChatPie paramBaseChatPie)
  {
    if (!apwl.jdField_a_of_type_Boolean) {
      a(paramBaseChatPie.sessionInfo.curType, 1000000001);
    }
  }
  
  private void c(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Ahvy.a(paramBaseChatPie.getActivity(), paramQQAppInterface.getCurrentAccountUin())) {
      a(paramBaseChatPie.sessionInfo.curType, 210);
    }
    a(paramBaseChatPie.sessionInfo.curType, 1000000006);
    a(paramBaseChatPie.sessionInfo.curType, 211);
    a(paramBaseChatPie.sessionInfo.curType, 212);
    a(paramBaseChatPie.sessionInfo.curType, 213);
    if (bbbf.a()) {
      a(paramBaseChatPie.sessionInfo.curType, 216);
    }
    if (((becf)paramQQAppInterface.getManager(QQManagerFactory.TEAMWORK_MANAGER)).a().booleanValue())
    {
      a(paramBaseChatPie.sessionInfo.curType, 214);
      ahpt.a(paramQQAppInterface, "0X80093F3", paramBaseChatPie.sessionInfo.curType);
    }
    if ((amme.a(paramBaseChatPie.mContext, Boolean.valueOf(false))) && (amme.a(paramQQAppInterface, "aio", null) > 0)) {
      a(paramBaseChatPie.sessionInfo.curType, 215);
    }
  }
  
  private void d(BaseChatPie paramBaseChatPie, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface.getAccount() != null) && (paramQQAppInterface.getAccount().equals(paramBaseChatPie.sessionInfo.curFriendUin)))
    {
      a(paramBaseChatPie.sessionInfo.curType, 211);
      a(paramBaseChatPie.sessionInfo.curType, 203);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      PlusPanelAppInfo localPlusPanelAppInfo = C2CPlusPanelAppConfigHelper.INSTANCE.getAppInfoByAppID(paramInt2);
      if (localPlusPanelAppInfo != null)
      {
        this.jdField_a_of_type_JavaUtilList.add(localPlusPanelAppInfo);
        return;
      }
    }
    super.a(paramInt1, paramInt2);
  }
  
  void b(BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    bdla.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOshow", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Boolean = false;
    List localList = C2CPlusPanelAppConfigHelper.INSTANCE.getC2CAppInfo();
    if (!localList.isEmpty())
    {
      this.jdField_a_of_type_Boolean = true;
      a(paramBaseChatPie, localList);
      return;
    }
    a(paramBaseChatPie, localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwe
 * JD-Core Version:    0.7.0.1
 */