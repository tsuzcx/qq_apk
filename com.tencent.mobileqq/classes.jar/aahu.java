import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.GetCurrentPositionCallback;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.PositionCallback;
import com.tencent.qphone.base.util.QLog;

class aahu
  implements Runnable
{
  aahu(aaht paramaaht, SosoInterface.SosoLbsInfo paramSosoLbsInfo, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("onLocationFinish mPositionCallback=").append(ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a)).append(", mPositionCallbackId=").append(ArkAppEventObserverManager.b(this.jdField_a_of_type_Aaht.a)).append(", mGetCurrentPositionCallback=").append(ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a)).append(", mGetCurrentPositionCallbackId=").append(ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a)).append(", lbsInfo=").append(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo).append(", lbsInfo.mLocation=");
      if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a;
        QLog.d("ArkAppEventObserverManager", 2, localObject);
      }
    }
    else
    {
      if ((ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a) != null) || (ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a) != null)) {
        break label180;
      }
      SosoInterface.b(ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a));
    }
    label180:
    label367:
    double d1;
    double d2;
    label588:
    do
    {
      do
      {
        return;
        localObject = "NULL";
        break;
      } while ((this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a == null));
      if (QLog.isColorLevel())
      {
        if (ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a) == null) {
          break label760;
        }
        QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", positionCallback=" + ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d + ", mLastLat=" + ArkAppEventObserverManager.b(this.jdField_a_of_type_Aaht.a) + ", mLastLon=" + ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a));
      }
      double d3 = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c;
      double d4 = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d;
      d1 = d3;
      d2 = d4;
      if (d3 <= 1.0E-006D)
      {
        d1 = d3;
        d2 = d4;
        if (d4 <= 1.0E-006D)
        {
          localObject = ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a);
          d3 = localObject[0];
          d4 = localObject[1];
          d1 = d4;
          d2 = d3;
          if (QLog.isColorLevel())
          {
            QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish gcj02towgs84 curLat=" + d4 + ", curLon=" + d3);
            d2 = d3;
            d1 = d4;
          }
        }
      }
      if ((ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a) != null) && ((Math.abs(d1 - ArkAppEventObserverManager.b(this.jdField_a_of_type_Aaht.a)) >= 1.0E-006D) || (Math.abs(d2 - ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a)) >= 1.0E-006D)))
      {
        localObject = ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a);
        if (this.jdField_a_of_type_Int != 0) {
          break label927;
        }
        bool = true;
        ((ArkAppEventObserverManager.PositionCallback)localObject).a(bool, d1, d2);
        ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a, d1);
        ArkAppEventObserverManager.b(this.jdField_a_of_type_Aaht.a, d2);
      }
    } while (ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a) == null);
    Object localObject = ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a);
    if (this.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ArkAppEventObserverManager.GetCurrentPositionCallback)localObject).a(bool, d1, d2);
      if (ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a) != 0L) {
        ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a).a(ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a));
      }
      ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a, null);
      ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a, 0L);
      if (ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a) != null) {
        break;
      }
      SosoInterface.b(ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a));
      return;
      label760:
      if (ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a) == null) {
        break label367;
      }
      QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", getcurrentPositionCallback=" + ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d + ", mLastLat=" + ArkAppEventObserverManager.b(this.jdField_a_of_type_Aaht.a) + ", mLastLon=" + ArkAppEventObserverManager.a(this.jdField_a_of_type_Aaht.a));
      break label367;
      label927:
      bool = false;
      break label588;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aahu
 * JD-Core Version:    0.7.0.1
 */