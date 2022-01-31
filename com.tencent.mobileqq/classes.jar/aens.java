import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class aens
  implements bfph
{
  aens(aenm paramaenm, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bfpc.cancel();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        paramView = this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      } while ((this.jdField_a_of_type_Aenm.a() == null) || (this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(paramView)) || (this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
      try
      {
        localObject1 = xkn.b(paramView, xkn.b(2));
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Aenm.jdField_a_of_type_JavaLangString, 2, "openMoreOptions uin:" + paramView + " uinCode:" + (String)localObject1);
        }
        localObject2 = this.jdField_a_of_type_Aenm.a();
        Object localObject3 = new ArrayList();
        if (localObject2 != null) {
          ((List)localObject3).addAll((Collection)localObject2);
        }
        localObject2 = xkn.a(paramView, this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 21002, 10, (List)localObject3);
        localObject3 = ((String)localObject2).replaceAll(paramView, (String)localObject1);
        Bundle localBundle = xkn.a(this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Aenm.jdField_a_of_type_JavaLangString, 2, "openMoreOptions safetyReport reportMsgOrg: " + (String)localObject2 + "  reportMsg: " + (String)localObject3);
        }
        xkn.a(this.jdField_a_of_type_Aenm.a(), paramView, (String)localObject1, null, null, this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 21002, (String)localObject3, localBundle);
      }
      catch (Throwable paramView)
      {
        for (;;)
        {
          QLog.e(this.jdField_a_of_type_Aenm.jdField_a_of_type_JavaLangString, 1, "openMoreOptions safetyReport error" + paramView.getMessage());
        }
      }
      axqy.b(this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80091A4", "0X80091A4", 0, 0, "", "", "", "");
      return;
      paramView = this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    } while ((this.jdField_a_of_type_Aenm.a() == null) || (this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(paramView)) || (this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    Object localObject1 = (amnk)this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(125);
    Object localObject2 = ((amnn)this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b();
    if (localObject2 == null) {}
    for (paramInt = 24;; paramInt = ((amnj)localObject2).j)
    {
      ((amnk)localObject1).a(paramView, this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, this.jdField_a_of_type_Aenm.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo, paramInt);
      this.jdField_a_of_type_Aenm.a(0, amnj.h, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aens
 * JD-Core Version:    0.7.0.1
 */