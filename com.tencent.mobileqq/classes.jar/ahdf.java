import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageRecord;

public class ahdf
  extends ahed
{
  public ahdf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected agen a()
  {
    return new ahdh(this);
  }
  
  @TargetApi(16)
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    paramagen = (ahdh)paramagen;
    paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558886, null);
    paramagen.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367669));
    paramagen.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376424));
    paramagen.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372096));
    paramagen.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372178));
    paramagen.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    int i;
    if ((paramMessageRecord instanceof MessageForFoldMsgGrayTips))
    {
      paramMessageRecord = (MessageForFoldMsgGrayTips)paramMessageRecord;
      paramagen.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord.getShowMsgContent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
      paramagen.jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(0.0F, 1.0F);
      paramLinearLayout = paramagen.jdField_b_of_type_AndroidWidgetImageView;
      if (!paramMessageRecord.isOpen) {
        break label301;
      }
      i = 8;
      paramLinearLayout.setVisibility(i);
      if (paramMessageRecord.isOpen)
      {
        paramMessageRecord = paramagen.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if ((paramMessageRecord instanceof ViewGroup.MarginLayoutParams))
        {
          paramMessageRecord = (ViewGroup.MarginLayoutParams)paramMessageRecord;
          if (paramMessageRecord.rightMargin != agej.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) {
            paramMessageRecord.rightMargin = agej.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          }
        }
      }
      paramMessageRecord = ((akwu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125)).a("StatusIcon_HongBaoIcon", 2130847304);
      if (Build.VERSION.SDK_INT >= 16) {
        break label307;
      }
      paramagen.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramMessageRecord));
    }
    for (;;)
    {
      paramagen.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new ahdg(this));
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064BE", "0X80064BE", 0, 0, "", "", "", "");
      return paramView;
      label301:
      i = 0;
      break;
      label307:
      paramagen.jdField_a_of_type_AndroidWidgetImageView.setBackground(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramMessageRecord));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdf
 * JD-Core Version:    0.7.0.1
 */