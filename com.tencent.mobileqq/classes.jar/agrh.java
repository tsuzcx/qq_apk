import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agrh
  extends BaseBubbleBuilder
  implements afqq, arug
{
  boolean f = false;
  
  public agrh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  @SuppressLint({"ResourceAsColor"})
  @TargetApi(11)
  private RelativeLayout a(agrk paramagrk)
  {
    int i = AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.dp2px(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = AIOUtils.dp2px(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131364522);
    Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131366765);
    ((RelativeLayout)localObject2).setBackgroundResource(2130844228);
    ((RelativeLayout)localObject2).setPadding(AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), i, i, AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramagrk.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364522);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131366766);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, k);
    localLayoutParams.addRule(10, 2131366765);
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
    ((AsyncImageView)localObject2).setWidth(k);
    ((AsyncImageView)localObject2).setHeight(k);
    ((AsyncImageView)localObject2).setId(2131364491);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams.addRule(9, 2131366766);
    localLayoutParams.addRule(15, 2131366766);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramagrk.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131364492);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(9, 2131366766);
    localLayoutParams.addRule(15, 2131366766);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramagrk.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364493);
    ((TextView)localObject2).setGravity(16);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167045));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131364491);
    localLayoutParams.addRule(11, 2131366766);
    localLayoutParams.addRule(10, 2131366766);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramagrk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364490);
    ((TextView)localObject2).setSingleLine();
    if (VersionUtils.isHoneycomb()) {
      ((TextView)localObject2).setAlpha(0.75F);
    }
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(5, 2131364493);
    localLayoutParams.addRule(6, 2131364495);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramagrk.b = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364495);
    ((TextView)localObject2).setGravity(5);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131366766);
    localLayoutParams.addRule(12, 2131366766);
    localLayoutParams.addRule(1, 2131364490);
    localLayoutParams.leftMargin = i;
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramagrk.c = ((TextView)localObject2);
    return localRelativeLayout;
  }
  
  private void a(agrk paramagrk, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null)
    {
      paramagrk.c.setVisibility(8);
      return;
    }
    c(paramagrk, paramMessageForDeviceFile);
    b(paramagrk, paramMessageForDeviceFile);
  }
  
  private void a(agrk paramagrk, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramagrk.c.setVisibility(0);
    if ((!paramMessageForDeviceFile.isSend()) && (this.f)) {
      paramagrk.c.setText(paramString);
    }
  }
  
  private void a(agrk paramagrk, MessageForDeviceFile paramMessageForDeviceFile, String paramString, int paramInt1, int paramInt2)
  {
    if (paramMessageForDeviceFile.isSend())
    {
      paramagrk.c.setVisibility(paramInt1);
      return;
    }
    paramagrk.c.setVisibility(0);
    paramagrk.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(paramInt2));
  }
  
  private void a(agrk paramagrk, String paramString)
  {
    paramagrk.c.setVisibility(0);
    if (this.f) {
      paramagrk.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691524));
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, agrk paramagrk)
  {
    paramagrk.jdField_a_of_type_AndroidWidgetTextView.setText(auea.d(paramMessageForDeviceFile.srcFileName));
    paramagrk.b.setText(FileUtil.filesizeToString(paramMessageForDeviceFile.fileSize));
    auea.a(paramagrk.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForDeviceFile.filePath, auea.a(paramMessageForDeviceFile.filePath));
    paramagrk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((paramMessageForDeviceFile.strServiceName != null) && (paramMessageForDeviceFile.strServiceName.compareTo(abkw.c) == 0)) {
      this.f = true;
    }
    d(paramagrk, paramMessageForDeviceFile);
    a(paramagrk, paramMessageForDeviceFile);
    paramBaseChatItemLayout.setFailedIconVisable(a(paramMessageForDeviceFile), this);
  }
  
  private boolean a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {
      return false;
    }
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    case 11: 
    default: 
      return false;
    }
    return true;
  }
  
  private void b(agrk paramagrk, MessageForDeviceFile paramMessageForDeviceFile)
  {
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    case 0: 
    case 11: 
    default: 
      return;
    case -1: 
      a(paramagrk, paramMessageForDeviceFile, "", 8, 2131692294);
      return;
    case 1: 
    case 2: 
    case 3: 
      e(paramagrk, paramMessageForDeviceFile, "");
      return;
    case 4: 
      d(paramagrk, paramMessageForDeviceFile, "");
      return;
    case 6: 
      c(paramagrk, paramMessageForDeviceFile, "");
      return;
    case 5: 
      b(paramagrk, paramMessageForDeviceFile, "");
      return;
    case 9: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691516));
      return;
    case 8: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691517));
      return;
    case 19: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691518));
      return;
    case 10: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691521));
      return;
    case 12: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691523) + "（错误01）");
      return;
    case 13: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691523) + "（错误02）");
      return;
    case 14: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691523) + "（错误03）");
      return;
    case 15: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691523) + "（错误04）");
      return;
    case 16: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691523) + "（错误05）");
      return;
    case 17: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691523) + "（错误06）");
      return;
    case 20: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691523) + "（错误07）");
      return;
    case 21: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691523) + "（错误08）");
      return;
    case 22: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691523) + "（错误09）");
      return;
    case 24: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691523) + "（错误10）");
      return;
    case 25: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691523) + "（错误11）");
      return;
    case 18: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691523) + this.jdField_a_of_type_AndroidContentContext.getString(2131691521));
      return;
    case 23: 
      a(paramagrk, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691522));
      return;
    }
    a(paramagrk, "");
  }
  
  private void b(agrk paramagrk, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramagrk.c.setVisibility(0);
    if (paramMessageForDeviceFile.isSend())
    {
      if (this.f)
      {
        paramagrk.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691525));
        return;
      }
      paramagrk.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692293));
      return;
    }
    if (this.f)
    {
      paramagrk.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691520));
      return;
    }
    paramagrk.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692285));
  }
  
  private void c(agrk paramagrk, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if ((this.f) && (paramMessageForDeviceFile.issend == 0))
    {
      paramagrk.c.setMaxLines(3);
      return;
    }
    paramagrk.c.setMaxLines(2);
  }
  
  private void c(agrk paramagrk, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramagrk.c.setVisibility(0);
    if (paramMessageForDeviceFile.isSend())
    {
      paramagrk.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692292));
      return;
    }
    if (this.f)
    {
      paramagrk.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691515));
      return;
    }
    paramagrk.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692291));
  }
  
  private void c(MessageForDeviceFile paramMessageForDeviceFile) {}
  
  private void d(agrk paramagrk, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile != null) {}
    int i;
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    default: 
      i = 0;
      if (i != 0)
      {
        if (paramagrk.jdField_a_of_type_AndroidWidgetProgressBar == null)
        {
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
          localProgressBar.setId(2131364494);
          localProgressBar.setMax(100);
          localProgressBar.setMinimumHeight(AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838066));
          localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.addRule(3, 2131366766);
          localLayoutParams.addRule(12, 2131366765);
          localLayoutParams.setMargins(0, AIOUtils.dp2px(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramagrk.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localProgressBar, localLayoutParams);
          paramagrk.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
        }
        paramagrk.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
        paramagrk.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      break;
    }
    while (paramagrk.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      ProgressBar localProgressBar;
      RelativeLayout.LayoutParams localLayoutParams;
      return;
      i = 1;
      break;
    }
    paramagrk.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void d(agrk paramagrk, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    if (paramMessageForDeviceFile.isSend())
    {
      paramagrk.c.setVisibility(4);
      return;
    }
    paramagrk.c.setVisibility(0);
    paramagrk.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131693641));
  }
  
  private void e(agrk paramagrk, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    if (this.f)
    {
      paramagrk.c.setVisibility(0);
      if (paramMessageForDeviceFile.isSend())
      {
        paramagrk.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131719843));
        return;
      }
      paramagrk.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691519));
      return;
    }
    paramagrk.c.setVisibility(4);
  }
  
  private void e(View paramView)
  {
    Object localObject2 = (MessageForDeviceFile)AIOUtils.getMessage(paramView);
    paramView = auea.a((MessageForDeviceFile)localObject2);
    Object localObject1 = new ForwardFileInfo();
    if ((this.f) && (paramView.nFileType != 0)) {
      ((ForwardFileInfo)localObject1).b(10000);
    }
    Intent localIntent;
    for (;;)
    {
      ((ForwardFileInfo)localObject1).d(8);
      ((ForwardFileInfo)localObject1).b(paramView.nSessionId);
      ((ForwardFileInfo)localObject1).d(paramView.fileName);
      ((ForwardFileInfo)localObject1).c(paramView.uniseq);
      ((ForwardFileInfo)localObject1).d(paramView.fileSize);
      ((ForwardFileInfo)localObject1).a(paramView.getFilePath());
      ((ForwardFileInfo)localObject1).b(paramView.Uuid);
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, FileBrowserActivity.class);
      localIntent.putExtra("fileinfo", (Parcelable)localObject1);
      localObject1 = new ArrayList();
      if ((paramView.nFileType != 0) && (paramView.nFileType != 1)) {
        break;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAIOList(((MessageForDeviceFile)localObject2).frienduin, ((MessageForDeviceFile)localObject2).istroop);
      if ((localObject2 == null) || (((List)localObject2).size() == 0)) {
        break;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (ChatMessage)((Iterator)localObject2).next();
        if (((ChatMessage)localObject3).msgtype == -4500)
        {
          localObject3 = (MessageForDeviceFile)localObject3;
          if (auea.a(((MessageForDeviceFile)localObject3).filePath) == paramView.nFileType) {
            ((ArrayList)localObject1).add(String.valueOf(auea.a((MessageForDeviceFile)localObject3).nSessionId));
          }
        }
      }
      ((ForwardFileInfo)localObject1).b(10009);
    }
    localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject1);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 102);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqq a(View paramView)
  {
    return this;
  }
  
  public afqr a()
  {
    return new agrk(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaftk);
    ((agrk)paramChatMessage.getTag()).jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.e;
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    agrk localagrk = (agrk)paramafqr;
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a((agrk)paramafqr);
    }
    c(localMessageForDeviceFile);
    a(paramBaseChatItemLayout, localMessageForDeviceFile, localagrk);
    paramChatMessage.setOnLongClickListener(paramaftk);
    paramChatMessage.setOnTouchListener(paramaftk);
    paramChatMessage.setOnClickListener(this);
    localagrk.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((abkw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return anvx.a(2131702651);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForDeviceFile)))
    {
      paramContext = (MessageForDeviceFile)paramChatMessage;
      if (paramInt != 2131365475) {
        break label36;
      }
      admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    label36:
    do
    {
      return;
      if (paramInt == 2131371684)
      {
        super.d(paramChatMessage);
        return;
      }
    } while (paramInt != 2131367213);
    paramChatMessage = new Bundle();
    paramChatMessage.putInt("forward_type", 0);
    paramChatMessage.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    paramChatMessage.putInt("selection_mode", this.b);
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_filepath", paramContext.filePath);
    localIntent.putExtra("BUSI_TYPE", 1009);
    localIntent.putExtra("forward_download_image_org_uin", paramContext.frienduin);
    localIntent.putExtra("forward_download_image_org_uin_type", paramContext.istroop);
    localIntent.putExtra("forward_photo_isSend", paramContext.issend);
    localIntent.putExtras(paramChatMessage);
    aupt.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.getMessage(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForDeviceFile)((agrk)AIOUtils.getHolder(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
        localbkzi.a(2131689976, 5);
        localbkzi.c(2131690697);
        localbkzi.a(new agri(this, paramView, localbkzi));
        localbkzi.show();
        return;
      }
    } while (this.f);
    bkzi localbkzi = bkzi.a(this.jdField_a_of_type_AndroidContentContext);
    localbkzi.a(2131691514);
    localbkzi.b(2131691513);
    localbkzi.c(2131690697);
    localbkzi.a(new agrj(this, paramView, localbkzi));
    localbkzi.show();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (agrk)AIOUtils.getHolder(paramView);
    if (paramView == null) {}
    do
    {
      return;
      paramView = paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getBackground();
    } while (paramView == null);
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return;
    case 0: 
      paramView.setColorFilter(BaseBubbleBuilder.jdField_a_of_type_AndroidGraphicsColorFilter);
      paramView.invalidateSelf();
      return;
    }
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void a(View paramView, MessageForDeviceFile paramMessageForDeviceFile)
  {
    paramView = (agrk)AIOUtils.getHolder(paramView);
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "error get holder in updateview");
      }
    }
    MessageForDeviceFile localMessageForDeviceFile;
    do
    {
      return;
      localMessageForDeviceFile = (MessageForDeviceFile)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    } while (localMessageForDeviceFile.uniseq != paramMessageForDeviceFile.uniseq);
    localMessageForDeviceFile.msgStatus = paramMessageForDeviceFile.msgStatus;
    localMessageForDeviceFile.nFileStatus = paramMessageForDeviceFile.nFileStatus;
    localMessageForDeviceFile.progress = paramMessageForDeviceFile.progress;
    localMessageForDeviceFile.msg = paramMessageForDeviceFile.msg;
    a(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localMessageForDeviceFile, paramView);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    paramView = (agrk)AIOUtils.getHolder(paramView);
    if (paramView == null) {}
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getBackground();
    } while (localDrawable == null);
    if (paramBoolean) {}
    for (paramView = null;; paramView = jdField_a_of_type_AndroidGraphicsColorFilter)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  void a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      audr.a(2131692469);
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForDeviceFile.filePath)) {
      ((abkw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramMessageForDeviceFile.strServiceName, paramMessageForDeviceFile);
    }
    super.b();
  }
  
  public bhjs[] a(View paramView)
  {
    bhjq localbhjq = new bhjq();
    admh.a(localbhjq, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((agrk)AIOUtils.getHolder(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage).filePath)) {
      localbhjq.a(2131367213, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838991);
    }
    super.c(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    return localbhjq.a();
  }
  
  public void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      audr.a(2131692469);
      return;
    }
    ((abkw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramMessageForDeviceFile);
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.isUserOperatedInAIO = true;
    if (super.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)AIOUtils.getMessage(paramView);
      if ((paramView.getId() != 2131364531) || (localMessageForDeviceFile == null) || (localMessageForDeviceFile.uint32_src_uin_type != 1))
      {
        super.onClick(paramView);
        switch (paramView.getId())
        {
        case 2131364492: 
        case 2131364530: 
        default: 
          break;
        case 2131364522: 
          e(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrh
 * JD-Core Version:    0.7.0.1
 */