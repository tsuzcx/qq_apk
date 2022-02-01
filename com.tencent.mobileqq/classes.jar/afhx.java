import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.avatar.VasAvatar;

public class afhx
{
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt)
  {
    paramChatMessage = paramBaseChatItemLayout.a;
    afhr localafhr = new afhr();
    Handler localHandler = new Handler(Looper.getMainLooper());
    paramBaseChatItemLayout = new afhq(paramBaseChatItemLayout.getContext(), localafhr, localHandler);
    localafhr.a(paramBaseChatItemLayout);
    paramChatMessage.setOnTouchListener(new afhy(this));
    paramChatMessage.setTag(2131362344, paramBaseChatItemLayout);
    paramBaseChatItemLayout.a(paramChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhx
 * JD-Core Version:    0.7.0.1
 */