import com.tencent.mobileqq.business.sougou.WordMatchManager;
import com.tencent.mobileqq.business.sougou.WordMatchManager.MatcherCallback;
import java.util.ArrayList;
import java.util.Iterator;

class abtk
  implements Runnable
{
  abtk(abtj paramabtj) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.b = this.a.jdField_a_of_type_Boolean;
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.c = this.a.jdField_a_of_type_Boolean;
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.d = false;
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.e = false;
    Iterator localIterator = this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      WordMatchManager.MatcherCallback localMatcherCallback = (WordMatchManager.MatcherCallback)localIterator.next();
      if (localMatcherCallback != null) {
        localMatcherCallback.a(this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager$WordMatcher);
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessSougouWordMatchManager.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abtk
 * JD-Core Version:    0.7.0.1
 */