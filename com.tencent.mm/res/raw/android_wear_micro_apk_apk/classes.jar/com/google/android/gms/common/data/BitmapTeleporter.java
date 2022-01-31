package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BitmapTeleporter
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new e();
  final int GT;
  final int Hc;
  ParcelFileDescriptor Ib;
  private Bitmap Ic;
  private boolean Id;
  private File Ie;
  
  BitmapTeleporter(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2)
  {
    this.Hc = paramInt1;
    this.Ib = paramParcelFileDescriptor;
    this.GT = paramInt2;
    this.Ic = null;
    this.Id = false;
  }
  
  private static void a(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.w("BitmapTeleporter", "Could not close stream", paramCloseable);
    }
  }
  
  /* Error */
  private java.io.FileOutputStream gK()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 67	com/google/android/gms/common/data/BitmapTeleporter:Ie	Ljava/io/File;
    //   4: ifnonnull +13 -> 17
    //   7: new 69	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 71
    //   13: invokespecial 74	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: ldc 76
    //   19: ldc 78
    //   21: aload_0
    //   22: getfield 67	com/google/android/gms/common/data/BitmapTeleporter:Ie	Ljava/io/File;
    //   25: invokestatic 84	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   28: astore_1
    //   29: new 86	java/io/FileOutputStream
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 89	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   37: astore_2
    //   38: aload_0
    //   39: aload_1
    //   40: ldc 90
    //   42: invokestatic 96	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   45: putfield 36	com/google/android/gms/common/data/BitmapTeleporter:Ib	Landroid/os/ParcelFileDescriptor;
    //   48: aload_1
    //   49: invokevirtual 100	java/io/File:delete	()Z
    //   52: pop
    //   53: aload_2
    //   54: areturn
    //   55: astore_1
    //   56: new 69	java/lang/IllegalStateException
    //   59: dup
    //   60: ldc 102
    //   62: aload_1
    //   63: invokespecial 105	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   66: athrow
    //   67: astore_1
    //   68: new 69	java/lang/IllegalStateException
    //   71: dup
    //   72: ldc 107
    //   74: invokespecial 74	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	BitmapTeleporter
    //   28	21	1	localFile	File
    //   55	8	1	localIOException	IOException
    //   67	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   37	17	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   17	29	55	java/io/IOException
    //   29	48	67	java/io/FileNotFoundException
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Bitmap localBitmap;
    Object localObject;
    byte[] arrayOfByte;
    if (this.Ib == null)
    {
      localBitmap = this.Ic;
      localObject = ByteBuffer.allocate(localBitmap.getRowBytes() * localBitmap.getHeight());
      localBitmap.copyPixelsToBuffer((Buffer)localObject);
      arrayOfByte = ((ByteBuffer)localObject).array();
      localObject = new DataOutputStream(gK());
    }
    try
    {
      ((DataOutputStream)localObject).writeInt(arrayOfByte.length);
      ((DataOutputStream)localObject).writeInt(localBitmap.getWidth());
      ((DataOutputStream)localObject).writeInt(localBitmap.getHeight());
      ((DataOutputStream)localObject).writeUTF(localBitmap.getConfig().toString());
      ((DataOutputStream)localObject).write(arrayOfByte);
      a((Closeable)localObject);
      e.a(this, paramParcel, paramInt | 0x1);
      this.Ib = null;
      return;
    }
    catch (IOException paramParcel)
    {
      throw new IllegalStateException("Could not write into unlinked file", paramParcel);
    }
    finally
    {
      a((Closeable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.data.BitmapTeleporter
 * JD-Core Version:    0.7.0.1
 */