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

public class adod
  extends BaseBubbleBuilder
  implements acui, anix
{
  boolean f = false;
  
  public adod(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  @SuppressLint({"ResourceAsColor"})
  @TargetApi(11)
  private RelativeLayout a(adog paramadog)
  {
    int i = actj.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = actj.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int k = actj.a(70.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131364109);
    Object localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131366235);
    ((RelativeLayout)localObject2).setBackgroundResource(2130843443);
    ((RelativeLayout)localObject2).setPadding(actj.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), i, i, actj.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    paramadog.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364109);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131366236);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, k);
    localLayoutParams.addRule(10, 2131366235);
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new AsyncImageView(this.jdField_a_of_type_AndroidContentContext);
    ((AsyncImageView)localObject2).setWidth(k);
    ((AsyncImageView)localObject2).setHeight(k);
    ((AsyncImageView)localObject2).setId(2131364078);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams.addRule(9, 2131366236);
    localLayoutParams.addRule(15, 2131366236);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramadog.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131364079);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(9, 2131366236);
    localLayoutParams.addRule(15, 2131366236);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramadog.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364080);
    ((TextView)localObject2).setGravity(16);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131166872));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131364078);
    localLayoutParams.addRule(11, 2131366236);
    localLayoutParams.addRule(10, 2131366236);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramadog.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364077);
    ((TextView)localObject2).setSingleLine();
    if (bfnz.e()) {
      ((TextView)localObject2).setAlpha(0.75F);
    }
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(5, 2131364080);
    localLayoutParams.addRule(6, 2131364082);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramadog.b = ((TextView)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131364082);
    ((TextView)localObject2).setGravity(5);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131366236);
    localLayoutParams.addRule(12, 2131366236);
    localLayoutParams.addRule(1, 2131364077);
    localLayoutParams.leftMargin = i;
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    paramadog.c = ((TextView)localObject2);
    return localRelativeLayout;
  }
  
  private void a(adog paramadog, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {
      paramadog.c.setVisibility(8);
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
                                          paramadog.c.setMaxLines(3);
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
                                            paramadog.c.setVisibility(8);
                                            return;
                                            paramadog.c.setMaxLines(2);
                                          }
                                        }
                                        paramadog.c.setVisibility(0);
                                        paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692488));
                                        return;
                                        if (this.f)
                                        {
                                          paramadog.c.setVisibility(0);
                                          if (paramMessageForDeviceFile.isSend())
                                          {
                                            paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131720704));
                                            return;
                                          }
                                          paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691586));
                                          return;
                                        }
                                        paramadog.c.setVisibility(4);
                                        return;
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          paramadog.c.setVisibility(4);
                                          return;
                                        }
                                        paramadog.c.setVisibility(0);
                                        paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131693939));
                                        return;
                                        paramadog.c.setVisibility(0);
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692486));
                                          return;
                                        }
                                        if (this.f)
                                        {
                                          paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691582));
                                          return;
                                        }
                                        paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692485));
                                        return;
                                        paramadog.c.setVisibility(0);
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          if (this.f)
                                          {
                                            paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691592));
                                            return;
                                          }
                                          paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692487));
                                          return;
                                        }
                                        if (this.f)
                                        {
                                          paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691587));
                                          return;
                                        }
                                        paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131692479));
                                        return;
                                        paramadog.c.setVisibility(0);
                                      } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                      paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691583));
                                      return;
                                      paramadog.c.setVisibility(0);
                                    } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                    paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691584));
                                    return;
                                    paramadog.c.setVisibility(0);
                                  } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                  paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691585));
                                  return;
                                  paramadog.c.setVisibility(0);
                                } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                                paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691588));
                                return;
                                paramadog.c.setVisibility(0);
                              } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                              paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误01）");
                              return;
                              paramadog.c.setVisibility(0);
                            } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                            paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误02）");
                            return;
                            paramadog.c.setVisibility(0);
                          } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                          paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误03）");
                          return;
                          paramadog.c.setVisibility(0);
                        } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                        paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误04）");
                        return;
                        paramadog.c.setVisibility(0);
                      } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                      paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误05）");
                      return;
                      paramadog.c.setVisibility(0);
                    } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                    paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误06）");
                    return;
                    paramadog.c.setVisibility(0);
                  } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                  paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误07）");
                  return;
                  paramadog.c.setVisibility(0);
                } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
                paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误08）");
                return;
                paramadog.c.setVisibility(0);
              } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
              paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误09）");
              return;
              paramadog.c.setVisibility(0);
            } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
            paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误10）");
            return;
            paramadog.c.setVisibility(0);
          } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
          paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + "（错误11）");
          return;
          paramadog.c.setVisibility(0);
        } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
        paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691590) + this.jdField_a_of_type_AndroidContentContext.getString(2131691588));
        return;
        paramadog.c.setVisibility(0);
      } while ((paramMessageForDeviceFile.isSend()) || (!this.f));
      paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691589));
      return;
      paramadog.c.setVisibility(0);
    } while (!this.f);
    paramadog.c.setText("" + this.jdField_a_of_type_AndroidContentContext.getString(2131691591));
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, adog paramadog)
  {
    paramadog.jdField_a_of_type_AndroidWidgetTextView.setText(apug.d(paramMessageForDeviceFile.srcFileName));
    paramadog.b.setText(apvd.a(paramMessageForDeviceFile.fileSize));
    apug.a(paramadog.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForDeviceFile.filePath, apug.a(paramMessageForDeviceFile.filePath));
    paramadog.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    if ((paramMessageForDeviceFile.strServiceName != null) && (paramMessageForDeviceFile.strServiceName.compareTo(yer.c) == 0)) {
      this.f = true;
    }
    b(paramadog, paramMessageForDeviceFile);
    a(paramadog, paramMessageForDeviceFile);
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
  
  private void b(adog paramadog, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile != null) {}
    int i;
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    default: 
      i = 0;
      if (i != 0)
      {
        if (paramadog.jdField_a_of_type_AndroidWidgetProgressBar == null)
        {
          localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 16842872);
          localProgressBar.setId(2131364081);
          localProgressBar.setMax(100);
          localProgressBar.setMinimumHeight(actj.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localProgressBar.setProgressDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837727));
          localLayoutParams = new RelativeLayout.LayoutParams(-1, actj.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          localLayoutParams.addRule(3, 2131366236);
          localLayoutParams.addRule(12, 2131366235);
          localLayoutParams.setMargins(0, actj.a(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
          paramadog.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localProgressBar, localLayoutParams);
          paramadog.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
        }
        paramadog.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
        paramadog.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      break;
    }
    while (paramadog.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      ProgressBar localProgressBar;
      RelativeLayout.LayoutParams localLayoutParams;
      return;
      i = 1;
      break;
    }
    paramadog.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void c(MessageForDeviceFile paramMessageForDeviceFile) {}
  
  private void d(View paramView)
  {
    Object localObject2 = (MessageForDeviceFile)actj.a(paramView);
    paramView = apug.a((MessageForDeviceFile)localObject2);
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
          if (apug.a(((MessageForDeviceFile)localObject3).filePath) == paramView.nFileType) {
            ((ArrayList)localObject1).add(String.valueOf(apug.a((MessageForDeviceFile)localObject3).nSessionId));
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
  
  public acui a(View paramView)
  {
    return this;
  }
  
  public acuj a()
  {
    return new adog(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxj paramacxj)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxj);
    ((adog)paramChatMessage.getTag()).jdField_a_of_type_AndroidViewView.getLayoutParams().width = BaseChatItemLayout.d;
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    adog localadog = (adog)paramacuj;
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a((adog)paramacuj);
    }
    c(localMessageForDeviceFile);
    a(paramBaseChatItemLayout, localMessageForDeviceFile, localadog);
    paramChatMessage.setOnLongClickListener(paramacxj);
    paramChatMessage.setOnTouchListener(paramacxj);
    paramChatMessage.setOnClickListener(this);
    localadog.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajya.a(2131703177);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForDeviceFile)))
    {
      paramContext = (MessageForDeviceFile)paramChatMessage;
      if (paramInt != 2131364984) {
        break label36;
      }
      aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    label36:
    do
    {
      return;
      if (paramInt == 2131370536)
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
    aqbe.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (actj.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForDeviceFile)((adog)actj.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.isSendFromLocal())
      {
        localbfpc = (bfpc)bfpp.a(this.jdField_a_of_type_AndroidContentContext, null);
        localbfpc.a(2131689995, 5);
        localbfpc.c(2131690596);
        localbfpc.a(new adoe(this, paramView, localbfpc));
        localbfpc.show();
        return;
      }
    } while (this.f);
    bfpc localbfpc = bfpc.a(this.jdField_a_of_type_AndroidContentContext);
    localbfpc.a(2131691580);
    localbfpc.b(2131691579);
    localbfpc.c(2131690596);
    localbfpc.a(new adof(this, paramView, localbfpc));
    localbfpc.show();
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (adog)actj.a(paramView);
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
    paramView = (adog)actj.a(paramView);
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
    paramView = (adog)actj.a(paramView);
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
    if (!bbfj.d(this.jdField_a_of_type_AndroidContentContext))
    {
      aptx.a(2131692666);
      return;
    }
    if (bbdx.b(paramMessageForDeviceFile.filePath)) {
      ((yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile.strServiceName, paramMessageForDeviceFile);
    }
    super.b();
  }
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    aanz.a(localbbmf, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((adog)actj.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage).filePath)) {
      localbbmf.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692753), 2130838606);
    }
    super.c(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    return localbbmf.a();
  }
  
  public void b(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!bbfj.d(this.jdField_a_of_type_AndroidContentContext))
    {
      aptx.a(2131692666);
      return;
    }
    ((yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(paramMessageForDeviceFile);
  }
  
  public void onClick(View paramView)
  {
    actj.n = true;
    if (super.a()) {}
    MessageForDeviceFile localMessageForDeviceFile;
    do
    {
      return;
      localMessageForDeviceFile = (MessageForDeviceFile)actj.a(paramView);
    } while ((paramView.getId() == 2131364118) && (localMessageForDeviceFile != null) && (localMessageForDeviceFile.uint32_src_uin_type == 1));
    super.onClick(paramView);
    switch (paramView.getId())
    {
    case 2131364079: 
    case 2131364117: 
    default: 
      return;
    }
    d(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adod
 * JD-Core Version:    0.7.0.1
 */