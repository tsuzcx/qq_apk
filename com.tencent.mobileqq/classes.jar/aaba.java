import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.mobileqq.ar.ARRenderModel.GreetingCardRender;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class aaba
  implements Runnable
{
  public aaba(GreetingCardRender paramGreetingCardRender) {}
  
  public void run()
  {
    if (GreetingCardRender.a(this.a) != null) {}
    try
    {
      GreetingCardRender.a(this.a).stop();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("GreetingCardRender", 2, "playVideo fail.", localException);
      return;
    }
    finally
    {
      if (GreetingCardRender.a(this.a) != null)
      {
        GreetingCardRender.a(this.a).setOnFrameAvailableListener(null);
        GreetingCardRender.a(this.a).release();
        GreetingCardRender.a(this.a, null);
      }
      if (GreetingCardRender.a(this.a) != -1)
      {
        GLES20.glDeleteTextures(1, new int[] { GreetingCardRender.a(this.a) }, 0);
        GreetingCardRender.c(this.a, -1);
      }
      if (GreetingCardRender.a(this.a) != null)
      {
        GreetingCardRender.a(this.a).d();
        GreetingCardRender.a(this.a, null);
      }
      if (GreetingCardRender.b(this.a) != null)
      {
        GreetingCardRender.b(this.a).d();
        GreetingCardRender.b(this.a, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaba
 * JD-Core Version:    0.7.0.1
 */