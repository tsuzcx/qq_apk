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

public class ahcr
  extends ahtp
{
  public ahcr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (ahtx)paramaggl;
    paramaggl = paramView;
    if (paramView == null)
    {
      paramaggl = new ETTextView((Context)localObject);
      paramaggl.setTextColor(((Context)localObject).getResources().getColorStateList(2131167009));
      paramaggl.setLinkTextColor(((Context)localObject).getResources().getColorStateList(2131167002));
      paramaggl.setSpannableFactory(begp.a);
      paramaggl.setMaxWidth(BaseChatItemLayout.e);
      paramaggl.setMovementMethod(LinkMovementMethod.getInstance());
      paramaggl.setId(2131364426);
      paramBaseChatItemLayout.d = paramaggl;
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
          paramBaseChatItemLayout.d.setText(((Context)localObject).getString(2131717795));
        }
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.d.setOnTouchListener(paramagjk);
      paramBaseChatItemLayout.d.setOnLongClickListener(paramagjk);
      if ((paramBaseChatItemLayout.d instanceof AnimationTextView)) {
        ((AnimationTextView)paramBaseChatItemLayout.d).onDoubleClick = new ahcw(this);
      }
      return paramaggl;
      paramBaseChatItemLayout.d.setText(((Context)localObject).getString(2131717794));
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
        localObject = new ahcu(this);
        ahcv localahcv = new ahcv(this);
        ((ClickableSpan)localObject).updateDrawState(paramChatMessage);
        localahcv.updateDrawState(paramChatMessage);
        paramView.setSpan(localObject, i, j + i, 33);
        paramView.setSpan(localahcv, k, m + k, 33);
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
    paramContext = (abzb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
    paramChatMessage = (MessageForDeviceText)paramChatMessage;
    paramContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage);
  }
  
  public void a(View paramView)
  {
    if (agej.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForDeviceText)agej.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689933);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689934);
    } while (!paramView.isSendFromLocal());
    bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ahcs(this, paramView), new ahct(this)).show();
  }
  
  public bhum[] a(View paramView)
  {
    paramView = agej.a(paramView);
    bhuk localbhuk = new bhuk();
    localbhuk.a(2131365191, anzj.a(2131702122), 2130838930);
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
      localbhuk.a(2131376567, this.jdField_a_of_type_AndroidContentContext.getString(2131717399), 2130838944);
    }
    aean.a(localbhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (agej.a(5) == 1) {
      localbhuk.a(2131366320, this.jdField_a_of_type_AndroidContentContext.getString(2131691990), 2130838938);
    }
    super.e(localbhuk, this.jdField_a_of_type_AndroidContentContext);
    return localbhuk.a();
  }
  
  public void b(View paramView)
  {
    ChatMessage localChatMessage = agej.a(paramView);
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
 * Qualified Name:     ahcr
 * JD-Core Version:    0.7.0.1
 */