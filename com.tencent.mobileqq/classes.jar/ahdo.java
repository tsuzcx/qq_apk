import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mobileqq.activity.book.BookEditText;

public class ahdo
  implements InputFilter
{
  public ahdo(BookEditText paramBookEditText) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    this.a.a(paramSpanned.toString());
    if (this.a.a(paramCharSequence.toString()) == 0) {
      BookEditText.a(this.a);
    }
    while (!bamp.a(paramCharSequence.toString())) {
      return paramCharSequence.subSequence(paramInt1, paramInt2 - paramInt1);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdo
 * JD-Core Version:    0.7.0.1
 */