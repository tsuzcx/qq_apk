import com.tencent.mobileqq.data.LebaPluginInfo;
import java.util.Comparator;

public class alrd
  implements Comparator<aovj>
{
  private boolean a(aovj paramaovj)
  {
    return (paramaovj != null) && (paramaovj.a != null);
  }
  
  public int a(aovj paramaovj1, aovj paramaovj2)
  {
    if ((a(paramaovj1)) && (a(paramaovj2))) {
      if (paramaovj1.a.sPriority <= paramaovj2.a.sPriority) {}
    }
    do
    {
      return 1;
      if (paramaovj1.a.sPriority < paramaovj2.a.sPriority) {
        return -1;
      }
      return 0;
      if (a(paramaovj1)) {
        return -1;
      }
    } while (a(paramaovj2));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alrd
 * JD-Core Version:    0.7.0.1
 */