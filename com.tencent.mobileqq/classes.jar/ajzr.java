import com.tencent.mobileqq.data.LebaPluginInfo;
import java.util.Comparator;

public class ajzr
  implements Comparator<andx>
{
  private boolean a(andx paramandx)
  {
    return (paramandx != null) && (paramandx.a != null);
  }
  
  public int a(andx paramandx1, andx paramandx2)
  {
    if ((a(paramandx1)) && (a(paramandx2))) {
      if (paramandx1.a.sPriority <= paramandx2.a.sPriority) {}
    }
    do
    {
      return 1;
      if (paramandx1.a.sPriority < paramandx2.a.sPriority) {
        return -1;
      }
      return 0;
      if (a(paramandx1)) {
        return -1;
      }
    } while (a(paramandx2));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajzr
 * JD-Core Version:    0.7.0.1
 */