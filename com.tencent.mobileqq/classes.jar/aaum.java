import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.ark.ArkAppCenter.OnGetAppIcon;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter.ItemViewHolder;

class aaum
  implements ArkAppCenter.OnGetAppIcon
{
  aaum(aaul paramaaul) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.a.a.a.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaum
 * JD-Core Version:    0.7.0.1
 */