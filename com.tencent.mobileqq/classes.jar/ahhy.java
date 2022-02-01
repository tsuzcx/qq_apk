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

public class ahhy
  extends BaseBubbleBuilder
  implements afyl, bcee
{
  static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new arnj(-10065297, c, d);
  public static WeakReference<VideoDrawable> a;
  private static WeakReference<MessageForShortVideo> jdField_b_of_type_JavaLangRefWeakReference;
  static int c;
  static int d;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  Handler jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    c = afur.a(160.0F, localResources);
    d = afur.a(160.0F, localResources);
  }
  
  public ahhy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    ShortVideoUtils.a(paramQQAppInterface);
    ahif.a();
  }
  
  private View a(View paramView, ahie paramahie, ahib paramahib, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      String str = paramMessageForShortVideo.mThumbFilePath;
      if (!bgmg.b(str)) {
        break label146;
      }
      if (paramahib.a(str))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 占坑 msgSeq: " + paramahie.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramahib.b(URLDrawable.getDrawable(new File(str), localURLDrawableOptions));
        a(paramahie);
        Utils.executeAsyncTaskOnSerialExcuter(new ahid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo), new Void[] { (Void)null });
      }
    }
    label146:
    do
    {
      return paramView;
      paramahib.setImageDrawable(bdzx.a());
      b(paramahie);
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView():You must get thumb before send video. msgSeq: " + paramahie.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return paramView;
  }
  
  private View a(View paramView, ahie paramahie, ahib paramahib, MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2)
  {
    if (paramahib.a(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷缩略图 " + paramString1 + " msgSeq: " + paramahie.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramahib.b(URLDrawable.getDrawable(new File(paramString1), localURLDrawableOptions));
    }
    for (;;)
    {
      paramahie.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      if (!bgmg.b(paramString2)) {
        break label253;
      }
      if ((!paramMessageForShortVideo.isSendFromLocal()) || (paramMessageForShortVideo.videoFileProgress > 100) || (paramMessageForShortVideo.videoFileStatus == 1003)) {
        break;
      }
      a(paramahie, paramMessageForShortVideo.videoFileProgress);
      return paramView;
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷缩略图用缓存 " + paramString1 + " msgSeq: " + paramahie.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramString1 = paramahib.b;
      if ((paramString1 != null) && (paramString1.getStatus() == 1)) {
        paramahib.b(paramString1);
      }
    }
    if ((ShortVideoUtils.a()) && (ahif.b))
    {
      b(paramahie);
      return paramView;
    }
    c(paramahie);
    return paramView;
    label253:
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView():短视频已过期不启动下载流程 1 msgSeq: " + paramahie.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      b(paramahie, 2131717372);
      return paramView;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo, true))
    {
      a(paramMessageForShortVideo, true);
      a(paramahie, paramMessageForShortVideo.videoFileProgress);
      return paramView;
    }
    if (bdsx.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq)))
    {
      a(paramahie, paramMessageForShortVideo.videoFileProgress);
      return paramView;
    }
    c(paramahie);
    return paramView;
  }
  
  private void a(ahie paramahie, MessageForShortVideo paramMessageForShortVideo, URLDrawable paramURLDrawable)
  {
    paramURLDrawable = (VideoDrawable)paramURLDrawable.getCurrDrawable();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, " videoDrawable.isAudioPlaying(): " + paramURLDrawable.isAudioPlaying());
    }
    if (paramURLDrawable.isAudioPlaying())
    {
      paramURLDrawable.stopAudio();
      paramahie.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
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
    paramahie.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
    jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramMessageForShortVideo);
    paramURLDrawable.setOnAudioPlayOnceListener(new ahia(this));
  }
  
  private void a(ahie paramahie, MessageForShortVideo paramMessageForShortVideo, String paramString, ahib paramahib, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_RECV_FINISHED");
    }
    if (ahif.b)
    {
      String str = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
      if (paramahib.a(str))
      {
        QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "handleMessage: 刷视频 " + str);
        if ((ShortVideoUtils.a()) && (bgmg.b(str)))
        {
          paramString = URLDrawable.URLDrawableOptions.obtain();
          paramString.mRequestWidth = paramInt1;
          paramString.mRequestHeight = paramInt2;
          paramString.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramString.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
          localVideoDrawableParams.mPlayVideoFrame = true;
          localVideoDrawableParams.mVideoRoundCorner = 0;
          localVideoDrawableParams.mRequestedFPS = ahif.jdField_a_of_type_Int;
          paramString.mExtraInfo = localVideoDrawableParams;
          paramString = URLDrawable.getDrawable(new File(str), paramString);
          if (paramString.getStatus() != 1) {
            break label337;
          }
          paramahib.b(paramString);
        }
      }
      for (;;)
      {
        if (!paramMessageForShortVideo.isSend()) {
          new bard(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
        }
        if (paramMessageForShortVideo.subBusiType == 1) {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", "" + paramMessageForShortVideo.uuid, "" + paramMessageForShortVideo.isSend());
        }
        b(paramahie);
        paramahie.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(0);
        return;
        label337:
        paramahib.a(paramString);
      }
    }
    paramMessageForShortVideo = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (bgmg.b(paramMessageForShortVideo))
    {
      if (!paramahib.a(paramMessageForShortVideo)) {
        break label426;
      }
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mRequestWidth = paramInt1;
      paramString.mRequestHeight = paramInt2;
      paramString.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramString.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramahib.b(URLDrawable.getDrawable(new File(paramMessageForShortVideo), paramString));
    }
    for (;;)
    {
      c(paramahie);
      return;
      label426:
      paramMessageForShortVideo = paramahib.b;
      if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.getStatus() == 1)) {
        paramahib.b(paramMessageForShortVideo);
      }
    }
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
      i = afur.a(paramChatMessage.uniseq, paramListView.getAdapter());
      if (i > -1)
      {
        paramListView = afur.a(paramListView, i);
        if (paramListView != null)
        {
          paramListView = afur.a(paramListView);
          if ((paramListView != null) && ((paramListView instanceof ahie)))
          {
            paramListView = (ahie)paramListView;
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
  
  private View b(View paramView, ahie paramahie, ahib paramahib, MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2)
  {
    if (!paramMessageForShortVideo.isSend()) {
      new bard(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
    }
    Object localObject;
    if (paramahib.a(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频 " + paramString2 + " msgSeq: " + paramahie.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      if (!paramahib.a(paramString1)) {
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramahib.b;
      }
      VideoDrawable.VideoDrawableParams localVideoDrawableParams = new VideoDrawable.VideoDrawableParams();
      localVideoDrawableParams.mPlayVideoFrame = true;
      localVideoDrawableParams.mPlayAudioFrame = false;
      localVideoDrawableParams.mVideoRoundCorner = 0;
      localVideoDrawableParams.mRequestedFPS = ahif.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = localVideoDrawableParams;
      localObject = URLDrawable.getDrawable(new File(paramString2), (URLDrawable.URLDrawableOptions)localObject);
      paramahib.b((URLDrawable)localObject);
      if ((((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))
      {
        boolean bool = ((VideoDrawable)((URLDrawable)localObject).getCurrDrawable()).isAudioPlaying();
        if (!bool) {
          break label417;
        }
        paramahie.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频, isAudioPlaying= " + bool + ", videoPath:" + paramString2 + " msgSeq: " + paramahie.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
      }
    }
    for (;;)
    {
      if (!bgmg.b(paramString1))
      {
        a(paramMessageForShortVideo);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: Video file exist and status finish. Thumb not exist. msgSeq: " + paramahie.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
      }
      if (!paramMessageForShortVideo.isSendFromLocal()) {
        break label568;
      }
      paramahib = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      if (!bdsx.class.isInstance(paramahib)) {
        break label561;
      }
      if (((bdsx)paramahib).c() == 1002L) {
        a(paramahie, paramMessageForShortVideo.videoFileProgress);
      }
      return paramView;
      label417:
      paramahie.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      break;
      localObject = paramahib.b;
      if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1))
      {
        paramahib.b((URLDrawable)localObject);
        if ((((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))
        {
          paramahib = (VideoDrawable)((URLDrawable)localObject).getCurrDrawable();
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频用缓存, isAudioPlaying= " + paramahib.isAudioPlaying() + ", videoPath:" + paramString2 + " msgSeq: " + paramahie.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          }
          if (paramahib.isAudioPlaying()) {
            paramahie.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
          } else {
            paramahie.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
          }
        }
      }
    }
    label561:
    b(paramahie);
    return paramView;
    label568:
    b(paramahie);
    return paramView;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afwq a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (ahie)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_Ahib;
      }
    }
    return null;
  }
  
  public afwr a()
  {
    return new ahie(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afzq paramafzq)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafzq);
    paramafzq = afyj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramafzq != null) {
      paramafzq.a(paramView, this);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetListView == null) && (paramViewGroup != null) && ((paramViewGroup instanceof ListView))) {
      this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramViewGroup);
    }
    try
    {
      paramViewGroup = (ahie)paramView.getTag();
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
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    paramBaseChatItemLayout = (ahie)paramafwr;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    Object localObject3 = ((Context)localObject1).getResources();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView(), message = " + paramChatMessage);
    }
    if (paramView == null)
    {
      paramafwr = new RelativeLayout((Context)localObject1);
      int i = afur.a(160.0F, (Resources)localObject3);
      int j = afur.a(160.0F, (Resources)localObject3);
      paramView = new ahib((Context)localObject1);
      paramView.setId(2131372517);
      paramView.setScaleType(ImageView.ScaleType.FIT_XY);
      Object localObject2 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramafwr.addView(paramView, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new CircleProgressView((Context)localObject1);
      ((CircleProgressView)localObject2).setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
      localLayoutParams.addRule(13);
      paramafwr.addView((View)localObject2, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(8, 2131372517);
      localLayoutParams.bottomMargin = afur.a(6.0F, (Resources)localObject3);
      localObject3 = new AudioAnimationView((Context)localObject1);
      ((AudioAnimationView)localObject3).setRectCount(7);
      ((AudioAnimationView)localObject3).setSyle(1);
      ((AudioAnimationView)localObject3).setIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838200));
      paramafwr.addView((View)localObject3, localLayoutParams);
      localObject1 = new ImageView((Context)localObject1);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      ((ImageView)localObject1).setVisibility(8);
      paramafwr.addView((View)localObject1, localLayoutParams);
      paramafwr.setOnClickListener(this);
      paramafwr.setOnTouchListener(paramafzq);
      paramafwr.setOnLongClickListener(paramafzq);
      paramBaseChatItemLayout.jdField_a_of_type_Ahib = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView = ((CircleProgressView)localObject2);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView = ((AudioAnimationView)localObject3);
    }
    for (;;)
    {
      paramView = paramBaseChatItemLayout.jdField_a_of_type_Ahib;
      paramafzq = (MessageForShortVideo)paramChatMessage;
      paramView.c = paramafzq.isSend();
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIsSend(paramafzq.isSend());
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
        paramafwr.setContentDescription(((StringBuilder)localObject1).toString());
        if (paramafzq.md5 != null) {
          break;
        }
        return a(paramafwr, paramBaseChatItemLayout, paramView, paramafzq);
        label530:
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("发出视频对讲消息,");
      }
      paramChatMessage = ShortVideoUtils.a(paramafzq.thumbMD5, "jpg");
      localObject1 = ShortVideoUtils.a(paramafzq, "mp4");
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView() videoPath" + (String)localObject1 + "thumbPath=" + paramChatMessage);
      }
      if ((ahif.b) && (ShortVideoUtils.a()) && (bgmg.b((String)localObject1)) && ((!paramafzq.isSendFromLocal()) || (paramafzq.videoFileStatus == 1003) || (paramafzq.videoFileStatus == 2003))) {
        return b(paramafwr, paramBaseChatItemLayout, paramView, paramafzq, paramChatMessage, (String)localObject1);
      }
      if (bgmg.b(paramChatMessage)) {
        return a(paramafwr, paramBaseChatItemLayout, paramView, paramafzq, paramChatMessage, (String)localObject1);
      }
      if (paramafzq.videoFileStatus == 5002)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView():短视频已过期不启动下载流程 2 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        paramView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        b(paramBaseChatItemLayout, 2131717372);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
        return paramafwr;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 下占位图 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      a(paramafzq);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      return paramafwr;
      paramafwr = paramView;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bgnr.a(paramChatMessage.issend)) {
      return anni.a(2131712830);
    }
    return anni.a(2131712819);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt != 2131365308) {
        break label38;
      }
      adrm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
    }
    label38:
    do
    {
      do
      {
        return;
        if (paramInt == 2131371422)
        {
          super.d(paramChatMessage);
          return;
        }
        if (paramInt == 2131367027)
        {
          paramInt = ayxu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
          if (paramInt == 3) {
            paramContext = "1";
          }
          for (;;)
          {
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
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
        if (paramInt == 2131366271)
        {
          bljl.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
          bljv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
          return;
        }
        if (paramInt != 2131371380) {
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
        if (!bdyr.class.isInstance(paramContext))
        {
          paramInt = i;
          if (!bdyk.class.isInstance(paramContext)) {}
        }
        else
        {
          boolean bool = ((bdsx)paramContext).d();
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
  
  void a(ahie paramahie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showLoading() msgSeq: " + paramahie.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramahie.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIndeterminate(true);
    paramahie.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a();
    paramahie.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void a(ahie paramahie, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showProgress(), progress = " + paramInt + " msgSeq: " + paramahie.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    CircleProgressView localCircleProgressView = paramahie.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView;
    int i = paramInt;
    if (paramInt > 100)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "startShowProgress, illegal process:" + paramInt + " msgSeq: " + paramahie.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      i = 100;
    }
    localCircleProgressView.setIndeterminate(false);
    localCircleProgressView.setProgress(i);
    paramahie.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (ahie)afur.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {
      return;
    }
    bkho localbkho = (bkho)bkif.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbkho.a(2131689926, 5);
    localbkho.c(2131690582);
    localbkho.a(new ahhz(this, localMessageForShortVideo, paramView, localbkho));
    localbkho.show();
  }
  
  public void a(View paramView, bduk parambduk, int paramInt1, int paramInt2)
  {
    paramView = (ahie)afur.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    String str = "handleMessage() msgSeq: " + localMessageForShortVideo.uniseq + " ";
    if (localMessageForShortVideo.uniseq != parambduk.jdField_b_of_type_Long) {}
    ahib localahib;
    do
    {
      return;
      localahib = paramView.jdField_a_of_type_Ahib;
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramInt1 = afur.a(' ', localResources);
      paramInt2 = afur.a(' ', localResources);
      if ((parambduk.jdField_b_of_type_Int == 6) || (parambduk.jdField_b_of_type_Int == 17) || (parambduk.jdField_b_of_type_Int == 9) || (parambduk.jdField_b_of_type_Int == 20))
      {
        b(parambduk, paramView, localMessageForShortVideo, str, localahib, paramInt1, paramInt2);
        return;
      }
    } while ((parambduk.jdField_b_of_type_Int != 7) && (parambduk.jdField_b_of_type_Int != 18) && (parambduk.jdField_b_of_type_Int != 16));
    a(parambduk, paramView, localMessageForShortVideo, str, localahib, paramInt1, paramInt2);
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
  
  protected void a(bduk parambduk, ahie paramahie, MessageForShortVideo paramMessageForShortVideo, String paramString, ahib paramahib, int paramInt1, int paramInt2)
  {
    switch (parambduk.d)
    {
    default: 
    case 2001: 
    case 2003: 
      do
      {
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.i("ShortVideoPTVItemBuilder", 2, "THUMB STATUS_RECV_START");
        return;
        paramString = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
        parambduk = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
        boolean bool = bgmg.b(parambduk);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "THUMB STATUS_RECV_FINISHED: videoExists=" + bool + ", sAutoPlayInAIO=" + ahif.b);
        }
        if ((bool) && (ahif.b))
        {
          if (paramahib.a(parambduk))
          {
            if (QLog.isColorLevel()) {
              QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 视频存在,刷缩略图 " + paramString);
            }
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
              paramString.mRequestedFPS = ahif.jdField_a_of_type_Int;
              paramMessageForShortVideo.mExtraInfo = paramString;
              paramahib.b(URLDrawable.getDrawable(new File(parambduk), paramMessageForShortVideo));
            }
          }
          for (;;)
          {
            b(paramahie);
            return;
            parambduk = paramahib.b;
            if ((parambduk != null) && (parambduk.getStatus() == 1)) {
              paramahib.b(parambduk);
            }
          }
        }
        if (!bgmg.b(paramString)) {
          break;
        }
      } while (!paramahib.a(paramString));
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 缩略图存在，刷缩略图 " + paramString);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramahib.b(URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions));
      if (!bgmg.b(parambduk))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo, true))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 刷缩略图，视频文件不存在， isNeedPredownload=true, downloadVideo");
          }
          a(paramMessageForShortVideo, true);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 刷缩略图，视频文件不存在， isNeedPredownload=false, showPauseProgress");
        }
        c(paramahie);
        return;
      }
      if (ShortVideoUtils.a())
      {
        b(paramahie);
        return;
      }
      c(paramahie);
      return;
      paramahib.setImageDrawable(bdzx.a());
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
    parambduk = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    if (bgmg.b(parambduk)) {
      if (paramahib.a(parambduk))
      {
        QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "STATUS_RECV_ERROR: 缩略图下载失败刷视频 " + parambduk);
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
          paramString.mRequestedFPS = ahif.jdField_a_of_type_Int;
          paramMessageForShortVideo.mExtraInfo = paramString;
          paramahib.b(URLDrawable.getDrawable(new File(parambduk), paramMessageForShortVideo));
        }
      }
    }
    for (;;)
    {
      b(paramahie);
      return;
      parambduk = paramahib.b;
      if ((parambduk != null) && (parambduk.getStatus() == 1))
      {
        paramahib.b(parambduk);
        continue;
        paramahib.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      }
    }
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    bcev localbcev = bcec.a(2, 3);
    bcef localbcef = paramMessageForShortVideo.getDownloadInfo(localbcev.jdField_b_of_type_Int);
    localbcef.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "downloadThumb thumbPath" + localbcef.i);
    }
    localbcef.a(paramMessageForShortVideo.istroop, 1);
    localbcef.f = 2;
    localbcef.g = 2;
    localbcev.a(localbcef);
    localbcev.a(paramMessageForShortVideo);
    bcec.a(localbcev, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, ahie paramahie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!bgmg.b((String)localObject))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718107, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
      paramahie.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
    }
    do
    {
      return;
      if (!bgmg.b(str))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718108, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
        paramahie.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      localObject = bcec.a(1, 3);
      ((bcev)localObject).a(bcec.a(((bcev)localObject).jdField_b_of_type_Int, paramMessageForShortVideo, (bcev)localObject));
      bcec.a((bcev)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((!paramMessageForShortVideo.isSendFromLocal()) || (paramMessageForShortVideo.videoFileStatus != 1005) || (paramMessageForShortVideo.videoFileProgress != 0));
    a(paramahie, 3);
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131717588, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
      return;
      i = 0;
      break;
    }
    label114:
    localObject = bcec.a(2, 3);
    bcef localbcef = paramMessageForShortVideo.getDownloadInfo(((bcev)localObject).jdField_b_of_type_Int);
    localbcef.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localbcef.a(paramMessageForShortVideo.istroop, 0);
    i = j;
    if (paramBoolean) {
      i = 2;
    }
    localbcef.f = i;
    localbcef.g = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localbcef.e + ", uniseq:" + paramMessageForShortVideo.uniseq + "localPath=" + localbcef.h);
    }
    ((bcev)localObject).a(localbcef);
    ((bcev)localObject).a(paramMessageForShortVideo);
    bcec.a((bcev)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      if ((paramBaseChatItemLayout instanceof bdsx))
      {
        if (((bdsx)paramBaseChatItemLayout).c() == 1005L) {}
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
  
  public bguj[] a(View paramView)
  {
    int k = 0;
    bguh localbguh = new bguh();
    Object localObject = (ahie)afur.a(paramView);
    paramView = (MessageForShortVideo)((ahie)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.md5 != null)
    {
      String str = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
      ShortVideoUtils.a(paramView, "mp4");
      if (bgmg.b(str)) {
        if ((((ahie)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView == null) || (!((ahie)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a())) {
          break label271;
        }
      }
    }
    label271:
    for (int i = 1;; i = 0)
    {
      int j = k;
      if (((ahie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
      {
        j = k;
        if (((ahie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
          j = 1;
        }
      }
      if ((paramView.isSendFromLocal()) && (j == 0)) {
        localbguh.a(2131367027, this.jdField_a_of_type_AndroidContentContext.getString(2131692395), 2130838929);
      }
      a(paramView, localbguh);
      if ((i == 0) && (j == 0)) {
        a(localbguh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbguh, paramView);
      if (paramView.md5 != null)
      {
        localObject = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
        if (bgmg.b(ShortVideoUtils.a(paramView, "mp4"))) {
          localbguh.a(2131366271, this.jdField_a_of_type_AndroidContentContext.getString(2131691986), 2130838928);
        }
        if (bgmg.b((String)localObject)) {
          b(paramView, localbguh);
        }
      }
      super.e(localbguh, this.jdField_a_of_type_AndroidContentContext);
      return localbguh.a();
    }
  }
  
  void b(ahie paramahie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "hideProgress() msgSeq: " + paramahie.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramahie.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramahie.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void b(ahie paramahie, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showWarnProgress() msgSeq: " + paramahie.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramahie.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramahie.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramahie.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845713);
    paramahie.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
  }
  
  protected void b(bduk parambduk, ahie paramahie, MessageForShortVideo paramMessageForShortVideo, String paramString, ahib paramahib, int paramInt1, int paramInt2)
  {
    switch (parambduk.d)
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
      label657:
      label716:
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_START progress " + paramMessageForShortVideo.videoFileProgress);
        }
        paramahie.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_FINISHED");
        }
        b(paramahie);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_ERROR");
        }
        paramahie.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        b(paramahie);
        paramahie.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(8);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_CANCEL");
        }
        b(paramahie);
        return;
        paramInt1 = paramMessageForShortVideo.videoFileProgress;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_SEND_PROCESS " + paramInt1);
        }
        a(paramahie, paramInt1);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, paramString + "VIDEO STATUS_RECV_START");
        }
        a(paramahie, paramMessageForShortVideo.videoFileProgress);
        return;
        a(paramahie, paramMessageForShortVideo, paramString, paramahib, paramInt1, paramInt2);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_FILE_UNSAFE");
        }
        b(paramahie);
        if (paramMessageForShortVideo.uiOperatorFlag == 2)
        {
          paramahie.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718076, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
          return;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718100, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
        return;
        if (QLog.isColorLevel())
        {
          if (parambduk.d == 2005) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_ERROR");
          }
        }
        else
        {
          paramMessageForShortVideo = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
          if (bgmg.b(paramMessageForShortVideo))
          {
            if (!paramahib.a(paramMessageForShortVideo)) {
              break label657;
            }
            if (QLog.isColorLevel()) {
              QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_FILE_EXPIRED: 刷缩略图 " + paramMessageForShortVideo);
            }
            paramString = URLDrawable.URLDrawableOptions.obtain();
            paramString.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            paramString.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            paramahib.b(URLDrawable.getDrawable(new File(paramMessageForShortVideo), paramString));
          }
        }
        for (;;)
        {
          if (parambduk.d != 2005) {
            break label716;
          }
          b(paramahie, 2131717376);
          return;
          QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_FILE_EXPIRED");
          break;
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_FILE_EXPIRED: 刷缩略图用缓存 " + paramMessageForShortVideo);
          }
          paramMessageForShortVideo = paramahib.b;
          if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.getStatus() == 1)) {
            paramahib.b(paramMessageForShortVideo);
          }
        }
        b(paramahie, 2131717372);
        return;
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_CANCEL");
      return;
    }
    paramInt1 = paramMessageForShortVideo.videoFileProgress;
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
    }
    a(paramahie, paramInt1);
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
    aufz.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, ahie paramahie)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
      }
      if (!bgmg.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718108, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
        paramahie.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        paramahie = bcec.a(4, 3);
        paramahie.a(bcec.a(paramahie.jdField_b_of_type_Int, paramMessageForShortVideo, paramahie));
        bcec.a(paramahie, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoPTVItemBuilder", 2, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void c(ahie paramahie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showPauseProgress() msgSeq: " + paramahie.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramahie.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramahie.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramahie.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845712);
    paramahie.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void onClick(View paramView)
  {
    ahie localahie = (ahie)afur.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localahie.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.getId() == 2131364422) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
          break;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695235, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298998));
      }
      if (paramView.getId() != 2131364379) {
        break;
      }
    } while (localMessageForShortVideo.md5 == null);
    Object localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
    String str = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    if (QLog.isColorLevel()) {
      QLog.e("ptvitem", 2, "onClick videoPath=" + str + "thumbPath=" + (String)localObject);
    }
    if (!bgmg.b(str))
    {
      a(localMessageForShortVideo, false);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E96", "0X8005E96", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (!localMessageForShortVideo.isSend()) {
        new bard(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1003);
      }
      if (localMessageForShortVideo.isBlessMsg) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", "" + localMessageForShortVideo.uuid, "" + localMessageForShortVideo.isSend());
      }
      super.onClick(paramView);
      break;
      if (bgmg.b((String)localObject))
      {
        if ((ahif.b) && (ShortVideoUtils.a()))
        {
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E95", "0X8005E95", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
            break;
          }
          if ((localahie.jdField_a_of_type_Ahib.getDrawable() == null) || (!(localahie.jdField_a_of_type_Ahib.getDrawable() instanceof URLDrawable))) {
            continue;
          }
          localObject = (URLDrawable)localahie.jdField_a_of_type_Ahib.getDrawable();
          if ((((URLDrawable)localObject).getStatus() != 1) || (!(((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))) {
            continue;
          }
          a(localahie, localMessageForShortVideo, (URLDrawable)localObject);
          continue;
        }
        ShortVideoRealItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo, localahie.jdField_a_of_type_Ahib, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhy
 * JD-Core Version:    0.7.0.1
 */