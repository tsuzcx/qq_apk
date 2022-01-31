import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.ARGlobalConfigService;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.qphone.base.util.QLog;

public final class akxh
{
  private static volatile akxh jdField_a_of_type_Akxh;
  private volatile aleh jdField_a_of_type_Aleh;
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new akxi(this);
  
  private akxh(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static akxh a(Context paramContext)
  {
    if (jdField_a_of_type_Akxh == null) {}
    try
    {
      if (jdField_a_of_type_Akxh == null) {
        jdField_a_of_type_Akxh = new akxh(paramContext.getApplicationContext());
      }
      return jdField_a_of_type_Akxh;
    }
    finally {}
  }
  
  public ARScanStarFaceConfigInfo a()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (this.jdField_a_of_type_Aleh != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_Aleh.a();
      QLog.d("ARGlobalRemoteManager", 2, String.format("getScanStarFaceConfigInfo IService=%s configInfo=%s", new Object[] { this.jdField_a_of_type_Aleh, localObject1 }));
      return localObject1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("ARGlobalRemoteManager", 1, "getScanStarFaceConfigInfo fail!", localRemoteException);
        Object localObject2 = localObject3;
      }
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Aleh == null)
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ARGlobalConfigService.class);
        this.jdField_a_of_type_AndroidContentContext.bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akxh
 * JD-Core Version:    0.7.0.1
 */