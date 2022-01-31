import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hiboom.HiBoomFontDrawer;
import java.util.List;
import java.util.Vector;

public class adxi
  implements Runnable
{
  public adxi(HiBoomFontDrawer paramHiBoomFontDrawer, List paramList) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      Bitmap localBitmap = HiBoomFontDrawer.a((String)this.jdField_a_of_type_JavaUtilList.get(i));
      if (localBitmap != null) {
        BaseApplicationImpl.sImageCache.put(this.jdField_a_of_type_JavaUtilList.get(i), localBitmap);
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer.a.add(this.jdField_a_of_type_JavaUtilList.get(i));
      }
    }
    HiBoomFontDrawer.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomFontDrawer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxi
 * JD-Core Version:    0.7.0.1
 */