package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public final class c
{
  public static void a(Parcel paramParcel, double paramDouble)
  {
    b(paramParcel, 5, 8);
    paramParcel.writeDouble(paramDouble);
  }
  
  public static void a(Parcel paramParcel, float paramFloat)
  {
    b(paramParcel, 15, 4);
    paramParcel.writeFloat(paramFloat);
  }
  
  public static void a(Parcel paramParcel, int paramInt, byte paramByte)
  {
    b(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramByte);
  }
  
  public static void a(Parcel paramParcel, int paramInt, long paramLong)
  {
    b(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
  }
  
  public static void a(Parcel paramParcel, int paramInt, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramInt = t(paramParcel, paramInt);
    paramParcel.writeBundle(paramBundle);
    u(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt, IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return;
    }
    paramInt = t(paramParcel, paramInt);
    paramParcel.writeStrongBinder(paramIBinder);
    u(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel, int paramInt1, Parcelable paramParcelable, int paramInt2)
  {
    if (paramParcelable == null) {
      return;
    }
    paramInt1 = t(paramParcel, paramInt1);
    paramParcelable.writeToParcel(paramParcel, paramInt2);
    u(paramParcel, paramInt1);
  }
  
  public static void a(Parcel paramParcel, int paramInt, Integer paramInteger)
  {
    if (paramInteger == null) {
      return;
    }
    b(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramInteger.intValue());
  }
  
  public static void a(Parcel paramParcel, int paramInt, String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramInt = t(paramParcel, paramInt);
    paramParcel.writeString(paramString);
    u(paramParcel, paramInt);
  }
  
  public static <T extends Parcelable> void a(Parcel paramParcel, int paramInt, List<T> paramList)
  {
    if (paramList == null) {
      return;
    }
    int i = t(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    paramInt = 0;
    if (paramInt < j)
    {
      Parcelable localParcelable = (Parcelable)paramList.get(paramInt);
      if (localParcelable == null) {
        paramParcel.writeInt(0);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        a(paramParcel, localParcelable, 0);
      }
    }
    u(paramParcel, i);
  }
  
  public static void a(Parcel paramParcel, int paramInt, boolean paramBoolean)
  {
    b(paramParcel, paramInt, 4);
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
  
  public static void a(Parcel paramParcel, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    paramInt = t(paramParcel, paramInt);
    paramParcel.writeByteArray(paramArrayOfByte);
    u(paramParcel, paramInt);
  }
  
  public static <T extends Parcelable> void a(Parcel paramParcel, int paramInt1, T[] paramArrayOfT, int paramInt2)
  {
    if (paramArrayOfT == null) {
      return;
    }
    int i = t(paramParcel, paramInt1);
    int j = paramArrayOfT.length;
    paramParcel.writeInt(j);
    paramInt1 = 0;
    if (paramInt1 < j)
    {
      T ? = paramArrayOfT[paramInt1];
      if (? == null) {
        paramParcel.writeInt(0);
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        a(paramParcel, ?, paramInt2);
      }
    }
    u(paramParcel, i);
  }
  
  public static void a(Parcel paramParcel, int paramInt, String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return;
    }
    paramInt = t(paramParcel, paramInt);
    paramParcel.writeStringArray(paramArrayOfString);
    u(paramParcel, paramInt);
  }
  
  public static void a(Parcel paramParcel1, Parcel paramParcel2)
  {
    if (paramParcel2 == null) {
      return;
    }
    int i = t(paramParcel1, 2);
    paramParcel1.appendFrom(paramParcel2, 0, paramParcel2.dataSize());
    u(paramParcel1, i);
  }
  
  private static <T extends Parcelable> void a(Parcel paramParcel, T paramT, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.writeInt(1);
    int j = paramParcel.dataPosition();
    paramT.writeToParcel(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    paramParcel.setDataPosition(i);
    paramParcel.writeInt(paramInt - j);
    paramParcel.setDataPosition(paramInt);
  }
  
  public static void a(Parcel paramParcel, List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    int i = t(paramParcel, 6);
    paramParcel.writeStringList(paramList);
    u(paramParcel, i);
  }
  
  public static int b(Parcel paramParcel)
  {
    return t(paramParcel, 20293);
  }
  
  private static void b(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 65535)
    {
      paramParcel.writeInt(0xFFFF0000 | paramInt1);
      paramParcel.writeInt(paramInt2);
      return;
    }
    paramParcel.writeInt(paramInt2 << 16 | paramInt1);
  }
  
  public static void c(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    b(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
  }
  
  private static int t(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(0xFFFF0000 | paramInt);
    paramParcel.writeInt(0);
    return paramParcel.dataPosition();
  }
  
  private static void u(Parcel paramParcel, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(i - paramInt);
    paramParcel.setDataPosition(i);
  }
  
  public static void v(Parcel paramParcel, int paramInt)
  {
    u(paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.safeparcel.c
 * JD-Core Version:    0.7.0.1
 */