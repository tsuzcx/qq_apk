import android.app.Activity;
import android.os.MessageQueue.IdleHandler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import java.util.Locale;

class agip
  implements MessageQueue.IdleHandler
{
  agip(aghx paramaghx) {}
  
  public boolean queueIdle()
  {
    Object localObject = this.a.jdField_a_of_type_Agjh.a();
    if ((localObject != null) && (AIOImageData.class.isInstance(((agkf)localObject).a)))
    {
      AIOImageData localAIOImageData = (AIOImageData)((agkf)localObject).a;
      if ((localAIOImageData != null) && (localAIOImageData.a(4)) && (localAIOImageData.a(4) == null))
      {
        this.a.c(true);
        this.a.u();
      }
    }
    if ((localObject != null) && (AIOFilePicData.class.isInstance(((agkf)localObject).a)))
    {
      localObject = (AIOFilePicData)((agkf)localObject).a;
      if ((localObject != null) && (((AIOFilePicData)localObject).a(20)) && (((AIOFilePicData)localObject).a(20) == null))
      {
        if ((!((AIOFilePicData)localObject).d) || (!bdil.a(((AIOFilePicData)localObject).b))) {
          break label211;
        }
        this.a.c(true);
        this.a.a(false);
        this.a.jdField_a_of_type_Agiw = null;
      }
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(Locale.CHINA, aghx.d(this.a).getString(2131695502), new Object[] { arso.a(((AIOFilePicData)localObject).a) }));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agip
 * JD-Core Version:    0.7.0.1
 */