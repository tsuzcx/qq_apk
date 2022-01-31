import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class aity
  implements aiuu
{
  private aity(ApolloTextureView paramApolloTextureView) {}
  
  public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    QLog.d("ApolloTextureView", 1, "[createContext], id:" + Thread.currentThread().getId());
    if (this.a.mIsDestroy != null) {
      this.a.mIsDestroy.set(false);
    }
    return paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    QLog.d("ApolloTextureView", 1, "[destroyContext], id:" + Thread.currentThread().getId());
    if (this.a.mIsDestroy != null) {
      this.a.mIsDestroy.set(true);
    }
    if (this.a.mRender != null) {
      this.a.mRender.onDestroy();
    }
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aity
 * JD-Core Version:    0.7.0.1
 */