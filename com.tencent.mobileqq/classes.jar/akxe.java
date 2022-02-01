import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText;

public class akxe
  implements InputFilter
{
  private int jdField_a_of_type_Int;
  
  public akxe(ExtendEditText paramExtendEditText, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    if (ExtendEditText.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText) != null) {
      ExtendEditText.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText).a(this.jdField_a_of_type_Int);
    }
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    akxd localakxd = ExtendEditText.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText);
    if (localakxd == null)
    {
      paramInt3 = paramSpanned.length() - (paramInt4 - paramInt3);
      if (localakxd != null) {
        break label95;
      }
      paramInt2 -= paramInt1;
    }
    for (;;)
    {
      paramInt3 = this.jdField_a_of_type_Int - paramInt3;
      if (paramInt3 > 0) {
        break label109;
      }
      a();
      return "";
      paramInt3 = localakxd.a(paramSpanned, 0, paramInt3) + localakxd.a(paramSpanned, paramInt4, paramSpanned.length());
      break;
      label95:
      paramInt2 = localakxd.a(paramCharSequence, paramInt1, paramInt2);
    }
    label109:
    if (paramInt3 >= paramInt2) {
      return null;
    }
    a();
    if (localakxd != null)
    {
      paramInt3 = localakxd.b(paramCharSequence, paramInt1, paramInt1 + paramInt3);
      paramInt2 = paramInt3;
      if (paramInt3 <= 0) {
        return "";
      }
    }
    else
    {
      paramInt2 = paramInt3;
    }
    paramInt3 = paramInt2 + paramInt1;
    paramInt2 = paramInt3;
    if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt3 - 1)))
    {
      paramInt3 -= 1;
      paramInt2 = paramInt3;
      if (paramInt3 == paramInt1) {
        return "";
      }
    }
    return paramCharSequence.subSequence(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxe
 * JD-Core Version:    0.7.0.1
 */