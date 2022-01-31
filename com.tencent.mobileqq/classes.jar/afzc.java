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

public class afzc
  extends aepl
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
  
  public afzc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    paramBaseAdapter = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = aepi.a(251.0F, paramBaseAdapter);
    this.c = aepi.a(131.0F, paramBaseAdapter);
    this.d = aepi.a(128.5F, paramBaseAdapter);
    this.jdField_e_of_type_Int = aepi.a(131.0F, paramBaseAdapter);
    this.f = aepi.a(122.5F, paramBaseAdapter);
    this.g = aepi.a(131.0F, paramBaseAdapter);
    this.h = aepi.a(16.0F, paramBaseAdapter);
    this.l = aepi.a(71.5F, paramBaseAdapter);
    this.m = aepi.a(74.0F, paramBaseAdapter);
    this.i = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedNicknameMaxLength", 10);
    this.j = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedBlogTitleMaxLength", 8);
    this.k = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedPicBlogTitleMaxLength", 12);
    this.jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedLogoWaterImgUrl", "https://qzonestyle.gtimg.cn/aoi/sola/20191119115951_pUMyXUXliB.png");
    paramQQAppInterface = (aeqn)paramQQAppInterface.getManager(282);
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
  
  private View a(View paramView, afzg paramafzg)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558787, null);
      paramafzg.jdField_b_of_type_AndroidViewView = paramView;
      paramafzg.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362356);
      paramafzg.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131362347);
      paramafzg.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362368));
      paramafzg.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362360));
      paramafzg.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362371));
      paramafzg.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131362365));
      localView = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramafzg.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (jdField_e_of_type_Boolean)
    {
      localView.setContentDescription(null);
      paramafzg.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramafzg.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
    paramString = bdeu.b(paramString, paramInt);
    return "《" + paramString + "》";
  }
  
  private void a(afzg paramafzg)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.l;
    localURLDrawableOptions.mRequestHeight = this.m;
    paramafzg.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(0);
    paramafzg.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F });
    paramafzg.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setAlpha(0.08F);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
    paramafzg.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions));
  }
  
  private void a(afzg paramafzg, int paramInt)
  {
    if (paramafzg.jdField_e_of_type_AndroidViewView == null)
    {
      paramafzg.jdField_e_of_type_AndroidViewView = ((ViewStub)paramafzg.jdField_b_of_type_AndroidViewView.findViewById(2131362359)).inflate();
      paramafzg.k = ((TextView)paramafzg.jdField_e_of_type_AndroidViewView.findViewById(2131362357));
    }
    paramafzg.jdField_e_of_type_AndroidViewView.setOnClickListener(new afze(this));
    paramafzg.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (paramafzg.jdField_f_of_type_AndroidViewView != null) {
      paramafzg.jdField_f_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramafzg.jdField_b_of_type_AndroidWidgetTextView != null) {
      paramafzg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    String str = "TA";
    if (paramInt == 1) {
      str = alud.a(2131712208);
    }
    for (;;)
    {
      if (paramafzg.k != null) {
        paramafzg.k.setText(alud.a(2131712221) + str + alud.a(2131712237));
      }
      paramafzg = new bjdn();
      paramafzg.c = "330";
      paramafzg.d = "3";
      paramafzg.e = "1";
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramafzg);
      return;
      if (paramInt == 2) {
        str = alud.a(2131712219);
      }
    }
  }
  
  private void a(afzg paramafzg, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    boolean bool2 = false;
    String str2;
    Object localObject;
    CharSequence localCharSequence;
    switch (a(paramMessageForQzoneFeed))
    {
    default: 
      str2 = bdeu.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.i);
      localObject = str2 + paramMessageForQzoneFeed.summery;
      paramafzg.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramafzg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localCharSequence = bdns.a(this.jdField_a_of_type_AndroidContentContext, 7, paramMessageForQzoneFeed.feedTime * 1000L);
      if (paramMessageForQzoneFeed.isFirstMsgWithNewFriend) {
        a(paramafzg, paramMessageForQzoneFeed.gender);
      }
      break;
    }
    for (;;)
    {
      if (jdField_e_of_type_Boolean)
      {
        paramafzg.jdField_b_of_type_JavaLangStringBuilder.append(str2);
        if (paramMessageForQzoneFeed.feedTime > 0L) {
          paramafzg.jdField_b_of_type_JavaLangStringBuilder.append("于").append(localCharSequence);
        }
        paramafzg.jdField_b_of_type_JavaLangStringBuilder.append(paramMessageForQzoneFeed.summery).append("内容是：").append(paramMessageForQzoneFeed.title).append(paramMessageForQzoneFeed.content);
        paramafzg.jdField_b_of_type_AndroidViewView.setContentDescription(paramafzg.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      return;
      b(paramafzg, paramMessageForQzoneFeed);
      break;
      c(paramafzg, paramMessageForQzoneFeed);
      break;
      e(paramafzg, paramMessageForQzoneFeed);
      break;
      d(paramafzg, paramMessageForQzoneFeed);
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
      a(paramafzg, localCharSequence, paramMessageForQzoneFeed, paramMessageForQzoneFeed.ulikeNum, paramMessageForQzoneFeed.uCommentNum, paramMessageForQzoneFeed.appId, bool1, (String)localObject);
    }
  }
  
  private void a(afzg paramafzg, CharSequence paramCharSequence, MessageForQzoneFeed paramMessageForQzoneFeed, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, String paramString)
  {
    if (paramafzg.jdField_f_of_type_AndroidViewView == null)
    {
      paramafzg.jdField_f_of_type_AndroidViewView = ((ViewStub)paramafzg.jdField_b_of_type_AndroidViewView.findViewById(2131362353)).inflate();
      paramafzg.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramafzg.jdField_f_of_type_AndroidViewView.findViewById(2131362373));
      paramafzg.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramafzg.jdField_f_of_type_AndroidViewView.findViewById(2131362370));
      paramafzg.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramafzg.jdField_f_of_type_AndroidViewView.findViewById(2131362369));
      paramafzg.j = ((TextView)paramafzg.jdField_f_of_type_AndroidViewView.findViewById(2131362355));
    }
    paramafzg.jdField_h_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    paramafzg.jdField_i_of_type_AndroidWidgetTextView.setText(b(paramInt1));
    paramCharSequence = paramafzg.jdField_d_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i1 = 2130847052;; i1 = 2130847051)
    {
      paramCharSequence.setImageResource(i1);
      paramafzg.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(new afzf(this, paramBoolean, paramInt1, paramafzg, paramString, paramInt2, paramMessageForQzoneFeed));
      paramafzg.j.setText(b(paramLong));
      paramafzg.jdField_f_of_type_AndroidViewView.setVisibility(0);
      if (paramafzg.jdField_e_of_type_AndroidViewView != null) {
        paramafzg.jdField_e_of_type_AndroidViewView.setVisibility(8);
      }
      if (paramafzg.jdField_b_of_type_AndroidWidgetTextView != null) {
        paramafzg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
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
  
  private void b(afzg paramafzg, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() == 0)) {
      return;
    }
    paramafzg.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramafzg.jdField_h_of_type_AndroidViewView != null) {
      paramafzg.jdField_h_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramafzg.jdField_i_of_type_AndroidViewView != null) {
      paramafzg.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramafzg.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramafzg.jdField_g_of_type_AndroidViewView == null)
    {
      paramafzg.jdField_g_of_type_AndroidViewView = ((ViewStub)paramafzg.jdField_b_of_type_AndroidViewView.findViewById(2131362372)).inflate();
      paramafzg.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramafzg.jdField_b_of_type_AndroidViewView.findViewById(2131362361));
      paramafzg.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramafzg.jdField_b_of_type_AndroidViewView.findViewById(2131362374));
    }
    paramafzg.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838122);
    paramafzg.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramafzg.jdField_g_of_type_AndroidViewView.setVisibility(0);
    MessageForQzoneFeed.MediaData localMediaData = (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneFeedItemBuilder", 2, "setDataToSinglePicContainer picUrl= " + localMediaData.strImgUrl);
    }
    if (paramMessageForQzoneFeed.appId == 2)
    {
      paramMessageForQzoneFeed = a(paramMessageForQzoneFeed.title, this.k);
      paramafzg.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed);
    }
    for (;;)
    {
      paramMessageForQzoneFeed = URLDrawable.URLDrawableOptions.obtain();
      paramMessageForQzoneFeed.mRequestWidth = this.jdField_a_of_type_Int;
      paramMessageForQzoneFeed.mRequestHeight = this.c;
      a(paramafzg.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramafzg.jdField_a_of_type_AndroidWidgetImageView, localMediaData, paramMessageForQzoneFeed, new float[] { this.h, this.h, this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      paramafzg.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
    }
  }
  
  private void c(afzg paramafzg, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    if ((paramMessageForQzoneFeed.mediaDatas == null) || (paramMessageForQzoneFeed.mediaDatas.size() < 2)) {
      return;
    }
    paramafzg.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramafzg.jdField_g_of_type_AndroidViewView != null) {
      paramafzg.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramafzg.jdField_i_of_type_AndroidViewView != null) {
      paramafzg.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramafzg.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramafzg.jdField_h_of_type_AndroidViewView == null)
    {
      paramafzg.jdField_h_of_type_AndroidViewView = ((ViewStub)paramafzg.jdField_b_of_type_AndroidViewView.findViewById(2131362367)).inflate();
      paramafzg.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramafzg.jdField_b_of_type_AndroidViewView.findViewById(2131362362));
      paramafzg.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramafzg.jdField_b_of_type_AndroidViewView.findViewById(2131362375));
      paramafzg.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramafzg.jdField_b_of_type_AndroidViewView.findViewById(2131362363));
      paramafzg.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramafzg.jdField_b_of_type_AndroidViewView.findViewById(2131362364));
      paramafzg.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramafzg.jdField_b_of_type_AndroidViewView.findViewById(2131362366));
    }
    paramafzg.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838122);
    paramafzg.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramafzg.jdField_h_of_type_AndroidViewView.setVisibility(0);
    Object localObject;
    if (paramMessageForQzoneFeed.appId == 2)
    {
      localObject = a(paramMessageForQzoneFeed.title, this.k);
      paramafzg.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      if (paramMessageForQzoneFeed.imageCount <= 2) {
        break label468;
      }
      paramafzg.jdField_e_of_type_AndroidWidgetTextView.setText(String.format("共 %s 个", new Object[] { b(paramMessageForQzoneFeed.imageCount) }));
    }
    for (;;)
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.d;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_e_of_type_Int;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.f;
      localURLDrawableOptions.mRequestHeight = this.g;
      a(paramafzg.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramafzg.jdField_b_of_type_AndroidWidgetImageView, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(0), (URLDrawable.URLDrawableOptions)localObject, new float[] { this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
      a(paramafzg.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramafzg.jdField_c_of_type_AndroidWidgetImageView, (MessageForQzoneFeed.MediaData)paramMessageForQzoneFeed.mediaDatas.get(1), localURLDrawableOptions, new float[] { 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F });
      return;
      paramafzg.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
      break;
      label468:
      paramafzg.jdField_e_of_type_AndroidWidgetTextView.setText("");
    }
  }
  
  private void d(afzg paramafzg, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramafzg.jdField_d_of_type_AndroidViewView.setVisibility(8);
    paramafzg.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    if (paramafzg.jdField_i_of_type_AndroidViewView == null)
    {
      paramafzg.jdField_i_of_type_AndroidViewView = ((ViewStub)paramafzg.jdField_b_of_type_AndroidViewView.findViewById(2131362350)).inflate();
      paramafzg.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramafzg.jdField_b_of_type_AndroidViewView.findViewById(2131362351));
      paramafzg.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramafzg.jdField_b_of_type_AndroidViewView.findViewById(2131362349));
    }
    paramafzg.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838124);
    a(paramafzg);
    paramafzg.jdField_i_of_type_AndroidViewView.setVisibility(0);
    String str = a(paramMessageForQzoneFeed.title, this.j);
    paramafzg.jdField_f_of_type_AndroidWidgetTextView.setText(str);
    paramafzg.jdField_g_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  private void e(afzg paramafzg, MessageForQzoneFeed paramMessageForQzoneFeed)
  {
    paramafzg.jdField_d_of_type_AndroidViewView.setVisibility(8);
    if (paramafzg.jdField_i_of_type_AndroidViewView != null) {
      paramafzg.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    paramafzg.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838124);
    a(paramafzg);
    paramafzg.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    paramafzg.jdField_d_of_type_AndroidWidgetTextView.setText(paramMessageForQzoneFeed.content);
  }
  
  protected aepm a()
  {
    return new afzg(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aepm paramaepm, View paramView, LinearLayout paramLinearLayout, aetk paramaetk)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QzoneFeedItemBuilder", 2, "getItemView: invoked. info: message = " + paramMessageRecord);
    }
    paramLinearLayout = (MessageForQzoneFeed)paramMessageRecord;
    paramMessageRecord = (afzg)paramaepm;
    paramaepm = a(paramView, paramMessageRecord);
    paramMessageRecord.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramMessageRecord.jdField_a_of_type_JavaLangString = paramLinearLayout.frienduin;
    paramMessageRecord.jdField_b_of_type_JavaLangString = null;
    paramLinearLayout.coverImageUrl = a(paramLinearLayout.coverImageUrl);
    a(paramMessageRecord, paramLinearLayout);
    paramMessageRecord.jdField_c_of_type_AndroidViewView.setOnClickListener(new afzd(this, paramLinearLayout));
    if (!paramLinearLayout.hasExposed)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FFF", "0X8005FFF", 0, 0, "", "", "", "");
      paramLinearLayout.hasExposed = true;
    }
    paramView = bhsz.a(paramLinearLayout.actionUrl);
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
      paramView = new bjdn();
      paramView.c = "330";
      paramView.d = "1";
      paramView.e = paramMessageRecord;
      if (paramLinearLayout.isFirstMsgWithNewFriend) {
        paramView.i = "1";
      }
      paramView.a = new ArrayList();
      paramView.a.add(paramLinearLayout.actionUrl);
      QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramView);
      return paramaepm;
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
    syb.a(localIntent, paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    return true;
  }
  
  public bdpk[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afzc
 * JD-Core Version:    0.7.0.1
 */