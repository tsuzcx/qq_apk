package com.tencent.mm.plugin.sns.ad.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public final class b
{
  private String PNw;
  private FileLock fileLock;
  private String filename;
  private RandomAccessFile randomAccessFile;
  
  public b(String paramString1, String paramString2)
  {
    this.PNw = paramString1;
    this.filename = paramString2;
  }
  
  private boolean isValid()
  {
    AppMethodBeat.i(309679);
    if ((!TextUtils.isEmpty(this.PNw)) && (!TextUtils.isEmpty(this.filename)))
    {
      AppMethodBeat.o(309679);
      return true;
    }
    AppMethodBeat.o(309679);
    return false;
  }
  
  public final void close()
  {
    AppMethodBeat.i(309691);
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
      }
      finally
      {
        AppMethodBeat.o(309691);
        return;
      }
    }
    finally
    {
      break label24;
    }
  }
  
  public final String gZD()
  {
    AppMethodBeat.i(309701);
    if (!isValid())
    {
      AppMethodBeat.o(309701);
      return null;
    }
    if ((this.randomAccessFile == null) || (this.fileLock == null))
    {
      AppMethodBeat.o(309701);
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
            AppMethodBeat.o(309701);
            return null;
          }
          Object localObject1 = new byte[i];
          if (this.randomAccessFile.read((byte[])localObject1, 0, i) == i)
          {
            localObject1 = new String((byte[])localObject1, 0, i, "UTF-8");
            AppMethodBeat.o(309701);
            return localObject1;
          }
        }
      }
      finally
      {
        AppMethodBeat.o(309701);
        return null;
      }
      int i = 10240;
    }
  }
  
  public final boolean open()
  {
    AppMethodBeat.i(309687);
    if (!isValid())
    {
      AppMethodBeat.o(309687);
      return false;
    }
    if ((this.randomAccessFile != null) || (this.fileLock != null))
    {
      AppMethodBeat.o(309687);
      return false;
    }
    try
    {
      File localFile1 = new File(Environment.getExternalStorageDirectory(), this.PNw);
      File localFile2 = new File(localFile1, this.filename);
      if (!localFile1.exists())
      {
        boolean bool = localFile1.mkdirs();
        if (!bool)
        {
          AppMethodBeat.o(309687);
          return false;
        }
      }
      this.randomAccessFile = new RandomAccessFile(localFile2, "rwd");
      this.fileLock = this.randomAccessFile.getChannel().lock();
      if (!localFile2.isFile()) {
        return false;
      }
      AppMethodBeat.o(309687);
      return true;
    }
    finally
    {
      close();
      AppMethodBeat.o(309687);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.a.b
 * JD-Core Version:    0.7.0.1
 */