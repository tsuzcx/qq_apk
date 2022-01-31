import com.tencent.mobileqq.data.LebaPluginInfo;
import java.util.Comparator;

public class alvs
  implements Comparator<aozs>
{
  private boolean a(aozs paramaozs)
  {
    return (paramaozs != null) && (paramaozs.a != null);
  }
  
  public int a(aozs paramaozs1, aozs paramaozs2)
  {
    if ((a(paramaozs1)) && (a(paramaozs2))) {
      if (paramaozs1.a.sPriority <= paramaozs2.a.sPriority) {}
    }
    do
    {
      return 1;
      if (paramaozs1.a.sPriority < paramaozs2.a.sPriority) {
        return -1;
      }
      return 0;
      if (a(paramaozs1)) {
        return -1;
      }
    } while (a(paramaozs2));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alvs
 * JD-Core Version:    0.7.0.1
 */