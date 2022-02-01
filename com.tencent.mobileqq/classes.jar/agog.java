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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.ArkReportData;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class agog
  extends BaseBubbleBuilder
  implements afqw
{
  private List<MessageForArkApp> a;
  private SessionInfo b;
  private int c;
  private int d;
  
  public agog(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  private void a(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    ArkAppCenterUtil.showArkMessageContent(paramContext, paramMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
  }
  
  private void a(View paramView, MessageForArkApp paramMessageForArkApp, agol paramagol, ArkViewImplement.ArkViewInterface paramArkViewInterface)
  {
    if (e)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if ((paramagol.jdField_b_of_type_JavaLangStringBuilder != null) && (paramagol.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
        localStringBuilder.append(paramagol.jdField_b_of_type_JavaLangStringBuilder);
      }
      localStringBuilder.append(a(paramMessageForArkApp));
      paramView.setContentDescription(localStringBuilder);
      paramArkViewInterface.setContentDescription(localStringBuilder);
      ArkAppCenter.a("ArkAppItemBubbleBuilder", "Type is normal, and talkbackText is " + localStringBuilder);
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      paramView.bottomMargin = MessageForArkApp.dp2px(55.0F);
      if (paramBoolean)
      {
        paramView.addRule(0, 2131364522);
        paramView.addRule(1, 0);
      }
    }
    else
    {
      return;
    }
    paramView.addRule(1, 2131364522);
    paramView.addRule(0, 0);
  }
  
  private void a(bhjq parambhjq)
  {
    if (!ArkAppCenter.e()) {
      return;
    }
    parambhjq.a(2131362959, this.jdField_a_of_type_AndroidContentContext.getString(2131690192), 2130839001);
    parambhjq.a(2131362961, this.jdField_a_of_type_AndroidContentContext.getString(2131690191), 2130839001);
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, agol paramagol)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (!bflj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
        break label65;
      }
      paramagol.c = super.a(paramagol.c, paramagol, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 21.0F));
      super.a(paramagol.c, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
    }
    label65:
    while (paramagol.c == null) {
      return;
    }
    paramagol.c.setVisibility(8);
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramMessageForArkApp))
    {
      paramMessageForArkApp.report(0);
      this.jdField_a_of_type_JavaUtilList.add(paramMessageForArkApp);
    }
  }
  
  private void a(MessageForArkApp paramMessageForArkApp, ArkAppMessage.Config paramConfig)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramConfig.autoSize != null)
    {
      bool1 = bool2;
      if (paramConfig.autoSize.intValue() == 1) {
        bool1 = true;
      }
    }
    int i = ArkAppCenterUtil.sChatBubbleMaxWidth;
    int k = MessageForArkApp.dp2px(390.0F);
    bool2 = MessageForArkApp.isSetSizeByConfig(paramConfig);
    StringBuilder localStringBuilder = new StringBuilder("isSetSize=");
    localStringBuilder.append(bool2).append(",param=[");
    Object localObject;
    if (bool2)
    {
      localObject = MessageForArkApp.limitToSizeRange(ArkAppCenterUtil.getDensity(), paramConfig.width.intValue(), paramConfig.height.intValue());
      if (localObject != null) {
        if (!bool1) {
          break label316;
        }
      }
      label316:
      for (j = i;; j = ((MessageForArkApp.Size)localObject).width)
      {
        this.c = j;
        this.d = ((MessageForArkApp.Size)localObject).height;
        paramMessageForArkApp.arkContainer.setFixSize(this.c, this.d);
        localStringBuilder.append("arkConfig.width=").append(paramConfig.width).append(",arkConfig.height=").append(paramConfig.height).append("][autoSize=").append(bool1).append(",maxSize=").append(i).append("][size=").append(((MessageForArkApp.Size)localObject).width).append(",").append(((MessageForArkApp.Size)localObject).height).append("]").append("],app=").append(paramMessageForArkApp.ark_app_message.appName);
        QLog.i("ArkAppItemBubbleBuilder", 1, localStringBuilder.toString());
        ArkAppCenterUtil.printScaleInfo("ArkAppItemBubbleBuilder.attachArkView", this.jdField_a_of_type_AndroidContentContext);
        j = MessageForArkApp.dp2px(30.0F);
        int m = MessageForArkApp.dp2px(30.0F);
        paramMessageForArkApp.arkContainer.setMinSize(j, m);
        paramMessageForArkApp.arkContainer.setHintSize(-1, i);
        paramMessageForArkApp.arkContainer.a(i, i);
        paramMessageForArkApp.arkContainer.setMaxSize(i, k);
        return;
      }
    }
    if (bool1)
    {
      j = i;
      label334:
      this.c = j;
      this.d = -1;
      localObject = paramMessageForArkApp.arkContainer;
      if (!bool1) {
        break label444;
      }
    }
    label444:
    for (int j = i;; j = -1)
    {
      ((agnw)localObject).setFixSize(j, -1);
      localStringBuilder.append("arkConfig.width=").append(paramConfig.width).append(",arkConfig.height=").append(paramConfig.height).append("][autoSize=").append(bool1).append(",maxSize=").append(i).append("]").append(",app=").append(paramMessageForArkApp.ark_app_message.appName);
      break;
      j = -1;
      break label334;
    }
  }
  
  private boolean a(MessageForArkApp paramMessageForArkApp)
  {
    if (!ausz.a(paramMessageForArkApp))
    {
      QLog.d("ArkAppItemBubbleBuilder", 1, "showForbidShareDialog false");
      return false;
    }
    paramMessageForArkApp = paramMessageForArkApp.getExtInfoFromExtStr(bcrn.x);
    QLog.d("ArkAppItemBubbleBuilder", 1, new Object[] { "resend forbid msg wording=", paramMessageForArkApp });
    QQCustomDialog localQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230);
    localQQCustomDialog.setMessage(paramMessageForArkApp);
    localQQCustomDialog.setPositiveButton(2131694399, new agok(this));
    try
    {
      localQQCustomDialog.show();
      return true;
    }
    catch (Exception paramMessageForArkApp)
    {
      for (;;)
      {
        QLog.e("ArkAppItemBubbleBuilder", 1, "Exception", paramMessageForArkApp);
      }
    }
  }
  
  private void b(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    String str = "not loaded";
    if (paramMessageForArkApp.arkContainer != null) {
      str = paramMessageForArkApp.arkContainer.b();
    }
    QQToast.a(paramContext, str, 2000).a();
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
        break label177;
      }
    }
    label177:
    for (int i = 1;; i = 0)
    {
      localArkAppMessage.metaList = ((String)localObject).replace("#sender#", String.valueOf(i)).replace("#msgId#", String.valueOf(paramMessageForArkApp.uniseq));
      localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localObject != null) {
        ((bazk)((QQAppInterface)localObject).getManager(QQManagerFactory.QZONE_GIFT_MANAGER)).c(localArkAppMessage.metaList);
      }
      QLog.i("ArkAppItemBubbleBuilder", 1, "debugArkMeta = " + localArkAppMessage.metaList + " id = " + paramMessageForArkApp.msgtype + " _ " + paramMessageForArkApp.msgseq);
      return;
    }
  }
  
  private boolean b(MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp == null) {}
    while ((!"com.tencent.test.troopapp".equals(paramMessageForArkApp.ark_app_message.appName)) && (!"com.tencent.troopapp".equals(paramMessageForArkApp.ark_app_message.appName))) {
      return false;
    }
    return true;
  }
  
  private void c(MessageForArkApp paramMessageForArkApp)
  {
    if ((paramMessageForArkApp == null) || (paramMessageForArkApp.ark_app_message == null)) {}
    for (;;)
    {
      return;
      Object localObject = (MessageForArkApp)apyl.a(1, paramMessageForArkApp.ark_app_message.appName, paramMessageForArkApp, paramMessageForArkApp);
      if (localObject == null) {}
      while ((paramMessageForArkApp != null) && (paramMessageForArkApp.ark_app_message != null))
      {
        int i = paramMessageForArkApp.getMsgArkAppCount();
        Intent localIntent = new Intent();
        if (i == 1)
        {
          localObject = QQCustomArkDialog.AppInfo.zipArgs(paramMessageForArkApp.ark_app_message.appName, paramMessageForArkApp.ark_app_message.appView, paramMessageForArkApp.ark_app_message.appMinVersion, paramMessageForArkApp.ark_app_message.metaList, ArkAppCenterUtil.getDensity(), null, null);
          localIntent.putExtra("is_ark_display_share", true);
        }
        for (;;)
        {
          MessageForArkApp.ArkReportData localArkReportData = paramMessageForArkApp.buildTypeAndTitle();
          if (localArkReportData.isSdkShare)
          {
            ((Bundle)localObject).putString("forward_ark_app_type", localArkReportData.type);
            ((Bundle)localObject).putString("forward_ark_app_title", localArkReportData.title);
          }
          ((Bundle)localObject).putInt("forward_type", 27);
          ((Bundle)localObject).putString("forward_ark_app_name", paramMessageForArkApp.ark_app_message.appName);
          ((Bundle)localObject).putString("forward_ark_app_view", paramMessageForArkApp.ark_app_message.appView);
          ((Bundle)localObject).putString("forward_ark_app_ver", paramMessageForArkApp.ark_app_message.appMinVersion);
          ((Bundle)localObject).putString("forward_ark_app_prompt", paramMessageForArkApp.ark_app_message.promptText);
          ((Bundle)localObject).putString("forward_ark_app_config", paramMessageForArkApp.ark_app_message.config);
          ((Bundle)localObject).putString("forward_ark_app_desc", paramMessageForArkApp.ark_app_message.appDesc);
          ((Bundle)localObject).putString("forward_ark_app_compat", paramMessageForArkApp.ark_app_message.compatibleText);
          ((Bundle)localObject).putString("forward_ark_app_meta", paramMessageForArkApp.ark_app_message.metaList);
          ((Bundle)localObject).putString("forward_appId_ark_from_sdk", paramMessageForArkApp.ark_app_message.appId);
          ((Bundle)localObject).putString("struct_share_key_source_name", paramMessageForArkApp.ark_app_message.mSourceName);
          ((Bundle)localObject).putString("struct_share_key_source_action_data", paramMessageForArkApp.ark_app_message.mSourceActionData);
          ((Bundle)localObject).putString("struct_share_key_source_a_action_data", paramMessageForArkApp.ark_app_message.mSource_A_ActionData);
          ((Bundle)localObject).putString("struct_share_key_source_url", paramMessageForArkApp.ark_app_message.mSourceUrl);
          ((Bundle)localObject).putInt("selection_mode", this.jdField_b_of_type_Int);
          ((Bundle)localObject).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
          localIntent.putExtras((Bundle)localObject);
          aupt.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
          return;
          localObject = new Bundle();
        }
        paramMessageForArkApp = (MessageForArkApp)localObject;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqr a()
  {
    return new agol();
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    paramBaseChatItemLayout.setHeadIconVisible(true);
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
    localConfig.fromString(localMessageForArkApp.ark_app_message.config);
    agol localagol = (agol)paramafqr;
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558859, null);
      localagol.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)localView.findViewById(2131362957));
      localagol.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131362966));
      localagol.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362965));
      localagol.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362967));
      localagol.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setTag(localagol);
      localagol.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)localView.findViewById(2131370436));
    }
    localagol.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    if (localagol.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout != null)
    {
      paramView = (RelativeLayout.LayoutParams)localagol.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
      paramView.width = ArkAppCenterUtil.sChatBubbleMaxWidth;
      paramView.height = ArkAppCenterUtil.sChatBubbleMaxWidth;
      paramView.setMargins(0, 0, 0, 0);
      localagol.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setLayoutParams(paramView);
    }
    localView.findViewById(2131362983).setPadding(0, 0, 0, 0);
    b(localMessageForArkApp);
    if (localagol.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      localagol.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (apzo.a().a(paramChatMessage.uniseq)) {
      localMessageForArkApp.arkContainer = apzo.a().a();
    }
    if (localMessageForArkApp.arkContainer == null) {
      localMessageForArkApp.arkContainer = new agnw();
    }
    localMessageForArkApp.arkContainer.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppItemBubbleBuilder", 2, "multiAio.ArkAppItemBubbleBuilder set session info =" + apsl.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo));
    }
    paramView = localagol.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
    localMessageForArkApp.arkContainer.a(localMessageForArkApp.ark_app_message.appName, localMessageForArkApp.ark_app_message.appView, localMessageForArkApp.ark_app_message.appMinVersion, localMessageForArkApp.ark_app_message.metaList, ArkAppCenterUtil.getDensity(), localMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Object localObject = new agoh(this, localMessageForArkApp, localagol);
    localagol.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback((ArkViewImplement.LoadCallback)localObject);
    a(localMessageForArkApp, localConfig);
    localagol.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
    localObject = localagol.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    ArkAppView localArkAppView = localagol.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    ((ArkViewImplement.ArkViewInterface)localObject).setClipRadius(16.0F);
    if (MessageForArkApp.isRectangleBorder(localConfig))
    {
      ((ArkViewImplement.ArkViewInterface)localObject).setBorderType(0);
      if (paramChatMessage.isSend()) {
        break label661;
      }
    }
    label661:
    for (boolean bool = true;; bool = false)
    {
      ((ArkViewImplement.ArkViewInterface)localObject).setAlignLeft(bool);
      localArkAppView.a(localMessageForArkApp.arkContainer, paramView);
      ((ArkViewImplement.ArkViewInterface)localObject).setOnTouchListener(paramaftk);
      ((ArkViewImplement.ArkViewInterface)localObject).setOnLongClickListener(paramaftk);
      if (paramView != null)
      {
        paramView.setOnTouchListener(paramaftk);
        paramView.setOnLongClickListener(paramaftk);
      }
      a(localView, localMessageForArkApp, localagol, (ArkViewImplement.ArkViewInterface)localObject);
      aqce.b(localMessageForArkApp);
      if (paramBaseChatItemLayout.c != null) {
        a(paramBaseChatItemLayout.c, localMessageForArkApp.isSend());
      }
      if (paramBaseChatItemLayout.a != null) {
        a(paramBaseChatItemLayout.a, localMessageForArkApp.isSend());
      }
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramafqr.jdField_b_of_type_Int, paramafqr.c);
      a(localMessageForArkApp);
      a(paramChatMessage, paramBaseChatItemLayout, localagol);
      return localView;
      ((ArkViewImplement.ArkViewInterface)localObject).setBorderType(1);
      break;
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
    if (bhfj.a(paramChatMessage.issend)) {
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
      return;
    case 2131367213: 
      c((MessageForArkApp)paramChatMessage);
      return;
    case 2131365475: 
      admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131371641: 
      super.a(paramChatMessage);
      return;
    case 2131371684: 
      super.d(paramChatMessage);
      return;
    case 2131366456: 
      bmad.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      return;
    case 2131362959: 
      a(paramContext, (MessageForArkApp)paramChatMessage);
      return;
    }
    b(paramContext, (MessageForArkApp)paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForArkApp)AIOUtils.getMessage(paramView);
    if (paramView == null) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689976);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689977);
    } while ((!paramView.isSendFromLocal()) || (a(paramView)));
    bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new agoi(this, paramView), new agoj(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296389);
    int j = BaseChatItemLayout.h;
    int k = BaseChatItemLayout.i;
    int m = BaseChatItemLayout.k;
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(m, j, i, k);
      return;
    }
    paramView.setPadding(i, j, m, k);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppItemBubbleBuilder", 2, "updateView type=" + paramInt + ",message=" + paramChatMessage);
    }
    super.a(paramView, paramChatMessage, paramInt);
    b(paramChatMessage, (BaseChatItemLayout)paramView);
  }
  
  public void a(ChatMessage paramChatMessage, bhjq parambhjq)
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
        if ((paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) || (!paramChatMessage.isSupportReply())) {
          break;
        }
      } while ((!(paramChatMessage instanceof MessageForArkApp)) || (((MessageForArkApp)paramChatMessage).msg == null));
      parambhjq.a(2131376534, this.jdField_a_of_type_AndroidContentContext.getString(2131697435), 2130838997);
      return;
    } while ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (!(paramChatMessage instanceof MessageForArkApp)) || (paramChatMessage.istroop == 3000) || (((MessageForArkApp)paramChatMessage).msg == null));
    parambhjq.a(2131376534, this.jdField_a_of_type_AndroidContentContext.getString(2131697435), 2130838997);
  }
  
  public boolean a(afqr paramafqr)
  {
    return paramafqr instanceof agol;
  }
  
  public bhjs[] a(View paramView)
  {
    int j = 0;
    int m = 1;
    boolean bool = true;
    bhjq localbhjq = new bhjq();
    paramView = (afrk)AIOUtils.getHolder(paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return localbhjq.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 10007) {
      return localbhjq.a();
    }
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if ((paramView != null) && (paramView.ark_app_message != null))
      {
        a(localbhjq);
        if ((MessageForArkApp.isAllowedArkForward(false, paramView)) && (!b(paramView))) {
          localbhjq.a(2131367213, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838991);
        }
        if (paramView.isMultiMsg) {
          return localbhjq.a();
        }
        int i = j;
        if (!TextUtils.isEmpty(paramView.ark_app_message.appName))
        {
          i = j;
          if (b(paramView)) {
            i = 1;
          }
        }
        int k = m;
        if (paramView.extraflag != 32768)
        {
          k = m;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))
          {
            k = m;
            if (i == 0)
            {
              Boolean localBoolean = (Boolean)apyl.a(3, paramView.ark_app_message.appName, paramView, Boolean.valueOf(true));
              if (localBoolean != null) {
                bool = localBoolean.booleanValue();
              }
              k = bool;
              if (bool)
              {
                a(localbhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView);
                k = bool;
              }
            }
          }
        }
        if (k != 0) {
          a(localbhjq, paramView);
        }
        for (;;)
        {
          super.c(localbhjq, this.jdField_a_of_type_AndroidContentContext);
          if (bflj.b(paramView)) {
            c(paramView, localbhjq);
          }
          try
          {
            if (aqzu.a().a(paramView.ark_app_message.appName, paramView.ark_app_message.appView))
            {
              a(paramView, localbhjq);
              super.b(paramView, localbhjq);
            }
            if (bmaf.a(paramView)) {
              super.d(localbhjq, this.jdField_a_of_type_AndroidContentContext);
            }
            super.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, paramView);
            super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
            return localbhjq.a();
            admh.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
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
    admh.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    super.c(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    return localbhjq.a();
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "6", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agog
 * JD-Core Version:    0.7.0.1
 */