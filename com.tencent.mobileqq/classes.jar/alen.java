import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback;
import com.tencent.qphone.base.util.QLog;

final class alen
  implements ArkAppMgr.IGetAppPathByNameCallback
{
  public void onGetAppPathByName(int paramInt, String paramString, ArkAppMgr.AppPathInfo paramAppPathInfo, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAppCenterUtil", 2, new Object[] { "preDownloadArkApp download complete,retCode: ", Integer.valueOf(paramInt), ";msg: ", paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alen
 * JD-Core Version:    0.7.0.1
 */