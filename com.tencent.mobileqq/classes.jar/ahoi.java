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

public class ahoi
  extends agem
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
  
  public ahoi(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    paramBaseAdapter = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = agej.a(251.0F, paramBaseAdapter);
    this.c = agej.a(131.0F, paramBaseAdapter);
    this.d = agej.a(128.5F, paramBaseAdapter);
    this.jdField_e_of_type_Int = agej.a(131.0F, paramBaseAdapter);
    this.f = agej.a(122.5F, paramBaseAdapter);
    this.g = agej.a(131.0F, paramBaseAdapter);
    this.h = agej.a(4.0F, paramBaseAdapter);
    this.k = agej.a(71.5F, paramBaseAdapter);
    this.l = agej.a(74.0F, paramBaseAdapter);
    this.m = agej.a(20.0F, paramBaseAdapter);
    this.n = agej.a(20.0F, paramBaseAdapter);
    this.i = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedNicknameMaxLength", 10);
    this.j = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedPicBlogTitleMaxLength", 12);
    this.jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedLogoWaterImgUrl", "https://qzonestyle.gtimg.cn/aoi/sola/20191119115951_pUMyXUXliB.png");
    paramQQAppInterface = (aggr)paramQQAppInterface.getManager(282);
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
  
  private View a(View paramView, ahol paramahol)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558845, null);
      paramahol.jdField_b_of_type_AndroidViewView = paramView;
      paramahol.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362438);
      paramahol.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131362437);
      paramahol.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362445));
      paramahol.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362439));
      paramahol.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131362442));
      localView = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramahol.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (jdField_e_of_type_Boolean)
    {
      localView.setContentDescription(null);
      paramahol.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramahol.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
    paramString = bhjx.b(paramString, paramInt);
    return "《" + paramString + "》";
  }
  
  private void a(ahol paramahol, MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    switch (a(paramMessageForQCircleFeed))
    {
    }
    for (;;)
    {
      paramMessageForQCircleFeed = bhjx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, this.i);
      paramahol.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697274, new Object[] { paramMessageForQCircleFeed }));
      paramahol.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramMessageForQCircleFeed = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843971);
      paramMessageForQCircleFeed.setBounds(0, 0, this.m, this.n);
      paramahol.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramMessageForQCircleFeed, null, null, null);
      paramahol.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      return;
      b(paramahol, paramMessageForQCircleFeed);
    }
  }
  
  private void b(ahol paramahol, MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    if ((paramMessageForQCircleFeed.mediaDatas == null) || (paramMessageForQCircleFeed.mediaDatas.size() == 0)) {
      return;
    }
    paramahol.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (paramahol.f != null) {
      paramahol.f.setVisibility(8);
    }
    if (paramahol.e == null)
    {
      paramahol.e = ((ViewStub)paramahol.jdField_b_of_type_AndroidViewView.findViewById(2131362446)).inflate();
      paramahol.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramahol.jdField_b_of_type_AndroidViewView.findViewById(2131362440));
      paramahol.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramahol.jdField_b_of_type_AndroidViewView.findViewById(2131362447));
      paramahol.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramahol.jdField_b_of_type_AndroidViewView.findViewById(2131362443));
      paramahol.g = paramahol.jdField_b_of_type_AndroidViewView.findViewById(2131362441);
    }
    paramahol.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838228);
    paramahol.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setVisibility(8);
    paramahol.e.setVisibility(0);
    Object localObject = (MessageForQCircleFeed.MediaData)paramMessageForQCircleFeed.mediaDatas.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("QCircleFeedItemBuilder", 2, "setDataToSinglePicContainer picUrl= " + ((MessageForQCircleFeed.MediaData)localObject).mediaUrl);
    }
    int i1;
    if (paramMessageForQCircleFeed.appId == 2)
    {
      localObject = a(paramMessageForQCircleFeed.title, this.j);
      paramahol.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.c;
      a(paramahol.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, paramMessageForQCircleFeed, new float[] { this.h, this.h, this.h, this.h, this.h, this.h, this.h, this.h });
      localObject = paramahol.jdField_a_of_type_AndroidWidgetImageView;
      if (paramMessageForQCircleFeed.type != 3) {
        break label459;
      }
      i1 = 0;
      label359:
      ((ImageView)localObject).setVisibility(i1);
      if (paramMessageForQCircleFeed.imageCount <= 1) {
        break label465;
      }
      paramahol.jdField_d_of_type_AndroidWidgetTextView.setText(a(paramMessageForQCircleFeed.imageCount));
      paramahol.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      paramahol.g.setVisibility(0);
    }
    for (;;)
    {
      QLog.d("QCircleFeedItemBuilder", 2, "message.imageCount=" + paramMessageForQCircleFeed.imageCount);
      return;
      if (TextUtils.isEmpty(paramMessageForQCircleFeed.content)) {
        break;
      }
      paramahol.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQCircleFeed.content);
      break;
      label459:
      i1 = 8;
      break label359;
      label465:
      paramahol.jdField_d_of_type_AndroidWidgetTextView.setText("");
      paramahol.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      paramahol.g.setVisibility(8);
    }
  }
  
  protected agen a()
  {
    return new ahol(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCircleFeedItemBuilder", 2, "getItemView: invoked. info: message = " + paramMessageRecord);
    }
    paramMessageRecord = (MessageForQCircleFeed)paramMessageRecord;
    paramagen = (ahol)paramagen;
    paramView = a(paramView, paramagen);
    paramagen.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramagen.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    paramagen.jdField_b_of_type_JavaLangString = null;
    paramMessageRecord.coverImageUrl = a(paramMessageRecord.coverImageUrl);
    a(paramagen, paramMessageRecord);
    paramagen.jdField_c_of_type_AndroidViewView.setOnClickListener(new ahoj(this, paramMessageRecord));
    return paramView;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  protected void a(CornerImageView paramCornerImageView, MessageForQCircleFeed paramMessageForQCircleFeed, float[] paramArrayOfFloat)
  {
    String str = "";
    if ((paramCornerImageView.getTag(2131362463) instanceof String)) {
      str = (String)paramCornerImageView.getTag(2131362463);
    }
    paramCornerImageView.setRadius(paramArrayOfFloat);
    paramCornerImageView.setTag(2131362463, paramMessageForQCircleFeed.coverImageUrl);
    if (!str.equals(paramMessageForQCircleFeed.coverImageUrl))
    {
      paramCornerImageView = new vrd().a(paramMessageForQCircleFeed.coverImageUrl).a(paramCornerImageView).b(false).a(true).c(paramCornerImageView.getLayoutParams().width).b(paramCornerImageView.getLayoutParams().height);
      QCircleFeedPicLoader.a().a(paramCornerImageView, new ahok(this));
    }
  }
  
  public bhum[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahoi
 * JD-Core Version:    0.7.0.1
 */