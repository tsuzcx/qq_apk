import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import com.tencent.mobileqq.ar.ARRenderModel.GreetingCardRender;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.qphone.base.util.QLog;

public class aahf
  implements Runnable
{
  public aahf(GreetingCardRender paramGreetingCardRender) {}
  
  public void run()
  {
    try
    {
      if (GreetingCardRender.a(this.a) != null)
      {
        GreetingCardRender.a(this.a).updateTexImage();
        GreetingCardRender.a(this.a).getTransformMatrix(GreetingCardRender.a(this.a));
        GreetingCardRender.a(this.a);
        if (GreetingCardRender.a(this.a) == null) {
          GreetingCardRender.a(this.a, new RenderBuffer(540, 960, 33984));
        }
        if (GreetingCardRender.a(this.a) == null) {
          GreetingCardRender.a(this.a, new TextureRender());
        }
        GreetingCardRender.a(this.a).b();
        Matrix.setIdentityM(GreetingCardRender.b(this.a), 0);
        Matrix.rotateM(GreetingCardRender.b(this.a), 0, 180.0F, 1.0F, 0.0F, 0.0F);
        GreetingCardRender.a(this.a).a(36197, GreetingCardRender.a(this.a), GreetingCardRender.a(this.a), GreetingCardRender.b(this.a));
        GreetingCardRender.a(this.a).c();
        if ((!GreetingCardRender.a(this.a)) && (GreetingCardRender.a(this.a) != null) && (GreetingCardRender.b(this.a) > 2L))
        {
          GreetingCardRender.a(this.a, GreetingCardRender.a(this.a).a());
          GreetingCardRender.a(this.a, true);
          GreetingCardRender.b(this.a, true);
          QLog.d("GreetingCardRender", 2, "drawFrame hard decode frame update");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("GreetingCardRender", 1, "mUpdateHardTextureRunnable fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aahf
 * JD-Core Version:    0.7.0.1
 */