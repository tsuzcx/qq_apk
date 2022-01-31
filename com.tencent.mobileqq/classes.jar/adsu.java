import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imaxad.ImaxAdNetPresenter;
import com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager;
import com.tencent.mobileqq.imaxad.ImaxAdUtil;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import java.util.ArrayList;
import java.util.Iterator;

public class adsu
  implements Runnable
{
  public adsu(ImaxAdRecentUserManager paramImaxAdRecentUserManager, boolean paramBoolean, QQAppInterface paramQQAppInterface, AdvertisementItem paramAdvertisementItem, RecentUser paramRecentUser) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      ImaxAdNetPresenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem);
    }
    ImaxAdUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.iterator();
    while (localIterator.hasNext()) {
      ImaxAdVideoPreloadManager.a(((VideoCoverItem)localIterator.next()).b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsu
 * JD-Core Version:    0.7.0.1
 */