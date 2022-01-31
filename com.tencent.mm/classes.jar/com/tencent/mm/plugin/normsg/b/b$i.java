package com.tencent.mm.plugin.normsg.b;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Parcel;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.FileDescriptor;
import java.lang.reflect.Method;

final class b$i
  implements IBinder
{
  private final Class<?> phV;
  private b.i.a<String> phW = null;
  private String phX = null;
  
  b$i(Class<?> paramClass)
  {
    Object localObject;
    this.phV = localObject;
  }
  
  public final SparseArray<String> bXL()
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
        AppMethodBeat.i(10415);
        Object localObject1;
        if (this.phW != null)
        {
          localObject1 = this.phW;
          AppMethodBeat.o(10415);
          return localObject1;
        }
        this.phW = new b.i.a(this, (byte)0);
        try
        {
          localObject1 = (IInterface)h.b(this.phV, "asInterface", h.b(new Class[] { IBinder.class }), new Object[] { this });
          Class[] arrayOfClass1 = this.phV.getInterfaces();
          int m = arrayOfClass1.length;
          i = 0;
          if (i < m)
          {
            Object localObject3 = arrayOfClass1[i];
            if (!IInterface.class.isAssignableFrom((Class)localObject3)) {
              break label384;
            }
            localObject3 = ((Class)localObject3).getDeclaredMethods();
            int n = localObject3.length;
            j = 0;
            if (j >= n) {
              break label384;
            }
            localObject4 = localObject3[j];
            if ("asBinder".equals(localObject4.getName())) {
              break label377;
            }
            this.phX = localObject4.getName();
            if (!localObject4.isAccessible()) {
              localObject4.setAccessible(true);
            }
            Class[] arrayOfClass2 = localObject4.getParameterTypes();
            int i1 = arrayOfClass2.length;
            arrayOfObject = new Object[i1];
            k = 0;
            if (k >= i1) {
              break label367;
            }
            localClass = arrayOfClass2[k];
            if (!localClass.isPrimitive()) {
              break label305;
            }
            if (Boolean.TYPE.isAssignableFrom(localClass)) {
              arrayOfObject[k] = Boolean.FALSE;
            } else {
              arrayOfObject[k] = Integer.valueOf(0);
            }
          }
        }
        catch (Throwable localThrowable)
        {
          ab.printErrStackTrace("MicroMsg.AED", localThrowable, "unexpected exception.", new Object[0]);
          b.a(this.phI, localThrowable);
          this.phW.clear();
          b.i.a locala = this.phW;
          AppMethodBeat.o(10415);
        }
        continue;
        if (!Number.class.isAssignableFrom(localClass)) {
          break label326;
        }
      }
      finally {}
      label305:
      arrayOfObject[k] = Integer.valueOf(0);
      break;
      label326:
      if (Character.class.isAssignableFrom(localClass))
      {
        arrayOfObject[k] = Character.valueOf('\000');
        break;
      }
      if (!Boolean.class.isAssignableFrom(localClass)) {
        break label398;
      }
      arrayOfObject[k] = Boolean.FALSE;
      break;
      label367:
      localObject4.invoke(localObject2, arrayOfObject);
      label377:
      j += 1;
      continue;
      label384:
      i += 1;
    }
    for (;;)
    {
      k += 1;
      break;
      label398:
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
    AppMethodBeat.i(10416);
    try
    {
      if (this.phW != null) {
        this.phW.put(paramInt1, this.phX);
      }
      return false;
    }
    finally
    {
      AppMethodBeat.o(10416);
    }
  }
  
  public final boolean unlinkToDeath(IBinder.DeathRecipient paramDeathRecipient, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.i
 * JD-Core Version:    0.7.0.1
 */