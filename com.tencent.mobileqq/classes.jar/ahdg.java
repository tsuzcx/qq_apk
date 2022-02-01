import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahdg
  implements View.OnClickListener
{
  ahdg(ahdf paramahdf) {}
  
  public void onClick(View paramView)
  {
    Object localObject = agej.a(paramView);
    if ((localObject instanceof MessageForFoldMsgGrayTips))
    {
      ((MessageForFoldMsgGrayTips)localObject).isOpen = true;
      ahdh localahdh = (ahdh)agej.a(paramView);
      localahdh.jdField_b_of_type_AndroidWidgetTextView.setText(((MessageForFoldMsgGrayTips)localObject).getShowMsgContent(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext));
      localObject = localahdh.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        if (((ViewGroup.MarginLayoutParams)localObject).rightMargin != agej.a(10.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources())) {
          ((ViewGroup.MarginLayoutParams)localObject).rightMargin = agej.a(10.0F, this.a.jdField_a_of_type_AndroidContentContext.getResources());
        }
      }
      localahdh.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      localahdh.a.requestLayout();
      bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80064BD", "0X80064BD", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdg
 * JD-Core Version:    0.7.0.1
 */