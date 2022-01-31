package com.tencent.ttpic.device;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandomSpi;

public class EncryptUtils$LinuxPRNGSecureRandom
  extends SecureRandomSpi
{
  private static final File URANDOM_FILE = new File("/dev/urandom");
  private static final Object sLock = new Object();
  private static DataInputStream sUrandomIn;
  private static OutputStream sUrandomOut;
  private boolean mSeeded;
  
  private DataInputStream getUrandomInputStream()
  {
    synchronized (sLock)
    {
      DataInputStream localDataInputStream = sUrandomIn;
      if (localDataInputStream == null) {}
      try
      {
        sUrandomIn = new DataInputStream(new FileInputStream(URANDOM_FILE));
        localDataInputStream = sUrandomIn;
        return localDataInputStream;
      }
      catch (IOException localIOException)
      {
        throw new SecurityException("Failed to open " + URANDOM_FILE + " for reading", localIOException);
      }
    }
  }
  
  private OutputStream getUrandomOutputStream()
  {
    synchronized (sLock)
    {
      if (sUrandomOut == null) {
        sUrandomOut = new FileOutputStream(URANDOM_FILE);
      }
      OutputStream localOutputStream = sUrandomOut;
      return localOutputStream;
    }
  }
  
  protected byte[] engineGenerateSeed(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    engineNextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  /* Error */
  protected void engineNextBytes(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 91	com/tencent/ttpic/device/EncryptUtils$LinuxPRNGSecureRandom:mSeeded	Z
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: invokestatic 95	com/tencent/ttpic/device/EncryptUtils:access$000	()[B
    //   11: invokevirtual 98	com/tencent/ttpic/device/EncryptUtils$LinuxPRNGSecureRandom:engineSetSeed	([B)V
    //   14: getstatic 35	com/tencent/ttpic/device/EncryptUtils$LinuxPRNGSecureRandom:sLock	Ljava/lang/Object;
    //   17: astore_2
    //   18: aload_2
    //   19: monitorenter
    //   20: aload_0
    //   21: invokespecial 100	com/tencent/ttpic/device/EncryptUtils$LinuxPRNGSecureRandom:getUrandomInputStream	()Ljava/io/DataInputStream;
    //   24: astore_3
    //   25: aload_2
    //   26: monitorexit
    //   27: aload_3
    //   28: monitorenter
    //   29: aload_3
    //   30: aload_1
    //   31: invokevirtual 103	java/io/DataInputStream:readFully	([B)V
    //   34: aload_3
    //   35: monitorexit
    //   36: return
    //   37: astore_1
    //   38: aload_2
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: new 55	java/lang/SecurityException
    //   46: dup
    //   47: new 57	java/lang/StringBuilder
    //   50: dup
    //   51: ldc 105
    //   53: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: getstatic 29	com/tencent/ttpic/device/EncryptUtils$LinuxPRNGSecureRandom:URANDOM_FILE	Ljava/io/File;
    //   59: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: aload_1
    //   66: invokespecial 76	java/lang/SecurityException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   69: athrow
    //   70: astore_1
    //   71: aload_3
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	LinuxPRNGSecureRandom
    //   0	75	1	paramArrayOfByte	byte[]
    //   24	48	3	localDataInputStream	DataInputStream
    // Exception table:
    //   from	to	target	type
    //   20	27	37	finally
    //   38	40	37	finally
    //   14	20	42	java/io/IOException
    //   27	29	42	java/io/IOException
    //   40	42	42	java/io/IOException
    //   73	75	42	java/io/IOException
    //   29	36	70	finally
    //   71	73	70	finally
  }
  
  /* Error */
  protected void engineSetSeed(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: getstatic 35	com/tencent/ttpic/device/EncryptUtils$LinuxPRNGSecureRandom:sLock	Ljava/lang/Object;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: aload_0
    //   7: invokespecial 107	com/tencent/ttpic/device/EncryptUtils$LinuxPRNGSecureRandom:getUrandomOutputStream	()Ljava/io/OutputStream;
    //   10: astore_3
    //   11: aload_2
    //   12: monitorexit
    //   13: aload_3
    //   14: aload_1
    //   15: invokevirtual 112	java/io/OutputStream:write	([B)V
    //   18: aload_3
    //   19: invokevirtual 115	java/io/OutputStream:flush	()V
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 91	com/tencent/ttpic/device/EncryptUtils$LinuxPRNGSecureRandom:mSeeded	Z
    //   27: return
    //   28: astore_1
    //   29: aload_2
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    //   33: astore_1
    //   34: ldc 2
    //   36: invokevirtual 120	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   39: new 57	java/lang/StringBuilder
    //   42: dup
    //   43: ldc 122
    //   45: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: getstatic 29	com/tencent/ttpic/device/EncryptUtils$LinuxPRNGSecureRandom:URANDOM_FILE	Ljava/io/File;
    //   51: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 128	com/tencent/ttpic/baseutils/LogUtils:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 91	com/tencent/ttpic/device/EncryptUtils$LinuxPRNGSecureRandom:mSeeded	Z
    //   65: return
    //   66: astore_1
    //   67: aload_0
    //   68: iconst_1
    //   69: putfield 91	com/tencent/ttpic/device/EncryptUtils$LinuxPRNGSecureRandom:mSeeded	Z
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	LinuxPRNGSecureRandom
    //   0	74	1	paramArrayOfByte	byte[]
    //   10	9	3	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   6	13	28	finally
    //   29	31	28	finally
    //   0	6	33	java/io/IOException
    //   13	22	33	java/io/IOException
    //   31	33	33	java/io/IOException
    //   0	6	66	finally
    //   13	22	66	finally
    //   31	33	66	finally
    //   34	60	66	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.device.EncryptUtils.LinuxPRNGSecureRandom
 * JD-Core Version:    0.7.0.1
 */