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

public class adkl
  extends actm
{
  public int a;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public adkl(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131297948);
    int i = paramContext.getResources().getDimensionPixelSize(2131297949);
    this.f = i;
    this.jdField_e_of_type_Int = i;
    this.d = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296308) * 2);
    this.c = paramContext.getResources().getDimensionPixelSize(2131297947);
  }
  
  private View a(View paramView, adkn paramadkn)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558725, null);
      paramadkn.jdField_b_of_type_AndroidViewView = localView.findViewById(2131364691);
      paramadkn.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362368));
      paramadkn.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362369));
      paramadkn.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)localView.findViewById(2131362366));
      paramadkn.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362367));
      paramadkn.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.jdField_a_of_type_Int);
      paramView = new bbbe(-1, this.jdField_e_of_type_Int, this.f);
      paramadkn.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
    }
    return localView;
  }
  
  protected actn a()
  {
    return new adkn(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actn paramactn, View paramView, LinearLayout paramLinearLayout, acxj paramacxj)
  {
    paramLinearLayout = (MessageForAIOStoryVideo)paramMessageRecord;
    paramactn = (adkn)paramactn;
    paramView = a(paramView, paramactn);
    paramMessageRecord = (String)paramactn.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131372946);
    if ((!TextUtils.isEmpty(paramLinearLayout.cover)) && (bbbr.a(paramLinearLayout.cover, paramMessageRecord))) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {}
      try
      {
        paramMessageRecord = new URL(paramLinearLayout.cover);
        if (paramMessageRecord != null)
        {
          bbao.a(paramactn.jdField_a_of_type_AndroidWidgetImageView, paramLinearLayout.cover);
          paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, this.d, this.c);
          paramMessageRecord.setDecodeHandler(bavw.s);
          paramactn.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramMessageRecord);
          paramactn.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131372946, paramLinearLayout.cover);
        }
        if (jdField_e_of_type_Boolean) {
          paramView.setContentDescription(paramLinearLayout.text);
        }
        paramactn.jdField_b_of_type_AndroidViewView.setOnClickListener(new adkm(this, paramLinearLayout));
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
  
  public bbmh[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adkl
 * JD-Core Version:    0.7.0.1
 */