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
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class agop
  extends BaseBubbleBuilder
{
  private SessionInfo b;
  private int c;
  
  public agop(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
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
    if (StringUtil.isEmpty(paramString)) {
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
  
  public afqr a()
  {
    return new agol();
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    if ((BaseChatItemLayout.jdField_b_of_type_Int > BaseChatItemLayout.jdField_c_of_type_Int) && (QLog.isColorLevel())) {
      QLog.e("ArkAppItemBuilder", 2, String.format(Locale.CHINA, "widthPixels > heightPixels: (%d, %d)", new Object[] { Integer.valueOf(BaseChatItemLayout.jdField_b_of_type_Int), Integer.valueOf(BaseChatItemLayout.jdField_c_of_type_Int) }));
    }
    paramBaseChatItemLayout.setProgressVisable(false);
    paramBaseChatItemLayout.setFailedIconVisable(false, null);
    paramBaseChatItemLayout.setHeadIconVisible(false);
    paramBaseChatItemLayout.setNetIconVisible(false);
    if (paramBaseChatItemLayout.jdField_c_of_type_AndroidWidgetTextView != null) {
      paramBaseChatItemLayout.setTroopMemberLevel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null, false, -1, -1);
    }
    if (paramBaseChatItemLayout.a != null) {
      paramBaseChatItemLayout.a.setVisibility(8);
    }
    paramBaseChatItemLayout.setPadding(0, 0, 0, 0);
    this.jdField_c_of_type_Int = (ArkAppCenterUtil.sRealDisplayWith - BaseChatItemLayout.t - BaseChatItemLayout.u);
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    Object localObject2 = new StringBuilder().append("ArkFold.ArkAppCenterUtil.sRealDisplayWith=").append(ArkAppCenterUtil.sRealDisplayWith).append(",arkAppWidth=").append(this.jdField_c_of_type_Int).append(",app=");
    if (localMessageForArkApp.ark_app_message != null) {}
    for (Object localObject1 = localMessageForArkApp.ark_app_message.appName;; localObject1 = "(null)")
    {
      QLog.i("ArkAppItemBuilder", 1, (String)localObject1);
      localObject1 = (agol)paramafqr;
      localObject2 = a(localMessageForArkApp);
      paramafqr = paramView;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558859, null);
        ((agol)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramView.findViewById(2131362957));
        ((agol)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131362966));
        ((agol)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362965));
        ((agol)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362967));
        ((agol)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setTag(localObject1);
        ((agol)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)paramView.findViewById(2131370436));
        paramafqr = paramView;
        if (a((String)localObject2))
        {
          ((agol)localObject1).jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
          paramafqr = paramView;
        }
      }
      if (localMessageForArkApp.ark_app_message != null) {
        break;
      }
      QLog.i("ArkAppItemBuilder", 1, "getBubbleView, ark_app_message is null");
      return paramafqr;
    }
    int i = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296430);
    int j = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296382);
    int k = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296431);
    int m = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131296381);
    paramView = (RelativeLayout)paramafqr.findViewById(2131362983);
    ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).addRule(14);
    paramView.setPadding(i, j, k, m);
    if (((agol)localObject1).jdField_b_of_type_AndroidWidgetTextView != null)
    {
      if (!new oob().a(this.jdField_a_of_type_AndroidContentContext, localMessageForArkApp, ((agol)localObject1).jdField_b_of_type_AndroidWidgetTextView, (String)localObject2)) {
        break label1107;
      }
      paramView.removeView(((agol)localObject1).jdField_b_of_type_AndroidWidgetTextView);
      paramView.addView(((agol)localObject1).jdField_b_of_type_AndroidWidgetTextView);
      paramView = (RelativeLayout.LayoutParams)((agol)localObject1).jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      paramView.topMargin = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramView.height = -2;
      paramView.width = -2;
      paramView.addRule(3, 2131362957);
    }
    for (;;)
    {
      if (localMessageForArkApp.ark_app_message != null)
      {
        paramView = localMessageForArkApp.ark_app_message.config;
        if (!StringUtil.isEmpty(paramView))
        {
          localObject2 = new ArkAppMessage.Config();
          ((ArkAppMessage.Config)localObject2).fromString(paramView);
          if ((((ArkAppMessage.Config)localObject2).fitWidthAndCentered != null) && (((ArkAppMessage.Config)localObject2).fitWidthAndCentered.intValue() == 1) && ((paramafqr instanceof ArkAppRootLayout)))
          {
            paramView = (RelativeLayout.LayoutParams)paramafqr.getLayoutParams();
            if (paramView != null) {
              paramView.addRule(14);
            }
          }
        }
      }
      if (((agol)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout != null)
      {
        paramView = (RelativeLayout.LayoutParams)((agol)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.getLayoutParams();
        paramView.addRule(14);
        paramView.width = this.jdField_c_of_type_Int;
        paramView.setMargins(i, j, k, m);
        ((agol)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setLayoutParams(paramView);
      }
      if (((agol)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        ((agol)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      paramView = new agoq(this, localMessageForArkApp, (agol)localObject1);
      ((agol)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setLoadCallback(paramView);
      if (apzo.a().a(paramChatMessage.uniseq)) {
        localMessageForArkApp.arkContainer = apzo.a().a();
      }
      if (localMessageForArkApp.arkContainer == null) {
        localMessageForArkApp.arkContainer = new agnw();
      }
      localMessageForArkApp.arkContainer.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppItemBuilder", 2, new Object[] { "multiAio.ArkAppItemBuilder set session info =", apuh.a(this.jdField_b_of_type_ComTencentMobileqqActivityAioSessionInfo) });
      }
      localMessageForArkApp.arkContainer.a(localMessageForArkApp.ark_app_message.appName, localMessageForArkApp.ark_app_message.appView, localMessageForArkApp.ark_app_message.appMinVersion, localMessageForArkApp.ark_app_message.metaList, ArkAppCenterUtil.getDensity(), localMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      i = AIOUtils.dp2px(352.0F, paramBaseChatItemLayout.getResources());
      localMessageForArkApp.arkContainer.setFixSize(this.jdField_c_of_type_Int, -1);
      localMessageForArkApp.arkContainer.setMaxSize(this.jdField_c_of_type_Int, -1);
      localMessageForArkApp.arkContainer.setHintSize(-1, i);
      localMessageForArkApp.arkContainer.a(this.jdField_c_of_type_Int, i);
      ((agol)localObject1).jdField_b_of_type_JavaLangString = localMessageForArkApp.msg;
      paramView = ((agol)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
      paramBaseChatItemLayout = ((agol)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      localObject2 = ((agol)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      paramBaseChatItemLayout.setClipRadius(16.0F);
      ((agob)localObject2).a(localMessageForArkApp.arkContainer, paramView);
      paramBaseChatItemLayout.setOnTouchListener(paramaftk);
      paramBaseChatItemLayout.setOnLongClickListener(paramaftk);
      if (paramView != null)
      {
        paramView.setOnTouchListener(paramaftk);
        paramView.setOnLongClickListener(paramaftk);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1008) || (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramChatMessage.uniseq)))) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(paramChatMessage.uniseq));
      apau.a(117, paramChatMessage, ((agol)localObject1).jdField_b_of_type_Int);
      return paramafqr;
      label1107:
      paramView.removeView(((agol)localObject1).jdField_b_of_type_AndroidWidgetTextView);
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
    case 2131367213: 
      do
      {
        return;
        paramContext = (MessageForArkApp)paramChatMessage;
      } while ((paramContext == null) || (paramContext.ark_app_message == null));
      paramChatMessage = (MessageForArkApp)apyl.a(1, paramContext.ark_app_message.appName, paramContext, paramContext);
      if (paramChatMessage != null) {
        break;
      }
    }
    while ((paramContext != null) && (paramContext.ark_app_message != null))
    {
      new Bundle();
      paramChatMessage = QQCustomArkDialog.AppInfo.zipArgs(paramContext.ark_app_message.appName, paramContext.ark_app_message.appView, paramContext.ark_app_message.appMinVersion, paramContext.ark_app_message.metaList, ArkAppCenterUtil.getDensity(), null, null);
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
      paramChatMessage.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      paramContext = new Intent();
      paramContext.putExtras(paramChatMessage);
      paramContext.putExtra("is_ark_display_share", true);
      aupt.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, 21);
      return;
      admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      paramContext = paramChatMessage;
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public bhjs[] a(View paramView)
  {
    bhjq localbhjq = new bhjq();
    paramView = (afrk)AIOUtils.getHolder(paramView);
    if (paramView != null)
    {
      paramView = (MessageForArkApp)paramView.a;
      if (MessageForArkApp.isAllowedArkForward(true, paramView)) {
        localbhjq.a(2131367213, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838991);
      }
      if (paramView.isMultiMsg) {
        return localbhjq.a();
      }
    }
    localbhjq.a(2131365475, this.jdField_a_of_type_AndroidContentContext.getString(2131690756), 2130838986);
    e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    return localbhjq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agop
 * JD-Core Version:    0.7.0.1
 */