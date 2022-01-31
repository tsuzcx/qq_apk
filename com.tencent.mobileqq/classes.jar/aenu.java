import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class aenu
  implements bfoq
{
  aenu(aeno paramaeno, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bfol.cancel();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        paramView = this.jdField_a_of_type_Aeno.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      } while ((this.jdField_a_of_type_Aeno.a() == null) || (this.jdField_a_of_type_Aeno.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(paramView)) || (this.jdField_a_of_type_Aeno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
      try
      {
        localObject1 = xkq.b(paramView, xkq.b(2));
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Aeno.jdField_a_of_type_JavaLangString, 2, "openMoreOptions uin:" + paramView + " uinCode:" + (String)localObject1);
        }
        localObject2 = this.jdField_a_of_type_Aeno.a();
        Object localObject3 = new ArrayList();
        if (localObject2 != null) {
          ((List)localObject3).addAll((Collection)localObject2);
        }
        localObject2 = xkq.a(paramView, this.jdField_a_of_type_Aeno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 21002, 10, (List)localObject3);
        localObject3 = ((String)localObject2).replaceAll(paramView, (String)localObject1);
        Bundle localBundle = xkq.a(this.jdField_a_of_type_Aeno.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Aeno.jdField_a_of_type_JavaLangString, 2, "openMoreOptions safetyReport reportMsgOrg: " + (String)localObject2 + "  reportMsg: " + (String)localObject3);
        }
        xkq.a(this.jdField_a_of_type_Aeno.a(), paramView, (String)localObject1, null, null, this.jdField_a_of_type_Aeno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 21002, (String)localObject3, localBundle);
      }
      catch (Throwable paramView)
      {
        for (;;)
        {
          QLog.e(this.jdField_a_of_type_Aeno.jdField_a_of_type_JavaLangString, 1, "openMoreOptions safetyReport error" + paramView.getMessage());
        }
      }
      axqw.b(this.jdField_a_of_type_Aeno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80091A4", "0X80091A4", 0, 0, "", "", "", "");
      return;
      paramView = this.jdField_a_of_type_Aeno.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    } while ((this.jdField_a_of_type_Aeno.a() == null) || (this.jdField_a_of_type_Aeno.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(paramView)) || (this.jdField_a_of_type_Aeno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    Object localObject1 = (amnl)this.jdField_a_of_type_Aeno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(125);
    Object localObject2 = ((amno)this.jdField_a_of_type_Aeno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(269)).b();
    if (localObject2 == null) {}
    for (paramInt = 24;; paramInt = ((amnk)localObject2).j)
    {
      ((amnl)localObject1).a(paramView, this.jdField_a_of_type_Aeno.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Aeno.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, this.jdField_a_of_type_Aeno.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo, paramInt);
      this.jdField_a_of_type_Aeno.a(0, amnk.h, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aenu
 * JD-Core Version:    0.7.0.1
 */