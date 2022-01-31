import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class aejo
  implements mre
{
  aejo(aejb paramaejb) {}
  
  public void a()
  {
    if ((ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) != null) || (QLog.isColorLevel())) {
      QLog.d(".troop.notify_feeds.aio", 2, "getAppIds onFailed, reqNotifyItems");
    }
    azhh.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
  
  public void a(ArrayList<TroopAppInfo> paramArrayList)
  {
    if (ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) != null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(1L));
      localArrayList.add(Long.valueOf(2L));
      localArrayList.add(Long.valueOf(1101236949L));
      localArrayList.add(Long.valueOf(1101484419L));
      localArrayList.add(Long.valueOf(1102858908L));
      localArrayList.add(Long.valueOf(1106611799L));
      localArrayList.add(Long.valueOf(1104445552L));
      localArrayList.add(Long.valueOf(1106717414L));
      localArrayList.add(Long.valueOf(101509131L));
      localArrayList.add(Long.valueOf(1106588005L));
      localArrayList.add(Long.valueOf(1106664488L));
      localArrayList.add(Long.valueOf(101618516L));
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          localArrayList.add(Long.valueOf(((TroopAppInfo)paramArrayList.next()).appId));
        }
      }
      paramArrayList = (ajtg)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    } while (paramArrayList == null);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.notify_feeds.aio", 2, "send_oidb_0x8c9_2, appIds.size=" + localArrayList.size());
    }
    paramArrayList.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localArrayList, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aejo
 * JD-Core Version:    0.7.0.1
 */