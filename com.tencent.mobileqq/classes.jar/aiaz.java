import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import java.nio.ByteBuffer;

public class aiaz
{
  public static ByteBuffer a(int paramInt1, int paramInt2)
  {
    try
    {
      if (aiay.c)
      {
        ByteBuffer localByteBuffer1 = CameraGLSurfaceView.allocate(paramInt1, paramInt2);
        aiay.b = true;
        ByteBuffer localByteBuffer2 = localByteBuffer1;
        if (localByteBuffer1 == null)
        {
          localByteBuffer2 = ByteBuffer.allocateDirect(paramInt2);
          aiay.b = false;
        }
        return localByteBuffer2;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        Object localObject = null;
        continue;
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aiaz
 * JD-Core Version:    0.7.0.1
 */