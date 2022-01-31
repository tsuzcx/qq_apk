import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;

class aifo
  extends batl
{
  aifo(aifg paramaifg) {}
  
  public void onDone(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download onDone");
    }
    if (parambatm.a() == 3) {
      bajr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_download_success", 0, 0, new String[0]);
    }
    if (this.a.jdField_a_of_type_Ajak != null) {
      this.a.jdField_a_of_type_Ajak.b();
    }
  }
  
  public void onDoneFile(batm parambatm)
  {
    if (parambatm == null) {}
    label314:
    label320:
    for (;;)
    {
      return;
      String str1 = parambatm.c;
      parambatm = parambatm.a();
      if (parambatm != null)
      {
        parambatm = (ApolloActionData)parambatm.getSerializable(str1);
        if (parambatm == null)
        {
          QLog.e("ApolloManager", 1, "action res onDoneFile but action data is null");
          return;
        }
        String str2 = ApolloUtil.a(parambatm, 4);
        if (str1.equals(ApolloUtil.a(parambatm, 5)))
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "action res zip done acitonid=" + parambatm.actionId + " action name =" + parambatm.actionName);
            }
            if (!ApolloUtil.a(parambatm.actionId, parambatm.personNum))
            {
              bace.a(str2, ApolloUtil.a(parambatm, 6), false);
              bace.d(str2);
              this.a.a(parambatm);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("ApolloManager", 2, "uncompressZip fail zip file: " + str2, localException);
              }
            }
          }
          if (parambatm.compoundType <= 0) {
            break label314;
          }
        }
        for (boolean bool = ApolloUtil.a(parambatm.actionId, 1, parambatm.personNum, false);; bool = ApolloUtil.a(parambatm))
        {
          if ((!bool) || (this.a.jdField_a_of_type_Ajak == null)) {
            break label320;
          }
          parambatm.status = 1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            ((aiyu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(parambatm);
          }
          this.a.jdField_a_of_type_Ajak.a(parambatm);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, "onDoneFile panelView actionId = " + parambatm.actionId + " action name =" + parambatm.actionName);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aifo
 * JD-Core Version:    0.7.0.1
 */