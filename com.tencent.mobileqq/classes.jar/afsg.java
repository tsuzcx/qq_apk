import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import java.util.Comparator;

public class afsg
  implements Comparator<aftt>
{
  public afsg(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public int a(aftt paramaftt1, aftt paramaftt2)
  {
    long l = paramaftt2.a - paramaftt1.a;
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
 * Qualified Name:     afsg
 * JD-Core Version:    0.7.0.1
 */