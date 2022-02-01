import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class agom
  implements ArkAppCacheMgr.OnGetAppIcon
{
  agom(agol paramagol1, agol paramagol2) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.b.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agom
 * JD-Core Version:    0.7.0.1
 */