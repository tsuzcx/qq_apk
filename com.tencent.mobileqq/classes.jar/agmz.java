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

public class agmz
  extends afor
{
  public int a;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public agmz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298130);
    int i = paramContext.getResources().getDimensionPixelSize(2131298131);
    this.f = i;
    this.jdField_e_of_type_Int = i;
    this.d = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296405) * 2);
    this.c = paramContext.getResources().getDimensionPixelSize(2131298129);
  }
  
  private View a(View paramView, agnb paramagnb)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558857, null);
      paramagnb.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365157);
      paramagnb.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362506));
      paramagnb.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362507));
      paramagnb.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)localView.findViewById(2131362504));
      paramagnb.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362505));
      paramagnb.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.jdField_a_of_type_Int);
      paramView = new bhbj(-1, this.jdField_e_of_type_Int, this.f);
      paramagnb.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
    }
    return localView;
  }
  
  protected afos a()
  {
    return new agnb(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    paramLinearLayout = (MessageForAIOStoryVideo)paramMessageRecord;
    paramafos = (agnb)paramafos;
    paramView = a(paramView, paramafos);
    paramMessageRecord = (String)paramafos.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131374252);
    if ((!TextUtils.isEmpty(paramLinearLayout.cover)) && (bhbx.a(paramLinearLayout.cover, paramMessageRecord))) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {}
      try
      {
        paramMessageRecord = new URL(paramLinearLayout.cover);
        if (paramMessageRecord != null)
        {
          bham.a(paramafos.jdField_a_of_type_AndroidWidgetImageView, paramLinearLayout.cover);
          paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, this.d, this.c);
          paramMessageRecord.setDecodeHandler(bgxc.t);
          paramafos.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramMessageRecord);
          paramafos.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131374252, paramLinearLayout.cover);
        }
        if (jdField_e_of_type_Boolean) {
          paramView.setContentDescription(paramLinearLayout.text);
        }
        paramafos.jdField_b_of_type_AndroidViewView.setOnClickListener(new agna(this, paramLinearLayout));
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
  
  public bhjs[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmz
 * JD-Core Version:    0.7.0.1
 */