import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;

public abstract class ahwu
  extends ahvv
{
  public ahvd a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo, int paramInt)
  {
    ahvd localahvd = new ahvd();
    localahvd.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramBaseChatPie.app, paramPlusPanelAppInfo);
    localahvd.jdField_a_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localahvd.jdField_b_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localahvd.c = String.valueOf(localahvd.jdField_b_of_type_Int);
    localahvd.e = paramPlusPanelAppInfo.actionType;
    localahvd.d = paramPlusPanelAppInfo.action;
    localahvd.jdField_a_of_type_JavaLangString = a(paramPlusPanelAppInfo);
    localahvd.jdField_b_of_type_JavaLangString = (localahvd.jdField_a_of_type_JavaLangString + anvx.a(2131707759));
    localahvd.f = paramBaseChatPie.sessionInfo.troopUin;
    int i = paramPlusPanelAppInfo.getAppID();
    if ((i == 1104864062) || (i == 101761547) || (i == 101793773) || (i == 101817424)) {
      localahvd.jdField_a_of_type_Boolean = paramPlusPanelAppInfo.redPoint;
    }
    if (i == 1104874204) {
      this.jdField_a_of_type_Int = (paramInt / 8);
    }
    return localahvd;
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    b(paramBaseChatPie);
    a(paramBaseChatPie.app, paramBaseChatPie.sessionInfo.curType, paramBaseChatPie.sessionInfo.curFriendUin);
  }
  
  protected abstract void b(BaseChatPie paramBaseChatPie);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwu
 * JD-Core Version:    0.7.0.1
 */