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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.2;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.3;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.6;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.PAVideoView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.NewIntent;
import org.json.JSONObject;

public class agrl
  extends BaseBubbleBuilder
{
  public agrp a;
  protected Drawable a;
  public View.OnClickListener a;
  protected bgoj a;
  protected vmu a;
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
  
  public agrl(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = 15.0F;
    this.jdField_a_of_type_Vmu = new vmu();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new agrm(this);
    this.jdField_a_of_type_Agrp = new agro(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    float f1 = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 15.0F);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f1, f1, f1 };
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#00000000"));
    this.e = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 135.0F);
    this.jdField_f_of_type_Int = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 19.0F);
    this.c = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 137.0F);
    this.d = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 218.0F);
    this.g = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 7.0F);
    paramBaseAdapter = (vna)vux.a(6);
    if (!paramBaseAdapter.a())
    {
      paramBaseAdapter.c();
      this.jdField_f_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Bgoj = ((bgog)paramQQAppInterface.getManager(47)).a(1);
    this.jdField_a_of_type_Vmu.a(this.jdField_a_of_type_Agrp);
    ShortVideoUtils.ShortVideoPlayConfig.initConfig();
  }
  
  private void a(agrq paramagrq, long paramLong, boolean paramBoolean)
  {
    paramagrq.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView = ((CropBubbleVideoView)azjm.a(this.jdField_b_of_type_AndroidContentContext, paramLong, null, paramBoolean));
    a(paramagrq.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.c, this.d);
    paramagrq.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setFocusable(false);
    paramagrq.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setFocusableInTouchMode(false);
    paramagrq.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setClickable(false);
    paramagrq.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramagrq.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, 0);
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
      this.c = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 218.0F);
      this.d = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 137.0F);
      return;
    }
    this.c = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 137.0F);
    this.d = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 218.0F);
  }
  
  private void a(CropBubbleVideoView paramCropBubbleVideoView, int paramInt1, int paramInt2)
  {
    paramCropBubbleVideoView.setLayoutParams(new RelativeLayout.LayoutParams(paramInt1, paramInt2));
  }
  
  private void c(agrq paramagrq)
  {
    paramagrq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramagrq.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363700));
    paramagrq.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
    paramagrq.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
  }
  
  private void d(agrq paramagrq)
  {
    paramagrq.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)paramagrq.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380611));
    paramagrq.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
    paramagrq.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
    paramagrq.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(true);
    paramagrq.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(1);
  }
  
  private void e(agrq paramagrq)
  {
    paramagrq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramagrq.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370610));
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
    localGradientDrawable.setShape(0);
    float f1 = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 15.0F);
    localGradientDrawable.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
    localGradientDrawable.setGradientType(0);
    paramagrq.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localGradientDrawable);
  }
  
  private void f(agrq paramagrq)
  {
    int i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296391);
    int j = this.c;
    int k = BaseChatItemLayout.k;
    int m = this.d;
    int n = BaseChatItemLayout.h;
    int i1 = this.g;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramagrq.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.width = (j + k + i);
    localLayoutParams.height = (i1 + (m + n));
    paramagrq.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aezf a()
  {
    return new agrq();
  }
  
  public Drawable a(String paramString)
  {
    aqww localaqww2 = PAVideoView.a;
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
      aqww localaqww1 = localaqww2;
    } while (!QLog.isColorLevel());
    QLog.e("TribeShortVideoItemBuilder", 2, "getCoverDrawable():  coverUrl=" + paramString);
    return localaqww2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afce paramafce)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafce);
    a(paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    boolean bool = paramChatMessage.isSend();
    paramaezf = (agrq)paramaezf;
    a((MessageForTribeShortVideo)paramChatMessage);
    int i;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131558856, paramBaseChatItemLayout, false);
      paramaezf.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364441));
      c(paramaezf);
      a(paramaezf, paramChatMessage.uniseq, bool);
      e(paramaezf);
      d(paramaezf);
      f(paramaezf);
      paramaezf.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setOnLongClickListener(paramafce);
      paramView.setOnTouchListener(paramafce);
      paramaezf.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setKey(paramChatMessage.frienduin + paramChatMessage.uniseq);
      paramaezf.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(bool);
      i = DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, paramaezf.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth());
      if (paramaezf.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend != bool)
      {
        paramaezf.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend = bool;
        paramaezf.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.invalidate();
      }
      if (bool) {
        break label305;
      }
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramaezf.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramaezf.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramaezf.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramaezf.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatItemLayout);
    }
    for (;;)
    {
      a(paramaezf, paramChatMessage.uniseq, (MessageForTribeShortVideo)paramChatMessage, false);
      return paramView;
      a(paramaezf.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.c, this.d);
      f(paramaezf);
      break;
      label305:
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramaezf.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramaezf.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramaezf.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramaezf.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatItemLayout);
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
      acvv.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
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
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      atky.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
      return;
      super.a(paramChatMessage);
      return;
      super.d(paramChatMessage);
    }
  }
  
  protected void a(agrq paramagrq)
  {
    try
    {
      paramagrq = (MessageForTribeShortVideo)paramagrq.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick:" + paramagrq.toString());
      }
      Intent localIntent = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramagrq.jumpUrl);
      this.jdField_b_of_type_AndroidContentContext.startActivity(localIntent);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "clk_obj", 0, 0, paramagrq.bid, paramagrq.pid, "", "");
      return;
    }
    catch (Exception paramagrq)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick exp :", paramagrq);
    }
  }
  
  public void a(agrq paramagrq, long paramLong)
  {
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.6(this, paramagrq, paramLong));
  }
  
  public void a(agrq paramagrq, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramagrq.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!bfth.a().a(paramagrq.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "video_play"))
    {
      bfth.a().a(paramagrq.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "video_play");
      if ((paramagrq.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTribeShortVideo))
      {
        paramString2 = (MessageForTribeShortVideo)paramagrq.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "video_play", 0, 0, paramString2.bid, paramString2.pid, "", "");
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
        paramagrq = Integer.valueOf(0);
        paramString1.put("pid", paramagrq);
        if (!TextUtils.isEmpty(paramString2.themeName)) {
          paramString1.put("theme_id", paramString2.themeName);
        }
      }
      catch (Exception paramagrq)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TribeShortVideoItemBuilder", 2, "request cgi params is wrong!");
        continue;
      }
      paramagrq = new NewIntent(this.jdField_b_of_type_AndroidContentContext, nma.class);
      paramagrq.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.publish_post");
      paramString2 = new WebSsoBody.WebSsoRequestBody();
      paramString2.type.set(0);
      paramString2.data.set(paramString1.toString());
      paramagrq.putExtra("data", paramString2.toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramagrq);
      return;
      paramLong = Long.parseLong(paramString2.bid);
      continue;
      paramagrq = paramString2.pid;
    }
  }
  
  public void a(agrq paramagrq, long paramLong, MessageForTribeShortVideo paramMessageForTribeShortVideo, boolean paramBoolean)
  {
    Object localObject = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_SHORTVIDEO_SAVE + paramMessageForTribeShortVideo.mVid + ".mp4"));
    if (((File)localObject).exists())
    {
      if ((this.jdField_b_of_type_AndroidContentContext instanceof Activity))
      {
        localObject = ((File)localObject).getAbsolutePath();
        ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.2(this, (String)localObject, paramagrq, paramLong, paramMessageForTribeShortVideo));
      }
      return;
    }
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.3(this, paramagrq));
    if (QLog.isColorLevel()) {
      QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder handleGetVideo 1: download");
    }
    a(paramMessageForTribeShortVideo, paramagrq);
  }
  
  protected void a(agrq paramagrq, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramagrq.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
    Object localObject1 = new TextView(this.jdField_b_of_type_AndroidContentContext);
    ((TextView)localObject1).setBackgroundResource(2130842626);
    Object localObject2 = this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130846300);
    ((Drawable)localObject2).setBounds(0, 0, 36, 36);
    ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
    ((TextView)localObject1).setCompoundDrawablePadding(5);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    ((TextView)localObject1).setTextColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131167337));
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setGravity(16);
    ((TextView)localObject1).setPadding(DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0, DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0);
    paramagrq.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject2 = new FrameLayout.LayoutParams(-2, -2);
    paramagrq.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    paramagrq.b = ((TextView)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131364441);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131364441);
    paramViewGroup.addView(paramagrq.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject1);
  }
  
  @SuppressLint({"SetTextI18n"})
  protected void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    localMessageForTribeShortVideo.parse();
    agrq localagrq = (agrq)paramViewGroup.getTag();
    boolean bool = localMessageForTribeShortVideo.isSend();
    if (localagrq.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      a(localagrq, paramViewGroup, bool);
    }
    paramViewGroup = (FrameLayout.LayoutParams)localagrq.b.getLayoutParams();
    if (bool)
    {
      paramViewGroup.leftMargin = BaseChatItemLayout.k;
      localagrq.b.setLayoutParams(paramViewGroup);
      if (TextUtils.isEmpty(localMessageForTribeShortVideo.themeName)) {
        break label297;
      }
      localagrq.jdField_a_of_type_AndroidWidgetTextView.setText("#" + localMessageForTribeShortVideo.themeName);
      localagrq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label126:
      if (TextUtils.isEmpty(localMessageForTribeShortVideo.srcName)) {
        break label384;
      }
      if (localMessageForTribeShortVideo.srcName.length() <= 5) {
        break label346;
      }
      localagrq.b.setText(localMessageForTribeShortVideo.srcName.substring(0, 5) + amtj.a(2131714107));
      label189:
      localagrq.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(paramChatMessage.isSend());
      if ((!TextUtils.isEmpty(localMessageForTribeShortVideo.mVid)) && (ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO)) {
        break label414;
      }
      localagrq.jdField_a_of_type_Boolean = false;
      localagrq.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localagrq.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localagrq.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getCoverImage(), localMessageForTribeShortVideo.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    label297:
    label346:
    do
    {
      return;
      paramViewGroup.leftMargin = (DisplayUtil.dip2px(this.jdField_b_of_type_AndroidContentContext, localagrq.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth()) + BaseChatItemLayout.j);
      break;
      if (!TextUtils.isEmpty(localMessageForTribeShortVideo.brief))
      {
        localagrq.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTribeShortVideo.brief);
        localagrq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        break label126;
      }
      localagrq.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label126;
      localagrq.b.setText(localMessageForTribeShortVideo.srcName + amtj.a(2131714108));
      break label189;
      localagrq.b.setText(this.jdField_b_of_type_AndroidContentContext.getString(2131719732));
      localagrq.b.setOnClickListener(null);
      break label189;
      paramViewGroup = (Long)localagrq.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTag();
    } while ((paramViewGroup != null) && (paramViewGroup.longValue() == localMessageForTribeShortVideo.uniseq));
    label384:
    label414:
    localagrq.jdField_a_of_type_Boolean = false;
    a(localagrq.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getCoverImage(), localMessageForTribeShortVideo.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    a(localagrq, localMessageForTribeShortVideo.uniseq, localMessageForTribeShortVideo, false);
    localagrq.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setTag(Long.valueOf(localMessageForTribeShortVideo.uniseq));
  }
  
  protected void a(MessageForTribeShortVideo paramMessageForTribeShortVideo, agrq paramagrq)
  {
    Object localObject1 = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_SHORTVIDEO_SAVE));
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = AppConstants.SDCARD_SHORTVIDEO_SAVE + paramMessageForTribeShortVideo.mVid + ".mp4";
    Object localObject2 = new File(VFSAssistantUtils.getSDKPrivatePath((String)localObject1));
    localObject2 = new bgoe(paramMessageForTribeShortVideo.videoUrl, (File)localObject2);
    ((bgoe)localObject2).jdField_b_of_type_Int = 2;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject1);
    this.jdField_a_of_type_Bgoj.a((bgoe)localObject2, new agrn(this, paramagrq, paramMessageForTribeShortVideo), localBundle);
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
    paramString1.mSceneName = azjn.a(111);
    paramCropBubbleVideoView.setVideoParam(paramString1);
    paramCropBubbleVideoView.play();
  }
  
  public bgbb[] a(View paramView)
  {
    bgaz localbgaz = new bgaz();
    paramView = AIOUtils.getMessage(paramView);
    if (bfat.a(paramView) == null) {}
    localbgaz.a(2131367094, this.jdField_b_of_type_AndroidContentContext.getString(2131692448), 2130838971);
    if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
      a(localbgaz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView);
    }
    a(localbgaz, paramView);
    c(localbgaz, this.jdField_b_of_type_AndroidContentContext);
    super.e(localbgaz, this.jdField_b_of_type_AndroidContentContext);
    return localbgaz.a();
  }
  
  protected void b(agrq paramagrq)
  {
    try
    {
      paramagrq = (MessageForTribeShortVideo)paramagrq.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick:" + paramagrq.toString());
      }
      Intent localIntent = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("isOpeningQunApp", false);
      localIntent.putExtra("url", paramagrq.sourceJumpUrl);
      this.jdField_b_of_type_AndroidContentContext.startActivity(localIntent);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "Clk_tail", 0, 0, paramagrq.bid, paramagrq.pid, "", "");
      return;
    }
    catch (Exception paramagrq)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick exp :", paramagrq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrl
 * JD-Core Version:    0.7.0.1
 */