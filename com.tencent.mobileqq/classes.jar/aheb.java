import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aheb
  extends binf
{
  aheb(ahdt paramahdt) {}
  
  protected void a(boolean paramBoolean, binh parambinh)
  {
    boolean bool = true;
    if ((paramBoolean) && (parambinh != null)) {
      if ((this.a.sessionInfo.curFriendUin != null) && (this.a.sessionInfo.curFriendUin.equals(String.valueOf(parambinh.jdField_a_of_type_Long)))) {
        if (parambinh.jdField_a_of_type_Int == 1)
        {
          localbini = (bini)this.a.app.getBusinessHandler(105);
          localPubAccountNavigationMenu = localbini.a(this.a.sessionInfo.curFriendUin);
          localahdt = this.a;
          if (parambinh.jdField_b_of_type_Int == 0)
          {
            paramBoolean = bool;
            ahdt.b(localahdt, paramBoolean);
            if ((localPubAccountNavigationMenu != null) && (parambinh.jdField_b_of_type_Int == localPubAccountNavigationMenu.version)) {
              break label152;
            }
            localbini.a(this.a.sessionInfo.curFriendUin, parambinh.jdField_b_of_type_Long);
          }
        }
      }
    }
    label152:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          PubAccountNavigationMenu localPubAccountNavigationMenu;
          for (;;)
          {
            bini localbini;
            ahdt localahdt;
            return;
            paramBoolean = false;
          }
          if (QLog.isColorLevel()) {
            QLog.d("BusinessChatPie", 2, "onGetNatigationStatus show directly");
          }
          if (ahdt.a(this.a) == 0)
          {
            this.a.a(localPubAccountNavigationMenu);
            return;
          }
          ahdt.a(this.a, 0);
          return;
          if (parambinh.c == 1) {
            ahdt.a(this.a, 1);
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
      if ((!ahdt.b(this.a)) && (ahdt.a(this.a) != 0)) {
        ahdt.a(this.a, 0);
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
        paramHashMap = ((bini)this.a.app.getBusinessHandler(105)).a(this.a.sessionInfo.curFriendUin);
        bing localbing = (bing)this.a.app.getBusinessHandler(85);
        long l2 = this.a.app.getLongAccountUin();
        if (paramHashMap != null) {
          i = paramHashMap.version;
        }
        localbing.a(l1, l2, i, ahdt.a(this.a), false);
      }
      return;
    }
    catch (Exception paramHashMap) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aheb
 * JD-Core Version:    0.7.0.1
 */