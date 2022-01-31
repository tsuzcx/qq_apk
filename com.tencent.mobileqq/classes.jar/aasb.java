import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

public class aasb
  implements bcwm
{
  public aasb(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList, aouu paramaouu) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      aptx.d(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.getString(2131692830));
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if (!localFileManagerEntity.sendCloudUnsuccessful()) {
          if (bbdx.b(localFileManagerEntity.getFilePath())) {
            this.jdField_a_of_type_Aouu.a(localFileManagerEntity.getFilePath(), "", this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.app.getCurrentAccountUin(), 0, false);
          } else {
            this.jdField_a_of_type_Aouu.a(localFileManagerEntity, String.valueOf(localFileManagerEntity.peerUin));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aasb
 * JD-Core Version:    0.7.0.1
 */