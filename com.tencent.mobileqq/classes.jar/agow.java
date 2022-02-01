import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class agow
  extends ahit
{
  public agow(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private MessageForArkApp a(MessageForArkApp paramMessageForArkApp, ArkAppMessage paramArkAppMessage)
  {
    MessageForArkApp localMessageForArkApp = new MessageForArkApp();
    localMessageForArkApp.isMultiItemMsg = true;
    localMessageForArkApp.compatibleMsg = paramMessageForArkApp.compatibleMsg;
    localMessageForArkApp.ark_app_message = paramArkAppMessage;
    localMessageForArkApp.issend = paramMessageForArkApp.issend;
    return localMessageForArkApp;
  }
  
  private String a(ArkAppMessage paramArkAppMessage)
  {
    if (paramArkAppMessage == null) {
      return null;
    }
    if ((paramArkAppMessage.mAppList == null) || (paramArkAppMessage.mAppList.isEmpty())) {
      return null;
    }
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramArkAppMessage = paramArkAppMessage.mAppList.iterator();
      while (paramArkAppMessage.hasNext()) {
        localJSONArray.put(new JSONObject(((ArkAppMessage)paramArkAppMessage.next()).toAppXml()));
      }
      paramArkAppMessage = localJSONArray.toString();
    }
    catch (Exception paramArkAppMessage)
    {
      QLog.e("ChatItemBuilder", 1, "getArrayFromArkAppMessage catch error : " + paramArkAppMessage.getMessage());
      return null;
    }
    return paramArkAppMessage;
  }
  
  private void a(agox paramagox, MessageForArkApp paramMessageForArkApp)
  {
    if ((e) && (paramagox != null) && (paramMessageForArkApp != null))
    {
      if ((paramagox.jdField_b_of_type_JavaLangStringBuilder != null) && (paramagox.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
        paramagox.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
      }
      paramMessageForArkApp = a(paramMessageForArkApp);
      paramagox.d.setContentDescription(paramMessageForArkApp);
    }
  }
  
  private void a(Context paramContext, MessageForArkApp paramMessageForArkApp)
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
        localObject = new Intent();
        if (i == 1)
        {
          paramContext = QQCustomArkDialog.AppInfo.zipArgs(paramMessageForArkApp.ark_app_message.appName, paramMessageForArkApp.ark_app_message.appView, paramMessageForArkApp.ark_app_message.appMinVersion, paramMessageForArkApp.ark_app_message.metaList, paramContext.getResources().getDisplayMetrics().scaledDensity, null, null);
          ((Intent)localObject).putExtra("is_ark_display_share", true);
        }
        for (;;)
        {
          paramContext.putInt("forward_type", 27);
          paramContext.putString("forward_ark_app_name", paramMessageForArkApp.ark_app_message.appName);
          paramContext.putString("forward_ark_app_view", paramMessageForArkApp.ark_app_message.appView);
          paramContext.putString("forward_ark_app_ver", paramMessageForArkApp.ark_app_message.appMinVersion);
          paramContext.putString("forward_ark_app_prompt", paramMessageForArkApp.ark_app_message.promptText);
          paramContext.putString("forward_ark_app_config", paramMessageForArkApp.ark_app_message.config);
          paramContext.putString("forward_ark_app_desc", paramMessageForArkApp.ark_app_message.appDesc);
          paramContext.putString("forward_ark_app_compat", paramMessageForArkApp.ark_app_message.compatibleText);
          paramContext.putString("forward_ark_app_meta", paramMessageForArkApp.ark_app_message.metaList);
          paramContext.putString("forward_ark_app_text", paramMessageForArkApp.ark_app_message.mText);
          paramContext.putString("forward_ark_app_list", a(paramMessageForArkApp.ark_app_message));
          paramContext.putString("forward_appId_ark_from_sdk", paramMessageForArkApp.ark_app_message.appId);
          paramContext.putString("struct_share_key_source_name", paramMessageForArkApp.ark_app_message.mSourceName);
          paramContext.putString("struct_share_key_source_action_data", paramMessageForArkApp.ark_app_message.mSourceActionData);
          paramContext.putString("struct_share_key_source_a_action_data", paramMessageForArkApp.ark_app_message.mSource_A_ActionData);
          paramContext.putString("struct_share_key_source_url", paramMessageForArkApp.ark_app_message.mSourceUrl);
          paramContext.putInt("selection_mode", this.b);
          ((Intent)localObject).putExtras(paramContext);
          aupt.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
          return;
          paramContext = new Bundle();
        }
        paramMessageForArkApp = (MessageForArkApp)localObject;
      }
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
  
  private void b(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    ArkAppCenterUtil.showArkMessageContent(paramContext, paramMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
  }
  
  private void c(Context paramContext, MessageForArkApp paramMessageForArkApp)
  {
    String str = "not loaded";
    if (paramMessageForArkApp.arkContainer != null) {
      str = paramMessageForArkApp.arkContainer.b();
    }
    QQToast.a(paramContext, str, 2000).a();
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public afqr a()
  {
    return new agox();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    localMessageForArkApp.isMultiItemMsg = true;
    boolean bool = paramChatMessage.isSend();
    paramView = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaftk);
    paramViewGroup = (agox)paramView.getTag();
    paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
    Object localObject1 = new ArkAppMessage.Config();
    ((ArkAppMessage.Config)localObject1).fromString(localMessageForArkApp.ark_app_message.config);
    Object localObject2;
    label159:
    label197:
    label233:
    label373:
    int j;
    int i;
    if (MessageForArkApp.isSetSizeByConfig((ArkAppMessage.Config)localObject1))
    {
      paramInt1 = MessageForArkApp.limitToSizeRange(ArkAppCenterUtil.getDensity(), ((ArkAppMessage.Config)localObject1).width.intValue(), ((ArkAppMessage.Config)localObject1).height.intValue()).height + AIOUtils.dp2px(29.0F, paramChatMessage);
      localObject2 = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
      localObject1 = new RelativeLayout.LayoutParams(-1, paramInt1);
      if (TextUtils.isEmpty(localMessageForArkApp.ark_app_message.mText)) {
        break label567;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label572;
      }
      paramViewGroup.d.setText(localMessageForArkApp.ark_app_message.mText);
      paramViewGroup.d.setVisibility(0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131364522);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
      paramView.setPadding(0, BaseChatItemLayout.v, 0, BaseChatItemLayout.i + BaseChatItemLayout.l);
      if (!bool) {
        break label607;
      }
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = BaseChatItemLayout.o;
      ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, paramView.a());
      ((RelativeLayout.LayoutParams)localObject2).topMargin = paramChatMessage.getDimensionPixelSize(2131296418);
      paramView.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if ((paramView.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramView.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        localObject2 = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = BaseChatItemLayout.t;
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if ((paramView.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramView.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 8))
      {
        localObject2 = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        if (!bool) {
          break label670;
        }
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = BaseChatItemLayout.u;
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      j = BaseChatItemLayout.o * 2 + AIOUtils.dp2px(40.0F, paramChatMessage) + paramChatMessage.getDimensionPixelSize(2131296388);
      i = paramChatMessage.getDimensionPixelSize(2131296380);
      paramInt2 = BaseChatItemLayout.d - j - BaseChatItemLayout.e - i;
      if (!bool) {
        break label725;
      }
      paramInt1 = paramInt2;
      label436:
      if (!bool) {
        break label734;
      }
      paramInt2 = j - i;
    }
    label567:
    label572:
    label725:
    label734:
    for (;;)
    {
      if ((localMessageForArkApp.ark_app_message.mAppList == null) || (localMessageForArkApp.ark_app_message.mAppList.isEmpty()) || (!localMessageForArkApp.mExtendMsgArkAppList.isEmpty())) {
        break label737;
      }
      paramChatMessage = localMessageForArkApp.ark_app_message.mAppList.iterator();
      while (paramChatMessage.hasNext())
      {
        localObject2 = (ArkAppMessage)paramChatMessage.next();
        ((ArkAppMessage)localObject2).config = localMessageForArkApp.ark_app_message.config;
        localMessageForArkApp.mExtendMsgArkAppList.add(a(localMessageForArkApp, (ArkAppMessage)localObject2));
      }
      paramInt1 = ArkAppCenterUtil.sChatBubbleMaxWidth + AIOUtils.dp2px(29.0F, paramChatMessage);
      break;
      paramInt1 = 0;
      break label159;
      ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131364531);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = (((RelativeLayout.LayoutParams)localObject2).height / 2);
      paramViewGroup.d.setVisibility(8);
      break label197;
      label607:
      if ((paramView.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramView.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        paramInt1 = AIOUtils.dp2px(30.0F, paramChatMessage);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = (BaseChatItemLayout.t + paramInt1);
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = (paramInt1 - BaseChatItemLayout.t);
        break label233;
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = BaseChatItemLayout.o;
      break label233;
      if ((paramView.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramView.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = (AIOUtils.dp2px(25.0F, paramView.getResources()) + BaseChatItemLayout.t);
        break label373;
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = BaseChatItemLayout.t;
      break label373;
      paramInt1 = j - i;
      break label436;
    }
    label670:
    label737:
    if (paramViewGroup.a == null)
    {
      localObject2 = new ArkHorizontalListView(this.jdField_a_of_type_AndroidContentContext);
      ((ArkHorizontalListView)localObject2).MIN_SPACE = (BaseChatItemLayout.d / 4);
      ((ArkHorizontalListView)localObject2).setDividerWidth(i);
      paramChatMessage = new apzb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArkHorizontalListView)localObject2, paramaftk);
      ((ArkHorizontalListView)localObject2).setAdapter(paramChatMessage);
      paramViewGroup.a = ((ArkHorizontalListView)localObject2);
      paramViewGroup.a.setTag(localMessageForArkApp);
      paramView.addView(paramViewGroup.a, 0, (ViewGroup.LayoutParams)localObject1);
      paramViewGroup.a.setIsSend(bool);
      paramChatMessage.a(paramInt1, paramInt2);
      paramViewGroup.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
      paramInt2 = localMessageForArkApp.getMsgArkAppCount();
      paramChatMessage.a(paramChatMessage.a() - paramInt2);
      paramInt1 = 0;
      label875:
      if (paramInt1 >= paramInt2) {
        break label957;
      }
      paramaftk = localMessageForArkApp.getMsgArkAppByPosition(paramInt1);
      if ((MessageForArkApp)paramChatMessage.b(paramInt1) != null) {
        break label947;
      }
      paramChatMessage.a(paramaftk);
    }
    for (;;)
    {
      paramInt1 += 1;
      break label875;
      paramViewGroup.a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewGroup.a.setTag(localMessageForArkApp);
      paramChatMessage = (apzb)paramViewGroup.a.getAdapter();
      break;
      label947:
      paramChatMessage.b(paramInt1, paramaftk);
    }
    label957:
    a(paramViewGroup, localMessageForArkApp);
    return paramView;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ((MessageForArkApp)paramChatMessage).compatibleMsg;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131367213)
    {
      a(paramContext, (MessageForArkApp)paramChatMessage);
      return;
    }
    if (paramInt == 2131362959)
    {
      b(paramContext, (MessageForArkApp)paramChatMessage);
      return;
    }
    if (paramInt == 2131362961)
    {
      c(paramContext, (MessageForArkApp)paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public bhjs[] a(View paramView)
  {
    int i = 0;
    int k = 1;
    boolean bool = true;
    bhjq localbhjq = new bhjq();
    paramView = (afrk)AIOUtils.getHolder(paramView);
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if ((paramView != null) && (paramView.ark_app_message != null))
      {
        a(localbhjq);
        if (MessageForArkApp.isAllowedArkForward(false, paramView)) {
          localbhjq.a(2131367213, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838991);
        }
        if (paramView.isMultiMsg) {
          return localbhjq.a();
        }
        if (!TextUtils.isEmpty(paramView.ark_app_message.appName)) {
          i = 1;
        }
        int j = k;
        if (paramView.extraflag != 32768)
        {
          j = k;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))
          {
            j = k;
            if (i == 0)
            {
              Boolean localBoolean = (Boolean)apyl.a(3, paramView.ark_app_message.appName, paramView, Boolean.valueOf(true));
              if (localBoolean != null) {
                bool = localBoolean.booleanValue();
              }
              j = bool;
              if (bool)
              {
                a(localbhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView);
                j = bool;
              }
            }
          }
        }
        if (j != 0) {
          a(localbhjq, paramView);
        }
        for (;;)
        {
          super.c(localbhjq, this.jdField_a_of_type_AndroidContentContext);
          super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
          return localbhjq.a();
          admh.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        }
      }
    }
    admh.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    super.c(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    return localbhjq.a();
  }
  
  protected boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agow
 * JD-Core Version:    0.7.0.1
 */