import com.tencent.mobileqq.ar.ObjectSurfaceView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;

public class aajy
  implements Runnable
{
  public aajy(ObjectSurfaceView paramObjectSurfaceView, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (ObjectSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView).size() > 0)
    {
      ObjectSurfaceView.b(this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView).add(this.jdField_a_of_type_JavaLangString);
      ObjectSurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqArObjectSurfaceView, this.b);
      return;
    }
    QLog.d("ObjectSurfaceView", 1, "the dataList is null, cancel the jump action.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aajy
 * JD-Core Version:    0.7.0.1
 */