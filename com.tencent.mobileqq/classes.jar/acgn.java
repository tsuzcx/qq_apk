import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import java.util.Comparator;

public class acgn
  implements Comparator<acia>
{
  public acgn(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public int a(acia paramacia1, acia paramacia2)
  {
    long l = paramacia2.a - paramacia1.a;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acgn
 * JD-Core Version:    0.7.0.1
 */