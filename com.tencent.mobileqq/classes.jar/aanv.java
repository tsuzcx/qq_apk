import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.biz.troop.EditUniqueTitleActivity;
import com.tencent.mobileqq.theme.ThemeUtil;

public class aanv
  implements TextWatcher
{
  public aanv(EditUniqueTitleActivity paramEditUniqueTitleActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    int i;
    if (str.equals(""))
    {
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      i = str.length();
      ThemeUtil.getCurrentThemeInfo().getString("themeId");
      if (i <= 6) {
        break label215;
      }
      EditUniqueTitleActivity.a(this.a, false);
      if (!this.a.jdField_a_of_type_Boolean) {
        this.a.rightViewText.setAlpha(0.5F);
      }
    }
    for (paramEditable = this.a.getResources().getColorStateList(2131167121);; paramEditable = this.a.getResources().getColorStateList(2131167066))
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramEditable);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(str.length() + "/" + 6);
      int j = 6 - str.length();
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(this.a.getString(2131695444), new Object[] { Integer.valueOf(i) }));
      return;
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      break;
      label215:
      EditUniqueTitleActivity.b(this.a, true);
      if (!this.a.jdField_a_of_type_Boolean) {
        this.a.rightViewText.setAlpha(1.0F);
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aanv
 * JD-Core Version:    0.7.0.1
 */