import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.AddressCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.ArkGetLocationCallback;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkMessageServerLogic;

public final class aaph
  implements ArkAppLocationManager.AddressCallback
{
  public aaph(ArkAppLocationManager.ArkGetLocationCallback paramArkGetLocationCallback) {}
  
  public void a(boolean paramBoolean, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    double d2;
    double d1;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      if (!TextUtils.isEmpty(paramSosoLbsInfo.a.e)) {
        ArkMessageServerLogic.jdField_a_of_type_JavaLangString = paramSosoLbsInfo.a.e;
      }
      if ((Math.abs(paramSosoLbsInfo.a.c) <= 1.0E-006D) || (Math.abs(paramSosoLbsInfo.a.d) <= 1.0E-006D)) {
        break label193;
      }
      d2 = paramSosoLbsInfo.a.c;
      d1 = paramSosoLbsInfo.a.d;
    }
    for (;;)
    {
      if ((Math.abs(d2) > 1.0E-006D) && (Math.abs(d1) > 1.0E-006D))
      {
        ArkMessageServerLogic.jdField_a_of_type_Double = d2;
        ArkMessageServerLogic.b = d1;
      }
      if (!TextUtils.isEmpty(ArkMessageServerLogic.jdField_a_of_type_JavaLangString))
      {
        ArkMessageServerLogic.b();
        if (this.a != null) {
          this.a.a(ArkMessageServerLogic.jdField_a_of_type_JavaLangString, ArkMessageServerLogic.jdField_a_of_type_Double, ArkMessageServerLogic.b);
        }
        ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("getCurrentAddress, city=%s, lat=%f, lon=%f", new Object[] { ArkMessageServerLogic.jdField_a_of_type_JavaLangString, Double.valueOf(ArkMessageServerLogic.jdField_a_of_type_Double), Double.valueOf(ArkMessageServerLogic.b) }));
        return;
        label193:
        if ((Math.abs(paramSosoLbsInfo.a.jdField_a_of_type_Double) > 1.0E-006D) && (Math.abs(paramSosoLbsInfo.a.b) > 1.0E-006D))
        {
          paramSosoLbsInfo = ArkAppEventObserverManager.a(paramSosoLbsInfo.a.b, paramSosoLbsInfo.a.jdField_a_of_type_Double);
          d1 = paramSosoLbsInfo[0];
          d2 = paramSosoLbsInfo[1];
        }
      }
      else
      {
        if (this.a != null) {
          this.a.a("", 0.0D, 0.0D);
        }
        ArkAppCenter.b("ArkApp.ArkMessageServerLogic", String.format("getCurrentAddress,location get failed", new Object[0]));
        return;
      }
      d1 = 0.0D;
      d2 = 0.0D;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaph
 * JD-Core Version:    0.7.0.1
 */