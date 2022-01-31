import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.teamwork.spread.BaseTimAIOTipsProcessor.ListResult;
import com.tencent.mobileqq.teamwork.spread.BuddyFileAIOMsgTips;
import com.tencent.mobileqq.teamwork.spread.ConfigSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class aine
  implements Runnable
{
  public aine(BuddyFileAIOMsgTips paramBuddyFileAIOMsgTips, BaseTimAIOTipsProcessor.ListResult paramListResult) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BuddyFileAIOMsgTips", 1, "sub Thread getWordsList by buddyFile[" + System.currentTimeMillis() + "]");
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadBuddyFileAIOMsgTips.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadBuddyFileAIOMsgTips.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("BuddyFileAIOMsgTips", 1, "current AIO has not File,peerType[" + this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadBuddyFileAIOMsgTips.jdField_a_of_type_Int + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadBaseTimAIOTipsProcessor$ListResult.a(localArrayList);
      return;
    }
    Object localObject2 = new StringTokenizer(this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadBuddyFileAIOMsgTips.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadConfigSetting.a(), "|");
    if (!((StringTokenizer)localObject2).hasMoreTokens())
    {
      if (QLog.isColorLevel()) {
        QLog.i("BuddyFileAIOMsgTips", 1, "config filetype is null");
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadBaseTimAIOTipsProcessor$ListResult.a(localArrayList);
      return;
    }
    String[] arrayOfString = new String[((StringTokenizer)localObject2).countTokens()];
    int i = 0;
    while (((StringTokenizer)localObject2).hasMoreTokens())
    {
      arrayOfString[i] = ((StringTokenizer)localObject2).nextToken();
      i += 1;
    }
    long l = MessageCache.a();
    localObject1 = ((List)localObject1).iterator();
    label385:
    label434:
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        if (((FileManagerEntity)localObject2).uniseq == this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadBuddyFileAIOMsgTips.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) {
          continue;
        }
        if (((FileManagerEntity)localObject2).srvTime - l * 1000L <= 86400000L) {
          break label369;
        }
        if (QLog.isColorLevel()) {
          QLog.i("BuddyFileAIOMsgTips", 1, "file is over 24h");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("BuddyFileAIOMsgTips", 1, "find file msg count[" + localArrayList.size() + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadBaseTimAIOTipsProcessor$ListResult.a(localArrayList);
      return;
      label369:
      String str = FileUtil.a(((FileManagerEntity)localObject2).fileName);
      int j = arrayOfString.length;
      i = 0;
      if (i < j) {
        if (!arrayOfString[i].equalsIgnoreCase(str)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label434;
        }
        localArrayList.add(((FileManagerEntity)localObject2).fileName);
        break;
        i += 1;
        break label385;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aine
 * JD-Core Version:    0.7.0.1
 */