package com.tencent.tinker.loader.hotplug.b;

import android.os.IBinder;
import android.os.IInterface;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class i
  implements InvocationHandler
{
  private final h api;
  private final IBinder apn;
  
  i(IBinder paramIBinder, h paramh)
  {
    this.apn = paramIBinder;
    this.api = paramh;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if ("queryLocalInterface".equals(paramMethod.getName()))
    {
      paramMethod = this.apn.getInterfaceDescriptor();
      if (paramMethod.equals("android.app.IActivityManager")) {}
      for (paramMethod = "android.app.ActivityManagerNative";; paramMethod = paramMethod + "$Stub")
      {
        paramMethod = (IInterface)com.tencent.tinker.loader.a.h.a(Class.forName(paramMethod), "asInterface", new Class[] { IBinder.class }).invoke(null, new Object[] { this.apn });
        paramObject = new j(paramMethod, (IBinder)paramObject, this.api);
        return g.b(g.j(paramMethod.getClass()), paramObject);
      }
    }
    return paramMethod.invoke(this.apn, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.b.i
 * JD-Core Version:    0.7.0.1
 */