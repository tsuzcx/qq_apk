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
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.12;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.3;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.4;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.6;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.videoplayer.AIOBubbleVideoView;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.widget.BubbleImageView;
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
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class adoi
  extends BaseBubbleBuilder
  implements acjx, aclm, awei, awgc, awnh
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect;
  private static CopyOnWriteArraySet<AIOBubbleVideoView> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  public static AtomicLong a;
  private static long c;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adom(this);
  private aryq jdField_a_of_type_Aryq;
  private bafb jdField_a_of_type_Bafb;
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ShortVideoItemBuilder.12(this);
  private Handler b;
  public int c;
  int d = -1;
  boolean f = false;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  }
  
  public adoi(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = 0;
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if (this.jdField_a_of_type_Aryq == null) {
      this.jdField_a_of_type_Aryq = ((aryq)paramQQAppInterface.getManager(324));
    }
  }
  
  private ados a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int i = aciy.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (i <= -1) {
        break label215;
      }
      Object localObject = aciy.a(this.jdField_a_of_type_ComTencentWidgetListView, i);
      if (localObject != null)
      {
        localObject = aciy.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof ados))) {
          return (ados)localObject;
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
  
  private ados a(MessageForShortVideo paramMessageForShortVideo)
  {
    ados localados = a(paramMessageForShortVideo.uniseq);
    if ((localados == null) && (QLog.isColorLevel())) {
      QLog.d("ShortVideoItemBuilder", 2, "holder is null, seq = " + paramMessageForShortVideo.uniseq);
    }
    return localados;
  }
  
  private Rect a(View paramView, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramView == null) || (paramMessageForShortVideo == null)) {
      return null;
    }
    paramView = paramView.findViewById(2131296697);
    if ((paramView instanceof AIOBubbleVideoView))
    {
      paramView = (AIOBubbleVideoView)paramView;
      Rect localRect = xgx.a(paramView);
      if (paramMessageForShortVideo.isSend()) {
        localRect.right = ((int)(localRect.right - paramView.k));
      }
      for (;;)
      {
        return localRect;
        float f1 = localRect.left;
        localRect.left = ((int)(paramView.k + f1));
      }
    }
    return null;
  }
  
  public static Drawable a(int paramInt1, int paramInt2)
  {
    return new amym(Color.rgb(214, 214, 214), paramInt1, paramInt2);
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Drawable localDrawable = null;
    if (bace.b(paramString))
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
  
  private String a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      int i;
      do
      {
        return null;
        i = paramString.indexOf(':');
      } while ((i < 0) || (i + 1 >= paramString.length()));
      paramString = paramString.substring(i + 1);
    } while (paramString == null);
    return paramString.trim();
  }
  
  private void a(ados paramados, int paramInt)
  {
    paramados.c.setVisibility(0);
    paramados.c.setText(paramInt);
    paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
    paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setImageResource(2130848457);
    paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(3);
  }
  
  private void a(ados paramados, View paramView, ChatMessage paramChatMessage)
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
        if ((aweo.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.msgTailType)) && (paramChatMessage.istroop == 1))
        {
          if (paramados.e == null)
          {
            paramados.e = new TextView(this.jdField_a_of_type_AndroidContentContext);
            paramados.e.setBackgroundResource(2130841999);
            paramados.e.setTextSize(1, 12.0F);
            paramados.e.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101537));
            paramados.e.setText(aweo.b(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.msgTailType));
            paramados.e.setSingleLine();
            paramados.e.setGravity(16);
            paramados.e.setPadding(azvv.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, azvv.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0);
            paramados.e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
            paramChatMessage.addRule(3, 2131298552);
            paramChatMessage.addRule(5, 2131298552);
            if ((paramView instanceof ViewGroup)) {
              ((ViewGroup)paramView).addView(paramados.e, paramChatMessage);
            }
          }
          paramView = (RelativeLayout.LayoutParams)paramados.e.getLayoutParams();
          if (localMessageForShortVideo.isSend()) {}
          for (paramView.leftMargin = BaseChatItemLayout.j;; paramView.leftMargin = BaseChatItemLayout.i)
          {
            paramados.e.setTag(localMessageForShortVideo);
            paramados.e.setVisibility(0);
            return;
          }
        }
      } while (paramados.e == null);
      paramados.e.setVisibility(8);
      return;
    }
  }
  
  private void a(ados paramados, MessageForShortVideo paramMessageForShortVideo, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, msg.uniseq = " + paramMessageForShortVideo.uniseq);
    }
    paramString = ShortVideoUtils.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, url = " + paramString);
    }
    if ((QLog.isColorLevel()) && (paramados.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d.getURL()=" + paramados.jdField_a_of_type_ComTencentImageURLDrawable.getURL());
    }
    paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setLogID(paramMessageForShortVideo.uniseq);
    if ((paramados.jdField_a_of_type_ComTencentImageURLDrawable != null) && (paramados.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d is reuse !!!");
      }
      if (paramBoolean)
      {
        paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setCoverDrawable(paramados.jdField_a_of_type_ComTencentImageURLDrawable);
        return;
      }
      paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(paramados.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    paramMessageForShortVideo = a(paramInt1, paramInt2);
    paramMessageForShortVideo = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, paramMessageForShortVideo, paramMessageForShortVideo);
    paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(paramMessageForShortVideo);
    paramados.jdField_a_of_type_ComTencentImageURLDrawable = paramMessageForShortVideo;
  }
  
  private void a(ados paramados, MessageForShortVideo paramMessageForShortVideo, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "playShortVideoLocal, msg.uniseq = " + paramMessageForShortVideo.uniseq);
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("playShortVideoLocal, thumbPath = ");
      if (paramString2 != null)
      {
        localObject = paramString2;
        QLog.d("ShortVideoItemBuilder", 2, (String)localObject);
      }
    }
    else
    {
      paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setLogID(paramMessageForShortVideo.uniseq);
      paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setPlayBusiType("bus_type_aio_long_bubble");
      localObject = a(paramInt1, paramInt2);
      if (!TextUtils.isEmpty(paramString2)) {
        break label205;
      }
      paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setCoverDrawable((Drawable)localObject);
      label128:
      if (paramMessageForShortVideo.videoFileTime > 8) {
        break label241;
      }
    }
    label205:
    label241:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0)
      {
        paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setVideoFileTimeMs(paramMessageForShortVideo.videoFileTime * 1000);
        paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setMaxPlayTimeMs(8000L);
      }
      paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setMute(true);
      paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setVideoPlayerCallback(this);
      paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(paramString1, true);
      return;
      localObject = "null";
      break;
      paramString2 = URLDrawable.getDrawable(ShortVideoUtils.a(paramString2), paramInt1, paramInt2, (Drawable)localObject, (Drawable)localObject);
      paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setCoverDrawable(paramString2);
      paramados.jdField_a_of_type_ComTencentImageURLDrawable = paramString2;
      break label128;
    }
  }
  
  private void a(ados paramados, MessageForShortVideo paramMessageForShortVideo, String[] paramArrayOfString, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "playShortVideoOnline, message.uniseq = " + paramMessageForShortVideo.uniseq);
    }
    paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setLogID(paramMessageForShortVideo.uniseq);
    paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setPlayBusiType("bus_type_aio_long_bubble");
    paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setServerType(String.valueOf(20160518));
    paramString = ShortVideoUtils.a(paramString);
    Drawable localDrawable = a(paramInt1, paramInt2);
    paramString = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localDrawable, localDrawable);
    paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setCoverDrawable(paramString);
    paramados.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
    if (paramMessageForShortVideo.videoFileTime <= 8) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0)
      {
        paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setVideoFileTimeMs(paramMessageForShortVideo.videoFileTime * 1000);
        paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setMaxPlayTimeMs(8000L);
      }
      paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setSavePath(ShortVideoUtils.a(paramMessageForShortVideo, "mp4"));
      paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setVid(paramMessageForShortVideo.md5 + paramMessageForShortVideo.uniseq);
      paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setMute(true);
      paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setVideoPlayerCallback(this);
      paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(paramArrayOfString, true);
      return;
    }
  }
  
  private void a(ados paramados, boolean paramBoolean)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    int i = localMessageForShortVideo.videoFileStatus;
    long l = 0L;
    if (paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView != null) {
      l = paramados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "click ppv, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType: " + ShortVideoUtils.a(localMessageForShortVideo.fileType) + ", fileStatus:" + ShortVideoUtils.b(i) + ", playPosition:" + l);
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("......click ppv, msg.uniseq:" + localMessageForShortVideo.uniseq);
    Object localObject = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    if (!localMessageForShortVideo.isSendFromLocal())
    {
      localStringBuilder.append(" sendFromLocal:false ");
      if (!bace.b((String)localObject))
      {
        localStringBuilder.append(" videoPathExists:false ");
        if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9))
        {
          localStringBuilder.append(" fileType:video, =" + ShortVideoUtils.a(localMessageForShortVideo.fileType));
          if (i == 2005)
          {
            b(paramados);
            bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653701, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
            localStringBuilder.append(" result:toast recv_error ");
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, localStringBuilder.toString());
      }
      return;
      if (i == 5001)
      {
        b(paramados);
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653699, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        localStringBuilder.append(" result: toast file_unsafe ");
      }
      else if (i == 5002)
      {
        a(paramados, 2131652954);
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653700, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        localStringBuilder.append(" result: toast file_expired ");
      }
      else
      {
        b(paramados);
        a(localMessageForShortVideo, l, paramBoolean);
        localStringBuilder.append(" status:other, result: download ");
        continue;
        if (i == 5002)
        {
          a(paramados, 2131652954);
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653700, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
          localStringBuilder.append("fileType:not video,videoPathExits:false, result:toast file_expired ");
        }
        else
        {
          b(paramados);
          a(localMessageForShortVideo, l, paramBoolean);
          localStringBuilder.append("fileType:not video,videoPathExits:false, result: download");
          continue;
          b(paramados);
          a(localMessageForShortVideo, l, paramBoolean);
          localStringBuilder.append("videoPathExists:true, result:play ");
          continue;
          localStringBuilder.append(" sendFromLocal:true ");
          if (localMessageForShortVideo.isMultiMsg) {
            localMessageForShortVideo.extraflag = 32772;
          }
          if (bace.b(localMessageForShortVideo.videoFileName))
          {
            localStringBuilder.append(" localUploadPath Exists:true ");
            if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9))
            {
              localStringBuilder.append(" fileType:video ");
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
              if (localObject != null)
              {
                if ((ShortVideoUploadProcessor.class.isInstance(localObject)) || (axun.class.isInstance(localObject)))
                {
                  if (i == 1005)
                  {
                    b(paramados);
                    paramados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                    localStringBuilder.append(" status:send_error, result:show send error ");
                  }
                  else if ((i == 1002) || (i == 1001))
                  {
                    a(localMessageForShortVideo, l, paramBoolean);
                    localStringBuilder.append(" status:process or start, result:pauseSending ");
                  }
                  else
                  {
                    b(paramados);
                    a(localMessageForShortVideo, l, paramBoolean);
                    localStringBuilder.append(" status:other, result:play ");
                  }
                }
                else if (axuk.class.isInstance(localObject)) {
                  localStringBuilder.append(" processor:not up of forward, result: none");
                }
              }
              else
              {
                b(paramados);
                a(localMessageForShortVideo, l, paramBoolean);
                localStringBuilder.append(" processor:null, result:play ");
              }
            }
            else
            {
              b(paramados);
              a(localMessageForShortVideo, l, paramBoolean);
              localStringBuilder.append(" fileType:not video, result: play ");
            }
          }
          else
          {
            localStringBuilder.append(" localUploadPath Exists:false ");
            if (!bace.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))
            {
              localStringBuilder.append(" downloadPath Exists:false ");
              if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9))
              {
                localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
                if (localObject != null)
                {
                  boolean bool;
                  if (axuk.class.isInstance(localObject))
                  {
                    bool = ((axuk)localObject).d();
                    localStringBuilder.append(" processor:download, pause:" + bool);
                    if (bool)
                    {
                      b(paramados);
                      a(localMessageForShortVideo, l, paramBoolean);
                      localStringBuilder.append(" pause:true, result:download ");
                    }
                    else if (i == 2005)
                    {
                      b(paramados);
                      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653701, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
                      localStringBuilder.append(" status:recv_error, result:toast recv_error ");
                    }
                    else if ((i == 2002) || (i == 2000) || (i == 2008) || (i == 2001))
                    {
                      b(paramados);
                    }
                    else if (i == 5001)
                    {
                      b(paramados);
                      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653699, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
                      localStringBuilder.append(" status:file_unsafe, result:toast unsafe ");
                    }
                    else if (i == 5002)
                    {
                      a(paramados, 2131652954);
                      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653700, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
                      localStringBuilder.append(" status:file_expired, result:toast expired ");
                    }
                    else
                    {
                      b(paramados);
                      a(localMessageForShortVideo, l, paramBoolean);
                      localStringBuilder.append(" status:other, result:download ");
                    }
                  }
                  else if (ShortVideoUploadProcessor.class.isInstance(localObject))
                  {
                    b(paramados);
                    paramados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                    bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653706, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
                    localStringBuilder.append(" processor:upload, result:show upload error and show toast");
                  }
                  else if (axun.class.isInstance(localObject))
                  {
                    bool = ((axun)localObject).d();
                    localStringBuilder.append(" processor:forward, pause:" + bool);
                    if (bool)
                    {
                      a(paramados, 10, false);
                      b(localMessageForShortVideo, paramados);
                      localStringBuilder.append(" pause:true, result:reforward ");
                    }
                    else if (i == 5001)
                    {
                      b(paramados);
                      paramados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653674, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
                      localStringBuilder.append(" status:unsafe, result:toast unsafe ");
                    }
                    else if (i == 5002)
                    {
                      a(paramados, 2131652954);
                      paramados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653675, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
                      localStringBuilder.append(" status:expired, result:toast expired ");
                    }
                    else if (i == 1005)
                    {
                      b(paramados);
                      paramados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                      localStringBuilder.append(" status:send_error, result:show send_error ");
                    }
                    else if ((i == 1002) || (i == 1001))
                    {
                      a(localMessageForShortVideo, 0L, paramBoolean);
                    }
                    else
                    {
                      b(paramados);
                      a(localMessageForShortVideo, 0L, paramBoolean);
                      localStringBuilder.append(" status:other, result:plau ");
                    }
                  }
                  else
                  {
                    localStringBuilder.append(" processor:not down or forward or up, result:none ");
                  }
                }
                else
                {
                  b(paramados);
                  localStringBuilder.append(" processor:null, result:download ");
                  a(localMessageForShortVideo, 0L, paramBoolean);
                }
              }
              else
              {
                b(paramados);
                a(localMessageForShortVideo, l, paramBoolean);
                localStringBuilder.append(" fileType:not video, result:download ");
              }
            }
            else
            {
              b(paramados);
              a(localMessageForShortVideo, l, paramBoolean);
              localStringBuilder.append(" downloadPath Exists:true，result:play ");
            }
          }
        }
      }
    }
  }
  
  private void a(ados paramados, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramados != null) && (paramados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null))
    {
      if (paramBoolean) {
        b(paramados, false, null);
      }
      paramados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!baab.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      baab.a().a(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForShortVideo.frienduin, 1, 1, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Bundle paramBundle, MessageForReplyText paramMessageForReplyText)
  {
    if ((qji.a(paramContext)) || (paramQQAppInterface.c()))
    {
      bbmy.a(paramContext, 0, 2131653692, 0).b(paramContext.getResources().getDimensionPixelSize(2131167766));
      return;
    }
    if (!paramMessageForShortVideo.isSend()) {
      new auxb(BaseApplication.getContext()).a(paramQQAppInterface, 2002, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
    }
    boolean bool = bgmq.d(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startPlayerActivity() msg.videoAttr=" + paramMessageForShortVideo.videoAttr + ", msg.istroop=" + paramMessageForShortVideo.istroop + ", isSupportMultiVideoSwitch=" + Boolean.valueOf(bool));
    }
    bool = bgmp.a(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startPlayerActivity() msg.videoAttr=" + paramMessageForShortVideo.videoAttr + ", msg.istroop=" + paramMessageForShortVideo.istroop + ", isSupportHOTVideoSwitch=" + Boolean.valueOf(bool));
    }
    if (MediaPlayerManager.a(paramQQAppInterface).b()) {
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
        bfcq.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), adwz.a(paramMessageForShortVideo), -1, i);
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
        localObject = (aryq)paramQQAppInterface.getManager(324);
        bool = ((aryq)localObject).a(paramMessageForShortVideo);
        paramBundle.putBoolean("extra.IS_SAVING_FILE", bool);
        if (bool)
        {
          localObject = ((aryq)localObject).a(((aryq)localObject).a(paramMessageForShortVideo));
          if ((localObject != null) && (((arym)localObject).d == 1)) {
            paramBundle.putInt("extra.SAVE_FILE_PROGRESS", ((arym)localObject).jdField_c_of_type_Int);
          }
        }
        if ((paramMessageForShortVideo.istroop != 0) || (!azzz.b(paramMessageForShortVideo.senderuin)) || (TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type")))) {
          continue;
        }
        paramBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
        bfcq.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), adwz.a(paramMessageForShortVideo), 13007, i);
        ((avau)paramQQAppInterface.getManager(326)).a();
        if (!paramMessageForShortVideo.isSend()) {
          new auxb(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
        }
        atuf.b(paramQQAppInterface, paramMessageForShortVideo);
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
    localBundle.putBoolean(bfcq.b, paramBoolean2);
    a(paramMessageForShortVideo, paramLong, paramContext, paramQQAppInterface, paramSessionInfo, localBundle, paramMessageForReplyText);
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "handleVideoCompressSucceed, seq = " + paramMessageForShortVideo.uniseq);
    }
    awfz localawfz = awfy.a().a(paramMessageForShortVideo.uniseq);
    if ((paramQQAppInterface != null) && (localawfz != null)) {
      if (localawfz.a() >= 104345600L)
      {
        paramMessageForShortVideo.videoFileStatus = 1005;
        paramMessageForShortVideo.serial();
        paramQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
        if (paramContext != null)
        {
          bbmy.a(paramContext, paramContext.getResources().getString(2131653672), 0).b(paramContext.getResources().getDimensionPixelSize(2131167766));
          paramContext = ((FragmentActivity)paramContext).getChatFragment();
          if (paramContext != null)
          {
            paramContext = paramContext.a();
            if (paramContext != null) {
              paramContext.b(false, false);
            }
          }
        }
        avau.a(paramQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
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
      paramContext = aweg.a(0, 0);
      paramMessageForShortVideo = aweg.a(paramMessageForShortVideo, paramContext);
      if (paramMessageForShortVideo != null)
      {
        paramMessageForShortVideo.i = localawfz.a();
        paramMessageForShortVideo.jdField_a_of_type_Boolean = false;
        paramContext.a(paramMessageForShortVideo);
      }
      aweg.a(paramContext, paramQQAppInterface);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(-1L);
      return;
    }
    QLog.i("ShortVideoItemBuilder", 2, "CompressTask onPostExecute QQAppInterface is null...");
  }
  
  private boolean a(long paramLong)
  {
    return ((avau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong);
  }
  
  private boolean a(ados paramados)
  {
    if (this.jdField_a_of_type_Aryq != null)
    {
      paramados = this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_Aryq.a(paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage));
      return (paramados != null) && (paramados.d == 1) && (!paramados.jdField_a_of_type_Boolean);
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
      if (awfy.a().a(paramMessageForShortVideo.uniseq) == null)
      {
        paramMessageForShortVideo = ShortVideoUtils.c(paramMessageForShortVideo.videoFileName, "mp4");
        if (!TextUtils.isEmpty(paramMessageForShortVideo)) {
          bace.d(paramMessageForShortVideo);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static Drawable b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    amym localamym = new amym(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localamym, localamym);
        localURLDrawable.setTag(azue.b(0, 0, paramInt3));
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
    return localamym;
  }
  
  private void b(ados paramados, View paramView, ChatMessage paramChatMessage)
  {
    if (c(paramados))
    {
      if (paramados.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        paramados.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramados.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838098);
        paramados.jdField_a_of_type_AndroidWidgetImageView.setId(2131298571);
        paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
        paramChatMessage.bottomMargin = aciy.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramChatMessage.addRule(8, 2131298552);
        paramChatMessage.addRule(0, 2131298552);
        paramChatMessage.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramados.jdField_a_of_type_AndroidWidgetImageView, paramChatMessage);
        }
      }
      b(paramados, true, this);
      return;
    }
    b(paramados, false, null);
  }
  
  private void b(ados paramados, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      if (paramados.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        paramados.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramados.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      }
    }
    while (paramados.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    paramados.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramados.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
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
      avau.a(paramQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    }
    if (paramContext != null) {}
  }
  
  private boolean b(ados paramados)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Aryq != null)
    {
      paramados = this.jdField_a_of_type_Aryq.a(this.jdField_a_of_type_Aryq.a(paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage));
      if ((paramados != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      bool1 = bool2;
      if (paramados != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean b(MessageForShortVideo paramMessageForShortVideo)
  {
    return false;
  }
  
  private void c(ados paramados)
  {
    if (c(paramados))
    {
      if (paramados.jdField_a_of_type_AndroidWidgetImageView != null) {
        break label20;
      }
      h();
    }
    label20:
    while (paramados.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      return;
    }
    b(paramados, true, this);
  }
  
  private void c(MessageForShortVideo paramMessageForShortVideo, ados paramados)
  {
    int k = 1;
    arym localarym;
    int i;
    if ((this.jdField_a_of_type_Aryq != null) && (paramMessageForShortVideo != null) && (paramados != null))
    {
      paramMessageForShortVideo = this.jdField_a_of_type_Aryq.a(paramMessageForShortVideo);
      localarym = this.jdField_a_of_type_Aryq.a(paramMessageForShortVideo);
      if ((localarym != null) && (localarym.d == 1))
      {
        if (localarym.jdField_c_of_type_Int >= 0) {
          break label188;
        }
        i = 0;
        j = k;
        if (paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getVisibility() != 8) {
          if ((paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getVisibility() != 0) || (paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.d != 2)) {
            break label213;
          }
        }
      }
    }
    label188:
    label213:
    for (int j = k;; j = 0)
    {
      if ((i < 100) && (j != 0) && (!localarym.jdField_a_of_type_Boolean) && (localarym.jdField_a_of_type_Aryl != null))
      {
        localarym.jdField_a_of_type_Aryl.a(new adoo(this, paramMessageForShortVideo, paramados));
        this.jdField_a_of_type_Aryq.a(paramMessageForShortVideo, localarym);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "dealVideoSaveUI showSaveProgress");
        }
        a(paramados, i, false);
        paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      }
      return;
      if (localarym.jdField_c_of_type_Int > 100)
      {
        i = 100;
        break;
      }
      i = localarym.jdField_c_of_type_Int;
      break;
    }
  }
  
  private boolean c(ados paramados)
  {
    boolean bool2 = true;
    if ((paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {
        return false;
      }
      int i;
      int j;
      if ((localMessageForShortVideo.videoFileStatus == 998) || (localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 1001))
      {
        i = 1;
        if ((localMessageForShortVideo.isMultiMsg) || (localMessageForShortVideo.uiOperatorFlag == 2) || (localMessageForShortVideo.busiType != 0) || (!localMessageForShortVideo.isSendFromLocal()) || (paramados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a())) {
          break label211;
        }
        j = 1;
        label109:
        if (QLog.isColorLevel())
        {
          paramados = new StringBuilder().append("needShowPauseIcon seq:").append(localMessageForShortVideo.uniseq).append(", videostatus:").append(localMessageForShortVideo.videoFileStatus).append(", iconshow:");
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
    return awug.a().a(this.jdField_a_of_type_AndroidContentContext, 1, paramMessageForShortVideo.istroop);
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
        AIOBubbleVideoView localAIOBubbleVideoView = (AIOBubbleVideoView)localIterator.next();
        if (localAIOBubbleVideoView != null) {
          localAIOBubbleVideoView.a();
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
        AIOBubbleVideoView localAIOBubbleVideoView = (AIOBubbleVideoView)localIterator.next();
        if (localAIOBubbleVideoView != null) {
          localAIOBubbleVideoView.b();
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
        AIOBubbleVideoView localAIOBubbleVideoView = (AIOBubbleVideoView)localIterator.next();
        if (localAIOBubbleVideoView != null)
        {
          localAIOBubbleVideoView.a(false);
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localAIOBubbleVideoView);
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
  
  public acjt a(View paramView)
  {
    if (paramView != null)
    {
      paramView = (ados)aciy.a(paramView);
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView;
      }
    }
    return null;
  }
  
  public acju a()
  {
    return new ados(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acmv paramacmv)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacmv);
    if ((paramChatMessage instanceof MessageForShortVideo)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramChatMessage);
    }
    a(paramChatMessage, paramView, this);
    a((ados)paramView.getTag(), paramView, paramChatMessage);
    b((ados)paramView.getTag(), paramView, paramChatMessage);
    if (e) {}
    try
    {
      paramChatMessage = (ados)paramView.getTag();
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append(paramChatMessage.jdField_a_of_type_AndroidWidgetTextView.getText());
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime);
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append("秒按钮");
      paramView.setContentDescription(paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.toString());
      return paramView;
    }
    catch (Exception paramChatMessage) {}
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView, message.uniseq = " + paramChatMessage.uniseq);
    }
    ados localados = (ados)paramacju;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramBaseChatItemLayout = (MessageForShortVideo)paramChatMessage;
    boolean bool1 = paramBaseChatItemLayout.isSend();
    paramacju = paramView;
    int i;
    if (paramView == null)
    {
      paramacju = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new AIOBubbleVideoView(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout.uniseq, bool1);
      paramView.setId(2131296697);
      paramView.setVisibility(0);
      paramView.setContentDescription(ajjy.a(2131648238));
      paramacju.addView(paramView);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramView);
      VideoProgressView localVideoProgressView = new VideoProgressView(this.jdField_a_of_type_AndroidContentContext);
      localVideoProgressView.setId(2131298594);
      paramacju.addView(localVideoProgressView);
      ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 0);
      i = aciy.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      Object localObject2 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramacju.addView(localProgressBar, (ViewGroup.LayoutParams)localObject2);
      Object localObject3 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject3).setOrientation(1);
      ((LinearLayout)localObject3).setGravity(17);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramacju.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      Object localObject4 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject4).topMargin = aciy.a(70.0F, (Resources)localObject1);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setId(2131298592);
      ((TextView)localObject2).setVisibility(4);
      ((LinearLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      localObject3 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject3).setBackgroundResource(2130838764);
      localObject4 = new RelativeLayout.LayoutParams(-1, aciy.a(55.0F, (Resources)localObject1));
      ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131296697);
      ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131296697);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131296697);
      paramacju.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setTextSize(1, 12.0F);
      ((TextView)localObject4).setTextColor(-1);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).leftMargin = aciy.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject5).bottomMargin = aciy.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject5).addRule(9);
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout)localObject3).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject5).setTextSize(1, 12.0F);
      ((TextView)localObject5).setTextColor(-1);
      Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).rightMargin = aciy.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject6).bottomMargin = aciy.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject6).addRule(11);
      ((RelativeLayout.LayoutParams)localObject6).addRule(12);
      ((RelativeLayout)localObject3).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      localObject6 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject6).setTextSize(1, 14.0F);
      ((TextView)localObject6).setTextColor(-1);
      ((TextView)localObject6).setGravity(17);
      ((TextView)localObject6).setText(2131653693);
      ((TextView)localObject6).setShadowLayer(3.0F, 1.0F, 1.0F, -16777216);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = aciy.a(14.0F, (Resources)localObject1);
      localLayoutParams.addRule(14);
      paramacju.addView((View)localObject6, localLayoutParams);
      paramacju.setOnClickListener(this);
      super.a(paramacju, paramacmv);
      localados.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
      localados.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
      localados.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      localados.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject5);
      localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView = localVideoProgressView;
      localados.c = ((TextView)localObject2);
      localados.d = ((TextView)localObject6);
      localados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView = paramView;
    }
    localados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setTag(Long.valueOf(paramBaseChatItemLayout.uniseq));
    baab.a().a(Long.valueOf(paramBaseChatItemLayout.uniseq), paramBaseChatItemLayout);
    if (localados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.jdField_a_of_type_Boolean != bool1)
    {
      localados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.jdField_a_of_type_Boolean = bool1;
      localados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.invalidate();
    }
    localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnClickListener(this);
    localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnTouchListener(paramacmv);
    localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnLongClickListener(paramacmv);
    localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setRadius(15.0F, true);
    localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setShowCorner(true);
    localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setSharpCornerCor(BubbleImageView.a);
    localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setCornerDirection(bool1);
    localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    atuf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout);
    paramView = (RelativeLayout.LayoutParams)localados.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    label1017:
    int j;
    int k;
    if (bool1)
    {
      paramView.leftMargin = 0;
      paramView.rightMargin = aciy.a(localados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(), (Resources)localObject1);
      paramView = (RelativeLayout.LayoutParams)localados.d.getLayoutParams();
      if (!bool1) {
        break label1408;
      }
      paramView.rightMargin = (aciy.a(localados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(), (Resources)localObject1) / 2);
      localados.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramBaseChatItemLayout.videoFileTime * 1000));
      localados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView = ShortVideoUtils.a(paramBaseChatItemLayout.thumbMD5, "jpg");
      paramacmv = ShortVideoUtils.a(paramBaseChatItemLayout.thumbWidth, paramBaseChatItemLayout.thumbHeight);
      j = paramacmv[0];
      k = paramacmv[1];
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView, msg.uniseq = " + paramBaseChatItemLayout.uniseq + " msg.thumbWidth = " + paramBaseChatItemLayout.thumbWidth + ", msg.thumbHeight = " + paramBaseChatItemLayout.thumbHeight + ", adjustWidth = " + j + ", adjustHeight = " + k);
      }
      paramacmv = localados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.getLayoutParams();
      if (paramacmv != null) {
        break label1430;
      }
      paramacmv = new RelativeLayout.LayoutParams(j, k);
      localados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setLayoutParams(paramacmv);
      label1210:
      paramacmv = localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getLayoutParams();
      if (paramacmv != null) {
        break label1477;
      }
      paramacmv = new LinearLayout.LayoutParams(j, k);
      localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setLayoutParams(paramacmv);
      label1248:
      if (aweg.jdField_a_of_type_Boolean)
      {
        aweg.jdField_a_of_type_Long = System.currentTimeMillis();
        aweg.jdField_a_of_type_Boolean = false;
      }
      paramacmv = a(j, k);
      b(localados);
      c(paramBaseChatItemLayout, localados);
      if ((paramBaseChatItemLayout.md5 != null) || (paramBaseChatItemLayout.CheckIsHotVideo()) || (paramBaseChatItemLayout.isCancelStatus())) {
        break label1682;
      }
      if (paramBaseChatItemLayout.isSendFromLocal())
      {
        localados.jdField_a_of_type_AndroidWidgetTextView.setText("");
        if (bace.b(paramView))
        {
          a(localados, paramBaseChatItemLayout, paramView, j, k, false);
          if (paramBaseChatItemLayout.videoFileStatus != 1005) {
            break label1524;
          }
          localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(2);
          localados.c.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      label1381:
      return paramacju;
      paramView.leftMargin = aciy.a(localados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(), (Resources)localObject1);
      paramView.rightMargin = 0;
      break;
      label1408:
      paramView.leftMargin = (aciy.a(localados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(), (Resources)localObject1) / 2);
      break label1017;
      label1430:
      if ((paramacmv.width == j) && (paramacmv.height == k)) {
        break label1210;
      }
      paramacmv.width = j;
      paramacmv.height = k;
      localados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setLayoutParams(paramacmv);
      break label1210;
      label1477:
      if ((paramacmv.width == j) && (paramacmv.height == k)) {
        break label1248;
      }
      paramacmv.width = j;
      paramacmv.height = k;
      localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setLayoutParams(paramacmv);
      break label1248;
      label1524:
      localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      localados.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      localados.d.setVisibility(8);
      localados.c.setVisibility(8);
      localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      if ((paramBaseChatItemLayout.videoFileStatus != 998) || (a(paramBaseChatItemLayout)))
      {
        paramChatMessage = new awfz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, this);
        awfy.a().a(paramBaseChatItemLayout.uniseq, paramChatMessage);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView(): msg.md5 == null, start compress task, id:" + paramBaseChatItemLayout.uniseq);
        }
      }
      paramChatMessage = awfy.a().a(paramBaseChatItemLayout.uniseq);
      if (paramChatMessage == null) {
        continue;
      }
      paramChatMessage.a(this);
      return paramacju;
      label1682:
      localados.c.setVisibility(8);
      localados.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout.videoFileSize));
      localados.d.setVisibility(8);
      if (bace.b(paramView))
      {
        if ((paramBaseChatItemLayout.videoFileStatus == 998) || (paramBaseChatItemLayout.videoFileStatus == 1001) || (paramBaseChatItemLayout.videoFileStatus == 1002) || (paramBaseChatItemLayout.videoFileStatus == 1004)) {}
        for (i = 1;; i = 0)
        {
          if ((c(paramBaseChatItemLayout)) && ((!paramBaseChatItemLayout.isSendFromLocal()) || (i == 0)) && (!b(localados)) && (!b(paramBaseChatItemLayout)) && (!a(paramBaseChatItemLayout.uniseq))) {
            break label2166;
          }
          a(localados, paramBaseChatItemLayout, paramView, j, k, false);
          localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
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
            return paramacju;
          case 1001: 
            if (paramChatMessage != null) {
              break label3044;
            }
            localados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            b(localados);
            if (!QLog.isColorLevel()) {
              break label1381;
            }
            QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_START, 上传开始被杀进程然后恢复, uniseq:" + paramBaseChatItemLayout.uniseq);
            return paramacju;
          }
        }
        label2166:
        paramacmv = ShortVideoUtils.a(paramBaseChatItemLayout, "mp4");
        localObject1 = new File(paramacmv);
        long l1;
        label2220:
        label2231:
        boolean bool2;
        if (((File)localObject1).exists())
        {
          long l2 = ((File)localObject1).length();
          if (paramBaseChatItemLayout.videoFileTime <= 8)
          {
            l1 = paramBaseChatItemLayout.videoFileSize;
            if (l2 >= l1) {
              break label2394;
            }
            bool1 = true;
            bool2 = bool1;
            if (QLog.isColorLevel())
            {
              QLog.d("ShortVideoItemBuilder", 2, "===> 1 video file  exits, downloadedSize =" + l2 + ", estimatedSize=" + l1 + ", needDownload=" + bool1 + ",videoFileTime=" + paramBaseChatItemLayout.videoFileTime);
              bool2 = bool1;
            }
            label2308:
            if (!bool2) {
              break label2433;
            }
            if ((!badq.h(this.jdField_a_of_type_AndroidContentContext)) || (paramBaseChatItemLayout.videoFileStatus == 5002)) {
              break label2421;
            }
            paramChatMessage = aweg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, 2);
            if (paramChatMessage != null) {
              aweg.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
          }
        }
        for (;;)
        {
          a(localados, paramBaseChatItemLayout, paramView, j, k, true);
          break;
          l1 = qhv.a(8, paramBaseChatItemLayout.videoFileTime, paramBaseChatItemLayout.videoFileSize);
          break label2220;
          label2394:
          bool1 = false;
          break label2231;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "===> 2 video file no exits, need download video.");
          }
          bool2 = true;
          break label2308;
          label2421:
          localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
        }
        label2433:
        a(localados, paramBaseChatItemLayout, paramacmv, paramView, j, k);
        if (paramBaseChatItemLayout.videoFileTime <= 8)
        {
          i = 1;
          label2461:
          a(localados);
          if (i == 0) {
            localados.d.setVisibility(0);
          }
          if ((paramBaseChatItemLayout.CheckIsHotVideo()) && (!baab.a().a(paramBaseChatItemLayout, "0X8007EDB")))
          {
            baab.a().a(paramBaseChatItemLayout, "0X8007EDB");
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
          }
          if (baab.a().a(paramBaseChatItemLayout, "0X80077D9")) {
            continue;
          }
          i = new.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          paramView = new JSONObject();
        }
      }
      try
      {
        paramView.put("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramView.put("memNum", i);
        paramView.put("msg_uniseq", paramChatMessage.uniseq);
        ndn.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", new.a(paramBaseChatItemLayout.getMd5(), null, null, null, paramView), false);
        baab.a().a(paramBaseChatItemLayout, "0X80077D9");
        return paramacju;
        i = 0;
        break label2461;
        if (((paramBaseChatItemLayout.fileType == 7) || (paramBaseChatItemLayout.fileType == 18) || (paramBaseChatItemLayout.fileType == 16)) && (paramBaseChatItemLayout.videoFileStatus == 5002))
        {
          localados.d.setVisibility(8);
          localados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(paramacmv);
          a(localados, 2131652954);
          if (!QLog.isColorLevel()) {
            break label1852;
          }
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not download pic : 缩略图不存在，而且文件已经过期，不下载, , uniseq:" + paramBaseChatItemLayout.uniseq);
          break label1852;
        }
        if ((paramBaseChatItemLayout.extraflag == 32768) || (b(localados))) {
          break label1852;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not SendFromLocal : 缩略图不存在，开始下载缩略图, , uniseq:" + paramBaseChatItemLayout.uniseq);
        }
        localados.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(paramacmv);
        paramChatMessage = aweg.a(2, this.jdField_c_of_type_Int);
        paramView = paramBaseChatItemLayout.getDownloadInfo(paramChatMessage.jdField_b_of_type_Int);
        paramView.i = ShortVideoUtils.a(paramBaseChatItemLayout.thumbMD5, "jpg");
        if ((paramBaseChatItemLayout.istroop == 0) || (paramBaseChatItemLayout.istroop == 1008)) {
          paramView.e = 1002;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideoThumb downloadVideo fileType=" + paramView.e + ", uniseq:" + paramBaseChatItemLayout.uniseq);
          }
          paramView.f = 2;
          paramChatMessage.a(paramView);
          paramChatMessage.a(paramBaseChatItemLayout);
          aweg.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
          if (paramBaseChatItemLayout.istroop == 3000) {
            paramView.e = 1006;
          } else if (paramBaseChatItemLayout.istroop == 1) {
            paramView.e = 1004;
          }
        }
        label3044:
        a(localados, ShortVideoUtils.a(paramBaseChatItemLayout.videoFileProgress, 10), false);
        return paramacju;
        localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
        localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(localados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + localados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        b(localados);
        a(localados, true, this);
        return paramacju;
        if (paramChatMessage == null)
        {
          localados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          b(localados);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_PROCESS, 上传过程中被杀进程然后恢复, uniseq:" + paramBaseChatItemLayout.uniseq);
          return paramacju;
        }
        if (((avau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).b(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq))
        {
          localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(10, paramBaseChatItemLayout.frienduin + paramBaseChatItemLayout.uniseq);
          localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
          return paramacju;
        }
        i = paramBaseChatItemLayout.videoFileProgress;
        if ((paramChatMessage instanceof ShortVideoUploadProcessor))
        {
          paramChatMessage = (ShortVideoUploadProcessor)paramChatMessage;
          if (paramChatMessage.a() != 0L)
          {
            i = (int)(100L * paramChatMessage.b() / paramChatMessage.a());
            a(localados, ShortVideoUtils.a(i, 10), false);
            return paramacju;
            b(localados);
            return paramacju;
            b(localados);
            return paramacju;
            b(localados);
            return paramacju;
            b(localados);
            return paramacju;
            a(localados, 2131652954);
            return paramacju;
          }
        }
      }
      catch (Exception paramChatMessage)
      {
        for (;;) {}
      }
    }
  }
  
  public bakh a(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    boolean bool3 = false;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramackl = (ados)paramackl;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.a(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForShortVideo.videoFileStatus));
    }
    b(parambakh, this.jdField_a_of_type_AndroidContentContext);
    int i;
    boolean bool1;
    label221:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramChatMessage = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (bace.b(paramChatMessage))
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
        if ((paramackl.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView == null) || (!paramackl.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramackl.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramackl.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
          break label479;
        }
        bool1 = true;
        bool2 = bool3;
        if (paramackl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
        {
          bool2 = bool3;
          if (paramackl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
            bool2 = true;
          }
        }
        if ((!bool4) || (bool1) || (bool2)) {
          break label432;
        }
        parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131627114), 2130838599);
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
      if ((localMessageForShortVideo != null) && (bace.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))) {
        parambakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131626722), 2130838598);
      }
      this.f = true;
      return parambakh;
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
    if (bado.a(paramChatMessage.issend)) {
      return ajjy.a(2131648246);
    }
    return ajjy.a(2131648298);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing()))
    {
      this.jdField_a_of_type_Bafb.dismiss();
      this.jdField_a_of_type_Bafb = null;
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        AIOBubbleVideoView localAIOBubbleVideoView = (AIOBubbleVideoView)localIterator.next();
        if (localAIOBubbleVideoView != null)
        {
          long l = localAIOBubbleVideoView.a();
          if (l > 0L)
          {
            MessageForShortVideo localMessageForShortVideo = baab.a().a(Integer.valueOf(localAIOBubbleVideoView.getId()));
            if (localMessageForShortVideo != null) {
              a(localMessageForShortVideo, l);
            }
          }
          localAIOBubbleVideoView.a(false);
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localAIOBubbleVideoView);
        }
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForShortVideo)) {}
    label648:
    label651:
    for (;;)
    {
      return;
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      this.d = paramInt;
      if (paramInt == 2131299417)
      {
        aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
      }
      if (paramInt == 2131304871)
      {
        super.d(paramChatMessage);
        return;
      }
      if (paramInt == 2131301021)
      {
        b(localMessageForShortVideo);
        if (paramChatMessage.isMultiMsg) {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 6, 0, "6", "", "", "");
        }
      }
      else if (paramInt == 2131300328)
      {
        bfhl.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bfhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
        if (paramChatMessage.isMultiMsg) {
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 6, 0, "6", "", "", "");
        }
      }
      else
      {
        if (paramInt == 2131304829)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked(): msg_revoke =>" + localMessageForShortVideo.toLogString());
          }
          if (localMessageForShortVideo.md5 == null)
          {
            awfy.a().b(localMessageForShortVideo.uniseq);
            jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(localMessageForShortVideo.uniseq);
            ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(20)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
            avau.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
            return;
          }
          paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
          if ((paramContext == null) || ((!ShortVideoUploadProcessor.class.isInstance(paramContext)) && (!axun.class.isInstance(paramContext)))) {
            break label648;
          }
          boolean bool = ((axou)paramContext).d();
          paramInt = localMessageForShortVideo.videoFileStatus;
          if ((!bool) && (paramInt != 1002) && (paramInt != 1001)) {
            break label648;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
          ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(20)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked: stop uploading short video");
          }
        }
        for (paramInt = 0;; paramInt = 1)
        {
          if (paramInt == 0) {
            break label651;
          }
          super.a(localMessageForShortVideo);
          return;
          if (paramInt == 2131304932)
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
            awqx.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 2, 0, "", "", "", "");
            return;
          }
          super.a(paramInt, paramContext, paramChatMessage);
          return;
        }
      }
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "onStateChange , state = " + paramInt + ", msgUniseq=" + paramLong);
    }
    if (paramInt == 3)
    {
      paramObject = baab.a().a(Long.valueOf(paramLong));
      if ((!baab.a().a(Long.valueOf(paramLong))) && (paramObject != null))
      {
        ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObject, this.jdField_a_of_type_AndroidContentContext);
        if (!baab.a().b(Long.valueOf(paramObject.uniseq)))
        {
          baab.a().a(Long.valueOf(paramObject.uniseq));
          ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E50", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObject, this.jdField_a_of_type_AndroidContentContext);
        }
        baab.a().a(Long.valueOf(paramLong), true);
      }
    }
    paramObject = a(paramLong);
    if (paramObject == null) {
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
          if (((MessageForShortVideo)paramObject.jdField_a_of_type_ComTencentMobileqqDataChatMessage).videoFileTime <= 8) {}
          for (bool = true; paramInt == 4; bool = false)
          {
            this.jdField_b_of_type_AndroidOsHandler.postDelayed(new ShortVideoItemBuilder.6(this, bool, paramObject), 1200L);
            return;
          }
          if ((paramInt != 6) && (paramInt != 7)) {
            break;
          }
          this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          paramObject.d.setVisibility(8);
          paramObject.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
          b(paramObject);
          paramObject.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          paramObject.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        } while (paramInt != 7);
        paramObject = baab.a().a(Long.valueOf(paramLong));
      } while (paramObject == null);
      a(paramObject, paramObject.videoFileTime * 1000);
      return;
    } while (paramInt != 3);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (bool) {
      paramObject.d.setVisibility(8);
    }
    for (;;)
    {
      a(paramObject);
      paramObject.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramObject.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramObject = baab.a().a(Long.valueOf(paramLong));
      if (paramObject == null) {
        break;
      }
      a(paramObject, 0L);
      return;
      paramObject.d.setVisibility(0);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "onLoopBack, id = " + paramLong1 + " ,position = " + paramLong2);
    }
    a(baab.a().a(Long.valueOf(paramLong1)), paramLong2);
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "onDownload , id = " + paramLong + ", str=" + paramString);
    }
    Object localObject1 = aciy.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
    if ((localObject1 instanceof MessageForShortVideo))
    {
      localObject1 = (MessageForShortVideo)localObject1;
      if (((((MessageForShortVideo)localObject1).fileType != 6) && (((MessageForShortVideo)localObject1).fileType != 17) && (((MessageForShortVideo)localObject1).fileType != 9)) || (((MessageForShortVideo)localObject1).videoFileStatus == 2003)) {}
    }
    label579:
    label584:
    for (;;)
    {
      try
      {
        int j;
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = new JSONObject(paramString);
          int m = paramString.getInt("callBackType");
          int k = paramString.getInt("fileSize");
          int n = paramString.getInt("newFileSize");
          int i = paramString.getInt("offset");
          if (m != 7) {
            break label584;
          }
          ((MessageForShortVideo)localObject1).videoFileStatus = 2003;
          ((MessageForShortVideo)localObject1).transferedSize = 0;
          ((MessageForShortVideo)localObject1).videoFileProgress = 100;
          ((MessageForShortVideo)localObject1).serial();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForShortVideo)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageForShortVideo)localObject1).uniseq, ((MessageForShortVideo)localObject1).msgData);
          i = k;
          if (paramString.has("httpHeader"))
          {
            paramString = paramString.getString("httpHeader");
            if (!TextUtils.isEmpty(paramString))
            {
              paramString = paramString.split("\r\n");
              if (paramString != null)
              {
                j = 1;
                if (j >= paramString.length) {
                  break label579;
                }
                Object localObject2 = paramString[j];
                if (!((String)localObject2).startsWith("User-ReturnCode")) {
                  continue;
                }
                paramString = a((String)localObject2);
                if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("-5103059")))
                {
                  localObject2 = a(((MessageForShortVideo)localObject1).uniseq);
                  if (localObject2 != null)
                  {
                    ((ados)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
                    ((ados)localObject2).d.setVisibility(8);
                    a((ados)localObject2, 2131652954);
                  }
                  ((MessageForShortVideo)localObject1).videoFileStatus = 5002;
                  ((MessageForShortVideo)localObject1).serial();
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForShortVideo)localObject1).frienduin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((MessageForShortVideo)localObject1).uniseq, ((MessageForShortVideo)localObject1).msgData);
                }
                if (QLog.isColorLevel()) {
                  QLog.d("ShortVideoItemBuilder", 2, "OnDownload: User-ReturnCode = " + paramString);
                }
              }
            }
          }
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder("OnDownload:");
            paramString.append("uniseq=").append(paramLong).append("|");
            paramString.append("callBackType=").append(m).append("|");
            paramString.append("fileSize=").append(k).append("|");
            paramString.append("newFileSize=").append(n).append("|");
            paramString.append("offset=").append(i).append("|");
            QLog.i("ShortVideoItemBuilder", 2, paramString.toString());
          }
        }
        return;
        j += 1;
        continue;
        paramString = null;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
  }
  
  public void a(ados paramados)
  {
    if (a(paramados)) {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "disProgress...file is saving, so return!");
      }
    }
    do
    {
      return;
      if (!a(paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "disProgress fail...video order sending! " + paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return;
    if (!paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
      return;
    }
    paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimRunnableListener(new adon(this, paramados));
  }
  
  protected void a(ados paramados, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 100)
    {
      paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(paramInt, paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    for (;;)
    {
      paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVideoCompressStatus(false);
      paramados.c.setVisibility(8);
      return;
      paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(paramInt, paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (ados)aciy.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      begr localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbegr.a(2131624443, 5);
      localbegr.c(2131625035);
      localbegr.a(new adol(this, localMessageForShortVideo, paramView, localbegr));
      localbegr.show();
      if (localMessageForShortVideo.videoFileStatus == 1004) {
        ShortVideoUtils.c("0X800A374", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(View paramView, axqf paramaxqf, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = (ados)aciy.a(paramView);
        paramView = (MessageForShortVideo)((ados)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject2 = ((ados)localObject1).jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView;
        if (paramView.uniseq != paramaxqf.jdField_b_of_type_Long) {
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.e("ShortVideoItemBuilder", 2, "handleMessage getHolder error ! ", paramView);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "handleMessage msg.uniseq:" + paramView.uniseq + ",fileType:" + ShortVideoUtils.a(paramaxqf.jdField_b_of_type_Int) + " ===> fileStatus:" + ShortVideoUtils.b(paramaxqf.d));
      }
      paramInt2 = 0;
      paramInt1 = 0;
      if ((paramaxqf.jdField_b_of_type_Int == 6) || (paramaxqf.jdField_b_of_type_Int == 17) || (paramaxqf.jdField_b_of_type_Int == 9) || (paramaxqf.jdField_b_of_type_Int == 20)) {}
      switch (paramaxqf.d)
      {
      default: 
      case 1001: 
        if (paramaxqf.jdField_a_of_type_Long != 0L) {
          paramInt1 = (int)(100L * paramaxqf.e / paramaxqf.jdField_a_of_type_Long);
        }
        a((ados)localObject1, ShortVideoUtils.a(paramInt1, 10), true);
        ((ados)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        c((ados)localObject1);
        return;
      case 1003: 
        a((ados)localObject1, 100, true);
        b((ados)localObject1);
        b((ados)localObject1, false, null);
        awfy.a().a(((ados)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1005: 
        b((ados)localObject1);
        ((ados)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        awfy.a().a(((ados)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1004: 
        ((ados)localObject1).jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(((ados)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + ((ados)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        b((ados)localObject1);
        a((ados)localObject1, true, this);
        awfy.a().a(((ados)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1007: 
        b((ados)localObject1);
        b((ados)localObject1, false, null);
        awfy.a().a(((ados)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1002: 
        if (!paramView.isSendFromLocal()) {
          continue;
        }
        if (paramaxqf.jdField_a_of_type_Long != 0L) {
          paramInt1 = (int)(100L * paramaxqf.e / paramaxqf.jdField_a_of_type_Long);
        }
        for (;;)
        {
          a((ados)localObject1, ShortVideoUtils.a(paramInt1, 10), true);
          return;
          paramInt1 = paramInt2;
          if (QLog.isColorLevel())
          {
            QLog.e("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS: fileSize == 0 ");
            paramInt1 = paramInt2;
          }
        }
      case 2001: 
        b((ados)localObject1);
        ((ados)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        return;
      case 2003: 
        b((ados)localObject1);
        if (b((ados)localObject1)) {
          continue;
        }
        paramaxqf = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
        if (bace.b(paramaxqf)) {
          continue;
        }
        localObject1 = aweg.a(2, this.jdField_c_of_type_Int);
        localObject2 = paramView.getDownloadInfo(((awey)localObject1).jdField_b_of_type_Int);
        ((awej)localObject2).i = paramaxqf;
        if ((paramView.istroop == 0) || (paramView.istroop == 1008)) {
          ((awej)localObject2).e = 1002;
        }
        for (;;)
        {
          ((awey)localObject1).a((awej)localObject2);
          ((awey)localObject1).a(paramView);
          aweg.a((awey)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
          if (paramView.istroop == 3000) {
            ((awej)localObject2).e = 1006;
          } else if (paramView.istroop == 1) {
            ((awej)localObject2).e = 1004;
          }
        }
      case 2005: 
        b((ados)localObject1);
        if (paramaxqf.g == -5100528) {
          continue;
        }
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653701, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        return;
      case 5001: 
        a((ados)localObject1, 2131652953);
        if (paramView.uiOperatorFlag == 2)
        {
          ((ados)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653674, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
          return;
        }
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653699, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        return;
      case 5002: 
        a((ados)localObject1, 2131652954);
        if (paramView.uiOperatorFlag == 2)
        {
          ((ados)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653675, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
          return;
        }
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653700, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        return;
      case 2004: 
        b((ados)localObject1);
        return;
      case 2002: 
        b((ados)localObject1);
        a((ados)localObject1);
        if ((paramaxqf.c == null) || (!c(paramView)) || (b((ados)localObject1)) || (b(paramView))) {
          continue;
        }
        localObject2 = paramaxqf.c;
        paramaxqf = paramaxqf.u;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_RECV_PROCESS: domain=" + paramaxqf + ", videoUrls=" + Arrays.toString((Object[])localObject2));
        }
        Object localObject3 = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
        int[] arrayOfInt = ShortVideoUtils.a(paramView.thumbWidth, paramView.thumbHeight);
        paramInt2 = arrayOfInt[0];
        int i = arrayOfInt[1];
        paramInt1 = 0;
        while (paramInt1 < 1)
        {
          if (!TextUtils.isEmpty(paramaxqf)) {
            localObject2[paramInt1] = (localObject2[paramInt1] + "&txhost=" + paramaxqf);
          }
          paramInt1 += 1;
        }
        a((ados)localObject1, paramView, (String[])localObject2, (String)localObject3, paramInt2, i);
        if ((paramView.CheckIsHotVideo()) && (!baab.a().a(paramView, "0X8007EDB")))
        {
          baab.a().a(paramView, "0X8007EDB");
          awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
        }
        if (baab.a().a(paramView, "0X80077D9")) {
          continue;
        }
        paramInt1 = new.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramaxqf = new JSONObject();
        try
        {
          paramaxqf.put("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          paramaxqf.put("memNum", paramInt1);
          paramaxqf.put("msg_uniseq", paramView.uniseq);
          label1304:
          ndn.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", new.a(paramView.getMd5(), null, null, null, paramaxqf), false);
          baab.a().a(paramView, "0X80077D9");
          return;
          if ((paramaxqf.jdField_b_of_type_Int != 7) && (paramaxqf.jdField_b_of_type_Int != 18) && (paramaxqf.jdField_b_of_type_Int != 16)) {
            continue;
          }
          switch (paramaxqf.d)
          {
          default: 
          case 2001: 
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_START:");
            return;
          case 2003: 
            paramaxqf = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
            localObject2 = ShortVideoUtils.a(paramView.thumbWidth, paramView.thumbHeight);
            paramInt2 = localObject2[0];
            i = localObject2[1];
            if ((!c(paramView)) || (b((ados)localObject1)) || (b(paramView))) {
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
                  break label1634;
                }
                paramInt1 = 0;
              }
            }
            for (;;)
            {
              if (paramInt1 == 0) {
                break label1644;
              }
              if (badq.h(this.jdField_a_of_type_AndroidContentContext))
              {
                localObject2 = aweg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, 2);
                if (localObject2 != null) {
                  aweg.a((awey)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                }
              }
              a((ados)localObject1, paramView, paramaxqf, paramInt2, i, true);
              return;
              l1 = qhv.a(8, paramView.videoFileTime, paramView.videoFileSize);
              break;
              paramInt1 = 1;
              continue;
              paramInt1 = 1;
            }
            if (paramView.videoFileTime <= 8) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              a((ados)localObject1, paramView, (String)localObject2, paramaxqf, paramInt2, i);
              a((ados)localObject1);
              if (paramInt1 == 0) {
                break;
              }
              ((ados)localObject1).d.setVisibility(8);
              return;
            }
            ((ados)localObject1).d.setVisibility(0);
            return;
          case 2005: 
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_ERROR:");
            return;
          case 5002: 
            label1634:
            label1644:
            paramView = ShortVideoUtils.a(paramView.thumbWidth, paramView.thumbHeight);
            paramInt1 = paramView[0];
            paramInt2 = paramView[1];
            ((ados)localObject1).jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(a(paramInt1, paramInt2));
            a((ados)localObject1, 2131652954);
            ((ados)localObject1).d.setVisibility(8);
            return;
          }
        }
        catch (Exception localException)
        {
          break label1304;
        }
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165222);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, i, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, float paramFloat)
  {
    ados localados = a(paramMessageForShortVideo);
    if (localados == null) {
      return;
    }
    paramMessageForShortVideo = paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq;
    localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(ajjy.a(2131648274), paramMessageForShortVideo);
    localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramMessageForShortVideo, paramFloat);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "CompressUpdateListener,onFinish. seq = " + paramMessageForShortVideo.uniseq);
    }
    befn.a(new ShortVideoItemBuilder.4(this, paramMessageForShortVideo, paramInt));
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 998) {
      return;
    }
    if ((TextUtils.isEmpty(paramMessageForShortVideo.md5)) || (paramMessageForShortVideo.videoFileStatus == 1004))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653664, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
      return;
    }
    String str = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    boolean bool2 = NetworkUtils.isMobileConnected(this.jdField_a_of_type_AndroidContentContext);
    if ((aweg.jdField_a_of_type_Long != 0L) && (System.currentTimeMillis() - aweg.jdField_a_of_type_Long < 300000L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "startPlayVideo isConfirmed=" + bool1 + " allowPlayInXGTime=" + aweg.jdField_a_of_type_Long + " isXGConnected = " + bool2);
      }
      if ((!bool2) || (bool1) || ((bace.a(str)) && (paramMessageForShortVideo.videoFileStatus != 2002)) || (paramMessageForShortVideo.videoFileSize < 1048576)) {
        break label348;
      }
      if (!bbrm.a((Activity)this.jdField_a_of_type_AndroidContentContext, 3, new adop(this, paramMessageForShortVideo, paramLong, paramBoolean))) {
        break;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131652638);
      this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131652641), str, this.jdField_a_of_type_AndroidContentContext.getString(2131652639), this.jdField_a_of_type_AndroidContentContext.getString(2131652640), new adoq(this, paramMessageForShortVideo, paramLong, paramBoolean), new ador(this));
      paramMessageForShortVideo = aric.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
      if ((paramMessageForShortVideo instanceof SpannableString)) {
        this.jdField_a_of_type_Bafb.setMessageWithoutAutoLink(paramMessageForShortVideo);
      }
      try
      {
        this.jdField_a_of_type_Bafb.show();
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
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, ados paramados)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    boolean bool = paramMessageForShortVideo.CheckIsHotVideo();
    String str1 = paramMessageForShortVideo.videoFileName;
    String str2 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if ((!bace.b(str1)) && (!bool))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131653706, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
      b(paramados);
      paramados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if ((!bace.b(str2)) && (!bool))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131653707, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
      b(paramados);
      paramados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((avau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    paramados = aweg.a(1, this.jdField_c_of_type_Int);
    paramMessageForShortVideo = aweg.a(this.jdField_c_of_type_Int, paramMessageForShortVideo, paramados);
    paramMessageForShortVideo.e = bool;
    paramados.a(paramMessageForShortVideo);
    aweg.a(paramados, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    ados localados = a(paramMessageForShortVideo);
    if (localados == null) {
      return;
    }
    befn.a(new ShortVideoItemBuilder.3(this, paramMessageForShortVideo, paramBoolean, localados));
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
            break label453;
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
                      if (paramChatMessage.videoFileStatus != 998) {
                        j = 1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label453:
        break;
      }
    }
  }
  
  public bakj[] a(View paramView)
  {
    paramView = (ados)aciy.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bakh localbakh = new bakh();
    if (localMessageForShortVideo != null)
    {
      if (!localMessageForShortVideo.isMultiMsg) {
        break label48;
      }
      a(localbakh, localMessageForShortVideo, paramView);
    }
    for (;;)
    {
      return localbakh.a();
      label48:
      b(localbakh, localMessageForShortVideo, paramView);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public bakh b(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    boolean bool3 = false;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    ados localados = (ados)paramackl;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.a(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForShortVideo.videoFileStatus));
    }
    b(parambakh, this.jdField_a_of_type_AndroidContentContext);
    int i;
    boolean bool1;
    label226:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramackl = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (bace.b(paramackl))
      {
        paramackl = "";
        i = 1;
        if (i == 0) {
          break label574;
        }
        if (!"1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"))) {
          break label561;
        }
        boolean bool4 = localMessageForShortVideo.checkForward();
        if ((localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView == null) || (!localados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(localados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + localados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
          break label568;
        }
        bool1 = true;
        bool2 = bool3;
        if (localados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
        {
          bool2 = bool3;
          if (localados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
            bool2 = true;
          }
        }
        if ((!bool4) || (bool1) || (bool2)) {
          break label521;
        }
        parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131627114), 2130838599);
        paramackl = paramackl + "inMiddleStatus = false, progeressBarShowing = false, errorIconShowing = false, show forward menu.";
      }
    }
    label521:
    label561:
    label568:
    label574:
    for (;;)
    {
      a(localMessageForShortVideo, parambakh);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getMenuItem: " + paramackl);
      }
      if ((localMessageForShortVideo != null) && ((localados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (localados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0))) {
        a(parambakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForShortVideo);
      }
      a(parambakh, localMessageForShortVideo);
      if ((localMessageForShortVideo != null) && (bace.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))) {
        parambakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131626722), 2130838598);
      }
      b(paramChatMessage, parambakh);
      super.c(parambakh, this.jdField_a_of_type_AndroidContentContext);
      super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
      this.f = true;
      return parambakh;
      paramackl = "thumbFilePath=" + paramackl + " , not exits.";
      i = 0;
      break;
      paramackl = " msg == null or md5 is empty.";
      i = 0;
      break;
      paramackl = paramackl + "progeressBarShowing=" + bool1 + ", errorIconShowing=" + bool2;
      continue;
      paramackl = " not inDPCWhiteList.";
      continue;
      bool1 = false;
      break label226;
    }
  }
  
  protected void b(ados paramados)
  {
    if (a(paramados)) {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "hideProgress...file is saving, so return!");
      }
    }
    do
    {
      return;
      if (!a(paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "hideProgress fail...video order sending! " + paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return;
    paramados.c.setVisibility(8);
    if (!paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramados.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(2);
      return;
    }
    paramados.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimRunnableListener(new adoj(this, paramados));
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
    if (!TextUtils.isEmpty(paramMessageForShortVideo.templateId)) {
      localBundle.putString("widgetinfo", paramMessageForShortVideo.templateId);
    }
    paramMessageForShortVideo = new Intent();
    paramMessageForShortVideo.putExtras(localBundle);
    aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "1", "", "");
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("muate_play", paramBoolean);
    a(paramMessageForShortVideo, paramLong, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localBundle, null);
    ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, ados paramados)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "reForwardVideo：" + paramMessageForShortVideo.toString());
      }
      if (!bace.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131653707, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        b(paramados);
        paramados.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        ((avau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
        paramados = aweg.a(4, this.jdField_c_of_type_Int);
        paramados.a(aweg.a(this.jdField_c_of_type_Int, paramMessageForShortVideo, paramados));
        aweg.a(paramados, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    Object localObject1 = (AppActivity)this.jdField_a_of_type_AndroidContentContext;
    if ((localObject1 != null) && (Build.VERSION.SDK_INT >= 23) && (!akhu.a((Context)localObject1))) {
      akhu.a((AppActivity)localObject1, 3, new adok(this, (AppActivity)localObject1));
    }
    do
    {
      do
      {
        do
        {
          long l;
          do
          {
            return;
            super.onClick(paramView);
            localObject1 = (ados)aciy.a(paramView);
            jdField_a_of_type_AndroidGraphicsRect = a(paramView, (MessageForShortVideo)((ados)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
            aciy.n = true;
            l = System.currentTimeMillis();
            if ((l - jdField_c_of_type_Long >= 1000L) || (l <= jdField_c_of_type_Long)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("ShortVideoItemBuilder", 2, "click too offen,please try again later ");
          return;
          jdField_c_of_type_Long = l;
          if ((paramView.getId() == 2131298552) || (paramView.getId() == 2131298594))
          {
            a((ados)localObject1, false);
            return;
          }
        } while (paramView.getId() != 2131298571);
        paramView = new StringBuilder();
      } while (((ados)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((ados)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((ados)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if ((!(localObject2 instanceof ShortVideoUploadProcessor)) || (!((ShortVideoUploadProcessor)localObject2).g)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoItemBuilder", 2, "CompressTask pauseOperator!");
    return;
    Object localObject2 = awfy.a().a(((ados)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    if (localObject2 != null)
    {
      ((awfz)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.isPause = true;
      boolean bool = ((awfz)localObject2).cancel(true);
      paramView.append("\n ShortVideoItemBuilder task cancel:").append(bool);
      paramView.append("\n md5 info:").append(((MessageForShortVideo)((ados)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).md5);
      if ((bool) && (((MessageForShortVideo)((ados)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).md5 == null))
      {
        bool = ((awfz)localObject2).a();
        paramView.append("\n media codec cancel:").append(bool);
        if (!bool) {
          break label471;
        }
        paramView.append("\n ffmpeg process cancel!");
      }
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((ados)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((ados)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
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
      label471:
      paramView.append("\n ffmpeg process cancel exception!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adoi
 * JD-Core Version:    0.7.0.1
 */