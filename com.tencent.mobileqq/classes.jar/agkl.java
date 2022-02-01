import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.qphone.base.util.QLog;

class agkl
  extends beke
{
  agkl(agkk paramagkk) {}
  
  protected void a(boolean paramBoolean, bekh parambekh, int paramInt, String paramString)
  {
    int i = 1;
    if (!agkk.a(this.a).sessionInfo.curFriendUin.equals(parambekh.jdField_e_of_type_JavaLangString)) {
      super.a(paramBoolean, parambekh, paramInt, paramString);
    }
    label180:
    label250:
    label255:
    do
    {
      return;
      if (paramBoolean)
      {
        agkk.a(this.a).setTogetherSession(parambekh);
        if (parambekh.h == 3)
        {
          this.a.b();
          paramBoolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState success, session.serviceType=", Integer.valueOf(parambekh.jdField_e_of_type_Int), " session.userState=", Integer.valueOf(parambekh.i), " needPanel=", Boolean.valueOf(paramBoolean) });
          }
          if (paramBoolean)
          {
            if ((!beki.a(agkk.a(this.a).app, parambekh)) || (avxi.a(parambekh.jdField_e_of_type_Int, parambekh.jdField_e_of_type_JavaLangString, parambekh.f)) || (this.a.e())) {
              break label250;
            }
            paramInt = i;
            if (paramInt != 0) {
              break label255;
            }
            this.a.b();
          }
        }
        for (;;)
        {
          agkk.a(this.a);
          agkk.a(this.a, parambekh);
          return;
          switch (parambekh.i)
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
            agkk.a(this.a);
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
      if (((paramObject instanceof bgsx)) && (agkk.a(this.a).sessionInfo.curFriendUin.equals(((bgsx)paramObject).a)) && ((agkk.a(this.a) instanceof TroopChatPie))) {
        ((TroopChatPie)agkk.a(this.a)).a().a(1000, new Object[0]);
      }
      return;
    }
    super.onUpdate(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkl
 * JD-Core Version:    0.7.0.1
 */