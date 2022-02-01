import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.view.QggMinusOneViewTitleLayout;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;

public class agoy
  extends agop
{
  private long c;
  private long d;
  
  public agoy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public afqr a()
  {
    return new agoz();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    if (paramChatMessage.istroop == 1038)
    {
      long l = System.currentTimeMillis();
      if ((this.c != paramChatMessage.msgUid) || (l - this.d > 1000L))
      {
        this.c = paramChatMessage.msgUid;
        this.d = l;
        if ((paramChatMessage instanceof MessageForArkApp))
        {
          MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
          if (localMessageForArkApp.ark_app_message != null)
          {
            this.d = System.currentTimeMillis();
            MiniProgramLpReportDC04239.reportByQQ("message", "message_aio", "expo", "com.tencent.miniapp", localMessageForArkApp.ark_app_message.appView, "", "");
            if (QLog.isColorLevel()) {
              QLog.d("xiaoyong", 2, "ArkAppPublicAccountItemBuilder report");
            }
          }
        }
      }
    }
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaftk);
    onx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramView);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) && ((paramafqr instanceof agoz)))
        {
          localagoz = (agoz)paramafqr;
          if ((paramChatMessage instanceof MessageForArkApp))
          {
            if (paramView == null) {
              localagoz.a = new QggMinusOneViewTitleLayout(this.jdField_a_of_type_AndroidContentContext);
            }
            if ((localagoz.a != null) && (paramBaseChatItemLayout != null))
            {
              String str = paramChatMessage.getExtInfoFromExtStr("add_title");
              if ((!str.equals("minus_view_title_first")) && (!str.equals("minus_view_title_second"))) {
                continue;
              }
              if (paramBaseChatItemLayout.a != null) {
                paramBaseChatItemLayout.a.setText("");
              }
              if (!str.equals("minus_view_title_first")) {
                continue;
              }
              localagoz.a.setMinusViewTitle(ope.a());
              localagoz.a.setId(2131364553);
              paramBaseChatItemLayout.removeView(localagoz.a);
              paramBaseChatItemLayout.addView(localagoz.a);
              if (!str.equals("minus_view_title_second")) {
                continue;
              }
              localagoz.a.setPadding((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296430), UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 40.0F), (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296431), -UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 7.0F));
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        agoz localagoz;
        QLog.e("ArkAppPublicAccountItemBuilder", 1, localThrowable, new Object[0]);
        continue;
        localThrowable.a.setPadding((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296430), UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 28.0F), (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296431), -UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 7.0F));
        continue;
        paramBaseChatItemLayout.removeView(localThrowable.a);
        continue;
      }
      return super.a(paramChatMessage, paramafqr, paramView, paramBaseChatItemLayout, paramaftk);
      localagoz.a.setQggTitle(ope.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agoy
 * JD-Core Version:    0.7.0.1
 */