import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManagerImpl.CameraOpenErrorCallbackForward.1;
import com.tencent.mobileqq.camera.CameraManagerImpl.CameraOpenErrorCallbackForward.2;
import com.tencent.mobileqq.camera.CameraManagerImpl.CameraOpenErrorCallbackForward.3;

public class alqy
  implements alqp
{
  private final alqp jdField_a_of_type_Alqp;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.CameraOpenErrorCallbackForward.1(this, paramInt));
  }
  
  public void a(alql paramalql)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.CameraOpenErrorCallbackForward.3(this, paramalql));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraManagerImpl.CameraOpenErrorCallbackForward.2(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alqy
 * JD-Core Version:    0.7.0.1
 */