import android.text.Spanned;
import java.util.Comparator;

public final class ajvu
  implements Comparator
{
  public ajvu(Spanned paramSpanned) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return this.a.getSpanStart(paramObject1) - this.a.getSpanStart(paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvu
 * JD-Core Version:    0.7.0.1
 */