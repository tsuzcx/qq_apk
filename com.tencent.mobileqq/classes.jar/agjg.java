import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class agjg
  extends bfvh
{
  agjg(agiy paramagiy) {}
  
  protected void a(boolean paramBoolean, bfvj parambfvj)
  {
    boolean bool = true;
    if ((paramBoolean) && (parambfvj != null)) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(String.valueOf(parambfvj.jdField_a_of_type_Long)))) {
        if (parambfvj.jdField_a_of_type_Int == 1)
        {
          localbfvk = (bfvk)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(105);
          localPubAccountNavigationMenu = localbfvk.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          localagiy = this.a;
          if (parambfvj.jdField_b_of_type_Int == 0)
          {
            paramBoolean = bool;
            agiy.b(localagiy, paramBoolean);
            if ((localPubAccountNavigationMenu != null) && (parambfvj.jdField_b_of_type_Int == localPubAccountNavigationMenu.version)) {
              break label152;
            }
            localbfvk.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, parambfvj.jdField_b_of_type_Long);
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
            bfvk localbfvk;
            agiy localagiy;
            return;
            paramBoolean = false;
          }
          if (QLog.isColorLevel()) {
            QLog.d("BusinessChatPie", 2, "onGetNatigationStatus show directly");
          }
          if (agiy.a(this.a) == 0)
          {
            this.a.a(localPubAccountNavigationMenu);
            return;
          }
          agiy.a(this.a, 0);
          return;
          if (parambfvj.c == 1) {
            agiy.a(this.a, 1);
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
      if ((!agiy.b(this.a)) && (agiy.a(this.a) != 0)) {
        agiy.a(this.a, 0);
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
        paramHashMap = ((bfvk)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(105)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        bfvi localbfvi = (bfvi)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
        long l2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
        if (paramHashMap != null) {
          i = paramHashMap.version;
        }
        localbfvi.a(l1, l2, i, agiy.a(this.a), false);
      }
      return;
    }
    catch (Exception paramHashMap) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjg
 * JD-Core Version:    0.7.0.1
 */