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

public class ahgf
  extends BaseBubbleBuilder
{
  private avsb a;
  Context b;
  
  public ahgf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Avsb = new ahgg(this);
    this.b = paramContext;
  }
  
  private void h(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      ((aogu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramChatMessage.mHiBoomMessage.id, paramChatMessage.mHiBoomMessage.text, 1);
      paramChatMessage = avrl.a(this.b);
      if (paramChatMessage != null)
      {
        paramChatMessage.a(anzj.a(2131704361));
        paramChatMessage.show();
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aggl a()
  {
    return new ahgj();
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    if ((paramaggl instanceof ahgj))
    {
      paramBaseChatItemLayout = (ahgj)paramaggl;
      paramaggl = paramView;
      paramView = paramBaseChatItemLayout;
      if (!(paramaggl instanceof HiBoomTextView)) {
        break label129;
      }
      paramagjk = (HiBoomTextView)paramaggl;
      paramBaseChatItemLayout = paramaggl;
      paramaggl = paramagjk;
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.jdField_a_of_type_Avsb = this.jdField_a_of_type_Avsb;
      if ((paramChatMessage instanceof MessageForHiBoom))
      {
        paramChatMessage = (MessageForHiBoom)paramChatMessage;
        if (paramChatMessage.mHiBoomMessage != null)
        {
          paramaggl.setHiBoom(paramChatMessage.mHiBoomMessage.id, 0, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, avrl.jdField_a_of_type_Avre);
          paramaggl.setText(paramChatMessage.mHiBoomMessage.text);
          if (e) {
            paramaggl.setContentDescription(a(paramChatMessage));
          }
        }
      }
      return paramBaseChatItemLayout;
      paramView = (ahgj)a();
      paramaggl = null;
      break;
      label129:
      paramaggl = new HiBoomTextView(this.b);
      paramaggl.setMaxSize(Math.min(BaseChatItemLayout.f, avrl.jdField_a_of_type_Int));
      paramView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = paramaggl;
      paramaggl.setOnLongClickListener(paramagjk);
      paramaggl.setOnTouchListener(paramagjk);
      paramaggl.setTag(paramView);
      paramBaseChatItemLayout = paramaggl;
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
    case 2131371530: 
      super.d(paramChatMessage);
      return;
    case 2131368020: 
      h(paramChatMessage);
      return;
    case 2131365352: 
      aean.b(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = agej.a(paramView);
    String str1 = this.b.getString(2131689933);
    String str2 = this.b.getString(2131689934);
    if (paramView.isSendFromLocal()) {
      bhlq.a(this.b, 230, str1, str2, new ahgh(this, paramView), new ahgi(this)).show();
    }
  }
  
  public bhum[] a(View paramView)
  {
    bhuk localbhuk = new bhuk();
    if ((agej.a(paramView) instanceof ahgj))
    {
      paramView = (ahgj)agej.a(paramView);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForHiBoom))
      {
        localbhuk.a(2131368020, this.b.getString(2131692400), 2130838939);
        if (((MessageForHiBoom)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).istroop == 0) {
          a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbhuk);
        }
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
        a(localbhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      a(localbhuk, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    super.c(localbhuk, this.b);
    super.e(localbhuk, this.b);
    return localbhuk.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgf
 * JD-Core Version:    0.7.0.1
 */