import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessNewsBgView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopConfess;

public class alyu
  extends BaseBubbleBuilder
{
  private int c;
  
  public alyu(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.c = (BaseChatItemLayout.A + aciy.a(20.0F, paramContext.getResources()));
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acju a()
  {
    return new alyw();
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    paramBaseChatItemLayout = (MessageForTroopConfess)paramChatMessage;
    alyw localalyw = (alyw)paramacju;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493201, null);
      paramChatMessage.setLayoutParams(new ViewGroup.LayoutParams(this.c, -2));
      alyw.a(localalyw, (TextView)paramChatMessage.findViewById(2131312700));
      alyw.b(localalyw, (TextView)paramChatMessage.findViewById(2131312691));
      alyw.c(localalyw, (TextView)paramChatMessage.findViewById(2131312715));
      alyw.a(localalyw, (ConfessNewsBgView)paramChatMessage.findViewById(2131312974));
      alyw.a(localalyw).setPressMask(true);
      alyw.a(localalyw, paramChatMessage.findViewById(2131303748));
    }
    alyw.a(localalyw).setBgType(paramBaseChatItemLayout.getConfessTopicId() % 4);
    alyw.a(localalyw).setOnLongClickListener(paramacmv);
    alyw.a(localalyw).setOnTouchListener(paramacmv);
    localalyw.a(paramBaseChatItemLayout.mTroopConfessMsg);
    paramChatMessage.setOnClickListener(new alyv(this, paramBaseChatItemLayout));
    if (e)
    {
      ((alyw)paramacju).b.append(alyw.b(localalyw).getText()).append(alyw.a(localalyw).getText());
      if (alyw.c(localalyw).getVisibility() == 0) {
        ((alyw)paramacju).b.append(alyw.c(localalyw).getText());
      }
      paramChatMessage.setContentDescription(((alyw)paramacju).b.toString());
    }
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForTroopConfess))) {
      return;
    }
    MessageForTroopConfess localMessageForTroopConfess = (MessageForTroopConfess)paramChatMessage;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2) {}
  
  public bakj[] a(View paramView)
  {
    paramView = new bakh();
    aael.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.d(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  public void b(View paramView)
  {
    super.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alyu
 * JD-Core Version:    0.7.0.1
 */