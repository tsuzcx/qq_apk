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
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.AudioAnimationView;
import com.tencent.mobileqq.widget.CircleProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.ref.WeakReference;

public class ahri
  extends BaseBubbleBuilder
  implements agif, bcww
{
  static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ascz(-10065297, c, d);
  public static WeakReference<VideoDrawable> a;
  private static WeakReference<MessageForShortVideo> jdField_b_of_type_JavaLangRefWeakReference;
  static int c;
  static int d;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  Handler jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    c = agej.a(160.0F, localResources);
    d = agej.a(160.0F, localResources);
  }
  
  public ahri(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    ShortVideoUtils.a(paramQQAppInterface);
    ahrp.a();
  }
  
  private View a(View paramView, ahro paramahro, ahrl paramahrl, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      String str = paramMessageForShortVideo.mThumbFilePath;
      if (!bhmi.b(str)) {
        break label146;
      }
      if (paramahrl.a(str))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 占坑 msgSeq: " + paramahro.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramahrl.b(URLDrawable.getDrawable(new File(str), localURLDrawableOptions));
        a(paramahro);
        Utils.executeAsyncTaskOnSerialExcuter(new ahrn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo), new Void[] { (Void)null });
      }
    }
    label146:
    do
    {
      return paramView;
      paramahrl.setImageDrawable(beyq.a());
      b(paramahro);
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView():You must get thumb before send video. msgSeq: " + paramahro.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return paramView;
  }
  
  private View a(View paramView, ahro paramahro, ahrl paramahrl, MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2)
  {
    if (paramahrl.a(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷缩略图 " + paramString1 + " msgSeq: " + paramahro.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramahrl.b(URLDrawable.getDrawable(new File(paramString1), localURLDrawableOptions));
    }
    for (;;)
    {
      paramahro.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      if (!bhmi.b(paramString2)) {
        break label253;
      }
      if ((!paramMessageForShortVideo.isSendFromLocal()) || (paramMessageForShortVideo.videoFileProgress > 100) || (paramMessageForShortVideo.videoFileStatus == 1003)) {
        break;
      }
      a(paramahro, paramMessageForShortVideo.videoFileProgress);
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷缩略图用缓存 " + paramString1 + " msgSeq: " + paramahro.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramString1 = paramahrl.b;
      if ((paramString1 != null) && (paramString1.getStatus() == 1)) {
        paramahrl.b(paramString1);
      }
    }
    if ((ShortVideoUtils.a()) && (ahrp.b))
    {
      b(paramahro);
      return paramView;
    }
    c(paramahro);
    return paramView;
    label253:
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView():短视频已过期不启动下载流程 1 msgSeq: " + paramahro.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      b(paramahro, 2131717503);
      return paramView;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo, true))
    {
      a(paramMessageForShortVideo, true);
      a(paramahro, paramMessageForShortVideo.videoFileProgress);
      return paramView;
    }
    if (berp.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq)))
    {
      a(paramahro, paramMessageForShortVideo.videoFileProgress);
      return paramView;
    }
    c(paramahro);
    return paramView;
  }
  
  private void a(ahro paramahro, ahrl paramahrl, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (paramahrl.a(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 视频存在,刷缩略图 " + paramString1);
      }
      if (ShortVideoUtils.a())
      {
        paramString1 = URLDrawable.URLDrawableOptions.obtain();
        paramString1.mRequestWidth = paramInt1;
        paramString1.mRequestHeight = paramInt2;
        paramString1.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramString1.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
        localVideoDrawableParams.mPlayVideoFrame = true;
        localVideoDrawableParams.mVideoRoundCorner = 0;
        localVideoDrawableParams.mRequestedFPS = ahrp.jdField_a_of_type_Int;
        paramString1.mExtraInfo = localVideoDrawableParams;
        paramahrl.b(URLDrawable.getDrawable(new File(paramString2), paramString1));
      }
    }
    for (;;)
    {
      b(paramahro);
      return;
      paramString1 = paramahrl.b;
      if ((paramString1 != null) && (paramString1.getStatus() == 1)) {
        paramahrl.b(paramString1);
      }
    }
  }
  
  private void a(ahro paramahro, MessageForShortVideo paramMessageForShortVideo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_FILE_UNSAFE");
    }
    b(paramahro);
    if (paramMessageForShortVideo.uiOperatorFlag == 2)
    {
      paramahro.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718209, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718233, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
  }
  
  private void a(ahro paramahro, MessageForShortVideo paramMessageForShortVideo, ahrl paramahrl, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (bhmi.b(paramString1))
    {
      if (paramahrl.a(paramString1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 缩略图存在，刷缩略图 " + paramString1);
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = paramInt1;
        localURLDrawableOptions.mRequestHeight = paramInt2;
        localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramahrl.b(URLDrawable.getDrawable(new File(paramString1), localURLDrawableOptions));
        if (bhmi.b(paramString2)) {
          break label169;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo, true))
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
      c(paramahro);
      return;
      label169:
      if (ShortVideoUtils.a())
      {
        b(paramahro);
        return;
      }
      c(paramahro);
      return;
    }
    paramahrl.setImageDrawable(beyq.a());
  }
  
  private void a(ahro paramahro, MessageForShortVideo paramMessageForShortVideo, URLDrawable paramURLDrawable)
  {
    paramURLDrawable = (VideoDrawable)paramURLDrawable.getCurrDrawable();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, " videoDrawable.isAudioPlaying(): " + paramURLDrawable.isAudioPlaying());
    }
    if (paramURLDrawable.isAudioPlaying())
    {
      paramURLDrawable.stopAudio();
      paramahro.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
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
    paramahro.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
    jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramMessageForShortVideo);
    paramURLDrawable.setOnAudioPlayOnceListener(new ahrk(this));
  }
  
  private void a(ahro paramahro, MessageForShortVideo paramMessageForShortVideo, String paramString, ahrl paramahrl, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_RECV_FINISHED");
    }
    if (ahrp.b)
    {
      String str = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
      if (paramahrl.a(str))
      {
        QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "handleMessage: 刷视频 " + str);
        if ((ShortVideoUtils.a()) && (bhmi.b(str)))
        {
          paramString = URLDrawable.URLDrawableOptions.obtain();
          paramString.mRequestWidth = paramInt1;
          paramString.mRequestHeight = paramInt2;
          paramString.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramString.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
          localVideoDrawableParams.mPlayVideoFrame = true;
          localVideoDrawableParams.mVideoRoundCorner = 0;
          localVideoDrawableParams.mRequestedFPS = ahrp.jdField_a_of_type_Int;
          paramString.mExtraInfo = localVideoDrawableParams;
          paramString = URLDrawable.getDrawable(new File(str), paramString);
          if (paramString.getStatus() != 1) {
            break label337;
          }
          paramahrl.b(paramString);
        }
      }
      for (;;)
      {
        if (!paramMessageForShortVideo.isSend()) {
          new bbjw(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
        }
        if (paramMessageForShortVideo.subBusiType == 1) {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", "" + paramMessageForShortVideo.uuid, "" + paramMessageForShortVideo.isSend());
        }
        b(paramahro);
        paramahro.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(0);
        return;
        label337:
        paramahrl.a(paramString);
      }
    }
    paramMessageForShortVideo = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (bhmi.b(paramMessageForShortVideo))
    {
      if (!paramahrl.a(paramMessageForShortVideo)) {
        break label426;
      }
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mRequestWidth = paramInt1;
      paramString.mRequestHeight = paramInt2;
      paramString.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramString.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramahrl.b(URLDrawable.getDrawable(new File(paramMessageForShortVideo), paramString));
    }
    for (;;)
    {
      c(paramahro);
      return;
      label426:
      paramMessageForShortVideo = paramahrl.b;
      if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.getStatus() == 1)) {
        paramahrl.b(paramMessageForShortVideo);
      }
    }
  }
  
  private void a(bete parambete, ahro paramahro, MessageForShortVideo paramMessageForShortVideo, ahrl paramahrl)
  {
    if (QLog.isColorLevel())
    {
      if (parambete.d == 2005) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_ERROR");
      }
    }
    else
    {
      paramMessageForShortVideo = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      if (bhmi.b(paramMessageForShortVideo))
      {
        if (!paramahrl.a(paramMessageForShortVideo)) {
          break label154;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_FILE_EXPIRED: 刷缩略图 " + paramMessageForShortVideo);
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramahrl.b(URLDrawable.getDrawable(new File(paramMessageForShortVideo), localURLDrawableOptions));
      }
    }
    for (;;)
    {
      if (parambete.d != 2005) {
        break label213;
      }
      b(paramahro, 2131717507);
      return;
      QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_FILE_EXPIRED");
      break;
      label154:
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_FILE_EXPIRED: 刷缩略图用缓存 " + paramMessageForShortVideo);
      }
      paramMessageForShortVideo = paramahrl.b;
      if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.getStatus() == 1)) {
        paramahrl.b(paramMessageForShortVideo);
      }
    }
    label213:
    b(paramahro, 2131717503);
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
      i = agej.a(paramChatMessage.uniseq, paramListView.getAdapter());
      if (i > -1)
      {
        paramListView = agej.a(paramListView, i);
        if (paramListView != null)
        {
          paramListView = agej.a(paramListView);
          if ((paramListView != null) && ((paramListView instanceof ahro)))
          {
            paramListView = (ahro)paramListView;
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
  
  private View b(View paramView, ahro paramahro, ahrl paramahrl, MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2)
  {
    if (!paramMessageForShortVideo.isSend()) {
      new bbjw(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
    }
    Object localObject;
    if (paramahrl.a(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频 " + paramString2 + " msgSeq: " + paramahro.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      if (!paramahrl.a(paramString1)) {
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramahrl.b;
      }
      VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
      localVideoDrawableParams.mPlayVideoFrame = true;
      localVideoDrawableParams.mPlayAudioFrame = false;
      localVideoDrawableParams.mVideoRoundCorner = 0;
      localVideoDrawableParams.mRequestedFPS = ahrp.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = localVideoDrawableParams;
      localObject = URLDrawable.getDrawable(new File(paramString2), (URLDrawable.URLDrawableOptions)localObject);
      paramahrl.b((URLDrawable)localObject);
      if ((((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))
      {
        boolean bool = ((VideoDrawable)((URLDrawable)localObject).getCurrDrawable()).isAudioPlaying();
        if (!bool) {
          break label417;
        }
        paramahro.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频, isAudioPlaying= " + bool + ", videoPath:" + paramString2 + " msgSeq: " + paramahro.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
      }
    }
    for (;;)
    {
      if (!bhmi.b(paramString1))
      {
        a(paramMessageForShortVideo);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: Video file exist and status finish. Thumb not exist. msgSeq: " + paramahro.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
      }
      if (!paramMessageForShortVideo.isSendFromLocal()) {
        break label568;
      }
      paramahrl = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      if (!berp.class.isInstance(paramahrl)) {
        break label561;
      }
      if (((berp)paramahrl).c() == 1002L) {
        a(paramahro, paramMessageForShortVideo.videoFileProgress);
      }
      return paramView;
      label417:
      paramahro.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      break;
      localObject = paramahrl.b;
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1))
      {
        paramahrl.b((URLDrawable)localObject);
        if ((((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))
        {
          paramahrl = (VideoDrawable)((URLDrawable)localObject).getCurrDrawable();
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频用缓存, isAudioPlaying= " + paramahrl.isAudioPlaying() + ", videoPath:" + paramString2 + " msgSeq: " + paramahro.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          }
          if (paramahrl.isAudioPlaying()) {
            paramahro.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
          } else {
            paramahro.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
          }
        }
      }
    }
    label561:
    b(paramahro);
    return paramView;
    label568:
    b(paramahro);
    return paramView;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aggk a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (ahro)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_Ahrl;
      }
    }
    return null;
  }
  
  public aggl a()
  {
    return new ahro(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    paramagjk = agid.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramagjk != null) {
      paramagjk.a(paramView, this);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetListView == null) && (paramViewGroup != null) && ((paramViewGroup instanceof ListView))) {
      this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramViewGroup);
    }
    try
    {
      paramViewGroup = (ahro)paramView.getTag();
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
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    paramBaseChatItemLayout = (ahro)paramaggl;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    Object localObject3 = ((Context)localObject1).getResources();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView(), message = " + paramChatMessage);
    }
    if (paramView == null)
    {
      paramaggl = new RelativeLayout((Context)localObject1);
      int i = agej.a(160.0F, (Resources)localObject3);
      int j = agej.a(160.0F, (Resources)localObject3);
      paramView = new ahrl((Context)localObject1);
      paramView.setId(2131372628);
      paramView.setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject2 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramaggl.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new CircleProgressView((Context)localObject1);
      ((CircleProgressView)localObject2).setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
      localLayoutParams.addRule(13);
      paramaggl.addView((View)localObject2, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(8, 2131372628);
      localLayoutParams.bottomMargin = agej.a(6.0F, (Resources)localObject3);
      localObject3 = new AudioAnimationView((Context)localObject1);
      ((AudioAnimationView)localObject3).setRectCount(7);
      ((AudioAnimationView)localObject3).setSyle(1);
      ((AudioAnimationView)localObject3).setIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838210));
      paramaggl.addView((View)localObject3, localLayoutParams);
      localObject1 = new ImageView((Context)localObject1);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      ((ImageView)localObject1).setVisibility(8);
      paramaggl.addView((View)localObject1, localLayoutParams);
      paramaggl.setOnClickListener(this);
      paramaggl.setOnTouchListener(paramagjk);
      paramaggl.setOnLongClickListener(paramagjk);
      paramBaseChatItemLayout.jdField_a_of_type_Ahrl = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView = ((CircleProgressView)localObject2);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView = ((AudioAnimationView)localObject3);
    }
    for (;;)
    {
      paramView = paramBaseChatItemLayout.jdField_a_of_type_Ahrl;
      paramagjk = (MessageForShortVideo)paramChatMessage;
      paramView.c = paramagjk.isSend();
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIsSend(paramagjk.isSend());
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
        paramaggl.setContentDescription(((StringBuilder)localObject1).toString());
        if (paramagjk.md5 != null) {
          break;
        }
        return a(paramaggl, paramBaseChatItemLayout, paramView, paramagjk);
        label530:
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("发出视频对讲消息,");
      }
      paramChatMessage = ShortVideoUtils.a(paramagjk.thumbMD5, "jpg");
      localObject1 = ShortVideoUtils.a(paramagjk, "mp4");
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView() videoPath" + (String)localObject1 + "thumbPath=" + paramChatMessage);
      }
      if ((ahrp.b) && (ShortVideoUtils.a()) && (bhmi.b((String)localObject1)) && ((!paramagjk.isSendFromLocal()) || (paramagjk.videoFileStatus == 1003) || (paramagjk.videoFileStatus == 2003))) {
        return b(paramaggl, paramBaseChatItemLayout, paramView, paramagjk, paramChatMessage, (String)localObject1);
      }
      if (bhmi.b(paramChatMessage)) {
        return a(paramaggl, paramBaseChatItemLayout, paramView, paramagjk, paramChatMessage, (String)localObject1);
      }
      if (paramagjk.videoFileStatus == 5002)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView():短视频已过期不启动下载流程 2 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        paramView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        b(paramBaseChatItemLayout, 2131717503);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
        return paramaggl;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 下占位图 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      a(paramagjk);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      return paramaggl;
      paramaggl = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bhnt.a(paramChatMessage.issend)) {
      return anzj.a(2131712939);
    }
    return anzj.a(2131712928);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt != 2131365352) {
        break label38;
      }
      aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
    }
    label38:
    do
    {
      do
      {
        return;
        if (paramInt == 2131371530)
        {
          super.d(paramChatMessage);
          return;
        }
        if (paramInt == 2131367078)
        {
          paramInt = azqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
          if (paramInt == 3) {
            paramContext = "1";
          }
          for (;;)
          {
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
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
        if (paramInt == 2131366320)
        {
          bmko.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
          bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
          return;
        }
        if (paramInt != 2131371487) {
          break label422;
        }
        if (localMessageForShortVideo.md5 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoPTVItemBuilder", 2, "onMenuItemClicked: msg_revoke => md5 = null");
      return;
      int i = 1;
      paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
      paramInt = i;
      if (paramContext != null) {
        if (!bexk.class.isInstance(paramContext))
        {
          paramInt = i;
          if (!bexd.class.isInstance(paramContext)) {}
        }
        else
        {
          boolean bool = ((berp)paramContext).d();
          int j = localMessageForShortVideo.videoFileStatus;
          if ((!bool) && (j != 1002))
          {
            paramInt = i;
            if (j != 1001) {}
          }
          else
          {
            i = 0;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
            ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(20)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
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
  
  void a(ahro paramahro)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showLoading() msgSeq: " + paramahro.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramahro.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIndeterminate(true);
    paramahro.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a();
    paramahro.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void a(ahro paramahro, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showProgress(), progress = " + paramInt + " msgSeq: " + paramahro.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    CircleProgressView localCircleProgressView = paramahro.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView;
    int i = paramInt;
    if (paramInt > 100)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "startShowProgress, illegal process:" + paramInt + " msgSeq: " + paramahro.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      i = 100;
    }
    localCircleProgressView.setIndeterminate(false);
    localCircleProgressView.setProgress(i);
    paramahro.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (ahro)agej.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {
      return;
    }
    blir localblir = (blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null);
    localblir.a(2131689933, 5);
    localblir.c(2131690580);
    localblir.a(new ahrj(this, localMessageForShortVideo, paramView, localblir));
    localblir.show();
  }
  
  public void a(View paramView, bete parambete, int paramInt1, int paramInt2)
  {
    paramView = (ahro)agej.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    String str = "handleMessage() msgSeq: " + localMessageForShortVideo.uniseq + " ";
    if (localMessageForShortVideo.uniseq != parambete.jdField_b_of_type_Long) {}
    ahrl localahrl;
    do
    {
      return;
      localahrl = paramView.jdField_a_of_type_Ahrl;
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramInt1 = agej.a(' ', localResources);
      paramInt2 = agej.a(' ', localResources);
      if ((parambete.jdField_b_of_type_Int == 6) || (parambete.jdField_b_of_type_Int == 17) || (parambete.jdField_b_of_type_Int == 9) || (parambete.jdField_b_of_type_Int == 20))
      {
        b(parambete, paramView, localMessageForShortVideo, str, localahrl, paramInt1, paramInt2);
        return;
      }
    } while ((parambete.jdField_b_of_type_Int != 7) && (parambete.jdField_b_of_type_Int != 18) && (parambete.jdField_b_of_type_Int != 16));
    a(parambete, paramView, localMessageForShortVideo, str, localahrl, paramInt1, paramInt2);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(0, BaseChatItemLayout.h, 0, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(0, BaseChatItemLayout.h, 0, BaseChatItemLayout.i);
  }
  
  protected void a(bete parambete, ahro paramahro, MessageForShortVideo paramMessageForShortVideo, String paramString, ahrl paramahrl, int paramInt1, int paramInt2)
  {
    switch (parambete.d)
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
      parambete = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      paramString = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
      boolean bool = bhmi.b(paramString);
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "THUMB STATUS_RECV_FINISHED: videoExists=" + bool + ", sAutoPlayInAIO=" + ahrp.b);
      }
      if ((bool) && (ahrp.b))
      {
        a(paramahro, paramahrl, paramInt1, paramInt2, parambete, paramString);
        return;
      }
      a(paramahro, paramMessageForShortVideo, paramahrl, paramInt1, paramInt2, parambete, paramString);
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
    parambete = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    if (bhmi.b(parambete)) {
      if (paramahrl.a(parambete))
      {
        QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "STATUS_RECV_ERROR: 缩略图下载失败刷视频 " + parambete);
        if (ShortVideoUtils.a())
        {
          paramMessageForShortVideo = URLDrawable.URLDrawableOptions.obtain();
          paramMessageForShortVideo.mRequestWidth = paramInt1;
          paramMessageForShortVideo.mRequestHeight = paramInt2;
          paramMessageForShortVideo.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramMessageForShortVideo.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramString = new VideoDrawable.VideoDrawableParams();
          paramString.mPlayVideoFrame = true;
          paramString.mVideoRoundCorner = 0;
          paramString.mRequestedFPS = ahrp.jdField_a_of_type_Int;
          paramMessageForShortVideo.mExtraInfo = paramString;
          paramahrl.b(URLDrawable.getDrawable(new File(parambete), paramMessageForShortVideo));
        }
      }
    }
    for (;;)
    {
      b(paramahro);
      return;
      parambete = paramahrl.b;
      if ((parambete != null) && (parambete.getStatus() == 1))
      {
        paramahrl.b(parambete);
        continue;
        paramahrl.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      }
    }
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    bcxn localbcxn = bcwu.a(2, 3);
    bcwx localbcwx = paramMessageForShortVideo.getDownloadInfo(localbcxn.jdField_b_of_type_Int);
    localbcwx.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "downloadThumb thumbPath" + localbcwx.i);
    }
    localbcwx.a(paramMessageForShortVideo.istroop, 1);
    localbcwx.f = 2;
    localbcwx.g = 2;
    localbcxn.a(localbcwx);
    localbcxn.a(paramMessageForShortVideo);
    bcwu.a(localbcxn, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, ahro paramahro)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!bhmi.b((String)localObject))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718240, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      paramahro.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
    }
    do
    {
      return;
      if (!bhmi.b(str))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718241, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
        paramahro.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      localObject = bcwu.a(1, 3);
      ((bcxn)localObject).a(bcwu.a(((bcxn)localObject).jdField_b_of_type_Int, paramMessageForShortVideo, (bcxn)localObject));
      bcwu.a((bcxn)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((!paramMessageForShortVideo.isSendFromLocal()) || (paramMessageForShortVideo.videoFileStatus != 1005) || (paramMessageForShortVideo.videoFileProgress != 0));
    a(paramahro, 3);
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131717719, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      return;
      i = 0;
      break;
    }
    label114:
    localObject = bcwu.a(2, 3);
    bcwx localbcwx = paramMessageForShortVideo.getDownloadInfo(((bcxn)localObject).jdField_b_of_type_Int);
    localbcwx.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localbcwx.a(paramMessageForShortVideo.istroop, 0);
    i = j;
    if (paramBoolean) {
      i = 2;
    }
    localbcwx.f = i;
    localbcwx.g = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localbcwx.e + ", uniseq:" + paramMessageForShortVideo.uniseq + "localPath=" + localbcwx.h);
    }
    ((bcxn)localObject).a(localbcwx);
    ((bcxn)localObject).a(paramMessageForShortVideo);
    bcwu.a((bcxn)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      paramBaseChatItemLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramBaseChatItemLayout instanceof berp))
      {
        if (((berp)paramBaseChatItemLayout).c() == 1005L) {}
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
  
  public bhum[] a(View paramView)
  {
    int k = 0;
    bhuk localbhuk = new bhuk();
    Object localObject = (ahro)agej.a(paramView);
    paramView = (MessageForShortVideo)((ahro)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.md5 != null)
    {
      String str = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
      ShortVideoUtils.a(paramView, "mp4");
      if (bhmi.b(str)) {
        if ((((ahro)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView == null) || (!((ahro)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a())) {
          break label271;
        }
      }
    }
    label271:
    for (int i = 1;; i = 0)
    {
      int j = k;
      if (((ahro)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
      {
        j = k;
        if (((ahro)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
          j = 1;
        }
      }
      if ((paramView.isSendFromLocal()) && (j == 0)) {
        localbhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
      }
      a(paramView, localbhuk);
      if ((i == 0) && (j == 0)) {
        a(localbhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbhuk, paramView);
      if (paramView.md5 != null)
      {
        localObject = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
        if (bhmi.b(ShortVideoUtils.a(paramView, "mp4"))) {
          localbhuk.a(2131366320, this.jdField_a_of_type_AndroidContentContext.getString(2131691990), 2130838938);
        }
        if (bhmi.b((String)localObject)) {
          b(paramView, localbhuk);
        }
      }
      super.e(localbhuk, this.jdField_a_of_type_AndroidContentContext);
      return localbhuk.a();
    }
  }
  
  void b(ahro paramahro)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "hideProgress() msgSeq: " + paramahro.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramahro.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramahro.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void b(ahro paramahro, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showWarnProgress() msgSeq: " + paramahro.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramahro.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramahro.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramahro.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845728);
    paramahro.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
  }
  
  protected void b(bete parambete, ahro paramahro, MessageForShortVideo paramMessageForShortVideo, String paramString, ahrl paramahrl, int paramInt1, int paramInt2)
  {
    switch (parambete.d)
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
        paramahro.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_FINISHED");
        }
        b(paramahro);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_ERROR");
        }
        paramahro.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        b(paramahro);
        paramahro.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(8);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_CANCEL");
        }
        b(paramahro);
        return;
        paramInt1 = paramMessageForShortVideo.videoFileProgress;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_PROCESS " + paramInt1);
        }
        a(paramahro, paramInt1);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_RECV_START");
        }
        a(paramahro, paramMessageForShortVideo.videoFileProgress);
        return;
        a(paramahro, paramMessageForShortVideo, paramString, paramahrl, paramInt1, paramInt2);
        return;
        a(paramahro, paramMessageForShortVideo);
        return;
        a(parambete, paramahro, paramMessageForShortVideo, paramahrl);
        return;
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_CANCEL");
      return;
    }
    paramInt1 = paramMessageForShortVideo.videoFileProgress;
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
    }
    a(paramahro, paramInt1);
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
    String str1 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localBundle.putString("forward_thumb", str1);
    localBundle.putString("from_uin", ShortVideoUtils.d(paramMessageForShortVideo));
    localBundle.putInt("from_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localBundle.putString("from_session_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
    String str2 = ShortVideoUtils.c(paramMessageForShortVideo);
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
    auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, ahro paramahro)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
      }
      if (!bhmi.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718241, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
        paramahro.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        paramahro = bcwu.a(4, 3);
        paramahro.a(bcwu.a(paramahro.jdField_b_of_type_Int, paramMessageForShortVideo, paramahro));
        bcwu.a(paramahro, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoPTVItemBuilder", 2, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void c(ahro paramahro)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showPauseProgress() msgSeq: " + paramahro.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramahro.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramahro.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramahro.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845727);
    paramahro.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void onClick(View paramView)
  {
    ahro localahro = (ahro)agej.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localahro.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.getId() == 2131364466) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
          break;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695278, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      }
      if (paramView.getId() != 2131364423) {
        break;
      }
    } while (localMessageForShortVideo.md5 == null);
    Object localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
    String str = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    if (QLog.isColorLevel()) {
      QLog.e("ptvitem", 2, "onClick videoPath=" + str + "thumbPath=" + (String)localObject);
    }
    if (!bhmi.b(str))
    {
      a(localMessageForShortVideo, false);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E96", "0X8005E96", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (!localMessageForShortVideo.isSend()) {
        new bbjw(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1003);
      }
      if (localMessageForShortVideo.isBlessMsg) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", "" + localMessageForShortVideo.uuid, "" + localMessageForShortVideo.isSend());
      }
      super.onClick(paramView);
      break;
      if (bhmi.b((String)localObject))
      {
        if ((ahrp.b) && (ShortVideoUtils.a()))
        {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E95", "0X8005E95", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
            break;
          }
          if ((localahro.jdField_a_of_type_Ahrl.getDrawable() == null) || (!(localahro.jdField_a_of_type_Ahrl.getDrawable() instanceof URLDrawable))) {
            continue;
          }
          localObject = (URLDrawable)localahro.jdField_a_of_type_Ahrl.getDrawable();
          if ((((URLDrawable)localObject).getStatus() != 1) || (!(((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))) {
            continue;
          }
          a(localahro, localMessageForShortVideo, (URLDrawable)localObject);
          continue;
        }
        ShortVideoRealItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo, localahro.jdField_a_of_type_Ahrl, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahri
 * JD-Core Version:    0.7.0.1
 */