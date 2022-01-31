package com.tencent.soter.soterserver;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface a
  extends IInterface
{
  public abstract SoterSessionResult E(int paramInt, String paramString1, String paramString2);
  
  public abstract int Jn(int paramInt);
  
  public abstract SoterExportResult Jo(int paramInt);
  
  public abstract boolean Jp(int paramInt);
  
  public abstract int Jq(int paramInt);
  
  public abstract int bl(int paramInt, String paramString);
  
  public abstract int bm(int paramInt, String paramString);
  
  public abstract SoterExportResult bn(int paramInt, String paramString);
  
  public abstract boolean bo(int paramInt, String paramString);
  
  public abstract SoterDeviceResult cPv();
  
  public abstract int getVersion();
  
  public abstract SoterSignResult io(long paramLong);
  
  public static abstract class a
    extends Binder
    implements a
  {
    public static a N(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.soter.soterserver.ISoterService");
      if ((localIInterface != null) && ((localIInterface instanceof a))) {
        return (a)localIInterface;
      }
      return new a.a.a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      int j = 0;
      int i = 0;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.soter.soterserver.ISoterService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramInt1 = Jn(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramParcel1 = Jo(paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        bool = Jp(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramInt1 = bl(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramInt1 = bm(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramParcel1 = bn(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramInt1 = Jq(paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        bool = bo(paramParcel1.readInt(), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramParcel1 = E(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 10: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramParcel1 = io(paramParcel1.readLong());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
        paramParcel1 = cPv();
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.soter.soterserver.ISoterService");
      paramInt1 = getVersion();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.soterserver.a
 * JD-Core Version:    0.7.0.1
 */