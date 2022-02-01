import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.Comparator;

public class aeor
  implements Comparator<aeon>
{
  public aeor(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(aeon paramaeon1, aeon paramaeon2)
  {
    long l = paramaeon1.a.certifiedGrade;
    return (int)(paramaeon2.a.certifiedGrade - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeor
 * JD-Core Version:    0.7.0.1
 */