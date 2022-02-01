import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import java.util.Comparator;

public class agbm
  implements Comparator<agdh>
{
  public agbm(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public int a(agdh paramagdh1, agdh paramagdh2)
  {
    long l = paramagdh2.a - paramagdh1.a;
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
 * Qualified Name:     agbm
 * JD-Core Version:    0.7.0.1
 */