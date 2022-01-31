import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mobileqq.activity.EditInfoActivity;

public class abam
  implements InputFilter
{
  public abam(EditInfoActivity paramEditInfoActivity) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (paramCharSequence.toString().contains("\n")) {
      return paramCharSequence.toString().replace("\n", "");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abam
 * JD-Core Version:    0.7.0.1
 */