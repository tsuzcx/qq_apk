import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.8.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public class ajag
  extends Handler
{
  private LinkedList<ajai> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  
  public ajag(PreloadManager paramPreloadManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a()
  {
    WeakReference localWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager);
    ajai localajai = (ajai)this.jdField_a_of_type_JavaUtilLinkedList.getFirst();
    this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
    ThreadManager.excute(new PreloadManager.8.1(this, localWeakReference, localajai), 64, null, false);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1: 
        this.jdField_a_of_type_JavaUtilLinkedList.addLast((ajai)paramMessage.obj);
      }
    } while (this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Boolean = true;
    sendEmptyMessage(2);
    return;
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      a();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajag
 * JD-Core Version:    0.7.0.1
 */