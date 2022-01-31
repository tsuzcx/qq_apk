import android.content.Intent;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.activity.selectable.TextPreviewMenu;

public class ajtr
  implements benj
{
  public ajtr(TextPreviewMenu paramTextPreviewMenu, TextPreviewActivity paramTextPreviewActivity) {}
  
  public void a()
  {
    TextPreviewMenu.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu);
  }
  
  public void a(String paramString)
  {
    baja.a(paramString, "OCR_Participle_copy");
  }
  
  public void b(String paramString)
  {
    baja.a(this.jdField_a_of_type_ComTencentMobileqqActivityTextPreviewActivity, paramString);
  }
  
  public void c(String paramString)
  {
    baja.a(this.jdField_a_of_type_ComTencentMobileqqActivityTextPreviewActivity, this.jdField_a_of_type_ComTencentMobileqqActivityTextPreviewActivity.app, paramString);
  }
  
  public void d(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTextPreviewActivity, TextPreviewTranslateActivity.class);
    localIntent.putExtra("TranslateText", paramString);
    localIntent.putExtra("WhereAreYouFrom", "AIO_TEXTPREVIEW");
    TextPreviewMenu.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtr
 * JD-Core Version:    0.7.0.1
 */