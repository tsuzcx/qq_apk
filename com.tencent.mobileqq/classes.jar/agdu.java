import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import java.util.Locale;

class agdu
  implements agdd
{
  agdu(agdi paramagdi) {}
  
  public void a(AIOImageData paramAIOImageData, boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_Ages.a() != null) && ((this.a.jdField_a_of_type_Ages.a().a instanceof AIOImageData)))
    {
      AIOImageData localAIOImageData = (AIOImageData)this.a.jdField_a_of_type_Ages.a().a;
      if ((!paramBoolean) && (TextUtils.equals(localAIOImageData.jdField_h_of_type_JavaLangString, paramAIOImageData.jdField_h_of_type_JavaLangString)))
      {
        if (localAIOImageData.jdField_h_of_type_Long <= 0L) {
          break label127;
        }
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, agdi.am(this.a).getString(2131695500), new Object[] { arof.a(localAIOImageData.jdField_h_of_type_Long) }));
      }
    }
    for (;;)
    {
      this.a.c(true);
      return;
      label127:
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131695497);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdu
 * JD-Core Version:    0.7.0.1
 */