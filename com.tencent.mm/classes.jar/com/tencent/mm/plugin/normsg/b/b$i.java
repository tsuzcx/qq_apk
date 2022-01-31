package com.tencent.mm.plugin.normsg.b;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Parcel;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.y;
import java.io.FileDescriptor;
import java.lang.reflect.Method;

final class b$i
  implements IBinder
{
  private final Class<?> mHP;
  private b.i.a<String> mHQ = null;
  private String mHR = null;
  
  b$i(Class<?> paramClass)
  {
    Object localObject;
    this.mHP = localObject;
  }
  
  public final SparseArray<String> bpi()
  {
    Object[] arrayOfObject;
    int k;
    for (;;)
    {
      int i;
      int j;
      Object localObject4;
      Class localClass;
      try
      {
        Object localObject1;
        if (this.mHQ != null)
        {
          localObject1 = this.mHQ;
          return localObject1;
        }
        this.mHQ = new b.i.a(this, (byte)0);
        try
        {
          localObject1 = (IInterface)h.b(this.mHP, "asInterface", h.b(new Class[] { IBinder.class }), new Object[] { this });
          Class[] arrayOfClass1 = this.mHP.getInterfaces();
          int m = arrayOfClass1.length;
          i = 0;
          if (i < m)
          {
            Object localObject3 = arrayOfClass1[i];
            if (!IInterface.class.isAssignableFrom((Class)localObject3)) {
              break label368;
            }
            localObject3 = ((Class)localObject3).getDeclaredMethods();
            int n = localObject3.length;
            j = 0;
            if (j >= n) {
              break label368;
            }
            localObject4 = localObject3[j];
            if ("asBinder".equals(localObject4.getName())) {
              break label361;
            }
            this.mHR = localObject4.getName();
            if (!localObject4.isAccessible()) {
              localObject4.setAccessible(true);
            }
            Class[] arrayOfClass2 = localObject4.getParameterTypes();
            int i1 = arrayOfClass2.length;
            arrayOfObject = new Object[i1];
            k = 0;
            if (k >= i1) {
              break label351;
            }
            localClass = arrayOfClass2[k];
            if (!localClass.isPrimitive()) {
              continue;
            }
            if (Boolean.TYPE.isAssignableFrom(localClass)) {
              arrayOfObject[k] = Boolean.valueOf(false);
            } else {
              arrayOfObject[k] = Integer.valueOf(0);
            }
          }
        }
        catch (Throwable localThrowable)
        {
          y.printErrStackTrace("MicroMsg.AED", localThrowable, "unexpected exception.", new Object[0]);
          b.a(this.mHC, localThrowable);
          this.mHQ.clear();
          b.i.a locala = this.mHQ;
        }
        continue;
        if (Number.class.isAssignableFrom(localClass)) {
          arrayOfObject[k] = Integer.valueOf(0);
        }
      }
      finally {}
      if (Character.class.isAssignableFrom(localClass))
      {
        arrayOfObject[k] = Character.valueOf('\000');
        break;
      }
      if (!Boolean.class.isAssignableFrom(localClass)) {
        break label382;
      }
      arrayOfObject[k] = Boolean.valueOf(false);
      break;
      label351:
      localObject4.invoke(localObject2, arrayOfObject);
      label361:
      j += 1;
      continue;
      label368:
      i += 1;
    }
    for (;;)
    {
      k += 1;
      break;
      label382:
      arrayOfObject[k] = null;
    }
  }
  
  public final void dump(FileDescriptor paramFileDescriptor, String[] paramArrayOfString) {}
  
  public final void dumpAsync(FileDescriptor paramFileDescriptor, String[] paramArrayOfString) {}
  
  public final String getInterfaceDescriptor()
  {
    return null;
  }
  
  public final boolean isBinderAlive()
  {
    return false;
  }
  
  public final void linkToDeath(IBinder.DeathRecipient paramDeathRecipient, int paramInt) {}
  
  public final boolean pingBinder()
  {
    return false;
  }
  
  public final IInterface queryLocalInterface(String paramString)
  {
    return null;
  }
  
  public final boolean transact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    try
    {
      if (this.mHQ != null) {
        this.mHQ.put(paramInt1, this.mHR);
      }
      return false;
    }
    finally {}
  }
  
  public final boolean unlinkToDeath(IBinder.DeathRecipient paramDeathRecipient, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.i
 * JD-Core Version:    0.7.0.1
 */