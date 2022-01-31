import android.graphics.Bitmap;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;

class ajrz
  implements Runnable
{
  ajrz(ajry paramajry) {}
  
  public void run()
  {
    Bitmap localBitmap = this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AvatarInfo.a;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.a.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(localBitmap);
      return;
    }
    this.a.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrz
 * JD-Core Version:    0.7.0.1
 */