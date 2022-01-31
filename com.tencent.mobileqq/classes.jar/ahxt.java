import android.opengl.GLES20;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

public class ahxt
  implements Runnable
{
  public ahxt(VideoSprite paramVideoSprite) {}
  
  public void run()
  {
    GLES20.glDeleteTextures(this.a.a.length, this.a.a, 0);
    GLES20.glFlush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahxt
 * JD-Core Version:    0.7.0.1
 */