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

public class ahab
  extends BaseBubbleBuilder
  implements aggp, aqcl
{
  private List<MessageForArkApp> a;
  
  public ahab(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private RelativeLayout.LayoutParams a(BaseChatItemLayout paramBaseChatItemLayout, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams1.width = -1;
    localLayoutParams1.height = (aqbx.jdField_a_of_type_Int + agej.a(29.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    localLayoutParams1.leftMargin = 0;
    paramBaseChatItemLayout.setPadding(0, BaseChatItemLayout.v, 0, BaseChatItemLayout.i + BaseChatItemLayout.l);
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
    int i;
    if (paramBoolean)
    {
      localLayoutParams2.rightMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296337);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setLayoutParams(localLayoutParams2);
      if (paramBaseChatItemLayout.b != null)
      {
        localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.b.getLayoutParams();
        i = MessageForArkApp.dp2px(1.0F);
        if (!paramBoolean) {
          break label327;
        }
        localLayoutParams2.addRule(7, 2131364432);
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
      localLayoutParams2.leftMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296337);
      break;
      label327:
      localLayoutParams2.addRule(5, 2131364432);
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
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(paramInt1, paramInt1);
    localLayoutParams.addRule(8, 2131364423);
    localLayoutParams.bottomMargin = paramInt2;
    if (paramBoolean)
    {
      localLayoutParams.addRule(5, 2131364423);
      localLayoutParams.leftMargin = paramInt3;
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.addRule(7, 2131364423);
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
  
  public aggl a()
  {
    return new ahae();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    paramChatMessage = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    paramView = (ahae)paramChatMessage.getTag();
    paramViewGroup = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramagjk = paramChatMessage.b();
    if ((paramagjk != null) && (paramagjk.getVisibility() == 0)) {
      paramViewGroup.addRule(3, 2131364441);
    }
    for (paramViewGroup.topMargin = BaseChatItemLayout.h;; paramViewGroup.topMargin = 0)
    {
      paramView.jdField_a_of_type_AndroidViewView.setLayoutParams(paramViewGroup);
      return paramChatMessage;
      paramViewGroup.addRule(6, 2131364432);
    }
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    boolean bool = localMessageForArkApp.isSend();
    Object localObject = a(paramBaseChatItemLayout, bool);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = BaseChatItemLayout.o;
    int j = MessageForArkApp.dp2px(40.0F);
    int k = localResources.getDimensionPixelSize(2131296335) + (i * 2 + j);
    int m = localResources.getDimensionPixelSize(2131296327);
    i = aqbx.d - k - aqbx.jdField_a_of_type_Int - m;
    label106:
    ahae localahae;
    aqcm localaqcm;
    if (bool)
    {
      j = i;
      if (!bool) {
        break label433;
      }
      k -= m;
      QLog.d("ArkAppShareMultiItemBuilder", 1, new Object[] { "ArkFold.appName:", localMessageForArkApp.ark_app_message.appName, ", getChatbubbleMaxWidth=", Integer.valueOf(aqbx.jdField_a_of_type_Int), ", displaywitdh=", Integer.valueOf(aqbx.c), ", headerWidth=", Integer.valueOf(j), ",footerWidth=", Integer.valueOf(k) });
      localahae = (ahae)paramaggl;
      paramView = (ArkHorizontalListView)paramView;
      if (paramView != null) {
        break label440;
      }
      paramView = new ArkHorizontalListView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setDividerWidth(m);
      localaqcm = new aqcm(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView, paramagjk);
      paramView.setAdapter(localaqcm);
      paramagjk = paramView;
      label253:
      paramagjk.setIsSend(bool);
      paramagjk.MIN_SPACE = (aqbx.c / 4);
      localaqcm.a(j, k);
      paramagjk.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramagjk.setRefreshCallback(this);
      paramagjk.setTag(localahae);
      localahae.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
      localahae.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      k = localMessageForArkApp.getMsgArkAppCount();
      localaqcm.a(localaqcm.a() - k);
      paramView = null;
      j = 0;
      label343:
      if (j >= k) {
        break label467;
      }
      localObject = localMessageForArkApp.getMsgArkAppByPosition(j);
      if ((MessageForArkApp)localaqcm.b(j) != null) {
        break label455;
      }
      localaqcm.a((apzt)localObject);
      label379:
      if ((localObject == null) || (TextUtils.isEmpty(((MessageForArkApp)localObject).ark_app_message.appName)) || (!TextUtils.isEmpty(paramView))) {
        break label826;
      }
      paramView = ((MessageForArkApp)localObject).ark_app_message.appName;
    }
    label433:
    label440:
    label826:
    for (;;)
    {
      j += 1;
      break label343;
      j = k - m;
      break;
      k = i;
      break label106;
      localaqcm = (aqcm)paramView.getAdapter();
      paramagjk = paramView;
      break label253;
      label455:
      localaqcm.b(j, (apzt)localObject);
      break label379;
      label467:
      a(paramagjk);
      if (localaqcm.a() == 1)
      {
        int n;
        if (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar != null)
        {
          j = MessageForArkApp.dp2px(16.0F);
          k = MessageForArkApp.dp2px(47.0F);
          m = localResources.getDimensionPixelSize(2131296335);
          n = BaseChatItemLayout.t;
          a(paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar, j, k, i - j - m - n, bool);
        }
        if (paramBaseChatItemLayout.c != null)
        {
          j = MessageForArkApp.dp2px(24.0F);
          k = MessageForArkApp.dp2px(45.0F);
          m = localResources.getDimensionPixelSize(2131296335);
          n = BaseChatItemLayout.t;
          a(paramBaseChatItemLayout.c, j, k, i - j - m - n, bool);
        }
      }
      if (e)
      {
        paramView = new StringBuilder();
        if ((localahae.jdField_b_of_type_JavaLangStringBuilder != null) && (localahae.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
          paramView.append(localahae.jdField_b_of_type_JavaLangStringBuilder);
        }
        paramView.append(a(localMessageForArkApp));
        paramagjk.setContentDescription(paramView);
        ArkAppCenter.a("ArkAppShareMultiItemBuilder", "Type is card, and talkbackText is " + paramView);
      }
      aqfp.b(localMessageForArkApp);
      ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, paramaggl.b, paramaggl.c);
      a(localMessageForArkApp);
      if ((localahae != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        if (!bfuv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label805;
        }
        localahae.c = super.a(localahae.c, localahae, paramBaseChatItemLayout, paramChatMessage, -2, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
        super.a(localahae.c, paramBaseChatItemLayout, null, paramChatMessage, 0, null);
      }
      while (localahae.c == null) {
        return paramagjk;
      }
      localahae.c.setVisibility(8);
      return paramagjk;
    }
  }
  
  public bhuk a(bhuk parambhuk, ChatMessage paramChatMessage, aghd paramaghd)
  {
    paramChatMessage = (MessageForArkApp)paramChatMessage;
    if ((paramChatMessage != null) && (paramChatMessage.ark_app_message != null) && (paramChatMessage.arkContainer.getErrorInfo() != null) && (MessageForArkApp.isAllowedArkForward(false, paramChatMessage))) {
      parambhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
    }
    return parambhuk;
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
    if (bhnt.a(paramChatMessage.issend)) {
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
    case 2131367078: 
      do
      {
        return;
        localMessageForArkApp = (MessageForArkApp)paramChatMessage;
      } while ((localMessageForArkApp == null) || (localMessageForArkApp.ark_app_message == null));
      paramContext = (MessageForArkApp)aqbu.a(1, localMessageForArkApp.ark_app_message.appName, localMessageForArkApp, localMessageForArkApp);
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
        paramChatMessage = bhow.a(paramContext.ark_app_message.appName, paramContext.ark_app_message.appView, paramContext.ark_app_message.appMinVersion, paramContext.ark_app_message.metaList, aqbx.a(), null, null);
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
        paramChatMessage.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        localIntent.putExtras(paramChatMessage);
        auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
        if (!localMessageForArkApp.isMultiMsg) {
          break;
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 11, 0, "11", "", "", "");
        return;
        paramChatMessage = new Bundle();
      }
      aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      super.a(paramChatMessage);
      return;
      super.d(paramChatMessage);
      return;
      super.b(paramChatMessage);
      return;
      bmko.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      return;
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForArkApp)agej.a(paramView);
    if (paramView == null) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689933);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689934);
    } while (!paramView.isSendFromLocal());
    bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new ahac(this, paramView), new ahad(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public void a(ArkHorizontalListView paramArkHorizontalListView)
  {
    int k = 1;
    aggl localaggl = (aggl)paramArkHorizontalListView.getTag();
    if ((localaggl == null) || (!(localaggl instanceof ahae))) {
      return;
    }
    int[] arrayOfInt1 = new int[2];
    localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLocationOnScreen(arrayOfInt1);
    int j = arrayOfInt1[0];
    int m = localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getMeasuredWidth();
    int n = arrayOfInt1[1];
    int i1 = localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getMeasuredHeight();
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
      if ((localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0))
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
        if (localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b == null)
        {
          localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setScaleType(ImageView.ScaleType.FIT_XY);
          j = MessageForArkApp.dp2px(42.0F);
          paramArkHorizontalListView = new RelativeLayout.LayoutParams(j, j);
          localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.addView(localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b, paramArkHorizontalListView);
        }
        paramArkHorizontalListView = (RelativeLayout.LayoutParams)localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.getLayoutParams();
        paramArkHorizontalListView.addRule(6, 2131364432);
        paramArkHorizontalListView.topMargin = (-i);
        if (!localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b()) {
          break label436;
        }
        paramArkHorizontalListView.addRule(7, 2131364432);
        paramArkHorizontalListView.rightMargin = (-i);
      }
      for (;;)
      {
        localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setBackgroundResource(2130844900);
        localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.requestLayout();
        localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setVisibility(0);
        return;
        i += 1;
        break;
        j = 0;
        break label229;
        label431:
        i = 0;
        break label240;
        label436:
        paramArkHorizontalListView.addRule(5, 2131364432);
        paramArkHorizontalListView.leftMargin = (-i);
      }
      label452:
      if (localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b == null) {
        break;
      }
      localaggl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b.setVisibility(8);
      return;
    }
  }
  
  public void a(ChatMessage paramChatMessage, bhuk parambhuk)
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
      parambhuk.a(2131376511, this.jdField_a_of_type_AndroidContentContext.getString(2131697016), 2130838943);
      return;
    } while ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (!(paramChatMessage instanceof MessageForArkApp)) || (paramChatMessage.istroop == 3000) || (((MessageForArkApp)paramChatMessage).msg == null));
    parambhuk.a(2131376511, this.jdField_a_of_type_AndroidContentContext.getString(2131697016), 2130838943);
  }
  
  public bhum[] a(View paramView)
  {
    bhuk localbhuk = new bhuk();
    paramView = (aghd)agej.a(paramView);
    if (paramView != null)
    {
      paramView = paramView.a;
      if ((paramView != null) && ((paramView instanceof MessageForArkApp)))
      {
        if (!paramView.isMultiMsg) {
          break label61;
        }
        a(localbhuk, paramView, null);
      }
    }
    for (;;)
    {
      return localbhuk.a();
      paramView = null;
      break;
      label61:
      b(localbhuk, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "6", "", "", "");
  }
  
  public bhuk b(bhuk parambhuk, ChatMessage paramChatMessage, aghd paramaghd)
  {
    paramaghd = (MessageForArkApp)paramChatMessage;
    boolean bool1;
    if ((paramaghd != null) && (paramaghd.ark_app_message != null) && (paramaghd.arkContainer != null) && (paramaghd.arkContainer.getErrorInfo() != null))
    {
      if (MessageForArkApp.isAllowedArkForward(false, paramaghd)) {
        parambhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
      }
      if ((paramaghd.extraflag == 32768) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramaghd))) {
        break label330;
      }
      Boolean localBoolean = (Boolean)aqbu.a(3, paramaghd.ark_app_message.appName, paramaghd, Boolean.valueOf(true));
      if (localBoolean == null) {
        break label324;
      }
      bool1 = localBoolean.booleanValue();
      bool2 = bool1;
      if (bool1) {
        a(parambhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramaghd);
      }
    }
    label324:
    label330:
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if (bool2) {
        a(parambhuk, paramaghd);
      }
      try
      {
        for (;;)
        {
          if (ardb.a().a(paramaghd.ark_app_message.appName, paramaghd.ark_app_message.appView))
          {
            a(paramaghd, parambhuk);
            super.b(paramaghd, parambhuk);
          }
          super.c(parambhuk, this.jdField_a_of_type_AndroidContentContext);
          if (bmkq.a(paramChatMessage)) {
            super.d(parambhuk, this.jdField_a_of_type_AndroidContentContext);
          }
          super.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, paramaghd);
          super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
          return parambhuk;
          aean.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("ArkAppShareMultiItemBuilder", 2, "add reply menu error, exception =" + localException.getMessage());
        }
      }
      aean.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      super.c(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      return parambhuk;
      bool1 = true;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahab
 * JD-Core Version:    0.7.0.1
 */