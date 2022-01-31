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

public class afgz
  extends afyl
{
  public afgz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (afys)paramaelt;
    paramaelt = paramView;
    if (paramView == null)
    {
      paramaelt = new ETTextView((Context)localObject);
      paramaelt.setTextColor(((Context)localObject).getResources().getColorStateList(2131166919));
      paramaelt.setLinkTextColor(((Context)localObject).getResources().getColorStateList(2131166913));
      paramaelt.setSpannableFactory(baig.a);
      paramaelt.setMaxWidth(BaseChatItemLayout.d);
      paramaelt.setMovementMethod(LinkMovementMethod.getInstance());
      paramaelt.setId(2131364174);
      paramBaseChatItemLayout.d = paramaelt;
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
          paramBaseChatItemLayout.d.setText(((Context)localObject).getString(2131719625));
        }
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.d.setOnTouchListener(paramaeov);
      paramBaseChatItemLayout.d.setOnLongClickListener(paramaeov);
      if ((paramBaseChatItemLayout.d instanceof AnimationTextView)) {
        ((AnimationTextView)paramBaseChatItemLayout.d).onDoubleClick = new afhe(this);
      }
      return paramaelt;
      paramBaseChatItemLayout.d.setText(((Context)localObject).getString(2131719624));
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
        localObject = new afhc(this);
        afhd localafhd = new afhd(this);
        ((ClickableSpan)localObject).updateDrawState(paramChatMessage);
        localafhd.updateDrawState(paramChatMessage);
        paramView.setSpan(localObject, i, j + i, 33);
        paramView.setSpan(localafhd, k, m + k, 33);
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
    paramContext = (ztk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
    paramChatMessage = (MessageForDeviceText)paramChatMessage;
    paramContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage);
  }
  
  public void a(View paramView)
  {
    if (aekt.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForDeviceText)aekt.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690042);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131690043);
    } while (!paramView.isSendFromLocal());
    bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new afha(this, paramView), new afhb(this)).show();
  }
  
  public bdlb[] a(View paramView)
  {
    paramView = aekt.a(paramView);
    bdkz localbdkz = new bdkz();
    localbdkz.a(2131364910, alpo.a(2131703606), 2130838668);
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
      localbdkz.a(2131375657, this.jdField_a_of_type_AndroidContentContext.getString(2131719140), 2130838682);
    }
    acex.a(localbdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (aekt.a(5) == 1) {
      localbdkz.a(2131366015, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838676);
    }
    super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    return localbdkz.a();
  }
  
  public void b(View paramView)
  {
    ChatMessage localChatMessage = aekt.a(paramView);
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
 * Qualified Name:     afgz
 * JD-Core Version:    0.7.0.1
 */