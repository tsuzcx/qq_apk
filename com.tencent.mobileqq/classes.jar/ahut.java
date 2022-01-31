import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import java.util.Comparator;

public class ahut
  implements Comparator<ahwx>
{
  public ahut(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public int a(ahwx paramahwx1, ahwx paramahwx2)
  {
    if ((paramahwx1.a < paramahwx2.a) || ((paramahwx1.a == paramahwx2.a) && (paramahwx1.b < paramahwx2.b))) {
      return -1;
    }
    if ((paramahwx1.a != paramahwx2.a) || (paramahwx1.b != paramahwx2.b)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahut
 * JD-Core Version:    0.7.0.1
 */