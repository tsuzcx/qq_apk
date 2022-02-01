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
import com.tencent.imcore.message.BaseMessageManager;
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
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.11;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.8;
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
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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

public class ahqw
  extends BaseBubbleBuilder
  implements aggp, agif, bcww
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect;
  private static CopyOnWriteArraySet<CropBubbleVideoView> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  public static AtomicLong a;
  private static long c;
  private ahrg jdField_a_of_type_Ahrg;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahrf(this);
  private axqb jdField_a_of_type_Axqb;
  private bhpc jdField_a_of_type_Bhpc;
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ShortVideoItemBuilder.8(this);
  private Handler b;
  public int c;
  int d = -1;
  boolean f = false;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  }
  
  public ahqw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = 0;
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if (this.jdField_a_of_type_Axqb == null) {
      this.jdField_a_of_type_Axqb = ((axqb)paramQQAppInterface.getManager(324));
    }
    this.jdField_a_of_type_Ahrg = new ahrg(this, null);
  }
  
  private ahrh a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int i = agej.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (i <= -1) {
        break label215;
      }
      Object localObject = agej.a(this.jdField_a_of_type_ComTencentWidgetListView, i);
      if (localObject != null)
      {
        localObject = agej.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof ahrh))) {
          return (ahrh)localObject;
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
  
  private ahrh a(MessageForShortVideo paramMessageForShortVideo)
  {
    ahrh localahrh = a(paramMessageForShortVideo.uniseq);
    if ((localahrh == null) && (QLog.isColorLevel())) {
      QLog.d("ShortVideoItemBuilder", 2, "holder is null, seq = " + paramMessageForShortVideo.uniseq);
    }
    return localahrh;
  }
  
  private Rect a(View paramView, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramView == null) || (paramMessageForShortVideo == null)) {
      return null;
    }
    paramView = paramView.findViewById(2131362346);
    if ((paramView instanceof CropBubbleVideoView))
    {
      paramView = (CropBubbleVideoView)paramView;
      Rect localRect = abke.a(paramView);
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
    return new ascz(Color.rgb(214, 214, 214), paramInt1, paramInt2);
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Drawable localDrawable = null;
    if (bhmi.b(paramString))
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
  
  private void a(long paramLong, int paramInt)
  {
    if (paramInt == 4)
    {
      localObject = bhjz.a().a(Long.valueOf(paramLong));
      if ((!bhjz.a().a(Long.valueOf(paramLong))) && (localObject != null))
      {
        ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, this.jdField_a_of_type_AndroidContentContext);
        if (!bhjz.a().b(Long.valueOf(((MessageForShortVideo)localObject).uniseq)))
        {
          bhjz.a().a(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
          ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E50", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, this.jdField_a_of_type_AndroidContentContext);
        }
        bhjz.a().a(Long.valueOf(paramLong), true);
      }
    }
    Object localObject = a(paramLong);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoItemBuilder", 2, "holder == null, msgUniseq=" + paramLong);
      }
    }
    boolean bool;
    do
    {
      do
      {
        do
        {
          return;
          if (((MessageForShortVideo)((ahrh)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage).videoFileTime <= 8) {}
          for (bool = true; paramInt == 5; bool = false)
          {
            this.jdField_b_of_type_AndroidOsHandler.postDelayed(new ShortVideoItemBuilder.10(this, bool, (ahrh)localObject), 1200L);
            return;
          }
          if ((paramInt != 7) && (paramInt != 8)) {
            break;
          }
          this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          ((ahrh)localObject).d.setVisibility(8);
          ((ahrh)localObject).jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
          b((ahrh)localObject);
          ((ahrh)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          ((ahrh)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        } while (paramInt != 8);
        localObject = bhjz.a().a(Long.valueOf(paramLong));
      } while (localObject == null);
      a((MessageForShortVideo)localObject, ((MessageForShortVideo)localObject).videoFileTime * 1000);
      return;
    } while (paramInt != 4);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (bool) {
      ((ahrh)localObject).d.setVisibility(8);
    }
    for (;;)
    {
      a((ahrh)localObject);
      ((ahrh)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      ((ahrh)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localObject = bhjz.a().a(Long.valueOf(paramLong));
      if (localObject == null) {
        break;
      }
      a((MessageForShortVideo)localObject, 0L);
      return;
      ((ahrh)localObject).d.setVisibility(0);
    }
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, VideoPlayParam paramVideoPlayParam)
  {
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onPlayError , id = ").append(paramLong);
      localStringBuilder1.append(" , module = ").append(paramInt1);
      localStringBuilder1.append(" , errorType = ").append(paramInt2);
      localStringBuilder1.append(" , errorCode = ").append(paramInt3);
      localStringBuilder2 = localStringBuilder1.append(" , exInfo =");
      if (paramString == null) {
        break label119;
      }
    }
    for (;;)
    {
      localStringBuilder2.append(paramString);
      QLog.e("ShortVideoItemBuilder", 2, localStringBuilder1.toString());
      if (paramInt3 != 14011001) {
        break label218;
      }
      if (this.jdField_a_of_type_ComTencentWidgetListView != null) {
        break;
      }
      return;
      label119:
      paramString = "null";
    }
    paramString = agej.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
    if ((paramString instanceof MessageForShortVideo))
    {
      paramString = (MessageForShortVideo)paramString;
      paramString.videoFileStatus = 5002;
      paramString.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString.frienduin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramString.uniseq, paramString.msgData);
      this.jdField_b_of_type_AndroidOsHandler.post(new ShortVideoItemBuilder.11(this, paramString));
    }
    label218:
    bapj.a(paramInt3, paramVideoPlayParam);
  }
  
  private void a(ahrh paramahrh, int paramInt)
  {
    paramahrh.c.setVisibility(0);
    paramahrh.c.setText(paramInt);
    paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
    paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setImageResource(2130849764);
    paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(3);
  }
  
  private void a(ahrh paramahrh, View paramView, ChatMessage paramChatMessage)
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
        if ((bcxc.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.msgTailType)) && (paramChatMessage.istroop == 1))
        {
          if (paramahrh.e == null)
          {
            paramahrh.e = new TextView(this.jdField_a_of_type_AndroidContentContext);
            paramahrh.e.setBackgroundResource(2130842581);
            paramahrh.e.setTextSize(1, 12.0F);
            paramahrh.e.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167302));
            paramahrh.e.setText(bcxc.b(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.msgTailType));
            paramahrh.e.setSingleLine();
            paramahrh.e.setGravity(16);
            paramahrh.e.setPadding(bhgr.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0);
            paramahrh.e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
            paramChatMessage.addRule(3, 2131364423);
            paramChatMessage.addRule(5, 2131364423);
            if ((paramView instanceof ViewGroup)) {
              ((ViewGroup)paramView).addView(paramahrh.e, paramChatMessage);
            }
          }
          paramView = (RelativeLayout.LayoutParams)paramahrh.e.getLayoutParams();
          if (localMessageForShortVideo.isSend()) {}
          for (paramView.leftMargin = BaseChatItemLayout.k;; paramView.leftMargin = BaseChatItemLayout.j)
          {
            paramahrh.e.setTag(localMessageForShortVideo);
            paramahrh.e.setVisibility(0);
            return;
          }
        }
      } while (paramahrh.e == null);
      paramahrh.e.setVisibility(8);
      return;
    }
  }
  
  private void a(ahrh paramahrh, MessageForShortVideo paramMessageForShortVideo, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, msg.uniseq = " + paramMessageForShortVideo.uniseq);
    }
    paramString = ShortVideoUtils.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, url = " + paramString);
    }
    if ((QLog.isColorLevel()) && (paramahrh.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d.getURL()=" + paramahrh.jdField_a_of_type_ComTencentImageURLDrawable.getURL());
    }
    paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    if ((paramahrh.jdField_a_of_type_ComTencentImageURLDrawable != null) && (paramahrh.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d is reuse !!!");
      }
      if (paramBoolean)
      {
        paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setCoverDrawable(paramahrh.jdField_a_of_type_ComTencentImageURLDrawable);
        return;
      }
      paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramahrh.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    Drawable localDrawable = a(paramInt1, paramInt2);
    paramString = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localDrawable, localDrawable);
    paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramString);
    paramahrh.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
  }
  
  private void a(ahrh paramahrh, boolean paramBoolean)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    int i = localMessageForShortVideo.videoFileStatus;
    long l = 0L;
    if (paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView != null) {
      l = paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getCurPlayingPos();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "click ppv, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType: " + ShortVideoUtils.a(localMessageForShortVideo.fileType) + ", fileStatus:" + ShortVideoUtils.b(i) + ", playPosition:" + l);
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("......click ppv, msg.uniseq:" + localMessageForShortVideo.uniseq);
    String str = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    if (!localMessageForShortVideo.isSendFromLocal()) {
      a(localMessageForShortVideo, localStringBuilder, i, str, paramahrh, l, paramBoolean);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, localStringBuilder.toString());
      }
      return;
      b(localMessageForShortVideo, localStringBuilder, i, str, paramahrh, l, paramBoolean);
    }
  }
  
  private void a(ahrh paramahrh, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramahrh != null) && (paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null))
    {
      if (paramBoolean) {
        b(paramahrh, false, null);
      }
      paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private void a(ahrh paramahrh, boolean paramBoolean, MessageForShortVideo paramMessageForShortVideo, String paramString1, String[] paramArrayOfString, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "playShortVideo, msg.uniseq = " + paramMessageForShortVideo.uniseq + " , getAIOState() = " + a());
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
      paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      localObject = new VideoPlayParam();
      ((VideoPlayParam)localObject).mSceneId = 101;
      ((VideoPlayParam)localObject).mSceneName = bapi.a(101);
      ((VideoPlayParam)localObject).mIsMute = true;
      ((VideoPlayParam)localObject).mCallback = new ahqy(this, (VideoPlayParam)localObject);
      ((VideoPlayParam)localObject).mIsLocal = paramBoolean;
      ((VideoPlayParam)localObject).mIsLoop = true;
      ((VideoPlayParam)localObject).mVideoPath = paramString1;
      ((VideoPlayParam)localObject).mSavePath = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
      ((VideoPlayParam)localObject).mFileID = (paramMessageForShortVideo.md5 + paramMessageForShortVideo.uniseq);
      ((VideoPlayParam)localObject).mUrls = paramArrayOfString;
      ((VideoPlayParam)localObject).mFileSize = paramMessageForShortVideo.videoFileSize;
      if (paramMessageForShortVideo.videoFileTime > 8) {
        break label335;
      }
      i = 1;
      label241:
      if (i == 0)
      {
        ((VideoPlayParam)localObject).mVideoFileTimeMs = (paramMessageForShortVideo.videoFileTime * 1000);
        ((VideoPlayParam)localObject).mMaxPlayTimeMs = 8000L;
      }
      paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setVideoParam((VideoPlayParam)localObject);
      paramMessageForShortVideo = a(paramInt1, paramInt2);
      if (!TextUtils.isEmpty(paramString2)) {
        break label341;
      }
      paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setCoverDrawable(paramMessageForShortVideo);
    }
    for (;;)
    {
      if (d()) {
        paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.play();
      }
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView);
      return;
      localObject = "null";
      break;
      label335:
      i = 0;
      break label241;
      label341:
      paramMessageForShortVideo = URLDrawable.getDrawable(ShortVideoUtils.a(paramString2), paramInt1, paramInt2, paramMessageForShortVideo, paramMessageForShortVideo);
      paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setCoverDrawable(paramMessageForShortVideo);
      paramahrh.jdField_a_of_type_ComTencentImageURLDrawable = paramMessageForShortVideo;
    }
  }
  
  private void a(axpx paramaxpx, String paramString, ahrh paramahrh, axqa paramaxqa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "dealVideoSaveUI onSaveComplete");
    }
    if (paramaxpx != null)
    {
      if (paramaxpx.jdField_a_of_type_Int != 0) {
        break label96;
      }
      axpy.a(this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      paramaxpx.jdField_a_of_type_Axpw.b(paramaxqa);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
        paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
      }
      return;
      label96:
      axpy.b(this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  private void a(bhvc parambhvc, StringBuilder paramStringBuilder, ahrh paramahrh, MessageForShortVideo paramMessageForShortVideo, int paramInt, long paramLong, boolean paramBoolean)
  {
    boolean bool = ((bexb)parambhvc).d();
    paramStringBuilder.append(" processor:download, pause:" + bool);
    if (bool)
    {
      b(paramahrh);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" pause:true, result:download ");
      return;
    }
    if (paramInt == 2005)
    {
      b(paramahrh);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718235, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      paramStringBuilder.append(" status:recv_error, result:toast recv_error ");
      return;
    }
    if ((paramInt == 2002) || (paramInt == 2000) || (paramInt == 2008) || (paramInt == 2001))
    {
      b(paramahrh);
      return;
    }
    if (paramInt == 5001)
    {
      b(paramahrh);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718233, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      paramStringBuilder.append(" status:file_unsafe, result:toast unsafe ");
      return;
    }
    if (paramInt == 5002)
    {
      a(paramahrh, 2131717503);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718234, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      paramStringBuilder.append(" status:file_expired, result:toast expired ");
      return;
    }
    b(paramahrh);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append(" status:other, result:download ");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, Context paramContext, SessionInfo paramSessionInfo, Bundle paramBundle, MessageForReplyText paramMessageForReplyText)
  {
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.n)) {
      paramBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().g());
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      paramBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      paramBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
    }
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000))
    {
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
      if (paramMessageForReplyText == null) {
        break label342;
      }
      paramBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
    }
    for (;;)
    {
      paramBundle.putLong("click_video_bubble_time", System.currentTimeMillis());
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        paramMessageForReplyText = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (paramMessageForReplyText.processName.endsWith("mobileqq")) {
          paramBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", paramMessageForReplyText.pid);
        }
      }
      paramQQAppInterface = (axqb)paramQQAppInterface.getManager(324);
      boolean bool = paramQQAppInterface.a(paramMessageForShortVideo);
      paramBundle.putBoolean("extra.IS_SAVING_FILE", bool);
      if (bool)
      {
        paramQQAppInterface = paramQQAppInterface.a(paramQQAppInterface.a(paramMessageForShortVideo));
        if ((paramQQAppInterface != null) && (paramQQAppInterface.d == 1)) {
          paramBundle.putInt("extra.SAVE_FILE_PROGRESS", paramQQAppInterface.jdField_c_of_type_Int);
        }
      }
      if (jdField_a_of_type_AndroidGraphicsRect != null) {
        paramBundle.putParcelable("KEY_THUMBNAL_BOUND", jdField_a_of_type_AndroidGraphicsRect);
      }
      paramBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      paramBundle.putString("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
      return;
      paramBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
      break;
      label342:
      paramBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForShortVideo.isMultiMsg);
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!bhjz.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      bhjz.a().a(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForShortVideo.frienduin, 1, 1, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Bundle paramBundle, MessageForReplyText paramMessageForReplyText)
  {
    if ((rxg.a(paramContext)) || (paramQQAppInterface.d()))
    {
      QQToast.a(paramContext, 0, 2131718227, 0).b(paramContext.getResources().getDimensionPixelSize(2131299011));
      return;
    }
    if (!paramMessageForShortVideo.isSend()) {
      new bbjw(BaseApplication.getContext()).a(paramQQAppInterface, 2002, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
    }
    if (MediaPlayerManager.a(paramQQAppInterface).a()) {
      MediaPlayerManager.a(paramQQAppInterface).a(true);
    }
    a(paramQQAppInterface, paramMessageForShortVideo, paramContext, paramSessionInfo, paramBundle, paramMessageForReplyText);
    int j = -1;
    int i;
    if ((paramContext instanceof SplashActivity))
    {
      i = 1;
      str = paramMessageForShortVideo.selfuin;
      paramMessageForReplyText = str;
      if (!paramMessageForShortVideo.isMultiMsg) {}
    }
    try
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramMessageForReplyText = str;
      if ((localAppRuntime instanceof QQAppInterface)) {
        paramMessageForReplyText = localAppRuntime.getAccount();
      }
    }
    catch (Exception paramMessageForReplyText)
    {
      for (;;)
      {
        paramMessageForReplyText = str;
      }
    }
    if ((paramMessageForShortVideo.istroop == 0) && (bhjx.b(paramMessageForShortVideo.senderuin)) && (!TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"))))
    {
      paramBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
      bmgb.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), aicv.a(paramMessageForShortVideo), 13007, i);
    }
    for (;;)
    {
      ((bbnr)paramQQAppInterface.getManager(326)).a();
      if (!paramMessageForShortVideo.isSend()) {
        new bbjw(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
      }
      azvd.b(paramQQAppInterface, paramMessageForShortVideo);
      return;
      if ((paramContext instanceof ChatHistoryActivity))
      {
        i = 2;
        break;
      }
      i = j;
      if (!(paramContext instanceof PublicFragmentActivity)) {
        break;
      }
      i = j;
      if (!(((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)) {
        break;
      }
      i = 2;
      break;
      bmgb.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), aicv.a(paramMessageForShortVideo), -1, i);
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, MessageForReplyText paramMessageForReplyText)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("muate_play", false);
    localBundle.putBoolean("is_one_item", true);
    localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean1);
    localBundle.putBoolean(bmgb.b, paramBoolean2);
    a(paramMessageForShortVideo, paramLong, paramContext, paramQQAppInterface, paramSessionInfo, localBundle, paramMessageForReplyText);
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "handleVideoCompressSucceed, seq = " + paramMessageForShortVideo.uniseq);
    }
    bcyq localbcyq = bcyp.a().a(paramMessageForShortVideo.uniseq);
    if ((paramQQAppInterface != null) && (localbcyq != null)) {
      if (localbcyq.a() >= 104345600L)
      {
        paramMessageForShortVideo.videoFileStatus = 1005;
        paramMessageForShortVideo.serial();
        paramQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
        if (paramContext != null)
        {
          QQToast.a(paramContext, paramContext.getResources().getString(2131718207), 0).b(paramContext.getResources().getDimensionPixelSize(2131299011));
          paramContext = ((FragmentActivity)paramContext).getChatFragment();
          if (paramContext != null)
          {
            paramContext = paramContext.a();
            if (paramContext != null) {
              paramContext.b(false, false);
            }
          }
        }
        bbnr.a(paramQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
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
      paramContext = bcwu.a(0, 0);
      paramMessageForShortVideo = bcwu.a(paramMessageForShortVideo, paramContext);
      if (paramMessageForShortVideo != null)
      {
        paramMessageForShortVideo.i = localbcyq.a();
        paramMessageForShortVideo.jdField_a_of_type_Boolean = false;
        paramContext.a(paramMessageForShortVideo);
      }
      bcwu.a(paramContext, paramQQAppInterface);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(-1L);
      return;
    }
    QLog.i("ShortVideoItemBuilder", 2, "CompressTask onPostExecute QQAppInterface is null...");
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, StringBuilder paramStringBuilder, int paramInt, String paramString, ahrh paramahrh, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" sendFromLocal:false ");
    if (!bhmi.b(paramString))
    {
      paramStringBuilder.append(" videoPathExists:false ");
      if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9))
      {
        paramStringBuilder.append(" fileType:video, =" + ShortVideoUtils.a(paramMessageForShortVideo.fileType));
        if ((paramInt == 2005) && (paramMessageForShortVideo.isAllowAutoDown))
        {
          b(paramahrh);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718235, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
          paramStringBuilder.append(" result:toast recv_error ");
          return;
        }
        if (paramInt == 5001)
        {
          b(paramahrh);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718233, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
          paramStringBuilder.append(" result: toast file_unsafe ");
          return;
        }
        if (paramInt == 5002)
        {
          a(paramahrh, 2131717503);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718234, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
          paramStringBuilder.append(" result: toast file_expired ");
          return;
        }
        b(paramahrh);
        a(paramMessageForShortVideo, paramLong, paramBoolean);
        paramStringBuilder.append(" status:other, result: download ");
        return;
      }
      if (paramInt == 5002)
      {
        a(paramahrh, 2131717503);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718234, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
        paramStringBuilder.append("fileType:not video,videoPathExits:false, result:toast file_expired ");
        return;
      }
      b(paramahrh);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append("fileType:not video,videoPathExits:false, result: download");
      return;
    }
    b(paramahrh);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append("videoPathExists:true, result:play ");
  }
  
  private void a(StringBuilder paramStringBuilder, ahrh paramahrh, MessageForShortVideo paramMessageForShortVideo, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" localUploadPath Exists:true ");
    if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9))
    {
      paramStringBuilder.append(" fileType:video ");
      bhvc localbhvc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      if (localbhvc != null)
      {
        if ((bexk.class.isInstance(localbhvc)) || (bexd.class.isInstance(localbhvc))) {
          if (paramInt == 1005)
          {
            b(paramahrh);
            paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            paramStringBuilder.append(" status:send_error, result:show send error ");
          }
        }
        while (!bexb.class.isInstance(localbhvc))
        {
          return;
          if ((paramInt == 1002) || (paramInt == 1001))
          {
            a(paramMessageForShortVideo, paramLong, paramBoolean);
            paramStringBuilder.append(" status:process or start, result:pauseSending ");
            return;
          }
          b(paramahrh);
          a(paramMessageForShortVideo, paramLong, paramBoolean);
          paramStringBuilder.append(" status:other, result:play ");
          return;
        }
        paramStringBuilder.append(" processor:not up of forward, result: none");
        return;
      }
      b(paramahrh);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" processor:null, result:play ");
      return;
    }
    b(paramahrh);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append(" fileType:not video, result: play ");
  }
  
  private boolean a(long paramLong)
  {
    return ((bbnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong);
  }
  
  private boolean a(ahrh paramahrh)
  {
    if (this.jdField_a_of_type_Axqb != null)
    {
      paramahrh = this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_Axqb.a(paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage));
      return (paramahrh != null) && (paramahrh.d == 1) && (!paramahrh.jdField_a_of_type_Boolean);
    }
    return false;
  }
  
  private static Drawable b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    ascz localascz = new ascz(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localascz, localascz);
        localURLDrawable.setTag(bhez.b(0, 0, paramInt3));
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
    return localascz;
  }
  
  private void b(ahrh paramahrh, View paramView, ChatMessage paramChatMessage)
  {
    if (c(paramahrh))
    {
      if (paramahrh.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        paramahrh.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramahrh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838285);
        paramahrh.jdField_a_of_type_AndroidWidgetImageView.setId(2131364442);
        paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
        paramChatMessage.bottomMargin = agej.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramChatMessage.addRule(8, 2131364423);
        paramChatMessage.addRule(0, 2131364423);
        paramChatMessage.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramahrh.jdField_a_of_type_AndroidWidgetImageView, paramChatMessage);
        }
      }
      b(paramahrh, true, this);
      return;
    }
    b(paramahrh, false, null);
  }
  
  private void b(ahrh paramahrh, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      if (paramahrh.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        paramahrh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramahrh.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      }
    }
    while (paramahrh.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    paramahrh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramahrh.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
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
      bbnr.a(paramQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    }
    if (paramContext != null) {}
  }
  
  private void b(MessageForShortVideo paramMessageForShortVideo, StringBuilder paramStringBuilder, int paramInt, String paramString, ahrh paramahrh, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" sendFromLocal:true ");
    if (paramMessageForShortVideo.isMultiMsg) {
      paramMessageForShortVideo.extraflag = 32772;
    }
    if (bhmi.b(paramMessageForShortVideo.videoFileName))
    {
      a(paramStringBuilder, paramahrh, paramMessageForShortVideo, paramInt, paramLong, paramBoolean);
      return;
    }
    b(paramStringBuilder, paramahrh, paramMessageForShortVideo, paramInt, paramLong, paramBoolean);
  }
  
  private void b(StringBuilder paramStringBuilder, ahrh paramahrh, MessageForShortVideo paramMessageForShortVideo, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" localUploadPath Exists:false ");
    if (!bhmi.b(ShortVideoUtils.a(paramMessageForShortVideo, "mp4")))
    {
      paramStringBuilder.append(" downloadPath Exists:false ");
      if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9))
      {
        bhvc localbhvc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
        if (localbhvc != null)
        {
          if (bexb.class.isInstance(localbhvc))
          {
            a(localbhvc, paramStringBuilder, paramahrh, paramMessageForShortVideo, paramInt, paramLong, paramBoolean);
            return;
          }
          if (bexk.class.isInstance(localbhvc))
          {
            b(paramahrh);
            paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718240, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
            paramStringBuilder.append(" processor:upload, result:show upload error and show toast");
            return;
          }
          if (bexd.class.isInstance(localbhvc))
          {
            boolean bool = ((bexd)localbhvc).d();
            paramStringBuilder.append(" processor:forward, pause:" + bool);
            if (bool)
            {
              a(paramahrh, 10, false);
              c(paramMessageForShortVideo, paramahrh);
              paramStringBuilder.append(" pause:true, result:reforward ");
              return;
            }
            if (paramInt == 5001)
            {
              b(paramahrh);
              paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718209, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
              paramStringBuilder.append(" status:unsafe, result:toast unsafe ");
              return;
            }
            if (paramInt == 5002)
            {
              a(paramahrh, 2131717503);
              paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718210, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
              paramStringBuilder.append(" status:expired, result:toast expired ");
              return;
            }
            if (paramInt == 1005)
            {
              b(paramahrh);
              paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              paramStringBuilder.append(" status:send_error, result:show send_error ");
              return;
            }
            if ((paramInt == 1002) || (paramInt == 1001))
            {
              a(paramMessageForShortVideo, 0L, paramBoolean);
              return;
            }
            b(paramahrh);
            a(paramMessageForShortVideo, 0L, paramBoolean);
            paramStringBuilder.append(" status:other, result:plau ");
            return;
          }
          paramStringBuilder.append(" processor:not down or forward or up, result:none ");
          return;
        }
        b(paramahrh);
        paramStringBuilder.append(" processor:null, result:download ");
        a(paramMessageForShortVideo, 0L, paramBoolean);
        return;
      }
      b(paramahrh);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" fileType:not video, result:download ");
      return;
    }
    b(paramahrh);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append(" downloadPath Exists:true，result:play ");
  }
  
  private boolean b(ahrh paramahrh)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Axqb != null)
    {
      paramahrh = this.jdField_a_of_type_Axqb.a(this.jdField_a_of_type_Axqb.a(paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage));
      if ((paramahrh != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      bool1 = bool2;
      if (paramahrh != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean b(MessageForShortVideo paramMessageForShortVideo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageForShortVideo.videoFileStatus == 998)
    {
      bool1 = bool2;
      if (bcyp.a().a(paramMessageForShortVideo.uniseq) == null)
      {
        paramMessageForShortVideo = ShortVideoUtils.c(paramMessageForShortVideo.videoFileName, "mp4");
        if (!TextUtils.isEmpty(paramMessageForShortVideo)) {
          bhmi.d(paramMessageForShortVideo);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void c(ahrh paramahrh)
  {
    if (c(paramahrh))
    {
      if (paramahrh.jdField_a_of_type_AndroidWidgetImageView != null) {
        break label20;
      }
      h();
    }
    label20:
    while (paramahrh.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      return;
    }
    b(paramahrh, true, this);
  }
  
  private boolean c(ahrh paramahrh)
  {
    boolean bool2 = true;
    if ((paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {
        return false;
      }
      int i;
      int j;
      if ((localMessageForShortVideo.videoFileStatus == 998) || (localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 1001))
      {
        i = 1;
        if ((localMessageForShortVideo.isMultiMsg) || (localMessageForShortVideo.uiOperatorFlag == 2) || (localMessageForShortVideo.busiType != 0) || (!localMessageForShortVideo.isSendFromLocal()) || (paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a())) {
          break label211;
        }
        j = 1;
        label109:
        if (QLog.isColorLevel())
        {
          paramahrh = new StringBuilder().append("needShowPauseIcon seq:").append(localMessageForShortVideo.uniseq).append(", videostatus:").append(localMessageForShortVideo.videoFileStatus).append(", iconshow:");
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
    return false;
  }
  
  private void d(MessageForShortVideo paramMessageForShortVideo, ahrh paramahrh)
  {
    int k = 1;
    axpx localaxpx;
    int i;
    if ((this.jdField_a_of_type_Axqb != null) && (paramMessageForShortVideo != null) && (paramahrh != null))
    {
      paramMessageForShortVideo = this.jdField_a_of_type_Axqb.a(paramMessageForShortVideo);
      localaxpx = this.jdField_a_of_type_Axqb.a(paramMessageForShortVideo);
      if ((localaxpx != null) && (localaxpx.d == 1))
      {
        if (localaxpx.jdField_c_of_type_Int >= 0) {
          break label188;
        }
        i = 0;
        j = k;
        if (paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getVisibility() != 8) {
          if ((paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getVisibility() != 0) || (paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.d != 2)) {
            break label213;
          }
        }
      }
    }
    label188:
    label213:
    for (int j = k;; j = 0)
    {
      if ((i < 100) && (j != 0) && (!localaxpx.jdField_a_of_type_Boolean) && (localaxpx.jdField_a_of_type_Axpw != null))
      {
        localaxpx.jdField_a_of_type_Axpw.a(new ahra(this, paramMessageForShortVideo, paramahrh));
        this.jdField_a_of_type_Axqb.a(paramMessageForShortVideo, localaxpx);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "dealVideoSaveUI showSaveProgress");
        }
        a(paramahrh, i, false);
        paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      }
      return;
      if (localaxpx.jdField_c_of_type_Int > 100)
      {
        i = 100;
        break;
      }
      i = localaxpx.jdField_c_of_type_Int;
      break;
    }
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
    return bdog.a().a(this.jdField_a_of_type_AndroidContentContext, 1, paramMessageForShortVideo.istroop);
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
  
  private boolean e(MessageForShortVideo paramMessageForShortVideo)
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
          if (bhmi.b(str))
          {
            bool1 = bool2;
            if (bhmi.b(paramMessageForShortVideo)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
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
  
  public aggk a(View paramView)
  {
    return null;
  }
  
  public aggl a()
  {
    return new ahrh(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    if ((paramChatMessage instanceof MessageForShortVideo)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramChatMessage);
    }
    a(paramChatMessage, paramView, this);
    a((ahrh)paramView.getTag(), paramView, paramChatMessage);
    b((ahrh)paramView.getTag(), paramView, paramChatMessage);
    if (e) {}
    try
    {
      paramChatMessage = (ahrh)paramView.getTag();
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append(paramChatMessage.jdField_a_of_type_AndroidWidgetTextView.getText());
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime);
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append("秒按钮");
      paramView.setContentDescription(paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.toString());
      return paramView;
    }
    catch (Exception paramChatMessage) {}
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView, message.uniseq = " + paramChatMessage.uniseq);
    }
    paramBaseChatItemLayout = (ahrh)paramaggl;
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    boolean bool = localMessageForShortVideo.isSend();
    paramaggl = paramView;
    int i;
    if (paramView == null)
    {
      paramaggl = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = (CropBubbleVideoView)baph.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.uniseq, null, bool);
      paramView.setId(2131362346);
      paramView.setVisibility(0);
      paramView.setContentDescription(anzj.a(2131712900));
      paramaggl.addView(paramView);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramView);
      VideoProgressView localVideoProgressView = new VideoProgressView(this.jdField_a_of_type_AndroidContentContext);
      localVideoProgressView.setId(2131364466);
      paramaggl.addView(localVideoProgressView);
      ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 0);
      i = agej.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      Object localObject1 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramaggl.addView(localProgressBar, (ViewGroup.LayoutParams)localObject1);
      Object localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject2).setOrientation(1);
      ((LinearLayout)localObject2).setGravity(17);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramaggl.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).topMargin = agej.a(70.0F, localResources);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setId(2131364464);
      ((TextView)localObject1).setVisibility(4);
      ((LinearLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject2).setBackgroundResource(2130839121);
      localObject3 = new RelativeLayout.LayoutParams(-1, agej.a(55.0F, localResources));
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131362346);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131362346);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131362346);
      paramaggl.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject3).setTextSize(1, 12.0F);
      ((TextView)localObject3).setTextColor(-1);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = agej.a(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject4).bottomMargin = agej.a(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject4).addRule(9);
      ((RelativeLayout.LayoutParams)localObject4).addRule(12);
      ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setTextSize(1, 12.0F);
      ((TextView)localObject4).setTextColor(-1);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).rightMargin = agej.a(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject5).bottomMargin = agej.a(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject5).addRule(11);
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject5).setTextSize(1, 14.0F);
      ((TextView)localObject5).setTextColor(-1);
      ((TextView)localObject5).setGravity(17);
      ((TextView)localObject5).setText(2131718228);
      ((TextView)localObject5).setShadowLayer(3.0F, 1.0F, 1.0F, -16777216);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = agej.a(14.0F, localResources);
      localLayoutParams.addRule(14);
      paramaggl.addView((View)localObject5, localLayoutParams);
      paramaggl.setOnClickListener(this);
      super.a(paramaggl, paramagjk);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject2);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject3);
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView = localVideoProgressView;
      paramBaseChatItemLayout.c = ((TextView)localObject1);
      paramBaseChatItemLayout.d = ((TextView)localObject5);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView = paramView;
    }
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setTag(Long.valueOf(localMessageForShortVideo.uniseq));
    bhjz.a().a(Long.valueOf(localMessageForShortVideo.uniseq), localMessageForShortVideo);
    if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend != bool)
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend = bool;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.invalidate();
    }
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnClickListener(this);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnTouchListener(paramagjk);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnLongClickListener(paramagjk);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setRadius(15.0F, true);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setShowCorner(true);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setSharpCornerCor(BubbleImageView.a);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setCornerDirection(bool);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    azvd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
    paramChatMessage = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    label1017:
    int j;
    if (bool)
    {
      paramChatMessage.leftMargin = 0;
      paramChatMessage.rightMargin = agej.a(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), localResources);
      paramChatMessage = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.d.getLayoutParams();
      if (!bool) {
        break label1339;
      }
      paramChatMessage.rightMargin = (agej.a(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), localResources) / 2);
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(localMessageForShortVideo.videoFileTime * 1000));
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramChatMessage = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      paramView = ShortVideoUtils.a(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
      i = paramView[0];
      j = paramView[1];
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView, msg.uniseq = " + localMessageForShortVideo.uniseq + " msg.thumbWidth = " + localMessageForShortVideo.thumbWidth + ", msg.thumbHeight = " + localMessageForShortVideo.thumbHeight + ", adjustWidth = " + i + ", adjustHeight = " + j);
      }
      paramView = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getLayoutParams();
      if (paramView != null) {
        break label1361;
      }
      paramView = new RelativeLayout.LayoutParams(i, j);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramView);
      label1203:
      paramView = paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getLayoutParams();
      if (paramView != null) {
        break label1403;
      }
      paramView = new LinearLayout.LayoutParams(i, j);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setLayoutParams(paramView);
      label1237:
      if (bcwu.jdField_a_of_type_Boolean)
      {
        bcwu.jdField_a_of_type_Long = System.currentTimeMillis();
        bcwu.jdField_a_of_type_Boolean = false;
      }
      paramView = a(i, j);
      b(paramBaseChatItemLayout);
      d(localMessageForShortVideo, paramBaseChatItemLayout);
      if ((localMessageForShortVideo.md5 != null) || (localMessageForShortVideo.CheckIsHotVideo()) || (localMessageForShortVideo.isCancelStatus())) {
        break label1445;
      }
      a(localMessageForShortVideo, paramBaseChatItemLayout, paramChatMessage, i, j);
    }
    label1339:
    label1361:
    label1403:
    do
    {
      return paramaggl;
      paramChatMessage.leftMargin = agej.a(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), localResources);
      paramChatMessage.rightMargin = 0;
      break;
      paramChatMessage.leftMargin = (agej.a(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), localResources) / 2);
      break label1017;
      if ((paramView.width == i) && (paramView.height == j)) {
        break label1203;
      }
      paramView.width = i;
      paramView.height = j;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramView);
      break label1203;
      if ((paramView.width == i) && (paramView.height == j)) {
        break label1237;
      }
      paramView.width = i;
      paramView.height = j;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setLayoutParams(paramView);
      break label1237;
      paramBaseChatItemLayout.c.setVisibility(8);
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.videoFileSize));
      paramBaseChatItemLayout.d.setVisibility(8);
    } while (!a(paramChatMessage, localMessageForShortVideo, paramBaseChatItemLayout, i, j, paramView));
    label1445:
    a(localMessageForShortVideo, paramBaseChatItemLayout);
    return paramaggl;
  }
  
  public bhuk a(bhuk parambhuk, ChatMessage paramChatMessage, aghd paramaghd)
  {
    boolean bool3 = false;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramaghd = (ahrh)paramaghd;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.a(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForShortVideo.videoFileStatus));
    }
    b(parambhuk, this.jdField_a_of_type_AndroidContentContext);
    int i;
    boolean bool1;
    label221:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramChatMessage = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (bhmi.b(paramChatMessage))
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
        if ((paramaghd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView == null) || (!paramaghd.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramaghd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaghd.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
          break label479;
        }
        bool1 = true;
        bool2 = bool3;
        if (paramaghd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
        {
          bool2 = bool3;
          if (paramaghd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
            bool2 = true;
          }
        }
        if ((!bool4) || (bool1) || (bool2)) {
          break label432;
        }
        parambhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
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
      if ((localMessageForShortVideo != null) && (bhmi.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))) {
        parambhuk.a(2131366320, this.jdField_a_of_type_AndroidContentContext.getString(2131691990), 2130838938);
      }
      this.f = true;
      return parambhuk;
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
    if (bhnt.a(paramChatMessage.issend)) {
      return anzj.a(2131712908);
    }
    return anzj.a(2131712960);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing()))
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      this.jdField_a_of_type_Bhpc = null;
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
            MessageForShortVideo localMessageForShortVideo = bhjz.a().a(Integer.valueOf(localCropBubbleVideoView.getId()));
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
    do
    {
      MessageForShortVideo localMessageForShortVideo;
      do
      {
        do
        {
          do
          {
            return;
            localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
            this.d = paramInt;
            if (paramInt == 2131365352)
            {
              aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
              return;
            }
            if (paramInt == 2131371530)
            {
              super.d(paramChatMessage);
              return;
            }
            if (paramInt != 2131367078) {
              break;
            }
            c(localMessageForShortVideo);
          } while (!paramChatMessage.isMultiMsg);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 6, 0, "6", "", "", "");
          return;
          if (paramInt != 2131366320) {
            break;
          }
        } while (!e((MessageForShortVideo)paramChatMessage));
        bmko.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
        bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
      } while (!paramChatMessage.isMultiMsg);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 6, 0, "6", "", "", "");
      return;
      if (paramInt == 2131371487)
      {
        d(localMessageForShortVideo);
        return;
      }
      if (paramInt != 2131371594) {
        break label337;
      }
      paramContext = a(paramChatMessage.uniseq);
      if (paramContext != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoItemBuilder", 2, "onMenuItemClicked(), mute_play, holder == null, message.uniseq = " + paramChatMessage.uniseq);
    return;
    a(paramContext, true);
    bdll.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 2, 0, "", "", "", "");
    return;
    label337:
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(ahrh paramahrh)
  {
    if (a(paramahrh)) {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "disProgress...file is saving, so return!");
      }
    }
    do
    {
      return;
      if (!a(paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "disProgress fail...video order sending! " + paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return;
    if (!paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
      return;
    }
    paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimRunnableListener(new ahqz(this, paramahrh));
  }
  
  protected void a(ahrh paramahrh, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 100)
    {
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(paramInt, paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    for (;;)
    {
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVideoCompressStatus(false);
      paramahrh.c.setVisibility(8);
      return;
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(paramInt, paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
  }
  
  public void a(ahrh paramahrh, MessageForShortVideo paramMessageForShortVideo)
  {
    b(paramahrh);
    if (b(paramahrh)) {}
    do
    {
      return;
      paramahrh = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    } while (bhmi.b(paramahrh));
    bcxn localbcxn = bcwu.a(2, this.jdField_c_of_type_Int);
    bcwx localbcwx = paramMessageForShortVideo.getDownloadInfo(localbcxn.jdField_b_of_type_Int);
    localbcwx.i = paramahrh;
    if ((paramMessageForShortVideo.istroop == 0) || (paramMessageForShortVideo.istroop == 1008)) {
      localbcwx.e = 1002;
    }
    for (;;)
    {
      localbcxn.a(localbcwx);
      localbcxn.a(paramMessageForShortVideo);
      bcwu.a(localbcxn, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      if (paramMessageForShortVideo.istroop == 3000) {
        localbcwx.e = 1006;
      } else if (paramMessageForShortVideo.istroop == 1) {
        localbcwx.e = 1004;
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (ahrh)agej.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      blir localblir = (blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null);
      localblir.a(2131689933, 5);
      localblir.c(2131690580);
      localblir.a(new ahre(this, localMessageForShortVideo, paramView, localblir));
      localblir.show();
      if (localMessageForShortVideo.videoFileStatus == 1004) {
        ShortVideoUtils.c("0X800A374", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(View paramView, bete parambete, int paramInt1, int paramInt2)
  {
    MessageForShortVideo localMessageForShortVideo;
    do
    {
      try
      {
        paramView = (ahrh)agej.a(paramView);
        localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        VideoProgressView localVideoProgressView = paramView.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView;
        if (localMessageForShortVideo.uniseq != parambete.jdField_b_of_type_Long) {
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.e("ShortVideoItemBuilder", 2, "handleMessage getHolder error ! ", paramView);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "handleMessage msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType:" + ShortVideoUtils.a(parambete.jdField_b_of_type_Int) + " ===> fileStatus:" + ShortVideoUtils.b(parambete.d));
      }
      if ((parambete.jdField_b_of_type_Int == 6) || (parambete.jdField_b_of_type_Int == 17) || (parambete.jdField_b_of_type_Int == 9) || (parambete.jdField_b_of_type_Int == 20))
      {
        c(parambete, paramView, localMessageForShortVideo);
        return;
      }
    } while ((parambete.jdField_b_of_type_Int != 7) && (parambete.jdField_b_of_type_Int != 18) && (parambete.jdField_b_of_type_Int != 16));
    d(parambete, paramView, localMessageForShortVideo);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296338);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.h, i, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  public void a(bete parambete, ahrh paramahrh, MessageForShortVideo paramMessageForShortVideo)
  {
    b(paramahrh);
    a(paramahrh);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "handleReceiveProcess, getAIOState() = " + a());
    }
    if (a() != 4) {}
    do
    {
      do
      {
        return;
      } while ((parambete.c == null) || (!d(paramMessageForShortVideo)) || (b(paramahrh)) || (c(paramMessageForShortVideo)));
      String[] arrayOfString = parambete.c;
      parambete = parambete.u;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_RECV_PROCESS: domain=" + parambete + ", videoUrls=" + Arrays.toString(arrayOfString));
      }
      String str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      int[] arrayOfInt = ShortVideoUtils.a(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
      int j = arrayOfInt[0];
      int k = arrayOfInt[1];
      i = 0;
      while (i < 1)
      {
        if (!TextUtils.isEmpty(parambete)) {
          arrayOfString[i] = (arrayOfString[i] + "&txhost=" + parambete);
        }
        i += 1;
      }
      a(paramahrh, false, paramMessageForShortVideo, null, arrayOfString, str, j, k);
      if ((paramMessageForShortVideo.CheckIsHotVideo()) && (!bhjz.a().a(paramMessageForShortVideo, "0X8007EDB")))
      {
        bhjz.a().a(paramMessageForShortVideo, "0X8007EDB");
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
      }
    } while (bhjz.a().a(paramMessageForShortVideo, "0X80077D9"));
    int i = odr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    parambete = new JSONObject();
    try
    {
      parambete.put("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      parambete.put("memNum", i);
      parambete.put("msg_uniseq", paramMessageForShortVideo.uniseq);
      label400:
      ocd.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", odr.a(paramMessageForShortVideo.getMd5(), null, null, null, parambete), false);
      bhjz.a().a(paramMessageForShortVideo, "0X80077D9");
      return;
    }
    catch (Exception paramahrh)
    {
      break label400;
    }
  }
  
  void a(bhvc parambhvc, ahrh paramahrh, MessageForShortVideo paramMessageForShortVideo)
  {
    if (parambhvc == null)
    {
      paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      b(paramahrh);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_PROCESS, 上传过程中被杀进程然后恢复, uniseq:" + paramMessageForShortVideo.uniseq);
      }
      return;
    }
    if (((bbnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).b(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq))
    {
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(10, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      return;
    }
    int j = paramMessageForShortVideo.videoFileProgress;
    int i = j;
    if ((parambhvc instanceof bexk))
    {
      parambhvc = (bexk)parambhvc;
      i = j;
      if (parambhvc.a() != 0L) {
        i = (int)(100L * parambhvc.b() / parambhvc.a());
      }
    }
    a(paramahrh, ShortVideoUtils.a(i, 10), false);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 998) {
      return;
    }
    if ((TextUtils.isEmpty(paramMessageForShortVideo.md5)) || (paramMessageForShortVideo.videoFileStatus == 1004))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718201, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      return;
    }
    String str = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    boolean bool2 = NetworkUtils.isMobileConnected(this.jdField_a_of_type_AndroidContentContext);
    if ((bcwu.jdField_a_of_type_Long != 0L) && (System.currentTimeMillis() - bcwu.jdField_a_of_type_Long < 300000L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "startPlayVideo isConfirmed=" + bool1 + " allowPlayInXGTime=" + bcwu.jdField_a_of_type_Long + " isXGConnected = " + bool2);
      }
      if ((!bool2) || (bool1) || ((bhmi.a(str)) && (paramMessageForShortVideo.videoFileStatus != 2002)) || (paramMessageForShortVideo.videoFileSize < 1048576)) {
        break label348;
      }
      if (!bjhk.a((Activity)this.jdField_a_of_type_AndroidContentContext, 3, new ahrb(this, paramMessageForShortVideo, paramLong, paramBoolean))) {
        break;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131717151);
      this.jdField_a_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131717154), str, this.jdField_a_of_type_AndroidContentContext.getString(2131717152), this.jdField_a_of_type_AndroidContentContext.getString(2131717153), new ahrc(this, paramMessageForShortVideo, paramLong, paramBoolean), new ahrd(this));
      paramMessageForShortVideo = awzq.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
      if ((paramMessageForShortVideo instanceof SpannableString)) {
        this.jdField_a_of_type_Bhpc.setMessageWithoutAutoLink(paramMessageForShortVideo);
      }
      try
      {
        this.jdField_a_of_type_Bhpc.show();
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
  
  void a(MessageForShortVideo paramMessageForShortVideo, ahrh paramahrh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView ，video no exits: sendFromLocal=" + paramMessageForShortVideo.isSendFromLocal() + "===>  fileType:" + ShortVideoUtils.a(paramMessageForShortVideo.fileType) + " ===> videoFileStatus:" + ShortVideoUtils.b(paramMessageForShortVideo.videoFileStatus) + "===> videoFileProgress:" + paramMessageForShortVideo.videoFileProgress + ", uniseq:" + paramMessageForShortVideo.uniseq);
    }
    bhvc localbhvc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9) || (paramMessageForShortVideo.fileType == 19) || (paramMessageForShortVideo.fileType == 20)) {}
    switch (paramMessageForShortVideo.videoFileStatus)
    {
    default: 
    case 1001: 
      do
      {
        return;
        if (localbhvc != null) {
          break;
        }
        paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        b(paramahrh);
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_START, 上传开始被杀进程然后恢复, uniseq:" + paramMessageForShortVideo.uniseq);
      return;
      a(paramahrh, ShortVideoUtils.a(paramMessageForShortVideo.videoFileProgress, 10), false);
      return;
    case 1004: 
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      b(paramahrh);
      a(paramahrh, true, this);
      return;
    case 1002: 
      a(localbhvc, paramahrh, paramMessageForShortVideo);
      return;
    case 1003: 
      b(paramahrh);
      return;
    case 2001: 
      b(paramahrh);
      return;
    case 2004: 
      b(paramahrh);
      return;
    case 2002: 
      b(paramahrh);
      return;
    }
    a(paramahrh, 2131717503);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, ahrh paramahrh, String paramString, int paramInt1, int paramInt2)
  {
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      paramahrh.jdField_a_of_type_AndroidWidgetTextView.setText("");
      if (bhmi.b(paramString))
      {
        a(paramahrh, paramMessageForShortVideo, paramString, paramInt1, paramInt2, false);
        if (paramMessageForShortVideo.videoFileStatus != 1005) {
          break label64;
        }
        paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(2);
        paramahrh.c.setVisibility(8);
      }
    }
    label64:
    do
    {
      return;
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramahrh.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramahrh.d.setVisibility(8);
      paramahrh.c.setVisibility(8);
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      if ((paramMessageForShortVideo.videoFileStatus != 998) || (b(paramMessageForShortVideo)))
      {
        paramahrh = new bcyq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, this.jdField_a_of_type_Ahrg);
        bcyp.a().a(paramMessageForShortVideo.uniseq, paramahrh);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView(): msg.md5 == null, start compress task, id:" + paramMessageForShortVideo.uniseq);
        }
      }
      paramMessageForShortVideo = bcyp.a().a(paramMessageForShortVideo.uniseq);
    } while (paramMessageForShortVideo == null);
    paramMessageForShortVideo.a(this.jdField_a_of_type_Ahrg);
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
        label78:
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
      for (i = 1;; i = 0)
      {
        int j = i;
        if (paramChatMessage.uiOperatorFlag == 1)
        {
          j = i;
          if (paramChatMessage.videoFileStatus == 1004)
          {
            a("2152 msg send cancel:", paramChatMessage);
            j = 1;
          }
        }
        if (a(paramChatMessage)) {
          j = 1;
        }
        if ((k == 0) && (j == 0)) {
          break;
        }
        return true;
        i = 0;
        break label78;
      }
    }
  }
  
  protected boolean a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq) == null) {
      if (paramMessageForShortVideo.CheckIsHotVideo())
      {
        if ((paramMessageForShortVideo.videoFileProgress != 100) && (paramMessageForShortVideo.videoFileStatus != 1003) && (paramMessageForShortVideo.videoFileStatus != 1004) && (paramMessageForShortVideo.videoFileStatus != 2009) && (paramMessageForShortVideo.uiOperatorFlag != 2) && (paramMessageForShortVideo.videoFileStatus != 2003) && (paramMessageForShortVideo.videoFileStatus != 2002)) {
          a("2164 msg.videoFileProgress = " + paramMessageForShortVideo.videoFileProgress + " msg.videoFileStatus = " + paramMessageForShortVideo.videoFileStatus, paramMessageForShortVideo);
        }
      }
      else {
        while ((paramMessageForShortVideo.videoFileProgress != 100) && (paramMessageForShortVideo.videoFileStatus != 1003) && (paramMessageForShortVideo.videoFileStatus != 1004) && (paramMessageForShortVideo.videoFileStatus != 2009) && (paramMessageForShortVideo.uiOperatorFlag != 2) && (paramMessageForShortVideo.videoFileStatus != 2003) && (paramMessageForShortVideo.videoFileStatus != 998) && (paramMessageForShortVideo.isAllowAutoDown == true)) {
          return true;
        }
      }
    }
    return false;
  }
  
  protected boolean a(String paramString, MessageForShortVideo paramMessageForShortVideo, ahrh paramahrh, int paramInt1, int paramInt2)
  {
    if ((paramMessageForShortVideo.videoFileStatus == 998) || (paramMessageForShortVideo.videoFileStatus == 1001) || (paramMessageForShortVideo.videoFileStatus == 1002) || (paramMessageForShortVideo.videoFileStatus == 1004)) {}
    for (int i = 1; (!d(paramMessageForShortVideo)) || ((paramMessageForShortVideo.isSendFromLocal()) && (i != 0)) || (b(paramahrh)) || (c(paramMessageForShortVideo)) || (a(paramMessageForShortVideo.uniseq)); i = 0)
    {
      a(paramahrh, paramMessageForShortVideo, paramString, paramInt1, paramInt2, false);
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      return true;
    }
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView(): videoPath = " + (String)localObject);
    }
    File localFile = new File((String)localObject);
    long l1;
    label202:
    boolean bool1;
    label213:
    boolean bool2;
    if (localFile.exists())
    {
      long l2 = localFile.length();
      if (paramMessageForShortVideo.videoFileTime <= 8)
      {
        l1 = paramMessageForShortVideo.videoFileSize;
        if (l2 >= l1) {
          break label372;
        }
        bool1 = true;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("ShortVideoItemBuilder", 2, "===> 1 video file  exits, downloadedSize =" + l2 + ", estimatedSize=" + l1 + ", needDownload=" + bool1 + ",videoFileTime=" + paramMessageForShortVideo.videoFileTime);
          bool2 = bool1;
        }
        label289:
        if (!bool2) {
          break label410;
        }
        if ((!bhnv.h(this.jdField_a_of_type_AndroidContentContext)) || (paramMessageForShortVideo.videoFileStatus == 5002)) {
          break label399;
        }
        localObject = bcwu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo, 2);
        if (localObject != null) {
          bcwu.a((bcxn)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
    }
    for (;;)
    {
      a(paramahrh, paramMessageForShortVideo, paramString, paramInt1, paramInt2, true);
      break;
      l1 = rwe.a(8, paramMessageForShortVideo.videoFileTime, paramMessageForShortVideo.videoFileSize);
      break label202;
      label372:
      bool1 = false;
      break label213;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "===> 2 video file no exits, need download video.");
      }
      bool2 = true;
      break label289;
      label399:
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
    }
    label410:
    a(paramahrh, true, paramMessageForShortVideo, (String)localObject, null, paramString, paramInt1, paramInt2);
    if (paramMessageForShortVideo.videoFileTime <= 8) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      a(paramahrh);
      if (paramInt1 == 0) {
        paramahrh.d.setVisibility(0);
      }
      b(paramMessageForShortVideo);
      return false;
    }
  }
  
  protected boolean a(String paramString, MessageForShortVideo paramMessageForShortVideo, ahrh paramahrh, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    boolean bool2 = true;
    boolean bool1;
    if (bhmi.b(paramString)) {
      bool1 = a(paramString, paramMessageForShortVideo, paramahrh, paramInt1, paramInt2);
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (((paramMessageForShortVideo.fileType != 7) && (paramMessageForShortVideo.fileType != 18) && (paramMessageForShortVideo.fileType != 16)) || (paramMessageForShortVideo.videoFileStatus != 5002)) {
            break;
          }
          paramahrh.d.setVisibility(8);
          paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
          paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramDrawable);
          a(paramahrh, 2131717503);
          bool1 = bool2;
        } while (!QLog.isColorLevel());
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not download pic : 缩略图不存在，而且文件已经过期，不下载, , uniseq:" + paramMessageForShortVideo.uniseq);
        return true;
        bool1 = bool2;
      } while (paramMessageForShortVideo.extraflag == 32768);
      bool1 = bool2;
    } while (b(paramahrh));
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not SendFromLocal : 缩略图不存在，开始下载缩略图, , uniseq:" + paramMessageForShortVideo.uniseq);
    }
    paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramDrawable);
    paramString = bcwu.a(2, this.jdField_c_of_type_Int);
    paramahrh = paramMessageForShortVideo.getDownloadInfo(paramString.jdField_b_of_type_Int);
    paramahrh.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if ((paramMessageForShortVideo.istroop == 0) || (paramMessageForShortVideo.istroop == 1008)) {
      paramahrh.e = 1002;
    }
    for (;;)
    {
      paramahrh.f = 2;
      paramString.a(paramahrh);
      paramString.a(paramMessageForShortVideo);
      bcwu.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return true;
      if (paramMessageForShortVideo.istroop == 3000) {
        paramahrh.e = 1006;
      } else if (paramMessageForShortVideo.istroop == 1) {
        paramahrh.e = 1004;
      }
    }
  }
  
  public bhum[] a(View paramView)
  {
    paramView = (ahrh)agej.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bhuk localbhuk = new bhuk();
    if (localMessageForShortVideo != null)
    {
      if (!localMessageForShortVideo.isMultiMsg) {
        break label48;
      }
      a(localbhuk, localMessageForShortVideo, paramView);
    }
    for (;;)
    {
      return localbhuk.a();
      label48:
      b(localbhuk, localMessageForShortVideo, paramView);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public bhuk b(bhuk parambhuk, ChatMessage paramChatMessage, aghd paramaghd)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    ahrh localahrh = (ahrh)paramaghd;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.a(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForShortVideo.videoFileStatus));
    }
    b(parambhuk, this.jdField_a_of_type_AndroidContentContext);
    int i;
    boolean bool1;
    label223:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramaghd = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (bhmi.b(paramaghd))
      {
        paramaghd = "";
        i = 1;
        if (i == 0) {
          break label581;
        }
        if (!"1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"))) {
          break label562;
        }
        boolean bool3 = localMessageForShortVideo.checkForward();
        if ((localahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView == null) || (!localahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(localahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + localahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
          break label575;
        }
        bool1 = true;
        if ((localahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (localahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0)) {
          break label569;
        }
        bool2 = true;
        label251:
        if ((!bool3) || (bool1) || (bool2)) {
          break label522;
        }
        parambhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
        paramaghd = paramaghd + "inMiddleStatus = false, progeressBarShowing = false, errorIconShowing = false, show forward menu.";
      }
    }
    label522:
    label562:
    label569:
    label575:
    label581:
    for (;;)
    {
      a(localMessageForShortVideo, parambhuk);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getMenuItem: " + paramaghd);
      }
      if ((localMessageForShortVideo != null) && ((localahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (localahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0))) {
        a(parambhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForShortVideo);
      }
      a(parambhuk, localMessageForShortVideo);
      if ((localMessageForShortVideo != null) && (bhmi.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))) {
        parambhuk.a(2131366320, this.jdField_a_of_type_AndroidContentContext.getString(2131691990), 2130838938);
      }
      super.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo, false);
      b(paramChatMessage, parambhuk);
      super.c(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      this.f = true;
      return parambhuk;
      paramaghd = "thumbFilePath=" + paramaghd + " , not exits.";
      i = 0;
      break;
      paramaghd = " msg == null or md5 is empty.";
      i = 0;
      break;
      paramaghd = paramaghd + "progeressBarShowing=" + bool1 + ", errorIconShowing=" + bool2;
      continue;
      paramaghd = " not inDPCWhiteList.";
      continue;
      bool2 = false;
      break label251;
      bool1 = false;
      break label223;
    }
  }
  
  protected void b(ahrh paramahrh)
  {
    if (a(paramahrh)) {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "hideProgress...file is saving, so return!");
      }
    }
    do
    {
      return;
      if (!a(paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "hideProgress fail...video order sending! " + paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return;
    paramahrh.c.setVisibility(8);
    if (!paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(2);
      return;
    }
    paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimRunnableListener(new ahqx(this, paramahrh));
  }
  
  public void b(bete parambete, ahrh paramahrh, MessageForShortVideo paramMessageForShortVideo)
  {
    int j = 0;
    int i;
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      if (parambete.jdField_a_of_type_Long == 0L) {
        break label49;
      }
      i = (int)(100L * parambete.e / parambete.jdField_a_of_type_Long);
    }
    for (;;)
    {
      a(paramahrh, ShortVideoUtils.a(i, 10), true);
      return;
      label49:
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.e("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS: fileSize == 0 ");
        i = j;
      }
    }
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo.CheckIsHotVideo()) && (!bhjz.a().a(paramMessageForShortVideo, "0X8007EDB")))
    {
      bhjz.a().a(paramMessageForShortVideo, "0X8007EDB");
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
    }
    int i;
    JSONObject localJSONObject;
    if (!bhjz.a().a(paramMessageForShortVideo, "0X80077D9"))
    {
      i = odr.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("memNum", i);
      localJSONObject.put("msg_uniseq", paramMessageForShortVideo.uniseq);
      label150:
      ocd.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", odr.a(paramMessageForShortVideo.getMd5(), null, null, null, localJSONObject), false);
      bhjz.a().a(paramMessageForShortVideo, "0X80077D9");
      return;
    }
    catch (Exception localException)
    {
      break label150;
    }
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("muate_play", paramBoolean);
    a(paramMessageForShortVideo, paramLong, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localBundle, null);
    ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, ahrh paramahrh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    boolean bool = paramMessageForShortVideo.CheckIsHotVideo();
    String str1 = paramMessageForShortVideo.videoFileName;
    String str2 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if ((!bhmi.b(str1)) && (!bool))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718240, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      b(paramahrh);
      paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if ((!bhmi.b(str2)) && (!bool))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718241, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      b(paramahrh);
      paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((bbnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    paramahrh = bcwu.a(1, this.jdField_c_of_type_Int);
    paramMessageForShortVideo = bcwu.a(this.jdField_c_of_type_Int, paramMessageForShortVideo, paramahrh);
    paramMessageForShortVideo.e = bool;
    paramahrh.a(paramMessageForShortVideo);
    bcwu.a(paramahrh, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void c(bete parambete, ahrh paramahrh, MessageForShortVideo paramMessageForShortVideo)
  {
    switch (parambete.d)
    {
    default: 
      return;
    case 1001: 
      if (parambete.jdField_a_of_type_Long == 0L) {
        break;
      }
    }
    for (int i = (int)(100L * parambete.e / parambete.jdField_a_of_type_Long);; i = 0)
    {
      a(paramahrh, ShortVideoUtils.a(i, 10), true);
      paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      c(paramahrh);
      return;
      a(paramahrh, 100, true);
      b(paramahrh);
      b(paramahrh, false, null);
      bcyp.a().a(paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
      b(paramahrh);
      paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      bcyp.a().a(paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
      paramahrh.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      b(paramahrh);
      a(paramahrh, true, this);
      bcyp.a().a(paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
      b(paramahrh);
      b(paramahrh, false, null);
      bcyp.a().a(paramahrh.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
      b(parambete, paramahrh, paramMessageForShortVideo);
      return;
      b(paramahrh);
      paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      return;
      a(paramahrh, paramMessageForShortVideo);
      return;
      b(paramahrh);
      if (parambete.g == -5100528) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718235, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      return;
      a(paramahrh, 2131717502);
      if (paramMessageForShortVideo.uiOperatorFlag == 2)
      {
        paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718209, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
        return;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718233, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      return;
      a(paramahrh, 2131717503);
      if (paramMessageForShortVideo.uiOperatorFlag == 2)
      {
        paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718210, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
        return;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718234, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      return;
      b(paramahrh);
      return;
      a(parambete, paramahrh, paramMessageForShortVideo);
      return;
    }
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo)
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
    if (bhmi.b(str2))
    {
      localBundle.putBoolean("k_dataline", true);
      localBundle.putString("forward_extra", str2);
      localBundle.putBoolean("direct_send_if_dataline_forward", true);
      localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    paramMessageForShortVideo = new Intent();
    paramMessageForShortVideo.putExtras(localBundle);
    auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "1", "", "");
  }
  
  protected void c(MessageForShortVideo paramMessageForShortVideo, ahrh paramahrh)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "reForwardVideo：" + paramMessageForShortVideo.toString());
      }
      if (!bhmi.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718241, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
        b(paramahrh);
        paramahrh.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        ((bbnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
        paramahrh = bcwu.a(4, this.jdField_c_of_type_Int);
        paramahrh.a(bcwu.a(this.jdField_c_of_type_Int, paramMessageForShortVideo, paramahrh));
        bcwu.a(paramahrh, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
  
  public void d(bete parambete, ahrh paramahrh, MessageForShortVideo paramMessageForShortVideo)
  {
    switch (parambete.d)
    {
    default: 
    case 2001: 
    case 2003: 
    case 2005: 
      label258:
      label270:
      do
      {
        int k;
        do
        {
          do
          {
            return;
          } while (!QLog.isColorLevel());
          QLog.d("ShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_START:");
          return;
          parambete = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
          localObject = ShortVideoUtils.a(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
          j = localObject[0];
          k = localObject[1];
        } while ((!d(paramMessageForShortVideo)) || (b(paramahrh)) || (c(paramMessageForShortVideo)));
        Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
        File localFile = new File((String)localObject);
        long l1;
        if (localFile.exists())
        {
          long l2 = localFile.length();
          if (paramMessageForShortVideo.videoFileTime <= 8)
          {
            l1 = paramMessageForShortVideo.videoFileSize;
            if (l2 < l1) {
              break label258;
            }
            i = 0;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label270;
          }
          if (bhnv.h(this.jdField_a_of_type_AndroidContentContext))
          {
            localObject = bcwu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo, 2);
            if (localObject != null) {
              bcwu.a((bcxn)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
          }
          a(paramahrh, paramMessageForShortVideo, parambete, j, k, true);
          return;
          l1 = rwe.a(8, paramMessageForShortVideo.videoFileTime, paramMessageForShortVideo.videoFileSize);
          break;
          i = 1;
          continue;
          i = 1;
        }
        if (paramMessageForShortVideo.videoFileTime <= 8) {}
        for (i = 1;; i = 0)
        {
          a(paramahrh, true, paramMessageForShortVideo, (String)localObject, null, parambete, j, k);
          a(paramahrh);
          if (i == 0) {
            break;
          }
          paramahrh.d.setVisibility(8);
          return;
        }
        paramahrh.d.setVisibility(0);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_ERROR:");
      return;
    }
    parambete = ShortVideoUtils.a(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    int i = parambete[0];
    int j = parambete[1];
    paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    paramahrh.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(a(i, j));
    a(paramahrh, 2131717503);
    paramahrh.d.setVisibility(8);
  }
  
  public void d(MessageForShortVideo paramMessageForShortVideo)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked(): msg_revoke =>" + paramMessageForShortVideo.toLogString());
    }
    if (paramMessageForShortVideo.md5 == null)
    {
      bcyp.a().b(paramMessageForShortVideo.uniseq);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(paramMessageForShortVideo.uniseq);
      ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(20)).a(paramMessageForShortVideo.istroop).d(paramMessageForShortVideo);
      bbnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return;
      bhvc localbhvc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      if ((localbhvc != null) && ((bexk.class.isInstance(localbhvc)) || (bexd.class.isInstance(localbhvc))))
      {
        boolean bool = ((berp)localbhvc).d();
        i = paramMessageForShortVideo.videoFileStatus;
        if ((bool) || (i == 1002) || (i == 1001))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
          ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(20)).a(paramMessageForShortVideo.istroop).d(paramMessageForShortVideo);
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
          i = j;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked: stop uploading short video");
          }
        }
      }
      for (int i = j; i != 0; i = 1)
      {
        super.a(paramMessageForShortVideo);
        return;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    Object localObject1 = (ahrh)agej.a(paramView);
    jdField_a_of_type_AndroidGraphicsRect = a(paramView, (MessageForShortVideo)((ahrh)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    agej.n = true;
    long l = System.currentTimeMillis();
    if ((l - jdField_c_of_type_Long < 1000L) && (l > jdField_c_of_type_Long)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoItemBuilder", 2, "click too offen,please try again later ");
      }
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      jdField_c_of_type_Long = l;
      if ((paramView.getId() == 2131364423) || (paramView.getId() == 2131364466))
      {
        a((ahrh)localObject1, false);
      }
      else if (paramView.getId() == 2131364442)
      {
        localStringBuilder = new StringBuilder();
        if (!((ahrh)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((ahrh)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((ahrh)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          if ((!(localObject2 instanceof bexk)) || (!((bexk)localObject2).b)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "CompressTask pauseOperator!");
          }
        }
      }
    }
    Object localObject2 = bcyp.a().a(((ahrh)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    if (localObject2 != null)
    {
      ((bcyq)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.isPause = true;
      boolean bool = ((bcyq)localObject2).cancel(true);
      localStringBuilder.append("\n ShortVideoItemBuilder task cancel:").append(bool);
      localStringBuilder.append("\n md5 info:").append(((MessageForShortVideo)((ahrh)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).md5);
      if ((bool) && (((MessageForShortVideo)((ahrh)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).md5 == null))
      {
        bool = ((bcyq)localObject2).a();
        localStringBuilder.append("\n media codec cancel:").append(bool);
        if (!bool) {
          break label444;
        }
        localStringBuilder.append("\n ffmpeg process cancel!");
      }
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((ahrh)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((ahrh)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if ((localObject1 instanceof bexk))
      {
        ((bexk)localObject1).c();
        localStringBuilder.append("\n upload process pause!");
      }
      ShortVideoUtils.c("0X800A373", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShortVideoItemBuilder", 2, "CompressTask pauseOperator info:" + localStringBuilder.toString());
      break;
      label444:
      localStringBuilder.append("\n ffmpeg process cancel exception!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqw
 * JD-Core Version:    0.7.0.1
 */