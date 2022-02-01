import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.data.PubAccountNavigationMenu;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aihp
  extends bkia
{
  aihp(aihh paramaihh) {}
  
  protected void a(boolean paramBoolean, bkic parambkic)
  {
    boolean bool = true;
    if ((paramBoolean) && (parambkic != null)) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(String.valueOf(parambkic.jdField_a_of_type_Long)))) {
        if (parambkic.jdField_a_of_type_Int == 1)
        {
          localbkid = (bkid)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(105);
          localPubAccountNavigationMenu = localbkid.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          localaihh = this.a;
          if (parambkic.jdField_b_of_type_Int == 0)
          {
            paramBoolean = bool;
            aihh.b(localaihh, paramBoolean);
            if ((localPubAccountNavigationMenu != null) && (parambkic.jdField_b_of_type_Int == localPubAccountNavigationMenu.version)) {
              break label152;
            }
            localbkid.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, parambkic.jdField_b_of_type_Long);
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
            bkid localbkid;
            aihh localaihh;
            return;
            paramBoolean = false;
          }
          if (QLog.isColorLevel()) {
            QLog.d("BusinessChatPie", 2, "onGetNatigationStatus show directly");
          }
          if (aihh.a(this.a) == 0)
          {
            this.a.a(localPubAccountNavigationMenu);
            return;
          }
          aihh.a(this.a, 0);
          return;
          if (parambkic.c == 1) {
            aihh.a(this.a, 1);
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
      if ((!aihh.b(this.a)) && (aihh.a(this.a) != 0)) {
        aihh.a(this.a, 0);
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
        paramHashMap = ((bkid)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(105)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        bkib localbkib = (bkib)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(85);
        long l2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
        if (paramHashMap != null) {
          i = paramHashMap.version;
        }
        localbkib.a(l1, l2, i, aihh.a(this.a), false);
      }
      return;
    }
    catch (Exception paramHashMap) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihp
 * JD-Core Version:    0.7.0.1
 */