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

public class agwr
  extends BaseBubbleBuilder
{
  private avaa a;
  Context b;
  
  public agwr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Avaa = new agws(this);
    this.b = paramContext;
  }
  
  private void h(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      ((anuk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramChatMessage.mHiBoomMessage.id, paramChatMessage.mHiBoomMessage.text, 1);
      paramChatMessage = auzk.a(this.b);
      if (paramChatMessage != null)
      {
        paramChatMessage.a(anni.a(2131704254));
        paramChatMessage.show();
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afwr a()
  {
    return new agwv();
  }
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    if ((paramafwr instanceof agwv))
    {
      paramBaseChatItemLayout = (agwv)paramafwr;
      paramafwr = paramView;
      paramView = paramBaseChatItemLayout;
      if (!(paramafwr instanceof HiBoomTextView)) {
        break label129;
      }
      paramafzq = (HiBoomTextView)paramafwr;
      paramBaseChatItemLayout = paramafwr;
      paramafwr = paramafzq;
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.jdField_a_of_type_Avaa = this.jdField_a_of_type_Avaa;
      if ((paramChatMessage instanceof MessageForHiBoom))
      {
        paramChatMessage = (MessageForHiBoom)paramChatMessage;
        if (paramChatMessage.mHiBoomMessage != null)
        {
          paramafwr.setHiBoom(paramChatMessage.mHiBoomMessage.id, 0, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, auzk.jdField_a_of_type_Auzd);
          paramafwr.setText(paramChatMessage.mHiBoomMessage.text);
          if (e) {
            paramafwr.setContentDescription(a(paramChatMessage));
          }
        }
      }
      return paramBaseChatItemLayout;
      paramView = (agwv)a();
      paramafwr = null;
      break;
      label129:
      paramafwr = new HiBoomTextView(this.b);
      paramafwr.setMaxSize(Math.min(BaseChatItemLayout.f, auzk.jdField_a_of_type_Int));
      paramView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = paramafwr;
      paramafwr.setOnLongClickListener(paramafzq);
      paramafwr.setOnTouchListener(paramafzq);
      paramafwr.setTag(paramView);
      paramBaseChatItemLayout = paramafwr;
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
    case 2131371422: 
      super.d(paramChatMessage);
      return;
    case 2131367950: 
      h(paramChatMessage);
      return;
    case 2131365308: 
      adrm.b(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = afur.a(paramView);
    String str1 = this.b.getString(2131689926);
    String str2 = this.b.getString(2131689927);
    if (paramView.isSendFromLocal()) {
      bglp.a(this.b, 230, str1, str2, new agwt(this, paramView), new agwu(this)).show();
    }
  }
  
  public bguj[] a(View paramView)
  {
    bguh localbguh = new bguh();
    if ((afur.a(paramView) instanceof agwv))
    {
      paramView = (agwv)afur.a(paramView);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForHiBoom))
      {
        localbguh.a(2131367950, this.b.getString(2131692395), 2130838929);
        if (((MessageForHiBoom)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).istroop == 0) {
          a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbguh);
        }
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
        a(localbguh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      a(localbguh, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    super.c(localbguh, this.b);
    super.e(localbguh, this.b);
    return localbguh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwr
 * JD-Core Version:    0.7.0.1
 */