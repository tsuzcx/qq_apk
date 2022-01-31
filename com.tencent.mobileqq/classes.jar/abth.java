import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatcherCallback;
import java.util.ArrayList;

public class abth
  implements Runnable
{
  public abth(WordMatchManager paramWordMatchManager, WordMatchManager.MatcherCallback paramMatcherCallback) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback != null) && (!this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a.contains(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback))) {
        this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.a.add(this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$MatcherCallback);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.d);
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.d = true;
    this.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abth
 * JD-Core Version:    0.7.0.1
 */