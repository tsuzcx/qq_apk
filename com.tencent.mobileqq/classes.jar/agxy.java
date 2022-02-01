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

public class agxy
  extends agem
{
  public int a;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public agxy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131298062);
    int i = paramContext.getResources().getDimensionPixelSize(2131298063);
    this.f = i;
    this.jdField_e_of_type_Int = i;
    this.d = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296352) * 2);
    this.c = paramContext.getResources().getDimensionPixelSize(2131298061);
  }
  
  private View a(View paramView, agya paramagya)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558824, null);
      paramagya.jdField_b_of_type_AndroidViewView = localView.findViewById(2131365046);
      paramagya.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362489));
      paramagya.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362490));
      paramagya.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)localView.findViewById(2131362487));
      paramagya.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362488));
      paramagya.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.jdField_a_of_type_Int);
      paramView = new bhjj(-1, this.jdField_e_of_type_Int, this.f);
      paramagya.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
    }
    return localView;
  }
  
  protected agen a()
  {
    return new agya(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    paramLinearLayout = (MessageForAIOStoryVideo)paramMessageRecord;
    paramagen = (agya)paramagen;
    paramView = a(paramView, paramagen);
    paramMessageRecord = (String)paramagen.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.getTag(2131374278);
    if ((!TextUtils.isEmpty(paramLinearLayout.cover)) && (bhjx.a(paramLinearLayout.cover, paramMessageRecord))) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0) {}
      try
      {
        paramMessageRecord = new URL(paramLinearLayout.cover);
        if (paramMessageRecord != null)
        {
          bhil.a(paramagen.jdField_a_of_type_AndroidWidgetImageView, paramLinearLayout.cover);
          paramMessageRecord = URLDrawable.getDrawable(paramMessageRecord, this.d, this.c);
          paramMessageRecord.setDecodeHandler(bhez.t);
          paramagen.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(paramMessageRecord);
          paramagen.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setTag(2131374278, paramLinearLayout.cover);
        }
        if (jdField_e_of_type_Boolean) {
          paramView.setContentDescription(paramLinearLayout.text);
        }
        paramagen.jdField_b_of_type_AndroidViewView.setOnClickListener(new agxz(this, paramLinearLayout));
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
  
  public bhum[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agxy
 * JD-Core Version:    0.7.0.1
 */