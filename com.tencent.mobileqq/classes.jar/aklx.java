import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessManager.WebProcessStartListener;
import java.lang.ref.WeakReference;

public class aklx
  implements Runnable
{
  int jdField_a_of_type_Int;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public aklx(int paramInt, WebProcessManager.WebProcessStartListener paramWebProcessStartListener)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebProcessStartListener);
  }
  
  public void run()
  {
    WebProcessManager.WebProcessStartListener localWebProcessStartListener = (WebProcessManager.WebProcessStartListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (!WebProcessManager.c())
    {
      WebProcessManager.b(true);
      WebProcessManager.a(false);
      WebProcessManager.b(this.jdField_a_of_type_Int);
      if (localWebProcessStartListener != null) {
        localWebProcessStartListener.a(true);
      }
    }
    while (localWebProcessStartListener == null) {
      return;
    }
    localWebProcessStartListener.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aklx
 * JD-Core Version:    0.7.0.1
 */