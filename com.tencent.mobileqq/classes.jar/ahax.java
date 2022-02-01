import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForAutoReply;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ahax
  extends ahtp
{
  private bhpc a;
  
  public ahax(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  @NotNull
  private ClickableSpan a(ahtx paramahtx, MessageForAutoReply paramMessageForAutoReply)
  {
    return new ahay(this, paramMessageForAutoReply, paramahtx);
  }
  
  @Nullable
  private BaseChatPie a(FragmentActivity paramFragmentActivity)
  {
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if ((paramFragmentActivity instanceof ChatFragment)) {
      return ((ChatFragment)paramFragmentActivity).a();
    }
    return null;
  }
  
  @Nullable
  private CharSequence a(MessageForAutoReply paramMessageForAutoReply)
  {
    boolean bool = e();
    if (QLog.isColorLevel()) {
      QLog.d("[AutoReply] AutoReplyTextItemBuilder", 2, new Object[] { "[view] getMessageContent: invoked. ", " friendChatPie: ", Boolean.valueOf(bool) });
    }
    if (bool) {
      return paramMessageForAutoReply.sb;
    }
    return new begp(paramMessageForAutoReply.msg, 13, ChatTextSizeSettingActivity.a(), paramMessageForAutoReply);
  }
  
  private void a(ahtx paramahtx, MessageForAutoReply paramMessageForAutoReply)
  {
    Object localObject1 = a(paramMessageForAutoReply);
    if (paramMessageForAutoReply.needTextLink)
    {
      Object localObject2 = a(paramahtx, paramMessageForAutoReply);
      localObject2 = new bega(paramMessageForAutoReply.msg, 13, ChatTextSizeSettingActivity.a(), paramMessageForAutoReply, localObject2);
      localObject1 = (begw[])((bega)localObject2).getSpans(0, ((CharSequence)localObject1).length(), begw.class);
      if ((localObject1.length > 0) && (((bega)localObject2).b().length() == 0))
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          localObject1[i].a(bdep.a(26.0F));
          i += 1;
        }
      }
      paramahtx.d.setText((CharSequence)localObject2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[AutoReply] AutoReplyTextItemBuilder", 2, new Object[] { "[view] bindQQTextView: invoked. ", " message.needTextLink: ", Boolean.valueOf(paramMessageForAutoReply.needTextLink) });
      }
      return;
      paramahtx.d.setText((CharSequence)localObject1);
    }
  }
  
  private void a(Context paramContext)
  {
    Object localObject = BaseActivity.sTopActivity;
    if (localObject != null) {}
    for (;;)
    {
      this.jdField_a_of_type_Bhpc = bhlq.a((Context)localObject, 230, paramContext.getResources().getString(2131690193), paramContext.getResources().getString(2131690192), 2131690580, 2131693171, new ahaz(this, paramContext), new ahba(this));
      try
      {
        this.jdField_a_of_type_Bhpc.show();
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("[AutoReply] AutoReplyTextItemBuilder", 1, "[谨慎此异常，弹窗无法展示] showSetAutoReplyDialog: failed. context: " + this.jdField_a_of_type_AndroidContentContext.getClass().getName(), paramContext);
      }
      localObject = paramContext;
    }
  }
  
  private void a(View paramView, MessageForAutoReply paramMessageForAutoReply)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(paramMessageForAutoReply.senderuin)) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      azir.a("0X800B0AE");
      if (QLog.isColorLevel()) {
        QLog.d("[AutoReply] AutoReplyTextItemBuilder", 2, new Object[] { "[action] onTextLinkClicked: invoked. ", " message: ", paramMessageForAutoReply.senderuin });
      }
      return;
      a(this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Intent localIntent = new Intent();
    if (aqqy.a(paramQQAppInterface.getOnlineStatus())) {
      localIntent.putExtra("KEY_ONLINE_STATUS", AppRuntime.Status.away);
    }
    localIntent.putExtra("KEY_HAS_LEFT_BUTTON_TEXT", true);
    localIntent.putExtra("KEY_ENTRANCE", 1);
    PublicFragmentActivity.a(paramContext, localIntent, AccountOnlineStateActivity.class);
  }
  
  private boolean e()
  {
    BaseChatPie localBaseChatPie;
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      localBaseChatPie = a((FragmentActivity)BaseActivity.sTopActivity);
      if (localBaseChatPie != null) {}
    }
    else
    {
      return false;
    }
    if (((localBaseChatPie instanceof aijm)) && (localBaseChatPie.b() == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    paramView = super.a(paramChatMessage, paramaggl, paramView, paramBaseChatItemLayout, paramagjk);
    paramaggl = (ahtx)paramaggl;
    if ((paramChatMessage instanceof MessageForAutoReply)) {
      a(paramaggl, (MessageForAutoReply)paramChatMessage);
    }
    return paramView;
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("[AutoReply] AutoReplyTextItemBuilder", 2, new Object[] { "[dialog] destroy: invoked. ", " setAutoReplyDialog: ", this.jdField_a_of_type_Bhpc });
    }
    if (this.jdField_a_of_type_Bhpc != null) {}
    try
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      this.jdField_a_of_type_Bhpc = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("[AutoReply] AutoReplyTextItemBuilder", 1, new Object[] { "[dialog] destroy: invoked. ", " e: ", localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahax
 * JD-Core Version:    0.7.0.1
 */