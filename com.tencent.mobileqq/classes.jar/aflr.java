import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import java.util.Comparator;

public class aflr
  implements Comparator<afnm>
{
  public aflr(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public int a(afnm paramafnm1, afnm paramafnm2)
  {
    long l = paramafnm2.a - paramafnm1.a;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aflr
 * JD-Core Version:    0.7.0.1
 */