import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.portal.ShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class agmy
  implements Runnable
{
  public agmy(ShareHelper paramShareHelper, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    Bitmap localBitmap2 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Bitmap localBitmap1 = null;
    localBitmap3 = localBitmap2;
    localObject4 = localObject6;
    localObject5 = localObject7;
    try
    {
      byte[] arrayOfByte = HttpUtil.a(BaseApplication.getContext(), this.jdField_a_of_type_JavaLangString, "GET", null, null);
      if (arrayOfByte != null)
      {
        localBitmap3 = localBitmap2;
        localObject4 = localObject6;
        localObject5 = localObject7;
        localBitmap2 = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
        localBitmap1 = localBitmap2;
        if (localBitmap2 != null)
        {
          localBitmap3 = localBitmap2;
          localObject4 = localBitmap2;
          localObject5 = localBitmap2;
          int i = localBitmap2.getWidth();
          localBitmap3 = localBitmap2;
          localObject4 = localBitmap2;
          localObject5 = localBitmap2;
          int j = localBitmap2.getHeight();
          localBitmap1 = localBitmap2;
          if (i * j > 8000)
          {
            localBitmap3 = localBitmap2;
            localObject4 = localBitmap2;
            localObject5 = localBitmap2;
            double d1 = Math.sqrt(8000.0D / (i * j));
            localBitmap3 = localBitmap2;
            localObject4 = localBitmap2;
            localObject5 = localBitmap2;
            localBitmap1 = Bitmap.createScaledBitmap(localBitmap2, (int)(i * d1), (int)(j * d1), true);
            localBitmap3 = localBitmap2;
            localObject4 = localBitmap2;
            localObject5 = localBitmap2;
            localBitmap2.recycle();
          }
          localBitmap3 = localBitmap1;
          localObject4 = localBitmap1;
          localObject5 = localBitmap1;
          this.jdField_a_of_type_ComTencentMobileqqPortalShareHelper.a = new WeakReference(localBitmap1);
        }
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
        Object localObject1 = localBitmap3;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Object localObject2 = localObject4;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject3 = localObject5;
      }
    }
    ShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqPortalShareHelper).runOnUiThread(new agmz(this, localBitmap1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmy
 * JD-Core Version:    0.7.0.1
 */