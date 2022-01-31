import android.text.InputFilter;
import android.text.Spanned;

class acwy
  implements InputFilter
{
  acwy(acwx paramacwx) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    paramInt3 = 4500 - (paramSpanned.length() - (paramInt4 - paramInt3));
    if (paramInt3 <= 0)
    {
      acwx.a(this.a);
      return "";
    }
    if (paramInt3 >= paramInt2 - paramInt1) {
      return null;
    }
    paramInt3 += paramInt1;
    paramInt2 = paramInt3;
    if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt3 - 1)))
    {
      paramInt3 -= 1;
      paramInt2 = paramInt3;
      if (paramInt3 == paramInt1)
      {
        acwx.a(this.a);
        return "";
      }
    }
    acwx.a(this.a);
    return paramCharSequence.subSequence(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwy
 * JD-Core Version:    0.7.0.1
 */