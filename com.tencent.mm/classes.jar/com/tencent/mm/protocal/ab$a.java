package com.tencent.mm.protocal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class ab$a
  extends Binder
  implements ab
{
  public ab$a()
  {
    attachInterface(this, "com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
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
      paramParcel2.writeString("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
      paramParcel1 = aiW();
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
      paramParcel1 = aiX();
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
    paramInt1 = O(paramParcel1.createByteArray());
    paramParcel2.writeNoException();
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.ab.a
 * JD-Core Version:    0.7.0.1
 */