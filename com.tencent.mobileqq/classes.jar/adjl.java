import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.qphone.base.util.QLog;

class adjl
  extends aynj
{
  adjl(adjk paramadjk) {}
  
  protected void a(boolean paramBoolean, aynm paramaynm, int paramInt, String paramString)
  {
    int i = 1;
    if (!adjk.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramaynm.jdField_e_of_type_JavaLangString)) {
      super.a(paramBoolean, paramaynm, paramInt, paramString);
    }
    label180:
    label242:
    label247:
    do
    {
      return;
      if (paramBoolean)
      {
        adjk.a(this.a).setTogetherSession(paramaynm);
        if (paramaynm.g == 3)
        {
          this.a.b();
          paramBoolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState success, session.serviceType=", Integer.valueOf(paramaynm.d), " session.userState=", Integer.valueOf(paramaynm.h), " needPanel=", Boolean.valueOf(paramBoolean) });
          }
          if (paramBoolean)
          {
            if ((!aynn.a(adjk.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaynm)) || (arkn.a(paramaynm.d, paramaynm.jdField_e_of_type_JavaLangString, paramaynm.jdField_e_of_type_Int)) || (this.a.e())) {
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
          adjk.a(this.a);
          return;
          switch (paramaynm.h)
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
            adjk.a(this.a);
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
      if (((paramObject instanceof basr)) && (adjk.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(((basr)paramObject).a)) && ((adjk.a(this.a) instanceof TroopChatPie))) {
        ((TroopChatPie)adjk.a(this.a)).a().a(1000, new Object[0]);
      }
      return;
    }
    super.onUpdate(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adjl
 * JD-Core Version:    0.7.0.1
 */