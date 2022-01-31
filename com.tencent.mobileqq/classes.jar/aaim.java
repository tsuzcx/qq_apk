import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

public class aaim
  implements apca
{
  public aaim(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList, aodw paramaodw) {}
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        this.jdField_a_of_type_Aodw.b(localFileManagerEntity);
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaim
 * JD-Core Version:    0.7.0.1
 */