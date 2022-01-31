import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class akpx
  implements akqt
{
  private akpx(ApolloTextureView paramApolloTextureView) {}
  
  public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    if (this.a.mIsDestroy != null) {
      this.a.mIsDestroy.set(false);
    }
    int i = aknx.a();
    QLog.d("ApolloTextureView", 1, new Object[] { "[createContext], id:" + Thread.currentThread().getId(), ",openGLVersion: ", i + ", hashCode: " + hashCode() });
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = 12440;
    arrayOfInt[1] = i;
    arrayOfInt[2] = 12344;
    EGLContext localEGLContext2 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, arrayOfInt);
    EGLContext localEGLContext1 = localEGLContext2;
    if (localEGLContext2 == null)
    {
      localEGLContext1 = localEGLContext2;
      if (arrayOfInt[1] == 3)
      {
        QLog.e("ApolloTextureView", 1, "[createContext], context error, try foll back opengl 2.0");
        arrayOfInt[1] = 2;
        localEGLContext1 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, arrayOfInt);
      }
    }
    return localEGLContext1;
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    StringBuilder localStringBuilder = new StringBuilder("[destroyContext], id:").append(Thread.currentThread().getId());
    if ((this.a.mRender != null) && (this.a.mRender.getSavaWrapper() != null)) {
      localStringBuilder.append(", director: ").append(this.a.mRender.getSavaWrapper().toString() + ", hashCode: " + hashCode());
    }
    QLog.d("ApolloTextureView", 1, localStringBuilder.toString());
    if (this.a.mIsDestroy != null) {
      this.a.mIsDestroy.set(true);
    }
    if (this.a.mRender != null) {
      this.a.mRender.onDestroy();
    }
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpx
 * JD-Core Version:    0.7.0.1
 */