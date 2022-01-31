import android.os.Handler;
import android.os.Message;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQMapView.QQMapViewObserver;

public class aldv
  extends Handler
{
  public aldv(QQMapView paramQQMapView) {}
  
  public void handleMessage(Message paramMessage)
  {
    GeoPoint localGeoPoint;
    if ((paramMessage != null) && (paramMessage.obj != null) && (this.a.a != null)) {
      localGeoPoint = (GeoPoint)paramMessage.obj;
    }
    switch (paramMessage.arg1)
    {
    default: 
      return;
    case 0: 
      this.a.a.a(localGeoPoint);
      return;
    }
    this.a.a.b(localGeoPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aldv
 * JD-Core Version:    0.7.0.1
 */