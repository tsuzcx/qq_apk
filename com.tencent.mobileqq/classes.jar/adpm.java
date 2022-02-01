import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

public class adpm
  implements audq
{
  public adpm(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList, athn paramathn) {}
  
  public void onNo() {}
  
  public void onYes()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        this.jdField_a_of_type_Athn.b(localFileManagerEntity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpm
 * JD-Core Version:    0.7.0.1
 */