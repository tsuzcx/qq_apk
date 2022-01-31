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

public class adps
  extends BaseBubbleBuilder
{
  protected View a;
  private aotz a;
  public Handler b;
  
  private void a(String paramString1, String paramString2, adpw paramadpw, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramadpw.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramadpw.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramadpw.jdField_a_of_type_AndroidViewView).removeView(paramadpw.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131364078);
    localRelativeLayout.setBackgroundResource(2130838791);
    paramadpw.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
    Object localObject = new RelativeLayout.LayoutParams(-1, actn.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).addRule(5, 2131371608);
      ((RelativeLayout.LayoutParams)localObject).addRule(7, 2131371608);
      if (paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject).rightMargin = actn.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
        int i = apvk.a(paramadpw.e, paramadpw.f);
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(2131364078);
        paramViewGroup.setTextSize(2, 12.0F);
        paramViewGroup.setTextColor(-1);
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).leftMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).rightMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        localRelativeLayout.addView(paramViewGroup, (ViewGroup.LayoutParams)localObject);
        localObject = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
        ((TextView)localObject).setId(2131364081);
        ((TextView)localObject).setTextSize(2, 14.0F);
        ((TextView)localObject).setTextColor(-1);
        ((TextView)localObject).setSingleLine();
        ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.rightMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.bottomMargin = actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (i != 1) {
          break label513;
        }
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(2, 2131364078);
        label412:
        localRelativeLayout.addView((View)localObject, localLayoutParams);
        paramString1 = apvk.a(this.jdField_a_of_type_AndroidContentContext, i, paramadpw.e, (TextView)localObject, paramViewGroup, paramString1, paramString2);
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
      ((RelativeLayout.LayoutParams)localObject).leftMargin = actn.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
  
  public acum a(View paramView)
  {
    if (paramView != null)
    {
      paramView = actn.a(paramView);
      if ((paramView != null) && (adpw.class.isInstance(paramView)))
      {
        paramView = (adpw)paramView;
        if (paramView != null) {
          return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
        }
      }
    }
    return null;
  }
  
  public acun a()
  {
    return new adpw(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxn paramacxn)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxn);
    paramViewGroup = (acun)actn.a(paramView);
    this.jdField_a_of_type_Aotz.a(paramViewGroup, paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    adpw localadpw;
    if (adpw.class.isInstance(paramacun)) {
      localadpw = (adpw)paramacun;
    }
    for (paramacun = paramView;; paramacun = null)
    {
      this.jdField_a_of_type_AndroidContentContext.getResources();
      Object localObject = paramacun;
      if (paramacun == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramacun = new BubbleVideoView(this.jdField_a_of_type_AndroidContentContext);
        paramacun.setId(2131371608);
        paramacun.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramacun.setRadius(15.0F);
        paramacun.d(true);
        paramacun.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(paramacun);
        MessageProgressView localMessageProgressView = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
        localMessageProgressView.setId(2131364152);
        ((RelativeLayout)localObject).addView(localMessageProgressView);
        paramacun.setOnClickListener(this);
        super.a(paramacun, paramacxn);
        localadpw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramacun;
        localadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      boolean bool = paramChatMessage.isSend();
      if (localadpw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool)
      {
        localadpw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool;
        localadpw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
      }
      localadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      super.a(localadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView, paramacxn);
      localadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
      localadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
      localadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
      localadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      localadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
      localadpw.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramChatMessage, localadpw, paramView, paramBaseChatItemLayout);
      return localObject;
      localadpw = new adpw(this);
      localadpw.jdField_b_of_type_JavaLangStringBuilder = paramacun.jdField_b_of_type_JavaLangStringBuilder;
      localadpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramacun.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localadpw.jdField_a_of_type_AndroidViewView = paramacun.jdField_a_of_type_AndroidViewView;
      localadpw.jdField_a_of_type_Ambh = paramacun.jdField_a_of_type_Ambh;
      localadpw.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramacun.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      localadpw.jdField_a_of_type_Int = paramacun.jdField_a_of_type_Int;
      localadpw.jdField_b_of_type_Int = paramacun.jdField_b_of_type_Int;
      localadpw.c = paramacun.c;
      localadpw.d = paramacun.d;
      localadpw.jdField_a_of_type_JavaLangString = paramacun.jdField_a_of_type_JavaLangString;
    }
  }
  
  public bblr a(bblr parambblr, ChatMessage paramChatMessage, acve paramacve)
  {
    paramChatMessage = (MessageForFile)paramChatMessage;
    paramacve = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    int j;
    if (paramacve != null)
    {
      j = 0;
      if (paramacve.status != 16) {
        b(parambblr, this.jdField_a_of_type_AndroidContentContext);
      }
      if ((!paramChatMessage.isSendFromLocal()) || (paramacve.status != 2)) {
        break label56;
      }
    }
    label56:
    int i;
    do
    {
      return parambblr;
      i = j;
      if (paramacve.status != 16)
      {
        if (!paramacve.sendCloudUnsuccessful()) {
          parambblr.a(2131366632, ajyc.a(2131704593), 2130838606);
        }
        i = j;
        if (apue.c(paramacve)) {
          i = 1;
        }
      }
    } while (i == 0);
    parambblr.a(2131365928, ajyc.a(2131704587), 2130838605);
    return parambblr;
  }
  
  public MessageForFile a(View paramView)
  {
    paramView = (acve)actn.a(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg) {
      return (MessageForFile)apue.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    }
    return (MessageForFile)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bbet.a(paramChatMessage.issend)) {
      return ajyc.a(2131704591);
    }
    return ajyc.a(2131704581);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
    case 2131370494: 
    case 2131375571: 
    case 2131365928: 
      do
      {
        do
        {
          return;
          long l1 = awzw.a();
          long l2 = paramChatMessage.time;
          if ((paramChatMessage.msgtype == -2005) && (paramChatMessage.istroop == 3000) && (l1 - l2 > 604800L))
          {
            aptv.a(ajyc.a(2131704592));
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
            return;
          }
          a(paramChatMessage);
          apuc.a("0X8005E4B");
          return;
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
          if (!apsz.a((MessageForFile)paramChatMessage).a(false)) {
            break;
          }
        } while (!bcvm.a((Activity)paramContext, 5, new adpt(this, paramChatMessage, paramContext)));
        aptr.a(paramContext, 2131692672, 2131692675, new adpu(this, paramChatMessage, paramContext));
        return;
        apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramContext);
        return;
        paramContext = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
        new bgpd(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, paramContext, paramChatMessage, false);
      } while (!paramChatMessage.isMultiMsg);
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
      return;
    case 2131366659: 
      apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramContext);
      return;
    case 2131366632: 
      paramContext = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
      localObject = new apud();
      ((apud)localObject).b = "file_forward";
      ((apud)localObject).jdField_a_of_type_Int = 9;
      ((apud)localObject).jdField_a_of_type_Long = paramContext.fileSize;
      ((apud)localObject).c = apvb.a(paramContext.fileName);
      ((apud)localObject).d = apue.a(paramContext.getCloudType(), paramContext.peerType);
      apuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (apud)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("forward_type", 0);
      ((Bundle)localObject).putBoolean("not_forward", true);
      ((Bundle)localObject).putInt("selection_mode", this.jdField_b_of_type_Int);
      ((Bundle)localObject).putParcelable("fileinfo", aqce.a(paramContext, paramChatMessage));
      ((Bundle)localObject).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      Intent localIntent = new Intent();
      localIntent.putExtras((Bundle)localObject);
      localIntent.putExtra("forward_text", ajyc.a(2131704585) + apue.d(paramContext.fileName) + ajyc.a(2131704589) + apvb.a(paramContext.fileSize) + "。");
      localIntent.putExtra("direct_send_if_dataline_forward", true);
      localIntent.putExtra("forward _key_nojump", true);
      if (!bbev.d(BaseApplication.getContext())) {
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131694672, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      }
      for (;;)
      {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
        if (!paramChatMessage.isMultiMsg) {
          break;
        }
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
        return;
        aqbc.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
      }
    case 2131364985: 
      aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      paramContext = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext);
      return;
    case 2131370537: 
      super.d(paramChatMessage);
      return;
    case 2131363865: 
      paramContext = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramContext.nSessionId);
      b();
      return;
    }
    paramContext = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramChatMessage);
    axqw.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    Object localObject = xpx.a(this.jdField_a_of_type_AndroidViewView);
    paramInt = 0;
    if (paramContext.peerType == 0) {
      paramInt = 1;
    }
    for (;;)
    {
      apvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, (Rect)localObject, paramInt, 10004, paramContext, true, false);
      return;
      if (paramContext.peerType == 3000) {
        paramInt = 5;
      } else {
        QLog.w("FileVideoItemBuilder<FileAssistant>", 1, "entranceType is unknow ,peerType:" + paramContext.peerType);
      }
    }
  }
  
  protected void a(adpw paramadpw, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 100)
    {
      paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramadpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramadpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692446);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692445);
    bfol localbfol = (bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbfol.c(str1);
    localbfol.d(this.jdField_a_of_type_AndroidContentContext.getString(2131690596));
    localbfol.a(str2);
    localbfol.a(new adpv(this, paramView, localbfol));
    localbfol.show();
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
  
  protected void a(ChatMessage paramChatMessage, adpw paramadpw, View paramView, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramView = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    Object localObject = localFileManagerEntity.fileName + localFileManagerEntity.nSessionId;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject))
    {
      axqw.b(null, "dc00898", "", "", "0X800A686", "0X800A686", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject);
    }
    paramView.fileName = localFileManagerEntity.fileName;
    if ((localFileManagerEntity.cloudType == 1) && (apue.a(localFileManagerEntity))) {
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
      paramView = paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (paramView != null) {
        break label557;
      }
      paramView = new RelativeLayout.LayoutParams(i, j);
      paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
      label310:
      paramView = paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (paramView != null) {
        break label598;
      }
      paramView = new LinearLayout.LayoutParams(i, j);
      paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramView);
      label342:
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoItemBuilder<FileAssistant>", 1, "Id[" + localFileManagerEntity.nSessionId + "]show AIOFileVideoItem,use size(wh)[" + i + ":" + j + "]");
      }
      paramadpw.e = i;
      paramadpw.f = j;
      if (paramadpw.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramadpw.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        ((RelativeLayout)paramadpw.jdField_a_of_type_AndroidViewView).removeView(paramadpw.jdField_b_of_type_AndroidWidgetRelativeLayout);
      }
      localObject = new anou(Color.rgb(214, 214, 214), i, j);
      paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      if (localFileManagerEntity.status != 2) {
        break label639;
      }
      a(paramadpw, (int)(localFileManagerEntity.fProgress * 100.0F), true);
      label505:
      if ((!localFileManagerEntity.bCannotPlay) && (localFileManagerEntity.status != 16)) {
        break label929;
      }
      a(localFileManagerEntity, paramadpw);
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
      paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
      break label310;
      label598:
      if ((paramView.width == i) && (paramView.height == j)) {
        break label342;
      }
      paramView.width = i;
      paramView.height = j;
      paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramView);
      break label342;
      label639:
      if (localFileManagerEntity.status == 0)
      {
        paramView = ajyc.a(2131704583);
        paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130848692);
        paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramView);
        paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
        paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
        break label505;
      }
      if (localFileManagerEntity.status == 3)
      {
        paramView = ajyc.a(2131704578);
        paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramView);
        if (paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
        {
          paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishResource(2130848692);
          paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramadpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          break label505;
        }
        paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130848692);
        paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
        break label505;
      }
      if (paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
      {
        paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
        paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramadpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadpw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        break label505;
      }
      paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      break label505;
      label929:
      paramView = bbdj.a(localFileManagerEntity.fileSize);
      a(localFileManagerEntity.fileName, paramView, paramadpw, (RelativeLayout)paramadpw.jdField_a_of_type_AndroidViewView, false);
      paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(0);
      paramBaseChatItemLayout = localFileManagerEntity.strLargeThumPath;
      paramView = paramBaseChatItemLayout;
      if (paramChatMessage.isMultiMsg)
      {
        paramView = paramBaseChatItemLayout;
        if (TextUtils.isEmpty(paramBaseChatItemLayout)) {
          paramView = apue.a(paramChatMessage);
        }
      }
      if (apvb.b(paramView))
      {
        paramChatMessage = ShortVideoUtils.a(paramView);
        if ((paramadpw.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramadpw.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramChatMessage)))
        {
          paramChatMessage = URLDrawable.getDrawable(paramChatMessage, i, j, (Drawable)localObject, (Drawable)localObject);
          paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramChatMessage);
          paramadpw.jdField_a_of_type_ComTencentImageURLDrawable = paramChatMessage;
          paramChatMessage = URLDrawable.URLDrawableOptions.obtain();
          paramChatMessage.mLoadingDrawable = new ColorDrawable(-16777216);
          URLDrawable.getDrawable(new File(paramView), paramChatMessage);
        }
        while ((localFileManagerEntity != null) && ((localFileManagerEntity.imgWidth <= 0) || (localFileManagerEntity.imgHeight <= 0)))
        {
          apue.e(localFileManagerEntity);
          return;
          if (paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getDrawable() != paramadpw.jdField_a_of_type_ComTencentImageURLDrawable) {
            paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramadpw.jdField_a_of_type_ComTencentImageURLDrawable);
          }
        }
      }
      else
      {
        paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageResource(2130843502);
        if ((apvb.b(localFileManagerEntity.getFilePath())) && (apue.b(localFileManagerEntity)))
        {
          ThreadManager.executeOnSubThread(new FileVideoItemBuilder.1(this, localFileManagerEntity));
          return;
        }
        if (localFileManagerEntity.peerType == 3000) {}
        for (paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localFileManagerEntity); bbdj.b(paramChatMessage); paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity))
        {
          ThreadManager.executeOnSubThread(new FileVideoItemBuilder.2(this, localFileManagerEntity, paramChatMessage));
          return;
        }
      }
    }
  }
  
  protected void a(FileManagerEntity paramFileManagerEntity, adpw paramadpw)
  {
    if (paramadpw.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramadpw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    float f = this.jdField_a_of_type_Float;
    Object localObject = new adkl(Color.parseColor("#D8DAE0"), 255, f * 8.0F);
    if (Build.VERSION.SDK_INT >= 16)
    {
      localRelativeLayout.setBackground((Drawable)localObject);
      localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      if (paramFileManagerEntity.status != 16) {
        break label268;
      }
      ((TextView)localObject).setText(ajyc.a(2131704580));
    }
    for (;;)
    {
      ((TextView)localObject).setCompoundDrawablePadding(actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130848693, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramadpw.e, paramadpw.f - 40);
      ((RelativeLayout)paramadpw.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = bbdj.a(paramFileManagerEntity.fileSize);
      a(paramFileManagerEntity.fileName, (String)localObject, paramadpw, localRelativeLayout, true);
      paramadpw.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable((Drawable)localObject);
      break;
      label268:
      ((TextView)localObject).setText(ajyc.a(2131704582));
    }
  }
  
  public bblt[] a(View paramView)
  {
    MessageForFile localMessageForFile = a(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramView = new bblr();
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
  
  public bblr b(bblr parambblr, ChatMessage paramChatMessage, acve paramacve)
  {
    paramChatMessage = (MessageForFile)paramChatMessage;
    paramacve = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    if (paramacve.status != 16) {
      b(parambblr, this.jdField_a_of_type_AndroidContentContext);
    }
    int j = 0;
    int i = 0;
    if ((paramChatMessage.isSendFromLocal()) && (paramacve.status == 2)) {
      parambblr.a(2131363865, this.jdField_a_of_type_AndroidContentContext.getString(2131690707), 2130838595);
    }
    for (;;)
    {
      super.e(parambblr, this.jdField_a_of_type_AndroidContentContext);
      do
      {
        return parambblr;
      } while (paramacve == null);
      if (paramacve.status != 16)
      {
        if (!paramacve.sendCloudUnsuccessful()) {
          parambblr.a(2131366632, ajyc.a(2131704588), 2130838606);
        }
        a(paramChatMessage, parambblr);
        if (apue.c(paramacve)) {
          i = 1;
        }
        if ((paramacve.status != 1) && (paramacve.status != -1))
        {
          j = i;
          if (paramacve.status != 3) {
            break label202;
          }
          if (paramacve.nOpType != 1)
          {
            j = i;
            if (paramacve.nOpType != 8) {
              break label202;
            }
          }
        }
        a(parambblr, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
        j = i;
      }
      label202:
      a(parambblr, paramChatMessage);
      if (j != 0) {
        parambblr.a(2131365928, ajyc.a(2131704579), 2130838605);
      }
      if (paramacve.status != 16) {
        b(paramChatMessage, parambblr);
      }
      if ((paramacve.getCloudType() != 1) || (paramacve.status != 2)) {
        super.c(parambblr, this.jdField_a_of_type_AndroidContentContext);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    actn.n = true;
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
          if ((paramView.getId() != 2131371608) && (paramView.getId() != 2131364152))
          {
            super.onClick(paramView);
            return;
          }
          localMessageForFile = a(paramView);
        } while ((localMessageForFile.isMultiMsg) && (!apue.a(localMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext)));
        localFileManagerEntity = apue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForFile);
        if (localFileManagerEntity == null)
        {
          QLog.e("FileVideoItemBuilder<FileAssistant>", 1, "get Entity by Msg faild!");
          return;
        }
      } while (localFileManagerEntity.status == 16);
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68B", "0X800A68B", 0, 0, "4", "", "", "");
      if (apvk.a(localFileManagerEntity)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FileVideoItemBuilder<FileAssistant>", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    if ((localFileManagerEntity.sendCloudUnsuccessful()) && (!apvb.b(localFileManagerEntity.getFilePath())))
    {
      aptv.a(ajyc.a(2131704577));
      return;
    }
    apud localapud = new apud();
    localapud.b = "file_viewer_in";
    localapud.jdField_a_of_type_Int = 9;
    localapud.c = apvb.a(localFileManagerEntity.fileName);
    localapud.d = apue.a(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
    apuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localapud);
    apuc.a("0X8004AE3");
    QLog.i("FileVideoItemBuilder<FileAssistant>", 1, "handle item click: file peerType[" + localFileManagerEntity.peerType + "]");
    int i;
    if (localFileManagerEntity.peerType == 0) {
      i = 1;
    }
    for (;;)
    {
      paramView = xpx.a(paramView);
      apvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageForFile, paramView, i, 10004, localFileManagerEntity, false, false);
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
 * Qualified Name:     adps
 * JD-Core Version:    0.7.0.1
 */