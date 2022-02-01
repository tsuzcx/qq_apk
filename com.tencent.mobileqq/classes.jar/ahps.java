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

public class ahps
  extends agem
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
  
  public ahps(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    paramBaseAdapter = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = agej.a(251.0F, paramBaseAdapter);
    this.c = agej.a(131.0F, paramBaseAdapter);
    this.d = agej.a(128.5F, paramBaseAdapter);
    this.jdField_e_of_type_Int = agej.a(131.0F, paramBaseAdapter);
    this.f = agej.a(122.5F, paramBaseAdapter);
    this.g = agej.a(131.0F, paramBaseAdapter);
    this.h = agej.a(16.0F, paramBaseAdapter);
    this.l = agej.a(71.5F, paramBaseAdapter);
    this.m = agej.a(74.0F, paramBaseAdapter);
    this.i = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedNicknameMaxLength", 10);
    this.j = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedBlogTitleMaxLength", 8);
    this.k = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedPicBlogTitleMaxLength", 12);
    this.jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedLogoWaterImgUrl", "https://qzonestyle.gtimg.cn/aoi/sola/20191119115951_pUMyXUXliB.png");
    paramQQAppInterface = (aggr)paramQQAppInterface.getManager(282);
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
  
  private View a(View paramView, ahpw paramahpw)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558853, null);
      paramahpw.jdField_b_of_type_AndroidViewView = paramView;
      paramahpw.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362458);
      paramahpw.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131362449);
      paramahpw.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362469));
      paramahpw.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362462));
      paramahpw.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362472));
      paramahpw.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131362467));
      localView = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramahpw.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (jdField_e_of_type_Boolean)
    {
      localView.setContentDescription(null);
      paramahpw.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramahpw.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
    paramString = bhjx.b(paramString, paramInt);
    return "《" + paramString + "》";
  }
  
  private void a(ahpw paramahpw)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.l;
    localURLDrawableOptions.mRequestHeight = this.m;
    paramahpw.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(0);
    paramahpw.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F });
    paramahpw.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setAlpha(0.08F);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
    paramahpw.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions));
  }
  
  private void a(ahpw paramahpw, int paramInt)
  {
    if (paramahpw.jdField_e_of_type_AndroidViewView == null)
    {
      paramahpw.jdField_e_of_type_AndroidViewView = ((ViewStub)paramahpw.jdField_b_of_type_AndroidViewView.findViewById(2131362461)).inflate();
      paramahpw.k = ((TextView)paramahpw.jdField_e_of_type_AndroidViewView.findViewById(2131362459));
    }
    paramahpw.jdField_e_of_type_AndroidViewView.setOnClickListener(new ahpu(this));
    paramahpw.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (paramahpw.jdField_f_of_type_AndroidViewView != null) {
      paramahpw.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramahpw.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramahpw.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    String str = "TA";
    if (paramInt == 1) {
      str = anzj.a(2131710696);
    }
    for (;;)
    {
      if (paramahpw.k != null) {
        paramahpw.k.setText(anzj.a(2131710709) + str + anzj.a(2131710725));
      }
      paramahpw = new bmsx();
      paramahpw.c = "330";
      paramahpw.d = "3";
      paramahpw.e = "1";
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramahpw);
      return;
      if (paramInt == 2) {
        str = anzj.a(2131710707);
      }
    }
  }
  
  private void a(ahpw paramahpw, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    boolean bool2 = false;
    String str2;
    Object localObject;
    CharSequence localCharSequence;
    switch (a(paramMessageForQzoneFeed))
    {
    default: 
      str2 = bhjx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.i);
      localObject = str2 + paramMessageForQzoneFeed.summery;
      paramahpw.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramahpw.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localCharSequence = bhsw.a(this.jdField_a_of_type_AndroidContentContext, 7, paramMessageForQzoneFeed.feedTime * 1000L);
      if (paramMessageForQzoneFeed.isFirstMsgWithNewFriend) {
        a(paramahpw, paramMessageForQzoneFeed.gender);
      }
      break;
    }
    for (;;)
    {
      if (jdField_e_of_type_Boolean)
      {
        paramahpw.jdField_b_of_type_JavaLangStringBuilder.append(str2);
        if (paramMessageForQzoneFeed.feedTime > 0L) {
          paramahpw.jdField_b_of_type_JavaLangStringBuilder.append("于").append(localCharSequence);
        }
        paramahpw.jdField_b_of_type_JavaLangStringBuilder.append(paramMessageForQzoneFeed.summery).append("内容是：").append(paramMessageForQzoneFeed.title).append(paramMessageForQzoneFeed.content);
        paramahpw.jdField_b_of_type_AndroidViewView.setContentDescription(paramahpw.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      return;
      b(paramahpw, paramMessageForQzoneFeed);
      break;
      c(paramahpw, paramMessageForQzoneFeed);
      break;
      e(paramahpw, paramMessageForQzoneFeed);
      break;
      d(paramahpw, paramMessageForQzoneFeed);
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
      a(paramahpw, localCharSequence, paramMessageForQzoneFeed, paramMessageForQzoneFeed.ulikeNum, paramMessageForQzoneFeed.uCommentNum, paramMessageForQzoneFeed.appId, bool1, (String)localObject);
    }
  }
  
  private void a(ahpw paramahpw, CharSequence paramCharSequence, MessageForQzoneFeed paramMessageForQzoneFeed, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (paramahpw.jdField_f_of_type_AndroidViewView == null)
    {
      paramahpw.jdField_f_of_type_AndroidViewView = ((ViewStub)paramahpw.jdField_b_of_type_AndroidViewView.findViewById(2131362455)).inflate();
      paramahpw.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramahpw.jdField_f_of_type_AndroidViewView.findViewById(2131362474));
      paramahpw.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramahpw.jdField_f_of_type_AndroidViewView.findViewById(2131362471));
      paramahpw.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramahpw.jdField_f_of_type_AndroidViewView.findViewById(2131362470));
      paramahpw.j = ((TextView)paramahpw.jdField_f_of_type_AndroidViewView.findViewById(2131362457));
    }
    paramahpw.jdField_h_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    paramahpw.jdField_i_of_type_AndroidWidgetTextView.setText(b(paramInt1));
    paramCharSequence = paramahpw.jdField_d_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i1 = 2130847530;; i1 = 2130847529)
    {
      paramCharSequence.setImageResource(i1);
      paramahpw.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new ahpv(this, paramBoolean, paramInt1, paramahpw, paramString, paramInt2, paramMessageForQzoneFeed));
      paramahpw.j.setText(b(paramLong));
      paramahpw.jdField_f_of_type_AndroidViewView.setVisibility(0);
      if (paramahpw.jdField_e_of_type_AndroidViewView != null) {
        paramahpw.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      if (paramahpw.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramahpw.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
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
  
  private void b(ahpw paramahpw, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() == 0)) {
      return;
    }
    paramahpw.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramahpw.jdField_h_of_type_AndroidViewView != null) {
      paramahpw.jdField_h_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramahpw.jdField_i_of_type_AndroidViewView != null) {
      paramahpw.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramahpw.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramahpw.jdField_g_of_type_AndroidViewView == null)
    {
      paramahpw.jdField_g_of_type_AndroidViewView = ((ViewStub)paramahpw.jdField_b_of_type_AndroidViewView.findViewById(2131362473)).inflate();
      paramahpw.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramahpw.jdField_b_of_type_AndroidViewView.findViewById(2131362463));
      paramahpw.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramahpw.jdField_b_of_type_AndroidViewView.findViewById(2131362447));
    }
    paramahpw.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838228);
    paramahpw.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramahpw.jdField_g_of_type_AndroidViewView.setVisibility(0);
    MessageForQzoneFeed.MediaData localMediaData = (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneFeedItemBuilder", 2, "setDataToSinglePicContainer picUrl= " + localMediaData.strImgUrl);
    }
    if (paramMessageForQzoneFeed.appId == 2)
    {
      paramMessageForQzoneFeed = a(paramMessageForQzoneFeed.title, this.k);
      paramahpw.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed);
    }
    for (;;)
    {
      paramMessageForQzoneFeed = URLDrawable.URLDrawableOptions.obtain();
      paramMessageForQzoneFeed.mRequestWidth = this.jdField_a_of_type_Int;
      paramMessageForQzoneFeed.mRequestHeight = this.c;
      a(paramahpw.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramahpw.jdField_a_of_type_AndroidWidgetImageView, localMediaData, paramMessageForQzoneFeed, new float[] { this.h, this.h, this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      paramahpw.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
    }
  }
  
  private void c(ahpw paramahpw, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() < 2)) {
      return;
    }
    paramahpw.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramahpw.jdField_g_of_type_AndroidViewView != null) {
      paramahpw.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramahpw.jdField_i_of_type_AndroidViewView != null) {
      paramahpw.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramahpw.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramahpw.jdField_h_of_type_AndroidViewView == null)
    {
      paramahpw.jdField_h_of_type_AndroidViewView = ((ViewStub)paramahpw.jdField_b_of_type_AndroidViewView.findViewById(2131362468)).inflate();
      paramahpw.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramahpw.jdField_b_of_type_AndroidViewView.findViewById(2131362464));
      paramahpw.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramahpw.jdField_b_of_type_AndroidViewView.findViewById(2131362475));
      paramahpw.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramahpw.jdField_b_of_type_AndroidViewView.findViewById(2131362465));
      paramahpw.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramahpw.jdField_b_of_type_AndroidViewView.findViewById(2131362466));
      paramahpw.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramahpw.jdField_b_of_type_AndroidViewView.findViewById(2131362443));
    }
    paramahpw.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838228);
    paramahpw.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramahpw.jdField_h_of_type_AndroidViewView.setVisibility(0);
    Object localObject;
    if (paramMessageForQzoneFeed.appId == 2)
    {
      localObject = a(paramMessageForQzoneFeed.title, this.k);
      paramahpw.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (paramMessageForQzoneFeed.imageCount <= 2) {
        break label468;
      }
      paramahpw.jdField_e_of_type_AndroidWidgetTextView.setText(String.format("共 %s 个", new Object[] { b(paramMessageForQzoneFeed.imageCount) }));
    }
    for (;;)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.d;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_e_of_type_Int;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.f;
      localURLDrawableOptions.mRequestHeight = this.g;
      a(paramahpw.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramahpw.jdField_b_of_type_AndroidWidgetImageView, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0), (URLDrawable.URLDrawableOptions)localObject, new float[] { this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
      a(paramahpw.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramahpw.jdField_c_of_type_AndroidWidgetImageView, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(1), localURLDrawableOptions, new float[] { 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      paramahpw.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
      break;
      label468:
      paramahpw.jdField_e_of_type_AndroidWidgetTextView.setText("");
    }
  }
  
  private void d(ahpw paramahpw, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramahpw.jdField_d_of_type_AndroidViewView.setVisibility(8);
    paramahpw.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramahpw.jdField_i_of_type_AndroidViewView == null)
    {
      paramahpw.jdField_i_of_type_AndroidViewView = ((ViewStub)paramahpw.jdField_b_of_type_AndroidViewView.findViewById(2131362452)).inflate();
      paramahpw.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramahpw.jdField_b_of_type_AndroidViewView.findViewById(2131362453));
      paramahpw.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramahpw.jdField_b_of_type_AndroidViewView.findViewById(2131362451));
    }
    paramahpw.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838230);
    a(paramahpw);
    paramahpw.jdField_i_of_type_AndroidViewView.setVisibility(0);
    String str = a(paramMessageForQzoneFeed.title, this.j);
    paramahpw.jdField_f_of_type_AndroidWidgetTextView.setText(str);
    paramahpw.jdField_g_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  private void e(ahpw paramahpw, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramahpw.jdField_d_of_type_AndroidViewView.setVisibility(8);
    if (paramahpw.jdField_i_of_type_AndroidViewView != null) {
      paramahpw.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramahpw.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838230);
    a(paramahpw);
    paramahpw.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    paramahpw.jdField_d_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  protected agen a()
  {
    return new ahpw(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneFeedItemBuilder", 2, "getItemView: invoked. info: message = " + paramMessageRecord);
    }
    paramLinearLayout = (MessageForQzoneFeed)paramMessageRecord;
    paramMessageRecord = (ahpw)paramagen;
    paramagen = a(paramView, paramMessageRecord);
    paramMessageRecord.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramMessageRecord.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramMessageRecord.jdField_b_of_type_JavaLangString = null;
    paramLinearLayout.coverImageUrl = a(paramLinearLayout.coverImageUrl);
    a(paramMessageRecord, paramLinearLayout);
    paramMessageRecord.jdField_c_of_type_AndroidViewView.setOnClickListener(new ahpt(this, paramLinearLayout));
    if (!paramLinearLayout.hasExposed)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FFF", "0X8005FFF", 0, 0, "", "", "", "");
      paramLinearLayout.hasExposed = true;
    }
    paramView = blhn.a(paramLinearLayout.actionUrl);
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
      paramView = new bmsx();
      paramView.c = "330";
      paramView.d = "1";
      paramView.e = paramMessageRecord;
      if (paramLinearLayout.isFirstMsgWithNewFriend) {
        paramView.i = "1";
      }
      paramView.a = new ArrayList();
      paramView.a.add(paramLinearLayout.actionUrl);
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramView);
      return paramagen;
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
    tzq.a(localIntent, paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public bhum[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahps
 * JD-Core Version:    0.7.0.1
 */