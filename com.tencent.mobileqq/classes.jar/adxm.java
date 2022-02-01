import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.Comparator;

public class adxm
  implements Comparator<adxi>
{
  public adxm(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(adxi paramadxi1, adxi paramadxi2)
  {
    long l = paramadxi1.a.certifiedGrade;
    return (int)(paramadxi2.a.certifiedGrade - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxm
 * JD-Core Version:    0.7.0.1
 */