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

public class afyr
  extends BaseBubbleBuilder
  implements aeze, aqqv
{
  boolean f = false;
  
  public afyr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  @SuppressLint({"ResourceAsColor"})
  @TargetApi(11)
  private RelativeLayout a(afyu paramafyu)
  {
    int i = AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = AIOUtils.dp2px(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = AIOUtils.dp2px(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131364441);
    Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131366654);
    ((RelativeLayout)localObject2).setBackgroundResource(2130844161);
    ((RelativeLayout)localObject2).setPadding(AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), i, i, AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramafyu.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364441);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131366655);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, k);
    localLayoutParams.addRule(10, 2131366654);
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
    ((AsyncImageView)localObject2).setWidth(k);
    ((AsyncImageView)localObject2).setHeight(k);
    ((AsyncImageView)localObject2).setId(2131364410);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams.addRule(9, 2131366655);
    localLayoutParams.addRule(15, 2131366655);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramafyu.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131364411);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(9, 2131366655);
    localLayoutParams.addRule(15, 2131366655);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramafyu.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364412);
    ((TextView)localObject2).setGravity(16);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167031));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131364410);
    localLayoutParams.addRule(11, 2131366655);
    localLayoutParams.addRule(10, 2131366655);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramafyu.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364409);
    ((TextView)localObject2).setSingleLine();
    if (VersionUtils.isHoneycomb()) {
      ((TextView)localObject2).setAlpha(0.75F);
    }
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(5, 2131364412);
    localLayoutParams.addRule(6, 2131364414);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramafyu.b = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364414);
    ((TextView)localObject2).setGravity(5);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131366655);
    localLayoutParams.addRule(12, 2131366655);
    localLayoutParams.addRule(1, 2131364409);
    localLayoutParams.leftMargin = i;
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramafyu.c = ((TextView)localObject2);
    return localRelativeLayout;
  }
  
  private void a(afyu paramafyu, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null)
    {
      paramafyu.c.setVisibility(8);
      return;
    }
    c(paramafyu, paramMessageForDeviceFile);
    b(paramafyu, paramMessageForDeviceFile);
  }
  
  private void a(afyu paramafyu, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramafyu.c.setVisibility(0);
    if ((!paramMessageForDeviceFile.isSend()) && (this.f)) {
      paramafyu.c.setText(paramString);
    }
  }
  
  private void a(afyu paramafyu, MessageForDeviceFile paramMessageForDeviceFile, String paramString, int paramInt1, int paramInt2)
  {
    if (paramMessageForDeviceFile.isSend())
    {
      paramafyu.c.setVisibility(paramInt1);
      return;
    }
    paramafyu.c.setVisibility(0);
    paramafyu.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(paramInt2));
  }
  
  private void a(afyu paramafyu, String paramString)
  {
    paramafyu.c.setVisibility(0);
    if (this.f) {
      paramafyu.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691439));
    }
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, afyu paramafyu)
  {
    paramafyu.jdField_a_of_type_AndroidWidgetTextView.setText(aszt.d(paramMessageForDeviceFile.srcFileName));
    paramafyu.b.setText(FileUtil.filesizeToString(paramMessageForDeviceFile.fileSize));
    aszt.a(paramafyu.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForDeviceFile.filePath, aszt.a(paramMessageForDeviceFile.filePath));
    paramafyu.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((paramMessageForDeviceFile.strServiceName != null) && (paramMessageForDeviceFile.strServiceName.compareTo(aavk.c) == 0)) {
      this.f = true;
    }
    d(paramafyu, paramMessageForDeviceFile);
    a(paramafyu, paramMessageForDeviceFile);
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
  
  private void b(afyu paramafyu, MessageForDeviceFile paramMessageForDeviceFile)
  {
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    case 0: 
    case 11: 
    default: 
      return;
    case -1: 
      a(paramafyu, paramMessageForDeviceFile, "", 8, 2131692204);
      return;
    case 1: 
    case 2: 
    case 3: 
      e(paramafyu, paramMessageForDeviceFile, "");
      return;
    case 4: 
      d(paramafyu, paramMessageForDeviceFile, "");
      return;
    case 6: 
      c(paramafyu, paramMessageForDeviceFile, "");
      return;
    case 5: 
      b(paramafyu, paramMessageForDeviceFile, "");
      return;
    case 9: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691431));
      return;
    case 8: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691432));
      return;
    case 19: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691433));
      return;
    case 10: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691436));
      return;
    case 12: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691438) + "（错误01）");
      return;
    case 13: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691438) + "（错误02）");
      return;
    case 14: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691438) + "（错误03）");
      return;
    case 15: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691438) + "（错误04）");
      return;
    case 16: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691438) + "（错误05）");
      return;
    case 17: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691438) + "（错误06）");
      return;
    case 20: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691438) + "（错误07）");
      return;
    case 21: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691438) + "（错误08）");
      return;
    case 22: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691438) + "（错误09）");
      return;
    case 24: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691438) + "（错误10）");
      return;
    case 25: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691438) + "（错误11）");
      return;
    case 18: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691438) + this.jdField_a_of_type_AndroidContentContext.getString(2131691436));
      return;
    case 23: 
      a(paramafyu, paramMessageForDeviceFile, "" + this.jdField_a_of_type_AndroidContentContext.getString(2131691437));
      return;
    }
    a(paramafyu, "");
  }
  
  private void b(afyu paramafyu, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramafyu.c.setVisibility(0);
    if (paramMessageForDeviceFile.isSend())
    {
      if (this.f)
      {
        paramafyu.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691440));
        return;
      }
      paramafyu.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692203));
      return;
    }
    if (this.f)
    {
      paramafyu.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691435));
      return;
    }
    paramafyu.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692195));
  }
  
  private void c(afyu paramafyu, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if ((this.f) && (paramMessageForDeviceFile.issend == 0))
    {
      paramafyu.c.setMaxLines(3);
      return;
    }
    paramafyu.c.setMaxLines(2);
  }
  
  private void c(afyu paramafyu, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    paramafyu.c.setVisibility(0);
    if (paramMessageForDeviceFile.isSend())
    {
      paramafyu.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692202));
      return;
    }
    if (this.f)
    {
      paramafyu.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691430));
      return;
    }
    paramafyu.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131692201));
  }
  
  private void c(MessageForDeviceFile paramMessageForDeviceFile) {}
  
  private void d(afyu paramafyu, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile != null) {}
    int i;
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    default: 
      i = 0;
      if (i != 0)
      {
        if (paramafyu.jdField_a_of_type_AndroidWidgetProgressBar == null)
        {
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
          localProgressBar.setId(2131364413);
          localProgressBar.setMax(100);
          localProgressBar.setMinimumHeight(AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838052));
          localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.addRule(3, 2131366655);
          localLayoutParams.addRule(12, 2131366654);
          localLayoutParams.setMargins(0, AIOUtils.dp2px(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramafyu.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localProgressBar, localLayoutParams);
          paramafyu.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
        }
        paramafyu.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
        paramafyu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      break;
    }
    while (paramafyu.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      ProgressBar localProgressBar;
      RelativeLayout.LayoutParams localLayoutParams;
      return;
      i = 1;
      break;
    }
    paramafyu.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void d(afyu paramafyu, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    if (paramMessageForDeviceFile.isSend())
    {
      paramafyu.c.setVisibility(4);
      return;
    }
    paramafyu.c.setVisibility(0);
    paramafyu.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131693460));
  }
  
  private void e(afyu paramafyu, MessageForDeviceFile paramMessageForDeviceFile, String paramString)
  {
    if (this.f)
    {
      paramafyu.c.setVisibility(0);
      if (paramMessageForDeviceFile.isSend())
      {
        paramafyu.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131719415));
        return;
      }
      paramafyu.c.setText(paramString + this.jdField_a_of_type_AndroidContentContext.getString(2131691434));
      return;
    }
    paramafyu.c.setVisibility(4);
  }
  
  private void e(View paramView)
  {
    Object localObject2 = (MessageForDeviceFile)AIOUtils.getMessage(paramView);
    paramView = aszt.a((MessageForDeviceFile)localObject2);
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
          if (aszt.a(((MessageForDeviceFile)localObject3).filePath) == paramView.nFileType) {
            ((ArrayList)localObject1).add(String.valueOf(aszt.a((MessageForDeviceFile)localObject3).nSessionId));
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
  
  public aeze a(View paramView)
  {
    return this;
  }
  
  public aezf a()
  {
    return new afyu(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afce paramafce)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafce);
    ((afyu)paramChatMessage.getTag()).jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.e;
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    afyu localafyu = (afyu)paramaezf;
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a((afyu)paramaezf);
    }
    c(localMessageForDeviceFile);
    a(paramBaseChatItemLayout, localMessageForDeviceFile, localafyu);
    paramChatMessage.setOnLongClickListener(paramafce);
    paramChatMessage.setOnTouchListener(paramafce);
    paramChatMessage.setOnClickListener(this);
    localafyu.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((aavk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(49)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return amtj.a(2131702300);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForDeviceFile)))
    {
      paramContext = (MessageForDeviceFile)paramChatMessage;
      if (paramInt != 2131365382) {
        break label36;
      }
      acvv.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    label36:
    do
    {
      return;
      if (paramInt == 2131371498)
      {
        super.d(paramChatMessage);
        return;
      }
    } while (paramInt != 2131367094);
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
    atky.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.getMessage(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForDeviceFile)((afyu)AIOUtils.getHolder(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        localbjnw = (bjnw)bjon.a(this.jdField_a_of_type_AndroidContentContext, null);
        localbjnw.a(2131689947, 5);
        localbjnw.c(2131690620);
        localbjnw.a(new afys(this, paramView, localbjnw));
        localbjnw.show();
        return;
      }
    } while (this.f);
    bjnw localbjnw = bjnw.a(this.jdField_a_of_type_AndroidContentContext);
    localbjnw.a(2131691429);
    localbjnw.b(2131691428);
    localbjnw.c(2131690620);
    localbjnw.a(new afyt(this, paramView, localbjnw));
    localbjnw.show();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (afyu)AIOUtils.getHolder(paramView);
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
    paramView = (afyu)AIOUtils.getHolder(paramView);
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
    paramView = (afyu)AIOUtils.getHolder(paramView);
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
      aszk.a(2131692367);
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForDeviceFile.filePath)) {
      ((aavk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(49)).a().a(paramMessageForDeviceFile.strServiceName, paramMessageForDeviceFile);
    }
    super.b();
  }
  
  public bgbb[] a(View paramView)
  {
    bgaz localbgaz = new bgaz();
    acvv.a(localbgaz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((afyu)AIOUtils.getHolder(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage).filePath)) {
      localbgaz.a(2131367094, this.jdField_a_of_type_AndroidContentContext.getString(2131692448), 2130838971);
    }
    super.c(localbgaz, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbgaz, this.jdField_a_of_type_AndroidContentContext);
    return localbgaz.a();
  }
  
  public void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      aszk.a(2131692367);
      return;
    }
    ((aavk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(49)).a().a(paramMessageForDeviceFile);
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
      if ((paramView.getId() != 2131364450) || (localMessageForDeviceFile == null) || (localMessageForDeviceFile.uint32_src_uin_type != 1))
      {
        super.onClick(paramView);
        switch (paramView.getId())
        {
        case 2131364411: 
        case 2131364449: 
        default: 
          break;
        case 2131364441: 
          e(paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyr
 * JD-Core Version:    0.7.0.1
 */