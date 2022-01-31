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

public class afjg
  extends agda
{
  public afjg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aeqi a()
  {
    return new afjh();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aetk paramaetk)
  {
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    localMessageForArkApp.isMultiItemMsg = true;
    boolean bool = paramChatMessage.isSend();
    paramViewGroup = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaetk);
    afjh localafjh = (afjh)paramViewGroup.getTag();
    paramView = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramChatMessage = new ArkAppMessage.Config();
    paramChatMessage.fromString(localMessageForArkApp.ark_app_message.config);
    Object localObject;
    label154:
    label190:
    label225:
    label365:
    int j;
    int i;
    if (MessageForArkApp.isSetSizeByConfig(paramChatMessage))
    {
      paramInt1 = MessageForArkApp.limitToSizeRange(anob.a(), paramChatMessage.width.intValue(), paramChatMessage.height.intValue()).height + aepi.a(29.0F, paramView);
      localObject = (RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
      paramChatMessage = new RelativeLayout.LayoutParams(-1, paramInt1);
      if (TextUtils.isEmpty(localMessageForArkApp.ark_app_message.mText)) {
        break label565;
      }
      paramInt1 = 1;
      if (paramInt1 == 0) {
        break label570;
      }
      localafjh.d.setText(localMessageForArkApp.ark_app_message.mText);
      localafjh.d.setVisibility(0);
      paramChatMessage.addRule(3, 2131364173);
      paramChatMessage.leftMargin = 0;
      paramViewGroup.setPadding(0, BaseChatItemLayout.u, 0, BaseChatItemLayout.h + BaseChatItemLayout.k);
      if (!bool) {
        break label603;
      }
      ((RelativeLayout.LayoutParams)localObject).rightMargin = BaseChatItemLayout.n;
      ((RelativeLayout.LayoutParams)localObject).addRule(10, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramViewGroup.a());
      ((RelativeLayout.LayoutParams)localObject).topMargin = paramView.getDimensionPixelSize(2131296327);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if ((paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        localObject = (RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).leftMargin = BaseChatItemLayout.s;
        paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if ((paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() != 8))
      {
        localObject = (RelativeLayout.LayoutParams)paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        if (!bool) {
          break label666;
        }
        ((RelativeLayout.LayoutParams)localObject).rightMargin = BaseChatItemLayout.t;
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      j = BaseChatItemLayout.n * 2 + aepi.a(40.0F, paramView) + paramView.getDimensionPixelSize(2131296297);
      i = paramView.getDimensionPixelSize(2131296289);
      paramInt2 = BaseChatItemLayout.c - j - BaseChatItemLayout.d - i;
      if (!bool) {
        break label721;
      }
      paramInt1 = paramInt2;
      label431:
      if (!bool) {
        break label730;
      }
      paramInt2 = j - i;
    }
    label565:
    label570:
    label721:
    label730:
    for (;;)
    {
      if ((localMessageForArkApp.ark_app_message.mAppList == null) || (localMessageForArkApp.ark_app_message.mAppList.isEmpty()) || (!localMessageForArkApp.mExtendMsgArkAppList.isEmpty())) {
        break label733;
      }
      paramView = localMessageForArkApp.ark_app_message.mAppList.iterator();
      while (paramView.hasNext())
      {
        localObject = (ArkAppMessage)paramView.next();
        ((ArkAppMessage)localObject).config = localMessageForArkApp.ark_app_message.config;
        localMessageForArkApp.mExtendMsgArkAppList.add(a(localMessageForArkApp, (ArkAppMessage)localObject));
      }
      paramInt1 = anob.a + aepi.a(29.0F, paramView);
      break;
      paramInt1 = 0;
      break label154;
      paramChatMessage.addRule(6, 2131364182);
      paramChatMessage.topMargin = (((RelativeLayout.LayoutParams)localObject).height / 2);
      localafjh.d.setVisibility(8);
      break label190;
      label603:
      if ((paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        paramInt1 = aepi.a(30.0F, paramView);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = (BaseChatItemLayout.s + paramInt1);
        paramChatMessage.leftMargin = (paramInt1 - BaseChatItemLayout.s);
        break label225;
      }
      ((RelativeLayout.LayoutParams)localObject).leftMargin = BaseChatItemLayout.n;
      break label225;
      if ((paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox != null) && (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() != 8))
      {
        ((RelativeLayout.LayoutParams)localObject).leftMargin = (aepi.a(25.0F, paramViewGroup.getResources()) + BaseChatItemLayout.s);
        break label365;
      }
      ((RelativeLayout.LayoutParams)localObject).leftMargin = BaseChatItemLayout.s;
      break label365;
      paramInt1 = j - i;
      break label431;
    }
    label666:
    label733:
    if (localafjh.a == null)
    {
      localObject = new ArkHorizontalListView(this.jdField_a_of_type_AndroidContentContext);
      ((ArkHorizontalListView)localObject).MIN_SPACE = (BaseChatItemLayout.c / 4);
      ((ArkHorizontalListView)localObject).setDividerWidth(i);
      paramView = new anoq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (ArkHorizontalListView)localObject, paramaetk);
      ((ArkHorizontalListView)localObject).setAdapter(paramView);
      localafjh.a = ((ArkHorizontalListView)localObject);
      localafjh.a.setTag(localMessageForArkApp);
      paramViewGroup.addView(localafjh.a, 0, paramChatMessage);
      localafjh.a.setIsSend(bool);
      paramView.a(paramInt1, paramInt2);
      localafjh.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
      paramChatMessage = null;
      paramInt2 = localMessageForArkApp.getMsgArkAppCount();
      paramView.a(paramView.a() - paramInt2);
      paramInt1 = 0;
      label877:
      if (paramInt1 >= paramInt2) {
        break label997;
      }
      paramaetk = localMessageForArkApp.getMsgArkAppByPosition(paramInt1);
      if ((MessageForArkApp)paramView.b(paramInt1) != null) {
        break label986;
      }
      paramView.a(paramaetk);
      if ((paramaetk == null) || (TextUtils.isEmpty(paramaetk.ark_app_message.appName)) || (!TextUtils.isEmpty(paramChatMessage))) {
        break label1050;
      }
      paramChatMessage = paramaetk.ark_app_message.appName;
    }
    label909:
    label1050:
    for (;;)
    {
      paramInt1 += 1;
      break label877;
      localafjh.a.setLayoutParams(paramChatMessage);
      localafjh.a.setTag(localMessageForArkApp);
      paramView = (anoq)localafjh.a.getAdapter();
      break;
      label986:
      paramView.b(paramInt1, paramaetk);
      break label909;
      label997:
      if (e)
      {
        if ((localafjh.jdField_b_of_type_JavaLangStringBuilder != null) && (localafjh.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
          localafjh.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
        }
        paramChatMessage = a(localMessageForArkApp);
        localafjh.d.setContentDescription(paramChatMessage);
      }
      return paramViewGroup;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ((MessageForArkApp)paramChatMessage).compatibleMsg;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131366760)
    {
      paramChatMessage = (MessageForArkApp)paramChatMessage;
      if ((paramChatMessage != null) && (paramChatMessage.ark_app_message != null)) {}
    }
    for (;;)
    {
      return;
      Object localObject = (MessageForArkApp)anny.a(1, paramChatMessage.ark_app_message.appName, paramChatMessage, paramChatMessage);
      if (localObject == null) {}
      while ((paramChatMessage != null) && (paramChatMessage.ark_app_message != null))
      {
        paramInt = paramChatMessage.getMsgArkAppCount();
        localObject = new Intent();
        if (paramInt == 1)
        {
          paramContext = bdjt.a(paramChatMessage.ark_app_message.appName, paramChatMessage.ark_app_message.appView, paramChatMessage.ark_app_message.appMinVersion, paramChatMessage.ark_app_message.metaList, paramContext.getResources().getDisplayMetrics().scaledDensity, null, null);
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
          aryv.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
          return;
          paramContext = new Bundle();
        }
        super.a(paramInt, paramContext, paramChatMessage);
        return;
        paramChatMessage = (ChatMessage)localObject;
      }
    }
  }
  
  public bdpk[] a(View paramView)
  {
    int i = 0;
    int k = 1;
    boolean bool = true;
    bdpi localbdpi = new bdpi();
    paramView = (aeqz)aepi.a(paramView);
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if ((paramView != null) && (paramView.ark_app_message != null))
      {
        if (MessageForArkApp.isAllowedArkForward(false, paramView)) {
          localbdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
        }
        if (paramView.isMultiMsg) {
          return localbdpi.a();
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
              Boolean localBoolean = (Boolean)anny.a(3, paramView.ark_app_message.appName, paramView, Boolean.valueOf(true));
              if (localBoolean != null) {
                bool = localBoolean.booleanValue();
              }
              j = bool;
              if (bool)
              {
                a(localbdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
                j = bool;
              }
            }
          }
        }
        if (j != 0) {
          a(localbdpi, paramView);
        }
        for (;;)
        {
          super.c(localbdpi, this.jdField_a_of_type_AndroidContentContext);
          super.e(localbdpi, this.jdField_a_of_type_AndroidContentContext);
          return localbdpi.a();
          acjm.a(localbdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        }
      }
    }
    acjm.a(localbdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(localbdpi, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbdpi, this.jdField_a_of_type_AndroidContentContext);
    return localbdpi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjg
 * JD-Core Version:    0.7.0.1
 */