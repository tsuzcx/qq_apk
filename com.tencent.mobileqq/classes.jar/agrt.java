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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.AnimationTextView;

public class agrt
  extends ahit
{
  public agrt(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (ahjb)paramafqr;
    paramafqr = paramView;
    if (paramView == null)
    {
      paramafqr = new ETTextView((Context)localObject);
      paramafqr.setTextColor(((Context)localObject).getResources().getColorStateList(2131167045));
      paramafqr.setLinkTextColor(((Context)localObject).getResources().getColorStateList(2131167038));
      paramafqr.setSpannableFactory(QQText.SPANNABLE_FACTORY);
      paramafqr.setMaxWidth(BaseChatItemLayout.e);
      paramafqr.setMovementMethod(LinkMovementMethod.getInstance());
      paramafqr.setId(2131364525);
      paramBaseChatItemLayout.d = paramafqr;
    }
    ((ETTextView)paramBaseChatItemLayout.d).setFont(0, paramChatMessage.uniseq);
    if (!TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
    {
      paramView = ((ETTextView)paramBaseChatItemLayout.d).getETLayout();
      if (paramView != null) {
        paramView.a = (paramChatMessage.uniseq + 1L);
      }
    }
    paramBaseChatItemLayout.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
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
          paramBaseChatItemLayout.d.setText(((Context)localObject).getString(2131718418));
        }
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.d.setOnTouchListener(paramaftk);
      paramBaseChatItemLayout.d.setOnLongClickListener(paramaftk);
      if ((paramBaseChatItemLayout.d instanceof AnimationTextView)) {
        ((AnimationTextView)paramBaseChatItemLayout.d).onDoubleClick = new agry(this);
      }
      return paramafqr;
      paramBaseChatItemLayout.d.setText(((Context)localObject).getString(2131718417));
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
        localObject = new agrw(this);
        agrx localagrx = new agrx(this);
        ((ClickableSpan)localObject).updateDrawState(paramChatMessage);
        localagrx.updateDrawState(paramChatMessage);
        paramView.setSpan(localObject, i, j + i, 33);
        paramView.setSpan(localagrx, k, m + k, 33);
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
    paramContext = (abkw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
    paramChatMessage = (MessageForDeviceText)paramChatMessage;
    paramContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage);
  }
  
  public void a(View paramView)
  {
    if (AIOUtils.getMessage(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForDeviceText)AIOUtils.getMessage(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689976);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689977);
    } while (!paramView.isSendFromLocal());
    bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new agru(this, paramView), new agrv(this)).show();
  }
  
  public bhjs[] a(View paramView)
  {
    paramView = AIOUtils.getMessage(paramView);
    bhjq localbhjq = new bhjq();
    localbhjq.a(2131365307, anvx.a(2131702708), 2130838982);
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
      localbhjq.a(2131376588, this.jdField_a_of_type_AndroidContentContext.getString(2131717998), 2130838998);
    }
    admh.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    if (AIOUtils.getAIOMsgMenuDpcConfig(5) == 1) {
      localbhjq.a(2131366456, this.jdField_a_of_type_AndroidContentContext.getString(2131692126), 2130838990);
    }
    super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    return localbhjq.a();
  }
  
  public void b(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.getMessage(paramView);
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
  
  protected boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrt
 * JD-Core Version:    0.7.0.1
 */