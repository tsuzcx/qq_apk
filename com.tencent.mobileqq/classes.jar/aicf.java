import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import java.util.Locale;

class aicf
  implements aibm
{
  aicf(aibr paramaibr) {}
  
  public void a(AIOImageData paramAIOImageData, boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_Aicx.a() != null) && ((this.a.jdField_a_of_type_Aicx.a().a instanceof AIOImageData)))
    {
      AIOImageData localAIOImageData = (AIOImageData)this.a.jdField_a_of_type_Aicx.a().a;
      if ((!paramBoolean) && (TextUtils.equals(localAIOImageData.jdField_h_of_type_JavaLangString, paramAIOImageData.jdField_h_of_type_JavaLangString)))
      {
        if (localAIOImageData.jdField_h_of_type_Long <= 0L) {
          break label127;
        }
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, aibr.N(this.a).getString(2131694456), new Object[] { auog.a(localAIOImageData.jdField_h_of_type_Long) }));
      }
    }
    for (;;)
    {
      this.a.c(true);
      return;
      label127:
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131694453);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicf
 * JD-Core Version:    0.7.0.1
 */