package android.support.v4.os;

import android.os.IBinder;

final class c
  implements a
{
  private IBinder jN;
  
  c(IBinder paramIBinder)
  {
    this.jN = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return this.jN;
  }
  
  /* Error */
  public final void send(int paramInt, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: ldc 28
    //   7: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_3
    //   11: iload_1
    //   12: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   15: aload_2
    //   16: ifnull +33 -> 49
    //   19: aload_3
    //   20: iconst_1
    //   21: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   24: aload_2
    //   25: aload_3
    //   26: iconst_0
    //   27: invokevirtual 42	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   30: aload_0
    //   31: getfield 15	android/support/v4/os/c:jN	Landroid/os/IBinder;
    //   34: iconst_1
    //   35: aload_3
    //   36: aconst_null
    //   37: iconst_1
    //   38: invokeinterface 48 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 51	android/os/Parcel:recycle	()V
    //   48: return
    //   49: aload_3
    //   50: iconst_0
    //   51: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   54: goto -24 -> 30
    //   57: astore_2
    //   58: aload_3
    //   59: invokevirtual 51	android/os/Parcel:recycle	()V
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	c
    //   0	64	1	paramInt	int
    //   0	64	2	paramBundle	android.os.Bundle
    //   3	56	3	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   4	15	57	finally
    //   19	30	57	finally
    //   30	44	57	finally
    //   49	54	57	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.os.c
 * JD-Core Version:    0.7.0.1
 */