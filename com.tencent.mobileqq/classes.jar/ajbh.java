import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Task;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskPool;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class ajbh
  implements Runnable
{
  public ajbh(TroopFileTransferManager.TaskPool paramTaskPool) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      for (;;)
      {
        if (this.a.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
        {
          this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
          return;
        }
        TroopFileTransferManager.Task localTask = (TroopFileTransferManager.Task)this.a.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        localTask.run();
        if (localTask.a != 0) {
          continue;
        }
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajbh
 * JD-Core Version:    0.7.0.1
 */