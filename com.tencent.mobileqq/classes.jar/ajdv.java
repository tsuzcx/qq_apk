import android.graphics.Bitmap;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;

class ajdv
  implements Runnable
{
  ajdv(ajdu paramajdu) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajdv
 * JD-Core Version:    0.7.0.1
 */