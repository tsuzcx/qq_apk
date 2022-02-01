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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageRecord;

public class agsh
  extends agtf
{
  public agsh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected afos a()
  {
    return new agsj(this);
  }
  
  @TargetApi(16)
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    paramafos = (agsj)paramafos;
    paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558921, null);
    paramafos.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367837));
    paramafos.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376441));
    paramafos.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372254));
    paramafos.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372335));
    paramafos.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    int i;
    if ((paramMessageRecord instanceof MessageForFoldMsgGrayTips))
    {
      paramMessageRecord = (MessageForFoldMsgGrayTips)paramMessageRecord;
      paramafos.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord.getShowMsgContent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
      paramafos.jdField_b_of_type_AndroidWidgetTextView.setLineSpacing(0.0F, 1.0F);
      paramLinearLayout = paramafos.jdField_b_of_type_AndroidWidgetImageView;
      if (!paramMessageRecord.isOpen) {
        break label302;
      }
      i = 8;
      paramLinearLayout.setVisibility(i);
      if (paramMessageRecord.isOpen)
      {
        paramMessageRecord = paramafos.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        if ((paramMessageRecord instanceof ViewGroup.MarginLayoutParams))
        {
          paramMessageRecord = (ViewGroup.MarginLayoutParams)paramMessageRecord;
          if (paramMessageRecord.rightMargin != AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources())) {
            paramMessageRecord.rightMargin = AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          }
        }
      }
      paramMessageRecord = ((akqe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER)).a("StatusIcon_HongBaoIcon", 2130847311);
      if (Build.VERSION.SDK_INT >= 16) {
        break label308;
      }
      paramafos.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramMessageRecord));
    }
    for (;;)
    {
      paramafos.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new agsi(this));
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064BE", "0X80064BE", 0, 0, "", "", "", "");
      return paramView;
      label302:
      i = 0;
      break;
      label308:
      paramafos.jdField_a_of_type_AndroidWidgetImageView.setBackground(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramMessageRecord));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsh
 * JD-Core Version:    0.7.0.1
 */