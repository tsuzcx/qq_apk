import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatPanel;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class agpn
  extends BaseBubbleBuilder
{
  private static final int c = BaseChatItemLayout.h;
  private static final int d = BaseChatItemLayout.i;
  private static final int e;
  protected View.OnClickListener a;
  
  static
  {
    jdField_e_of_type_Int = BaseChatItemLayout.k;
  }
  
  public agpn(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new agpq(this);
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    int k = paramString.length();
    int i = 0;
    if (i < k)
    {
      int j = i;
      if ('\024' == paramString.charAt(i))
      {
        j = i;
        if (i + 1 < k)
        {
          j = i;
          if ('ÿ' == paramString.charAt(i + 1))
          {
            j = i;
            if (i + 2 < k)
            {
              if (!paramBoolean) {
                break label116;
              }
              if (paramString.charAt(i + 2) == '\024') {
                paramString.setCharAt(i + 2, 'ý');
              }
            }
          }
        }
      }
      for (;;)
      {
        j = i + 4;
        i = j + 1;
        break;
        label116:
        if (paramString.charAt(i + 2) == 'ý') {
          paramString.setCharAt(i + 2, '\024');
        }
      }
    }
    return paramString.toString();
  }
  
  protected static final String[] a(String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(paramString1)) {
        break label47;
      }
    }
    label47:
    for (int i = -1;; i = paramString1.indexOf("://"))
    {
      if (i != -1) {
        break label57;
      }
      arrayOfString[0] = paramString1;
      return arrayOfString;
      paramString1 = paramString2;
      break;
    }
    label57:
    arrayOfString[0] = paramString1.substring(0, i);
    arrayOfString[1] = paramString1.substring(i + 3);
    return arrayOfString;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqr a()
  {
    return new agpt();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaftk);
    paramViewGroup = (BaseChatItemLayout)paramView;
    paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
    paramChatMessage = (RelativeLayout)paramViewGroup.findViewById(2131378137);
    "com.tencent.mobileqq".equals(this.jdField_a_of_type_AndroidContentContext.getPackageName());
    paramaftk = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a;
    if (paramChatMessage != null) {
      paramViewGroup.removeView(paramChatMessage);
    }
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "ArkFlashChatItemBubbleBuilder getBubbleView");
    }
    paramBaseChatItemLayout = (MessageForArkFlashChat)paramChatMessage;
    agpt localagpt;
    Object localObject;
    boolean bool;
    label354:
    int i;
    if (paramBaseChatItemLayout.arkContainer == null)
    {
      paramBaseChatItemLayout.arkContainer = new ArkFlashChatContainerWrapper();
      float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity;
      localagpt = (agpt)paramafqr;
      paramafqr = paramView;
      if (paramView == null)
      {
        paramafqr = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558860, null);
        paramView = paramafqr.findViewById(2131362983);
        localObject = (ArkAppLoadLayout)paramafqr.findViewById(2131370436);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ArkAppLoadLayout)localObject).getLayoutParams();
        localLayoutParams.width = ((int)FlashChatPanel.a());
        localLayoutParams.height = ((int)FlashChatPanel.b());
        ((ArkAppLoadLayout)localObject).setLayoutParams(localLayoutParams);
        localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
        localLayoutParams.width = ((int)FlashChatPanel.a());
        localLayoutParams.height = ((int)FlashChatPanel.b());
        paramView.setLayoutParams(localLayoutParams);
        localagpt.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)localObject);
        localagpt.d = localagpt.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.findViewById(2131366837);
        localagpt.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localagpt.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.findViewById(2131366838));
        localagpt.c = localagpt.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.findViewById(2131370446);
        localagpt.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramafqr.findViewById(2131362957));
        localagpt.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)paramafqr.findViewById(2131377397));
        localagpt.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
        localagpt.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(false);
        localagpt.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(0);
        paramView = (RelativeLayout.LayoutParams)localagpt.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.getLayoutParams();
        paramView.width = ((int)FlashChatPanel.a());
        paramView.height = ((int)FlashChatPanel.b());
        paramView.leftMargin = 0;
        localagpt.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setLayoutParams(paramView);
      }
      paramChatMessage.isSend();
      paramView = localagpt.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      paramView.setClipRadius(16.0F);
      paramView.setBorderType(1);
      if (paramChatMessage.isSend()) {
        break label890;
      }
      bool = true;
      paramView.setAlignLeft(bool);
      paramChatMessage = localagpt.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      if (paramBaseChatItemLayout.uniseq != ((QQMessageFacade.Message)localObject).uniseq) {
        break label896;
      }
      i = 1;
      label409:
      bool = false;
      localObject = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
      if (i != 0)
      {
        if ((paramBaseChatItemLayout.isread) && (!((FlashChatManager)localObject).a(paramBaseChatItemLayout))) {
          break label902;
        }
        bool = true;
      }
      label453:
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "testMyStopAnimLogic " + bool + " " + paramBaseChatItemLayout.uniseq + " " + paramBaseChatItemLayout.getSummery() + " " + paramBaseChatItemLayout.isread + ", " + ((FlashChatManager)localObject).a(paramBaseChatItemLayout));
      }
      if (!bool) {
        break label908;
      }
      ((FlashChatManager)localObject).b(paramBaseChatItemLayout);
      ((FlashChatManager)localObject).a(null);
    }
    label562:
    label946:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "testMyStopAnimLogic " + bool + " " + paramBaseChatItemLayout.uniseq + " " + paramBaseChatItemLayout.getSummery());
      }
      long l = paramBaseChatItemLayout.uniseq;
      paramBaseChatItemLayout.arkContainer.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout.ark_app_message.appName, paramBaseChatItemLayout.ark_app_message.appView, paramBaseChatItemLayout.ark_app_message.appMinVersion, paramBaseChatItemLayout.ark_app_message.appResId, paramBaseChatItemLayout.ark_app_message.getMeta(l, false), ArkAppCenterUtil.getDensity(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, FlashChatPanel.a(), FlashChatPanel.b(), FlashChatPanel.a(), FlashChatPanel.b(), paramBaseChatItemLayout);
      paramBaseChatItemLayout.setupSendLoading(localagpt.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar);
      if (bool) {
        paramView.setCallback(new agpo(this, paramBaseChatItemLayout));
      }
      for (;;)
      {
        paramView.a(paramBaseChatItemLayout.arkContainer, paramChatMessage);
        localagpt.b = paramBaseChatItemLayout.msg;
        paramView.setTag(localagpt);
        paramView.setOnTouchListener(paramaftk);
        paramView.setOnLongClickListener(paramaftk);
        if (paramChatMessage != null)
        {
          paramChatMessage.setOnTouchListener(paramaftk);
          paramChatMessage.setOnLongClickListener(paramaftk);
        }
        localagpt.jdField_a_of_type_AndroidViewView = paramafqr;
        localagpt.d.setVisibility(8);
        localagpt.c.setVisibility(0);
        localagpt.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(8);
        localagpt.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.b();
        localagpt.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setBkgColorNormal(ArkAppLoadLayout.b);
        if (jdField_e_of_type_Boolean) {
          paramView.setContentDescription(paramBaseChatItemLayout.ark_app_message.promptText);
        }
        return paramafqr;
        if (!paramBaseChatItemLayout.arkContainer.a()) {
          break;
        }
        paramBaseChatItemLayout.arkContainer.reinitArkContainer();
        break;
        label890:
        bool = false;
        break label354;
        i = 0;
        break label409;
        bool = false;
        break label453;
        if ((i == 0) || (!((FlashChatManager)localObject).b(paramBaseChatItemLayout))) {
          break label946;
        }
        bool = true;
        break label562;
        paramView.setCallback(new agpp(this, paramBaseChatItemLayout));
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return "";
    }
    if ((paramChatMessage instanceof MessageForArkFlashChat))
    {
      paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
      return anvx.a(2131700180) + paramChatMessage.ark_app_message.promptText;
    }
    return anvx.a(2131700179) + paramChatMessage.msg;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131365307: 
    case 2131366456: 
    case 2131367213: 
      do
      {
        do
        {
          do
          {
            return;
          } while (paramChatMessage.msg == null);
          try
          {
            ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(paramChatMessage.msg);
            return;
          }
          catch (Exception paramContext) {}
        } while (!QLog.isColorLevel());
        QLog.e("ChatItemBuilder", 2, paramContext.toString());
        return;
        h(paramChatMessage);
        return;
        paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
      } while ((paramChatMessage == null) || (paramChatMessage.ark_app_message == null));
      paramContext = new Bundle();
      paramContext.putInt("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      paramContext.putString("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      paramContext.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin);
      paramContext.putInt("forward_type", 33);
      paramContext.putString("forward_flashchat_rawcontent", paramChatMessage.ark_app_message.toAppXml());
      paramContext.putString("forward_ark_app_prompt", paramChatMessage.ark_app_message.getSummery());
      paramContext.putInt("selection_mode", this.b);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      aupt.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      return;
    case 2131365475: 
      admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131371641: 
      super.a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForArkFlashChat)AIOUtils.getMessage(paramView);
    if (paramView == null) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689976);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689977);
    } while (!paramView.isSendFromLocal());
    bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new agpr(this, paramView), new agps(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296389);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(jdField_e_of_type_Int, c, i, d);
      return;
    }
    paramView.setPadding(i, c, jdField_e_of_type_Int, d);
  }
  
  public boolean a(String paramString1, String paramString2, MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "SourceClickHandler clickWebMsg  url = " + paramString1);
    }
    if ((TextUtils.isEmpty(paramString1)) || ((!paramString1.startsWith("http://")) && (!paramString1.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("title", paramString2);
    localIntent.putExtra("url", paramString1);
    uuc.a(paramMessageForArkFlashChat, localIntent, paramString1);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    bdla.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "SourceClickHandler clickAppMsg url = " + paramString1 + ", actionData = " + paramString2 + ", actionDataA = " + paramString3);
    }
    paramString1 = a(paramString2, paramString3);
    paramString2 = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
    try
    {
      if (paramString2.getPackageInfo(paramString1[0], 1) != null)
      {
        paramString2 = paramString2.getLaunchIntentForPackage(paramString1[0]);
        if (paramString2 == null) {
          return false;
        }
        paramString2.addFlags(67108864);
        if (!TextUtils.isEmpty(paramString1[1])) {
          paramString2.setData(Uri.parse(paramString1[1]));
        }
        try
        {
          ((aodv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.STARTAPPCHECK_HANDLER)).b(paramString1[0].trim(), this.jdField_a_of_type_AndroidContentContext, paramString2);
          return true;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
            }
            this.jdField_a_of_type_AndroidContentContext.startActivity(paramString2);
          }
        }
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, paramString1.getMessage());
      }
    }
  }
  
  public bhjs[] a(View paramView)
  {
    bhjq localbhjq = new bhjq();
    paramView = (afrk)AIOUtils.getHolder(paramView);
    localbhjq.a(2131365307, anvx.a(2131700178), 2130838982);
    if (paramView != null)
    {
      MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)paramView.a;
      if ((localMessageForArkFlashChat != null) && (localMessageForArkFlashChat.ark_app_message != null))
      {
        localbhjq.a(2131367213, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838991);
        if (localMessageForArkFlashChat.isMultiMsg) {
          return localbhjq.a();
        }
        if (localMessageForArkFlashChat.istroop == 0) {
          a(paramView.a, localbhjq);
        }
        if ((localMessageForArkFlashChat.isSend()) && (localMessageForArkFlashChat.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(localMessageForArkFlashChat))) {
          a(localbhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, localMessageForArkFlashChat);
        }
        a(localbhjq, localMessageForArkFlashChat);
        super.c(localbhjq, this.jdField_a_of_type_AndroidContentContext);
        super.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, localMessageForArkFlashChat);
        super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
        return localbhjq.a();
      }
    }
    admh.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    super.c(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    return localbhjq.a();
  }
  
  protected void h(ChatMessage paramChatMessage)
  {
    paramChatMessage.msg = a(paramChatMessage.msg, true);
    bmad.a(null, paramChatMessage.msg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agpn
 * JD-Core Version:    0.7.0.1
 */