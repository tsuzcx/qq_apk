package mqq.app.remote;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.remote.RemoteProxyUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import mqq.app.api.IRuntimeService;

public class ServiceRemoteHandler
  implements InvocationHandler
{
  private static final String TAG = "ServiceRemoteHandler";
  private final Class<? extends IRuntimeService> clazz;
  
  public ServiceRemoteHandler(Class<? extends IRuntimeService> paramClass)
  {
    this.clazz = paramClass;
  }
  
  private Object checkResult(@NonNull String paramString, EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult != null)
    {
      if ((paramEIPCResult.code == 0) && (paramEIPCResult.data != null))
      {
        localObject = paramEIPCResult.data.getString("resultType");
        if (localObject != null) {
          return RemoteProxyUtil.getBundleParameter(paramEIPCResult.data, (String)localObject, "result");
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Call ");
        ((StringBuilder)localObject).append(this.clazz.getName());
        ((StringBuilder)localObject).append("$");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" fail, resultType is null");
        paramString = ((StringBuilder)localObject).toString();
        QLog.e("ServiceRemoteHandler", 1, paramString);
        throw new IllegalStateException(paramString, paramEIPCResult.e);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Call ");
      ((StringBuilder)localObject).append(this.clazz.getName());
      ((StringBuilder)localObject).append("$");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" fail, code=");
      ((StringBuilder)localObject).append(paramEIPCResult.code);
      ((StringBuilder)localObject).append(" data=");
      boolean bool;
      if (paramEIPCResult.data == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      paramString = ((StringBuilder)localObject).toString();
      QLog.e("ServiceRemoteHandler", 1, paramString, paramEIPCResult.e);
      throw new IllegalStateException(paramString, paramEIPCResult.e);
    }
    paramEIPCResult = new StringBuilder();
    paramEIPCResult.append("callAPISync before init, ");
    paramEIPCResult.append(this.clazz.getName());
    paramEIPCResult.append("$");
    paramEIPCResult.append(paramString);
    paramEIPCResult.append(" fail, result is null");
    paramString = paramEIPCResult.toString();
    QLog.e("ServiceRemoteHandler", 1, paramString);
    throw new IllegalStateException(paramString);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = new Bundle();
    paramObject.setClassLoader(getClass().getClassLoader());
    RemoteProxyUtil.checkMethodAndParameter(paramMethod, true, paramArrayOfObject);
    RemoteProxyUtil.setMethodAndParameter(paramMethod, paramArrayOfObject, paramObject);
    long l = System.currentTimeMillis();
    paramArrayOfObject = new StringBuilder();
    paramArrayOfObject.append("callService$");
    paramArrayOfObject.append(this.clazz.getName());
    paramArrayOfObject.append("$");
    paramArrayOfObject.append(paramMethod.getName());
    paramArrayOfObject = paramArrayOfObject.toString();
    paramObject = QIPCClientHelper.getInstance().callServer("QRouteIPCModule", paramArrayOfObject, paramObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("action=");
      localStringBuilder.append(paramArrayOfObject);
      localStringBuilder.append(" cost=");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.d("ServiceRemoteHandler", 2, localStringBuilder.toString());
    }
    return checkResult(paramMethod.getName(), paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.remote.ServiceRemoteHandler
 * JD-Core Version:    0.7.0.1
 */