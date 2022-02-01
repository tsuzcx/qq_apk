package com.tencent.tinker.loader;

import android.os.IBinder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class TinkerDexOptimizer$2
  implements InvocationHandler
{
  TinkerDexOptimizer$2(IBinder paramIBinder) {}
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if ("transact".equals(paramMethod.getName())) {
      paramArrayOfObject[3] = Integer.valueOf(0);
    }
    return paramMethod.invoke(this.val$pmsBinderProxy, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerDexOptimizer.2
 * JD-Core Version:    0.7.0.1
 */