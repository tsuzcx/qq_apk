import android.text.TextUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.teamwork.spread.BaseTimAIOTipsProcessor;
import com.tencent.mobileqq.teamwork.spread.BuddyFileAIOMsgTips;
import com.tencent.mobileqq.teamwork.spread.ConfigSetting;
import com.tencent.mobileqq.teamwork.spread.TeamWorkTextMsgTipsProcessor;
import com.tencent.mobileqq.teamwork.spread.TroopFileAIOMsgTips;
import com.tencent.qphone.base.util.QLog;

public class ahyx
  implements Runnable
{
  public ahyx(AIOMessageSpreadManager paramAIOMessageSpreadManager, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    if (QLog.isDebugVersion()) {
      QLog.i("AIOMessageSpreadManager", 1, "SubThread Process Start");
    }
    if (!AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "config return false!");
      }
    }
    label279:
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForText))
      {
        AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager, new TeamWorkTextMsgTipsProcessor(AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager), this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager)));
        if (QLog.isDebugVersion()) {
          QLog.i("AIOMessageSpreadManager", 1, "message is MessageForText");
        }
      }
      for (;;)
      {
        if (AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager).a()) {
          break label294;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("AIOMessageSpreadManager", 1, "file[" + AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager).a() + "] is not support!");
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForFile))
        {
          if (QLog.isDebugVersion()) {
            QLog.i("AIOMessageSpreadManager", 1, "message is MessageForFile");
          }
          AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager, new BuddyFileAIOMsgTips(AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager), this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager)));
        }
        else
        {
          if (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTroopFile)) {
            break label279;
          }
          if (QLog.isDebugVersion()) {
            QLog.i("AIOMessageSpreadManager", 1, "message is MessageForTroopFile");
          }
          AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager, new TroopFileAIOMsgTips(AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager), this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager)));
        }
      }
    } while (!QLog.isDebugVersion());
    QLog.i("AIOMessageSpreadManager", 1, "message is unknown");
    return;
    label294:
    String str = AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager).a();
    if (QLog.isColorLevel()) {
      QLog.i("AIOMessageSpreadManager", 1, "recv new File name is :" + str);
    }
    Object localObject2 = AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager).a(AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager));
    Object localObject1;
    if (QLog.isDebugVersion())
    {
      localObject1 = new StringBuilder();
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject1).append(localObject2[i]).append(",");
        i += 1;
      }
      if (((StringBuilder)localObject1).length() > 0) {
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
      }
      QLog.i("AIOMessageSpreadManager", 1, "getConfig keyWords:" + ((StringBuilder)localObject1).toString());
    }
    int j = localObject2.length;
    int i = 0;
    if (i < j)
    {
      localObject1 = localObject2[i];
      if (!str.contains((CharSequence)localObject1)) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AIOMessageSpreadManager", 1, "keyWord[" + (String)localObject1 + "] find!");
        }
        str = AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager).a(AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager));
        localObject2 = AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager).b(AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager));
        if ((TextUtils.isEmpty(str)) && (QLog.isColorLevel())) {
          QLog.i("AIOMessageSpreadManager", 1, "tips is null! return, tips[" + str + "], link[" + (String)localObject2 + "]");
        }
        if (AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager).a(AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager)) == 1) {}
        for (str = str + (String)localObject1 + "。" + (String)localObject2;; str = str + "。" + (String)localObject2)
        {
          if ((!(AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager) instanceof BuddyFileAIOMsgTips)) && (!(AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager) instanceof TroopFileAIOMsgTips))) {
            break label743;
          }
          AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, str, (String)localObject2, "keyword", null);
          return;
          i += 1;
          break;
        }
        label743:
        if (!(AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager) instanceof TeamWorkTextMsgTipsProcessor)) {
          break;
        }
        AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, str, (String)localObject2, "text_keyword", AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager).a((String)localObject1));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "keyWords not find!");
      }
      if ((AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager) instanceof TeamWorkTextMsgTipsProcessor)) {
        break;
      }
      AIOMessageSpreadManager.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager).a(new ahyy(this, str));
      return;
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahyx
 * JD-Core Version:    0.7.0.1
 */