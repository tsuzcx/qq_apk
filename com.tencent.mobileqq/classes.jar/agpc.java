import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.ArkReportData;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class agpc
  extends BaseBubbleBuilder
  implements afqw, apza
{
  private List<MessageForArkApp> a;
  
  public agpc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private RelativeLayout.LayoutParams a(BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams1.width = -1;
    localLayoutParams1.height = (ArkAppCenterUtil.sChatBubbleMaxWidth + AIOUtils.dp2px(29.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localLayoutParams1.leftMargin = 0;
    paramBaseChatItemLayout.setPadding(0, BaseChatItemLayout.v, 0, BaseChatItemLayout.i + BaseChatItemLayout.l);
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
    int i;
    if (paramBoolean)
    {
      localLayoutParams2.rightMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296390);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setLayoutParams(localLayoutParams2);
      if (paramBaseChatItemLayout.b != null)
      {
        localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.b.getLayoutParams();
        i = MessageForArkApp.dp2px(1.0F);
        if (!paramBoolean) {
          break label327;
        }
        localLayoutParams2.addRule(7, 2131364531);
        localLayoutParams2.rightMargin = (-i);
        label147:
        paramBaseChatItemLayout.b.setLayoutParams(localLayoutParams2);
      }
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
        localLayoutParams2.leftMargin = BaseChatItemLayout.t;
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams(localLayoutParams2);
      }
      if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 8))
      {
        localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        if (!paramBoolean) {
          break label345;
        }
        localLayoutParams2.rightMargin = BaseChatItemLayout.u;
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams2);
      return localLayoutParams1;
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        i = MessageForArkApp.dp2px(30.0F);
        localLayoutParams2.leftMargin = (BaseChatItemLayout.t + i);
        localLayoutParams1.leftMargin = (i - BaseChatItemLayout.t);
        break;
      }
      localLayoutParams2.leftMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296390);
      break;
      label327:
      localLayoutParams2.addRule(5, 2131364531);
      localLayoutParams2.leftMargin = (-i);
      break label147;
      label345:
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8)) {
        localLayoutParams2.leftMargin = (MessageForArkApp.dp2px(25.0F) + BaseChatItemLayout.t);
      } else {
        localLayoutParams2.leftMargin = BaseChatItemLayout.t;
      }
    }
  }
  
  private void a(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    ArkAppCenterUtil.showArkMessageContent(paramContext, paramMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt1);
    localLayoutParams.addRule(8, 2131364522);
    localLayoutParams.bottomMargin = paramInt2;
    if (paramBoolean)
    {
      localLayoutParams.addRule(5, 2131364522);
      localLayoutParams.leftMargin = paramInt3;
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.addRule(7, 2131364522);
      localLayoutParams.rightMargin = paramInt3;
    }
  }
  
  private void a(bhjq parambhjq)
  {
    if (!ArkAppCenter.e()) {
      return;
    }
    parambhjq.a(2131362959, this.jdField_a_of_type_AndroidContentContext.getString(2131690192), 2130839001);
    parambhjq.a(2131362961, this.jdField_a_of_type_AndroidContentContext.getString(2131690191), 2130839001);
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramMessageForArkApp))
    {
      paramMessageForArkApp.report(0);
      this.jdField_a_of_type_JavaUtilList.add(paramMessageForArkApp);
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
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqr a()
  {
    return new agpf();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    paramChatMessage = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaftk);
    paramView = (agpf)paramChatMessage.getTag();
    paramViewGroup = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramaftk = paramChatMessage.b();
    if ((paramaftk != null) && (paramaftk.getVisibility() == 0)) {
      paramViewGroup.addRule(3, 2131364540);
    }
    for (paramViewGroup.topMargin = BaseChatItemLayout.h;; paramViewGroup.topMargin = 0)
    {
      paramView.jdField_a_of_type_AndroidViewView.setLayoutParams(paramViewGroup);
      return paramChatMessage;
      paramViewGroup.addRule(6, 2131364531);
    }
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    boolean bool = localMessageForArkApp.isSend();
    Object localObject = a(paramBaseChatItemLayout, bool);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = BaseChatItemLayout.o;
    int j = MessageForArkApp.dp2px(40.0F);
    int k = localResources.getDimensionPixelSize(2131296388) + (i * 2 + j);
    int m = localResources.getDimensionPixelSize(2131296380);
    i = ArkAppCenterUtil.sRealDisplayWith - k - ArkAppCenterUtil.sChatBubbleMaxWidth - m;
    label109:
    agpf localagpf;
    apzb localapzb;
    if (bool)
    {
      j = i;
      if (!bool) {
        break label442;
      }
      k -= m;
      QLog.d("ArkAppShareMultiItemBuilder", 1, new Object[] { "ArkFold.appName:", localMessageForArkApp.ark_app_message.appName, ", getChatbubbleMaxWidth=", Integer.valueOf(ArkAppCenterUtil.sChatBubbleMaxWidth), ", displaywitdh=", Integer.valueOf(ArkAppCenterUtil.sDisplayWith), ", headerWidth=", Integer.valueOf(j), ",footerWidth=", Integer.valueOf(k) });
      localagpf = (agpf)paramafqr;
      paramView = (ArkHorizontalListView)paramView;
      if (paramView != null) {
        break label449;
      }
      paramView = new ArkHorizontalListView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setDividerWidth(m);
      localapzb = new apzb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, paramaftk);
      paramView.setAdapter(localapzb);
      paramaftk = paramView;
      label262:
      paramaftk.setIsSend(bool);
      paramaftk.MIN_SPACE = (ArkAppCenterUtil.sDisplayWith / 4);
      localapzb.a(j, k);
      paramaftk.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramaftk.setRefreshCallback(this);
      paramaftk.setTag(localagpf);
      localagpf.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
      localagpf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      k = localMessageForArkApp.getMsgArkAppCount();
      localapzb.a(localapzb.a() - k);
      paramView = null;
      j = 0;
      label352:
      if (j >= k) {
        break label476;
      }
      localObject = localMessageForArkApp.getMsgArkAppByPosition(j);
      if ((MessageForArkApp)localapzb.b(j) != null) {
        break label464;
      }
      localapzb.a((apwk)localObject);
      label388:
      if ((localObject == null) || (TextUtils.isEmpty(((MessageForArkApp)localObject).ark_app_message.appName)) || (!TextUtils.isEmpty(paramView))) {
        break label833;
      }
      paramView = ((MessageForArkApp)localObject).ark_app_message.appName;
    }
    label442:
    label833:
    for (;;)
    {
      j += 1;
      break label352;
      j = k - m;
      break;
      k = i;
      break label109;
      label449:
      localapzb = (apzb)paramView.getAdapter();
      paramaftk = paramView;
      break label262;
      label464:
      localapzb.b(j, (apwk)localObject);
      break label388;
      label476:
      a(paramaftk);
      if (localapzb.a() == 1)
      {
        int n;
        if (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar != null)
        {
          j = MessageForArkApp.dp2px(16.0F);
          k = MessageForArkApp.dp2px(47.0F);
          m = localResources.getDimensionPixelSize(2131296388);
          n = BaseChatItemLayout.t;
          a(paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar, j, k, i - j - m - n, bool);
        }
        if (paramBaseChatItemLayout.c != null)
        {
          j = MessageForArkApp.dp2px(24.0F);
          k = MessageForArkApp.dp2px(45.0F);
          m = localResources.getDimensionPixelSize(2131296388);
          n = BaseChatItemLayout.t;
          a(paramBaseChatItemLayout.c, j, k, i - j - m - n, bool);
        }
      }
      if (e)
      {
        paramView = new StringBuilder();
        if ((localagpf.jdField_b_of_type_JavaLangStringBuilder != null) && (localagpf.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
          paramView.append(localagpf.jdField_b_of_type_JavaLangStringBuilder);
        }
        paramView.append(a(localMessageForArkApp));
        paramaftk.setContentDescription(paramView);
        ArkAppCenter.a("ArkAppShareMultiItemBuilder", "Type is card, and talkbackText is " + paramView);
      }
      aqce.b(localMessageForArkApp);
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramafqr.b, paramafqr.c);
      a(localMessageForArkApp);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        if (!bflj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) {
          break label812;
        }
        localagpf.c = super.a(localagpf.c, localagpf, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 21.0F));
        super.a(localagpf.c, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
      }
      while (localagpf.c == null) {
        return paramaftk;
      }
      localagpf.c.setVisibility(8);
      return paramaftk;
    }
  }
  
  public bhjq a(bhjq parambhjq, ChatMessage paramChatMessage, afrk paramafrk)
  {
    paramChatMessage = (MessageForArkApp)paramChatMessage;
    if ((paramChatMessage != null) && (paramChatMessage.ark_app_message != null) && (paramChatMessage.arkContainer.getErrorInfo() != null) && (MessageForArkApp.isAllowedArkForward(false, paramChatMessage))) {
      parambhjq.a(2131367213, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838991);
    }
    return parambhjq;
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
    MessageForArkApp localMessageForArkApp;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131367213: 
      do
      {
        return;
        localMessageForArkApp = (MessageForArkApp)paramChatMessage;
      } while ((localMessageForArkApp == null) || (localMessageForArkApp.ark_app_message == null));
      paramContext = (MessageForArkApp)apyl.a(1, localMessageForArkApp.ark_app_message.appName, localMessageForArkApp, localMessageForArkApp);
      if (paramContext == null) {
        paramContext = localMessageForArkApp;
      }
      break;
    }
    while ((paramContext != null) && (paramContext.ark_app_message != null))
    {
      Intent localIntent = new Intent();
      if (paramContext.getMsgArkAppCount() >= 1)
      {
        paramChatMessage = QQCustomArkDialog.AppInfo.zipArgs(paramContext.ark_app_message.appName, paramContext.ark_app_message.appView, paramContext.ark_app_message.appMinVersion, paramContext.ark_app_message.metaList, ArkAppCenterUtil.getDensity(), null, null);
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
        paramChatMessage.putInt("selection_mode", this.b);
        paramChatMessage.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        localIntent.putExtras(paramChatMessage);
        aupt.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
        if (!localMessageForArkApp.isMultiMsg) {
          break;
        }
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 11, 0, "11", "", "", "");
        return;
        paramChatMessage = new Bundle();
      }
      admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      super.a(paramChatMessage);
      return;
      super.d(paramChatMessage);
      return;
      super.b(paramChatMessage);
      return;
      bmad.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      return;
      a(paramContext, (MessageForArkApp)paramChatMessage);
      return;
      b(paramContext, (MessageForArkApp)paramChatMessage);
      return;
    }
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
    } while (!paramView.isSendFromLocal());
    bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new agpd(this, paramView), new agpe(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public void a(ArkHorizontalListView paramArkHorizontalListView)
  {
    int k = 1;
    afqr localafqr = (afqr)paramArkHorizontalListView.getTag();
    if ((localafqr == null) || (!(localafqr instanceof agpf))) {
      return;
    }
    int[] arrayOfInt1 = new int[2];
    localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLocationOnScreen(arrayOfInt1);
    int j = arrayOfInt1[0];
    int m = localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getMeasuredWidth();
    int n = arrayOfInt1[1];
    int i1 = localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getMeasuredHeight();
    int i2 = paramArkHorizontalListView.getChildCount();
    int[] arrayOfInt2 = new int[2];
    int i = 0;
    if (i < i2)
    {
      View localView = paramArkHorizontalListView.getChildAt(i);
      if (localView != null)
      {
        localView.getLocationOnScreen(arrayOfInt2);
        int i3 = arrayOfInt2[0];
        int i4 = localView.getMeasuredWidth();
        int i5 = arrayOfInt2[1];
        int i6 = localView.getMeasuredHeight();
        if ((!(localView instanceof LinearLayout)) || (i3 + i4 < arrayOfInt1[0]) || (arrayOfInt2[0] > m + j) || (i5 + i6 < arrayOfInt1[1]) || (arrayOfInt2[1] > i1 + n)) {}
      }
    }
    for (i = 1;; i = 0)
    {
      if ((localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0))
      {
        j = 1;
        label229:
        if ((i == 0) || (j != 0)) {
          break label431;
        }
        i = k;
        label240:
        if (i == 0) {
          break label452;
        }
        i = MessageForArkApp.dp2px(1.0F);
        if (localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b == null)
        {
          localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setScaleType(ImageView.ScaleType.FIT_XY);
          j = MessageForArkApp.dp2px(42.0F);
          paramArkHorizontalListView = new RelativeLayout.LayoutParams(j, j);
          localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b, paramArkHorizontalListView);
        }
        paramArkHorizontalListView = (RelativeLayout.LayoutParams)localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.getLayoutParams();
        paramArkHorizontalListView.addRule(6, 2131364531);
        paramArkHorizontalListView.topMargin = (-i);
        if (!localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b()) {
          break label436;
        }
        paramArkHorizontalListView.addRule(7, 2131364531);
        paramArkHorizontalListView.rightMargin = (-i);
      }
      for (;;)
      {
        localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setBackgroundResource(2130844854);
        localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.requestLayout();
        localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setVisibility(0);
        return;
        i += 1;
        break;
        j = 0;
        break label229;
        label431:
        i = 0;
        break label240;
        label436:
        paramArkHorizontalListView.addRule(5, 2131364531);
        paramArkHorizontalListView.leftMargin = (-i);
      }
      label452:
      if (localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b == null) {
        break;
      }
      localafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setVisibility(8);
      return;
    }
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
  
  public bhjs[] a(View paramView)
  {
    bhjq localbhjq = new bhjq();
    paramView = (afrk)AIOUtils.getHolder(paramView);
    if (paramView != null)
    {
      paramView = paramView.a;
      if ((paramView != null) && ((paramView instanceof MessageForArkApp)))
      {
        a(localbhjq);
        if (!paramView.isMultiMsg) {
          break label66;
        }
        a(localbhjq, paramView, null);
      }
    }
    for (;;)
    {
      return localbhjq.a();
      paramView = null;
      break;
      label66:
      b(localbhjq, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "6", "", "", "");
  }
  
  public bhjq b(bhjq parambhjq, ChatMessage paramChatMessage, afrk paramafrk)
  {
    paramafrk = (MessageForArkApp)paramChatMessage;
    boolean bool1;
    if ((paramafrk != null) && (paramafrk.ark_app_message != null) && (paramafrk.arkContainer != null) && (paramafrk.arkContainer.getErrorInfo() != null))
    {
      if (MessageForArkApp.isAllowedArkForward(false, paramafrk)) {
        parambhjq.a(2131367213, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838991);
      }
      if ((paramafrk.extraflag == 32768) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramafrk))) {
        break label331;
      }
      Boolean localBoolean = (Boolean)apyl.a(3, paramafrk.ark_app_message.appName, paramafrk, Boolean.valueOf(true));
      if (localBoolean == null) {
        break label325;
      }
      bool1 = localBoolean.booleanValue();
      bool2 = bool1;
      if (bool1) {
        a(parambhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramafrk);
      }
    }
    label325:
    label331:
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if (bool2) {
        a(parambhjq, paramafrk);
      }
      try
      {
        for (;;)
        {
          if (aqzu.a().a(paramafrk.ark_app_message.appName, paramafrk.ark_app_message.appView))
          {
            a(paramafrk, parambhjq);
            super.b(paramafrk, parambhjq);
          }
          super.c(parambhjq, this.jdField_a_of_type_AndroidContentContext);
          if (bmaf.a(paramChatMessage)) {
            super.d(parambhjq, this.jdField_a_of_type_AndroidContentContext);
          }
          super.a(parambhjq, this.jdField_a_of_type_AndroidContentContext, paramafrk);
          super.e(parambhjq, this.jdField_a_of_type_AndroidContentContext);
          return parambhjq;
          admh.a(parambhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("ArkAppShareMultiItemBuilder", 2, "add reply menu error, exception =" + localException.getMessage());
        }
      }
      admh.a(parambhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      super.c(parambhjq, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambhjq, this.jdField_a_of_type_AndroidContentContext);
      return parambhjq;
      bool1 = true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agpc
 * JD-Core Version:    0.7.0.1
 */