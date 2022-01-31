import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.teamwork.spread.BaseTimAIOTipsProcessor.ListResult;
import com.tencent.mobileqq.teamwork.spread.ConfigSetting;
import com.tencent.mobileqq.teamwork.spread.TroopFileAIOMsgTips;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ainj
  implements Runnable
{
  public ainj(TroopFileAIOMsgTips paramTroopFileAIOMsgTips, BaseTimAIOTipsProcessor.ListResult paramListResult) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileAIOMsgTips", 1, "sub Thread getWordsList by TroopFile[" + System.currentTimeMillis() + "]");
    }
    long l1 = MessageCache.a();
    ArrayList localArrayList = new ArrayList();
    int i = this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadTroopFileAIOMsgTips.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting.d();
    List localList = this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadTroopFileAIOMsgTips.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadTroopFileAIOMsgTips.jdField_a_of_type_JavaLangString, 1, 9223372036854775807L, 3, 9223372036854775807L, new int[] { -2017 }, i);
    if ((localList == null) || (localList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileAIOMsgTips", 1, "current AIO has not File,peerType[" + this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadTroopFileAIOMsgTips.jdField_a_of_type_Int + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadBaseTimAIOTipsProcessor$ListResult.a(localArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileAIOMsgTips", 1, "current AIO msg count[" + localList.size() + "]");
    }
    long l2 = this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadTroopFileAIOMsgTips.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting.c() * 3600;
    i = 0;
    if (i < localList.size())
    {
      Object localObject = (MessageRecord)localList.get(i);
      if (!(localObject instanceof MessageForTroopFile)) {}
      for (;;)
      {
        i += 1;
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadTroopFileAIOMsgTips.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq != ((MessageRecord)localObject).uniseq) && (new TroopFileAIOMsgTips(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadTroopFileAIOMsgTips.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject, this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadTroopFileAIOMsgTips.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting).a()))
        {
          localObject = (MessageForTroopFile)localObject;
          if (l1 - ((MessageForTroopFile)localObject).time <= l2) {
            localArrayList.add(((MessageForTroopFile)localObject).fileName);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileAIOMsgTips", 1, "find file msg count[" + localArrayList.size() + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadBaseTimAIOTipsProcessor$ListResult.a(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainj
 * JD-Core Version:    0.7.0.1
 */