import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.open.agent.FriendChooser.SearchResultAdapter;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;

public class alby
  implements ImageLoader.ImageLoadListener
{
  public alby(FriendChooser.SearchResultAdapter paramSearchResultAdapter, ImageView paramImageView) {}
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alby
 * JD-Core Version:    0.7.0.1
 */