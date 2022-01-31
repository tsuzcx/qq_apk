import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;

class afmu
  implements View.OnClickListener
{
  afmu(afmt paramafmt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = aepi.a(paramView);
    if ((localObject instanceof MessageForFoldMsgGrayTips))
    {
      ((MessageForFoldMsgGrayTips)localObject).isOpen = true;
      paramView = (afmv)aepi.a(paramView);
      paramView.jdField_b_of_type_AndroidWidgetTextView.setText(((MessageForFoldMsgGrayTips)localObject).getShowMsgContent(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext));
      localObject = paramView.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        if (((ViewGroup.MarginLayoutParams)localObject).rightMargin != aepi.a(10.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources())) {
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = aepi.a(10.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
        }
      }
      paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView.a.requestLayout();
      azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064BD", "0X80064BD", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afmu
 * JD-Core Version:    0.7.0.1
 */