import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qq.im.poi.LbsPackManager;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ARMapActivity.LocationMonitor;
import com.tencent.mobileqq.armap.ArMapHandler;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.map.ARMapEngine;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class aatk
  extends SosoInterface.OnLocationListener
{
  public aatk(ARMapActivity paramARMapActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "onConsecutiveFailure() error: " + paramInt1 + ",failCount:" + paramInt2);
    }
    this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 4, paramInt1).sendToTarget();
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (ARMapActivity.f(this.a)) {
      return;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("onLocationUpdate() (info is null??):");
      if (paramSosoLbsInfo != null) {
        break label815;
      }
    }
    label815:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ARMapActivity", 2, bool);
      double d1;
      double d2;
      int i;
      if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
      {
        d1 = paramSosoLbsInfo.a.jdField_b_of_type_Double;
        d2 = paramSosoLbsInfo.a.jdField_a_of_type_Double;
        i = (int)paramSosoLbsInfo.a.jdField_a_of_type_Float;
        localObject1 = paramSosoLbsInfo.a.m;
        if (this.a.jdField_a_of_type_Double != 0.0D)
        {
          d3 = Math.abs(d1 - this.a.jdField_a_of_type_Double);
          double d4 = Math.abs(d2 - this.a.jdField_b_of_type_Double);
          if ((d3 > 0.0005D) || (d4 > 0.0005D)) {
            this.a.a(d3, d4, i, (String)localObject1);
          }
        }
      }
      try
      {
        long l = Long.valueOf(paramSosoLbsInfo.a.f).longValue();
        if (l > 0L)
        {
          if (this.a.e != l)
          {
            ARMapActivity.c(this.a, false);
            this.a.e = l;
          }
          localObject2 = (ArMapHandler)this.a.app.a(2);
          if ((localObject2 != null) && (((ArMapHandler)localObject2).jdField_a_of_type_Long != l)) {
            ((ArMapHandler)localObject2).jdField_a_of_type_Long = l;
          }
          ARMapActivity.b(this.a);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          int j;
          float f;
          if (QLog.isColorLevel())
          {
            QLog.d("ARMapActivity", 2, "onLocationUpdate() error");
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("ARMapActivity", 2, "onLocationUpdate() mMapEngine = null or mMapEngine.mGameplayHandler = 0 ");
            }
          }
        }
      }
      this.a.jdField_a_of_type_Double = d1;
      this.a.jdField_b_of_type_Double = d2;
      ((LbsPackManager)this.a.app.getManager(214)).a(d1, d2, i);
      this.a.jdField_a_of_type_Long = System.currentTimeMillis();
      this.a.jdField_a_of_type_Float = i;
      this.a.jdField_b_of_type_JavaLangString = ((String)localObject1);
      localObject2 = paramSosoLbsInfo.a.l;
      j = paramSosoLbsInfo.a.jdField_a_of_type_Int;
      double d3 = paramSosoLbsInfo.a.jdField_a_of_type_Long;
      f = paramSosoLbsInfo.a.jdField_b_of_type_Float;
      if ((TextUtils.isEmpty((CharSequence)localObject2)) && (this.a.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity$LocationMonitor != null)) {
        this.a.jdField_a_of_type_ComTencentMobileqqArmapARMapActivity$LocationMonitor.a(paramSosoLbsInfo);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("ARMapActivity", 2, "onLocationUpdate() longitude=" + d1 + ",latitude=" + d2 + ",accuracy=" + i + ",verifyKey=" + (String)localObject2 + ",source=" + (String)localObject1 + ",imei=" + this.a.jdField_a_of_type_JavaLangString + ",fakeReason=" + j + ",speed=" + f + ",locationTime=" + d3 + " mAdcode:" + this.a.e);
        if (localObject2 != null) {
          QLog.d("ARMapActivity", 2, "onLocationUpdate-------v---verifyKey = " + (String)localObject2 + ", locationTime=" + d3 + " longitude:" + d1 + ", latitude:" + d2);
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramSosoLbsInfo = (ArMapHandler)this.a.app.a(2);
        if (paramSosoLbsInfo != null) {
          paramSosoLbsInfo.a((String)localObject2, d1, d2, d3, i, (String)localObject1, j);
        }
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine == null) || (this.a.jdField_a_of_type_ComTencentMobileqqArmapMapARMapEngine.mGameplayHandler == 0L)) {
        break label841;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.queueEvent(new aatl(this, d1, d2, (String)localObject2, d3, i, (String)localObject1, j));
      }
      if (!this.a.g) {
        this.a.g = true;
      }
      if (paramInt == 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ARMapActivity", 2, "onLocationUpdate() error: " + paramInt);
      }
      ReportController.b(null, "dc01440", "", "", "0X8007853", "0X8007853", 0, 0, "", "", "", "");
      this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, 4, paramInt).sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aatk
 * JD-Core Version:    0.7.0.1
 */