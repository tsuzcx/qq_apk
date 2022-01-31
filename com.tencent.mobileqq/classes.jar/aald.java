import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mobileqq.activity.AuthDevRenameActivity;

public class aald
  implements InputFilter
{
  private int jdField_a_of_type_Int = 32;
  
  public aald(AuthDevRenameActivity paramAuthDevRenameActivity) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    int j = paramInt1;
    int k = 0;
    if (j < paramInt2)
    {
      i = paramCharSequence.charAt(j);
      if (i < 128) {
        i = 1;
      }
      for (;;)
      {
        j += 1;
        k += i;
        break;
        if (i < 2048) {
          i = 2;
        } else {
          i = 3;
        }
      }
    }
    int n = paramSpanned.length();
    int i = 0;
    int m = 0;
    if (m < n)
    {
      if ((m >= paramInt3) && (m < paramInt4)) {
        break label272;
      }
      j = paramSpanned.charAt(m);
      if (j < 128)
      {
        j = 1;
        label127:
        i = j + i;
      }
    }
    label272:
    for (;;)
    {
      m += 1;
      break;
      if (j < 2048)
      {
        j = 2;
        break label127;
      }
      j = 3;
      break label127;
      i = this.jdField_a_of_type_Int - i;
      if (i <= 0) {
        return "";
      }
      if (i >= k) {
        return null;
      }
      paramInt4 = paramInt1;
      while (paramInt4 < paramInt2)
      {
        paramInt3 = paramCharSequence.charAt(paramInt4);
        if (paramInt3 < 128) {
          paramInt3 = 1;
        }
        for (;;)
        {
          i -= paramInt3;
          if (i >= 0) {
            break;
          }
          return paramCharSequence.subSequence(paramInt1, paramInt4);
          if (paramInt3 < 2048) {
            paramInt3 = 2;
          } else {
            paramInt3 = 3;
          }
        }
        paramInt4 += 1;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aald
 * JD-Core Version:    0.7.0.1
 */