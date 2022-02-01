package com.tencent.tinker.loader.hotplug.b;

import android.os.IBinder;
import android.os.IInterface;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class j
  implements InvocationHandler
{
  private final h api;
  private final IBinder apn;
  private final IInterface apo;
  
  j(IInterface paramIInterface, IBinder paramIBinder, h paramh)
  {
    this.apo = paramIInterface;
    this.apn = paramIBinder;
    this.api = paramh;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if ("asBinder".equals(paramMethod.getName())) {
      return this.apn;
    }
    return this.api.invoke(this.apo, paramMethod, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.b.j
 * JD-Core Version:    0.7.0.1
 */