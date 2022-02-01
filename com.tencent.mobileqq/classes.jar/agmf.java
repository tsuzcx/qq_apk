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

public class agmf
  extends aexf
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
  
  public agmf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
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
    paramQQAppInterface = (aezm)paramQQAppInterface.getManager(282);
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
  
  private View a(View paramView, agmj paramagmj)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558861, null);
      paramagmj.jdField_b_of_type_AndroidViewView = paramView;
      paramagmj.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362462);
      paramagmj.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131362453);
      paramagmj.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362473));
      paramagmj.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362466));
      paramagmj.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362476));
      paramagmj.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131362471));
      localView = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramagmj.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (jdField_e_of_type_Boolean)
    {
      localView.setContentDescription(null);
      paramagmj.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramagmj.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
    paramString = bftf.b(paramString, paramInt);
    return "《" + paramString + "》";
  }
  
  private void a(agmj paramagmj)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.l;
    localURLDrawableOptions.mRequestHeight = this.m;
    paramagmj.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(0);
    paramagmj.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F });
    paramagmj.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setAlpha(0.08F);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
    paramagmj.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions));
  }
  
  private void a(agmj paramagmj, int paramInt)
  {
    if (paramagmj.jdField_e_of_type_AndroidViewView == null)
    {
      paramagmj.jdField_e_of_type_AndroidViewView = ((ViewStub)paramagmj.jdField_b_of_type_AndroidViewView.findViewById(2131362465)).inflate();
      paramagmj.k = ((TextView)paramagmj.jdField_e_of_type_AndroidViewView.findViewById(2131362463));
    }
    paramagmj.jdField_e_of_type_AndroidViewView.setOnClickListener(new agmh(this));
    paramagmj.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (paramagmj.jdField_f_of_type_AndroidViewView != null) {
      paramagmj.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramagmj.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramagmj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    String str = "TA";
    if (paramInt == 1) {
      str = amtj.a(2131710928);
    }
    for (;;)
    {
      if (paramagmj.k != null) {
        paramagmj.k.setText(amtj.a(2131710941) + str + amtj.a(2131710957));
      }
      paramagmj = new QZoneClickReport.ReportInfo();
      paramagmj.actionType = "330";
      paramagmj.subactionType = "3";
      paramagmj.reserves = "1";
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramagmj);
      return;
      if (paramInt == 2) {
        str = amtj.a(2131710939);
      }
    }
  }
  
  private void a(agmj paramagmj, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    boolean bool2 = false;
    String str2;
    Object localObject;
    CharSequence localCharSequence;
    switch (a(paramMessageForQzoneFeed))
    {
    default: 
      str2 = bftf.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, this.i);
      localObject = str2 + paramMessageForQzoneFeed.summery;
      paramagmj.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramagmj.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localCharSequence = bfzl.a(this.jdField_a_of_type_AndroidContentContext, 7, paramMessageForQzoneFeed.feedTime * 1000L);
      if (paramMessageForQzoneFeed.isFirstMsgWithNewFriend) {
        a(paramagmj, paramMessageForQzoneFeed.gender);
      }
      break;
    }
    for (;;)
    {
      if (jdField_e_of_type_Boolean)
      {
        paramagmj.jdField_b_of_type_JavaLangStringBuilder.append(str2);
        if (paramMessageForQzoneFeed.feedTime > 0L) {
          paramagmj.jdField_b_of_type_JavaLangStringBuilder.append("于").append(localCharSequence);
        }
        paramagmj.jdField_b_of_type_JavaLangStringBuilder.append(paramMessageForQzoneFeed.summery).append("内容是：").append(paramMessageForQzoneFeed.title).append(paramMessageForQzoneFeed.content);
        paramagmj.jdField_b_of_type_AndroidViewView.setContentDescription(paramagmj.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      return;
      b(paramagmj, paramMessageForQzoneFeed);
      break;
      c(paramagmj, paramMessageForQzoneFeed);
      break;
      e(paramagmj, paramMessageForQzoneFeed);
      break;
      d(paramagmj, paramMessageForQzoneFeed);
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
      a(paramagmj, localCharSequence, paramMessageForQzoneFeed, paramMessageForQzoneFeed.ulikeNum, paramMessageForQzoneFeed.uCommentNum, paramMessageForQzoneFeed.appId, bool1, (String)localObject);
    }
  }
  
  private void a(agmj paramagmj, CharSequence paramCharSequence, MessageForQzoneFeed paramMessageForQzoneFeed, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (paramagmj.jdField_f_of_type_AndroidViewView == null)
    {
      paramagmj.jdField_f_of_type_AndroidViewView = ((ViewStub)paramagmj.jdField_b_of_type_AndroidViewView.findViewById(2131362459)).inflate();
      paramagmj.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramagmj.jdField_f_of_type_AndroidViewView.findViewById(2131362478));
      paramagmj.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramagmj.jdField_f_of_type_AndroidViewView.findViewById(2131362475));
      paramagmj.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramagmj.jdField_f_of_type_AndroidViewView.findViewById(2131362474));
      paramagmj.j = ((TextView)paramagmj.jdField_f_of_type_AndroidViewView.findViewById(2131362461));
    }
    paramagmj.jdField_h_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    paramagmj.jdField_i_of_type_AndroidWidgetTextView.setText(b(paramInt1));
    paramCharSequence = paramagmj.jdField_d_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i1 = 2130847439;; i1 = 2130847438)
    {
      paramCharSequence.setImageResource(i1);
      paramagmj.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new agmi(this, paramBoolean, paramInt1, paramagmj, paramString, paramInt2, paramMessageForQzoneFeed));
      paramagmj.j.setText(b(paramLong));
      paramagmj.jdField_f_of_type_AndroidViewView.setVisibility(0);
      if (paramagmj.jdField_e_of_type_AndroidViewView != null) {
        paramagmj.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      if (paramagmj.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramagmj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
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
  
  private void b(agmj paramagmj, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() == 0)) {
      return;
    }
    paramagmj.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramagmj.jdField_h_of_type_AndroidViewView != null) {
      paramagmj.jdField_h_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramagmj.jdField_i_of_type_AndroidViewView != null) {
      paramagmj.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramagmj.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramagmj.jdField_g_of_type_AndroidViewView == null)
    {
      paramagmj.jdField_g_of_type_AndroidViewView = ((ViewStub)paramagmj.jdField_b_of_type_AndroidViewView.findViewById(2131362477)).inflate();
      paramagmj.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramagmj.jdField_b_of_type_AndroidViewView.findViewById(2131362467));
      paramagmj.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramagmj.jdField_b_of_type_AndroidViewView.findViewById(2131362451));
    }
    paramagmj.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838259);
    paramagmj.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramagmj.jdField_g_of_type_AndroidViewView.setVisibility(0);
    MessageForQzoneFeed.MediaData localMediaData = (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneFeedItemBuilder", 2, "setDataToSinglePicContainer picUrl= " + localMediaData.strImgUrl);
    }
    if (paramMessageForQzoneFeed.appId == 2)
    {
      paramMessageForQzoneFeed = a(paramMessageForQzoneFeed.title, this.k);
      paramagmj.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed);
    }
    for (;;)
    {
      paramMessageForQzoneFeed = URLDrawable.URLDrawableOptions.obtain();
      paramMessageForQzoneFeed.mRequestWidth = this.jdField_a_of_type_Int;
      paramMessageForQzoneFeed.mRequestHeight = this.c;
      a(paramagmj.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramagmj.jdField_a_of_type_AndroidWidgetImageView, localMediaData, paramMessageForQzoneFeed, new float[] { this.h, this.h, this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      paramagmj.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
    }
  }
  
  private void c(agmj paramagmj, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() < 2)) {
      return;
    }
    paramagmj.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramagmj.jdField_g_of_type_AndroidViewView != null) {
      paramagmj.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramagmj.jdField_i_of_type_AndroidViewView != null) {
      paramagmj.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramagmj.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramagmj.jdField_h_of_type_AndroidViewView == null)
    {
      paramagmj.jdField_h_of_type_AndroidViewView = ((ViewStub)paramagmj.jdField_b_of_type_AndroidViewView.findViewById(2131362472)).inflate();
      paramagmj.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramagmj.jdField_b_of_type_AndroidViewView.findViewById(2131362468));
      paramagmj.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramagmj.jdField_b_of_type_AndroidViewView.findViewById(2131362479));
      paramagmj.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramagmj.jdField_b_of_type_AndroidViewView.findViewById(2131362469));
      paramagmj.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramagmj.jdField_b_of_type_AndroidViewView.findViewById(2131362470));
      paramagmj.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramagmj.jdField_b_of_type_AndroidViewView.findViewById(2131362447));
    }
    paramagmj.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838259);
    paramagmj.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramagmj.jdField_h_of_type_AndroidViewView.setVisibility(0);
    Object localObject;
    if (paramMessageForQzoneFeed.appId == 2)
    {
      localObject = a(paramMessageForQzoneFeed.title, this.k);
      paramagmj.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (paramMessageForQzoneFeed.imageCount <= 2) {
        break label468;
      }
      paramagmj.jdField_e_of_type_AndroidWidgetTextView.setText(String.format("共 %s 个", new Object[] { b(paramMessageForQzoneFeed.imageCount) }));
    }
    for (;;)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.d;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_e_of_type_Int;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.f;
      localURLDrawableOptions.mRequestHeight = this.g;
      a(paramagmj.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramagmj.jdField_b_of_type_AndroidWidgetImageView, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0), (URLDrawable.URLDrawableOptions)localObject, new float[] { this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
      a(paramagmj.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramagmj.jdField_c_of_type_AndroidWidgetImageView, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(1), localURLDrawableOptions, new float[] { 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      paramagmj.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
      break;
      label468:
      paramagmj.jdField_e_of_type_AndroidWidgetTextView.setText("");
    }
  }
  
  private void d(agmj paramagmj, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramagmj.jdField_d_of_type_AndroidViewView.setVisibility(8);
    paramagmj.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramagmj.jdField_i_of_type_AndroidViewView == null)
    {
      paramagmj.jdField_i_of_type_AndroidViewView = ((ViewStub)paramagmj.jdField_b_of_type_AndroidViewView.findViewById(2131362456)).inflate();
      paramagmj.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramagmj.jdField_b_of_type_AndroidViewView.findViewById(2131362457));
      paramagmj.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramagmj.jdField_b_of_type_AndroidViewView.findViewById(2131362455));
    }
    paramagmj.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838261);
    a(paramagmj);
    paramagmj.jdField_i_of_type_AndroidViewView.setVisibility(0);
    String str = a(paramMessageForQzoneFeed.title, this.j);
    paramagmj.jdField_f_of_type_AndroidWidgetTextView.setText(str);
    paramagmj.jdField_g_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  private void e(agmj paramagmj, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramagmj.jdField_d_of_type_AndroidViewView.setVisibility(8);
    if (paramagmj.jdField_i_of_type_AndroidViewView != null) {
      paramagmj.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramagmj.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838261);
    a(paramagmj);
    paramagmj.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    paramagmj.jdField_d_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  protected aexg a()
  {
    return new agmj(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aexg paramaexg, View paramView, LinearLayout paramLinearLayout, afce paramafce)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneFeedItemBuilder", 2, "getItemView: invoked. info: message = " + paramMessageRecord);
    }
    paramLinearLayout = (MessageForQzoneFeed)paramMessageRecord;
    paramMessageRecord = (agmj)paramaexg;
    paramaexg = a(paramView, paramMessageRecord);
    paramMessageRecord.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramMessageRecord.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramMessageRecord.jdField_b_of_type_JavaLangString = null;
    paramLinearLayout.coverImageUrl = a(paramLinearLayout.coverImageUrl);
    a(paramMessageRecord, paramLinearLayout);
    paramMessageRecord.jdField_c_of_type_AndroidViewView.setOnClickListener(new agmg(this, paramLinearLayout));
    if (!paramLinearLayout.hasExposed)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FFF", "0X8005FFF", 0, 0, "", "", "", "");
      paramLinearLayout.hasExposed = true;
    }
    paramView = bjnd.a(paramLinearLayout.actionUrl);
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
      return paramaexg;
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
    ugf.a(localIntent, paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public bgbb[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmf
 * JD-Core Version:    0.7.0.1
 */