import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForQzoneFeed.MediaData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ahev
  extends afor
{
  private static int n = -1;
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private final int l;
  private final int m;
  
  public ahev(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    paramBaseAdapter = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = AIOUtils.dp2px(251.0F, paramBaseAdapter);
    this.c = AIOUtils.dp2px(131.0F, paramBaseAdapter);
    this.d = AIOUtils.dp2px(128.5F, paramBaseAdapter);
    this.jdField_e_of_type_Int = AIOUtils.dp2px(131.0F, paramBaseAdapter);
    this.f = AIOUtils.dp2px(122.5F, paramBaseAdapter);
    this.g = AIOUtils.dp2px(131.0F, paramBaseAdapter);
    this.h = AIOUtils.dp2px(16.0F, paramBaseAdapter);
    this.l = AIOUtils.dp2px(71.5F, paramBaseAdapter);
    this.m = AIOUtils.dp2px(74.0F, paramBaseAdapter);
    this.i = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedNicknameMaxLength", 10);
    this.j = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedBlogTitleMaxLength", 8);
    this.k = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedPicBlogTitleMaxLength", 12);
    this.jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedLogoWaterImgUrl", "https://qzonestyle.gtimg.cn/aoi/sola/20191119115951_pUMyXUXliB.png");
    paramQQAppInterface = (afqy)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 2);
    }
  }
  
  private int a(MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    int i1 = 1;
    if (paramMessageForQzoneFeed.mediaDatas != null)
    {
      if (paramMessageForQzoneFeed.mediaDatas.size() > 1) {
        i1 = 2;
      }
      return i1;
    }
    if (!TextUtils.isEmpty(paramMessageForQzoneFeed.title)) {
      return 4;
    }
    return 3;
  }
  
  private View a(View paramView, ahez paramahez)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558887, null);
      paramahez.jdField_b_of_type_AndroidViewView = paramView;
      paramahez.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362475);
      paramahez.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131362466);
      paramahez.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362486));
      paramahez.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362479));
      paramahez.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362489));
      paramahez.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131362484));
      localView = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramahez.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (jdField_e_of_type_Boolean)
    {
      localView.setContentDescription(null);
      paramahez.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramahez.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localView;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i1;
    do
    {
      return null;
      i1 = paramString.indexOf("http");
    } while (i1 < 0);
    paramString = paramString.substring(i1);
    try
    {
      new URL(paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static String a(String paramString, int paramInt)
  {
    paramString = bhbx.b(paramString, paramInt);
    return "《" + paramString + "》";
  }
  
  private void a(ahez paramahez)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.l;
    localURLDrawableOptions.mRequestHeight = this.m;
    paramahez.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(0);
    paramahez.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F });
    paramahez.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setAlpha(0.08F);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
    paramahez.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions));
  }
  
  private void a(ahez paramahez, int paramInt)
  {
    if (paramahez.jdField_e_of_type_AndroidViewView == null)
    {
      paramahez.jdField_e_of_type_AndroidViewView = ((ViewStub)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362478)).inflate();
      paramahez.k = ((TextView)paramahez.jdField_e_of_type_AndroidViewView.findViewById(2131362476));
    }
    paramahez.jdField_e_of_type_AndroidViewView.setOnClickListener(new ahex(this));
    paramahez.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (paramahez.jdField_f_of_type_AndroidViewView != null) {
      paramahez.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramahez.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramahez.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    String str = "TA";
    if (paramInt == 1) {
      str = anvx.a(2131711275);
    }
    for (;;)
    {
      if (paramahez.k != null) {
        paramahez.k.setText(anvx.a(2131711288) + str + anvx.a(2131711304));
      }
      paramahez = new QZoneClickReport.ReportInfo();
      paramahez.actionType = "330";
      paramahez.subactionType = "3";
      paramahez.reserves = "1";
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramahez);
      return;
      if (paramInt == 2) {
        str = anvx.a(2131711286);
      }
    }
  }
  
  private void a(ahez paramahez, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    boolean bool2 = false;
    String str2;
    Object localObject;
    CharSequence localCharSequence;
    switch (a(paramMessageForQzoneFeed))
    {
    default: 
      str2 = bhbx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, this.i);
      localObject = str2 + paramMessageForQzoneFeed.summery;
      paramahez.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramahez.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localCharSequence = bhid.a(this.jdField_a_of_type_AndroidContentContext, 7, paramMessageForQzoneFeed.feedTime * 1000L);
      if (paramMessageForQzoneFeed.isFirstMsgWithNewFriend) {
        a(paramahez, paramMessageForQzoneFeed.gender);
      }
      break;
    }
    for (;;)
    {
      if (jdField_e_of_type_Boolean)
      {
        paramahez.jdField_b_of_type_JavaLangStringBuilder.append(str2);
        if (paramMessageForQzoneFeed.feedTime > 0L) {
          paramahez.jdField_b_of_type_JavaLangStringBuilder.append("于").append(localCharSequence);
        }
        paramahez.jdField_b_of_type_JavaLangStringBuilder.append(paramMessageForQzoneFeed.summery).append("内容是：").append(paramMessageForQzoneFeed.title).append(paramMessageForQzoneFeed.content);
        paramahez.jdField_b_of_type_AndroidViewView.setContentDescription(paramahez.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      return;
      b(paramahez, paramMessageForQzoneFeed);
      break;
      c(paramahez, paramMessageForQzoneFeed);
      break;
      e(paramahez, paramMessageForQzoneFeed);
      break;
      d(paramahez, paramMessageForQzoneFeed);
      break;
      String str1 = "";
      boolean bool1 = bool2;
      if (paramMessageForQzoneFeed.mapExt != null)
      {
        bool1 = bool2;
        if (paramMessageForQzoneFeed.mapExt.containsKey("isliked")) {
          bool1 = "1".equals(paramMessageForQzoneFeed.mapExt.get("isliked"));
        }
      }
      localObject = str1;
      if (paramMessageForQzoneFeed.mapExt != null)
      {
        localObject = str1;
        if (paramMessageForQzoneFeed.mapExt.containsKey("likekey")) {
          localObject = (String)paramMessageForQzoneFeed.mapExt.get("likekey");
        }
      }
      a(paramahez, localCharSequence, paramMessageForQzoneFeed, paramMessageForQzoneFeed.ulikeNum, paramMessageForQzoneFeed.uCommentNum, paramMessageForQzoneFeed.appId, bool1, (String)localObject);
    }
  }
  
  private void a(ahez paramahez, CharSequence paramCharSequence, MessageForQzoneFeed paramMessageForQzoneFeed, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (paramahez.jdField_f_of_type_AndroidViewView == null)
    {
      paramahez.jdField_f_of_type_AndroidViewView = ((ViewStub)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362472)).inflate();
      paramahez.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramahez.jdField_f_of_type_AndroidViewView.findViewById(2131362491));
      paramahez.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramahez.jdField_f_of_type_AndroidViewView.findViewById(2131362488));
      paramahez.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramahez.jdField_f_of_type_AndroidViewView.findViewById(2131362487));
      paramahez.j = ((TextView)paramahez.jdField_f_of_type_AndroidViewView.findViewById(2131362474));
    }
    paramahez.jdField_h_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    paramahez.jdField_i_of_type_AndroidWidgetTextView.setText(b(paramInt1));
    paramCharSequence = paramahez.jdField_d_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i1 = 2130847530;; i1 = 2130847529)
    {
      paramCharSequence.setImageResource(i1);
      paramahez.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new ahey(this, paramBoolean, paramInt1, paramahez, paramString, paramInt2, paramMessageForQzoneFeed));
      paramahez.j.setText(b(paramLong));
      paramahez.jdField_f_of_type_AndroidViewView.setVisibility(0);
      if (paramahez.jdField_e_of_type_AndroidViewView != null) {
        paramahez.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      if (paramahez.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramahez.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      return;
    }
  }
  
  private static void a(CornerImageView paramCornerImageView, View paramView, MessageForQzoneFeed.MediaData paramMediaData, URLDrawable.URLDrawableOptions paramURLDrawableOptions, float[] paramArrayOfFloat)
  {
    if (paramMediaData.uType == 1) {
      paramView.setVisibility(0);
    }
    for (;;)
    {
      paramCornerImageView.setRadius(paramArrayOfFloat);
      paramView = a(paramMediaData.strImgUrl);
      if (!TextUtils.isEmpty(paramView)) {
        paramCornerImageView.setImageDrawable(URLDrawable.getDrawable(paramView, paramURLDrawableOptions));
      }
      return;
      paramView.setVisibility(8);
    }
  }
  
  private static String b(long paramLong)
  {
    if (paramLong > 100000000L) {
      return String.format("%.1f亿", new Object[] { Float.valueOf((float)paramLong / 1.0E+008F) });
    }
    if (paramLong > 10000L) {
      return String.format("%.1f万", new Object[] { Float.valueOf((float)paramLong / 10000.0F) });
    }
    return String.format("%d", new Object[] { Long.valueOf(paramLong) });
  }
  
  private void b(ahez paramahez, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() == 0)) {
      return;
    }
    paramahez.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramahez.jdField_h_of_type_AndroidViewView != null) {
      paramahez.jdField_h_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramahez.jdField_i_of_type_AndroidViewView != null) {
      paramahez.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramahez.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramahez.jdField_g_of_type_AndroidViewView == null)
    {
      paramahez.jdField_g_of_type_AndroidViewView = ((ViewStub)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362490)).inflate();
      paramahez.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362480));
      paramahez.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362462));
    }
    paramahez.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838283);
    paramahez.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramahez.jdField_g_of_type_AndroidViewView.setVisibility(0);
    MessageForQzoneFeed.MediaData localMediaData = (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneFeedItemBuilder", 2, "setDataToSinglePicContainer picUrl= " + localMediaData.strImgUrl);
    }
    if (paramMessageForQzoneFeed.appId == 2)
    {
      paramMessageForQzoneFeed = a(paramMessageForQzoneFeed.title, this.k);
      paramahez.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed);
    }
    for (;;)
    {
      paramMessageForQzoneFeed = URLDrawable.URLDrawableOptions.obtain();
      paramMessageForQzoneFeed.mRequestWidth = this.jdField_a_of_type_Int;
      paramMessageForQzoneFeed.mRequestHeight = this.c;
      a(paramahez.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramahez.jdField_a_of_type_AndroidWidgetImageView, localMediaData, paramMessageForQzoneFeed, new float[] { this.h, this.h, this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      paramahez.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
    }
  }
  
  private void c(ahez paramahez, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() < 2)) {
      return;
    }
    paramahez.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramahez.jdField_g_of_type_AndroidViewView != null) {
      paramahez.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramahez.jdField_i_of_type_AndroidViewView != null) {
      paramahez.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramahez.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramahez.jdField_h_of_type_AndroidViewView == null)
    {
      paramahez.jdField_h_of_type_AndroidViewView = ((ViewStub)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362485)).inflate();
      paramahez.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362481));
      paramahez.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362492));
      paramahez.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362482));
      paramahez.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362483));
      paramahez.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362458));
    }
    paramahez.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838283);
    paramahez.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramahez.jdField_h_of_type_AndroidViewView.setVisibility(0);
    Object localObject;
    if (paramMessageForQzoneFeed.appId == 2)
    {
      localObject = a(paramMessageForQzoneFeed.title, this.k);
      paramahez.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (paramMessageForQzoneFeed.imageCount <= 2) {
        break label468;
      }
      paramahez.jdField_e_of_type_AndroidWidgetTextView.setText(String.format("共 %s 个", new Object[] { b(paramMessageForQzoneFeed.imageCount) }));
    }
    for (;;)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.d;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_e_of_type_Int;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.f;
      localURLDrawableOptions.mRequestHeight = this.g;
      a(paramahez.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramahez.jdField_b_of_type_AndroidWidgetImageView, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0), (URLDrawable.URLDrawableOptions)localObject, new float[] { this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
      a(paramahez.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramahez.jdField_c_of_type_AndroidWidgetImageView, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(1), localURLDrawableOptions, new float[] { 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      paramahez.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
      break;
      label468:
      paramahez.jdField_e_of_type_AndroidWidgetTextView.setText("");
    }
  }
  
  private void d(ahez paramahez, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramahez.jdField_d_of_type_AndroidViewView.setVisibility(8);
    paramahez.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramahez.jdField_i_of_type_AndroidViewView == null)
    {
      paramahez.jdField_i_of_type_AndroidViewView = ((ViewStub)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362469)).inflate();
      paramahez.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362470));
      paramahez.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362468));
    }
    paramahez.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838285);
    a(paramahez);
    paramahez.jdField_i_of_type_AndroidViewView.setVisibility(0);
    String str = a(paramMessageForQzoneFeed.title, this.j);
    paramahez.jdField_f_of_type_AndroidWidgetTextView.setText(str);
    paramahez.jdField_g_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  private void e(ahez paramahez, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramahez.jdField_d_of_type_AndroidViewView.setVisibility(8);
    if (paramahez.jdField_i_of_type_AndroidViewView != null) {
      paramahez.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramahez.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838285);
    a(paramahez);
    paramahez.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    paramahez.jdField_d_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  protected afos a()
  {
    return new ahez(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneFeedItemBuilder", 2, "getItemView: invoked. info: message = " + paramMessageRecord);
    }
    paramLinearLayout = (MessageForQzoneFeed)paramMessageRecord;
    paramMessageRecord = (ahez)paramafos;
    paramafos = a(paramView, paramMessageRecord);
    paramMessageRecord.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramMessageRecord.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramMessageRecord.jdField_b_of_type_JavaLangString = null;
    paramLinearLayout.coverImageUrl = a(paramLinearLayout.coverImageUrl);
    a(paramMessageRecord, paramLinearLayout);
    paramMessageRecord.jdField_c_of_type_AndroidViewView.setOnClickListener(new ahew(this, paramLinearLayout));
    if (!paramLinearLayout.hasExposed)
    {
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FFF", "0X8005FFF", 0, 0, "", "", "", "");
      paramLinearLayout.hasExposed = true;
    }
    paramView = bkyp.a(paramLinearLayout.actionUrl);
    paramMessageRecord = null;
    if (paramView != null) {
      paramMessageRecord = (String)paramView.get("a");
    }
    if (paramMessageRecord != null)
    {
      if (!paramMessageRecord.equals("4")) {
        break label280;
      }
      paramMessageRecord = "1";
    }
    for (;;)
    {
      paramView = new QZoneClickReport.ReportInfo();
      paramView.actionType = "330";
      paramView.subactionType = "1";
      paramView.reserves = paramMessageRecord;
      if (paramLinearLayout.isFirstMsgWithNewFriend) {
        paramView.reserves10 = "1";
      }
      paramView.reservesExt = new ArrayList();
      paramView.reservesExt.add(paramLinearLayout.actionUrl);
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramView);
      return paramafos;
      label280:
      if (paramMessageRecord.equals("311")) {
        paramMessageRecord = "2";
      } else if (paramMessageRecord.equals("2")) {
        paramMessageRecord = "3";
      } else {
        paramMessageRecord = "4";
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
      return false;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("fromAio", true);
    uuc.a(localIntent, paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public bhjs[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahev
 * JD-Core Version:    0.7.0.1
 */