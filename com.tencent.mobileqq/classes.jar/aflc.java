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

public class aflc
  extends BaseBubbleBuilder
  implements aeqh, apen
{
  boolean f = false;
  
  public aflc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  @SuppressLint({"ResourceAsColor"})
  @TargetApi(11)
  private RelativeLayout a(aflf paramaflf)
  {
    int i = aepi.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = aepi.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = aepi.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131364173);
    Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131366325);
    ((RelativeLayout)localObject2).setBackgroundResource(2130843874);
    ((RelativeLayout)localObject2).setPadding(aepi.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), i, i, aepi.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramaflf.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364173);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131366326);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, k);
    localLayoutParams.addRule(10, 2131366325);
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
    ((AsyncImageView)localObject2).setWidth(k);
    ((AsyncImageView)localObject2).setHeight(k);
    ((AsyncImageView)localObject2).setId(2131364142);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams.addRule(9, 2131366326);
    localLayoutParams.addRule(15, 2131366326);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramaflf.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131364143);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(9, 2131366326);
    localLayoutParams.addRule(15, 2131366326);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramaflf.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364144);
    ((TextView)localObject2).setGravity(16);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166921));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131364142);
    localLayoutParams.addRule(11, 2131366326);
    localLayoutParams.addRule(10, 2131366326);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramaflf.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364141);
    ((TextView)localObject2).setSingleLine();
    if (bhtb.e()) {
      ((TextView)localObject2).setAlpha(0.75F);
    }
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(5, 2131364144);
    localLayoutParams.addRule(6, 2131364146);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramaflf.b = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364146);
    ((TextView)localObject2).setGravity(5);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131366326);
    localLayoutParams.addRule(12, 2131366326);
    localLayoutParams.addRule(1, 2131364141);
    localLayoutParams.leftMargin = i;
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramaflf.c = ((TextView)localObject2);
    return localRelativeLayout;
  }
  
  private void a(aflf paramaflf, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {
      paramaflf.c.setVisibility(8);
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
                                          paramaflf.c.setMaxLines(3);
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
                                            paramaflf.c.setVisibility(8);
                                            return;
                                            paramaflf.c.setMaxLines(2);
                                          }
                                        }
                                        paramaflf.c.setVisibility(0);
                                        paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692565));
                                        return;
                                        if (this.f)
                                        {
                                          paramaflf.c.setVisibility(0);
                                          if (paramMessageForDeviceFile.isSend())
                                          {
                                            paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131721257));
                                            return;
                                          }
                                          paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691642));
                                          return;
                                        }
                                        paramaflf.c.setVisibility(4);
                                        return;
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          paramaflf.c.setVisibility(4);
                                          return;
                                        }
                                        paramaflf.c.setVisibility(0);
                                        paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131694057));
                                        return;
                                        paramaflf.c.setVisibility(0);
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692563));
                                          return;
                                        }
                                        if (this.f)
                                        {
                                          paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691638));
                                          return;
                                        }
                                        paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692562));
                                        return;
                                        paramaflf.c.setVisibility(0);
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          if (this.f)
                                          {
                                            paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691648));
                                            return;
                                          }
                                          paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692564));
                                          return;
                                        }
                                        if (this.f)
                                        {
                                          paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691643));
                                          return;
                                        }
                                        paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692556));
                                        return;
                                        paramaflf.c.setVisibility(0);
                                      } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                      paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691639));
                                      return;
                                      paramaflf.c.setVisibility(0);
                                    } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                    paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691640));
                                    return;
                                    paramaflf.c.setVisibility(0);
                                  } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                  paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691641));
                                  return;
                                  paramaflf.c.setVisibility(0);
                                } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691644));
                                return;
                                paramaflf.c.setVisibility(0);
                              } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                              paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691646) + "（错误01）");
                              return;
                              paramaflf.c.setVisibility(0);
                            } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                            paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691646) + "（错误02）");
                            return;
                            paramaflf.c.setVisibility(0);
                          } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                          paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691646) + "（错误03）");
                          return;
                          paramaflf.c.setVisibility(0);
                        } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                        paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691646) + "（错误04）");
                        return;
                        paramaflf.c.setVisibility(0);
                      } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                      paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691646) + "（错误05）");
                      return;
                      paramaflf.c.setVisibility(0);
                    } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                    paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691646) + "（错误06）");
                    return;
                    paramaflf.c.setVisibility(0);
                  } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                  paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691646) + "（错误07）");
                  return;
                  paramaflf.c.setVisibility(0);
                } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691646) + "（错误08）");
                return;
                paramaflf.c.setVisibility(0);
              } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
              paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691646) + "（错误09）");
              return;
              paramaflf.c.setVisibility(0);
            } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
            paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691646) + "（错误10）");
            return;
            paramaflf.c.setVisibility(0);
          } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
          paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691646) + "（错误11）");
          return;
          paramaflf.c.setVisibility(0);
        } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
        paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691646) + this.jdField_a_of_type_AndroidContentContext.getString(2131691644));
        return;
        paramaflf.c.setVisibility(0);
      } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
      paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691645));
      return;
      paramaflf.c.setVisibility(0);
    } while (!this.f);
    paramaflf.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691647));
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, aflf paramaflf)
  {
    paramaflf.jdField_a_of_type_AndroidWidgetTextView.setText(arrr.d(paramMessageForDeviceFile.srcFileName));
    paramaflf.b.setText(arso.a(paramMessageForDeviceFile.fileSize));
    arrr.a(paramaflf.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForDeviceFile.filePath, arrr.a(paramMessageForDeviceFile.filePath));
    paramaflf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((paramMessageForDeviceFile.strServiceName != null) && (paramMessageForDeviceFile.strServiceName.compareTo(zxz.c) == 0)) {
      this.f = true;
    }
    b(paramaflf, paramMessageForDeviceFile);
    a(paramaflf, paramMessageForDeviceFile);
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
  
  private void b(aflf paramaflf, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile != null) {}
    int i;
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    default: 
      i = 0;
      if (i != 0)
      {
        if (paramaflf.jdField_a_of_type_AndroidWidgetProgressBar == null)
        {
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
          localProgressBar.setId(2131364145);
          localProgressBar.setMax(100);
          localProgressBar.setMinimumHeight(aepi.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837924));
          localLayoutParams = new RelativeLayout.LayoutParams(-1, aepi.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.addRule(3, 2131366326);
          localLayoutParams.addRule(12, 2131366325);
          localLayoutParams.setMargins(0, aepi.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramaflf.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localProgressBar, localLayoutParams);
          paramaflf.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
        }
        paramaflf.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
        paramaflf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      break;
    }
    while (paramaflf.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      ProgressBar localProgressBar;
      RelativeLayout.LayoutParams localLayoutParams;
      return;
      i = 1;
      break;
    }
    paramaflf.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void c(MessageForDeviceFile paramMessageForDeviceFile) {}
  
  private void d(View paramView)
  {
    Object localObject2 = (MessageForDeviceFile)aepi.a(paramView);
    paramView = arrr.a((MessageForDeviceFile)localObject2);
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
          if (arrr.a(((MessageForDeviceFile)localObject3).filePath) == paramView.nFileType) {
            ((ArrayList)localObject1).add(String.valueOf(arrr.a((MessageForDeviceFile)localObject3).nSessionId));
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
  
  public aeqh a(View paramView)
  {
    return this;
  }
  
  public aeqi a()
  {
    return new aflf(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aetk paramaetk)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaetk);
    ((aflf)paramChatMessage.getTag()).jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.d;
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    aflf localaflf = (aflf)paramaeqi;
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a((aflf)paramaeqi);
    }
    c(localMessageForDeviceFile);
    a(paramBaseChatItemLayout, localMessageForDeviceFile, localaflf);
    paramChatMessage.setOnLongClickListener(paramaetk);
    paramChatMessage.setOnTouchListener(paramaetk);
    paramChatMessage.setOnClickListener(this);
    localaflf.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((zxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return alud.a(2131703561);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForDeviceFile)))
    {
      paramContext = (MessageForDeviceFile)paramChatMessage;
      if (paramInt != 2131365071) {
        break label36;
      }
      acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    label36:
    do
    {
      return;
      if (paramInt == 2131370861)
      {
        super.d(paramChatMessage);
        return;
      }
    } while (paramInt != 2131366760);
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
    aryv.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (aepi.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForDeviceFile)((aflf)aepi.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        localbhuf = (bhuf)bhus.a(this.jdField_a_of_type_AndroidContentContext, null);
        localbhuf.a(2131690042, 5);
        localbhuf.c(2131690648);
        localbhuf.a(new afld(this, paramView, localbhuf));
        localbhuf.show();
        return;
      }
    } while (this.f);
    bhuf localbhuf = bhuf.a(this.jdField_a_of_type_AndroidContentContext);
    localbhuf.a(2131691636);
    localbhuf.b(2131691635);
    localbhuf.c(2131690648);
    localbhuf.a(new afle(this, paramView, localbhuf));
    localbhuf.show();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (aflf)aepi.a(paramView);
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
    paramView = (aflf)aepi.a(paramView);
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
    paramView = (aflf)aepi.a(paramView);
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
    if (!bdin.d(this.jdField_a_of_type_AndroidContentContext))
    {
      arri.a(2131692747);
      return;
    }
    if (bdhb.b(paramMessageForDeviceFile.filePath)) {
      ((zxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile.strServiceName, paramMessageForDeviceFile);
    }
    super.b();
  }
  
  public bdpk[] a(View paramView)
  {
    bdpi localbdpi = new bdpi();
    acjm.a(localbdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((aflf)aepi.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage).filePath)) {
      localbdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
    }
    super.c(localbdpi, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbdpi, this.jdField_a_of_type_AndroidContentContext);
    return localbdpi.a();
  }
  
  public void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!bdin.d(this.jdField_a_of_type_AndroidContentContext))
    {
      arri.a(2131692747);
      return;
    }
    ((zxz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile);
  }
  
  public void onClick(View paramView)
  {
    aepi.n = true;
    if (super.a()) {}
    MessageForDeviceFile localMessageForDeviceFile;
    do
    {
      return;
      localMessageForDeviceFile = (MessageForDeviceFile)aepi.a(paramView);
    } while ((paramView.getId() == 2131364182) && (localMessageForDeviceFile != null) && (localMessageForDeviceFile.uint32_src_uin_type == 1));
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131364143: 
    case 2131364181: 
    default: 
      return;
    }
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aflc
 * JD-Core Version:    0.7.0.1
 */