import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.UpdateAppByNameTask;
import java.util.ArrayList;

public class abck
  implements Runnable
{
  public abck(ArkLocalAppMgr paramArkLocalAppMgr, ArkLocalAppMgr.UpdateAppByNameTask paramUpdateAppByNameTask) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.b.size())
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.a.get(i);
      abcy localabcy = (abcy)this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask.b.get(i);
      if (localabcy != null) {
        localabcy.a(this.jdField_a_of_type_ComTencentMobileqqArkArkLocalAppMgr$UpdateAppByNameTask, localObject);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abck
 * JD-Core Version:    0.7.0.1
 */