import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.AnimationTextView;

public class agte
  extends ahkf
{
  public agte(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (ahkn)paramafwr;
    paramafwr = paramView;
    if (paramView == null)
    {
      paramafwr = new ETTextView((Context)localObject);
      paramafwr.setTextColor(((Context)localObject).getResources().getColorStateList(2131167004));
      paramafwr.setLinkTextColor(((Context)localObject).getResources().getColorStateList(2131166998));
      paramafwr.setSpannableFactory(bdnt.a);
      paramafwr.setMaxWidth(BaseChatItemLayout.e);
      paramafwr.setMovementMethod(LinkMovementMethod.getInstance());
      paramafwr.setId(2131364382);
      paramBaseChatItemLayout.d = paramafwr;
    }
    ((ETTextView)paramBaseChatItemLayout.d).setFont(0, paramChatMessage.uniseq);
    if (!TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
    {
      paramView = ((ETTextView)paramBaseChatItemLayout.d).getETLayout();
      if (paramView != null) {
        paramView.a = (paramChatMessage.uniseq + 1L);
      }
    }
    paramBaseChatItemLayout.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int j = BaseChatItemLayout.o;
    int i = BaseChatItemLayout.p;
    if (paramChatMessage.isSend())
    {
      j = BaseChatItemLayout.p;
      i = BaseChatItemLayout.o;
    }
    paramBaseChatItemLayout.d.setPadding(j, BaseChatItemLayout.m, i, BaseChatItemLayout.n);
    if ((paramChatMessage instanceof MessageForDeviceText))
    {
      paramView = (MessageForDeviceText)paramChatMessage;
      if (paramChatMessage.msgtype == -2008) {
        if (paramChatMessage.isSend()) {
          paramBaseChatItemLayout.d.setText(((Context)localObject).getString(2131717664));
        }
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.d.setOnTouchListener(paramafzq);
      paramBaseChatItemLayout.d.setOnLongClickListener(paramafzq);
      if ((paramBaseChatItemLayout.d instanceof AnimationTextView)) {
        ((AnimationTextView)paramBaseChatItemLayout.d).onDoubleClick = new agtj(this);
      }
      return paramafwr;
      paramBaseChatItemLayout.d.setText(((Context)localObject).getString(2131717663));
      continue;
      if ("device_lock_msg".equals(paramView.extStr))
      {
        localObject = paramView.msg;
        paramChatMessage = new TextPaint();
        paramChatMessage.setColor(-12541697);
        paramChatMessage.setUnderlineText(true);
        paramView = new SpannableString((CharSequence)localObject);
        i = ((String)localObject).indexOf("点这里开启QQ设备锁");
        j = "点这里开启QQ设备锁".length();
        int k = ((String)localObject).indexOf("QQ设备锁介绍");
        int m = "QQ设备锁介绍".length();
        localObject = new agth(this);
        agti localagti = new agti(this);
        ((ClickableSpan)localObject).updateDrawState(paramChatMessage);
        localagti.updateDrawState(paramChatMessage);
        paramView.setSpan(localObject, i, j + i, 33);
        paramView.setSpan(localagti, k, m + k, 33);
        paramBaseChatItemLayout.d.setMovementMethod(LinkMovementMethod.getInstance());
        paramBaseChatItemLayout.d.setText(paramView);
      }
      else
      {
        paramBaseChatItemLayout.d.setText(paramView.sb);
        continue;
        paramBaseChatItemLayout.d.setText(paramChatMessage.msg);
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    paramContext = (abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
    paramChatMessage = (MessageForDeviceText)paramChatMessage;
    paramContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage);
  }
  
  public void a(View paramView)
  {
    if (afur.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForDeviceText)afur.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689926);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689927);
    } while (!paramView.isSendFromLocal());
    bglp.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new agtf(this, paramView), new agtg(this)).show();
  }
  
  public bguj[] a(View paramView)
  {
    paramView = afur.a(paramView);
    bguh localbguh = new bguh();
    localbguh.a(2131365147, anni.a(2131702015), 2130838920);
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
      localbguh.a(2131376435, this.jdField_a_of_type_AndroidContentContext.getString(2131717283), 2130838934);
    }
    adrm.a(localbguh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (afur.a(5) == 1) {
      localbguh.a(2131366271, this.jdField_a_of_type_AndroidContentContext.getString(2131691986), 2130838928);
    }
    super.e(localbguh, this.jdField_a_of_type_AndroidContentContext);
    return localbguh.a();
  }
  
  public void b(View paramView)
  {
    ChatMessage localChatMessage = afur.a(paramView);
    if (localChatMessage == null) {}
    do
    {
      do
      {
        return;
      } while (localChatMessage.istroop != 9501);
      if (localChatMessage.isSendFromLocal())
      {
        super.b(paramView);
        return;
      }
    } while (!"device_groupchat".equals(localChatMessage.extStr));
    super.b(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agte
 * JD-Core Version:    0.7.0.1
 */