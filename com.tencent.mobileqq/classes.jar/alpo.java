import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.7;

public class alpo
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public alpo(ArkAppModuleReg.ModuleQQ.7 param7, bbgg parambbgg) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.jdField_a_of_type_Bbgg.findViewById(2131365106)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alpo
 * JD-Core Version:    0.7.0.1
 */