import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class aish
  extends bbwf
{
  aish(airz paramairz) {}
  
  public void onDone(bbwg parambbwg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download onDone");
    }
    if (parambbwg.a() == 3) {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_download_success", 0, 0, new String[0]);
    }
    if (this.a.jdField_a_of_type_Ajom != null) {
      this.a.jdField_a_of_type_Ajom.b();
    }
  }
  
  public void onDoneFile(bbwg parambbwg)
  {
    if (parambbwg == null) {}
    label314:
    label320:
    for (;;)
    {
      return;
      String str1 = parambbwg.c;
      parambbwg = parambbwg.a();
      if (parambbwg != null)
      {
        parambbwg = (ApolloActionData)parambbwg.getSerializable(str1);
        if (parambbwg == null)
        {
          QLog.e("ApolloManager", 1, "action res onDoneFile but action data is null");
          return;
        }
        String str2 = ApolloUtil.a(parambbwg, 4);
        if (str1.equals(ApolloUtil.a(parambbwg, 5)))
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "action res zip done acitonid=" + parambbwg.actionId + " action name =" + parambbwg.actionName);
            }
            if (!ApolloUtil.a(parambbwg.actionId, parambbwg.personNum))
            {
              bbdj.a(str2, ApolloUtil.a(parambbwg, 6), false);
              bbdj.d(str2);
              this.a.a(parambbwg);
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
          if (parambbwg.compoundType <= 0) {
            break label314;
          }
        }
        for (boolean bool = ApolloUtil.a(parambbwg.actionId, 1, parambbwg.personNum, false);; bool = ApolloUtil.a(parambbwg))
        {
          if ((!bool) || (this.a.jdField_a_of_type_Ajom == null)) {
            break label320;
          }
          parambbwg.status = 1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            ((ajmw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(parambbwg);
          }
          this.a.jdField_a_of_type_Ajom.a(parambbwg);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, "onDoneFile panelView actionId = " + parambbwg.actionId + " action name =" + parambbwg.actionName);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aish
 * JD-Core Version:    0.7.0.1
 */