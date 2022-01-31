import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20;
import com.tencent.widget.SingleLineTextView;

public class aija
  implements Runnable
{
  public aija(StructMsgItemLayout20 paramStructMsgItemLayout20, int paramInt, aijb paramaijb) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_Aijb.jdField_a_of_type_AndroidWidgetTextView.getWidth();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Aijb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.getLayoutParams();
    localLayoutParams.rightMargin = (j + i);
    this.jdField_a_of_type_Aijb.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aija
 * JD-Core Version:    0.7.0.1
 */