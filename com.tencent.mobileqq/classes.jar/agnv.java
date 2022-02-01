import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.AudioAnimationView;
import com.tencent.mobileqq.widget.CircleProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.ref.WeakReference;

public class agnv
  extends BaseBubbleBuilder
  implements afbb, ShortVideoConstants
{
  static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new aqww(-10065297, c, d);
  public static WeakReference<VideoDrawable> a;
  private static WeakReference<MessageForShortVideo> jdField_b_of_type_JavaLangRefWeakReference;
  static int c;
  static int d;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  Handler jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    c = AIOUtils.dp2px(160.0F, localResources);
    d = AIOUtils.dp2px(160.0F, localResources);
  }
  
  public agnv(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    ShortVideoUtils.loadShortVideoSo(paramQQAppInterface);
    agoc.a();
  }
  
  private View a(View paramView, agob paramagob, agny paramagny, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      String str = paramMessageForShortVideo.mThumbFilePath;
      if (!FileUtils.fileExistsAndNotEmpty(str)) {
        break label146;
      }
      if (paramagny.a(str))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 占坑 msgSeq: " + paramagob.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramagny.b(URLDrawable.getDrawable(new File(str), localURLDrawableOptions));
        a(paramagob);
        Utils.executeAsyncTaskOnSerialExcuter(new agoa(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo), new Void[] { (Void)null });
      }
    }
    label146:
    do
    {
      return paramView;
      paramagny.setImageDrawable(URLDrawableHelper.getFailedDrawable());
      b(paramagob);
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView():You must get thumb before send video. msgSeq: " + paramagob.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return paramView;
  }
  
  private View a(View paramView, agob paramagob, agny paramagny, MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2)
  {
    if (paramagny.a(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷缩略图 " + paramString1 + " msgSeq: " + paramagob.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramagny.b(URLDrawable.getDrawable(new File(paramString1), localURLDrawableOptions));
    }
    for (;;)
    {
      paramagob.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      if (!FileUtils.fileExistsAndNotEmpty(paramString2)) {
        break label253;
      }
      if ((!paramMessageForShortVideo.isSendFromLocal()) || (paramMessageForShortVideo.videoFileProgress > 100) || (paramMessageForShortVideo.videoFileStatus == 1003)) {
        break;
      }
      a(paramagob, paramMessageForShortVideo.videoFileProgress);
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷缩略图用缓存 " + paramString1 + " msgSeq: " + paramagob.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramString1 = paramagny.b;
      if ((paramString1 != null) && (paramString1.getStatus() == 1)) {
        paramagny.b(paramString1);
      }
    }
    if ((ShortVideoUtils.isVideoSoLibLoaded()) && (agoc.b))
    {
      b(paramagob);
      return paramView;
    }
    c(paramagob);
    return paramView;
    label253:
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView():短视频已过期不启动下载流程 1 msgSeq: " + paramagob.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      b(paramagob, 2131717739);
      return paramView;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().a(paramMessageForShortVideo, true))
    {
      a(paramMessageForShortVideo, true);
      a(paramagob, paramMessageForShortVideo.videoFileProgress);
      return paramView;
    }
    if (BaseTransProcessor.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq)))
    {
      a(paramagob, paramMessageForShortVideo.videoFileProgress);
      return paramView;
    }
    c(paramagob);
    return paramView;
  }
  
  private void a(agob paramagob, agny paramagny, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (paramagny.a(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 视频存在,刷缩略图 " + paramString1);
      }
      if (ShortVideoUtils.isVideoSoLibLoaded())
      {
        paramString1 = URLDrawable.URLDrawableOptions.obtain();
        paramString1.mRequestWidth = paramInt1;
        paramString1.mRequestHeight = paramInt2;
        paramString1.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramString1.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
        localVideoDrawableParams.mPlayVideoFrame = true;
        localVideoDrawableParams.mVideoRoundCorner = 0;
        localVideoDrawableParams.mRequestedFPS = agoc.a;
        paramString1.mExtraInfo = localVideoDrawableParams;
        paramagny.b(URLDrawable.getDrawable(new File(paramString2), paramString1));
      }
    }
    for (;;)
    {
      b(paramagob);
      return;
      paramString1 = paramagny.b;
      if ((paramString1 != null) && (paramString1.getStatus() == 1)) {
        paramagny.b(paramString1);
      }
    }
  }
  
  private void a(agob paramagob, MessageForShortVideo paramMessageForShortVideo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_FILE_UNSAFE");
    }
    b(paramagob);
    if (paramMessageForShortVideo.uiOperatorFlag == 2)
    {
      paramagob.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718450, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718474, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
  }
  
  private void a(agob paramagob, MessageForShortVideo paramMessageForShortVideo, agny paramagny, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString1))
    {
      if (paramagny.a(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 缩略图存在，刷缩略图 " + paramString1);
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = paramInt1;
        localURLDrawableOptions.mRequestHeight = paramInt2;
        localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramagny.b(URLDrawable.getDrawable(new File(paramString1), localURLDrawableOptions));
        if (FileUtils.fileExistsAndNotEmpty(paramString2)) {
          break label169;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getShortVideoPredownloer().a(paramMessageForShortVideo, true))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 刷缩略图，视频文件不存在， isNeedPredownload=true, downloadVideo");
          }
          a(paramMessageForShortVideo, true);
        }
      }
      else
      {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 刷缩略图，视频文件不存在， isNeedPredownload=false, showPauseProgress");
      }
      c(paramagob);
      return;
      label169:
      if (ShortVideoUtils.isVideoSoLibLoaded())
      {
        b(paramagob);
        return;
      }
      c(paramagob);
      return;
    }
    paramagny.setImageDrawable(URLDrawableHelper.getFailedDrawable());
  }
  
  private void a(agob paramagob, MessageForShortVideo paramMessageForShortVideo, URLDrawable paramURLDrawable)
  {
    paramURLDrawable = (VideoDrawable)paramURLDrawable.getCurrDrawable();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, " videoDrawable.isAudioPlaying(): " + paramURLDrawable.isAudioPlaying());
    }
    if (paramURLDrawable.isAudioPlaying())
    {
      paramURLDrawable.stopAudio();
      paramagob.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      jdField_b_of_type_JavaLangRefWeakReference = null;
      return;
    }
    if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) {
      MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
    }
    if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() != paramURLDrawable) && (((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).isAudioPlaying()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "onCLick sPlayingAudioDrawable.get() not null && isAudioPlaying, need stop audio.");
      }
      ((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).stopAudio();
      if ((jdField_b_of_type_JavaLangRefWeakReference != null) && (jdField_b_of_type_JavaLangRefWeakReference.get() != null))
      {
        a(this.jdField_a_of_type_ComTencentWidgetListView, (ChatMessage)jdField_b_of_type_JavaLangRefWeakReference.get());
        jdField_b_of_type_JavaLangRefWeakReference = null;
      }
    }
    paramURLDrawable.resetAndPlayAudioOnce();
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramURLDrawable);
    paramagob.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
    jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramMessageForShortVideo);
    paramURLDrawable.setOnAudioPlayOnceListener(new agnx(this));
  }
  
  private void a(agob paramagob, MessageForShortVideo paramMessageForShortVideo, String paramString, agny paramagny, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_RECV_FINISHED");
    }
    if (agoc.b)
    {
      String str = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
      if (paramagny.a(str))
      {
        QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "handleMessage: 刷视频 " + str);
        if ((ShortVideoUtils.isVideoSoLibLoaded()) && (FileUtils.fileExistsAndNotEmpty(str)))
        {
          paramString = URLDrawable.URLDrawableOptions.obtain();
          paramString.mRequestWidth = paramInt1;
          paramString.mRequestHeight = paramInt2;
          paramString.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramString.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
          localVideoDrawableParams.mPlayVideoFrame = true;
          localVideoDrawableParams.mVideoRoundCorner = 0;
          localVideoDrawableParams.mRequestedFPS = agoc.a;
          paramString.mExtraInfo = localVideoDrawableParams;
          paramString = URLDrawable.getDrawable(new File(str), paramString);
          if (paramString.getStatus() != 1) {
            break label337;
          }
          paramagny.b(paramString);
        }
      }
      for (;;)
      {
        if (!paramMessageForShortVideo.isSend()) {
          new badr(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 1002);
        }
        if (paramMessageForShortVideo.subBusiType == 1) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", "" + paramMessageForShortVideo.uuid, "" + paramMessageForShortVideo.isSend());
        }
        b(paramagob);
        paramagob.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(0);
        return;
        label337:
        paramagny.a(paramString);
      }
    }
    paramMessageForShortVideo = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForShortVideo))
    {
      if (!paramagny.a(paramMessageForShortVideo)) {
        break label426;
      }
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mRequestWidth = paramInt1;
      paramString.mRequestHeight = paramInt2;
      paramString.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramString.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramagny.b(URLDrawable.getDrawable(new File(paramMessageForShortVideo), paramString));
    }
    for (;;)
    {
      c(paramagob);
      return;
      label426:
      paramMessageForShortVideo = paramagny.b;
      if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.getStatus() == 1)) {
        paramagny.b(paramMessageForShortVideo);
      }
    }
  }
  
  private void a(FileMsg paramFileMsg, agob paramagob, MessageForShortVideo paramMessageForShortVideo, agny paramagny)
  {
    if (QLog.isColorLevel())
    {
      if (paramFileMsg.status == 2005) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_ERROR");
      }
    }
    else
    {
      paramMessageForShortVideo = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
      if (FileUtils.fileExistsAndNotEmpty(paramMessageForShortVideo))
      {
        if (!paramagny.a(paramMessageForShortVideo)) {
          break label154;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_FILE_EXPIRED: 刷缩略图 " + paramMessageForShortVideo);
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramagny.b(URLDrawable.getDrawable(new File(paramMessageForShortVideo), localURLDrawableOptions));
      }
    }
    for (;;)
    {
      if (paramFileMsg.status != 2005) {
        break label213;
      }
      b(paramagob, 2131717743);
      return;
      QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_FILE_EXPIRED");
      break;
      label154:
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_FILE_EXPIRED: 刷缩略图用缓存 " + paramMessageForShortVideo);
      }
      paramMessageForShortVideo = paramagny.b;
      if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.getStatus() == 1)) {
        paramagny.b(paramMessageForShortVideo);
      }
    }
    label213:
    b(paramagob, 2131717739);
  }
  
  public static void a(ListView paramListView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bool1 = bool2;
      if (jdField_a_of_type_JavaLangRefWeakReference.get() != null)
      {
        bool1 = bool2;
        if (((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).isAudioPlaying())
        {
          ((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).stopAudio();
          bool2 = true;
          bool1 = bool2;
          if (jdField_b_of_type_JavaLangRefWeakReference != null)
          {
            bool1 = bool2;
            if (jdField_b_of_type_JavaLangRefWeakReference.get() != null)
            {
              a(paramListView, (ChatMessage)jdField_b_of_type_JavaLangRefWeakReference.get());
              bool1 = bool2;
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "stopAudioIfPlaying(), stopSuccess = " + bool1);
    }
  }
  
  static void a(ListView paramListView, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && (paramListView != null))
    {
      i = AIOUtils.findMessagePosition(paramChatMessage.uniseq, paramListView.getAdapter());
      if (i > -1)
      {
        paramListView = AIOUtils.getViewByPostion(paramListView, i);
        if (paramListView != null)
        {
          paramListView = AIOUtils.getHolder(paramListView);
          if ((paramListView != null) && ((paramListView instanceof agob)))
          {
            paramListView = (agob)paramListView;
            if (paramListView != null) {
              paramListView.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
            }
          }
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int i;
      return;
    }
    QLog.e("ShortVideoPTVItemBuilder", 2, "stopAudioAnimByMsg(), message = " + paramChatMessage);
  }
  
  private View b(View paramView, agob paramagob, agny paramagny, MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2)
  {
    if (!paramMessageForShortVideo.isSend()) {
      new badr(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 1002);
    }
    Object localObject;
    if (paramagny.a(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频 " + paramString2 + " msgSeq: " + paramagob.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      if (!paramagny.a(paramString1)) {
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramagny.b;
      }
      VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
      localVideoDrawableParams.mPlayVideoFrame = true;
      localVideoDrawableParams.mPlayAudioFrame = false;
      localVideoDrawableParams.mVideoRoundCorner = 0;
      localVideoDrawableParams.mRequestedFPS = agoc.a;
      ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = localVideoDrawableParams;
      localObject = URLDrawable.getDrawable(new File(paramString2), (URLDrawable.URLDrawableOptions)localObject);
      paramagny.b((URLDrawable)localObject);
      if ((((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))
      {
        boolean bool = ((VideoDrawable)((URLDrawable)localObject).getCurrDrawable()).isAudioPlaying();
        if (!bool) {
          break label417;
        }
        paramagob.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频, isAudioPlaying= " + bool + ", videoPath:" + paramString2 + " msgSeq: " + paramagob.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
      }
    }
    for (;;)
    {
      if (!FileUtils.fileExistsAndNotEmpty(paramString1))
      {
        a(paramMessageForShortVideo);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: Video file exist and status finish. Thumb not exist. msgSeq: " + paramagob.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
      }
      if (!paramMessageForShortVideo.isSendFromLocal()) {
        break label568;
      }
      paramagny = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      if (!BaseTransProcessor.class.isInstance(paramagny)) {
        break label561;
      }
      if (((BaseTransProcessor)paramagny).getFileStatus() == 1002L) {
        a(paramagob, paramMessageForShortVideo.videoFileProgress);
      }
      return paramView;
      label417:
      paramagob.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      break;
      localObject = paramagny.b;
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1))
      {
        paramagny.b((URLDrawable)localObject);
        if ((((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))
        {
          paramagny = (VideoDrawable)((URLDrawable)localObject).getCurrDrawable();
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频用缓存, isAudioPlaying= " + paramagny.isAudioPlaying() + ", videoPath:" + paramString2 + " msgSeq: " + paramagob.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          }
          if (paramagny.isAudioPlaying()) {
            paramagob.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
          } else {
            paramagob.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
          }
        }
      }
    }
    label561:
    b(paramagob);
    return paramView;
    label568:
    b(paramagob);
    return paramView;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aeze a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (agob)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_Agny;
      }
    }
    return null;
  }
  
  public aezf a()
  {
    return new agob(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afce paramafce)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafce);
    paramafce = afaz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramafce != null) {
      paramafce.a(paramView, this);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetListView == null) && (paramViewGroup != null) && ((paramViewGroup instanceof ListView))) {
      this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramViewGroup);
    }
    try
    {
      paramViewGroup = (agob)paramView.getTag();
      float f = ((MessageForShortVideo)paramChatMessage).videoFileSize / 1000;
      paramViewGroup.b.append(f);
      paramViewGroup.b.append("K");
      paramViewGroup.b.append(String.valueOf(((MessageForShortVideo)paramChatMessage).videoFileTime));
      paramViewGroup.b.append("秒");
      paramView.setContentDescription(paramViewGroup.b.toString());
      return paramView;
    }
    catch (Exception paramChatMessage) {}
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    paramBaseChatItemLayout = (agob)paramaezf;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    Object localObject3 = ((Context)localObject1).getResources();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView(), message = " + paramChatMessage);
    }
    if (paramView == null)
    {
      paramaezf = new RelativeLayout((Context)localObject1);
      int i = AIOUtils.dp2px(160.0F, (Resources)localObject3);
      int j = AIOUtils.dp2px(160.0F, (Resources)localObject3);
      paramView = new agny((Context)localObject1);
      paramView.setId(2131372596);
      paramView.setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject2 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramaezf.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new CircleProgressView((Context)localObject1);
      ((CircleProgressView)localObject2).setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
      localLayoutParams.addRule(13);
      paramaezf.addView((View)localObject2, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(8, 2131372596);
      localLayoutParams.bottomMargin = AIOUtils.dp2px(6.0F, (Resources)localObject3);
      localObject3 = new AudioAnimationView((Context)localObject1);
      ((AudioAnimationView)localObject3).setRectCount(7);
      ((AudioAnimationView)localObject3).setSyle(1);
      ((AudioAnimationView)localObject3).setIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838238));
      paramaezf.addView((View)localObject3, localLayoutParams);
      localObject1 = new ImageView((Context)localObject1);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      ((ImageView)localObject1).setVisibility(8);
      paramaezf.addView((View)localObject1, localLayoutParams);
      paramaezf.setOnClickListener(this);
      paramaezf.setOnTouchListener(paramafce);
      paramaezf.setOnLongClickListener(paramafce);
      paramBaseChatItemLayout.jdField_a_of_type_Agny = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView = ((CircleProgressView)localObject2);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView = ((AudioAnimationView)localObject3);
    }
    for (;;)
    {
      paramView = paramBaseChatItemLayout.jdField_a_of_type_Agny;
      paramafce = (MessageForShortVideo)paramChatMessage;
      paramView.c = paramafce.isSend();
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIsSend(paramafce.isSend());
      if (e)
      {
        localObject1 = new StringBuilder();
        if (!paramChatMessage.isSend()) {
          break label530;
        }
        ((StringBuilder)localObject1).append("你发出视频对讲消息,");
      }
      for (;;)
      {
        float f = ((MessageForShortVideo)paramChatMessage).videoFileSize / 1000;
        ((StringBuilder)localObject1).append("文件大小:");
        ((StringBuilder)localObject1).append(f);
        ((StringBuilder)localObject1).append("K ");
        ((StringBuilder)localObject1).append("视频时长:");
        ((StringBuilder)localObject1).append(String.valueOf(((MessageForShortVideo)paramChatMessage).videoFileTime));
        ((StringBuilder)localObject1).append("秒");
        paramaezf.setContentDescription(((StringBuilder)localObject1).toString());
        if (paramafce.md5 != null) {
          break;
        }
        return a(paramaezf, paramBaseChatItemLayout, paramView, paramafce);
        label530:
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick).append("发出视频对讲消息,");
      }
      paramChatMessage = ShortVideoUtils.getShortVideoThumbPicPath(paramafce.thumbMD5, "jpg");
      localObject1 = ShortVideoUtils.getShortVideoSavePath(paramafce, "mp4");
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView() videoPath" + (String)localObject1 + "thumbPath=" + paramChatMessage);
      }
      if ((agoc.b) && (ShortVideoUtils.isVideoSoLibLoaded()) && (FileUtils.fileExistsAndNotEmpty((String)localObject1)) && ((!paramafce.isSendFromLocal()) || (paramafce.videoFileStatus == 1003) || (paramafce.videoFileStatus == 2003))) {
        return b(paramaezf, paramBaseChatItemLayout, paramView, paramafce, paramChatMessage, (String)localObject1);
      }
      if (FileUtils.fileExistsAndNotEmpty(paramChatMessage)) {
        return a(paramaezf, paramBaseChatItemLayout, paramView, paramafce, paramChatMessage, (String)localObject1);
      }
      if (paramafce.videoFileStatus == 5002)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView():短视频已过期不启动下载流程 2 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        paramView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        b(paramBaseChatItemLayout, 2131717739);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
        return paramaezf;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 下占位图 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      a(paramafce);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      return paramaezf;
      paramaezf = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bfwr.a(paramChatMessage.issend)) {
      return amtj.a(2131713171);
    }
    return amtj.a(2131713160);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt != 2131365382) {
        break label38;
      }
      acvv.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
    }
    label38:
    do
    {
      do
      {
        return;
        if (paramInt == 2131371498)
        {
          super.d(paramChatMessage);
          return;
        }
        if (paramInt == 2131367094)
        {
          paramInt = aydq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
          if (paramInt == 3) {
            paramContext = "1";
          }
          for (;;)
          {
            bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
            b(localMessageForShortVideo);
            return;
            if (paramInt == 2) {
              paramContext = "2";
            } else if (paramInt == 0) {
              paramContext = "3";
            } else {
              paramContext = "4";
            }
          }
        }
        if (paramInt == 2131366347)
        {
          bkov.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          bkpf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
          bkpf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
          return;
        }
        if (paramInt != 2131371455) {
          break label422;
        }
        if (localMessageForShortVideo.md5 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoPTVItemBuilder", 2, "onMenuItemClicked: msg_revoke => md5 = null");
      return;
      int i = 1;
      paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
      paramInt = i;
      if (paramContext != null) {
        if (!ShortVideoUploadProcessor.class.isInstance(paramContext))
        {
          paramInt = i;
          if (!ShortVideoForwardProcessor.class.isInstance(paramContext)) {}
        }
        else
        {
          boolean bool = ((BaseTransProcessor)paramContext).isPause();
          int j = localMessageForShortVideo.videoFileStatus;
          if ((!bool) && (j != 1002))
          {
            paramInt = i;
            if (j != 1001) {}
          }
          else
          {
            i = 0;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().stopSendingShortVideo(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
            ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(20)).getBaseMessageManager(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
            paramInt = i;
            if (QLog.isColorLevel())
            {
              QLog.d("ShortVideoPTVItemBuilder", 2, "onMenuItemClicked: stop uploading short video");
              paramInt = i;
            }
          }
        }
      }
    } while (paramInt == 0);
    super.a(localMessageForShortVideo);
    return;
    label422:
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  void a(agob paramagob)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showLoading() msgSeq: " + paramagob.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramagob.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIndeterminate(true);
    paramagob.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a();
    paramagob.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void a(agob paramagob, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showProgress(), progress = " + paramInt + " msgSeq: " + paramagob.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    CircleProgressView localCircleProgressView = paramagob.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView;
    int i = paramInt;
    if (paramInt > 100)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "startShowProgress, illegal process:" + paramInt + " msgSeq: " + paramagob.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      i = 100;
    }
    localCircleProgressView.setIndeterminate(false);
    localCircleProgressView.setProgress(i);
    paramagob.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (agob)AIOUtils.getHolder(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {
      return;
    }
    bjnw localbjnw = (bjnw)bjon.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbjnw.a(2131689947, 5);
    localbjnw.c(2131690620);
    localbjnw.a(new agnw(this, localMessageForShortVideo, paramView, localbjnw));
    localbjnw.show();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, BaseChatItemLayout.h, 0, BaseChatItemLayout.i);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (agob)AIOUtils.getHolder(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    String str = "handleMessage() msgSeq: " + localMessageForShortVideo.uniseq + " ";
    if (localMessageForShortVideo.uniseq != paramFileMsg.uniseq) {}
    agny localagny;
    do
    {
      return;
      localagny = paramView.jdField_a_of_type_Agny;
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramInt1 = AIOUtils.dp2px(' ', localResources);
      paramInt2 = AIOUtils.dp2px(' ', localResources);
      if ((paramFileMsg.fileType == 6) || (paramFileMsg.fileType == 17) || (paramFileMsg.fileType == 9) || (paramFileMsg.fileType == 20))
      {
        b(paramFileMsg, paramView, localMessageForShortVideo, str, localagny, paramInt1, paramInt2);
        return;
      }
    } while ((paramFileMsg.fileType != 7) && (paramFileMsg.fileType != 18) && (paramFileMsg.fileType != 16));
    a(paramFileMsg, paramView, localMessageForShortVideo, str, localagny, paramInt1, paramInt2);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    bbqx localbbqx = bbqf.a(2, 3);
    bbqh localbbqh = paramMessageForShortVideo.getDownloadInfo(localbbqx.jdField_b_of_type_Int);
    localbbqh.i = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "downloadThumb thumbPath" + localbbqh.i);
    }
    localbbqh.a(paramMessageForShortVideo.istroop, 1);
    localbbqh.f = 2;
    localbbqh.g = 2;
    localbbqx.a(localbbqh);
    localbbqx.a(paramMessageForShortVideo);
    bbqf.a(localbbqx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, agob paramagob)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    Object localObject = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!FileUtils.fileExistsAndNotEmpty((String)localObject))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718481, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      paramagob.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
    }
    do
    {
      return;
      if (!FileUtils.fileExistsAndNotEmpty(str))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718482, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
        paramagob.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      localObject = bbqf.a(1, 3);
      ((bbqx)localObject).a(bbqf.a(((bbqx)localObject).jdField_b_of_type_Int, paramMessageForShortVideo, (bbqx)localObject));
      bbqf.a((bbqx)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((!paramMessageForShortVideo.isSendFromLocal()) || (paramMessageForShortVideo.videoFileStatus != 1005) || (paramMessageForShortVideo.videoFileProgress != 0));
    a(paramagob, 3);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    int j = 1;
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "downloadVideo():STATUS_FILE_EXPIRED 短视频已过期不启动下载流程");
      }
      return;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label109;
      }
    }
    label109:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label114;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131717955, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      return;
      i = 0;
      break;
    }
    label114:
    localObject = bbqf.a(2, 3);
    bbqh localbbqh = paramMessageForShortVideo.getDownloadInfo(((bbqx)localObject).jdField_b_of_type_Int);
    localbbqh.h = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    localbbqh.a(paramMessageForShortVideo.istroop, 0);
    i = j;
    if (paramBoolean) {
      i = 2;
    }
    localbbqh.f = i;
    localbbqh.g = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localbbqh.e + ", uniseq:" + paramMessageForShortVideo.uniseq + "localPath=" + localbbqh.h);
    }
    ((bbqx)localObject).a(localbbqh);
    ((bbqx)localObject).a(paramMessageForShortVideo);
    bbqf.a((bbqx)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void a(FileMsg paramFileMsg, agob paramagob, MessageForShortVideo paramMessageForShortVideo, String paramString, agny paramagny, int paramInt1, int paramInt2)
  {
    switch (paramFileMsg.status)
    {
    default: 
    case 2001: 
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoPTVItemBuilder", 2, "THUMB STATUS_RECV_START");
      return;
    case 2003: 
      paramFileMsg = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
      paramString = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
      boolean bool = FileUtils.fileExistsAndNotEmpty(paramString);
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "THUMB STATUS_RECV_FINISHED: videoExists=" + bool + ", sAutoPlayInAIO=" + agoc.b);
      }
      if ((bool) && (agoc.b))
      {
        a(paramagob, paramagny, paramInt1, paramInt2, paramFileMsg, paramString);
        return;
      }
      a(paramagob, paramMessageForShortVideo, paramagny, paramInt1, paramInt2, paramFileMsg, paramString);
      return;
    case 5002: 
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "THUMB STATUS_FILE_EXPIRED");
      }
      break;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "THUMB STATUS_RECV_ERROR");
    }
    paramFileMsg = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    if (FileUtils.fileExistsAndNotEmpty(paramFileMsg)) {
      if (paramagny.a(paramFileMsg))
      {
        QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "STATUS_RECV_ERROR: 缩略图下载失败刷视频 " + paramFileMsg);
        if (ShortVideoUtils.isVideoSoLibLoaded())
        {
          paramMessageForShortVideo = URLDrawable.URLDrawableOptions.obtain();
          paramMessageForShortVideo.mRequestWidth = paramInt1;
          paramMessageForShortVideo.mRequestHeight = paramInt2;
          paramMessageForShortVideo.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramMessageForShortVideo.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramString = new VideoDrawable.VideoDrawableParams();
          paramString.mPlayVideoFrame = true;
          paramString.mVideoRoundCorner = 0;
          paramString.mRequestedFPS = agoc.a;
          paramMessageForShortVideo.mExtraInfo = paramString;
          paramagny.b(URLDrawable.getDrawable(new File(paramFileMsg), paramMessageForShortVideo));
        }
      }
    }
    for (;;)
    {
      b(paramagob);
      return;
      paramFileMsg = paramagny.b;
      if ((paramFileMsg != null) && (paramFileMsg.getStatus() == 1))
      {
        paramagny.b(paramFileMsg);
        continue;
        paramagny.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      }
    }
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!paramChatMessage.isSendFromLocal()) {}
    do
    {
      do
      {
        return false;
        paramChatMessage = (MessageForShortVideo)paramChatMessage;
      } while ((paramChatMessage.md5 == null) || (paramChatMessage.videoFileStatus == 5002));
      paramBaseChatItemLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramBaseChatItemLayout instanceof BaseTransProcessor))
      {
        if (((BaseTransProcessor)paramBaseChatItemLayout).getFileStatus() == 1005L) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      if (paramChatMessage.videoFileStatus == 1005) {
        return true;
      }
    } while ((paramChatMessage.videoFileProgress == 100) || (paramChatMessage.videoFileStatus == 1003) || (paramChatMessage.videoFileStatus == 2003));
    return true;
  }
  
  public bgbb[] a(View paramView)
  {
    int k = 0;
    bgaz localbgaz = new bgaz();
    Object localObject = (agob)AIOUtils.getHolder(paramView);
    paramView = (MessageForShortVideo)((agob)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.md5 != null)
    {
      String str = ShortVideoUtils.getShortVideoThumbPicPath(paramView.thumbMD5, "jpg");
      ShortVideoUtils.getShortVideoSavePath(paramView, "mp4");
      if (FileUtils.fileExistsAndNotEmpty(str)) {
        if ((((agob)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView == null) || (!((agob)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a())) {
          break label271;
        }
      }
    }
    label271:
    for (int i = 1;; i = 0)
    {
      int j = k;
      if (((agob)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
      {
        j = k;
        if (((agob)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
          j = 1;
        }
      }
      if ((paramView.isSendFromLocal()) && (j == 0)) {
        localbgaz.a(2131367094, this.jdField_a_of_type_AndroidContentContext.getString(2131692448), 2130838971);
      }
      a(paramView, localbgaz);
      if ((i == 0) && (j == 0)) {
        a(localbgaz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView);
      }
      a(localbgaz, paramView);
      if (paramView.md5 != null)
      {
        localObject = ShortVideoUtils.getShortVideoThumbPicPath(paramView.thumbMD5, "jpg");
        if (FileUtils.fileExistsAndNotEmpty(ShortVideoUtils.getShortVideoSavePath(paramView, "mp4"))) {
          localbgaz.a(2131366347, this.jdField_a_of_type_AndroidContentContext.getString(2131692036), 2130838970);
        }
        if (FileUtils.fileExistsAndNotEmpty((String)localObject)) {
          b(paramView, localbgaz);
        }
      }
      super.e(localbgaz, this.jdField_a_of_type_AndroidContentContext);
      return localbgaz.a();
    }
  }
  
  void b(agob paramagob)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "hideProgress() msgSeq: " + paramagob.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramagob.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramagob.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void b(agob paramagob, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showWarnProgress() msgSeq: " + paramagob.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramagob.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramagob.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramagob.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845607);
    paramagob.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "Forward menu clicked, md5 is empty.");
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 21);
    localBundle.putBoolean("forward_need_sendmsg", true);
    String str1 = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    localBundle.putString("forward_thumb", str1);
    localBundle.putString("from_uin", ShortVideoUtils.getFromUinForForward(paramMessageForShortVideo));
    localBundle.putInt("from_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    localBundle.putString("from_session_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
    String str2 = ShortVideoUtils.findVideoPathIfExists(paramMessageForShortVideo);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "Forward menu clicked, thumbPath=" + str1 + ",videoPath = " + str2 + ", " + paramMessageForShortVideo.toLogString());
    }
    localBundle.putString("file_send_path", str2);
    localBundle.putString("thumbfile_send_path", str1);
    localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
    localBundle.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    localBundle.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    localBundle.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    localBundle.putString("file_source", paramMessageForShortVideo.fileSource);
    localBundle.putString("file_uuid", paramMessageForShortVideo.uuid);
    localBundle.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    localBundle.putBoolean("support_progressive", paramMessageForShortVideo.supportProgressive);
    localBundle.putInt("file_width", paramMessageForShortVideo.fileWidth);
    localBundle.putInt("file_height", paramMessageForShortVideo.fileHeight);
    localBundle.putBoolean("is_forward_ptv", true);
    localBundle.putInt("special_video_type", paramMessageForShortVideo.specialVideoType);
    if (paramMessageForShortVideo.CheckIsHotVideo())
    {
      localBundle.putString("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
      localBundle.putString("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
      localBundle.putString("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
      localBundle.putString("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
    }
    paramMessageForShortVideo = new Intent();
    paramMessageForShortVideo.putExtras(localBundle);
    atky.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, agob paramagob)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
      }
      if (!FileUtils.fileExistsAndNotEmpty(ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718482, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
        paramagob.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        paramagob = bbqf.a(4, 3);
        paramagob.a(bbqf.a(paramagob.jdField_b_of_type_Int, paramMessageForShortVideo, paramagob));
        bbqf.a(paramagob, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoPTVItemBuilder", 2, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  protected void b(FileMsg paramFileMsg, agob paramagob, MessageForShortVideo paramMessageForShortVideo, String paramString, agny paramagny, int paramInt1, int paramInt2)
  {
    switch (paramFileMsg.status)
    {
    default: 
    case 1001: 
    case 1003: 
    case 1005: 
    case 1004: 
    case 1002: 
    case 2001: 
    case 2003: 
    case 5001: 
    case 2005: 
    case 5002: 
    case 2004: 
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_START progress " + paramMessageForShortVideo.videoFileProgress);
        }
        paramagob.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_FINISHED");
        }
        b(paramagob);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_ERROR");
        }
        paramagob.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        b(paramagob);
        paramagob.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(8);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_CANCEL");
        }
        b(paramagob);
        return;
        paramInt1 = paramMessageForShortVideo.videoFileProgress;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_PROCESS " + paramInt1);
        }
        a(paramagob, paramInt1);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_RECV_START");
        }
        a(paramagob, paramMessageForShortVideo.videoFileProgress);
        return;
        a(paramagob, paramMessageForShortVideo, paramString, paramagny, paramInt1, paramInt2);
        return;
        a(paramagob, paramMessageForShortVideo);
        return;
        a(paramFileMsg, paramagob, paramMessageForShortVideo, paramagny);
        return;
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_CANCEL");
      return;
    }
    paramInt1 = paramMessageForShortVideo.videoFileProgress;
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
    }
    a(paramagob, paramInt1);
  }
  
  void c(agob paramagob)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showPauseProgress() msgSeq: " + paramagob.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramagob.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramagob.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramagob.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845606);
    paramagob.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void onClick(View paramView)
  {
    agob localagob = (agob)AIOUtils.getHolder(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localagob.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.getId() == 2131364485) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
          break;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695417, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299076));
      }
      if (paramView.getId() != 2131364441) {
        break;
      }
    } while (localMessageForShortVideo.md5 == null);
    Object localObject = ShortVideoUtils.getShortVideoThumbPicPath(localMessageForShortVideo.thumbMD5, "jpg");
    String str = ShortVideoUtils.getShortVideoSavePath(localMessageForShortVideo, "mp4");
    if (QLog.isColorLevel()) {
      QLog.e("ptvitem", 2, "onClick videoPath=" + str + "thumbPath=" + (String)localObject);
    }
    if (!FileUtils.fileExistsAndNotEmpty(str))
    {
      a(localMessageForShortVideo, false);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E96", "0X8005E96", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (!localMessageForShortVideo.isSend()) {
        new badr(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 1003);
      }
      if (localMessageForShortVideo.isBlessMsg) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", "" + localMessageForShortVideo.uuid, "" + localMessageForShortVideo.isSend());
      }
      super.onClick(paramView);
      break;
      if (FileUtils.fileExistsAndNotEmpty((String)localObject))
      {
        if ((agoc.b) && (ShortVideoUtils.isVideoSoLibLoaded()))
        {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E95", "0X8005E95", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
            break;
          }
          if ((localagob.jdField_a_of_type_Agny.getDrawable() == null) || (!(localagob.jdField_a_of_type_Agny.getDrawable() instanceof URLDrawable))) {
            continue;
          }
          localObject = (URLDrawable)localagob.jdField_a_of_type_Agny.getDrawable();
          if ((((URLDrawable)localObject).getStatus() != 1) || (!(((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))) {
            continue;
          }
          a(localagob, localMessageForShortVideo, (URLDrawable)localObject);
          continue;
        }
        ShortVideoRealItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo, localagob.jdField_a_of_type_Agny, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnv
 * JD-Core Version:    0.7.0.1
 */