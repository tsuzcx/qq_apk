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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.msg.activities.DevicePttItemBuilder.3;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils;
import com.tencent.mobileqq.activity.aio.anim.VoicePrintUtils.VoicePrintView;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;

public class abyo
  extends ahnz
  implements abwc
{
  public abyo(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
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
      if ((paramMessageForPtt.url != null) && (paramMessageForPtt.url.startsWith(antf.aZ))) {
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
            QLog.d("DevicePttItemBuilder", 2, "handlePttItem recieve friendUin " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + " url " + paramMessageForPtt.url + " urlAtServer " + paramMessageForPtt.urlAtServer + " uniseq " + paramMessageForPtt.uniseq);
          }
          if (paramMessageForPtt != null)
          {
            if (paramMessageForPtt.url == null)
            {
              i = 2005;
            }
            else if ((paramMessageForPtt.url.startsWith(antf.aZ)) && (bhmi.a(paramMessageForPtt.url)))
            {
              i = 2003;
            }
            else if ((paramMessageForPtt.url.startsWith("/data/data")) && (bhmi.a(paramMessageForPtt.url)))
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
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevicePttItemBuilder", 2, "getBubbleView fileStatus");
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    ahoc localahoc = (ahoc)paramaggl;
    if (!bhmi.b(localMessageForPtt.url)) {
      a(localahoc, localMessageForPtt);
    }
    paramChatMessage = b(paramChatMessage, paramaggl, paramView, paramBaseChatItemLayout, paramagjk);
    ((abzb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public void a(aggl paramaggl, View paramView, ChatMessage paramChatMessage, aqkt paramaqkt)
  {
    ahoc localahoc = (ahoc)paramaggl;
    if (localahoc == null) {}
    for (;;)
    {
      return;
      if ((paramaqkt.jdField_a_of_type_Int == 0) || (!paramaqkt.a()))
      {
        paramaggl = paramView.getResources();
        if (paramChatMessage.isSend()) {}
        for (paramaggl = paramaggl.getColorStateList(2131167013);; paramaggl = paramaggl.getColorStateList(2131167009))
        {
          if ((localahoc.jdField_a_of_type_AndroidWidgetTextView != null) && (paramaggl != null)) {
            localahoc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaggl);
          }
          if ((localahoc.b == null) || (paramaggl == null)) {
            break;
          }
          localahoc.b.setTextColor(paramaggl);
          return;
        }
      }
      if (paramaqkt.jdField_b_of_type_Int == 0)
      {
        localahoc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        if (localahoc.b != null) {
          localahoc.b.setTextColor(-16777216);
        }
      }
      while ((paramaqkt.jdField_b_of_type_Boolean) && (((ChatBackgroundManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(63)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localahoc.jdField_a_of_type_AndroidWidgetTextView.getCurrentTextColor(), 10000.0D * localahoc.jdField_a_of_type_Aqkt.jdField_a_of_type_Double) == 1))
      {
        float f2 = localahoc.jdField_a_of_type_AndroidWidgetTextView.getTextSize() * 3.0F / 16.0F;
        float f1 = f2;
        if (f2 > 25.0F) {
          f1 = 25.0F;
        }
        localahoc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        localahoc.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(f1, 0.0F, 0.0F, paramaqkt.d);
        return;
        localahoc.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramaqkt.jdField_b_of_type_Int);
        if (localahoc.b != null) {
          localahoc.b.setTextColor(paramaqkt.jdField_b_of_type_Int);
        }
      }
    }
  }
  
  protected void a(ahoc paramahoc, MessageForPtt paramMessageForPtt)
  {
    paramahoc = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramahoc instanceof QQAppInterface))
    {
      paramahoc = (QQAppInterface)paramahoc;
      if (!bhnv.d(BaseApplication.getContext()))
      {
        paramMessageForPtt.fileSize = -1L;
        paramMessageForPtt.extraflag = 32768;
        paramMessageForPtt.serial();
        paramahoc.a().a(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new DevicePttItemBuilder.3(this, paramMessageForPtt));
  }
  
  protected void a(ahoc paramahoc, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    b(paramahoc, paramMessageForPtt, paramInt, paramBoolean);
    if (paramInt == 2005)
    {
      if (TextUtils.isEmpty(paramMessageForPtt.timeStr))
      {
        paramMessageForPtt.timeStr = ahnz.a(paramMessageForPtt.voiceLength);
        if (QLog.isColorLevel()) {
          QLog.d("DevicePttItemBuilder", 2, "voiceLength showPttItem voice:" + paramMessageForPtt.voiceLength);
        }
      }
      paramahoc.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessageForPtt.timeStr);
    }
  }
  
  public void a(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)agej.a(paramView);
    if (localMessageForPtt == null) {
      return;
    }
    paramView = (ahoc)agej.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = blir.a(this.jdField_a_of_type_AndroidContentContext);
      paramView.b(2131689933);
      paramView.c(2131690580);
      paramView.a(new abyp(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    blir localblir = blir.a(this.jdField_a_of_type_AndroidContentContext);
    localblir.a(2131691389);
    localblir.b(2131691388);
    localblir.c(2131690580);
    localblir.a(new abyq(this, paramView, localMessageForPtt, localblir));
    localblir.show();
  }
  
  public void a(View paramView, abwd paramabwd)
  {
    int i = 1005;
    MessageForPtt localMessageForPtt = (MessageForPtt)agej.a(paramView);
    if ((localMessageForPtt == null) || (localMessageForPtt.uniseq != paramabwd.jdField_a_of_type_Long)) {
      return;
    }
    int j = paramabwd.jdField_a_of_type_Int;
    paramView = (ahoc)agej.a(paramView);
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
  
  public bhum[] a(View paramView)
  {
    paramView = new bhuk();
    aean.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  protected View b(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    paramBaseChatItemLayout = (ahoc)paramaggl;
    MessageForPtt localMessageForPtt = (MessageForPtt)paramChatMessage;
    paramaggl = paramView;
    if (paramView == null)
    {
      paramaggl = new BreathAnimationLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131374265);
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setId(2131374270);
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167009));
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject).setId(2131374266);
      ((RelativeLayout)localObject).addView(paramView);
      ((RelativeLayout)localObject).addView(localTextView);
      paramaggl.addView((View)localObject);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = paramaggl;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = localTextView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
    }
    paramBaseChatItemLayout.jdField_a_of_type_Agjk = paramagjk;
    if (paramChatMessage.isSend())
    {
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, 2131374270);
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
      return paramaggl;
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(1, 2131374265);
      ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).addRule(1, -1);
    }
  }
  
  protected void b(ahoc paramahoc, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DevicePttItemBuilder", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag + ", voiceLength is: " + paramMessageForPtt.voiceLength);
    }
    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(false, null, null);
    Object localObject1 = (RelativeLayout.LayoutParams)paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, -1);
    Object localObject2 = null;
    if (paramahoc.c != null)
    {
      paramahoc.c.setVisibility(8);
      paramahoc.c.setOnClickListener(null);
      paramahoc.d.setVisibility(8);
    }
    if (paramahoc.b != null)
    {
      paramahoc.b.setVisibility(8);
      paramahoc.b.setOnClickListener(null);
      paramahoc.e.setVisibility(8);
      paramahoc.f.setVisibility(8);
    }
    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramahoc.jdField_a_of_type_Agjk);
    paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramahoc.jdField_a_of_type_Agjk);
    Object localObject6 = this.jdField_a_of_type_AndroidContentContext.getResources();
    boolean bool2 = a(paramMessageForPtt, paramahoc);
    boolean bool1;
    boolean bool3;
    int i;
    int j;
    if (paramMessageForPtt.voiceChangeFlag != 0)
    {
      bool1 = true;
      bool3 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetBaseAdapter, paramahoc, paramMessageForPtt);
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
          if (this.jdField_a_of_type_Bdug.a(paramMessageForPtt)) {
            j = 4;
          }
        }
        switch (j)
        {
        case 2: 
        case 3: 
        default: 
          paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
          if (paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) {
            paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          }
          label522:
          if (bool2)
          {
            paramMessageForPtt = (alao)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245);
            if (paramMessageForPtt == null) {
              break label3197;
            }
            paramMessageForPtt = paramMessageForPtt.a("voice_pwd", anzj.a(2131702110), new String[] { "lowTipStr" });
            label569:
            paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, paramMessageForPtt, null);
          }
          if (AppSetting.c)
          {
            paramMessageForPtt = anzj.a(2131702112);
            if (i == 0) {
              break label3207;
            }
            paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject1 + anzj.a(2131702114) + anzj.a(2131702113));
            label641:
            if (paramahoc.jdField_a_of_type_JavaLangStringBuilder != null)
            {
              paramahoc.jdField_a_of_type_JavaLangStringBuilder.append("发送了语音.").append((String)localObject1);
              if (localObject2 != null) {
                paramahoc.jdField_a_of_type_JavaLangStringBuilder.append(" ").append((String)localObject2);
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
      paramahoc.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramahoc.jdField_a_of_type_AndroidWidgetTextView.setPadding(agej.a(10.0F, (Resources)localObject6), BaseChatItemLayout.m, agej.a(10.0F, (Resources)localObject6), BaseChatItemLayout.n);
      if (paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      a(paramahoc, bool3, bool1, paramMessageForPtt.isSend());
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      a(paramMessageForPtt, bool1, paramahoc);
      localObject1 = "";
      paramInt = 1;
      i = j;
      break label431;
      paramahoc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramahoc.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramahoc.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramahoc.jdField_a_of_type_AndroidWidgetTextView.setPadding(agej.a(40.0F, (Resources)localObject6), BaseChatItemLayout.m, agej.a(40.0F, (Resources)localObject6), BaseChatItemLayout.n);
      if (paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView != null) {
        paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
      }
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
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
      paramahoc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramahoc.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, 0);
      paramahoc.jdField_a_of_type_AndroidWidgetTextView.setText("");
      paramahoc.jdField_a_of_type_AndroidWidgetTextView.setPadding(agej.a(10.0F, (Resources)localObject6), BaseChatItemLayout.m, agej.a(10.0F, (Resources)localObject6), BaseChatItemLayout.n);
    } while (paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null);
    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(8);
    return;
    label1034:
    label1167:
    Object localObject3;
    Object localObject5;
    if (paramMessageForPtt.voiceLength > ahnz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt")) {
      if (paramMessageForPtt.longPttVipFlag == 1)
      {
        if (this.jdField_a_of_type_AndroidTextSpannableString == null)
        {
          this.jdField_a_of_type_AndroidTextSpannableString = new SpannableString("[v] QQ会员专享长语音");
          localObject1 = ((Resources)localObject6).getDrawable(2130840362);
          ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
          localObject1 = new bizo((Drawable)localObject1, 1).a(0.05F);
          this.jdField_a_of_type_AndroidTextSpannableString.setSpan(localObject1, 0, 3, 17);
        }
        paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.jdField_a_of_type_AndroidTextSpannableString, this);
        localObject2 = "QQ会员专享长语音";
        localObject1 = localObject2;
        if (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          localObject5 = nnr.a();
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
      paramahoc.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      a(paramahoc, bool3, bool1, paramMessageForPtt.isSend());
      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
      paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      a(paramMessageForPtt, paramBoolean, bool3, bool1, paramahoc);
      if (paramMessageForPtt.isSend()) {
        if (paramMessageForPtt.mRobotFlag == 1)
        {
          localObject3 = ((bgty)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
        }
        else
        {
          label1442:
          if ((paramInt != 2003) && (paramInt != 1003)) {
            break label2122;
          }
          if ((paramMessageForPtt.isSend()) || (paramMessageForPtt.isReadPtt)) {
            break label3256;
          }
          paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setUnread(true, null, null);
        }
      }
      label2055:
      label2329:
      label3256:
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
            k = agej.a(9.0F, (Resources)localObject6);
            int n = agej.a(12.0F, (Resources)localObject6);
            try
            {
              m = ((Resources)localObject6).getDrawable(2130844849).getIntrinsicHeight();
              i1 = agej.a(1.0F, (Resources)localObject6);
              if (j == 1)
              {
                m = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, null, null, 0);
                if (paramMessageForPtt.isSend())
                {
                  paramahoc.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
                  localObject3 = paramahoc.jdField_a_of_type_AndroidWidgetTextView;
                  n = BaseChatItemLayout.m;
                  if (bool3)
                  {
                    j = k;
                    ((TextView)localObject3).setPadding(0, n, j, BaseChatItemLayout.n);
                    localObject3 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, bool1, m + k, paramahoc);
                    if (paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView == null) {
                      break label3077;
                    }
                    localObject5 = (RelativeLayout.LayoutParams)paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject5).width = (localObject3[0] + localObject3[1] + localObject3[2]);
                    ((RelativeLayout.LayoutParams)localObject5).height = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, paramahoc);
                    if (QLog.isColorLevel()) {
                      QLog.d("DevicePttItemBuilder", 2, "message seq=" + paramMessageForPtt.uniseq + ", VpLp.width=" + ((RelativeLayout.LayoutParams)localObject5).width + ", flagTimeContainer.getLeft()=" + paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.getLeft());
                    }
                    if ((!bool3) || (((RelativeLayout.LayoutParams)localObject5).height <= 0)) {
                      break label3069;
                    }
                    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(0);
                    localObject7 = paramahoc.jdField_a_of_type_Aqkt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 7);
                    if ((((aqku)((Pair)localObject7).first).a != null) && (((aqku)((Pair)localObject7).first).a.length > 0))
                    {
                      localObject6 = paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView;
                      localObject7 = (aqku)((Pair)localObject7).first;
                      j = localObject3[0];
                      k = ((RelativeLayout.LayoutParams)localObject5).height;
                      m = localObject3[1];
                      n = localObject3[2];
                      if (paramMessageForPtt.isSend()) {
                        break label3052;
                      }
                      bool1 = true;
                      ((VoicePrintUtils.VoicePrintView)localObject6).setBitmap((aqku)localObject7, j, k, m, n, bool1);
                      if (!paramBoolean) {
                        break label3058;
                      }
                      paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(false);
                    }
                    localObject3 = localObject1;
                    localObject1 = localObject2;
                    localObject2 = localObject3;
                    break;
                    if (paramMessageForPtt.longPttVipFlag != 2) {
                      break label3261;
                    }
                    if (this.b == null)
                    {
                      this.b = new SpannableString(anzj.a(2131702108));
                      localObject1 = ((Resources)localObject6).getDrawable(2130840361);
                      ((Drawable)localObject1).setBounds(0, -5, ((Drawable)localObject1).getIntrinsicWidth() * 4 / 5 + 5, ((Drawable)localObject1).getIntrinsicHeight() * 4 / 5);
                      localObject1 = new bizo((Drawable)localObject1, 1).a(0.05F);
                      this.b.setSpan(localObject1, 0, 3, 17);
                    }
                    localObject2 = anzj.a(2131702105);
                    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, this.b, this);
                    break label1167;
                    localObject1 = "vip";
                    break label1210;
                    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject3, null);
                    break label1442;
                    localObject3 = ((bgty)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt);
                    if (TextUtils.isEmpty((CharSequence)localObject3)) {
                      break label1442;
                    }
                    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(true, (CharSequence)localObject3, null);
                    break label1442;
                    label2122:
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
                int m = agej.a(24.0F, (Resources)localObject6);
                QLog.e("DevicePttItemBuilder", 1, "", localException);
                continue;
                j = BaseChatItemLayout.r;
                continue;
                paramahoc.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, 0, 0, 0);
                localObject4 = paramahoc.jdField_a_of_type_AndroidWidgetTextView;
                if (bool3) {}
                for (j = k;; j = BaseChatItemLayout.r)
                {
                  ((TextView)localObject4).setPadding(j, BaseChatItemLayout.m, 0, BaseChatItemLayout.n);
                  break;
                }
                if (paramahoc.b == null)
                {
                  localObject5 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                  ((ImageView)localObject5).setImageDrawable(new ColorDrawable(838860800));
                  localObject7 = new RelativeLayout.LayoutParams(-1, i1);
                  ((ImageView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject7);
                  ((ImageView)localObject5).setId(2131374286);
                  TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
                  if (paramMessageForPtt.isSend())
                  {
                    localObject4 = ((Resources)localObject6).getColorStateList(2131167013);
                    if (localObject4 != null) {
                      localTextView.setTextColor((ColorStateList)localObject4);
                    }
                    localTextView.setId(2131374285);
                    localObject4 = new RelativeLayout.LayoutParams(-2, -2);
                    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
                    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
                    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    localImageView.setLayoutParams(localLayoutParams);
                    localImageView.setImageResource(2130844849);
                    localImageView.setScaleType(ImageView.ScaleType.FIT_END);
                    ((RelativeLayout.LayoutParams)localObject7).addRule(3, 2131374266);
                    ((RelativeLayout.LayoutParams)localObject7).addRule(14);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131374286);
                    localLayoutParams.addRule(3, 2131374286);
                    localLayoutParams.addRule(14);
                    localLayoutParams.addRule(6, 2131374285);
                    localLayoutParams.addRule(8, 2131374285);
                    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView((View)localObject5);
                    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localTextView);
                    paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.addView(localImageView);
                    paramahoc.e = ((ImageView)localObject5);
                    paramahoc.b = localTextView;
                    paramahoc.f = localImageView;
                    label2524:
                    paramahoc.b.setOnClickListener(this);
                    paramahoc.b.setOnTouchListener(paramahoc.jdField_a_of_type_Agjk);
                    paramahoc.b.setOnLongClickListener(paramahoc.jdField_a_of_type_Agjk);
                    localObject5 = paramMessageForPtt.sttText;
                    localObject4 = localObject5;
                    if (TextUtils.isEmpty((CharSequence)localObject5)) {
                      localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131718376);
                    }
                    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
                      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
                    }
                    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
                    j = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForPtt.voiceLength, (String)localObject4, this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), 0);
                    localObject5 = VoicePrintUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool3, bool1, j + k, paramahoc);
                    paramahoc.b.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
                    j = m + agej.a(22.0F, (Resources)localObject6);
                    if (!paramMessageForPtt.isSend()) {
                      break label2917;
                    }
                    localObject4 = (RelativeLayout.LayoutParams)paramahoc.e.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131374266);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131374266);
                    localObject4 = (RelativeLayout.LayoutParams)paramahoc.b.getLayoutParams();
                    ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131374266);
                    ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131374266);
                    paramahoc.jdField_a_of_type_AndroidWidgetImageView.setPadding(0, 0, k, 0);
                    paramahoc.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, BaseChatItemLayout.m, BaseChatItemLayout.r, BaseChatItemLayout.n);
                    paramahoc.e.setPadding(k, 0, k, 0);
                    paramahoc.b.setPadding(k, BaseChatItemLayout.m, k, j);
                    paramahoc.f.setPadding(0, 0, 0, n);
                  }
                }
                for (;;)
                {
                  localObject6 = paramMessageForPtt.sttText;
                  localObject4 = localObject6;
                  if (TextUtils.isEmpty((CharSequence)localObject6)) {
                    localObject4 = this.jdField_a_of_type_AndroidContentContext.getString(2131718376);
                  }
                  paramahoc.b.setText((CharSequence)localObject4);
                  localObject4 = localObject5;
                  break;
                  localObject4 = ((Resources)localObject6).getColorStateList(2131167009);
                  break label2329;
                  paramahoc.e.setVisibility(0);
                  paramahoc.b.setVisibility(0);
                  paramahoc.f.setVisibility(0);
                  break label2524;
                  label2917:
                  localObject4 = (RelativeLayout.LayoutParams)paramahoc.e.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131374266);
                  ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131374266);
                  localObject4 = (RelativeLayout.LayoutParams)paramahoc.b.getLayoutParams();
                  ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131374266);
                  ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131374266);
                  paramahoc.jdField_a_of_type_AndroidWidgetImageView.setPadding(k, 0, 0, 0);
                  paramahoc.jdField_a_of_type_AndroidWidgetTextView.setPadding(BaseChatItemLayout.r, BaseChatItemLayout.m, 0, BaseChatItemLayout.n);
                  paramahoc.e.setPadding(k, 0, k, 0);
                  paramahoc.b.setPadding(k, BaseChatItemLayout.m, k, j);
                  paramahoc.f.setPadding(0, 0, 0, n);
                }
                label3052:
                bool1 = false;
                continue;
                label3058:
                paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.a(true);
              }
              label3069:
              paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVoicePrintUtils$VoicePrintView.setVisibility(4);
              localObject4 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject4;
            }
          }
          break;
          paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          Object localObject4 = paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c;
          if (paramMessageForPtt.isSendFromLocal()) {}
          for (paramMessageForPtt = anzj.a(2131702109);; paramMessageForPtt = anzj.a(2131702106))
          {
            ((ImageView)localObject4).setContentDescription(paramMessageForPtt);
            break;
          }
          paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839414, null);
          paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.setBackgroundDrawable(null);
          ((Animatable)paramahoc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getDrawable()).start();
          break label522;
          label3197:
          paramMessageForPtt = anzj.a(2131702110);
          break label569;
          paramahoc.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramMessageForPtt + (String)localObject1 + anzj.a(2131702111));
          break label641;
          i = paramInt;
          paramInt = 0;
          j = 1;
        }
      }
      label3077:
      label3207:
      label3261:
      localObject2 = null;
      break label1167;
    }
  }
  
  public void b(View paramView)
  {
    ChatMessage localChatMessage = agej.a(paramView);
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
    agej.n = true;
    int i = paramView.getId();
    if ((AppSetting.c) && (i == 2131363324)) {
      paramView.findViewById(2131374266).performClick();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = (ahoc)agej.a(paramView);
      if (localObject1 != null)
      {
        Object localObject2 = (MessageForPtt)((ahoc)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (i == 2131374266)
        {
          if (c((ChatMessage)localObject2)) {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
          }
          for (;;)
          {
            if (((MessageForPtt)localObject2).istroop == 1008) {
              ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", ((MessageForPtt)localObject2).timeStr, "", false);
            }
            if (((MessageForPtt)localObject2).voiceChangeFlag != 1) {
              break;
            }
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "changevoice", "0X8006F7E", 0, 0, "" + ((MessageForPtt)localObject2).istroop, "", "", "");
            break;
            if ((localObject2 != MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) && (((MessageForPtt)localObject2).isReady())) {
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694616, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
              } else if (!MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(agej.a(paramView))) {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131694615, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
              }
            }
          }
        }
        if (i == 2131374285)
        {
          if (((MessageForPtt)localObject2).expandStt)
          {
            ((MessageForPtt)localObject2).expandStt = false;
            ((MessageForPtt)localObject2).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageForPtt)localObject2).uniseq, ((MessageForPtt)localObject2).msgData);
            a((ahoc)localObject1, (MessageForPtt)localObject2, a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPtt)localObject2), c((ChatMessage)localObject2));
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8003F37", "0X8003F37", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if (i == 2131364452)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            String str = nnr.a();
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
 * Qualified Name:     abyo
 * JD-Core Version:    0.7.0.1
 */