import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import java.util.ArrayList;

class ahig
  extends FriendListObserver
{
  ahig(ahif paramahif) {}
  
  protected void onSearchFriendResult(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null) {
      NetSearchEngine.a(this.a.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine).removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    if (ahif.a(this.a)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramInt1 != 88) || (paramBoolean2));
        if (!paramBoolean1) {
          break;
        }
      } while (!(paramObject instanceof ArrayList));
      ThreadManager.post(new ahih(this.a.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine, ahif.a(this.a), (ArrayList)paramObject, ahif.a(this.a)), 10, null, true);
      return;
    } while (ahif.a(this.a) == null);
    ahif.a(this.a).a(null, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahig
 * JD-Core Version:    0.7.0.1
 */