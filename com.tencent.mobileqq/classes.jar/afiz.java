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

public class afiz
  extends BaseBubbleBuilder
{
  private SessionInfo b;
  private int c;
  
  public afiz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
    if (bdnn.a(paramString)) {
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
  
  public aeqi a()
  {
    return new afiv();
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
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
    this.c = (anob.d - BaseChatItemLayout.s - BaseChatItemLayout.t);
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    QLog.i("ArkAppItemBuilder", 1, "ArkFold.ArkAppCenterUtil.sRealDisplayWith=" + anob.d + ",arkAppWidth=" + this.c + ",app=" + localMessageForArkApp.ark_app_message.appName);
    afiv localafiv = (afiv)paramaeqi;
    Object localObject = a(localMessageForArkApp);
    paramaeqi = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558762, null);
      localafiv.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramView.findViewById(2131362798));
      localafiv.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131362805));
      localafiv.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362804));
      localafiv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362806));
      localafiv.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setTag(localafiv);
      localafiv.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)paramView.findViewById(2131369757));
      paramaeqi = paramView;
      if (a((String)localObject))
      {
        localafiv.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramaeqi = paramView;
      }
    }
    int i = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296339);
    int j = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296291);
    int k = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296340);
    int m = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296290);
    paramView = (RelativeLayout)paramaeqi.findViewById(2131362821);
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).addRule(14);
    paramView.setPadding(i, j, k, m);
    if (localafiv.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      if (!new nuh().a(this.jdField_a_of_type_AndroidContentContext, localMessageForArkApp, localafiv.jdField_b_of_type_AndroidWidgetTextView, (String)localObject)) {
        break label1025;
      }
      paramView.removeView(localafiv.jdField_b_of_type_AndroidWidgetTextView);
      paramView.addView(localafiv.jdField_b_of_type_AndroidWidgetTextView);
      paramView = (RelativeLayout.LayoutParams)localafiv.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      paramView.topMargin = xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramView.height = -2;
      paramView.width = -2;
      paramView.addRule(3, 2131362798);
    }
    for (;;)
    {
      if ((localMessageForArkApp != null) && (localMessageForArkApp.ark_app_message != null))
      {
        paramView = localMessageForArkApp.ark_app_message.config;
        if (!bdnn.a(paramView))
        {
          localObject = new ArkAppMessage.Config();
          ((ArkAppMessage.Config)localObject).fromString(paramView);
          if ((((ArkAppMessage.Config)localObject).fitWidthAndCentered.intValue() == 1) && ((paramaeqi instanceof ArkAppRootLayout)))
          {
            paramView = (RelativeLayout.LayoutParams)paramaeqi.getLayoutParams();
            if (paramView != null) {
              paramView.addRule(14);
            }
          }
        }
      }
      paramView = (RelativeLayout.LayoutParams)localafiv.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
      paramView.addRule(14);
      paramView.width = this.c;
      paramView.setMargins(i, j, k, m);
      localafiv.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setLayoutParams(paramView);
      if (localafiv.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        localafiv.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      paramView = new afja(this, localMessageForArkApp, localafiv);
      localafiv.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback(paramView);
      if (anpd.a().a(paramChatMessage.uniseq)) {
        localMessageForArkApp.arkContainer = anpd.a().a();
      }
      if (localMessageForArkApp.arkContainer == null) {
        localMessageForArkApp.arkContainer = new afih();
      }
      localMessageForArkApp.arkContainer.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppItemBuilder", 2, new Object[] { "multiAio.ArkAppItemBuilder set session info =", anjy.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo) });
      }
      localMessageForArkApp.arkContainer.a(localMessageForArkApp.ark_app_message.appName, localMessageForArkApp.ark_app_message.appView, localMessageForArkApp.ark_app_message.appMinVersion, localMessageForArkApp.ark_app_message.metaList, anob.a(), localMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      i = aepi.a(352.0F, paramBaseChatItemLayout.getResources());
      localMessageForArkApp.arkContainer.setFixSize(this.c, -1);
      localMessageForArkApp.arkContainer.setMaxSize(this.c, -1);
      localMessageForArkApp.arkContainer.setHintSize(-1, i);
      localMessageForArkApp.arkContainer.a(this.c, i);
      localafiv.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
      paramView = localafiv.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
      paramBaseChatItemLayout = localafiv.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      localObject = localafiv.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      paramBaseChatItemLayout.setClipRadius(16.0F);
      ((afim)localObject).a(localMessageForArkApp.arkContainer, paramView);
      paramBaseChatItemLayout.setOnTouchListener(paramaetk);
      paramBaseChatItemLayout.setOnLongClickListener(paramaetk);
      if (paramView != null)
      {
        paramView.setOnTouchListener(paramaetk);
        paramView.setOnLongClickListener(paramaetk);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) && (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramChatMessage.uniseq))))
      {
        this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramChatMessage.uniseq));
        amrz.a(117, paramChatMessage, localafiv.jdField_b_of_type_Int);
      }
      return paramaeqi;
      label1025:
      paramView.removeView(localafiv.jdField_b_of_type_AndroidWidgetTextView);
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
    case 2131366760: 
      do
      {
        return;
        paramContext = (MessageForArkApp)paramChatMessage;
      } while ((paramContext == null) || (paramContext.ark_app_message == null));
      paramChatMessage = (MessageForArkApp)anny.a(1, paramContext.ark_app_message.appName, paramContext, paramContext);
      if (paramChatMessage != null) {
        break;
      }
    }
    while ((paramContext != null) && (paramContext.ark_app_message != null))
    {
      new Bundle();
      paramChatMessage = bdjt.a(paramContext.ark_app_message.appName, paramContext.ark_app_message.appView, paramContext.ark_app_message.appMinVersion, paramContext.ark_app_message.metaList, anob.a(), null, null);
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
      aryv.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
      return;
      acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      paramContext = paramChatMessage;
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public bdpk[] a(View paramView)
  {
    bdpi localbdpi = new bdpi();
    paramView = (aeqz)aepi.a(paramView);
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if (MessageForArkApp.isAllowedArkForward(true, paramView)) {
        localbdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
      }
      if (paramView.isMultiMsg) {
        return localbdpi.a();
      }
    }
    localbdpi.a(2131365071, this.jdField_a_of_type_AndroidContentContext.getString(2131690760), 2130838673);
    e(localbdpi, this.jdField_a_of_type_AndroidContentContext);
    return localbdpi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afiz
 * JD-Core Version:    0.7.0.1
 */