import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.provider.MediaStore.Video.Thumbnails;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.net.URL;

public class agqr
  implements aywy
{
  Context jdField_a_of_type_AndroidContentContext;
  LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  
  public agqr(Context paramContext, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
  }
  
  public Bitmap a(URL paramURL)
  {
    paramURL = this.jdField_a_of_type_AndroidContentContext.getContentResolver();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    return ThumbnailUtils.extractThumbnail(MediaStore.Video.Thumbnails.getThumbnail(paramURL, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo._id, 1, localOptions), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agqr
 * JD-Core Version:    0.7.0.1
 */