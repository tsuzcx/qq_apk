import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;

public class achf
  implements View.OnClickListener
{
  public achf(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    if (this.a.d < this.a.c)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838928);
      paramView = this.a;
      paramView.d += 1;
      if (this.a.d >= this.a.c)
      {
        this.a.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
        this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130848977);
      }
      this.a.e = ((this.a.d - 1) * 8);
      this.a.jdField_a_of_type_Acid.a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, this.a.e);
      this.a.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(this.a.d));
      this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().length());
      this.a.t();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     achf
 * JD-Core Version:    0.7.0.1
 */