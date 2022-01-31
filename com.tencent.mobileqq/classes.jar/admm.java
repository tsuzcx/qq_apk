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

public class admm
  extends acjb
{
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private admo jdField_a_of_type_Admo;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new admn(this);
  private MessageForQQStoryFeed jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed;
  private boolean jdField_a_of_type_Boolean;
  
  public admm(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private View a(View paramView, admo paramadmo)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493192, null);
      paramadmo.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131303284));
      paramadmo.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131303064));
      paramadmo.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131303066));
      paramadmo.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312424));
      paramadmo.c = ((TextView)paramView.findViewById(2131312344));
      paramadmo.d = ((TextView)paramView.findViewById(2131312336));
      paramadmo.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302938));
      b();
      this.jdField_a_of_type_Admo.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      this.jdField_a_of_type_Admo.jdField_b_of_type_AndroidWidgetTextView.setText(b());
      this.jdField_a_of_type_Admo.c.setText(a());
      a();
      a(paramView);
      localView = paramView;
      if (e)
      {
        paramadmo.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramadmo.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
    }
    return localView;
  }
  
  private URLDrawable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = aciy.a(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131167669), this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = aciy.a(this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131167673), this.jdField_a_of_type_AndroidContentContext.getResources());
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
    jdField_a_of_type_JavaTextSimpleDateFormat.applyPattern(String.format("M%sd%s HH:mm", new Object[] { paramContext.getString(2131628651), paramContext.getString(2131625883) }));
    return DateFormat.format(jdField_a_of_type_JavaTextSimpleDateFormat.toLocalizedPattern(), paramLong);
  }
  
  private String a()
  {
    String str = azzz.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mFeedAddress, 10);
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_Admo.d.setText(str);
      return str;
    }
    this.jdField_a_of_type_Admo.d.setVisibility(4);
    this.jdField_a_of_type_Admo.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    return str;
  }
  
  private void a(View paramView)
  {
    if (e)
    {
      this.jdField_a_of_type_Admo.jdField_b_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_Admo.jdField_b_of_type_AndroidWidgetTextView.getText());
      paramView.setContentDescription(this.jdField_a_of_type_Admo.jdField_b_of_type_JavaLangStringBuilder.toString());
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
    this.jdField_a_of_type_Admo.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressMask(true);
    int i = aciy.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_Admo.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(new float[] { i, i, i, i, 0.0F, 0.0F, 0.0F, 0.0F });
    this.jdField_a_of_type_Admo.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(localURLDrawable);
  }
  
  private void b(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mUnionId;
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.mFeedId;
    urp.a("aio_msg", "aio_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed.frienduin });
    tij.a(BaseActivity.sTopActivity, paramView, str, 1, 109, 1, this.jdField_a_of_type_Admo.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView);
  }
  
  protected acjc a()
  {
    return new admo();
  }
  
  protected View a(MessageRecord paramMessageRecord, acjc paramacjc, View paramView, LinearLayout paramLinearLayout, acmv paramacmv)
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
      if (this.jdField_a_of_type_Admo == null) {
        this.jdField_a_of_type_Admo = ((admo)admo.class.cast(paramacjc));
      }
      paramacjc = a(paramView, this.jdField_a_of_type_Admo);
      paramMessageRecord = paramacjc;
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = a(paramacjc, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQStoryFeed);
    return paramacjc;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bakj[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     admm
 * JD-Core Version:    0.7.0.1
 */