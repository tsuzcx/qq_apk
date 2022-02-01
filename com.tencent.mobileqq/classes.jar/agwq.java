import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.qphone.base.util.QLog;

class agwq
  extends bekg
{
  agwq(agwp paramagwp) {}
  
  protected void a(boolean paramBoolean, bekj parambekj, int paramInt, String paramString)
  {
    int i = 1;
    if (!agwp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(parambekj.jdField_e_of_type_JavaLangString)) {
      super.a(paramBoolean, parambekj, paramInt, paramString);
    }
    label180:
    label242:
    label247:
    do
    {
      return;
      if (paramBoolean)
      {
        agwp.a(this.a).setTogetherSession(parambekj);
        if (parambekj.g == 3)
        {
          this.a.b();
          paramBoolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState success, session.serviceType=", Integer.valueOf(parambekj.d), " session.userState=", Integer.valueOf(parambekj.h), " needPanel=", Boolean.valueOf(paramBoolean) });
          }
          if (paramBoolean)
          {
            if ((!bekk.a(agwp.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambekj)) || (awen.a(parambekj.d, parambekj.jdField_e_of_type_JavaLangString, parambekj.jdField_e_of_type_Int)) || (this.a.e())) {
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
          agwp.a(this.a);
          return;
          switch (parambekj.h)
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
            agwp.a(this.a);
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
      if (((paramObject instanceof bhau)) && (agwp.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(((bhau)paramObject).a)) && ((agwp.a(this.a) instanceof TroopChatPie))) {
        ((TroopChatPie)agwp.a(this.a)).a().a(1000, new Object[0]);
      }
      return;
    }
    super.onUpdate(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwq
 * JD-Core Version:    0.7.0.1
 */