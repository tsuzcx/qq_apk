import com.tencent.mobileqq.data.LebaPluginInfo;
import java.util.Comparator;

public class ajzp
  implements Comparator<anec>
{
  private boolean a(anec paramanec)
  {
    return (paramanec != null) && (paramanec.a != null);
  }
  
  public int a(anec paramanec1, anec paramanec2)
  {
    if ((a(paramanec1)) && (a(paramanec2))) {
      if (paramanec1.a.sPriority <= paramanec2.a.sPriority) {}
    }
    do
    {
      return 1;
      if (paramanec1.a.sPriority < paramanec2.a.sPriority) {
        return -1;
      }
      return 0;
      if (a(paramanec1)) {
        return -1;
      }
    } while (a(paramanec2));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajzp
 * JD-Core Version:    0.7.0.1
 */