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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class afgn
  extends BaseBubbleBuilder
  implements aels, apae
{
  boolean f = false;
  
  public afgn(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  @SuppressLint({"ResourceAsColor"})
  @TargetApi(11)
  private RelativeLayout a(afgq paramafgq)
  {
    int i = aekt.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = aekt.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = aekt.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131364171);
    Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131366323);
    ((RelativeLayout)localObject2).setBackgroundResource(2130843802);
    ((RelativeLayout)localObject2).setPadding(aekt.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), i, i, aekt.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramafgq.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364171);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131366324);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, k);
    localLayoutParams.addRule(10, 2131366323);
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
    ((AsyncImageView)localObject2).setWidth(k);
    ((AsyncImageView)localObject2).setHeight(k);
    ((AsyncImageView)localObject2).setId(2131364140);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams.addRule(9, 2131366324);
    localLayoutParams.addRule(15, 2131366324);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramafgq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131364141);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(9, 2131366324);
    localLayoutParams.addRule(15, 2131366324);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramafgq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364142);
    ((TextView)localObject2).setGravity(16);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166919));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131364140);
    localLayoutParams.addRule(11, 2131366324);
    localLayoutParams.addRule(10, 2131366324);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramafgq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364139);
    ((TextView)localObject2).setSingleLine();
    if (bhou.e()) {
      ((TextView)localObject2).setAlpha(0.75F);
    }
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(5, 2131364142);
    localLayoutParams.addRule(6, 2131364144);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramafgq.b = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364144);
    ((TextView)localObject2).setGravity(5);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131366324);
    localLayoutParams.addRule(12, 2131366324);
    localLayoutParams.addRule(1, 2131364139);
    localLayoutParams.leftMargin = i;
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramafgq.c = ((TextView)localObject2);
    return localRelativeLayout;
  }
  
  private void a(afgq paramafgq, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {
      paramafgq.c.setVisibility(8);
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
                                          paramafgq.c.setMaxLines(3);
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
                                            paramafgq.c.setVisibility(8);
                                            return;
                                            paramafgq.c.setMaxLines(2);
                                          }
                                        }
                                        paramafgq.c.setVisibility(0);
                                        paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692564));
                                        return;
                                        if (this.f)
                                        {
                                          paramafgq.c.setVisibility(0);
                                          if (paramMessageForDeviceFile.isSend())
                                          {
                                            paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131721244));
                                            return;
                                          }
                                          paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691641));
                                          return;
                                        }
                                        paramafgq.c.setVisibility(4);
                                        return;
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          paramafgq.c.setVisibility(4);
                                          return;
                                        }
                                        paramafgq.c.setVisibility(0);
                                        paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131694055));
                                        return;
                                        paramafgq.c.setVisibility(0);
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692562));
                                          return;
                                        }
                                        if (this.f)
                                        {
                                          paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691637));
                                          return;
                                        }
                                        paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692561));
                                        return;
                                        paramafgq.c.setVisibility(0);
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          if (this.f)
                                          {
                                            paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691647));
                                            return;
                                          }
                                          paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692563));
                                          return;
                                        }
                                        if (this.f)
                                        {
                                          paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691642));
                                          return;
                                        }
                                        paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692555));
                                        return;
                                        paramafgq.c.setVisibility(0);
                                      } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                      paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691638));
                                      return;
                                      paramafgq.c.setVisibility(0);
                                    } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                    paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691639));
                                    return;
                                    paramafgq.c.setVisibility(0);
                                  } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                  paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691640));
                                  return;
                                  paramafgq.c.setVisibility(0);
                                } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691643));
                                return;
                                paramafgq.c.setVisibility(0);
                              } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                              paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691645) + "（错误01）");
                              return;
                              paramafgq.c.setVisibility(0);
                            } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                            paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691645) + "（错误02）");
                            return;
                            paramafgq.c.setVisibility(0);
                          } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                          paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691645) + "（错误03）");
                          return;
                          paramafgq.c.setVisibility(0);
                        } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                        paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691645) + "（错误04）");
                        return;
                        paramafgq.c.setVisibility(0);
                      } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                      paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691645) + "（错误05）");
                      return;
                      paramafgq.c.setVisibility(0);
                    } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                    paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691645) + "（错误06）");
                    return;
                    paramafgq.c.setVisibility(0);
                  } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                  paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691645) + "（错误07）");
                  return;
                  paramafgq.c.setVisibility(0);
                } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691645) + "（错误08）");
                return;
                paramafgq.c.setVisibility(0);
              } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
              paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691645) + "（错误09）");
              return;
              paramafgq.c.setVisibility(0);
            } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
            paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691645) + "（错误10）");
            return;
            paramafgq.c.setVisibility(0);
          } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
          paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691645) + "（错误11）");
          return;
          paramafgq.c.setVisibility(0);
        } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
        paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691645) + this.jdField_a_of_type_AndroidContentContext.getString(2131691643));
        return;
        paramafgq.c.setVisibility(0);
      } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
      paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691644));
      return;
      paramafgq.c.setVisibility(0);
    } while (!this.f);
    paramafgq.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691646));
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, afgq paramafgq)
  {
    paramafgq.jdField_a_of_type_AndroidWidgetTextView.setText(arni.d(paramMessageForDeviceFile.srcFileName));
    paramafgq.b.setText(arof.a(paramMessageForDeviceFile.fileSize));
    arni.a(paramafgq.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForDeviceFile.filePath, arni.a(paramMessageForDeviceFile.filePath));
    paramafgq.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((paramMessageForDeviceFile.strServiceName != null) && (paramMessageForDeviceFile.strServiceName.compareTo(ztk.c) == 0)) {
      this.f = true;
    }
    b(paramafgq, paramMessageForDeviceFile);
    a(paramafgq, paramMessageForDeviceFile);
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
  
  private void b(afgq paramafgq, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile != null) {}
    int i;
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    default: 
      i = 0;
      if (i != 0)
      {
        if (paramafgq.jdField_a_of_type_AndroidWidgetProgressBar == null)
        {
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
          localProgressBar.setId(2131364143);
          localProgressBar.setMax(100);
          localProgressBar.setMinimumHeight(aekt.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837923));
          localLayoutParams = new RelativeLayout.LayoutParams(-1, aekt.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.addRule(3, 2131366324);
          localLayoutParams.addRule(12, 2131366323);
          localLayoutParams.setMargins(0, aekt.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramafgq.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localProgressBar, localLayoutParams);
          paramafgq.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
        }
        paramafgq.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
        paramafgq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      break;
    }
    while (paramafgq.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      ProgressBar localProgressBar;
      RelativeLayout.LayoutParams localLayoutParams;
      return;
      i = 1;
      break;
    }
    paramafgq.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void c(MessageForDeviceFile paramMessageForDeviceFile) {}
  
  private void d(View paramView)
  {
    Object localObject2 = (MessageForDeviceFile)aekt.a(paramView);
    paramView = arni.a((MessageForDeviceFile)localObject2);
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
          if (arni.a(((MessageForDeviceFile)localObject3).filePath) == paramView.nFileType) {
            ((ArrayList)localObject1).add(String.valueOf(arni.a((MessageForDeviceFile)localObject3).nSessionId));
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
  
  public aels a(View paramView)
  {
    return this;
  }
  
  public aelt a()
  {
    return new afgq(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaeov);
    ((afgq)paramChatMessage.getTag()).jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.d;
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    afgq localafgq = (afgq)paramaelt;
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a((afgq)paramaelt);
    }
    c(localMessageForDeviceFile);
    a(paramBaseChatItemLayout, localMessageForDeviceFile, localafgq);
    paramChatMessage.setOnLongClickListener(paramaeov);
    paramChatMessage.setOnTouchListener(paramaeov);
    paramChatMessage.setOnClickListener(this);
    localafgq.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((ztk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return alpo.a(2131703549);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForDeviceFile)))
    {
      paramContext = (MessageForDeviceFile)paramChatMessage;
      if (paramInt != 2131365069) {
        break label36;
      }
      acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    label36:
    do
    {
      return;
      if (paramInt == 2131370842)
      {
        super.d(paramChatMessage);
        return;
      }
    } while (paramInt != 2131366750);
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
    arum.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (aekt.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForDeviceFile)((afgq)aekt.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_AndroidContentContext, null);
        localbhpy.a(2131690042, 5);
        localbhpy.c(2131690648);
        localbhpy.a(new afgo(this, paramView, localbhpy));
        localbhpy.show();
        return;
      }
    } while (this.f);
    bhpy localbhpy = bhpy.a(this.jdField_a_of_type_AndroidContentContext);
    localbhpy.a(2131691635);
    localbhpy.b(2131691634);
    localbhpy.c(2131690648);
    localbhpy.a(new afgp(this, paramView, localbhpy));
    localbhpy.show();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (afgq)aekt.a(paramView);
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
    paramView = (afgq)aekt.a(paramView);
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
    paramView = (afgq)aekt.a(paramView);
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
    if (!bdee.d(this.jdField_a_of_type_AndroidContentContext))
    {
      armz.a(2131692745);
      return;
    }
    if (bdcs.b(paramMessageForDeviceFile.filePath)) {
      ((ztk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile.strServiceName, paramMessageForDeviceFile);
    }
    super.b();
  }
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    acex.a(localbdkz, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((afgq)aekt.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage).filePath)) {
      localbdkz.a(2131366750, this.jdField_a_of_type_AndroidContentContext.getString(2131692835), 2130838677);
    }
    super.c(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    return localbdkz.a();
  }
  
  public void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!bdee.d(this.jdField_a_of_type_AndroidContentContext))
    {
      armz.a(2131692745);
      return;
    }
    ((ztk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile);
  }
  
  public void onClick(View paramView)
  {
    aekt.n = true;
    if (super.a()) {}
    MessageForDeviceFile localMessageForDeviceFile;
    do
    {
      return;
      localMessageForDeviceFile = (MessageForDeviceFile)aekt.a(paramView);
    } while ((paramView.getId() == 2131364180) && (localMessageForDeviceFile != null) && (localMessageForDeviceFile.uint32_src_uin_type == 1));
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131364141: 
    case 2131364179: 
    default: 
      return;
    }
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgn
 * JD-Core Version:    0.7.0.1
 */