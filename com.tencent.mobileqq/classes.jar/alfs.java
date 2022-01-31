import android.graphics.Bitmap;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class alfs
  implements ArkAppCacheMgr.OnGetAppIcon
{
  alfs(alfr paramalfr) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      alfo.a(this.a.jdField_a_of_type_Alfo, paramBitmap, this.a.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alfs
 * JD-Core Version:    0.7.0.1
 */