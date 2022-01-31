import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.qphone.base.util.QLog;

public class aagu
  implements TextWatcher
{
  public aagu(ChatHistory paramChatHistory) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {}
    for (;;)
    {
      try
      {
        paramInt1 = Integer.valueOf(paramCharSequence.toString()).intValue();
        if ((paramCharSequence.length() <= 1) || (paramCharSequence.charAt(0) != '0')) {
          break label421;
        }
        paramCharSequence = String.valueOf(paramInt1);
        paramInt2 = 1;
        if ((paramInt1 < 1) || (paramInt1 > this.a.c)) {
          paramCharSequence = paramCharSequence.subSequence(0, paramCharSequence.length() - 1).toString();
        }
      }
      catch (Exception localException1)
      {
        try
        {
          paramInt1 = Integer.valueOf(paramCharSequence.toString()).intValue();
          paramInt2 = 1;
          continue;
          localException1 = localException1;
          paramInt1 = this.a.c;
        }
        catch (Exception paramCharSequence)
        {
          paramInt1 = this.a.c;
          paramCharSequence = String.valueOf(paramInt1);
          continue;
        }
      }
      if (paramInt2 != 0) {}
      try
      {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(Math.max(0, paramCharSequence.length() - 1));
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramCharSequence.toString());
        paramCharSequence = this.a;
        if (paramInt1 < this.a.c)
        {
          paramCharSequence.d = paramInt1;
          if (this.a.d < this.a.c) {
            break label369;
          }
          this.a.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
          this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130848311);
          if (this.a.d > 1) {
            break label395;
          }
          this.a.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
          this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840138);
          this.a.e = ((this.a.d - 1) * 8);
          this.a.jdField_a_of_type_Aahr.a(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, this.a.e);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("ChatHistory", 1, "current s:" + paramCharSequence);
          continue;
          paramInt1 = this.a.c;
          continue;
          label369:
          this.a.jdField_b_of_type_AndroidWidgetImageView.setEnabled(true);
          this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838747);
          continue;
          label395:
          this.a.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
          this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838746);
        }
      }
      label421:
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aagu
 * JD-Core Version:    0.7.0.1
 */