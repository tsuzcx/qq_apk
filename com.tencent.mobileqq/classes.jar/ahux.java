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

public class ahux
  extends BaseBubbleBuilder
{
  public ahvb a;
  protected Drawable a;
  public View.OnClickListener a;
  protected bihz a;
  protected wkv a;
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
  
  public ahux(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = 15.0F;
    this.jdField_a_of_type_Wkv = new wkv();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahuy(this);
    this.jdField_a_of_type_Ahvb = new ahva(this);
    this.jdField_b_of_type_AndroidContentContext = paramContext;
    float f1 = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f1, f1, f1 };
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#e1e1e5"));
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#00000000"));
    this.e = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 135.0F);
    this.jdField_f_of_type_Int = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 19.0F);
    this.c = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
    this.d = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
    this.g = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 7.0F);
    paramBaseAdapter = (wlb)wth.a(6);
    if (!paramBaseAdapter.a())
    {
      paramBaseAdapter.c();
      this.jdField_f_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Bihz = ((bihw)paramQQAppInterface.getManager(47)).a(1);
    this.jdField_a_of_type_Wkv.a(this.jdField_a_of_type_Ahvb);
    bcyh.a();
  }
  
  private void a(ahvc paramahvc, long paramLong, boolean paramBoolean)
  {
    paramahvc.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView = ((CropBubbleVideoView)baph.a(this.jdField_b_of_type_AndroidContentContext, paramLong, null, paramBoolean));
    a(paramahvc.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.c, this.d);
    paramahvc.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setFocusable(false);
    paramahvc.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setFocusableInTouchMode(false);
    paramahvc.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setClickable(false);
    paramahvc.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramahvc.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, 0);
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
      this.c = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
      this.d = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
      return;
    }
    this.c = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 137.0F);
    this.d = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 218.0F);
  }
  
  private void a(CropBubbleVideoView paramCropBubbleVideoView, int paramInt1, int paramInt2)
  {
    paramCropBubbleVideoView.setLayoutParams(new RelativeLayout.LayoutParams(paramInt1, paramInt2));
  }
  
  private void c(ahvc paramahvc)
  {
    paramahvc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramahvc.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363669));
    paramahvc.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
    paramahvc.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
  }
  
  private void d(ahvc paramahvc)
  {
    paramahvc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar = ((AutoStartProgressBar)paramahvc.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380885));
    paramahvc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setSharpCornerCor(BubbleImageView.jdField_a_of_type_ArrayOfFloat);
    paramahvc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setRadius(15.0F, true);
    paramahvc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setShowCorner(true);
    paramahvc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(1);
  }
  
  private void e(ahvc paramahvc)
  {
    paramahvc.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramahvc.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370642));
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 536870912, 0 });
    localGradientDrawable.setShape(0);
    float f1 = bhgr.a(this.jdField_b_of_type_AndroidContentContext, 15.0F);
    localGradientDrawable.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
    localGradientDrawable.setGradientType(0);
    paramahvc.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localGradientDrawable);
  }
  
  private void f(ahvc paramahvc)
  {
    int i = this.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296338);
    int j = this.c;
    int k = BaseChatItemLayout.k;
    int m = this.d;
    int n = BaseChatItemLayout.h;
    int i1 = this.g;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramahvc.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.width = (j + k + i);
    localLayoutParams.height = (i1 + (m + n));
    paramahvc.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aggl a()
  {
    return new ahvc();
  }
  
  public Drawable a(String paramString)
  {
    ascz localascz2 = PAVideoView.a;
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
      ascz localascz1 = localascz2;
    } while (!QLog.isColorLevel());
    QLog.e("TribeShortVideoItemBuilder", 2, "getCoverDrawable():  coverUrl=" + paramString);
    return localascz2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    paramView = (ViewGroup)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    a(paramView, paramChatMessage);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    boolean bool = paramChatMessage.isSend();
    paramaggl = (ahvc)paramaggl;
    a((MessageForTribeShortVideo)paramChatMessage);
    int i;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_b_of_type_AndroidContentContext).inflate(2131558848, paramBaseChatItemLayout, false);
      paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131364423));
      c(paramaggl);
      a(paramaggl, paramChatMessage.uniseq, bool);
      e(paramaggl);
      d(paramaggl);
      f(paramaggl);
      paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setOnLongClickListener(paramagjk);
      paramView.setOnTouchListener(paramagjk);
      paramaggl.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setKey(paramChatMessage.frienduin + paramChatMessage.uniseq);
      paramaggl.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(bool);
      i = bhgr.a(this.jdField_b_of_type_AndroidContentContext, paramaggl.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth());
      if (paramaggl.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend != bool)
      {
        paramaggl.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.mIsSend = bool;
        paramaggl.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.invalidate();
      }
      if (bool) {
        break label305;
      }
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramaggl.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramaggl.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramaggl.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = i;
      paramBaseChatItemLayout.rightMargin = 0;
      paramaggl.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatItemLayout);
    }
    for (;;)
    {
      a(paramaggl, paramChatMessage.uniseq, (MessageForTribeShortVideo)paramChatMessage, false);
      return paramView;
      a(paramaggl.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.c, this.d);
      f(paramaggl);
      break;
      label305:
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramaggl.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramaggl.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBaseChatItemLayout);
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramaggl.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramBaseChatItemLayout.leftMargin = 0;
      paramBaseChatItemLayout.rightMargin = i;
      paramaggl.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBaseChatItemLayout);
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
      aean.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
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
      auxu.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
      return;
      super.a(paramChatMessage);
      return;
      super.d(paramChatMessage);
    }
  }
  
  protected void a(ahvc paramahvc)
  {
    try
    {
      paramahvc = (MessageForTribeShortVideo)paramahvc.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick:" + paramahvc.toString());
      }
      Intent localIntent = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramahvc.jumpUrl);
      this.jdField_b_of_type_AndroidContentContext.startActivity(localIntent);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "clk_obj", 0, 0, paramahvc.bid, paramahvc.pid, "", "");
      return;
    }
    catch (Exception paramahvc)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onBubbleOnClick exp :", paramahvc);
    }
  }
  
  public void a(ahvc paramahvc, long paramLong)
  {
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.6(this, paramahvc, paramLong));
  }
  
  public void a(ahvc paramahvc, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramahvc.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if (!bhjz.a().a(paramahvc.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "video_play"))
    {
      bhjz.a().a(paramahvc.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "video_play");
      if ((paramahvc.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTribeShortVideo))
      {
        paramString2 = (MessageForTribeShortVideo)paramahvc.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "video_play", 0, 0, paramString2.bid, paramString2.pid, "", "");
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
        paramahvc = Integer.valueOf(0);
        paramString1.put("pid", paramahvc);
        if (!TextUtils.isEmpty(paramString2.themeName)) {
          paramString1.put("theme_id", paramString2.themeName);
        }
      }
      catch (Exception paramahvc)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TribeShortVideoItemBuilder", 2, "request cgi params is wrong!");
        continue;
      }
      paramahvc = new NewIntent(this.jdField_b_of_type_AndroidContentContext, nkl.class);
      paramahvc.putExtra("cmd", "MQUpdateSvc_com_qq_xiaoqu.web.publish_post");
      paramString2 = new WebSsoBody.WebSsoRequestBody();
      paramString2.type.set(0);
      paramString2.data.set(paramString1.toString());
      paramahvc.putExtra("data", paramString2.toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramahvc);
      return;
      paramLong = Long.parseLong(paramString2.bid);
      continue;
      paramahvc = paramString2.pid;
    }
  }
  
  public void a(ahvc paramahvc, long paramLong, MessageForTribeShortVideo paramMessageForTribeShortVideo, boolean paramBoolean)
  {
    Object localObject = new File(bigv.a(antf.bj + paramMessageForTribeShortVideo.mVid + ".mp4"));
    if (((File)localObject).exists())
    {
      if ((this.jdField_b_of_type_AndroidContentContext instanceof Activity))
      {
        localObject = ((File)localObject).getAbsolutePath();
        ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.2(this, (String)localObject, paramahvc, paramLong, paramMessageForTribeShortVideo));
      }
      return;
    }
    ((Activity)this.jdField_b_of_type_AndroidContentContext).runOnUiThread(new TribeShortVideoItemBuilder.3(this, paramahvc));
    if (QLog.isColorLevel()) {
      QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder handleGetVideo 1: download");
    }
    a(paramMessageForTribeShortVideo, paramahvc);
  }
  
  protected void a(ahvc paramahvc, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramahvc.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_b_of_type_AndroidContentContext);
    Object localObject1 = new TextView(this.jdField_b_of_type_AndroidContentContext);
    ((TextView)localObject1).setBackgroundResource(2130842581);
    Object localObject2 = this.jdField_b_of_type_AndroidContentContext.getResources().getDrawable(2130846392);
    ((Drawable)localObject2).setBounds(0, 0, 36, 36);
    ((TextView)localObject1).setCompoundDrawables((Drawable)localObject2, null, null, null);
    ((TextView)localObject1).setCompoundDrawablePadding(5);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    ((TextView)localObject1).setTextColor(this.jdField_b_of_type_AndroidContentContext.getResources().getColor(2131167302));
    ((TextView)localObject1).setIncludeFontPadding(false);
    ((TextView)localObject1).setSingleLine();
    ((TextView)localObject1).setGravity(16);
    ((TextView)localObject1).setPadding(bhgr.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0, bhgr.a(this.jdField_b_of_type_AndroidContentContext, 5.0F), 0);
    paramahvc.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject2 = new FrameLayout.LayoutParams(-2, -2);
    paramahvc.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    paramahvc.b = ((TextView)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131364423);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131364423);
    paramViewGroup.addView(paramahvc.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject1);
  }
  
  @SuppressLint({"SetTextI18n"})
  protected void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    MessageForTribeShortVideo localMessageForTribeShortVideo = (MessageForTribeShortVideo)paramChatMessage;
    localMessageForTribeShortVideo.parse();
    ahvc localahvc = (ahvc)paramViewGroup.getTag();
    boolean bool = localMessageForTribeShortVideo.isSend();
    if (localahvc.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      a(localahvc, paramViewGroup, bool);
    }
    paramViewGroup = (FrameLayout.LayoutParams)localahvc.b.getLayoutParams();
    if (bool)
    {
      paramViewGroup.leftMargin = BaseChatItemLayout.k;
      localahvc.b.setLayoutParams(paramViewGroup);
      if (TextUtils.isEmpty(localMessageForTribeShortVideo.themeName)) {
        break label297;
      }
      localahvc.jdField_a_of_type_AndroidWidgetTextView.setText("#" + localMessageForTribeShortVideo.themeName);
      localahvc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label126:
      if (TextUtils.isEmpty(localMessageForTribeShortVideo.srcName)) {
        break label384;
      }
      if (localMessageForTribeShortVideo.srcName.length() <= 5) {
        break label346;
      }
      localahvc.b.setText(localMessageForTribeShortVideo.srcName.substring(0, 5) + anzj.a(2131713875));
      label189:
      localahvc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setCornerDirection(paramChatMessage.isSend());
      if ((!TextUtils.isEmpty(localMessageForTribeShortVideo.mVid)) && (bcyh.b)) {
        break label414;
      }
      localahvc.jdField_a_of_type_Boolean = false;
      localahvc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localahvc.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localahvc.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getCoverImage(), localMessageForTribeShortVideo.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    label297:
    label346:
    do
    {
      return;
      paramViewGroup.leftMargin = (bhgr.a(this.jdField_b_of_type_AndroidContentContext, localahvc.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth()) + BaseChatItemLayout.j);
      break;
      if (!TextUtils.isEmpty(localMessageForTribeShortVideo.brief))
      {
        localahvc.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTribeShortVideo.brief);
        localahvc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        break label126;
      }
      localahvc.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label126;
      localahvc.b.setText(localMessageForTribeShortVideo.srcName + anzj.a(2131713876));
      break label189;
      localahvc.b.setText(this.jdField_b_of_type_AndroidContentContext.getString(2131719409));
      localahvc.b.setOnClickListener(null);
      break label189;
      paramViewGroup = (Long)localahvc.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTag();
    } while ((paramViewGroup != null) && (paramViewGroup.longValue() == localMessageForTribeShortVideo.uniseq));
    label384:
    label414:
    localahvc.jdField_a_of_type_Boolean = false;
    a(localahvc.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getCoverImage(), localMessageForTribeShortVideo.coverImgUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    a(localahvc, localMessageForTribeShortVideo.uniseq, localMessageForTribeShortVideo, false);
    localahvc.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setTag(Long.valueOf(localMessageForTribeShortVideo.uniseq));
  }
  
  protected void a(MessageForTribeShortVideo paramMessageForTribeShortVideo, ahvc paramahvc)
  {
    Object localObject1 = new File(bigv.a(antf.bj));
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = antf.bj + paramMessageForTribeShortVideo.mVid + ".mp4";
    Object localObject2 = new File(bigv.a((String)localObject1));
    localObject2 = new bihu(paramMessageForTribeShortVideo.videoUrl, (File)localObject2);
    ((bihu)localObject2).jdField_b_of_type_Int = 2;
    Bundle localBundle = new Bundle();
    localBundle.putString("filePath", (String)localObject1);
    this.jdField_a_of_type_Bihz.a((bihu)localObject2, new ahuz(this, paramahvc, paramMessageForTribeShortVideo), localBundle);
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
    paramString1.mSceneName = bapi.a(111);
    paramCropBubbleVideoView.setVideoParam(paramString1);
    paramCropBubbleVideoView.play();
  }
  
  public bhum[] a(View paramView)
  {
    bhuk localbhuk = new bhuk();
    paramView = agej.a(paramView);
    if (bgrf.a(paramView) == null) {}
    localbhuk.a(2131367078, this.jdField_b_of_type_AndroidContentContext.getString(2131692400), 2130838939);
    if ((paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
      a(localbhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
    }
    a(localbhuk, paramView);
    c(localbhuk, this.jdField_b_of_type_AndroidContentContext);
    super.e(localbhuk, this.jdField_b_of_type_AndroidContentContext);
    return localbhuk.a();
  }
  
  protected void b(ahvc paramahvc)
  {
    try
    {
      paramahvc = (MessageForTribeShortVideo)paramahvc.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick:" + paramahvc.toString());
      }
      Intent localIntent = new Intent(this.jdField_b_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("isOpeningQunApp", false);
      localIntent.putExtra("url", paramahvc.sourceJumpUrl);
      this.jdField_b_of_type_AndroidContentContext.startActivity(localIntent);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_tribe", "", "video_obj", "Clk_tail", 0, 0, paramahvc.bid, paramahvc.pid, "", "");
      return;
    }
    catch (Exception paramahvc)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("TribeShortVideoItemBuilder", 2, "TribeShortVideoItemBuilder onSourceOnClick exp :", paramahvc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahux
 * JD-Core Version:    0.7.0.1
 */