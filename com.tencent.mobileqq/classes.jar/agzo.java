import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberNewLevelView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class agzo
  extends BaseBubbleBuilder
{
  private SessionInfo b;
  private int c;
  
  public agzo(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  private String a(MessageForArkApp paramMessageForArkApp)
  {
    String str2 = "";
    String str1 = str2;
    if (paramMessageForArkApp != null)
    {
      paramMessageForArkApp = paramMessageForArkApp.ark_app_message;
      str1 = str2;
      if (paramMessageForArkApp != null) {
        str1 = paramMessageForArkApp.mSourceAd;
      }
    }
    return str1;
  }
  
  private boolean a(String paramString)
  {
    String str = "";
    if (bhsr.a(paramString)) {
      return false;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      paramString = str;
      if (localJSONObject != null) {
        paramString = localJSONObject.optString("from");
      }
      return "gw".equals(paramString);
    }
    catch (JSONException paramString) {}
    return false;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aggl a()
  {
    return new agzk();
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    if ((BaseChatItemLayout.jdField_b_of_type_Int > BaseChatItemLayout.c) && (QLog.isColorLevel())) {
      QLog.e("ArkAppItemBuilder", 2, String.format(Locale.CHINA, "widthPixels > heightPixels: (%d, %d)", new Object[] { Integer.valueOf(BaseChatItemLayout.jdField_b_of_type_Int), Integer.valueOf(BaseChatItemLayout.c) }));
    }
    paramBaseChatItemLayout.setProgressVisable(false);
    paramBaseChatItemLayout.setFailedIconVisable(false, null);
    paramBaseChatItemLayout.setHeadIconVisible(false);
    paramBaseChatItemLayout.setNetIconVisible(false);
    paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, -1);
    if (paramBaseChatItemLayout.a != null) {
      paramBaseChatItemLayout.a.setVisibility(8);
    }
    paramBaseChatItemLayout.setPadding(0, 0, 0, 0);
    this.c = (aqbx.d - BaseChatItemLayout.t - BaseChatItemLayout.u);
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    QLog.i("ArkAppItemBuilder", 1, "ArkFold.ArkAppCenterUtil.sRealDisplayWith=" + aqbx.d + ",arkAppWidth=" + this.c + ",app=" + localMessageForArkApp.ark_app_message.appName);
    agzk localagzk = (agzk)paramaggl;
    Object localObject = a(localMessageForArkApp);
    paramaggl = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558826, null);
      localagzk.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramView.findViewById(2131362928));
      localagzk.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131362935));
      localagzk.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362934));
      localagzk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362936));
      localagzk.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setTag(localagzk);
      localagzk.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)paramView.findViewById(2131370289));
      paramaggl = paramView;
      if (a((String)localObject))
      {
        localagzk.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramaggl = paramView;
      }
    }
    int i = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296377);
    int j = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296329);
    int k = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296378);
    int m = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296328);
    paramView = (RelativeLayout)paramaggl.findViewById(2131362952);
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).addRule(14);
    paramView.setPadding(i, j, k, m);
    if (localagzk.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      if (!new oev().a(this.jdField_a_of_type_AndroidContentContext, localMessageForArkApp, localagzk.jdField_b_of_type_AndroidWidgetTextView, (String)localObject)) {
        break label1051;
      }
      paramView.removeView(localagzk.jdField_b_of_type_AndroidWidgetTextView);
      paramView.addView(localagzk.jdField_b_of_type_AndroidWidgetTextView);
      paramView = (RelativeLayout.LayoutParams)localagzk.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      paramView.topMargin = zps.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramView.height = -2;
      paramView.width = -2;
      paramView.addRule(3, 2131362928);
    }
    for (;;)
    {
      if ((localMessageForArkApp != null) && (localMessageForArkApp.ark_app_message != null))
      {
        paramView = localMessageForArkApp.ark_app_message.config;
        if (!bhsr.a(paramView))
        {
          localObject = new ArkAppMessage.Config();
          ((ArkAppMessage.Config)localObject).fromString(paramView);
          if ((((ArkAppMessage.Config)localObject).fitWidthAndCentered != null) && (((ArkAppMessage.Config)localObject).fitWidthAndCentered.intValue() == 1) && ((paramaggl instanceof ArkAppRootLayout)))
          {
            paramView = (RelativeLayout.LayoutParams)paramaggl.getLayoutParams();
            if (paramView != null) {
              paramView.addRule(14);
            }
          }
        }
      }
      paramView = (RelativeLayout.LayoutParams)localagzk.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
      paramView.addRule(14);
      paramView.width = this.c;
      paramView.setMargins(i, j, k, m);
      localagzk.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setLayoutParams(paramView);
      if (localagzk.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        localagzk.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      paramView = new agzp(this, localMessageForArkApp, localagzk);
      localagzk.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback(paramView);
      if (aqcz.a().a(paramChatMessage.uniseq)) {
        localMessageForArkApp.arkContainer = aqcz.a().a();
      }
      if (localMessageForArkApp.arkContainer == null) {
        localMessageForArkApp.arkContainer = new agyv();
      }
      localMessageForArkApp.arkContainer.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppItemBuilder", 2, new Object[] { "multiAio.ArkAppItemBuilder set session info =", apxt.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo) });
      }
      localMessageForArkApp.arkContainer.a(localMessageForArkApp.ark_app_message.appName, localMessageForArkApp.ark_app_message.appView, localMessageForArkApp.ark_app_message.appMinVersion, localMessageForArkApp.ark_app_message.metaList, aqbx.a(), localMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      i = agej.a(352.0F, paramBaseChatItemLayout.getResources());
      localMessageForArkApp.arkContainer.setFixSize(this.c, -1);
      localMessageForArkApp.arkContainer.setMaxSize(this.c, -1);
      localMessageForArkApp.arkContainer.setHintSize(-1, i);
      localMessageForArkApp.arkContainer.a(this.c, i);
      localagzk.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
      paramView = localagzk.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
      paramBaseChatItemLayout = localagzk.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      localObject = localagzk.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      paramBaseChatItemLayout.setClipRadius(16.0F);
      ((agza)localObject).a(localMessageForArkApp.arkContainer, paramView);
      paramBaseChatItemLayout.setOnTouchListener(paramagjk);
      paramBaseChatItemLayout.setOnLongClickListener(paramagjk);
      if (paramView != null)
      {
        paramView.setOnTouchListener(paramagjk);
        paramView.setOnLongClickListener(paramagjk);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) && (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramChatMessage.uniseq))))
      {
        this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramChatMessage.uniseq));
        apeg.a(117, paramChatMessage, localagzk.jdField_b_of_type_Int);
      }
      return paramaggl;
      label1051:
      paramView.removeView(localagzk.jdField_b_of_type_AndroidWidgetTextView);
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131367078: 
      do
      {
        return;
        paramContext = (MessageForArkApp)paramChatMessage;
      } while ((paramContext == null) || (paramContext.ark_app_message == null));
      paramChatMessage = (MessageForArkApp)aqbu.a(1, paramContext.ark_app_message.appName, paramContext, paramContext);
      if (paramChatMessage != null) {
        break;
      }
    }
    while ((paramContext != null) && (paramContext.ark_app_message != null))
    {
      new Bundle();
      paramChatMessage = bhow.a(paramContext.ark_app_message.appName, paramContext.ark_app_message.appView, paramContext.ark_app_message.appMinVersion, paramContext.ark_app_message.metaList, aqbx.a(), null, null);
      paramChatMessage.putInt("forward_type", 27);
      paramChatMessage.putString("forward_ark_app_name", paramContext.ark_app_message.appName);
      paramChatMessage.putString("forward_ark_app_view", paramContext.ark_app_message.appView);
      paramChatMessage.putString("forward_ark_app_ver", paramContext.ark_app_message.appMinVersion);
      paramChatMessage.putString("forward_ark_app_prompt", paramContext.ark_app_message.promptText);
      paramChatMessage.putString("forward_ark_app_config", paramContext.ark_app_message.config);
      paramChatMessage.putString("forward_ark_app_desc", paramContext.ark_app_message.appDesc);
      paramChatMessage.putString("forward_ark_app_compat", paramContext.ark_app_message.compatibleText);
      paramChatMessage.putString("forward_ark_app_meta", paramContext.ark_app_message.metaList);
      paramChatMessage.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramChatMessage.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      paramContext = new Intent();
      paramContext.putExtras(paramChatMessage);
      paramContext.putExtra("is_ark_display_share", true);
      auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
      return;
      aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      paramContext = paramChatMessage;
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public bhum[] a(View paramView)
  {
    bhuk localbhuk = new bhuk();
    paramView = (aghd)agej.a(paramView);
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if (MessageForArkApp.isAllowedArkForward(true, paramView)) {
        localbhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
      }
      if (paramView.isMultiMsg) {
        return localbhuk.a();
      }
    }
    localbhuk.a(2131365352, this.jdField_a_of_type_AndroidContentContext.getString(2131690639), 2130838934);
    e(localbhuk, this.jdField_a_of_type_AndroidContentContext);
    return localbhuk.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzo
 * JD-Core Version:    0.7.0.1
 */