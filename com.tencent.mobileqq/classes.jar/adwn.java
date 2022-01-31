import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import java.util.Locale;

class adwn
  implements MessageQueue.IdleHandler
{
  adwn(advv paramadvv) {}
  
  public boolean queueIdle()
  {
    Object localObject = this.a.jdField_a_of_type_Adxf.a();
    if ((localObject != null) && (AIOImageData.class.isInstance(((adyb)localObject).a)))
    {
      AIOImageData localAIOImageData = (AIOImageData)((adyb)localObject).a;
      if ((localAIOImageData != null) && (localAIOImageData.a(4)) && (localAIOImageData.a(4) == null))
      {
        this.a.c(true);
        this.a.u();
      }
    }
    if ((localObject != null) && (AIOFilePicData.class.isInstance(((adyb)localObject).a)))
    {
      localObject = (AIOFilePicData)((adyb)localObject).a;
      if ((localObject != null) && (((AIOFilePicData)localObject).a(20)) && (((AIOFilePicData)localObject).a(20) == null))
      {
        if ((!((AIOFilePicData)localObject).d) || (!bado.a(((AIOFilePicData)localObject).b))) {
          break label211;
        }
        this.a.c(true);
        this.a.a(false);
        this.a.jdField_a_of_type_Adwu = null;
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, advv.d(this.a).getString(2131629660), new Object[] { apdh.a(((AIOFilePicData)localObject).a) }));
      }
      return false;
      label211:
      if (((AIOFilePicData)localObject).e) {
        this.a.c(false);
      } else {
        this.a.c(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adwn
 * JD-Core Version:    0.7.0.1
 */