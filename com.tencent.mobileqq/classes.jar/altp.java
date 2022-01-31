import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class altp
  implements ArkAppCacheMgr.OnGetAppIcon
{
  altp(alto paramalto, alts paramalts) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_Alts.b.setVisibility(0);
      this.jdField_a_of_type_Alts.a.setVisibility(0);
      this.jdField_a_of_type_Alts.a.setImageBitmap(paramBitmap);
      return;
    }
    this.jdField_a_of_type_Alts.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     altp
 * JD-Core Version:    0.7.0.1
 */