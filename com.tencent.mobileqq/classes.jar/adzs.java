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

public class adzs
  extends BaseBubbleBuilder
  implements acwf, axdq
{
  static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new anou(-10065297, c, d);
  public static WeakReference<VideoDrawable> a;
  private static WeakReference<MessageForShortVideo> jdField_b_of_type_JavaLangRefWeakReference;
  static int c;
  static int d;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  Handler jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    c = actn.a(160.0F, localResources);
    d = actn.a(160.0F, localResources);
  }
  
  public adzs(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    ShortVideoUtils.a(paramQQAppInterface);
    adzz.a();
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
      i = actn.a(paramChatMessage.uniseq, paramListView.getAdapter());
      if (i > -1)
      {
        paramListView = actn.a(paramListView, i);
        if (paramListView != null)
        {
          paramListView = actn.a(paramListView);
          if ((paramListView != null) && ((paramListView instanceof adzy)))
          {
            paramListView = (adzy)paramListView;
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
  
  public acum a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (adzy)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_Adzv;
      }
    }
    return null;
  }
  
  public acun a()
  {
    return new adzy(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxn paramacxn)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxn);
    paramacxn = acwd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramacxn != null) {
      paramacxn.a(paramView, this);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetListView == null) && (paramViewGroup != null) && ((paramViewGroup instanceof ListView))) {
      this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramViewGroup);
    }
    try
    {
      paramViewGroup = (adzy)paramView.getTag();
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
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    paramBaseChatItemLayout = (adzy)paramacun;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    Object localObject2 = ((Context)localObject1).getResources();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView(), message = " + paramChatMessage);
    }
    paramacun = paramView;
    Object localObject3;
    if (paramView == null)
    {
      paramacun = new RelativeLayout((Context)localObject1);
      int i = actn.a(160.0F, (Resources)localObject2);
      int j = actn.a(160.0F, (Resources)localObject2);
      paramView = new adzv((Context)localObject1);
      paramView.setId(2131371608);
      paramView.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject3 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      paramacun.addView(paramView, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new CircleProgressView((Context)localObject1);
      ((CircleProgressView)localObject3).setVisibility(8);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
      localLayoutParams.addRule(13);
      paramacun.addView((View)localObject3, localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(8, 2131371608);
      localLayoutParams.bottomMargin = actn.a(6.0F, (Resources)localObject2);
      localObject2 = new AudioAnimationView((Context)localObject1);
      ((AudioAnimationView)localObject2).setRectCount(7);
      ((AudioAnimationView)localObject2).setSyle(1);
      ((AudioAnimationView)localObject2).setIcon(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838049));
      paramacun.addView((View)localObject2, localLayoutParams);
      localObject1 = new ImageView((Context)localObject1);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      ((ImageView)localObject1).setVisibility(8);
      paramacun.addView((View)localObject1, localLayoutParams);
      paramacun.setOnClickListener(this);
      paramacun.setOnTouchListener(paramacxn);
      paramacun.setOnLongClickListener(paramacxn);
      paramBaseChatItemLayout.jdField_a_of_type_Adzv = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView = ((CircleProgressView)localObject3);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject1);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView = ((AudioAnimationView)localObject2);
    }
    paramacxn = paramBaseChatItemLayout.jdField_a_of_type_Adzv;
    paramView = (MessageForShortVideo)paramChatMessage;
    paramacxn.c = paramView.isSend();
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
        paramacun.setContentDescription(((StringBuilder)localObject1).toString());
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
        if (!bbdj.b(paramChatMessage)) {
          break label681;
        }
        if (paramacxn.a(paramChatMessage))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 占坑 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          }
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramacxn.b(URLDrawable.getDrawable(new File(paramChatMessage), (URLDrawable.URLDrawableOptions)localObject1));
          a(paramBaseChatItemLayout);
          Utils.executeAsyncTaskOnSerialExcuter(new adzx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView), new Void[] { (Void)null });
        }
      }
    }
    label681:
    do
    {
      return paramacun;
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d).append("发出视频对讲消息,");
      break;
      paramacxn.setImageDrawable(aywk.a());
      b(paramBaseChatItemLayout);
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView():You must get thumb before send video. msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return paramacun;
    label736:
    localObject1 = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
    paramChatMessage = ShortVideoUtils.a(paramView, "mp4");
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView() videoPath" + paramChatMessage + "thumbPath=" + (String)localObject1);
    }
    if ((adzz.b) && (ShortVideoUtils.a()) && (bbdj.b(paramChatMessage)) && ((!paramView.isSendFromLocal()) || (paramView.videoFileStatus == 1003) || (paramView.videoFileStatus == 2003)))
    {
      if (!paramView.isSend()) {
        new avws(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
      }
      if (paramacxn.a(paramChatMessage))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频 " + paramChatMessage + " msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        if (!paramacxn.a((String)localObject1)) {
          ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = paramacxn.b;
        }
        localObject3 = new VideoDrawable.VideoDrawableParams();
        ((VideoDrawable.VideoDrawableParams)localObject3).mPlayVideoFrame = true;
        ((VideoDrawable.VideoDrawableParams)localObject3).mPlayAudioFrame = false;
        ((VideoDrawable.VideoDrawableParams)localObject3).mVideoRoundCorner = 0;
        ((VideoDrawable.VideoDrawableParams)localObject3).mRequestedFPS = adzz.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = localObject3;
        localObject2 = URLDrawable.getDrawable(new File(paramChatMessage), (URLDrawable.URLDrawableOptions)localObject2);
        paramacxn.b((URLDrawable)localObject2);
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
        if (!bbdj.b((String)localObject1))
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
        if (!ayoz.class.isInstance(paramChatMessage)) {
          break label1416;
        }
        if (((ayoz)paramChatMessage).c() != 1002L) {
          break;
        }
        a(paramBaseChatItemLayout, paramView.videoFileProgress);
        return paramacun;
        label1263:
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
        break label1089;
        localObject2 = paramacxn.b;
        if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 1))
        {
          paramacxn.b((URLDrawable)localObject2);
          if ((((URLDrawable)localObject2).getCurrDrawable() instanceof VideoDrawable))
          {
            paramacxn = (VideoDrawable)((URLDrawable)localObject2).getCurrDrawable();
            if (QLog.isColorLevel()) {
              QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷视频用缓存, isAudioPlaying= " + paramacxn.isAudioPlaying() + ", videoPath:" + paramChatMessage + " msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
            }
            if (paramacxn.isAudioPlaying()) {
              paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
            } else {
              paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
            }
          }
        }
      }
      label1416:
      b(paramBaseChatItemLayout);
      return paramacun;
      label1424:
      b(paramBaseChatItemLayout);
      return paramacun;
    }
    if (bbdj.b((String)localObject1))
    {
      if (paramacxn.a((String)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷缩略图 " + (String)localObject1 + " msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramacxn.b(URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2));
      }
      for (;;)
      {
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
        if (!bbdj.b(paramChatMessage)) {
          break label1702;
        }
        if ((!paramView.isSendFromLocal()) || (paramView.videoFileProgress > 100) || (paramView.videoFileStatus == 1003)) {
          break;
        }
        a(paramBaseChatItemLayout, paramView.videoFileProgress);
        return paramacun;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 刷缩略图用缓存 " + (String)localObject1 + " msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        localObject1 = paramacxn.b;
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1)) {
          paramacxn.b((URLDrawable)localObject1);
        }
      }
      if ((ShortVideoUtils.a()) && (adzz.b))
      {
        b(paramBaseChatItemLayout);
        return paramacun;
      }
      c(paramBaseChatItemLayout);
      return paramacun;
      label1702:
      if (paramView.videoFileStatus == 5002)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView():短视频已过期不启动下载流程 1 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        b(paramBaseChatItemLayout, 2131718779);
        return paramacun;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView, true))
      {
        a(paramView, true);
        a(paramBaseChatItemLayout, paramView.videoFileProgress);
        return paramacun;
      }
      if (ayoz.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramView.frienduin, paramView.uniseq)))
      {
        a(paramBaseChatItemLayout, paramView.videoFileProgress);
        return paramacun;
      }
      c(paramBaseChatItemLayout);
      return paramacun;
    }
    if (paramView.videoFileStatus == 5002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "getBubbleView():短视频已过期不启动下载流程 2 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      paramacxn.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(paramBaseChatItemLayout, 2131718779);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      return paramacun;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, "getBubbleView: 下占位图 msgSeq: " + paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramacxn.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    a(paramView);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
    return paramacun;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bbet.a(paramChatMessage.issend)) {
      return ajyc.a(2131714065);
    }
    return ajyc.a(2131714054);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt != 2131364985) {
        break label38;
      }
      aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
    }
    label38:
    do
    {
      do
      {
        return;
        if (paramInt == 2131370537)
        {
          super.d(paramChatMessage);
          return;
        }
        if (paramInt == 2131366632)
        {
          paramInt = aunq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
          if (paramInt == 3) {
            paramContext = "1";
          }
          for (;;)
          {
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
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
        if (paramInt == 2131365928)
        {
          bgpd.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          bgpr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
          bgpr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
          return;
        }
        if (paramInt != 2131370494) {
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
        if (!ShortVideoUploadProcessor.class.isInstance(paramContext))
        {
          paramInt = i;
          if (!ayuu.class.isInstance(paramContext)) {}
        }
        else
        {
          boolean bool = ((ayoz)paramContext).d();
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
  
  void a(adzy paramadzy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showLoading() msgSeq: " + paramadzy.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramadzy.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.setIndeterminate(true);
    paramadzy.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a();
    paramadzy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void a(adzy paramadzy, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showProgress(), progress = " + paramInt + " msgSeq: " + paramadzy.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    CircleProgressView localCircleProgressView = paramadzy.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView;
    int i = paramInt;
    if (paramInt > 100)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "startShowProgress, illegal process:" + paramInt + " msgSeq: " + paramadzy.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      i = 100;
    }
    localCircleProgressView.setIndeterminate(false);
    localCircleProgressView.setProgress(i);
    paramadzy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (adzy)actn.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {
      return;
    }
    bfol localbfol = (bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbfol.a(2131689995, 5);
    localbfol.c(2131690596);
    localbfol.a(new adzt(this, localMessageForShortVideo, paramView, localbfol));
    localbfol.show();
  }
  
  public void a(View paramView, ayqm paramayqm, int paramInt1, int paramInt2)
  {
    paramView = (adzy)actn.a(paramView);
    Object localObject1 = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject2 = "handleMessage() msgSeq: " + ((MessageForShortVideo)localObject1).uniseq + " ";
    if (((MessageForShortVideo)localObject1).uniseq != paramayqm.jdField_b_of_type_Long) {}
    adzv localadzv;
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
            localadzv = paramView.jdField_a_of_type_Adzv;
            localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources();
            paramInt1 = actn.a(' ', (Resources)localObject3);
            paramInt2 = actn.a(' ', (Resources)localObject3);
            if ((paramayqm.jdField_b_of_type_Int != 6) && (paramayqm.jdField_b_of_type_Int != 17) && (paramayqm.jdField_b_of_type_Int != 9) && (paramayqm.jdField_b_of_type_Int != 20)) {
              break;
            }
            switch (paramayqm.d)
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
              if (adzz.b)
              {
                paramayqm = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
                if (localadzv.a(paramayqm))
                {
                  QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "handleMessage: 刷视频 " + paramayqm);
                  if ((ShortVideoUtils.a()) && (bbdj.b(paramayqm)))
                  {
                    localObject2 = URLDrawable.URLDrawableOptions.obtain();
                    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramInt1;
                    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramInt2;
                    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                    localObject3 = new VideoDrawable.VideoDrawableParams();
                    ((VideoDrawable.VideoDrawableParams)localObject3).mPlayVideoFrame = true;
                    ((VideoDrawable.VideoDrawableParams)localObject3).mVideoRoundCorner = 0;
                    ((VideoDrawable.VideoDrawableParams)localObject3).mRequestedFPS = adzz.jdField_a_of_type_Int;
                    ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = localObject3;
                    paramayqm = URLDrawable.getDrawable(new File(paramayqm), (URLDrawable.URLDrawableOptions)localObject2);
                    if (paramayqm.getStatus() != 1) {
                      break label870;
                    }
                    localadzv.b(paramayqm);
                  }
                }
                for (;;)
                {
                  if (!((MessageForShortVideo)localObject1).isSend()) {
                    new avws(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
                  }
                  if (((MessageForShortVideo)localObject1).subBusiType == 1) {
                    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", "" + ((MessageForShortVideo)localObject1).uuid, "" + ((MessageForShortVideo)localObject1).isSend());
                  }
                  b(paramView);
                  paramView.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(0);
                  return;
                  localadzv.a(paramayqm);
                }
              }
              paramayqm = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
              if (bbdj.b(paramayqm))
              {
                if (!localadzv.a(paramayqm)) {
                  break label965;
                }
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = paramInt1;
                ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = paramInt2;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                localadzv.b(URLDrawable.getDrawable(new File(paramayqm), (URLDrawable.URLDrawableOptions)localObject1));
              }
              for (;;)
              {
                c(paramView);
                return;
                paramayqm = localadzv.b;
                if ((paramayqm != null) && (paramayqm.getStatus() == 1)) {
                  localadzv.b(paramayqm);
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
                bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719558, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                return;
              }
              bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719583, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
              return;
            case 2005: 
            case 5002: 
              if (QLog.isColorLevel())
              {
                if (paramayqm.d == 2005) {
                  QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_RECV_ERROR");
                }
              }
              else
              {
                localObject1 = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
                if (bbdj.b((String)localObject1))
                {
                  if (!localadzv.a((String)localObject1)) {
                    break label1248;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_FILE_EXPIRED: 刷缩略图 " + (String)localObject1);
                  }
                  localObject2 = URLDrawable.URLDrawableOptions.obtain();
                  ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                  ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
                  localadzv.b(URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2));
                }
              }
              for (;;)
              {
                if (paramayqm.d != 2005) {
                  break label1312;
                }
                b(paramView, 2131718783);
                return;
                QLog.i("ShortVideoPTVItemBuilder", 2, "VIDEO STATUS_FILE_EXPIRED");
                break;
                if (QLog.isColorLevel()) {
                  QLog.i("ShortVideoPTVItemBuilder", 2, "STATUS_FILE_EXPIRED: 刷缩略图用缓存 " + (String)localObject1);
                }
                localObject1 = localadzv.b;
                if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1)) {
                  localadzv.b((URLDrawable)localObject1);
                }
              }
              b(paramView, 2131718779);
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
        } while ((paramayqm.jdField_b_of_type_Int != 7) && (paramayqm.jdField_b_of_type_Int != 18) && (paramayqm.jdField_b_of_type_Int != 16));
        switch (paramayqm.d)
        {
        default: 
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoPTVItemBuilder", 2, "THUMB STATUS_RECV_START");
      return;
      localObject2 = ShortVideoUtils.a(((MessageForShortVideo)localObject1).thumbMD5, "jpg");
      paramayqm = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
      boolean bool = bbdj.b(paramayqm);
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoPTVItemBuilder", 2, "THUMB STATUS_RECV_FINISHED: videoExists=" + bool + ", sAutoPlayInAIO=" + adzz.b);
      }
      if ((bool) && (adzz.b))
      {
        if (localadzv.a(paramayqm))
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
            ((VideoDrawable.VideoDrawableParams)localObject2).mRequestedFPS = adzz.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
            localadzv.b(URLDrawable.getDrawable(new File(paramayqm), (URLDrawable.URLDrawableOptions)localObject1));
          }
        }
        for (;;)
        {
          b(paramView);
          return;
          paramayqm = localadzv.b;
          if ((paramayqm != null) && (paramayqm.getStatus() == 1)) {
            localadzv.b(paramayqm);
          }
        }
      }
      if (!bbdj.b((String)localObject2)) {
        break;
      }
    } while (!localadzv.a((String)localObject2));
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
    localadzv.b(URLDrawable.getDrawable(new File((String)localObject2), (URLDrawable.URLDrawableOptions)localObject3));
    if (!bbdj.b(paramayqm))
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
    localadzv.setImageDrawable(aywk.a());
    return;
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "THUMB STATUS_FILE_EXPIRED");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "THUMB STATUS_RECV_ERROR");
    }
    paramayqm = ShortVideoUtils.a((MessageForShortVideo)localObject1, "mp4");
    if (bbdj.b(paramayqm)) {
      if (localadzv.a(paramayqm))
      {
        QLog.i("ShortVideoPTVItemBuilder", 2, (String)localObject2 + "STATUS_RECV_ERROR: 缩略图下载失败刷视频 " + paramayqm);
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
          ((VideoDrawable.VideoDrawableParams)localObject2).mRequestedFPS = adzz.jdField_a_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject1).mExtraInfo = localObject2;
          localadzv.b(URLDrawable.getDrawable(new File(paramayqm), (URLDrawable.URLDrawableOptions)localObject1));
        }
      }
    }
    for (;;)
    {
      b(paramView);
      return;
      paramayqm = localadzv.b;
      if ((paramayqm != null) && (paramayqm.getStatus() == 1))
      {
        localadzv.b(paramayqm);
        continue;
        localadzv.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
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
    axeg localaxeg = axdo.a(2, 3);
    axdr localaxdr = paramMessageForShortVideo.getDownloadInfo(localaxeg.jdField_b_of_type_Int);
    localaxdr.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "downloadThumb thumbPath" + localaxdr.i);
    }
    localaxdr.a(paramMessageForShortVideo.istroop, 1);
    localaxdr.f = 2;
    localaxdr.g = 2;
    localaxeg.a(localaxdr);
    localaxeg.a(paramMessageForShortVideo);
    axdo.a(localaxeg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, adzy paramadzy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!bbdj.b((String)localObject))
    {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719590, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      paramadzy.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
    }
    do
    {
      return;
      if (!bbdj.b(str))
      {
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719591, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        paramadzy.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      localObject = axdo.a(1, 3);
      ((axeg)localObject).a(axdo.a(((axeg)localObject).jdField_b_of_type_Int, paramMessageForShortVideo, (axeg)localObject));
      axdo.a((axeg)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((!paramMessageForShortVideo.isSendFromLocal()) || (paramMessageForShortVideo.videoFileStatus != 1005) || (paramMessageForShortVideo.videoFileProgress != 0));
    a(paramadzy, 3);
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
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719044, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      return;
      i = 0;
      break;
    }
    label114:
    localObject = axdo.a(2, 3);
    axdr localaxdr = paramMessageForShortVideo.getDownloadInfo(((axeg)localObject).jdField_b_of_type_Int);
    localaxdr.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localaxdr.a(paramMessageForShortVideo.istroop, 0);
    i = j;
    if (paramBoolean) {
      i = 2;
    }
    localaxdr.f = i;
    localaxdr.g = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localaxdr.e + ", uniseq:" + paramMessageForShortVideo.uniseq + "localPath=" + localaxdr.h);
    }
    ((axeg)localObject).a(localaxdr);
    ((axeg)localObject).a(paramMessageForShortVideo);
    axdo.a((axeg)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      if ((paramBaseChatItemLayout instanceof ayoz))
      {
        if (((ayoz)paramBaseChatItemLayout).c() == 1005L) {}
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
  
  public bblt[] a(View paramView)
  {
    int k = 0;
    bblr localbblr = new bblr();
    Object localObject = (adzy)actn.a(paramView);
    paramView = (MessageForShortVideo)((adzy)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.md5 != null)
    {
      String str = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
      ShortVideoUtils.a(paramView, "mp4");
      if (bbdj.b(str)) {
        if ((((adzy)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView == null) || (!((adzy)localObject).jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.a())) {
          break label271;
        }
      }
    }
    label271:
    for (int i = 1;; i = 0)
    {
      int j = k;
      if (((adzy)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
      {
        j = k;
        if (((adzy)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
          j = 1;
        }
      }
      if ((paramView.isSendFromLocal()) && (j == 0)) {
        localbblr.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692752), 2130838606);
      }
      a(paramView, localbblr);
      if ((i == 0) && (j == 0)) {
        a(localbblr, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
      }
      a(localbblr, paramView);
      if (paramView.md5 != null)
      {
        localObject = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
        if (bbdj.b(ShortVideoUtils.a(paramView, "mp4"))) {
          localbblr.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692324), 2130838605);
        }
        if (bbdj.b((String)localObject)) {
          b(paramView, localbblr);
        }
      }
      super.e(localbblr, this.jdField_a_of_type_AndroidContentContext);
      return localbblr.a();
    }
  }
  
  void b(adzy paramadzy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "hideProgress() msgSeq: " + paramadzy.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramadzy.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramadzy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void b(adzy paramadzy, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showWarnProgress() msgSeq: " + paramadzy.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramadzy.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramadzy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramadzy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844880);
    paramadzy.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
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
    aqbc.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, adzy paramadzy)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPTVItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
      }
      if (!bbdj.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719591, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        paramadzy.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        paramadzy = axdo.a(4, 3);
        paramadzy.a(axdo.a(paramadzy.jdField_b_of_type_Int, paramMessageForShortVideo, paramadzy));
        axdo.a(paramadzy, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoPTVItemBuilder", 2, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void c(adzy paramadzy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPTVItemBuilder", 2, "showPauseProgress() msgSeq: " + paramadzy.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    paramadzy.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressView.c();
    paramadzy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramadzy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844879);
    paramadzy.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(4);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void onClick(View paramView)
  {
    adzy localadzy = (adzy)actn.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localadzy.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView.getId() == 2131364152) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
      {
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131696181, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        return;
      }
      if (paramView.getId() != 2131364110) {
        break;
      }
    } while (localMessageForShortVideo.md5 == null);
    Object localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
    String str = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    if (QLog.isColorLevel()) {
      QLog.e("ptvitem", 2, "onClick videoPath=" + str + "thumbPath=" + (String)localObject);
    }
    if (!bbdj.b(str))
    {
      a(localMessageForShortVideo, false);
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E96", "0X8005E96", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (!localMessageForShortVideo.isSend()) {
        new avws(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2003, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1003);
      }
      if (localMessageForShortVideo.isBlessMsg) {
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006199", "0X8006199", 0, 0, "", "", "" + localMessageForShortVideo.uuid, "" + localMessageForShortVideo.isSend());
      }
      super.onClick(paramView);
      return;
      if (bbdj.b((String)localObject))
      {
        if ((adzz.b) && (ShortVideoUtils.a()))
        {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005E95", "0X8005E95", 0, 0, "", "", "", "");
          if (this.jdField_a_of_type_ComTencentWidgetListView == null) {
            break;
          }
          if ((localadzy.jdField_a_of_type_Adzv.getDrawable() == null) || (!(localadzy.jdField_a_of_type_Adzv.getDrawable() instanceof URLDrawable))) {
            continue;
          }
          localObject = (URLDrawable)localadzy.jdField_a_of_type_Adzv.getDrawable();
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
            localadzy.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
            jdField_b_of_type_JavaLangRefWeakReference = null;
            continue;
          }
          if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) {
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
          localadzy.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
          jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(localMessageForShortVideo);
          ((VideoDrawable)localObject).setOnAudioPlayOnceListener(new adzu(this));
          continue;
        }
        ShortVideoRealItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo, localadzy.jdField_a_of_type_Adzv, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adzs
 * JD-Core Version:    0.7.0.1
 */