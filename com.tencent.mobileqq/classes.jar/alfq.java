import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.mobileqq.worldcup.ARWorldCupMediaPlayerWrapper;
import com.tencent.mobileqq.worldcup.ARWorldCupMediaPlayerWrapper.OnPlayMediaStatusListener;
import com.tencent.qphone.base.util.QLog;

public class alfq
  implements Runnable
{
  public alfq(ARWorldCupMediaPlayerWrapper paramARWorldCupMediaPlayerWrapper) {}
  
  public void run()
  {
    try
    {
      if (ARWorldCupMediaPlayerWrapper.a(this.a)) {
        return;
      }
      if (ARWorldCupMediaPlayerWrapper.a(this.a) != null)
      {
        ARWorldCupMediaPlayerWrapper.a(this.a).updateTexImage();
        ARWorldCupMediaPlayerWrapper.a(this.a).getTransformMatrix(ARWorldCupMediaPlayerWrapper.a(this.a));
        ARWorldCupMediaPlayerWrapper.a(this.a);
        ARWorldCupMediaPlayerWrapper.a(this.a);
        Matrix.setIdentityM(ARWorldCupMediaPlayerWrapper.b(this.a), 0);
        ARWorldCupMediaPlayerWrapper.a(this.a).b();
        ARWorldCupMediaPlayerWrapper.a(this.a).a(36197, ARWorldCupMediaPlayerWrapper.a(this.a), ARWorldCupMediaPlayerWrapper.a(this.a), ARWorldCupMediaPlayerWrapper.b(this.a));
        ARWorldCupMediaPlayerWrapper.a(this.a).c();
        if ((ARWorldCupMediaPlayerWrapper.b(this.a) == 2L) && (ARWorldCupMediaPlayerWrapper.a(this.a) != null))
        {
          ARWorldCupMediaPlayerWrapper.a(this.a).a(ARWorldCupMediaPlayerWrapper.b(this.a), 0, ARWorldCupMediaPlayerWrapper.a(this.a).a());
          QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.drawFrame hardWare");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("ARWorldCupMediaPlayerWrapper", 1, "mUpdateHardTextureRunnable fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alfq
 * JD-Core Version:    0.7.0.1
 */