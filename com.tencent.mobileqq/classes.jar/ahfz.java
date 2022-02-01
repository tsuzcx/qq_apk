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
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.10;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.11;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.8;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
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

public class ahfz
  extends BaseBubbleBuilder
  implements afqw, afsn, ShortVideoConstants
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect;
  private static CopyOnWriteArraySet<CropBubbleVideoView> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  public static AtomicLong a;
  private static long c;
  private ahgj jdField_a_of_type_Ahgj;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahgi(this);
  private axjk jdField_a_of_type_Axjk;
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
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
  
  public ahfz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = 0;
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if (this.jdField_a_of_type_Axjk == null) {
      this.jdField_a_of_type_Axjk = ((axjk)paramQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER));
    }
    this.jdField_a_of_type_Ahgj = new ahgj(this, null);
  }
  
  private ahgk a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int i = AIOUtils.findMessagePosition(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (i <= -1) {
        break label215;
      }
      Object localObject = AIOUtils.getViewByPostion(this.jdField_a_of_type_ComTencentWidgetListView, i);
      if (localObject != null)
      {
        localObject = AIOUtils.getHolder((View)localObject);
        if ((localObject != null) && ((localObject instanceof ahgk))) {
          return (ahgk)localObject;
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
  
  private ahgk a(MessageForShortVideo paramMessageForShortVideo)
  {
    ahgk localahgk = a(paramMessageForShortVideo.uniseq);
    if ((localahgk == null) && (QLog.isColorLevel())) {
      QLog.d("ShortVideoItemBuilder", 2, "holder is null, seq = " + paramMessageForShortVideo.uniseq);
    }
    return localahgk;
  }
  
  private Rect a(View paramView, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramView == null) || (paramMessageForShortVideo == null)) {
      return null;
    }
    paramView = paramView.findViewById(2131362355);
    if ((paramView instanceof CropBubbleVideoView))
    {
      paramView = (CropBubbleVideoView)paramView;
      Rect localRect = aavz.a(paramView);
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
    return new asbg(Color.rgb(214, 214, 214), paramInt1, paramInt2);
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Drawable localDrawable = null;
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.getThumbPicUrl(paramString);
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
      localObject = bhbz.a().a(Long.valueOf(paramLong));
      if ((!bhbz.a().a(Long.valueOf(paramLong))) && (localObject != null))
      {
        ShortVideoUtils.reportVideoPlay(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, this.jdField_a_of_type_AndroidContentContext);
        if (!bhbz.a().b(Long.valueOf(((MessageForShortVideo)localObject).uniseq)))
        {
          bhbz.a().a(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
          ShortVideoUtils.reportVideoPlay(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E50", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject, this.jdField_a_of_type_AndroidContentContext);
        }
        bhbz.a().a(Long.valueOf(paramLong), true);
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
          if (((MessageForShortVideo)((ahgk)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage).videoFileTime <= 8) {}
          for (bool = true; paramInt == 5; bool = false)
          {
            this.jdField_b_of_type_AndroidOsHandler.postDelayed(new ShortVideoItemBuilder.10(this, bool, (ahgk)localObject), 1200L);
            return;
          }
          if ((paramInt != 7) && (paramInt != 8)) {
            break;
          }
          this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          ((ahgk)localObject).d.setVisibility(8);
          ((ahgk)localObject).jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
          b((ahgk)localObject);
          ((ahgk)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          ((ahgk)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        } while (paramInt != 8);
        localObject = bhbz.a().a(Long.valueOf(paramLong));
      } while (localObject == null);
      a((MessageForShortVideo)localObject, ((MessageForShortVideo)localObject).videoFileTime * 1000);
      return;
    } while (paramInt != 4);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (bool) {
      ((ahgk)localObject).d.setVisibility(8);
    }
    for (;;)
    {
      a((ahgk)localObject);
      ((ahgk)localObject).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      ((ahgk)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localObject = bhbz.a().a(Long.valueOf(paramLong));
      if (localObject == null) {
        break;
      }
      a((MessageForShortVideo)localObject, 0L);
      return;
      ((ahgk)localObject).d.setVisibility(0);
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
    paramString = AIOUtils.findMessage(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
    if ((paramString instanceof MessageForShortVideo))
    {
      paramString = (MessageForShortVideo)paramString;
      paramString.videoFileStatus = 5002;
      paramString.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(paramString.frienduin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramString.uniseq, paramString.msgData);
      this.jdField_b_of_type_AndroidOsHandler.post(new ShortVideoItemBuilder.11(this, paramString));
    }
    label218:
    bapw.a(paramInt3, paramVideoPlayParam);
  }
  
  private void a(ahgk paramahgk, int paramInt)
  {
    paramahgk.c.setVisibility(0);
    paramahgk.c.setText(paramInt);
    paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
    paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setImageResource(2130849774);
    paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(3);
  }
  
  private void a(ahgk paramahgk, View paramView, ChatMessage paramChatMessage)
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
        if ((bcxg.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.msgTailType)) && (paramChatMessage.istroop == 1))
        {
          if (paramahgk.e == null)
          {
            paramahgk.e = new TextView(this.jdField_a_of_type_AndroidContentContext);
            paramahgk.e.setBackgroundResource(2130842656);
            paramahgk.e.setTextSize(1, 12.0F);
            paramahgk.e.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167363));
            paramahgk.e.setText(bcxg.b(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.msgTailType));
            paramahgk.e.setSingleLine();
            paramahgk.e.setGravity(16);
            paramahgk.e.setPadding(DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0);
            paramahgk.e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
            paramChatMessage.addRule(3, 2131364522);
            paramChatMessage.addRule(5, 2131364522);
            if ((paramView instanceof ViewGroup)) {
              ((ViewGroup)paramView).addView(paramahgk.e, paramChatMessage);
            }
          }
          paramView = (RelativeLayout.LayoutParams)paramahgk.e.getLayoutParams();
          if (localMessageForShortVideo.isSend()) {}
          for (paramView.leftMargin = BaseChatItemLayout.k;; paramView.leftMargin = BaseChatItemLayout.j)
          {
            paramahgk.e.setTag(localMessageForShortVideo);
            paramahgk.e.setVisibility(0);
            return;
          }
        }
      } while (paramahgk.e == null);
      paramahgk.e.setVisibility(8);
      return;
    }
  }
  
  private void a(ahgk paramahgk, MessageForShortVideo paramMessageForShortVideo, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, msg.uniseq = " + paramMessageForShortVideo.uniseq);
    }
    paramString = ShortVideoUtils.getThumbUrl(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, url = " + paramString);
    }
    if ((QLog.isColorLevel()) && (paramahgk.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d.getURL()=" + paramahgk.jdField_a_of_type_ComTencentImageURLDrawable.getURL());
    }
    paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    if ((paramahgk.jdField_a_of_type_ComTencentImageURLDrawable != null) && (paramahgk.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d is reuse !!!");
      }
      if (paramBoolean)
      {
        paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setCoverDrawable(paramahgk.jdField_a_of_type_ComTencentImageURLDrawable);
        return;
      }
      paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramahgk.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    Drawable localDrawable = a(paramInt1, paramInt2);
    paramString = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localDrawable, localDrawable);
    paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramString);
    paramahgk.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
  }
  
  private void a(ahgk paramahgk, boolean paramBoolean)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    int i = localMessageForShortVideo.videoFileStatus;
    long l = 0L;
    if (paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView != null) {
      l = paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getCurPlayingPos();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "click ppv, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType: " + ShortVideoUtils.getFileTypeStr(localMessageForShortVideo.fileType) + ", fileStatus:" + ShortVideoUtils.getFileStatusStr(i) + ", playPosition:" + l);
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("......click ppv, msg.uniseq:" + localMessageForShortVideo.uniseq);
    String str = ShortVideoUtils.getShortVideoSavePath(localMessageForShortVideo, "mp4");
    if (!localMessageForShortVideo.isSendFromLocal()) {
      a(localMessageForShortVideo, localStringBuilder, i, str, paramahgk, l, paramBoolean);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, localStringBuilder.toString());
      }
      return;
      b(localMessageForShortVideo, localStringBuilder, i, str, paramahgk, l, paramBoolean);
    }
  }
  
  private void a(ahgk paramahgk, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramahgk != null) && (paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null))
    {
      if (paramBoolean) {
        b(paramahgk, false, null);
      }
      paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private void a(ahgk paramahgk, boolean paramBoolean, MessageForShortVideo paramMessageForShortVideo, String paramString1, String[] paramArrayOfString, String paramString2, int paramInt1, int paramInt2)
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
      paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      localObject = new VideoPlayParam();
      ((VideoPlayParam)localObject).mSceneId = 101;
      ((VideoPlayParam)localObject).mSceneName = bapv.a(101);
      ((VideoPlayParam)localObject).mIsMute = true;
      ((VideoPlayParam)localObject).mCallback = new ahgb(this, (VideoPlayParam)localObject);
      ((VideoPlayParam)localObject).mIsLocal = paramBoolean;
      ((VideoPlayParam)localObject).mIsLoop = true;
      ((VideoPlayParam)localObject).mVideoPath = paramString1;
      ((VideoPlayParam)localObject).mSavePath = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
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
      paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setVideoParam((VideoPlayParam)localObject);
      paramMessageForShortVideo = a(paramInt1, paramInt2);
      if (!TextUtils.isEmpty(paramString2)) {
        break label341;
      }
      paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setCoverDrawable(paramMessageForShortVideo);
    }
    for (;;)
    {
      if (d()) {
        paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.play();
      }
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView);
      return;
      localObject = "null";
      break;
      label335:
      i = 0;
      break label241;
      label341:
      paramMessageForShortVideo = URLDrawable.getDrawable(ShortVideoUtils.getThumbUrl(paramString2), paramInt1, paramInt2, paramMessageForShortVideo, paramMessageForShortVideo);
      paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setCoverDrawable(paramMessageForShortVideo);
      paramahgk.jdField_a_of_type_ComTencentImageURLDrawable = paramMessageForShortVideo;
    }
  }
  
  private void a(axjg paramaxjg, String paramString, ahgk paramahgk, axjj paramaxjj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "dealVideoSaveUI onSaveComplete");
    }
    if (paramaxjg != null)
    {
      if (paramaxjg.jdField_a_of_type_Int != 0) {
        break label96;
      }
      axjh.a(this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      paramaxjg.jdField_a_of_type_Axjf.b(paramaxjj);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
        paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
      }
      return;
      label96:
      axjh.b(this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, Context paramContext, SessionInfo paramSessionInfo, Bundle paramBundle, MessageForReplyText paramMessageForReplyText)
  {
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.isUpComingPrevious)) {
      paramBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().getCurrentPanel());
    }
    if (paramSessionInfo.curType == 1)
    {
      paramBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      paramBundle.putString("extra.GROUP_UIN", paramSessionInfo.curFriendUin);
      paramBundle.putString("extra.GROUP_CODE", paramSessionInfo.troopUin);
    }
    if ((paramSessionInfo.curType == 1) || (paramSessionInfo.curType == 3000))
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
      paramQQAppInterface = (axjk)paramQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
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
      paramBundle.putInt("forward_source_uin_type", paramSessionInfo.curType);
      paramBundle.putString("uin", paramSessionInfo.curFriendUin);
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
    if ((paramMessageForShortVideo != null) && (!bhbz.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      bhbz.a().a(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.reportVideoPlayEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramMessageForShortVideo.frienduin, 1, 1, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Bundle paramBundle, MessageForReplyText paramMessageForReplyText)
  {
    if ((sqp.a(paramContext)) || (paramQQAppInterface.isVideoChatting()))
    {
      QQToast.a(paramContext, 0, 2131718854, 0).b(paramContext.getResources().getDimensionPixelSize(2131299080));
      return;
    }
    if (!paramMessageForShortVideo.isSend()) {
      new bbkg(BaseApplication.getContext()).a(paramQQAppInterface, 2002, paramSessionInfo.curType, paramSessionInfo.curFriendUin, 1001);
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
    if ((paramMessageForShortVideo.istroop == 0) && (bhbx.b(paramMessageForShortVideo.senderuin)) && (!TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"))))
    {
      paramBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
      blvp.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), ahsl.a(paramMessageForShortVideo), 13007, i);
    }
    for (;;)
    {
      ((bbob)paramQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a();
      if (!paramMessageForShortVideo.isSend()) {
        new bbkg(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.curType, paramSessionInfo.curFriendUin, 1001);
      }
      azon.b(paramQQAppInterface, paramMessageForShortVideo);
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
      blvp.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), ahsl.a(paramMessageForShortVideo), -1, i);
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, MessageForReplyText paramMessageForReplyText)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("muate_play", false);
    localBundle.putBoolean("is_one_item", true);
    localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean1);
    localBundle.putBoolean(blvp.b, paramBoolean2);
    a(paramMessageForShortVideo, paramLong, paramContext, paramQQAppInterface, paramSessionInfo, localBundle, paramMessageForReplyText);
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "handleVideoCompressSucceed, seq = " + paramMessageForShortVideo.uniseq);
    }
    bcyt localbcyt = bcys.a().a(paramMessageForShortVideo.uniseq);
    if ((paramQQAppInterface != null) && (localbcyt != null)) {
      if (localbcyt.a() >= 104345600L)
      {
        paramMessageForShortVideo.videoFileStatus = 1005;
        paramMessageForShortVideo.serial();
        paramQQAppInterface.getMessageFacade().updateMsgContentByUniseq(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
        if (paramContext != null)
        {
          QQToast.a(paramContext, paramContext.getResources().getString(2131718834), 0).b(paramContext.getResources().getDimensionPixelSize(2131299080));
          paramContext = ((FragmentActivity)paramContext).getChatFragment();
          if (paramContext != null)
          {
            paramContext = paramContext.a();
            if (paramContext != null) {
              paramContext.instantUpdate(false, false);
            }
          }
        }
        bbob.a(paramQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
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
      paramQQAppInterface.getMessageFacade().updateMsgContentByUniseq(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
      paramContext = bcwz.a(0, 0);
      paramMessageForShortVideo = bcwz.a(paramMessageForShortVideo, paramContext);
      if (paramMessageForShortVideo != null)
      {
        paramMessageForShortVideo.i = localbcyt.a();
        paramMessageForShortVideo.jdField_a_of_type_Boolean = false;
        paramContext.a(paramMessageForShortVideo);
      }
      bcwz.a(paramContext, paramQQAppInterface);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(-1L);
      return;
    }
    QLog.i("ShortVideoItemBuilder", 2, "CompressTask onPostExecute QQAppInterface is null...");
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, StringBuilder paramStringBuilder, int paramInt, String paramString, ahgk paramahgk, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" sendFromLocal:false ");
    if (!FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramStringBuilder.append(" videoPathExists:false ");
      if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9))
      {
        paramStringBuilder.append(" fileType:video, =" + ShortVideoUtils.getFileTypeStr(paramMessageForShortVideo.fileType));
        if ((paramInt == 2005) && (paramMessageForShortVideo.isAllowAutoDown))
        {
          b(paramahgk);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718862, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
          paramStringBuilder.append(" result:toast recv_error ");
          return;
        }
        if (paramInt == 5001)
        {
          b(paramahgk);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718860, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
          paramStringBuilder.append(" result: toast file_unsafe ");
          return;
        }
        if (paramInt == 5002)
        {
          a(paramahgk, 2131718121);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718861, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
          paramStringBuilder.append(" result: toast file_expired ");
          return;
        }
        b(paramahgk);
        a(paramMessageForShortVideo, paramLong, paramBoolean);
        paramStringBuilder.append(" status:other, result: download ");
        return;
      }
      if (paramInt == 5002)
      {
        a(paramahgk, 2131718121);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718861, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
        paramStringBuilder.append("fileType:not video,videoPathExits:false, result:toast file_expired ");
        return;
      }
      b(paramahgk);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append("fileType:not video,videoPathExits:false, result: download");
      return;
    }
    b(paramahgk);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append("videoPathExists:true, result:play ");
  }
  
  private void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, StringBuilder paramStringBuilder, ahgk paramahgk, MessageForShortVideo paramMessageForShortVideo, int paramInt, long paramLong, boolean paramBoolean)
  {
    boolean bool = ((ShortVideoDownloadProcessor)paramIHttpCommunicatorListener).isPause();
    paramStringBuilder.append(" processor:download, pause:" + bool);
    if (bool)
    {
      b(paramahgk);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" pause:true, result:download ");
      return;
    }
    if (paramInt == 2005)
    {
      b(paramahgk);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718862, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      paramStringBuilder.append(" status:recv_error, result:toast recv_error ");
      return;
    }
    if ((paramInt == 2002) || (paramInt == 2000) || (paramInt == 2008) || (paramInt == 2001))
    {
      b(paramahgk);
      return;
    }
    if (paramInt == 5001)
    {
      b(paramahgk);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718860, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      paramStringBuilder.append(" status:file_unsafe, result:toast unsafe ");
      return;
    }
    if (paramInt == 5002)
    {
      a(paramahgk, 2131718121);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718861, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      paramStringBuilder.append(" status:file_expired, result:toast expired ");
      return;
    }
    b(paramahgk);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append(" status:other, result:download ");
  }
  
  private void a(StringBuilder paramStringBuilder, ahgk paramahgk, MessageForShortVideo paramMessageForShortVideo, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" localUploadPath Exists:true ");
    if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9))
    {
      paramStringBuilder.append(" fileType:video ");
      IHttpCommunicatorListener localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      if (localIHttpCommunicatorListener != null)
      {
        if ((ShortVideoUploadProcessor.class.isInstance(localIHttpCommunicatorListener)) || (ShortVideoForwardProcessor.class.isInstance(localIHttpCommunicatorListener))) {
          if (paramInt == 1005)
          {
            b(paramahgk);
            paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            paramStringBuilder.append(" status:send_error, result:show send error ");
          }
        }
        while (!ShortVideoDownloadProcessor.class.isInstance(localIHttpCommunicatorListener))
        {
          return;
          if ((paramInt == 1002) || (paramInt == 1001))
          {
            a(paramMessageForShortVideo, paramLong, paramBoolean);
            paramStringBuilder.append(" status:process or start, result:pauseSending ");
            return;
          }
          b(paramahgk);
          a(paramMessageForShortVideo, paramLong, paramBoolean);
          paramStringBuilder.append(" status:other, result:play ");
          return;
        }
        paramStringBuilder.append(" processor:not up of forward, result: none");
        return;
      }
      b(paramahgk);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" processor:null, result:play ");
      return;
    }
    b(paramahgk);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append(" fileType:not video, result: play ");
  }
  
  private boolean a(long paramLong)
  {
    return ((bbob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramLong);
  }
  
  private boolean a(ahgk paramahgk)
  {
    if (this.jdField_a_of_type_Axjk != null)
    {
      paramahgk = this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_Axjk.a(paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage));
      return (paramahgk != null) && (paramahgk.d == 1) && (!paramahgk.jdField_a_of_type_Boolean);
    }
    return false;
  }
  
  private static Drawable b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    asbg localasbg = new asbg(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localasbg, localasbg);
        localURLDrawable.setTag(bgxc.b(0, 0, paramInt3));
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
    return localasbg;
  }
  
  private void b(ahgk paramahgk, View paramView, ChatMessage paramChatMessage)
  {
    if (c(paramahgk))
    {
      if (paramahgk.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        paramahgk.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramahgk.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838323);
        paramahgk.jdField_a_of_type_AndroidWidgetImageView.setId(2131364541);
        paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
        paramChatMessage.bottomMargin = AIOUtils.dp2px(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramChatMessage.addRule(8, 2131364522);
        paramChatMessage.addRule(0, 2131364522);
        paramChatMessage.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramahgk.jdField_a_of_type_AndroidWidgetImageView, paramChatMessage);
        }
      }
      b(paramahgk, true, this);
      return;
    }
    b(paramahgk, false, null);
  }
  
  private void b(ahgk paramahgk, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      if (paramahgk.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        paramahgk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramahgk.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      }
    }
    while (paramahgk.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    paramahgk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramahgk.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
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
      paramQQAppInterface.getMessageFacade().updateMsgContentByUniseq(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
      bbob.a(paramQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    }
    if (paramContext != null) {}
  }
  
  private void b(MessageForShortVideo paramMessageForShortVideo, StringBuilder paramStringBuilder, int paramInt, String paramString, ahgk paramahgk, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" sendFromLocal:true ");
    if (paramMessageForShortVideo.isMultiMsg) {
      paramMessageForShortVideo.extraflag = 32772;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramMessageForShortVideo.videoFileName))
    {
      a(paramStringBuilder, paramahgk, paramMessageForShortVideo, paramInt, paramLong, paramBoolean);
      return;
    }
    b(paramStringBuilder, paramahgk, paramMessageForShortVideo, paramInt, paramLong, paramBoolean);
  }
  
  private void b(StringBuilder paramStringBuilder, ahgk paramahgk, MessageForShortVideo paramMessageForShortVideo, int paramInt, long paramLong, boolean paramBoolean)
  {
    paramStringBuilder.append(" localUploadPath Exists:false ");
    if (!FileUtils.fileExistsAndNotEmpty(ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4")))
    {
      paramStringBuilder.append(" downloadPath Exists:false ");
      if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9))
      {
        IHttpCommunicatorListener localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
        if (localIHttpCommunicatorListener != null)
        {
          if (ShortVideoDownloadProcessor.class.isInstance(localIHttpCommunicatorListener))
          {
            a(localIHttpCommunicatorListener, paramStringBuilder, paramahgk, paramMessageForShortVideo, paramInt, paramLong, paramBoolean);
            return;
          }
          if (ShortVideoUploadProcessor.class.isInstance(localIHttpCommunicatorListener))
          {
            b(paramahgk);
            paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718867, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
            paramStringBuilder.append(" processor:upload, result:show upload error and show toast");
            return;
          }
          if (ShortVideoForwardProcessor.class.isInstance(localIHttpCommunicatorListener))
          {
            boolean bool = ((ShortVideoForwardProcessor)localIHttpCommunicatorListener).isPause();
            paramStringBuilder.append(" processor:forward, pause:" + bool);
            if (bool)
            {
              a(paramahgk, 10, false);
              c(paramMessageForShortVideo, paramahgk);
              paramStringBuilder.append(" pause:true, result:reforward ");
              return;
            }
            if (paramInt == 5001)
            {
              b(paramahgk);
              paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718836, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
              paramStringBuilder.append(" status:unsafe, result:toast unsafe ");
              return;
            }
            if (paramInt == 5002)
            {
              a(paramahgk, 2131718121);
              paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718837, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
              paramStringBuilder.append(" status:expired, result:toast expired ");
              return;
            }
            if (paramInt == 1005)
            {
              b(paramahgk);
              paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              paramStringBuilder.append(" status:send_error, result:show send_error ");
              return;
            }
            if ((paramInt == 1002) || (paramInt == 1001))
            {
              a(paramMessageForShortVideo, 0L, paramBoolean);
              return;
            }
            b(paramahgk);
            a(paramMessageForShortVideo, 0L, paramBoolean);
            paramStringBuilder.append(" status:other, result:plau ");
            return;
          }
          paramStringBuilder.append(" processor:not down or forward or up, result:none ");
          return;
        }
        b(paramahgk);
        paramStringBuilder.append(" processor:null, result:download ");
        a(paramMessageForShortVideo, 0L, paramBoolean);
        return;
      }
      b(paramahgk);
      a(paramMessageForShortVideo, paramLong, paramBoolean);
      paramStringBuilder.append(" fileType:not video, result:download ");
      return;
    }
    b(paramahgk);
    a(paramMessageForShortVideo, paramLong, paramBoolean);
    paramStringBuilder.append(" downloadPath Exists:true，result:play ");
  }
  
  private boolean b(ahgk paramahgk)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Axjk != null)
    {
      paramahgk = this.jdField_a_of_type_Axjk.a(this.jdField_a_of_type_Axjk.a(paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage));
      if ((paramahgk != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      bool1 = bool2;
      if (paramahgk != null) {
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
      if (bcys.a().a(paramMessageForShortVideo.uniseq) == null)
      {
        paramMessageForShortVideo = ShortVideoUtils.getShortVideoCompressPath(paramMessageForShortVideo.videoFileName, "mp4");
        if (!TextUtils.isEmpty(paramMessageForShortVideo)) {
          FileUtils.deleteFile(paramMessageForShortVideo);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void c(ahgk paramahgk)
  {
    if (c(paramahgk))
    {
      if (paramahgk.jdField_a_of_type_AndroidWidgetImageView != null) {
        break label20;
      }
      h();
    }
    label20:
    while (paramahgk.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      return;
    }
    b(paramahgk, true, this);
  }
  
  private boolean c(ahgk paramahgk)
  {
    boolean bool2 = true;
    if ((paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {
        return false;
      }
      int i;
      int j;
      if ((localMessageForShortVideo.videoFileStatus == 998) || (localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 1001))
      {
        i = 1;
        if ((localMessageForShortVideo.isMultiMsg) || (localMessageForShortVideo.uiOperatorFlag == 2) || (localMessageForShortVideo.busiType != 0) || (!localMessageForShortVideo.isSendFromLocal()) || (paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a())) {
          break label211;
        }
        j = 1;
        label109:
        if (QLog.isColorLevel())
        {
          paramahgk = new StringBuilder().append("needShowPauseIcon seq:").append(localMessageForShortVideo.uniseq).append(", videostatus:").append(localMessageForShortVideo.videoFileStatus).append(", iconshow:");
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
  
  private void d(MessageForShortVideo paramMessageForShortVideo, ahgk paramahgk)
  {
    int k = 1;
    axjg localaxjg;
    int i;
    if ((this.jdField_a_of_type_Axjk != null) && (paramMessageForShortVideo != null) && (paramahgk != null))
    {
      paramMessageForShortVideo = this.jdField_a_of_type_Axjk.a(paramMessageForShortVideo);
      localaxjg = this.jdField_a_of_type_Axjk.a(paramMessageForShortVideo);
      if ((localaxjg != null) && (localaxjg.d == 1))
      {
        if (localaxjg.jdField_c_of_type_Int >= 0) {
          break label188;
        }
        i = 0;
        j = k;
        if (paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getVisibility() != 8) {
          if ((paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getVisibility() != 0) || (paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.d != 2)) {
            break label213;
          }
        }
      }
    }
    label188:
    label213:
    for (int j = k;; j = 0)
    {
      if ((i < 100) && (j != 0) && (!localaxjg.jdField_a_of_type_Boolean) && (localaxjg.jdField_a_of_type_Axjf != null))
      {
        localaxjg.jdField_a_of_type_Axjf.a(new ahgd(this, paramMessageForShortVideo, paramahgk));
        this.jdField_a_of_type_Axjk.a(paramMessageForShortVideo, localaxjg);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "dealVideoSaveUI showSaveProgress");
        }
        a(paramahgk, i, false);
        paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      }
      return;
      if (localaxjg.jdField_c_of_type_Int > 100)
      {
        i = 100;
        break;
      }
      i = localaxjg.jdField_c_of_type_Int;
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
    return bdnp.a().a(this.jdField_a_of_type_AndroidContentContext, 1, paramMessageForShortVideo.istroop);
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
          String str = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
          paramMessageForShortVideo = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
          bool1 = bool2;
          if (FileUtils.fileExistsAndNotEmpty(str))
          {
            bool1 = bool2;
            if (FileUtils.fileExistsAndNotEmpty(paramMessageForShortVideo)) {
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
            ((BaseChatPie)localObject).instantUpdate(false, false);
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
  
  public afqq a(View paramView)
  {
    return null;
  }
  
  public afqr a()
  {
    return new ahgk(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaftk);
    if ((paramChatMessage instanceof MessageForShortVideo)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramChatMessage);
    }
    a(paramChatMessage, paramView, this);
    a((ahgk)paramView.getTag(), paramView, paramChatMessage);
    b((ahgk)paramView.getTag(), paramView, paramChatMessage);
    if (e) {}
    try
    {
      paramChatMessage = (ahgk)paramView.getTag();
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append(paramChatMessage.jdField_a_of_type_AndroidWidgetTextView.getText());
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime);
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append("秒按钮");
      paramView.setContentDescription(paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.toString());
      return paramView;
    }
    catch (Exception paramChatMessage) {}
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView, message.uniseq = " + paramChatMessage.uniseq);
    }
    paramBaseChatItemLayout = (ahgk)paramafqr;
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    boolean bool = localMessageForShortVideo.isSend();
    paramafqr = paramView;
    int i;
    if (paramView == null)
    {
      paramafqr = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = (CropBubbleVideoView)bapu.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.uniseq, null, bool);
      paramView.setId(2131362355);
      paramView.setVisibility(0);
      paramView.setContentDescription(anvx.a(2131713479));
      paramafqr.addView(paramView);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramView);
      VideoProgressView localVideoProgressView = new VideoProgressView(this.jdField_a_of_type_AndroidContentContext);
      localVideoProgressView.setId(2131364567);
      paramafqr.addView(localVideoProgressView);
      ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 0);
      i = AIOUtils.dp2px(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      Object localObject1 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramafqr.addView(localProgressBar, (ViewGroup.LayoutParams)localObject1);
      Object localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject2).setOrientation(1);
      ((LinearLayout)localObject2).setGravity(17);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      paramafqr.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(70.0F, localResources);
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 12.0F);
      ((TextView)localObject1).setId(2131364565);
      ((TextView)localObject1).setVisibility(4);
      ((LinearLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject2).setBackgroundResource(2130839176);
      localObject3 = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(55.0F, localResources));
      ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131362355);
      ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131362355);
      ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131362355);
      paramafqr.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject3).setTextSize(1, 12.0F);
      ((TextView)localObject3).setTextColor(-1);
      Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = AIOUtils.dp2px(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject4).bottomMargin = AIOUtils.dp2px(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject4).addRule(9);
      ((RelativeLayout.LayoutParams)localObject4).addRule(12);
      ((RelativeLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setTextSize(1, 12.0F);
      ((TextView)localObject4).setTextColor(-1);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).rightMargin = AIOUtils.dp2px(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject5).bottomMargin = AIOUtils.dp2px(7.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject5).addRule(11);
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject5).setTextSize(1, 14.0F);
      ((TextView)localObject5).setTextColor(-1);
      ((TextView)localObject5).setGravity(17);
      ((TextView)localObject5).setText(2131718855);
      ((TextView)localObject5).setShadowLayer(3.0F, 1.0F, 1.0F, -16777216);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = AIOUtils.dp2px(14.0F, localResources);
      localLayoutParams.addRule(14);
      paramafqr.addView((View)localObject5, localLayoutParams);
      paramafqr.setOnClickListener(this);
      super.a(paramafqr, paramaftk);
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
    bhbz.a().a(Long.valueOf(localMessageForShortVideo.uniseq), localMessageForShortVideo);
    if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend != bool)
    {
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend = bool;
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.invalidate();
    }
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnClickListener(this);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnTouchListener(paramaftk);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnLongClickListener(paramaftk);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setRadius(15.0F, true);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setShowCorner(true);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setSharpCornerCor(BubbleImageView.a);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setCornerDirection(bool);
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    azon.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
    paramChatMessage = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    label1017:
    int j;
    if (bool)
    {
      paramChatMessage.leftMargin = 0;
      paramChatMessage.rightMargin = AIOUtils.dp2px(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), localResources);
      paramChatMessage = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.d.getLayoutParams();
      if (!bool) {
        break label1339;
      }
      paramChatMessage.rightMargin = (AIOUtils.dp2px(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), localResources) / 2);
      paramBaseChatItemLayout.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForTime(localMessageForShortVideo.videoFileTime * 1000));
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramChatMessage = ShortVideoUtils.getShortVideoThumbPicPath(localMessageForShortVideo.thumbMD5, "jpg");
      paramView = ShortVideoUtils.adjustSize(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
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
      if (bcwz.jdField_a_of_type_Boolean)
      {
        bcwz.jdField_a_of_type_Long = System.currentTimeMillis();
        bcwz.jdField_a_of_type_Boolean = false;
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
      return paramafqr;
      paramChatMessage.leftMargin = AIOUtils.dp2px(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), localResources);
      paramChatMessage.rightMargin = 0;
      break;
      paramChatMessage.leftMargin = (AIOUtils.dp2px(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), localResources) / 2);
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
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.stringForFileSize(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.videoFileSize));
      paramBaseChatItemLayout.d.setVisibility(8);
    } while (!a(paramChatMessage, localMessageForShortVideo, paramBaseChatItemLayout, i, j, paramView));
    label1445:
    a(localMessageForShortVideo, paramBaseChatItemLayout);
    return paramafqr;
  }
  
  public bhjq a(bhjq parambhjq, ChatMessage paramChatMessage, afrk paramafrk)
  {
    boolean bool3 = false;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramafrk = (ahgk)paramafrk;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.getFileTypeStr(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.getFileStatusStr(localMessageForShortVideo.videoFileStatus));
    }
    b(parambhjq, this.jdField_a_of_type_AndroidContentContext);
    int i;
    boolean bool1;
    label221:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramChatMessage = ShortVideoUtils.getShortVideoThumbPicPath(localMessageForShortVideo.thumbMD5, "jpg");
      if (FileUtils.fileExistsAndNotEmpty(paramChatMessage))
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
        if ((paramafrk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView == null) || (!paramafrk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramafrk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafrk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
          break label479;
        }
        bool1 = true;
        bool2 = bool3;
        if (paramafrk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
        {
          bool2 = bool3;
          if (paramafrk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
            bool2 = true;
          }
        }
        if ((!bool4) || (bool1) || (bool2)) {
          break label432;
        }
        parambhjq.a(2131367213, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838991);
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
      if ((localMessageForShortVideo != null) && (FileUtils.fileExistsAndNotEmpty(ShortVideoUtils.getShortVideoSavePath(localMessageForShortVideo, "mp4")))) {
        parambhjq.a(2131366456, this.jdField_a_of_type_AndroidContentContext.getString(2131692126), 2130838990);
      }
      this.f = true;
      return parambhjq;
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
    if (bhfj.a(paramChatMessage.issend)) {
      return anvx.a(2131713487);
    }
    return anvx.a(2131713539);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
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
            MessageForShortVideo localMessageForShortVideo = bhbz.a().a(Integer.valueOf(localCropBubbleVideoView.getId()));
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
            if (paramInt == 2131365475)
            {
              admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
              return;
            }
            if (paramInt == 2131371684)
            {
              super.d(paramChatMessage);
              return;
            }
            if (paramInt != 2131367213) {
              break;
            }
            c(localMessageForShortVideo);
          } while (!paramChatMessage.isMultiMsg);
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 6, 0, "6", "", "", "");
          return;
          if (paramInt != 2131366456) {
            break;
          }
        } while (!e((MessageForShortVideo)paramChatMessage));
        bmad.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bman.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
        bman.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
      } while (!paramChatMessage.isMultiMsg);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 6, 0, "6", "", "", "");
      return;
      if (paramInt == 2131371641)
      {
        d(localMessageForShortVideo);
        return;
      }
      if (paramInt != 2131371748) {
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
    bdla.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 2, 0, "", "", "", "");
    return;
    label337:
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(ahgk paramahgk)
  {
    if (a(paramahgk)) {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "disProgress...file is saving, so return!");
      }
    }
    do
    {
      return;
      if (!a(paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "disProgress fail...video order sending! " + paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return;
    if (!paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
      return;
    }
    paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimRunnableListener(new ahgc(this, paramahgk));
  }
  
  protected void a(ahgk paramahgk, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 100)
    {
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(paramInt, paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    for (;;)
    {
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVideoCompressStatus(false);
      paramahgk.c.setVisibility(8);
      return;
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(paramInt, paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
  }
  
  public void a(ahgk paramahgk, MessageForShortVideo paramMessageForShortVideo)
  {
    b(paramahgk);
    if (b(paramahgk)) {}
    do
    {
      return;
      paramahgk = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    } while (FileUtils.fileExistsAndNotEmpty(paramahgk));
    bcxr localbcxr = bcwz.a(2, this.jdField_c_of_type_Int);
    bcxb localbcxb = paramMessageForShortVideo.getDownloadInfo(localbcxr.jdField_b_of_type_Int);
    localbcxb.i = paramahgk;
    if ((paramMessageForShortVideo.istroop == 0) || (paramMessageForShortVideo.istroop == 1008)) {
      localbcxb.e = 1002;
    }
    for (;;)
    {
      localbcxr.a(localbcxb);
      localbcxr.a(paramMessageForShortVideo);
      bcwz.a(localbcxr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      if (paramMessageForShortVideo.istroop == 3000) {
        localbcxb.e = 1006;
      } else if (paramMessageForShortVideo.istroop == 1) {
        localbcxb.e = 1004;
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (ahgk)AIOUtils.getHolder(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbkzi.a(2131689976, 5);
      localbkzi.c(2131690697);
      localbkzi.a(new ahgh(this, localMessageForShortVideo, paramView, localbkzi));
      localbkzi.show();
      if (localMessageForShortVideo.videoFileStatus == 1004) {
        ShortVideoUtils.reportCancelSendVideo("0X800A374", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296391);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.h, i, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    MessageForShortVideo localMessageForShortVideo;
    do
    {
      try
      {
        paramView = (ahgk)AIOUtils.getHolder(paramView);
        localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        VideoProgressView localVideoProgressView = paramView.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView;
        if (localMessageForShortVideo.uniseq != paramFileMsg.uniseq) {
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.e("ShortVideoItemBuilder", 2, "handleMessage getHolder error ! ", paramView);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "handleMessage msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType:" + ShortVideoUtils.getFileTypeStr(paramFileMsg.fileType) + " ===> fileStatus:" + ShortVideoUtils.getFileStatusStr(paramFileMsg.status));
      }
      if ((paramFileMsg.fileType == 6) || (paramFileMsg.fileType == 17) || (paramFileMsg.fileType == 9) || (paramFileMsg.fileType == 20))
      {
        c(paramFileMsg, paramView, localMessageForShortVideo);
        return;
      }
    } while ((paramFileMsg.fileType != 7) && (paramFileMsg.fileType != 18) && (paramFileMsg.fileType != 16));
    d(paramFileMsg, paramView, localMessageForShortVideo);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 998) {
      return;
    }
    if ((TextUtils.isEmpty(paramMessageForShortVideo.md5)) || (paramMessageForShortVideo.videoFileStatus == 1004))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718828, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      return;
    }
    String str = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
    boolean bool2 = NetworkUtils.isMobileConnected(this.jdField_a_of_type_AndroidContentContext);
    if ((bcwz.jdField_a_of_type_Long != 0L) && (System.currentTimeMillis() - bcwz.jdField_a_of_type_Long < 300000L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "startPlayVideo isConfirmed=" + bool1 + " allowPlayInXGTime=" + bcwz.jdField_a_of_type_Long + " isXGConnected = " + bool2);
      }
      if ((!bool2) || (bool1) || ((FileUtils.fileExists(str)) && (paramMessageForShortVideo.videoFileStatus != 2002)) || (paramMessageForShortVideo.videoFileSize < 1048576)) {
        break label348;
      }
      if (!bixr.a((Activity)this.jdField_a_of_type_AndroidContentContext, 3, new ahge(this, paramMessageForShortVideo, paramLong, paramBoolean))) {
        break;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131717754);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131717757), str, this.jdField_a_of_type_AndroidContentContext.getString(2131717755), this.jdField_a_of_type_AndroidContentContext.getString(2131717756), new ahgf(this, paramMessageForShortVideo, paramLong, paramBoolean), new ahgg(this));
      paramMessageForShortVideo = awtc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
      if ((paramMessageForShortVideo instanceof SpannableString)) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageWithoutAutoLink(paramMessageForShortVideo);
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
      catch (Throwable paramMessageForShortVideo)
      {
        return;
      }
    }
    label348:
    b(paramMessageForShortVideo, paramLong, paramBoolean);
    ShortVideoUtils.reportVideoPlay(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E53", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageForShortVideo, this.jdField_a_of_type_AndroidContentContext);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, ahgk paramahgk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView ，video no exits: sendFromLocal=" + paramMessageForShortVideo.isSendFromLocal() + "===>  fileType:" + ShortVideoUtils.getFileTypeStr(paramMessageForShortVideo.fileType) + " ===> videoFileStatus:" + ShortVideoUtils.getFileStatusStr(paramMessageForShortVideo.videoFileStatus) + "===> videoFileProgress:" + paramMessageForShortVideo.videoFileProgress + ", uniseq:" + paramMessageForShortVideo.uniseq);
    }
    IHttpCommunicatorListener localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9) || (paramMessageForShortVideo.fileType == 19) || (paramMessageForShortVideo.fileType == 20)) {}
    switch (paramMessageForShortVideo.videoFileStatus)
    {
    default: 
    case 1001: 
      do
      {
        return;
        if (localIHttpCommunicatorListener != null) {
          break;
        }
        paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        b(paramahgk);
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_START, 上传开始被杀进程然后恢复, uniseq:" + paramMessageForShortVideo.uniseq);
      return;
      a(paramahgk, ShortVideoUtils.getDisplayProgress(paramMessageForShortVideo.videoFileProgress, 10), false);
      return;
    case 1004: 
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      b(paramahgk);
      a(paramahgk, true, this);
      return;
    case 1002: 
      a(localIHttpCommunicatorListener, paramahgk, paramMessageForShortVideo);
      return;
    case 1003: 
      b(paramahgk);
      return;
    case 2001: 
      b(paramahgk);
      return;
    case 2004: 
      b(paramahgk);
      return;
    case 2002: 
      b(paramahgk);
      return;
    }
    a(paramahgk, 2131718121);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, ahgk paramahgk, String paramString, int paramInt1, int paramInt2)
  {
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      paramahgk.jdField_a_of_type_AndroidWidgetTextView.setText("");
      if (FileUtils.fileExistsAndNotEmpty(paramString))
      {
        a(paramahgk, paramMessageForShortVideo, paramString, paramInt1, paramInt2, false);
        if (paramMessageForShortVideo.videoFileStatus != 1005) {
          break label64;
        }
        paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(2);
        paramahgk.c.setVisibility(8);
      }
    }
    label64:
    do
    {
      return;
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramahgk.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramahgk.d.setVisibility(8);
      paramahgk.c.setVisibility(8);
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      if ((paramMessageForShortVideo.videoFileStatus != 998) || (b(paramMessageForShortVideo)))
      {
        paramahgk = new bcyt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, this.jdField_a_of_type_Ahgj);
        bcys.a().a(paramMessageForShortVideo.uniseq, paramahgk);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView(): msg.md5 == null, start compress task, id:" + paramMessageForShortVideo.uniseq);
        }
      }
      paramMessageForShortVideo = bcys.a().a(paramMessageForShortVideo.uniseq);
    } while (paramMessageForShortVideo == null);
    paramMessageForShortVideo.a(this.jdField_a_of_type_Ahgj);
  }
  
  public void a(FileMsg paramFileMsg, ahgk paramahgk, MessageForShortVideo paramMessageForShortVideo)
  {
    b(paramahgk);
    a(paramahgk);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "handleReceiveProcess, getAIOState() = " + a());
    }
    if (a() != 4) {}
    do
    {
      do
      {
        return;
      } while ((paramFileMsg.urls == null) || (!d(paramMessageForShortVideo)) || (b(paramahgk)) || (c(paramMessageForShortVideo)));
      String[] arrayOfString = paramFileMsg.urls;
      paramFileMsg = paramFileMsg.domain;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_RECV_PROCESS: domain=" + paramFileMsg + ", videoUrls=" + Arrays.toString(arrayOfString));
      }
      String str = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
      int[] arrayOfInt = ShortVideoUtils.adjustSize(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
      int j = arrayOfInt[0];
      int k = arrayOfInt[1];
      i = 0;
      while (i < 1)
      {
        if (!TextUtils.isEmpty(paramFileMsg)) {
          arrayOfString[i] = (arrayOfString[i] + "&txhost=" + paramFileMsg);
        }
        i += 1;
      }
      a(paramahgk, false, paramMessageForShortVideo, null, arrayOfString, str, j, k);
      if ((paramMessageForShortVideo.CheckIsHotVideo()) && (!bhbz.a().a(paramMessageForShortVideo, "0X8007EDB")))
      {
        bhbz.a().a(paramMessageForShortVideo, "0X8007EDB");
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
      }
    } while (bhbz.a().a(paramMessageForShortVideo, "0X80077D9"));
    int i = omx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    paramFileMsg = new JSONObject();
    try
    {
      paramFileMsg.put("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      paramFileMsg.put("memNum", i);
      paramFileMsg.put("msg_uniseq", paramMessageForShortVideo.uniseq);
      label400:
      olh.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", omx.a(paramMessageForShortVideo.getMd5(), null, null, null, paramFileMsg), false);
      bhbz.a().a(paramMessageForShortVideo, "0X80077D9");
      return;
    }
    catch (Exception paramahgk)
    {
      break label400;
    }
  }
  
  void a(IHttpCommunicatorListener paramIHttpCommunicatorListener, ahgk paramahgk, MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramIHttpCommunicatorListener == null)
    {
      paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      b(paramahgk);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_PROCESS, 上传过程中被杀进程然后恢复, uniseq:" + paramMessageForShortVideo.uniseq);
      }
      return;
    }
    if (((bbob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).b(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq))
    {
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(10, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      return;
    }
    int j = paramMessageForShortVideo.videoFileProgress;
    int i = j;
    if ((paramIHttpCommunicatorListener instanceof ShortVideoUploadProcessor))
    {
      paramIHttpCommunicatorListener = (ShortVideoUploadProcessor)paramIHttpCommunicatorListener;
      i = j;
      if (paramIHttpCommunicatorListener.getFileSize() != 0L) {
        i = (int)(100L * paramIHttpCommunicatorListener.getTransferedSize() / paramIHttpCommunicatorListener.getFileSize());
      }
    }
    a(paramahgk, ShortVideoUtils.getDisplayProgress(i, 10), false);
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq) == null) {
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
  
  protected boolean a(String paramString, MessageForShortVideo paramMessageForShortVideo, ahgk paramahgk, int paramInt1, int paramInt2)
  {
    if ((paramMessageForShortVideo.videoFileStatus == 998) || (paramMessageForShortVideo.videoFileStatus == 1001) || (paramMessageForShortVideo.videoFileStatus == 1002) || (paramMessageForShortVideo.videoFileStatus == 1004)) {}
    for (int i = 1; (!d(paramMessageForShortVideo)) || ((paramMessageForShortVideo.isSendFromLocal()) && (i != 0)) || (b(paramahgk)) || (c(paramMessageForShortVideo)) || (a(paramMessageForShortVideo.uniseq)); i = 0)
    {
      a(paramahgk, paramMessageForShortVideo, paramString, paramInt1, paramInt2, false);
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      return true;
    }
    Object localObject = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
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
        if ((!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext)) || (paramMessageForShortVideo.videoFileStatus == 5002)) {
          break label399;
        }
        localObject = bcwz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo, 2);
        if (localObject != null) {
          bcwz.a((bcxr)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
    }
    for (;;)
    {
      a(paramahgk, paramMessageForShortVideo, paramString, paramInt1, paramInt2, true);
      break;
      l1 = spm.a(8, paramMessageForShortVideo.videoFileTime, paramMessageForShortVideo.videoFileSize);
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
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
    }
    label410:
    a(paramahgk, true, paramMessageForShortVideo, (String)localObject, null, paramString, paramInt1, paramInt2);
    if (paramMessageForShortVideo.videoFileTime <= 8) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      a(paramahgk);
      if (paramInt1 == 0) {
        paramahgk.d.setVisibility(0);
      }
      b(paramMessageForShortVideo);
      return false;
    }
  }
  
  protected boolean a(String paramString, MessageForShortVideo paramMessageForShortVideo, ahgk paramahgk, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    boolean bool2 = true;
    boolean bool1;
    if (FileUtils.fileExistsAndNotEmpty(paramString)) {
      bool1 = a(paramString, paramMessageForShortVideo, paramahgk, paramInt1, paramInt2);
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
          paramahgk.d.setVisibility(8);
          paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
          paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramDrawable);
          a(paramahgk, 2131718121);
          bool1 = bool2;
        } while (!QLog.isColorLevel());
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not download pic : 缩略图不存在，而且文件已经过期，不下载, , uniseq:" + paramMessageForShortVideo.uniseq);
        return true;
        bool1 = bool2;
      } while (paramMessageForShortVideo.extraflag == 32768);
      bool1 = bool2;
    } while (b(paramahgk));
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not SendFromLocal : 缩略图不存在，开始下载缩略图, , uniseq:" + paramMessageForShortVideo.uniseq);
    }
    paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramDrawable);
    paramString = bcwz.a(2, this.jdField_c_of_type_Int);
    paramahgk = paramMessageForShortVideo.getDownloadInfo(paramString.jdField_b_of_type_Int);
    paramahgk.i = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    if ((paramMessageForShortVideo.istroop == 0) || (paramMessageForShortVideo.istroop == 1008)) {
      paramahgk.e = 1002;
    }
    for (;;)
    {
      paramahgk.f = 2;
      paramString.a(paramahgk);
      paramString.a(paramMessageForShortVideo);
      bcwz.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return true;
      if (paramMessageForShortVideo.istroop == 3000) {
        paramahgk.e = 1006;
      } else if (paramMessageForShortVideo.istroop == 1) {
        paramahgk.e = 1004;
      }
    }
  }
  
  public bhjs[] a(View paramView)
  {
    paramView = (ahgk)AIOUtils.getHolder(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bhjq localbhjq = new bhjq();
    if (localMessageForShortVideo != null)
    {
      if (!localMessageForShortVideo.isMultiMsg) {
        break label48;
      }
      a(localbhjq, localMessageForShortVideo, paramView);
    }
    for (;;)
    {
      return localbhjq.a();
      label48:
      b(localbhjq, localMessageForShortVideo, paramView);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public bhjq b(bhjq parambhjq, ChatMessage paramChatMessage, afrk paramafrk)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    ahgk localahgk = (ahgk)paramafrk;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.getFileTypeStr(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.getFileStatusStr(localMessageForShortVideo.videoFileStatus));
    }
    b(parambhjq, this.jdField_a_of_type_AndroidContentContext);
    int i;
    boolean bool1;
    label223:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramafrk = ShortVideoUtils.getShortVideoThumbPicPath(localMessageForShortVideo.thumbMD5, "jpg");
      if (FileUtils.fileExistsAndNotEmpty(paramafrk))
      {
        paramafrk = "";
        i = 1;
        if (i == 0) {
          break label581;
        }
        if (!"1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"))) {
          break label562;
        }
        boolean bool3 = localMessageForShortVideo.checkForward();
        if ((localahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView == null) || (!localahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(localahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + localahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
          break label575;
        }
        bool1 = true;
        if ((localahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (localahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0)) {
          break label569;
        }
        bool2 = true;
        label251:
        if ((!bool3) || (bool1) || (bool2)) {
          break label522;
        }
        parambhjq.a(2131367213, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838991);
        paramafrk = paramafrk + "inMiddleStatus = false, progeressBarShowing = false, errorIconShowing = false, show forward menu.";
      }
    }
    label522:
    label562:
    label569:
    label575:
    label581:
    for (;;)
    {
      a(localMessageForShortVideo, parambhjq);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getMenuItem: " + paramafrk);
      }
      if ((localMessageForShortVideo != null) && ((localahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (localahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0))) {
        a(parambhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, localMessageForShortVideo);
      }
      a(parambhjq, localMessageForShortVideo);
      if ((localMessageForShortVideo != null) && (FileUtils.fileExistsAndNotEmpty(ShortVideoUtils.getShortVideoSavePath(localMessageForShortVideo, "mp4")))) {
        parambhjq.a(2131366456, this.jdField_a_of_type_AndroidContentContext.getString(2131692126), 2130838990);
      }
      super.a(parambhjq, this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo, false);
      b(paramChatMessage, parambhjq);
      super.c(parambhjq, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambhjq, this.jdField_a_of_type_AndroidContentContext);
      this.f = true;
      return parambhjq;
      paramafrk = "thumbFilePath=" + paramafrk + " , not exits.";
      i = 0;
      break;
      paramafrk = " msg == null or md5 is empty.";
      i = 0;
      break;
      paramafrk = paramafrk + "progeressBarShowing=" + bool1 + ", errorIconShowing=" + bool2;
      continue;
      paramafrk = " not inDPCWhiteList.";
      continue;
      bool2 = false;
      break label251;
      bool1 = false;
      break label223;
    }
  }
  
  protected void b(ahgk paramahgk)
  {
    if (a(paramahgk)) {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "hideProgress...file is saving, so return!");
      }
    }
    do
    {
      return;
      if (!a(paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "hideProgress fail...video order sending! " + paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return;
    paramahgk.c.setVisibility(8);
    if (!paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(2);
      return;
    }
    paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimRunnableListener(new ahga(this, paramahgk));
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo.CheckIsHotVideo()) && (!bhbz.a().a(paramMessageForShortVideo, "0X8007EDB")))
    {
      bhbz.a().a(paramMessageForShortVideo, "0X8007EDB");
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
    }
    int i;
    JSONObject localJSONObject;
    if (!bhbz.a().a(paramMessageForShortVideo, "0X80077D9"))
    {
      i = omx.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      localJSONObject.put("memNum", i);
      localJSONObject.put("msg_uniseq", paramMessageForShortVideo.uniseq);
      label150:
      olh.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", omx.a(paramMessageForShortVideo.getMd5(), null, null, null, localJSONObject), false);
      bhbz.a().a(paramMessageForShortVideo, "0X80077D9");
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
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, ahgk paramahgk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    boolean bool = paramMessageForShortVideo.CheckIsHotVideo();
    String str1 = paramMessageForShortVideo.videoFileName;
    String str2 = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    if ((!FileUtils.fileExistsAndNotEmpty(str1)) && (!bool))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718867, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      b(paramahgk);
      paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if ((!FileUtils.fileExistsAndNotEmpty(str2)) && (!bool))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718868, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      b(paramahgk);
      paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((bbob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    paramahgk = bcwz.a(1, this.jdField_c_of_type_Int);
    paramMessageForShortVideo = bcwz.a(this.jdField_c_of_type_Int, paramMessageForShortVideo, paramahgk);
    paramMessageForShortVideo.e = bool;
    paramahgk.a(paramMessageForShortVideo);
    bcwz.a(paramahgk, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void b(FileMsg paramFileMsg, ahgk paramahgk, MessageForShortVideo paramMessageForShortVideo)
  {
    int j = 0;
    int i;
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      if (paramFileMsg.fileSize == 0L) {
        break label49;
      }
      i = (int)(100L * paramFileMsg.transferedSize / paramFileMsg.fileSize);
    }
    for (;;)
    {
      a(paramahgk, ShortVideoUtils.getDisplayProgress(i, 10), true);
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
    String str1 = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
    localBundle.putString("forward_thumb", str1);
    localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
    localBundle.putString("from_uin", ShortVideoUtils.getFromUinForForward(paramMessageForShortVideo));
    localBundle.putInt("from_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    localBundle.putString("from_session_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    String str2 = ShortVideoUtils.findVideoPathIfExists(paramMessageForShortVideo);
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
    if (FileUtils.fileExistsAndNotEmpty(str2))
    {
      localBundle.putBoolean("k_dataline", true);
      localBundle.putString("forward_extra", str2);
      localBundle.putBoolean("direct_send_if_dataline_forward", true);
      localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    }
    paramMessageForShortVideo = new Intent();
    paramMessageForShortVideo.putExtras(localBundle);
    aupt.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "1", "", "");
  }
  
  protected void c(MessageForShortVideo paramMessageForShortVideo, ahgk paramahgk)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "reForwardVideo：" + paramMessageForShortVideo.toString());
      }
      if (!FileUtils.fileExistsAndNotEmpty(ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718868, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
        b(paramahgk);
        paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        ((bbob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
        paramahgk = bcwz.a(4, this.jdField_c_of_type_Int);
        paramahgk.a(bcwz.a(this.jdField_c_of_type_Int, paramMessageForShortVideo, paramahgk));
        bcwz.a(paramahgk, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoItemBuilder", 2, "ShortVideoItemBuilder:reForwardVideo() path is empty");
  }
  
  public void c(FileMsg paramFileMsg, ahgk paramahgk, MessageForShortVideo paramMessageForShortVideo)
  {
    switch (paramFileMsg.status)
    {
    default: 
      return;
    case 1001: 
      if (paramFileMsg.fileSize == 0L) {
        break;
      }
    }
    for (int i = (int)(100L * paramFileMsg.transferedSize / paramFileMsg.fileSize);; i = 0)
    {
      a(paramahgk, ShortVideoUtils.getDisplayProgress(i, 10), true);
      paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      c(paramahgk);
      return;
      a(paramahgk, 100, true);
      b(paramahgk);
      b(paramahgk, false, null);
      bcys.a().a(paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
      b(paramahgk);
      paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      bcys.a().a(paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
      paramahgk.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      b(paramahgk);
      a(paramahgk, true, this);
      bcys.a().a(paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
      b(paramahgk);
      b(paramahgk, false, null);
      bcys.a().a(paramahgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
      b(paramFileMsg, paramahgk, paramMessageForShortVideo);
      return;
      b(paramahgk);
      paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
      return;
      a(paramahgk, paramMessageForShortVideo);
      return;
      b(paramahgk);
      if (paramFileMsg.errorCode == -5100528) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718862, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      return;
      a(paramahgk, 2131718120);
      if (paramMessageForShortVideo.uiOperatorFlag == 2)
      {
        paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718836, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
        return;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718860, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      return;
      a(paramahgk, 2131718121);
      if (paramMessageForShortVideo.uiOperatorFlag == 2)
      {
        paramahgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718837, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
        return;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718861, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
      return;
      b(paramahgk);
      return;
      a(paramFileMsg, paramahgk, paramMessageForShortVideo);
      return;
    }
  }
  
  public void d()
  {
    super.d();
    this.d = -1;
    this.f = false;
  }
  
  public void d(MessageForShortVideo paramMessageForShortVideo)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked(): msg_revoke =>" + paramMessageForShortVideo.toLogString());
    }
    if (paramMessageForShortVideo.md5 == null)
    {
      bcys.a().b(paramMessageForShortVideo.uniseq);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(paramMessageForShortVideo.uniseq);
      ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MSG_FACADE)).getBaseMessageManager(paramMessageForShortVideo.istroop).d(paramMessageForShortVideo);
      bbob.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return;
      IHttpCommunicatorListener localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      if ((localIHttpCommunicatorListener != null) && ((ShortVideoUploadProcessor.class.isInstance(localIHttpCommunicatorListener)) || (ShortVideoForwardProcessor.class.isInstance(localIHttpCommunicatorListener))))
      {
        boolean bool = ((BaseTransProcessor)localIHttpCommunicatorListener).isPause();
        i = paramMessageForShortVideo.videoFileStatus;
        if ((bool) || (i == 1002) || (i == 1001))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().stopSendingShortVideo(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
          ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_MSG_FACADE)).getBaseMessageManager(paramMessageForShortVideo.istroop).d(paramMessageForShortVideo);
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
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
  
  public void d(FileMsg paramFileMsg, ahgk paramahgk, MessageForShortVideo paramMessageForShortVideo)
  {
    switch (paramFileMsg.status)
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
          paramFileMsg = ShortVideoUtils.getShortVideoThumbPicPath(paramMessageForShortVideo.thumbMD5, "jpg");
          localObject = ShortVideoUtils.adjustSize(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
          j = localObject[0];
          k = localObject[1];
        } while ((!d(paramMessageForShortVideo)) || (b(paramahgk)) || (c(paramMessageForShortVideo)));
        Object localObject = ShortVideoUtils.getShortVideoSavePath(paramMessageForShortVideo, "mp4");
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
          if (NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext))
          {
            localObject = bcwz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForShortVideo, 2);
            if (localObject != null) {
              bcwz.a((bcxr)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
          }
          a(paramahgk, paramMessageForShortVideo, paramFileMsg, j, k, true);
          return;
          l1 = spm.a(8, paramMessageForShortVideo.videoFileTime, paramMessageForShortVideo.videoFileSize);
          break;
          i = 1;
          continue;
          i = 1;
        }
        if (paramMessageForShortVideo.videoFileTime <= 8) {}
        for (i = 1;; i = 0)
        {
          a(paramahgk, true, paramMessageForShortVideo, (String)localObject, null, paramFileMsg, j, k);
          a(paramahgk);
          if (i == 0) {
            break;
          }
          paramahgk.d.setVisibility(8);
          return;
        }
        paramahgk.d.setVisibility(0);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_ERROR:");
      return;
    }
    paramFileMsg = ShortVideoUtils.adjustSize(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    int i = paramFileMsg[0];
    int j = paramFileMsg[1];
    paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    paramahgk.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(a(i, j));
    a(paramahgk, 2131718121);
    paramahgk.d.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    Object localObject1 = (ahgk)AIOUtils.getHolder(paramView);
    jdField_a_of_type_AndroidGraphicsRect = a(paramView, (MessageForShortVideo)((ahgk)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    AIOUtils.isUserOperatedInAIO = true;
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
      if ((paramView.getId() == 2131364522) || (paramView.getId() == 2131364567))
      {
        a((ahgk)localObject1, false);
      }
      else if (paramView.getId() == 2131364541)
      {
        localStringBuilder = new StringBuilder();
        if (!((ahgk)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(((ahgk)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((ahgk)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          if ((!(localObject2 instanceof ShortVideoUploadProcessor)) || (!((ShortVideoUploadProcessor)localObject2).isBDHSuccess)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "CompressTask pauseOperator!");
          }
        }
      }
    }
    Object localObject2 = bcys.a().a(((ahgk)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    if (localObject2 != null)
    {
      ((bcyt)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.isPause = true;
      boolean bool = ((bcyt)localObject2).cancel(true);
      localStringBuilder.append("\n ShortVideoItemBuilder task cancel:").append(bool);
      localStringBuilder.append("\n md5 info:").append(((MessageForShortVideo)((ahgk)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).md5);
      if ((bool) && (((MessageForShortVideo)((ahgk)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).md5 == null))
      {
        bool = ((bcyt)localObject2).a();
        localStringBuilder.append("\n media codec cancel:").append(bool);
        if (!bool) {
          break label444;
        }
        localStringBuilder.append("\n ffmpeg process cancel!");
      }
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(((ahgk)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((ahgk)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if ((localObject1 instanceof ShortVideoUploadProcessor))
      {
        ((ShortVideoUploadProcessor)localObject1).pause();
        localStringBuilder.append("\n upload process pause!");
      }
      ShortVideoUtils.reportCancelSendVideo("0X800A373", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
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
 * Qualified Name:     ahfz
 * JD-Core Version:    0.7.0.1
 */