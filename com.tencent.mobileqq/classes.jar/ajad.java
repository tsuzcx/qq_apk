import android.text.Spanned;
import java.util.Comparator;

public final class ajad
  implements Comparator
{
  public ajad(Spanned paramSpanned) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return this.a.getSpanStart(paramObject1) - this.a.getSpanStart(paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajad
 * JD-Core Version:    0.7.0.1
 */