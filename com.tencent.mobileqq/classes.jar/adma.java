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

public class adma
  extends BaseBubbleBuilder
{
  private SessionInfo b;
  private int c;
  
  public adma(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
    if (bbkk.a(paramString)) {
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
  
  public acuj a()
  {
    return new adlw();
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
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
    this.c = (alsz.d - BaseChatItemLayout.s - BaseChatItemLayout.t);
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    QLog.i("ArkAppItemBuilder", 1, "ArkFold.ArkAppCenterUtil.sRealDisplayWith=" + alsz.d + ",arkAppWidth=" + this.c + ",app=" + localMessageForArkApp.ark_app_message.appName);
    adlw localadlw = (adlw)paramacuj;
    Object localObject = a(localMessageForArkApp);
    paramacuj = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558727, null);
      localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramView.findViewById(2131362768));
      localadlw.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131362774));
      localadlw.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362773));
      localadlw.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362775));
      localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setTag(localadlw);
      localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)paramView.findViewById(2131369476));
      paramacuj = paramView;
      if (a((String)localObject))
      {
        localadlw.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramacuj = paramView;
      }
    }
    int i = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296333);
    int j = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296285);
    int k = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296334);
    int m = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296284);
    paramView = (RelativeLayout)paramacuj.findViewById(2131362789);
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).addRule(14);
    paramView.setPadding(i, j, k, m);
    if (localadlw.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      if (!new nqy().a(this.jdField_a_of_type_AndroidContentContext, localMessageForArkApp, localadlw.jdField_b_of_type_AndroidWidgetTextView, (String)localObject)) {
        break label1025;
      }
      paramView.removeView(localadlw.jdField_b_of_type_AndroidWidgetTextView);
      paramView.addView(localadlw.jdField_b_of_type_AndroidWidgetTextView);
      paramView = (RelativeLayout.LayoutParams)localadlw.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      paramView.topMargin = vzl.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramView.height = -2;
      paramView.width = -2;
      paramView.addRule(3, 2131362768);
    }
    for (;;)
    {
      if ((localMessageForArkApp != null) && (localMessageForArkApp.ark_app_message != null))
      {
        paramView = localMessageForArkApp.ark_app_message.config;
        if (!bbkk.a(paramView))
        {
          localObject = new ArkAppMessage.Config();
          ((ArkAppMessage.Config)localObject).fromString(paramView);
          if ((((ArkAppMessage.Config)localObject).fitWidthAndCentered.intValue() == 1) && ((paramacuj instanceof ArkAppRootLayout)))
          {
            paramView = (RelativeLayout.LayoutParams)paramacuj.getLayoutParams();
            if (paramView != null) {
              paramView.addRule(14);
            }
          }
        }
      }
      paramView = (RelativeLayout.LayoutParams)localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
      paramView.addRule(14);
      paramView.width = this.c;
      paramView.setMargins(i, j, k, m);
      localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setLayoutParams(paramView);
      if (localadlw.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        localadlw.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      paramView = new admb(this, localMessageForArkApp, localadlw);
      localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback(paramView);
      if (alub.a().a(paramChatMessage.uniseq)) {
        localMessageForArkApp.arkContainer = alub.a().a();
      }
      if (localMessageForArkApp.arkContainer == null) {
        localMessageForArkApp.arkContainer = new adli();
      }
      localMessageForArkApp.arkContainer.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppItemBuilder", 2, new Object[] { "multiAio.ArkAppItemBuilder set session info =", aloy.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo) });
      }
      localMessageForArkApp.arkContainer.a(localMessageForArkApp.ark_app_message.appName, localMessageForArkApp.ark_app_message.appView, localMessageForArkApp.ark_app_message.appMinVersion, localMessageForArkApp.ark_app_message.metaList, alsz.a(), localMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      i = actj.a(352.0F, paramBaseChatItemLayout.getResources());
      localMessageForArkApp.arkContainer.setFixSize(this.c, -1);
      localMessageForArkApp.arkContainer.setMaxSize(this.c, -1);
      localMessageForArkApp.arkContainer.setHintSize(-1, i);
      localMessageForArkApp.arkContainer.a(this.c, i);
      localadlw.jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
      paramView = localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
      paramBaseChatItemLayout = localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      localObject = localadlw.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      paramBaseChatItemLayout.setClipRadius(16.0F);
      ((adln)localObject).a(localMessageForArkApp.arkContainer, paramView);
      paramBaseChatItemLayout.setOnTouchListener(paramacxj);
      paramBaseChatItemLayout.setOnLongClickListener(paramacxj);
      if (paramView != null)
      {
        paramView.setOnTouchListener(paramacxj);
        paramView.setOnLongClickListener(paramacxj);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 1008) && (!this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramChatMessage.uniseq))))
      {
        this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramChatMessage.uniseq));
        akwu.a(117, paramChatMessage, localadlw.jdField_b_of_type_Int);
      }
      return paramacuj;
      label1025:
      paramView.removeView(localadlw.jdField_b_of_type_AndroidWidgetTextView);
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
    case 2131366632: 
      do
      {
        return;
        paramContext = (MessageForArkApp)paramChatMessage;
      } while ((paramContext == null) || (paramContext.ark_app_message == null));
      paramChatMessage = (MessageForArkApp)alsw.a(1, paramContext.ark_app_message.appName, paramContext, paramContext);
      if (paramChatMessage != null) {
        break;
      }
    }
    while ((paramContext != null) && (paramContext.ark_app_message != null))
    {
      new Bundle();
      paramChatMessage = bbgo.a(paramContext.ark_app_message.appName, paramContext.ark_app_message.appView, paramContext.ark_app_message.appMinVersion, paramContext.ark_app_message.metaList, alsz.a(), null, null);
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
      aqbe.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
      return;
      aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      paramContext = paramChatMessage;
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    paramView = (acva)actj.a(paramView);
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if (MessageForArkApp.isAllowedArkForward(true, paramView)) {
        localbbmf.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692753), 2130838606);
      }
      if (paramView.isMultiMsg) {
        return localbbmf.a();
      }
    }
    localbbmf.a(2131364984, this.jdField_a_of_type_AndroidContentContext.getString(2131690708), 2130838601);
    e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    return localbbmf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adma
 * JD-Core Version:    0.7.0.1
 */