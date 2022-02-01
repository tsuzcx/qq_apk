import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class agvh
  extends BaseBubbleBuilder
{
  private avkx a;
  Context b;
  
  public agvh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Avkx = new agvi(this);
    this.b = paramContext;
  }
  
  private void h(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      ((aocy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramChatMessage.mHiBoomMessage.id, paramChatMessage.mHiBoomMessage.text, 1);
      paramChatMessage = avkh.a(this.b);
      if (paramChatMessage != null)
      {
        paramChatMessage.a(anvx.a(2131704942));
        paramChatMessage.show();
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqr a()
  {
    return new agvl();
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    if ((paramafqr instanceof agvl))
    {
      paramBaseChatItemLayout = (agvl)paramafqr;
      paramafqr = paramView;
      paramView = paramBaseChatItemLayout;
      if (!(paramafqr instanceof HiBoomTextView)) {
        break label129;
      }
      paramaftk = (HiBoomTextView)paramafqr;
      paramBaseChatItemLayout = paramafqr;
      paramafqr = paramaftk;
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.jdField_a_of_type_Avkx = this.jdField_a_of_type_Avkx;
      if ((paramChatMessage instanceof MessageForHiBoom))
      {
        paramChatMessage = (MessageForHiBoom)paramChatMessage;
        if (paramChatMessage.mHiBoomMessage != null)
        {
          paramafqr.setHiBoom(paramChatMessage.mHiBoomMessage.id, 0, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, avkh.jdField_a_of_type_Avka);
          paramafqr.setText(paramChatMessage.mHiBoomMessage.text);
          if (e) {
            paramafqr.setContentDescription(a(paramChatMessage));
          }
        }
      }
      return paramBaseChatItemLayout;
      paramView = (agvl)a();
      paramafqr = null;
      break;
      label129:
      paramafqr = new HiBoomTextView(this.b);
      paramafqr.setMaxSize(Math.min(BaseChatItemLayout.f, avkh.jdField_a_of_type_Int));
      paramView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = paramafqr;
      paramafqr.setOnLongClickListener(paramaftk);
      paramafqr.setOnTouchListener(paramaftk);
      paramafqr.setTag(paramView);
      paramBaseChatItemLayout = paramafqr;
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
    case 2131371684: 
      super.d(paramChatMessage);
      return;
    case 2131368190: 
      h(paramChatMessage);
      return;
    case 2131365475: 
      admh.b(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = AIOUtils.getMessage(paramView);
    String str1 = this.b.getString(2131689976);
    String str2 = this.b.getString(2131689977);
    if (paramView.isSendFromLocal()) {
      bhdj.a(this.b, 230, str1, str2, new agvj(this, paramView), new agvk(this)).show();
    }
  }
  
  public bhjs[] a(View paramView)
  {
    bhjq localbhjq = new bhjq();
    if ((AIOUtils.getHolder(paramView) instanceof agvl))
    {
      paramView = (agvl)AIOUtils.getHolder(paramView);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForHiBoom))
      {
        localbhjq.a(2131368190, this.b.getString(2131692550), 2130838991);
        if (((MessageForHiBoom)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).istroop == 0) {
          a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbhjq);
        }
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
        a(localbhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      a(localbhjq, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    super.c(localbhjq, this.b);
    super.e(localbhjq, this.b);
    return localbhjq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvh
 * JD-Core Version:    0.7.0.1
 */