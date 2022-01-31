package com.tencent.mm.plugin.normsg.b;

import android.graphics.Region;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.Map;

final class b$a
  extends b.d
{
  private b.i phK;
  private WeakReference<Object> phL;
  
  b$a(b paramb, Object paramObject, IBinder paramIBinder)
  {
    super(paramb, paramIBinder);
    AppMethodBeat.i(10392);
    this.phK = null;
    this.phL = null;
    try
    {
      this.phL = new WeakReference(paramObject);
      this.phK = new b.i(paramb, h.findClass(b.access$200() + "$Stub"));
      AppMethodBeat.o(10392);
      return;
    }
    catch (Throwable paramObject)
    {
      b.a(paramb, paramObject);
      AppMethodBeat.o(10392);
    }
  }
  
  protected final boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    AppMethodBeat.i(10393);
    boolean bool;
    if ((paramInt1 <= 0) || (paramInt1 > 16777215))
    {
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      AppMethodBeat.o(10393);
      return bool;
    }
    if (this.phK == null)
    {
      ab.e("MicroMsg.AED", "init failed, give up intercepting.");
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      AppMethodBeat.o(10393);
      return bool;
    }
    if (this.phL.get() == null)
    {
      ab.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      AppMethodBeat.o(10393);
      return bool;
    }
    Object localObject = (String)this.phK.bXL().get(paramInt1);
    int i;
    IBinder localIBinder;
    for (;;)
    {
      try
      {
        paramParcel1.enforceInterface(b.access$200());
        if (!b.bXC().equals(localObject)) {
          continue;
        }
        i = Build.VERSION.SDK_INT;
        if (i >= 16) {
          continue;
        }
        paramParcel1.readInt();
        if ((i < 16) || (i >= 17)) {
          continue;
        }
        paramParcel1.readInt();
        paramParcel1.readInt();
      }
      catch (Throwable localThrowable)
      {
        ab.printErrStackTrace("MicroMsg.AED", localThrowable, "unexpected exception.", new Object[0]);
        b.a(this.phI, localThrowable);
        continue;
        if ((i < 21) || (paramParcel1.readInt() == 0)) {
          continue;
        }
        Region.CREATOR.createFromParcel(paramParcel1);
        continue;
        if (!b.acE().equals(localThrowable)) {
          continue;
        }
        i = Build.VERSION.SDK_INT;
        if (i >= 16) {
          continue;
        }
        paramParcel1.readInt();
        if (i < 16) {
          continue;
        }
        paramParcel1.readInt();
        if (i >= 17) {
          continue;
        }
        paramParcel1.readInt();
        paramParcel1.readInt();
        paramParcel1.readInt();
        localIBinder = paramParcel1.readStrongBinder();
        if (i < 16) {
          continue;
        }
        paramParcel1.readInt();
        i = paramParcel1.readInt();
        b.c(this.phI).put(localIBinder, Integer.valueOf(i));
        continue;
        paramParcel1.readLong();
        continue;
        if (!b.acb().equals(localIBinder)) {
          continue;
        }
        i = Build.VERSION.SDK_INT;
        paramParcel1.readLong();
        paramParcel1.readString();
        if ((i < 21) || (paramParcel1.readInt() == 0)) {
          continue;
        }
        Region.CREATOR.createFromParcel(paramParcel1);
        paramParcel1.readInt();
        localIBinder = paramParcel1.readStrongBinder();
        paramParcel1.readInt();
        i = paramParcel1.readInt();
        b.c(this.phI).put(localIBinder, Integer.valueOf(i));
        continue;
        if (!b.bXD().equals(localIBinder)) {
          continue;
        }
        i = Build.VERSION.SDK_INT;
        paramParcel1.readLong();
        paramParcel1.readString();
        if ((i < 16) || (i >= 17)) {
          continue;
        }
        paramParcel1.readInt();
        paramParcel1.readInt();
        paramParcel1.readInt();
        localIBinder = paramParcel1.readStrongBinder();
        paramParcel1.readInt();
        i = paramParcel1.readInt();
        b.c(this.phI).put(localIBinder, Integer.valueOf(i));
        continue;
        if ((i < 21) || (paramParcel1.readInt() == 0)) {
          continue;
        }
        Region.CREATOR.createFromParcel(paramParcel1);
        continue;
        if (!b.bXE().equals(localIBinder)) {
          continue;
        }
        i = Build.VERSION.SDK_INT;
        paramParcel1.readLong();
        paramParcel1.readInt();
        if ((i < 16) || (i >= 17)) {
          continue;
        }
        paramParcel1.readInt();
        paramParcel1.readInt();
        paramParcel1.readInt();
        localIBinder = paramParcel1.readStrongBinder();
        paramParcel1.readInt();
        i = paramParcel1.readInt();
        b.c(this.phI).put(localIBinder, Integer.valueOf(i));
        continue;
        if ((i < 21) || (paramParcel1.readInt() == 0)) {
          continue;
        }
        Region.CREATOR.createFromParcel(paramParcel1);
        continue;
        if (!b.bXF().equals(localIBinder)) {
          continue;
        }
        i = Build.VERSION.SDK_INT;
        paramParcel1.readLong();
        paramParcel1.readInt();
        if ((i < 16) || (i >= 17)) {
          continue;
        }
        paramParcel1.readInt();
        paramParcel1.readInt();
        paramParcel1.readInt();
        localIBinder = paramParcel1.readStrongBinder();
        paramParcel1.readInt();
        i = paramParcel1.readInt();
        b.c(this.phI).put(localIBinder, Integer.valueOf(i));
        continue;
        if ((i < 21) || (paramParcel1.readInt() == 0)) {
          continue;
        }
        Region.CREATOR.createFromParcel(paramParcel1);
        continue;
        if (!b.bXG().equals(localIBinder)) {
          continue;
        }
        i = Build.VERSION.SDK_INT;
        if (i >= 16) {
          break;
        }
      }
      paramParcel1.readInt();
      localObject = paramParcel1.readStrongBinder();
      if (i >= 16) {
        paramParcel1.readInt();
      }
      i = paramParcel1.readInt();
      b.c(this.phI).put(localObject, Integer.valueOf(i));
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      AppMethodBeat.o(10393);
      return bool;
      paramParcel1.readLong();
      continue;
      paramParcel1.readInt();
    }
    for (;;)
    {
      paramParcel1.readInt();
      if ((i >= 16) && (paramParcel1.readInt() != 0)) {
        Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1.readInt();
      localIBinder = paramParcel1.readStrongBinder();
      if (i >= 16) {
        paramParcel1.readInt();
      }
      i = paramParcel1.readInt();
      b.c(this.phI).put(localIBinder, Integer.valueOf(i));
      break;
      paramParcel1.readLong();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.a
 * JD-Core Version:    0.7.0.1
 */