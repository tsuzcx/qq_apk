import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public final class aacw
  implements Runnable
{
  public aacw(SosoInterface.OnLocationListener paramOnLocationListener) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("startLocation() reqLoc=").append(this.a.g).append(" askGPS=").append(this.a.h).append(" level=").append(this.a.jdField_c_of_type_Int).append(" caller=").append(this.a.jdField_c_of_type_JavaLangString).append(" ui=").append(this.a.e).append(" goon=").append(this.a.f);
      if (SosoInterface.a().get() == 0)
      {
        localObject = " do startLocation";
        QLog.d("SOSO.LBS", 2, (String)localObject);
      }
    }
    else
    {
      SosoInterface.c(this.a);
      if (SosoInterface.a().get() != 0) {
        break label450;
      }
      if (this.a != SosoInterface.a()) {
        break label435;
      }
      SosoInterface.a().set(1);
      this.a.d = SystemClock.elapsedRealtime();
      localObject = TencentLocationRequest.create();
      ((TencentLocationRequest)localObject).setInterval(SosoInterface.a);
      ((TencentLocationRequest)localObject).setRequestLevel(this.a.jdField_c_of_type_Int);
      ((TencentLocationRequest)localObject).setAllowCache(true);
      ((TencentLocationRequest)localObject).setAllowGPS(this.a.h);
      ((TencentLocationRequest)localObject).setCheckInterval(30000L);
      if (this.a.g) {
        break label445;
      }
      bool = true;
      TencentExtraKeys.setRequestRawData((TencentLocationRequest)localObject, bool);
      ((TencentLocationRequest)localObject).getExtras().putInt("qq_level", this.a.jdField_c_of_type_Int);
      ((TencentLocationRequest)localObject).getExtras().putBoolean("qq_reqLocation", this.a.g);
      ((TencentLocationRequest)localObject).getExtras().putString("qq_caller", this.a.jdField_c_of_type_JavaLangString);
      ((TencentLocationRequest)localObject).getExtras().putBoolean("qq_goonListener", this.a.f);
      SosoInterface.b(0);
      SosoInterface.a(SystemClock.elapsedRealtime());
      SosoInterface.c(0);
      SosoInterface.OnLocationListener.b(this.a, true);
      if (SosoInterface.a() == null) {
        SosoInterface.a(TencentLocationManager.getInstance(BaseApplicationImpl.getContext()));
      }
      if (SosoInterface.a().hasMessages(1001)) {
        SosoInterface.a().removeMessages(1001);
      }
      SosoInterface.a().sendEmptyMessageDelayed(1001, 35000L);
      SosoInterface.a(0);
      i = SosoInterface.a().requestLocationUpdates((TencentLocationRequest)localObject, SosoInterface.a(), ThreadManager.getSubThreadLooper());
      QLog.i("SOSO.LBS", 1, "location manager requestLocationUpdates result is: " + i);
    }
    label435:
    label445:
    label450:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        int i;
        return;
        localObject = " waitting...";
        break;
        SosoInterface.a().set(2);
        continue;
        boolean bool = false;
      }
    }
    QLog.d("SOSO.LBS", 2, "status != REQ_STOP");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aacw
 * JD-Core Version:    0.7.0.1
 */