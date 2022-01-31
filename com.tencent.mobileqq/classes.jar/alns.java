import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.6;

public class alns
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public alns(ArkAppDeviceModule.ObserverMethod.6 param6, bbgu parambbgu) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.jdField_a_of_type_Bbgu.findViewById(2131365105)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alns
 * JD-Core Version:    0.7.0.1
 */