import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class abfr
  implements QQPermissionCallback
{
  abfr(abfp paramabfp) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("PubAccountMailJsPlugin", 1, "CheckPermission user denied = ");
    bhlq.a(this.a.mRuntime.a(), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.d("PubAccountMailJsPlugin", 1, "CheckPermission user grant = ");
    abfp.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abfr
 * JD-Core Version:    0.7.0.1
 */