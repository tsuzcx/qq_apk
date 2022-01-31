import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStoryFeed;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;

public class adxj
  extends actm
{
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private adxl jdField_a_of_type_Adxl;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new adxk(this);
  private MessageForQQStoryFeed jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed;
  private boolean jdField_a_of_type_Boolean;
  
  public adxj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private View a(View paramView, adxl paramadxl)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558748, null);
      paramadxl.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131368951));
      paramadxl.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131368700));
      paramadxl.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368702));
      paramadxl.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378255));
      paramadxl.c = ((TextView)paramView.findViewById(2131378173));
      paramadxl.d = ((TextView)paramView.findViewById(2131378165));
      paramadxl.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368569));
      b();
      this.jdField_a_of_type_Adxl.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_Adxl.jdField_b_of_type_AndroidWidgetTextView.setText(b());
      this.jdField_a_of_type_Adxl.c.setText(a());
      a();
      a(paramView);
      localView = paramView;
      if (e)
      {
        paramadxl.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramadxl.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
    }
    return localView;
  }
  
  private URLDrawable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = actj.a(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298768), this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = actj.a(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298772), this.jdField_a_of_type_AndroidContentContext.getResources());
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = j;
    localURLDrawableOptions.mRequestHeight = i;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  private CharSequence a()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mFeedTime;
    return a(this.jdField_a_of_type_AndroidContentContext, l * 1000L);
  }
  
  public static CharSequence a(Context paramContext, long paramLong)
  {
    if (jdField_a_of_type_JavaTextSimpleDateFormat == null) {
      jdField_a_of_type_JavaTextSimpleDateFormat = (SimpleDateFormat)DateFormat.getDateFormat(paramContext);
    }
    jdField_a_of_type_JavaTextSimpleDateFormat.applyPattern(String.format("M%sd%s HH:mm", new Object[] { paramContext.getString(2131694302), paramContext.getString(2131691459) }));
    return DateFormat.format(jdField_a_of_type_JavaTextSimpleDateFormat.toLocalizedPattern(), paramLong);
  }
  
  private String a()
  {
    String str = bbbr.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mFeedAddress, 10);
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_Adxl.d.setText(str);
      return str;
    }
    this.jdField_a_of_type_Adxl.d.setVisibility(4);
    this.jdField_a_of_type_Adxl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    return str;
  }
  
  private void a(View paramView)
  {
    if (e)
    {
      this.jdField_a_of_type_Adxl.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_Adxl.jdField_b_of_type_AndroidWidgetTextView.getText());
      paramView.setContentDescription(this.jdField_a_of_type_Adxl.jdField_b_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  private boolean a(View paramView, MessageForQQStoryFeed paramMessageForQQStoryFeed)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQStoryFeedItemBuilder", 2, "setFeedViewVisibility invoked. info: empty msg. ");
      }
      paramView.setVisibility(8);
    }
    return true;
  }
  
  private CharSequence b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mMainText;
  }
  
  private void b()
  {
    URLDrawable localURLDrawable = a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mCoverUrl);
    if (localURLDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQStoryFeedItemBuilder", 2, "setupCover invoked. info: drawable: " + localURLDrawable);
      }
      return;
    }
    this.jdField_a_of_type_Adxl.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
    int i = actj.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_Adxl.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(new float[] { i, i, i, i, 0.0F, 0.0F, 0.0F, 0.0F });
    this.jdField_a_of_type_Adxl.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(localURLDrawable);
  }
  
  private void b(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mUnionId;
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mFeedId;
    vei.a("aio_msg", "aio_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.frienduin });
    tvc.a(BaseActivity.sTopActivity, paramView, str, 1, 109, 1, this.jdField_a_of_type_Adxl.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView);
  }
  
  protected actn a()
  {
    return new adxl();
  }
  
  protected View a(MessageRecord paramMessageRecord, actn paramactn, View paramView, LinearLayout paramLinearLayout, acxj paramacxj)
  {
    if (!(paramMessageRecord instanceof MessageForQQStoryFeed))
    {
      paramMessageRecord = paramView;
      if (QLog.isColorLevel())
      {
        QLog.e("QQStoryFeedItemBuilder", 2, "getItemView Failed. info: wrong message type. ");
        paramMessageRecord = paramView;
      }
    }
    do
    {
      return paramMessageRecord;
      paramMessageRecord = (MessageForQQStoryFeed)MessageForQQStoryFeed.class.cast(paramMessageRecord);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed == null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed = new MessageForQQStoryFeed(paramMessageRecord);
      }
      if (this.jdField_a_of_type_Adxl == null) {
        this.jdField_a_of_type_Adxl = ((adxl)adxl.class.cast(paramactn));
      }
      paramactn = a(paramView, this.jdField_a_of_type_Adxl);
      paramMessageRecord = paramactn;
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = a(paramactn, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed);
    return paramactn;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bbmh[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxj
 * JD-Core Version:    0.7.0.1
 */