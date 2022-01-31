import android.graphics.Bitmap;
import com.tencent.mobileqq.nearby.NearbyIconDecoder;
import com.tencent.mobileqq.util.IIconDecoder.IIconListener;
import java.util.Iterator;
import java.util.List;

public class aelz
  implements Runnable
{
  public aelz(NearbyIconDecoder paramNearbyIconDecoder, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      String[] arrayOfString = this.jdField_a_of_type_JavaLangString.split("_s_");
      if ((arrayOfString.length == 3) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyIconDecoder.a != null))
      {
        int i = Integer.parseInt(arrayOfString[0]);
        int j = Integer.parseInt(arrayOfString[2]);
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyIconDecoder.a.iterator();
        while (localIterator.hasNext()) {
          ((IIconDecoder.IIconListener)localIterator.next()).a(i, arrayOfString[1], j, this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aelz
 * JD-Core Version:    0.7.0.1
 */