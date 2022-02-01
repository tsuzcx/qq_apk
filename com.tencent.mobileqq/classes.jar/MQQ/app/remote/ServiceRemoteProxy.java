package mqq.app.remote;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.remote.RemoteProxyUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

public class ServiceRemoteProxy
{
  private static final HashMap<String, Class<?>> CACHE_CLASS_MAP;
  private static final HashMap<String, Method> CACHE_METHOD_MAP = new HashMap(512);
  private static final ConcurrentHashMap<String, Object> CACHE_PROXY_CLASS_MAP;
  private static final Object LOCK_OBJECT = new Object();
  private static final String TAG = "ServiceRemoteProxy";
  
  static
  {
    CACHE_CLASS_MAP = new HashMap(512);
    CACHE_PROXY_CLASS_MAP = new ConcurrentHashMap(512);
  }
  
  public static EIPCResult callInMainProcess(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("action:");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("  callbackId:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("ServiceRemoteProxy", 1, ((StringBuilder)localObject1).toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("$")))
    {
      localObject1 = paramString.split("\\$");
      if (localObject1.length != 3)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("wrong action, action = ");
        paramBundle.append(paramString);
        return EIPCResult.createExceptionResult(new IllegalStateException(paramBundle.toString()));
      }
      Object localObject3 = localObject1[1];
      Object localObject2 = localObject1[2];
      try
      {
        if (CACHE_CLASS_MAP.containsKey(localObject3))
        {
          localObject1 = (Class)CACHE_CLASS_MAP.get(localObject3);
        }
        else
        {
          localObject1 = Class.forName((String)localObject3);
          CACHE_CLASS_MAP.put(localObject3, localObject1);
        }
        localObject3 = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService((Class)localObject1, "");
        if (localObject3 == null)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("IRuntimeService is null, action = ");
          paramBundle.append(paramString);
          return EIPCResult.createExceptionResult(new IllegalStateException(paramBundle.toString()));
        }
        paramBundle.setClassLoader(((Class)localObject1).getClassLoader());
        ArrayList localArrayList = paramBundle.getStringArrayList("__parameterTypes__");
        paramInt = localArrayList.size();
        Class[] arrayOfClass = new Class[paramInt];
        Object[] arrayOfObject = new Object[paramInt];
        paramInt = 0;
        while (paramInt < localArrayList.size())
        {
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("__arg+");
          ((StringBuilder)localObject4).append(paramInt);
          ((StringBuilder)localObject4).append("__");
          localObject4 = ((StringBuilder)localObject4).toString();
          String str = (String)localArrayList.get(paramInt);
          arrayOfClass[paramInt] = RemoteProxyUtil.getClassFromName(str);
          arrayOfObject[paramInt] = RemoteProxyUtil.getBundleParameter(paramBundle, str, (String)localObject4);
          paramInt += 1;
        }
        if (CACHE_METHOD_MAP.get(paramString) != null)
        {
          paramString = (Method)CACHE_METHOD_MAP.get(paramString);
        }
        else
        {
          localObject1 = ((Class)localObject1).getDeclaredMethod((String)localObject2, arrayOfClass);
          CACHE_METHOD_MAP.put(paramString, localObject1);
          paramString = (String)localObject1;
        }
        localObject1 = paramString.invoke(localObject3, arrayOfObject);
        localObject2 = EIPCResult.createSuccessResult(paramBundle);
        RemoteProxyUtil.setBundleParameter(paramBundle, paramString.getReturnType().getName(), "result", localObject1);
        paramBundle.putString("resultType", paramString.getReturnType().getName());
        return localObject2;
      }
      catch (Exception paramString)
      {
        CACHE_METHOD_MAP.clear();
        paramString.printStackTrace();
        QLog.d("ServiceRemoteProxy", 1, "onCall exception", paramString);
        return EIPCResult.createExceptionResult(paramString);
      }
    }
    return EIPCResult.createExceptionResult(new IllegalStateException("wrong acton"));
  }
  
  public static void clear()
  {
    CACHE_CLASS_MAP.clear();
    CACHE_PROXY_CLASS_MAP.clear();
  }
  
  public static Object getProxy(Class<? extends IRuntimeService> paramClass1, Class<? extends IRuntimeService> paramClass2)
  {
    String str = paramClass1.getName();
    if (CACHE_PROXY_CLASS_MAP.containsKey(str)) {
      return CACHE_PROXY_CLASS_MAP.get(str);
    }
    synchronized (LOCK_OBJECT)
    {
      if (!CACHE_PROXY_CLASS_MAP.containsKey(str))
      {
        paramClass1 = Proxy.newProxyInstance(paramClass2.getClassLoader(), paramClass2.getInterfaces(), new ServiceRemoteHandler(paramClass1));
        CACHE_PROXY_CLASS_MAP.put(str, paramClass1);
        return paramClass1;
      }
      return CACHE_PROXY_CLASS_MAP.get(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.remote.ServiceRemoteProxy
 * JD-Core Version:    0.7.0.1
 */