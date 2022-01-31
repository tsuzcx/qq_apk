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

public class afvt
  extends BaseBubbleBuilder
  implements aelw, aenl, ayyw, azas
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect;
  private static CopyOnWriteArraySet<CropBubbleVideoView> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  public static AtomicLong a;
  private static long c;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afvv(this);
  private ault jdField_a_of_type_Ault;
  private bdfq jdField_a_of_type_Bdfq;
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
  
  public afvt(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = 0;
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if (this.jdField_a_of_type_Ault == null) {
      this.jdField_a_of_type_Ault = ((ault)paramQQAppInterface.getManager(324));
    }
  }
  
  private afwd a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int i = aekt.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (i <= -1) {
        break label215;
      }
      Object localObject = aekt.a(this.jdField_a_of_type_ComTencentWidgetListView, i);
      if (localObject != null)
      {
        localObject = aekt.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof afwd))) {
          return (afwd)localObject;
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
  
  private afwd a(MessageForShortVideo paramMessageForShortVideo)
  {
    afwd localafwd = a(paramMessageForShortVideo.uniseq);
    if ((localafwd == null) && (QLog.isColorLevel())) {
      QLog.d("ShortVideoItemBuilder", 2, "holder is null, seq = " + paramMessageForShortVideo.uniseq);
    }
    return localafwd;
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
      Rect localRect = zen.a(paramView);
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
    return new apgg(Color.rgb(214, 214, 214), paramInt1, paramInt2);
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Drawable localDrawable = null;
    if (bdcs.b(paramString))
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
  
  private void a(afwd paramafwd, int paramInt)
  {
    paramafwd.c.setVisibility(0);
    paramafwd.c.setText(paramInt);
    paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
    paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setImageResource(2130849131);
    paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(3);
  }
  
  private void a(afwd paramafwd, View paramView, ChatMessage paramChatMessage)
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
        if ((ayzc.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.msgTailType)) && (paramChatMessage.istroop == 1))
        {
          if (paramafwd.e == null)
          {
            paramafwd.e = new TextView(this.jdField_a_of_type_AndroidContentContext);
            paramafwd.e.setBackgroundResource(2130842245);
            paramafwd.e.setTextSize(1, 12.0F);
            paramafwd.e.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167192));
            paramafwd.e.setText(ayzc.b(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.msgTailType));
            paramafwd.e.setSingleLine();
            paramafwd.e.setGravity(16);
            paramafwd.e.setPadding(bcwh.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, bcwh.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0);
            paramafwd.e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
            paramChatMessage.addRule(3, 2131364171);
            paramChatMessage.addRule(5, 2131364171);
            if ((paramView instanceof ViewGroup)) {
              ((ViewGroup)paramView).addView(paramafwd.e, paramChatMessage);
            }
          }
          paramView = (RelativeLayout.LayoutParams)paramafwd.e.getLayoutParams();
          if (localMessageForShortVideo.isSend()) {}
          for (paramView.leftMargin = BaseChatItemLayout.j;; paramView.leftMargin = BaseChatItemLayout.i)
          {
            paramafwd.e.setTag(localMessageForShortVideo);
            paramafwd.e.setVisibility(0);
            return;
          }
        }
      } while (paramafwd.e == null);
      paramafwd.e.setVisibility(8);
      return;
    }
  }
  
  private void a(afwd paramafwd, MessageForShortVideo paramMessageForShortVideo, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, msg.uniseq = " + paramMessageForShortVideo.uniseq);
    }
    paramString = ShortVideoUtils.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, url = " + paramString);
    }
    if ((QLog.isColorLevel()) && (paramafwd.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d.getURL()=" + paramafwd.jdField_a_of_type_ComTencentImageURLDrawable.getURL());
    }
    paramafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    if ((paramafwd.jdField_a_of_type_ComTencentImageURLDrawable != null) && (paramafwd.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d is reuse !!!");
      }
      if (paramBoolean)
      {
        paramafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setCoverDrawable(paramafwd.jdField_a_of_type_ComTencentImageURLDrawable);
        return;
      }
      paramafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramafwd.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    Drawable localDrawable = a(paramInt1, paramInt2);
    paramString = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localDrawable, localDrawable);
    paramafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    paramafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramString);
    paramafwd.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
  }
  
  private void a(afwd paramafwd, boolean paramBoolean)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    int i = localMessageForShortVideo.videoFileStatus;
    long l = 0L;
    if (paramafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView != null) {
      l = paramafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getCurPlayingPos();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "click ppv, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType: " + ShortVideoUtils.a(localMessageForShortVideo.fileType) + ", fileStatus:" + ShortVideoUtils.b(i) + ", playPosition:" + l);
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("......click ppv, msg.uniseq:" + localMessageForShortVideo.uniseq);
    String str = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    if (!localMessageForShortVideo.isSendFromLocal()) {
      a(localMessageForShortVideo, localStringBuilder, i, str, paramafwd, l, paramBoolean);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, localStringBuilder.toString());
      }
      return;
      b(localMessageForShortVideo, localStringBuilder, i, str, paramafwd, l, paramBoolean);
    }
  }
  
  private void a(afwd paramafwd, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramafwd != null) && (paramafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null))
    {
      if (paramBoolean) {
        b(paramafwd, false, null);
      }
      paramafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private void a(afwd paramafwd, boolean paramBoolean, MessageForShortVideo paramMessageForShortVideo, String paramString1, String[] paramArrayOfString, String paramString2, int paramInt1, int paramInt2)
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
      paramafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      localObject = new VideoPlayParam();
      ((VideoPlayParam)localObject).mSceneId = 101;
      ((VideoPlayParam)localObject).mSceneName = awwr.a(101);
      ((VideoPlayParam)localObject).mIsMute = true;
      ((VideoPlayParam)localObject).mCallback = new afvw(this);
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
      paramafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setVideoParam((VideoPlayParam)localObject);
      paramMessageForShortVideo = a(paramInt1, paramInt2);
      if (!TextUtils.isEmpty(paramString2)) {
        break label326;
      }
      paramafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setCoverDrawable(paramMessageForShortVideo);
    }
    for (;;)
    {
      if (d()) {
        paramafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.play();
      }
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView);
      return;
      localObject = "null";
      break;
      label320:
      i = 0;
      break label226;
      label326:
      paramMessageForShortVideo = URLDrawable.getDrawable(ShortVideoUtils.a(paramString2), paramInt1, paramInt2, paramMessageForShortVideo, paramMessageForShortVideo);
      paramafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setCoverDrawable(paramMessageForShortVideo);
      paramafwd.jdField_a_of_type_ComTencentImageURLDrawable = paramMessageForShortVideo;
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!bdan.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      bdan.a().a(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForShortVideo.frienduin, 1, 1, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Bundle paramBundle, MessageForReplyText paramMessageForReplyText)
  {
    if ((rlb.a(paramContext)) || (paramQQAppInterface.c()))
    {
      QQToast.a(paramContext, 0, 2131720119, 0).b(paramContext.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    if (!paramMessageForShortVideo.isSend()) {
      new axot(BaseApplication.getContext()).a(paramQQAppInterface, 2002, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
    }
    boolean bool = bjxj.d(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startPlayerActivity() msg.videoAttr=" + paramMessageForShortVideo.videoAttr + ", msg.istroop=" + paramMessageForShortVideo.istroop + ", isSupportMultiVideoSwitch=" + Boolean.valueOf(bool));
    }
    bool = bjxi.a(paramQQAppInterface);
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
        bilx.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), agem.a(paramMessageForShortVideo), -1, i);
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
        localObject = (ault)paramQQAppInterface.getManager(324);
        bool = ((ault)localObject).a(paramMessageForShortVideo);
        paramBundle.putBoolean("extra.IS_SAVING_FILE", bool);
        if (bool)
        {
          localObject = ((ault)localObject).a(((ault)localObject).a(paramMessageForShortVideo));
          if ((localObject != null) && (((aulp)localObject).d == 1)) {
            paramBundle.putInt("extra.SAVE_FILE_PROGRESS", ((aulp)localObject).jdField_c_of_type_Int);
          }
        }
        if ((paramMessageForShortVideo.istroop != 0) || (!bdal.b(paramMessageForShortVideo.senderuin)) || (TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type")))) {
          continue;
        }
        paramBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
        bilx.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), agem.a(paramMessageForShortVideo), 13007, i);
        ((axso)paramQQAppInterface.getManager(326)).a();
        if (!paramMessageForShortVideo.isSend()) {
          new axot(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
        }
        awjr.b(paramQQAppInterface, paramMessageForShortVideo);
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
    localBundle.putBoolean(bilx.b, paramBoolean2);
    a(paramMessageForShortVideo, paramLong, paramContext, paramQQAppInterface, paramSessionInfo, localBundle, paramMessageForReplyText);
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "handleVideoCompressSucceed, seq = " + paramMessageForShortVideo.uniseq);
    }
    azap localazap = azao.a().a(paramMessageForShortVideo.uniseq);
    if ((paramQQAppInterface != null) && (localazap != null)) {
      if (localazap.a() >= 104345600L)
      {
        paramMessageForShortVideo.videoFileStatus = 1005;
        paramMessageForShortVideo.serial();
        paramQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
        if (paramContext != null)
        {
          QQToast.a(paramContext, paramContext.getResources().getString(2131720099), 0).b(paramContext.getResources().getDimensionPixelSize(2131298914));
          paramContext = ((FragmentActivity)paramContext).getChatFragment();
          if (paramContext != null)
          {
            paramContext = paramContext.a();
            if (paramContext != null) {
              paramContext.b(false, false);
            }
          }
        }
        axso.a(paramQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
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
      paramContext = ayyu.a(0, 0);
      paramMessageForShortVideo = ayyu.a(paramMessageForShortVideo, paramContext);
      if (paramMessageForShortVideo != null)
      {
        paramMessageForShortVideo.i = localazap.a();
        paramMessageForShortVideo.jdField_a_of_type_Boolean = false;
        paramContext.a(paramMessageForShortVideo);
      }
      ayyu.a(paramContext, paramQQAppInterface);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(-1L);
      return;
    }
    QLog.i("ShortVideoItemBuilder", 2, "CompressTask onPostExecute QQAppInterface is null...");
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, StringBuilder paramStringBuilder, int paramInt, String paramString, afwd paramafwd, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" sendFromLocal:false ");
    if (!bdcs.b(paramString))
    {
      paramStringBuilder.append(" videoPathExists:false ");
      if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9))
      {
        paramStringBuilder.append(" fileType:video, =" + ShortVideoUtils.a(paramMessageForShortVideo.fileType));
        if ((paramInt == 2005) && (paramMessageForShortVideo.isAllowAutoDown))
        {
          b(paramafwd);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720128, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          paramStringBuilder.append(" result:toast recv_error ");
          return;
        }
        if (paramInt == 5001)
        {
          b(paramafwd);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720126, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          paramStringBuilder.append(" result: toast file_unsafe ");
          return;
        }
        if (paramInt == 5002)
        {
          a(paramafwd, 2131719264);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720127, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          paramStringBuilder.append(" result: toast file_expired ");
          return;
        }
        b(paramafwd);
        a(paramMessageForShortVideo, paramLong, paramBoolean);
        paramStringBuilder.append(" status:other, result: download ");
        return;
      }
      if (paramInt == 5002)
      {
        a(paramafwd, 2131719264);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720127, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        paramStringBuilder.append("fileType:not video,videoPathExits:false, result:toast file_expired ");
        return;
      }
      b(paramafwd);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append("fileType:not video,videoPathExits:false, result: download");
      return;
    }
    b(paramafwd);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append("videoPathExists:true, result:play ");
  }
  
  private boolean a(long paramLong)
  {
    return ((axso)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong);
  }
  
  private boolean a(afwd paramafwd)
  {
    if (this.jdField_a_of_type_Ault != null)
    {
      paramafwd = this.jdField_a_of_type_Ault.a(this.jdField_a_of_type_Ault.a(paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage));
      return (paramafwd != null) && (paramafwd.d == 1) && (!paramafwd.jdField_a_of_type_Boolean);
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
      if (azao.a().a(paramMessageForShortVideo.uniseq) == null)
      {
        paramMessageForShortVideo = ShortVideoUtils.c(paramMessageForShortVideo.videoFileName, "mp4");
        if (!TextUtils.isEmpty(paramMessageForShortVideo)) {
          bdcs.d(paramMessageForShortVideo);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static Drawable b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    apgg localapgg = new apgg(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localapgg, localapgg);
        localURLDrawable.setTag(bcuq.b(0, 0, paramInt3));
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
    return localapgg;
  }
  
  private void b(afwd paramafwd, View paramView, ChatMessage paramChatMessage)
  {
    if (c(paramafwd))
    {
      if (paramafwd.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        paramafwd.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramafwd.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838161);
        paramafwd.jdField_a_of_type_AndroidWidgetImageView.setId(2131364190);
        paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
        paramChatMessage.bottomMargin = aekt.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramChatMessage.addRule(8, 2131364171);
        paramChatMessage.addRule(0, 2131364171);
        paramChatMessage.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramafwd.jdField_a_of_type_AndroidWidgetImageView, paramChatMessage);
        }
      }
      b(paramafwd, true, this);
      return;
    }
    b(paramafwd, false, null);
  }
  
  private void b(afwd paramafwd, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      if (paramafwd.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        paramafwd.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramafwd.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      }
    }
    while (paramafwd.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    paramafwd.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramafwd.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
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
      axso.a(paramQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    }
    if (paramContext != null) {}
  }
  
  private void b(MessageForShortVideo paramMessageForShortVideo, StringBuilder paramStringBuilder, int paramInt, String paramString, afwd paramafwd, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" sendFromLocal:true ");
    if (paramMessageForShortVideo.isMultiMsg) {
      paramMessageForShortVideo.extraflag = 32772;
    }
    if (bdcs.b(paramMessageForShortVideo.videoFileName))
    {
      paramStringBuilder.append(" localUploadPath Exists:true ");
      if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9))
      {
        paramStringBuilder.append(" fileType:video ");
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
        if (paramString != null)
        {
          if ((ShortVideoUploadProcessor.class.isInstance(paramString)) || (basv.class.isInstance(paramString))) {
            if (paramInt == 1005)
            {
              b(paramafwd);
              paramafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              paramStringBuilder.append(" status:send_error, result:show send error ");
            }
          }
          while (!bass.class.isInstance(paramString))
          {
            return;
            if ((paramInt == 1002) || (paramInt == 1001))
            {
              a(paramMessageForShortVideo, paramLong, paramBoolean);
              paramStringBuilder.append(" status:process or start, result:pauseSending ");
              return;
            }
            b(paramafwd);
            a(paramMessageForShortVideo, paramLong, paramBoolean);
            paramStringBuilder.append(" status:other, result:play ");
            return;
          }
          paramStringBuilder.append(" processor:not up of forward, result: none");
          return;
        }
        b(paramafwd);
        a(paramMessageForShortVideo, paramLong, paramBoolean);
        paramStringBuilder.append(" processor:null, result:play ");
        return;
      }
      b(paramafwd);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" fileType:not video, result: play ");
      return;
    }
    paramStringBuilder.append(" localUploadPath Exists:false ");
    if (!bdcs.b(ShortVideoUtils.a(paramMessageForShortVideo, "mp4")))
    {
      paramStringBuilder.append(" downloadPath Exists:false ");
      if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
        if (paramString != null)
        {
          boolean bool;
          if (bass.class.isInstance(paramString))
          {
            bool = ((bass)paramString).d();
            paramStringBuilder.append(" processor:download, pause:" + bool);
            if (bool)
            {
              b(paramafwd);
              a(paramMessageForShortVideo, paramLong, paramBoolean);
              paramStringBuilder.append(" pause:true, result:download ");
              return;
            }
            if (paramInt == 2005)
            {
              b(paramafwd);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720128, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
              paramStringBuilder.append(" status:recv_error, result:toast recv_error ");
              return;
            }
            if ((paramInt == 2002) || (paramInt == 2000) || (paramInt == 2008) || (paramInt == 2001))
            {
              b(paramafwd);
              return;
            }
            if (paramInt == 5001)
            {
              b(paramafwd);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720126, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
              paramStringBuilder.append(" status:file_unsafe, result:toast unsafe ");
              return;
            }
            if (paramInt == 5002)
            {
              a(paramafwd, 2131719264);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720127, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
              paramStringBuilder.append(" status:file_expired, result:toast expired ");
              return;
            }
            b(paramafwd);
            a(paramMessageForShortVideo, paramLong, paramBoolean);
            paramStringBuilder.append(" status:other, result:download ");
            return;
          }
          if (ShortVideoUploadProcessor.class.isInstance(paramString))
          {
            b(paramafwd);
            paramafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720133, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
            paramStringBuilder.append(" processor:upload, result:show upload error and show toast");
            return;
          }
          if (basv.class.isInstance(paramString))
          {
            bool = ((basv)paramString).d();
            paramStringBuilder.append(" processor:forward, pause:" + bool);
            if (bool)
            {
              a(paramafwd, 10, false);
              b(paramMessageForShortVideo, paramafwd);
              paramStringBuilder.append(" pause:true, result:reforward ");
              return;
            }
            if (paramInt == 5001)
            {
              b(paramafwd);
              paramafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720101, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
              paramStringBuilder.append(" status:unsafe, result:toast unsafe ");
              return;
            }
            if (paramInt == 5002)
            {
              a(paramafwd, 2131719264);
              paramafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720102, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
              paramStringBuilder.append(" status:expired, result:toast expired ");
              return;
            }
            if (paramInt == 1005)
            {
              b(paramafwd);
              paramafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              paramStringBuilder.append(" status:send_error, result:show send_error ");
              return;
            }
            if ((paramInt == 1002) || (paramInt == 1001))
            {
              a(paramMessageForShortVideo, 0L, paramBoolean);
              return;
            }
            b(paramafwd);
            a(paramMessageForShortVideo, 0L, paramBoolean);
            paramStringBuilder.append(" status:other, result:plau ");
            return;
          }
          paramStringBuilder.append(" processor:not down or forward or up, result:none ");
          return;
        }
        b(paramafwd);
        paramStringBuilder.append(" processor:null, result:download ");
        a(paramMessageForShortVideo, 0L, paramBoolean);
        return;
      }
      b(paramafwd);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" fileType:not video, result:download ");
      return;
    }
    b(paramafwd);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append(" downloadPath Exists:true，result:play ");
  }
  
  private boolean b(afwd paramafwd)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Ault != null)
    {
      paramafwd = this.jdField_a_of_type_Ault.a(this.jdField_a_of_type_Ault.a(paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage));
      if ((paramafwd != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      bool1 = bool2;
      if (paramafwd != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean b(MessageForShortVideo paramMessageForShortVideo)
  {
    return false;
  }
  
  private void c(afwd paramafwd)
  {
    if (c(paramafwd))
    {
      if (paramafwd.jdField_a_of_type_AndroidWidgetImageView != null) {
        break label20;
      }
      h();
    }
    label20:
    while (paramafwd.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      return;
    }
    b(paramafwd, true, this);
  }
  
  private void c(MessageForShortVideo paramMessageForShortVideo, afwd paramafwd)
  {
    int k = 1;
    aulp localaulp;
    int i;
    if ((this.jdField_a_of_type_Ault != null) && (paramMessageForShortVideo != null) && (paramafwd != null))
    {
      paramMessageForShortVideo = this.jdField_a_of_type_Ault.a(paramMessageForShortVideo);
      localaulp = this.jdField_a_of_type_Ault.a(paramMessageForShortVideo);
      if ((localaulp != null) && (localaulp.d == 1))
      {
        if (localaulp.jdField_c_of_type_Int >= 0) {
          break label188;
        }
        i = 0;
        j = k;
        if (paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getVisibility() != 8) {
          if ((paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getVisibility() != 0) || (paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.d != 2)) {
            break label213;
          }
        }
      }
    }
    label188:
    label213:
    for (int j = k;; j = 0)
    {
      if ((i < 100) && (j != 0) && (!localaulp.jdField_a_of_type_Boolean) && (localaulp.jdField_a_of_type_Aulo != null))
      {
        localaulp.jdField_a_of_type_Aulo.a(new afvy(this, paramMessageForShortVideo, paramafwd));
        this.jdField_a_of_type_Ault.a(paramMessageForShortVideo, localaulp);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "dealVideoSaveUI showSaveProgress");
        }
        a(paramafwd, i, false);
        paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      }
      return;
      if (localaulp.jdField_c_of_type_Int > 100)
      {
        i = 100;
        break;
      }
      i = localaulp.jdField_c_of_type_Int;
      break;
    }
  }
  
  private boolean c(afwd paramafwd)
  {
    boolean bool2 = true;
    if ((paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {
        return false;
      }
      int i;
      int j;
      if ((localMessageForShortVideo.videoFileStatus == 998) || (localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 1001))
      {
        i = 1;
        if ((localMessageForShortVideo.isMultiMsg) || (localMessageForShortVideo.uiOperatorFlag == 2) || (localMessageForShortVideo.busiType != 0) || (!localMessageForShortVideo.isSendFromLocal()) || (paramafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a())) {
          break label211;
        }
        j = 1;
        label109:
        if (QLog.isColorLevel())
        {
          paramafwd = new StringBuilder().append("needShowPauseIcon seq:").append(localMessageForShortVideo.uniseq).append(", videostatus:").append(localMessageForShortVideo.videoFileStatus).append(", iconshow:");
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
    return azqe.a().a(this.jdField_a_of_type_AndroidContentContext, 1, paramMessageForShortVideo.istroop);
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
          if (bdcs.b(str))
          {
            bool1 = bool2;
            if (bdcs.b(paramMessageForShortVideo)) {
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
  
  public aels a(View paramView)
  {
    return null;
  }
  
  public aelt a()
  {
    return new afwd(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaeov);
    if ((paramChatMessage instanceof MessageForShortVideo)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramChatMessage);
    }
    a(paramChatMessage, paramView, this);
    a((afwd)paramView.getTag(), paramView, paramChatMessage);
    b((afwd)paramView.getTag(), paramView, paramChatMessage);
    if (e) {}
    try
    {
      paramChatMessage = (afwd)paramView.getTag();
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append(paramChatMessage.jdField_a_of_type_AndroidWidgetTextView.getText());
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime);
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append("秒按钮");
      paramView.setContentDescription(paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.toString());
      return paramView;
    }
    catch (Exception paramChatMessage) {}
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView, message.uniseq = " + paramChatMessage.uniseq);
    }
    afwd localafwd = (afwd)paramaelt;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramBaseChatItemLayout = (MessageForShortVideo)paramChatMessage;
    boolean bool1 = paramBaseChatItemLayout.isSend();
    paramaelt = paramView;
    int i;
    if (paramView == null)
    {
      paramaelt = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = (CropBubbleVideoView)awwq.a(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout.uniseq, null, bool1);
      paramView.setId(2131362258);
      paramView.setVisibility(0);
      paramView.setContentDescription(alpo.a(2131714409));
      paramaelt.addView(paramView);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramView);
      VideoProgressView localVideoProgressView = new VideoProgressView(this.jdField_a_of_type_AndroidContentContext);
      localVideoProgressView.setId(2131364213);
      paramaelt.addView(localVideoProgressView);
      ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 0);
      i = aekt.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      Object localObject2 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramaelt.addView(localProgressBar, (ViewGroup.LayoutParams)localObject2);
      Object localObject3 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject3).setOrientation(1);
      ((LinearLayout)localObject3).setGravity(17);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramaelt.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      Object localObject4 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject4).topMargin = aekt.a(70.0F, (Resources)localObject1);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setId(2131364211);
      ((TextView)localObject2).setVisibility(4);
      ((LinearLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      localObject3 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject3).setBackgroundResource(2130838946);
      localObject4 = new RelativeLayout.LayoutParams(-1, aekt.a(55.0F, (Resources)localObject1));
      ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131362258);
      ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131362258);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131362258);
      paramaelt.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setTextSize(1, 12.0F);
      ((TextView)localObject4).setTextColor(-1);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).leftMargin = aekt.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject5).bottomMargin = aekt.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject5).addRule(9);
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout)localObject3).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject5).setTextSize(1, 12.0F);
      ((TextView)localObject5).setTextColor(-1);
      Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).rightMargin = aekt.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject6).bottomMargin = aekt.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject6).addRule(11);
      ((RelativeLayout.LayoutParams)localObject6).addRule(12);
      ((RelativeLayout)localObject3).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      localObject6 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject6).setTextSize(1, 14.0F);
      ((TextView)localObject6).setTextColor(-1);
      ((TextView)localObject6).setGravity(17);
      ((TextView)localObject6).setText(2131720120);
      ((TextView)localObject6).setShadowLayer(3.0F, 1.0F, 1.0F, -16777216);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = aekt.a(14.0F, (Resources)localObject1);
      localLayoutParams.addRule(14);
      paramaelt.addView((View)localObject6, localLayoutParams);
      paramaelt.setOnClickListener(this);
      super.a(paramaelt, paramaeov);
      localafwd.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
      localafwd.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
      localafwd.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      localafwd.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject5);
      localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView = localVideoProgressView;
      localafwd.c = ((TextView)localObject2);
      localafwd.d = ((TextView)localObject6);
      localafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView = paramView;
    }
    localafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setTag(Long.valueOf(paramBaseChatItemLayout.uniseq));
    bdan.a().a(Long.valueOf(paramBaseChatItemLayout.uniseq), paramBaseChatItemLayout);
    if (localafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend != bool1)
    {
      localafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend = bool1;
      localafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.invalidate();
    }
    localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnClickListener(this);
    localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnTouchListener(paramaeov);
    localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnLongClickListener(paramaeov);
    localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setRadius(15.0F, true);
    localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setShowCorner(true);
    localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setSharpCornerCor(BubbleImageView.a);
    localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setCornerDirection(bool1);
    localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    awjr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout);
    paramView = (RelativeLayout.LayoutParams)localafwd.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    label1017:
    int j;
    int k;
    if (bool1)
    {
      paramView.leftMargin = 0;
      paramView.rightMargin = aekt.a(localafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), (Resources)localObject1);
      paramView = (RelativeLayout.LayoutParams)localafwd.d.getLayoutParams();
      if (!bool1) {
        break label1408;
      }
      paramView.rightMargin = (aekt.a(localafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), (Resources)localObject1) / 2);
      localafwd.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramBaseChatItemLayout.videoFileTime * 1000));
      localafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView = ShortVideoUtils.a(paramBaseChatItemLayout.thumbMD5, "jpg");
      paramaeov = ShortVideoUtils.a(paramBaseChatItemLayout.thumbWidth, paramBaseChatItemLayout.thumbHeight);
      j = paramaeov[0];
      k = paramaeov[1];
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView, msg.uniseq = " + paramBaseChatItemLayout.uniseq + " msg.thumbWidth = " + paramBaseChatItemLayout.thumbWidth + ", msg.thumbHeight = " + paramBaseChatItemLayout.thumbHeight + ", adjustWidth = " + j + ", adjustHeight = " + k);
      }
      paramaeov = localafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getLayoutParams();
      if (paramaeov != null) {
        break label1430;
      }
      paramaeov = new RelativeLayout.LayoutParams(j, k);
      localafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramaeov);
      label1210:
      paramaeov = localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getLayoutParams();
      if (paramaeov != null) {
        break label1477;
      }
      paramaeov = new LinearLayout.LayoutParams(j, k);
      localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setLayoutParams(paramaeov);
      label1248:
      if (ayyu.jdField_a_of_type_Boolean)
      {
        ayyu.jdField_a_of_type_Long = System.currentTimeMillis();
        ayyu.jdField_a_of_type_Boolean = false;
      }
      paramaeov = a(j, k);
      b(localafwd);
      c(paramBaseChatItemLayout, localafwd);
      if ((paramBaseChatItemLayout.md5 != null) || (paramBaseChatItemLayout.CheckIsHotVideo()) || (paramBaseChatItemLayout.isCancelStatus())) {
        break label1682;
      }
      if (paramBaseChatItemLayout.isSendFromLocal())
      {
        localafwd.jdField_a_of_type_AndroidWidgetTextView.setText("");
        if (bdcs.b(paramView))
        {
          a(localafwd, paramBaseChatItemLayout, paramView, j, k, false);
          if (paramBaseChatItemLayout.videoFileStatus != 1005) {
            break label1524;
          }
          localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(2);
          localafwd.c.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      label1381:
      return paramaelt;
      paramView.leftMargin = aekt.a(localafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), (Resources)localObject1);
      paramView.rightMargin = 0;
      break;
      label1408:
      paramView.leftMargin = (aekt.a(localafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), (Resources)localObject1) / 2);
      break label1017;
      label1430:
      if ((paramaeov.width == j) && (paramaeov.height == k)) {
        break label1210;
      }
      paramaeov.width = j;
      paramaeov.height = k;
      localafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramaeov);
      break label1210;
      label1477:
      if ((paramaeov.width == j) && (paramaeov.height == k)) {
        break label1248;
      }
      paramaeov.width = j;
      paramaeov.height = k;
      localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setLayoutParams(paramaeov);
      break label1248;
      label1524:
      localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      localafwd.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      localafwd.d.setVisibility(8);
      localafwd.c.setVisibility(8);
      localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      if ((paramBaseChatItemLayout.videoFileStatus != 998) || (a(paramBaseChatItemLayout)))
      {
        paramChatMessage = new azap(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, this);
        azao.a().a(paramBaseChatItemLayout.uniseq, paramChatMessage);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView(): msg.md5 == null, start compress task, id:" + paramBaseChatItemLayout.uniseq);
        }
      }
      paramChatMessage = azao.a().a(paramBaseChatItemLayout.uniseq);
      if (paramChatMessage == null) {
        continue;
      }
      paramChatMessage.a(this);
      return paramaelt;
      label1682:
      localafwd.c.setVisibility(8);
      localafwd.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout.videoFileSize));
      localafwd.d.setVisibility(8);
      if (bdcs.b(paramView))
      {
        if ((paramBaseChatItemLayout.videoFileStatus == 998) || (paramBaseChatItemLayout.videoFileStatus == 1001) || (paramBaseChatItemLayout.videoFileStatus == 1002) || (paramBaseChatItemLayout.videoFileStatus == 1004)) {}
        for (i = 1;; i = 0)
        {
          if ((c(paramBaseChatItemLayout)) && ((!paramBaseChatItemLayout.isSendFromLocal()) || (i == 0)) && (!b(localafwd)) && (!b(paramBaseChatItemLayout)) && (!a(paramBaseChatItemLayout.uniseq))) {
            break label2166;
          }
          a(localafwd, paramBaseChatItemLayout, paramView, j, k, false);
          localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
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
            return paramaelt;
          case 1001: 
            if (paramChatMessage != null) {
              break label3056;
            }
            localafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            b(localafwd);
            if (!QLog.isColorLevel()) {
              break label1381;
            }
            QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_START, 上传开始被杀进程然后恢复, uniseq:" + paramBaseChatItemLayout.uniseq);
            return paramaelt;
          }
        }
        label2166:
        paramaeov = ShortVideoUtils.a(paramBaseChatItemLayout, "mp4");
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView(): videoPath = " + paramaeov);
        }
        localObject1 = new File(paramaeov);
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
            if ((!bdee.h(this.jdField_a_of_type_AndroidContentContext)) || (paramBaseChatItemLayout.videoFileStatus == 5002)) {
              break label2454;
            }
            paramChatMessage = ayyu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, 2);
            if (paramChatMessage != null) {
              ayyu.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
          }
        }
        for (;;)
        {
          a(localafwd, paramBaseChatItemLayout, paramView, j, k, true);
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
          localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
        }
        label2466:
        a(localafwd, true, paramBaseChatItemLayout, paramaeov, null, paramView, j, k);
        if (paramBaseChatItemLayout.videoFileTime <= 8)
        {
          i = 1;
          label2496:
          a(localafwd);
          if (i == 0) {
            localafwd.d.setVisibility(0);
          }
          if ((paramBaseChatItemLayout.CheckIsHotVideo()) && (!bdan.a().a(paramBaseChatItemLayout, "0X8007EDB")))
          {
            bdan.a().a(paramBaseChatItemLayout, "0X8007EDB");
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
          }
          if (bdan.a().a(paramBaseChatItemLayout, "0X80077D9")) {
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
        bdan.a().a(paramBaseChatItemLayout, "0X80077D9");
        return paramaelt;
        i = 0;
        break label2496;
        if (((paramBaseChatItemLayout.fileType == 7) || (paramBaseChatItemLayout.fileType == 18) || (paramBaseChatItemLayout.fileType == 16)) && (paramBaseChatItemLayout.videoFileStatus == 5002))
        {
          localafwd.d.setVisibility(8);
          localafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramBaseChatItemLayout.uniseq);
          localafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramaeov);
          a(localafwd, 2131719264);
          if (!QLog.isColorLevel()) {
            break label1852;
          }
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not download pic : 缩略图不存在，而且文件已经过期，不下载, , uniseq:" + paramBaseChatItemLayout.uniseq);
          break label1852;
        }
        if ((paramBaseChatItemLayout.extraflag == 32768) || (b(localafwd))) {
          break label1852;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not SendFromLocal : 缩略图不存在，开始下载缩略图, , uniseq:" + paramBaseChatItemLayout.uniseq);
        }
        localafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramBaseChatItemLayout.uniseq);
        localafwd.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramaeov);
        paramChatMessage = ayyu.a(2, this.jdField_c_of_type_Int);
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
          ayyu.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
          if (paramBaseChatItemLayout.istroop == 3000) {
            paramView.e = 1006;
          } else if (paramBaseChatItemLayout.istroop == 1) {
            paramView.e = 1004;
          }
        }
        label3056:
        a(localafwd, ShortVideoUtils.a(paramBaseChatItemLayout.videoFileProgress, 10), false);
        return paramaelt;
        localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
        localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(localafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + localafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        b(localafwd);
        a(localafwd, true, this);
        return paramaelt;
        if (paramChatMessage == null)
        {
          localafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          b(localafwd);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_PROCESS, 上传过程中被杀进程然后恢复, uniseq:" + paramBaseChatItemLayout.uniseq);
          return paramaelt;
        }
        if (((axso)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).b(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq))
        {
          localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(10, paramBaseChatItemLayout.frienduin + paramBaseChatItemLayout.uniseq);
          localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
          return paramaelt;
        }
        i = paramBaseChatItemLayout.videoFileProgress;
        if ((paramChatMessage instanceof ShortVideoUploadProcessor))
        {
          paramChatMessage = (ShortVideoUploadProcessor)paramChatMessage;
          if (paramChatMessage.a() != 0L)
          {
            i = (int)(100L * paramChatMessage.b() / paramChatMessage.a());
            a(localafwd, ShortVideoUtils.a(i, 10), false);
            return paramaelt;
            b(localafwd);
            return paramaelt;
            b(localafwd);
            return paramaelt;
            b(localafwd);
            return paramaelt;
            b(localafwd);
            return paramaelt;
            a(localafwd, 2131719264);
            return paramaelt;
          }
        }
      }
      catch (Exception paramChatMessage)
      {
        for (;;) {}
      }
    }
  }
  
  public bdkz a(bdkz parambdkz, ChatMessage paramChatMessage, aemk paramaemk)
  {
    boolean bool3 = false;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramaemk = (afwd)paramaemk;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.a(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForShortVideo.videoFileStatus));
    }
    b(parambdkz, this.jdField_a_of_type_AndroidContentContext);
    int i;
    boolean bool1;
    label221:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramChatMessage = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (bdcs.b(paramChatMessage))
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
        if ((paramaemk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView == null) || (!paramaemk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramaemk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaemk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
          break label479;
        }
        bool1 = true;
        bool2 = bool3;
        if (paramaemk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
        {
          bool2 = bool3;
          if (paramaemk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
            bool2 = true;
          }
        }
        if ((!bool4) || (bool1) || (bool2)) {
          break label432;
        }
        parambdkz.a(2131366750, this.jdField_a_of_type_AndroidContentContext.getString(2131692835), 2130838677);
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
      if ((localMessageForShortVideo != null) && (bdcs.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))) {
        parambdkz.a(2131366015, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838676);
      }
      this.f = true;
      return parambdkz;
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
    if (bdec.a(paramChatMessage.issend)) {
      return alpo.a(2131714417);
    }
    return alpo.a(2131714469);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_Bdfq != null) && (this.jdField_a_of_type_Bdfq.isShowing()))
    {
      this.jdField_a_of_type_Bdfq.dismiss();
      this.jdField_a_of_type_Bdfq = null;
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
            MessageForShortVideo localMessageForShortVideo = bdan.a().a(Integer.valueOf(localCropBubbleVideoView.getId()));
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
      if (paramInt == 2131365069)
      {
        acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
      }
      if (paramInt == 2131370842)
      {
        super.d(paramChatMessage);
        return;
      }
      if (paramInt == 2131366750)
      {
        b(localMessageForShortVideo);
        if (paramChatMessage.isMultiMsg) {
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 6, 0, "6", "", "", "");
        }
      }
      else if (paramInt == 2131366015)
      {
        if (d((MessageForShortVideo)paramChatMessage))
        {
          biqt.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
          birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
          if (paramChatMessage.isMultiMsg) {
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 6, 0, "6", "", "", "");
          }
        }
      }
      else
      {
        if (paramInt == 2131370799)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked(): msg_revoke =>" + localMessageForShortVideo.toLogString());
          }
          if (localMessageForShortVideo.md5 == null)
          {
            azao.a().b(localMessageForShortVideo.uniseq);
            jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(localMessageForShortVideo.uniseq);
            ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(20)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
            axso.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
            return;
          }
          paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
          if ((paramContext == null) || ((!ShortVideoUploadProcessor.class.isInstance(paramContext)) && (!basv.class.isInstance(paramContext)))) {
            break label672;
          }
          boolean bool = ((bamw)paramContext).d();
          paramInt = localMessageForShortVideo.videoFileStatus;
          if ((!bool) && (paramInt != 1002) && (paramInt != 1001)) {
            break label672;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
          ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(20)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
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
          if (paramInt == 2131370902)
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
            azmj.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 2, 0, "", "", "", "");
            return;
          }
          super.a(paramInt, paramContext, paramChatMessage);
          return;
        }
      }
    }
  }
  
  public void a(afwd paramafwd)
  {
    if (a(paramafwd)) {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "disProgress...file is saving, so return!");
      }
    }
    do
    {
      return;
      if (!a(paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "disProgress fail...video order sending! " + paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return;
    if (!paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
      return;
    }
    paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimRunnableListener(new afvx(this, paramafwd));
  }
  
  protected void a(afwd paramafwd, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 100)
    {
      paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(paramInt, paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    for (;;)
    {
      paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVideoCompressStatus(false);
      paramafwd.c.setVisibility(8);
      return;
      paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(paramInt, paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (afwd)aekt.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      bhpy localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbhpy.a(2131690042, 5);
      localbhpy.c(2131690648);
      localbhpy.a(new afwc(this, localMessageForShortVideo, paramView, localbhpy));
      localbhpy.show();
      if (localMessageForShortVideo.videoFileStatus == 1004) {
        ShortVideoUtils.c("0X800A374", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(View paramView, baoj parambaoj, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = (afwd)aekt.a(paramView);
        paramView = (MessageForShortVideo)((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject2 = ((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView;
        if (paramView.uniseq != parambaoj.jdField_b_of_type_Long) {
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.e("ShortVideoItemBuilder", 2, "handleMessage getHolder error ! ", paramView);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "handleMessage msg.uniseq:" + paramView.uniseq + ",fileType:" + ShortVideoUtils.a(parambaoj.jdField_b_of_type_Int) + " ===> fileStatus:" + ShortVideoUtils.b(parambaoj.d));
      }
      paramInt2 = 0;
      paramInt1 = 0;
      if ((parambaoj.jdField_b_of_type_Int == 6) || (parambaoj.jdField_b_of_type_Int == 17) || (parambaoj.jdField_b_of_type_Int == 9) || (parambaoj.jdField_b_of_type_Int == 20)) {}
      switch (parambaoj.d)
      {
      default: 
      case 1001: 
        if (parambaoj.jdField_a_of_type_Long != 0L) {
          paramInt1 = (int)(100L * parambaoj.e / parambaoj.jdField_a_of_type_Long);
        }
        a((afwd)localObject1, ShortVideoUtils.a(paramInt1, 10), true);
        ((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        c((afwd)localObject1);
        return;
      case 1003: 
        a((afwd)localObject1, 100, true);
        b((afwd)localObject1);
        b((afwd)localObject1, false, null);
        azao.a().a(((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1005: 
        b((afwd)localObject1);
        ((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        azao.a().a(((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1004: 
        ((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + ((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        b((afwd)localObject1);
        a((afwd)localObject1, true, this);
        azao.a().a(((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1007: 
        b((afwd)localObject1);
        b((afwd)localObject1, false, null);
        azao.a().a(((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1002: 
        if (!paramView.isSendFromLocal()) {
          continue;
        }
        if (parambaoj.jdField_a_of_type_Long != 0L) {
          paramInt1 = (int)(100L * parambaoj.e / parambaoj.jdField_a_of_type_Long);
        }
        for (;;)
        {
          a((afwd)localObject1, ShortVideoUtils.a(paramInt1, 10), true);
          return;
          paramInt1 = paramInt2;
          if (QLog.isColorLevel())
          {
            QLog.e("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS: fileSize == 0 ");
            paramInt1 = paramInt2;
          }
        }
      case 2001: 
        b((afwd)localObject1);
        ((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        return;
      case 2003: 
        b((afwd)localObject1);
        if (b((afwd)localObject1)) {
          continue;
        }
        parambaoj = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
        if (bdcs.b(parambaoj)) {
          continue;
        }
        localObject1 = ayyu.a(2, this.jdField_c_of_type_Int);
        localObject2 = paramView.getDownloadInfo(((ayzo)localObject1).jdField_b_of_type_Int);
        ((ayyx)localObject2).i = parambaoj;
        if ((paramView.istroop == 0) || (paramView.istroop == 1008)) {
          ((ayyx)localObject2).e = 1002;
        }
        for (;;)
        {
          ((ayzo)localObject1).a((ayyx)localObject2);
          ((ayzo)localObject1).a(paramView);
          ayyu.a((ayzo)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
          if (paramView.istroop == 3000) {
            ((ayyx)localObject2).e = 1006;
          } else if (paramView.istroop == 1) {
            ((ayyx)localObject2).e = 1004;
          }
        }
      case 2005: 
        b((afwd)localObject1);
        if (parambaoj.g == -5100528) {
          continue;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720128, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        return;
      case 5001: 
        a((afwd)localObject1, 2131719263);
        if (paramView.uiOperatorFlag == 2)
        {
          ((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720101, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          return;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720126, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        return;
      case 5002: 
        a((afwd)localObject1, 2131719264);
        if (paramView.uiOperatorFlag == 2)
        {
          ((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720102, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          return;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720127, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        return;
      case 2004: 
        b((afwd)localObject1);
        return;
      case 2002: 
        b((afwd)localObject1);
        a((afwd)localObject1);
        if ((parambaoj.c == null) || (!c(paramView)) || (b((afwd)localObject1)) || (b(paramView))) {
          continue;
        }
        localObject2 = parambaoj.c;
        parambaoj = parambaoj.u;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_RECV_PROCESS: domain=" + parambaoj + ", videoUrls=" + Arrays.toString((Object[])localObject2));
        }
        Object localObject3 = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
        int[] arrayOfInt = ShortVideoUtils.a(paramView.thumbWidth, paramView.thumbHeight);
        paramInt2 = arrayOfInt[0];
        int i = arrayOfInt[1];
        paramInt1 = 0;
        while (paramInt1 < 1)
        {
          if (!TextUtils.isEmpty(parambaoj)) {
            localObject2[paramInt1] = (localObject2[paramInt1] + "&txhost=" + parambaoj);
          }
          paramInt1 += 1;
        }
        a((afwd)localObject1, false, paramView, null, (String[])localObject2, (String)localObject3, paramInt2, i);
        if ((paramView.CheckIsHotVideo()) && (!bdan.a().a(paramView, "0X8007EDB")))
        {
          bdan.a().a(paramView, "0X8007EDB");
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
        }
        if (bdan.a().a(paramView, "0X80077D9")) {
          continue;
        }
        paramInt1 = ntd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        parambaoj = new JSONObject();
        try
        {
          parambaoj.put("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          parambaoj.put("memNum", paramInt1);
          parambaoj.put("msg_uniseq", paramView.uniseq);
          label1306:
          nrt.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", ntd.a(paramView.getMd5(), null, null, null, parambaoj), false);
          bdan.a().a(paramView, "0X80077D9");
          return;
          if ((parambaoj.jdField_b_of_type_Int != 7) && (parambaoj.jdField_b_of_type_Int != 18) && (parambaoj.jdField_b_of_type_Int != 16)) {
            continue;
          }
          switch (parambaoj.d)
          {
          default: 
          case 2001: 
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_START:");
            return;
          case 2003: 
            parambaoj = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
            localObject2 = ShortVideoUtils.a(paramView.thumbWidth, paramView.thumbHeight);
            paramInt2 = localObject2[0];
            i = localObject2[1];
            if ((!c(paramView)) || (b((afwd)localObject1)) || (b(paramView))) {
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
              if (bdee.h(this.jdField_a_of_type_AndroidContentContext))
              {
                localObject2 = ayyu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, 2);
                if (localObject2 != null) {
                  ayyu.a((ayzo)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                }
              }
              a((afwd)localObject1, paramView, parambaoj, paramInt2, i, true);
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
              a((afwd)localObject1, true, paramView, (String)localObject2, null, parambaoj, paramInt2, i);
              a((afwd)localObject1);
              if (paramInt1 == 0) {
                break;
              }
              ((afwd)localObject1).d.setVisibility(8);
              return;
            }
            ((afwd)localObject1).d.setVisibility(0);
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
            parambaoj = ShortVideoUtils.a(paramView.thumbWidth, paramView.thumbHeight);
            paramInt1 = parambaoj[0];
            paramInt2 = parambaoj[1];
            ((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramView.uniseq);
            ((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(a(paramInt1, paramInt2));
            a((afwd)localObject1, 2131719264);
            ((afwd)localObject1).d.setVisibility(8);
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
    afwd localafwd = a(paramMessageForShortVideo);
    if (localafwd == null) {
      return;
    }
    paramMessageForShortVideo = paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq;
    localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(alpo.a(2131714445), paramMessageForShortVideo);
    localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramMessageForShortVideo, paramFloat);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "CompressUpdateListener,onFinish. seq = " + paramMessageForShortVideo.uniseq);
    }
    bhot.a(new ShortVideoItemBuilder.4(this, paramMessageForShortVideo, paramInt));
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 998) {
      return;
    }
    if ((TextUtils.isEmpty(paramMessageForShortVideo.md5)) || (paramMessageForShortVideo.videoFileStatus == 1004))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720091, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      return;
    }
    String str = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    boolean bool2 = NetworkUtils.isMobileConnected(this.jdField_a_of_type_AndroidContentContext);
    if ((ayyu.jdField_a_of_type_Long != 0L) && (System.currentTimeMillis() - ayyu.jdField_a_of_type_Long < 300000L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "startPlayVideo isConfirmed=" + bool1 + " allowPlayInXGTime=" + ayyu.jdField_a_of_type_Long + " isXGConnected = " + bool2);
      }
      if ((!bool2) || (bool1) || ((bdcs.a(str)) && (paramMessageForShortVideo.videoFileStatus != 2002)) || (paramMessageForShortVideo.videoFileSize < 1048576)) {
        break label348;
      }
      if (!bevd.a((Activity)this.jdField_a_of_type_AndroidContentContext, 3, new afvz(this, paramMessageForShortVideo, paramLong, paramBoolean))) {
        break;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131718897);
      this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131718900), str, this.jdField_a_of_type_AndroidContentContext.getString(2131718898), this.jdField_a_of_type_AndroidContentContext.getString(2131718899), new afwa(this, paramMessageForShortVideo, paramLong, paramBoolean), new afwb(this));
      paramMessageForShortVideo = atvg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
      if ((paramMessageForShortVideo instanceof SpannableString)) {
        this.jdField_a_of_type_Bdfq.setMessageWithoutAutoLink(paramMessageForShortVideo);
      }
      try
      {
        this.jdField_a_of_type_Bdfq.show();
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
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, afwd paramafwd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    boolean bool = paramMessageForShortVideo.CheckIsHotVideo();
    String str1 = paramMessageForShortVideo.videoFileName;
    String str2 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if ((!bdcs.b(str1)) && (!bool))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131720133, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      b(paramafwd);
      paramafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if ((!bdcs.b(str2)) && (!bool))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131720134, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      b(paramafwd);
      paramafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((axso)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    paramafwd = ayyu.a(1, this.jdField_c_of_type_Int);
    paramMessageForShortVideo = ayyu.a(this.jdField_c_of_type_Int, paramMessageForShortVideo, paramafwd);
    paramMessageForShortVideo.e = bool;
    paramafwd.a(paramMessageForShortVideo);
    ayyu.a(paramafwd, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    afwd localafwd = a(paramMessageForShortVideo);
    if (localafwd == null) {
      return;
    }
    bhot.a(new ShortVideoItemBuilder.3(this, paramMessageForShortVideo, paramBoolean, localafwd));
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
  
  public bdlb[] a(View paramView)
  {
    paramView = (afwd)aekt.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bdkz localbdkz = new bdkz();
    if (localMessageForShortVideo != null)
    {
      if (!localMessageForShortVideo.isMultiMsg) {
        break label48;
      }
      a(localbdkz, localMessageForShortVideo, paramView);
    }
    for (;;)
    {
      return localbdkz.a();
      label48:
      b(localbdkz, localMessageForShortVideo, paramView);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public bdkz b(bdkz parambdkz, ChatMessage paramChatMessage, aemk paramaemk)
  {
    boolean bool3 = false;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    afwd localafwd = (afwd)paramaemk;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.a(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForShortVideo.videoFileStatus));
    }
    b(parambdkz, this.jdField_a_of_type_AndroidContentContext);
    int i;
    boolean bool1;
    label226:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramaemk = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (bdcs.b(paramaemk))
      {
        paramaemk = "";
        i = 1;
        if (i == 0) {
          break label574;
        }
        if (!"1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"))) {
          break label561;
        }
        boolean bool4 = localMessageForShortVideo.checkForward();
        if ((localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView == null) || (!localafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(localafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + localafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
          break label568;
        }
        bool1 = true;
        bool2 = bool3;
        if (localafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
        {
          bool2 = bool3;
          if (localafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
            bool2 = true;
          }
        }
        if ((!bool4) || (bool1) || (bool2)) {
          break label521;
        }
        parambdkz.a(2131366750, this.jdField_a_of_type_AndroidContentContext.getString(2131692835), 2130838677);
        paramaemk = paramaemk + "inMiddleStatus = false, progeressBarShowing = false, errorIconShowing = false, show forward menu.";
      }
    }
    label521:
    label561:
    label568:
    label574:
    for (;;)
    {
      a(localMessageForShortVideo, parambdkz);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getMenuItem: " + paramaemk);
      }
      if ((localMessageForShortVideo != null) && ((localafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (localafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0))) {
        a(parambdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForShortVideo);
      }
      a(parambdkz, localMessageForShortVideo);
      if ((localMessageForShortVideo != null) && (bdcs.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))) {
        parambdkz.a(2131366015, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838676);
      }
      b(paramChatMessage, parambdkz);
      super.c(parambdkz, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
      this.f = true;
      return parambdkz;
      paramaemk = "thumbFilePath=" + paramaemk + " , not exits.";
      i = 0;
      break;
      paramaemk = " msg == null or md5 is empty.";
      i = 0;
      break;
      paramaemk = paramaemk + "progeressBarShowing=" + bool1 + ", errorIconShowing=" + bool2;
      continue;
      paramaemk = " not inDPCWhiteList.";
      continue;
      bool1 = false;
      break label226;
    }
  }
  
  protected void b(afwd paramafwd)
  {
    if (a(paramafwd)) {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "hideProgress...file is saving, so return!");
      }
    }
    do
    {
      return;
      if (!a(paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "hideProgress fail...video order sending! " + paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return;
    paramafwd.c.setVisibility(8);
    if (!paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafwd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(2);
      return;
    }
    paramafwd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimRunnableListener(new afvu(this, paramafwd));
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
    if (bdcs.b(str2))
    {
      localBundle.putBoolean("k_dataline", true);
      localBundle.putString("forward_extra", str2);
      localBundle.putBoolean("direct_send_if_dataline_forward", true);
      localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    paramMessageForShortVideo = new Intent();
    paramMessageForShortVideo.putExtras(localBundle);
    arum.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "1", "", "");
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("muate_play", paramBoolean);
    a(paramMessageForShortVideo, paramLong, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localBundle, null);
    ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, afwd paramafwd)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "reForwardVideo：" + paramMessageForShortVideo.toString());
      }
      if (!bdcs.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131720134, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        b(paramafwd);
        paramafwd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        ((axso)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
        paramafwd = ayyu.a(4, this.jdField_c_of_type_Int);
        paramafwd.a(ayyu.a(this.jdField_c_of_type_Int, paramMessageForShortVideo, paramafwd));
        ayyu.a(paramafwd, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    Object localObject1 = (afwd)aekt.a(paramView);
    jdField_a_of_type_AndroidGraphicsRect = a(paramView, (MessageForShortVideo)((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    aekt.n = true;
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
          if ((paramView.getId() == 2131364171) || (paramView.getId() == 2131364213))
          {
            a((afwd)localObject1, false);
            return;
          }
        } while (paramView.getId() != 2131364190);
        paramView = new StringBuilder();
      } while (((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if ((!(localObject2 instanceof ShortVideoUploadProcessor)) || (!((ShortVideoUploadProcessor)localObject2).g)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoItemBuilder", 2, "CompressTask pauseOperator!");
    return;
    Object localObject2 = azao.a().a(((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    if (localObject2 != null)
    {
      ((azap)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.isPause = true;
      boolean bool = ((azap)localObject2).cancel(true);
      paramView.append("\n ShortVideoItemBuilder task cancel:").append(bool);
      paramView.append("\n md5 info:").append(((MessageForShortVideo)((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).md5);
      if ((bool) && (((MessageForShortVideo)((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).md5 == null))
      {
        bool = ((azap)localObject2).a();
        paramView.append("\n media codec cancel:").append(bool);
        if (!bool) {
          break label424;
        }
        paramView.append("\n ffmpeg process cancel!");
      }
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((afwd)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
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
 * Qualified Name:     afvt
 * JD-Core Version:    0.7.0.1
 */