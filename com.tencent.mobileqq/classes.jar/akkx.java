import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForScribble;

public class akkx
  extends ahtp
{
  public akkx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aggl paramaggl, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaggl, paramInt1, paramInt2);
    paramContext = (ahtx)paramaggl;
    if (paramContext.d != null)
    {
      if ((!(paramChatMessage instanceof MessageForPoke)) && (!(paramChatMessage instanceof MessageForPokeEmo))) {
        break label109;
      }
      if (!TextUtils.isEmpty(paramChatMessage.msg)) {
        break label95;
      }
      paramContext.d.setText(anzj.a(2131705728));
    }
    for (;;)
    {
      if (paramContext.b != null) {
        paramContext.b.setVisibility(8);
      }
      if (paramContext.c != null) {
        paramContext.c.setVisibility(8);
      }
      return;
      label95:
      paramContext.d.setText(paramChatMessage.msg);
      continue;
      label109:
      if ((paramChatMessage instanceof MessageForScribble)) {
        paramContext.d.setText(anzj.a(2131705727));
      } else {
        paramContext.d.setText(anzj.a(2131705729));
      }
    }
  }
  
  public void b(View paramView)
  {
    super.b(paramView);
  }
  
  protected boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akkx
 * JD-Core Version:    0.7.0.1
 */