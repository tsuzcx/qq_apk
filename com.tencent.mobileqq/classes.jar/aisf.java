import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class aisf
  extends bbwt
{
  aisf(airx paramairx) {}
  
  public void onDone(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download onDone");
    }
    if (parambbwu.a() == 3) {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_download_success", 0, 0, new String[0]);
    }
    if (this.a.jdField_a_of_type_Ajok != null) {
      this.a.jdField_a_of_type_Ajok.b();
    }
  }
  
  public void onDoneFile(bbwu parambbwu)
  {
    if (parambbwu == null) {}
    label314:
    label320:
    for (;;)
    {
      return;
      String str1 = parambbwu.c;
      parambbwu = parambbwu.a();
      if (parambbwu != null)
      {
        parambbwu = (ApolloActionData)parambbwu.getSerializable(str1);
        if (parambbwu == null)
        {
          QLog.e("ApolloManager", 1, "action res onDoneFile but action data is null");
          return;
        }
        String str2 = ApolloUtil.a(parambbwu, 4);
        if (str1.equals(ApolloUtil.a(parambbwu, 5)))
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "action res zip done acitonid=" + parambbwu.actionId + " action name =" + parambbwu.actionName);
            }
            if (!ApolloUtil.a(parambbwu.actionId, parambbwu.personNum))
            {
              bbdx.a(str2, ApolloUtil.a(parambbwu, 6), false);
              bbdx.d(str2);
              this.a.a(parambbwu);
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
          if (parambbwu.compoundType <= 0) {
            break label314;
          }
        }
        for (boolean bool = ApolloUtil.a(parambbwu.actionId, 1, parambbwu.personNum, false);; bool = ApolloUtil.a(parambbwu))
        {
          if ((!bool) || (this.a.jdField_a_of_type_Ajok == null)) {
            break label320;
          }
          parambbwu.status = 1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            ((ajmu)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(parambbwu);
          }
          this.a.jdField_a_of_type_Ajok.a(parambbwu);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, "onDoneFile panelView actionId = " + parambbwu.actionId + " action name =" + parambbwu.actionName);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aisf
 * JD-Core Version:    0.7.0.1
 */