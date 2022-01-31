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

public class adpq
  extends BaseBubbleBuilder
{
  protected View a;
  private aoud a;
  public Handler b;
  
  private void a(String paramString1, String paramString2, adpu paramadpu, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramadpu.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramadpu.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramadpu.jdField_a_of_type_AndroidViewView).removeView(paramadpu.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131364077);
    localRelativeLayout.setBackgroundResource(2130838791);
    paramadpu.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
    Object localObject = new RelativeLayout.LayoutParams(-1, actj.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131371608);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131371608);
      if (paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).rightMargin = actj.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
        int i = apvm.a(paramadpu.e, paramadpu.f);
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(2131364077);
        paramViewGroup.setTextSize(2, 12.0F);
        paramViewGroup.setTextColor(-1);
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).rightMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        localRelativeLayout.addView(paramViewGroup, (ViewGroup.LayoutParams)localObject);
        localObject = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
        ((TextView)localObject).setId(2131364080);
        ((TextView)localObject).setTextSize(2, 14.0F);
        ((TextView)localObject).setTextColor(-1);
        ((TextView)localObject).setSingleLine();
        ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.rightMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.bottomMargin = actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (i != 1) {
          break label513;
        }
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(2, 2131364077);
        label412:
        localRelativeLayout.addView((View)localObject, localLayoutParams);
        paramString1 = apvm.a(this.jdField_a_of_type_AndroidContentContext, i, paramadpu.e, (TextView)localObject, paramViewGroup, paramString1, paramString2);
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
      ((RelativeLayout.LayoutParams)localObject).leftMargin = actj.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
  
  public acui a(View paramView)
  {
    if (paramView != null)
    {
      paramView = actj.a(paramView);
      if ((paramView != null) && (adpu.class.isInstance(paramView)))
      {
        paramView = (adpu)paramView;
        if (paramView != null) {
          return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
        }
      }
    }
    return null;
  }
  
  public acuj a()
  {
    return new adpu(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxj paramacxj)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxj);
    paramViewGroup = (acuj)actj.a(paramView);
    this.jdField_a_of_type_Aoud.a(paramViewGroup, paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    adpu localadpu;
    if (adpu.class.isInstance(paramacuj)) {
      localadpu = (adpu)paramacuj;
    }
    for (paramacuj = paramView;; paramacuj = null)
    {
      this.jdField_a_of_type_AndroidContentContext.getResources();
      Object localObject = paramacuj;
      if (paramacuj == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramacuj = new BubbleVideoView(this.jdField_a_of_type_AndroidContentContext);
        paramacuj.setId(2131371608);
        paramacuj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramacuj.setRadius(15.0F);
        paramacuj.d(true);
        paramacuj.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(paramacuj);
        MessageProgressView localMessageProgressView = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
        localMessageProgressView.setId(2131364151);
        ((RelativeLayout)localObject).addView(localMessageProgressView);
        paramacuj.setOnClickListener(this);
        super.a(paramacuj, paramacxj);
        localadpu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramacuj;
        localadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      boolean bool = paramChatMessage.isSend();
      if (localadpu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool)
      {
        localadpu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
        localadpu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      }
      localadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      super.a(localadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView, paramacxj);
      localadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
      localadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
      localadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
      localadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      localadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
      localadpu.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramChatMessage, localadpu, paramView, paramBaseChatItemLayout);
      return localObject;
      localadpu = new adpu(this);
      localadpu.jdField_b_of_type_JavaLangStringBuilder = paramacuj.jdField_b_of_type_JavaLangStringBuilder;
      localadpu.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramacuj.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localadpu.jdField_a_of_type_AndroidViewView = paramacuj.jdField_a_of_type_AndroidViewView;
      localadpu.jdField_a_of_type_Ambg = paramacuj.jdField_a_of_type_Ambg;
      localadpu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramacuj.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      localadpu.jdField_a_of_type_Int = paramacuj.jdField_a_of_type_Int;
      localadpu.jdField_b_of_type_Int = paramacuj.jdField_b_of_type_Int;
      localadpu.c = paramacuj.c;
      localadpu.d = paramacuj.d;
      localadpu.jdField_a_of_type_JavaLangString = paramacuj.jdField_a_of_type_JavaLangString;
    }
  }
  
  public bbmf a(bbmf parambbmf, ChatMessage paramChatMessage, acva paramacva)
  {
    paramChatMessage = (MessageForFile)paramChatMessage;
    paramacva = apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    int j;
    if (paramacva != null)
    {
      j = 0;
      if (paramacva.status != 16) {
        b(parambbmf, this.jdField_a_of_type_AndroidContentContext);
      }
      if ((!paramChatMessage.isSendFromLocal()) || (paramacva.status != 2)) {
        break label56;
      }
    }
    label56:
    int i;
    do
    {
      return parambbmf;
      i = j;
      if (paramacva.status != 16)
      {
        if (!paramacva.sendCloudUnsuccessful()) {
          parambbmf.a(2131366632, ajya.a(2131704604), 2130838606);
        }
        i = j;
        if (apug.c(paramacva)) {
          i = 1;
        }
      }
    } while (i == 0);
    parambbmf.a(2131365928, ajya.a(2131704598), 2130838605);
    return parambbmf;
  }
  
  public MessageForFile a(View paramView)
  {
    paramView = (acva)actj.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg) {
      return (MessageForFile)apug.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    return (MessageForFile)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bbfh.a(paramChatMessage.issend)) {
      return ajya.a(2131704602);
    }
    return ajya.a(2131704592);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131370493: 
    case 2131375573: 
    case 2131365928: 
      do
      {
        do
        {
          return;
          long l1 = awzy.a();
          long l2 = paramChatMessage.time;
          if ((paramChatMessage.msgtype == -2005) && (paramChatMessage.istroop == 3000) && (l1 - l2 > 604800L))
          {
            aptx.a(ajya.a(2131704603));
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
            return;
          }
          a(paramChatMessage);
          apue.a("0X8005E4B");
          return;
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
          if (!aptd.a((MessageForFile)paramChatMessage).a(false)) {
            break;
          }
        } while (!bcwb.a((Activity)paramContext, 5, new adpr(this, paramChatMessage, paramContext)));
        aptt.a(paramContext, 2131692673, 2131692676, new adps(this, paramChatMessage, paramContext));
        return;
        apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramContext);
        return;
        paramContext = apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
        new bgpu(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, paramChatMessage, false);
      } while (!paramChatMessage.isMultiMsg);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
      return;
    case 2131366659: 
      apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramContext);
      return;
    case 2131366632: 
      paramContext = apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
      localObject = new apuf();
      ((apuf)localObject).b = "file_forward";
      ((apuf)localObject).jdField_a_of_type_Int = 9;
      ((apuf)localObject).jdField_a_of_type_Long = paramContext.fileSize;
      ((apuf)localObject).c = apvd.a(paramContext.fileName);
      ((apuf)localObject).d = apug.a(paramContext.getCloudType(), paramContext.peerType);
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (apuf)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("forward_type", 0);
      ((Bundle)localObject).putBoolean("not_forward", true);
      ((Bundle)localObject).putInt("selection_mode", this.jdField_b_of_type_Int);
      ((Bundle)localObject).putParcelable("fileinfo", aqcg.a(paramContext, paramChatMessage));
      ((Bundle)localObject).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      Intent localIntent = new Intent();
      localIntent.putExtras((Bundle)localObject);
      localIntent.putExtra("forward_text", ajya.a(2131704596) + apug.d(paramContext.fileName) + ajya.a(2131704600) + apvd.a(paramContext.fileSize) + "。");
      localIntent.putExtra("direct_send_if_dataline_forward", true);
      localIntent.putExtra("forward _key_nojump", true);
      if (!bbfj.d(BaseApplication.getContext())) {
        bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131694673, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      }
      for (;;)
      {
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
        if (!paramChatMessage.isMultiMsg) {
          break;
        }
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
        return;
        aqbe.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
      }
    case 2131364984: 
      aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      paramContext = apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext);
      return;
    case 2131370536: 
      super.d(paramChatMessage);
      return;
    case 2131363864: 
      paramContext = apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.nSessionId);
      b();
      return;
    }
    paramContext = apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
    axqy.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    Object localObject = xpu.a(this.jdField_a_of_type_AndroidViewView);
    paramInt = 0;
    if (paramContext.peerType == 0) {
      paramInt = 1;
    }
    for (;;)
    {
      apvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, (Rect)localObject, paramInt, 10004, paramContext, true, false);
      return;
      if (paramContext.peerType == 3000) {
        paramInt = 5;
      } else {
        QLog.w("FileVideoItemBuilder<FileAssistant>", 1, "entranceType is unknow ,peerType:" + paramContext.peerType);
      }
    }
  }
  
  protected void a(adpu paramadpu, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 100)
    {
      paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramadpu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadpu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramadpu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadpu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692447);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692446);
    bfpc localbfpc = (bfpc)bfpp.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbfpc.c(str1);
    localbfpc.d(this.jdField_a_of_type_AndroidContentContext.getString(2131690596));
    localbfpc.a(str2);
    localbfpc.a(new adpt(this, paramView, localbfpc));
    localbfpc.show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296294);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, i, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  protected void a(ChatMessage paramChatMessage, adpu paramadpu, View paramView, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramView = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    Object localObject = localFileManagerEntity.fileName + localFileManagerEntity.nSessionId;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject))
    {
      axqy.b(null, "dc00898", "", "", "0X800A686", "0X800A686", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject);
    }
    paramView.fileName = localFileManagerEntity.fileName;
    if ((localFileManagerEntity.cloudType == 1) && (apug.a(localFileManagerEntity))) {
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
      paramView = paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (paramView != null) {
        break label557;
      }
      paramView = new RelativeLayout.LayoutParams(i, j);
      paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
      label310:
      paramView = paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (paramView != null) {
        break label598;
      }
      paramView = new LinearLayout.LayoutParams(i, j);
      paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramView);
      label342:
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoItemBuilder<FileAssistant>", 1, "Id[" + localFileManagerEntity.nSessionId + "]show AIOFileVideoItem,use size(wh)[" + i + ":" + j + "]");
      }
      paramadpu.e = i;
      paramadpu.f = j;
      if (paramadpu.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramadpu.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        ((RelativeLayout)paramadpu.jdField_a_of_type_AndroidViewView).removeView(paramadpu.jdField_b_of_type_AndroidWidgetRelativeLayout);
      }
      localObject = new anoz(Color.rgb(214, 214, 214), i, j);
      paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      if (localFileManagerEntity.status != 2) {
        break label639;
      }
      a(paramadpu, (int)(localFileManagerEntity.fProgress * 100.0F), true);
      label505:
      if ((!localFileManagerEntity.bCannotPlay) && (localFileManagerEntity.status != 16)) {
        break label929;
      }
      a(localFileManagerEntity, paramadpu);
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
      paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
      break label310;
      label598:
      if ((paramView.width == i) && (paramView.height == j)) {
        break label342;
      }
      paramView.width = i;
      paramView.height = j;
      paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramView);
      break label342;
      label639:
      if (localFileManagerEntity.status == 0)
      {
        paramView = ajya.a(2131704594);
        paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130848698);
        paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramView);
        paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
        paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
        break label505;
      }
      if (localFileManagerEntity.status == 3)
      {
        paramView = ajya.a(2131704589);
        paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramView);
        if (paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadpu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadpu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
        {
          paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishResource(2130848698);
          paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramadpu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadpu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          break label505;
        }
        paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130848698);
        paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
        break label505;
      }
      if (paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadpu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadpu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
      {
        paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
        paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramadpu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadpu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        break label505;
      }
      paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      break label505;
      label929:
      paramView = bbdx.a(localFileManagerEntity.fileSize);
      a(localFileManagerEntity.fileName, paramView, paramadpu, (RelativeLayout)paramadpu.jdField_a_of_type_AndroidViewView, false);
      paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(0);
      paramBaseChatItemLayout = localFileManagerEntity.strLargeThumPath;
      paramView = paramBaseChatItemLayout;
      if (paramChatMessage.isMultiMsg)
      {
        paramView = paramBaseChatItemLayout;
        if (TextUtils.isEmpty(paramBaseChatItemLayout)) {
          paramView = apug.a(paramChatMessage);
        }
      }
      if (apvd.b(paramView))
      {
        paramChatMessage = ShortVideoUtils.a(paramView);
        if ((paramadpu.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramadpu.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramChatMessage)))
        {
          paramChatMessage = URLDrawable.getDrawable(paramChatMessage, i, j, (Drawable)localObject, (Drawable)localObject);
          paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramChatMessage);
          paramadpu.jdField_a_of_type_ComTencentImageURLDrawable = paramChatMessage;
          paramChatMessage = URLDrawable.URLDrawableOptions.obtain();
          paramChatMessage.mLoadingDrawable = new ColorDrawable(-16777216);
          URLDrawable.getDrawable(new File(paramView), paramChatMessage);
        }
        while ((localFileManagerEntity != null) && ((localFileManagerEntity.imgWidth <= 0) || (localFileManagerEntity.imgHeight <= 0)))
        {
          apug.e(localFileManagerEntity);
          return;
          if (paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getDrawable() != paramadpu.jdField_a_of_type_ComTencentImageURLDrawable) {
            paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramadpu.jdField_a_of_type_ComTencentImageURLDrawable);
          }
        }
      }
      else
      {
        paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130843503);
        if ((apvd.b(localFileManagerEntity.getFilePath())) && (apug.b(localFileManagerEntity)))
        {
          ThreadManager.executeOnSubThread(new FileVideoItemBuilder.1(this, localFileManagerEntity));
          return;
        }
        if (localFileManagerEntity.peerType == 3000) {}
        for (paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localFileManagerEntity); bbdx.b(paramChatMessage); paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity))
        {
          ThreadManager.executeOnSubThread(new FileVideoItemBuilder.2(this, localFileManagerEntity, paramChatMessage));
          return;
        }
      }
    }
  }
  
  protected void a(FileManagerEntity paramFileManagerEntity, adpu paramadpu)
  {
    if (paramadpu.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramadpu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    float f = this.jdField_a_of_type_Float;
    Object localObject = new adkj(Color.parseColor("#D8DAE0"), 255, f * 8.0F);
    if (Build.VERSION.SDK_INT >= 16)
    {
      localRelativeLayout.setBackground((Drawable)localObject);
      localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      if (paramFileManagerEntity.status != 16) {
        break label268;
      }
      ((TextView)localObject).setText(ajya.a(2131704591));
    }
    for (;;)
    {
      ((TextView)localObject).setCompoundDrawablePadding(actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130848699, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramadpu.e, paramadpu.f - 40);
      ((RelativeLayout)paramadpu.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = bbdx.a(paramFileManagerEntity.fileSize);
      a(paramFileManagerEntity.fileName, (String)localObject, paramadpu, localRelativeLayout, true);
      paramadpu.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable((Drawable)localObject);
      break;
      label268:
      ((TextView)localObject).setText(ajya.a(2131704593));
    }
  }
  
  public bbmh[] a(View paramView)
  {
    MessageForFile localMessageForFile = a(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramView = new bbmf();
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
  
  public bbmf b(bbmf parambbmf, ChatMessage paramChatMessage, acva paramacva)
  {
    paramChatMessage = (MessageForFile)paramChatMessage;
    paramacva = apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    if (paramacva.status != 16) {
      b(parambbmf, this.jdField_a_of_type_AndroidContentContext);
    }
    int j = 0;
    int i = 0;
    if ((paramChatMessage.isSendFromLocal()) && (paramacva.status == 2)) {
      parambbmf.a(2131363864, this.jdField_a_of_type_AndroidContentContext.getString(2131690707), 2130838595);
    }
    for (;;)
    {
      super.e(parambbmf, this.jdField_a_of_type_AndroidContentContext);
      do
      {
        return parambbmf;
      } while (paramacva == null);
      if (paramacva.status != 16)
      {
        if (!paramacva.sendCloudUnsuccessful()) {
          parambbmf.a(2131366632, ajya.a(2131704599), 2130838606);
        }
        a(paramChatMessage, parambbmf);
        if (apug.c(paramacva)) {
          i = 1;
        }
        if ((paramacva.status != 1) && (paramacva.status != -1))
        {
          j = i;
          if (paramacva.status != 3) {
            break label202;
          }
          if (paramacva.nOpType != 1)
          {
            j = i;
            if (paramacva.nOpType != 8) {
              break label202;
            }
          }
        }
        a(parambbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
        j = i;
      }
      label202:
      a(parambbmf, paramChatMessage);
      if (j != 0) {
        parambbmf.a(2131365928, ajya.a(2131704590), 2130838605);
      }
      if (paramacva.status != 16) {
        b(paramChatMessage, parambbmf);
      }
      if ((paramacva.getCloudType() != 1) || (paramacva.status != 2)) {
        super.c(parambbmf, this.jdField_a_of_type_AndroidContentContext);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    actj.n = true;
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
          if ((paramView.getId() != 2131371608) && (paramView.getId() != 2131364151))
          {
            super.onClick(paramView);
            return;
          }
          localMessageForFile = a(paramView);
        } while ((localMessageForFile.isMultiMsg) && (!apug.a(localMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext)));
        localFileManagerEntity = apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
        if (localFileManagerEntity == null)
        {
          QLog.e("FileVideoItemBuilder<FileAssistant>", 1, "get Entity by Msg faild!");
          return;
        }
      } while (localFileManagerEntity.status == 16);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68B", "0X800A68B", 0, 0, "4", "", "", "");
      if (apvm.a(localFileManagerEntity)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FileVideoItemBuilder<FileAssistant>", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    if ((localFileManagerEntity.sendCloudUnsuccessful()) && (!apvd.b(localFileManagerEntity.getFilePath())))
    {
      aptx.a(ajya.a(2131704588));
      return;
    }
    apuf localapuf = new apuf();
    localapuf.b = "file_viewer_in";
    localapuf.jdField_a_of_type_Int = 9;
    localapuf.c = apvd.a(localFileManagerEntity.fileName);
    localapuf.d = apug.a(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
    apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localapuf);
    apue.a("0X8004AE3");
    QLog.i("FileVideoItemBuilder<FileAssistant>", 1, "handle item click: file peerType[" + localFileManagerEntity.peerType + "]");
    int i;
    if (localFileManagerEntity.peerType == 0) {
      i = 1;
    }
    for (;;)
    {
      paramView = xpu.a(paramView);
      apvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageForFile, paramView, i, 10004, localFileManagerEntity, false, false);
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
 * Qualified Name:     adpq
 * JD-Core Version:    0.7.0.1
 */