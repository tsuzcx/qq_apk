import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.10;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.3;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.4;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class agai
  extends BaseBubbleBuilder
  implements aeql, aesa, azdf, azfb
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect;
  private static CopyOnWriteArraySet<CropBubbleVideoView> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  public static AtomicLong a;
  private static long c;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new agak(this);
  private auqc jdField_a_of_type_Auqc;
  private bdjz jdField_a_of_type_Bdjz;
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ShortVideoItemBuilder.10(this);
  private Handler b;
  public int c;
  int d = -1;
  boolean f = false;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  }
  
  public agai(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = 0;
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if (this.jdField_a_of_type_Auqc == null) {
      this.jdField_a_of_type_Auqc = ((auqc)paramQQAppInterface.getManager(324));
    }
  }
  
  private agas a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int i = aepi.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (i <= -1) {
        break label215;
      }
      Object localObject = aepi.a(this.jdField_a_of_type_ComTencentWidgetListView, i);
      if (localObject != null)
      {
        localObject = aepi.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof agas))) {
          return (agas)localObject;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("ShortVideoItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + i + ", view = null");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + i + ", firstVisblePosi=" + k + ",lastVisblePosi=" + m + ",headerCount=" + j);
      }
    }
    for (;;)
    {
      return null;
      label215:
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi<= -1");
      }
    }
  }
  
  private agas a(MessageForShortVideo paramMessageForShortVideo)
  {
    agas localagas = a(paramMessageForShortVideo.uniseq);
    if ((localagas == null) && (QLog.isColorLevel())) {
      QLog.d("ShortVideoItemBuilder", 2, "holder is null, seq = " + paramMessageForShortVideo.uniseq);
    }
    return localagas;
  }
  
  private Rect a(View paramView, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramView == null) || (paramMessageForShortVideo == null)) {
      return null;
    }
    paramView = paramView.findViewById(2131362258);
    if ((paramView instanceof CropBubbleVideoView))
    {
      paramView = (CropBubbleVideoView)paramView;
      Rect localRect = zjc.a(paramView);
      if (paramMessageForShortVideo.isSend()) {
        localRect.right = ((int)(localRect.right - paramView.triWidth));
      }
      for (;;)
      {
        return localRect;
        float f1 = localRect.left;
        localRect.left = ((int)(paramView.triWidth + f1));
      }
    }
    return null;
  }
  
  public static Drawable a(int paramInt1, int paramInt2)
  {
    return new apkp(Color.rgb(214, 214, 214), paramInt1, paramInt2);
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Drawable localDrawable = null;
    if (bdhb.b(paramString))
    {
      paramString = ShortVideoUtils.b(paramString);
      if (paramString != null) {
        localDrawable = b(paramString.toString(), paramInt1, paramInt2, paramInt3);
      }
    }
    else
    {
      return localDrawable;
    }
    QLog.d("ShortVideoItemBuilder", 2, "url  is null ");
    return null;
  }
  
  public static String a(long paramLong)
  {
    return "qqlive://msgId=" + paramLong;
  }
  
  private void a(agas paramagas, int paramInt)
  {
    paramagas.c.setVisibility(0);
    paramagas.c.setText(paramInt);
    paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
    paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setImageResource(2130849204);
    paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(3);
  }
  
  private void a(agas paramagas, View paramView, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {}
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoItemBuilder", 2, "msgForShortVideo.msgTailType=" + localMessageForShortVideo.msgTailType);
        }
        if ((azdl.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.msgTailType)) && (paramChatMessage.istroop == 1))
        {
          if (paramagas.e == null)
          {
            paramagas.e = new TextView(this.jdField_a_of_type_AndroidContentContext);
            paramagas.e.setBackgroundResource(2130842258);
            paramagas.e.setTextSize(1, 12.0F);
            paramagas.e.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167194));
            paramagas.e.setText(azdl.b(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.msgTailType));
            paramagas.e.setSingleLine();
            paramagas.e.setGravity(16);
            paramagas.e.setPadding(bdaq.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0);
            paramagas.e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
            paramChatMessage.addRule(3, 2131364173);
            paramChatMessage.addRule(5, 2131364173);
            if ((paramView instanceof ViewGroup)) {
              ((ViewGroup)paramView).addView(paramagas.e, paramChatMessage);
            }
          }
          paramView = (RelativeLayout.LayoutParams)paramagas.e.getLayoutParams();
          if (localMessageForShortVideo.isSend()) {}
          for (paramView.leftMargin = BaseChatItemLayout.j;; paramView.leftMargin = BaseChatItemLayout.i)
          {
            paramagas.e.setTag(localMessageForShortVideo);
            paramagas.e.setVisibility(0);
            return;
          }
        }
      } while (paramagas.e == null);
      paramagas.e.setVisibility(8);
      return;
    }
  }
  
  private void a(agas paramagas, MessageForShortVideo paramMessageForShortVideo, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, msg.uniseq = " + paramMessageForShortVideo.uniseq);
    }
    paramString = ShortVideoUtils.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, url = " + paramString);
    }
    if ((QLog.isColorLevel()) && (paramagas.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d.getURL()=" + paramagas.jdField_a_of_type_ComTencentImageURLDrawable.getURL());
    }
    paramagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    if ((paramagas.jdField_a_of_type_ComTencentImageURLDrawable != null) && (paramagas.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d is reuse !!!");
      }
      if (paramBoolean)
      {
        paramagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setCoverDrawable(paramagas.jdField_a_of_type_ComTencentImageURLDrawable);
        return;
      }
      paramagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramagas.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    Drawable localDrawable = a(paramInt1, paramInt2);
    paramString = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localDrawable, localDrawable);
    paramagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    paramagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramString);
    paramagas.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
  }
  
  private void a(agas paramagas, boolean paramBoolean)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    int i = localMessageForShortVideo.videoFileStatus;
    long l = 0L;
    if (paramagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView != null) {
      l = paramagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getCurPlayingPos();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "click ppv, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType: " + ShortVideoUtils.a(localMessageForShortVideo.fileType) + ", fileStatus:" + ShortVideoUtils.b(i) + ", playPosition:" + l);
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("......click ppv, msg.uniseq:" + localMessageForShortVideo.uniseq);
    String str = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    if (!localMessageForShortVideo.isSendFromLocal()) {
      a(localMessageForShortVideo, localStringBuilder, i, str, paramagas, l, paramBoolean);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, localStringBuilder.toString());
      }
      return;
      b(localMessageForShortVideo, localStringBuilder, i, str, paramagas, l, paramBoolean);
    }
  }
  
  private void a(agas paramagas, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramagas != null) && (paramagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null))
    {
      if (paramBoolean) {
        b(paramagas, false, null);
      }
      paramagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private void a(agas paramagas, boolean paramBoolean, MessageForShortVideo paramMessageForShortVideo, String paramString1, String[] paramArrayOfString, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "playShortVideo, msg.uniseq = " + paramMessageForShortVideo.uniseq);
    }
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("playShortVideo, thumbPath = ");
      if (paramString2 != null)
      {
        localObject = paramString2;
        QLog.d("ShortVideoItemBuilder", 2, (String)localObject);
      }
    }
    else
    {
      paramagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      localObject = new VideoPlayParam();
      ((VideoPlayParam)localObject).mSceneId = 101;
      ((VideoPlayParam)localObject).mSceneName = axba.a(101);
      ((VideoPlayParam)localObject).mIsMute = true;
      ((VideoPlayParam)localObject).mCallback = new agal(this);
      ((VideoPlayParam)localObject).mIsLocal = paramBoolean;
      ((VideoPlayParam)localObject).mIsLoop = true;
      ((VideoPlayParam)localObject).mVideoPath = paramString1;
      ((VideoPlayParam)localObject).mSavePath = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
      ((VideoPlayParam)localObject).mFileID = (paramMessageForShortVideo.md5 + paramMessageForShortVideo.uniseq);
      ((VideoPlayParam)localObject).mUrls = paramArrayOfString;
      ((VideoPlayParam)localObject).mFileSize = paramMessageForShortVideo.videoFileSize;
      if (paramMessageForShortVideo.videoFileTime > 8) {
        break label320;
      }
      i = 1;
      label226:
      if (i == 0)
      {
        ((VideoPlayParam)localObject).mVideoFileTimeMs = (paramMessageForShortVideo.videoFileTime * 1000);
        ((VideoPlayParam)localObject).mMaxPlayTimeMs = 8000L;
      }
      paramagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setVideoParam((VideoPlayParam)localObject);
      paramMessageForShortVideo = a(paramInt1, paramInt2);
      if (!TextUtils.isEmpty(paramString2)) {
        break label326;
      }
      paramagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setCoverDrawable(paramMessageForShortVideo);
    }
    for (;;)
    {
      if (d()) {
        paramagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.play();
      }
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView);
      return;
      localObject = "null";
      break;
      label320:
      i = 0;
      break label226;
      label326:
      paramMessageForShortVideo = URLDrawable.getDrawable(ShortVideoUtils.a(paramString2), paramInt1, paramInt2, paramMessageForShortVideo, paramMessageForShortVideo);
      paramagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setCoverDrawable(paramMessageForShortVideo);
      paramagas.jdField_a_of_type_ComTencentImageURLDrawable = paramMessageForShortVideo;
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!bdew.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      bdew.a().a(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForShortVideo.frienduin, 1, 1, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Bundle paramBundle, MessageForReplyText paramMessageForReplyText)
  {
    if ((rlb.a(paramContext)) || (paramQQAppInterface.c()))
    {
      QQToast.a(paramContext, 0, 2131720131, 0).b(paramContext.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    if (!paramMessageForShortVideo.isSend()) {
      new axtc(BaseApplication.getContext()).a(paramQQAppInterface, 2002, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
    }
    boolean bool = bkbq.d(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startPlayerActivity() msg.videoAttr=" + paramMessageForShortVideo.videoAttr + ", msg.istroop=" + paramMessageForShortVideo.istroop + ", isSupportMultiVideoSwitch=" + Boolean.valueOf(bool));
    }
    bool = bkbp.a(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startPlayerActivity() msg.videoAttr=" + paramMessageForShortVideo.videoAttr + ", msg.istroop=" + paramMessageForShortVideo.istroop + ", isSupportHOTVideoSwitch=" + Boolean.valueOf(bool));
    }
    if (MediaPlayerManager.a(paramQQAppInterface).a()) {
      MediaPlayerManager.a(paramQQAppInterface).a(true);
    }
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity))) {
      paramBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().f());
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      paramBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      paramBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
    }
    label368:
    Object localObject;
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000))
    {
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
      if (paramMessageForReplyText == null) {
        break label772;
      }
      paramBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
      paramMessageForReplyText = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramMessageForReplyText.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)paramMessageForReplyText.next();
        if (((ActivityManager.RunningAppProcessInfo)localObject).processName.endsWith("mobileqq")) {
          paramBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", ((ActivityManager.RunningAppProcessInfo)localObject).pid);
        }
      }
      paramMessageForReplyText = paramMessageForShortVideo.selfuin;
      if (!paramMessageForShortVideo.isMultiMsg) {
        break label873;
      }
    }
    label772:
    label873:
    for (;;)
    {
      try
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        localObject = paramMessageForReplyText;
        if ((localAppRuntime instanceof QQAppInterface)) {
          localObject = localAppRuntime.getAccount();
        }
        paramMessageForReplyText = (MessageForReplyText)localObject;
      }
      catch (Exception localException)
      {
        int j;
        continue;
        if (!(paramContext instanceof ChatHistoryActivity)) {
          continue;
        }
        int i = 2;
        continue;
        i = j;
        if (!(paramContext instanceof PublicFragmentActivity)) {
          continue;
        }
        i = j;
        if (!(((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)) {
          continue;
        }
        i = 2;
        continue;
        biqe.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), agjb.a(paramMessageForShortVideo), -1, i);
        continue;
      }
      if (jdField_a_of_type_AndroidGraphicsRect != null) {
        paramBundle.putParcelable("KEY_THUMBNAL_BOUND", jdField_a_of_type_AndroidGraphicsRect);
      }
      paramBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      paramBundle.putString("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
      j = -1;
      if ((paramContext instanceof SplashActivity))
      {
        i = 1;
        localObject = (auqc)paramQQAppInterface.getManager(324);
        bool = ((auqc)localObject).a(paramMessageForShortVideo);
        paramBundle.putBoolean("extra.IS_SAVING_FILE", bool);
        if (bool)
        {
          localObject = ((auqc)localObject).a(((auqc)localObject).a(paramMessageForShortVideo));
          if ((localObject != null) && (((aupy)localObject).d == 1)) {
            paramBundle.putInt("extra.SAVE_FILE_PROGRESS", ((aupy)localObject).jdField_c_of_type_Int);
          }
        }
        if ((paramMessageForShortVideo.istroop != 0) || (!bdeu.b(paramMessageForShortVideo.senderuin)) || (TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type")))) {
          continue;
        }
        paramBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
        biqe.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), agjb.a(paramMessageForShortVideo), 13007, i);
        ((axwx)paramQQAppInterface.getManager(326)).a();
        if (!paramMessageForShortVideo.isSend()) {
          new axtc(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
        }
        awoa.b(paramQQAppInterface, paramMessageForShortVideo);
        return;
        paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
        break;
        paramBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForShortVideo.isMultiMsg);
        break label368;
      }
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, MessageForReplyText paramMessageForReplyText)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("muate_play", false);
    localBundle.putBoolean("is_one_item", true);
    localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean1);
    localBundle.putBoolean(biqe.b, paramBoolean2);
    a(paramMessageForShortVideo, paramLong, paramContext, paramQQAppInterface, paramSessionInfo, localBundle, paramMessageForReplyText);
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "handleVideoCompressSucceed, seq = " + paramMessageForShortVideo.uniseq);
    }
    azey localazey = azex.a().a(paramMessageForShortVideo.uniseq);
    if ((paramQQAppInterface != null) && (localazey != null)) {
      if (localazey.a() >= 104345600L)
      {
        paramMessageForShortVideo.videoFileStatus = 1005;
        paramMessageForShortVideo.serial();
        paramQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
        if (paramContext != null)
        {
          QQToast.a(paramContext, paramContext.getResources().getString(2131720111), 0).b(paramContext.getResources().getDimensionPixelSize(2131298914));
          paramContext = ((FragmentActivity)paramContext).getChatFragment();
          if (paramContext != null)
          {
            paramContext = paramContext.a();
            if (paramContext != null) {
              paramContext.b(false, false);
            }
          }
        }
        axwx.a(paramQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
        if ((jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong == null) || (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get() != paramMessageForShortVideo.uniseq)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoItemBuilder", 2, "CompressTask onPostExecute sRevokeMsRecord==mr.uniseq==" + paramMessageForShortVideo.uniseq + ", just return");
      return;
      paramQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
      paramContext = azdd.a(0, 0);
      paramMessageForShortVideo = azdd.a(paramMessageForShortVideo, paramContext);
      if (paramMessageForShortVideo != null)
      {
        paramMessageForShortVideo.i = localazey.a();
        paramMessageForShortVideo.jdField_a_of_type_Boolean = false;
        paramContext.a(paramMessageForShortVideo);
      }
      azdd.a(paramContext, paramQQAppInterface);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(-1L);
      return;
    }
    QLog.i("ShortVideoItemBuilder", 2, "CompressTask onPostExecute QQAppInterface is null...");
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, StringBuilder paramStringBuilder, int paramInt, String paramString, agas paramagas, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" sendFromLocal:false ");
    if (!bdhb.b(paramString))
    {
      paramStringBuilder.append(" videoPathExists:false ");
      if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9))
      {
        paramStringBuilder.append(" fileType:video, =" + ShortVideoUtils.a(paramMessageForShortVideo.fileType));
        if ((paramInt == 2005) && (paramMessageForShortVideo.isAllowAutoDown))
        {
          b(paramagas);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720140, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          paramStringBuilder.append(" result:toast recv_error ");
          return;
        }
        if (paramInt == 5001)
        {
          b(paramagas);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720138, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          paramStringBuilder.append(" result: toast file_unsafe ");
          return;
        }
        if (paramInt == 5002)
        {
          a(paramagas, 2131719276);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720139, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          paramStringBuilder.append(" result: toast file_expired ");
          return;
        }
        b(paramagas);
        a(paramMessageForShortVideo, paramLong, paramBoolean);
        paramStringBuilder.append(" status:other, result: download ");
        return;
      }
      if (paramInt == 5002)
      {
        a(paramagas, 2131719276);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720139, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        paramStringBuilder.append("fileType:not video,videoPathExits:false, result:toast file_expired ");
        return;
      }
      b(paramagas);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append("fileType:not video,videoPathExits:false, result: download");
      return;
    }
    b(paramagas);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append("videoPathExists:true, result:play ");
  }
  
  private boolean a(long paramLong)
  {
    return ((axwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong);
  }
  
  private boolean a(agas paramagas)
  {
    if (this.jdField_a_of_type_Auqc != null)
    {
      paramagas = this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_Auqc.a(paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage));
      return (paramagas != null) && (paramagas.d == 1) && (!paramagas.jdField_a_of_type_Boolean);
    }
    return false;
  }
  
  private boolean a(MessageForShortVideo paramMessageForShortVideo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageForShortVideo.videoFileStatus == 998)
    {
      bool1 = bool2;
      if (azex.a().a(paramMessageForShortVideo.uniseq) == null)
      {
        paramMessageForShortVideo = ShortVideoUtils.c(paramMessageForShortVideo.videoFileName, "mp4");
        if (!TextUtils.isEmpty(paramMessageForShortVideo)) {
          bdhb.d(paramMessageForShortVideo);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static Drawable b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    apkp localapkp = new apkp(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localapkp, localapkp);
        localURLDrawable.setTag(bcyz.b(0, 0, paramInt3));
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoItemBuilder", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, localException);
        }
      }
    }
    return localapkp;
  }
  
  private void b(agas paramagas, View paramView, ChatMessage paramChatMessage)
  {
    if (c(paramagas))
    {
      if (paramagas.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        paramagas.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramagas.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838162);
        paramagas.jdField_a_of_type_AndroidWidgetImageView.setId(2131364192);
        paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
        paramChatMessage.bottomMargin = aepi.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramChatMessage.addRule(8, 2131364173);
        paramChatMessage.addRule(0, 2131364173);
        paramChatMessage.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramagas.jdField_a_of_type_AndroidWidgetImageView, paramChatMessage);
        }
      }
      b(paramagas, true, this);
      return;
    }
    b(paramagas, false, null);
  }
  
  private void b(agas paramagas, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      if (paramagas.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        paramagas.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramagas.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      }
    }
    while (paramagas.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    paramagas.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramagas.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
  }
  
  public static void b(MessageForShortVideo paramMessageForShortVideo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "handleVideoCompressFailure, seq = " + paramMessageForShortVideo.uniseq);
    }
    if (paramQQAppInterface != null)
    {
      paramMessageForShortVideo.videoFileStatus = 1005;
      paramMessageForShortVideo.serial();
      paramQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
      axwx.a(paramQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    }
    if (paramContext != null) {}
  }
  
  private void b(MessageForShortVideo paramMessageForShortVideo, StringBuilder paramStringBuilder, int paramInt, String paramString, agas paramagas, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" sendFromLocal:true ");
    if (paramMessageForShortVideo.isMultiMsg) {
      paramMessageForShortVideo.extraflag = 32772;
    }
    if (bdhb.b(paramMessageForShortVideo.videoFileName))
    {
      paramStringBuilder.append(" localUploadPath Exists:true ");
      if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9))
      {
        paramStringBuilder.append(" fileType:video ");
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
        if (paramString != null)
        {
          if ((ShortVideoUploadProcessor.class.isInstance(paramString)) || (baxe.class.isInstance(paramString))) {
            if (paramInt == 1005)
            {
              b(paramagas);
              paramagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              paramStringBuilder.append(" status:send_error, result:show send error ");
            }
          }
          while (!baxb.class.isInstance(paramString))
          {
            return;
            if ((paramInt == 1002) || (paramInt == 1001))
            {
              a(paramMessageForShortVideo, paramLong, paramBoolean);
              paramStringBuilder.append(" status:process or start, result:pauseSending ");
              return;
            }
            b(paramagas);
            a(paramMessageForShortVideo, paramLong, paramBoolean);
            paramStringBuilder.append(" status:other, result:play ");
            return;
          }
          paramStringBuilder.append(" processor:not up of forward, result: none");
          return;
        }
        b(paramagas);
        a(paramMessageForShortVideo, paramLong, paramBoolean);
        paramStringBuilder.append(" processor:null, result:play ");
        return;
      }
      b(paramagas);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" fileType:not video, result: play ");
      return;
    }
    paramStringBuilder.append(" localUploadPath Exists:false ");
    if (!bdhb.b(ShortVideoUtils.a(paramMessageForShortVideo, "mp4")))
    {
      paramStringBuilder.append(" downloadPath Exists:false ");
      if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
        if (paramString != null)
        {
          boolean bool;
          if (baxb.class.isInstance(paramString))
          {
            bool = ((baxb)paramString).d();
            paramStringBuilder.append(" processor:download, pause:" + bool);
            if (bool)
            {
              b(paramagas);
              a(paramMessageForShortVideo, paramLong, paramBoolean);
              paramStringBuilder.append(" pause:true, result:download ");
              return;
            }
            if (paramInt == 2005)
            {
              b(paramagas);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720140, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
              paramStringBuilder.append(" status:recv_error, result:toast recv_error ");
              return;
            }
            if ((paramInt == 2002) || (paramInt == 2000) || (paramInt == 2008) || (paramInt == 2001))
            {
              b(paramagas);
              return;
            }
            if (paramInt == 5001)
            {
              b(paramagas);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720138, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
              paramStringBuilder.append(" status:file_unsafe, result:toast unsafe ");
              return;
            }
            if (paramInt == 5002)
            {
              a(paramagas, 2131719276);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720139, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
              paramStringBuilder.append(" status:file_expired, result:toast expired ");
              return;
            }
            b(paramagas);
            a(paramMessageForShortVideo, paramLong, paramBoolean);
            paramStringBuilder.append(" status:other, result:download ");
            return;
          }
          if (ShortVideoUploadProcessor.class.isInstance(paramString))
          {
            b(paramagas);
            paramagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720145, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
            paramStringBuilder.append(" processor:upload, result:show upload error and show toast");
            return;
          }
          if (baxe.class.isInstance(paramString))
          {
            bool = ((baxe)paramString).d();
            paramStringBuilder.append(" processor:forward, pause:" + bool);
            if (bool)
            {
              a(paramagas, 10, false);
              b(paramMessageForShortVideo, paramagas);
              paramStringBuilder.append(" pause:true, result:reforward ");
              return;
            }
            if (paramInt == 5001)
            {
              b(paramagas);
              paramagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720113, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
              paramStringBuilder.append(" status:unsafe, result:toast unsafe ");
              return;
            }
            if (paramInt == 5002)
            {
              a(paramagas, 2131719276);
              paramagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720114, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
              paramStringBuilder.append(" status:expired, result:toast expired ");
              return;
            }
            if (paramInt == 1005)
            {
              b(paramagas);
              paramagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              paramStringBuilder.append(" status:send_error, result:show send_error ");
              return;
            }
            if ((paramInt == 1002) || (paramInt == 1001))
            {
              a(paramMessageForShortVideo, 0L, paramBoolean);
              return;
            }
            b(paramagas);
            a(paramMessageForShortVideo, 0L, paramBoolean);
            paramStringBuilder.append(" status:other, result:plau ");
            return;
          }
          paramStringBuilder.append(" processor:not down or forward or up, result:none ");
          return;
        }
        b(paramagas);
        paramStringBuilder.append(" processor:null, result:download ");
        a(paramMessageForShortVideo, 0L, paramBoolean);
        return;
      }
      b(paramagas);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" fileType:not video, result:download ");
      return;
    }
    b(paramagas);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append(" downloadPath Exists:true，result:play ");
  }
  
  private boolean b(agas paramagas)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Auqc != null)
    {
      paramagas = this.jdField_a_of_type_Auqc.a(this.jdField_a_of_type_Auqc.a(paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage));
      if ((paramagas != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      bool1 = bool2;
      if (paramagas != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean b(MessageForShortVideo paramMessageForShortVideo)
  {
    return false;
  }
  
  private void c(agas paramagas)
  {
    if (c(paramagas))
    {
      if (paramagas.jdField_a_of_type_AndroidWidgetImageView != null) {
        break label20;
      }
      h();
    }
    label20:
    while (paramagas.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      return;
    }
    b(paramagas, true, this);
  }
  
  private void c(MessageForShortVideo paramMessageForShortVideo, agas paramagas)
  {
    int k = 1;
    aupy localaupy;
    int i;
    if ((this.jdField_a_of_type_Auqc != null) && (paramMessageForShortVideo != null) && (paramagas != null))
    {
      paramMessageForShortVideo = this.jdField_a_of_type_Auqc.a(paramMessageForShortVideo);
      localaupy = this.jdField_a_of_type_Auqc.a(paramMessageForShortVideo);
      if ((localaupy != null) && (localaupy.d == 1))
      {
        if (localaupy.jdField_c_of_type_Int >= 0) {
          break label188;
        }
        i = 0;
        j = k;
        if (paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getVisibility() != 8) {
          if ((paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getVisibility() != 0) || (paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.d != 2)) {
            break label213;
          }
        }
      }
    }
    label188:
    label213:
    for (int j = k;; j = 0)
    {
      if ((i < 100) && (j != 0) && (!localaupy.jdField_a_of_type_Boolean) && (localaupy.jdField_a_of_type_Aupx != null))
      {
        localaupy.jdField_a_of_type_Aupx.a(new agan(this, paramMessageForShortVideo, paramagas));
        this.jdField_a_of_type_Auqc.a(paramMessageForShortVideo, localaupy);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "dealVideoSaveUI showSaveProgress");
        }
        a(paramagas, i, false);
        paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      }
      return;
      if (localaupy.jdField_c_of_type_Int > 100)
      {
        i = 100;
        break;
      }
      i = localaupy.jdField_c_of_type_Int;
      break;
    }
  }
  
  private boolean c(agas paramagas)
  {
    boolean bool2 = true;
    if ((paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {
        return false;
      }
      int i;
      int j;
      if ((localMessageForShortVideo.videoFileStatus == 998) || (localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 1001))
      {
        i = 1;
        if ((localMessageForShortVideo.isMultiMsg) || (localMessageForShortVideo.uiOperatorFlag == 2) || (localMessageForShortVideo.busiType != 0) || (!localMessageForShortVideo.isSendFromLocal()) || (paramagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a())) {
          break label211;
        }
        j = 1;
        label109:
        if (QLog.isColorLevel())
        {
          paramagas = new StringBuilder().append("needShowPauseIcon seq:").append(localMessageForShortVideo.uniseq).append(", videostatus:").append(localMessageForShortVideo.videoFileStatus).append(", iconshow:");
          if ((i == 0) || (j == 0)) {
            break label216;
          }
          bool1 = true;
          QLog.i("ShortVideoItemBuilder", 2, bool1);
        }
        label168:
        if ((i == 0) || (j == 0) || (Build.VERSION.SDK_INT < 21)) {
          break label222;
        }
      }
      label211:
      label216:
      label222:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        return bool1;
        i = 0;
        break;
        j = 0;
        break label109;
        bool1 = false;
        break label168;
      }
    }
  }
  
  private boolean c(MessageForShortVideo paramMessageForShortVideo)
  {
    return azun.a().a(this.jdField_a_of_type_AndroidContentContext, 1, paramMessageForShortVideo.istroop);
  }
  
  private boolean d()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && ((this.jdField_a_of_type_AndroidViewViewGroup instanceof ChatXListView))) {
      return ((ChatXListView)this.jdField_a_of_type_AndroidViewViewGroup).a();
    }
    return true;
  }
  
  private boolean d(MessageForShortVideo paramMessageForShortVideo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageForShortVideo != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramMessageForShortVideo.md5)) {
        if (paramMessageForShortVideo.mPreUpload)
        {
          bool1 = bool2;
          if (TextUtils.isEmpty(paramMessageForShortVideo.mLocalMd5)) {}
        }
        else
        {
          String str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
          paramMessageForShortVideo = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
          bool1 = bool2;
          if (bdhb.b(str))
          {
            bool1 = bool2;
            if (bdhb.b(paramMessageForShortVideo)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "pauseAllVideo");
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
        if (localCropBubbleVideoView != null) {
          localCropBubbleVideoView.pause();
        }
      }
    }
  }
  
  public static void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "resumeAllVideo");
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
        if (localCropBubbleVideoView != null) {
          localCropBubbleVideoView.resume();
        }
      }
    }
  }
  
  public static void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "releaseAllVideo");
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
        if (localCropBubbleVideoView != null)
        {
          localCropBubbleVideoView.releasePlayer(false);
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localCropBubbleVideoView);
        }
      }
    }
  }
  
  private void h()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).a();
          if (localObject != null) {
            ((BaseChatPie)localObject).b(false, false);
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aeqh a(View paramView)
  {
    return null;
  }
  
  public aeqi a()
  {
    return new agas(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aetk paramaetk)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaetk);
    if ((paramChatMessage instanceof MessageForShortVideo)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramChatMessage);
    }
    a(paramChatMessage, paramView, this);
    a((agas)paramView.getTag(), paramView, paramChatMessage);
    b((agas)paramView.getTag(), paramView, paramChatMessage);
    if (e) {}
    try
    {
      paramChatMessage = (agas)paramView.getTag();
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append(paramChatMessage.jdField_a_of_type_AndroidWidgetTextView.getText());
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime);
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append("秒按钮");
      paramView.setContentDescription(paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.toString());
      return paramView;
    }
    catch (Exception paramChatMessage) {}
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView, message.uniseq = " + paramChatMessage.uniseq);
    }
    agas localagas = (agas)paramaeqi;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramBaseChatItemLayout = (MessageForShortVideo)paramChatMessage;
    boolean bool1 = paramBaseChatItemLayout.isSend();
    paramaeqi = paramView;
    int i;
    if (paramView == null)
    {
      paramaeqi = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = (CropBubbleVideoView)axaz.a(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout.uniseq, null, bool1);
      paramView.setId(2131362258);
      paramView.setVisibility(0);
      paramView.setContentDescription(alud.a(2131714421));
      paramaeqi.addView(paramView);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramView);
      VideoProgressView localVideoProgressView = new VideoProgressView(this.jdField_a_of_type_AndroidContentContext);
      localVideoProgressView.setId(2131364215);
      paramaeqi.addView(localVideoProgressView);
      ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 0);
      i = aepi.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      Object localObject2 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramaeqi.addView(localProgressBar, (ViewGroup.LayoutParams)localObject2);
      Object localObject3 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject3).setOrientation(1);
      ((LinearLayout)localObject3).setGravity(17);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramaeqi.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      Object localObject4 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject4).topMargin = aepi.a(70.0F, (Resources)localObject1);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setId(2131364213);
      ((TextView)localObject2).setVisibility(4);
      ((LinearLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      localObject3 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject3).setBackgroundResource(2130838947);
      localObject4 = new RelativeLayout.LayoutParams(-1, aepi.a(55.0F, (Resources)localObject1));
      ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131362258);
      ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131362258);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131362258);
      paramaeqi.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setTextSize(1, 12.0F);
      ((TextView)localObject4).setTextColor(-1);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).leftMargin = aepi.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject5).bottomMargin = aepi.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject5).addRule(9);
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout)localObject3).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject5).setTextSize(1, 12.0F);
      ((TextView)localObject5).setTextColor(-1);
      Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).rightMargin = aepi.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject6).bottomMargin = aepi.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject6).addRule(11);
      ((RelativeLayout.LayoutParams)localObject6).addRule(12);
      ((RelativeLayout)localObject3).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      localObject6 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject6).setTextSize(1, 14.0F);
      ((TextView)localObject6).setTextColor(-1);
      ((TextView)localObject6).setGravity(17);
      ((TextView)localObject6).setText(2131720132);
      ((TextView)localObject6).setShadowLayer(3.0F, 1.0F, 1.0F, -16777216);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = aepi.a(14.0F, (Resources)localObject1);
      localLayoutParams.addRule(14);
      paramaeqi.addView((View)localObject6, localLayoutParams);
      paramaeqi.setOnClickListener(this);
      super.a(paramaeqi, paramaetk);
      localagas.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
      localagas.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
      localagas.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      localagas.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject5);
      localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView = localVideoProgressView;
      localagas.c = ((TextView)localObject2);
      localagas.d = ((TextView)localObject6);
      localagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView = paramView;
    }
    localagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setTag(Long.valueOf(paramBaseChatItemLayout.uniseq));
    bdew.a().a(Long.valueOf(paramBaseChatItemLayout.uniseq), paramBaseChatItemLayout);
    if (localagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend != bool1)
    {
      localagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend = bool1;
      localagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.invalidate();
    }
    localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnClickListener(this);
    localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnTouchListener(paramaetk);
    localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnLongClickListener(paramaetk);
    localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setRadius(15.0F, true);
    localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setShowCorner(true);
    localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setSharpCornerCor(BubbleImageView.a);
    localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setCornerDirection(bool1);
    localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    awoa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout);
    paramView = (RelativeLayout.LayoutParams)localagas.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    label1017:
    int j;
    int k;
    if (bool1)
    {
      paramView.leftMargin = 0;
      paramView.rightMargin = aepi.a(localagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), (Resources)localObject1);
      paramView = (RelativeLayout.LayoutParams)localagas.d.getLayoutParams();
      if (!bool1) {
        break label1408;
      }
      paramView.rightMargin = (aepi.a(localagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), (Resources)localObject1) / 2);
      localagas.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramBaseChatItemLayout.videoFileTime * 1000));
      localagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView = ShortVideoUtils.a(paramBaseChatItemLayout.thumbMD5, "jpg");
      paramaetk = ShortVideoUtils.a(paramBaseChatItemLayout.thumbWidth, paramBaseChatItemLayout.thumbHeight);
      j = paramaetk[0];
      k = paramaetk[1];
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView, msg.uniseq = " + paramBaseChatItemLayout.uniseq + " msg.thumbWidth = " + paramBaseChatItemLayout.thumbWidth + ", msg.thumbHeight = " + paramBaseChatItemLayout.thumbHeight + ", adjustWidth = " + j + ", adjustHeight = " + k);
      }
      paramaetk = localagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getLayoutParams();
      if (paramaetk != null) {
        break label1430;
      }
      paramaetk = new RelativeLayout.LayoutParams(j, k);
      localagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramaetk);
      label1210:
      paramaetk = localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getLayoutParams();
      if (paramaetk != null) {
        break label1477;
      }
      paramaetk = new LinearLayout.LayoutParams(j, k);
      localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setLayoutParams(paramaetk);
      label1248:
      if (azdd.jdField_a_of_type_Boolean)
      {
        azdd.jdField_a_of_type_Long = System.currentTimeMillis();
        azdd.jdField_a_of_type_Boolean = false;
      }
      paramaetk = a(j, k);
      b(localagas);
      c(paramBaseChatItemLayout, localagas);
      if ((paramBaseChatItemLayout.md5 != null) || (paramBaseChatItemLayout.CheckIsHotVideo()) || (paramBaseChatItemLayout.isCancelStatus())) {
        break label1682;
      }
      if (paramBaseChatItemLayout.isSendFromLocal())
      {
        localagas.jdField_a_of_type_AndroidWidgetTextView.setText("");
        if (bdhb.b(paramView))
        {
          a(localagas, paramBaseChatItemLayout, paramView, j, k, false);
          if (paramBaseChatItemLayout.videoFileStatus != 1005) {
            break label1524;
          }
          localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(2);
          localagas.c.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      label1381:
      return paramaeqi;
      paramView.leftMargin = aepi.a(localagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), (Resources)localObject1);
      paramView.rightMargin = 0;
      break;
      label1408:
      paramView.leftMargin = (aepi.a(localagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), (Resources)localObject1) / 2);
      break label1017;
      label1430:
      if ((paramaetk.width == j) && (paramaetk.height == k)) {
        break label1210;
      }
      paramaetk.width = j;
      paramaetk.height = k;
      localagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramaetk);
      break label1210;
      label1477:
      if ((paramaetk.width == j) && (paramaetk.height == k)) {
        break label1248;
      }
      paramaetk.width = j;
      paramaetk.height = k;
      localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setLayoutParams(paramaetk);
      break label1248;
      label1524:
      localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      localagas.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      localagas.d.setVisibility(8);
      localagas.c.setVisibility(8);
      localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      if ((paramBaseChatItemLayout.videoFileStatus != 998) || (a(paramBaseChatItemLayout)))
      {
        paramChatMessage = new azey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, this);
        azex.a().a(paramBaseChatItemLayout.uniseq, paramChatMessage);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView(): msg.md5 == null, start compress task, id:" + paramBaseChatItemLayout.uniseq);
        }
      }
      paramChatMessage = azex.a().a(paramBaseChatItemLayout.uniseq);
      if (paramChatMessage == null) {
        continue;
      }
      paramChatMessage.a(this);
      return paramaeqi;
      label1682:
      localagas.c.setVisibility(8);
      localagas.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout.videoFileSize));
      localagas.d.setVisibility(8);
      if (bdhb.b(paramView))
      {
        if ((paramBaseChatItemLayout.videoFileStatus == 998) || (paramBaseChatItemLayout.videoFileStatus == 1001) || (paramBaseChatItemLayout.videoFileStatus == 1002) || (paramBaseChatItemLayout.videoFileStatus == 1004)) {}
        for (i = 1;; i = 0)
        {
          if ((c(paramBaseChatItemLayout)) && ((!paramBaseChatItemLayout.isSendFromLocal()) || (i == 0)) && (!b(localagas)) && (!b(paramBaseChatItemLayout)) && (!a(paramBaseChatItemLayout.uniseq))) {
            break label2166;
          }
          a(localagas, paramBaseChatItemLayout, paramView, j, k, false);
          localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
          label1852:
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "getBubbleView ，video no exits: sendFromLocal=" + paramBaseChatItemLayout.isSendFromLocal() + "===>  fileType:" + ShortVideoUtils.a(paramBaseChatItemLayout.fileType) + " ===> videoFileStatus:" + ShortVideoUtils.b(paramBaseChatItemLayout.videoFileStatus) + "===> videoFileProgress:" + paramBaseChatItemLayout.videoFileProgress + ", uniseq:" + paramBaseChatItemLayout.uniseq);
          }
          paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq);
          if ((paramBaseChatItemLayout.fileType != 6) && (paramBaseChatItemLayout.fileType != 17) && (paramBaseChatItemLayout.fileType != 9) && (paramBaseChatItemLayout.fileType != 19) && (paramBaseChatItemLayout.fileType != 20)) {
            break;
          }
          switch (paramBaseChatItemLayout.videoFileStatus)
          {
          default: 
            return paramaeqi;
          case 1001: 
            if (paramChatMessage != null) {
              break label3056;
            }
            localagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            b(localagas);
            if (!QLog.isColorLevel()) {
              break label1381;
            }
            QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_START, 上传开始被杀进程然后恢复, uniseq:" + paramBaseChatItemLayout.uniseq);
            return paramaeqi;
          }
        }
        label2166:
        paramaetk = ShortVideoUtils.a(paramBaseChatItemLayout, "mp4");
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView(): videoPath = " + paramaetk);
        }
        localObject1 = new File(paramaetk);
        long l1;
        label2253:
        label2264:
        boolean bool2;
        if (((File)localObject1).exists())
        {
          long l2 = ((File)localObject1).length();
          if (paramBaseChatItemLayout.videoFileTime <= 8)
          {
            l1 = paramBaseChatItemLayout.videoFileSize;
            if (l2 >= l1) {
              break label2427;
            }
            bool1 = true;
            bool2 = bool1;
            if (QLog.isColorLevel())
            {
              QLog.d("ShortVideoItemBuilder", 2, "===> 1 video file  exits, downloadedSize =" + l2 + ", estimatedSize=" + l1 + ", needDownload=" + bool1 + ",videoFileTime=" + paramBaseChatItemLayout.videoFileTime);
              bool2 = bool1;
            }
            label2341:
            if (!bool2) {
              break label2466;
            }
            if ((!bdin.h(this.jdField_a_of_type_AndroidContentContext)) || (paramBaseChatItemLayout.videoFileStatus == 5002)) {
              break label2454;
            }
            paramChatMessage = azdd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, 2);
            if (paramChatMessage != null) {
              azdd.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
          }
        }
        for (;;)
        {
          a(localagas, paramBaseChatItemLayout, paramView, j, k, true);
          break;
          l1 = rjm.a(8, paramBaseChatItemLayout.videoFileTime, paramBaseChatItemLayout.videoFileSize);
          break label2253;
          label2427:
          bool1 = false;
          break label2264;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "===> 2 video file no exits, need download video.");
          }
          bool2 = true;
          break label2341;
          label2454:
          localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
        }
        label2466:
        a(localagas, true, paramBaseChatItemLayout, paramaetk, null, paramView, j, k);
        if (paramBaseChatItemLayout.videoFileTime <= 8)
        {
          i = 1;
          label2496:
          a(localagas);
          if (i == 0) {
            localagas.d.setVisibility(0);
          }
          if ((paramBaseChatItemLayout.CheckIsHotVideo()) && (!bdew.a().a(paramBaseChatItemLayout, "0X8007EDB")))
          {
            bdew.a().a(paramBaseChatItemLayout, "0X8007EDB");
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
          }
          if (bdew.a().a(paramBaseChatItemLayout, "0X80077D9")) {
            continue;
          }
          i = ntd.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          paramView = new JSONObject();
        }
      }
      try
      {
        paramView.put("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramView.put("memNum", i);
        paramView.put("msg_uniseq", paramChatMessage.uniseq);
        nrt.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", ntd.a(paramBaseChatItemLayout.getMd5(), null, null, null, paramView), false);
        bdew.a().a(paramBaseChatItemLayout, "0X80077D9");
        return paramaeqi;
        i = 0;
        break label2496;
        if (((paramBaseChatItemLayout.fileType == 7) || (paramBaseChatItemLayout.fileType == 18) || (paramBaseChatItemLayout.fileType == 16)) && (paramBaseChatItemLayout.videoFileStatus == 5002))
        {
          localagas.d.setVisibility(8);
          localagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramBaseChatItemLayout.uniseq);
          localagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramaetk);
          a(localagas, 2131719276);
          if (!QLog.isColorLevel()) {
            break label1852;
          }
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not download pic : 缩略图不存在，而且文件已经过期，不下载, , uniseq:" + paramBaseChatItemLayout.uniseq);
          break label1852;
        }
        if ((paramBaseChatItemLayout.extraflag == 32768) || (b(localagas))) {
          break label1852;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not SendFromLocal : 缩略图不存在，开始下载缩略图, , uniseq:" + paramBaseChatItemLayout.uniseq);
        }
        localagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramBaseChatItemLayout.uniseq);
        localagas.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramaetk);
        paramChatMessage = azdd.a(2, this.jdField_c_of_type_Int);
        paramView = paramBaseChatItemLayout.getDownloadInfo(paramChatMessage.jdField_b_of_type_Int);
        paramView.i = ShortVideoUtils.a(paramBaseChatItemLayout.thumbMD5, "jpg");
        if ((paramBaseChatItemLayout.istroop == 0) || (paramBaseChatItemLayout.istroop == 1008)) {
          paramView.e = 1002;
        }
        for (;;)
        {
          paramView.f = 2;
          paramChatMessage.a(paramView);
          paramChatMessage.a(paramBaseChatItemLayout);
          azdd.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
          if (paramBaseChatItemLayout.istroop == 3000) {
            paramView.e = 1006;
          } else if (paramBaseChatItemLayout.istroop == 1) {
            paramView.e = 1004;
          }
        }
        label3056:
        a(localagas, ShortVideoUtils.a(paramBaseChatItemLayout.videoFileProgress, 10), false);
        return paramaeqi;
        localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
        localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(localagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + localagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        b(localagas);
        a(localagas, true, this);
        return paramaeqi;
        if (paramChatMessage == null)
        {
          localagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          b(localagas);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_PROCESS, 上传过程中被杀进程然后恢复, uniseq:" + paramBaseChatItemLayout.uniseq);
          return paramaeqi;
        }
        if (((axwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).b(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq))
        {
          localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(10, paramBaseChatItemLayout.frienduin + paramBaseChatItemLayout.uniseq);
          localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
          return paramaeqi;
        }
        i = paramBaseChatItemLayout.videoFileProgress;
        if ((paramChatMessage instanceof ShortVideoUploadProcessor))
        {
          paramChatMessage = (ShortVideoUploadProcessor)paramChatMessage;
          if (paramChatMessage.a() != 0L)
          {
            i = (int)(100L * paramChatMessage.b() / paramChatMessage.a());
            a(localagas, ShortVideoUtils.a(i, 10), false);
            return paramaeqi;
            b(localagas);
            return paramaeqi;
            b(localagas);
            return paramaeqi;
            b(localagas);
            return paramaeqi;
            b(localagas);
            return paramaeqi;
            a(localagas, 2131719276);
            return paramaeqi;
          }
        }
      }
      catch (Exception paramChatMessage)
      {
        for (;;) {}
      }
    }
  }
  
  public bdpi a(bdpi parambdpi, ChatMessage paramChatMessage, aeqz paramaeqz)
  {
    boolean bool3 = false;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramaeqz = (agas)paramaeqz;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.a(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForShortVideo.videoFileStatus));
    }
    b(parambdpi, this.jdField_a_of_type_AndroidContentContext);
    int i;
    boolean bool1;
    label221:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramChatMessage = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (bdhb.b(paramChatMessage))
      {
        paramChatMessage = "";
        i = 1;
        if (i == 0) {
          break label485;
        }
        if (!"1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"))) {
          break label472;
        }
        boolean bool4 = localMessageForShortVideo.checkForward();
        if ((paramaeqz.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView == null) || (!paramaeqz.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramaeqz.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaeqz.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
          break label479;
        }
        bool1 = true;
        bool2 = bool3;
        if (paramaeqz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
        {
          bool2 = bool3;
          if (paramaeqz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
            bool2 = true;
          }
        }
        if ((!bool4) || (bool1) || (bool2)) {
          break label432;
        }
        parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
        paramChatMessage = paramChatMessage + "inMiddleStatus = false, progeressBarShowing = false, errorIconShowing = false, show forward menu.";
      }
    }
    label432:
    label472:
    label479:
    label485:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getMenuItem: " + paramChatMessage);
      }
      if ((localMessageForShortVideo != null) && (bdhb.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))) {
        parambdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692401), 2130838677);
      }
      this.f = true;
      return parambdpi;
      paramChatMessage = "thumbFilePath=" + paramChatMessage + " , not exits.";
      i = 0;
      break;
      paramChatMessage = " msg == null or md5 is empty.";
      i = 0;
      break;
      paramChatMessage = paramChatMessage + "progeressBarShowing=" + bool1 + ", errorIconShowing=" + bool2;
      continue;
      paramChatMessage = " not inDPCWhiteList.";
      continue;
      bool1 = false;
      break label221;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (bdil.a(paramChatMessage.issend)) {
      return alud.a(2131714429);
    }
    return alud.a(2131714481);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_Bdjz != null) && (this.jdField_a_of_type_Bdjz.isShowing()))
    {
      this.jdField_a_of_type_Bdjz.dismiss();
      this.jdField_a_of_type_Bdjz = null;
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
        if (localCropBubbleVideoView != null)
        {
          long l = localCropBubbleVideoView.getCurPlayingPos();
          if (l > 0L)
          {
            MessageForShortVideo localMessageForShortVideo = bdew.a().a(Integer.valueOf(localCropBubbleVideoView.getId()));
            if (localMessageForShortVideo != null) {
              a(localMessageForShortVideo, l);
            }
          }
          localCropBubbleVideoView.releasePlayer(false);
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localCropBubbleVideoView);
        }
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForShortVideo)) {}
    label672:
    label675:
    for (;;)
    {
      return;
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      this.d = paramInt;
      if (paramInt == 2131365071)
      {
        acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
      }
      if (paramInt == 2131370861)
      {
        super.d(paramChatMessage);
        return;
      }
      if (paramInt == 2131366760)
      {
        b(localMessageForShortVideo);
        if (paramChatMessage.isMultiMsg) {
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 6, 0, "6", "", "", "");
        }
      }
      else if (paramInt == 2131366017)
      {
        if (d((MessageForShortVideo)paramChatMessage))
        {
          biva.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
          bivo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
          if (paramChatMessage.isMultiMsg) {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 6, 0, "6", "", "", "");
          }
        }
      }
      else
      {
        if (paramInt == 2131370818)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked(): msg_revoke =>" + localMessageForShortVideo.toLogString());
          }
          if (localMessageForShortVideo.md5 == null)
          {
            azex.a().b(localMessageForShortVideo.uniseq);
            jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(localMessageForShortVideo.uniseq);
            ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(20)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
            axwx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
            return;
          }
          paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
          if ((paramContext == null) || ((!ShortVideoUploadProcessor.class.isInstance(paramContext)) && (!baxe.class.isInstance(paramContext)))) {
            break label672;
          }
          boolean bool = ((barf)paramContext).d();
          paramInt = localMessageForShortVideo.videoFileStatus;
          if ((!bool) && (paramInt != 1002) && (paramInt != 1001)) {
            break label672;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
          ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(20)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked: stop uploading short video");
          }
        }
        for (paramInt = 0;; paramInt = 1)
        {
          if (paramInt == 0) {
            break label675;
          }
          super.a(localMessageForShortVideo);
          return;
          if (paramInt == 2131370921)
          {
            paramContext = a(paramChatMessage.uniseq);
            if (paramContext == null)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("ShortVideoItemBuilder", 2, "onMenuItemClicked(), mute_play, holder == null, message.uniseq = " + paramChatMessage.uniseq);
              return;
            }
            a(paramContext, true);
            azqs.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 2, 0, "", "", "", "");
            return;
          }
          super.a(paramInt, paramContext, paramChatMessage);
          return;
        }
      }
    }
  }
  
  public void a(agas paramagas)
  {
    if (a(paramagas)) {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "disProgress...file is saving, so return!");
      }
    }
    do
    {
      return;
      if (!a(paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "disProgress fail...video order sending! " + paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return;
    if (!paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
      return;
    }
    paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimRunnableListener(new agam(this, paramagas));
  }
  
  protected void a(agas paramagas, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 100)
    {
      paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(paramInt, paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    for (;;)
    {
      paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVideoCompressStatus(false);
      paramagas.c.setVisibility(8);
      return;
      paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(paramInt, paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (agas)aepi.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      bhuf localbhuf = (bhuf)bhus.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbhuf.a(2131690042, 5);
      localbhuf.c(2131690648);
      localbhuf.a(new agar(this, localMessageForShortVideo, paramView, localbhuf));
      localbhuf.show();
      if (localMessageForShortVideo.videoFileStatus == 1004) {
        ShortVideoUtils.c("0X800A374", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(View paramView, bass parambass, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = (agas)aepi.a(paramView);
        paramView = (MessageForShortVideo)((agas)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject2 = ((agas)localObject1).jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView;
        if (paramView.uniseq != parambass.jdField_b_of_type_Long) {
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.e("ShortVideoItemBuilder", 2, "handleMessage getHolder error ! ", paramView);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "handleMessage msg.uniseq:" + paramView.uniseq + ",fileType:" + ShortVideoUtils.a(parambass.jdField_b_of_type_Int) + " ===> fileStatus:" + ShortVideoUtils.b(parambass.d));
      }
      paramInt2 = 0;
      paramInt1 = 0;
      if ((parambass.jdField_b_of_type_Int == 6) || (parambass.jdField_b_of_type_Int == 17) || (parambass.jdField_b_of_type_Int == 9) || (parambass.jdField_b_of_type_Int == 20)) {}
      switch (parambass.d)
      {
      default: 
      case 1001: 
        if (parambass.jdField_a_of_type_Long != 0L) {
          paramInt1 = (int)(100L * parambass.e / parambass.jdField_a_of_type_Long);
        }
        a((agas)localObject1, ShortVideoUtils.a(paramInt1, 10), true);
        ((agas)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        c((agas)localObject1);
        return;
      case 1003: 
        a((agas)localObject1, 100, true);
        b((agas)localObject1);
        b((agas)localObject1, false, null);
        azex.a().a(((agas)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1005: 
        b((agas)localObject1);
        ((agas)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        azex.a().a(((agas)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1004: 
        ((agas)localObject1).jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(((agas)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + ((agas)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        b((agas)localObject1);
        a((agas)localObject1, true, this);
        azex.a().a(((agas)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1007: 
        b((agas)localObject1);
        b((agas)localObject1, false, null);
        azex.a().a(((agas)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1002: 
        if (!paramView.isSendFromLocal()) {
          continue;
        }
        if (parambass.jdField_a_of_type_Long != 0L) {
          paramInt1 = (int)(100L * parambass.e / parambass.jdField_a_of_type_Long);
        }
        for (;;)
        {
          a((agas)localObject1, ShortVideoUtils.a(paramInt1, 10), true);
          return;
          paramInt1 = paramInt2;
          if (QLog.isColorLevel())
          {
            QLog.e("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS: fileSize == 0 ");
            paramInt1 = paramInt2;
          }
        }
      case 2001: 
        b((agas)localObject1);
        ((agas)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        return;
      case 2003: 
        b((agas)localObject1);
        if (b((agas)localObject1)) {
          continue;
        }
        parambass = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
        if (bdhb.b(parambass)) {
          continue;
        }
        localObject1 = azdd.a(2, this.jdField_c_of_type_Int);
        localObject2 = paramView.getDownloadInfo(((azdx)localObject1).jdField_b_of_type_Int);
        ((azdg)localObject2).i = parambass;
        if ((paramView.istroop == 0) || (paramView.istroop == 1008)) {
          ((azdg)localObject2).e = 1002;
        }
        for (;;)
        {
          ((azdx)localObject1).a((azdg)localObject2);
          ((azdx)localObject1).a(paramView);
          azdd.a((azdx)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
          if (paramView.istroop == 3000) {
            ((azdg)localObject2).e = 1006;
          } else if (paramView.istroop == 1) {
            ((azdg)localObject2).e = 1004;
          }
        }
      case 2005: 
        b((agas)localObject1);
        if (parambass.g == -5100528) {
          continue;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720140, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        return;
      case 5001: 
        a((agas)localObject1, 2131719275);
        if (paramView.uiOperatorFlag == 2)
        {
          ((agas)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720113, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          return;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720138, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        return;
      case 5002: 
        a((agas)localObject1, 2131719276);
        if (paramView.uiOperatorFlag == 2)
        {
          ((agas)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720114, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          return;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720139, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        return;
      case 2004: 
        b((agas)localObject1);
        return;
      case 2002: 
        b((agas)localObject1);
        a((agas)localObject1);
        if ((parambass.c == null) || (!c(paramView)) || (b((agas)localObject1)) || (b(paramView))) {
          continue;
        }
        localObject2 = parambass.c;
        parambass = parambass.u;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_RECV_PROCESS: domain=" + parambass + ", videoUrls=" + Arrays.toString((Object[])localObject2));
        }
        Object localObject3 = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
        int[] arrayOfInt = ShortVideoUtils.a(paramView.thumbWidth, paramView.thumbHeight);
        paramInt2 = arrayOfInt[0];
        int i = arrayOfInt[1];
        paramInt1 = 0;
        while (paramInt1 < 1)
        {
          if (!TextUtils.isEmpty(parambass)) {
            localObject2[paramInt1] = (localObject2[paramInt1] + "&txhost=" + parambass);
          }
          paramInt1 += 1;
        }
        a((agas)localObject1, false, paramView, null, (String[])localObject2, (String)localObject3, paramInt2, i);
        if ((paramView.CheckIsHotVideo()) && (!bdew.a().a(paramView, "0X8007EDB")))
        {
          bdew.a().a(paramView, "0X8007EDB");
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
        }
        if (bdew.a().a(paramView, "0X80077D9")) {
          continue;
        }
        paramInt1 = ntd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        parambass = new JSONObject();
        try
        {
          parambass.put("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          parambass.put("memNum", paramInt1);
          parambass.put("msg_uniseq", paramView.uniseq);
          label1306:
          nrt.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", ntd.a(paramView.getMd5(), null, null, null, parambass), false);
          bdew.a().a(paramView, "0X80077D9");
          return;
          if ((parambass.jdField_b_of_type_Int != 7) && (parambass.jdField_b_of_type_Int != 18) && (parambass.jdField_b_of_type_Int != 16)) {
            continue;
          }
          switch (parambass.d)
          {
          default: 
          case 2001: 
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_START:");
            return;
          case 2003: 
            parambass = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
            localObject2 = ShortVideoUtils.a(paramView.thumbWidth, paramView.thumbHeight);
            paramInt2 = localObject2[0];
            i = localObject2[1];
            if ((!c(paramView)) || (b((agas)localObject1)) || (b(paramView))) {
              continue;
            }
            localObject2 = ShortVideoUtils.a(paramView, "mp4");
            localObject3 = new File((String)localObject2);
            long l1;
            if (((File)localObject3).exists())
            {
              long l2 = ((File)localObject3).length();
              if (paramView.videoFileTime <= 8)
              {
                l1 = paramView.videoFileSize;
                if (l2 < l1) {
                  break label1638;
                }
                paramInt1 = 0;
              }
            }
            for (;;)
            {
              if (paramInt1 == 0) {
                break label1648;
              }
              if (bdin.h(this.jdField_a_of_type_AndroidContentContext))
              {
                localObject2 = azdd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, 2);
                if (localObject2 != null) {
                  azdd.a((azdx)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                }
              }
              a((agas)localObject1, paramView, parambass, paramInt2, i, true);
              return;
              l1 = rjm.a(8, paramView.videoFileTime, paramView.videoFileSize);
              break;
              paramInt1 = 1;
              continue;
              paramInt1 = 1;
            }
            if (paramView.videoFileTime <= 8) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              a((agas)localObject1, true, paramView, (String)localObject2, null, parambass, paramInt2, i);
              a((agas)localObject1);
              if (paramInt1 == 0) {
                break;
              }
              ((agas)localObject1).d.setVisibility(8);
              return;
            }
            ((agas)localObject1).d.setVisibility(0);
            return;
          case 2005: 
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_ERROR:");
            return;
          case 5002: 
            label1638:
            label1648:
            parambass = ShortVideoUtils.a(paramView.thumbWidth, paramView.thumbHeight);
            paramInt1 = parambass[0];
            paramInt2 = parambass[1];
            ((agas)localObject1).jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramView.uniseq);
            ((agas)localObject1).jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(a(paramInt1, paramInt2));
            a((agas)localObject1, 2131719276);
            ((agas)localObject1).d.setVisibility(8);
            return;
          }
        }
        catch (Exception localException)
        {
          break label1306;
        }
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296300);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, i, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, float paramFloat)
  {
    agas localagas = a(paramMessageForShortVideo);
    if (localagas == null) {
      return;
    }
    paramMessageForShortVideo = paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq;
    localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(alud.a(2131714457), paramMessageForShortVideo);
    localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramMessageForShortVideo, paramFloat);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "CompressUpdateListener,onFinish. seq = " + paramMessageForShortVideo.uniseq);
    }
    bhta.a(new ShortVideoItemBuilder.4(this, paramMessageForShortVideo, paramInt));
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 998) {
      return;
    }
    if ((TextUtils.isEmpty(paramMessageForShortVideo.md5)) || (paramMessageForShortVideo.videoFileStatus == 1004))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720103, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    String str = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    boolean bool2 = NetworkUtils.isMobileConnected(this.jdField_a_of_type_AndroidContentContext);
    if ((azdd.jdField_a_of_type_Long != 0L) && (System.currentTimeMillis() - azdd.jdField_a_of_type_Long < 300000L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "startPlayVideo isConfirmed=" + bool1 + " allowPlayInXGTime=" + azdd.jdField_a_of_type_Long + " isXGConnected = " + bool2);
      }
      if ((!bool2) || (bool1) || ((bdhb.a(str)) && (paramMessageForShortVideo.videoFileStatus != 2002)) || (paramMessageForShortVideo.videoFileSize < 1048576)) {
        break label348;
      }
      if (!bezm.a((Activity)this.jdField_a_of_type_AndroidContentContext, 3, new agao(this, paramMessageForShortVideo, paramLong, paramBoolean))) {
        break;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131718909);
      this.jdField_a_of_type_Bdjz = bdgm.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131718912), str, this.jdField_a_of_type_AndroidContentContext.getString(2131718910), this.jdField_a_of_type_AndroidContentContext.getString(2131718911), new agap(this, paramMessageForShortVideo, paramLong, paramBoolean), new agaq(this));
      paramMessageForShortVideo = atzp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
      if ((paramMessageForShortVideo instanceof SpannableString)) {
        this.jdField_a_of_type_Bdjz.setMessageWithoutAutoLink(paramMessageForShortVideo);
      }
      try
      {
        this.jdField_a_of_type_Bdjz.show();
        return;
      }
      catch (Throwable paramMessageForShortVideo)
      {
        return;
      }
    }
    label348:
    b(paramMessageForShortVideo, paramLong, paramBoolean);
    ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E53", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageForShortVideo, this.jdField_a_of_type_AndroidContentContext);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, agas paramagas)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    boolean bool = paramMessageForShortVideo.CheckIsHotVideo();
    String str1 = paramMessageForShortVideo.videoFileName;
    String str2 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if ((!bdhb.b(str1)) && (!bool))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131720145, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      b(paramagas);
      paramagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if ((!bdhb.b(str2)) && (!bool))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131720146, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      b(paramagas);
      paramagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((axwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    paramagas = azdd.a(1, this.jdField_c_of_type_Int);
    paramMessageForShortVideo = azdd.a(this.jdField_c_of_type_Int, paramMessageForShortVideo, paramagas);
    paramMessageForShortVideo.e = bool;
    paramagas.a(paramMessageForShortVideo);
    azdd.a(paramagas, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    agas localagas = a(paramMessageForShortVideo);
    if (localagas == null) {
      return;
    }
    bhta.a(new ShortVideoItemBuilder.3(this, paramMessageForShortVideo, paramBoolean, localagas));
  }
  
  void a(String paramString, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo.CheckIsHotVideo()) && (QLog.isColorLevel()))
    {
      paramMessageForShortVideo = "logHotVideoError ";
      if (paramString != null) {
        paramMessageForShortVideo = "logHotVideoError " + paramString;
      }
      QLog.d("ShortVideoItemBuilder", 2, paramMessageForShortVideo);
    }
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramChatMessage.isMultiMsg) {}
    do
    {
      do
      {
        return false;
      } while (!paramChatMessage.isSendFromLocal());
      paramChatMessage = (MessageForShortVideo)paramChatMessage;
      if (paramChatMessage.videoFileStatus == 1005)
      {
        a("2131 msg.videoFileStatus == FileMsg.STATUS_SEND_ERROR", paramChatMessage);
        return true;
      }
    } while (paramChatMessage.md5 == null);
    int i;
    if (paramChatMessage.uiOperatorFlag == 2) {
      if ((paramChatMessage.videoFileStatus == 5002) || (paramChatMessage.videoFileStatus == 5001))
      {
        i = 1;
        k = i;
        if (i != 0) {
          a("2145 forwardError = true msg.videoFileStatus is " + paramChatMessage.videoFileStatus, paramChatMessage);
        }
      }
    }
    for (int k = i;; k = 0)
    {
      if ((paramChatMessage.videoFileStatus == 1005) || (paramChatMessage.extraflag == 32768)) {
        a("2151 msg.extraflag == MessageRecordInfo.EXTRA_FLAG_SEND_FAIL sendError = true", paramChatMessage);
      }
      for (int j = 1;; j = 0)
      {
        i = j;
        if (paramChatMessage.uiOperatorFlag == 1)
        {
          i = j;
          if (paramChatMessage.videoFileStatus == 1004)
          {
            a("2152 msg send cancel:", paramChatMessage);
            i = 1;
          }
        }
        j = i;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq) == null)
        {
          if (!paramChatMessage.CheckIsHotVideo()) {
            break label361;
          }
          j = i;
          if (paramChatMessage.videoFileProgress != 100)
          {
            j = i;
            if (paramChatMessage.videoFileStatus != 1003)
            {
              j = i;
              if (paramChatMessage.videoFileStatus != 1004)
              {
                j = i;
                if (paramChatMessage.videoFileStatus != 2009)
                {
                  j = i;
                  if (paramChatMessage.uiOperatorFlag != 2)
                  {
                    j = i;
                    if (paramChatMessage.videoFileStatus != 2003)
                    {
                      j = i;
                      if (paramChatMessage.videoFileStatus != 2002)
                      {
                        a("2164 msg.videoFileProgress = " + paramChatMessage.videoFileProgress + " msg.videoFileStatus = " + paramChatMessage.videoFileStatus, paramChatMessage);
                        j = 1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          if ((k == 0) && (j == 0)) {
            break label464;
          }
          return true;
          i = 0;
          break;
          label361:
          j = i;
          if (paramChatMessage.videoFileProgress != 100)
          {
            j = i;
            if (paramChatMessage.videoFileStatus != 1003)
            {
              j = i;
              if (paramChatMessage.videoFileStatus != 1004)
              {
                j = i;
                if (paramChatMessage.videoFileStatus != 2009)
                {
                  j = i;
                  if (paramChatMessage.uiOperatorFlag != 2)
                  {
                    j = i;
                    if (paramChatMessage.videoFileStatus != 2003)
                    {
                      j = i;
                      if (paramChatMessage.videoFileStatus != 998)
                      {
                        j = i;
                        if (paramChatMessage.isAllowAutoDown == true) {
                          j = 1;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label464:
        break;
      }
    }
  }
  
  public bdpk[] a(View paramView)
  {
    paramView = (agas)aepi.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bdpi localbdpi = new bdpi();
    if (localMessageForShortVideo != null)
    {
      if (!localMessageForShortVideo.isMultiMsg) {
        break label48;
      }
      a(localbdpi, localMessageForShortVideo, paramView);
    }
    for (;;)
    {
      return localbdpi.a();
      label48:
      b(localbdpi, localMessageForShortVideo, paramView);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public bdpi b(bdpi parambdpi, ChatMessage paramChatMessage, aeqz paramaeqz)
  {
    boolean bool3 = false;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    agas localagas = (agas)paramaeqz;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.a(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForShortVideo.videoFileStatus));
    }
    b(parambdpi, this.jdField_a_of_type_AndroidContentContext);
    int i;
    boolean bool1;
    label226:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramaeqz = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (bdhb.b(paramaeqz))
      {
        paramaeqz = "";
        i = 1;
        if (i == 0) {
          break label574;
        }
        if (!"1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"))) {
          break label561;
        }
        boolean bool4 = localMessageForShortVideo.checkForward();
        if ((localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView == null) || (!localagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(localagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + localagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
          break label568;
        }
        bool1 = true;
        bool2 = bool3;
        if (localagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
        {
          bool2 = bool3;
          if (localagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
            bool2 = true;
          }
        }
        if ((!bool4) || (bool1) || (bool2)) {
          break label521;
        }
        parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
        paramaeqz = paramaeqz + "inMiddleStatus = false, progeressBarShowing = false, errorIconShowing = false, show forward menu.";
      }
    }
    label521:
    label561:
    label568:
    label574:
    for (;;)
    {
      a(localMessageForShortVideo, parambdpi);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getMenuItem: " + paramaeqz);
      }
      if ((localMessageForShortVideo != null) && ((localagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (localagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0))) {
        a(parambdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForShortVideo);
      }
      a(parambdpi, localMessageForShortVideo);
      if ((localMessageForShortVideo != null) && (bdhb.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))) {
        parambdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692401), 2130838677);
      }
      b(paramChatMessage, parambdpi);
      super.c(parambdpi, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
      this.f = true;
      return parambdpi;
      paramaeqz = "thumbFilePath=" + paramaeqz + " , not exits.";
      i = 0;
      break;
      paramaeqz = " msg == null or md5 is empty.";
      i = 0;
      break;
      paramaeqz = paramaeqz + "progeressBarShowing=" + bool1 + ", errorIconShowing=" + bool2;
      continue;
      paramaeqz = " not inDPCWhiteList.";
      continue;
      bool1 = false;
      break label226;
    }
  }
  
  protected void b(agas paramagas)
  {
    if (a(paramagas)) {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "hideProgress...file is saving, so return!");
      }
    }
    do
    {
      return;
      if (!a(paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "hideProgress fail...video order sending! " + paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return;
    paramagas.c.setVisibility(8);
    if (!paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagas.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(2);
      return;
    }
    paramagas.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimRunnableListener(new agaj(this, paramagas));
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "Forward menu clicked, md5 is empty.");
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 21);
    localBundle.putBoolean("forward_is_long_video", true);
    localBundle.putBoolean("forward_need_sendmsg", true);
    String str1 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localBundle.putString("forward_thumb", str1);
    localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
    localBundle.putString("from_uin", ShortVideoUtils.d(paramMessageForShortVideo));
    localBundle.putInt("from_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localBundle.putString("from_session_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    String str2 = ShortVideoUtils.c(paramMessageForShortVideo);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "Forward menu clicked, videoPath=" + str2 + ",videoPath = " + str2 + ", " + paramMessageForShortVideo.toLogString());
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
    localBundle.putInt("special_video_type", paramMessageForShortVideo.specialVideoType);
    localBundle.putInt("short_video_msg_tail_type", paramMessageForShortVideo.msgTailType);
    localBundle.putLong("from_msg_uniseq", paramMessageForShortVideo.uniseq);
    if (paramMessageForShortVideo.CheckIsHotVideo())
    {
      localBundle.putString("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
      localBundle.putString("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
      localBundle.putString("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
      localBundle.putString("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
    }
    localBundle.putParcelable("key_message_for_shortvideo", paramMessageForShortVideo);
    if (!TextUtils.isEmpty(paramMessageForShortVideo.templateId))
    {
      localBundle.putString("widgetinfo", paramMessageForShortVideo.templateId);
      localBundle.putString("key_camera_material_name", paramMessageForShortVideo.templateName);
    }
    if (bdhb.b(str2))
    {
      localBundle.putBoolean("k_dataline", true);
      localBundle.putString("forward_extra", str2);
      localBundle.putBoolean("direct_send_if_dataline_forward", true);
      localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    paramMessageForShortVideo = new Intent();
    paramMessageForShortVideo.putExtras(localBundle);
    aryv.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "1", "", "");
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("muate_play", paramBoolean);
    a(paramMessageForShortVideo, paramLong, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localBundle, null);
    ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, agas paramagas)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "reForwardVideo：" + paramMessageForShortVideo.toString());
      }
      if (!bdhb.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131720146, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        b(paramagas);
        paramagas.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        ((axwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
        paramagas = azdd.a(4, this.jdField_c_of_type_Int);
        paramagas.a(azdd.a(this.jdField_c_of_type_Int, paramMessageForShortVideo, paramagas));
        azdd.a(paramagas, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoItemBuilder", 2, "ShortVideoItemBuilder:reForwardVideo() path is empty");
  }
  
  public void d()
  {
    super.d();
    this.d = -1;
    this.f = false;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    Object localObject1 = (agas)aepi.a(paramView);
    jdField_a_of_type_AndroidGraphicsRect = a(paramView, (MessageForShortVideo)((agas)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    aepi.n = true;
    long l = System.currentTimeMillis();
    if ((l - jdField_c_of_type_Long < 1000L) && (l > jdField_c_of_type_Long)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoItemBuilder", 2, "click too offen,please try again later ");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          jdField_c_of_type_Long = l;
          if ((paramView.getId() == 2131364173) || (paramView.getId() == 2131364215))
          {
            a((agas)localObject1, false);
            return;
          }
        } while (paramView.getId() != 2131364192);
        paramView = new StringBuilder();
      } while (((agas)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((agas)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((agas)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if ((!(localObject2 instanceof ShortVideoUploadProcessor)) || (!((ShortVideoUploadProcessor)localObject2).g)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoItemBuilder", 2, "CompressTask pauseOperator!");
    return;
    Object localObject2 = azex.a().a(((agas)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    if (localObject2 != null)
    {
      ((azey)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.isPause = true;
      boolean bool = ((azey)localObject2).cancel(true);
      paramView.append("\n ShortVideoItemBuilder task cancel:").append(bool);
      paramView.append("\n md5 info:").append(((MessageForShortVideo)((agas)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).md5);
      if ((bool) && (((MessageForShortVideo)((agas)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).md5 == null))
      {
        bool = ((azey)localObject2).a();
        paramView.append("\n media codec cancel:").append(bool);
        if (!bool) {
          break label424;
        }
        paramView.append("\n ffmpeg process cancel!");
      }
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((agas)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((agas)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if ((localObject1 instanceof ShortVideoUploadProcessor))
      {
        ((ShortVideoUploadProcessor)localObject1).c();
        paramView.append("\n upload process pause!");
      }
      ShortVideoUtils.c("0X800A373", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShortVideoItemBuilder", 2, "CompressTask pauseOperator info:" + paramView.toString());
      return;
      label424:
      paramView.append("\n ffmpeg process cancel exception!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agai
 * JD-Core Version:    0.7.0.1
 */