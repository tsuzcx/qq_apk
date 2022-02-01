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

public class ahpb
  extends agem
{
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private ahpd jdField_a_of_type_Ahpd;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new ahpc(this);
  private MessageForQQStoryFeed jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed;
  private boolean jdField_a_of_type_Boolean;
  
  public ahpb(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private View a(View paramView, ahpd paramahpd)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558849, null);
      paramahpd.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131369683));
      paramahpd.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131369393));
      paramahpd.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369395));
      paramahpd.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379939));
      paramahpd.c = ((TextView)paramView.findViewById(2131379833));
      paramahpd.d = ((TextView)paramView.findViewById(2131379824));
      paramahpd.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369212));
      b();
      this.jdField_a_of_type_Ahpd.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_Ahpd.jdField_b_of_type_AndroidWidgetTextView.setText(b());
      this.jdField_a_of_type_Ahpd.c.setText(a());
      a();
      a(paramView);
      localView = paramView;
      if (e)
      {
        paramahpd.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramahpd.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
    }
    return localView;
  }
  
  private URLDrawable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = agej.a(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298892), this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = agej.a(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298896), this.jdField_a_of_type_AndroidContentContext.getResources());
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
    jdField_a_of_type_JavaTextSimpleDateFormat.applyPattern(String.format("M%sd%s HH:mm", new Object[] { paramContext.getString(2131693745), paramContext.getString(2131691294) }));
    return DateFormat.format(jdField_a_of_type_JavaTextSimpleDateFormat.toLocalizedPattern(), paramLong);
  }
  
  private String a()
  {
    String str = bhjx.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mFeedAddress, 10);
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_Ahpd.d.setText(str);
      return str;
    }
    this.jdField_a_of_type_Ahpd.d.setVisibility(4);
    this.jdField_a_of_type_Ahpd.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    return str;
  }
  
  private void a(View paramView)
  {
    if (e)
    {
      this.jdField_a_of_type_Ahpd.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_Ahpd.jdField_b_of_type_AndroidWidgetTextView.getText());
      paramView.setContentDescription(this.jdField_a_of_type_Ahpd.jdField_b_of_type_JavaLangStringBuilder.toString());
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
    this.jdField_a_of_type_Ahpd.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
    int i = agej.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_Ahpd.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(new float[] { i, i, i, i, 0.0F, 0.0F, 0.0F, 0.0F });
    this.jdField_a_of_type_Ahpd.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(localURLDrawable);
  }
  
  private void b(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mUnionId;
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mFeedId;
    yup.a("aio_msg", "aio_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.frienduin });
    xlj.a(BaseActivity.sTopActivity, paramView, str, 1, 109, 1, this.jdField_a_of_type_Ahpd.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView);
  }
  
  protected agen a()
  {
    return new ahpd();
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
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
      if (this.jdField_a_of_type_Ahpd == null) {
        this.jdField_a_of_type_Ahpd = ((ahpd)ahpd.class.cast(paramagen));
      }
      paramagen = a(paramView, this.jdField_a_of_type_Ahpd);
      paramMessageRecord = paramagen;
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = a(paramagen, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed);
    return paramagen;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhum[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpb
 * JD-Core Version:    0.7.0.1
 */