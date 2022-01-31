import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class alud
  implements ArkAppCacheMgr.OnGetAppIcon
{
  alud(alub paramalub, Context paramContext) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      alub.a(this.jdField_a_of_type_Alub, paramBitmap, this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alud
 * JD-Core Version:    0.7.0.1
 */