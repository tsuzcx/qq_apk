import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class agnv
  extends bfzo
{
  agnv(agnn paramagnn) {}
  
  protected void a(boolean paramBoolean, bfzq parambfzq)
  {
    boolean bool = true;
    if ((paramBoolean) && (parambfzq != null)) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(String.valueOf(parambfzq.jdField_a_of_type_Long)))) {
        if (parambfzq.jdField_a_of_type_Int == 1)
        {
          localbfzr = (bfzr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(105);
          localPubAccountNavigationMenu = localbfzr.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          localagnn = this.a;
          if (parambfzq.jdField_b_of_type_Int == 0)
          {
            paramBoolean = bool;
            agnn.b(localagnn, paramBoolean);
            if ((localPubAccountNavigationMenu != null) && (parambfzq.jdField_b_of_type_Int == localPubAccountNavigationMenu.version)) {
              break label152;
            }
            localbfzr.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, parambfzq.jdField_b_of_type_Long);
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
            bfzr localbfzr;
            agnn localagnn;
            return;
            paramBoolean = false;
          }
          if (QLog.isColorLevel()) {
            QLog.d("BusinessChatPie", 2, "onGetNatigationStatus show directly");
          }
          if (agnn.a(this.a) == 0)
          {
            this.a.a(localPubAccountNavigationMenu);
            return;
          }
          agnn.a(this.a, 0);
          return;
          if (parambfzq.c == 1) {
            agnn.a(this.a, 1);
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
      if ((!agnn.b(this.a)) && (agnn.a(this.a) != 0)) {
        agnn.a(this.a, 0);
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
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramHashMap.uin))
      {
        if ((TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d)) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d = paramHashMap.nickname;
          this.a.e.setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        }
        this.a.r();
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
  
  protected void c(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    int i = 0;
    super.c(paramBoolean, paramHashMap);
    if ((paramBoolean) && (paramHashMap != null)) {}
    try
    {
      int j = Integer.parseInt(String.valueOf(paramHashMap.get("result")));
      String.valueOf(paramHashMap.get("master_uin"));
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (j == 1))
      {
        long l1 = Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        paramHashMap = ((bfzr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(105)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        bfzp localbfzp = (bfzp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
        long l2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
        if (paramHashMap != null) {
          i = paramHashMap.version;
        }
        localbfzp.a(l1, l2, i, agnn.a(this.a), false);
      }
      return;
    }
    catch (Exception paramHashMap) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnv
 * JD-Core Version:    0.7.0.1
 */