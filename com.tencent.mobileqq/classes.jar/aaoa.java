import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.ark.ArkAppCenter.OnGetAppIcon;
import com.tencent.mobileqq.utils.QQCustomDialog;

class aaoa
  implements ArkAppCenter.OnGetAppIcon
{
  aaoa(aanz paramaanz, QQCustomDialog paramQQCustomDialog) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      ((ImageView)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131364041)).setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaoa
 * JD-Core Version:    0.7.0.1
 */