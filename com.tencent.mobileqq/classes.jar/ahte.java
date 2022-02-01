import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

public class ahte
{
  public static void a(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie.mChatDrawer != null) {
      paramBaseChatPie.mChatDrawer.c(false);
    }
    if (paramBaseChatPie.mApolloViewController != null) {
      paramBaseChatPie.mApolloViewController.a(false);
    }
    paramBaseChatPie.hideAppShortcutBar();
  }
  
  public static void b(BaseChatPie paramBaseChatPie)
  {
    if (paramBaseChatPie.mChatDrawer != null) {
      paramBaseChatPie.mChatDrawer.c(true);
    }
    if (paramBaseChatPie.mApolloViewController != null) {
      paramBaseChatPie.mApolloViewController.a(true);
    }
    paramBaseChatPie.resumeAppShorcutBar();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahte
 * JD-Core Version:    0.7.0.1
 */