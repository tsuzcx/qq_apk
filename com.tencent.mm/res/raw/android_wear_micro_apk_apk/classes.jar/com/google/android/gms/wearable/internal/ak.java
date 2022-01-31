package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class ak
  extends Binder
  implements aj
{
  public ak()
  {
    attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
  }
  
  public static aj o(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof aj))) {
      return (aj)localIInterface;
    }
    return new al(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject9 = null;
    Object localObject10 = null;
    Object localObject11 = null;
    Object localObject12 = null;
    Object localObject13 = null;
    Object localObject14 = null;
    Object localObject15 = null;
    Object localObject16 = null;
    Object localObject17 = null;
    Object localObject18 = null;
    Object localObject19 = null;
    Object localObject20 = null;
    Object localObject21 = null;
    Object localObject22 = null;
    Object localObject23 = null;
    Object localObject24 = null;
    Object localObject25 = null;
    Object localObject26 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.wearable.internal.IWearableCallbacks");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzbh)zzbh.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzbh)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzbj)zzbj.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzbj)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 28: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzbc)zzbc.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzbc)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 29: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzbg)zzbg.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzbg)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 30: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject5;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzbe)zzbe.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzbe)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject6;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzci)zzci.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzci)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject7;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzbn)zzbn.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzbn)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject8;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (DataHolder)DataHolder.CREATOR.createFromParcel(paramParcel1);
      }
      b((DataHolder)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject9;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzar)zzar.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzar)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject10;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzco)zzco.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzco)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject11;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzbp)zzbp.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzbp)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject12;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzbr)zzbr.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzbr)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject13;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzbl)zzbl.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzbl)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject14;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzce)zzce.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzce)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject15;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzae)zzae.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzae)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject16;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzae)zzae.CREATOR.createFromParcel(paramParcel1);
      }
      b((zzae)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject17;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzax)zzax.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzax)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject18;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzaz)zzaz.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzaz)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject19;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzy)zzy.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzy)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 20: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject20;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzaa)zzaa.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzaa)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject21;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
      }
      j((Status)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject22;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzcs)zzcs.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzcs)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject23;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzav)zzav.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzav)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 23: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject24;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zzat)zzat.CREATOR.createFromParcel(paramParcel1);
      }
      a((zzat)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 26: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
      localObject1 = localObject25;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (zze)zze.CREATOR.createFromParcel(paramParcel1);
      }
      a((zze)localObject1);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
    localObject1 = localObject26;
    if (paramParcel1.readInt() != 0) {
      localObject1 = (zzcm)zzcm.CREATOR.createFromParcel(paramParcel1);
    }
    a((zzcm)localObject1);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ak
 * JD-Core Version:    0.7.0.1
 */