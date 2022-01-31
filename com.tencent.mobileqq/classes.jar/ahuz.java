import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20;

public class ahuz
  extends PublicAccountObserver
{
  ahuy jdField_a_of_type_Ahuy = null;
  
  public ahuz(StructMsgItemLayout20 paramStructMsgItemLayout20, ahuy paramahuy)
  {
    this.jdField_a_of_type_Ahuy = paramahuy;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Ahuy != null)
    {
      this.jdField_a_of_type_Ahuy.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Ahuy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Ahuy.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
        this.jdField_a_of_type_Ahuy.jdField_a_of_type_AndroidWidgetTextView.setText("已关注");
        this.jdField_a_of_type_Ahuy.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahuz
 * JD-Core Version:    0.7.0.1
 */