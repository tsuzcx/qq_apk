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

public class adop
  extends aebx
{
  public adop(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (aece)paramacuj;
    paramacuj = paramView;
    if (paramView == null)
    {
      paramacuj = new ETTextView((Context)localObject);
      paramacuj.setTextColor(((Context)localObject).getResources().getColorStateList(2131166872));
      paramacuj.setLinkTextColor(((Context)localObject).getResources().getColorStateList(2131166866));
      paramacuj.setSpannableFactory(aykk.a);
      paramacuj.setMaxWidth(BaseChatItemLayout.d);
      paramacuj.setMovementMethod(LinkMovementMethod.getInstance());
      paramacuj.setId(2131364112);
      paramBaseChatItemLayout.d = paramacuj;
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
    int j = BaseChatItemLayout.n;
    int i = BaseChatItemLayout.o;
    if (paramChatMessage.isSend())
    {
      j = BaseChatItemLayout.o;
      i = BaseChatItemLayout.n;
    }
    paramBaseChatItemLayout.d.setPadding(j, BaseChatItemLayout.l, i, BaseChatItemLayout.m);
    if ((paramChatMessage instanceof MessageForDeviceText))
    {
      paramView = (MessageForDeviceText)paramChatMessage;
      if (paramChatMessage.msgtype == -2008) {
        if (paramChatMessage.isSend()) {
          paramBaseChatItemLayout.d.setText(((Context)localObject).getString(2131719144));
        }
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.d.setOnTouchListener(paramacxj);
      paramBaseChatItemLayout.d.setOnLongClickListener(paramacxj);
      if ((paramBaseChatItemLayout.d instanceof AnimationTextView)) {
        ((AnimationTextView)paramBaseChatItemLayout.d).onDoubleClick = new adou(this);
      }
      return paramacuj;
      paramBaseChatItemLayout.d.setText(((Context)localObject).getString(2131719143));
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
        localObject = new ados(this);
        adot localadot = new adot(this);
        ((ClickableSpan)localObject).updateDrawState(paramChatMessage);
        localadot.updateDrawState(paramChatMessage);
        paramView.setSpan(localObject, i, j + i, 33);
        paramView.setSpan(localadot, k, m + k, 33);
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
    paramContext = (yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
    paramChatMessage = (MessageForDeviceText)paramChatMessage;
    paramContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage);
  }
  
  public void a(View paramView)
  {
    if (actj.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForDeviceText)actj.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689995);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689996);
    } while (!paramView.isSendFromLocal());
    bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new adoq(this, paramView), new ador(this)).show();
  }
  
  public bbmh[] a(View paramView)
  {
    paramView = actj.a(paramView);
    bbmf localbbmf = new bbmf();
    localbbmf.a(2131364824, ajya.a(2131703234), 2130838597);
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
      localbbmf.a(2131375176, this.jdField_a_of_type_AndroidContentContext.getString(2131718667), 2130838611);
    }
    aanz.a(localbbmf, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (actj.a(5) == 1) {
      localbbmf.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692324), 2130838605);
    }
    super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    return localbbmf.a();
  }
  
  public void b(View paramView)
  {
    ChatMessage localChatMessage = actj.a(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adop
 * JD-Core Version:    0.7.0.1
 */