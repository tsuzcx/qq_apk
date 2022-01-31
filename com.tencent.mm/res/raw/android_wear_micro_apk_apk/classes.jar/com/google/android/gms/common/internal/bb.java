package com.google.android.gms.common.internal;

import android.os.IBinder;

final class bb
  implements az
{
  private IBinder KE;
  
  bb(IBinder paramIBinder)
  {
    this.KE = paramIBinder;
  }
  
  /* Error */
  public final com.google.android.gms.a.a a(com.google.android.gms.a.a parama, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 26
    //   14: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +70 -> 88
    //   21: aload_1
    //   22: invokeinterface 36 1 0
    //   27: astore_1
    //   28: aload 4
    //   30: aload_1
    //   31: invokevirtual 39	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload 4
    //   36: iload_2
    //   37: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   40: aload 4
    //   42: iload_3
    //   43: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   46: aload_0
    //   47: getfield 15	com/google/android/gms/common/internal/bb:KE	Landroid/os/IBinder;
    //   50: iconst_1
    //   51: aload 4
    //   53: aload 5
    //   55: iconst_0
    //   56: invokeinterface 49 5 0
    //   61: pop
    //   62: aload 5
    //   64: invokevirtual 52	android/os/Parcel:readException	()V
    //   67: aload 5
    //   69: invokevirtual 55	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   72: invokestatic 61	com/google/android/gms/a/b:j	(Landroid/os/IBinder;)Lcom/google/android/gms/a/a;
    //   75: astore_1
    //   76: aload 5
    //   78: invokevirtual 64	android/os/Parcel:recycle	()V
    //   81: aload 4
    //   83: invokevirtual 64	android/os/Parcel:recycle	()V
    //   86: aload_1
    //   87: areturn
    //   88: aconst_null
    //   89: astore_1
    //   90: goto -62 -> 28
    //   93: astore_1
    //   94: aload 5
    //   96: invokevirtual 64	android/os/Parcel:recycle	()V
    //   99: aload 4
    //   101: invokevirtual 64	android/os/Parcel:recycle	()V
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	bb
    //   0	106	1	parama	com.google.android.gms.a.a
    //   0	106	2	paramInt1	int
    //   0	106	3	paramInt2	int
    //   3	97	4	localParcel1	android.os.Parcel
    //   8	87	5	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	93	finally
    //   21	28	93	finally
    //   28	76	93	finally
  }
  
  /* Error */
  public final com.google.android.gms.a.a a(com.google.android.gms.a.a parama, zzah paramzzah)
  {
    // Byte code:
    //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 26
    //   12: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +70 -> 86
    //   19: aload_1
    //   20: invokeinterface 36 1 0
    //   25: astore_1
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual 39	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_2
    //   32: ifnull +59 -> 91
    //   35: aload_3
    //   36: iconst_1
    //   37: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: invokevirtual 71	com/google/android/gms/common/internal/zzah:writeToParcel	(Landroid/os/Parcel;I)V
    //   46: aload_0
    //   47: getfield 15	com/google/android/gms/common/internal/bb:KE	Landroid/os/IBinder;
    //   50: iconst_2
    //   51: aload_3
    //   52: aload 4
    //   54: iconst_0
    //   55: invokeinterface 49 5 0
    //   60: pop
    //   61: aload 4
    //   63: invokevirtual 52	android/os/Parcel:readException	()V
    //   66: aload 4
    //   68: invokevirtual 55	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   71: invokestatic 61	com/google/android/gms/a/b:j	(Landroid/os/IBinder;)Lcom/google/android/gms/a/a;
    //   74: astore_1
    //   75: aload 4
    //   77: invokevirtual 64	android/os/Parcel:recycle	()V
    //   80: aload_3
    //   81: invokevirtual 64	android/os/Parcel:recycle	()V
    //   84: aload_1
    //   85: areturn
    //   86: aconst_null
    //   87: astore_1
    //   88: goto -62 -> 26
    //   91: aload_3
    //   92: iconst_0
    //   93: invokevirtual 43	android/os/Parcel:writeInt	(I)V
    //   96: goto -50 -> 46
    //   99: astore_1
    //   100: aload 4
    //   102: invokevirtual 64	android/os/Parcel:recycle	()V
    //   105: aload_3
    //   106: invokevirtual 64	android/os/Parcel:recycle	()V
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	bb
    //   0	111	1	parama	com.google.android.gms.a.a
    //   0	111	2	paramzzah	zzah
    //   3	103	3	localParcel1	android.os.Parcel
    //   7	94	4	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   9	15	99	finally
    //   19	26	99	finally
    //   26	31	99	finally
    //   35	46	99	finally
    //   46	75	99	finally
    //   91	96	99	finally
  }
  
  public final IBinder asBinder()
  {
    return this.KE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.bb
 * JD-Core Version:    0.7.0.1
 */