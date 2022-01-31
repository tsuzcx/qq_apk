import android.os.Handler;
import android.os.Message;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.concurrent.atomic.AtomicInteger;

class aifd
  implements aiey
{
  aifd(aiez paramaiez) {}
  
  public void a()
  {
    this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
  }
  
  public void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo)
  {
    boolean bool = true;
    Object localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    ((Message)localObject).obj = paramRedTypeInfo;
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    localObject = oxp.a();
    if (paramRedTypeInfo != null) {}
    for (;;)
    {
      ((oxp)localObject).b(bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifd
 * JD-Core Version:    0.7.0.1
 */