import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.3;

public class alnm
  implements ArkAppCacheMgr.OnGetAppIcon
{
  public alnm(ArkAppDeviceModule.ObserverMethod.3 param3, bbgu parambbgu) {}
  
  public void callback(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.jdField_a_of_type_Bbgu.findViewById(2131365105)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alnm
 * JD-Core Version:    0.7.0.1
 */