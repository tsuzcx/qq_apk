import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class agrg
  implements Runnable
{
  agrg(agrf paramagrf, Bitmap paramBitmap) {}
  
  public void run()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_Agrf.a.a.get("map_key_face");
    if ((localImageView != null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      QLog.d("Q.qqhead.freq", 1, "ProfileHeaderView updateAvatar, bitmap: " + this.jdField_a_of_type_AndroidGraphicsBitmap);
      localImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agrg
 * JD-Core Version:    0.7.0.1
 */