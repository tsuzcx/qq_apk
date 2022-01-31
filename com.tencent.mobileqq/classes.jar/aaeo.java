import android.graphics.Bitmap;
import com.tencent.mobileqq.arcard.ARCardCameraRecordFragment;
import com.tencent.mobileqq.arcard.ARCardUtils;
import java.io.File;

public class aaeo
  implements Runnable
{
  public aaeo(ARCardCameraRecordFragment paramARCardCameraRecordFragment, int paramInt, Object paramObject) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 1001)
    {
      Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaLangObject;
      ARCardUtils.a(localBitmap, new File("/sdcard/test/123.jpg"), true);
      localBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aaeo
 * JD-Core Version:    0.7.0.1
 */