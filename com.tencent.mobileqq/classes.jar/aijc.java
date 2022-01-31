import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20;

public class aijc
  extends PublicAccountObserver
{
  aijb jdField_a_of_type_Aijb = null;
  
  public aijc(StructMsgItemLayout20 paramStructMsgItemLayout20, aijb paramaijb)
  {
    this.jdField_a_of_type_Aijb = paramaijb;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Aijb != null)
    {
      this.jdField_a_of_type_Aijb.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Aijb.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Aijb.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
        this.jdField_a_of_type_Aijb.jdField_a_of_type_AndroidWidgetTextView.setText("已关注");
        this.jdField_a_of_type_Aijb.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijc
 * JD-Core Version:    0.7.0.1
 */