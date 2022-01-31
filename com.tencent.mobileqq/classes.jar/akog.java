import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class akog
  extends bead
{
  akog(aknx paramaknx) {}
  
  public void onDone(beae parambeae)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download onDone");
    }
    if (parambeae.a() == 3) {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_download_success", 0, 0, new String[0]);
    }
    if (this.a.jdField_a_of_type_Alkm != null) {
      this.a.jdField_a_of_type_Alkm.b();
    }
  }
  
  public void onDoneFile(beae parambeae)
  {
    if (parambeae == null) {}
    label314:
    label320:
    for (;;)
    {
      return;
      String str1 = parambeae.c;
      parambeae = parambeae.a();
      if (parambeae != null)
      {
        parambeae = (ApolloActionData)parambeae.getSerializable(str1);
        if (parambeae == null)
        {
          QLog.e("ApolloManager", 1, "action res onDoneFile but action data is null");
          return;
        }
        String str2 = ApolloUtil.a(parambeae, 4);
        if (str1.equals(ApolloUtil.a(parambeae, 5)))
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "action res zip done acitonid=" + parambeae.actionId + " action name =" + parambeae.actionName);
            }
            if (!ApolloUtil.a(parambeae.actionId, parambeae.personNum))
            {
              bdhb.a(str2, ApolloUtil.a(parambeae, 6), false);
              bdhb.d(str2);
              this.a.a(parambeae);
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
          if (parambeae.compoundType <= 0) {
            break label314;
          }
        }
        for (boolean bool = ApolloUtil.a(parambeae.actionId, 1, parambeae.personNum, false);; bool = ApolloUtil.a(parambeae))
        {
          if ((!bool) || (this.a.jdField_a_of_type_Alkm == null)) {
            break label320;
          }
          parambeae.status = 1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            ((aliw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(parambeae);
          }
          this.a.jdField_a_of_type_Alkm.a(parambeae);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, "onDoneFile panelView actionId = " + parambeae.actionId + " action name =" + parambeae.actionName);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akog
 * JD-Core Version:    0.7.0.1
 */