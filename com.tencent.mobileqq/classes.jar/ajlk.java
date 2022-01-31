import com.tencent.mobileqq.data.LebaPluginInfo;
import java.util.Comparator;

public class ajlk
  implements Comparator<amnq>
{
  private boolean a(amnq paramamnq)
  {
    return (paramamnq != null) && (paramamnq.a != null);
  }
  
  public int a(amnq paramamnq1, amnq paramamnq2)
  {
    if ((a(paramamnq1)) && (a(paramamnq2))) {
      if (paramamnq1.a.sPriority <= paramamnq2.a.sPriority) {}
    }
    do
    {
      return 1;
      if (paramamnq1.a.sPriority < paramamnq2.a.sPriority) {
        return -1;
      }
      return 0;
      if (a(paramamnq1)) {
        return -1;
      }
    } while (a(paramamnq2));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajlk
 * JD-Core Version:    0.7.0.1
 */