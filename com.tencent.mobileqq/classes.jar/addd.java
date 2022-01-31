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

public class addd
  extends BaseBubbleBuilder
  implements acjt, amsl
{
  boolean f = false;
  
  public addd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  @SuppressLint({"ResourceAsColor"})
  @TargetApi(11)
  private RelativeLayout a(addg paramaddg)
  {
    int i = aciy.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = aciy.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = aciy.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131298552);
    Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131300633);
    ((RelativeLayout)localObject2).setBackgroundResource(2130843360);
    ((RelativeLayout)localObject2).setPadding(aciy.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), i, i, aciy.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramaddg.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131298552);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131300634);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, k);
    localLayoutParams.addRule(10, 2131300633);
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
    ((AsyncImageView)localObject2).setWidth(k);
    ((AsyncImageView)localObject2).setHeight(k);
    ((AsyncImageView)localObject2).setId(2131298521);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams.addRule(9, 2131300634);
    localLayoutParams.addRule(15, 2131300634);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramaddg.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131298522);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(9, 2131300634);
    localLayoutParams.addRule(15, 2131300634);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramaddg.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131298523);
    ((TextView)localObject2).setGravity(16);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131101278));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131298521);
    localLayoutParams.addRule(11, 2131300634);
    localLayoutParams.addRule(10, 2131300634);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramaddg.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131298520);
    ((TextView)localObject2).setSingleLine();
    if (befo.e()) {
      ((TextView)localObject2).setAlpha(0.75F);
    }
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(5, 2131298523);
    localLayoutParams.addRule(6, 2131298525);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramaddg.b = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131298525);
    ((TextView)localObject2).setGravity(5);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131300634);
    localLayoutParams.addRule(12, 2131300634);
    localLayoutParams.addRule(1, 2131298520);
    localLayoutParams.leftMargin = i;
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramaddg.c = ((TextView)localObject2);
    return localRelativeLayout;
  }
  
  private void a(addg paramaddg, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {
      paramaddg.c.setVisibility(8);
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
                                          paramaddg.c.setMaxLines(3);
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
                                            paramaddg.c.setVisibility(8);
                                            return;
                                            paramaddg.c.setMaxLines(2);
                                          }
                                        }
                                        paramaddg.c.setVisibility(0);
                                        paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626874));
                                        return;
                                        if (this.f)
                                        {
                                          paramaddg.c.setVisibility(0);
                                          if (paramMessageForDeviceFile.isSend())
                                          {
                                            paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131654795));
                                            return;
                                          }
                                          paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626010));
                                          return;
                                        }
                                        paramaddg.c.setVisibility(4);
                                        return;
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          paramaddg.c.setVisibility(4);
                                          return;
                                        }
                                        paramaddg.c.setVisibility(0);
                                        paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131628297));
                                        return;
                                        paramaddg.c.setVisibility(0);
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626872));
                                          return;
                                        }
                                        if (this.f)
                                        {
                                          paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626006));
                                          return;
                                        }
                                        paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626871));
                                        return;
                                        paramaddg.c.setVisibility(0);
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          if (this.f)
                                          {
                                            paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626016));
                                            return;
                                          }
                                          paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626873));
                                          return;
                                        }
                                        if (this.f)
                                        {
                                          paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626011));
                                          return;
                                        }
                                        paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626865));
                                        return;
                                        paramaddg.c.setVisibility(0);
                                      } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                      paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626007));
                                      return;
                                      paramaddg.c.setVisibility(0);
                                    } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                    paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626008));
                                    return;
                                    paramaddg.c.setVisibility(0);
                                  } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                  paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626009));
                                  return;
                                  paramaddg.c.setVisibility(0);
                                } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626012));
                                return;
                                paramaddg.c.setVisibility(0);
                              } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                              paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626014) + "（错误01）");
                              return;
                              paramaddg.c.setVisibility(0);
                            } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                            paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626014) + "（错误02）");
                            return;
                            paramaddg.c.setVisibility(0);
                          } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                          paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626014) + "（错误03）");
                          return;
                          paramaddg.c.setVisibility(0);
                        } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                        paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626014) + "（错误04）");
                        return;
                        paramaddg.c.setVisibility(0);
                      } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                      paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626014) + "（错误05）");
                      return;
                      paramaddg.c.setVisibility(0);
                    } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                    paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626014) + "（错误06）");
                    return;
                    paramaddg.c.setVisibility(0);
                  } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                  paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626014) + "（错误07）");
                  return;
                  paramaddg.c.setVisibility(0);
                } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626014) + "（错误08）");
                return;
                paramaddg.c.setVisibility(0);
              } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
              paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626014) + "（错误09）");
              return;
              paramaddg.c.setVisibility(0);
            } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
            paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626014) + "（错误10）");
            return;
            paramaddg.c.setVisibility(0);
          } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
          paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626014) + "（错误11）");
          return;
          paramaddg.c.setVisibility(0);
        } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
        paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626014) + this.jdField_a_of_type_AndroidContentContext.getString(2131626012));
        return;
        paramaddg.c.setVisibility(0);
      } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
      paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626013));
      return;
      paramaddg.c.setVisibility(0);
    } while (!this.f);
    paramaddg.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131626015));
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, addg paramaddg)
  {
    paramaddg.jdField_a_of_type_AndroidWidgetTextView.setText(apck.d(paramMessageForDeviceFile.srcFileName));
    paramaddg.b.setText(apdh.a(paramMessageForDeviceFile.fileSize));
    apck.a(paramaddg.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForDeviceFile.filePath, apck.a(paramMessageForDeviceFile.filePath));
    paramaddg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((paramMessageForDeviceFile.strServiceName != null) && (paramMessageForDeviceFile.strServiceName.compareTo(xvq.c) == 0)) {
      this.f = true;
    }
    b(paramaddg, paramMessageForDeviceFile);
    a(paramaddg, paramMessageForDeviceFile);
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
  
  private void b(addg paramaddg, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile != null) {}
    int i;
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    default: 
      i = 0;
      if (i != 0)
      {
        if (paramaddg.jdField_a_of_type_AndroidWidgetProgressBar == null)
        {
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
          localProgressBar.setId(2131298524);
          localProgressBar.setMax(100);
          localProgressBar.setMinimumHeight(aciy.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837717));
          localLayoutParams = new RelativeLayout.LayoutParams(-1, aciy.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.addRule(3, 2131300634);
          localLayoutParams.addRule(12, 2131300633);
          localLayoutParams.setMargins(0, aciy.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramaddg.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localProgressBar, localLayoutParams);
          paramaddg.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
        }
        paramaddg.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
        paramaddg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      break;
    }
    while (paramaddg.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      ProgressBar localProgressBar;
      RelativeLayout.LayoutParams localLayoutParams;
      return;
      i = 1;
      break;
    }
    paramaddg.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void c(MessageForDeviceFile paramMessageForDeviceFile) {}
  
  private void d(View paramView)
  {
    Object localObject2 = (MessageForDeviceFile)aciy.a(paramView);
    paramView = apck.a((MessageForDeviceFile)localObject2);
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
          if (apck.a(((MessageForDeviceFile)localObject3).filePath) == paramView.nFileType) {
            ((ArrayList)localObject1).add(String.valueOf(apck.a((MessageForDeviceFile)localObject3).nSessionId));
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
  
  public acjt a(View paramView)
  {
    return this;
  }
  
  public acju a()
  {
    return new addg(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acmv paramacmv)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacmv);
    ((addg)paramChatMessage.getTag()).jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.d;
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    addg localaddg = (addg)paramacju;
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a((addg)paramacju);
    }
    c(localMessageForDeviceFile);
    a(paramBaseChatItemLayout, localMessageForDeviceFile, localaddg);
    paramChatMessage.setOnLongClickListener(paramacmv);
    paramChatMessage.setOnTouchListener(paramacmv);
    paramChatMessage.setOnClickListener(this);
    localaddg.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((xvq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajjy.a(2131637381);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForDeviceFile)))
    {
      paramContext = (MessageForDeviceFile)paramChatMessage;
      if (paramInt != 2131299417) {
        break label36;
      }
      aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    label36:
    do
    {
      return;
      if (paramInt == 2131304871)
      {
        super.d(paramChatMessage);
        return;
      }
    } while (paramInt != 2131301021);
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
    aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (aciy.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForDeviceFile)((addg)aciy.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
        localbegr.a(2131624443, 5);
        localbegr.c(2131625035);
        localbegr.a(new adde(this, paramView, localbegr));
        localbegr.show();
        return;
      }
    } while (this.f);
    begr localbegr = begr.a(this.jdField_a_of_type_AndroidContentContext);
    localbegr.a(2131626004);
    localbegr.b(2131626003);
    localbegr.c(2131625035);
    localbegr.a(new addf(this, paramView, localbegr));
    localbegr.show();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (addg)aciy.a(paramView);
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
    paramView = (addg)aciy.a(paramView);
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
    paramView = (addg)aciy.a(paramView);
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
    if (!badq.d(this.jdField_a_of_type_AndroidContentContext))
    {
      apcb.a(2131627028);
      return;
    }
    if (bace.b(paramMessageForDeviceFile.filePath)) {
      ((xvq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile.strServiceName, paramMessageForDeviceFile);
    }
    super.b();
  }
  
  public bakj[] a(View paramView)
  {
    bakh localbakh = new bakh();
    aael.a(localbakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((addg)aciy.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage).filePath)) {
      localbakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131627114), 2130838599);
    }
    super.c(localbakh, this.jdField_a_of_type_AndroidContentContext);
    super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
    return localbakh.a();
  }
  
  public void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!badq.d(this.jdField_a_of_type_AndroidContentContext))
    {
      apcb.a(2131627028);
      return;
    }
    ((xvq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile);
  }
  
  public void onClick(View paramView)
  {
    aciy.n = true;
    if (super.a()) {}
    MessageForDeviceFile localMessageForDeviceFile;
    do
    {
      return;
      localMessageForDeviceFile = (MessageForDeviceFile)aciy.a(paramView);
    } while ((paramView.getId() == 2131298561) && (localMessageForDeviceFile != null) && (localMessageForDeviceFile.uint32_src_uin_type == 1));
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131298522: 
    case 2131298560: 
    default: 
      return;
    }
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     addd
 * JD-Core Version:    0.7.0.1
 */