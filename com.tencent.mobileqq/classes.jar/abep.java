import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter.OnGetAppIcon;
import com.tencent.mobileqq.ark.ArkRecommendController.AttachAppHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public final class abep
  implements ArkAppCenter.OnGetAppIcon
{
  private ArkRecommendController.AttachAppHolder a;
  
  public abep(ArkRecommendController.AttachAppHolder paramAttachAppHolder)
  {
    this.a = paramAttachAppHolder;
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (!paramString.equals(this.a.jdField_a_of_type_JavaLangString)) {
      ArkAppCenter.a(paramString);
    }
    do
    {
      return;
      switch (this.a.jdField_a_of_type_Int)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.i("ArkRecommendController", 2, String.format(Locale.CHINA, "invalid load state: %d", new Object[] { Integer.valueOf(this.a.jdField_a_of_type_Int) }));
    return;
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.a.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130838206));
    ArkAppCenter.a(paramString);
    this.a.jdField_a_of_type_Int = 0;
    this.a.jdField_a_of_type_JavaLangString = null;
    return;
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(paramBitmap));
    this.a.jdField_a_of_type_Int = 2;
    this.a.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abep
 * JD-Core Version:    0.7.0.1
 */