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

public class afld
  extends BaseBubbleBuilder
{
  private ason a;
  Context b;
  
  public afld(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Ason = new afle(this);
    this.b = paramContext;
  }
  
  private void g(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      ((alxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramChatMessage.mHiBoomMessage.id, paramChatMessage.mHiBoomMessage.text, 1);
      paramChatMessage = asnx.a(this.b);
      if (paramChatMessage != null)
      {
        paramChatMessage.a(alpo.a(2131705841));
        paramChatMessage.show();
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aelt a()
  {
    return new aflh();
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    if ((paramaelt instanceof aflh))
    {
      paramBaseChatItemLayout = (aflh)paramaelt;
      paramaelt = paramView;
      paramView = paramBaseChatItemLayout;
      if (!(paramaelt instanceof HiBoomTextView)) {
        break label129;
      }
      paramaeov = (HiBoomTextView)paramaelt;
      paramBaseChatItemLayout = paramaelt;
      paramaelt = paramaeov;
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.jdField_a_of_type_Ason = this.jdField_a_of_type_Ason;
      if ((paramChatMessage instanceof MessageForHiBoom))
      {
        paramChatMessage = (MessageForHiBoom)paramChatMessage;
        if (paramChatMessage.mHiBoomMessage != null)
        {
          paramaelt.setHiBoom(paramChatMessage.mHiBoomMessage.id, 0, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, asnx.jdField_a_of_type_Asnq);
          paramaelt.setText(paramChatMessage.mHiBoomMessage.text);
          if (e) {
            paramaelt.setContentDescription(a(paramChatMessage));
          }
        }
      }
      return paramBaseChatItemLayout;
      paramView = (aflh)a();
      paramaelt = null;
      break;
      label129:
      paramaelt = new HiBoomTextView(this.b);
      paramaelt.setMaxSize(Math.min(BaseChatItemLayout.e, asnx.jdField_a_of_type_Int));
      paramView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = paramaelt;
      paramaelt.setOnLongClickListener(paramaeov);
      paramaelt.setOnTouchListener(paramaeov);
      paramaelt.setTag(paramView);
      paramBaseChatItemLayout = paramaelt;
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
    case 2131370842: 
      super.d(paramChatMessage);
      return;
    case 2131367633: 
      g(paramChatMessage);
      return;
    case 2131365069: 
      acex.b(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = aekt.a(paramView);
    String str1 = this.b.getString(2131690042);
    String str2 = this.b.getString(2131690043);
    if (paramView.isSendFromLocal()) {
      bdcd.a(this.b, 230, str1, str2, new aflf(this, paramView), new aflg(this)).show();
    }
  }
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    if ((aekt.a(paramView) instanceof aflh))
    {
      paramView = (aflh)aekt.a(paramView);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForHiBoom))
      {
        localbdkz.a(2131367633, this.b.getString(2131692835), 2130838677);
        if (((MessageForHiBoom)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).istroop == 0) {
          a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbdkz);
        }
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
        a(localbdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      a(localbdkz, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    super.c(localbdkz, this.b);
    super.e(localbdkz, this.b);
    return localbdkz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afld
 * JD-Core Version:    0.7.0.1
 */