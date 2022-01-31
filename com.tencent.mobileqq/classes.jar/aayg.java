import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.ark.ArkAppCenter.OnGetAppIcon;
import com.tencent.mobileqq.ark.ArkTipsManager;

public class aayg
  implements ArkAppCenter.OnGetAppIcon
{
  public aayg(ArkTipsManager paramArkTipsManager, Context paramContext) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ArkTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager, paramBitmap, this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayg
 * JD-Core Version:    0.7.0.1
 */