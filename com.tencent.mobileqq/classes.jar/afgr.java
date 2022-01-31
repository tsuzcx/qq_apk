import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserImage.OnLoadListener;

public class afgr
  implements Runnable
{
  public afgr(PicBrowserImage paramPicBrowserImage, URLDrawable paramURLDrawable, PicBrowserImage.OnLoadListener paramOnLoadListener, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 2)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserImage$OnLoadListener.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentImageURLDrawable.getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afgr
 * JD-Core Version:    0.7.0.1
 */