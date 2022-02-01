import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.Comparator;

public class aevq
  implements Comparator<aevm>
{
  public aevq(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(aevm paramaevm1, aevm paramaevm2)
  {
    long l = paramaevm1.a.certifiedGrade;
    return (int)(paramaevm2.a.certifiedGrade - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aevq
 * JD-Core Version:    0.7.0.1
 */