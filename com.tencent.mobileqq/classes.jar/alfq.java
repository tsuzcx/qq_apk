import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;

class alfq
  implements ArkAppCacheMgr.OnGetAppIcon
{
  alfq(alfo paramalfo, Context paramContext) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      alfo.a(this.jdField_a_of_type_Alfo, paramBitmap, this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alfq
 * JD-Core Version:    0.7.0.1
 */