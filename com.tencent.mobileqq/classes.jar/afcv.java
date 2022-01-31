import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class afcv
  extends aekw
{
  public int a;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public afcv(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131297969);
    int i = paramContext.getResources().getDimensionPixelSize(2131297970);
    this.f = i;
    this.jdField_e_of_type_Int = i;
    this.d = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296314) * 2);
    this.c = paramContext.getResources().getDimensionPixelSize(2131297968);
  }
  
  private View a(View paramView, afcx paramafcx)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558761, null);
      paramafcx.jdField_b_of_type_AndroidViewView = localView.findViewById(2131364770);
      paramafcx.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362389));
      paramafcx.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362390));
      paramafcx.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)localView.findViewById(2131362387));
      paramafcx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362388));
      paramafcx.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.jdField_a_of_type_Int);
      paramView = new bczy(-1, this.jdField_e_of_type_Int, this.f);
      paramafcx.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
    }
    return localView;
  }
  
  protected aekx a()
  {
    return new afcx(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aekx paramaekx, View paramView, LinearLayout paramLinearLayout, aeov paramaeov)
  {
    paramLinearLayout = (MessageForAIOStoryVideo)paramMessageRecord;
    paramaekx = (afcx)paramaekx;
    paramView = a(paramView, paramaekx);
    paramMessageRecord = (String)paramaekx.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131373384);
    if ((!TextUtils.isEmpty(paramLinearLayout.cover)) && (bdal.a(paramLinearLayout.cover, paramMessageRecord))) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {}
      try
      {
        paramMessageRecord = new URL(paramLinearLayout.cover);
        if (paramMessageRecord != null)
        {
          bczi.a(paramaekx.jdField_a_of_type_AndroidWidgetImageView, paramLinearLayout.cover);
          paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, this.d, this.c);
          paramMessageRecord.setDecodeHandler(bcuq.s);
          paramaekx.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramMessageRecord);
          paramaekx.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131373384, paramLinearLayout.cover);
        }
        if (jdField_e_of_type_Boolean) {
          paramView.setContentDescription(paramLinearLayout.text);
        }
        paramaekx.jdField_b_of_type_AndroidViewView.setOnClickListener(new afcw(this, paramLinearLayout));
        return paramView;
      }
      catch (Exception paramMessageRecord)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ChatItemBuilder", 2, " AIOStoryVideoBuilder:  url has problem");
          }
          paramMessageRecord = null;
        }
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bdlb[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcv
 * JD-Core Version:    0.7.0.1
 */