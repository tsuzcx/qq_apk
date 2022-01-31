import android.graphics.Bitmap;
import com.tencent.mobileqq.ark.ArkAppCenter.OnGetAppIcon;
import com.tencent.mobileqq.ark.ArkTipsManager;

class aarh
  implements ArkAppCenter.OnGetAppIcon
{
  aarh(aarg paramaarg) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ArkTipsManager.a(this.a.jdField_a_of_type_ComTencentMobileqqArkArkTipsManager, paramBitmap, this.a.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aarh
 * JD-Core Version:    0.7.0.1
 */