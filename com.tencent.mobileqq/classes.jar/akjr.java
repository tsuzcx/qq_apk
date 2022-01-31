import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class akjr
  extends bdvu
{
  akjr(akji paramakji) {}
  
  public void onDone(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download onDone");
    }
    if (parambdvv.a() == 3) {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_download_success", 0, 0, new String[0]);
    }
    if (this.a.jdField_a_of_type_Alfx != null) {
      this.a.jdField_a_of_type_Alfx.b();
    }
  }
  
  public void onDoneFile(bdvv parambdvv)
  {
    if (parambdvv == null) {}
    label314:
    label320:
    for (;;)
    {
      return;
      String str1 = parambdvv.c;
      parambdvv = parambdvv.a();
      if (parambdvv != null)
      {
        parambdvv = (ApolloActionData)parambdvv.getSerializable(str1);
        if (parambdvv == null)
        {
          QLog.e("ApolloManager", 1, "action res onDoneFile but action data is null");
          return;
        }
        String str2 = ApolloUtil.a(parambdvv, 4);
        if (str1.equals(ApolloUtil.a(parambdvv, 5)))
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "action res zip done acitonid=" + parambdvv.actionId + " action name =" + parambdvv.actionName);
            }
            if (!ApolloUtil.a(parambdvv.actionId, parambdvv.personNum))
            {
              bdcs.a(str2, ApolloUtil.a(parambdvv, 6), false);
              bdcs.d(str2);
              this.a.a(parambdvv);
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
          if (parambdvv.compoundType <= 0) {
            break label314;
          }
        }
        for (boolean bool = ApolloUtil.a(parambdvv.actionId, 1, parambdvv.personNum, false);; bool = ApolloUtil.a(parambdvv))
        {
          if ((!bool) || (this.a.jdField_a_of_type_Alfx == null)) {
            break label320;
          }
          parambdvv.status = 1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            ((aleh)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(parambdvv);
          }
          this.a.jdField_a_of_type_Alfx.a(parambdvv);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, "onDoneFile panelView actionId = " + parambdvv.actionId + " action name =" + parambdvv.actionName);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjr
 * JD-Core Version:    0.7.0.1
 */