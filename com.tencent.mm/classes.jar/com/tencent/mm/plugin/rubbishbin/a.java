package com.tencent.mm.plugin.rubbishbin;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface a
  extends IInterface
{
  public abstract void M(int paramInt1, int paramInt2, String paramString);
  
  public static abstract class a
    extends Binder
    implements a
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.rubbishbin.IRubbishBinInterface");
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.plugin.rubbishbin.IRubbishBinInterface");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.rubbishbin.IRubbishBinInterface");
      M(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.a
 * JD-Core Version:    0.7.0.1
 */