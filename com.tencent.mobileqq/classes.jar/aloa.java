import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;

class aloa
  extends bgod
{
  aloa(alnr paramalnr) {}
  
  public void onDone(bgoe parambgoe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download onDone");
    }
    if (parambgoe.a() == 3) {
      VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_download_success", 0, 0, new String[0]);
    }
    if (this.a.jdField_a_of_type_Amki != null) {
      this.a.jdField_a_of_type_Amki.b();
    }
  }
  
  public void onDoneFile(bgoe parambgoe)
  {
    if (parambgoe == null) {}
    label314:
    label320:
    for (;;)
    {
      return;
      String str1 = parambgoe.c;
      parambgoe = parambgoe.a();
      if (parambgoe != null)
      {
        parambgoe = (ApolloActionData)parambgoe.getSerializable(str1);
        if (parambgoe == null)
        {
          QLog.e("ApolloManager", 1, "action res onDoneFile but action data is null");
          return;
        }
        String str2 = ApolloUtil.a(parambgoe, 4);
        if (str1.equals(ApolloUtil.a(parambgoe, 5)))
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "action res zip done acitonid=" + parambgoe.actionId + " action name =" + parambgoe.actionName);
            }
            if (!ApolloUtil.a(parambgoe.actionId, parambgoe.personNum))
            {
              FileUtils.uncompressZip(str2, ApolloUtil.a(parambgoe, 6), false);
              FileUtils.deleteFile(str2);
              this.a.a(parambgoe);
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
          if (parambgoe.compoundType <= 0) {
            break label314;
          }
        }
        for (boolean bool = ApolloUtil.a(parambgoe.actionId, 1, parambgoe.personNum, false);; bool = ApolloUtil.a(parambgoe))
        {
          if ((!bool) || (this.a.jdField_a_of_type_Amki == null)) {
            break label320;
          }
          parambgoe.status = 1;
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            ((amir)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).b(parambgoe);
          }
          this.a.jdField_a_of_type_Amki.a(parambgoe);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, "onDoneFile panelView actionId = " + parambgoe.actionId + " action name =" + parambgoe.actionName);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aloa
 * JD-Core Version:    0.7.0.1
 */