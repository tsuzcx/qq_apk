import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

public class aciy
  implements army
{
  public aciy(ChatHistoryFileActivity paramChatHistoryFileActivity, List paramList, aqns paramaqns) {}
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (!localFileManagerEntity.sendCloudUnsuccessful()) {
        this.jdField_a_of_type_Aqns.b(localFileManagerEntity);
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aciy
 * JD-Core Version:    0.7.0.1
 */