import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.qphone.base.util.QLog;

class acyk
  extends axnc
{
  acyk(acyj paramacyj) {}
  
  protected void a(boolean paramBoolean, axnf paramaxnf, int paramInt, String paramString)
  {
    if (!acyj.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramaxnf.e)) {
      super.a(paramBoolean, paramaxnf, paramInt, paramString);
    }
    label202:
    do
    {
      return;
      if (paramBoolean)
      {
        acyj.a(this.a).setTogetherSession(paramaxnf);
        if (paramaxnf.g == 3)
        {
          this.a.b();
          paramBoolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState success, session.serviceType=", Integer.valueOf(paramaxnf.d), " session.userState=", Integer.valueOf(paramaxnf.h), " needPanel=", Boolean.valueOf(paramBoolean) });
          }
          if (paramBoolean)
          {
            if (axng.a(acyj.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaxnf)) {
              break label202;
            }
            this.a.b();
          }
        }
        for (;;)
        {
          acyj.a(this.a);
          return;
          switch (paramaxnf.h)
          {
          default: 
            paramBoolean = false;
            break;
          case 1: 
          case 2: 
          case 3: 
            paramBoolean = true;
            break;
            acyj.a(this.a);
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
      if (((paramObject instanceof azrn)) && (acyj.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(((azrn)paramObject).a)) && ((acyj.a(this.a) instanceof aejb))) {
        ((aejb)acyj.a(this.a)).a().a(1000, new Object[0]);
      }
      return;
    }
    super.onUpdate(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acyk
 * JD-Core Version:    0.7.0.1
 */