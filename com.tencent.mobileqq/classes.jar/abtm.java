import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.Comparator;

public class abtm
  implements Comparator<abti>
{
  public abtm(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(abti paramabti1, abti paramabti2)
  {
    long l = paramabti1.a.certifiedGrade;
    return (int)(paramabti2.a.certifiedGrade - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abtm
 * JD-Core Version:    0.7.0.1
 */