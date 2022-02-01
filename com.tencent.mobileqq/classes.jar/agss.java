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
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class agss
  extends BaseBubbleBuilder
  implements afwq, arhk
{
  boolean f = false;
  
  public agss(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  @SuppressLint({"ResourceAsColor"})
  @TargetApi(11)
  private RelativeLayout a(agsv paramagsv)
  {
    int i = afur.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = afur.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = afur.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131364379);
    Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131366577);
    ((RelativeLayout)localObject2).setBackgroundResource(2130844262);
    ((RelativeLayout)localObject2).setPadding(afur.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), i, i, afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramagsv.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364379);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131366578);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, k);
    localLayoutParams.addRule(10, 2131366577);
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
    ((AsyncImageView)localObject2).setWidth(k);
    ((AsyncImageView)localObject2).setHeight(k);
    ((AsyncImageView)localObject2).setId(2131364348);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams.addRule(9, 2131366578);
    localLayoutParams.addRule(15, 2131366578);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramagsv.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131364349);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(9, 2131366578);
    localLayoutParams.addRule(15, 2131366578);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramagsv.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364350);
    ((TextView)localObject2).setGravity(16);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167004));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131364348);
    localLayoutParams.addRule(11, 2131366578);
    localLayoutParams.addRule(10, 2131366578);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramagsv.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364347);
    ((TextView)localObject2).setSingleLine();
    if (VersionUtils.isHoneycomb()) {
      ((TextView)localObject2).setAlpha(0.75F);
    }
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(5, 2131364350);
    localLayoutParams.addRule(6, 2131364352);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramagsv.b = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364352);
    ((TextView)localObject2).setGravity(5);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131366578);
    localLayoutParams.addRule(12, 2131366578);
    localLayoutParams.addRule(1, 2131364347);
    localLayoutParams.leftMargin = i;
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramagsv.c = ((TextView)localObject2);
    return localRelativeLayout;
  }
  
  private void a(agsv paramagsv, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null)
    {
      paramagsv.c.setVisibility(8);
      return;
    }
    c(paramagsv, paramMessageForDeviceFile);
    b(paramagsv, paramMessageForDeviceFile);
  }
  
  private void a(agsv paramagsv, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramagsv.c.setVisibility(0);
    if ((!paramMessageForDeviceFile.isSend()) && (this.f)) {
      paramagsv.c.setText(paramString);
    }
  }
  
  private void a(agsv paramagsv, MessageForDeviceFile paramMessageForDeviceFile, String paramString, int paramInt1, int paramInt2)
  {
    if (paramMessageForDeviceFile.isSend())
    {
      paramagsv.c.setVisibility(paramInt1);
      return;
    }
    paramagsv.c.setVisibility(0);
    paramagsv.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(paramInt2));
  }
  
  private void a(agsv paramagsv, String paramString)
  {
    paramagsv.c.setVisibility(0);
    if (this.f) {
      paramagsv.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691396));
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, agsv paramagsv)
  {
    paramagsv.jdField_a_of_type_AndroidWidgetTextView.setText(atvo.d(paramMessageForDeviceFile.srcFileName));
    paramagsv.b.setText(atwl.a(paramMessageForDeviceFile.fileSize));
    atvo.a(paramagsv.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForDeviceFile.filePath, atvo.a(paramMessageForDeviceFile.filePath));
    paramagsv.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((paramMessageForDeviceFile.strServiceName != null) && (paramMessageForDeviceFile.strServiceName.compareTo(abux.c) == 0)) {
      this.f = true;
    }
    d(paramagsv, paramMessageForDeviceFile);
    a(paramagsv, paramMessageForDeviceFile);
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
  
  private void b(agsv paramagsv, MessageForDeviceFile paramMessageForDeviceFile)
  {
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    case 0: 
    case 11: 
    default: 
      return;
    case -1: 
      a(paramagsv, paramMessageForDeviceFile, "", 8, 2131692151);
      return;
    case 1: 
    case 2: 
    case 3: 
      e(paramagsv, paramMessageForDeviceFile, "");
      return;
    case 4: 
      d(paramagsv, paramMessageForDeviceFile, "");
      return;
    case 6: 
      c(paramagsv, paramMessageForDeviceFile, "");
      return;
    case 5: 
      b(paramagsv, paramMessageForDeviceFile, "");
      return;
    case 9: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691388));
      return;
    case 8: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691389));
      return;
    case 19: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691390));
      return;
    case 10: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691393));
      return;
    case 12: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691395) + "（错误01）");
      return;
    case 13: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691395) + "（错误02）");
      return;
    case 14: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691395) + "（错误03）");
      return;
    case 15: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691395) + "（错误04）");
      return;
    case 16: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691395) + "（错误05）");
      return;
    case 17: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691395) + "（错误06）");
      return;
    case 20: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691395) + "（错误07）");
      return;
    case 21: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691395) + "（错误08）");
      return;
    case 22: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691395) + "（错误09）");
      return;
    case 24: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691395) + "（错误10）");
      return;
    case 25: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691395) + "（错误11）");
      return;
    case 18: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691395) + this.jdField_a_of_type_AndroidContentContext.getString(2131691393));
      return;
    case 23: 
      a(paramagsv, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691394));
      return;
    }
    a(paramagsv, "");
  }
  
  private void b(agsv paramagsv, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramagsv.c.setVisibility(0);
    if (paramMessageForDeviceFile.isSend())
    {
      if (this.f)
      {
        paramagsv.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691397));
        return;
      }
      paramagsv.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692150));
      return;
    }
    if (this.f)
    {
      paramagsv.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691392));
      return;
    }
    paramagsv.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692142));
  }
  
  private void c(agsv paramagsv, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if ((this.f) && (paramMessageForDeviceFile.issend == 0))
    {
      paramagsv.c.setMaxLines(3);
      return;
    }
    paramagsv.c.setMaxLines(2);
  }
  
  private void c(agsv paramagsv, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramagsv.c.setVisibility(0);
    if (paramMessageForDeviceFile.isSend())
    {
      paramagsv.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692149));
      return;
    }
    if (this.f)
    {
      paramagsv.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691387));
      return;
    }
    paramagsv.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692148));
  }
  
  private void c(MessageForDeviceFile paramMessageForDeviceFile) {}
  
  private void d(agsv paramagsv, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile != null) {}
    int i;
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    default: 
      i = 0;
      if (i != 0)
      {
        if (paramagsv.jdField_a_of_type_AndroidWidgetProgressBar == null)
        {
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
          localProgressBar.setId(2131364351);
          localProgressBar.setMax(100);
          localProgressBar.setMinimumHeight(afur.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838018));
          localLayoutParams = new RelativeLayout.LayoutParams(-1, afur.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.addRule(3, 2131366578);
          localLayoutParams.addRule(12, 2131366577);
          localLayoutParams.setMargins(0, afur.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramagsv.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localProgressBar, localLayoutParams);
          paramagsv.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
        }
        paramagsv.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
        paramagsv.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      break;
    }
    while (paramagsv.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      ProgressBar localProgressBar;
      RelativeLayout.LayoutParams localLayoutParams;
      return;
      i = 1;
      break;
    }
    paramagsv.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void d(agsv paramagsv, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    if (paramMessageForDeviceFile.isSend())
    {
      paramagsv.c.setVisibility(4);
      return;
    }
    paramagsv.c.setVisibility(0);
    paramagsv.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131693353));
  }
  
  private void e(agsv paramagsv, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    if (this.f)
    {
      paramagsv.c.setVisibility(0);
      if (paramMessageForDeviceFile.isSend())
      {
        paramagsv.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131718979));
        return;
      }
      paramagsv.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691391));
      return;
    }
    paramagsv.c.setVisibility(4);
  }
  
  private void e(View paramView)
  {
    Object localObject2 = (MessageForDeviceFile)afur.a(paramView);
    paramView = atvo.a((MessageForDeviceFile)localObject2);
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
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForDeviceFile)localObject2).frienduin, ((MessageForDeviceFile)localObject2).istroop);
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
          if (atvo.a(((MessageForDeviceFile)localObject3).filePath) == paramView.nFileType) {
            ((ArrayList)localObject1).add(String.valueOf(atvo.a((MessageForDeviceFile)localObject3).nSessionId));
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
  
  public afwq a(View paramView)
  {
    return this;
  }
  
  public afwr a()
  {
    return new agsv(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afzq paramafzq)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafzq);
    ((agsv)paramChatMessage.getTag()).jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.e;
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    agsv localagsv = (agsv)paramafwr;
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a((agsv)paramafwr);
    }
    c(localMessageForDeviceFile);
    a(paramBaseChatItemLayout, localMessageForDeviceFile, localagsv);
    paramChatMessage.setOnLongClickListener(paramafzq);
    paramChatMessage.setOnTouchListener(paramafzq);
    paramChatMessage.setOnClickListener(this);
    localagsv.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return anni.a(2131701958);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForDeviceFile)))
    {
      paramContext = (MessageForDeviceFile)paramChatMessage;
      if (paramInt != 2131365308) {
        break label36;
      }
      adrm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    label36:
    do
    {
      return;
      if (paramInt == 2131371422)
      {
        super.d(paramChatMessage);
        return;
      }
    } while (paramInt != 2131367027);
    paramChatMessage = new Bundle();
    paramChatMessage.putInt("forward_type", 0);
    paramChatMessage.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    paramChatMessage.putInt("selection_mode", this.b);
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_filepath", paramContext.filePath);
    localIntent.putExtra("BUSI_TYPE", 1009);
    localIntent.putExtra("forward_download_image_org_uin", paramContext.frienduin);
    localIntent.putExtra("forward_download_image_org_uin_type", paramContext.istroop);
    localIntent.putExtra("forward_photo_isSend", paramContext.issend);
    localIntent.putExtras(paramChatMessage);
    aufz.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (afur.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForDeviceFile)((agsv)afur.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        localbkho = (bkho)bkif.a(this.jdField_a_of_type_AndroidContentContext, null);
        localbkho.a(2131689926, 5);
        localbkho.c(2131690582);
        localbkho.a(new agst(this, paramView, localbkho));
        localbkho.show();
        return;
      }
    } while (this.f);
    bkho localbkho = bkho.a(this.jdField_a_of_type_AndroidContentContext);
    localbkho.a(2131691386);
    localbkho.b(2131691385);
    localbkho.c(2131690582);
    localbkho.a(new agsu(this, paramView, localbkho));
    localbkho.show();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (agsv)afur.a(paramView);
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
    paramView = (agsv)afur.a(paramView);
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
    paramView = (agsv)afur.a(paramView);
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
    if (!bgnt.d(this.jdField_a_of_type_AndroidContentContext))
    {
      atvf.a(2131692314);
      return;
    }
    if (bgmg.b(paramMessageForDeviceFile.filePath)) {
      ((abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile.strServiceName, paramMessageForDeviceFile);
    }
    super.b();
  }
  
  public bguj[] a(View paramView)
  {
    bguh localbguh = new bguh();
    adrm.a(localbguh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((agsv)afur.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage).filePath)) {
      localbguh.a(2131367027, this.jdField_a_of_type_AndroidContentContext.getString(2131692395), 2130838929);
    }
    super.c(localbguh, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbguh, this.jdField_a_of_type_AndroidContentContext);
    return localbguh.a();
  }
  
  public void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!bgnt.d(this.jdField_a_of_type_AndroidContentContext))
    {
      atvf.a(2131692314);
      return;
    }
    ((abux)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile);
  }
  
  public void onClick(View paramView)
  {
    afur.n = true;
    if (super.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)afur.a(paramView);
      if ((paramView.getId() != 2131364388) || (localMessageForDeviceFile == null) || (localMessageForDeviceFile.uint32_src_uin_type != 1))
      {
        super.onClick(paramView);
        switch (paramView.getId())
        {
        case 2131364349: 
        case 2131364387: 
        default: 
          break;
        case 2131364379: 
          e(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agss
 * JD-Core Version:    0.7.0.1
 */