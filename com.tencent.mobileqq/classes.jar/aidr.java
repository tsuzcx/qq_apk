import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.util.OffScreenGLSurface;

public class aidr
  implements Runnable
{
  public aidr(OffScreenGLSurface paramOffScreenGLSurface) {}
  
  public void run()
  {
    OffScreenGLSurface.a(this.a).sendFirstFrameMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aidr
 * JD-Core Version:    0.7.0.1
 */