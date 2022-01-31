import android.text.TextUtils.EllipsizeCallback;
import android.widget.TextView;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout13;

public class aiiw
  implements TextUtils.EllipsizeCallback
{
  public aiiw(StructMsgItemLayout13 paramStructMsgItemLayout13, TextView paramTextView, String paramString) {}
  
  public void ellipsized(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      return;
    }
    String str = this.jdField_a_of_type_JavaLangString.substring(0, paramInt1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str + "...");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiiw
 * JD-Core Version:    0.7.0.1
 */