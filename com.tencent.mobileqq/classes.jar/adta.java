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

public class adta
  extends BaseBubbleBuilder
{
  private aqxx a;
  Context b;
  
  public adta(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Aqxx = new adtb(this);
    this.b = paramContext;
  }
  
  private void g(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      ((akfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramChatMessage.mHiBoomMessage.id, paramChatMessage.mHiBoomMessage.text, 1);
      paramChatMessage = aqxh.a(this.b);
      if (paramChatMessage != null)
      {
        paramChatMessage.a(ajyc.a(2131705458));
        paramChatMessage.show();
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acun a()
  {
    return new adte();
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    if ((paramacun instanceof adte))
    {
      paramBaseChatItemLayout = (adte)paramacun;
      paramacun = paramView;
      paramView = paramBaseChatItemLayout;
      if (!(paramacun instanceof HiBoomTextView)) {
        break label129;
      }
      paramacxn = (HiBoomTextView)paramacun;
      paramBaseChatItemLayout = paramacun;
      paramacun = paramacxn;
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.jdField_a_of_type_Aqxx = this.jdField_a_of_type_Aqxx;
      if ((paramChatMessage instanceof MessageForHiBoom))
      {
        paramChatMessage = (MessageForHiBoom)paramChatMessage;
        if (paramChatMessage.mHiBoomMessage != null)
        {
          paramacun.setHiBoom(paramChatMessage.mHiBoomMessage.id, 0, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, aqxh.jdField_a_of_type_Aqxa);
          paramacun.setText(paramChatMessage.mHiBoomMessage.text);
          if (e) {
            paramacun.setContentDescription(a(paramChatMessage));
          }
        }
      }
      return paramBaseChatItemLayout;
      paramView = (adte)a();
      paramacun = null;
      break;
      label129:
      paramacun = new HiBoomTextView(this.b);
      paramacun.setMaxSize(Math.min(BaseChatItemLayout.e, aqxh.jdField_a_of_type_Int));
      paramView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = paramacun;
      paramacun.setOnLongClickListener(paramacxn);
      paramacun.setOnTouchListener(paramacxn);
      paramacun.setTag(paramView);
      paramBaseChatItemLayout = paramacun;
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
    case 2131370537: 
      super.d(paramChatMessage);
      return;
    case 2131367505: 
      g(paramChatMessage);
      return;
    case 2131364985: 
      aaod.b(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = actn.a(paramView);
    String str1 = this.b.getString(2131689995);
    String str2 = this.b.getString(2131689996);
    if (paramView.isSendFromLocal()) {
      bbcv.a(this.b, 230, str1, str2, new adtc(this, paramView), new adtd(this)).show();
    }
  }
  
  public bblt[] a(View paramView)
  {
    bblr localbblr = new bblr();
    if ((actn.a(paramView) instanceof adte))
    {
      paramView = (adte)actn.a(paramView);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForHiBoom))
      {
        localbblr.a(2131367505, this.b.getString(2131692752), 2130838606);
        if (((MessageForHiBoom)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).istroop == 0) {
          a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbblr);
        }
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
        a(localbblr, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      a(localbblr, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    super.c(localbblr, this.b);
    super.e(localbblr, this.b);
    return localbblr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adta
 * JD-Core Version:    0.7.0.1
 */