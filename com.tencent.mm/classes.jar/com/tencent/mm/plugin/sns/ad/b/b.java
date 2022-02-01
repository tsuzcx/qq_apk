package com.tencent.mm.plugin.sns.ad.b;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public final class b
{
  private String Dsq;
  private FileLock fileLock;
  private String filename;
  private RandomAccessFile randomAccessFile;
  
  public b(String paramString1, String paramString2)
  {
    this.Dsq = paramString1;
    this.filename = paramString2;
  }
  
  private boolean isValid()
  {
    AppMethodBeat.i(192743);
    if ((!TextUtils.isEmpty(this.Dsq)) && (!TextUtils.isEmpty(this.filename)))
    {
      AppMethodBeat.o(192743);
      return true;
    }
    AppMethodBeat.o(192743);
    return false;
  }
  
  public final void close()
  {
    AppMethodBeat.i(192745);
    try
    {
      if (this.fileLock != null)
      {
        this.fileLock.release();
        this.fileLock = null;
      }
      try
      {
        label24:
        if (this.randomAccessFile != null)
        {
          this.randomAccessFile.close();
          this.randomAccessFile = null;
        }
        AppMethodBeat.o(192745);
        return;
      }
      catch (Throwable localThrowable1)
      {
        AppMethodBeat.o(192745);
        return;
      }
    }
    catch (Throwable localThrowable2)
    {
      break label24;
    }
  }
  
  public final String eWG()
  {
    AppMethodBeat.i(192746);
    if (!isValid())
    {
      AppMethodBeat.o(192746);
      return null;
    }
    if ((this.randomAccessFile == null) || (this.fileLock == null))
    {
      AppMethodBeat.o(192746);
      return null;
    }
    for (;;)
    {
      try
      {
        if (this.randomAccessFile.length() <= 10240L)
        {
          i = Long.valueOf(this.randomAccessFile.length()).intValue();
          if (i <= 0)
          {
            AppMethodBeat.o(192746);
            return null;
          }
          Object localObject = new byte[i];
          if (this.randomAccessFile.read((byte[])localObject, 0, i) == i)
          {
            localObject = new String((byte[])localObject, 0, i, "UTF-8");
            AppMethodBeat.o(192746);
            return localObject;
          }
          AppMethodBeat.o(192746);
          return null;
        }
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(192746);
        return null;
      }
      int i = 10240;
    }
  }
  
  public final boolean open()
  {
    AppMethodBeat.i(192744);
    if (!isValid())
    {
      AppMethodBeat.o(192744);
      return false;
    }
    if ((this.randomAccessFile != null) || (this.fileLock != null))
    {
      AppMethodBeat.o(192744);
      return false;
    }
    try
    {
      File localFile1 = new File(Environment.getExternalStorageDirectory(), this.Dsq);
      File localFile2 = new File(localFile1, this.filename);
      if (!localFile1.exists())
      {
        boolean bool = localFile1.mkdirs();
        if (!bool)
        {
          AppMethodBeat.o(192744);
          return false;
        }
      }
      this.randomAccessFile = new RandomAccessFile(localFile2, "rwd");
      this.fileLock = this.randomAccessFile.getChannel().lock();
      if (!localFile2.isFile())
      {
        close();
        AppMethodBeat.o(192744);
        return false;
      }
      AppMethodBeat.o(192744);
      return true;
    }
    catch (Throwable localThrowable)
    {
      close();
      AppMethodBeat.o(192744);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.b.b
 * JD-Core Version:    0.7.0.1
 */