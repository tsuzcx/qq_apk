import android.os.Handler;
import android.os.Message;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.concurrent.atomic.AtomicInteger;

class agcj
  implements agce
{
  agcj(agcf paramagcf) {}
  
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
    localObject = osx.a();
    if (paramRedTypeInfo != null) {}
    for (;;)
    {
      ((osx)localObject).b(bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agcj
 * JD-Core Version:    0.7.0.1
 */