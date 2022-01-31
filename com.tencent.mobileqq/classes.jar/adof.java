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
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class adof
  extends BaseBubbleBuilder
  implements acum, anis
{
  boolean f = false;
  
  public adof(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  @SuppressLint({"ResourceAsColor"})
  @TargetApi(11)
  private RelativeLayout a(adoi paramadoi)
  {
    int i = actn.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = actn.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = actn.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131364110);
    Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131366235);
    ((RelativeLayout)localObject2).setBackgroundResource(2130843442);
    ((RelativeLayout)localObject2).setPadding(actn.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), i, i, actn.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramadoi.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364110);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131366236);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, k);
    localLayoutParams.addRule(10, 2131366235);
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
    ((AsyncImageView)localObject2).setWidth(k);
    ((AsyncImageView)localObject2).setHeight(k);
    ((AsyncImageView)localObject2).setId(2131364079);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams.addRule(9, 2131366236);
    localLayoutParams.addRule(15, 2131366236);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramadoi.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131364080);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(9, 2131366236);
    localLayoutParams.addRule(15, 2131366236);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramadoi.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364081);
    ((TextView)localObject2).setGravity(16);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166872));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131364079);
    localLayoutParams.addRule(11, 2131366236);
    localLayoutParams.addRule(10, 2131366236);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramadoi.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364078);
    ((TextView)localObject2).setSingleLine();
    if (bfni.e()) {
      ((TextView)localObject2).setAlpha(0.75F);
    }
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(5, 2131364081);
    localLayoutParams.addRule(6, 2131364083);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramadoi.b = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364083);
    ((TextView)localObject2).setGravity(5);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131366236);
    localLayoutParams.addRule(12, 2131366236);
    localLayoutParams.addRule(1, 2131364078);
    localLayoutParams.leftMargin = i;
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramadoi.c = ((TextView)localObject2);
    return localRelativeLayout;
  }
  
  private void a(adoi paramadoi, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {
      paramadoi.c.setVisibility(8);
    }
    label193:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        return;
                                        if ((this.f) && (paramMessageForDeviceFile.issend == 0)) {
                                          paramadoi.c.setMaxLines(3);
                                        }
                                        for (;;)
                                        {
                                          switch (paramMessageForDeviceFile.nFileStatus)
                                          {
                                          case 0: 
                                          case 11: 
                                          default: 
                                            return;
                                          case -1: 
                                            if (!paramMessageForDeviceFile.isSend()) {
                                              break label193;
                                            }
                                            paramadoi.c.setVisibility(8);
                                            return;
                                            paramadoi.c.setMaxLines(2);
                                          }
                                        }
                                        paramadoi.c.setVisibility(0);
                                        paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692487));
                                        return;
                                        if (this.f)
                                        {
                                          paramadoi.c.setVisibility(0);
                                          if (paramMessageForDeviceFile.isSend())
                                          {
                                            paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131720693));
                                            return;
                                          }
                                          paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691586));
                                          return;
                                        }
                                        paramadoi.c.setVisibility(4);
                                        return;
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          paramadoi.c.setVisibility(4);
                                          return;
                                        }
                                        paramadoi.c.setVisibility(0);
                                        paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131693938));
                                        return;
                                        paramadoi.c.setVisibility(0);
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692485));
                                          return;
                                        }
                                        if (this.f)
                                        {
                                          paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691582));
                                          return;
                                        }
                                        paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692484));
                                        return;
                                        paramadoi.c.setVisibility(0);
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          if (this.f)
                                          {
                                            paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691592));
                                            return;
                                          }
                                          paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692486));
                                          return;
                                        }
                                        if (this.f)
                                        {
                                          paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691587));
                                          return;
                                        }
                                        paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692478));
                                        return;
                                        paramadoi.c.setVisibility(0);
                                      } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                      paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691583));
                                      return;
                                      paramadoi.c.setVisibility(0);
                                    } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                    paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691584));
                                    return;
                                    paramadoi.c.setVisibility(0);
                                  } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                  paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691585));
                                  return;
                                  paramadoi.c.setVisibility(0);
                                } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691588));
                                return;
                                paramadoi.c.setVisibility(0);
                              } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                              paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误01）");
                              return;
                              paramadoi.c.setVisibility(0);
                            } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                            paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误02）");
                            return;
                            paramadoi.c.setVisibility(0);
                          } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                          paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误03）");
                          return;
                          paramadoi.c.setVisibility(0);
                        } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                        paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误04）");
                        return;
                        paramadoi.c.setVisibility(0);
                      } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                      paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误05）");
                      return;
                      paramadoi.c.setVisibility(0);
                    } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                    paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误06）");
                    return;
                    paramadoi.c.setVisibility(0);
                  } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                  paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误07）");
                  return;
                  paramadoi.c.setVisibility(0);
                } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误08）");
                return;
                paramadoi.c.setVisibility(0);
              } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
              paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误09）");
              return;
              paramadoi.c.setVisibility(0);
            } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
            paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误10）");
            return;
            paramadoi.c.setVisibility(0);
          } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
          paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误11）");
          return;
          paramadoi.c.setVisibility(0);
        } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
        paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + this.jdField_a_of_type_AndroidContentContext.getString(2131691588));
        return;
        paramadoi.c.setVisibility(0);
      } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
      paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691589));
      return;
      paramadoi.c.setVisibility(0);
    } while (!this.f);
    paramadoi.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691591));
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, adoi paramadoi)
  {
    paramadoi.jdField_a_of_type_AndroidWidgetTextView.setText(apue.d(paramMessageForDeviceFile.srcFileName));
    paramadoi.b.setText(apvb.a(paramMessageForDeviceFile.fileSize));
    apue.a(paramadoi.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForDeviceFile.filePath, apue.a(paramMessageForDeviceFile.filePath));
    paramadoi.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((paramMessageForDeviceFile.strServiceName != null) && (paramMessageForDeviceFile.strServiceName.compareTo(yeu.c) == 0)) {
      this.f = true;
    }
    b(paramadoi, paramMessageForDeviceFile);
    a(paramadoi, paramMessageForDeviceFile);
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
  
  private void b(adoi paramadoi, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile != null) {}
    int i;
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    default: 
      i = 0;
      if (i != 0)
      {
        if (paramadoi.jdField_a_of_type_AndroidWidgetProgressBar == null)
        {
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
          localProgressBar.setId(2131364082);
          localProgressBar.setMax(100);
          localProgressBar.setMinimumHeight(actn.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837727));
          localLayoutParams = new RelativeLayout.LayoutParams(-1, actn.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.addRule(3, 2131366236);
          localLayoutParams.addRule(12, 2131366235);
          localLayoutParams.setMargins(0, actn.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramadoi.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localProgressBar, localLayoutParams);
          paramadoi.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
        }
        paramadoi.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
        paramadoi.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      break;
    }
    while (paramadoi.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      ProgressBar localProgressBar;
      RelativeLayout.LayoutParams localLayoutParams;
      return;
      i = 1;
      break;
    }
    paramadoi.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void c(MessageForDeviceFile paramMessageForDeviceFile) {}
  
  private void d(View paramView)
  {
    Object localObject2 = (MessageForDeviceFile)actn.a(paramView);
    paramView = apue.a((MessageForDeviceFile)localObject2);
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
          if (apue.a(((MessageForDeviceFile)localObject3).filePath) == paramView.nFileType) {
            ((ArrayList)localObject1).add(String.valueOf(apue.a((MessageForDeviceFile)localObject3).nSessionId));
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
  
  public acum a(View paramView)
  {
    return this;
  }
  
  public acun a()
  {
    return new adoi(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxn paramacxn)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxn);
    ((adoi)paramChatMessage.getTag()).jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.d;
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    adoi localadoi = (adoi)paramacun;
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a((adoi)paramacun);
    }
    c(localMessageForDeviceFile);
    a(paramBaseChatItemLayout, localMessageForDeviceFile, localadoi);
    paramChatMessage.setOnLongClickListener(paramacxn);
    paramChatMessage.setOnTouchListener(paramacxn);
    paramChatMessage.setOnClickListener(this);
    localadoi.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((yeu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajyc.a(2131703166);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForDeviceFile)))
    {
      paramContext = (MessageForDeviceFile)paramChatMessage;
      if (paramInt != 2131364985) {
        break label36;
      }
      aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    label36:
    do
    {
      return;
      if (paramInt == 2131370537)
      {
        super.d(paramChatMessage);
        return;
      }
    } while (paramInt != 2131366632);
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
    aqbc.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (actn.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForDeviceFile)((adoi)actn.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        localbfol = (bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null);
        localbfol.a(2131689995, 5);
        localbfol.c(2131690596);
        localbfol.a(new adog(this, paramView, localbfol));
        localbfol.show();
        return;
      }
    } while (this.f);
    bfol localbfol = bfol.a(this.jdField_a_of_type_AndroidContentContext);
    localbfol.a(2131691580);
    localbfol.b(2131691579);
    localbfol.c(2131690596);
    localbfol.a(new adoh(this, paramView, localbfol));
    localbfol.show();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (adoi)actn.a(paramView);
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
    paramView = (adoi)actn.a(paramView);
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
    paramView = (adoi)actn.a(paramView);
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
    if (!bbev.d(this.jdField_a_of_type_AndroidContentContext))
    {
      aptv.a(2131692665);
      return;
    }
    if (bbdj.b(paramMessageForDeviceFile.filePath)) {
      ((yeu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile.strServiceName, paramMessageForDeviceFile);
    }
    super.b();
  }
  
  public bblt[] a(View paramView)
  {
    bblr localbblr = new bblr();
    aaod.a(localbblr, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((adoi)actn.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage).filePath)) {
      localbblr.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692752), 2130838606);
    }
    super.c(localbblr, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbblr, this.jdField_a_of_type_AndroidContentContext);
    return localbblr.a();
  }
  
  public void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!bbev.d(this.jdField_a_of_type_AndroidContentContext))
    {
      aptv.a(2131692665);
      return;
    }
    ((yeu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile);
  }
  
  public void onClick(View paramView)
  {
    actn.n = true;
    if (super.a()) {}
    MessageForDeviceFile localMessageForDeviceFile;
    do
    {
      return;
      localMessageForDeviceFile = (MessageForDeviceFile)actn.a(paramView);
    } while ((paramView.getId() == 2131364119) && (localMessageForDeviceFile != null) && (localMessageForDeviceFile.uint32_src_uin_type == 1));
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131364080: 
    case 2131364118: 
    default: 
      return;
    }
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adof
 * JD-Core Version:    0.7.0.1
 */