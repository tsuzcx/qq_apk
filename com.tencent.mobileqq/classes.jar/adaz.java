import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class adaz
  implements ArkAppCacheMgr.OnGetAppIcon
{
  adaz(aday paramaday) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.a.b.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.a.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.a.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adaz
 * JD-Core Version:    0.7.0.1
 */