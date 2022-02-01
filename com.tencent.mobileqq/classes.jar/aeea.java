import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

public class aeea
  implements bjhv
{
  public aeea(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList, atqx paramatqx) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      auna.d(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.getString(2131692445));
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          if (bhmi.b(localFileManagerEntity.getFilePath())) {
            this.jdField_a_of_type_Atqx.a(localFileManagerEntity.getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.app.getCurrentAccountUin(), 0, false);
          } else {
            this.jdField_a_of_type_Atqx.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeea
 * JD-Core Version:    0.7.0.1
 */