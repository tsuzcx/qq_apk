import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.qphone.base.util.QLog;

class agnn
  extends bdrk
{
  agnn(agnm paramagnm) {}
  
  protected void a(boolean paramBoolean, bdrn parambdrn, int paramInt, String paramString)
  {
    int i = 1;
    if (!agnm.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(parambdrn.jdField_e_of_type_JavaLangString)) {
      super.a(paramBoolean, parambdrn, paramInt, paramString);
    }
    label180:
    label242:
    label247:
    do
    {
      return;
      if (paramBoolean)
      {
        agnm.a(this.a).setTogetherSession(parambdrn);
        if (parambdrn.g == 3)
        {
          this.a.b();
          paramBoolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState success, session.serviceType=", Integer.valueOf(parambdrn.d), " session.userState=", Integer.valueOf(parambdrn.h), " needPanel=", Boolean.valueOf(paramBoolean) });
          }
          if (paramBoolean)
          {
            if ((!bdro.a(agnm.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambdrn)) || (avmc.a(parambdrn.d, parambdrn.jdField_e_of_type_JavaLangString, parambdrn.jdField_e_of_type_Int)) || (this.a.e())) {
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
          agnm.a(this.a);
          return;
          switch (parambdrn.h)
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
            agnm.a(this.a);
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
      if (((paramObject instanceof bgat)) && (agnm.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(((bgat)paramObject).a)) && ((agnm.a(this.a) instanceof TroopChatPie))) {
        ((TroopChatPie)agnm.a(this.a)).a().a(1000, new Object[0]);
      }
      return;
    }
    super.onUpdate(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnn
 * JD-Core Version:    0.7.0.1
 */