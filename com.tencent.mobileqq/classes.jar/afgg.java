import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.qphone.base.util.QLog;

class afgg
  extends bapq
{
  afgg(afgf paramafgf) {}
  
  protected void a(boolean paramBoolean, bapt parambapt, int paramInt, String paramString)
  {
    int i = 1;
    if (!afgf.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(parambapt.jdField_e_of_type_JavaLangString)) {
      super.a(paramBoolean, parambapt, paramInt, paramString);
    }
    label180:
    label242:
    label247:
    do
    {
      return;
      if (paramBoolean)
      {
        afgf.a(this.a).setTogetherSession(parambapt);
        if (parambapt.g == 3)
        {
          this.a.b();
          paramBoolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState success, session.serviceType=", Integer.valueOf(parambapt.d), " session.userState=", Integer.valueOf(parambapt.h), " needPanel=", Boolean.valueOf(paramBoolean) });
          }
          if (paramBoolean)
          {
            if ((!bapu.a(afgf.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambapt)) || (atfm.a(parambapt.d, parambapt.jdField_e_of_type_JavaLangString, parambapt.jdField_e_of_type_Int)) || (this.a.e())) {
              break label242;
            }
            paramInt = i;
            if (paramInt != 0) {
              break label247;
            }
            this.a.b();
          }
        }
        for (;;)
        {
          afgf.a(this.a);
          return;
          switch (parambapt.h)
          {
          default: 
            paramBoolean = false;
            break;
          case 1: 
          case 2: 
          case 3: 
            paramBoolean = true;
            break;
            paramInt = 0;
            break label180;
            afgf.a(this.a);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState false, ", Integer.valueOf(paramInt), " ", paramString });
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 2)
    {
      if (((paramObject instanceof bcwi)) && (afgf.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(((bcwi)paramObject).a)) && ((afgf.a(this.a) instanceof TroopChatPie))) {
        ((TroopChatPie)afgf.a(this.a)).a().a(1000, new Object[0]);
      }
      return;
    }
    super.onUpdate(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgg
 * JD-Core Version:    0.7.0.1
 */