import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import java.util.Comparator;

public class ajqq
  implements Comparator<ajsu>
{
  public ajqq(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public int a(ajsu paramajsu1, ajsu paramajsu2)
  {
    if ((paramajsu1.a < paramajsu2.a) || ((paramajsu1.a == paramajsu2.a) && (paramajsu1.b < paramajsu2.b))) {
      return -1;
    }
    if ((paramajsu1.a != paramajsu2.a) || (paramajsu1.b != paramajsu2.b)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqq
 * JD-Core Version:    0.7.0.1
 */