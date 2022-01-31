import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.3;

public class alnn
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public alnn(ArkAppDeviceModule.ObserverMethod.3 param3, bbgg parambbgg) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.jdField_a_of_type_Bbgg.findViewById(2131365106)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alnn
 * JD-Core Version:    0.7.0.1
 */