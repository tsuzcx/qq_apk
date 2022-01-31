import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import java.util.Comparator;

public class ahur
  implements Comparator<ahwv>
{
  public ahur(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public int a(ahwv paramahwv1, ahwv paramahwv2)
  {
    if ((paramahwv1.a < paramahwv2.a) || ((paramahwv1.a == paramahwv2.a) && (paramahwv1.b < paramahwv2.b))) {
      return -1;
    }
    if ((paramahwv1.a != paramahwv2.a) || (paramahwv1.b != paramahwv2.b)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahur
 * JD-Core Version:    0.7.0.1
 */