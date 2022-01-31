import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import mqq.os.MqqHandler;

public class ajes
  implements ThreadExcutor.IThreadListener
{
  public ajes(TroopFileItemOperation paramTroopFileItemOperation, TroopFileTransferManager paramTroopFileTransferManager, TroopFileInfo paramTroopFileInfo) {}
  
  public void a() {}
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new ajet(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajes
 * JD-Core Version:    0.7.0.1
 */