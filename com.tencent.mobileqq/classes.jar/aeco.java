import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import java.util.Comparator;

public class aeco
  implements Comparator<aecm>
{
  private aeco(DiscussionMemberActivity paramDiscussionMemberActivity) {}
  
  public int a(aecm paramaecm1, aecm paramaecm2)
  {
    return paramaecm1.c.compareToIgnoreCase(paramaecm2.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeco
 * JD-Core Version:    0.7.0.1
 */