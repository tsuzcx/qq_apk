import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.Comparator;

public class abtq
  implements Comparator<abtm>
{
  public abtq(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(abtm paramabtm1, abtm paramabtm2)
  {
    long l = paramabtm1.a.certifiedGrade;
    return (int)(paramabtm2.a.certifiedGrade - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abtq
 * JD-Core Version:    0.7.0.1
 */