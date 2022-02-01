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

public class ahcf
  extends BaseBubbleBuilder
  implements aggk, arwz
{
  boolean f = false;
  
  public ahcf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  @SuppressLint({"ResourceAsColor"})
  @TargetApi(11)
  private RelativeLayout a(ahci paramahci)
  {
    int i = agej.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = agej.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = agej.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131364423);
    Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131366627);
    ((RelativeLayout)localObject2).setBackgroundResource(2130844276);
    ((RelativeLayout)localObject2).setPadding(agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), i, i, agej.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramahci.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364423);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131366628);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, k);
    localLayoutParams.addRule(10, 2131366627);
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
    ((AsyncImageView)localObject2).setWidth(k);
    ((AsyncImageView)localObject2).setHeight(k);
    ((AsyncImageView)localObject2).setId(2131364392);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams.addRule(9, 2131366628);
    localLayoutParams.addRule(15, 2131366628);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramahci.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131364393);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(9, 2131366628);
    localLayoutParams.addRule(15, 2131366628);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramahci.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364394);
    ((TextView)localObject2).setGravity(16);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167009));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131364392);
    localLayoutParams.addRule(11, 2131366628);
    localLayoutParams.addRule(10, 2131366628);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramahci.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364391);
    ((TextView)localObject2).setSingleLine();
    if (VersionUtils.isHoneycomb()) {
      ((TextView)localObject2).setAlpha(0.75F);
    }
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(5, 2131364394);
    localLayoutParams.addRule(6, 2131364396);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramahci.b = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364396);
    ((TextView)localObject2).setGravity(5);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131366628);
    localLayoutParams.addRule(12, 2131366628);
    localLayoutParams.addRule(1, 2131364391);
    localLayoutParams.leftMargin = i;
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramahci.c = ((TextView)localObject2);
    return localRelativeLayout;
  }
  
  private void a(ahci paramahci, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null)
    {
      paramahci.c.setVisibility(8);
      return;
    }
    c(paramahci, paramMessageForDeviceFile);
    b(paramahci, paramMessageForDeviceFile);
  }
  
  private void a(ahci paramahci, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramahci.c.setVisibility(0);
    if ((!paramMessageForDeviceFile.isSend()) && (this.f)) {
      paramahci.c.setText(paramString);
    }
  }
  
  private void a(ahci paramahci, MessageForDeviceFile paramMessageForDeviceFile, String paramString, int paramInt1, int paramInt2)
  {
    if (paramMessageForDeviceFile.isSend())
    {
      paramahci.c.setVisibility(paramInt1);
      return;
    }
    paramahci.c.setVisibility(0);
    paramahci.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(paramInt2));
  }
  
  private void a(ahci paramahci, String paramString)
  {
    paramahci.c.setVisibility(0);
    if (this.f) {
      paramahci.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691399));
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, ahci paramahci)
  {
    paramahci.jdField_a_of_type_AndroidWidgetTextView.setText(aunj.d(paramMessageForDeviceFile.srcFileName));
    paramahci.b.setText(auog.a(paramMessageForDeviceFile.fileSize));
    aunj.a(paramahci.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForDeviceFile.filePath, aunj.a(paramMessageForDeviceFile.filePath));
    paramahci.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((paramMessageForDeviceFile.strServiceName != null) && (paramMessageForDeviceFile.strServiceName.compareTo(abzb.c) == 0)) {
      this.f = true;
    }
    d(paramahci, paramMessageForDeviceFile);
    a(paramahci, paramMessageForDeviceFile);
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
  
  private void b(ahci paramahci, MessageForDeviceFile paramMessageForDeviceFile)
  {
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    case 0: 
    case 11: 
    default: 
      return;
    case -1: 
      a(paramahci, paramMessageForDeviceFile, "", 8, 2131692156);
      return;
    case 1: 
    case 2: 
    case 3: 
      e(paramahci, paramMessageForDeviceFile, "");
      return;
    case 4: 
      d(paramahci, paramMessageForDeviceFile, "");
      return;
    case 6: 
      c(paramahci, paramMessageForDeviceFile, "");
      return;
    case 5: 
      b(paramahci, paramMessageForDeviceFile, "");
      return;
    case 9: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691391));
      return;
    case 8: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691392));
      return;
    case 19: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691393));
      return;
    case 10: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691396));
      return;
    case 12: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691398) + "（错误01）");
      return;
    case 13: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691398) + "（错误02）");
      return;
    case 14: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691398) + "（错误03）");
      return;
    case 15: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691398) + "（错误04）");
      return;
    case 16: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691398) + "（错误05）");
      return;
    case 17: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691398) + "（错误06）");
      return;
    case 20: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691398) + "（错误07）");
      return;
    case 21: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691398) + "（错误08）");
      return;
    case 22: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691398) + "（错误09）");
      return;
    case 24: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691398) + "（错误10）");
      return;
    case 25: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691398) + "（错误11）");
      return;
    case 18: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691398) + this.jdField_a_of_type_AndroidContentContext.getString(2131691396));
      return;
    case 23: 
      a(paramahci, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691397));
      return;
    }
    a(paramahci, "");
  }
  
  private void b(ahci paramahci, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramahci.c.setVisibility(0);
    if (paramMessageForDeviceFile.isSend())
    {
      if (this.f)
      {
        paramahci.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691400));
        return;
      }
      paramahci.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692155));
      return;
    }
    if (this.f)
    {
      paramahci.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691395));
      return;
    }
    paramahci.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692147));
  }
  
  private void c(ahci paramahci, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if ((this.f) && (paramMessageForDeviceFile.issend == 0))
    {
      paramahci.c.setMaxLines(3);
      return;
    }
    paramahci.c.setMaxLines(2);
  }
  
  private void c(ahci paramahci, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramahci.c.setVisibility(0);
    if (paramMessageForDeviceFile.isSend())
    {
      paramahci.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692154));
      return;
    }
    if (this.f)
    {
      paramahci.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691390));
      return;
    }
    paramahci.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692153));
  }
  
  private void c(MessageForDeviceFile paramMessageForDeviceFile) {}
  
  private void d(ahci paramahci, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile != null) {}
    int i;
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    default: 
      i = 0;
      if (i != 0)
      {
        if (paramahci.jdField_a_of_type_AndroidWidgetProgressBar == null)
        {
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
          localProgressBar.setId(2131364395);
          localProgressBar.setMax(100);
          localProgressBar.setMinimumHeight(agej.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838027));
          localLayoutParams = new RelativeLayout.LayoutParams(-1, agej.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.addRule(3, 2131366628);
          localLayoutParams.addRule(12, 2131366627);
          localLayoutParams.setMargins(0, agej.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramahci.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localProgressBar, localLayoutParams);
          paramahci.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
        }
        paramahci.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
        paramahci.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      break;
    }
    while (paramahci.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      ProgressBar localProgressBar;
      RelativeLayout.LayoutParams localLayoutParams;
      return;
      i = 1;
      break;
    }
    paramahci.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void d(ahci paramahci, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    if (paramMessageForDeviceFile.isSend())
    {
      paramahci.c.setVisibility(4);
      return;
    }
    paramahci.c.setVisibility(0);
    paramahci.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131693365));
  }
  
  private void e(ahci paramahci, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    if (this.f)
    {
      paramahci.c.setVisibility(0);
      if (paramMessageForDeviceFile.isSend())
      {
        paramahci.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131719129));
        return;
      }
      paramahci.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691394));
      return;
    }
    paramahci.c.setVisibility(4);
  }
  
  private void e(View paramView)
  {
    Object localObject2 = (MessageForDeviceFile)agej.a(paramView);
    paramView = aunj.a((MessageForDeviceFile)localObject2);
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
          if (aunj.a(((MessageForDeviceFile)localObject3).filePath) == paramView.nFileType) {
            ((ArrayList)localObject1).add(String.valueOf(aunj.a((MessageForDeviceFile)localObject3).nSessionId));
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
  
  public aggk a(View paramView)
  {
    return this;
  }
  
  public aggl a()
  {
    return new ahci(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    ((ahci)paramChatMessage.getTag()).jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.e;
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    ahci localahci = (ahci)paramaggl;
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a((ahci)paramaggl);
    }
    c(localMessageForDeviceFile);
    a(paramBaseChatItemLayout, localMessageForDeviceFile, localahci);
    paramChatMessage.setOnLongClickListener(paramagjk);
    paramChatMessage.setOnTouchListener(paramagjk);
    paramChatMessage.setOnClickListener(this);
    localahci.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((abzb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return anzj.a(2131702065);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForDeviceFile)))
    {
      paramContext = (MessageForDeviceFile)paramChatMessage;
      if (paramInt != 2131365352) {
        break label36;
      }
      aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    label36:
    do
    {
      return;
      if (paramInt == 2131371530)
      {
        super.d(paramChatMessage);
        return;
      }
    } while (paramInt != 2131367078);
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
    auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (agej.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForDeviceFile)((ahci)agej.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        localblir = (blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null);
        localblir.a(2131689933, 5);
        localblir.c(2131690580);
        localblir.a(new ahcg(this, paramView, localblir));
        localblir.show();
        return;
      }
    } while (this.f);
    blir localblir = blir.a(this.jdField_a_of_type_AndroidContentContext);
    localblir.a(2131691389);
    localblir.b(2131691388);
    localblir.c(2131690580);
    localblir.a(new ahch(this, paramView, localblir));
    localblir.show();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (ahci)agej.a(paramView);
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
    paramView = (ahci)agej.a(paramView);
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
    paramView = (ahci)agej.a(paramView);
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
    if (!bhnv.d(this.jdField_a_of_type_AndroidContentContext))
    {
      auna.a(2131692319);
      return;
    }
    if (bhmi.b(paramMessageForDeviceFile.filePath)) {
      ((abzb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile.strServiceName, paramMessageForDeviceFile);
    }
    super.b();
  }
  
  public bhum[] a(View paramView)
  {
    bhuk localbhuk = new bhuk();
    aean.a(localbhuk, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((ahci)agej.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage).filePath)) {
      localbhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
    }
    super.c(localbhuk, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbhuk, this.jdField_a_of_type_AndroidContentContext);
    return localbhuk.a();
  }
  
  public void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!bhnv.d(this.jdField_a_of_type_AndroidContentContext))
    {
      auna.a(2131692319);
      return;
    }
    ((abzb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile);
  }
  
  public void onClick(View paramView)
  {
    agej.n = true;
    if (super.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)agej.a(paramView);
      if ((paramView.getId() != 2131364432) || (localMessageForDeviceFile == null) || (localMessageForDeviceFile.uint32_src_uin_type != 1))
      {
        super.onClick(paramView);
        switch (paramView.getId())
        {
        case 2131364393: 
        case 2131364431: 
        default: 
          break;
        case 2131364423: 
          e(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcf
 * JD-Core Version:    0.7.0.1
 */