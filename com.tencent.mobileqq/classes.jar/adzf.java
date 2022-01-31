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
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.videoplatform.CropBubbleVideoView;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class adzf
  extends BaseBubbleBuilder
  implements acum, acwb, axds, axfm
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect;
  private static CopyOnWriteArraySet<CropBubbleVideoView> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  public static AtomicLong a;
  private static long c;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adzh(this);
  private asuw jdField_a_of_type_Asuw;
  private bbgu jdField_a_of_type_Bbgu;
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
  
  public adzf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = 0;
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if (this.jdField_a_of_type_Asuw == null) {
      this.jdField_a_of_type_Asuw = ((asuw)paramQQAppInterface.getManager(324));
    }
  }
  
  private adzp a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int i = actj.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (i <= -1) {
        break label215;
      }
      Object localObject = actj.a(this.jdField_a_of_type_ComTencentWidgetListView, i);
      if (localObject != null)
      {
        localObject = actj.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof adzp))) {
          return (adzp)localObject;
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
  
  private adzp a(MessageForShortVideo paramMessageForShortVideo)
  {
    adzp localadzp = a(paramMessageForShortVideo.uniseq);
    if ((localadzp == null) && (QLog.isColorLevel())) {
      QLog.d("ShortVideoItemBuilder", 2, "holder is null, seq = " + paramMessageForShortVideo.uniseq);
    }
    return localadzp;
  }
  
  private Rect a(View paramView, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramView == null) || (paramMessageForShortVideo == null)) {
      return null;
    }
    paramView = paramView.findViewById(2131362237);
    if ((paramView instanceof CropBubbleVideoView))
    {
      paramView = (CropBubbleVideoView)paramView;
      Rect localRect = xpu.a(paramView);
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
    return new anoz(Color.rgb(214, 214, 214), paramInt1, paramInt2);
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Drawable localDrawable = null;
    if (bbdx.b(paramString))
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
  
  private void a(adzp paramadzp, int paramInt)
  {
    paramadzp.c.setVisibility(0);
    paramadzp.c.setText(paramInt);
    paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
    paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setImageResource(2130848699);
    paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(3);
  }
  
  private void a(adzp paramadzp, View paramView, ChatMessage paramChatMessage)
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
        if ((axdy.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.msgTailType)) && (paramChatMessage.istroop == 1))
        {
          if (paramadzp.e == null)
          {
            paramadzp.e = new TextView(this.jdField_a_of_type_AndroidContentContext);
            paramadzp.e.setBackgroundResource(2130842092);
            paramadzp.e.setTextSize(1, 12.0F);
            paramadzp.e.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167134));
            paramadzp.e.setText(axdy.b(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.msgTailType));
            paramadzp.e.setSingleLine();
            paramadzp.e.setGravity(16);
            paramadzp.e.setPadding(baxn.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, baxn.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0);
            paramadzp.e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
            paramChatMessage.addRule(3, 2131364109);
            paramChatMessage.addRule(5, 2131364109);
            if ((paramView instanceof ViewGroup)) {
              ((ViewGroup)paramView).addView(paramadzp.e, paramChatMessage);
            }
          }
          paramView = (RelativeLayout.LayoutParams)paramadzp.e.getLayoutParams();
          if (localMessageForShortVideo.isSend()) {}
          for (paramView.leftMargin = BaseChatItemLayout.j;; paramView.leftMargin = BaseChatItemLayout.i)
          {
            paramadzp.e.setTag(localMessageForShortVideo);
            paramadzp.e.setVisibility(0);
            return;
          }
        }
      } while (paramadzp.e == null);
      paramadzp.e.setVisibility(8);
      return;
    }
  }
  
  private void a(adzp paramadzp, MessageForShortVideo paramMessageForShortVideo, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, msg.uniseq = " + paramMessageForShortVideo.uniseq);
    }
    paramString = ShortVideoUtils.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, url = " + paramString);
    }
    if ((QLog.isColorLevel()) && (paramadzp.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d.getURL()=" + paramadzp.jdField_a_of_type_ComTencentImageURLDrawable.getURL());
    }
    paramadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    if ((paramadzp.jdField_a_of_type_ComTencentImageURLDrawable != null) && (paramadzp.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d is reuse !!!");
      }
      if (paramBoolean)
      {
        paramadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setCoverDrawable(paramadzp.jdField_a_of_type_ComTencentImageURLDrawable);
        return;
      }
      paramadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(paramadzp.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    Drawable localDrawable = a(paramInt1, paramInt2);
    paramString = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localDrawable, localDrawable);
    paramadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    paramadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(paramString);
    paramadzp.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
  }
  
  private void a(adzp paramadzp, boolean paramBoolean)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    int i = localMessageForShortVideo.videoFileStatus;
    long l = 0L;
    if (paramadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView != null) {
      l = paramadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a();
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
      if (!bbdx.b((String)localObject))
      {
        localStringBuilder.append(" videoPathExists:false ");
        if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9))
        {
          localStringBuilder.append(" fileType:video, =" + ShortVideoUtils.a(localMessageForShortVideo.fileType));
          if (i == 2005)
          {
            b(paramadzp);
            bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719596, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
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
        b(paramadzp);
        bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719594, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        localStringBuilder.append(" result: toast file_unsafe ");
      }
      else if (i == 5002)
      {
        a(paramadzp, 2131718790);
        bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719595, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        localStringBuilder.append(" result: toast file_expired ");
      }
      else
      {
        b(paramadzp);
        a(localMessageForShortVideo, l, paramBoolean);
        localStringBuilder.append(" status:other, result: download ");
        continue;
        if (i == 5002)
        {
          a(paramadzp, 2131718790);
          bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719595, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          localStringBuilder.append("fileType:not video,videoPathExits:false, result:toast file_expired ");
        }
        else
        {
          b(paramadzp);
          a(localMessageForShortVideo, l, paramBoolean);
          localStringBuilder.append("fileType:not video,videoPathExits:false, result: download");
          continue;
          b(paramadzp);
          a(localMessageForShortVideo, l, paramBoolean);
          localStringBuilder.append("videoPathExists:true, result:play ");
          continue;
          localStringBuilder.append(" sendFromLocal:true ");
          if (localMessageForShortVideo.isMultiMsg) {
            localMessageForShortVideo.extraflag = 32772;
          }
          if (bbdx.b(localMessageForShortVideo.videoFileName))
          {
            localStringBuilder.append(" localUploadPath Exists:true ");
            if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9))
            {
              localStringBuilder.append(" fileType:video ");
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
              if (localObject != null)
              {
                if ((ShortVideoUploadProcessor.class.isInstance(localObject)) || (ayuw.class.isInstance(localObject)))
                {
                  if (i == 1005)
                  {
                    b(paramadzp);
                    paramadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                    localStringBuilder.append(" status:send_error, result:show send error ");
                  }
                  else if ((i == 1002) || (i == 1001))
                  {
                    a(localMessageForShortVideo, l, paramBoolean);
                    localStringBuilder.append(" status:process or start, result:pauseSending ");
                  }
                  else
                  {
                    b(paramadzp);
                    a(localMessageForShortVideo, l, paramBoolean);
                    localStringBuilder.append(" status:other, result:play ");
                  }
                }
                else if (ayut.class.isInstance(localObject)) {
                  localStringBuilder.append(" processor:not up of forward, result: none");
                }
              }
              else
              {
                b(paramadzp);
                a(localMessageForShortVideo, l, paramBoolean);
                localStringBuilder.append(" processor:null, result:play ");
              }
            }
            else
            {
              b(paramadzp);
              a(localMessageForShortVideo, l, paramBoolean);
              localStringBuilder.append(" fileType:not video, result: play ");
            }
          }
          else
          {
            localStringBuilder.append(" localUploadPath Exists:false ");
            if (!bbdx.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))
            {
              localStringBuilder.append(" downloadPath Exists:false ");
              if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9))
              {
                localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
                if (localObject != null)
                {
                  boolean bool;
                  if (ayut.class.isInstance(localObject))
                  {
                    bool = ((ayut)localObject).d();
                    localStringBuilder.append(" processor:download, pause:" + bool);
                    if (bool)
                    {
                      b(paramadzp);
                      a(localMessageForShortVideo, l, paramBoolean);
                      localStringBuilder.append(" pause:true, result:download ");
                    }
                    else if (i == 2005)
                    {
                      b(paramadzp);
                      bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719596, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                      localStringBuilder.append(" status:recv_error, result:toast recv_error ");
                    }
                    else if ((i == 2002) || (i == 2000) || (i == 2008) || (i == 2001))
                    {
                      b(paramadzp);
                    }
                    else if (i == 5001)
                    {
                      b(paramadzp);
                      bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719594, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                      localStringBuilder.append(" status:file_unsafe, result:toast unsafe ");
                    }
                    else if (i == 5002)
                    {
                      a(paramadzp, 2131718790);
                      bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719595, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                      localStringBuilder.append(" status:file_expired, result:toast expired ");
                    }
                    else
                    {
                      b(paramadzp);
                      a(localMessageForShortVideo, l, paramBoolean);
                      localStringBuilder.append(" status:other, result:download ");
                    }
                  }
                  else if (ShortVideoUploadProcessor.class.isInstance(localObject))
                  {
                    b(paramadzp);
                    paramadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                    bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719601, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                    localStringBuilder.append(" processor:upload, result:show upload error and show toast");
                  }
                  else if (ayuw.class.isInstance(localObject))
                  {
                    bool = ((ayuw)localObject).d();
                    localStringBuilder.append(" processor:forward, pause:" + bool);
                    if (bool)
                    {
                      a(paramadzp, 10, false);
                      b(localMessageForShortVideo, paramadzp);
                      localStringBuilder.append(" pause:true, result:reforward ");
                    }
                    else if (i == 5001)
                    {
                      b(paramadzp);
                      paramadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                      bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719569, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                      localStringBuilder.append(" status:unsafe, result:toast unsafe ");
                    }
                    else if (i == 5002)
                    {
                      a(paramadzp, 2131718790);
                      paramadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                      bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719570, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                      localStringBuilder.append(" status:expired, result:toast expired ");
                    }
                    else if (i == 1005)
                    {
                      b(paramadzp);
                      paramadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                      localStringBuilder.append(" status:send_error, result:show send_error ");
                    }
                    else if ((i == 1002) || (i == 1001))
                    {
                      a(localMessageForShortVideo, 0L, paramBoolean);
                    }
                    else
                    {
                      b(paramadzp);
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
                  b(paramadzp);
                  localStringBuilder.append(" processor:null, result:download ");
                  a(localMessageForShortVideo, 0L, paramBoolean);
                }
              }
              else
              {
                b(paramadzp);
                a(localMessageForShortVideo, l, paramBoolean);
                localStringBuilder.append(" fileType:not video, result:download ");
              }
            }
            else
            {
              b(paramadzp);
              a(localMessageForShortVideo, l, paramBoolean);
              localStringBuilder.append(" downloadPath Exists:true，result:play ");
            }
          }
        }
      }
    }
  }
  
  private void a(adzp paramadzp, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramadzp != null) && (paramadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null))
    {
      if (paramBoolean) {
        b(paramadzp, false, null);
      }
      paramadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private void a(adzp paramadzp, boolean paramBoolean, MessageForShortVideo paramMessageForShortVideo, String paramString1, String[] paramArrayOfString, String paramString2, int paramInt1, int paramInt2)
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
      paramadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      localObject = new bbwg();
      ((bbwg)localObject).jdField_a_of_type_Int = 101;
      ((bbwg)localObject).jdField_c_of_type_Boolean = true;
      ((bbwg)localObject).jdField_a_of_type_Bbwl = new adzi(this);
      ((bbwg)localObject).jdField_b_of_type_Boolean = paramBoolean;
      ((bbwg)localObject).jdField_a_of_type_Boolean = true;
      ((bbwg)localObject).jdField_a_of_type_JavaLangString = paramString1;
      ((bbwg)localObject).jdField_b_of_type_JavaLangString = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
      ((bbwg)localObject).jdField_c_of_type_JavaLangString = (paramMessageForShortVideo.md5 + paramMessageForShortVideo.uniseq);
      ((bbwg)localObject).jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
      ((bbwg)localObject).d = paramMessageForShortVideo.videoFileSize;
      if (paramMessageForShortVideo.videoFileTime > 8) {
        break label303;
      }
      i = 1;
      label216:
      if (i == 0)
      {
        ((bbwg)localObject).jdField_a_of_type_Long = (paramMessageForShortVideo.videoFileTime * 1000);
        ((bbwg)localObject).jdField_b_of_type_Long = 8000L;
      }
      paramadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setVideoParam((bbwg)localObject);
      paramMessageForShortVideo = a(paramInt1, paramInt2);
      if (!TextUtils.isEmpty(paramString2)) {
        break label309;
      }
      paramadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setCoverDrawable(paramMessageForShortVideo);
    }
    for (;;)
    {
      paramadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a();
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView);
      return;
      localObject = "null";
      break;
      label303:
      i = 0;
      break label216;
      label309:
      paramMessageForShortVideo = URLDrawable.getDrawable(ShortVideoUtils.a(paramString2), paramInt1, paramInt2, paramMessageForShortVideo, paramMessageForShortVideo);
      paramadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setCoverDrawable(paramMessageForShortVideo);
      paramadzp.jdField_a_of_type_ComTencentImageURLDrawable = paramMessageForShortVideo;
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!bbbt.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      bbbt.a().a(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForShortVideo.frienduin, 1, 1, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Bundle paramBundle, MessageForReplyText paramMessageForReplyText)
  {
    if ((qvk.a(paramContext)) || (paramQQAppInterface.c()))
    {
      bcql.a(paramContext, 0, 2131719587, 0).b(paramContext.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    if (!paramMessageForShortVideo.isSend()) {
      new avwu(BaseApplication.getContext()).a(paramQQAppInterface, 2002, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
    }
    boolean bool = bhvy.d(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startPlayerActivity() msg.videoAttr=" + paramMessageForShortVideo.videoAttr + ", msg.istroop=" + paramMessageForShortVideo.istroop + ", isSupportMultiVideoSwitch=" + Boolean.valueOf(bool));
    }
    bool = bhvx.a(paramQQAppInterface);
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
      paramBundle.putString("extra.GROUP_CODE", paramSessionInfo.jdField_b_of_type_JavaLangString);
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
        bgky.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), aehw.a(paramMessageForShortVideo), -1, i);
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
        localObject = (asuw)paramQQAppInterface.getManager(324);
        bool = ((asuw)localObject).a(paramMessageForShortVideo);
        paramBundle.putBoolean("extra.IS_SAVING_FILE", bool);
        if (bool)
        {
          localObject = ((asuw)localObject).a(((asuw)localObject).a(paramMessageForShortVideo));
          if ((localObject != null) && (((asus)localObject).d == 1)) {
            paramBundle.putInt("extra.SAVE_FILE_PROGRESS", ((asus)localObject).jdField_c_of_type_Int);
          }
        }
        if ((paramMessageForShortVideo.istroop != 0) || (!bbbr.b(paramMessageForShortVideo.senderuin)) || (TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type")))) {
          continue;
        }
        paramBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
        bgky.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), aehw.a(paramMessageForShortVideo), 13007, i);
        ((awap)paramQQAppInterface.getManager(326)).a();
        if (!paramMessageForShortVideo.isSend()) {
          new avwu(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
        }
        ausf.b(paramQQAppInterface, paramMessageForShortVideo);
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
    localBundle.putBoolean(bgky.jdField_b_of_type_JavaLangString, paramBoolean2);
    a(paramMessageForShortVideo, paramLong, paramContext, paramQQAppInterface, paramSessionInfo, localBundle, paramMessageForReplyText);
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "handleVideoCompressSucceed, seq = " + paramMessageForShortVideo.uniseq);
    }
    axfj localaxfj = axfi.a().a(paramMessageForShortVideo.uniseq);
    if ((paramQQAppInterface != null) && (localaxfj != null)) {
      if (localaxfj.a() >= 104345600L)
      {
        paramMessageForShortVideo.videoFileStatus = 1005;
        paramMessageForShortVideo.serial();
        paramQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
        if (paramContext != null)
        {
          bcql.a(paramContext, paramContext.getResources().getString(2131719567), 0).b(paramContext.getResources().getDimensionPixelSize(2131298865));
          paramContext = ((FragmentActivity)paramContext).getChatFragment();
          if (paramContext != null)
          {
            paramContext = paramContext.a();
            if (paramContext != null) {
              paramContext.b(false, false);
            }
          }
        }
        awap.a(paramQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
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
      paramContext = axdq.a(0, 0);
      paramMessageForShortVideo = axdq.a(paramMessageForShortVideo, paramContext);
      if (paramMessageForShortVideo != null)
      {
        paramMessageForShortVideo.i = localaxfj.a();
        paramMessageForShortVideo.jdField_a_of_type_Boolean = false;
        paramContext.a(paramMessageForShortVideo);
      }
      axdq.a(paramContext, paramQQAppInterface);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(-1L);
      return;
    }
    QLog.i("ShortVideoItemBuilder", 2, "CompressTask onPostExecute QQAppInterface is null...");
  }
  
  private boolean a(long paramLong)
  {
    return ((awap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong);
  }
  
  private boolean a(adzp paramadzp)
  {
    if (this.jdField_a_of_type_Asuw != null)
    {
      paramadzp = this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_Asuw.a(paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage));
      return (paramadzp != null) && (paramadzp.d == 1) && (!paramadzp.jdField_a_of_type_Boolean);
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
      if (axfi.a().a(paramMessageForShortVideo.uniseq) == null)
      {
        paramMessageForShortVideo = ShortVideoUtils.c(paramMessageForShortVideo.videoFileName, "mp4");
        if (!TextUtils.isEmpty(paramMessageForShortVideo)) {
          bbdx.d(paramMessageForShortVideo);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static Drawable b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    anoz localanoz = new anoz(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localanoz, localanoz);
        localURLDrawable.setTag(bavw.b(0, 0, paramInt3));
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
    return localanoz;
  }
  
  private void b(adzp paramadzp, View paramView, ChatMessage paramChatMessage)
  {
    if (c(paramadzp))
    {
      if (paramadzp.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        paramadzp.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramadzp.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838105);
        paramadzp.jdField_a_of_type_AndroidWidgetImageView.setId(2131364128);
        paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
        paramChatMessage.bottomMargin = actj.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramChatMessage.addRule(8, 2131364109);
        paramChatMessage.addRule(0, 2131364109);
        paramChatMessage.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramadzp.jdField_a_of_type_AndroidWidgetImageView, paramChatMessage);
        }
      }
      b(paramadzp, true, this);
      return;
    }
    b(paramadzp, false, null);
  }
  
  private void b(adzp paramadzp, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      if (paramadzp.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        paramadzp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramadzp.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      }
    }
    while (paramadzp.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    paramadzp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramadzp.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
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
      awap.a(paramQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    }
    if (paramContext != null) {}
  }
  
  private boolean b(adzp paramadzp)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Asuw != null)
    {
      paramadzp = this.jdField_a_of_type_Asuw.a(this.jdField_a_of_type_Asuw.a(paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage));
      if ((paramadzp != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      bool1 = bool2;
      if (paramadzp != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean b(MessageForShortVideo paramMessageForShortVideo)
  {
    return false;
  }
  
  private void c(adzp paramadzp)
  {
    if (c(paramadzp))
    {
      if (paramadzp.jdField_a_of_type_AndroidWidgetImageView != null) {
        break label20;
      }
      h();
    }
    label20:
    while (paramadzp.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      return;
    }
    b(paramadzp, true, this);
  }
  
  private void c(MessageForShortVideo paramMessageForShortVideo, adzp paramadzp)
  {
    int k = 1;
    asus localasus;
    int i;
    if ((this.jdField_a_of_type_Asuw != null) && (paramMessageForShortVideo != null) && (paramadzp != null))
    {
      paramMessageForShortVideo = this.jdField_a_of_type_Asuw.a(paramMessageForShortVideo);
      localasus = this.jdField_a_of_type_Asuw.a(paramMessageForShortVideo);
      if ((localasus != null) && (localasus.d == 1))
      {
        if (localasus.jdField_c_of_type_Int >= 0) {
          break label188;
        }
        i = 0;
        j = k;
        if (paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getVisibility() != 8) {
          if ((paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getVisibility() != 0) || (paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.d != 2)) {
            break label213;
          }
        }
      }
    }
    label188:
    label213:
    for (int j = k;; j = 0)
    {
      if ((i < 100) && (j != 0) && (!localasus.jdField_a_of_type_Boolean) && (localasus.jdField_a_of_type_Asur != null))
      {
        localasus.jdField_a_of_type_Asur.a(new adzk(this, paramMessageForShortVideo, paramadzp));
        this.jdField_a_of_type_Asuw.a(paramMessageForShortVideo, localasus);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "dealVideoSaveUI showSaveProgress");
        }
        a(paramadzp, i, false);
        paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      }
      return;
      if (localasus.jdField_c_of_type_Int > 100)
      {
        i = 100;
        break;
      }
      i = localasus.jdField_c_of_type_Int;
      break;
    }
  }
  
  private boolean c(adzp paramadzp)
  {
    boolean bool2 = true;
    if ((paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {
        return false;
      }
      int i;
      int j;
      if ((localMessageForShortVideo.videoFileStatus == 998) || (localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 1001))
      {
        i = 1;
        if ((localMessageForShortVideo.isMultiMsg) || (localMessageForShortVideo.uiOperatorFlag == 2) || (localMessageForShortVideo.busiType != 0) || (!localMessageForShortVideo.isSendFromLocal()) || (paramadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a())) {
          break label211;
        }
        j = 1;
        label109:
        if (QLog.isColorLevel())
        {
          paramadzp = new StringBuilder().append("needShowPauseIcon seq:").append(localMessageForShortVideo.uniseq).append(", videostatus:").append(localMessageForShortVideo.videoFileStatus).append(", iconshow:");
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
    return axuk.a().a(this.jdField_a_of_type_AndroidContentContext, 1, paramMessageForShortVideo.istroop);
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
          if (bbdx.b(str))
          {
            bool1 = bool2;
            if (bbdx.b(paramMessageForShortVideo)) {
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
          localCropBubbleVideoView.c();
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
          localCropBubbleVideoView.b();
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
          localCropBubbleVideoView.a(false);
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
  
  public acui a(View paramView)
  {
    if (paramView != null)
    {
      paramView = (adzp)actj.a(paramView);
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView;
      }
    }
    return null;
  }
  
  public acuj a()
  {
    return new adzp(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxj paramacxj)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxj);
    if ((paramChatMessage instanceof MessageForShortVideo)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramChatMessage);
    }
    a(paramChatMessage, paramView, this);
    a((adzp)paramView.getTag(), paramView, paramChatMessage);
    b((adzp)paramView.getTag(), paramView, paramChatMessage);
    if (e) {}
    try
    {
      paramChatMessage = (adzp)paramView.getTag();
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append(paramChatMessage.jdField_a_of_type_AndroidWidgetTextView.getText());
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime);
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append("秒按钮");
      paramView.setContentDescription(paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.toString());
      return paramView;
    }
    catch (Exception paramChatMessage) {}
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView, message.uniseq = " + paramChatMessage.uniseq);
    }
    adzp localadzp = (adzp)paramacuj;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramBaseChatItemLayout = (MessageForShortVideo)paramChatMessage;
    boolean bool1 = paramBaseChatItemLayout.isSend();
    paramacuj = paramView;
    int i;
    if (paramView == null)
    {
      paramacuj = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new CropBubbleVideoView(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout.uniseq, null, bool1);
      paramView.setId(2131362237);
      paramView.setVisibility(0);
      paramView.setContentDescription(ajya.a(2131714037));
      paramacuj.addView(paramView);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramView);
      VideoProgressView localVideoProgressView = new VideoProgressView(this.jdField_a_of_type_AndroidContentContext);
      localVideoProgressView.setId(2131364151);
      paramacuj.addView(localVideoProgressView);
      ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 0);
      i = actj.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      Object localObject2 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramacuj.addView(localProgressBar, (ViewGroup.LayoutParams)localObject2);
      Object localObject3 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject3).setOrientation(1);
      ((LinearLayout)localObject3).setGravity(17);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramacuj.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      Object localObject4 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject4).topMargin = actj.a(70.0F, (Resources)localObject1);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setId(2131364149);
      ((TextView)localObject2).setVisibility(4);
      ((LinearLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      localObject3 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject3).setBackgroundResource(2130838791);
      localObject4 = new RelativeLayout.LayoutParams(-1, actj.a(55.0F, (Resources)localObject1));
      ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131362237);
      ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131362237);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131362237);
      paramacuj.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setTextSize(1, 12.0F);
      ((TextView)localObject4).setTextColor(-1);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).leftMargin = actj.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject5).bottomMargin = actj.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject5).addRule(9);
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout)localObject3).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject5).setTextSize(1, 12.0F);
      ((TextView)localObject5).setTextColor(-1);
      Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).rightMargin = actj.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject6).bottomMargin = actj.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject6).addRule(11);
      ((RelativeLayout.LayoutParams)localObject6).addRule(12);
      ((RelativeLayout)localObject3).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      localObject6 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject6).setTextSize(1, 14.0F);
      ((TextView)localObject6).setTextColor(-1);
      ((TextView)localObject6).setGravity(17);
      ((TextView)localObject6).setText(2131719588);
      ((TextView)localObject6).setShadowLayer(3.0F, 1.0F, 1.0F, -16777216);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = actj.a(14.0F, (Resources)localObject1);
      localLayoutParams.addRule(14);
      paramacuj.addView((View)localObject6, localLayoutParams);
      paramacuj.setOnClickListener(this);
      super.a(paramacuj, paramacxj);
      localadzp.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
      localadzp.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
      localadzp.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      localadzp.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject5);
      localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView = localVideoProgressView;
      localadzp.c = ((TextView)localObject2);
      localadzp.d = ((TextView)localObject6);
      localadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView = paramView;
    }
    localadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setTag(Long.valueOf(paramBaseChatItemLayout.uniseq));
    bbbt.a().a(Long.valueOf(paramBaseChatItemLayout.uniseq), paramBaseChatItemLayout);
    if (localadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.jdField_a_of_type_Boolean != bool1)
    {
      localadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.jdField_a_of_type_Boolean = bool1;
      localadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.invalidate();
    }
    localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnClickListener(this);
    localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnTouchListener(paramacxj);
    localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnLongClickListener(paramacxj);
    localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setRadius(15.0F, true);
    localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setShowCorner(true);
    localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setSharpCornerCor(BubbleImageView.a);
    localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setCornerDirection(bool1);
    localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    ausf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout);
    paramView = (RelativeLayout.LayoutParams)localadzp.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    label1018:
    int j;
    int k;
    if (bool1)
    {
      paramView.leftMargin = 0;
      paramView.rightMargin = actj.a(localadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(), (Resources)localObject1);
      paramView = (RelativeLayout.LayoutParams)localadzp.d.getLayoutParams();
      if (!bool1) {
        break label1409;
      }
      paramView.rightMargin = (actj.a(localadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(), (Resources)localObject1) / 2);
      localadzp.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramBaseChatItemLayout.videoFileTime * 1000));
      localadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView = ShortVideoUtils.a(paramBaseChatItemLayout.thumbMD5, "jpg");
      paramacxj = ShortVideoUtils.a(paramBaseChatItemLayout.thumbWidth, paramBaseChatItemLayout.thumbHeight);
      j = paramacxj[0];
      k = paramacxj[1];
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView, msg.uniseq = " + paramBaseChatItemLayout.uniseq + " msg.thumbWidth = " + paramBaseChatItemLayout.thumbWidth + ", msg.thumbHeight = " + paramBaseChatItemLayout.thumbHeight + ", adjustWidth = " + j + ", adjustHeight = " + k);
      }
      paramacxj = localadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.getLayoutParams();
      if (paramacxj != null) {
        break label1431;
      }
      paramacxj = new RelativeLayout.LayoutParams(j, k);
      localadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setLayoutParams(paramacxj);
      label1211:
      paramacxj = localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getLayoutParams();
      if (paramacxj != null) {
        break label1478;
      }
      paramacxj = new LinearLayout.LayoutParams(j, k);
      localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setLayoutParams(paramacxj);
      label1249:
      if (axdq.jdField_a_of_type_Boolean)
      {
        axdq.jdField_a_of_type_Long = System.currentTimeMillis();
        axdq.jdField_a_of_type_Boolean = false;
      }
      paramacxj = a(j, k);
      b(localadzp);
      c(paramBaseChatItemLayout, localadzp);
      if ((paramBaseChatItemLayout.md5 != null) || (paramBaseChatItemLayout.CheckIsHotVideo()) || (paramBaseChatItemLayout.isCancelStatus())) {
        break label1683;
      }
      if (paramBaseChatItemLayout.isSendFromLocal())
      {
        localadzp.jdField_a_of_type_AndroidWidgetTextView.setText("");
        if (bbdx.b(paramView))
        {
          a(localadzp, paramBaseChatItemLayout, paramView, j, k, false);
          if (paramBaseChatItemLayout.videoFileStatus != 1005) {
            break label1525;
          }
          localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(2);
          localadzp.c.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      label1382:
      return paramacuj;
      paramView.leftMargin = actj.a(localadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(), (Resources)localObject1);
      paramView.rightMargin = 0;
      break;
      label1409:
      paramView.leftMargin = (actj.a(localadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(), (Resources)localObject1) / 2);
      break label1018;
      label1431:
      if ((paramacxj.width == j) && (paramacxj.height == k)) {
        break label1211;
      }
      paramacxj.width = j;
      paramacxj.height = k;
      localadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setLayoutParams(paramacxj);
      break label1211;
      label1478:
      if ((paramacxj.width == j) && (paramacxj.height == k)) {
        break label1249;
      }
      paramacxj.width = j;
      paramacxj.height = k;
      localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setLayoutParams(paramacxj);
      break label1249;
      label1525:
      localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      localadzp.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      localadzp.d.setVisibility(8);
      localadzp.c.setVisibility(8);
      localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      if ((paramBaseChatItemLayout.videoFileStatus != 998) || (a(paramBaseChatItemLayout)))
      {
        paramChatMessage = new axfj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, this);
        axfi.a().a(paramBaseChatItemLayout.uniseq, paramChatMessage);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView(): msg.md5 == null, start compress task, id:" + paramBaseChatItemLayout.uniseq);
        }
      }
      paramChatMessage = axfi.a().a(paramBaseChatItemLayout.uniseq);
      if (paramChatMessage == null) {
        continue;
      }
      paramChatMessage.a(this);
      return paramacuj;
      label1683:
      localadzp.c.setVisibility(8);
      localadzp.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout.videoFileSize));
      localadzp.d.setVisibility(8);
      if (bbdx.b(paramView))
      {
        if ((paramBaseChatItemLayout.videoFileStatus == 998) || (paramBaseChatItemLayout.videoFileStatus == 1001) || (paramBaseChatItemLayout.videoFileStatus == 1002) || (paramBaseChatItemLayout.videoFileStatus == 1004)) {}
        for (i = 1;; i = 0)
        {
          if ((c(paramBaseChatItemLayout)) && ((!paramBaseChatItemLayout.isSendFromLocal()) || (i == 0)) && (!b(localadzp)) && (!b(paramBaseChatItemLayout)) && (!a(paramBaseChatItemLayout.uniseq))) {
            break label2166;
          }
          a(localadzp, paramBaseChatItemLayout, paramView, j, k, false);
          localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
          label1853:
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
            return paramacuj;
          case 1001: 
            if (paramChatMessage != null) {
              break label3056;
            }
            localadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            b(localadzp);
            if (!QLog.isColorLevel()) {
              break label1382;
            }
            QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_START, 上传开始被杀进程然后恢复, uniseq:" + paramBaseChatItemLayout.uniseq);
            return paramacuj;
          }
        }
        label2166:
        paramacxj = ShortVideoUtils.a(paramBaseChatItemLayout, "mp4");
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView(): videoPath = " + paramacxj);
        }
        localObject1 = new File(paramacxj);
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
            if ((!bbfj.h(this.jdField_a_of_type_AndroidContentContext)) || (paramBaseChatItemLayout.videoFileStatus == 5002)) {
              break label2454;
            }
            paramChatMessage = axdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, 2);
            if (paramChatMessage != null) {
              axdq.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
          }
        }
        for (;;)
        {
          a(localadzp, paramBaseChatItemLayout, paramView, j, k, true);
          break;
          l1 = qtx.a(8, paramBaseChatItemLayout.videoFileTime, paramBaseChatItemLayout.videoFileSize);
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
          localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
        }
        label2466:
        a(localadzp, true, paramBaseChatItemLayout, paramacxj, null, paramView, j, k);
        if (paramBaseChatItemLayout.videoFileTime <= 8)
        {
          i = 1;
          label2496:
          a(localadzp);
          if (i == 0) {
            localadzp.d.setVisibility(0);
          }
          if ((paramBaseChatItemLayout.CheckIsHotVideo()) && (!bbbt.a().a(paramBaseChatItemLayout, "0X8007EDB")))
          {
            bbbt.a().a(paramBaseChatItemLayout, "0X8007EDB");
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
          }
          if (bbbt.a().a(paramBaseChatItemLayout, "0X80077D9")) {
            continue;
          }
          i = npu.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          paramView = new JSONObject();
        }
      }
      try
      {
        paramView.put("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramView.put("memNum", i);
        paramView.put("msg_uniseq", paramChatMessage.uniseq);
        nol.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", npu.a(paramBaseChatItemLayout.getMd5(), null, null, null, paramView), false);
        bbbt.a().a(paramBaseChatItemLayout, "0X80077D9");
        return paramacuj;
        i = 0;
        break label2496;
        if (((paramBaseChatItemLayout.fileType == 7) || (paramBaseChatItemLayout.fileType == 18) || (paramBaseChatItemLayout.fileType == 16)) && (paramBaseChatItemLayout.videoFileStatus == 5002))
        {
          localadzp.d.setVisibility(8);
          localadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(paramBaseChatItemLayout.uniseq);
          localadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(paramacxj);
          a(localadzp, 2131718790);
          if (!QLog.isColorLevel()) {
            break label1853;
          }
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not download pic : 缩略图不存在，而且文件已经过期，不下载, , uniseq:" + paramBaseChatItemLayout.uniseq);
          break label1853;
        }
        if ((paramBaseChatItemLayout.extraflag == 32768) || (b(localadzp))) {
          break label1853;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not SendFromLocal : 缩略图不存在，开始下载缩略图, , uniseq:" + paramBaseChatItemLayout.uniseq);
        }
        localadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(paramBaseChatItemLayout.uniseq);
        localadzp.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(paramacxj);
        paramChatMessage = axdq.a(2, this.jdField_c_of_type_Int);
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
          axdq.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
          if (paramBaseChatItemLayout.istroop == 3000) {
            paramView.e = 1006;
          } else if (paramBaseChatItemLayout.istroop == 1) {
            paramView.e = 1004;
          }
        }
        label3056:
        a(localadzp, ShortVideoUtils.a(paramBaseChatItemLayout.videoFileProgress, 10), false);
        return paramacuj;
        localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
        localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(localadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + localadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        b(localadzp);
        a(localadzp, true, this);
        return paramacuj;
        if (paramChatMessage == null)
        {
          localadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          b(localadzp);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_PROCESS, 上传过程中被杀进程然后恢复, uniseq:" + paramBaseChatItemLayout.uniseq);
          return paramacuj;
        }
        if (((awap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).b(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq))
        {
          localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(10, paramBaseChatItemLayout.frienduin + paramBaseChatItemLayout.uniseq);
          localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
          return paramacuj;
        }
        i = paramBaseChatItemLayout.videoFileProgress;
        if ((paramChatMessage instanceof ShortVideoUploadProcessor))
        {
          paramChatMessage = (ShortVideoUploadProcessor)paramChatMessage;
          if (paramChatMessage.a() != 0L)
          {
            i = (int)(100L * paramChatMessage.b() / paramChatMessage.a());
            a(localadzp, ShortVideoUtils.a(i, 10), false);
            return paramacuj;
            b(localadzp);
            return paramacuj;
            b(localadzp);
            return paramacuj;
            b(localadzp);
            return paramacuj;
            b(localadzp);
            return paramacuj;
            a(localadzp, 2131718790);
            return paramacuj;
          }
        }
      }
      catch (Exception paramChatMessage)
      {
        for (;;) {}
      }
    }
  }
  
  public bbmf a(bbmf parambbmf, ChatMessage paramChatMessage, acva paramacva)
  {
    boolean bool3 = false;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramacva = (adzp)paramacva;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.a(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForShortVideo.videoFileStatus));
    }
    b(parambbmf, this.jdField_a_of_type_AndroidContentContext);
    int i;
    boolean bool1;
    label221:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramChatMessage = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (bbdx.b(paramChatMessage))
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
        if ((paramacva.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView == null) || (!paramacva.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramacva.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramacva.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
          break label479;
        }
        bool1 = true;
        bool2 = bool3;
        if (paramacva.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
        {
          bool2 = bool3;
          if (paramacva.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
            bool2 = true;
          }
        }
        if ((!bool4) || (bool1) || (bool2)) {
          break label432;
        }
        parambbmf.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692753), 2130838606);
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
      if ((localMessageForShortVideo != null) && (bbdx.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))) {
        parambbmf.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692324), 2130838605);
      }
      this.f = true;
      return parambbmf;
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
    if (bbfh.a(paramChatMessage.issend)) {
      return ajya.a(2131714045);
    }
    return ajya.a(2131714097);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_Bbgu != null) && (this.jdField_a_of_type_Bbgu.isShowing()))
    {
      this.jdField_a_of_type_Bbgu.dismiss();
      this.jdField_a_of_type_Bbgu = null;
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
        if (localCropBubbleVideoView != null)
        {
          long l = localCropBubbleVideoView.a();
          if (l > 0L)
          {
            MessageForShortVideo localMessageForShortVideo = bbbt.a().a(Integer.valueOf(localCropBubbleVideoView.getId()));
            if (localMessageForShortVideo != null) {
              a(localMessageForShortVideo, l);
            }
          }
          localCropBubbleVideoView.a(false);
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
      if (paramInt == 2131364984)
      {
        aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
      }
      if (paramInt == 2131370536)
      {
        super.d(paramChatMessage);
        return;
      }
      if (paramInt == 2131366632)
      {
        b(localMessageForShortVideo);
        if (paramChatMessage.isMultiMsg) {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 6, 0, "6", "", "", "");
        }
      }
      else if (paramInt == 2131365928)
      {
        if (d((MessageForShortVideo)paramChatMessage))
        {
          bgpu.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          bgqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
          bgqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
          if (paramChatMessage.isMultiMsg) {
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 6, 0, "6", "", "", "");
          }
        }
      }
      else
      {
        if (paramInt == 2131370493)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked(): msg_revoke =>" + localMessageForShortVideo.toLogString());
          }
          if (localMessageForShortVideo.md5 == null)
          {
            axfi.a().b(localMessageForShortVideo.uniseq);
            jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(localMessageForShortVideo.uniseq);
            ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(20)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
            awap.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
            return;
          }
          paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
          if ((paramContext == null) || ((!ShortVideoUploadProcessor.class.isInstance(paramContext)) && (!ayuw.class.isInstance(paramContext)))) {
            break label672;
          }
          boolean bool = ((aypb)paramContext).d();
          paramInt = localMessageForShortVideo.videoFileStatus;
          if ((!bool) && (paramInt != 1002) && (paramInt != 1001)) {
            break label672;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
          ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(20)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
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
          if (paramInt == 2131370597)
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
            axqy.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 2, 0, "", "", "", "");
            return;
          }
          super.a(paramInt, paramContext, paramChatMessage);
          return;
        }
      }
    }
  }
  
  public void a(adzp paramadzp)
  {
    if (a(paramadzp)) {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "disProgress...file is saving, so return!");
      }
    }
    do
    {
      return;
      if (!a(paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "disProgress fail...video order sending! " + paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return;
    if (!paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
      return;
    }
    paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimRunnableListener(new adzj(this, paramadzp));
  }
  
  protected void a(adzp paramadzp, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 100)
    {
      paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(paramInt, paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    for (;;)
    {
      paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVideoCompressStatus(false);
      paramadzp.c.setVisibility(8);
      return;
      paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(paramInt, paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (adzp)actj.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      bfpc localbfpc = (bfpc)bfpp.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbfpc.a(2131689995, 5);
      localbfpc.c(2131690596);
      localbfpc.a(new adzo(this, localMessageForShortVideo, paramView, localbfpc));
      localbfpc.show();
      if (localMessageForShortVideo.videoFileStatus == 1004) {
        ShortVideoUtils.c("0X800A374", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(View paramView, ayqo paramayqo, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = (adzp)actj.a(paramView);
        paramView = (MessageForShortVideo)((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject2 = ((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView;
        if (paramView.uniseq != paramayqo.jdField_b_of_type_Long) {
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.e("ShortVideoItemBuilder", 2, "handleMessage getHolder error ! ", paramView);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "handleMessage msg.uniseq:" + paramView.uniseq + ",fileType:" + ShortVideoUtils.a(paramayqo.jdField_b_of_type_Int) + " ===> fileStatus:" + ShortVideoUtils.b(paramayqo.d));
      }
      paramInt2 = 0;
      paramInt1 = 0;
      if ((paramayqo.jdField_b_of_type_Int == 6) || (paramayqo.jdField_b_of_type_Int == 17) || (paramayqo.jdField_b_of_type_Int == 9) || (paramayqo.jdField_b_of_type_Int == 20)) {}
      switch (paramayqo.d)
      {
      default: 
      case 1001: 
        if (paramayqo.jdField_a_of_type_Long != 0L) {
          paramInt1 = (int)(100L * paramayqo.e / paramayqo.jdField_a_of_type_Long);
        }
        a((adzp)localObject1, ShortVideoUtils.a(paramInt1, 10), true);
        ((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        c((adzp)localObject1);
        return;
      case 1003: 
        a((adzp)localObject1, 100, true);
        b((adzp)localObject1);
        b((adzp)localObject1, false, null);
        axfi.a().a(((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1005: 
        b((adzp)localObject1);
        ((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        axfi.a().a(((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1004: 
        ((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + ((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        b((adzp)localObject1);
        a((adzp)localObject1, true, this);
        axfi.a().a(((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1007: 
        b((adzp)localObject1);
        b((adzp)localObject1, false, null);
        axfi.a().a(((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1002: 
        if (!paramView.isSendFromLocal()) {
          continue;
        }
        if (paramayqo.jdField_a_of_type_Long != 0L) {
          paramInt1 = (int)(100L * paramayqo.e / paramayqo.jdField_a_of_type_Long);
        }
        for (;;)
        {
          a((adzp)localObject1, ShortVideoUtils.a(paramInt1, 10), true);
          return;
          paramInt1 = paramInt2;
          if (QLog.isColorLevel())
          {
            QLog.e("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS: fileSize == 0 ");
            paramInt1 = paramInt2;
          }
        }
      case 2001: 
        b((adzp)localObject1);
        ((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        return;
      case 2003: 
        b((adzp)localObject1);
        if (b((adzp)localObject1)) {
          continue;
        }
        paramayqo = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
        if (bbdx.b(paramayqo)) {
          continue;
        }
        localObject1 = axdq.a(2, this.jdField_c_of_type_Int);
        localObject2 = paramView.getDownloadInfo(((axei)localObject1).jdField_b_of_type_Int);
        ((axdt)localObject2).i = paramayqo;
        if ((paramView.istroop == 0) || (paramView.istroop == 1008)) {
          ((axdt)localObject2).e = 1002;
        }
        for (;;)
        {
          ((axei)localObject1).a((axdt)localObject2);
          ((axei)localObject1).a(paramView);
          axdq.a((axei)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
          if (paramView.istroop == 3000) {
            ((axdt)localObject2).e = 1006;
          } else if (paramView.istroop == 1) {
            ((axdt)localObject2).e = 1004;
          }
        }
      case 2005: 
        b((adzp)localObject1);
        if (paramayqo.g == -5100528) {
          continue;
        }
        bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719596, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        return;
      case 5001: 
        a((adzp)localObject1, 2131718789);
        if (paramView.uiOperatorFlag == 2)
        {
          ((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719569, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          return;
        }
        bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719594, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        return;
      case 5002: 
        a((adzp)localObject1, 2131718790);
        if (paramView.uiOperatorFlag == 2)
        {
          ((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719570, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          return;
        }
        bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719595, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        return;
      case 2004: 
        b((adzp)localObject1);
        return;
      case 2002: 
        b((adzp)localObject1);
        a((adzp)localObject1);
        if ((paramayqo.c == null) || (!c(paramView)) || (b((adzp)localObject1)) || (b(paramView))) {
          continue;
        }
        localObject2 = paramayqo.c;
        paramayqo = paramayqo.u;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_RECV_PROCESS: domain=" + paramayqo + ", videoUrls=" + Arrays.toString((Object[])localObject2));
        }
        Object localObject3 = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
        int[] arrayOfInt = ShortVideoUtils.a(paramView.thumbWidth, paramView.thumbHeight);
        paramInt2 = arrayOfInt[0];
        int i = arrayOfInt[1];
        paramInt1 = 0;
        while (paramInt1 < 1)
        {
          if (!TextUtils.isEmpty(paramayqo)) {
            localObject2[paramInt1] = (localObject2[paramInt1] + "&txhost=" + paramayqo);
          }
          paramInt1 += 1;
        }
        a((adzp)localObject1, false, paramView, null, (String[])localObject2, (String)localObject3, paramInt2, i);
        if ((paramView.CheckIsHotVideo()) && (!bbbt.a().a(paramView, "0X8007EDB")))
        {
          bbbt.a().a(paramView, "0X8007EDB");
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
        }
        if (bbbt.a().a(paramView, "0X80077D9")) {
          continue;
        }
        paramInt1 = npu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramayqo = new JSONObject();
        try
        {
          paramayqo.put("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          paramayqo.put("memNum", paramInt1);
          paramayqo.put("msg_uniseq", paramView.uniseq);
          label1306:
          nol.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", npu.a(paramView.getMd5(), null, null, null, paramayqo), false);
          bbbt.a().a(paramView, "0X80077D9");
          return;
          if ((paramayqo.jdField_b_of_type_Int != 7) && (paramayqo.jdField_b_of_type_Int != 18) && (paramayqo.jdField_b_of_type_Int != 16)) {
            continue;
          }
          switch (paramayqo.d)
          {
          default: 
          case 2001: 
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_START:");
            return;
          case 2003: 
            paramayqo = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
            localObject2 = ShortVideoUtils.a(paramView.thumbWidth, paramView.thumbHeight);
            paramInt2 = localObject2[0];
            i = localObject2[1];
            if ((!c(paramView)) || (b((adzp)localObject1)) || (b(paramView))) {
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
              if (bbfj.h(this.jdField_a_of_type_AndroidContentContext))
              {
                localObject2 = axdq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, 2);
                if (localObject2 != null) {
                  axdq.a((axei)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                }
              }
              a((adzp)localObject1, paramView, paramayqo, paramInt2, i, true);
              return;
              l1 = qtx.a(8, paramView.videoFileTime, paramView.videoFileSize);
              break;
              paramInt1 = 1;
              continue;
              paramInt1 = 1;
            }
            if (paramView.videoFileTime <= 8) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              a((adzp)localObject1, true, paramView, (String)localObject2, null, paramayqo, paramInt2, i);
              a((adzp)localObject1);
              if (paramInt1 == 0) {
                break;
              }
              ((adzp)localObject1).d.setVisibility(8);
              return;
            }
            ((adzp)localObject1).d.setVisibility(0);
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
            paramayqo = ShortVideoUtils.a(paramView.thumbWidth, paramView.thumbHeight);
            paramInt1 = paramayqo[0];
            paramInt2 = paramayqo[1];
            ((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(paramView.uniseq);
            ((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(a(paramInt1, paramInt2));
            a((adzp)localObject1, 2131718790);
            ((adzp)localObject1).d.setVisibility(8);
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
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296294);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, i, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, float paramFloat)
  {
    adzp localadzp = a(paramMessageForShortVideo);
    if (localadzp == null) {
      return;
    }
    paramMessageForShortVideo = paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq;
    localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(ajya.a(2131714073), paramMessageForShortVideo);
    localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramMessageForShortVideo, paramFloat);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "CompressUpdateListener,onFinish. seq = " + paramMessageForShortVideo.uniseq);
    }
    bfny.a(new ShortVideoItemBuilder.4(this, paramMessageForShortVideo, paramInt));
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 998) {
      return;
    }
    if ((TextUtils.isEmpty(paramMessageForShortVideo.md5)) || (paramMessageForShortVideo.videoFileStatus == 1004))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719559, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    String str = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    boolean bool2 = NetworkUtils.isMobileConnected(this.jdField_a_of_type_AndroidContentContext);
    if ((axdq.jdField_a_of_type_Long != 0L) && (System.currentTimeMillis() - axdq.jdField_a_of_type_Long < 300000L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "startPlayVideo isConfirmed=" + bool1 + " allowPlayInXGTime=" + axdq.jdField_a_of_type_Long + " isXGConnected = " + bool2);
      }
      if ((!bool2) || (bool1) || ((bbdx.a(str)) && (paramMessageForShortVideo.videoFileStatus != 2002)) || (paramMessageForShortVideo.videoFileSize < 1048576)) {
        break label348;
      }
      if (!bcwb.a((Activity)this.jdField_a_of_type_AndroidContentContext, 3, new adzl(this, paramMessageForShortVideo, paramLong, paramBoolean))) {
        break;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131718468);
      this.jdField_a_of_type_Bbgu = bbdj.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131718471), str, this.jdField_a_of_type_AndroidContentContext.getString(2131718469), this.jdField_a_of_type_AndroidContentContext.getString(2131718470), new adzm(this, paramMessageForShortVideo, paramLong, paramBoolean), new adzn(this));
      paramMessageForShortVideo = aseg.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
      if ((paramMessageForShortVideo instanceof SpannableString)) {
        this.jdField_a_of_type_Bbgu.setMessageWithoutAutoLink(paramMessageForShortVideo);
      }
      try
      {
        this.jdField_a_of_type_Bbgu.show();
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
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, adzp paramadzp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    boolean bool = paramMessageForShortVideo.CheckIsHotVideo();
    String str1 = paramMessageForShortVideo.videoFileName;
    String str2 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if ((!bbdx.b(str1)) && (!bool))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719601, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      b(paramadzp);
      paramadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if ((!bbdx.b(str2)) && (!bool))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719602, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      b(paramadzp);
      paramadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((awap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    paramadzp = axdq.a(1, this.jdField_c_of_type_Int);
    paramMessageForShortVideo = axdq.a(this.jdField_c_of_type_Int, paramMessageForShortVideo, paramadzp);
    paramMessageForShortVideo.e = bool;
    paramadzp.a(paramMessageForShortVideo);
    axdq.a(paramadzp, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    adzp localadzp = a(paramMessageForShortVideo);
    if (localadzp == null) {
      return;
    }
    bfny.a(new ShortVideoItemBuilder.3(this, paramMessageForShortVideo, paramBoolean, localadzp));
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
  
  public bbmh[] a(View paramView)
  {
    paramView = (adzp)actj.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bbmf localbbmf = new bbmf();
    if (localMessageForShortVideo != null)
    {
      if (!localMessageForShortVideo.isMultiMsg) {
        break label48;
      }
      a(localbbmf, localMessageForShortVideo, paramView);
    }
    for (;;)
    {
      return localbbmf.a();
      label48:
      b(localbbmf, localMessageForShortVideo, paramView);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public bbmf b(bbmf parambbmf, ChatMessage paramChatMessage, acva paramacva)
  {
    boolean bool3 = false;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    adzp localadzp = (adzp)paramacva;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.a(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForShortVideo.videoFileStatus));
    }
    b(parambbmf, this.jdField_a_of_type_AndroidContentContext);
    int i;
    boolean bool1;
    label226:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramacva = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (bbdx.b(paramacva))
      {
        paramacva = "";
        i = 1;
        if (i == 0) {
          break label574;
        }
        if (!"1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"))) {
          break label561;
        }
        boolean bool4 = localMessageForShortVideo.checkForward();
        if ((localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView == null) || (!localadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(localadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + localadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
          break label568;
        }
        bool1 = true;
        bool2 = bool3;
        if (localadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
        {
          bool2 = bool3;
          if (localadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
            bool2 = true;
          }
        }
        if ((!bool4) || (bool1) || (bool2)) {
          break label521;
        }
        parambbmf.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692753), 2130838606);
        paramacva = paramacva + "inMiddleStatus = false, progeressBarShowing = false, errorIconShowing = false, show forward menu.";
      }
    }
    label521:
    label561:
    label568:
    label574:
    for (;;)
    {
      a(localMessageForShortVideo, parambbmf);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getMenuItem: " + paramacva);
      }
      if ((localMessageForShortVideo != null) && ((localadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (localadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0))) {
        a(parambbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForShortVideo);
      }
      a(parambbmf, localMessageForShortVideo);
      if ((localMessageForShortVideo != null) && (bbdx.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))) {
        parambbmf.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692324), 2130838605);
      }
      b(paramChatMessage, parambbmf);
      super.c(parambbmf, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambbmf, this.jdField_a_of_type_AndroidContentContext);
      this.f = true;
      return parambbmf;
      paramacva = "thumbFilePath=" + paramacva + " , not exits.";
      i = 0;
      break;
      paramacva = " msg == null or md5 is empty.";
      i = 0;
      break;
      paramacva = paramacva + "progeressBarShowing=" + bool1 + ", errorIconShowing=" + bool2;
      continue;
      paramacva = " not inDPCWhiteList.";
      continue;
      bool1 = false;
      break label226;
    }
  }
  
  protected void b(adzp paramadzp)
  {
    if (a(paramadzp)) {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "hideProgress...file is saving, so return!");
      }
    }
    do
    {
      return;
      if (!a(paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "hideProgress fail...video order sending! " + paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return;
    paramadzp.c.setVisibility(8);
    if (!paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadzp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(2);
      return;
    }
    paramadzp.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimRunnableListener(new adzg(this, paramadzp));
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
    aqbe.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "1", "", "");
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("muate_play", paramBoolean);
    a(paramMessageForShortVideo, paramLong, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localBundle, null);
    ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, adzp paramadzp)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "reForwardVideo：" + paramMessageForShortVideo.toString());
      }
      if (!bbdx.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719602, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        b(paramadzp);
        paramadzp.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        ((awap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
        paramadzp = axdq.a(4, this.jdField_c_of_type_Int);
        paramadzp.a(axdq.a(this.jdField_c_of_type_Int, paramMessageForShortVideo, paramadzp));
        axdq.a(paramadzp, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    Object localObject1 = (adzp)actj.a(paramView);
    jdField_a_of_type_AndroidGraphicsRect = a(paramView, (MessageForShortVideo)((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    actj.n = true;
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
          if ((paramView.getId() == 2131364109) || (paramView.getId() == 2131364151))
          {
            a((adzp)localObject1, false);
            return;
          }
        } while (paramView.getId() != 2131364128);
        paramView = new StringBuilder();
      } while (((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if ((!(localObject2 instanceof ShortVideoUploadProcessor)) || (!((ShortVideoUploadProcessor)localObject2).g)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoItemBuilder", 2, "CompressTask pauseOperator!");
    return;
    Object localObject2 = axfi.a().a(((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    if (localObject2 != null)
    {
      ((axfj)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.isPause = true;
      boolean bool = ((axfj)localObject2).cancel(true);
      paramView.append("\n ShortVideoItemBuilder task cancel:").append(bool);
      paramView.append("\n md5 info:").append(((MessageForShortVideo)((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).md5);
      if ((bool) && (((MessageForShortVideo)((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).md5 == null))
      {
        bool = ((axfj)localObject2).a();
        paramView.append("\n media codec cancel:").append(bool);
        if (!bool) {
          break label424;
        }
        paramView.append("\n ffmpeg process cancel!");
      }
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((adzp)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adzf
 * JD-Core Version:    0.7.0.1
 */