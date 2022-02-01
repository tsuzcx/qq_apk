import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import java.util.Comparator;

public class advs
  implements Comparator<advq>
{
  private advs(DiscussionMemberActivity paramDiscussionMemberActivity) {}
  
  public int a(advq paramadvq1, advq paramadvq2)
  {
    return paramadvq1.c.compareToIgnoreCase(paramadvq2.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advs
 * JD-Core Version:    0.7.0.1
 */