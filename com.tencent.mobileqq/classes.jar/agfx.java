import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import com.tencent.mobileqq.ocr.OcrCamera;

public class agfx
  implements Camera.PictureCallback
{
  public agfx(OcrCamera paramOcrCamera) {}
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.a.a(paramArrayOfByte, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agfx
 * JD-Core Version:    0.7.0.1
 */