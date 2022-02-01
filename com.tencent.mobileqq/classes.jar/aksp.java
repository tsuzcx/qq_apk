import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import java.util.Comparator;

public class aksp
  implements Comparator<akur>
{
  public aksp(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public int a(akur paramakur1, akur paramakur2)
  {
    if ((paramakur1.a < paramakur2.a) || ((paramakur1.a == paramakur2.a) && (paramakur1.b < paramakur2.b))) {
      return -1;
    }
    if ((paramakur1.a != paramakur2.a) || (paramakur1.b != paramakur2.b)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksp
 * JD-Core Version:    0.7.0.1
 */