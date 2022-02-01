import android.graphics.Paint;
import android.graphics.Typeface;
import java.util.Hashtable;

final class aadx
  implements aaad
{
  aadx(String paramString, Paint paramPaint) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    }
    for (;;)
    {
      if (i < 3) {}
      try
      {
        Typeface localTypeface = Typeface.createFromFile(paramString);
        aadv.a().put(this.jdField_a_of_type_JavaLangString, localTypeface);
        this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(localTypeface);
        return;
      }
      catch (Throwable localThrowable)
      {
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadx
 * JD-Core Version:    0.7.0.1
 */