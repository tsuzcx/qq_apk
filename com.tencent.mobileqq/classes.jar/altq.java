import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class altq
  implements ArkAppCacheMgr.OnGetAppIcon
{
  altq(altp paramaltp, altt paramaltt) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_Altt.b.setVisibility(0);
      this.jdField_a_of_type_Altt.a.setVisibility(0);
      this.jdField_a_of_type_Altt.a.setImageBitmap(paramBitmap);
      return;
    }
    this.jdField_a_of_type_Altt.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     altq
 * JD-Core Version:    0.7.0.1
 */