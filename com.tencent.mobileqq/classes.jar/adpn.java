import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.Iterator;
import java.util.List;

public class adpn
  implements biyc
{
  public adpn(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList, athn paramathn) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      audr.d(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.getString(2131692595));
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          if (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) {
            this.jdField_a_of_type_Athn.a(localFileManagerEntity.getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.app.getCurrentAccountUin(), 0, false);
          } else {
            this.jdField_a_of_type_Athn.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpn
 * JD-Core Version:    0.7.0.1
 */