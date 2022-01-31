import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.ark.ArkAiBubbleView;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter.OnGetAppIcon;

public class aayp
  implements ArkAppCenter.OnGetAppIcon
{
  public aayp(ArkAiBubbleView paramArkAiBubbleView) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar == null)
    {
      ArkAppCenter.a(paramString);
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    this.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aayp
 * JD-Core Version:    0.7.0.1
 */