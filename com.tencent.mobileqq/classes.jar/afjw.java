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
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatPanel;
import com.tencent.qphone.base.util.QLog;

public class afjw
  extends BaseBubbleBuilder
{
  private static final int c = BaseChatItemLayout.g;
  private static final int d = BaseChatItemLayout.h;
  private static final int e;
  protected View.OnClickListener a;
  
  static
  {
    jdField_e_of_type_Int = BaseChatItemLayout.j;
  }
  
  public afjw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afjz(this);
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
  
  public aeqi a()
  {
    return new afkc();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aetk paramaetk)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaetk);
    paramViewGroup = (BaseChatItemLayout)paramView;
    paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
    paramChatMessage = (RelativeLayout)paramViewGroup.findViewById(2131377120);
    "com.tencent.mobileqq".equals(this.jdField_a_of_type_AndroidContentContext.getPackageName());
    paramaetk = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a;
    if (paramChatMessage != null) {
      paramViewGroup.removeView(paramChatMessage);
    }
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "ArkFlashChatItemBubbleBuilder getBubbleView");
    }
    paramBaseChatItemLayout = (MessageForArkFlashChat)paramChatMessage;
    afkc localafkc;
    Object localObject;
    boolean bool;
    label354:
    int i;
    if (paramBaseChatItemLayout.arkContainer == null)
    {
      paramBaseChatItemLayout.arkContainer = new ArkFlashChatContainerWrapper();
      float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().scaledDensity;
      localafkc = (afkc)paramaeqi;
      paramaeqi = paramView;
      if (paramView == null)
      {
        paramaeqi = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558763, null);
        paramView = paramaeqi.findViewById(2131362821);
        localObject = (ArkAppLoadLayout)paramaeqi.findViewById(2131369757);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ArkAppLoadLayout)localObject).getLayoutParams();
        localLayoutParams.width = ((int)FlashChatPanel.a());
        localLayoutParams.height = ((int)FlashChatPanel.b());
        ((ArkAppLoadLayout)localObject).setLayoutParams(localLayoutParams);
        localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
        localLayoutParams.width = ((int)FlashChatPanel.a());
        localLayoutParams.height = ((int)FlashChatPanel.b());
        paramView.setLayoutParams(localLayoutParams);
        localafkc.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)localObject);
        localafkc.d = localafkc.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.findViewById(2131366389);
        localafkc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localafkc.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.findViewById(2131366390));
        localafkc.c = localafkc.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.findViewById(2131369767);
        localafkc.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramaeqi.findViewById(2131362798));
        localafkc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)paramaeqi.findViewById(2131376431));
        localafkc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
        localafkc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(false);
        localafkc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(0);
        paramView = (RelativeLayout.LayoutParams)localafkc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.getLayoutParams();
        paramView.width = ((int)FlashChatPanel.a());
        paramView.height = ((int)FlashChatPanel.b());
        paramView.leftMargin = 0;
        localafkc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setLayoutParams(paramView);
      }
      paramChatMessage.isSend();
      paramView = localafkc.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
      paramView.setClipRadius(16.0F);
      paramView.setBorderType(1);
      if (paramChatMessage.isSend()) {
        break label890;
      }
      bool = true;
      paramView.setAlignLeft(bool);
      paramChatMessage = localafkc.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (paramBaseChatItemLayout.uniseq != ((QQMessageFacade.Message)localObject).uniseq) {
        break label896;
      }
      i = 1;
      label409:
      bool = false;
      localObject = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217);
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
      paramBaseChatItemLayout.arkContainer.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout.ark_app_message.appName, paramBaseChatItemLayout.ark_app_message.appView, paramBaseChatItemLayout.ark_app_message.appMinVersion, paramBaseChatItemLayout.ark_app_message.appResId, paramBaseChatItemLayout.ark_app_message.getMeta(l, false), anob.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, FlashChatPanel.a(), FlashChatPanel.b(), FlashChatPanel.a(), FlashChatPanel.b(), paramBaseChatItemLayout);
      paramBaseChatItemLayout.setupSendLoading(localafkc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar);
      if (bool) {
        paramView.setCallback(new afjx(this, paramBaseChatItemLayout));
      }
      for (;;)
      {
        paramView.a(paramBaseChatItemLayout.arkContainer, paramChatMessage);
        localafkc.b = paramBaseChatItemLayout.msg;
        paramView.setTag(localafkc);
        paramView.setOnTouchListener(paramaetk);
        paramView.setOnLongClickListener(paramaetk);
        if (paramChatMessage != null)
        {
          paramChatMessage.setOnTouchListener(paramaetk);
          paramChatMessage.setOnLongClickListener(paramaetk);
        }
        localafkc.jdField_a_of_type_AndroidViewView = paramaeqi;
        localafkc.d.setVisibility(8);
        localafkc.c.setVisibility(0);
        localafkc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(8);
        localafkc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.b();
        localafkc.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setBkgColorNormal(ArkAppLoadLayout.b);
        if (jdField_e_of_type_Boolean) {
          paramView.setContentDescription(paramBaseChatItemLayout.ark_app_message.promptText);
        }
        return paramaeqi;
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
        paramView.setCallback(new afjy(this, paramBaseChatItemLayout));
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
      return alud.a(2131701062) + paramChatMessage.ark_app_message.promptText;
    }
    return alud.a(2131701061) + paramChatMessage.msg;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131364912: 
    case 2131366017: 
    case 2131366760: 
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
        g(paramChatMessage);
        return;
        paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
      } while ((paramChatMessage == null) || (paramChatMessage.ark_app_message == null));
      paramContext = new Bundle();
      paramContext.putInt("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramContext.putString("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramContext.putString("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      paramContext.putInt("forward_type", 33);
      paramContext.putString("forward_flashchat_rawcontent", paramChatMessage.ark_app_message.toAppXml());
      paramContext.putString("forward_ark_app_prompt", paramChatMessage.ark_app_message.getSummery());
      paramContext.putInt("selection_mode", this.b);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      aryv.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      return;
    case 2131365071: 
      acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    case 2131370818: 
      super.a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (MessageForArkFlashChat)aepi.a(paramView);
    if (paramView == null) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690042);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131690043);
    } while (!paramView.isSendFromLocal());
    bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new afka(this, paramView), new afkb(this)).show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296298);
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
    syb.a(paramMessageForArkFlashChat, localIntent, paramString1);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    azqs.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
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
          ((amcw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(23)).b(paramString1[0].trim(), this.jdField_a_of_type_AndroidContentContext, paramString2);
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
  
  public bdpk[] a(View paramView)
  {
    bdpi localbdpi = new bdpi();
    paramView = (aeqz)aepi.a(paramView);
    localbdpi.a(2131364912, alud.a(2131701060), 2130838669);
    if (paramView != null)
    {
      MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)paramView.a;
      if ((localMessageForArkFlashChat != null) && (localMessageForArkFlashChat.ark_app_message != null))
      {
        localbdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
        if (localMessageForArkFlashChat.isMultiMsg) {
          return localbdpi.a();
        }
        if (localMessageForArkFlashChat.istroop == 0) {
          a(paramView.a, localbdpi);
        }
        if ((localMessageForArkFlashChat.isSend()) && (localMessageForArkFlashChat.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForArkFlashChat))) {
          a(localbdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForArkFlashChat);
        }
        a(localbdpi, localMessageForArkFlashChat);
        super.c(localbdpi, this.jdField_a_of_type_AndroidContentContext);
        super.e(localbdpi, this.jdField_a_of_type_AndroidContentContext);
        return localbdpi.a();
      }
    }
    acjm.a(localbdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.c(localbdpi, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbdpi, this.jdField_a_of_type_AndroidContentContext);
    return localbdpi.a();
  }
  
  protected void g(ChatMessage paramChatMessage)
  {
    paramChatMessage.msg = a(paramChatMessage.msg, true);
    biva.a(null, paramChatMessage.msg).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjw
 * JD-Core Version:    0.7.0.1
 */