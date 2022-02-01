import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import java.util.Comparator;

public class aljg
  implements Comparator<allk>
{
  public aljg(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public int a(allk paramallk1, allk paramallk2)
  {
    if ((paramallk1.a < paramallk2.a) || ((paramallk1.a == paramallk2.a) && (paramallk1.b < paramallk2.b))) {
      return -1;
    }
    if ((paramallk1.a != paramallk2.a) || (paramallk1.b != paramallk2.b)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aljg
 * JD-Core Version:    0.7.0.1
 */