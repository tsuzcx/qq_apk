import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import java.util.Locale;

class aehe
  implements aegn
{
  aehe(aegs paramaegs) {}
  
  public void a(AIOImageData paramAIOImageData, boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_Aeic.a() != null) && ((this.a.jdField_a_of_type_Aeic.a().a instanceof AIOImageData)))
    {
      AIOImageData localAIOImageData = (AIOImageData)this.a.jdField_a_of_type_Aeic.a().a;
      if ((!paramBoolean) && (TextUtils.equals(localAIOImageData.jdField_h_of_type_JavaLangString, paramAIOImageData.jdField_h_of_type_JavaLangString)))
      {
        if (localAIOImageData.jdField_h_of_type_Long <= 0L) {
          break label127;
        }
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, aegs.am(this.a).getString(2131695342), new Object[] { apvd.a(localAIOImageData.jdField_h_of_type_Long) }));
      }
    }
    for (;;)
    {
      this.a.c(true);
      return;
      label127:
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131695339);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aehe
 * JD-Core Version:    0.7.0.1
 */