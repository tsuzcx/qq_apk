import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.qphone.base.util.QLog;

class adjj
  extends aynl
{
  adjj(adji paramadji) {}
  
  protected void a(boolean paramBoolean, ayno paramayno, int paramInt, String paramString)
  {
    int i = 1;
    if (!adji.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramayno.jdField_e_of_type_JavaLangString)) {
      super.a(paramBoolean, paramayno, paramInt, paramString);
    }
    label180:
    label242:
    label247:
    do
    {
      return;
      if (paramBoolean)
      {
        adji.a(this.a).setTogetherSession(paramayno);
        if (paramayno.g == 3)
        {
          this.a.b();
          paramBoolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState success, session.serviceType=", Integer.valueOf(paramayno.d), " session.userState=", Integer.valueOf(paramayno.h), " needPanel=", Boolean.valueOf(paramBoolean) });
          }
          if (paramBoolean)
          {
            if ((!aynp.a(adji.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramayno)) || (arkp.a(paramayno.d, paramayno.jdField_e_of_type_JavaLangString, paramayno.jdField_e_of_type_Int)) || (this.a.e())) {
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
          adji.a(this.a);
          return;
          switch (paramayno.h)
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
            adji.a(this.a);
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
      if (((paramObject instanceof batf)) && (adji.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(((batf)paramObject).a)) && ((adji.a(this.a) instanceof TroopChatPie))) {
        ((TroopChatPie)adji.a(this.a)).a().a(1000, new Object[0]);
      }
      return;
    }
    super.onUpdate(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adjj
 * JD-Core Version:    0.7.0.1
 */