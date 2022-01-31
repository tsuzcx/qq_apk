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

public class admm
  extends BaseBubbleBuilder
  implements acum, altn
{
  private List<MessageForArkApp> a;
  
  public admm(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt1);
    localLayoutParams.addRule(8, 2131364109);
    localLayoutParams.bottomMargin = paramInt2;
    if (paramBoolean)
    {
      localLayoutParams.addRule(5, 2131364109);
      localLayoutParams.leftMargin = paramInt3;
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.addRule(7, 2131364109);
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
  
  public acuj a()
  {
    return new admp();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxj paramacxj)
  {
    paramChatMessage = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxj);
    paramView = (admp)paramChatMessage.getTag();
    paramViewGroup = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramacxj = paramChatMessage.b();
    if ((paramacxj != null) && (paramacxj.getVisibility() == 0)) {
      paramViewGroup.addRule(3, 2131364127);
    }
    for (paramViewGroup.topMargin = BaseChatItemLayout.g;; paramViewGroup.topMargin = 0)
    {
      paramView.jdField_a_of_type_AndroidViewView.setLayoutParams(paramViewGroup);
      return paramChatMessage;
      paramViewGroup.addRule(6, 2131364118);
    }
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    boolean bool = localMessageForArkApp.isSend();
    admp localadmp = (admp)paramacuj;
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).width = -1;
    ((RelativeLayout.LayoutParams)localObject2).height = (alsz.a + actj.a(29.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
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
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296293);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (paramBaseChatItemLayout.b != null)
      {
        localObject1 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.b.getLayoutParams();
        i = MessageForArkApp.dp2px(1.0F);
        if (!bool) {
          break label762;
        }
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131364118);
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
      k = localResources.getDimensionPixelSize(2131296291) + (i * 2 + j);
      m = localResources.getDimensionPixelSize(2131296283);
      i = alsz.d - k - alsz.a - m;
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
      QLog.d("ArkAppShareMultiItemBuilder", 1, new Object[] { "ArkFold.appName:", localMessageForArkApp.ark_app_message.appName, ", getChatbubbleMaxWidth=", Integer.valueOf(alsz.a), ", displaywitdh=", Integer.valueOf(alsz.c), ", headerWidth=", Integer.valueOf(j), ",footerWidth=", Integer.valueOf(k) });
      paramView = (ArkHorizontalListView)paramView;
      if (paramView != null) {
        break label848;
      }
      paramView = new ArkHorizontalListView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setDividerWidth(m);
      localObject1 = new alto(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, paramacxj);
      paramView.setAdapter((ListAdapter)localObject1);
      paramacxj = paramView;
      label518:
      paramacxj.setIsSend(bool);
      paramacxj.MIN_SPACE = (alsz.c / 4);
      ((alto)localObject1).a(j, k);
      paramacxj.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramacxj.setRefreshCallback(this);
      paramacxj.setTag(localadmp);
      localadmp.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
      localadmp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      k = localMessageForArkApp.getMsgArkAppCount();
      ((alto)localObject1).a(((alto)localObject1).a() - k);
      paramView = null;
      j = 0;
      label608:
      if (j >= k) {
        break label875;
      }
      localObject2 = localMessageForArkApp.getMsgArkAppByPosition(j);
      if ((MessageForArkApp)((alto)localObject1).b(j) != null) {
        break label863;
      }
      ((alto)localObject1).a((alqw)localObject2);
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
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296293);
      break;
      label762:
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131364118);
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
      localObject1 = (alto)paramView.getAdapter();
      paramacxj = paramView;
      break label518;
      ((alto)localObject1).b(j, (alqw)localObject2);
      break label644;
      a(paramacxj);
      if (((alto)localObject1).a() == 1)
      {
        int n;
        if (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar != null)
        {
          j = MessageForArkApp.dp2px(16.0F);
          k = MessageForArkApp.dp2px(47.0F);
          m = localResources.getDimensionPixelSize(2131296291);
          n = BaseChatItemLayout.s;
          a(paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar, j, k, i - j - m - n, bool);
        }
        if (paramBaseChatItemLayout.c != null)
        {
          j = MessageForArkApp.dp2px(24.0F);
          k = MessageForArkApp.dp2px(45.0F);
          m = localResources.getDimensionPixelSize(2131296291);
          n = BaseChatItemLayout.s;
          a(paramBaseChatItemLayout.c, j, k, i - j - m - n, bool);
        }
      }
      if (e)
      {
        paramView = new StringBuilder();
        if ((localadmp.jdField_b_of_type_JavaLangStringBuilder != null) && (localadmp.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
          paramView.append(localadmp.jdField_b_of_type_JavaLangStringBuilder);
        }
        paramView.append(a(localMessageForArkApp));
        paramacxj.setContentDescription(paramView);
        ArkAppCenter.a("ArkAppShareMultiItemBuilder", "Type is card, and talkbackText is " + paramView);
      }
      alwo.b(localMessageForArkApp);
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramacuj.b, paramacuj.c);
      a(localMessageForArkApp);
      return paramacxj;
    }
  }
  
  public bbmf a(bbmf parambbmf, ChatMessage paramChatMessage, acva paramacva)
  {
    paramChatMessage = (MessageForArkApp)paramChatMessage;
    if ((paramChatMessage != null) && (paramChatMessage.ark_app_message != null) && (paramChatMessage.arkContainer.getErrorInfo() != null) && (MessageForArkApp.isAllowedArkForward(false, paramChatMessage))) {
      parambbmf.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692753), 2130838606);
    }
    return parambbmf;
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
    MessageForArkApp localMessageForArkApp;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131366632: 
      do
      {
        return;
        localMessageForArkApp = (MessageForArkApp)paramChatMessage;
      } while ((localMessageForArkApp == null) || (localMessageForArkApp.ark_app_message == null));
      paramContext = (MessageForArkApp)alsw.a(1, localMessageForArkApp.ark_app_message.appName, localMessageForArkApp, localMessageForArkApp);
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
        paramChatMessage.putInt("selection_mode", this.b);
        paramChatMessage.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        localIntent.putExtras(paramChatMessage);
        aqbe.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
        if (!localMessageForArkApp.isMultiMsg) {
          break;
        }
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 11, 0, "11", "", "", "");
        return;
        paramChatMessage = new Bundle();
      }
      aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      super.a(paramChatMessage);
      return;
      super.d(paramChatMessage);
      return;
      super.b(paramChatMessage);
      return;
      bgpu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      return;
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
    bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new admn(this, paramView), new admo(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public void a(ArkHorizontalListView paramArkHorizontalListView)
  {
    int k = 1;
    acuj localacuj = (acuj)paramArkHorizontalListView.getTag();
    if ((localacuj == null) || (!(localacuj instanceof admp))) {
      return;
    }
    int[] arrayOfInt1 = new int[2];
    localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLocationOnScreen(arrayOfInt1);
    int j = arrayOfInt1[0];
    int m = localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getMeasuredWidth();
    int n = arrayOfInt1[1];
    int i1 = localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getMeasuredHeight();
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
      if ((localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0))
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
        if (localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b == null)
        {
          localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setScaleType(ImageView.ScaleType.FIT_XY);
          j = MessageForArkApp.dp2px(42.0F);
          paramArkHorizontalListView = new RelativeLayout.LayoutParams(j, j);
          localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b, paramArkHorizontalListView);
        }
        paramArkHorizontalListView = (RelativeLayout.LayoutParams)localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.getLayoutParams();
        paramArkHorizontalListView.addRule(6, 2131364118);
        paramArkHorizontalListView.topMargin = (-i);
        if (!localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b()) {
          break label436;
        }
        paramArkHorizontalListView.addRule(7, 2131364118);
        paramArkHorizontalListView.rightMargin = (-i);
      }
      for (;;)
      {
        localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setBackgroundResource(2130844077);
        localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.requestLayout();
        localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setVisibility(0);
        return;
        i += 1;
        break;
        j = 0;
        break label229;
        label431:
        i = 0;
        break label240;
        label436:
        paramArkHorizontalListView.addRule(5, 2131364118);
        paramArkHorizontalListView.leftMargin = (-i);
      }
      label452:
      if (localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b == null) {
        break;
      }
      localacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setVisibility(8);
      return;
    }
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
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    paramView = (acva)actj.a(paramView);
    if (paramView != null)
    {
      paramView = paramView.a;
      if ((paramView != null) && ((paramView instanceof MessageForArkApp)))
      {
        if (!paramView.isMultiMsg) {
          break label61;
        }
        a(localbbmf, paramView, null);
      }
    }
    for (;;)
    {
      return localbbmf.a();
      paramView = null;
      break;
      label61:
      b(localbbmf, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "6", "", "", "");
  }
  
  public bbmf b(bbmf parambbmf, ChatMessage paramChatMessage, acva paramacva)
  {
    paramacva = (MessageForArkApp)paramChatMessage;
    boolean bool1;
    if ((paramacva != null) && (paramacva.ark_app_message != null) && (paramacva.arkContainer != null) && (paramacva.arkContainer.getErrorInfo() != null))
    {
      if (MessageForArkApp.isAllowedArkForward(false, paramacva)) {
        parambbmf.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692753), 2130838606);
      }
      if ((paramacva.extraflag == 32768) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramacva))) {
        break label327;
      }
      Boolean localBoolean = (Boolean)alsw.a(3, paramacva.ark_app_message.appName, paramacva, Boolean.valueOf(true));
      if (localBoolean == null) {
        break label321;
      }
      bool1 = localBoolean.booleanValue();
      bool2 = bool1;
      if (bool1) {
        a(parambbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramacva);
      }
    }
    label321:
    label327:
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if (bool2) {
        a(parambbmf, paramacva);
      }
      for (;;)
      {
        super.c(parambbmf, this.jdField_a_of_type_AndroidContentContext);
        try
        {
          if (amrr.a().a(paramacva.ark_app_message.appName, paramacva.ark_app_message.appView))
          {
            a(paramacva, parambbmf);
            super.b(paramacva, parambbmf);
          }
          super.c(parambbmf, this.jdField_a_of_type_AndroidContentContext);
          if (bgpw.a(paramChatMessage)) {
            super.d(parambbmf, this.jdField_a_of_type_AndroidContentContext);
          }
          super.e(parambbmf, this.jdField_a_of_type_AndroidContentContext);
          return parambbmf;
          aanz.a(parambbmf, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        }
        catch (Exception paramacva)
        {
          for (;;)
          {
            QLog.d("ArkAppShareMultiItemBuilder", 2, "add reply menu error, exception =" + paramacva.getMessage());
          }
        }
      }
      aanz.a(parambbmf, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      super.c(parambbmf, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambbmf, this.jdField_a_of_type_AndroidContentContext);
      return parambbmf;
      bool1 = true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     admm
 * JD-Core Version:    0.7.0.1
 */