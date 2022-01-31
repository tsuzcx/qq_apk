import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class alol
  implements INetInfoHandler
{
  alol(alob paramalob) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ark.download.module", 2, "onNetMobile2None");
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ark.download.module", 2, new Object[] { "onNetMobile2Wifi", paramString });
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ark.download.module", 2, new Object[] { "onNetNone2Mobile", paramString });
    }
    paramString = BaseActivity.sTopActivity;
    if ((alob.a(this.a)) && (!alob.b(this.a)) && (paramString != null))
    {
      paramString = paramString.getString(2131690232);
      if (alob.a(this.a, paramString)) {
        alob.b(this.a, true);
      }
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ark.download.module", 2, new Object[] { "onNetNone2Wifi", paramString });
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ark.download.module", 2, new Object[] { "onNetWifi2Mobile", paramString });
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ark.download.module", 2, "onNetWifi2None");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alol
 * JD-Core Version:    0.7.0.1
 */