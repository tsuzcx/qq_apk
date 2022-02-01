import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.2;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.3;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.6;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class ahln
  extends BaseBubbleBuilder
{
  public ahlr a;
  protected Drawable a;
  public View.OnClickListener a;
  protected bhhk a;
  protected wha a;
  protected float[] a;
  protected final float b;
  protected Context b;
  protected Drawable b;
  public int c;
  public int d;
  protected int e;
  protected int f;
  protected boolean f;
  protected int g;
  
  public ahln(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = 15.0F;
    this.jdField_a_of_type_Wha = new wha();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahlo(this);
    this.jdField_a_of_type_Ahlr = new ahlq(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    float f1 = bggq.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f1, f1, f1 };
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#00000000"));
    this.e = bggq.a(this.jdField_b_of_type_AndroidContentContext, 135.0F);
    this.jdField_f_of_type_Int = bggq.a(this.jdField_b_of_type_AndroidContentContext, 19.0F);
    this.c = bggq.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
    this.d = bggq.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
    this.g = bggq.a(this.jdField_b_of_type_AndroidContentContext, 7.0F);
    paramBaseAdapter = (whg)wpm.a(6);
    if (!paramBaseAdapter.a())
    {
      paramBaseAdapter.c();
      this.jdField_f_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Bhhk = ((bhhh)paramQQAppInterface.getManager(47)).a(1);
    this.jdField_a_of_type_Wha.a(this.jdField_a_of_type_Ahlr);
    bcfp.a();
  }
  
  private void a(ahls paramahls, long paramLong, boolean paramBoolean)
  {
    paramahls.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView = ((CropBubbleVideoView)azwr.a(this.jdField_b_of_type_AndroidContentContext, paramLong, null, paramBoolean));
    a(paramahls.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.c, this.d);
    paramahls.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setFocusable(false);
    paramahls.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setFocusableInTouchMode(false);
    paramahls.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setClickable(false);
    paramahls.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramahls.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, 0);
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    try
    {
      paramImageView.setImageDrawable(paramDrawable);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramString.getStatus() == 2) {
        paramString.restartDownload();
      }
      paramImageView.setImageDrawable(paramString);
      return;
    }
    catch (Exception paramImageView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "setImageUrl exp: " + paramImageView.toString());
    }
  }
  
  private void a(MessageForTribeShortVideo paramMessageForTribeShortVideo)
  {
    if (paramMessageForTribeShortVideo.videoWidth > paramMessageForTribeShortVideo.videoHeight)
    {
      this.c = bggq.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
      this.d = bggq.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
      return;
    }
    this.c = bggq.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
    this.d = bggq.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
  }
  
  private void a(CropBubbleVideoView paramCropBubbleVideoView, int paramInt1, int paramInt2)
  {
    paramCropBubbleVideoView.setLayoutParams(new RelativeLayout.LayoutParams(paramInt1, paramInt2));
  }
  
  private void c(ahls paramahls)
  {
    paramahls.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramahls.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363645));
    paramahls.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
    paramahls.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
  }
  
  private void d(ahls paramahls)
  {
    paramahls.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)paramahls.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380707));
    paramahls.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
    paramahls.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
    paramahls.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(true);
    paramahls.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(1);
  }
  
  private void e(ahls paramahls)
  {
    paramahls.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramahls.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370538));
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
    localGradientDrawable.setShape(0);
    float f1 = bggq.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
    localGradientDrawable.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
    localGradientDrawable.setGradientType(0);
    paramahls.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localGradientDrawable);
  }
  
  private void f(ahls paramahls)
  {
    int i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296334);
    int j = this.c;
    int k = BaseChatItemLayout.k;
    int m = this.d;
    int n = BaseChatItemLayout.h;
    int i1 = this.g;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramahls.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.width = (j + k + i);
    localLayoutParams.height = (i1 + (m + n));
    paramahls.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afwr a()
  {
    return new ahls();
  }
  
  public Drawable a(String paramString)
  {
    arnj localarnj2 = PAVideoView.a;
    if (!TextUtils.isEmpty(paramString)) {}
    do
    {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, PAVideoView.a, PAVideoView.a);
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TribeShortVideoItemBuilder", 2, "getCoverDrawable():  getDrawable Exception, coverUrl=" + paramString, localException);
        }
        return PAVideoView.a;
      }
      arnj localarnj1 = localarnj2;
    } while (!QLog.isColorLevel());
    QLog.e("TribeShortVideoItemBuilder", 2, "getCoverDrawable():  coverUrl=" + paramString);
    return localarnj2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afzq paramafzq)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafzq);
    a(paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    boolean bool = paramChatMessage.isSend();
    paramafwr = (ahls)paramafwr;
    a((MessageForTribeShortVideo)paramChatMessage);
    int i;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131558850, paramBaseChatItemLayout, false);
      paramafwr.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364379));
      c(paramafwr);
      a(paramafwr, paramChatMessage.uniseq, bool);
      e(paramafwr);
      d(paramafwr);
      f(paramafwr);
      paramafwr.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setOnLongClickListener(paramafzq);
      paramView.setOnTouchListener(paramafzq);
      paramafwr.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setKey(paramChatMessage.frienduin + paramChatMessage.uniseq);
      paramafwr.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(bool);
      i = bggq.a(this.jdField_b_of_type_AndroidContentContext, paramafwr.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth());
      if (paramafwr.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend != bool)
      {
        paramafwr.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend = bool;
        paramafwr.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.invalidate();
      }
      if (bool) {
        break label305;
      }
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramafwr.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramafwr.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramafwr.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramafwr.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatItemLayout);
    }
    for (;;)
    {
      a(paramafwr, paramChatMessage.uniseq, (MessageForTribeShortVideo)paramChatMessage, false);
      return paramView;
      a(paramafwr.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.c, this.d);
      f(paramafwr);
      break;
      label305:
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramafwr.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramafwr.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramafwr.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramafwr.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatItemLayout);
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForTribeShortVideo))
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
      adrm.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
      paramContext = new Bundle();
      if ((localMessageForTribeShortVideo.structingMsg.source_puin != null) && (!"".equals(localMessageForTribeShortVideo.structingMsg.source_puin))) {
        paramContext.putString("source_puin", localMessageForTribeShortVideo.structingMsg.source_puin);
      }
      paramContext.putInt("forward_type", 36);
      localMessageForTribeShortVideo.structingMsg.mCommentText = null;
      paramContext.putInt("structmsg_service_id", localMessageForTribeShortVideo.structingMsg.mMsgServiceID);
      paramContext.putByteArray("stuctmsg_bytes", localMessageForTribeShortVideo.structingMsg.getBytes());
      paramContext.putLong("structmsg_uniseq", localMessageForTribeShortVideo.uniseq);
      paramContext.putString("qqtribeVideoInfoExtra ", localMessageForTribeShortVideo.structingMsg.mTribeShortVideoExtra);
      paramContext.putInt("accostType", localMessageForTribeShortVideo.structingMsg.sourceAccoutType);
      paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      aufz.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
      return;
      super.a(paramChatMessage);
      return;
      super.d(paramChatMessage);
    }
  }
  
  protected void a(ahls paramahls)
  {
    try
    {
      paramahls = (MessageForTribeShortVideo)paramahls.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick:" + paramahls.toString());
      }
      Intent localIntent = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramahls.jumpUrl);
      this.jdField_b_of_type_AndroidContentContext.startActivity(localIntent);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "clk_obj", 0, 0, paramahls.bid, paramahls.pid, "", "");
      return;
    }
    catch (Exception paramahls)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick exp :", paramahls);
    }
  }
  
  public void a(ahls paramahls, long paramLong)
  {
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.6(this, paramahls, paramLong));
  }
  
  public void a(ahls paramahls, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramahls.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!bgjy.a().a(paramahls.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "video_play"))
    {
      bgjy.a().a(paramahls.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "video_play");
      if ((paramahls.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTribeShortVideo))
      {
        paramString2 = (MessageForTribeShortVideo)paramahls.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "video_play", 0, 0, paramString2.bid, paramString2.pid, "", "");
        paramString1 = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString2.bid)) {
          continue;
        }
        paramLong = 0L;
        paramString1.put("bid", paramLong);
        if (!TextUtils.isEmpty(paramString2.pid)) {
          continue;
        }
        paramahls = Integer.valueOf(0);
        paramString1.put("pid", paramahls);
        if (!TextUtils.isEmpty(paramString2.themeName)) {
          paramString1.put("theme_id", paramString2.themeName);
        }
      }
      catch (Exception paramahls)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TribeShortVideoItemBuilder", 2, "request cgi params is wrong!");
        continue;
      }
      paramahls = new NewIntent(this.jdField_b_of_type_AndroidContentContext, niq.class);
      paramahls.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.publish_post");
      paramString2 = new WebSsoBody.WebSsoRequestBody();
      paramString2.type.set(0);
      paramString2.data.set(paramString1.toString());
      paramahls.putExtra("data", paramString2.toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramahls);
      return;
      paramLong = Long.parseLong(paramString2.bid);
      continue;
      paramahls = paramString2.pid;
    }
  }
  
  public void a(ahls paramahls, long paramLong, MessageForTribeShortVideo paramMessageForTribeShortVideo, boolean paramBoolean)
  {
    Object localObject = new File(bhgg.a(anhk.bj + paramMessageForTribeShortVideo.mVid + ".mp4"));
    if (((File)localObject).exists())
    {
      if ((this.jdField_b_of_type_AndroidContentContext instanceof Activity))
      {
        localObject = ((File)localObject).getAbsolutePath();
        ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.2(this, (String)localObject, paramahls, paramLong, paramMessageForTribeShortVideo));
      }
      return;
    }
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.3(this, paramahls));
    if (QLog.isColorLevel()) {
      QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder handleGetVideo 1: download");
    }
    a(paramMessageForTribeShortVideo, paramahls);
  }
  
  protected void a(ahls paramahls, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramahls.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
    Object localObject1 = new TextView(this.jdField_b_of_type_AndroidContentContext);
    ((TextView)localObject1).setBackgroundResource(2130842568);
    Object localObject2 = this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130846375);
    ((Drawable)localObject2).setBounds(0, 0, 36, 36);
    ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
    ((TextView)localObject1).setCompoundDrawablePadding(5);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    ((TextView)localObject1).setTextColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131167279));
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setGravity(16);
    ((TextView)localObject1).setPadding(bggq.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0, bggq.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0);
    paramahls.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject2 = new FrameLayout.LayoutParams(-2, -2);
    paramahls.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    paramahls.b = ((TextView)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131364379);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131364379);
    paramViewGroup.addView(paramahls.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject1);
  }
  
  @SuppressLint({"SetTextI18n"})
  protected void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    localMessageForTribeShortVideo.parse();
    ahls localahls = (ahls)paramViewGroup.getTag();
    boolean bool = localMessageForTribeShortVideo.isSend();
    if (localahls.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      a(localahls, paramViewGroup, bool);
    }
    paramViewGroup = (FrameLayout.LayoutParams)localahls.b.getLayoutParams();
    if (bool)
    {
      paramViewGroup.leftMargin = BaseChatItemLayout.k;
      localahls.b.setLayoutParams(paramViewGroup);
      if (TextUtils.isEmpty(localMessageForTribeShortVideo.themeName)) {
        break label297;
      }
      localahls.jdField_a_of_type_AndroidWidgetTextView.setText("#" + localMessageForTribeShortVideo.themeName);
      localahls.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label126:
      if (TextUtils.isEmpty(localMessageForTribeShortVideo.srcName)) {
        break label384;
      }
      if (localMessageForTribeShortVideo.srcName.length() <= 5) {
        break label346;
      }
      localahls.b.setText(localMessageForTribeShortVideo.srcName.substring(0, 5) + anni.a(2131713766));
      label189:
      localahls.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(paramChatMessage.isSend());
      if ((!TextUtils.isEmpty(localMessageForTribeShortVideo.mVid)) && (bcfp.b)) {
        break label414;
      }
      localahls.jdField_a_of_type_Boolean = false;
      localahls.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localahls.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localahls.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getCoverImage(), localMessageForTribeShortVideo.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    label297:
    label346:
    do
    {
      return;
      paramViewGroup.leftMargin = (bggq.a(this.jdField_b_of_type_AndroidContentContext, localahls.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth()) + BaseChatItemLayout.j);
      break;
      if (!TextUtils.isEmpty(localMessageForTribeShortVideo.brief))
      {
        localahls.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTribeShortVideo.brief);
        localahls.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        break label126;
      }
      localahls.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label126;
      localahls.b.setText(localMessageForTribeShortVideo.srcName + anni.a(2131713767));
      break label189;
      localahls.b.setText(this.jdField_b_of_type_AndroidContentContext.getString(2131719209));
      localahls.b.setOnClickListener(null);
      break label189;
      paramViewGroup = (Long)localahls.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTag();
    } while ((paramViewGroup != null) && (paramViewGroup.longValue() == localMessageForTribeShortVideo.uniseq));
    label384:
    label414:
    localahls.jdField_a_of_type_Boolean = false;
    a(localahls.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getCoverImage(), localMessageForTribeShortVideo.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    a(localahls, localMessageForTribeShortVideo.uniseq, localMessageForTribeShortVideo, false);
    localahls.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setTag(Long.valueOf(localMessageForTribeShortVideo.uniseq));
  }
  
  protected void a(MessageForTribeShortVideo paramMessageForTribeShortVideo, ahls paramahls)
  {
    Object localObject1 = new File(bhgg.a(anhk.bj));
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = anhk.bj + paramMessageForTribeShortVideo.mVid + ".mp4";
    Object localObject2 = new File(bhgg.a((String)localObject1));
    localObject2 = new bhhf(paramMessageForTribeShortVideo.videoUrl, (File)localObject2);
    ((bhhf)localObject2).jdField_b_of_type_Int = 2;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject1);
    this.jdField_a_of_type_Bhhk.a((bhhf)localObject2, new ahlp(this, paramahls, paramMessageForTribeShortVideo), localBundle);
  }
  
  public void a(CropBubbleVideoView paramCropBubbleVideoView, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramCropBubbleVideoView, paramInt1, paramInt2);
    paramCropBubbleVideoView.setCoverDrawable(a(paramString1));
    paramString1 = new VideoPlayParam();
    paramString1.mVideoPath = paramString2;
    paramString1.mUrls = new String[] { PAVideoView.a(paramLong) };
    paramString1.mIsLocal = true;
    paramString1.mIsLoop = true;
    paramString1.mIsMute = true;
    paramString1.mSceneId = 111;
    paramString1.mSceneName = azws.a(111);
    paramCropBubbleVideoView.setVideoParam(paramString1);
    paramCropBubbleVideoView.play();
  }
  
  public bguj[] a(View paramView)
  {
    bguh localbguh = new bguh();
    paramView = afur.a(paramView);
    if (bfre.a(paramView) == null) {}
    localbguh.a(2131367027, this.jdField_b_of_type_AndroidContentContext.getString(2131692395), 2130838929);
    if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
      a(localbguh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
    }
    a(localbguh, paramView);
    c(localbguh, this.jdField_b_of_type_AndroidContentContext);
    super.e(localbguh, this.jdField_b_of_type_AndroidContentContext);
    return localbguh.a();
  }
  
  protected void b(ahls paramahls)
  {
    try
    {
      paramahls = (MessageForTribeShortVideo)paramahls.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick:" + paramahls.toString());
      }
      Intent localIntent = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("isOpeningQunApp", false);
      localIntent.putExtra("url", paramahls.sourceJumpUrl);
      this.jdField_b_of_type_AndroidContentContext.startActivity(localIntent);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "Clk_tail", 0, 0, paramahls.bid, paramahls.pid, "", "");
      return;
    }
    catch (Exception paramahls)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick exp :", paramahls);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahln
 * JD-Core Version:    0.7.0.1
 */