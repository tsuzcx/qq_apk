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

public class adzh
  extends BaseBubbleBuilder
  implements acuq, acwf, axdq, axfk
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect;
  private static CopyOnWriteArraySet<CropBubbleVideoView> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  public static AtomicLong a;
  private static long c;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adzj(this);
  private asuu jdField_a_of_type_Asuu;
  private bbgg jdField_a_of_type_Bbgg;
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
  
  public adzh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = 0;
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if (this.jdField_a_of_type_Asuu == null) {
      this.jdField_a_of_type_Asuu = ((asuu)paramQQAppInterface.getManager(324));
    }
  }
  
  private adzr a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int i = actn.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (i <= -1) {
        break label215;
      }
      Object localObject = actn.a(this.jdField_a_of_type_ComTencentWidgetListView, i);
      if (localObject != null)
      {
        localObject = actn.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof adzr))) {
          return (adzr)localObject;
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
  
  private adzr a(MessageForShortVideo paramMessageForShortVideo)
  {
    adzr localadzr = a(paramMessageForShortVideo.uniseq);
    if ((localadzr == null) && (QLog.isColorLevel())) {
      QLog.d("ShortVideoItemBuilder", 2, "holder is null, seq = " + paramMessageForShortVideo.uniseq);
    }
    return localadzr;
  }
  
  private Rect a(View paramView, MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramView == null) || (paramMessageForShortVideo == null)) {
      return null;
    }
    paramView = paramView.findViewById(2131362238);
    if ((paramView instanceof CropBubbleVideoView))
    {
      paramView = (CropBubbleVideoView)paramView;
      Rect localRect = xpx.a(paramView);
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
    return new anou(Color.rgb(214, 214, 214), paramInt1, paramInt2);
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Drawable localDrawable = null;
    if (bbdj.b(paramString))
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
  
  private void a(adzr paramadzr, int paramInt)
  {
    paramadzr.c.setVisibility(0);
    paramadzr.c.setText(paramInt);
    paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
    paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setImageResource(2130848693);
    paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(3);
  }
  
  private void a(adzr paramadzr, View paramView, ChatMessage paramChatMessage)
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
        if ((axdw.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.msgTailType)) && (paramChatMessage.istroop == 1))
        {
          if (paramadzr.e == null)
          {
            paramadzr.e = new TextView(this.jdField_a_of_type_AndroidContentContext);
            paramadzr.e.setBackgroundResource(2130842091);
            paramadzr.e.setTextSize(1, 12.0F);
            paramadzr.e.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167134));
            paramadzr.e.setText(axdw.b(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.msgTailType));
            paramadzr.e.setSingleLine();
            paramadzr.e.setGravity(16);
            paramadzr.e.setPadding(bawz.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, bawz.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0);
            paramadzr.e.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
            paramChatMessage.addRule(3, 2131364110);
            paramChatMessage.addRule(5, 2131364110);
            if ((paramView instanceof ViewGroup)) {
              ((ViewGroup)paramView).addView(paramadzr.e, paramChatMessage);
            }
          }
          paramView = (RelativeLayout.LayoutParams)paramadzr.e.getLayoutParams();
          if (localMessageForShortVideo.isSend()) {}
          for (paramView.leftMargin = BaseChatItemLayout.j;; paramView.leftMargin = BaseChatItemLayout.i)
          {
            paramadzr.e.setTag(localMessageForShortVideo);
            paramadzr.e.setVisibility(0);
            return;
          }
        }
      } while (paramadzr.e == null);
      paramadzr.e.setVisibility(8);
      return;
    }
  }
  
  private void a(adzr paramadzr, MessageForShortVideo paramMessageForShortVideo, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, msg.uniseq = " + paramMessageForShortVideo.uniseq);
    }
    paramString = ShortVideoUtils.a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, url = " + paramString);
    }
    if ((QLog.isColorLevel()) && (paramadzr.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
      QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d.getURL()=" + paramadzr.jdField_a_of_type_ComTencentImageURLDrawable.getURL());
    }
    paramadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    if ((paramadzr.jdField_a_of_type_ComTencentImageURLDrawable != null) && (paramadzr.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "showVideoThumb, holder.d is reuse !!!");
      }
      if (paramBoolean)
      {
        paramadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setCoverDrawable(paramadzr.jdField_a_of_type_ComTencentImageURLDrawable);
        return;
      }
      paramadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(paramadzr.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    Drawable localDrawable = a(paramInt1, paramInt2);
    paramString = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localDrawable, localDrawable);
    paramadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
    paramadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(paramString);
    paramadzr.jdField_a_of_type_ComTencentImageURLDrawable = paramString;
  }
  
  private void a(adzr paramadzr, boolean paramBoolean)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    int i = localMessageForShortVideo.videoFileStatus;
    long l = 0L;
    if (paramadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView != null) {
      l = paramadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a();
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
      if (!bbdj.b((String)localObject))
      {
        localStringBuilder.append(" videoPathExists:false ");
        if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9))
        {
          localStringBuilder.append(" fileType:video, =" + ShortVideoUtils.a(localMessageForShortVideo.fileType));
          if (i == 2005)
          {
            b(paramadzr);
            bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719585, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
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
        b(paramadzr);
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719583, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        localStringBuilder.append(" result: toast file_unsafe ");
      }
      else if (i == 5002)
      {
        a(paramadzr, 2131718779);
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719584, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        localStringBuilder.append(" result: toast file_expired ");
      }
      else
      {
        b(paramadzr);
        a(localMessageForShortVideo, l, paramBoolean);
        localStringBuilder.append(" status:other, result: download ");
        continue;
        if (i == 5002)
        {
          a(paramadzr, 2131718779);
          bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719584, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          localStringBuilder.append("fileType:not video,videoPathExits:false, result:toast file_expired ");
        }
        else
        {
          b(paramadzr);
          a(localMessageForShortVideo, l, paramBoolean);
          localStringBuilder.append("fileType:not video,videoPathExits:false, result: download");
          continue;
          b(paramadzr);
          a(localMessageForShortVideo, l, paramBoolean);
          localStringBuilder.append("videoPathExists:true, result:play ");
          continue;
          localStringBuilder.append(" sendFromLocal:true ");
          if (localMessageForShortVideo.isMultiMsg) {
            localMessageForShortVideo.extraflag = 32772;
          }
          if (bbdj.b(localMessageForShortVideo.videoFileName))
          {
            localStringBuilder.append(" localUploadPath Exists:true ");
            if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9))
            {
              localStringBuilder.append(" fileType:video ");
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
              if (localObject != null)
              {
                if ((ShortVideoUploadProcessor.class.isInstance(localObject)) || (ayuu.class.isInstance(localObject)))
                {
                  if (i == 1005)
                  {
                    b(paramadzr);
                    paramadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                    localStringBuilder.append(" status:send_error, result:show send error ");
                  }
                  else if ((i == 1002) || (i == 1001))
                  {
                    a(localMessageForShortVideo, l, paramBoolean);
                    localStringBuilder.append(" status:process or start, result:pauseSending ");
                  }
                  else
                  {
                    b(paramadzr);
                    a(localMessageForShortVideo, l, paramBoolean);
                    localStringBuilder.append(" status:other, result:play ");
                  }
                }
                else if (ayur.class.isInstance(localObject)) {
                  localStringBuilder.append(" processor:not up of forward, result: none");
                }
              }
              else
              {
                b(paramadzr);
                a(localMessageForShortVideo, l, paramBoolean);
                localStringBuilder.append(" processor:null, result:play ");
              }
            }
            else
            {
              b(paramadzr);
              a(localMessageForShortVideo, l, paramBoolean);
              localStringBuilder.append(" fileType:not video, result: play ");
            }
          }
          else
          {
            localStringBuilder.append(" localUploadPath Exists:false ");
            if (!bbdj.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))
            {
              localStringBuilder.append(" downloadPath Exists:false ");
              if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9))
              {
                localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
                if (localObject != null)
                {
                  boolean bool;
                  if (ayur.class.isInstance(localObject))
                  {
                    bool = ((ayur)localObject).d();
                    localStringBuilder.append(" processor:download, pause:" + bool);
                    if (bool)
                    {
                      b(paramadzr);
                      a(localMessageForShortVideo, l, paramBoolean);
                      localStringBuilder.append(" pause:true, result:download ");
                    }
                    else if (i == 2005)
                    {
                      b(paramadzr);
                      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719585, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                      localStringBuilder.append(" status:recv_error, result:toast recv_error ");
                    }
                    else if ((i == 2002) || (i == 2000) || (i == 2008) || (i == 2001))
                    {
                      b(paramadzr);
                    }
                    else if (i == 5001)
                    {
                      b(paramadzr);
                      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719583, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                      localStringBuilder.append(" status:file_unsafe, result:toast unsafe ");
                    }
                    else if (i == 5002)
                    {
                      a(paramadzr, 2131718779);
                      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719584, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                      localStringBuilder.append(" status:file_expired, result:toast expired ");
                    }
                    else
                    {
                      b(paramadzr);
                      a(localMessageForShortVideo, l, paramBoolean);
                      localStringBuilder.append(" status:other, result:download ");
                    }
                  }
                  else if (ShortVideoUploadProcessor.class.isInstance(localObject))
                  {
                    b(paramadzr);
                    paramadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                    bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719590, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                    localStringBuilder.append(" processor:upload, result:show upload error and show toast");
                  }
                  else if (ayuu.class.isInstance(localObject))
                  {
                    bool = ((ayuu)localObject).d();
                    localStringBuilder.append(" processor:forward, pause:" + bool);
                    if (bool)
                    {
                      a(paramadzr, 10, false);
                      b(localMessageForShortVideo, paramadzr);
                      localStringBuilder.append(" pause:true, result:reforward ");
                    }
                    else if (i == 5001)
                    {
                      b(paramadzr);
                      paramadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719558, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                      localStringBuilder.append(" status:unsafe, result:toast unsafe ");
                    }
                    else if (i == 5002)
                    {
                      a(paramadzr, 2131718779);
                      paramadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719559, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
                      localStringBuilder.append(" status:expired, result:toast expired ");
                    }
                    else if (i == 1005)
                    {
                      b(paramadzr);
                      paramadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
                      localStringBuilder.append(" status:send_error, result:show send_error ");
                    }
                    else if ((i == 1002) || (i == 1001))
                    {
                      a(localMessageForShortVideo, 0L, paramBoolean);
                    }
                    else
                    {
                      b(paramadzr);
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
                  b(paramadzr);
                  localStringBuilder.append(" processor:null, result:download ");
                  a(localMessageForShortVideo, 0L, paramBoolean);
                }
              }
              else
              {
                b(paramadzr);
                a(localMessageForShortVideo, l, paramBoolean);
                localStringBuilder.append(" fileType:not video, result:download ");
              }
            }
            else
            {
              b(paramadzr);
              a(localMessageForShortVideo, l, paramBoolean);
              localStringBuilder.append(" downloadPath Exists:true，result:play ");
            }
          }
        }
      }
    }
  }
  
  private void a(adzr paramadzr, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramadzr != null) && (paramadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null))
    {
      if (paramBoolean) {
        b(paramadzr, false, null);
      }
      paramadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private void a(adzr paramadzr, boolean paramBoolean, MessageForShortVideo paramMessageForShortVideo, String paramString1, String[] paramArrayOfString, String paramString2, int paramInt1, int paramInt2)
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
      paramadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      localObject = new bbvs();
      ((bbvs)localObject).jdField_a_of_type_Int = 101;
      ((bbvs)localObject).jdField_c_of_type_Boolean = true;
      ((bbvs)localObject).jdField_a_of_type_Bbvx = new adzk(this);
      ((bbvs)localObject).jdField_b_of_type_Boolean = paramBoolean;
      ((bbvs)localObject).jdField_a_of_type_Boolean = true;
      ((bbvs)localObject).jdField_a_of_type_JavaLangString = paramString1;
      ((bbvs)localObject).jdField_b_of_type_JavaLangString = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
      ((bbvs)localObject).jdField_c_of_type_JavaLangString = (paramMessageForShortVideo.md5 + paramMessageForShortVideo.uniseq);
      ((bbvs)localObject).jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
      ((bbvs)localObject).d = paramMessageForShortVideo.videoFileSize;
      if (paramMessageForShortVideo.videoFileTime > 8) {
        break label303;
      }
      i = 1;
      label216:
      if (i == 0)
      {
        ((bbvs)localObject).jdField_a_of_type_Long = (paramMessageForShortVideo.videoFileTime * 1000);
        ((bbvs)localObject).jdField_b_of_type_Long = 8000L;
      }
      paramadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setVideoParam((bbvs)localObject);
      paramMessageForShortVideo = a(paramInt1, paramInt2);
      if (!TextUtils.isEmpty(paramString2)) {
        break label309;
      }
      paramadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setCoverDrawable(paramMessageForShortVideo);
    }
    for (;;)
    {
      paramadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a();
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView);
      return;
      localObject = "null";
      break;
      label303:
      i = 0;
      break label216;
      label309:
      paramMessageForShortVideo = URLDrawable.getDrawable(ShortVideoUtils.a(paramString2), paramInt1, paramInt2, paramMessageForShortVideo, paramMessageForShortVideo);
      paramadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setCoverDrawable(paramMessageForShortVideo);
      paramadzr.jdField_a_of_type_ComTencentImageURLDrawable = paramMessageForShortVideo;
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!bbbf.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      bbbf.a().a(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForShortVideo.frienduin, 1, 1, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Bundle paramBundle, MessageForReplyText paramMessageForReplyText)
  {
    if ((qvn.a(paramContext)) || (paramQQAppInterface.c()))
    {
      bcpw.a(paramContext, 0, 2131719576, 0).b(paramContext.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    if (!paramMessageForShortVideo.isSend()) {
      new avws(BaseApplication.getContext()).a(paramQQAppInterface, 2002, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
    }
    boolean bool = bhvh.d(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startPlayerActivity() msg.videoAttr=" + paramMessageForShortVideo.videoAttr + ", msg.istroop=" + paramMessageForShortVideo.istroop + ", isSupportMultiVideoSwitch=" + Boolean.valueOf(bool));
    }
    bool = bhvg.a(paramQQAppInterface);
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
        bgkh.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), aehy.a(paramMessageForShortVideo), -1, i);
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
        localObject = (asuu)paramQQAppInterface.getManager(324);
        bool = ((asuu)localObject).a(paramMessageForShortVideo);
        paramBundle.putBoolean("extra.IS_SAVING_FILE", bool);
        if (bool)
        {
          localObject = ((asuu)localObject).a(((asuu)localObject).a(paramMessageForShortVideo));
          if ((localObject != null) && (((asuq)localObject).d == 1)) {
            paramBundle.putInt("extra.SAVE_FILE_PROGRESS", ((asuq)localObject).jdField_c_of_type_Int);
          }
        }
        if ((paramMessageForShortVideo.istroop != 0) || (!bbbd.b(paramMessageForShortVideo.senderuin)) || (TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type")))) {
          continue;
        }
        paramBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
        bgkh.a(paramContext, paramBundle, new AIOImageProviderService(paramMessageForReplyText, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), aehy.a(paramMessageForShortVideo), 13007, i);
        ((awan)paramQQAppInterface.getManager(326)).a();
        if (!paramMessageForShortVideo.isSend()) {
          new avws(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
        }
        ausd.b(paramQQAppInterface, paramMessageForShortVideo);
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
    localBundle.putBoolean(bgkh.jdField_b_of_type_JavaLangString, paramBoolean2);
    a(paramMessageForShortVideo, paramLong, paramContext, paramQQAppInterface, paramSessionInfo, localBundle, paramMessageForReplyText);
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "handleVideoCompressSucceed, seq = " + paramMessageForShortVideo.uniseq);
    }
    axfh localaxfh = axfg.a().a(paramMessageForShortVideo.uniseq);
    if ((paramQQAppInterface != null) && (localaxfh != null)) {
      if (localaxfh.a() >= 104345600L)
      {
        paramMessageForShortVideo.videoFileStatus = 1005;
        paramMessageForShortVideo.serial();
        paramQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
        if (paramContext != null)
        {
          bcpw.a(paramContext, paramContext.getResources().getString(2131719556), 0).b(paramContext.getResources().getDimensionPixelSize(2131298865));
          paramContext = ((FragmentActivity)paramContext).getChatFragment();
          if (paramContext != null)
          {
            paramContext = paramContext.a();
            if (paramContext != null) {
              paramContext.b(false, false);
            }
          }
        }
        awan.a(paramQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
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
      paramContext = axdo.a(0, 0);
      paramMessageForShortVideo = axdo.a(paramMessageForShortVideo, paramContext);
      if (paramMessageForShortVideo != null)
      {
        paramMessageForShortVideo.i = localaxfh.a();
        paramMessageForShortVideo.jdField_a_of_type_Boolean = false;
        paramContext.a(paramMessageForShortVideo);
      }
      axdo.a(paramContext, paramQQAppInterface);
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(-1L);
      return;
    }
    QLog.i("ShortVideoItemBuilder", 2, "CompressTask onPostExecute QQAppInterface is null...");
  }
  
  private boolean a(long paramLong)
  {
    return ((awan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong);
  }
  
  private boolean a(adzr paramadzr)
  {
    if (this.jdField_a_of_type_Asuu != null)
    {
      paramadzr = this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_Asuu.a(paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage));
      return (paramadzr != null) && (paramadzr.d == 1) && (!paramadzr.jdField_a_of_type_Boolean);
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
      if (axfg.a().a(paramMessageForShortVideo.uniseq) == null)
      {
        paramMessageForShortVideo = ShortVideoUtils.c(paramMessageForShortVideo.videoFileName, "mp4");
        if (!TextUtils.isEmpty(paramMessageForShortVideo)) {
          bbdj.d(paramMessageForShortVideo);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static Drawable b(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    anou localanou = new anou(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, paramInt1, paramInt2, localanou, localanou);
        localURLDrawable.setTag(bavi.b(0, 0, paramInt3));
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
    return localanou;
  }
  
  private void b(adzr paramadzr, View paramView, ChatMessage paramChatMessage)
  {
    if (c(paramadzr))
    {
      if (paramadzr.jdField_a_of_type_AndroidWidgetImageView == null)
      {
        paramadzr.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramadzr.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838105);
        paramadzr.jdField_a_of_type_AndroidWidgetImageView.setId(2131364129);
        paramChatMessage = new RelativeLayout.LayoutParams(-2, -2);
        paramChatMessage.bottomMargin = actn.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramChatMessage.addRule(8, 2131364110);
        paramChatMessage.addRule(0, 2131364110);
        paramChatMessage.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramadzr.jdField_a_of_type_AndroidWidgetImageView, paramChatMessage);
        }
      }
      b(paramadzr, true, this);
      return;
    }
    b(paramadzr, false, null);
  }
  
  private void b(adzr paramadzr, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      if (paramadzr.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        paramadzr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramadzr.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      }
    }
    while (paramadzr.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    paramadzr.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramadzr.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
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
      awan.a(paramQQAppInterface, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
    }
    if (paramContext != null) {}
  }
  
  private boolean b(adzr paramadzr)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Asuu != null)
    {
      paramadzr = this.jdField_a_of_type_Asuu.a(this.jdField_a_of_type_Asuu.a(paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage));
      if ((paramadzr != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      bool1 = bool2;
      if (paramadzr != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean b(MessageForShortVideo paramMessageForShortVideo)
  {
    return false;
  }
  
  private void c(adzr paramadzr)
  {
    if (c(paramadzr))
    {
      if (paramadzr.jdField_a_of_type_AndroidWidgetImageView != null) {
        break label20;
      }
      h();
    }
    label20:
    while (paramadzr.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      return;
    }
    b(paramadzr, true, this);
  }
  
  private void c(MessageForShortVideo paramMessageForShortVideo, adzr paramadzr)
  {
    int k = 1;
    asuq localasuq;
    int i;
    if ((this.jdField_a_of_type_Asuu != null) && (paramMessageForShortVideo != null) && (paramadzr != null))
    {
      paramMessageForShortVideo = this.jdField_a_of_type_Asuu.a(paramMessageForShortVideo);
      localasuq = this.jdField_a_of_type_Asuu.a(paramMessageForShortVideo);
      if ((localasuq != null) && (localasuq.d == 1))
      {
        if (localasuq.jdField_c_of_type_Int >= 0) {
          break label188;
        }
        i = 0;
        j = k;
        if (paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getVisibility() != 8) {
          if ((paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getVisibility() != 0) || (paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.d != 2)) {
            break label213;
          }
        }
      }
    }
    label188:
    label213:
    for (int j = k;; j = 0)
    {
      if ((i < 100) && (j != 0) && (!localasuq.jdField_a_of_type_Boolean) && (localasuq.jdField_a_of_type_Asup != null))
      {
        localasuq.jdField_a_of_type_Asup.a(new adzm(this, paramMessageForShortVideo, paramadzr));
        this.jdField_a_of_type_Asuu.a(paramMessageForShortVideo, localasuq);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "dealVideoSaveUI showSaveProgress");
        }
        a(paramadzr, i, false);
        paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      }
      return;
      if (localasuq.jdField_c_of_type_Int > 100)
      {
        i = 100;
        break;
      }
      i = localasuq.jdField_c_of_type_Int;
      break;
    }
  }
  
  private boolean c(adzr paramadzr)
  {
    boolean bool2 = true;
    if ((paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {
        return false;
      }
      int i;
      int j;
      if ((localMessageForShortVideo.videoFileStatus == 998) || (localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 1001))
      {
        i = 1;
        if ((localMessageForShortVideo.isMultiMsg) || (localMessageForShortVideo.uiOperatorFlag == 2) || (localMessageForShortVideo.busiType != 0) || (!localMessageForShortVideo.isSendFromLocal()) || (paramadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a())) {
          break label211;
        }
        j = 1;
        label109:
        if (QLog.isColorLevel())
        {
          paramadzr = new StringBuilder().append("needShowPauseIcon seq:").append(localMessageForShortVideo.uniseq).append(", videostatus:").append(localMessageForShortVideo.videoFileStatus).append(", iconshow:");
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
    return axui.a().a(this.jdField_a_of_type_AndroidContentContext, 1, paramMessageForShortVideo.istroop);
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
          if (bbdj.b(str))
          {
            bool1 = bool2;
            if (bbdj.b(paramMessageForShortVideo)) {
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
  
  public acum a(View paramView)
  {
    if (paramView != null)
    {
      paramView = (adzr)actn.a(paramView);
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView;
      }
    }
    return null;
  }
  
  public acun a()
  {
    return new adzr(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxn paramacxn)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxn);
    if ((paramChatMessage instanceof MessageForShortVideo)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)paramChatMessage);
    }
    a(paramChatMessage, paramView, this);
    a((adzr)paramView.getTag(), paramView, paramChatMessage);
    b((adzr)paramView.getTag(), paramView, paramChatMessage);
    if (e) {}
    try
    {
      paramChatMessage = (adzr)paramView.getTag();
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append(paramChatMessage.jdField_a_of_type_AndroidWidgetTextView.getText());
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime);
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.append("秒按钮");
      paramView.setContentDescription(paramChatMessage.jdField_b_of_type_JavaLangStringBuilder.toString());
      return paramView;
    }
    catch (Exception paramChatMessage) {}
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getBubbleView, message.uniseq = " + paramChatMessage.uniseq);
    }
    adzr localadzr = (adzr)paramacun;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramBaseChatItemLayout = (MessageForShortVideo)paramChatMessage;
    boolean bool1 = paramBaseChatItemLayout.isSend();
    paramacun = paramView;
    int i;
    if (paramView == null)
    {
      paramacun = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      paramView = new CropBubbleVideoView(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout.uniseq, null, bool1);
      paramView.setId(2131362238);
      paramView.setVisibility(0);
      paramView.setContentDescription(ajyc.a(2131714026));
      paramacun.addView(paramView);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramView);
      VideoProgressView localVideoProgressView = new VideoProgressView(this.jdField_a_of_type_AndroidContentContext);
      localVideoProgressView.setId(2131364152);
      paramacun.addView(localVideoProgressView);
      ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 0);
      i = actn.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      Object localObject2 = new RelativeLayout.LayoutParams(i, i);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramacun.addView(localProgressBar, (ViewGroup.LayoutParams)localObject2);
      Object localObject3 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject3).setOrientation(1);
      ((LinearLayout)localObject3).setGravity(17);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramacun.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      Object localObject4 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject4).topMargin = actn.a(70.0F, (Resources)localObject1);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setId(2131364150);
      ((TextView)localObject2).setVisibility(4);
      ((LinearLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      localObject3 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject3).setBackgroundResource(2130838791);
      localObject4 = new RelativeLayout.LayoutParams(-1, actn.a(55.0F, (Resources)localObject1));
      ((RelativeLayout.LayoutParams)localObject4).addRule(5, 2131362238);
      ((RelativeLayout.LayoutParams)localObject4).addRule(7, 2131362238);
      ((RelativeLayout.LayoutParams)localObject4).addRule(8, 2131362238);
      paramacun.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setTextSize(1, 12.0F);
      ((TextView)localObject4).setTextColor(-1);
      Object localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).leftMargin = actn.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject5).bottomMargin = actn.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject5).addRule(9);
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout)localObject3).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject5).setTextSize(1, 12.0F);
      ((TextView)localObject5).setTextColor(-1);
      Object localObject6 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject6).rightMargin = actn.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject6).bottomMargin = actn.a(7.0F, (Resources)localObject1);
      ((RelativeLayout.LayoutParams)localObject6).addRule(11);
      ((RelativeLayout.LayoutParams)localObject6).addRule(12);
      ((RelativeLayout)localObject3).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      localObject6 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject6).setTextSize(1, 14.0F);
      ((TextView)localObject6).setTextColor(-1);
      ((TextView)localObject6).setGravity(17);
      ((TextView)localObject6).setText(2131719577);
      ((TextView)localObject6).setShadowLayer(3.0F, 1.0F, 1.0F, -16777216);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = actn.a(14.0F, (Resources)localObject1);
      localLayoutParams.addRule(14);
      paramacun.addView((View)localObject6, localLayoutParams);
      paramacun.setOnClickListener(this);
      super.a(paramacun, paramacxn);
      localadzr.jdField_a_of_type_AndroidWidgetProgressBar = localProgressBar;
      localadzr.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject3);
      localadzr.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      localadzr.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localObject5);
      localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView = localVideoProgressView;
      localadzr.c = ((TextView)localObject2);
      localadzr.d = ((TextView)localObject6);
      localadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView = paramView;
    }
    localadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setTag(Long.valueOf(paramBaseChatItemLayout.uniseq));
    bbbf.a().a(Long.valueOf(paramBaseChatItemLayout.uniseq), paramBaseChatItemLayout);
    if (localadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.jdField_a_of_type_Boolean != bool1)
    {
      localadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.jdField_a_of_type_Boolean = bool1;
      localadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.invalidate();
    }
    localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnClickListener(this);
    localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnTouchListener(paramacxn);
    localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setOnLongClickListener(paramacxn);
    localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setRadius(15.0F, true);
    localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setShowCorner(true);
    localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setSharpCornerCor(BubbleImageView.a);
    localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setCornerDirection(bool1);
    localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    ausd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout);
    paramView = (RelativeLayout.LayoutParams)localadzr.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    label1018:
    int j;
    int k;
    if (bool1)
    {
      paramView.leftMargin = 0;
      paramView.rightMargin = actn.a(localadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(), (Resources)localObject1);
      paramView = (RelativeLayout.LayoutParams)localadzr.d.getLayoutParams();
      if (!bool1) {
        break label1409;
      }
      paramView.rightMargin = (actn.a(localadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(), (Resources)localObject1) / 2);
      localadzr.jdField_b_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(paramBaseChatItemLayout.videoFileTime * 1000));
      localadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView = ShortVideoUtils.a(paramBaseChatItemLayout.thumbMD5, "jpg");
      paramacxn = ShortVideoUtils.a(paramBaseChatItemLayout.thumbWidth, paramBaseChatItemLayout.thumbHeight);
      j = paramacxn[0];
      k = paramacxn[1];
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getBubbleView, msg.uniseq = " + paramBaseChatItemLayout.uniseq + " msg.thumbWidth = " + paramBaseChatItemLayout.thumbWidth + ", msg.thumbHeight = " + paramBaseChatItemLayout.thumbHeight + ", adjustWidth = " + j + ", adjustHeight = " + k);
      }
      paramacxn = localadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.getLayoutParams();
      if (paramacxn != null) {
        break label1431;
      }
      paramacxn = new RelativeLayout.LayoutParams(j, k);
      localadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setLayoutParams(paramacxn);
      label1211:
      paramacxn = localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.getLayoutParams();
      if (paramacxn != null) {
        break label1478;
      }
      paramacxn = new LinearLayout.LayoutParams(j, k);
      localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setLayoutParams(paramacxn);
      label1249:
      if (axdo.jdField_a_of_type_Boolean)
      {
        axdo.jdField_a_of_type_Long = System.currentTimeMillis();
        axdo.jdField_a_of_type_Boolean = false;
      }
      paramacxn = a(j, k);
      b(localadzr);
      c(paramBaseChatItemLayout, localadzr);
      if ((paramBaseChatItemLayout.md5 != null) || (paramBaseChatItemLayout.CheckIsHotVideo()) || (paramBaseChatItemLayout.isCancelStatus())) {
        break label1683;
      }
      if (paramBaseChatItemLayout.isSendFromLocal())
      {
        localadzr.jdField_a_of_type_AndroidWidgetTextView.setText("");
        if (bbdj.b(paramView))
        {
          a(localadzr, paramBaseChatItemLayout, paramView, j, k, false);
          if (paramBaseChatItemLayout.videoFileStatus != 1005) {
            break label1525;
          }
          localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(2);
          localadzr.c.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      label1382:
      return paramacun;
      paramView.leftMargin = actn.a(localadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(), (Resources)localObject1);
      paramView.rightMargin = 0;
      break;
      label1409:
      paramView.leftMargin = (actn.a(localadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(), (Resources)localObject1) / 2);
      break label1018;
      label1431:
      if ((paramacxn.width == j) && (paramacxn.height == k)) {
        break label1211;
      }
      paramacxn.width = j;
      paramacxn.height = k;
      localadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setLayoutParams(paramacxn);
      break label1211;
      label1478:
      if ((paramacxn.width == j) && (paramacxn.height == k)) {
        break label1249;
      }
      paramacxn.width = j;
      paramacxn.height = k;
      localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setLayoutParams(paramacxn);
      break label1249;
      label1525:
      localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      localadzr.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      localadzr.d.setVisibility(8);
      localadzr.c.setVisibility(8);
      localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      if ((paramBaseChatItemLayout.videoFileStatus != 998) || (a(paramBaseChatItemLayout)))
      {
        paramChatMessage = new axfh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout, this);
        axfg.a().a(paramBaseChatItemLayout.uniseq, paramChatMessage);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView(): msg.md5 == null, start compress task, id:" + paramBaseChatItemLayout.uniseq);
        }
      }
      paramChatMessage = axfg.a().a(paramBaseChatItemLayout.uniseq);
      if (paramChatMessage == null) {
        continue;
      }
      paramChatMessage.a(this);
      return paramacun;
      label1683:
      localadzr.c.setVisibility(8);
      localadzr.jdField_a_of_type_AndroidWidgetTextView.setText(ShortVideoUtils.a(this.jdField_a_of_type_AndroidContentContext, paramBaseChatItemLayout.videoFileSize));
      localadzr.d.setVisibility(8);
      if (bbdj.b(paramView))
      {
        if ((paramBaseChatItemLayout.videoFileStatus == 998) || (paramBaseChatItemLayout.videoFileStatus == 1001) || (paramBaseChatItemLayout.videoFileStatus == 1002) || (paramBaseChatItemLayout.videoFileStatus == 1004)) {}
        for (i = 1;; i = 0)
        {
          if ((c(paramBaseChatItemLayout)) && ((!paramBaseChatItemLayout.isSendFromLocal()) || (i == 0)) && (!b(localadzr)) && (!b(paramBaseChatItemLayout)) && (!a(paramBaseChatItemLayout.uniseq))) {
            break label2166;
          }
          a(localadzr, paramBaseChatItemLayout, paramView, j, k, false);
          localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
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
            return paramacun;
          case 1001: 
            if (paramChatMessage != null) {
              break label3056;
            }
            localadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
            b(localadzr);
            if (!QLog.isColorLevel()) {
              break label1382;
            }
            QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_START, 上传开始被杀进程然后恢复, uniseq:" + paramBaseChatItemLayout.uniseq);
            return paramacun;
          }
        }
        label2166:
        paramacxn = ShortVideoUtils.a(paramBaseChatItemLayout, "mp4");
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView(): videoPath = " + paramacxn);
        }
        localObject1 = new File(paramacxn);
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
            if ((!bbev.h(this.jdField_a_of_type_AndroidContentContext)) || (paramBaseChatItemLayout.videoFileStatus == 5002)) {
              break label2454;
            }
            paramChatMessage = axdo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, 2);
            if (paramChatMessage != null) {
              axdo.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
          }
        }
        for (;;)
        {
          a(localadzr, paramBaseChatItemLayout, paramView, j, k, true);
          break;
          l1 = qua.a(8, paramBaseChatItemLayout.videoFileTime, paramBaseChatItemLayout.videoFileSize);
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
          localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
        }
        label2466:
        a(localadzr, true, paramBaseChatItemLayout, paramacxn, null, paramView, j, k);
        if (paramBaseChatItemLayout.videoFileTime <= 8)
        {
          i = 1;
          label2496:
          a(localadzr);
          if (i == 0) {
            localadzr.d.setVisibility(0);
          }
          if ((paramBaseChatItemLayout.CheckIsHotVideo()) && (!bbbf.a().a(paramBaseChatItemLayout, "0X8007EDB")))
          {
            bbbf.a().a(paramBaseChatItemLayout, "0X8007EDB");
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
          }
          if (bbbf.a().a(paramBaseChatItemLayout, "0X80077D9")) {
            continue;
          }
          i = npx.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          paramView = new JSONObject();
        }
      }
      try
      {
        paramView.put("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        paramView.put("memNum", i);
        paramView.put("msg_uniseq", paramChatMessage.uniseq);
        noo.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", npx.a(paramBaseChatItemLayout.getMd5(), null, null, null, paramView), false);
        bbbf.a().a(paramBaseChatItemLayout, "0X80077D9");
        return paramacun;
        i = 0;
        break label2496;
        if (((paramBaseChatItemLayout.fileType == 7) || (paramBaseChatItemLayout.fileType == 18) || (paramBaseChatItemLayout.fileType == 16)) && (paramBaseChatItemLayout.videoFileStatus == 5002))
        {
          localadzr.d.setVisibility(8);
          localadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(paramBaseChatItemLayout.uniseq);
          localadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(paramacxn);
          a(localadzr, 2131718779);
          if (!QLog.isColorLevel()) {
            break label1853;
          }
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not download pic : 缩略图不存在，而且文件已经过期，不下载, , uniseq:" + paramBaseChatItemLayout.uniseq);
          break label1853;
        }
        if ((paramBaseChatItemLayout.extraflag == 32768) || (b(localadzr))) {
          break label1853;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView not SendFromLocal : 缩略图不存在，开始下载缩略图, , uniseq:" + paramBaseChatItemLayout.uniseq);
        }
        localadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(paramBaseChatItemLayout.uniseq);
        localadzr.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(paramacxn);
        paramChatMessage = axdo.a(2, this.jdField_c_of_type_Int);
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
          axdo.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
          if (paramBaseChatItemLayout.istroop == 3000) {
            paramView.e = 1006;
          } else if (paramBaseChatItemLayout.istroop == 1) {
            paramView.e = 1004;
          }
        }
        label3056:
        a(localadzr, ShortVideoUtils.a(paramBaseChatItemLayout.videoFileProgress, 10), false);
        return paramacun;
        localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
        localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(localadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + localadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        b(localadzr);
        a(localadzr, true, this);
        return paramacun;
        if (paramChatMessage == null)
        {
          localadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          b(localadzr);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ShortVideoItemBuilder", 2, "getBubbleView : --> STATUS_SEND_PROCESS, 上传过程中被杀进程然后恢复, uniseq:" + paramBaseChatItemLayout.uniseq);
          return paramacun;
        }
        if (((awan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).b(paramBaseChatItemLayout.frienduin, paramBaseChatItemLayout.uniseq))
        {
          localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(10, paramBaseChatItemLayout.frienduin + paramBaseChatItemLayout.uniseq);
          localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
          return paramacun;
        }
        i = paramBaseChatItemLayout.videoFileProgress;
        if ((paramChatMessage instanceof ShortVideoUploadProcessor))
        {
          paramChatMessage = (ShortVideoUploadProcessor)paramChatMessage;
          if (paramChatMessage.a() != 0L)
          {
            i = (int)(100L * paramChatMessage.b() / paramChatMessage.a());
            a(localadzr, ShortVideoUtils.a(i, 10), false);
            return paramacun;
            b(localadzr);
            return paramacun;
            b(localadzr);
            return paramacun;
            b(localadzr);
            return paramacun;
            b(localadzr);
            return paramacun;
            a(localadzr, 2131718779);
            return paramacun;
          }
        }
      }
      catch (Exception paramChatMessage)
      {
        for (;;) {}
      }
    }
  }
  
  public bblr a(bblr parambblr, ChatMessage paramChatMessage, acve paramacve)
  {
    boolean bool3 = false;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramacve = (adzr)paramacve;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.a(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForShortVideo.videoFileStatus));
    }
    b(parambblr, this.jdField_a_of_type_AndroidContentContext);
    int i;
    boolean bool1;
    label221:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramChatMessage = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (bbdj.b(paramChatMessage))
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
        if ((paramacve.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView == null) || (!paramacve.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramacve.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramacve.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
          break label479;
        }
        bool1 = true;
        bool2 = bool3;
        if (paramacve.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
        {
          bool2 = bool3;
          if (paramacve.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
            bool2 = true;
          }
        }
        if ((!bool4) || (bool1) || (bool2)) {
          break label432;
        }
        parambblr.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692752), 2130838606);
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
      if ((localMessageForShortVideo != null) && (bbdj.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))) {
        parambblr.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692324), 2130838605);
      }
      this.f = true;
      return parambblr;
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
    if (bbet.a(paramChatMessage.issend)) {
      return ajyc.a(2131714034);
    }
    return ajyc.a(2131714086);
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_Bbgg != null) && (this.jdField_a_of_type_Bbgg.isShowing()))
    {
      this.jdField_a_of_type_Bbgg.dismiss();
      this.jdField_a_of_type_Bbgg = null;
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
            MessageForShortVideo localMessageForShortVideo = bbbf.a().a(Integer.valueOf(localCropBubbleVideoView.getId()));
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
      if (paramInt == 2131364985)
      {
        aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
      }
      if (paramInt == 2131370537)
      {
        super.d(paramChatMessage);
        return;
      }
      if (paramInt == 2131366632)
      {
        b(localMessageForShortVideo);
        if (paramChatMessage.isMultiMsg) {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 6, 0, "6", "", "", "");
        }
      }
      else if (paramInt == 2131365928)
      {
        if (d((MessageForShortVideo)paramChatMessage))
        {
          bgpd.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          bgpr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
          bgpr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
          if (paramChatMessage.isMultiMsg) {
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 6, 0, "6", "", "", "");
          }
        }
      }
      else
      {
        if (paramInt == 2131370494)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoItemBuilder", 2, "onMenuItemClicked(): msg_revoke =>" + localMessageForShortVideo.toLogString());
          }
          if (localMessageForShortVideo.md5 == null)
          {
            axfg.a().b(localMessageForShortVideo.uniseq);
            jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(localMessageForShortVideo.uniseq);
            ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(20)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
            awan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
            return;
          }
          paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
          if ((paramContext == null) || ((!ShortVideoUploadProcessor.class.isInstance(paramContext)) && (!ayuu.class.isInstance(paramContext)))) {
            break label672;
          }
          boolean bool = ((ayoz)paramContext).d();
          paramInt = localMessageForShortVideo.videoFileStatus;
          if ((!bool) && (paramInt != 1002) && (paramInt != 1001)) {
            break label672;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
          ((QQMessageFacade)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(20)).a(localMessageForShortVideo.istroop).d(localMessageForShortVideo);
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "", "", "", "");
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
          if (paramInt == 2131370598)
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
            axqw.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 2, 0, "", "", "", "");
            return;
          }
          super.a(paramInt, paramContext, paramChatMessage);
          return;
        }
      }
    }
  }
  
  public void a(adzr paramadzr)
  {
    if (a(paramadzr)) {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "disProgress...file is saving, so return!");
      }
    }
    do
    {
      return;
      if (!a(paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "disProgress fail...video order sending! " + paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return;
    if (!paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(8);
      return;
    }
    paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimRunnableListener(new adzl(this, paramadzr));
  }
  
  protected void a(adzr paramadzr, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 100)
    {
      paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(paramInt, paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
    for (;;)
    {
      paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVisibility(0);
      paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setVideoCompressStatus(false);
      paramadzr.c.setVisibility(8);
      return;
      paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(1);
      paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(paramInt, paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (adzr)actn.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo.isSendFromLocal())
    {
      bfol localbfol = (bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbfol.a(2131689995, 5);
      localbfol.c(2131690596);
      localbfol.a(new adzq(this, localMessageForShortVideo, paramView, localbfol));
      localbfol.show();
      if (localMessageForShortVideo.videoFileStatus == 1004) {
        ShortVideoUtils.c("0X800A374", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
    }
  }
  
  public void a(View paramView, ayqm paramayqm, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = (adzr)actn.a(paramView);
        paramView = (MessageForShortVideo)((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject2 = ((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView;
        if (paramView.uniseq != paramayqm.jdField_b_of_type_Long) {
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.e("ShortVideoItemBuilder", 2, "handleMessage getHolder error ! ", paramView);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "handleMessage msg.uniseq:" + paramView.uniseq + ",fileType:" + ShortVideoUtils.a(paramayqm.jdField_b_of_type_Int) + " ===> fileStatus:" + ShortVideoUtils.b(paramayqm.d));
      }
      paramInt2 = 0;
      paramInt1 = 0;
      if ((paramayqm.jdField_b_of_type_Int == 6) || (paramayqm.jdField_b_of_type_Int == 17) || (paramayqm.jdField_b_of_type_Int == 9) || (paramayqm.jdField_b_of_type_Int == 20)) {}
      switch (paramayqm.d)
      {
      default: 
      case 1001: 
        if (paramayqm.jdField_a_of_type_Long != 0L) {
          paramInt1 = (int)(100L * paramayqm.e / paramayqm.jdField_a_of_type_Long);
        }
        a((adzr)localObject1, ShortVideoUtils.a(paramInt1, 10), true);
        ((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        c((adzr)localObject1);
        return;
      case 1003: 
        a((adzr)localObject1, 100, true);
        b((adzr)localObject1);
        b((adzr)localObject1, false, null);
        axfg.a().a(((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1005: 
        b((adzr)localObject1);
        ((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        axfg.a().a(((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1004: 
        ((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.b(((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + ((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        b((adzr)localObject1);
        a((adzr)localObject1, true, this);
        axfg.a().a(((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1007: 
        b((adzr)localObject1);
        b((adzr)localObject1, false, null);
        axfg.a().a(((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        return;
      case 1002: 
        if (!paramView.isSendFromLocal()) {
          continue;
        }
        if (paramayqm.jdField_a_of_type_Long != 0L) {
          paramInt1 = (int)(100L * paramayqm.e / paramayqm.jdField_a_of_type_Long);
        }
        for (;;)
        {
          a((adzr)localObject1, ShortVideoUtils.a(paramInt1, 10), true);
          return;
          paramInt1 = paramInt2;
          if (QLog.isColorLevel())
          {
            QLog.e("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_SEND_PROCESS: fileSize == 0 ");
            paramInt1 = paramInt2;
          }
        }
      case 2001: 
        b((adzr)localObject1);
        ((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
        return;
      case 2003: 
        b((adzr)localObject1);
        if (b((adzr)localObject1)) {
          continue;
        }
        paramayqm = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
        if (bbdj.b(paramayqm)) {
          continue;
        }
        localObject1 = axdo.a(2, this.jdField_c_of_type_Int);
        localObject2 = paramView.getDownloadInfo(((axeg)localObject1).jdField_b_of_type_Int);
        ((axdr)localObject2).i = paramayqm;
        if ((paramView.istroop == 0) || (paramView.istroop == 1008)) {
          ((axdr)localObject2).e = 1002;
        }
        for (;;)
        {
          ((axeg)localObject1).a((axdr)localObject2);
          ((axeg)localObject1).a(paramView);
          axdo.a((axeg)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
          if (paramView.istroop == 3000) {
            ((axdr)localObject2).e = 1006;
          } else if (paramView.istroop == 1) {
            ((axdr)localObject2).e = 1004;
          }
        }
      case 2005: 
        b((adzr)localObject1);
        if (paramayqm.g == -5100528) {
          continue;
        }
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719585, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        return;
      case 5001: 
        a((adzr)localObject1, 2131718778);
        if (paramView.uiOperatorFlag == 2)
        {
          ((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719558, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          return;
        }
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719583, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        return;
      case 5002: 
        a((adzr)localObject1, 2131718779);
        if (paramView.uiOperatorFlag == 2)
        {
          ((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719559, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          return;
        }
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719584, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        return;
      case 2004: 
        b((adzr)localObject1);
        return;
      case 2002: 
        b((adzr)localObject1);
        a((adzr)localObject1);
        if ((paramayqm.c == null) || (!c(paramView)) || (b((adzr)localObject1)) || (b(paramView))) {
          continue;
        }
        localObject2 = paramayqm.c;
        paramayqm = paramayqm.u;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "handleMessage VIDEO ==> STATUS_RECV_PROCESS: domain=" + paramayqm + ", videoUrls=" + Arrays.toString((Object[])localObject2));
        }
        Object localObject3 = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
        int[] arrayOfInt = ShortVideoUtils.a(paramView.thumbWidth, paramView.thumbHeight);
        paramInt2 = arrayOfInt[0];
        int i = arrayOfInt[1];
        paramInt1 = 0;
        while (paramInt1 < 1)
        {
          if (!TextUtils.isEmpty(paramayqm)) {
            localObject2[paramInt1] = (localObject2[paramInt1] + "&txhost=" + paramayqm);
          }
          paramInt1 += 1;
        }
        a((adzr)localObject1, false, paramView, null, (String[])localObject2, (String)localObject3, paramInt2, i);
        if ((paramView.CheckIsHotVideo()) && (!bbbf.a().a(paramView, "0X8007EDB")))
        {
          bbbf.a().a(paramView, "0X8007EDB");
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
        }
        if (bbbf.a().a(paramView, "0X80077D9")) {
          continue;
        }
        paramInt1 = npx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        paramayqm = new JSONObject();
        try
        {
          paramayqm.put("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          paramayqm.put("memNum", paramInt1);
          paramayqm.put("msg_uniseq", paramView.uniseq);
          label1306:
          noo.a(null, "", "0X80077D9", "0X80077D9", 0, 0, "0", "", "0", npx.a(paramView.getMd5(), null, null, null, paramayqm), false);
          bbbf.a().a(paramView, "0X80077D9");
          return;
          if ((paramayqm.jdField_b_of_type_Int != 7) && (paramayqm.jdField_b_of_type_Int != 18) && (paramayqm.jdField_b_of_type_Int != 16)) {
            continue;
          }
          switch (paramayqm.d)
          {
          default: 
          case 2001: 
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("ShortVideoItemBuilder", 2, "handleMessage THUMB ==> STATUS_RECV_START:");
            return;
          case 2003: 
            paramayqm = ShortVideoUtils.a(paramView.thumbMD5, "jpg");
            localObject2 = ShortVideoUtils.a(paramView.thumbWidth, paramView.thumbHeight);
            paramInt2 = localObject2[0];
            i = localObject2[1];
            if ((!c(paramView)) || (b((adzr)localObject1)) || (b(paramView))) {
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
              if (bbev.h(this.jdField_a_of_type_AndroidContentContext))
              {
                localObject2 = axdo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, 2);
                if (localObject2 != null) {
                  axdo.a((axeg)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                }
              }
              a((adzr)localObject1, paramView, paramayqm, paramInt2, i, true);
              return;
              l1 = qua.a(8, paramView.videoFileTime, paramView.videoFileSize);
              break;
              paramInt1 = 1;
              continue;
              paramInt1 = 1;
            }
            if (paramView.videoFileTime <= 8) {}
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              a((adzr)localObject1, true, paramView, (String)localObject2, null, paramayqm, paramInt2, i);
              a((adzr)localObject1);
              if (paramInt1 == 0) {
                break;
              }
              ((adzr)localObject1).d.setVisibility(8);
              return;
            }
            ((adzr)localObject1).d.setVisibility(0);
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
            paramayqm = ShortVideoUtils.a(paramView.thumbWidth, paramView.thumbHeight);
            paramInt1 = paramayqm[0];
            paramInt2 = paramayqm[1];
            ((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(paramView.uniseq);
            ((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(a(paramInt1, paramInt2));
            a((adzr)localObject1, 2131718779);
            ((adzr)localObject1).d.setVisibility(8);
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
    adzr localadzr = a(paramMessageForShortVideo);
    if (localadzr == null) {
      return;
    }
    paramMessageForShortVideo = paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq;
    localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimProgress(ajyc.a(2131714062), paramMessageForShortVideo);
    localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramMessageForShortVideo, paramFloat);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "CompressUpdateListener,onFinish. seq = " + paramMessageForShortVideo.uniseq);
    }
    bfnh.a(new ShortVideoItemBuilder.4(this, paramMessageForShortVideo, paramInt));
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 998) {
      return;
    }
    if ((TextUtils.isEmpty(paramMessageForShortVideo.md5)) || (paramMessageForShortVideo.videoFileStatus == 1004))
    {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 2131719548, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      return;
    }
    String str = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    boolean bool2 = NetworkUtils.isMobileConnected(this.jdField_a_of_type_AndroidContentContext);
    if ((axdo.jdField_a_of_type_Long != 0L) && (System.currentTimeMillis() - axdo.jdField_a_of_type_Long < 300000L)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "startPlayVideo isConfirmed=" + bool1 + " allowPlayInXGTime=" + axdo.jdField_a_of_type_Long + " isXGConnected = " + bool2);
      }
      if ((!bool2) || (bool1) || ((bbdj.a(str)) && (paramMessageForShortVideo.videoFileStatus != 2002)) || (paramMessageForShortVideo.videoFileSize < 1048576)) {
        break label348;
      }
      if (!bcvm.a((Activity)this.jdField_a_of_type_AndroidContentContext, 3, new adzn(this, paramMessageForShortVideo, paramLong, paramBoolean))) {
        break;
      }
      str = this.jdField_a_of_type_AndroidContentContext.getString(2131718457);
      this.jdField_a_of_type_Bbgg = bbcv.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131718460), str, this.jdField_a_of_type_AndroidContentContext.getString(2131718458), this.jdField_a_of_type_AndroidContentContext.getString(2131718459), new adzo(this, paramMessageForShortVideo, paramLong, paramBoolean), new adzp(this));
      paramMessageForShortVideo = asee.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, str);
      if ((paramMessageForShortVideo instanceof SpannableString)) {
        this.jdField_a_of_type_Bbgg.setMessageWithoutAutoLink(paramMessageForShortVideo);
      }
      try
      {
        this.jdField_a_of_type_Bbgg.show();
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
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, adzr paramadzr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "startUploadVideo：" + paramMessageForShortVideo.toString());
    }
    boolean bool = paramMessageForShortVideo.CheckIsHotVideo();
    String str1 = paramMessageForShortVideo.videoFileName;
    String str2 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if ((!bbdj.b(str1)) && (!bool))
    {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719590, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      b(paramadzr);
      paramadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if ((!bbdj.b(str2)) && (!bool))
    {
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719591, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      b(paramadzr);
      paramadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((awan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    paramadzr = axdo.a(1, this.jdField_c_of_type_Int);
    paramMessageForShortVideo = axdo.a(this.jdField_c_of_type_Int, paramMessageForShortVideo, paramadzr);
    paramMessageForShortVideo.e = bool;
    paramadzr.a(paramMessageForShortVideo);
    axdo.a(paramadzr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    adzr localadzr = a(paramMessageForShortVideo);
    if (localadzr == null) {
      return;
    }
    bfnh.a(new ShortVideoItemBuilder.3(this, paramMessageForShortVideo, paramBoolean, localadzr));
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
  
  public bblt[] a(View paramView)
  {
    paramView = (adzr)actn.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    bblr localbblr = new bblr();
    if (localMessageForShortVideo != null)
    {
      if (!localMessageForShortVideo.isMultiMsg) {
        break label48;
      }
      a(localbblr, localMessageForShortVideo, paramView);
    }
    for (;;)
    {
      return localbblr.a();
      label48:
      b(localbblr, localMessageForShortVideo, paramView);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public bblr b(bblr parambblr, ChatMessage paramChatMessage, acve paramacve)
  {
    boolean bool3 = false;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    adzr localadzr = (adzr)paramacve;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "getMenuItem, msg.uniseq:" + localMessageForShortVideo.uniseq + ",fileType===>" + ShortVideoUtils.a(localMessageForShortVideo.fileType) + " ===> fileStatus:" + ShortVideoUtils.b(localMessageForShortVideo.videoFileStatus));
    }
    b(parambblr, this.jdField_a_of_type_AndroidContentContext);
    int i;
    boolean bool1;
    label226:
    boolean bool2;
    if ((localMessageForShortVideo != null) && (!TextUtils.isEmpty(localMessageForShortVideo.md5)))
    {
      paramacve = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (bbdj.b(paramacve))
      {
        paramacve = "";
        i = 1;
        if (i == 0) {
          break label574;
        }
        if (!"1".equals(DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.shortvideo_forward_switch.name(), "1"))) {
          break label561;
        }
        boolean bool4 = localMessageForShortVideo.checkForward();
        if ((localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView == null) || (!localadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(localadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + localadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))) {
          break label568;
        }
        bool1 = true;
        bool2 = bool3;
        if (localadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null)
        {
          bool2 = bool3;
          if (localadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0) {
            bool2 = true;
          }
        }
        if ((!bool4) || (bool1) || (bool2)) {
          break label521;
        }
        parambblr.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692752), 2130838606);
        paramacve = paramacve + "inMiddleStatus = false, progeressBarShowing = false, errorIconShowing = false, show forward menu.";
      }
    }
    label521:
    label561:
    label568:
    label574:
    for (;;)
    {
      a(localMessageForShortVideo, parambblr);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "getMenuItem: " + paramacve);
      }
      if ((localMessageForShortVideo != null) && ((localadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (localadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0))) {
        a(parambblr, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForShortVideo);
      }
      a(parambblr, localMessageForShortVideo);
      if ((localMessageForShortVideo != null) && (bbdj.b(ShortVideoUtils.a(localMessageForShortVideo, "mp4")))) {
        parambblr.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692324), 2130838605);
      }
      b(paramChatMessage, parambblr);
      super.c(parambblr, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambblr, this.jdField_a_of_type_AndroidContentContext);
      this.f = true;
      return parambblr;
      paramacve = "thumbFilePath=" + paramacve + " , not exits.";
      i = 0;
      break;
      paramacve = " msg == null or md5 is empty.";
      i = 0;
      break;
      paramacve = paramacve + "progeressBarShowing=" + bool1 + ", errorIconShowing=" + bool2;
      continue;
      paramacve = " not inDPCWhiteList.";
      continue;
      bool1 = false;
      break label226;
    }
  }
  
  protected void b(adzr paramadzr)
  {
    if (a(paramadzr)) {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoItemBuilder", 2, "hideProgress...file is saving, so return!");
      }
    }
    do
    {
      return;
      if (!a(paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ShortVideoItemBuilder", 2, "hideProgress fail...video order sending! " + paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    return;
    paramadzr.c.setVisibility(8);
    if (!paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.a(paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadzr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setDrawStatus(2);
      return;
    }
    paramadzr.jdField_a_of_type_ComTencentMobileqqCustomviewsVideoProgressView.setAnimRunnableListener(new adzi(this, paramadzr));
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
    aqbc.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
    axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "1", "", "");
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, long paramLong, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("muate_play", paramBoolean);
    a(paramMessageForShortVideo, paramLong, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localBundle, null);
    ThreadManager.getFileThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void b(MessageForShortVideo paramMessageForShortVideo, adzr paramadzr)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "reForwardVideo：" + paramMessageForShortVideo.toString());
      }
      if (!bbdj.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
      {
        bcpw.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719591, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        b(paramadzr);
        paramadzr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        paramMessageForShortVideo.videoFileStatus = 1005;
        return;
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
      {
        ((awan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
        paramadzr = axdo.a(4, this.jdField_c_of_type_Int);
        paramadzr.a(axdo.a(this.jdField_c_of_type_Int, paramMessageForShortVideo, paramadzr));
        axdo.a(paramadzr, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    Object localObject1 = (adzr)actn.a(paramView);
    jdField_a_of_type_AndroidGraphicsRect = a(paramView, (MessageForShortVideo)((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    actn.n = true;
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
          if ((paramView.getId() == 2131364110) || (paramView.getId() == 2131364152))
          {
            a((adzr)localObject1, false);
            return;
          }
        } while (paramView.getId() != 2131364129);
        paramView = new StringBuilder();
      } while (((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if ((!(localObject2 instanceof ShortVideoUploadProcessor)) || (!((ShortVideoUploadProcessor)localObject2).g)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoItemBuilder", 2, "CompressTask pauseOperator!");
    return;
    Object localObject2 = axfg.a().a(((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
    if (localObject2 != null)
    {
      ((axfh)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.isPause = true;
      boolean bool = ((axfh)localObject2).cancel(true);
      paramView.append("\n ShortVideoItemBuilder task cancel:").append(bool);
      paramView.append("\n md5 info:").append(((MessageForShortVideo)((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).md5);
      if ((bool) && (((MessageForShortVideo)((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage).md5 == null))
      {
        bool = ((axfh)localObject2).a();
        paramView.append("\n media codec cancel:").append(bool);
        if (!bool) {
          break label424;
        }
        paramView.append("\n ffmpeg process cancel!");
      }
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((adzr)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
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
 * Qualified Name:     adzh
 * JD-Core Version:    0.7.0.1
 */