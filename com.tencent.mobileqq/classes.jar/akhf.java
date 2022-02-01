import android.os.Handler;
import android.os.Message;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.concurrent.atomic.AtomicInteger;

class akhf
  implements akgz
{
  akhf(akha paramakha) {}
  
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
    localObject = pfs.a();
    if (paramRedTypeInfo != null) {}
    for (;;)
    {
      ((pfs)localObject).b(bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akhf
 * JD-Core Version:    0.7.0.1
 */