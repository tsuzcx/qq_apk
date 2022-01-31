package com.tencent.mm.plugin.normsg.b;

import android.graphics.Region;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Map;

final class b$a
  extends b.d
{
  private b.i mHE = null;
  private WeakReference<Object> mHF = null;
  
  b$a(b paramb, Object paramObject, IBinder paramIBinder)
  {
    super(paramb, paramIBinder);
    try
    {
      this.mHF = new WeakReference(paramObject);
      this.mHE = new b.i(paramb, h.findClass(b.BG() + "$Stub"));
      return;
    }
    catch (Throwable paramObject)
    {
      b.a(paramb, paramObject);
    }
  }
  
  protected final boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt1 > 16777215)) {
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    if (this.mHE == null)
    {
      y.e("MicroMsg.AED", "init failed, give up intercepting.");
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    if (this.mHF.get() == null)
    {
      y.e("MicroMsg.AED", "lost viewRootImpl instance, give up intercepting.");
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    Object localObject = (String)this.mHE.bpi().get(paramInt1);
    int i;
    IBinder localIBinder;
    for (;;)
    {
      try
      {
        paramParcel1.enforceInterface(b.BG());
        if (!b.JE().equals(localObject)) {
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
        y.printErrStackTrace("MicroMsg.AED", localThrowable, "unexpected exception.", new Object[0]);
        b.a(this.mHC, localThrowable);
        continue;
        if ((i < 21) || (paramParcel1.readInt() == 0)) {
          continue;
        }
        Region.CREATOR.createFromParcel(paramParcel1);
        continue;
        if (!b.Je().equals(localThrowable)) {
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
        b.c(this.mHC).put(localIBinder, Integer.valueOf(i));
        continue;
        paramParcel1.readLong();
        continue;
        if (!b.bpa().equals(localIBinder)) {
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
        b.c(this.mHC).put(localIBinder, Integer.valueOf(i));
        continue;
        if (!b.access$1500().equals(localIBinder)) {
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
        b.c(this.mHC).put(localIBinder, Integer.valueOf(i));
        continue;
        if ((i < 21) || (paramParcel1.readInt() == 0)) {
          continue;
        }
        Region.CREATOR.createFromParcel(paramParcel1);
        continue;
        if (!b.bpb().equals(localIBinder)) {
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
        b.c(this.mHC).put(localIBinder, Integer.valueOf(i));
        continue;
        if ((i < 21) || (paramParcel1.readInt() == 0)) {
          continue;
        }
        Region.CREATOR.createFromParcel(paramParcel1);
        continue;
        if (!b.bpc().equals(localIBinder)) {
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
        b.c(this.mHC).put(localIBinder, Integer.valueOf(i));
        continue;
        if ((i < 21) || (paramParcel1.readInt() == 0)) {
          continue;
        }
        Region.CREATOR.createFromParcel(paramParcel1);
        continue;
        if (!b.bpd().equals(localIBinder)) {
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
      b.c(this.mHC).put(localObject, Integer.valueOf(i));
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
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
      b.c(this.mHC).put(localIBinder, Integer.valueOf(i));
      break;
      paramParcel1.readLong();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.a
 * JD-Core Version:    0.7.0.1
 */