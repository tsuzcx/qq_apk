import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import java.util.Comparator;

public class alql
  implements Comparator<alsn>
{
  public alql(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public int a(alsn paramalsn1, alsn paramalsn2)
  {
    if ((paramalsn1.a < paramalsn2.a) || ((paramalsn1.a == paramalsn2.a) && (paramalsn1.b < paramalsn2.b))) {
      return -1;
    }
    if ((paramalsn1.a != paramalsn2.a) || (paramalsn1.b != paramalsn2.b)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alql
 * JD-Core Version:    0.7.0.1
 */