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

public class adsy
  extends BaseBubbleBuilder
{
  private aqxz a;
  Context b;
  
  public adsy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Aqxz = new adsz(this);
    this.b = paramContext;
  }
  
  private void g(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      ((akfv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramChatMessage.mHiBoomMessage.id, paramChatMessage.mHiBoomMessage.text, 1);
      paramChatMessage = aqxj.a(this.b);
      if (paramChatMessage != null)
      {
        paramChatMessage.a(ajya.a(2131705469));
        paramChatMessage.show();
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acuj a()
  {
    return new adtc();
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    if ((paramacuj instanceof adtc))
    {
      paramBaseChatItemLayout = (adtc)paramacuj;
      paramacuj = paramView;
      paramView = paramBaseChatItemLayout;
      if (!(paramacuj instanceof HiBoomTextView)) {
        break label129;
      }
      paramacxj = (HiBoomTextView)paramacuj;
      paramBaseChatItemLayout = paramacuj;
      paramacuj = paramacxj;
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.jdField_a_of_type_Aqxz = this.jdField_a_of_type_Aqxz;
      if ((paramChatMessage instanceof MessageForHiBoom))
      {
        paramChatMessage = (MessageForHiBoom)paramChatMessage;
        if (paramChatMessage.mHiBoomMessage != null)
        {
          paramacuj.setHiBoom(paramChatMessage.mHiBoomMessage.id, 0, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, aqxj.jdField_a_of_type_Aqxc);
          paramacuj.setText(paramChatMessage.mHiBoomMessage.text);
          if (e) {
            paramacuj.setContentDescription(a(paramChatMessage));
          }
        }
      }
      return paramBaseChatItemLayout;
      paramView = (adtc)a();
      paramacuj = null;
      break;
      label129:
      paramacuj = new HiBoomTextView(this.b);
      paramacuj.setMaxSize(Math.min(BaseChatItemLayout.e, aqxj.jdField_a_of_type_Int));
      paramView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = paramacuj;
      paramacuj.setOnLongClickListener(paramacxj);
      paramacuj.setOnTouchListener(paramacxj);
      paramacuj.setTag(paramView);
      paramBaseChatItemLayout = paramacuj;
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
    case 2131370536: 
      super.d(paramChatMessage);
      return;
    case 2131367505: 
      g(paramChatMessage);
      return;
    case 2131364984: 
      aanz.b(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = actj.a(paramView);
    String str1 = this.b.getString(2131689995);
    String str2 = this.b.getString(2131689996);
    if (paramView.isSendFromLocal()) {
      bbdj.a(this.b, 230, str1, str2, new adta(this, paramView), new adtb(this)).show();
    }
  }
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    if ((actj.a(paramView) instanceof adtc))
    {
      paramView = (adtc)actj.a(paramView);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForHiBoom))
      {
        localbbmf.a(2131367505, this.b.getString(2131692753), 2130838606);
        if (((MessageForHiBoom)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).istroop == 0) {
          a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbbmf);
        }
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
        a(localbbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      a(localbbmf, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    super.c(localbbmf, this.b);
    super.e(localbbmf, this.b);
    return localbbmf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adsy
 * JD-Core Version:    0.7.0.1
 */