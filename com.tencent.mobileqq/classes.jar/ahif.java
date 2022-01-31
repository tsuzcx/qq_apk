import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import java.util.concurrent.CountDownLatch;

public class ahif
  implements Runnable
{
  private int jdField_a_of_type_Int;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ahig(this);
  private ISearchListener jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener;
  private String jdField_a_of_type_JavaLangString;
  public CountDownLatch a;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public ahif(NetSearchEngine paramNetSearchEngine, String paramString, int[] paramArrayOfInt, int paramInt, ISearchListener paramISearchListener)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = paramISearchListener;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = null;
    NetSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
  
  public void run()
  {
    NetSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_Int);
    if (NetSearchEngine.a(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine) == 12)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfInt, NetSearchEngine.b, NetSearchEngine.jdField_a_of_type_Double, false, 1);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactSearchFacade.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfInt, NetSearchEngine.b, NetSearchEngine.jdField_a_of_type_Double, false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahif
 * JD-Core Version:    0.7.0.1
 */