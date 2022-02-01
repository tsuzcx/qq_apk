import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import java.util.Comparator;

public class aluy
  implements Comparator<alxc>
{
  public aluy(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public int a(alxc paramalxc1, alxc paramalxc2)
  {
    if ((paramalxc1.a < paramalxc2.a) || ((paramalxc1.a == paramalxc2.a) && (paramalxc1.b < paramalxc2.b))) {
      return -1;
    }
    if ((paramalxc1.a != paramalxc2.a) || (paramalxc1.b != paramalxc2.b)) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aluy
 * JD-Core Version:    0.7.0.1
 */