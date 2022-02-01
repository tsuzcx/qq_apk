import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class agcr
  extends BaseBubbleBuilder
{
  private aufd a;
  Context b;
  
  public agcr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_Aufd = new agcs(this);
    this.b = paramContext;
  }
  
  private void h(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForHiBoom))
    {
      paramChatMessage = (MessageForHiBoom)paramChatMessage;
      ((anaj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(13)).a(paramChatMessage.mHiBoomMessage.id, paramChatMessage.mHiBoomMessage.text, 1);
      paramChatMessage = auen.a(this.b);
      if (paramChatMessage != null)
      {
        paramChatMessage.a(amtj.a(2131704591));
        paramChatMessage.show();
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aezf a()
  {
    return new agcv();
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    if ((paramaezf instanceof agcv))
    {
      paramBaseChatItemLayout = (agcv)paramaezf;
      paramaezf = paramView;
      paramView = paramBaseChatItemLayout;
      if (!(paramaezf instanceof HiBoomTextView)) {
        break label129;
      }
      paramafce = (HiBoomTextView)paramaezf;
      paramBaseChatItemLayout = paramaezf;
      paramaezf = paramafce;
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.jdField_a_of_type_Aufd = this.jdField_a_of_type_Aufd;
      if ((paramChatMessage instanceof MessageForHiBoom))
      {
        paramChatMessage = (MessageForHiBoom)paramChatMessage;
        if (paramChatMessage.mHiBoomMessage != null)
        {
          paramaezf.setHiBoom(paramChatMessage.mHiBoomMessage.id, 0, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, auen.jdField_a_of_type_Aueg);
          paramaezf.setText(paramChatMessage.mHiBoomMessage.text);
          if (e) {
            paramaezf.setContentDescription(a(paramChatMessage));
          }
        }
      }
      return paramBaseChatItemLayout;
      paramView = (agcv)a();
      paramaezf = null;
      break;
      label129:
      paramaezf = new HiBoomTextView(this.b);
      paramaezf.setMaxSize(Math.min(BaseChatItemLayout.f, auen.jdField_a_of_type_Int));
      paramView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = paramaezf;
      paramaezf.setOnLongClickListener(paramafce);
      paramaezf.setOnTouchListener(paramafce);
      paramaezf.setTag(paramView);
      paramBaseChatItemLayout = paramaezf;
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
    case 2131371498: 
      super.d(paramChatMessage);
      return;
    case 2131368055: 
      h(paramChatMessage);
      return;
    case 2131365382: 
      acvv.b(paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = AIOUtils.getMessage(paramView);
    String str1 = this.b.getString(2131689947);
    String str2 = this.b.getString(2131689948);
    if (paramView.isSendFromLocal()) {
      bfur.a(this.b, 230, str1, str2, new agct(this, paramView), new agcu(this)).show();
    }
  }
  
  public bgbb[] a(View paramView)
  {
    bgaz localbgaz = new bgaz();
    if ((AIOUtils.getHolder(paramView) instanceof agcv))
    {
      paramView = (agcv)AIOUtils.getHolder(paramView);
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForHiBoom))
      {
        localbgaz.a(2131368055, this.b.getString(2131692448), 2130838971);
        if (((MessageForHiBoom)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage).istroop == 0) {
          a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbgaz);
        }
      }
      if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
        a(localbgaz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      a(localbgaz, paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    super.c(localbgaz, this.b);
    super.e(localbgaz, this.b);
    return localbgaz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agcr
 * JD-Core Version:    0.7.0.1
 */