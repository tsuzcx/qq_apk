import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import java.nio.ByteBuffer;

public class ambg
{
  public static ByteBuffer a(int paramInt1, int paramInt2)
  {
    try
    {
      if (ambf.c)
      {
        ByteBuffer localByteBuffer1 = CameraGLSurfaceView.allocate(paramInt1, paramInt2);
        ambf.b = true;
        ByteBuffer localByteBuffer2 = localByteBuffer1;
        if (localByteBuffer1 == null)
        {
          localByteBuffer2 = ByteBuffer.allocateDirect(paramInt2);
          ambf.b = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambg
 * JD-Core Version:    0.7.0.1
 */