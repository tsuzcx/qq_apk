import android.opengl.GLES20;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;

public class aiqr
  implements Runnable
{
  public aiqr(VideoSprite paramVideoSprite) {}
  
  public void run()
  {
    GLES20.glDeleteTextures(this.a.a.length, this.a.a, 0);
    GLES20.glFlush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqr
 * JD-Core Version:    0.7.0.1
 */