import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.hiboom.HiBoomTextView;

public class adhy
  extends BaseBubbleBuilder
{
  private aqdv a;
  Context b;
  
  public adhy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Aqdv = new adhz(this);
    this.b = paramContext;
  }
  
  private void g(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      ((ajrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramChatMessage.mHiBoomMessage.id, paramChatMessage.mHiBoomMessage.text, 1);
      paramChatMessage = aqdf.a(this.b);
      if (paramChatMessage != null)
      {
        paramChatMessage.a(ajjy.a(2131639673));
        paramChatMessage.show();
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acju a()
  {
    return new adic();
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    if ((paramacju instanceof adic))
    {
      paramBaseChatItemLayout = (adic)paramacju;
      paramacju = paramView;
      paramView = paramBaseChatItemLayout;
      if (!(paramacju instanceof HiBoomTextView)) {
        break label129;
      }
      paramacmv = (HiBoomTextView)paramacju;
      paramBaseChatItemLayout = paramacju;
      paramacju = paramacmv;
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.jdField_a_of_type_Aqdv = this.jdField_a_of_type_Aqdv;
      if ((paramChatMessage instanceof MessageForHiBoom))
      {
        paramChatMessage = (MessageForHiBoom)paramChatMessage;
        if (paramChatMessage.mHiBoomMessage != null)
        {
          paramacju.setHiBoom(paramChatMessage.mHiBoomMessage.id, 0, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, aqdf.jdField_a_of_type_Aqcy);
          paramacju.setText(paramChatMessage.mHiBoomMessage.text);
          if (e) {
            paramacju.setContentDescription(a(paramChatMessage));
          }
        }
      }
      return paramBaseChatItemLayout;
      paramView = (adic)a();
      paramacju = null;
      break;
      label129:
      paramacju = new HiBoomTextView(this.b);
      paramacju.setMaxSize(Math.min(BaseChatItemLayout.e, aqdf.jdField_a_of_type_Int));
      paramView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = paramacju;
      paramacju.setOnLongClickListener(paramacmv);
      paramacju.setOnTouchListener(paramacmv);
      paramacju.setTag(paramView);
      paramBaseChatItemLayout = paramacju;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      if (paramChatMessage.mHiBoomMessage != null) {
        return paramChatMessage.mHiBoomMessage.text;
      }
    }
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131304871: 
      super.d(paramChatMessage);
      return;
    case 2131301888: 
      g(paramChatMessage);
      return;
    case 2131299417: 
      aael.b(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = aciy.a(paramView);
    String str1 = this.b.getString(2131624443);
    String str2 = this.b.getString(2131624444);
    if (paramView.isSendFromLocal()) {
      babr.a(this.b, 230, str1, str2, new adia(this, paramView), new adib(this)).show();
    }
  }
  
  public bakj[] a(View paramView)
  {
    bakh localbakh = new bakh();
    if ((aciy.a(paramView) instanceof adic))
    {
      paramView = (adic)aciy.a(paramView);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForHiBoom))
      {
        localbakh.a(2131301888, this.b.getString(2131627114), 2130838599);
        if (((MessageForHiBoom)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).istroop == 0) {
          a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbakh);
        }
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
        a(localbakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      a(localbakh, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    super.c(localbakh, this.b);
    super.d(localbakh, this.b);
    return localbakh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adhy
 * JD-Core Version:    0.7.0.1
 */