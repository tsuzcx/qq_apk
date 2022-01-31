import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.ArkReportData;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class adls
  extends BaseBubbleBuilder
  implements acum
{
  private static final int c = BaseChatItemLayout.g;
  private static final int d = BaseChatItemLayout.h;
  private static final int e;
  private List<MessageForArkApp> a;
  private SessionInfo b;
  private int f;
  private int g;
  
  static
  {
    jdField_e_of_type_Int = BaseChatItemLayout.j;
  }
  
  public adls(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      paramView.bottomMargin = MessageForArkApp.dp2px(55.0F);
      if (paramBoolean)
      {
        paramView.addRule(0, 2131364109);
        paramView.addRule(1, 0);
      }
    }
    else
    {
      return;
    }
    paramView.addRule(1, 2131364109);
    paramView.addRule(0, 0);
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramMessageForArkApp))
    {
      paramMessageForArkApp.report(0);
      this.jdField_a_of_type_JavaUtilList.add(paramMessageForArkApp);
    }
  }
  
  private boolean a(MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp == null) {}
    while ((!"com.tencent.test.troopapp".equals(paramMessageForArkApp.ark_app_message.appName)) && (!"com.tencent.troopapp".equals(paramMessageForArkApp.ark_app_message.appName))) {
      return false;
    }
    return true;
  }
  
  private void b(MessageForArkApp paramMessageForArkApp)
  {
    if ((paramMessageForArkApp == null) || (paramMessageForArkApp.ark_app_message == null) || (TextUtils.isEmpty(paramMessageForArkApp.ark_app_message.metaList))) {
      return;
    }
    ArkAppMessage localArkAppMessage = paramMessageForArkApp.ark_app_message;
    Object localObject;
    if ("com.tencent.giftmall.giftark".equals(localArkAppMessage.appName))
    {
      localObject = localArkAppMessage.metaList;
      if (!paramMessageForArkApp.isSend()) {
        break label171;
      }
    }
    label171:
    for (int i = 1;; i = 0)
    {
      localArkAppMessage.metaList = ((String)localObject).replace("#sender#", String.valueOf(i)).replace("#msgId#", String.valueOf(paramMessageForArkApp.uniseq));
      localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localObject != null) {
        ((avno)((QQAppInterface)localObject).getManager(312)).c(localArkAppMessage.metaList);
      }
      QLog.i("ArkAppItemBubbleBuilder", 1, "debugArkMeta = " + localArkAppMessage.metaList + " id = " + paramMessageForArkApp.msgtype + " _ " + paramMessageForArkApp.msgseq);
      return;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acuj a()
  {
    return new adlw();
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    paramBaseChatItemLayout.setHeadIconVisible(true);
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
    localConfig.fromString(localMessageForArkApp.ark_app_message.config);
    if ((localConfig.autoSize != null) && (localConfig.autoSize.intValue() == 1)) {}
    label1174:
    label1180:
    for (boolean bool1 = true;; bool1 = false)
    {
      adlw localadlw = (adlw)paramacuj;
      View localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558727, null);
        localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)localView.findViewById(2131362768));
        localadlw.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131362774));
        localadlw.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362773));
        localadlw.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362775));
        localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setTag(localadlw);
        localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)localView.findViewById(2131369476));
      }
      localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView = (RelativeLayout.LayoutParams)localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
      paramView.width = alsz.a;
      paramView.height = alsz.a;
      paramView.setMargins(0, 0, 0, 0);
      localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setLayoutParams(paramView);
      localView.findViewById(2131362789).setPadding(0, 0, 0, 0);
      b(localMessageForArkApp);
      if (localadlw.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        localadlw.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      if (alub.a().a(paramChatMessage.uniseq)) {
        localMessageForArkApp.arkContainer = alub.a().a();
      }
      if (localMessageForArkApp.arkContainer == null) {
        localMessageForArkApp.arkContainer = new adli();
      }
      localMessageForArkApp.arkContainer.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppItemBubbleBuilder", 2, "multiAio.ArkAppItemBubbleBuilder set session info =" + aloy.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo));
      }
      paramView = localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
      localMessageForArkApp.arkContainer.a(localMessageForArkApp.ark_app_message.appName, localMessageForArkApp.ark_app_message.appView, localMessageForArkApp.ark_app_message.appMinVersion, localMessageForArkApp.ark_app_message.metaList, alsz.a(), localMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      Object localObject1 = new adlt(this, localMessageForArkApp, localadlw);
      localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback((ArkViewImplement.LoadCallback)localObject1);
      int i = alsz.a;
      int k = MessageForArkApp.dp2px(390.0F);
      boolean bool2 = MessageForArkApp.isSetSizeByConfig(localConfig);
      localObject1 = new StringBuilder("isSetSize=");
      ((StringBuilder)localObject1).append(bool2).append(",param=[");
      Object localObject2;
      int j;
      if (bool2)
      {
        localObject2 = MessageForArkApp.limitToSizeRange(alsz.a(), localConfig.width.intValue(), localConfig.height.intValue());
        if (localObject2 != null)
        {
          if (bool1)
          {
            j = i;
            this.f = j;
            this.g = ((MessageForArkApp.Size)localObject2).height;
            localMessageForArkApp.arkContainer.setFixSize(this.f, this.g);
            ((StringBuilder)localObject1).append("arkConfig.width=").append(localConfig.width).append(",arkConfig.height=").append(localConfig.height).append("][autoSize=").append(bool1).append(",maxSize=").append(i).append("][size=").append(((MessageForArkApp.Size)localObject2).width).append(",").append(((MessageForArkApp.Size)localObject2).height).append("]").append("],app=").append(localMessageForArkApp.ark_app_message.appName);
          }
        }
        else
        {
          QLog.i("ArkAppItemBubbleBuilder", 1, ((StringBuilder)localObject1).toString());
          alsz.a("ArkAppItemBubbleBuilder.attachArkView", this.jdField_a_of_type_AndroidContentContext);
          j = MessageForArkApp.dp2px(30.0F);
          int m = MessageForArkApp.dp2px(30.0F);
          localMessageForArkApp.arkContainer.setMinSize(j, m);
          localMessageForArkApp.arkContainer.setHintSize(-1, i);
          localMessageForArkApp.arkContainer.a(i, i);
          localMessageForArkApp.arkContainer.setMaxSize(i, k);
          localadlw.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
          localObject1 = localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
          localObject2 = localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
          ((ArkViewImplement.ArkViewInterface)localObject1).setClipRadius(16.0F);
          if (!MessageForArkApp.isRectangleBorder(localConfig)) {
            break label1180;
          }
          ((ArkViewImplement.ArkViewInterface)localObject1).setBorderType(0);
          label798:
          if (paramChatMessage.isSend()) {
            break label1191;
          }
        }
      }
      label1054:
      label1191:
      for (bool1 = true;; bool1 = false)
      {
        ((ArkViewImplement.ArkViewInterface)localObject1).setAlignLeft(bool1);
        ((adln)localObject2).a(localMessageForArkApp.arkContainer, paramView);
        ((ArkViewImplement.ArkViewInterface)localObject1).setOnTouchListener(paramacxj);
        ((ArkViewImplement.ArkViewInterface)localObject1).setOnLongClickListener(paramacxj);
        if (paramView != null)
        {
          paramView.setOnTouchListener(paramacxj);
          paramView.setOnLongClickListener(paramacxj);
        }
        if (jdField_e_of_type_Boolean)
        {
          paramView = new StringBuilder();
          if ((localadlw.jdField_b_of_type_JavaLangStringBuilder != null) && (localadlw.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
            paramView.append(localadlw.jdField_b_of_type_JavaLangStringBuilder);
          }
          paramView.append(a(localMessageForArkApp));
          localView.setContentDescription(paramView);
          ((ArkViewImplement.ArkViewInterface)localObject1).setContentDescription(paramView);
          ArkAppCenter.a("ArkAppItemBubbleBuilder", "Type is normal, and talkbackText is " + paramView);
        }
        alwo.b(localMessageForArkApp);
        if (paramBaseChatItemLayout.c != null) {
          a(paramBaseChatItemLayout.c, localMessageForArkApp.isSend());
        }
        if (paramBaseChatItemLayout.a != null) {
          a(paramBaseChatItemLayout.a, localMessageForArkApp.isSend());
        }
        ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramacuj.jdField_b_of_type_Int, paramacuj.c);
        a(localMessageForArkApp);
        return localView;
        j = ((MessageForArkApp.Size)localObject2).width;
        break;
        if (bool1)
        {
          j = i;
          this.f = j;
          this.g = -1;
          localObject2 = localMessageForArkApp.arkContainer;
          if (!bool1) {
            break label1174;
          }
        }
        for (j = i;; j = -1)
        {
          ((adli)localObject2).setFixSize(j, -1);
          ((StringBuilder)localObject1).append("arkConfig.width=").append(localConfig.width).append(",arkConfig.height=").append(localConfig.height).append("][autoSize=").append(bool1).append(",maxSize=").append(i).append("]").append(",app=").append(localMessageForArkApp.ark_app_message.appName);
          break;
          j = -1;
          break label1054;
        }
        ((ArkViewImplement.ArkViewInterface)localObject1).setBorderType(1);
        break label798;
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return "";
    }
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    if ((localMessageForArkApp.ark_app_message == null) || (localMessageForArkApp.ark_app_message.promptText == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (bbfh.a(paramChatMessage.issend)) {
      localStringBuilder.append("发出");
    }
    for (;;)
    {
      localStringBuilder.append(localMessageForArkApp.ark_app_message.promptText);
      if (localMessageForArkApp.arkContainer != null)
      {
        paramChatMessage = localMessageForArkApp.arkContainer.jdField_b_of_type_JavaLangString;
        if (!TextUtils.isEmpty(paramChatMessage)) {
          localStringBuilder.append(paramChatMessage);
        }
      }
      return localStringBuilder.toString();
      localStringBuilder.append("发来");
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131366632: 
      do
      {
        return;
        paramContext = (MessageForArkApp)paramChatMessage;
      } while ((paramContext == null) || (paramContext.ark_app_message == null));
      paramChatMessage = (MessageForArkApp)alsw.a(1, paramContext.ark_app_message.appName, paramContext, paramContext);
      if (paramChatMessage != null) {
        break;
      }
    }
    while ((paramContext != null) && (paramContext.ark_app_message != null))
    {
      paramInt = paramContext.getMsgArkAppCount();
      Intent localIntent = new Intent();
      if (paramInt == 1)
      {
        paramChatMessage = bbgo.a(paramContext.ark_app_message.appName, paramContext.ark_app_message.appView, paramContext.ark_app_message.appMinVersion, paramContext.ark_app_message.metaList, alsz.a(), null, null);
        localIntent.putExtra("is_ark_display_share", true);
      }
      for (;;)
      {
        MessageForArkApp.ArkReportData localArkReportData = paramContext.buildTypeAndTitle();
        if (localArkReportData.isSdkShare)
        {
          paramChatMessage.putString("forward_ark_app_type", localArkReportData.type);
          paramChatMessage.putString("forward_ark_app_title", localArkReportData.title);
        }
        paramChatMessage.putInt("forward_type", 27);
        paramChatMessage.putString("forward_ark_app_name", paramContext.ark_app_message.appName);
        paramChatMessage.putString("forward_ark_app_view", paramContext.ark_app_message.appView);
        paramChatMessage.putString("forward_ark_app_ver", paramContext.ark_app_message.appMinVersion);
        paramChatMessage.putString("forward_ark_app_prompt", paramContext.ark_app_message.promptText);
        paramChatMessage.putString("forward_ark_app_config", paramContext.ark_app_message.config);
        paramChatMessage.putString("forward_ark_app_desc", paramContext.ark_app_message.appDesc);
        paramChatMessage.putString("forward_ark_app_compat", paramContext.ark_app_message.compatibleText);
        paramChatMessage.putString("forward_ark_app_meta", paramContext.ark_app_message.metaList);
        paramChatMessage.putString("forward_appId_ark_from_sdk", paramContext.ark_app_message.appId);
        paramChatMessage.putString("struct_share_key_source_name", paramContext.ark_app_message.mSourceName);
        paramChatMessage.putString("struct_share_key_source_action_data", paramContext.ark_app_message.mSourceActionData);
        paramChatMessage.putString("struct_share_key_source_a_action_data", paramContext.ark_app_message.mSource_A_ActionData);
        paramChatMessage.putString("struct_share_key_source_url", paramContext.ark_app_message.mSourceUrl);
        paramChatMessage.putInt("selection_mode", this.jdField_b_of_type_Int);
        paramChatMessage.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        localIntent.putExtras(paramChatMessage);
        aqbe.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
        return;
        paramChatMessage = new Bundle();
      }
      aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      super.a(paramChatMessage);
      return;
      super.d(paramChatMessage);
      return;
      bgpu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      return;
      paramContext = paramChatMessage;
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForArkApp)actj.a(paramView);
    if (paramView == null) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689995);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689996);
    } while (!paramView.isSendFromLocal());
    bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new adlu(this, paramView), new adlv(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296292);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(jdField_e_of_type_Int, c, i, d);
      return;
    }
    paramView.setPadding(i, c, jdField_e_of_type_Int, d);
  }
  
  public void a(ChatMessage paramChatMessage, bbmf parambbmf)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramChatMessage.istroop != 1) && (paramChatMessage.istroop != 3000) && (paramChatMessage.istroop != 0));
        if ((paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) || (!paramChatMessage.isSupportReply())) {
          break;
        }
      } while ((!(paramChatMessage instanceof MessageForArkApp)) || (((MessageForArkApp)paramChatMessage).msg == null));
      parambbmf.a(2131375125, this.jdField_a_of_type_AndroidContentContext.getString(2131697941), 2130838610);
      return;
    } while ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (!(paramChatMessage instanceof MessageForArkApp)) || (paramChatMessage.istroop == 3000) || (((MessageForArkApp)paramChatMessage).msg == null));
    parambbmf.a(2131375125, this.jdField_a_of_type_AndroidContentContext.getString(2131697941), 2130838610);
  }
  
  public boolean a(acuj paramacuj)
  {
    return paramacuj instanceof adlw;
  }
  
  public bbmh[] a(View paramView)
  {
    int j = 0;
    int m = 1;
    boolean bool = true;
    bbmf localbbmf = new bbmf();
    paramView = (acva)actj.a(paramView);
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if ((paramView != null) && (paramView.ark_app_message != null))
      {
        if ((MessageForArkApp.isAllowedArkForward(false, paramView)) && (!a(paramView))) {
          localbbmf.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692753), 2130838606);
        }
        if (paramView.isMultiMsg) {
          return localbbmf.a();
        }
        int i = j;
        if (!TextUtils.isEmpty(paramView.ark_app_message.appName))
        {
          i = j;
          if (a(paramView)) {
            i = 1;
          }
        }
        int k = m;
        if (paramView.extraflag != 32768)
        {
          k = m;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))
          {
            k = m;
            if (i == 0)
            {
              Boolean localBoolean = (Boolean)alsw.a(3, paramView.ark_app_message.appName, paramView, Boolean.valueOf(true));
              if (localBoolean != null) {
                bool = localBoolean.booleanValue();
              }
              k = bool;
              if (bool)
              {
                a(localbbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
                k = bool;
              }
            }
          }
        }
        if (k != 0) {
          a(localbbmf, paramView);
        }
        for (;;)
        {
          super.c(localbbmf, this.jdField_a_of_type_AndroidContentContext);
          try
          {
            if (amrr.a().a(paramView.ark_app_message.appName, paramView.ark_app_message.appView))
            {
              a(paramView, localbbmf);
              super.b(paramView, localbbmf);
            }
            if (bgpw.a(paramView)) {
              super.d(localbbmf, this.jdField_a_of_type_AndroidContentContext);
            }
            super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
            return localbbmf.a();
            aanz.a(localbbmf, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.d("ArkAppItemBubbleBuilder", 2, "add reply menu error, exception =" + localException.getMessage());
            }
          }
        }
      }
    }
    aanz.a(localbbmf, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    return localbbmf.a();
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "6", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adls
 * JD-Core Version:    0.7.0.1
 */