import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.Comparator;

public class adku
  implements Comparator<adkq>
{
  public adku(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(adkq paramadkq1, adkq paramadkq2)
  {
    long l = paramadkq1.a.certifiedGrade;
    return (int)(paramadkq2.a.certifiedGrade - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adku
 * JD-Core Version:    0.7.0.1
 */