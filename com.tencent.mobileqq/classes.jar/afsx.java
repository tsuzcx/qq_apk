import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.qphone.base.util.QLog;

class afsx
  extends bddc
{
  afsx(afsw paramafsw) {}
  
  protected void a(boolean paramBoolean, bddf parambddf, int paramInt, String paramString)
  {
    int i = 1;
    if (!afsw.a(this.a).sessionInfo.curFriendUin.equals(parambddf.jdField_e_of_type_JavaLangString)) {
      super.a(paramBoolean, parambddf, paramInt, paramString);
    }
    label180:
    label250:
    label255:
    do
    {
      return;
      if (paramBoolean)
      {
        afsw.a(this.a).setTogetherSession(parambddf);
        if (parambddf.g == 3)
        {
          this.a.b();
          paramBoolean = false;
          if (QLog.isColorLevel()) {
            QLog.d("TogetherControlHelper.helper", 2, new Object[] { "onGetPlayState success, session.serviceType=", Integer.valueOf(parambddf.d), " session.userState=", Integer.valueOf(parambddf.h), " needPanel=", Boolean.valueOf(paramBoolean) });
          }
          if (paramBoolean)
          {
            if ((!bddg.a(afsw.a(this.a).app, parambddf)) || (aurn.a(parambddf.d, parambddf.jdField_e_of_type_JavaLangString, parambddf.jdField_e_of_type_Int)) || (this.a.e())) {
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
          afsw.a(this.a);
          afsw.a(this.a, parambddf);
          return;
          switch (parambddf.h)
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
            afsw.a(this.a);
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
      if (((paramObject instanceof bfkg)) && (afsw.a(this.a).sessionInfo.curFriendUin.equals(((bfkg)paramObject).a)) && ((afsw.a(this.a) instanceof TroopChatPie))) {
        ((TroopChatPie)afsw.a(this.a)).a().a(1000, new Object[0]);
      }
      return;
    }
    super.onUpdate(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsx
 * JD-Core Version:    0.7.0.1
 */