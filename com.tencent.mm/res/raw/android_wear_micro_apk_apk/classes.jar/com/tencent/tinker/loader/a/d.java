package com.tencent.tinker.loader.a;

import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public final class d
  implements Closeable
{
  private final FileOutputStream apE;
  private final FileLock apF;
  
  private d(File paramFile)
  {
    this.apE = new FileOutputStream(paramFile);
    Throwable localThrowable = null;
    Object localObject1 = null;
    int i = 0;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      int j;
      if (i < 3)
      {
        j = i + 1;
        localObject2 = localObject1;
      }
      try
      {
        localObject1 = this.apE.getChannel().lock();
        if (localObject1 != null) {}
        for (i = 1; i != 0; i = 0)
        {
          localObject2 = localObject1;
          if (localObject2 != null) {
            break label141;
          }
          throw new IOException("Tinker Exception:FileLockHelper lock file failed: " + paramFile.getAbsolutePath(), localThrowable);
        }
        localObject2 = localObject1;
        Thread.sleep(10L);
        i = j;
      }
      catch (Exception localException)
      {
        Log.e("Tinker.FileLockHelper", "getInfoLock Thread failed time:10");
        localObject1 = localObject2;
        i = j;
      }
    }
    label141:
    this.apF = localObject2;
  }
  
  public static d i(File paramFile)
  {
    return new d(paramFile);
  }
  
  public final void close()
  {
    try
    {
      if (this.apF != null) {
        this.apF.release();
      }
      return;
    }
    finally
    {
      if (this.apE != null) {
        this.apE.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.a.d
 * JD-Core Version:    0.7.0.1
 */