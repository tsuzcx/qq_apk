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
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class afek
  extends BaseBubbleBuilder
{
  private SessionInfo b;
  private int c;
  
  public afek(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
    if (bdje.a(paramString)) {
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
  
  public aelt a()
  {
    return new afeg();
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    if ((BaseChatItemLayout.a > BaseChatItemLayout.jdField_b_of_type_Int) && (QLog.isColorLevel())) {
      QLog.e("ArkAppItemBuilder", 2, String.format(Locale.CHINA, "widthPixels > heightPixels: (%d, %d)", new Object[] { Integer.valueOf(BaseChatItemLayout.a), Integer.valueOf(BaseChatItemLayout.jdField_b_of_type_Int) }));
    }
    paramBaseChatItemLayout.setProgressVisable(false);
    paramBaseChatItemLayout.setFailedIconVisable(false, null);
    paramBaseChatItemLayout.setHeadIconVisible(false);
    paramBaseChatItemLayout.setNetIconVisible(false);
    paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, -1);
    paramBaseChatItemLayout.setPadding(0, 0, 0, 0);
    this.c = (anjs.d - BaseChatItemLayout.s - BaseChatItemLayout.t);
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    QLog.i("ArkAppItemBuilder", 1, "ArkFold.ArkAppCenterUtil.sRealDisplayWith=" + anjs.d + ",arkAppWidth=" + this.c + ",app=" + localMessageForArkApp.ark_app_message.appName);
    afeg localafeg = (afeg)paramaelt;
    Object localObject = a(localMessageForArkApp);
    paramaelt = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558763, null);
      localafeg.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramView.findViewById(2131362798));
      localafeg.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131362805));
      localafeg.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362804));
      localafeg.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362806));
      localafeg.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setTag(localafeg);
      localafeg.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)paramView.findViewById(2131369738));
      paramaelt = paramView;
      if (a((String)localObject))
      {
        localafeg.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramaelt = paramView;
      }
    }
    int i = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296339);
    int j = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296291);
    int k = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296340);
    int m = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296290);
    paramView = (RelativeLayout)paramaelt.findViewById(2131362821);
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).addRule(14);
    paramView.setPadding(i, j, k, m);
    if (localafeg.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      if (!new nuh().a(this.jdField_a_of_type_AndroidContentContext, localMessageForArkApp, localafeg.jdField_b_of_type_AndroidWidgetTextView, (String)localObject)) {
        break label1025;
      }
      paramView.removeView(localafeg.jdField_b_of_type_AndroidWidgetTextView);
      paramView.addView(localafeg.jdField_b_of_type_AndroidWidgetTextView);
      paramView = (RelativeLayout.LayoutParams)localafeg.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      paramView.topMargin = xod.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramView.height = -2;
      paramView.width = -2;
      paramView.addRule(3, 2131362798);
    }
    for (;;)
    {
      if ((localMessageForArkApp != null) && (localMessageForArkApp.ark_app_message != null))
      {
        paramView = localMessageForArkApp.ark_app_message.config;
        if (!bdje.a(paramView))
        {
          localObject = new ArkAppMessage.Config();
          ((ArkAppMessage.Config)localObject).fromString(paramView);
          if ((((ArkAppMessage.Config)localObject).fitWidthAndCentered.intValue() == 1) && ((paramaelt instanceof ArkAppRootLayout)))
          {
            paramView = (RelativeLayout.LayoutParams)paramaelt.getLayoutParams();
            if (paramView != null) {
              paramView.addRule(14);
            }
          }
        }
      }
      paramView = (RelativeLayout.LayoutParams)localafeg.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
      paramView.addRule(14);
      paramView.width = this.c;
      paramView.setMargins(i, j, k, m);
      localafeg.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setLayoutParams(paramView);
      if (localafeg.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        localafeg.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      paramView = new afel(this, localMessageForArkApp, localafeg);
      localafeg.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback(paramView);
      if (anku.a().a(paramChatMessage.uniseq)) {
        localMessageForArkApp.arkContainer = anku.a().a();
      }
      if (localMessageForArkApp.arkContainer == null) {
        localMessageForArkApp.arkContainer = new afds();
      }
      localMessageForArkApp.arkContainer.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppItemBuilder", 2, new Object[] { "multiAio.ArkAppItemBuilder set session info =", anfp.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo) });
      }
      localMessageForArkApp.arkContainer.a(localMessageForArkApp.ark_app_message.appName, localMessageForArkApp.ark_app_message.appView, localMessageForArkApp.ark_app_message.appMinVersion, localMessageForArkApp.ark_app_message.metaList, anjs.a(), localMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      i = aekt.a(352.0F, paramBaseChatItemLayout.getResources());
      localMessageForArkApp.arkContainer.setFixSize(this.c, -1);
      localMessageForArkApp.arkContainer.setMaxSize(this.c, -1);
      localMessageForArkApp.arkContainer.setHintSize(-1, i);
      localMessageForArkApp.arkContainer.a(this.c, i);
      localafeg.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
      paramView = localafeg.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
      paramBaseChatItemLayout = localafeg.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      localObject = localafeg.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      paramBaseChatItemLayout.setClipRadius(16.0F);
      ((afdx)localObject).a(localMessageForArkApp.arkContainer, paramView);
      paramBaseChatItemLayout.setOnTouchListener(paramaeov);
      paramBaseChatItemLayout.setOnLongClickListener(paramaeov);
      if (paramView != null)
      {
        paramView.setOnTouchListener(paramaeov);
        paramView.setOnLongClickListener(paramaeov);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) && (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramChatMessage.uniseq))))
      {
        this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramChatMessage.uniseq));
        amnk.a(117, paramChatMessage, localafeg.jdField_b_of_type_Int);
      }
      return paramaelt;
      label1025:
      paramView.removeView(localafeg.jdField_b_of_type_AndroidWidgetTextView);
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
    case 2131366750: 
      do
      {
        return;
        paramContext = (MessageForArkApp)paramChatMessage;
      } while ((paramContext == null) || (paramContext.ark_app_message == null));
      paramChatMessage = (MessageForArkApp)anjp.a(1, paramContext.ark_app_message.appName, paramContext, paramContext);
      if (paramChatMessage != null) {
        break;
      }
    }
    while ((paramContext != null) && (paramContext.ark_app_message != null))
    {
      new Bundle();
      paramChatMessage = bdfk.a(paramContext.ark_app_message.appName, paramContext.ark_app_message.appView, paramContext.ark_app_message.appMinVersion, paramContext.ark_app_message.metaList, anjs.a(), null, null);
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
      arum.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
      return;
      acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      paramContext = paramChatMessage;
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    paramView = (aemk)aekt.a(paramView);
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if (MessageForArkApp.isAllowedArkForward(true, paramView)) {
        localbdkz.a(2131366750, this.jdField_a_of_type_AndroidContentContext.getString(2131692835), 2130838677);
      }
      if (paramView.isMultiMsg) {
        return localbdkz.a();
      }
    }
    localbdkz.a(2131365069, this.jdField_a_of_type_AndroidContentContext.getString(2131690760), 2130838672);
    e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    return localbdkz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afek
 * JD-Core Version:    0.7.0.1
 */