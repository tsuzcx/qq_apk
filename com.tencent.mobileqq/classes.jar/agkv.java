import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.data.MessageForQCircleFeed.MediaData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.picload.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;

public class agkv
  extends aexf
{
  private static int o = -1;
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
  private final int n;
  
  public agkv(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    paramBaseAdapter = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = AIOUtils.dp2px(251.0F, paramBaseAdapter);
    this.c = AIOUtils.dp2px(131.0F, paramBaseAdapter);
    this.d = AIOUtils.dp2px(128.5F, paramBaseAdapter);
    this.jdField_e_of_type_Int = AIOUtils.dp2px(131.0F, paramBaseAdapter);
    this.f = AIOUtils.dp2px(122.5F, paramBaseAdapter);
    this.g = AIOUtils.dp2px(131.0F, paramBaseAdapter);
    this.h = AIOUtils.dp2px(4.0F, paramBaseAdapter);
    this.k = AIOUtils.dp2px(71.5F, paramBaseAdapter);
    this.l = AIOUtils.dp2px(74.0F, paramBaseAdapter);
    this.m = AIOUtils.dp2px(20.0F, paramBaseAdapter);
    this.n = AIOUtils.dp2px(20.0F, paramBaseAdapter);
    this.i = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedNicknameMaxLength", 10);
    this.j = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedPicBlogTitleMaxLength", 12);
    this.jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedLogoWaterImgUrl", "https://qzonestyle.gtimg.cn/aoi/sola/20191119115951_pUMyXUXliB.png");
    paramQQAppInterface = (aezm)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 12);
    }
  }
  
  private int a(MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    int i1 = 1;
    if (paramMessageForQCircleFeed.mediaDatas != null)
    {
      if (paramMessageForQCircleFeed.mediaDatas.size() > 1) {
        i1 = 2;
      }
      return i1;
    }
    if (!TextUtils.isEmpty(paramMessageForQCircleFeed.title)) {
      return 4;
    }
    return 3;
  }
  
  private View a(View paramView, agky paramagky)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558853, null);
      paramagky.jdField_b_of_type_AndroidViewView = paramView;
      paramagky.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362442);
      paramagky.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131362441);
      paramagky.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362449));
      paramagky.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362443));
      paramagky.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131362446));
      localView = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramagky.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (jdField_e_of_type_Boolean)
    {
      localView.setContentDescription(null);
      paramagky.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramagky.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localView;
  }
  
  private static String a(long paramLong)
  {
    if (paramLong > 100000000L) {
      return String.format("%.1f亿", new Object[] { Float.valueOf((float)paramLong / 1.0E+008F) });
    }
    if (paramLong > 10000L) {
      return String.format("%.1f万", new Object[] { Float.valueOf((float)paramLong / 10000.0F) });
    }
    return String.format("%d", new Object[] { Long.valueOf(paramLong) });
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
    return paramString.substring(i1);
  }
  
  private static String a(String paramString, int paramInt)
  {
    paramString = bftf.b(paramString, paramInt);
    return "《" + paramString + "》";
  }
  
  private void a(agky paramagky, MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    switch (a(paramMessageForQCircleFeed))
    {
    }
    for (;;)
    {
      paramMessageForQCircleFeed = bftf.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, this.i);
      paramagky.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697418, new Object[] { paramMessageForQCircleFeed }));
      paramagky.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramMessageForQCircleFeed = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843981);
      paramMessageForQCircleFeed.setBounds(0, 0, this.m, this.n);
      paramagky.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramMessageForQCircleFeed, null, null, null);
      paramagky.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      return;
      b(paramagky, paramMessageForQCircleFeed);
    }
  }
  
  private void b(agky paramagky, MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    if ((paramMessageForQCircleFeed.mediaDatas == null) || (paramMessageForQCircleFeed.mediaDatas.size() == 0)) {
      return;
    }
    paramagky.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramagky.f != null) {
      paramagky.f.setVisibility(8);
    }
    if (paramagky.e == null)
    {
      paramagky.e = ((ViewStub)paramagky.jdField_b_of_type_AndroidViewView.findViewById(2131362450)).inflate();
      paramagky.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramagky.jdField_b_of_type_AndroidViewView.findViewById(2131362444));
      paramagky.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramagky.jdField_b_of_type_AndroidViewView.findViewById(2131362451));
      paramagky.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramagky.jdField_b_of_type_AndroidViewView.findViewById(2131362447));
      paramagky.g = paramagky.jdField_b_of_type_AndroidViewView.findViewById(2131362445);
    }
    paramagky.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838259);
    paramagky.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramagky.e.setVisibility(0);
    Object localObject = (MessageForQCircleFeed.MediaData)paramMessageForQCircleFeed.mediaDatas.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("QCircleFeedItemBuilder", 2, "setDataToSinglePicContainer picUrl= " + ((MessageForQCircleFeed.MediaData)localObject).mediaUrl);
    }
    int i1;
    if (paramMessageForQCircleFeed.appId == 2)
    {
      localObject = a(paramMessageForQCircleFeed.title, this.j);
      paramagky.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.c;
      a(paramagky.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramMessageForQCircleFeed, new float[] { this.h, this.h, this.h, this.h, this.h, this.h, this.h, this.h });
      localObject = paramagky.jdField_a_of_type_AndroidWidgetImageView;
      if (paramMessageForQCircleFeed.type != 3) {
        break label459;
      }
      i1 = 0;
      label359:
      ((ImageView)localObject).setVisibility(i1);
      if (paramMessageForQCircleFeed.imageCount <= 1) {
        break label465;
      }
      paramagky.jdField_d_of_type_AndroidWidgetTextView.setText(a(paramMessageForQCircleFeed.imageCount));
      paramagky.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      paramagky.g.setVisibility(0);
    }
    for (;;)
    {
      QLog.d("QCircleFeedItemBuilder", 2, "message.imageCount=" + paramMessageForQCircleFeed.imageCount);
      return;
      if (TextUtils.isEmpty(paramMessageForQCircleFeed.content)) {
        break;
      }
      paramagky.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQCircleFeed.content);
      break;
      label459:
      i1 = 8;
      break label359;
      label465:
      paramagky.jdField_d_of_type_AndroidWidgetTextView.setText("");
      paramagky.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      paramagky.g.setVisibility(8);
    }
  }
  
  protected aexg a()
  {
    return new agky(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aexg paramaexg, View paramView, LinearLayout paramLinearLayout, afce paramafce)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCircleFeedItemBuilder", 2, "getItemView: invoked. info: message = " + paramMessageRecord);
    }
    paramMessageRecord = (MessageForQCircleFeed)paramMessageRecord;
    paramaexg = (agky)paramaexg;
    paramView = a(paramView, paramaexg);
    paramaexg.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramaexg.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    paramaexg.jdField_b_of_type_JavaLangString = null;
    paramMessageRecord.coverImageUrl = a(paramMessageRecord.coverImageUrl);
    a(paramaexg, paramMessageRecord);
    paramaexg.jdField_c_of_type_AndroidViewView.setOnClickListener(new agkw(this, paramMessageRecord));
    return paramView;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  protected void a(CornerImageView paramCornerImageView, MessageForQCircleFeed paramMessageForQCircleFeed, float[] paramArrayOfFloat)
  {
    String str = "";
    if ((paramCornerImageView.getTag(2131362467) instanceof String)) {
      str = (String)paramCornerImageView.getTag(2131362467);
    }
    paramCornerImageView.setRadius(paramArrayOfFloat);
    paramCornerImageView.setTag(2131362467, paramMessageForQCircleFeed.coverImageUrl);
    if (!str.equals(paramMessageForQCircleFeed.coverImageUrl))
    {
      paramCornerImageView = new Option().setUrl(paramMessageForQCircleFeed.coverImageUrl).setTargetView(paramCornerImageView).setFromPreLoad(false).setPredecode(true).setRequestWidth(paramCornerImageView.getLayoutParams().width).setRequestHeight(paramCornerImageView.getLayoutParams().height);
      QCircleFeedPicLoader.g().loadImage(paramCornerImageView, new agkx(this));
    }
  }
  
  public bgbb[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkv
 * JD-Core Version:    0.7.0.1
 */