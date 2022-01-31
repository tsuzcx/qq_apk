import android.util.Pair;
import com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagUtil;
import java.util.Comparator;

public class agpg
  implements Comparator
{
  public int a(Pair paramPair1, Pair paramPair2)
  {
    return TagUtil.a((CharSequence)paramPair1.second) - TagUtil.a((CharSequence)paramPair2.second);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agpg
 * JD-Core Version:    0.7.0.1
 */