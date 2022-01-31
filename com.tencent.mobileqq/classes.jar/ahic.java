import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import java.util.Comparator;

public class ahic
  implements Comparator<ahkf>
{
  public ahic(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public int a(ahkf paramahkf1, ahkf paramahkf2)
  {
    if ((paramahkf1.a < paramahkf2.a) || ((paramahkf1.a == paramahkf2.a) && (paramahkf1.b < paramahkf2.b))) {
      return -1;
    }
    if ((paramahkf1.a != paramahkf2.a) || (paramahkf1.b != paramahkf2.b)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahic
 * JD-Core Version:    0.7.0.1
 */