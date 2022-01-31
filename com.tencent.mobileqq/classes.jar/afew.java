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
import android.widget.ListAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.ArkReportData;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class afew
  extends BaseBubbleBuilder
  implements aelw, ankg
{
  private List<MessageForArkApp> a;
  
  public afew(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt1);
    localLayoutParams.addRule(8, 2131364171);
    localLayoutParams.bottomMargin = paramInt2;
    if (paramBoolean)
    {
      localLayoutParams.addRule(5, 2131364171);
      localLayoutParams.leftMargin = paramInt3;
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.addRule(7, 2131364171);
      localLayoutParams.rightMargin = paramInt3;
    }
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramMessageForArkApp))
    {
      paramMessageForArkApp.report(0);
      this.jdField_a_of_type_JavaUtilList.add(paramMessageForArkApp);
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aelt a()
  {
    return new afez();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    paramChatMessage = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaeov);
    paramView = (afez)paramChatMessage.getTag();
    paramViewGroup = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramaeov = paramChatMessage.b();
    if ((paramaeov != null) && (paramaeov.getVisibility() == 0)) {
      paramViewGroup.addRule(3, 2131364189);
    }
    for (paramViewGroup.topMargin = BaseChatItemLayout.g;; paramViewGroup.topMargin = 0)
    {
      paramView.jdField_a_of_type_AndroidViewView.setLayoutParams(paramViewGroup);
      return paramChatMessage;
      paramViewGroup.addRule(6, 2131364180);
    }
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    boolean bool = localMessageForArkApp.isSend();
    afez localafez = (afez)paramaelt;
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).width = -1;
    ((RelativeLayout.LayoutParams)localObject2).height = (anjs.a + aekt.a(29.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
    paramBaseChatItemLayout.setPadding(0, BaseChatItemLayout.u, 0, BaseChatItemLayout.h + BaseChatItemLayout.k);
    Object localObject1 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
    int i;
    label175:
    Resources localResources;
    label284:
    int j;
    int k;
    int m;
    if (bool)
    {
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296299);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (paramBaseChatItemLayout.b != null)
      {
        localObject1 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.b.getLayoutParams();
        i = MessageForArkApp.dp2px(1.0F);
        if (!bool) {
          break label762;
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131364180);
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = (-i);
        paramBaseChatItemLayout.b.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        localObject1 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = BaseChatItemLayout.s;
        paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 8))
      {
        localObject1 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        if (!bool) {
          break label781;
        }
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = BaseChatItemLayout.t;
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      i = BaseChatItemLayout.n;
      j = MessageForArkApp.dp2px(40.0F);
      k = localResources.getDimensionPixelSize(2131296297) + (i * 2 + j);
      m = localResources.getDimensionPixelSize(2131296289);
      i = anjs.d - k - anjs.a - m;
      if (!bool) {
        break label831;
      }
      j = i;
      label365:
      if (!bool) {
        break label841;
      }
      k -= m;
      label377:
      QLog.d("ArkAppShareMultiItemBuilder", 1, new Object[] { "ArkFold.appName:", localMessageForArkApp.ark_app_message.appName, ", getChatbubbleMaxWidth=", Integer.valueOf(anjs.a), ", displaywitdh=", Integer.valueOf(anjs.c), ", headerWidth=", Integer.valueOf(j), ",footerWidth=", Integer.valueOf(k) });
      paramView = (ArkHorizontalListView)paramView;
      if (paramView != null) {
        break label848;
      }
      paramView = new ArkHorizontalListView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setDividerWidth(m);
      localObject1 = new ankh(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, paramaeov);
      paramView.setAdapter((ListAdapter)localObject1);
      paramaeov = paramView;
      label518:
      paramaeov.setIsSend(bool);
      paramaeov.MIN_SPACE = (anjs.c / 4);
      ((ankh)localObject1).a(j, k);
      paramaeov.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramaeov.setRefreshCallback(this);
      paramaeov.setTag(localafez);
      localafez.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
      localafez.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      k = localMessageForArkApp.getMsgArkAppCount();
      ((ankh)localObject1).a(((ankh)localObject1).a() - k);
      paramView = null;
      j = 0;
      label608:
      if (j >= k) {
        break label875;
      }
      localObject2 = localMessageForArkApp.getMsgArkAppByPosition(j);
      if ((MessageForArkApp)((ankh)localObject1).b(j) != null) {
        break label863;
      }
      ((ankh)localObject1).a((anho)localObject2);
      label644:
      if ((localObject2 == null) || (TextUtils.isEmpty(((MessageForArkApp)localObject2).ark_app_message.appName)) || (!TextUtils.isEmpty(paramView))) {
        break label1137;
      }
      paramView = ((MessageForArkApp)localObject2).ark_app_message.appName;
    }
    label781:
    label831:
    label841:
    label848:
    label863:
    label875:
    label1137:
    for (;;)
    {
      j += 1;
      break label608;
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        i = MessageForArkApp.dp2px(30.0F);
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = (BaseChatItemLayout.s + i);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = (i - BaseChatItemLayout.s);
        break;
      }
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296299);
      break;
      label762:
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131364180);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = (-i);
      break label175;
      if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = (MessageForArkApp.dp2px(25.0F) + BaseChatItemLayout.s);
        break label284;
      }
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = BaseChatItemLayout.s;
      break label284;
      j = k - m;
      break label365;
      k = i;
      break label377;
      localObject1 = (ankh)paramView.getAdapter();
      paramaeov = paramView;
      break label518;
      ((ankh)localObject1).b(j, (anho)localObject2);
      break label644;
      a(paramaeov);
      if (((ankh)localObject1).a() == 1)
      {
        int n;
        if (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar != null)
        {
          j = MessageForArkApp.dp2px(16.0F);
          k = MessageForArkApp.dp2px(47.0F);
          m = localResources.getDimensionPixelSize(2131296297);
          n = BaseChatItemLayout.s;
          a(paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar, j, k, i - j - m - n, bool);
        }
        if (paramBaseChatItemLayout.c != null)
        {
          j = MessageForArkApp.dp2px(24.0F);
          k = MessageForArkApp.dp2px(45.0F);
          m = localResources.getDimensionPixelSize(2131296297);
          n = BaseChatItemLayout.s;
          a(paramBaseChatItemLayout.c, j, k, i - j - m - n, bool);
        }
      }
      if (e)
      {
        paramView = new StringBuilder();
        if ((localafez.jdField_b_of_type_JavaLangStringBuilder != null) && (localafez.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
          paramView.append(localafez.jdField_b_of_type_JavaLangStringBuilder);
        }
        paramView.append(a(localMessageForArkApp));
        paramaeov.setContentDescription(paramView);
        ArkAppCenter.a("ArkAppShareMultiItemBuilder", "Type is card, and talkbackText is " + paramView);
      }
      annl.b(localMessageForArkApp);
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramaelt.b, paramaelt.c);
      a(localMessageForArkApp);
      return paramaeov;
    }
  }
  
  public bdkz a(bdkz parambdkz, ChatMessage paramChatMessage, aemk paramaemk)
  {
    paramChatMessage = (MessageForArkApp)paramChatMessage;
    if ((paramChatMessage != null) && (paramChatMessage.ark_app_message != null) && (paramChatMessage.arkContainer.getErrorInfo() != null) && (MessageForArkApp.isAllowedArkForward(false, paramChatMessage))) {
      parambdkz.a(2131366750, this.jdField_a_of_type_AndroidContentContext.getString(2131692835), 2130838677);
    }
    return parambdkz;
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
    if (bdec.a(paramChatMessage.issend)) {
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
    case 2131366750: 
      do
      {
        return;
        localMessageForArkApp = (MessageForArkApp)paramChatMessage;
      } while ((localMessageForArkApp == null) || (localMessageForArkApp.ark_app_message == null));
      paramContext = (MessageForArkApp)anjp.a(1, localMessageForArkApp.ark_app_message.appName, localMessageForArkApp, localMessageForArkApp);
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
        paramChatMessage = bdfk.a(paramContext.ark_app_message.appName, paramContext.ark_app_message.appView, paramContext.ark_app_message.appMinVersion, paramContext.ark_app_message.metaList, anjs.a(), null, null);
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
        paramChatMessage.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        localIntent.putExtras(paramChatMessage);
        arum.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
        if (!localMessageForArkApp.isMultiMsg) {
          break;
        }
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 11, 0, "11", "", "", "");
        return;
        paramChatMessage = new Bundle();
      }
      acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      super.a(paramChatMessage);
      return;
      super.d(paramChatMessage);
      return;
      super.b(paramChatMessage);
      return;
      biqt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      return;
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForArkApp)aekt.a(paramView);
    if (paramView == null) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690042);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131690043);
    } while (!paramView.isSendFromLocal());
    bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new afex(this, paramView), new afey(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public void a(ArkHorizontalListView paramArkHorizontalListView)
  {
    int k = 1;
    aelt localaelt = (aelt)paramArkHorizontalListView.getTag();
    if ((localaelt == null) || (!(localaelt instanceof afez))) {
      return;
    }
    int[] arrayOfInt1 = new int[2];
    localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLocationOnScreen(arrayOfInt1);
    int j = arrayOfInt1[0];
    int m = localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getMeasuredWidth();
    int n = arrayOfInt1[1];
    int i1 = localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getMeasuredHeight();
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
      if ((localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0))
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
        if (localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b == null)
        {
          localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setScaleType(ImageView.ScaleType.FIT_XY);
          j = MessageForArkApp.dp2px(42.0F);
          paramArkHorizontalListView = new RelativeLayout.LayoutParams(j, j);
          localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b, paramArkHorizontalListView);
        }
        paramArkHorizontalListView = (RelativeLayout.LayoutParams)localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.getLayoutParams();
        paramArkHorizontalListView.addRule(6, 2131364180);
        paramArkHorizontalListView.topMargin = (-i);
        if (!localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b()) {
          break label436;
        }
        paramArkHorizontalListView.addRule(7, 2131364180);
        paramArkHorizontalListView.rightMargin = (-i);
      }
      for (;;)
      {
        localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setBackgroundResource(2130844420);
        localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.requestLayout();
        localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setVisibility(0);
        return;
        i += 1;
        break;
        j = 0;
        break label229;
        label431:
        i = 0;
        break label240;
        label436:
        paramArkHorizontalListView.addRule(5, 2131364180);
        paramArkHorizontalListView.leftMargin = (-i);
      }
      label452:
      if (localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b == null) {
        break;
      }
      localaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setVisibility(8);
      return;
    }
  }
  
  public void a(ChatMessage paramChatMessage, bdkz parambdkz)
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
      parambdkz.a(2131375605, this.jdField_a_of_type_AndroidContentContext.getString(2131698118), 2130838681);
      return;
    } while ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (!(paramChatMessage instanceof MessageForArkApp)) || (paramChatMessage.istroop == 3000) || (((MessageForArkApp)paramChatMessage).msg == null));
    parambdkz.a(2131375605, this.jdField_a_of_type_AndroidContentContext.getString(2131698118), 2130838681);
  }
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    paramView = (aemk)aekt.a(paramView);
    if (paramView != null)
    {
      paramView = paramView.a;
      if ((paramView != null) && ((paramView instanceof MessageForArkApp)))
      {
        if (!paramView.isMultiMsg) {
          break label61;
        }
        a(localbdkz, paramView, null);
      }
    }
    for (;;)
    {
      return localbdkz.a();
      paramView = null;
      break;
      label61:
      b(localbdkz, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "6", "", "", "");
  }
  
  public bdkz b(bdkz parambdkz, ChatMessage paramChatMessage, aemk paramaemk)
  {
    paramaemk = (MessageForArkApp)paramChatMessage;
    boolean bool1;
    if ((paramaemk != null) && (paramaemk.ark_app_message != null) && (paramaemk.arkContainer != null) && (paramaemk.arkContainer.getErrorInfo() != null))
    {
      if (MessageForArkApp.isAllowedArkForward(false, paramaemk)) {
        parambdkz.a(2131366750, this.jdField_a_of_type_AndroidContentContext.getString(2131692835), 2130838677);
      }
      if ((paramaemk.extraflag == 32768) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramaemk))) {
        break label327;
      }
      Boolean localBoolean = (Boolean)anjp.a(3, paramaemk.ark_app_message.appName, paramaemk, Boolean.valueOf(true));
      if (localBoolean == null) {
        break label321;
      }
      bool1 = localBoolean.booleanValue();
      bool2 = bool1;
      if (bool1) {
        a(parambdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramaemk);
      }
    }
    label321:
    label327:
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if (bool2) {
        a(parambdkz, paramaemk);
      }
      for (;;)
      {
        super.c(parambdkz, this.jdField_a_of_type_AndroidContentContext);
        try
        {
          if (aoip.a().a(paramaemk.ark_app_message.appName, paramaemk.ark_app_message.appView))
          {
            a(paramaemk, parambdkz);
            super.b(paramaemk, parambdkz);
          }
          super.c(parambdkz, this.jdField_a_of_type_AndroidContentContext);
          if (biqv.a(paramChatMessage)) {
            super.d(parambdkz, this.jdField_a_of_type_AndroidContentContext);
          }
          super.e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
          return parambdkz;
          acex.a(parambdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        }
        catch (Exception paramaemk)
        {
          for (;;)
          {
            QLog.d("ArkAppShareMultiItemBuilder", 2, "add reply menu error, exception =" + paramaemk.getMessage());
          }
        }
      }
      acex.a(parambdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      super.c(parambdkz, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
      return parambdkz;
      bool1 = true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afew
 * JD-Core Version:    0.7.0.1
 */