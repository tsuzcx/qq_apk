import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.FileVideoItemBuilder.1;
import com.tencent.mobileqq.activity.aio.item.FileVideoItemBuilder.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.BubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

public class adeq
  extends BaseBubbleBuilder
{
  protected View a;
  private aodf a;
  public Handler b;
  
  private void a(String paramString1, String paramString2, adeu paramadeu, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramadeu.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramadeu.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramadeu.jdField_a_of_type_AndroidViewView).removeView(paramadeu.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131298520);
    localRelativeLayout.setBackgroundResource(2130838764);
    paramadeu.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
    Object localObject = new RelativeLayout.LayoutParams(-1, aciy.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131305912);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131305912);
      if (paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).rightMargin = aciy.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
        int i = apdq.a(paramadeu.e, paramadeu.f);
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(2131298520);
        paramViewGroup.setTextSize(2, 12.0F);
        paramViewGroup.setTextColor(-1);
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).rightMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        localRelativeLayout.addView(paramViewGroup, (ViewGroup.LayoutParams)localObject);
        localObject = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
        ((TextView)localObject).setId(2131298523);
        ((TextView)localObject).setTextSize(2, 14.0F);
        ((TextView)localObject).setTextColor(-1);
        ((TextView)localObject).setSingleLine();
        ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.rightMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.bottomMargin = aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (i != 1) {
          break label513;
        }
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(2, 2131298520);
        label412:
        localRelativeLayout.addView((View)localObject, localLayoutParams);
        paramString1 = apdq.a(this.jdField_a_of_type_AndroidContentContext, i, paramadeu.e, (TextView)localObject, paramViewGroup, paramString1, paramString2);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject).setText(paramString1);
      paramViewGroup.setText(paramString2);
      return;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = aciy.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      break;
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      break;
      label513:
      localLayoutParams.addRule(12);
      break label412;
      ((TextView)localObject).setLines(2);
      ((TextView)localObject).setMaxLines(2);
      paramViewGroup.setGravity(3);
      continue;
      ((TextView)localObject).setLines(1);
      ((TextView)localObject).setMaxLines(1);
      paramViewGroup.setGravity(5);
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acjt a(View paramView)
  {
    if (paramView != null)
    {
      paramView = aciy.a(paramView);
      if ((paramView != null) && (adeu.class.isInstance(paramView)))
      {
        paramView = (adeu)paramView;
        if (paramView != null) {
          return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
        }
      }
    }
    return null;
  }
  
  public acju a()
  {
    return new adeu(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acmv paramacmv)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacmv);
    paramViewGroup = (acju)aciy.a(paramView);
    this.jdField_a_of_type_Aodf.a(paramViewGroup, paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    adeu localadeu;
    if (adeu.class.isInstance(paramacju)) {
      localadeu = (adeu)paramacju;
    }
    for (paramacju = paramView;; paramacju = null)
    {
      this.jdField_a_of_type_AndroidContentContext.getResources();
      Object localObject = paramacju;
      if (paramacju == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramacju = new BubbleVideoView(this.jdField_a_of_type_AndroidContentContext);
        paramacju.setId(2131305912);
        paramacju.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramacju.setRadius(15.0F);
        paramacju.d(true);
        paramacju.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(paramacju);
        MessageProgressView localMessageProgressView = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
        localMessageProgressView.setId(2131298594);
        ((RelativeLayout)localObject).addView(localMessageProgressView);
        paramacju.setOnClickListener(this);
        super.a(paramacju, paramacmv);
        localadeu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramacju;
        localadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      boolean bool = paramChatMessage.isSend();
      if (localadeu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool)
      {
        localadeu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
        localadeu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      }
      localadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      super.a(localadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView, paramacmv);
      localadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
      localadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
      localadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
      localadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      localadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
      localadeu.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramChatMessage, localadeu, paramView, paramBaseChatItemLayout);
      return localObject;
      localadeu = new adeu(this);
      localadeu.jdField_b_of_type_JavaLangStringBuilder = paramacju.jdField_b_of_type_JavaLangStringBuilder;
      localadeu.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramacju.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localadeu.jdField_a_of_type_AndroidViewView = paramacju.jdField_a_of_type_AndroidViewView;
      localadeu.jdField_a_of_type_Almt = paramacju.jdField_a_of_type_Almt;
      localadeu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramacju.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      localadeu.jdField_a_of_type_Int = paramacju.jdField_a_of_type_Int;
      localadeu.jdField_b_of_type_Int = paramacju.jdField_b_of_type_Int;
      localadeu.c = paramacju.c;
      localadeu.d = paramacju.d;
      localadeu.jdField_a_of_type_JavaLangString = paramacju.jdField_a_of_type_JavaLangString;
    }
  }
  
  public bakh a(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    paramChatMessage = (MessageForFile)paramChatMessage;
    paramackl = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    int j;
    if (paramackl != null)
    {
      j = 0;
      if (paramackl.status != 16) {
        b(parambakh, this.jdField_a_of_type_AndroidContentContext);
      }
      if ((!paramChatMessage.isSendFromLocal()) || (paramackl.status != 2)) {
        break label56;
      }
    }
    label56:
    int i;
    do
    {
      return parambakh;
      i = j;
      if (paramackl.status != 16)
      {
        if (!paramackl.sendCloudUnsuccessful()) {
          parambakh.a(2131301021, ajjy.a(2131638808), 2130838599);
        }
        i = j;
        if (apck.c(paramackl)) {
          i = 1;
        }
      }
    } while (i == 0);
    parambakh.a(2131300328, ajjy.a(2131638802), 2130838598);
    return parambakh;
  }
  
  public MessageForFile a(View paramView)
  {
    paramView = (ackl)aciy.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg) {
      return (MessageForFile)apck.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    return (MessageForFile)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bado.a(paramChatMessage.issend)) {
      return ajjy.a(2131638806);
    }
    return ajjy.a(2131638796);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131304829: 
    case 2131309812: 
    case 2131300328: 
      do
      {
        do
        {
          return;
          long l1 = awao.a();
          long l2 = paramChatMessage.time;
          if ((paramChatMessage.msgtype == -2005) && (paramChatMessage.istroop == 3000) && (l1 - l2 > 604800L))
          {
            apcb.a(ajjy.a(2131638807));
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
            return;
          }
          a(paramChatMessage);
          apci.a("0X8005E4B");
          return;
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
          if (!apbf.a((MessageForFile)paramChatMessage).a(false)) {
            break;
          }
        } while (!bbrm.a((Activity)paramContext, 5, new ader(this, paramChatMessage, paramContext)));
        apbx.a(paramContext, 2131627035, 2131627038, new ades(this, paramChatMessage, paramContext));
        return;
        apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramContext);
        return;
        paramContext = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
        new bfhl(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, paramChatMessage, false);
      } while (!paramChatMessage.isMultiMsg);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
      return;
    case 2131301048: 
      apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramContext);
      return;
    case 2131301021: 
      paramContext = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
      localObject = new apcj();
      ((apcj)localObject).b = "file_forward";
      ((apcj)localObject).jdField_a_of_type_Int = 9;
      ((apcj)localObject).jdField_a_of_type_Long = paramContext.fileSize;
      ((apcj)localObject).c = apdh.a(paramContext.fileName);
      ((apcj)localObject).d = apck.a(paramContext.getCloudType(), paramContext.peerType);
      apci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (apcj)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("forward_type", 0);
      ((Bundle)localObject).putBoolean("not_forward", true);
      ((Bundle)localObject).putInt("selection_mode", this.jdField_b_of_type_Int);
      ((Bundle)localObject).putParcelable("fileinfo", apir.a(paramContext, paramChatMessage));
      ((Bundle)localObject).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      Intent localIntent = new Intent();
      localIntent.putExtras((Bundle)localObject);
      localIntent.putExtra("forward_text", ajjy.a(2131638800) + apck.d(paramContext.fileName) + ajjy.a(2131638804) + apdh.a(paramContext.fileSize) + "。");
      localIntent.putExtra("direct_send_if_dataline_forward", true);
      localIntent.putExtra("forward _key_nojump", true);
      if (!badq.d(BaseApplication.getContext())) {
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131629008, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
      }
      for (;;)
      {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
        if (!paramChatMessage.isMultiMsg) {
          break;
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
        return;
        aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
      }
    case 2131299417: 
      aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      paramContext = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext);
      return;
    case 2131304871: 
      super.d(paramChatMessage);
      return;
    case 2131298310: 
      paramContext = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.nSessionId);
      b();
      return;
    }
    paramContext = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
    awqx.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    Object localObject = xgx.a(this.jdField_a_of_type_AndroidViewView);
    paramInt = 0;
    if (paramContext.peerType == 0) {
      paramInt = 1;
    }
    for (;;)
    {
      apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, (Rect)localObject, paramInt, 10004, paramContext, true, false);
      return;
      if (paramContext.peerType == 3000) {
        paramInt = 5;
      } else {
        QLog.w("FileVideoItemBuilder<FileAssistant>", 1, "entranceType is unknow ,peerType:" + paramContext.peerType);
      }
    }
  }
  
  protected void a(adeu paramadeu, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 100)
    {
      paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramadeu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadeu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramadeu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadeu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131626845);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131626844);
    begr localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbegr.c(str1);
    localbegr.d(this.jdField_a_of_type_AndroidContentContext.getString(2131625035));
    localbegr.a(str2);
    localbegr.a(new adet(this, paramView, localbegr));
    localbegr.show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165222);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, i, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  protected void a(ChatMessage paramChatMessage, adeu paramadeu, View paramView, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramView = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    Object localObject = localFileManagerEntity.fileName + localFileManagerEntity.nSessionId;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject))
    {
      awqx.b(null, "dc00898", "", "", "0X800A686", "0X800A686", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject);
    }
    paramView.fileName = localFileManagerEntity.fileName;
    if ((localFileManagerEntity.cloudType == 1) && (apck.a(localFileManagerEntity))) {
      localFileManagerEntity.status = 16;
    }
    int i;
    label245:
    int j;
    if ((localFileManagerEntity.isSend()) && (localFileManagerEntity.status == 0))
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoItemBuilder<FileAssistant>", 1, "Id[" + localFileManagerEntity.nSessionId + "] FileEntity,size(wh)[" + localFileManagerEntity.imgWidth + ":" + localFileManagerEntity.imgHeight + "]");
      }
      if (localFileManagerEntity.imgHeight <= 0) {
        break label541;
      }
      i = localFileManagerEntity.imgHeight;
      if (localFileManagerEntity.imgWidth <= 0) {
        break label549;
      }
      j = localFileManagerEntity.imgWidth;
      label260:
      paramView = ShortVideoUtils.a(j, i);
      i = paramView[0];
      j = paramView[1];
      paramView = paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (paramView != null) {
        break label557;
      }
      paramView = new RelativeLayout.LayoutParams(i, j);
      paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
      label310:
      paramView = paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (paramView != null) {
        break label598;
      }
      paramView = new LinearLayout.LayoutParams(i, j);
      paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramView);
      label342:
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoItemBuilder<FileAssistant>", 1, "Id[" + localFileManagerEntity.nSessionId + "]show AIOFileVideoItem,use size(wh)[" + i + ":" + j + "]");
      }
      paramadeu.e = i;
      paramadeu.f = j;
      if (paramadeu.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramadeu.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        ((RelativeLayout)paramadeu.jdField_a_of_type_AndroidViewView).removeView(paramadeu.jdField_b_of_type_AndroidWidgetRelativeLayout);
      }
      localObject = new amym(Color.rgb(214, 214, 214), i, j);
      paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      if (localFileManagerEntity.status != 2) {
        break label639;
      }
      a(paramadeu, (int)(localFileManagerEntity.fProgress * 100.0F), true);
      label505:
      if ((!localFileManagerEntity.bCannotPlay) && (localFileManagerEntity.status != 16)) {
        break label929;
      }
      a(localFileManagerEntity, paramadeu);
    }
    for (;;)
    {
      return;
      paramBaseChatItemLayout.setFailedIconVisable(false, this);
      break;
      label541:
      i = 480;
      break label245;
      label549:
      j = 640;
      break label260;
      label557:
      if ((paramView.width == i) && (paramView.height == j)) {
        break label310;
      }
      paramView.width = i;
      paramView.height = j;
      paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
      break label310;
      label598:
      if ((paramView.width == i) && (paramView.height == j)) {
        break label342;
      }
      paramView.width = i;
      paramView.height = j;
      paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramView);
      break label342;
      label639:
      if (localFileManagerEntity.status == 0)
      {
        paramView = ajjy.a(2131638798);
        paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130848456);
        paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramView);
        paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
        paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
        break label505;
      }
      if (localFileManagerEntity.status == 3)
      {
        paramView = ajjy.a(2131638793);
        paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramView);
        if (paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadeu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadeu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
        {
          paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishResource(2130848456);
          paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramadeu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadeu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          break label505;
        }
        paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130848456);
        paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
        break label505;
      }
      if (paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadeu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadeu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
      {
        paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
        paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramadeu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadeu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        break label505;
      }
      paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      break label505;
      label929:
      paramView = bace.a(localFileManagerEntity.fileSize);
      a(localFileManagerEntity.fileName, paramView, paramadeu, (RelativeLayout)paramadeu.jdField_a_of_type_AndroidViewView, false);
      paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(0);
      paramBaseChatItemLayout = localFileManagerEntity.strLargeThumPath;
      paramView = paramBaseChatItemLayout;
      if (paramChatMessage.isMultiMsg)
      {
        paramView = paramBaseChatItemLayout;
        if (TextUtils.isEmpty(paramBaseChatItemLayout)) {
          paramView = apck.a(paramChatMessage);
        }
      }
      if (apdh.b(paramView))
      {
        paramChatMessage = ShortVideoUtils.a(paramView);
        if ((paramadeu.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramadeu.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramChatMessage)))
        {
          paramChatMessage = URLDrawable.getDrawable(paramChatMessage, i, j, (Drawable)localObject, (Drawable)localObject);
          paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramChatMessage);
          paramadeu.jdField_a_of_type_ComTencentImageURLDrawable = paramChatMessage;
          paramChatMessage = URLDrawable.URLDrawableOptions.obtain();
          paramChatMessage.mLoadingDrawable = new ColorDrawable(-16777216);
          URLDrawable.getDrawable(new File(paramView), paramChatMessage);
        }
        while ((localFileManagerEntity != null) && ((localFileManagerEntity.imgWidth <= 0) || (localFileManagerEntity.imgHeight <= 0)))
        {
          apck.e(localFileManagerEntity);
          return;
          if (paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getDrawable() != paramadeu.jdField_a_of_type_ComTencentImageURLDrawable) {
            paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramadeu.jdField_a_of_type_ComTencentImageURLDrawable);
          }
        }
      }
      else
      {
        paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130843418);
        if ((apdh.b(localFileManagerEntity.getFilePath())) && (apck.b(localFileManagerEntity)))
        {
          ThreadManager.executeOnSubThread(new FileVideoItemBuilder.1(this, localFileManagerEntity));
          return;
        }
        if (localFileManagerEntity.peerType == 3000) {}
        for (paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localFileManagerEntity); bace.b(paramChatMessage); paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity))
        {
          ThreadManager.executeOnSubThread(new FileVideoItemBuilder.2(this, localFileManagerEntity, paramChatMessage));
          return;
        }
      }
    }
  }
  
  protected void a(FileManagerEntity paramFileManagerEntity, adeu paramadeu)
  {
    if (paramadeu.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramadeu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    float f = this.jdField_a_of_type_Float;
    Object localObject = new aczj(Color.parseColor("#D8DAE0"), 255, f * 8.0F);
    if (Build.VERSION.SDK_INT >= 16)
    {
      localRelativeLayout.setBackground((Drawable)localObject);
      localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      if (paramFileManagerEntity.status != 16) {
        break label268;
      }
      ((TextView)localObject).setText(ajjy.a(2131638795));
    }
    for (;;)
    {
      ((TextView)localObject).setCompoundDrawablePadding(aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130848457, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramadeu.e, paramadeu.f - 40);
      ((RelativeLayout)paramadeu.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = bace.a(paramFileManagerEntity.fileSize);
      a(paramFileManagerEntity.fileName, (String)localObject, paramadeu, localRelativeLayout, true);
      paramadeu.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable((Drawable)localObject);
      break;
      label268:
      ((TextView)localObject).setText(ajjy.a(2131638797));
    }
  }
  
  public bakj[] a(View paramView)
  {
    MessageForFile localMessageForFile = a(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramView = new bakh();
    if (localMessageForFile != null)
    {
      if (!localMessageForFile.isMultiMsg) {
        break label43;
      }
      a(paramView, localMessageForFile, null);
    }
    for (;;)
    {
      return paramView.a();
      label43:
      b(paramView, localMessageForFile, null);
    }
  }
  
  public bakh b(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    paramChatMessage = (MessageForFile)paramChatMessage;
    paramackl = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    if (paramackl.status != 16) {
      b(parambakh, this.jdField_a_of_type_AndroidContentContext);
    }
    int j = 0;
    int i = 0;
    if ((paramChatMessage.isSendFromLocal()) && (paramackl.status == 2)) {
      parambakh.a(2131298310, this.jdField_a_of_type_AndroidContentContext.getString(2131625146), 2130838588);
    }
    for (;;)
    {
      super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
      do
      {
        return parambakh;
      } while (paramackl == null);
      if (paramackl.status != 16)
      {
        if (!paramackl.sendCloudUnsuccessful()) {
          parambakh.a(2131301021, ajjy.a(2131638803), 2130838599);
        }
        a(paramChatMessage, parambakh);
        if (apck.c(paramackl)) {
          i = 1;
        }
        if ((paramackl.status != 1) && (paramackl.status != -1))
        {
          j = i;
          if (paramackl.status != 3) {
            break label202;
          }
          if (paramackl.nOpType != 1)
          {
            j = i;
            if (paramackl.nOpType != 8) {
              break label202;
            }
          }
        }
        a(parambakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
        j = i;
      }
      label202:
      a(parambakh, paramChatMessage);
      if (j != 0) {
        parambakh.a(2131300328, ajjy.a(2131638794), 2130838598);
      }
      if (paramackl.status != 16) {
        b(paramChatMessage, parambakh);
      }
      if ((paramackl.getCloudType() != 1) || (paramackl.status != 2)) {
        super.c(parambakh, this.jdField_a_of_type_AndroidContentContext);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    aciy.n = true;
    if (super.a()) {}
    MessageForFile localMessageForFile;
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        do
        {
          return;
          if ((paramView.getId() != 2131305912) && (paramView.getId() != 2131298594))
          {
            super.onClick(paramView);
            return;
          }
          localMessageForFile = a(paramView);
        } while ((localMessageForFile.isMultiMsg) && (!apck.a(localMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext)));
        localFileManagerEntity = apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
        if (localFileManagerEntity == null)
        {
          QLog.e("FileVideoItemBuilder<FileAssistant>", 1, "get Entity by Msg faild!");
          return;
        }
      } while (localFileManagerEntity.status == 16);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68B", "0X800A68B", 0, 0, "4", "", "", "");
      if (apdq.a(localFileManagerEntity)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FileVideoItemBuilder<FileAssistant>", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    if ((localFileManagerEntity.sendCloudUnsuccessful()) && (!apdh.b(localFileManagerEntity.getFilePath())))
    {
      apcb.a(ajjy.a(2131638792));
      return;
    }
    apcj localapcj = new apcj();
    localapcj.b = "file_viewer_in";
    localapcj.jdField_a_of_type_Int = 9;
    localapcj.c = apdh.a(localFileManagerEntity.fileName);
    localapcj.d = apck.a(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
    apci.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localapcj);
    apci.a("0X8004AE3");
    QLog.i("FileVideoItemBuilder<FileAssistant>", 1, "handle item click: file peerType[" + localFileManagerEntity.peerType + "]");
    int i;
    if (localFileManagerEntity.peerType == 0) {
      i = 1;
    }
    for (;;)
    {
      paramView = xgx.a(paramView);
      apdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageForFile, paramView, i, 10004, localFileManagerEntity, false, false);
      return;
      if (localFileManagerEntity.peerType == 3000) {
        i = 5;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adeq
 * JD-Core Version:    0.7.0.1
 */