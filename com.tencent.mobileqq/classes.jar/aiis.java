import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class aiis
  implements bliz
{
  aiis(aiim paramaiim, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Blir.cancel();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        paramView = this.jdField_a_of_type_Aiim.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      } while ((this.jdField_a_of_type_Aiim.a() == null) || (this.jdField_a_of_type_Aiim.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(paramView)) || (this.jdField_a_of_type_Aiim.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
      try
      {
        localObject1 = aber.b(paramView, aber.b(2));
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Aiim.jdField_a_of_type_JavaLangString, 2, "openMoreOptions uin:" + paramView + " uinCode:" + (String)localObject1);
        }
        localObject2 = this.jdField_a_of_type_Aiim.a();
        Object localObject3 = new ArrayList();
        if (localObject2 != null) {
          ((List)localObject3).addAll((Collection)localObject2);
        }
        localObject2 = aber.a(paramView, this.jdField_a_of_type_Aiim.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 21002, 10, (List)localObject3);
        localObject3 = ((String)localObject2).replaceAll(paramView, (String)localObject1);
        Bundle localBundle = aber.a(this.jdField_a_of_type_Aiim.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Aiim.jdField_a_of_type_JavaLangString, 2, "openMoreOptions safetyReport reportMsgOrg: " + (String)localObject2 + "  reportMsg: " + (String)localObject3);
        }
        aber.a(this.jdField_a_of_type_Aiim.a(), paramView, (String)localObject1, null, null, this.jdField_a_of_type_Aiim.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 21002, (String)localObject3, localBundle);
      }
      catch (Throwable paramView)
      {
        for (;;)
        {
          QLog.e(this.jdField_a_of_type_Aiim.jdField_a_of_type_JavaLangString, 1, "openMoreOptions safetyReport error" + paramView.getMessage());
        }
      }
      bdll.b(this.jdField_a_of_type_Aiim.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80091A4", "0X80091A4", 0, 0, "", "", "", "");
      return;
      paramView = this.jdField_a_of_type_Aiim.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    } while ((this.jdField_a_of_type_Aiim.a() == null) || (this.jdField_a_of_type_Aiim.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(paramView)) || (this.jdField_a_of_type_Aiim.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    Object localObject1 = (aqym)this.jdField_a_of_type_Aiim.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(125);
    Object localObject2 = ((aqyp)this.jdField_a_of_type_Aiim.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b();
    if (localObject2 == null) {}
    for (paramInt = 24;; paramInt = ((aqyl)localObject2).j)
    {
      ((aqym)localObject1).a(paramView, this.jdField_a_of_type_Aiim.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Aiim.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, this.jdField_a_of_type_Aiim.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo, paramInt);
      this.jdField_a_of_type_Aiim.a(0, aqyl.h, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiis
 * JD-Core Version:    0.7.0.1
 */