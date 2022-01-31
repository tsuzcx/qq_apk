import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class alrf
  implements ArkAppCacheMgr.OnGetAppIcon
{
  alrf(alre paramalre, alrg paramalrg) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_Alrg.a.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alrf
 * JD-Core Version:    0.7.0.1
 */