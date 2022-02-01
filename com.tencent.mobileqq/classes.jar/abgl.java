import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;

public class abgl
  implements BusinessObserver
{
  protected void a(ArrayList<DeviceInfo> paramArrayList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a((ArrayList)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abgl
 * JD-Core Version:    0.7.0.1
 */