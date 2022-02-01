package com.google.android.gms.a;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.n;

public abstract class e<T>
{
  private final String Nr;
  private T Ns;
  
  protected e(String paramString)
  {
    this.Nr = paramString;
  }
  
  protected abstract T d(IBinder paramIBinder);
  
  protected final T r(Context paramContext)
  {
    if (this.Ns == null)
    {
      d.D(paramContext);
      paramContext = n.p(paramContext);
      if (paramContext == null) {
        throw new f("Could not get remote context.");
      }
      paramContext = paramContext.getClassLoader();
    }
    try
    {
      this.Ns = d((IBinder)paramContext.loadClass(this.Nr).newInstance());
      return this.Ns;
    }
    catch (ClassNotFoundException paramContext)
    {
      throw new f("Could not load creator class.", paramContext);
    }
    catch (InstantiationException paramContext)
    {
      throw new f("Could not instantiate creator.", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new f("Could not access creator.", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.a.e
 * JD-Core Version:    0.7.0.1
 */