import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import java.util.Comparator;

public class acqy
  implements Comparator<acsl>
{
  public acqy(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public int a(acsl paramacsl1, acsl paramacsl2)
  {
    long l = paramacsl2.a - paramacsl1.a;
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
 * Qualified Name:     acqy
 * JD-Core Version:    0.7.0.1
 */