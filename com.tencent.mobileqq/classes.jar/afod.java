import android.hardware.Camera.Size;
import com.tencent.mobileqq.ocr.OcrCamera;
import java.util.Comparator;

public class afod
  implements Comparator
{
  public afod(OcrCamera paramOcrCamera) {}
  
  public int a(Camera.Size paramSize1, Camera.Size paramSize2)
  {
    int i = paramSize1.height * paramSize1.width;
    int j = paramSize2.height * paramSize2.width;
    if (j < i) {
      return 1;
    }
    if (j > i) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afod
 * JD-Core Version:    0.7.0.1
 */