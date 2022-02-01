import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class ahfe
  implements bjoe
{
  ahfe(ahey paramahey, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bjnw.cancel();
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        paramView = this.jdField_a_of_type_Ahey.sessionInfo.curFriendUin;
      } while ((this.jdField_a_of_type_Ahey.getActivity() == null) || (this.jdField_a_of_type_Ahey.sessionInfo == null) || (TextUtils.isEmpty(paramView)) || (this.jdField_a_of_type_Ahey.app == null));
      try
      {
        localObject1 = aabc.b(paramView, aabc.b(2));
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Ahey.tag, 2, "openMoreOptions uin:" + paramView + " uinCode:" + (String)localObject1);
        }
        localObject2 = this.jdField_a_of_type_Ahey.getAIOList();
        Object localObject3 = new ArrayList();
        if (localObject2 != null) {
          ((List)localObject3).addAll((Collection)localObject2);
        }
        localObject2 = aabc.a(paramView, this.jdField_a_of_type_Ahey.app.getCurrentAccountUin(), 21002, 10, (List)localObject3);
        localObject3 = ((String)localObject2).replaceAll(paramView, (String)localObject1);
        Bundle localBundle = aabc.a(this.jdField_a_of_type_Ahey.sessionInfo);
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Ahey.tag, 2, "openMoreOptions safetyReport reportMsgOrg: " + (String)localObject2 + "  reportMsg: " + (String)localObject3);
        }
        aabc.a(this.jdField_a_of_type_Ahey.getActivity(), paramView, (String)localObject1, null, null, this.jdField_a_of_type_Ahey.app.getCurrentAccountUin(), 21002, (String)localObject3, localBundle);
      }
      catch (Throwable paramView)
      {
        for (;;)
        {
          QLog.e(this.jdField_a_of_type_Ahey.tag, 1, "openMoreOptions safetyReport error" + paramView.getMessage());
        }
      }
      bcef.b(this.jdField_a_of_type_Ahey.app, "dc00898", "", "", "0X80091A4", "0X80091A4", 0, 0, "", "", "", "");
      return;
      paramView = this.jdField_a_of_type_Ahey.sessionInfo.curFriendUin;
    } while ((this.jdField_a_of_type_Ahey.getActivity() == null) || (this.jdField_a_of_type_Ahey.sessionInfo == null) || (TextUtils.isEmpty(paramView)) || (this.jdField_a_of_type_Ahey.app == null));
    Object localObject1 = (aprx)this.jdField_a_of_type_Ahey.app.getBusinessHandler(125);
    Object localObject2 = ((apsa)this.jdField_a_of_type_Ahey.app.getManager(269)).b();
    if (localObject2 == null) {}
    for (paramInt = 24;; paramInt = ((aprw)localObject2).j)
    {
      ((aprx)localObject1).a(paramView, this.jdField_a_of_type_Ahey.sessionInfo.curType, this.jdField_a_of_type_Ahey.sessionInfo.topicId, this.jdField_a_of_type_Ahey.a, paramInt);
      this.jdField_a_of_type_Ahey.a(0, aprw.h, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfe
 * JD-Core Version:    0.7.0.1
 */