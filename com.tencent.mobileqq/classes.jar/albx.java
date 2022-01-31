import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.open.agent.FriendChooser.GridViewAdapter;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;

public class albx
  implements ImageLoader.ImageLoadListener
{
  public albx(FriendChooser.GridViewAdapter paramGridViewAdapter, ImageView paramImageView) {}
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     albx
 * JD-Core Version:    0.7.0.1
 */