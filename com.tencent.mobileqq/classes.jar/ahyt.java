import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ahyt
  extends bjyh
{
  ahyt(ahyl paramahyl) {}
  
  protected void a(boolean paramBoolean, bjyj parambjyj)
  {
    boolean bool = true;
    if ((paramBoolean) && (parambjyj != null)) {
      if ((this.a.sessionInfo.curFriendUin != null) && (this.a.sessionInfo.curFriendUin.equals(String.valueOf(parambjyj.jdField_a_of_type_Long)))) {
        if (parambjyj.jdField_a_of_type_Int == 1)
        {
          localbjyk = (bjyk)this.a.app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_PA_BIG_DATA_HANDLER);
          localPubAccountNavigationMenu = localbjyk.a(this.a.sessionInfo.curFriendUin);
          localahyl = this.a;
          if (parambjyj.jdField_b_of_type_Int == 0)
          {
            paramBoolean = bool;
            ahyl.b(localahyl, paramBoolean);
            if ((localPubAccountNavigationMenu != null) && (parambjyj.jdField_b_of_type_Int == localPubAccountNavigationMenu.version)) {
              break label153;
            }
            localbjyk.a(this.a.sessionInfo.curFriendUin, parambjyj.jdField_b_of_type_Long);
          }
        }
      }
    }
    label153:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          PubAccountNavigationMenu localPubAccountNavigationMenu;
          for (;;)
          {
            bjyk localbjyk;
            ahyl localahyl;
            return;
            paramBoolean = false;
          }
          if (QLog.isColorLevel()) {
            QLog.d("BusinessChatPie", 2, "onGetNatigationStatus show directly");
          }
          if (ahyl.a(this.a) == 0)
          {
            this.a.a(localPubAccountNavigationMenu);
            return;
          }
          ahyl.a(this.a, 0);
          return;
          if (parambjyj.c == 1) {
            ahyl.a(this.a, 1);
          }
        } while (!QLog.isColorLevel());
        QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response no need show");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response not the same aio");
      return;
    }
    QLog.d("BusinessChatPie", 2, "onGetNatigationStatus response error");
  }
  
  protected void a(boolean paramBoolean, PubAccountNavigationMenu paramPubAccountNavigationMenu)
  {
    if (paramBoolean) {
      if ((!ahyl.b(this.a)) && (ahyl.a(this.a) != 0)) {
        ahyl.a(this.a, 0);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      this.a.a(paramPubAccountNavigationMenu);
      return;
    }
    QLog.d("BusinessChatPie", 2, "onGetNatigation response error");
  }
  
  protected void b(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      if (this.a.sessionInfo.curFriendUin.equals(paramHashMap.uin))
      {
        if ((TextUtils.isEmpty(this.a.sessionInfo.curFriendNick)) || (this.a.sessionInfo.curFriendNick.equals(this.a.sessionInfo.curFriendUin)))
        {
          this.a.sessionInfo.curFriendNick = paramHashMap.nickname;
          this.a.mTitleText.setText(this.a.sessionInfo.curFriendNick);
        }
        this.a.updateSession_updateTitleBtnCall();
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("BusinessChatPie", 2, "onGetQidianMasterInfo not current uin");
      return;
    }
    QLog.d("BusinessChatPie", 2, "onGetQidianMasterInfo fail");
  }
  
  protected void e(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    int i = 0;
    super.e(paramBoolean, paramHashMap);
    if ((paramBoolean) && (paramHashMap != null)) {}
    try
    {
      int j = Integer.parseInt(String.valueOf(paramHashMap.get("result")));
      String.valueOf(paramHashMap.get("master_uin"));
      if ((this.a.sessionInfo.curFriendUin != null) && (j == 1))
      {
        long l1 = Long.parseLong(this.a.sessionInfo.curFriendUin);
        paramHashMap = ((bjyk)this.a.app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_PA_BIG_DATA_HANDLER)).a(this.a.sessionInfo.curFriendUin);
        bjyi localbjyi = (bjyi)this.a.app.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER);
        long l2 = this.a.app.getLongAccountUin();
        if (paramHashMap != null) {
          i = paramHashMap.version;
        }
        localbjyi.a(l1, l2, i, ahyl.a(this.a), false);
      }
      return;
    }
    catch (Exception paramHashMap) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyt
 * JD-Core Version:    0.7.0.1
 */