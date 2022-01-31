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

public class adnd
  extends acjb
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
  
  public adnd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    paramBaseAdapter = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = aciy.a(251.0F, paramBaseAdapter);
    this.c = aciy.a(131.0F, paramBaseAdapter);
    this.d = aciy.a(128.5F, paramBaseAdapter);
    this.jdField_e_of_type_Int = aciy.a(131.0F, paramBaseAdapter);
    this.f = aciy.a(122.5F, paramBaseAdapter);
    this.g = aciy.a(131.0F, paramBaseAdapter);
    this.h = aciy.a(16.0F, paramBaseAdapter);
    this.l = aciy.a(71.5F, paramBaseAdapter);
    this.m = aciy.a(74.0F, paramBaseAdapter);
    this.i = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedNicknameMaxLength", 10);
    this.j = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedBlogTitleMaxLength", 8);
    this.k = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedPicBlogTitleMaxLength", 12);
    this.jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedLogoWaterImgUrl", "https://qzonestyle.gtimg.cn/aoi/sola/20191119115951_pUMyXUXliB.png");
    paramQQAppInterface = (acjz)paramQQAppInterface.getManager(282);
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
  
  private View a(View paramView, adnh paramadnh)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493196, null);
      paramadnh.jdField_b_of_type_AndroidViewView = paramView;
      paramadnh.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131296795);
      paramadnh.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131296786);
      paramadnh.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296807));
      paramadnh.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296799));
      paramadnh.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296810));
      paramadnh.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131296804));
      localView = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramadnh.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (jdField_e_of_type_Boolean)
    {
      localView.setContentDescription(null);
      paramadnh.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramadnh.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
    paramString = azzz.b(paramString, paramInt);
    return "《" + paramString + "》";
  }
  
  private void a(adnh paramadnh)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.l;
    localURLDrawableOptions.mRequestHeight = this.m;
    paramadnh.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(0);
    paramadnh.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F });
    paramadnh.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setAlpha(0.08F);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
    paramadnh.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions));
  }
  
  private void a(adnh paramadnh, int paramInt)
  {
    if (paramadnh.jdField_e_of_type_AndroidViewView == null)
    {
      paramadnh.jdField_e_of_type_AndroidViewView = ((ViewStub)paramadnh.jdField_b_of_type_AndroidViewView.findViewById(2131296798)).inflate();
      paramadnh.k = ((TextView)paramadnh.jdField_e_of_type_AndroidViewView.findViewById(2131296796));
    }
    paramadnh.jdField_e_of_type_AndroidViewView.setOnClickListener(new adnf(this));
    paramadnh.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (paramadnh.jdField_f_of_type_AndroidViewView != null) {
      paramadnh.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramadnh.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramadnh.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    String str = "TA";
    if (paramInt == 1) {
      str = ajjy.a(2131646025);
    }
    for (;;)
    {
      if (paramadnh.k != null) {
        paramadnh.k.setText(ajjy.a(2131646038) + str + ajjy.a(2131646054));
      }
      paramadnh = new bfpl();
      paramadnh.c = "330";
      paramadnh.d = "3";
      paramadnh.e = "1";
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramadnh);
      return;
      if (paramInt == 2) {
        str = ajjy.a(2131646036);
      }
    }
  }
  
  private void a(adnh paramadnh, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    boolean bool2 = false;
    String str2;
    Object localObject;
    CharSequence localCharSequence;
    switch (a(paramMessageForQzoneFeed))
    {
    default: 
      str2 = azzz.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.i);
      localObject = str2 + paramMessageForQzoneFeed.summery;
      paramadnh.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramadnh.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localCharSequence = baiu.a(this.jdField_a_of_type_AndroidContentContext, 7, paramMessageForQzoneFeed.feedTime * 1000L);
      if (paramMessageForQzoneFeed.isFirstMsgWithNewFriend) {
        a(paramadnh, paramMessageForQzoneFeed.gender);
      }
      break;
    }
    for (;;)
    {
      if (jdField_e_of_type_Boolean)
      {
        paramadnh.jdField_b_of_type_JavaLangStringBuilder.append(str2);
        if (paramMessageForQzoneFeed.feedTime > 0L) {
          paramadnh.jdField_b_of_type_JavaLangStringBuilder.append("于").append(localCharSequence);
        }
        paramadnh.jdField_b_of_type_JavaLangStringBuilder.append(paramMessageForQzoneFeed.summery).append("内容是：").append(paramMessageForQzoneFeed.title).append(paramMessageForQzoneFeed.content);
        paramadnh.jdField_b_of_type_AndroidViewView.setContentDescription(paramadnh.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      return;
      b(paramadnh, paramMessageForQzoneFeed);
      break;
      c(paramadnh, paramMessageForQzoneFeed);
      break;
      e(paramadnh, paramMessageForQzoneFeed);
      break;
      d(paramadnh, paramMessageForQzoneFeed);
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
      a(paramadnh, localCharSequence, paramMessageForQzoneFeed, paramMessageForQzoneFeed.ulikeNum, paramMessageForQzoneFeed.uCommentNum, paramMessageForQzoneFeed.appId, bool1, (String)localObject);
    }
  }
  
  private void a(adnh paramadnh, CharSequence paramCharSequence, MessageForQzoneFeed paramMessageForQzoneFeed, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (paramadnh.jdField_f_of_type_AndroidViewView == null)
    {
      paramadnh.jdField_f_of_type_AndroidViewView = ((ViewStub)paramadnh.jdField_b_of_type_AndroidViewView.findViewById(2131296792)).inflate();
      paramadnh.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramadnh.jdField_f_of_type_AndroidViewView.findViewById(2131296812));
      paramadnh.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramadnh.jdField_f_of_type_AndroidViewView.findViewById(2131296809));
      paramadnh.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramadnh.jdField_f_of_type_AndroidViewView.findViewById(2131296808));
      paramadnh.j = ((TextView)paramadnh.jdField_f_of_type_AndroidViewView.findViewById(2131296794));
    }
    paramadnh.jdField_h_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    paramadnh.jdField_i_of_type_AndroidWidgetTextView.setText(b(paramInt1));
    paramCharSequence = paramadnh.jdField_d_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i1 = 2130846418;; i1 = 2130846417)
    {
      paramCharSequence.setImageResource(i1);
      paramadnh.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new adng(this, paramBoolean, paramInt1, paramadnh, paramString, paramInt2, paramMessageForQzoneFeed));
      paramadnh.j.setText(b(paramLong));
      paramadnh.jdField_f_of_type_AndroidViewView.setVisibility(0);
      if (paramadnh.jdField_e_of_type_AndroidViewView != null) {
        paramadnh.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      if (paramadnh.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramadnh.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
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
  
  private void b(adnh paramadnh, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() == 0)) {
      return;
    }
    paramadnh.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramadnh.jdField_h_of_type_AndroidViewView != null) {
      paramadnh.jdField_h_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramadnh.jdField_i_of_type_AndroidViewView != null) {
      paramadnh.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramadnh.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramadnh.jdField_g_of_type_AndroidViewView == null)
    {
      paramadnh.jdField_g_of_type_AndroidViewView = ((ViewStub)paramadnh.jdField_b_of_type_AndroidViewView.findViewById(2131296811)).inflate();
      paramadnh.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramadnh.jdField_b_of_type_AndroidViewView.findViewById(2131296800));
      paramadnh.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramadnh.jdField_b_of_type_AndroidViewView.findViewById(2131296813));
    }
    paramadnh.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838058);
    paramadnh.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramadnh.jdField_g_of_type_AndroidViewView.setVisibility(0);
    MessageForQzoneFeed.MediaData localMediaData = (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneFeedItemBuilder", 2, "setDataToSinglePicContainer picUrl= " + localMediaData.strImgUrl);
    }
    if (paramMessageForQzoneFeed.appId == 2)
    {
      paramMessageForQzoneFeed = a(paramMessageForQzoneFeed.title, this.k);
      paramadnh.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed);
    }
    for (;;)
    {
      paramMessageForQzoneFeed = URLDrawable.URLDrawableOptions.obtain();
      paramMessageForQzoneFeed.mRequestWidth = this.jdField_a_of_type_Int;
      paramMessageForQzoneFeed.mRequestHeight = this.c;
      a(paramadnh.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramadnh.jdField_a_of_type_AndroidWidgetImageView, localMediaData, paramMessageForQzoneFeed, new float[] { this.h, this.h, this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      paramadnh.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
    }
  }
  
  private void c(adnh paramadnh, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() < 2)) {
      return;
    }
    paramadnh.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramadnh.jdField_g_of_type_AndroidViewView != null) {
      paramadnh.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramadnh.jdField_i_of_type_AndroidViewView != null) {
      paramadnh.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramadnh.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramadnh.jdField_h_of_type_AndroidViewView == null)
    {
      paramadnh.jdField_h_of_type_AndroidViewView = ((ViewStub)paramadnh.jdField_b_of_type_AndroidViewView.findViewById(2131296806)).inflate();
      paramadnh.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramadnh.jdField_b_of_type_AndroidViewView.findViewById(2131296801));
      paramadnh.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramadnh.jdField_b_of_type_AndroidViewView.findViewById(2131296814));
      paramadnh.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramadnh.jdField_b_of_type_AndroidViewView.findViewById(2131296802));
      paramadnh.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramadnh.jdField_b_of_type_AndroidViewView.findViewById(2131296803));
      paramadnh.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramadnh.jdField_b_of_type_AndroidViewView.findViewById(2131296805));
    }
    paramadnh.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838058);
    paramadnh.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramadnh.jdField_h_of_type_AndroidViewView.setVisibility(0);
    Object localObject;
    if (paramMessageForQzoneFeed.appId == 2)
    {
      localObject = a(paramMessageForQzoneFeed.title, this.k);
      paramadnh.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (paramMessageForQzoneFeed.imageCount <= 2) {
        break label468;
      }
      paramadnh.jdField_e_of_type_AndroidWidgetTextView.setText(String.format("共 %s 个", new Object[] { b(paramMessageForQzoneFeed.imageCount) }));
    }
    for (;;)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.d;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_e_of_type_Int;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.f;
      localURLDrawableOptions.mRequestHeight = this.g;
      a(paramadnh.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramadnh.jdField_b_of_type_AndroidWidgetImageView, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0), (URLDrawable.URLDrawableOptions)localObject, new float[] { this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
      a(paramadnh.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramadnh.jdField_c_of_type_AndroidWidgetImageView, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(1), localURLDrawableOptions, new float[] { 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      paramadnh.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
      break;
      label468:
      paramadnh.jdField_e_of_type_AndroidWidgetTextView.setText("");
    }
  }
  
  private void d(adnh paramadnh, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramadnh.jdField_d_of_type_AndroidViewView.setVisibility(8);
    paramadnh.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramadnh.jdField_i_of_type_AndroidViewView == null)
    {
      paramadnh.jdField_i_of_type_AndroidViewView = ((ViewStub)paramadnh.jdField_b_of_type_AndroidViewView.findViewById(2131296789)).inflate();
      paramadnh.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramadnh.jdField_b_of_type_AndroidViewView.findViewById(2131296790));
      paramadnh.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramadnh.jdField_b_of_type_AndroidViewView.findViewById(2131296788));
    }
    paramadnh.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838060);
    a(paramadnh);
    paramadnh.jdField_i_of_type_AndroidViewView.setVisibility(0);
    String str = a(paramMessageForQzoneFeed.title, this.j);
    paramadnh.jdField_f_of_type_AndroidWidgetTextView.setText(str);
    paramadnh.jdField_g_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  private void e(adnh paramadnh, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramadnh.jdField_d_of_type_AndroidViewView.setVisibility(8);
    if (paramadnh.jdField_i_of_type_AndroidViewView != null) {
      paramadnh.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramadnh.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838060);
    a(paramadnh);
    paramadnh.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    paramadnh.jdField_d_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  protected acjc a()
  {
    return new adnh(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, acjc paramacjc, View paramView, LinearLayout paramLinearLayout, acmv paramacmv)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneFeedItemBuilder", 2, "getItemView: invoked. info: message = " + paramMessageRecord);
    }
    paramLinearLayout = (MessageForQzoneFeed)paramMessageRecord;
    paramMessageRecord = (adnh)paramacjc;
    paramacjc = a(paramView, paramMessageRecord);
    paramMessageRecord.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramMessageRecord.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramMessageRecord.jdField_b_of_type_JavaLangString = null;
    paramLinearLayout.coverImageUrl = a(paramLinearLayout.coverImageUrl);
    a(paramMessageRecord, paramLinearLayout);
    paramMessageRecord.jdField_c_of_type_AndroidViewView.setOnClickListener(new adne(this, paramLinearLayout));
    if (!paramLinearLayout.hasExposed)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FFF", "0X8005FFF", 0, 0, "", "", "", "");
      paramLinearLayout.hasExposed = true;
    }
    paramView = befm.a(paramLinearLayout.actionUrl);
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
      paramView = new bfpl();
      paramView.c = "330";
      paramView.d = "1";
      paramView.e = paramMessageRecord;
      if (paramLinearLayout.isFirstMsgWithNewFriend) {
        paramView.i = "1";
      }
      paramView.a = new ArrayList();
      paramView.a.add(paramLinearLayout.actionUrl);
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramView);
      return paramacjc;
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
    rtr.a(localIntent, paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public bakj[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adnd
 * JD-Core Version:    0.7.0.1
 */