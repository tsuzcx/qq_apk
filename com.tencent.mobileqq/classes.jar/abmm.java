import com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordItem;
import com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordMatcher;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatchCallback;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatchTask;
import java.lang.ref.WeakReference;

public class abmm
  implements Runnable
{
  public abmm(WordMatchManager.HotWordMatcher paramHotWordMatcher, WordMatchManager.HotWordItem[] paramArrayOfHotWordItem) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.a != null) && (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.a.a != null))
    {
      WordMatchManager.MatchCallback localMatchCallback = (WordMatchManager.MatchCallback)this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.a.a.get();
      if (localMatchCallback != null) {
        localMatchCallback.a(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.a.b, this.jdField_a_of_type_ArrayOfComTencentMobileqqBusinessSougouWordMatchManager$HotWordItem);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$HotWordMatcher.dispatchNextTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abmm
 * JD-Core Version:    0.7.0.1
 */