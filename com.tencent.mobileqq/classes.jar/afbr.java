import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.qphone.base.util.QLog;

class afbr
  extends balh
{
  afbr(afbq paramafbq) {}
  
  protected void a(boolean paramBoolean, balk parambalk, int paramInt, String paramString)
  {
    int i = 1;
    if (!afbq.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(parambalk.jdField_e_of_type_JavaLangString)) {
      super.a(paramBoolean, parambalk, paramInt, paramString);
    }
    label180:
    label242:
    label247:
    do
    {
      return;
      if (paramBoolean)
      {
        afbq.a(this.a).setTogetherSession(parambalk);
        if (parambalk.g == 3)
        {
          this.a.b();
          paramBoolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState success, session.serviceType=", Integer.valueOf(parambalk.d), " session.userState=", Integer.valueOf(parambalk.h), " needPanel=", Boolean.valueOf(paramBoolean) });
          }
          if (paramBoolean)
          {
            if ((!ball.a(afbq.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambalk)) || (atbd.a(parambalk.d, parambalk.jdField_e_of_type_JavaLangString, parambalk.jdField_e_of_type_Int)) || (this.a.e())) {
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
          afbq.a(this.a);
          return;
          switch (parambalk.h)
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
            afbq.a(this.a);
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
      if (((paramObject instanceof bcrz)) && (afbq.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(((bcrz)paramObject).a)) && ((afbq.a(this.a) instanceof TroopChatPie))) {
        ((TroopChatPie)afbq.a(this.a)).a().a(1000, new Object[0]);
      }
      return;
    }
    super.onUpdate(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbr
 * JD-Core Version:    0.7.0.1
 */