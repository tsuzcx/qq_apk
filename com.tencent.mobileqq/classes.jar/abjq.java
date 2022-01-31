import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.Comparator;

public class abjq
  implements Comparator<abjm>
{
  public abjq(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(abjm paramabjm1, abjm paramabjm2)
  {
    long l = paramabjm1.a.certifiedGrade;
    return (int)(paramabjm2.a.certifiedGrade - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abjq
 * JD-Core Version:    0.7.0.1
 */