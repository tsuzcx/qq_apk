import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfoManager;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicObserver;
import java.util.concurrent.ConcurrentHashMap;

public class ajrh
  implements Runnable
{
  public ajrh(TroopTopicMgr paramTroopTopicMgr, String paramString, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    Object localObject = TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
    TroopTopicDetailInfo localTroopTopicDetailInfo = (TroopTopicDetailInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
    localObject = localTroopTopicDetailInfo;
    if (localTroopTopicDetailInfo == null)
    {
      localObject = new TroopTopicDetailInfo();
      ((TroopTopicDetailInfo)localObject).troopUin = this.jdField_a_of_type_JavaLangString;
      ((TroopTopicDetailInfo)localObject).msgSeq = this.jdField_a_of_type_Long;
    }
    ((TroopTopicDetailInfo)localObject).pVersion = this.b;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr.b((TroopTopicDetailInfo)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr.jdField_a_of_type_ComTencentMobileqqTroopDataTroopTopicDetailInfoManager.a((TroopTopicDetailInfo)localObject, true);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("ret", 0);
    ((Bundle)localObject).putString("troopUin", this.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putLong("msgSeq", this.jdField_a_of_type_Long);
    ((Bundle)localObject).putLong("pVersion", this.b);
    TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr).notifyObservers(TroopTopicObserver.class, 3, true, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrh
 * JD-Core Version:    0.7.0.1
 */