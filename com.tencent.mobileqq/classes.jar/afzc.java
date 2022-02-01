import android.os.Handler;
import android.os.Looper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.avatar.VasAvatar;

public class afzc
{
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt)
  {
    if (AppSetting.c) {
      return;
    }
    paramChatMessage = paramBaseChatItemLayout.a;
    afyw localafyw = new afyw();
    Handler localHandler = new Handler(Looper.getMainLooper());
    paramBaseChatItemLayout = new afyv(paramBaseChatItemLayout.getContext(), localafyw, localHandler);
    localafyw.a(paramBaseChatItemLayout);
    paramChatMessage.setOnTouchListener(new afzd(this));
    paramChatMessage.setTag(2131362349, paramBaseChatItemLayout);
    paramBaseChatItemLayout.a(paramChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzc
 * JD-Core Version:    0.7.0.1
 */