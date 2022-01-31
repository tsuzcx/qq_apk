import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment;
import mqq.os.MqqHandler;

public class ahfe
  implements Runnable
{
  public ahfe(HotWordsForSubBussFragment paramHotWordsForSubBussFragment, boolean paramBoolean) {}
  
  public void run()
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentHotWordsForSubBussFragment.a.a(UniteSearchHandler.a);
    ThreadManager.getUIHandler().post(new ahff(this, arrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahfe
 * JD-Core Version:    0.7.0.1
 */