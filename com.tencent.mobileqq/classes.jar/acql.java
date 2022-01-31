import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import java.util.Comparator;

public class acql
  implements Comparator<acqj>
{
  private acql(DiscussionMemberActivity paramDiscussionMemberActivity) {}
  
  public int a(acqj paramacqj1, acqj paramacqj2)
  {
    return paramacqj1.c.compareToIgnoreCase(paramacqj2.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acql
 * JD-Core Version:    0.7.0.1
 */