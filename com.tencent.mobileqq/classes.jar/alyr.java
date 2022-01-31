import android.graphics.Rect;
import java.util.Comparator;

class alyr
  implements Comparator<Rect>
{
  alyr(alyo paramalyo) {}
  
  public int a(Rect paramRect1, Rect paramRect2)
  {
    if (paramRect1.height() * paramRect1.width() > paramRect2.height() * paramRect2.width()) {}
    do
    {
      return -1;
      if (paramRect1.height() * paramRect1.width() < paramRect2.height() * paramRect2.width()) {
        return 1;
      }
    } while (paramRect1.width() > paramRect2.width());
    if (paramRect1.width() < paramRect2.width()) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alyr
 * JD-Core Version:    0.7.0.1
 */