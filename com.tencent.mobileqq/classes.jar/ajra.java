import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfoManager;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.qphone.base.util.QLog;

public class ajra
  implements Runnable
{
  public ajra(TroopTopicMgr paramTroopTopicMgr, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "syncTopicExtInfo query db");
    }
    TroopTopicDetailInfo localTroopTopicDetailInfo = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr.a.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq, true);
    if (localTroopTopicDetailInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr.b(localTroopTopicDetailInfo);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForTroopTopic)) {
        if (((MessageForTroopTopic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).pVersion < localTroopTopicDetailInfo.pVersion)
        {
          if (QLog.isColorLevel()) {
            QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "syncTopicExtInfo fetch network");
          }
          TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localTroopTopicDetailInfo);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (localTroopTopicDetailInfo.pVersion == localTroopTopicDetailInfo.mOldVersion);
      if (QLog.isColorLevel()) {
        QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "syncTopicExtInfo fetch network 2");
      }
      TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localTroopTopicDetailInfo);
      return;
    }
    QLog.e(".troop.troop_topic.TroopTopicMgr", 2, "syncTopicExtInfo there is no topic info in db.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajra
 * JD-Core Version:    0.7.0.1
 */