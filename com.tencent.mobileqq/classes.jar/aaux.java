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
import com.tencent.mobileqq.app.QQAppInterface;
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

public class aaux
  extends agkm
  implements aasl
{
  public aaux(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
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
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevicePttItemBuilder", 2, "getBubbleView fileStatus");
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    agkp localagkp = (agkp)paramaezf;
    if (!FileUtils.fileExistsAndNotEmpty(localMessageForPtt.url)) {
      a(localagkp, localMessageForPtt);
    }
    paramChatMessage = b(paramChatMessage, paramaezf, paramView, paramBaseChatItemLayout, paramafce);
    ((aavk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(49)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public void a(aezf paramaezf, View paramView, ChatMessage paramChatMessage, apee paramapee)
  {
    agkp localagkp = (agkp)paramaezf;
    if ((localagkp == null) || (paramapee == null)) {}
    for (;;)
    {
      return;
      if ((paramapee.jdField_a_of_type_Int == 0) || (!paramapee.a()))
      {
        paramaezf = paramView.getResources();
        if (paramChatMessage.isSend()) {}
        for (paramaezf = paramaezf.getColorStateList(2131167035);; paramaezf = paramaezf.getColorStateList(2131167031))
        {
          if ((localagkp.jdField_a_of_type_AndroidWidgetTextView != null) && (paramaezf != null)) {
            localagkp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaezf);
          }
          if ((localagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (paramaezf != null)) {
            localagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramaezf);
          }
          if ((localagkp.b == null) || (paramaezf == null)) {
            break;
          }
          localagkp.b.setTextColor(paramaezf);
          return;
        }
      }
      if (paramapee.jdField_b_of_type_Int == 0)
      {
        localagkp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        if (localagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
          localagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
        }
        if (localagkp.b != null) {
          localagkp.b.setTextColor(-16777216);
        }
      }
      while ((paramapee.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localagkp.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localagkp.jdField_a_of_type_Apee.jdField_a_of_type_Double) == 1))
      {
        float f2 = localagkp.jdField_a_of_type_AndroidWidgetTextView.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        localagkp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        localagkp.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(f1, 0.0F, 0.0F, paramapee.d);
        return;
        localagkp.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramapee.jdField_b_of_type_Int);
        if (localagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
          localagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramapee.jdField_b_of_type_Int);
        }
        if (localagkp.b != null) {
          localagkp.b.setTextColor(paramapee.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  protected void a(agkp paramagkp, MessageForPtt paramMessageForPtt)
  {
    paramagkp = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramagkp instanceof QQAppInterface))
    {
      paramagkp = (QQAppInterface)paramagkp;
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        paramMessageForPtt.fileSize = -1L;
        paramMessageForPtt.extraflag = 32768;
        paramMessageForPtt.serial();
        paramagkp.getMessageFacade().updateMsgContentByUniseq(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new DevicePttItemBuilder.3(this, paramMessageForPtt));
  }
  
  protected void a(agkp paramagkp, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    b(paramagkp, paramMessageForPtt, paramInt, paramBoolean);
    if (paramInt == 2005)
    {
      if (TextUtils.isEmpty(paramMessageForPtt.timeStr))
      {
        paramMessageForPtt.timeStr = agkm.a(paramMessageForPtt.voiceLength);
        if (QLog.isColorLevel()) {
          QLog.d("DevicePttItemBuilder", 2, "voiceLength showPttItem voice:" + paramMessageForPtt.voiceLength);
        }
      }
      paramagkp.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessageForPtt.timeStr);
    }
  }
  
  public void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.getMessage(paramView);
    if (localMessageForPtt == null) {
      return;
    }
    paramView = (agkp)AIOUtils.getHolder(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = bjnw.a(this.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131689947);
      paramView.c(2131690620);
      paramView.a(new aauy(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    bjnw localbjnw = bjnw.a(this.jdField_a_of_type_AndroidContentContext);
    localbjnw.a(2131691429);
    localbjnw.b(2131691428);
    localbjnw.c(2131690620);
    localbjnw.a(new aauz(this, paramView, localMessageForPtt, localbjnw));
    localbjnw.show();
  }
  
  public void a(View paramView, aasm paramaasm)
  {
    int i = 1005;
    MessageForPtt localMessageForPtt = (MessageForPtt)AIOUtils.getMessage(paramView);
    if ((localMessageForPtt == null) || (localMessageForPtt.uniseq != paramaasm.jdField_a_of_type_Long)) {
      return;
    }
    int j = paramaasm.jdField_a_of_type_Int;
    paramView = (agkp)AIOUtils.getHolder(paramView);
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
  
  public bgbb[] a(View paramView)
  {
    paramView = new bgaz();
    acvv.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  protected View b(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    paramBaseChatItemLayout = (agkp)paramaezf;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramaezf = paramView;
    if (paramView == null)
    {
      paramaezf = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131374010);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setId(2131374015);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167031));
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject).setId(2131374011);
      ((RelativeLayout)localObject).addView(paramView);
      ((RelativeLayout)localObject).addView(localTextView);
      paramaezf.addView((View)localObject);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramaezf;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
    }
    paramBaseChatItemLayout.jdField_a_of_type_Afce = paramafce;
    if (paramChatMessage.isSend())
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374015);
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
      return paramaezf;
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374010);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
    }
  }
  
  protected void b(agkp paramagkp, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevicePttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag + ", voiceLength is: " + paramMessageForPtt.voiceLength);
    }
    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject1 = (RelativeLayout.LayoutParams)paramagkp.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    Object localObject2 = null;
    if (paramagkp.c != null)
    {
      paramagkp.c.setVisibility(8);
      paramagkp.c.setOnClickListener(null);
      paramagkp.d.setVisibility(8);
    }
    if (paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null)
    {
      paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(8);
      paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(null);
      paramagkp.e.setVisibility(8);
      paramagkp.f.setVisibility(8);
    }
    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramagkp.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramagkp.jdField_a_of_type_Afce);
    paramagkp.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramagkp.jdField_a_of_type_Afce);
    Object localObject6 = this.jdField_a_of_type_AndroidContentContext.getResources();
    boolean bool2 = a(paramMessageForPtt, paramagkp);
    boolean bool1;
    boolean bool3;
    int i;
    int j;
    if (paramMessageForPtt.voiceChangeFlag != 0)
    {
      bool1 = true;
      bool3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramagkp, paramMessageForPtt);
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
          if (this.jdField_a_of_type_Bcms.a(paramMessageForPtt)) {
            j = 4;
          }
        }
        switch (j)
        {
        case 2: 
        case 3: 
        default: 
          paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
          if (paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) {
            paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          }
          label522:
          if (bool2)
          {
            paramMessageForPtt = (ajyg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245);
            if (paramMessageForPtt == null) {
              break label3242;
            }
            paramMessageForPtt = paramMessageForPtt.a("voice_pwd", amtj.a(2131702345), new String[] { "lowTipStr" });
            label569:
            paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, paramMessageForPtt, null);
          }
          if (AppSetting.c)
          {
            paramMessageForPtt = amtj.a(2131702347);
            if (i == 0) {
              break label3252;
            }
            paramagkp.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject1 + amtj.a(2131702349) + amtj.a(2131702348));
            label641:
            if (paramagkp.jdField_a_of_type_JavaLangStringBuilder != null)
            {
              paramagkp.jdField_a_of_type_JavaLangStringBuilder.append("发送了语音.").append((String)localObject1);
              if (localObject2 != null) {
                paramagkp.jdField_a_of_type_JavaLangStringBuilder.append(" ").append((String)localObject2);
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
      paramagkp.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramagkp.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(10.0F, (Resources)localObject6), BaseChatItemLayout.m, AIOUtils.dp2px(10.0F, (Resources)localObject6), BaseChatItemLayout.n);
      if (paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      a(paramagkp, bool3, bool1, paramMessageForPtt.isSend());
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      a(paramMessageForPtt, bool1, paramagkp);
      localObject1 = "";
      paramInt = 1;
      i = j;
      break label431;
      paramagkp.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramagkp.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramagkp.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramagkp.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(40.0F, (Resources)localObject6), BaseChatItemLayout.m, AIOUtils.dp2px(40.0F, (Resources)localObject6), BaseChatItemLayout.n);
      if (paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
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
      paramagkp.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramagkp.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramagkp.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramagkp.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.dp2px(10.0F, (Resources)localObject6), BaseChatItemLayout.m, AIOUtils.dp2px(10.0F, (Resources)localObject6), BaseChatItemLayout.n);
    } while (paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null);
    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    return;
    label1034:
    label1167:
    Object localObject3;
    Object localObject5;
    if (paramMessageForPtt.voiceLength > agkm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt")) {
      if (paramMessageForPtt.longPttVipFlag == 1)
      {
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("[v] QQ会员专享长语音");
          localObject1 = ((Resources)localObject6).getDrawable(2130840400);
          ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
          localObject1 = new bhfp((Drawable)localObject1, 1).a(0.05F);
          this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject1, 0, 3, 17);
        }
        paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
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
      paramagkp.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      a(paramagkp, bool3, bool1, paramMessageForPtt.isSend());
      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramagkp.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      a(paramMessageForPtt, paramBoolean, bool3, bool1, paramagkp);
      if (paramMessageForPtt.isSend()) {
        if (paramMessageForPtt.mRobotFlag == 1)
        {
          localObject3 = ((bfdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
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
          paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
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
              m = ((Resources)localObject6).getDrawable(2130844725).getIntrinsicHeight();
              i1 = AIOUtils.dp2px(1.0F, (Resources)localObject6);
              if (j == 1)
              {
                m = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, null, null, 0);
                if (paramMessageForPtt.isSend())
                {
                  paramagkp.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
                  localObject3 = paramagkp.jdField_a_of_type_AndroidWidgetTextView;
                  n = BaseChatItemLayout.m;
                  if (bool3)
                  {
                    j = k;
                    ((TextView)localObject3).setPadding(0, n, j, BaseChatItemLayout.n);
                    localObject3 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, bool1, m + k, paramagkp);
                    if (paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null) {
                      break label3122;
                    }
                    localObject5 = (RelativeLayout.LayoutParams)paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject5).width = (localObject3[0] + localObject3[1] + localObject3[2]);
                    ((RelativeLayout.LayoutParams)localObject5).height = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, paramagkp);
                    if (QLog.isColorLevel()) {
                      QLog.d("DevicePttItemBuilder", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + ((RelativeLayout.LayoutParams)localObject5).width + ", flagTimeContainer.getLeft()=" + paramagkp.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft());
                    }
                    if ((!bool3) || (((RelativeLayout.LayoutParams)localObject5).height <= 0)) {
                      break label3114;
                    }
                    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
                    localObject7 = paramagkp.jdField_a_of_type_Apee.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7);
                    if ((((apef)((Pair)localObject7).first).a != null) && (((apef)((Pair)localObject7).first).a.length > 0))
                    {
                      localObject6 = paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView;
                      localObject7 = (apef)((Pair)localObject7).first;
                      j = localObject3[0];
                      k = ((RelativeLayout.LayoutParams)localObject5).height;
                      m = localObject3[1];
                      n = localObject3[2];
                      if (paramMessageForPtt.isSend()) {
                        break label3097;
                      }
                      bool1 = true;
                      ((VoicePrintUtils.VoicePrintView)localObject6).setBitmap((apef)localObject7, j, k, m, n, bool1);
                      if (!paramBoolean) {
                        break label3103;
                      }
                      paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(false);
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
                      this.b = new SpannableString(amtj.a(2131702343));
                      localObject1 = ((Resources)localObject6).getDrawable(2130840399);
                      ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
                      localObject1 = new bhfp((Drawable)localObject1, 1).a(0.05F);
                      this.b.setSpan(localObject1, 0, 3, 17);
                    }
                    localObject2 = amtj.a(2131702340);
                    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.b, this);
                    break label1167;
                    localObject1 = "vip";
                    break label1210;
                    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject3, null);
                    break label1442;
                    localObject3 = ((bfdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
                    if (TextUtils.isEmpty((CharSequence)localObject3)) {
                      break label1442;
                    }
                    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject3, null);
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
                paramagkp.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, 0, 0, 0);
                localObject4 = paramagkp.jdField_a_of_type_AndroidWidgetTextView;
                if (bool3) {}
                for (j = k;; j = BaseChatItemLayout.r)
                {
                  ((TextView)localObject4).setPadding(j, BaseChatItemLayout.m, 0, BaseChatItemLayout.n);
                  break;
                }
                if (paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView == null)
                {
                  localObject5 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                  ((ImageView)localObject5).setImageDrawable(new ColorDrawable(838860800));
                  localObject7 = new RelativeLayout.LayoutParams(-1, i1);
                  ((ImageView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject7);
                  ((ImageView)localObject5).setId(2131374031);
                  ETTextView localETTextView = new ETTextView(this.jdField_a_of_type_AndroidContentContext);
                  if (paramMessageForPtt.isSend())
                  {
                    localObject4 = ((Resources)localObject6).getColorStateList(2131167035);
                    if (localObject4 != null) {
                      localETTextView.setTextColor((ColorStateList)localObject4);
                    }
                    localETTextView.setId(2131374030);
                    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
                    localETTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
                    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    localImageView.setLayoutParams(localLayoutParams);
                    localImageView.setImageResource(2130844725);
                    localImageView.setScaleType(ImageView.ScaleType.FIT_END);
                    ((RelativeLayout.LayoutParams)localObject7).addRule(3, 2131374011);
                    ((RelativeLayout.LayoutParams)localObject7).addRule(14);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131374031);
                    localLayoutParams.addRule(3, 2131374031);
                    localLayoutParams.addRule(14);
                    localLayoutParams.addRule(6, 2131374030);
                    localLayoutParams.addRule(8, 2131374030);
                    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject5);
                    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localETTextView);
                    paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
                    paramagkp.e = ((ImageView)localObject5);
                    paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView = localETTextView;
                    paramagkp.f = localImageView;
                    paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(this);
                    paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnTouchListener(paramagkp.jdField_a_of_type_Afce);
                    paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnLongClickListener(paramagkp.jdField_a_of_type_Afce);
                    paramagkp.jdField_a_of_type_Akxy = new akxy();
                    paramagkp.jdField_a_of_type_Akxy.a(paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView);
                    paramagkp.jdField_a_of_type_Akxy.a(paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout);
                    paramagkp.jdField_a_of_type_Akxy.b(paramMessageForPtt);
                    localObject5 = paramMessageForPtt.sttText;
                    localObject4 = localObject5;
                    if (TextUtils.isEmpty((CharSequence)localObject5)) {
                      localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131718622);
                    }
                    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
                      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
                    }
                    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
                    j = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, (String)localObject4, this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), 0);
                    localObject5 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, bool1, j + k, paramagkp);
                    paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem);
                    j = m + AIOUtils.dp2px(22.0F, (Resources)localObject6);
                    if (!paramMessageForPtt.isSend()) {
                      break label2962;
                    }
                    localObject4 = (RelativeLayout.LayoutParams)paramagkp.e.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131374011);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131374011);
                    localObject4 = (RelativeLayout.LayoutParams)paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131374011);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131374011);
                    paramagkp.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
                    paramagkp.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, BaseChatItemLayout.m, BaseChatItemLayout.r, BaseChatItemLayout.n);
                    paramagkp.e.setPadding(k, 0, k, 0);
                    paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(k, BaseChatItemLayout.m, k, j);
                    paramagkp.f.setPadding(0, 0, 0, n);
                  }
                }
                for (;;)
                {
                  localObject6 = paramMessageForPtt.sttText;
                  localObject4 = localObject6;
                  if (TextUtils.isEmpty((CharSequence)localObject6)) {
                    localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131718622);
                  }
                  paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText((CharSequence)localObject4);
                  localObject4 = localObject5;
                  break;
                  localObject4 = ((Resources)localObject6).getColorStateList(2131167031);
                  break label2329;
                  paramagkp.e.setVisibility(0);
                  paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
                  paramagkp.f.setVisibility(0);
                  break label2524;
                  localObject4 = (RelativeLayout.LayoutParams)paramagkp.e.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131374011);
                  ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131374011);
                  localObject4 = (RelativeLayout.LayoutParams)paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131374011);
                  ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131374011);
                  paramagkp.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, 0, 0, 0);
                  paramagkp.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.r, BaseChatItemLayout.m, 0, BaseChatItemLayout.n);
                  paramagkp.e.setPadding(k, 0, k, 0);
                  paramagkp.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setPadding(k, BaseChatItemLayout.m, k, j);
                  paramagkp.f.setPadding(0, 0, 0, n);
                }
                bool1 = false;
                continue;
                paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(true);
              }
              paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
              localObject4 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject4;
            }
          }
          break;
          paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          Object localObject4 = paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c;
          if (paramMessageForPtt.isSendFromLocal()) {}
          for (paramMessageForPtt = amtj.a(2131702344);; paramMessageForPtt = amtj.a(2131702341))
          {
            ((ImageView)localObject4).setContentDescription(paramMessageForPtt);
            break;
          }
          paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839449, null);
          paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          ((Animatable)paramagkp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getDrawable()).start();
          break label522;
          paramMessageForPtt = amtj.a(2131702345);
          break label569;
          paramagkp.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject1 + amtj.a(2131702346));
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
    if ((AppSetting.c) && (i == 2131363354)) {
      paramView.findViewById(2131374011).performClick();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = (agkp)AIOUtils.getHolder(paramView);
      if (localObject1 != null)
      {
        Object localObject2 = (MessageForPtt)((agkp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (i == 2131374011)
        {
          if (c((ChatMessage)localObject2)) {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
          }
          for (;;)
          {
            if (((MessageForPtt)localObject2).istroop == 1008) {
              odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", ((MessageForPtt)localObject2).timeStr, "", false);
            }
            if (((MessageForPtt)localObject2).voiceChangeFlag != 1) {
              break;
            }
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, "" + ((MessageForPtt)localObject2).istroop, "", "", "");
            break;
            if ((localObject2 != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (((MessageForPtt)localObject2).isReady())) {
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694732, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
              } else if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(AIOUtils.getMessage(paramView))) {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694731, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
              }
            }
          }
        }
        if (i == 2131374030)
        {
          if (((MessageForPtt)localObject2).expandStt)
          {
            ((MessageForPtt)localObject2).expandStt = false;
            ((MessageForPtt)localObject2).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, ((MessageForPtt)localObject2).uniseq, ((MessageForPtt)localObject2).msgData);
            a((agkp)localObject1, (MessageForPtt)localObject2, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPtt)localObject2), c((ChatMessage)localObject2));
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if (i == 2131364470)
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
 * Qualified Name:     aaux
 * JD-Core Version:    0.7.0.1
 */