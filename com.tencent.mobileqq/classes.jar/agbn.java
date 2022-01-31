import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import com.tencent.mobileqq.ocr.OcrCamera;

public class agbn
  implements Camera.PictureCallback
{
  public agbn(OcrCamera paramOcrCamera) {}
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.a.a(paramArrayOfByte, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agbn
 * JD-Core Version:    0.7.0.1
 */