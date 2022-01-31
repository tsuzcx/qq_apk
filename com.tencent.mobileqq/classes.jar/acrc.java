import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import java.util.Comparator;

public class acrc
  implements Comparator<acsp>
{
  public acrc(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public int a(acsp paramacsp1, acsp paramacsp2)
  {
    long l = paramacsp2.a - paramacsp1.a;
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
 * Qualified Name:     acrc
 * JD-Core Version:    0.7.0.1
 */