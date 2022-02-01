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
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.data.MessageForQCircleFeed.MediaData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;

public class ahew
  extends afuu
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
  
  public ahew(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    paramBaseAdapter = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = afur.a(251.0F, paramBaseAdapter);
    this.c = afur.a(131.0F, paramBaseAdapter);
    this.d = afur.a(128.5F, paramBaseAdapter);
    this.jdField_e_of_type_Int = afur.a(131.0F, paramBaseAdapter);
    this.f = afur.a(122.5F, paramBaseAdapter);
    this.g = afur.a(131.0F, paramBaseAdapter);
    this.h = afur.a(4.0F, paramBaseAdapter);
    this.k = afur.a(71.5F, paramBaseAdapter);
    this.l = afur.a(74.0F, paramBaseAdapter);
    this.m = afur.a(20.0F, paramBaseAdapter);
    this.n = afur.a(20.0F, paramBaseAdapter);
    this.i = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedNicknameMaxLength", 10);
    this.j = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedPicBlogTitleMaxLength", 12);
    this.jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedLogoWaterImgUrl", "https://qzonestyle.gtimg.cn/aoi/sola/20191119115951_pUMyXUXliB.png");
    paramQQAppInterface = (afwx)paramQQAppInterface.getManager(282);
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
  
  private View a(View paramView, ahez paramahez)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558847, null);
      paramahez.jdField_b_of_type_AndroidViewView = paramView;
      paramahez.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362423);
      paramahez.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131362422);
      paramahez.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362430));
      paramahez.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362424));
      paramahez.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131362427));
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
    paramString = bgjw.b(paramString, paramInt);
    return "《" + paramString + "》";
  }
  
  private void a(ahez paramahez, MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    switch (a(paramMessageForQCircleFeed))
    {
    }
    for (;;)
    {
      paramMessageForQCircleFeed = bgjw.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.i);
      paramahez.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697206, new Object[] { paramMessageForQCircleFeed }));
      paramahez.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramMessageForQCircleFeed = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843954);
      paramMessageForQCircleFeed.setBounds(0, 0, this.m, this.n);
      paramahez.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramMessageForQCircleFeed, null, null, null);
      paramahez.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      return;
      b(paramahez, paramMessageForQCircleFeed);
    }
  }
  
  private void b(ahez paramahez, MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    if ((paramMessageForQCircleFeed.mediaDatas == null) || (paramMessageForQCircleFeed.mediaDatas.size() == 0)) {
      return;
    }
    paramahez.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramahez.f != null) {
      paramahez.f.setVisibility(8);
    }
    if (paramahez.e == null)
    {
      paramahez.e = ((ViewStub)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362431)).inflate();
      paramahez.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362425));
      paramahez.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362432));
      paramahez.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362428));
      paramahez.g = paramahez.jdField_b_of_type_AndroidViewView.findViewById(2131362426);
    }
    paramahez.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838218);
    paramahez.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramahez.e.setVisibility(0);
    Object localObject = (MessageForQCircleFeed.MediaData)paramMessageForQCircleFeed.mediaDatas.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("QCircleFeedItemBuilder", 2, "setDataToSinglePicContainer picUrl= " + ((MessageForQCircleFeed.MediaData)localObject).mediaUrl);
    }
    int i1;
    if (paramMessageForQCircleFeed.appId == 2)
    {
      localObject = a(paramMessageForQCircleFeed.title, this.j);
      paramahez.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.c;
      a(paramahez.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramMessageForQCircleFeed, new float[] { this.h, this.h, this.h, this.h, this.h, this.h, this.h, this.h });
      localObject = paramahez.jdField_a_of_type_AndroidWidgetImageView;
      if (paramMessageForQCircleFeed.type != 3) {
        break label459;
      }
      i1 = 0;
      label359:
      ((ImageView)localObject).setVisibility(i1);
      if (paramMessageForQCircleFeed.imageCount <= 1) {
        break label465;
      }
      paramahez.jdField_d_of_type_AndroidWidgetTextView.setText(a(paramMessageForQCircleFeed.imageCount));
      paramahez.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      paramahez.g.setVisibility(0);
    }
    for (;;)
    {
      QLog.d("QCircleFeedItemBuilder", 2, "message.imageCount=" + paramMessageForQCircleFeed.imageCount);
      return;
      if (TextUtils.isEmpty(paramMessageForQCircleFeed.content)) {
        break;
      }
      paramahez.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQCircleFeed.content);
      break;
      label459:
      i1 = 8;
      break label359;
      label465:
      paramahez.jdField_d_of_type_AndroidWidgetTextView.setText("");
      paramahez.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      paramahez.g.setVisibility(8);
    }
  }
  
  protected afuv a()
  {
    return new ahez(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afuv paramafuv, View paramView, LinearLayout paramLinearLayout, afzq paramafzq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCircleFeedItemBuilder", 2, "getItemView: invoked. info: message = " + paramMessageRecord);
    }
    paramMessageRecord = (MessageForQCircleFeed)paramMessageRecord;
    paramafuv = (ahez)paramafuv;
    paramView = a(paramView, paramafuv);
    paramafuv.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramafuv.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    paramafuv.jdField_b_of_type_JavaLangString = null;
    paramMessageRecord.coverImageUrl = a(paramMessageRecord.coverImageUrl);
    a(paramafuv, paramMessageRecord);
    paramafuv.jdField_c_of_type_AndroidViewView.setOnClickListener(new ahex(this, paramMessageRecord));
    return paramView;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  protected void a(CornerImageView paramCornerImageView, MessageForQCircleFeed paramMessageForQCircleFeed, float[] paramArrayOfFloat)
  {
    String str = "";
    if ((paramCornerImageView.getTag(2131362448) instanceof String)) {
      str = (String)paramCornerImageView.getTag(2131362448);
    }
    paramCornerImageView.setRadius(paramArrayOfFloat);
    paramCornerImageView.setTag(2131362448, paramMessageForQCircleFeed.coverImageUrl);
    if (!str.equals(paramMessageForQCircleFeed.coverImageUrl))
    {
      paramCornerImageView = new vou().a(paramMessageForQCircleFeed.coverImageUrl).a(paramCornerImageView).b(false).a(true).c(paramCornerImageView.getLayoutParams().width).b(paramCornerImageView.getLayoutParams().height);
      QCircleFeedPicLoader.a().a(paramCornerImageView, new ahey(this));
    }
  }
  
  public bguj[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahew
 * JD-Core Version:    0.7.0.1
 */