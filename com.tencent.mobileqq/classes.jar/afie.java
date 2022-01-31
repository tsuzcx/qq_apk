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

public class afie
  extends afjb
{
  public afie(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected aekx a()
  {
    return new afig(this);
  }
  
  @TargetApi(16)
  protected View a(MessageRecord paramMessageRecord, aekx paramaekx, View paramView, LinearLayout paramLinearLayout, aeov paramaeov)
  {
    paramaekx = (afig)paramaekx;
    paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558817, null);
    paramaekx.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367282));
    paramaekx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131375517));
    paramaekx.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371393));
    paramaekx.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131371474));
    paramaekx.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    int i;
    if ((paramMessageRecord instanceof MessageForFoldMsgGrayTips))
    {
      paramMessageRecord = (MessageForFoldMsgGrayTips)paramMessageRecord;
      paramaekx.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord.getShowMsgContent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
      paramaekx.jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(0.0F, 1.0F);
      paramLinearLayout = paramaekx.jdField_b_of_type_AndroidWidgetImageView;
      if (!paramMessageRecord.isOpen) {
        break label301;
      }
      i = 8;
      paramLinearLayout.setVisibility(i);
      if (paramMessageRecord.isOpen)
      {
        paramMessageRecord = paramaekx.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if ((paramMessageRecord instanceof ViewGroup.MarginLayoutParams))
        {
          paramMessageRecord = (ViewGroup.MarginLayoutParams)paramMessageRecord;
          if (paramMessageRecord.rightMargin != aekt.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) {
            paramMessageRecord.rightMargin = aekt.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          }
        }
      }
      paramMessageRecord = ((aipw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(125)).a("StatusIcon_HongBaoIcon", 2130846764);
      if (Build.VERSION.SDK_INT >= 16) {
        break label307;
      }
      paramaekx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramMessageRecord));
    }
    for (;;)
    {
      paramaekx.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new afif(this));
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064BE", "0X80064BE", 0, 0, "", "", "", "");
      return paramView;
      label301:
      i = 0;
      break;
      label307:
      paramaekx.jdField_a_of_type_AndroidWidgetImageView.setBackground(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramMessageRecord));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afie
 * JD-Core Version:    0.7.0.1
 */