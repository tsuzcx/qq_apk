import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.6;

public class alnt
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public alnt(ArkAppDeviceModule.ObserverMethod.6 param6, bbgg parambbgg) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.jdField_a_of_type_Bbgg.findViewById(2131365106)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alnt
 * JD-Core Version:    0.7.0.1
 */