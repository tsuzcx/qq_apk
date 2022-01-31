import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import java.util.Comparator;

public class ajmb
  implements Comparator<ajof>
{
  public ajmb(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public int a(ajof paramajof1, ajof paramajof2)
  {
    if ((paramajof1.a < paramajof2.a) || ((paramajof1.a == paramajof2.a) && (paramajof1.b < paramajof2.b))) {
      return -1;
    }
    if ((paramajof1.a != paramajof2.a) || (paramajof1.b != paramajof2.b)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmb
 * JD-Core Version:    0.7.0.1
 */