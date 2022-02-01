import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.Conversation.22.1;
import com.tencent.mobileqq.activity.home.Conversation.22.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class ajbv
  implements GLSurfaceView.Renderer
{
  public ajbv(Conversation paramConversation) {}
  
  public void onDrawFrame(GL10 paramGL10) {}
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2) {}
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    Conversation.a(this.a, paramGL10.glGetString(7937));
    if (Conversation.a(this.a) != null) {
      ThreadManager.post(new Conversation.22.1(this), 5, null, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_GPU", 2, "onSurfaceCreated|GL_RENDERER= " + Conversation.a(this.a));
    }
    this.a.b(new Conversation.22.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbv
 * JD-Core Version:    0.7.0.1
 */