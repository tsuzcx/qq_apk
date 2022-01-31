import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.nearby.picbrowser.PicBrowserGalleryScene;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.File;

public class afbr
  implements ActionSheet.OnButtonClickListener
{
  public afbr(PicBrowserGalleryScene paramPicBrowserGalleryScene, ActionSheet paramActionSheet, File paramFile, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      AIOGalleryUtils.a(PicBrowserGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryScene), this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()));
      return;
    }
    PicBrowserGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqNearbyPicbrowserPicBrowserGalleryScene, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afbr
 * JD-Core Version:    0.7.0.1
 */