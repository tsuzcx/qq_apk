import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import com.tencent.mobileqq.richstatus.RichStatusEditText;
import com.tencent.mobileqq.richstatus.RichStatusEditText.RichStatusEditListener;
import com.tencent.mobileqq.widget.ClickableImageSpan;

public class ahuf
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public ahuf(RichStatusEditText paramRichStatusEditText) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.getText().replace(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setSelection(this.jdField_a_of_type_Int + this.jdField_a_of_type_JavaLangString.length());
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramInt3 > 0)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt3;
      RichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.setCursorVisible(true);
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    paramCharSequence = RichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText, paramInt1, false, false);
    if (paramCharSequence != null)
    {
      paramInt3 = RichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText).getSpanStart(paramCharSequence);
      if (paramInt3 != paramInt1)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Int = paramInt3;
        this.jdField_b_of_type_Int = (paramInt1 - paramInt3);
        this.jdField_a_of_type_JavaLangString = "";
      }
    }
    RichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText, paramInt1, paramInt2);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (!this.jdField_a_of_type_Boolean);
      ClickableImageSpan localClickableImageSpan = RichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText, paramInt1 + paramInt3, true, false);
      if ((localClickableImageSpan != null) && (RichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText) != null) && (!RichStatusEditText.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatusEditText).a(localClickableImageSpan)))
      {
        this.jdField_a_of_type_JavaLangString = "";
        this.jdField_b_of_type_Boolean = true;
        return;
      }
      this.jdField_a_of_type_JavaLangString = paramCharSequence.subSequence(paramInt1, paramInt1 + paramInt3).toString();
    } while (!this.jdField_a_of_type_JavaLangString.contains("\n"));
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.replace("\n", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahuf
 * JD-Core Version:    0.7.0.1
 */