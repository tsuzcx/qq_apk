import android.graphics.Bitmap;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.BorderURLImageView;

class ajrr
  implements Runnable
{
  ajrr(ajrq paramajrq) {}
  
  public void run()
  {
    Bitmap localBitmap = this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AvatarInfo.a;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView.setImageBitmap(localBitmap);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView.setImageDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrr
 * JD-Core Version:    0.7.0.1
 */