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
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class agzv
  extends ahtp
{
  public agzv(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
  
  private void a(agzw paramagzw, MessageForArkApp paramMessageForArkApp)
  {
    if ((e) && (paramagzw != null) && (paramMessageForArkApp != null))
    {
      if ((paramagzw.jdField_b_of_type_JavaLangStringBuilder != null) && (paramagzw.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
        paramagzw.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
      }
      paramMessageForArkApp = a(paramMessageForArkApp);
      paramagzw.d.setContentDescription(paramMessageForArkApp);
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aggl a()
  {
    return new agzw();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    localMessageForArkApp.isMultiItemMsg = true;
    boolean bool = paramChatMessage.isSend();
    paramView = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    paramViewGroup = (agzw)paramView.getTag();
    paramChatMessage = this.jdField_a_of_type_AndroidContentContext.getResources();
    Object localObject1 = new ArkAppMessage.Config();
    ((ArkAppMessage.Config)localObject1).fromString(localMessageForArkApp.ark_app_message.config);
    Object localObject2;
    label158:
    label195:
    label231:
    label371:
    int j;
    int i;
    if (MessageForArkApp.isSetSizeByConfig((ArkAppMessage.Config)localObject1))
    {
      paramInt1 = MessageForArkApp.limitToSizeRange(aqbx.a(), ((ArkAppMessage.Config)localObject1).width.intValue(), ((ArkAppMessage.Config)localObject1).height.intValue()).height + agej.a(29.0F, paramChatMessage);
      localObject2 = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
      localObject1 = new RelativeLayout.LayoutParams(-1, paramInt1);
      if (TextUtils.isEmpty(localMessageForArkApp.ark_app_message.mText)) {
        break label564;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label569;
      }
      paramViewGroup.d.setText(localMessageForArkApp.ark_app_message.mText);
      paramViewGroup.d.setVisibility(0);
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131364423);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = 0;
      paramView.setPadding(0, BaseChatItemLayout.v, 0, BaseChatItemLayout.i + BaseChatItemLayout.l);
      if (!bool) {
        break label604;
      }
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = BaseChatItemLayout.o;
      ((RelativeLayout.LayoutParams)localObject2).addRule(10, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, paramView.a());
      ((RelativeLayout.LayoutParams)localObject2).topMargin = paramChatMessage.getDimensionPixelSize(2131296365);
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
          break label667;
        }
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = BaseChatItemLayout.u;
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      j = BaseChatItemLayout.o * 2 + agej.a(40.0F, paramChatMessage) + paramChatMessage.getDimensionPixelSize(2131296335);
      i = paramChatMessage.getDimensionPixelSize(2131296327);
      paramInt2 = BaseChatItemLayout.d - j - BaseChatItemLayout.e - i;
      if (!bool) {
        break label722;
      }
      paramInt1 = paramInt2;
      label434:
      if (!bool) {
        break label731;
      }
      paramInt2 = j - i;
    }
    label564:
    label569:
    label722:
    label731:
    for (;;)
    {
      if ((localMessageForArkApp.ark_app_message.mAppList == null) || (localMessageForArkApp.ark_app_message.mAppList.isEmpty()) || (!localMessageForArkApp.mExtendMsgArkAppList.isEmpty())) {
        break label734;
      }
      paramChatMessage = localMessageForArkApp.ark_app_message.mAppList.iterator();
      while (paramChatMessage.hasNext())
      {
        localObject2 = (ArkAppMessage)paramChatMessage.next();
        ((ArkAppMessage)localObject2).config = localMessageForArkApp.ark_app_message.config;
        localMessageForArkApp.mExtendMsgArkAppList.add(a(localMessageForArkApp, (ArkAppMessage)localObject2));
      }
      paramInt1 = aqbx.a + agej.a(29.0F, paramChatMessage);
      break;
      paramInt1 = 0;
      break label158;
      ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131364432);
      ((RelativeLayout.LayoutParams)localObject1).topMargin = (((RelativeLayout.LayoutParams)localObject2).height / 2);
      paramViewGroup.d.setVisibility(8);
      break label195;
      label604:
      if ((paramView.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramView.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        paramInt1 = agej.a(30.0F, paramChatMessage);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = (BaseChatItemLayout.t + paramInt1);
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = (paramInt1 - BaseChatItemLayout.t);
        break label231;
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = BaseChatItemLayout.o;
      break label231;
      if ((paramView.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramView.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = (agej.a(25.0F, paramView.getResources()) + BaseChatItemLayout.t);
        break label371;
      }
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = BaseChatItemLayout.t;
      break label371;
      paramInt1 = j - i;
      break label434;
    }
    label667:
    label734:
    if (paramViewGroup.a == null)
    {
      localObject2 = new ArkHorizontalListView(this.jdField_a_of_type_AndroidContentContext);
      ((ArkHorizontalListView)localObject2).MIN_SPACE = (BaseChatItemLayout.d / 4);
      ((ArkHorizontalListView)localObject2).setDividerWidth(i);
      paramChatMessage = new aqcm(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArkHorizontalListView)localObject2, paramagjk);
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
      label872:
      if (paramInt1 >= paramInt2) {
        break label954;
      }
      paramagjk = localMessageForArkApp.getMsgArkAppByPosition(paramInt1);
      if ((MessageForArkApp)paramChatMessage.b(paramInt1) != null) {
        break label944;
      }
      paramChatMessage.a(paramagjk);
    }
    for (;;)
    {
      paramInt1 += 1;
      break label872;
      paramViewGroup.a.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewGroup.a.setTag(localMessageForArkApp);
      paramChatMessage = (aqcm)paramViewGroup.a.getAdapter();
      break;
      label944:
      paramChatMessage.b(paramInt1, paramagjk);
    }
    label954:
    a(paramViewGroup, localMessageForArkApp);
    return paramView;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ((MessageForArkApp)paramChatMessage).compatibleMsg;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131367078)
    {
      paramChatMessage = (MessageForArkApp)paramChatMessage;
      if ((paramChatMessage != null) && (paramChatMessage.ark_app_message != null)) {}
    }
    for (;;)
    {
      return;
      Object localObject = (MessageForArkApp)aqbu.a(1, paramChatMessage.ark_app_message.appName, paramChatMessage, paramChatMessage);
      if (localObject == null) {}
      while ((paramChatMessage != null) && (paramChatMessage.ark_app_message != null))
      {
        paramInt = paramChatMessage.getMsgArkAppCount();
        localObject = new Intent();
        if (paramInt == 1)
        {
          paramContext = bhow.a(paramChatMessage.ark_app_message.appName, paramChatMessage.ark_app_message.appView, paramChatMessage.ark_app_message.appMinVersion, paramChatMessage.ark_app_message.metaList, paramContext.getResources().getDisplayMetrics().scaledDensity, null, null);
          ((Intent)localObject).putExtra("is_ark_display_share", true);
        }
        for (;;)
        {
          paramContext.putInt("forward_type", 27);
          paramContext.putString("forward_ark_app_name", paramChatMessage.ark_app_message.appName);
          paramContext.putString("forward_ark_app_view", paramChatMessage.ark_app_message.appView);
          paramContext.putString("forward_ark_app_ver", paramChatMessage.ark_app_message.appMinVersion);
          paramContext.putString("forward_ark_app_prompt", paramChatMessage.ark_app_message.promptText);
          paramContext.putString("forward_ark_app_config", paramChatMessage.ark_app_message.config);
          paramContext.putString("forward_ark_app_desc", paramChatMessage.ark_app_message.appDesc);
          paramContext.putString("forward_ark_app_compat", paramChatMessage.ark_app_message.compatibleText);
          paramContext.putString("forward_ark_app_meta", paramChatMessage.ark_app_message.metaList);
          paramContext.putString("forward_ark_app_text", paramChatMessage.ark_app_message.mText);
          paramContext.putString("forward_ark_app_list", a(paramChatMessage.ark_app_message));
          paramContext.putString("forward_appId_ark_from_sdk", paramChatMessage.ark_app_message.appId);
          paramContext.putString("struct_share_key_source_name", paramChatMessage.ark_app_message.mSourceName);
          paramContext.putString("struct_share_key_source_action_data", paramChatMessage.ark_app_message.mSourceActionData);
          paramContext.putString("struct_share_key_source_a_action_data", paramChatMessage.ark_app_message.mSource_A_ActionData);
          paramContext.putString("struct_share_key_source_url", paramChatMessage.ark_app_message.mSourceUrl);
          paramContext.putInt("selection_mode", this.b);
          ((Intent)localObject).putExtras(paramContext);
          auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
          return;
          paramContext = new Bundle();
        }
        super.a(paramInt, paramContext, paramChatMessage);
        return;
        paramChatMessage = (ChatMessage)localObject;
      }
    }
  }
  
  public bhum[] a(View paramView)
  {
    int i = 0;
    int k = 1;
    boolean bool = true;
    bhuk localbhuk = new bhuk();
    paramView = (aghd)agej.a(paramView);
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if ((paramView != null) && (paramView.ark_app_message != null))
      {
        if (MessageForArkApp.isAllowedArkForward(false, paramView)) {
          localbhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
        }
        if (paramView.isMultiMsg) {
          return localbhuk.a();
        }
        if (!TextUtils.isEmpty(paramView.ark_app_message.appName)) {
          i = 1;
        }
        int j = k;
        if (paramView.extraflag != 32768)
        {
          j = k;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))
          {
            j = k;
            if (i == 0)
            {
              Boolean localBoolean = (Boolean)aqbu.a(3, paramView.ark_app_message.appName, paramView, Boolean.valueOf(true));
              if (localBoolean != null) {
                bool = localBoolean.booleanValue();
              }
              j = bool;
              if (bool)
              {
                a(localbhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
                j = bool;
              }
            }
          }
        }
        if (j != 0) {
          a(localbhuk, paramView);
        }
        for (;;)
        {
          super.c(localbhuk, this.jdField_a_of_type_AndroidContentContext);
          super.e(localbhuk, this.jdField_a_of_type_AndroidContentContext);
          return localbhuk.a();
          aean.a(localbhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        }
      }
    }
    aean.a(localbhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(localbhuk, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbhuk, this.jdField_a_of_type_AndroidContentContext);
    return localbhuk.a();
  }
  
  protected boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzv
 * JD-Core Version:    0.7.0.1
 */