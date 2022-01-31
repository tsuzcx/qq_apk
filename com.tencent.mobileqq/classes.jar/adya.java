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
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForQzoneFeed.MediaData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class adya
  extends actm
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
  
  public adya(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    paramBaseAdapter = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = actj.a(251.0F, paramBaseAdapter);
    this.c = actj.a(131.0F, paramBaseAdapter);
    this.d = actj.a(128.5F, paramBaseAdapter);
    this.jdField_e_of_type_Int = actj.a(131.0F, paramBaseAdapter);
    this.f = actj.a(122.5F, paramBaseAdapter);
    this.g = actj.a(131.0F, paramBaseAdapter);
    this.h = actj.a(16.0F, paramBaseAdapter);
    this.l = actj.a(71.5F, paramBaseAdapter);
    this.m = actj.a(74.0F, paramBaseAdapter);
    this.i = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedNicknameMaxLength", 10);
    this.j = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedBlogTitleMaxLength", 8);
    this.k = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedPicBlogTitleMaxLength", 12);
    this.jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedLogoWaterImgUrl", "https://qzonestyle.gtimg.cn/aoi/sola/20191119115951_pUMyXUXliB.png");
    paramQQAppInterface = (acuo)paramQQAppInterface.getManager(282);
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
  
  private View a(View paramView, adye paramadye)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558752, null);
      paramadye.jdField_b_of_type_AndroidViewView = paramView;
      paramadye.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362335);
      paramadye.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131362326);
      paramadye.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362347));
      paramadye.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362339));
      paramadye.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362350));
      paramadye.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131362344));
      localView = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramadye.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (jdField_e_of_type_Boolean)
    {
      localView.setContentDescription(null);
      paramadye.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramadye.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
    paramString = bbbr.b(paramString, paramInt);
    return "《" + paramString + "》";
  }
  
  private void a(adye paramadye)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.l;
    localURLDrawableOptions.mRequestHeight = this.m;
    paramadye.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(0);
    paramadye.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F });
    paramadye.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setAlpha(0.08F);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
    paramadye.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions));
  }
  
  private void a(adye paramadye, int paramInt)
  {
    if (paramadye.jdField_e_of_type_AndroidViewView == null)
    {
      paramadye.jdField_e_of_type_AndroidViewView = ((ViewStub)paramadye.jdField_b_of_type_AndroidViewView.findViewById(2131362338)).inflate();
      paramadye.k = ((TextView)paramadye.jdField_e_of_type_AndroidViewView.findViewById(2131362336));
    }
    paramadye.jdField_e_of_type_AndroidViewView.setOnClickListener(new adyc(this));
    paramadye.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (paramadye.jdField_f_of_type_AndroidViewView != null) {
      paramadye.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramadye.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramadye.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    String str = "TA";
    if (paramInt == 1) {
      str = ajya.a(2131711824);
    }
    for (;;)
    {
      if (paramadye.k != null) {
        paramadye.k.setText(ajya.a(2131711837) + str + ajya.a(2131711853));
      }
      paramadye = new bgyj();
      paramadye.c = "330";
      paramadye.d = "3";
      paramadye.e = "1";
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramadye);
      return;
      if (paramInt == 2) {
        str = ajya.a(2131711835);
      }
    }
  }
  
  private void a(adye paramadye, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    boolean bool2 = false;
    String str2;
    Object localObject;
    CharSequence localCharSequence;
    switch (a(paramMessageForQzoneFeed))
    {
    default: 
      str2 = bbbr.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.i);
      localObject = str2 + paramMessageForQzoneFeed.summery;
      paramadye.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramadye.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localCharSequence = bbkp.a(this.jdField_a_of_type_AndroidContentContext, 7, paramMessageForQzoneFeed.feedTime * 1000L);
      if (paramMessageForQzoneFeed.isFirstMsgWithNewFriend) {
        a(paramadye, paramMessageForQzoneFeed.gender);
      }
      break;
    }
    for (;;)
    {
      if (jdField_e_of_type_Boolean)
      {
        paramadye.jdField_b_of_type_JavaLangStringBuilder.append(str2);
        if (paramMessageForQzoneFeed.feedTime > 0L) {
          paramadye.jdField_b_of_type_JavaLangStringBuilder.append("于").append(localCharSequence);
        }
        paramadye.jdField_b_of_type_JavaLangStringBuilder.append(paramMessageForQzoneFeed.summery).append("内容是：").append(paramMessageForQzoneFeed.title).append(paramMessageForQzoneFeed.content);
        paramadye.jdField_b_of_type_AndroidViewView.setContentDescription(paramadye.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      return;
      b(paramadye, paramMessageForQzoneFeed);
      break;
      c(paramadye, paramMessageForQzoneFeed);
      break;
      e(paramadye, paramMessageForQzoneFeed);
      break;
      d(paramadye, paramMessageForQzoneFeed);
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
      a(paramadye, localCharSequence, paramMessageForQzoneFeed, paramMessageForQzoneFeed.ulikeNum, paramMessageForQzoneFeed.uCommentNum, paramMessageForQzoneFeed.appId, bool1, (String)localObject);
    }
  }
  
  private void a(adye paramadye, CharSequence paramCharSequence, MessageForQzoneFeed paramMessageForQzoneFeed, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (paramadye.jdField_f_of_type_AndroidViewView == null)
    {
      paramadye.jdField_f_of_type_AndroidViewView = ((ViewStub)paramadye.jdField_b_of_type_AndroidViewView.findViewById(2131362332)).inflate();
      paramadye.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramadye.jdField_f_of_type_AndroidViewView.findViewById(2131362352));
      paramadye.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramadye.jdField_f_of_type_AndroidViewView.findViewById(2131362349));
      paramadye.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramadye.jdField_f_of_type_AndroidViewView.findViewById(2131362348));
      paramadye.j = ((TextView)paramadye.jdField_f_of_type_AndroidViewView.findViewById(2131362334));
    }
    paramadye.jdField_h_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    paramadye.jdField_i_of_type_AndroidWidgetTextView.setText(b(paramInt1));
    paramCharSequence = paramadye.jdField_d_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i1 = 2130846612;; i1 = 2130846611)
    {
      paramCharSequence.setImageResource(i1);
      paramadye.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new adyd(this, paramBoolean, paramInt1, paramadye, paramString, paramInt2, paramMessageForQzoneFeed));
      paramadye.j.setText(b(paramLong));
      paramadye.jdField_f_of_type_AndroidViewView.setVisibility(0);
      if (paramadye.jdField_e_of_type_AndroidViewView != null) {
        paramadye.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      if (paramadye.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramadye.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
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
  
  private void b(adye paramadye, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() == 0)) {
      return;
    }
    paramadye.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramadye.jdField_h_of_type_AndroidViewView != null) {
      paramadye.jdField_h_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramadye.jdField_i_of_type_AndroidViewView != null) {
      paramadye.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramadye.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramadye.jdField_g_of_type_AndroidViewView == null)
    {
      paramadye.jdField_g_of_type_AndroidViewView = ((ViewStub)paramadye.jdField_b_of_type_AndroidViewView.findViewById(2131362351)).inflate();
      paramadye.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramadye.jdField_b_of_type_AndroidViewView.findViewById(2131362340));
      paramadye.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramadye.jdField_b_of_type_AndroidViewView.findViewById(2131362353));
    }
    paramadye.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838065);
    paramadye.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramadye.jdField_g_of_type_AndroidViewView.setVisibility(0);
    MessageForQzoneFeed.MediaData localMediaData = (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneFeedItemBuilder", 2, "setDataToSinglePicContainer picUrl= " + localMediaData.strImgUrl);
    }
    if (paramMessageForQzoneFeed.appId == 2)
    {
      paramMessageForQzoneFeed = a(paramMessageForQzoneFeed.title, this.k);
      paramadye.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed);
    }
    for (;;)
    {
      paramMessageForQzoneFeed = URLDrawable.URLDrawableOptions.obtain();
      paramMessageForQzoneFeed.mRequestWidth = this.jdField_a_of_type_Int;
      paramMessageForQzoneFeed.mRequestHeight = this.c;
      a(paramadye.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramadye.jdField_a_of_type_AndroidWidgetImageView, localMediaData, paramMessageForQzoneFeed, new float[] { this.h, this.h, this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      paramadye.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
    }
  }
  
  private void c(adye paramadye, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() < 2)) {
      return;
    }
    paramadye.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramadye.jdField_g_of_type_AndroidViewView != null) {
      paramadye.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramadye.jdField_i_of_type_AndroidViewView != null) {
      paramadye.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramadye.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramadye.jdField_h_of_type_AndroidViewView == null)
    {
      paramadye.jdField_h_of_type_AndroidViewView = ((ViewStub)paramadye.jdField_b_of_type_AndroidViewView.findViewById(2131362346)).inflate();
      paramadye.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramadye.jdField_b_of_type_AndroidViewView.findViewById(2131362341));
      paramadye.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramadye.jdField_b_of_type_AndroidViewView.findViewById(2131362354));
      paramadye.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramadye.jdField_b_of_type_AndroidViewView.findViewById(2131362342));
      paramadye.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramadye.jdField_b_of_type_AndroidViewView.findViewById(2131362343));
      paramadye.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramadye.jdField_b_of_type_AndroidViewView.findViewById(2131362345));
    }
    paramadye.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838065);
    paramadye.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramadye.jdField_h_of_type_AndroidViewView.setVisibility(0);
    Object localObject;
    if (paramMessageForQzoneFeed.appId == 2)
    {
      localObject = a(paramMessageForQzoneFeed.title, this.k);
      paramadye.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (paramMessageForQzoneFeed.imageCount <= 2) {
        break label468;
      }
      paramadye.jdField_e_of_type_AndroidWidgetTextView.setText(String.format("共 %s 个", new Object[] { b(paramMessageForQzoneFeed.imageCount) }));
    }
    for (;;)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.d;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_e_of_type_Int;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.f;
      localURLDrawableOptions.mRequestHeight = this.g;
      a(paramadye.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramadye.jdField_b_of_type_AndroidWidgetImageView, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0), (URLDrawable.URLDrawableOptions)localObject, new float[] { this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
      a(paramadye.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramadye.jdField_c_of_type_AndroidWidgetImageView, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(1), localURLDrawableOptions, new float[] { 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      paramadye.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
      break;
      label468:
      paramadye.jdField_e_of_type_AndroidWidgetTextView.setText("");
    }
  }
  
  private void d(adye paramadye, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramadye.jdField_d_of_type_AndroidViewView.setVisibility(8);
    paramadye.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramadye.jdField_i_of_type_AndroidViewView == null)
    {
      paramadye.jdField_i_of_type_AndroidViewView = ((ViewStub)paramadye.jdField_b_of_type_AndroidViewView.findViewById(2131362329)).inflate();
      paramadye.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramadye.jdField_b_of_type_AndroidViewView.findViewById(2131362330));
      paramadye.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramadye.jdField_b_of_type_AndroidViewView.findViewById(2131362328));
    }
    paramadye.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838067);
    a(paramadye);
    paramadye.jdField_i_of_type_AndroidViewView.setVisibility(0);
    String str = a(paramMessageForQzoneFeed.title, this.j);
    paramadye.jdField_f_of_type_AndroidWidgetTextView.setText(str);
    paramadye.jdField_g_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  private void e(adye paramadye, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramadye.jdField_d_of_type_AndroidViewView.setVisibility(8);
    if (paramadye.jdField_i_of_type_AndroidViewView != null) {
      paramadye.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramadye.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838067);
    a(paramadye);
    paramadye.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    paramadye.jdField_d_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  protected actn a()
  {
    return new adye(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actn paramactn, View paramView, LinearLayout paramLinearLayout, acxj paramacxj)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneFeedItemBuilder", 2, "getItemView: invoked. info: message = " + paramMessageRecord);
    }
    paramLinearLayout = (MessageForQzoneFeed)paramMessageRecord;
    paramMessageRecord = (adye)paramactn;
    paramactn = a(paramView, paramMessageRecord);
    paramMessageRecord.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramMessageRecord.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramMessageRecord.jdField_b_of_type_JavaLangString = null;
    paramLinearLayout.coverImageUrl = a(paramLinearLayout.coverImageUrl);
    a(paramMessageRecord, paramLinearLayout);
    paramMessageRecord.jdField_c_of_type_AndroidViewView.setOnClickListener(new adyb(this, paramLinearLayout));
    if (!paramLinearLayout.hasExposed)
    {
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FFF", "0X8005FFF", 0, 0, "", "", "", "");
      paramLinearLayout.hasExposed = true;
    }
    paramView = bfnx.a(paramLinearLayout.actionUrl);
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
      paramView = new bgyj();
      paramView.c = "330";
      paramView.d = "1";
      paramView.e = paramMessageRecord;
      if (paramLinearLayout.isFirstMsgWithNewFriend) {
        paramView.i = "1";
      }
      paramView.a = new ArrayList();
      paramView.a.add(paramLinearLayout.actionUrl);
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramView);
      return paramactn;
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
    sgg.a(localIntent, paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public bbmh[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adya
 * JD-Core Version:    0.7.0.1
 */