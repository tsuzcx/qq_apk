import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.view.QggMinusOneViewTitleLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qphone.base.util.QLog;

public class agzx
  extends agzo
{
  private long c;
  private long d;
  
  public agzx(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public aggl a()
  {
    return new agzy();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
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
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))) {
      oer.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramView);
    }
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ("3046055438".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && ((paramaggl instanceof agzy)))
        {
          localagzy = (agzy)paramaggl;
          if ((paramChatMessage instanceof MessageForArkApp))
          {
            if (paramView == null) {
              localagzy.a = new QggMinusOneViewTitleLayout(this.jdField_a_of_type_AndroidContentContext);
            }
            if ((localagzy.a != null) && (paramBaseChatItemLayout != null))
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
              localagzy.a.setMinusViewTitle(ofx.a());
              localagzy.a.setId(2131364454);
              paramBaseChatItemLayout.removeView(localagzy.a);
              paramBaseChatItemLayout.addView(localagzy.a);
              if (!str.equals("minus_view_title_second")) {
                continue;
              }
              localagzy.a.setPadding((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296377), zps.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296378), -zps.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        agzy localagzy;
        QLog.e("ArkAppPublicAccountItemBuilder", 1, localThrowable, new Object[0]);
        continue;
        localThrowable.a.setPadding((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296377), zps.a(this.jdField_a_of_type_AndroidContentContext, 28.0F), (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296378), -zps.a(this.jdField_a_of_type_AndroidContentContext, 7.0F));
        continue;
        paramBaseChatItemLayout.removeView(localThrowable.a);
        continue;
      }
      return super.a(paramChatMessage, paramaggl, paramView, paramBaseChatItemLayout, paramagjk);
      localagzy.a.setQggTitle(ofx.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzx
 * JD-Core Version:    0.7.0.1
 */