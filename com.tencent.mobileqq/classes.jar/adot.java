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
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.widget.AudioAnimationView;
import com.tencent.mobileqq.widget.CircleProgressView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.ref.WeakReference;

public class adot
  extends BaseBubbleBuilder
  implements aclm, awei
{
  static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new amym(-10065297, c, d);
  public static WeakReference<VideoDrawable> a;
  private static WeakReference<MessageForShortVideo> jdField_b_of_type_JavaLangRefWeakReference;
  static int c;
  static int d;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  Handler jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    c = aciy.a(160.0F, localResources);
    d = aciy.a(160.0F, localResources);
  }
  
  public adot(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    ShortVideoUtils.a(paramQQAppInterface);
    adpa.a();
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
      i = aciy.a(paramChatMessage.uniseq, paramListView.getAdapter());
      if (i > -1)
      {
        paramListView = aciy.a(paramListView, i);
        if (paramListView != null)
        {
          paramListView = aciy.a(paramListView);
          if ((paramListView != null) && ((paramListView instanceof adoz)))
          {
            paramListView = (adoz)paramListView;
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
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acjt a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (adoz)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_Adow;
      }
    }
    return null;
  }
  
  public acju a()
  {
    return new adoz(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acmv paramacmv)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacmv);
    paramacmv = aclk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramacmv != null) {
      paramacmv.a(paramView, this);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetListView == null) && (paramViewGroup != null) && ((paramViewGroup instanceof ListView))) {
      this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramViewGroup);
    }
    try
    {
      paramViewGroup = (adoz)paramView.getTag();
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
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    paramBaseChatItemLayout = (adoz)paramacju;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    Object localObject2 = ((Context)localObject1).getResources();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView(), message = " + paramChatMessage);
    }
    paramacju = paramView;
    Object localObject3;
    if (paramView == null)
    {
      paramacju = new RelativeLayout((Context)localObject1);
      int i = aciy.a(160.0F, (Resources)localObject2);
      int j = aciy.a(160.0F, (Resources)localObject2);
      paramView = new adow((Context)localObject1);
      paramView.setId(2131305912);
      paramView.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject3 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramacju.addView(paramView, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new CircleProgressView((Context)localObject1);
      ((CircleProgressView)localObject3).setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
      localLayoutParams.addRule(13);
      paramacju.addView((View)localObject3, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(8, 2131305912);
      localLayoutParams.bottomMargin = aciy.a(6.0F, (Resources)localObject2);
      localObject2 = new AudioAnimationView((Context)localObject1);
      ((AudioAnimationView)localObject2).setRectCount(7);
      ((AudioAnimationView)localObject2).setSyle(1);
      ((AudioAnimationView)localObject2).setIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838041));
      paramacju.addView((View)localObject2, localLayoutParams);
      localObject1 = new ImageView((Context)localObject1);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      ((ImageView)localObject1).setVisibility(8);
      paramacju.addView((View)localObject1, localLayoutParams);
      paramacju.setOnClickListener(this);
      paramacju.setOnTouchListener(paramacmv);
      paramacju.setOnLongClickListener(paramacmv);
      paramBaseChatItemLayout.jdField_a_of_type_Adow = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView = ((CircleProgressView)localObject3);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView = ((AudioAnimationView)localObject2);
    }
    paramacmv = paramBaseChatItemLayout.jdField_a_of_type_Adow;
    paramView = (MessageForShortVideo)paramChatMessage;
    paramacmv.c = paramView.isSend();
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIsSend(paramView.isSend());
    if (e)
    {
      localObject1 = new StringBuilder();
      if (paramChatMessage.isSend())
      {
        ((StringBuilder)localObject1).append("你发出视频对讲消息,");
        float f = ((MessageForShortVideo)paramChatMessage).videoFileSize / 1000;
        ((StringBuilder)localObject1).append("文件大小:");
        ((StringBuilder)localObject1).append(f);
        ((StringBuilder)localObject1).append("K ");
        ((StringBuilder)localObject1).append("视频时长:");
        ((StringBuilder)localObject1).append(String.valueOf(((MessageForShortVideo)paramChatMessage).videoFileTime));
        ((StringBuilder)localObject1).append("秒");
        paramacju.setContentDescription(((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      if (paramView.md5 != null) {
        break label736;
      }
      if (paramView.isSendFromLocal())
      {
        paramChatMessage = paramView.mThumbFilePath;
        if (!bace.b(paramChatMessage)) {
          break label681;
        }
        if (paramacmv.a(paramChatMessage))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 占坑 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          }
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramacmv.b(URLDrawable.getDrawable(new File(paramChatMessage), (URLDrawable.URLDrawableOptions)localObject1));
          a(paramBaseChatItemLayout);
          Utils.executeAsyncTaskOnSerialExcuter(new adoy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView), new Void[] { (Void)null });
        }
      }
    }
    label681:
    do
    {
      return paramacju;
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("发出视频对讲消息,");
      break;
      paramacmv.setImageDrawable(axwd.a());
      b(paramBaseChatItemLayout);
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView():You must get thumb before send video. msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return paramacju;
    label736:
    localObject1 = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
    paramChatMessage = ShortVideoUtils.a(paramView, "mp4");
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView() videoPath" + paramChatMessage + "thumbPath=" + (String)localObject1);
    }
    if ((adpa.b) && (ShortVideoUtils.a()) && (bace.b(paramChatMessage)) && ((!paramView.isSendFromLocal()) || (paramView.videoFileStatus == 1003) || (paramView.videoFileStatus == 2003)))
    {
      if (!paramView.isSend()) {
        new auxb(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
      }
      if (paramacmv.a(paramChatMessage))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频 " + paramChatMessage + " msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        if (!paramacmv.a((String)localObject1)) {
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = paramacmv.b;
        }
        localObject3 = new VideoDrawable.VideoDrawableParams();
        ((VideoDrawable.VideoDrawableParams)localObject3).mPlayVideoFrame = true;
        ((VideoDrawable.VideoDrawableParams)localObject3).mPlayAudioFrame = false;
        ((VideoDrawable.VideoDrawableParams)localObject3).mVideoRoundCorner = 0;
        ((VideoDrawable.VideoDrawableParams)localObject3).mRequestedFPS = adpa.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = localObject3;
        localObject2 = URLDrawable.getDrawable(new File(paramChatMessage), (URLDrawable.URLDrawableOptions)localObject2);
        paramacmv.b((URLDrawable)localObject2);
        if ((((URLDrawable)localObject2).getCurrDrawable() instanceof VideoDrawable))
        {
          boolean bool = ((VideoDrawable)((URLDrawable)localObject2).getCurrDrawable()).isAudioPlaying();
          if (!bool) {
            break label1263;
          }
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
          label1089:
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频, isAudioPlaying= " + bool + ", videoPath:" + paramChatMessage + " msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          }
        }
      }
      for (;;)
      {
        if (!bace.b((String)localObject1))
        {
          a(paramView);
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: Video file exist and status finish. Thumb not exist. msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          }
        }
        if (!paramView.isSendFromLocal()) {
          break label1424;
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.frienduin, paramView.uniseq);
        if (!axou.class.isInstance(paramChatMessage)) {
          break label1416;
        }
        if (((axou)paramChatMessage).c() != 1002L) {
          break;
        }
        a(paramBaseChatItemLayout, paramView.videoFileProgress);
        return paramacju;
        label1263:
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
        break label1089;
        localObject2 = paramacmv.b;
        if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 1))
        {
          paramacmv.b((URLDrawable)localObject2);
          if ((((URLDrawable)localObject2).getCurrDrawable() instanceof VideoDrawable))
          {
            paramacmv = (VideoDrawable)((URLDrawable)localObject2).getCurrDrawable();
            if (QLog.isColorLevel()) {
              QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频用缓存, isAudioPlaying= " + paramacmv.isAudioPlaying() + ", videoPath:" + paramChatMessage + " msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            }
            if (paramacmv.isAudioPlaying()) {
              paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
            } else {
              paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
            }
          }
        }
      }
      label1416:
      b(paramBaseChatItemLayout);
      return paramacju;
      label1424:
      b(paramBaseChatItemLayout);
      return paramacju;
    }
    if (bace.b((String)localObject1))
    {
      if (paramacmv.a((String)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷缩略图 " + (String)localObject1 + " msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramacmv.b(URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2));
      }
      for (;;)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
        if (!bace.b(paramChatMessage)) {
          break label1702;
        }
        if ((!paramView.isSendFromLocal()) || (paramView.videoFileProgress > 100) || (paramView.videoFileStatus == 1003)) {
          break;
        }
        a(paramBaseChatItemLayout, paramView.videoFileProgress);
        return paramacju;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷缩略图用缓存 " + (String)localObject1 + " msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        localObject1 = paramacmv.b;
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1)) {
          paramacmv.b((URLDrawable)localObject1);
        }
      }
      if ((ShortVideoUtils.a()) && (adpa.b))
      {
        b(paramBaseChatItemLayout);
        return paramacju;
      }
      c(paramBaseChatItemLayout);
      return paramacju;
      label1702:
      if (paramView.videoFileStatus == 5002)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView():短视频已过期不启动下载流程 1 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        b(paramBaseChatItemLayout, 2131652954);
        return paramacju;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView, true))
      {
        a(paramView, true);
        a(paramBaseChatItemLayout, paramView.videoFileProgress);
        return paramacju;
      }
      if (axou.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.frienduin, paramView.uniseq)))
      {
        a(paramBaseChatItemLayout, paramView.videoFileProgress);
        return paramacju;
      }
      c(paramBaseChatItemLayout);
      return paramacju;
    }
    if (paramView.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView():短视频已过期不启动下载流程 2 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramacmv.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(paramBaseChatItemLayout, 2131652954);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      return paramacju;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 下占位图 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramacmv.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    a(paramView);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
    return paramacju;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bado.a(paramChatMessage.issend)) {
      return ajjy.a(2131648277);
    }
    return ajjy.a(2131648266);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt != 2131299417) {
        break label38;
      }
      aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
    }
    label38:
    do
    {
      do
      {
        return;
        if (paramInt == 2131304871)
        {
          super.d(paramChatMessage);
          return;
        }
        if (paramInt == 2131301021)
        {
          paramInt = atps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
          if (paramInt == 3) {
            paramContext = "1";
          }
          for (;;)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
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
        if (paramInt == 2131300328)
        {
          bfhl.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          bfhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
          return;
        }
        if (paramInt != 2131304829) {
          break label409;
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
        if (!ShortVideoUploadProcessor.class.isInstance(paramContext))
        {
          paramInt = i;
          if (!axun.class.isInstance(paramContext)) {}
        }
        else
        {
          boolean bool = ((axou)paramContext).d();
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
    label409:
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  void a(adoz paramadoz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showLoading() msgSeq: " + paramadoz.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramadoz.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIndeterminate(true);
    paramadoz.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a();
    paramadoz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void a(adoz paramadoz, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showProgress(), progress = " + paramInt + " msgSeq: " + paramadoz.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    CircleProgressView localCircleProgressView = paramadoz.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView;
    int i = paramInt;
    if (paramInt > 100)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "startShowProgress, illegal process:" + paramInt + " msgSeq: " + paramadoz.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      i = 100;
    }
    localCircleProgressView.setIndeterminate(false);
    localCircleProgressView.setProgress(i);
    paramadoz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (adoz)aciy.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {
      return;
    }
    begr localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbegr.a(2131624443, 5);
    localbegr.c(2131625035);
    localbegr.a(new adou(this, localMessageForShortVideo, paramView, localbegr));
    localbegr.show();
  }
  
  public void a(View paramView, axqf paramaxqf, int paramInt1, int paramInt2)
  {
    paramView = (adoz)aciy.a(paramView);
    Object localObject1 = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject2 = "handleMessage() msgSeq: " + ((MessageForShortVideo)localObject1).uniseq + " ";
    if (((MessageForShortVideo)localObject1).uniseq != paramaxqf.jdField_b_of_type_Long) {}
    adow localadow;
    label870:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localadow = paramView.jdField_a_of_type_Adow;
            localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources();
            paramInt1 = aciy.a(' ', (Resources)localObject3);
            paramInt2 = aciy.a(' ', (Resources)localObject3);
            if ((paramaxqf.jdField_b_of_type_Int != 6) && (paramaxqf.jdField_b_of_type_Int != 17) && (paramaxqf.jdField_b_of_type_Int != 9) && (paramaxqf.jdField_b_of_type_Int != 20)) {
              break;
            }
            switch (paramaxqf.d)
            {
            default: 
              return;
            case 1001: 
              if (QLog.isColorLevel()) {
                QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "VIDEO STATUS_SEND_START progress " + ((MessageForShortVideo)localObject1).videoFileProgress);
              }
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
              return;
            case 1003: 
              if (QLog.isColorLevel()) {
                QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "VIDEO STATUS_SEND_FINISHED");
              }
              b(paramView);
              return;
            case 1005: 
              if (QLog.isColorLevel()) {
                QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "VIDEO STATUS_SEND_ERROR");
              }
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              b(paramView);
              paramView.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(8);
              return;
            case 1004: 
              if (QLog.isColorLevel()) {
                QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "VIDEO STATUS_SEND_CANCEL");
              }
              b(paramView);
              return;
            case 1002: 
              paramInt1 = ((MessageForShortVideo)localObject1).videoFileProgress;
              if (QLog.isColorLevel()) {
                QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "VIDEO STATUS_SEND_PROCESS " + paramInt1);
              }
              a(paramView, paramInt1);
              return;
            case 2001: 
              if (QLog.isColorLevel()) {
                QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "VIDEO STATUS_RECV_START");
              }
              a(paramView, ((MessageForShortVideo)localObject1).videoFileProgress);
              return;
            case 2003: 
              if (QLog.isColorLevel()) {
                QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "VIDEO STATUS_RECV_FINISHED");
              }
              if (adpa.b)
              {
                paramaxqf = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
                if (localadow.a(paramaxqf))
                {
                  QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "handleMessage: 刷视频 " + paramaxqf);
                  if ((ShortVideoUtils.a()) && (bace.b(paramaxqf)))
                  {
                    localObject2 = URLDrawable.URLDrawableOptions.obtain();
                    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramInt1;
                    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramInt2;
                    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                    localObject3 = new VideoDrawable.VideoDrawableParams();
                    ((VideoDrawable.VideoDrawableParams)localObject3).mPlayVideoFrame = true;
                    ((VideoDrawable.VideoDrawableParams)localObject3).mVideoRoundCorner = 0;
                    ((VideoDrawable.VideoDrawableParams)localObject3).mRequestedFPS = adpa.jdField_a_of_type_Int;
                    ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = localObject3;
                    paramaxqf = URLDrawable.getDrawable(new File(paramaxqf), (URLDrawable.URLDrawableOptions)localObject2);
                    if (paramaxqf.getStatus() != 1) {
                      break label870;
                    }
                    localadow.b(paramaxqf);
                  }
                }
                for (;;)
                {
                  if (!((MessageForShortVideo)localObject1).isSend()) {
                    new auxb(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
                  }
                  if (((MessageForShortVideo)localObject1).subBusiType == 1) {
                    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", "" + ((MessageForShortVideo)localObject1).uuid, "" + ((MessageForShortVideo)localObject1).isSend());
                  }
                  b(paramView);
                  paramView.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(0);
                  return;
                  localadow.a(paramaxqf);
                }
              }
              paramaxqf = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
              if (bace.b(paramaxqf))
              {
                if (!localadow.a(paramaxqf)) {
                  break label965;
                }
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramInt1;
                ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramInt2;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                localadow.b(URLDrawable.getDrawable(new File(paramaxqf), (URLDrawable.URLDrawableOptions)localObject1));
              }
              for (;;)
              {
                c(paramView);
                return;
                paramaxqf = localadow.b;
                if ((paramaxqf != null) && (paramaxqf.getStatus() == 1)) {
                  localadow.b(paramaxqf);
                }
              }
            case 5001: 
              if (QLog.isColorLevel()) {
                QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_FILE_UNSAFE");
              }
              b(paramView);
              if (((MessageForShortVideo)localObject1).uiOperatorFlag == 2)
              {
                paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653674, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
                return;
              }
              bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653699, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
              return;
            case 2005: 
            case 5002: 
              if (QLog.isColorLevel())
              {
                if (paramaxqf.d == 2005) {
                  QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_ERROR");
                }
              }
              else
              {
                localObject1 = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
                if (bace.b((String)localObject1))
                {
                  if (!localadow.a((String)localObject1)) {
                    break label1248;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_FILE_EXPIRED: 刷缩略图 " + (String)localObject1);
                  }
                  localObject2 = URLDrawable.URLDrawableOptions.obtain();
                  ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                  ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                  localadow.b(URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2));
                }
              }
              for (;;)
              {
                if (paramaxqf.d != 2005) {
                  break label1312;
                }
                b(paramView, 2131652958);
                return;
                QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_FILE_EXPIRED");
                break;
                if (QLog.isColorLevel()) {
                  QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_FILE_EXPIRED: 刷缩略图用缓存 " + (String)localObject1);
                }
                localObject1 = localadow.b;
                if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1)) {
                  localadow.b((URLDrawable)localObject1);
                }
              }
              b(paramView, 2131652954);
              return;
            }
          } while (!QLog.isColorLevel());
          QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_CANCEL");
          return;
          paramInt1 = ((MessageForShortVideo)localObject1).videoFileProgress;
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
          }
          a(paramView, paramInt1);
          return;
        } while ((paramaxqf.jdField_b_of_type_Int != 7) && (paramaxqf.jdField_b_of_type_Int != 18) && (paramaxqf.jdField_b_of_type_Int != 16));
        switch (paramaxqf.d)
        {
        default: 
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoPTVItemBuilder", 2, "THUMB STATUS_RECV_START");
      return;
      localObject2 = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
      paramaxqf = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
      boolean bool = bace.b(paramaxqf);
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "THUMB STATUS_RECV_FINISHED: videoExists=" + bool + ", sAutoPlayInAIO=" + adpa.b);
      }
      if ((bool) && (adpa.b))
      {
        if (localadow.a(paramaxqf))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 视频存在,刷缩略图 " + (String)localObject2);
          }
          if (ShortVideoUtils.a())
          {
            localObject1 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramInt1;
            ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramInt2;
            ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            localObject2 = new VideoDrawable.VideoDrawableParams();
            ((VideoDrawable.VideoDrawableParams)localObject2).mPlayVideoFrame = true;
            ((VideoDrawable.VideoDrawableParams)localObject2).mVideoRoundCorner = 0;
            ((VideoDrawable.VideoDrawableParams)localObject2).mRequestedFPS = adpa.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
            localadow.b(URLDrawable.getDrawable(new File(paramaxqf), (URLDrawable.URLDrawableOptions)localObject1));
          }
        }
        for (;;)
        {
          b(paramView);
          return;
          paramaxqf = localadow.b;
          if ((paramaxqf != null) && (paramaxqf.getStatus() == 1)) {
            localadow.b(paramaxqf);
          }
        }
      }
      if (!bace.b((String)localObject2)) {
        break;
      }
    } while (!localadow.a((String)localObject2));
    label965:
    label1248:
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 缩略图存在，刷缩略图 " + (String)localObject2);
    }
    label1312:
    Object localObject3 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = paramInt1;
    ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = paramInt2;
    ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localadow.b(URLDrawable.getDrawable(new File((String)localObject2), (URLDrawable.URLDrawableOptions)localObject3));
    if (!bace.b(paramaxqf))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageForShortVideo)localObject1, true))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 刷缩略图，视频文件不存在， isNeedPredownload=true, downloadVideo");
        }
        a((MessageForShortVideo)localObject1, true);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_RECV_FINISHED: 刷缩略图，视频文件不存在， isNeedPredownload=false, showPauseProgress");
      }
      c(paramView);
      return;
    }
    if (ShortVideoUtils.a())
    {
      b(paramView);
      return;
    }
    c(paramView);
    return;
    localadow.setImageDrawable(axwd.a());
    return;
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "THUMB STATUS_FILE_EXPIRED");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "THUMB STATUS_RECV_ERROR");
    }
    paramaxqf = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
    if (bace.b(paramaxqf)) {
      if (localadow.a(paramaxqf))
      {
        QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "STATUS_RECV_ERROR: 缩略图下载失败刷视频 " + paramaxqf);
        if (ShortVideoUtils.a())
        {
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramInt1;
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramInt2;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localObject2 = new VideoDrawable.VideoDrawableParams();
          ((VideoDrawable.VideoDrawableParams)localObject2).mPlayVideoFrame = true;
          ((VideoDrawable.VideoDrawableParams)localObject2).mVideoRoundCorner = 0;
          ((VideoDrawable.VideoDrawableParams)localObject2).mRequestedFPS = adpa.jdField_a_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
          localadow.b(URLDrawable.getDrawable(new File(paramaxqf), (URLDrawable.URLDrawableOptions)localObject1));
        }
      }
    }
    for (;;)
    {
      b(paramView);
      return;
      paramaxqf = localadow.b;
      if ((paramaxqf != null) && (paramaxqf.getStatus() == 1))
      {
        localadow.b(paramaxqf);
        continue;
        localadow.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(0, BaseChatItemLayout.g, 0, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(0, BaseChatItemLayout.g, 0, BaseChatItemLayout.h);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    awey localawey = aweg.a(2, 3);
    awej localawej = paramMessageForShortVideo.getDownloadInfo(localawey.jdField_b_of_type_Int);
    localawej.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "downloadThumb thumbPath" + localawej.i);
    }
    localawej.a(paramMessageForShortVideo.istroop, 1);
    localawej.f = 2;
    localawej.g = 2;
    localawey.a(localawej);
    localawey.a(paramMessageForShortVideo);
    aweg.a(localawey, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, adoz paramadoz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!bace.b((String)localObject))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131653706, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
      paramadoz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
    }
    do
    {
      return;
      if (!bace.b(str))
      {
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131653707, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        paramadoz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      localObject = aweg.a(1, 3);
      ((awey)localObject).a(aweg.a(((awey)localObject).jdField_b_of_type_Int, paramMessageForShortVideo, (awey)localObject));
      aweg.a((awey)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((!paramMessageForShortVideo.isSendFromLocal()) || (paramMessageForShortVideo.videoFileStatus != 1005) || (paramMessageForShortVideo.videoFileProgress != 0));
    a(paramadoz, 3);
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
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131653216, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
      return;
      i = 0;
      break;
    }
    label114:
    localObject = aweg.a(2, 3);
    awej localawej = paramMessageForShortVideo.getDownloadInfo(((awey)localObject).jdField_b_of_type_Int);
    localawej.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localawej.a(paramMessageForShortVideo.istroop, 0);
    i = j;
    if (paramBoolean) {
      i = 2;
    }
    localawej.f = i;
    localawej.g = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localawej.e + ", uniseq:" + paramMessageForShortVideo.uniseq + "localPath=" + localawej.h);
    }
    ((awey)localObject).a(localawej);
    ((awey)localObject).a(paramMessageForShortVideo);
    aweg.a((awey)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      if ((paramBaseChatItemLayout instanceof axou))
      {
        if (((axou)paramBaseChatItemLayout).c() == 1005L) {}
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
  
  public bakj[] a(View paramView)
  {
    int k = 0;
    bakh localbakh = new bakh();
    Object localObject = (adoz)aciy.a(paramView);
    paramView = (MessageForShortVideo)((adoz)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.md5 != null)
    {
      String str = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
      ShortVideoUtils.a(paramView, "mp4");
      if (bace.b(str)) {
        if ((((adoz)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView == null) || (!((adoz)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a())) {
          break label271;
        }
      }
    }
    label271:
    for (int i = 1;; i = 0)
    {
      int j = k;
      if (((adoz)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
      {
        j = k;
        if (((adoz)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
          j = 1;
        }
      }
      if ((paramView.isSendFromLocal()) && (j == 0)) {
        localbakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131627114), 2130838599);
      }
      a(paramView, localbakh);
      if ((i == 0) && (j == 0)) {
        a(localbakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbakh, paramView);
      if (paramView.md5 != null)
      {
        localObject = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
        if (bace.b(ShortVideoUtils.a(paramView, "mp4"))) {
          localbakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131626722), 2130838598);
        }
        if (bace.b((String)localObject)) {
          b(paramView, localbakh);
        }
      }
      super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
      return localbakh.a();
    }
  }
  
  void b(adoz paramadoz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "hideProgress() msgSeq: " + paramadoz.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramadoz.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramadoz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void b(adoz paramadoz, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showWarnProgress() msgSeq: " + paramadoz.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramadoz.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramadoz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramadoz.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844799);
    paramadoz.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
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
    aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, adoz paramadoz)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
      }
      if (!bace.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131653707, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        paramadoz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        paramadoz = aweg.a(4, 3);
        paramadoz.a(aweg.a(paramadoz.jdField_b_of_type_Int, paramMessageForShortVideo, paramadoz));
        aweg.a(paramadoz, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoPTVItemBuilder", 2, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void c(adoz paramadoz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showPauseProgress() msgSeq: " + paramadoz.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramadoz.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramadoz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramadoz.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844798);
    paramadoz.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void onClick(View paramView)
  {
    adoz localadoz = (adoz)aciy.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localadoz.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.getId() == 2131298594) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
      {
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131630481, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        return;
      }
      if (paramView.getId() != 2131298552) {
        break;
      }
    } while (localMessageForShortVideo.md5 == null);
    Object localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
    String str = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    if (QLog.isColorLevel()) {
      QLog.e("ptvitem", 2, "onClick videoPath=" + str + "thumbPath=" + (String)localObject);
    }
    if (!bace.b(str))
    {
      a(localMessageForShortVideo, false);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E96", "0X8005E96", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (!localMessageForShortVideo.isSend()) {
        new auxb(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1003);
      }
      if (localMessageForShortVideo.isBlessMsg) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", "" + localMessageForShortVideo.uuid, "" + localMessageForShortVideo.isSend());
      }
      super.onClick(paramView);
      return;
      if (bace.b((String)localObject))
      {
        if ((adpa.b) && (ShortVideoUtils.a()))
        {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E95", "0X8005E95", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
            break;
          }
          if ((localadoz.jdField_a_of_type_Adow.getDrawable() == null) || (!(localadoz.jdField_a_of_type_Adow.getDrawable() instanceof URLDrawable))) {
            continue;
          }
          localObject = (URLDrawable)localadoz.jdField_a_of_type_Adow.getDrawable();
          if ((((URLDrawable)localObject).getStatus() != 1) || (!(((URLDrawable)localObject).getCurrDrawable() instanceof VideoDrawable))) {
            continue;
          }
          localObject = (VideoDrawable)((URLDrawable)localObject).getCurrDrawable();
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPTVItemBuilder", 2, " videoDrawable.isAudioPlaying(): " + ((VideoDrawable)localObject).isAudioPlaying());
          }
          if (((VideoDrawable)localObject).isAudioPlaying())
          {
            ((VideoDrawable)localObject).stopAudio();
            localadoz.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
            jdField_b_of_type_JavaLangRefWeakReference = null;
            continue;
          }
          if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
          }
          if ((jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() != localObject) && (((VideoDrawable)jdField_a_of_type_JavaLangRefWeakReference.get()).isAudioPlaying()))
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
          ((VideoDrawable)localObject).resetAndPlayAudioOnce();
          jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject);
          localadoz.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
          jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(localMessageForShortVideo);
          ((VideoDrawable)localObject).setOnAudioPlayOnceListener(new adov(this));
          continue;
        }
        ShortVideoRealItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo, localadoz.jdField_a_of_type_Adow, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adot
 * JD-Core Version:    0.7.0.1
 */