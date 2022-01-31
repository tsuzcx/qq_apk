import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class akzw
{
  private avyz jdField_a_of_type_Avyz;
  private EGL10 jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10 = (EGL10)EGLContext.getEGL();
  private EGLContext jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetCurrentContext();
  private EGLDisplay jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetCurrentDisplay();
  private EGLSurface jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface = this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglGetCurrentSurface(12377);
  
  public akzw(avyy paramavyy, Surface paramSurface)
  {
    this.jdField_a_of_type_Avyz = new avyz(paramavyy);
    this.jdField_a_of_type_Avyz.a(paramSurface);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGL10.eglMakeCurrent(this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLDisplay, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLSurface, this.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Avyz.a(paramLong);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Avyz.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Avyz.a();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Avyz != null)
    {
      this.jdField_a_of_type_Avyz.a();
      this.jdField_a_of_type_Avyz = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akzw
 * JD-Core Version:    0.7.0.1
 */