import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.device.msg.activities.AIODevLittleVideoData;
import com.tencent.device.msg.activities.DevLittleVideoItemBuilder.1;
import com.tencent.device.msg.activities.DevLittleVideoItemBuilder.5;
import com.tencent.device.msg.activities.DevLittleVideoItemBuilder.6;
import com.tencent.device.msg.activities.DevLittleVideoItemBuilder.7;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class abjz
  extends ShortVideoRealItemBuilder
  implements abhx
{
  private EncodeVideoTask.ResultListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener = new abka(this);
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  
  public abjz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public static void a(Context paramContext, MessageForShortVideo paramMessageForShortVideo, View paramView, SessionInfo paramSessionInfo)
  {
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramMessageForShortVideo;
    Object localObject3 = paramMessageForShortVideo.videoFileName;
    Object localObject1 = paramMessageForShortVideo.mThumbFilePath;
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      localObject2 = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
      localObject1 = localObject2;
      if (!FileUtils.fileExistsAndNotEmpty((String)localObject3))
      {
        localObject3 = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
        localObject1 = localObject2;
      }
    }
    for (Object localObject2 = localObject3;; localObject2 = localObject3)
    {
      if (ShortVideoUtils.isVideoSoLibLoaded())
      {
        paramView = new Bundle();
        paramView.putInt("uintype", paramMessageForShortVideo.istroop);
        paramView.putString("from_uin", ShortVideoUtils.getFromUinForForward(paramMessageForShortVideo));
        paramView.putInt("from_uin_type", paramSessionInfo.curType);
        paramView.putInt("from_busi_type", paramMessageForShortVideo.busiType);
        paramView.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
        paramView.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
        paramView.putString("file_name", paramMessageForShortVideo.videoFileName);
        paramView.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
        paramView.putString("file_send_path", (String)localObject2);
        paramView.putString("thumbfile_send_path", (String)localObject1);
        paramView.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
        paramView.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
        paramView.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
        paramView.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
        paramView.putString("file_source", paramMessageForShortVideo.fileSource);
        paramView.putString("file_uuid", paramMessageForShortVideo.uuid);
        paramView.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
        paramView.putInt("video_play_caller", 0);
        paramView.putLong("message_click_start", System.currentTimeMillis());
        paramView.putParcelable("key_message_for_shortvideo", paramMessageForShortVideo);
        paramMessageForShortVideo = new Intent(paramContext, ShortVideoPlayActivity.class);
        paramMessageForShortVideo.putExtras(paramView);
        paramContext.startActivity(paramMessageForShortVideo);
        return;
      }
      paramView = aavz.a(paramView);
      paramMessageForShortVideo = new Bundle();
      paramMessageForShortVideo.putParcelable("KEY_THUMBNAL_BOUND", paramView);
      if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.isUpComingPrevious)) {
        paramMessageForShortVideo.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().getCurrentPanel());
      }
      paramMessageForShortVideo.putBoolean("extra.IS_FROM_MULTI_MSG", false);
      paramView = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramView.hasNext())
      {
        localObject3 = (ActivityManager.RunningAppProcessInfo)paramView.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject3).processName.endsWith("mobileqq")) {
          paramMessageForShortVideo.putInt("extra.MOBILE_QQ_PROCESS_ID", ((ActivityManager.RunningAppProcessInfo)localObject3).pid);
        }
      }
      paramMessageForShortVideo.putInt("forward_source_uin_type", paramSessionInfo.curType);
      paramMessageForShortVideo.putString("uin", localMessageForDevLittleVideo.frienduin);
      paramView = new AIODevLittleVideoData();
      paramView.a = ((String)localObject1);
      paramView.b = ((String)localObject2);
      paramMessageForShortVideo.putBoolean("extra.ENTER_NEW_GALLERY", true);
      blvp.a(paramContext, paramMessageForShortVideo, new AIOImageProviderService(localMessageForDevLittleVideo.selfuin, localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo), paramView, -1, -1);
      return;
    }
  }
  
  private void a(CropBubbleVideoView paramCropBubbleVideoView, String paramString)
  {
    if (a(paramCropBubbleVideoView, paramString))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramCropBubbleVideoView.showCover(URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions));
    }
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    paramBaseChatItemLayout = (ahha)paramafqr;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    paramafqr = ((Context)localObject1).getResources();
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramChatMessage;
    paramChatMessage = ShortVideoUtils.adjustSize(localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
    int i = paramChatMessage[0];
    int j = paramChatMessage[1];
    boolean bool = localMessageForDevLittleVideo.isSend();
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = new RelativeLayout((Context)localObject1);
      paramView = (CropBubbleVideoView)bapu.a(this.jdField_a_of_type_AndroidContentContext, localMessageForDevLittleVideo.uniseq, null, bool);
      paramView.setId(2131362355);
      paramView.setVisibility(0);
      paramView.setContentDescription(anvx.a(2131702726));
      paramChatMessage.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView((Context)localObject1);
      paramChatMessage.addView(localMessageProgressView);
      ImageView localImageView = new ImageView((Context)localObject1);
      localImageView.setImageResource(2130838089);
      localImageView.setVisibility(8);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131372790);
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131372790);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.dp2px(10.0F, paramafqr);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.dp2px(10.0F, paramafqr);
      paramChatMessage.addView(localImageView, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new LinearLayout((Context)localObject1);
      ((LinearLayout)localObject2).setOrientation(1);
      ((LinearLayout)localObject2).setGravity(17);
      Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramChatMessage.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject1 = new TextView((Context)localObject1);
      localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(70.0F, paramafqr);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setId(2131364565);
      ((LinearLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      paramChatMessage.setOnClickListener(this);
      paramChatMessage.setOnTouchListener(paramaftk);
      paramChatMessage.setOnLongClickListener(paramaftk);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    }
    paramafqr = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getLayoutParams();
    if (paramafqr == null)
    {
      paramafqr = new RelativeLayout.LayoutParams(i, j);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramafqr);
      ((abkw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(paramChatMessage, this);
      paramaftk = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView;
      paramafqr = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView;
      paramView = paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView;
      if (!localMessageForDevLittleVideo.isSendFromLocal()) {
        break label827;
      }
      if ((localMessageForDevLittleVideo.md5 != null) && (localMessageForDevLittleVideo.md5.length() != 0)) {
        break label630;
      }
      paramView = localMessageForDevLittleVideo.mThumbFilePath;
      if (!FileUtils.fileExistsAndNotEmpty(paramView)) {
        break label599;
      }
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: 占坑");
      }
      a(paramaftk, paramView);
      a(localMessageForDevLittleVideo, paramBaseChatItemLayout, localMessageForDevLittleVideo.videoFileProgress, false);
      ThreadManager.postImmediately(new DevLittleVideoItemBuilder.1(this, localMessageForDevLittleVideo), null, true);
    }
    label599:
    label630:
    do
    {
      do
      {
        do
        {
          return paramChatMessage;
          if ((paramafqr.width == i) && (paramafqr.height == j)) {
            break;
          }
          paramafqr.width = i;
          paramafqr.height = j;
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramafqr);
          break;
          paramaftk.showCover(URLDrawableHelper.getFailedDrawable());
          paramafqr.setVisibility(4);
        } while (!QLog.isColorLevel());
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView:You must get thumb before send video.");
        return paramChatMessage;
        localObject1 = ShortVideoUtils.getShortVideoThumbPicPath(localMessageForDevLittleVideo.thumbMD5, "jpg");
        paramView = localMessageForDevLittleVideo.videoFileName;
        paramafqr = paramView;
        if (!FileUtils.fileExistsAndNotEmpty(paramView)) {
          paramafqr = ShortVideoUtils.getShortVideoSavePath(localMessageForDevLittleVideo, "mp4");
        }
        if (localMessageForDevLittleVideo.videoFileStatus == 1003)
        {
          if ((ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO) && (ShortVideoUtils.isVideoSoLibLoaded()) && (FileUtils.fileExistsAndNotEmpty(paramafqr)))
          {
            if (QLog.isColorLevel()) {
              QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showVideo(video send finished)");
            }
            a(paramaftk, paramafqr, (String)localObject1, localMessageForDevLittleVideo, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
            return paramChatMessage;
          }
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb(video send finished)");
          }
          a(paramaftk, (String)localObject1);
          return paramChatMessage;
        }
        if (QLog.isColorLevel()) {
          QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb (video not send finished)");
        }
        a(paramaftk, (String)localObject1);
      } while (localMessageForDevLittleVideo.videoFileStatus != 1002);
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showProgress (video sending)");
      }
      a(localMessageForDevLittleVideo, paramBaseChatItemLayout, localMessageForDevLittleVideo.videoFileProgress, false);
      return paramChatMessage;
      paramafqr = localMessageForDevLittleVideo.videoFileName;
      paramView = localMessageForDevLittleVideo.mThumbFilePath;
      if (FileUtils.fileExistsAndNotEmpty(paramafqr))
      {
        if ((ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO) && (ShortVideoUtils.isVideoSoLibLoaded()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showVideo(video recv finished)");
          }
          a(paramaftk, paramafqr, paramView, localMessageForDevLittleVideo, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
          return paramChatMessage;
        }
        if (FileUtils.fileExistsAndNotEmpty(paramView))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showThumb(video recv finished)");
          }
          a(paramaftk, paramView);
          return paramChatMessage;
        }
        c(localMessageForDevLittleVideo);
        return paramChatMessage;
      }
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: showLoading(video not recv finished)");
      }
      paramaftk.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: downloadLittleVideo(video not recv finished)");
      }
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
      {
        localMessageForDevLittleVideo.videoFileStatus = 2005;
        localMessageForDevLittleVideo.videoFileProgress = 0;
        localMessageForDevLittleVideo.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
        return paramChatMessage;
      }
    } while (localMessageForDevLittleVideo.videoFileStatus != 2001);
    label827:
    localMessageForDevLittleVideo.videoFileStatus = 2002;
    localMessageForDevLittleVideo.videoFileProgress = 0;
    localMessageForDevLittleVideo.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(localMessageForDevLittleVideo.frienduin, localMessageForDevLittleVideo.istroop, localMessageForDevLittleVideo.uniseq, localMessageForDevLittleVideo.msgData);
    a(localMessageForDevLittleVideo, paramBaseChatItemLayout, localMessageForDevLittleVideo.videoFileProgress, false);
    if (!FileUtils.fileExistsAndNotEmpty(paramView))
    {
      if (QLog.isColorLevel()) {
        QLog.i("DevLittleVideoItemBuilder", 2, "getBubbleView: downloadLittleVideoThumb(video not recv finished)");
      }
      c(localMessageForDevLittleVideo);
    }
    b(localMessageForDevLittleVideo);
    return paramChatMessage;
  }
  
  public void a(View paramView)
  {
    paramView = (ahha)AIOUtils.getHolder(paramView);
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForDevLittleVideo.isSendFromLocal())
    {
      localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbkzi.a(2131689976, 5);
      localbkzi.c(2131690697);
      localbkzi.a(new abkb(this, localMessageForDevLittleVideo, paramView, localbkzi));
      localbkzi.show();
      return;
    }
    bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbkzi.a(2131689978, 5);
    localbkzi.c(2131690697);
    localbkzi.a(new abkc(this, localMessageForDevLittleVideo, paramView, localbkzi));
    localbkzi.show();
  }
  
  public void a(View paramView, abhy paramabhy)
  {
    paramView = (ahha)AIOUtils.getHolder(paramView);
    if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq != paramabhy.jdField_a_of_type_Long) {}
    MessageForDevLittleVideo localMessageForDevLittleVideo;
    CropBubbleVideoView localCropBubbleVideoView;
    int i;
    do
    {
      do
      {
        do
        {
          return;
          localMessageForDevLittleVideo = (MessageForDevLittleVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          if (QLog.isColorLevel()) {
            QLog.d("DevLittleVideoItemBuilder", 2, "updateView msg.uniseq:" + paramabhy.jdField_a_of_type_Long + " ===> fileStatus:" + ShortVideoUtils.getFileStatusStr(paramabhy.jdField_a_of_type_Int));
          }
          localCropBubbleVideoView = paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView;
          i = (int)(paramabhy.jdField_a_of_type_Float * 100.0F);
          switch (paramabhy.jdField_a_of_type_Int)
          {
          default: 
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_START progress " + localMessageForDevLittleVideo.videoFileProgress);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_FINISHED");
        }
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        a(paramView);
      } while (!ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO);
      paramabhy = localMessageForDevLittleVideo.videoFileName;
      paramView = paramabhy;
      if (!FileUtils.fileExistsAndNotEmpty(paramabhy)) {
        paramView = ShortVideoUtils.getShortVideoSavePath(localMessageForDevLittleVideo, "mp4");
      }
    } while ((!ShortVideoUtils.isVideoSoLibLoaded()) || (!FileUtils.fileExistsAndNotEmpty(paramView)));
    a(localCropBubbleVideoView, paramView, localMessageForDevLittleVideo.mThumbFilePath, localMessageForDevLittleVideo, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_ERROR");
    }
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    a(paramView);
    b();
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_PROCESS " + i);
    }
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    a(localMessageForDevLittleVideo, paramView, i, true);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_FINISHED");
    }
    paramabhy = localMessageForDevLittleVideo.videoFileName;
    String str = localMessageForDevLittleVideo.mThumbFilePath;
    if ((ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO) && (ShortVideoUtils.isVideoSoLibLoaded()) && (FileUtils.fileExistsAndNotEmpty(paramabhy)))
    {
      a(localCropBubbleVideoView, paramabhy, str, localMessageForDevLittleVideo, localMessageForDevLittleVideo.thumbWidth, localMessageForDevLittleVideo.thumbHeight);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
    }
    for (;;)
    {
      a(paramView);
      return;
      if (FileUtils.fileExistsAndNotEmpty(str))
      {
        a(localCropBubbleVideoView, str);
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      }
      else
      {
        localCropBubbleVideoView.showCover(URLDrawableHelper.getFailedDrawable());
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        b();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_PROCESS " + i);
    }
    a(localMessageForDevLittleVideo, paramView, i, true);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("DevLittleVideoItemBuilder", 2, "VIDEO STATUS_SEND_ERROR");
    }
    paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    a(paramView);
    b();
  }
  
  void a(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new DevLittleVideoItemBuilder.5(this, paramMessageForDevLittleVideo));
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramChatMessage = (MessageForDevLittleVideo)paramChatMessage;
    return (paramChatMessage.videoFileStatus == 1005) || (paramChatMessage.videoFileStatus == 2005);
  }
  
  public bhjs[] a(View paramView)
  {
    paramView = new bhjq();
    admh.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    return paramView.a();
  }
  
  void b(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    if (paramMessageForDevLittleVideo.isSendFromLocal()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new DevLittleVideoItemBuilder.6(this, paramMessageForDevLittleVideo));
  }
  
  void c(MessageForDevLittleVideo paramMessageForDevLittleVideo)
  {
    if (paramMessageForDevLittleVideo.isSendFromLocal()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new DevLittleVideoItemBuilder.7(this, paramMessageForDevLittleVideo));
  }
  
  public void onClick(View paramView)
  {
    ahha localahha = (ahha)AIOUtils.getHolder(paramView);
    MessageForDevLittleVideo localMessageForDevLittleVideo = (MessageForDevLittleVideo)localahha.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.getId() == 2131364567) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting())
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695634, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      }
      else if (paramView.getId() == 2131364522)
      {
        String str2 = localMessageForDevLittleVideo.videoFileName;
        Object localObject = localMessageForDevLittleVideo.mThumbFilePath;
        String str1 = str2;
        if (localMessageForDevLittleVideo.isSendFromLocal())
        {
          String str3 = ShortVideoUtils.getShortVideoThumbPicPath(localMessageForDevLittleVideo.thumbMD5, "jpg");
          localObject = str3;
          str1 = str2;
          if (!FileUtils.fileExistsAndNotEmpty(str2))
          {
            str1 = ShortVideoUtils.getShortVideoSavePath(localMessageForDevLittleVideo, "mp4");
            localObject = str3;
          }
        }
        if (!FileUtils.fileExistsAndNotEmpty(str1))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "downloadLittleVideo ");
          }
          b(localMessageForDevLittleVideo);
        }
        else if (!FileUtils.fileExistsAndNotEmpty((String)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.i("DevLittleVideoItemBuilder", 2, "downloadLittleVideoThumb ");
          }
          c(localMessageForDevLittleVideo);
        }
        else
        {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
          a(this.jdField_a_of_type_AndroidContentContext, localMessageForDevLittleVideo, localahha.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        }
      }
      else
      {
        super.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abjz
 * JD-Core Version:    0.7.0.1
 */