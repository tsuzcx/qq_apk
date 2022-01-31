import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;

public class ahit
  extends Handler
{
  public ahit(EffectsCameraCaptureFragment paramEffectsCameraCaptureFragment, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (((paramMessage.obj instanceof Boolean)) && (((Boolean)paramMessage.obj).booleanValue()))
      {
        EffectsCameraCaptureFragment.f(this.a, false);
        EffectsCameraCaptureFragment.c(this.a).setVisibility(8);
        this.a.a.v();
      }
      else
      {
        EffectsCameraCaptureFragment.c(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahit
 * JD-Core Version:    0.7.0.1
 */