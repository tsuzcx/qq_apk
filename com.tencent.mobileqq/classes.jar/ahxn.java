import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import mqq.os.MqqHandler;

public class ahxn
  implements Runnable
{
  public ahxn(BaseSearchFragment paramBaseSearchFragment, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment.c)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment.a.a();
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentBaseSearchFragment.c = true;
    }
    ThreadManager.getUIHandler().post(new ahxo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahxn
 * JD-Core Version:    0.7.0.1
 */