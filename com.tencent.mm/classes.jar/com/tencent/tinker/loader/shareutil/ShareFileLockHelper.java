package com.tencent.tinker.loader.shareutil;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class ShareFileLockHelper
  implements Closeable
{
  public static final int LOCK_WAIT_EACH_TIME = 10;
  public static final int MAX_LOCK_ATTEMPTS = 3;
  private static final String TAG = "Tinker.FileLockHelper";
  private final FileLock fileLock;
  private final FileOutputStream outputStream;
  
  private ShareFileLockHelper(File paramFile)
  {
    this.outputStream = new FileOutputStream(paramFile);
    Throwable localThrowable = null;
    Object localObject = null;
    int i = 0;
    int j;
    if (i < 3) {
      j = i + 1;
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          FileLock localFileLock = this.outputStream.getChannel().lock();
          localObject = localFileLock;
          if (localObject != null)
          {
            i = 1;
            if (i != 0)
            {
              if (localObject != null) {
                continue;
              }
              throw new IOException("Tinker Exception:FileLockHelper lock file failed: " + paramFile.getAbsolutePath(), localThrowable);
            }
          }
          else
          {
            i = 0;
            continue;
          }
        }
        catch (Exception localException1)
        {
          continue;
          this.fileLock = localObject;
          return;
        }
        try
        {
          Thread.sleep(10L);
          i = j;
        }
        catch (Exception localException2)
        {
          i = j;
        }
      }
      break;
    }
  }
  
  public static ShareFileLockHelper getFileLock(File paramFile)
  {
    return new ShareFileLockHelper(paramFile);
  }
  
  public void close()
  {
    try
    {
      if (this.fileLock != null) {
        this.fileLock.release();
      }
      return;
    }
    finally
    {
      if (this.outputStream != null) {
        this.outputStream.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.shareutil.ShareFileLockHelper
 * JD-Core Version:    0.7.0.1
 */