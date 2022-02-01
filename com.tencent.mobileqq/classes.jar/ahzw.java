import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class ahzw
  implements bkzq
{
  ahzw(ahzq paramahzq, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bkzi.cancel();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        paramView = this.jdField_a_of_type_Ahzq.sessionInfo.curFriendUin;
      } while ((this.jdField_a_of_type_Ahzq.getActivity() == null) || (this.jdField_a_of_type_Ahzq.sessionInfo == null) || (TextUtils.isEmpty(paramView)) || (this.jdField_a_of_type_Ahzq.app == null));
      try
      {
        localObject1 = aaqo.b(paramView, aaqo.b(2));
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Ahzq.tag, 2, "openMoreOptions uin:" + paramView + " uinCode:" + (String)localObject1);
        }
        localObject2 = this.jdField_a_of_type_Ahzq.getAIOList();
        Object localObject3 = new ArrayList();
        if (localObject2 != null) {
          ((List)localObject3).addAll((Collection)localObject2);
        }
        localObject2 = aaqo.a(paramView, this.jdField_a_of_type_Ahzq.app.getCurrentAccountUin(), 21002, 10, (List)localObject3);
        localObject3 = ((String)localObject2).replaceAll(paramView, (String)localObject1);
        Bundle localBundle = aaqo.a(this.jdField_a_of_type_Ahzq.sessionInfo);
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Ahzq.tag, 2, "openMoreOptions safetyReport reportMsgOrg: " + (String)localObject2 + "  reportMsg: " + (String)localObject3);
        }
        aaqo.a(this.jdField_a_of_type_Ahzq.getActivity(), paramView, (String)localObject1, null, null, this.jdField_a_of_type_Ahzq.app.getCurrentAccountUin(), 21002, (String)localObject3, localBundle);
      }
      catch (Throwable paramView)
      {
        for (;;)
        {
          QLog.e(this.jdField_a_of_type_Ahzq.tag, 1, "openMoreOptions safetyReport error" + paramView.getMessage());
        }
      }
      bdla.b(this.jdField_a_of_type_Ahzq.app, "dc00898", "", "", "0X80091A4", "0X80091A4", 0, 0, "", "", "", "");
      return;
      paramView = this.jdField_a_of_type_Ahzq.sessionInfo.curFriendUin;
    } while ((this.jdField_a_of_type_Ahzq.getActivity() == null) || (this.jdField_a_of_type_Ahzq.sessionInfo == null) || (TextUtils.isEmpty(paramView)) || (this.jdField_a_of_type_Ahzq.app == null));
    Object localObject1 = (aqva)this.jdField_a_of_type_Ahzq.app.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER);
    Object localObject2 = ((aqvd)this.jdField_a_of_type_Ahzq.app.getManager(QQManagerFactory.CONFESS_MANAGER)).b();
    if (localObject2 == null) {}
    for (paramInt = 24;; paramInt = ((aquz)localObject2).j)
    {
      ((aqva)localObject1).a(paramView, this.jdField_a_of_type_Ahzq.sessionInfo.curType, this.jdField_a_of_type_Ahzq.sessionInfo.topicId, this.jdField_a_of_type_Ahzq.a, paramInt);
      this.jdField_a_of_type_Ahzq.a(0, aquz.h, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzw
 * JD-Core Version:    0.7.0.1
 */