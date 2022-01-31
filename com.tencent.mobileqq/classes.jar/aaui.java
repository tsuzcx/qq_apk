import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.ark.ArkAppCenter.OnGetAppIcon;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter.ItemViewHolder;

public class aaui
  implements ArkAppCenter.OnGetAppIcon
{
  public aaui(ArkHorizontalListViewAdapter paramArkHorizontalListViewAdapter, ArkHorizontalListViewAdapter.ItemViewHolder paramItemViewHolder) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListViewAdapter$ItemViewHolder.a.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaui
 * JD-Core Version:    0.7.0.1
 */