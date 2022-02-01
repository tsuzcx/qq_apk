import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

public class ahws
  extends ahwu
{
  public ahvd a(BaseChatPie paramBaseChatPie, PlusPanelAppInfo paramPlusPanelAppInfo, int paramInt)
  {
    ahvd localahvd = new ahvd();
    if (paramPlusPanelAppInfo.getAppID() == 1104874204) {
      this.jdField_a_of_type_Int = (paramInt / 8);
    }
    localahvd.jdField_b_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localahvd.jdField_a_of_type_Int = paramPlusPanelAppInfo.getAppID();
    localahvd.jdField_a_of_type_JavaLangString = paramPlusPanelAppInfo.getAppName();
    localahvd.e = paramPlusPanelAppInfo.actionType;
    localahvd.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramBaseChatPie.app, paramPlusPanelAppInfo);
    if (localahvd.jdField_b_of_type_Int == 1107930043) {
      if (!ShortVideoUtils.isHotPicConfiginitied) {
        ShortVideoUtils.isHotPicConfiginitied = true;
      }
    }
    for (;;)
    {
      localahvd.jdField_b_of_type_JavaLangString = (paramPlusPanelAppInfo.getAppName() + anvx.a(2131707767));
      return localahvd;
      if (paramPlusPanelAppInfo.getAppID() == 101761547) {
        localahvd.jdField_a_of_type_Boolean = awfq.a(paramBaseChatPie.app, "listen_together_c2c_aio_red_dot_show", true, false);
      } else {
        localahvd.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  protected void b(BaseChatPie paramBaseChatPie)
  {
    if (((HotChatManager)paramBaseChatPie.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(paramBaseChatPie.sessionInfo.curFriendUin)) {
      a(paramBaseChatPie.sessionInfo.curType, 1200000000);
    }
    a(paramBaseChatPie.sessionInfo.curType, 1104864068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahws
 * JD-Core Version:    0.7.0.1
 */