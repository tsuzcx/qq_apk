import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import com.tencent.mobileqq.armap.sensor.provider.OrientationProviderNotFound;
import java.util.List;

public class alyd
  extends alyc
{
  private float[] d = new float[16];
  
  public alyd(Context paramContext, int paramInt, SensorManager paramSensorManager, alxu paramalxu)
  {
    super(paramContext, paramInt, paramSensorManager, paramalxu);
    paramContext = paramSensorManager.getDefaultSensor(15);
    if ((Build.VERSION.SDK_INT >= 18) && (paramContext != null))
    {
      this.a.add(paramContext);
      return;
    }
    throw new OrientationProviderNotFound(String.valueOf(15));
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    alxw.a(this.d, paramSensorEvent);
    super.a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alyd
 * JD-Core Version:    0.7.0.1
 */