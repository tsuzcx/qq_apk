import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aemp
  extends bdvm
{
  aemp(aemh paramaemh) {}
  
  protected void a(boolean paramBoolean, bdvo parambdvo)
  {
    boolean bool = true;
    if ((paramBoolean) && (parambdvo != null)) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(String.valueOf(parambdvo.jdField_a_of_type_Long)))) {
        if (parambdvo.jdField_a_of_type_Int == 1)
        {
          localbdvp = (bdvp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(105);
          localPubAccountNavigationMenu = localbdvp.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          localaemh = this.a;
          if (parambdvo.jdField_b_of_type_Int == 0)
          {
            paramBoolean = bool;
            aemh.b(localaemh, paramBoolean);
            if ((localPubAccountNavigationMenu != null) && (parambdvo.jdField_b_of_type_Int == localPubAccountNavigationMenu.version)) {
              break label152;
            }
            localbdvp.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, parambdvo.jdField_b_of_type_Long);
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
            bdvp localbdvp;
            aemh localaemh;
            return;
            paramBoolean = false;
          }
          if (QLog.isColorLevel()) {
            QLog.d("BusinessChatPie", 2, "onGetNatigationStatus show directly");
          }
          if (aemh.a(this.a) == 0)
          {
            this.a.a(localPubAccountNavigationMenu);
            return;
          }
          aemh.a(this.a, 0);
          return;
          if (parambdvo.c == 1) {
            aemh.a(this.a, 1);
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
      if ((!aemh.b(this.a)) && (aemh.a(this.a) != 0)) {
        aemh.a(this.a, 0);
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
        this.a.s();
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
        paramHashMap = ((bdvp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(105)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        bdvn localbdvn = (bdvn)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
        long l2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
        if (paramHashMap != null) {
          i = paramHashMap.version;
        }
        localbdvn.a(l1, l2, i, aemh.a(this.a), false);
      }
      return;
    }
    catch (Exception paramHashMap) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aemp
 * JD-Core Version:    0.7.0.1
 */