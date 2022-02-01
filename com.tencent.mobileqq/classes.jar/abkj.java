import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.msg.activities.DevicePttItemBuilder.3;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;

public class abkj
  extends ahdc
  implements abhx
{
  public abkj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
  }
  
  protected int a(MessageForPtt paramMessageForPtt)
  {
    int j = 1005;
    if (paramMessageForPtt == null) {
      return 0;
    }
    int i;
    if (paramMessageForPtt.isSendFromLocal()) {
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(AppConstants.SDCARD_ROOT))) {
        if (paramMessageForPtt.fileSize > 0L) {
          i = 1003;
        }
      }
    }
    for (;;)
    {
      return i;
      i = j;
      if (paramMessageForPtt.fileSize != -1L) {
        if (paramMessageForPtt.fileSize == -2L)
        {
          if (a(paramMessageForPtt))
          {
            i = 999;
          }
          else
          {
            paramMessageForPtt.fileSize = -1L;
            i = j;
          }
        }
        else if (paramMessageForPtt.fileSize == -3L)
        {
          i = 1001;
        }
        else
        {
          i = 1001;
          continue;
          i = 1004;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("DevicePttItemBuilder", 2, "handlePttItem recieve friendUin " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin + " url " + paramMessageForPtt.url + " urlAtServer " + paramMessageForPtt.urlAtServer + " uniseq " + paramMessageForPtt.uniseq);
          }
          if (paramMessageForPtt != null)
          {
            if (paramMessageForPtt.url == null)
            {
              i = 2005;
            }
            else if ((paramMessageForPtt.url.startsWith(AppConstants.SDCARD_ROOT)) && (FileUtils.fileExists(paramMessageForPtt.url)))
            {
              i = 2003;
            }
            else if ((paramMessageForPtt.url.startsWith("/data/data")) && (FileUtils.fileExists(paramMessageForPtt.url)))
            {
              i = 2003;
            }
            else if (paramMessageForPtt.fileSize == -1L)
            {
              i = 2005;
            }
            else
            {
              j = 2002;
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("DevicePttItemBuilder", 2, "handlePttItem recieve status " + 2002 + "   url " + paramMessageForPtt.url + " uniseq " + paramMessageForPtt.uniseq);
                i = j;
              }
            }
          }
          else {
            i = 0;
          }
        }
      }
    }
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevicePttItemBuilder", 2, "getBubbleView fileStatus");
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    ahdf localahdf = (ahdf)paramafqr;
    if (!FileUtils.fileExistsAndNotEmpty(localMessageForPtt.url)) {
      a(localahdf, localMessageForPtt);
    }
    paramChatMessage = b(paramChatMessage, paramafqr, paramView, paramBaseChatItemLayout, paramaftk);
    ((abkw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public void a(afqr paramafqr, View paramView, ChatMessage paramChatMessage, aqhi paramaqhi)
  {
    ahdf localahdf = (ahdf)paramafqr;
    if ((localahdf == null) || (paramaqhi == null)) {}
    for (;;)
    {
      return;
      if ((paramaqhi.jdField_a_of_type_Int == 0) || (!paramaqhi.a()))
      {
        paramafqr = paramView.getResources();
        if (paramChatMessage.isSend()) {}
        for (paramafqr = paramafqr.getColorStateList(2131167049);; paramafqr = paramafqr.getColorStateList(2131167045))
        {
          if ((localahdf.jdField_a_of_type_AndroidWidgetTextView != null) && (paramafqr != null)) {
            localahdf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramafqr);
          }
          if ((localahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramafqr != null)) {
            localahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramafqr);
          }
          if ((localahdf.b == null) || (paramafqr == null)) {
            break;
          }
          localahdf.b.setTextColor(paramafqr);
          return;
        }
      }
      if (paramaqhi.jdField_b_of_type_Int == 0)
      {
        localahdf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        if (localahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
          localahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        }
        if (localahdf.b != null) {
          localahdf.b.setTextColor(-16777216);
        }
      }
      while ((paramaqhi.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localahdf.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localahdf.jdField_a_of_type_Aqhi.jdField_a_of_type_Double) == 1))
      {
        float f2 = localahdf.jdField_a_of_type_AndroidWidgetTextView.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        localahdf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        localahdf.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(f1, 0.0F, 0.0F, paramaqhi.d);
        return;
        localahdf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
        if (localahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
          localahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaqhi.jdField_b_of_type_Int);
        }
        if (localahdf.b != null) {
          localahdf.b.setTextColor(paramaqhi.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  protected void a(ahdf paramahdf, MessageForPtt paramMessageForPtt)
  {
    paramahdf = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramahdf instanceof QQAppInterface))
    {
      paramahdf = (QQAppInterface)paramahdf;
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        paramMessageForPtt.fileSize = -1L;
        paramMessageForPtt.extraflag = 32768;
        paramMessageForPtt.serial();
        paramahdf.getMessageFacade().updateMsgContentByUniseq(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new DevicePttItemBuilder.3(this, paramMessageForPtt));
  }
  
  protected void a(ahdf paramahdf, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    b(paramahdf, paramMessageForPtt, paramInt, paramBoolean);
    if (paramInt == 2005)
    {
      if (TextUtils.isEmpty(paramMessageForPtt.timeStr))
      {
        paramMessageForPtt.timeStr = ahdc.a(paramMessageForPtt.voiceLength);
        if (QLog.isColorLevel()) {
          QLog.d("DevicePttItemBuilder", 2, "voiceLength showPttItem voice:" + paramMessageForPtt.voiceLength);
        }
      }
      paramahdf.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessageForPtt.timeStr);
    }
  }
  
  public void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.getMessage(paramView);
    if (localMessageForPtt == null) {
      return;
    }
    paramView = (ahdf)AIOUtils.getHolder(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = bkzi.a(this.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131689976);
      paramView.c(2131690697);
      paramView.a(new abkk(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    bkzi localbkzi = bkzi.a(this.jdField_a_of_type_AndroidContentContext);
    localbkzi.a(2131691514);
    localbkzi.b(2131691513);
    localbkzi.c(2131690697);
    localbkzi.a(new abkl(this, paramView, localMessageForPtt, localbkzi));
    localbkzi.show();
  }
  
  public void a(View paramView, abhy paramabhy)
  {
    int i = 1005;
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.getMessage(paramView);
    if ((localMessageForPtt == null) || (localMessageForPtt.uniseq != paramabhy.jdField_a_of_type_Long)) {
      return;
    }
    int j = paramabhy.jdField_a_of_type_Int;
    paramView = (ahdf)AIOUtils.getHolder(paramView);
    if ((j == 1003) || (j == 2003))
    {
      b();
      i = j;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->handleMessage", 2, "fileStatus:" + i + "|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
      }
      a(paramView, localMessageForPtt, i, c(localMessageForPtt));
      return;
      if ((j == 1005) || (j == 1004))
      {
        this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
        i = j;
      }
      else if (localMessageForPtt.fileSize == -2L)
      {
        i = 999;
      }
      else if (localMessageForPtt.fileSize == -3L)
      {
        i = 1001;
      }
      else if (localMessageForPtt.fileSize != -1L)
      {
        if (j == 2005) {
          localMessageForPtt.fileSize = -4L;
        }
        i = j;
      }
    }
  }
  
  public bhjs[] a(View paramView)
  {
    paramView = new bhjq();
    admh.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  protected View b(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    paramBaseChatItemLayout = (ahdf)paramafqr;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramafqr = paramView;
    if (paramView == null)
    {
      paramafqr = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131374239);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setId(2131374244);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167045));
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject).setId(2131374240);
      ((RelativeLayout)localObject).addView(paramView);
      ((RelativeLayout)localObject).addView(localTextView);
      paramafqr.addView((View)localObject);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramafqr;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
    }
    paramBaseChatItemLayout.jdField_a_of_type_Aftk = paramaftk;
    if (paramChatMessage.isSend())
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374244);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, -1);
    }
    for (;;)
    {
      int j = a(localMessageForPtt);
      int i = j;
      if (j == -1)
      {
        a(paramBaseChatItemLayout, localMessageForPtt);
        i = 2001;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i + " url " + localMessageForPtt.url + " uniseq " + localMessageForPtt.uniseq);
      }
      a(paramBaseChatItemLayout, localMessageForPtt, i, c(localMessageForPtt));
      return paramafqr;
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374239);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
    }
  }
  
  protected void b(ahdf paramahdf, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevicePttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag + ", voiceLength is: " + paramMessageForPtt.voiceLength);
    }
    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject1 = (RelativeLayout.LayoutParams)paramahdf.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    Object localObject2 = null;
    if (paramahdf.c != null)
    {
      paramahdf.c.setVisibility(8);
      paramahdf.c.setOnClickListener(null);
      paramahdf.d.setVisibility(8);
    }
    if (paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
      paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(null);
      paramahdf.e.setVisibility(8);
      paramahdf.f.setVisibility(8);
    }
    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramahdf.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramahdf.jdField_a_of_type_Aftk);
    paramahdf.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramahdf.jdField_a_of_type_Aftk);
    Object localObject6 = this.jdField_a_of_type_AndroidContentContext.getResources();
    boolean bool2 = a(paramMessageForPtt, paramahdf);
    boolean bool1;
    boolean bool3;
    int i;
    int j;
    if (paramMessageForPtt.voiceChangeFlag != 0)
    {
      bool1 = true;
      bool3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramahdf, paramMessageForPtt);
      i = 0;
      j = 0;
      switch (paramInt)
      {
      default: 
        localObject1 = "";
        paramInt = 0;
        i = j;
        label431:
        j = paramInt;
        if (paramMessageForPtt.sttAbility == 1)
        {
          j = paramInt;
          if (this.jdField_a_of_type_Bdts.a(paramMessageForPtt)) {
            j = 4;
          }
        }
        switch (j)
        {
        case 2: 
        case 3: 
        default: 
          paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
          if (paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) {
            paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          }
          label522:
          if (bool2)
          {
            paramMessageForPtt = (aktz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
            if (paramMessageForPtt == null) {
              break label3242;
            }
            paramMessageForPtt = paramMessageForPtt.a("voice_pwd", anvx.a(2131702696), new String[] { "lowTipStr" });
            label569:
            paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, paramMessageForPtt, null);
          }
          if (AppSetting.c)
          {
            paramMessageForPtt = anvx.a(2131702698);
            if (i == 0) {
              break label3252;
            }
            paramahdf.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject1 + anvx.a(2131702700) + anvx.a(2131702699));
            label641:
            if (paramahdf.jdField_a_of_type_JavaLangStringBuilder != null)
            {
              paramahdf.jdField_a_of_type_JavaLangStringBuilder.append("发送了语音.").append((String)localObject1);
              if (localObject2 != null) {
                paramahdf.jdField_a_of_type_JavaLangStringBuilder.append(" ").append((String)localObject2);
              }
            }
          }
          break;
        }
        break;
      }
    }
    do
    {
      return;
      bool1 = false;
      break;
      paramahdf.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramahdf.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(10.0F, (Resources)localObject6), BaseChatItemLayout.m, AIOUtils.dp2px(10.0F, (Resources)localObject6), BaseChatItemLayout.n);
      if (paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      a(paramahdf, bool3, bool1, paramMessageForPtt.isSend());
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      a(paramMessageForPtt, bool1, paramahdf);
      localObject1 = "";
      paramInt = 1;
      i = j;
      break label431;
      paramahdf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramahdf.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramahdf.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramahdf.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(40.0F, (Resources)localObject6), BaseChatItemLayout.m, AIOUtils.dp2px(40.0F, (Resources)localObject6), BaseChatItemLayout.n);
      if (paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
      localObject1 = "";
      paramInt = 0;
      i = j;
      break label431;
      if (QLog.isColorLevel()) {
        QLog.d("DevicePttItemBuilder", 2, "voiceLength showPttItem builder" + paramMessageForPtt.voiceLength);
      }
      if (paramMessageForPtt.voiceLength <= 1) {
        paramMessageForPtt.voiceLength = QQRecorder.a(paramMessageForPtt);
      }
      if (paramMessageForPtt.voiceLength > 0) {
        break label1034;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DevicePttItemBuilder", 2, "get a amr file length = 0 return now");
      }
      paramahdf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramahdf.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramahdf.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramahdf.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(10.0F, (Resources)localObject6), BaseChatItemLayout.m, AIOUtils.dp2px(10.0F, (Resources)localObject6), BaseChatItemLayout.n);
    } while (paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null);
    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    return;
    label1034:
    label1167:
    Object localObject3;
    Object localObject5;
    if (paramMessageForPtt.voiceLength > ahdc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt")) {
      if (paramMessageForPtt.longPttVipFlag == 1)
      {
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("[v] QQ会员专享长语音");
          localObject1 = ((Resources)localObject6).getDrawable(2130840437);
          ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
          localObject1 = new biqh((Drawable)localObject1, 1).a(0.05F);
          this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject1, 0, 3, 17);
        }
        paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
        localObject2 = "QQ会员专享长语音";
        localObject1 = localObject2;
        if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          localObject5 = HttpUtil.getNetWorkTypeByStr();
          if (!VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label2055;
          }
          localObject1 = "svip";
          label1210:
          VasWebviewUtil.reportCommercialDrainage((String)localObject3, "LongVoice", "TailView", "0", 1, 0, 0, (String)localObject5, "", (String)localObject1);
        }
      }
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      if (paramMessageForPtt.voiceLength > a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "ConvertText_MaxPtt")) {
        paramMessageForPtt.sttAbility = 0;
      }
      if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
        paramMessageForPtt.timeStr = a(paramMessageForPtt.voiceLength);
      }
      localObject2 = paramMessageForPtt.timeStr;
      if (QLog.isColorLevel()) {
        QLog.d("DevicePttItemBuilder", 2, "showPttItem, msgText = " + (String)localObject2 + ", message.voiceLength" + paramMessageForPtt.voiceLength);
      }
      paramahdf.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      a(paramahdf, bool3, bool1, paramMessageForPtt.isSend());
      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramahdf.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      a(paramMessageForPtt, paramBoolean, bool3, bool1, paramahdf);
      if (paramMessageForPtt.isSend()) {
        if (paramMessageForPtt.mRobotFlag == 1)
        {
          localObject3 = ((bgls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
        }
        else
        {
          label1442:
          if ((paramInt != 2003) && (paramInt != 1003)) {
            break label2122;
          }
          if ((paramMessageForPtt.isSend()) || (paramMessageForPtt.isReadPtt)) {
            break label3301;
          }
          paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
        }
      }
      label2055:
      label2122:
      label2524:
      label3301:
      for (paramInt = 1;; paramInt = 0)
      {
        int k;
        if ((paramMessageForPtt.sttAbility == 2) && (paramMessageForPtt.voiceChangeFlag != 1) && (paramMessageForPtt.expandStt))
        {
          k = 0;
          j = 2;
          i = paramInt;
          paramInt = k;
        }
        for (;;)
        {
          for (;;)
          {
            k = AIOUtils.dp2px(9.0F, (Resources)localObject6);
            int n = AIOUtils.dp2px(12.0F, (Resources)localObject6);
            try
            {
              m = ((Resources)localObject6).getDrawable(2130844794).getIntrinsicHeight();
              i1 = AIOUtils.dp2px(1.0F, (Resources)localObject6);
              if (j == 1)
              {
                m = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, null, null, 0);
                if (paramMessageForPtt.isSend())
                {
                  paramahdf.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
                  localObject3 = paramahdf.jdField_a_of_type_AndroidWidgetTextView;
                  n = BaseChatItemLayout.m;
                  if (bool3)
                  {
                    j = k;
                    ((TextView)localObject3).setPadding(0, n, j, BaseChatItemLayout.n);
                    localObject3 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, bool1, m + k, paramahdf);
                    if (paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null) {
                      break label3122;
                    }
                    localObject5 = (RelativeLayout.LayoutParams)paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject5).width = (localObject3[0] + localObject3[1] + localObject3[2]);
                    ((RelativeLayout.LayoutParams)localObject5).height = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, paramahdf);
                    if (QLog.isColorLevel()) {
                      QLog.d("DevicePttItemBuilder", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + ((RelativeLayout.LayoutParams)localObject5).width + ", flagTimeContainer.getLeft()=" + paramahdf.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft());
                    }
                    if ((!bool3) || (((RelativeLayout.LayoutParams)localObject5).height <= 0)) {
                      break label3114;
                    }
                    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
                    localObject7 = paramahdf.jdField_a_of_type_Aqhi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7);
                    if ((((aqhj)((Pair)localObject7).first).a != null) && (((aqhj)((Pair)localObject7).first).a.length > 0))
                    {
                      localObject6 = paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView;
                      localObject7 = (aqhj)((Pair)localObject7).first;
                      j = localObject3[0];
                      k = ((RelativeLayout.LayoutParams)localObject5).height;
                      m = localObject3[1];
                      n = localObject3[2];
                      if (paramMessageForPtt.isSend()) {
                        break label3097;
                      }
                      bool1 = true;
                      ((VoicePrintUtils.VoicePrintView)localObject6).setBitmap((aqhj)localObject7, j, k, m, n, bool1);
                      if (!paramBoolean) {
                        break label3103;
                      }
                      paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(false);
                    }
                    localObject3 = localObject1;
                    localObject1 = localObject2;
                    localObject2 = localObject3;
                    break;
                    if (paramMessageForPtt.longPttVipFlag != 2) {
                      break label3306;
                    }
                    if (this.b == null)
                    {
                      this.b = new SpannableString(anvx.a(2131702694));
                      localObject1 = ((Resources)localObject6).getDrawable(2130840436);
                      ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
                      localObject1 = new biqh((Drawable)localObject1, 1).a(0.05F);
                      this.b.setSpan(localObject1, 0, 3, 17);
                    }
                    localObject2 = anvx.a(2131702691);
                    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.b, this);
                    break label1167;
                    localObject1 = "vip";
                    break label1210;
                    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject3, null);
                    break label1442;
                    localObject3 = ((bgls)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
                    if (TextUtils.isEmpty((CharSequence)localObject3)) {
                      break label1442;
                    }
                    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject3, null);
                    break label1442;
                    if ((paramInt == 1005) || (paramInt == 1004))
                    {
                      paramInt = 1;
                      j = 1;
                      continue;
                    }
                    paramInt = 4;
                    j = 1;
                  }
                }
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                int i1;
                Object localObject7;
                int m = AIOUtils.dp2px(24.0F, (Resources)localObject6);
                QLog.e("DevicePttItemBuilder", 1, "", localException);
                continue;
                j = BaseChatItemLayout.r;
                continue;
                paramahdf.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, 0, 0, 0);
                localObject4 = paramahdf.jdField_a_of_type_AndroidWidgetTextView;
                if (bool3) {}
                for (j = k;; j = BaseChatItemLayout.r)
                {
                  ((TextView)localObject4).setPadding(j, BaseChatItemLayout.m, 0, BaseChatItemLayout.n);
                  break;
                }
                if (paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView == null)
                {
                  localObject5 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                  ((ImageView)localObject5).setImageDrawable(new ColorDrawable(838860800));
                  localObject7 = new RelativeLayout.LayoutParams(-1, i1);
                  ((ImageView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject7);
                  ((ImageView)localObject5).setId(2131374260);
                  ETTextView localETTextView = new ETTextView(this.jdField_a_of_type_AndroidContentContext);
                  if (paramMessageForPtt.isSend())
                  {
                    localObject4 = ((Resources)localObject6).getColorStateList(2131167049);
                    if (localObject4 != null) {
                      localETTextView.setTextColor((ColorStateList)localObject4);
                    }
                    localETTextView.setId(2131374259);
                    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
                    localETTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
                    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    localImageView.setLayoutParams(localLayoutParams);
                    localImageView.setImageResource(2130844794);
                    localImageView.setScaleType(ImageView.ScaleType.FIT_END);
                    ((RelativeLayout.LayoutParams)localObject7).addRule(3, 2131374240);
                    ((RelativeLayout.LayoutParams)localObject7).addRule(14);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131374260);
                    localLayoutParams.addRule(3, 2131374260);
                    localLayoutParams.addRule(14);
                    localLayoutParams.addRule(6, 2131374259);
                    localLayoutParams.addRule(8, 2131374259);
                    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject5);
                    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localETTextView);
                    paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
                    paramahdf.e = ((ImageView)localObject5);
                    paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView = localETTextView;
                    paramahdf.f = localImageView;
                    paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this);
                    paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTouchListener(paramahdf.jdField_a_of_type_Aftk);
                    paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnLongClickListener(paramahdf.jdField_a_of_type_Aftk);
                    paramahdf.jdField_a_of_type_Alvu = new alvu();
                    paramahdf.jdField_a_of_type_Alvu.a(paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView);
                    paramahdf.jdField_a_of_type_Alvu.a(paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
                    paramahdf.jdField_a_of_type_Alvu.b(paramMessageForPtt);
                    localObject5 = paramMessageForPtt.sttText;
                    localObject4 = localObject5;
                    if (TextUtils.isEmpty((CharSequence)localObject5)) {
                      localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131719011);
                    }
                    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
                      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
                    }
                    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
                    j = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, (String)localObject4, this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), 0);
                    localObject5 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, bool1, j + k, paramahdf);
                    paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
                    j = m + AIOUtils.dp2px(22.0F, (Resources)localObject6);
                    if (!paramMessageForPtt.isSend()) {
                      break label2962;
                    }
                    localObject4 = (RelativeLayout.LayoutParams)paramahdf.e.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131374240);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131374240);
                    localObject4 = (RelativeLayout.LayoutParams)paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131374240);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131374240);
                    paramahdf.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
                    paramahdf.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, BaseChatItemLayout.m, BaseChatItemLayout.r, BaseChatItemLayout.n);
                    paramahdf.e.setPadding(k, 0, k, 0);
                    paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(k, BaseChatItemLayout.m, k, j);
                    paramahdf.f.setPadding(0, 0, 0, n);
                  }
                }
                for (;;)
                {
                  localObject6 = paramMessageForPtt.sttText;
                  localObject4 = localObject6;
                  if (TextUtils.isEmpty((CharSequence)localObject6)) {
                    localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131719011);
                  }
                  paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText((CharSequence)localObject4);
                  localObject4 = localObject5;
                  break;
                  localObject4 = ((Resources)localObject6).getColorStateList(2131167045);
                  break label2329;
                  paramahdf.e.setVisibility(0);
                  paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
                  paramahdf.f.setVisibility(0);
                  break label2524;
                  localObject4 = (RelativeLayout.LayoutParams)paramahdf.e.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131374240);
                  ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131374240);
                  localObject4 = (RelativeLayout.LayoutParams)paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131374240);
                  ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131374240);
                  paramahdf.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, 0, 0, 0);
                  paramahdf.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.r, BaseChatItemLayout.m, 0, BaseChatItemLayout.n);
                  paramahdf.e.setPadding(k, 0, k, 0);
                  paramahdf.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(k, BaseChatItemLayout.m, k, j);
                  paramahdf.f.setPadding(0, 0, 0, n);
                }
                bool1 = false;
                continue;
                paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(true);
              }
              paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
              localObject4 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject4;
            }
          }
          break;
          paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          Object localObject4 = paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c;
          if (paramMessageForPtt.isSendFromLocal()) {}
          for (paramMessageForPtt = anvx.a(2131702695);; paramMessageForPtt = anvx.a(2131702692))
          {
            ((ImageView)localObject4).setContentDescription(paramMessageForPtt);
            break;
          }
          paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839470, null);
          paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          ((Animatable)paramahdf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getDrawable()).start();
          break label522;
          paramMessageForPtt = anvx.a(2131702696);
          break label569;
          paramahdf.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject1 + anvx.a(2131702697));
          break label641;
          i = paramInt;
          paramInt = 0;
          j = 1;
        }
      }
      label2329:
      label3097:
      label3103:
      label3114:
      label3122:
      label3252:
      label3306:
      localObject2 = null;
      label2962:
      label3242:
      break label1167;
    }
  }
  
  public void b(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.getMessage(paramView);
    if (localChatMessage == null) {}
    do
    {
      do
      {
        return;
      } while (localChatMessage.istroop != 9501);
      if (localChatMessage.isSendFromLocal())
      {
        super.b(paramView);
        return;
      }
    } while (!"device_groupchat".equals(localChatMessage.extStr));
    super.b(paramView);
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.isUserOperatedInAIO = true;
    int i = paramView.getId();
    if ((AppSetting.c) && (i == 2131363423)) {
      paramView.findViewById(2131374240).performClick();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = (ahdf)AIOUtils.getHolder(paramView);
      if (localObject1 != null)
      {
        Object localObject2 = (MessageForPtt)((ahdf)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (i == 2131374240)
        {
          if (c((ChatMessage)localObject2)) {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
          }
          for (;;)
          {
            if (((MessageForPtt)localObject2).istroop == 1008) {
              olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", ((MessageForPtt)localObject2).timeStr, "", false);
            }
            if (((MessageForPtt)localObject2).voiceChangeFlag != 1) {
              break;
            }
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, "" + ((MessageForPtt)localObject2).istroop, "", "", "");
            break;
            if ((localObject2 != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (((MessageForPtt)localObject2).isReady())) {
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694935, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
              } else if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.getMessage(paramView))) {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694934, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
              }
            }
          }
        }
        if (i == 2131374259)
        {
          if (((MessageForPtt)localObject2).expandStt)
          {
            ((MessageForPtt)localObject2).expandStt = false;
            ((MessageForPtt)localObject2).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, ((MessageForPtt)localObject2).uniseq, ((MessageForPtt)localObject2).msgData);
            a((ahdf)localObject1, (MessageForPtt)localObject2, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPtt)localObject2), c((ChatMessage)localObject2));
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if (i == 2131364551)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            String str = HttpUtil.getNetWorkTypeByStr();
            if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
            for (localObject1 = "svip";; localObject1 = "vip")
            {
              VasWebviewUtil.reportCommercialDrainage((String)localObject2, "LongVoice", "TailClick", "0", 1, 0, 0, str, "", (String)localObject1);
              localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
              ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              ((Intent)localObject1).putExtra("url", "https://m.vip.qq.com/freedom/xhycyy.html?_nav_alpha=0");
              this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
              break;
            }
          }
          super.onClick(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abkj
 * JD-Core Version:    0.7.0.1
 */